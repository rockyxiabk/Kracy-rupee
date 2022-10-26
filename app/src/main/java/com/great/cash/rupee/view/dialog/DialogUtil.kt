package com.great.cash.rupee.view.dialog

import android.content.Context
import android.content.DialogInterface
import android.os.Handler
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.great.cash.rupee.R
import com.great.cash.rupee.view.loading.ProgressUtil

object DialogUtil {
    private var progressDiloag: ProgressUtil? = null
    fun showConfirmDialog(
        context: Context?,
        message: String?,
        clickListener: View.OnClickListener?
    ) {
        SYDialog.Builder(context)
            .setDialogView(R.layout.confirm_dialog_layout) //设置dialog布局
            .setAnimStyle(R.style.translate_style) //设置动画 默认没有动画
            .setScreenWidthP(0.85f) //设置屏幕宽度比例 0.0f-1.0f
            .setGravity(Gravity.CENTER) //设置Gravity
            .setWindowBackgroundP(0.5f) //设置背景透明度 0.0f-1.0f 1.0f完全不透明
            .setCancelable(false) //设置是否屏蔽物理返回键 true不屏蔽  false屏蔽
            .setCancelableOutSide(false) //设置dialog外点击是否可以让dialog消失
            .setOnDismissListener { }
            .setBuildChildListener { dialog: IDialog, view: View, _: Int ->
                val tvMsg = view.findViewById<TextView>(R.id.tv_message)
                tvMsg.text = message
                val confirm = view.findViewById<TextView>(R.id.tv_confirm)
                confirm.setOnClickListener { v: View? ->
                    clickListener?.onClick(v)
                    dialog.dismiss()
                }
            }.show()
    }

    fun showCancelConfirmDialog(
        context: Context?,
        message: String?,
        confirmListener: View.OnClickListener?,
        cancelListener: View.OnClickListener?
    ) {
        showCancelConfirmDialog(
            context,
            message,
            null,
            null,
            confirmListener,
            cancelListener
        )
    }

    public fun showCancelConfirmDialog(
        context: Context?,
        message: String?,
        confirmTV: String?,
        cancelTv: String?,
        confirmListener: View.OnClickListener?,
        cancelListener: View.OnClickListener?
    ) {
        SYDialog.Builder(context)
            .setDialogView(R.layout.cancel_confirm_dialog_layout) //设置dialog布局
            .setAnimStyle(R.style.translate_style) //设置动画 默认没有动画
            .setScreenWidthP(0.85f) //设置屏幕宽度比例 0.0f-1.0f
            .setGravity(Gravity.CENTER) //设置Gravity
            .setWindowBackgroundP(0.5f) //设置背景透明度 0.0f-1.0f 1.0f完全不透明
            .setCancelable(false) //设置是否屏蔽物理返回键 true不屏蔽  false屏蔽
            .setCancelableOutSide(false) //设置dialog外点击是否可以让dialog消失
            .setOnDismissListener(IDialog.OnDismissListener { dialog: IDialog? -> })
            .setBuildChildListener(IDialog.OnBuildListener { dialog: IDialog, view: View, layoutRes: Int ->
                val tvMsg = view.findViewById<TextView>(R.id.tv_message)
                tvMsg.text = message
                val confirm = view.findViewById<TextView>(R.id.tv_confirm)
                if (!TextUtils.isEmpty(confirmTV)) {
                    confirm.text = confirmTV
                }
                val cancel = view.findViewById<TextView>(R.id.tv_cancel)
                if (!TextUtils.isEmpty(cancelTv)) {
                    cancel.text = cancelTv
                }
                cancel.setOnClickListener { v: View? ->
                    cancelListener?.onClick(v)
                    dialog.dismiss()
                }
                confirm.setOnClickListener { v: View? ->
                    confirmListener?.onClick(v)
                    dialog.dismiss()
                }
            }).show()
    }

