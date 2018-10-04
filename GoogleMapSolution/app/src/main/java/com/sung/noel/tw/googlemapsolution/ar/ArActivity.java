package com.sung.noel.tw.googlemapsolution.ar;

import android.Manifest;
import android.content.Context;
import android.hardware.Camera;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;
import com.sung.noel.tw.googlemapsolution.R;
import com.sung.noel.tw.googlemapsolution.ar.model.TargetData;
import com.sung.noel.tw.googlemapsolution.ar.util.SensorUtil;
import com.sung.noel.tw.googlemapsolution.base.BaseLocationActivity;

import static com.sung.noel.tw.googlemapsolution.util.BundleInfo.LAT;
import static com.sung.noel.tw.googlemapsolution.util.BundleInfo.LNG;
import static com.sung.noel.tw.googlemapsolution.util.BundleInfo.PLACE_NAME;

@RuntimePermissions
public class ArActivity extends BaseLocationActivity implements SurfaceHolder.Callback, SensorUtil.OnSensorFormatDirectionGetListener {

    @BindView(R.id.tv_location)
    TextView tvTargetLocation;
    @BindView(R.id.tv_target)
    TextView tvTarget;
    @BindView(R.id.surface_view)
    SurfaceView surfaceView;
    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;
    @BindView(R.id.iv_compass)
    ImageView ivCompass;

    private SurfaceHolder surfaceHolder;
    private Camera camera;

    private String targetName;
    private double targetLat;
    private double targetLng;
    private Location target;
    private SensorUtil sensorUtil;
    private float startAngle = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ar);
        ButterKnife.bind(this);

        ArActivityPermissionsDispatcher.startCameraRequestWithCheck(this);
    }
    //---------

    /**
     * 起始點 (當第一次取得location),此接口的method僅執行一次
     */
    @Override
    protected void onLocationGet(Location location) {
        setDataFromPreviousPage();
        initSensor();

    }
    //---------

    /**
     * 擺上取得自上一頁傳來的資料
     */
    private void setDataFromPreviousPage() {
        targetName = getIntent().getExtras().getString(PLACE_NAME);
        targetLat = getIntent().getExtras().getDouble(LAT);
        targetLng = getIntent().getExtras().getDouble(LNG);

        tvTargetLocation.setText(String.format(getString(R.string.ar_target_location), targetLng + "", targetLat + ""));
        tvTarget.setText(targetName);

        target = new Location("provider");
        target.setLatitude(targetLat);
        target.setLongitude(targetLng);
    }
    //---------

    /**
     * surfaceView基本設定
     */
    private void initSurfaceView() {
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }
    //-----

    /**
     * 加入 目標icon在鏡頭上
     */
    private void initSensor() {
        sensorUtil = new SensorUtil(this, targetName, targetLat, targetLng);
        sensorUtil.setOnSensorDirectionChangeListener(this);
    }
    //-----

    /***
     * 相機預覽的旋轉角度需要根據相機預覽目前的旋轉角度，以及屏幕的旋轉角度計算得到
     * @return
     */
    private int getDisplayOrientation() {
        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int rotation = display.getRotation();
        int degrees = 0;
        switch (rotation) {
            case Surface.ROTATION_0:
                degrees = 0;
                break;
            case Surface.ROTATION_90:
                degrees = 90;
                break;
            case Surface.ROTATION_180:
                degrees = 180;
                break;
            case Surface.ROTATION_270:
                degrees = 270;
                break;
        }

        Camera.CameraInfo camInfo =
                new Camera.CameraInfo();
        Camera.getCameraInfo(Camera.CameraInfo.CAMERA_FACING_BACK, camInfo);

        return (camInfo.orientation - degrees + 360) % 360;
    }

    @Override
    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
        camera.startPreview();
    }

    @Override
    public void surfaceCreated(SurfaceHolder arg0) {
        camera = Camera.open();
        camera.setDisplayOrientation(getDisplayOrientation());

        try {
            camera.setPreviewDisplay(surfaceHolder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder arg0) {
        camera.stopPreview();
        camera.release();
        camera = null;
    }
    //---------

    /***
     * 當方向取得
     * @param targetData
     */
    @Override
    public void onSensorFormatDirectionGet(TargetData targetData) {
        Location loc = getUserLocation();

        float bearTo = loc.bearingTo(target);
        if (bearTo < 0) {
            bearTo = bearTo + 360;
        }
        //需要轉的角度
        float needTurn = 360 - targetData.getFrontBean().getFrontCorrectAngle() + bearTo;


        RotateAnimation rotateAnimationa = new RotateAnimation(startAngle, needTurn,
                Animation.RELATIVE_TO_SELF, 0.5f, // x座標(圖片X軸中心點)
                Animation.RELATIVE_TO_SELF, 0.5f); // y座標(圖片Y軸中心點)

        // 轉動時間
        rotateAnimationa.setDuration(200);

        // 預設狀態結束後的動作設定
        rotateAnimationa.setFillAfter(true);

        ivCompass.startAnimation(rotateAnimationa);
        startAngle = needTurn;
    }
    //---------

    @Override
    public void onPause() {
        super.onPause();
        sensorUtil.unrigisterSensor();
    }

    //---------

    @NeedsPermission(Manifest.permission.CAMERA)
    void startCameraRequest() {
        initSurfaceView();
        getLocationPermissionsWithCheck();
    }

    @OnShowRationale(Manifest.permission.CAMERA)
    void askCameraRequest(final PermissionRequest request) {
        request.proceed();
    }

    @OnPermissionDenied(Manifest.permission.CAMERA)
    void refusedCameraRequest() {
        Toast.makeText(this, getString(R.string.ar_refuse_camera), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        ArActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }
}
