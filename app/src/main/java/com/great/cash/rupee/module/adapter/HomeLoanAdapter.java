package com.great.cash.rupee.module.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.great.cash.rupee.R;
import com.great.cash.rupee.entity.HomeIndexResp;
import com.great.cash.rupee.entity.HomeLoanResp;
import com.great.cash.rupee.module.home.LoanActivity;
import com.great.cash.rupee.module.me.CenterActivity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HomeLoanAdapter extends RecyclerView.Adapter<HomeLoanAdapter.ViewHolder> {


    private List<HomeLoanResp> list;
    private Context mContext;
    private HomeIndexResp indexResp;
    public HomeLoanAdapter(Context context){
        mContext = context;
        list = new ArrayList<>();
    }

    public void setData(HomeIndexResp homeIndexResp,List<HomeLoanResp> data){
        indexResp = homeIndexResp;
        list.clear();
        list.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.home_list_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        HomeLoanResp response = list.get(position);
        Glide.with(mContext).load(response.getProductLogo()).error(R.mipmap.ic_launcher).into(holder.icLauncher);
        holder.tvProductName.setText(response.getProductName());
        holder.tvRange.setText(response.getProductAmount());
        holder.tvInterest.setText(response.getProductInterest());
        if ("1".equals(response.getProductStatus())){// 1、可申请 2、 申请已满 3、审核中 4、拒绝
            holder.btnApply.setText("Apply");
            holder.btnApply.setBackgroundResource(R.drawable.apply_bg);
            holder.btnApply.setTextColor(mContext.getResources().getColor(R.color.white));
        }else if ("2".equals(response.getProductStatus())){
            holder.btnApply.setText("Full");
            holder.btnApply.setBackgroundResource(R.drawable.dis_apply_bg);
            holder.btnApply.setTextColor(mContext.getResources().getColor(R.color.progress_grey_color));
        }else if ("3".equals(response.getProductStatus())){
            holder.btnApply.setBackgroundResource(R.drawable.dis_apply_bg);
            holder.btnApply.setTextColor(mContext.getResources().getColor(R.color.progress_grey_color));
            holder.btnApply.setText("Reviewing");
        }else {
            holder.btnApply.setText("Reject");
            holder.btnApply.setBackgroundResource(R.drawable.dis_apply_bg);
            holder.btnApply.setTextColor(mContext.getResources().getColor(R.color.progress_grey_color));
        }
        if ("1".equals(response.getProductStatus())){
            holder.btnApply.setEnabled(true);
            holder.btnApply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   doClick(response);
                }
            });
        }else {
            holder.btnApply.setEnabled(false);
        }
    }

    private void doClick(HomeLoanResp response) {
        if (indexResp.getAuth().getQualified()!=1){
            mContext.startActivity(new Intent(mContext, CenterActivity.class));
        }else {
            mContext.startActivity(new Intent(mContext, LoanActivity.class));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView icLauncher;
        private AppCompatButton btnApply;
        private TextView tvProductName,tvRange,tvInterest;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            icLauncher = itemView.findViewById(R.id.iv_logo);
            tvProductName = itemView.findViewById(R.id.tv_product_name);
            btnApply = itemView.findViewById(R.id.btn_apply);
            tvRange = itemView.findViewById(R.id.tv_range);
            tvInterest = itemView.findViewById(R.id.tv_interest);
        }
    }
}
