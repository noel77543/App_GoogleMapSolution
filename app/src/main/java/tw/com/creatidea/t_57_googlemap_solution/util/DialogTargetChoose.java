package tw.com.creatidea.t_57_googlemap_solution.util;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.lang.reflect.Field;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tw.com.creatidea.t_57_googlemap_solution.R;

/**
 * Created by noel on 2017/9/20.
 */

public class DialogTargetChoose extends Dialog {

    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.btn_accept)
    Button btnAccept;
    @BindView(R.id.number_picker)
    NumberPicker numberPicker;

    private Context context;
    private View view;
    private LayoutInflater inflater;
    private OnAcceptClickListener acceptClickListener;
    //-----------------------------------------------

    public DialogTargetChoose(Context context) {
        super(context);
        this.context = context;
        inflater = LayoutInflater.from(context);
        if (view == null) {
            view = inflater.inflate(R.layout.dialog_target_choose, null);
        }
        setContentView(view);
        ButterKnife.bind(this, view);
        initStationPicker();
        setDialogGravity();
    }
    //-----------------------------------------------

    public void setTitleType(String title ) {
        tvType.setText(title);
    }

    //-----------------------------------------------

    /**
     * 控制dialog位置及大小
     */
    private void setDialogGravity() {
        Window dialogWindow = getWindow();
        WindowManager.LayoutParams latouyParams = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.CENTER);
        dialogWindow.setAttributes(latouyParams);
        dialogWindow.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

    }


    //------------------

    /**
     * 設置numberPicker的內容
     */
    public void setStationData(String[] data) {
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(data.length - 1);
        numberPicker.setDisplayedValues(data);
    }
    //------------------

    /**
     * 初始化numberPicker設定
     */
    private void initStationPicker() {

        numberPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        try {
            Class internalRID = Class.forName("com.android.internal.R$id");
            Field edit = internalRID.getField("numberpicker_input");
            EditText editText = (EditText) numberPicker.findViewById(edit.getInt(null));
            editText.setVisibility(View.GONE);
            editText.setClickable(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //-----------------------------------------------

    @OnClick({R.id.btn_accept})
    public void onViewClicked(View view) {
        acceptClickListener.OnAcceptClick(numberPicker.getValue());
        dismiss();
    }

    //-----------------------
    // 點擊事件
    public void setOnAcceptClickListener(OnAcceptClickListener acceptClickListener) {
        this.acceptClickListener = acceptClickListener;
    }

    public interface OnAcceptClickListener {
        void OnAcceptClick(int index);
    }
}