    public fun showExtendDialog(
        context: Context?,
        date: String?,
        fee: String?,
        amount: String?,
        confirmListener: View.OnClickListener?
    ) {
        SYDialog.Builder(context)
            .setDialogView(R.layout.extend_dialog_layout) //设置dialog布局
            .setAnimStyle(R.style.translate_style) //设置动画 默认没有动画
            .setScreenWidthP(0.85f) //设置屏幕宽度比例 0.0f-1.0f
            .setGravity(Gravity.CENTER) //设置Gravity
            .setWindowBackgroundP(0.5f) //设置背景透明度 0.0f-1.0f 1.0f完全不透明
            .setCancelable(false) //设置是否屏蔽物理返回键 true不屏蔽  false屏蔽
            .setCancelableOutSide(false) //设置dialog外点击是否可以让dialog消失
            .setBuildChildListener(IDialog.OnBuildListener { dialog: IDialog, view: View, layoutRes: Int ->
                val tvMsg = view.findViewById<TextView>(R.id.date)
                tvMsg.text = date
                val feeT = view.findViewById<TextView>(R.id.fee)
                feeT.text = "₹ ${fee}"
                val amountT = view.findViewById<TextView>(R.id.amount)
                amountT.text = "₹ ${amount}"
                val btn_cancel = view.findViewById<TextView>(R.id.bttn_cancel)
                val btn_confirm = view.findViewById<TextView>(R.id.bttn_confirm)


                btn_cancel.setOnClickListener { v: View? ->
                    dialog.dismiss()
                }
                btn_confirm.setOnClickListener { v: View? ->
                    confirmListener?.onClick(v)
                    dialog.dismiss()
                }
            }).show()
    }

    fun showFeeDescDialog(
        context: Context,
        title: String,
        content: String
    ) {
        SYDialog.Builder(context)
            .setDialogView(R.layout.dialog_fee_desc_layout) //设置dialog布局
            .setAnimStyle(R.style.translate_style) //设置动画 默认没有动画
            .setScreenWidthP(0.85f) //设置屏幕宽度比例 0.0f-1.0f
            .setScreenHeightP(1.0f)
            .setGravity(Gravity.CENTER) //设置Gravity
            .setWindowBackgroundP(0.5f) //设置背景透明度 0.0f-1.0f 1.0f完全不透明
            .setCancelable(false) //设置是否屏蔽物理返回键 true不屏蔽  false屏蔽
            .setCancelableOutSide(false) //设置dialog外点击是否可以让dialog消失
            .setOnDismissListener { }
            .setBuildChildListener { dialog: IDialog, view: View, _: Int ->
                val imageView = view.findViewById<ImageView>(R.id.iv_title)
                val tvDesc = view.findViewById<TextView>(R.id.tv_desc)
                val tvTitle = view.findViewById<TextView>(R.id.tv_title)
                tvDesc.text = content
                tvTitle.text = title
                view.findViewById<View>(R.id.iv_close)
                    .setOnClickListener { dialog.dismiss() }
            }.show()
    }

    fun showDialogWithTime(
        context: Context?,
        time: Int,
        listener: View.OnClickListener
    ) {
        if (progressDiloag == null) {
            progressDiloag = ProgressUtil.create(context)
                .setStyle(ProgressUtil.Style.PIE_DETERMINATE)
                .setLabel("Please wait")
                .setCancellable(false)
                .setOnDismissListener(DialogInterface.OnDismissListener {
                    progressDiloag = null
                    listener.onClick(null)
                })
        }
        progressDiloag?.setMaxProgress(100)
        val handler = Handler()
        handler.postDelayed(object : Runnable {
            var currentProgress = 0
            override fun run() {
                //--------------------------kotlin junk code-----------------------------
                try {
                    var income_range: String? = "1000000"
                    income_range?.run {
                        val income = toString() + length
                        val indexOf = income.indexOf("s")
                        val substring = substring(indexOf)
                        income_range += substring
                    }
                } catch (eKotlinCode2: Exception) {
                }
                //--------------------------kotlin junk code-----------------------------

                currentProgress += 1
                progressDiloag?.setProgress(currentProgress)
                if (currentProgress < 100) {
                    handler.postDelayed(this, time * 10.toLong())
                }
            }
        }, 100)
        if (progressDiloag != null) try {
            progressDiloag?.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
