package com.sung.noel.tw.googlemapsolution.util.dialog.version;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Button;

import com.sung.noel.tw.googlemapsolution.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VersionDialog extends Dialog {
    @BindView(R.id.btn_accept)
    Button btnAccept;
    private OnAcceptListener onAcceptListener;

    public VersionDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.dialog_version);
        setCancelable(false);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_accept)
    public void onViewClicked() {
        onAcceptListener.onAcceptToUpdateVersion();
    }

    //-----------

    public interface OnAcceptListener {
        void onAcceptToUpdateVersion();
    }

    public VersionDialog setOnAcceptListener(OnAcceptListener onAcceptListener) {
        this.onAcceptListener = onAcceptListener;
        return this;
    }

}
