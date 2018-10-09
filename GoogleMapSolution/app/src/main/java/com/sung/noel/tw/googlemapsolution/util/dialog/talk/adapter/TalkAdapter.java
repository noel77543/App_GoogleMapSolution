package com.sung.noel.tw.googlemapsolution.util.dialog.talk.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sung.noel.tw.googlemapsolution.R;
import com.sung.noel.tw.googlemapsolution.util.firebase.database.model.FirebaseData;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TalkAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<FirebaseData.BoardBean> boardBeans;
    private Context context;


    public TalkAdapter(Context context) {
        this.context = context;
        boardBeans = new ArrayList<>();

    }

    //------------

    public void setData(ArrayList<FirebaseData.BoardBean> boardBeans) {
        this.boardBeans = boardBeans;
        notifyDataSetChanged();
    }

    //--------------
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_talk, parent, false));
    }
    //--------------

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FirebaseData.BoardBean boardBean = boardBeans.get(position);

        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.tvName.setText(String.format(context.getString(R.string.talk_name), boardBean.getName()));
        viewHolder.tvMessage.setText(boardBean.getText());
        viewHolder.tvTime.setText(boardBean.getTime());
    }
    //--------------

    @Override
    public int getItemCount() {
        return boardBeans.size();
    }

    //--------

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_message)
        TextView tvMessage;
        @BindView(R.id.tv_time)
        TextView tvTime;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            tvTime.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        }
    }
}
