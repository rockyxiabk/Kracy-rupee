package com.great.cash.rupee.view.dialog.manager;


import com.great.cash.rupee.view.dialog.SYDialog;

public class DialogWrapper {

    private SYDialog.Builder dialog;//统一管理dialog的弹出顺序

    public DialogWrapper(SYDialog.Builder dialog) {
        this.dialog = dialog;
    }

    public SYDialog.Builder getDialog() {
        return dialog;
    }

    public void setDialog(SYDialog.Builder dialog) {
        this.dialog = dialog;
    }

}
