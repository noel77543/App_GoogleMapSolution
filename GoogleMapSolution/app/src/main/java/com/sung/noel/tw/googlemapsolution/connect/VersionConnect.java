package com.sung.noel.tw.googlemapsolution.connect;

import android.content.Context;

import com.sung.noel.tw.googlemapsolution.R;
import com.sung.noel.tw.googlemapsolution.base.BaseConnect;
import com.sung.noel.tw.googlemapsolution.event.EventCenter;
import com.sung.noel.tw.googlemapsolution.main.model.VersionData;
import com.sung.noel.tw.googlemapsolution.main.model.googlemap.AddressInfo;

import java.io.IOException;
import java.text.MessageFormat;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

import static com.sung.noel.tw.googlemapsolution.event.EventCenter.TYPE_ADDRESS;
import static com.sung.noel.tw.googlemapsolution.event.EventCenter.TYPE_VERSION;

public class VersionConnect extends BaseConnect {
    private Context context;

    public VersionConnect(Context context) {
        super(context);
        this.context = context;
    }

    //------

    public void connectToGetVersionData() {
        loadingDialog.setLoadingMessage(context.getString(R.string.version_checking));
        if (isNetWorkable()) {
            loadingDialog.showLoadingDialog();
            request = new Request.Builder().url(ConnectInfo.API_VERSION).get().build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    loadingDialog.dismiss();
                    EventCenter.getInstance().sendConnectErrorEvent(context.getString(R.string.toast_server_error_version));
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {

                    loadingDialog.dismiss();
                    reader = response.body().charStream();
                    EventCenter.getInstance().sendVersionData(TYPE_VERSION, gson.fromJson(reader, VersionData.class));
                }
            });
        } else {
            EventCenter.getInstance().sendConnectErrorEvent(context.getString(R.string.toast_net_cant_work));
        }

    }
}
