package com.great.cash.rupee.utils;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.great.cash.rupee.R;
import com.great.cash.rupee.entity.DictListResp;
import com.great.cash.rupee.module.adapter.SheetAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SelectDialogUtil {

    private static SelectDialogUtil instance;
    private BottomSheetDialog bottomSheetDialog;
    private SelectDialogUtil() {
    }

    public static SelectDialogUtil getInstance() {
        if (instance == null)
            instance = new SelectDialogUtil();
        return instance;
    }

    public void show(Context context, List<DictListResp.TypeInfo> data, String select, SheetAdapter.ChooseItem listener) {
        if (bottomSheetDialog!=null&&bottomSheetDialog.isShowing()) return;
        View v = View.inflate(context, R.layout.select_layout, null);
        bottomSheetDialog = new BottomSheetDialog(context, R.style.sheetdialog);
        bottomSheetDialog.setContentView(v);
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setCanceledOnTouchOutside(false);
        RecyclerView recyclerView = v.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        SheetAdapter adapter = new SheetAdapter(context, data, select, new SheetAdapter.ChooseItem() {
            @Override
            public void chooseContent(@NotNull DictListResp.TypeInfo result) {
                listener.chooseContent(result);
                bottomSheetDialog.dismiss();
                bottomSheetDialog = null;
            }
        });
        recyclerView.setAdapter(adapter);
        TextView cancel = v.findViewById(R.id.btn_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.dismiss();
                bottomSheetDialog = null;
            }
        });
        bottomSheetDialog.show();
    }
}
