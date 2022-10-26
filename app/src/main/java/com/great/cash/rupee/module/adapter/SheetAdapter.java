package com.great.cash.rupee.module.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.great.cash.rupee.R;
import com.great.cash.rupee.entity.DictListResp;

import java.util.ArrayList;
import java.util.List;

public class SheetAdapter extends RecyclerView.Adapter<SheetAdapter.ViewHolder> {

    private String selectStr;
    private Context context;
    private List<DictListResp.TypeInfo> content;
    private final LayoutInflater inflater;
    private ChooseItem chooseItem;

    public SheetAdapter(Context context, List<DictListResp.TypeInfo> data, String select, ChooseItem listener) {
        this.context = context;
        if (data == null)
            content = new ArrayList<>();
        else
            content = data;
        selectStr = select;
        chooseItem = listener;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.select_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DictListResp.TypeInfo typeInfo = content.get(position);
        String title = typeInfo.getValue();
        if (TextUtils.equals(title, selectStr))
            holder.content.setTextColor(context.getResources().getColor(R.color.text_yellow));
        else
            holder.content.setTextColor(context.getResources().getColor(R.color.text_color6));
        holder.content.setText(title);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chooseItem != null)
                    chooseItem.chooseContent(typeInfo);
            }
        });
    }

    @Override
    public int getItemCount() {
        return content.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            content = itemView.findViewById(R.id.content);
        }
    }

    public interface ChooseItem {
        void chooseContent(DictListResp.TypeInfo select);
    }
}
