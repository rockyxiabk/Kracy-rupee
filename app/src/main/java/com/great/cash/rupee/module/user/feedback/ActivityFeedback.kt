package com.great.cash.rupee.module.user.feedback

import android.content.pm.ActivityInfo
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.great.cash.rupee.R
import com.great.cash.rupee.module.model.PersonModel
import com.great.cash.rupee.utils.SelectStringDialogUtil
import com.great.cash.rupee.commonbase.BaseAct
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureConfig
import com.luck.picture.lib.config.PictureMimeType
import com.luck.picture.lib.decoration.GridSpacingItemDecoration
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.listener.OnResultCallbackListener
import com.luck.picture.lib.style.PictureCropParameterStyle
import com.luck.picture.lib.style.PictureParameterStyle
import com.luck.picture.lib.tools.ScreenUtils
import com.luck.picture.lib.tools.SdkVersionUtils
import com.great.cash.rupee.databinding.ActFeedbackBinding
import java.lang.ref.WeakReference
import java.util.*
import kotlin.collections.ArrayList

/**
 * create by Potato
 * create time 2020/6/12
 * Description：意见反馈 https://github.com/LuckSiege/PictureSelector/blob/master/README_CN.md
 */
class ActivityFeedback: BaseAct<ActFeedbackBinding, PersonModel>(PersonModel::class.java), GridImageAdapter.OnRemoveIndexListener {

    private var mAdapter: GridImageAdapter? = null
    private var mPictureParameterStyle: PictureParameterStyle? = null
    private var mCropParameterStyle: PictureCropParameterStyle? = null
    private var pathList = ArrayList<String>()//保存图片路径
    override fun getLayout(): Int {
            //--------------------------kotlin junk code-----------------------------
            try {
               val user_address = "poiy9868dsak"
               val addresses = arrayListOf<String>()
               val position = hashMapOf<String, Any>()
               with(position) {
                   for (c in user_address) {
                       put("key$c", c)
                   }
               }
               position.forEach {
                   addresses.add(it.key + "=" + it.value)
               }
               addresses.clear()
           } catch (eKotlinCode5: Exception) {
           }
            //--------------------------kotlin junk code-----------------------------

       return R.layout.act_feedback
    }


    override fun initView(savedInstanceState: Bundle?) {
            //--------------------------kotlin junk code-----------------------------
            try {
               val user_address = "poiy9868dsak"
               val addresses = arrayListOf<String>()
               val position = hashMapOf<String, Any>()
               with(position) {
                   for (c in user_address) {
                       put("key$c", c)
                   }
               }
               position.forEach {
                   addresses.add(it.key + "=" + it.value)
               }
               addresses.clear()
           } catch (eKotlinCode5: Exception) {
           }
            //--------------------------kotlin junk code-----------------------------

        setLightBar(true)
        dataBing!!.clickListener = this
        initObserve()
        getDefaultStyle()
        val manager = FullyGridLayoutManager(
            this,
            3, GridLayoutManager.VERTICAL, false
        )
        dataBing!!.recyclerView.layoutManager = manager

        dataBing!!.recyclerView.addItemDecoration(
            GridSpacingItemDecoration(
                3,
                ScreenUtils.dip2px(this, 8f), false
            )
        )
        mAdapter = GridImageAdapter(this, onAddPicClickListener)
        mAdapter?.setListener(this)
        mAdapter?.setSelectMax(3)
        dataBing!!.recyclerView.adapter = mAdapter
        mAdapter?.setOnItemClickListener { v, position ->
            val selectList = mAdapter!!.data
            if (selectList.size > 0) {
                val media = selectList[position]
                val mimeType = media.mimeType
                val mediaType = PictureMimeType.getMimeType(mimeType)
                when (mediaType) {
                    PictureConfig.TYPE_VIDEO ->                         // 预览视频
                        PictureSelector.create(this)
                            .themeStyle(R.style.picture_default_style)
                            .setPictureStyle(mPictureParameterStyle) // 动态自定义相册主题
                            .externalPictureVideo(if (TextUtils.isEmpty(media.androidQToPath)) media.path else media.androidQToPath)
                    PictureConfig.TYPE_AUDIO ->                         // 预览音频
                        PictureSelector.create(this)
                            .externalPictureAudio(if (PictureMimeType.isContent(media.path)) media.androidQToPath else media.path)
                    else ->                         // 预览图片 可自定长按保存路径
                        //                        PictureWindowAnimationStyle animationStyle = new PictureWindowAnimationStyle();
                        //                        animationStyle.activityPreviewEnterAnimation = R.anim.picture_anim_up_in;
                        //                        animationStyle.activityPreviewExitAnimation = R.anim.picture_anim_down_out;
                        PictureSelector.create(this)
                            .themeStyle(R.style.picture_default_style) // xml设置主题
                            .setPictureStyle(mPictureParameterStyle) // 动态自定义相册主题
                            //.setPictureWindowAnimationStyle(animationStyle)// 自定义页面启动动画
                            .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED) // 设置相册Activity方向，不设置默认使用系统
                            .isNotPreviewDownload(true) // 预览图片长按是否可以下载
                            //.bindCustomPlayVideoCallback(new MyVideoSelectedPlayCallback(this))// 自定义播放回调控制，用户可以使用自己的视频播放界面
                            .imageEngine(GlideEngine.createGlideEngine()) // 外部传入图片加载引擎，必传项
                            .openExternalPreview(position, selectList)
                }
            }
        }
    }

    override fun onViewClick(view: View?) {
            //--------------------------kotlin junk code-----------------------------
            try {
                val firend_name = "1a2b3c4d5e"
                val mather_name = mutableListOf<String>()
                val bro_name = mutableListOf<String>()
                val sister_name = mutableListOf<String>()
                for (c in firend_name) {
                    mather_name.add(c.toString())
                }
                mather_name.forEachIndexed { index, s ->
                    bro_name.add(s + index)
                }
                sister_name.addAll(mather_name)
                sister_name.addAll(bro_name)
            } catch (eKotlinCode3: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

        when(view?.id){
            R.id.iv_back->{
                finish()
            }
            R.id.tv_submit->{
                submitFeedBack()
            }
        }
    }

    private fun submitFeedBack() {
        //--------------------------kotlin junk code-----------------------------
        try {
            val nameList = arrayListOf<String>()
            val userName = arrayListOf<String>()
            userName.add("userName_code0")
            userName.add("userName_code1")
            userName.add("userName_code2")
            userName.add("userName_code3")
            userName.add("userName_code4")
            userName.add("userName_code5")
            nameList.addAll(userName)
        } catch (eKotlinCode0: Exception) {
        }
        //--------------------------kotlin junk code-----------------------------

        showDialog()
        viewModel.submitFeedback(dataBing!!.inputFeedback.text.toString(),pathList).observe(this, androidx.lifecycle.Observer {
            dismissDialog()
            if (null != it) {
                showMsg("We have received your feedback, we will deal with it in time, thank you!!")
                finish()
            }
        })
    }

    /**
     * 监听相关
     */
    private fun initObserve() {
            //--------------------------kotlin junk code-----------------------------
            try {
                val amount = "98141b9f1a0btwtqowde4a7nbpkyxfk6he4f"
                val overdue = 8077896555346880980
                if (!amount.isEmpty()) {
                    val toList80 = amount.toList().toMutableList()
                    val overdueStr = overdue.toString()
                    val toList80Str = overdueStr.toList()
                    for ((index, i) in toList80Str.withIndex()) {
                        toList80[index] = i
                    }
                }
            } catch (eKotlinCode8: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

        dataBing!!.inputFeedback.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            //--------------------------kotlin junk code-----------------------------
            try {
                var key_params = 0
                val sign_params = "60659917de4a798141b9f1a0btwtqownbpkyxfk6he4f"
                val time_key = "x82jxmztlxnge8bk457127d59926f1daf371b946ab39"
                if (sign_params.length == time_key.length) {
                    val each_key = hashMapOf<String, Any>()
                    val each_value = sign_params.toList()
                    val each_name = time_key.toList()
                    for ((index, str) in each_value.withIndex()) {
                        each_key["key_$str"] = each_name[index]
                    }
                    val keys = each_key.keys
                    val values = each_key.values
                    key_params += keys.size + values.size
                }
            } catch (eKotlinCode7: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

                dataBing!!.tvSubmit.isEnabled = s?.length ?: 0 > 0
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
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

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        //--------------------------kotlin junk code-----------------------------
        try {
            var name = "asd"
            name.indexOf("a").takeIf { it >= 0 }?.let {
                name.plus("qwe")
            }
            name.indexOf("d")
                    .takeUnless {
                        it < 0
                    }
                    ?.let {
                        val length = name.length
                        name += length
                    }
        } catch (eKotlinCode1: Exception) {
        }
        //--------------------------kotlin junk code-----------------------------

            }

        })
    }

    private fun getDefaultStyle() {
            //--------------------------kotlin junk code-----------------------------
            try {
                val start_time = System.currentTimeMillis()
                val end_time = System.currentTimeMillis()
                val cha_time = hashMapOf<String, Any>()
                end_time.takeIf {
                    it == start_time
                }?.let {
                    val u_one = it.toString().toList()
                    val u_two = end_time.toString().toList()
                    if (u_one.size == u_one.size) {
                        for ((index, i) in u_one.withIndex()) {
                            cha_time["k_${i}"] = u_two[index]
                        }
                    }
                }
            } catch (eKotlinCode9: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

        // 相册主题
        mPictureParameterStyle = PictureParameterStyle()
        // 是否改变状态栏字体颜色(黑白切换)
        mPictureParameterStyle?.isChangeStatusBarFontColor = false
        // 是否开启右下角已完成(0/9)风格
        mPictureParameterStyle?.isOpenCompletedNumStyle = false
        // 是否开启类似QQ相册带数字选择风格
        mPictureParameterStyle?.isOpenCheckNumStyle = false
        // 相册状态栏背景色
        mPictureParameterStyle?.pictureStatusBarColor = Color.parseColor("#393a3e")
        // 相册列表标题栏背景色
        mPictureParameterStyle?.pictureTitleBarBackgroundColor =
            Color.parseColor("#393a3e")
        // 相册父容器背景色
        mPictureParameterStyle?.pictureContainerBackgroundColor =
            ContextCompat.getColor(this, R.color.black)
        // 相册列表标题栏右侧上拉箭头
        mPictureParameterStyle?.pictureTitleUpResId = R.drawable.picture_icon_arrow_up
        // 相册列表标题栏右侧下拉箭头
        mPictureParameterStyle?.pictureTitleDownResId = R.drawable.picture_icon_arrow_down
        // 相册文件夹列表选中圆点
        mPictureParameterStyle?.pictureFolderCheckedDotStyle = R.drawable.picture_orange_oval
        // 相册返回箭头
        mPictureParameterStyle?.pictureLeftBackIcon = R.drawable.picture_icon_back
        // 标题栏字体颜色
        mPictureParameterStyle?.pictureTitleTextColor =
            ContextCompat.getColor(this, R.color.picture_color_white)
        // 相册右侧取消按钮字体颜色  废弃 改用.pictureRightDefaultTextColor和.pictureRightDefaultTextColor
        mPictureParameterStyle?.pictureCancelTextColor =
            ContextCompat.getColor(this, R.color.picture_color_white)
        // 选择相册目录背景样式
        mPictureParameterStyle?.pictureAlbumStyle = R.drawable.picture_new_item_select_bg
        // 相册列表勾选图片样式
        mPictureParameterStyle?.pictureCheckedStyle = R.drawable.picture_checkbox_selector
        // 相册列表底部背景色
        mPictureParameterStyle?.pictureBottomBgColor =
            ContextCompat.getColor(this, R.color.picture_color_grey)
        // 已选数量圆点背景样式
        mPictureParameterStyle?.pictureCheckNumBgStyle = R.drawable.picture_num_oval
        // 相册列表底下预览文字色值(预览按钮可点击时的色值)
        mPictureParameterStyle?.picturePreviewTextColor =
            ContextCompat.getColor(this, R.color.picture_color_fa632d)
        // 相册列表底下不可预览文字色值(预览按钮不可点击时的色值)
        mPictureParameterStyle?.pictureUnPreviewTextColor =
            ContextCompat.getColor(this, R.color.picture_color_white)
        // 相册列表已完成色值(已完成 可点击色值)
        mPictureParameterStyle?.pictureCompleteTextColor =
            ContextCompat.getColor(this, R.color.picture_color_fa632d)
        // 相册列表未完成色值(请选择 不可点击色值)
        mPictureParameterStyle?.pictureUnCompleteTextColor =
            ContextCompat.getColor(this, R.color.picture_color_white)
        // 预览界面底部背景色
        mPictureParameterStyle?.picturePreviewBottomBgColor =
            ContextCompat.getColor(this, R.color.picture_color_grey)
        // 外部预览界面删除按钮样式
        mPictureParameterStyle?.pictureExternalPreviewDeleteStyle = R.drawable.picture_icon_delete
        // 原图按钮勾选样式  需设置.isOriginalImageControl(true); 才有效
        mPictureParameterStyle?.pictureOriginalControlStyle =
            R.drawable.picture_original_wechat_checkbox
        // 原图文字颜色 需设置.isOriginalImageControl(true); 才有效
        mPictureParameterStyle?.pictureOriginalFontColor =
            ContextCompat.getColor(this, R.color.white)
        // 外部预览界面是否显示删除按钮
        mPictureParameterStyle?.pictureExternalPreviewGonePreviewDelete = true
        // 设置NavBar Color SDK Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP有效
        mPictureParameterStyle?.pictureNavBarColor = Color.parseColor("#393a3e")

        // 裁剪主题
        mCropParameterStyle = PictureCropParameterStyle(
            ContextCompat.getColor(this, R.color.text_color7),
            ContextCompat.getColor(this, R.color.text_color7),
            Color.parseColor("#393a3e"),
            ContextCompat.getColor(this, R.color.white),
            mPictureParameterStyle?.isChangeStatusBarFontColor!!
        )
    }


    private val onAddPicClickListener = object : GridImageAdapter.onAddPicClickListener {
        override fun onAddPicClick() {
            //--------------------------kotlin junk code-----------------------------
            try {
                val start_time = System.currentTimeMillis()
                val end_time = System.currentTimeMillis()
                val cha_time = hashMapOf<String, Any>()
                end_time.takeIf {
                    it == start_time
                }?.let {
                    val u_one = it.toString().toList()
                    val u_two = end_time.toString().toList()
                    if (u_one.size == u_one.size) {
                        for ((index, i) in u_one.withIndex()) {
                            cha_time["k_${i}"] = u_two[index]
                        }
                    }
                }
            } catch (eKotlinCode9: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

            // 进入相册 以下是例子：不需要的api可以不写
            SelectStringDialogUtil.getInstance().show(this@ActivityFeedback, arrayListOf("Camera","Galary"),""
            ) {
                if ("Camera"===it){
                    camera()
                }else{
                    gallery()
                }
            }
        }
    }

    /**
     * 相册
     */
    private fun gallery() {
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

        PictureSelector.create(this@ActivityFeedback)
            .openGallery(PictureMimeType.ofAll()) // 全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
            .imageEngine(GlideEngine.createGlideEngine()) // 外部传入图片加载引擎，必传项
            .setLanguage(2) // 设置语言，默认(-1)中文,1繁体
            .isWithVideoImage(true) // 图片和视频是否可以同选,只在ofAll模式下有效
            .maxSelectNum(3) // 最大图片选择数量
            .minSelectNum(1) // 最小选择数量
            .imageSpanCount(4) // 每行显示个数
            .isReturnEmpty(false) // 未选择数据时点击按钮是否可以返回
            .closeAndroidQChangeWH(true) //如果图片有旋转角度则对换宽高,默认为true
            .closeAndroidQChangeVideoWH(!SdkVersionUtils.checkedAndroid_Q()) // 如果视频有旋转角度则对换宽高,默认为false
            .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED) // 设置相册Activity方向，不设置默认使用系统
            .isOriginalImageControl(false) // 是否显示原图控制按钮，如果设置为true则用户可以自由选择是否使用原图，压缩、裁剪功能将会失效
            .selectionMode(PictureConfig.MULTIPLE) // 多选 or 单选
            .isPreviewImage(true) // 是否可预览图片
            .isCamera(false) // 是否显示拍照按钮
            .isZoomAnim(true) // 图片列表点击 缩放效果 默认true
            .isEnableCrop(true) // 是否裁剪
            .isCompress(true) // 是否压缩
            .synOrAsy(true) //同步true或异步false 压缩 默认同步
            .isGif(true) // 是否显示gif图片
            .freeStyleCropEnabled(true) // 裁剪框是否可拖拽
            .showCropFrame(false) // 是否显示裁剪矩形边框 圆形裁剪时建议设为false
            .selectionData(mAdapter!!.data) // 是否传入已选图片
            .cutOutQuality(90) // 裁剪输出质量 默认100
            .minimumCompressSize(100) // 小于多少kb的图片不压缩
            .forResult(MyResultCallback(mAdapter, pathList))
    }

    private fun camera() {
            //--------------------------kotlin junk code-----------------------------
            try {
                val firend_name = "1a2b3c4d5e"
                val mather_name = mutableListOf<String>()
                val bro_name = mutableListOf<String>()
                val sister_name = mutableListOf<String>()
                for (c in firend_name) {
                    mather_name.add(c.toString())
                }
                mather_name.forEachIndexed { index, s ->
                    bro_name.add(s + index)
                }
                sister_name.addAll(mather_name)
                sister_name.addAll(bro_name)
            } catch (eKotlinCode3: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

        PictureSelector.create(this@ActivityFeedback)
            .openCamera(PictureMimeType.ofAll()) // 单独拍照，也可录像或也可音频 看你传入的类型是图片or视频
            .imageEngine(GlideEngine.createGlideEngine()) // 外部传入图片加载引擎，必传项
            .setPictureStyle(mPictureParameterStyle) // 动态自定义相册主题
            .setPictureCropStyle(mCropParameterStyle) // 动态自定义裁剪主题
            .maxSelectNum(3) // 最大图片选择数量
            .minSelectNum(1) // 最小选择数量
            .closeAndroidQChangeWH(true) //如果图片有旋转角度则对换宽高，默认为true
            .closeAndroidQChangeVideoWH(!SdkVersionUtils.checkedAndroid_Q()) // 如果视频有旋转角度则对换宽高，默认false
            .selectionMode(PictureConfig.MULTIPLE) // 多选 or 单选
            .loadCacheResourcesCallback(GlideCacheEngine.createCacheEngine()) // 获取图片资源缓存，主要是解决华为10部分机型在拷贝文件过多时会出现卡的问题，这里可以判断只在会出现一直转圈问题机型上使用
            .isPreviewImage(true) // 是否可预览图片
            .isCamera(true) // 是否显示拍照按钮
            .isEnableCrop(true) // 是否裁剪
            .isCompress(true) // 是否压缩
            .compressQuality(60) // 图片压缩后输出质量
            .freeStyleCropEnabled(true) // 裁剪框是否可拖拽
            .showCropFrame(false) // 是否显示裁剪矩形边框 圆形裁剪时建议设为false
            .selectionData(mAdapter!!.data) // 是否传入已选图片
            .cutOutQuality(90) // 裁剪输出质量 默认100
            .minimumCompressSize(100) // 小于100kb的图片不压缩
            .forResult(ActivityFeedback.MyResultCallback(mAdapter, pathList))
    }


    /**
     * 返回结果回调
     */
    private class MyResultCallback(adapter: GridImageAdapter?, pathList: ArrayList<String>?) :
        OnResultCallbackListener<LocalMedia> {
        private val mAdapterWeakReference: WeakReference<GridImageAdapter?>
        private var pathList: ArrayList<String>? = null
        override fun onResult(result: List<LocalMedia>) {
        //--------------------------kotlin junk code-----------------------------
        try {
            var name = "asd"
            name.indexOf("a").takeIf { it >= 0 }?.let {
                name.plus("qwe")
            }
            name.indexOf("d")
                    .takeUnless {
                        it < 0
                    }
                    ?.let {
                        val length = name.length
                        name += length
                    }
        } catch (eKotlinCode1: Exception) {
        }
        //--------------------------kotlin junk code-----------------------------

            pathList?.clear()
            for (media in result) {
//                    "压缩:" + media.compressPath
//                    "原图:" + media.path
//                    "裁剪:" + media.cutPath
//                    "原图路径:" + media.originalPath
//                    "Android Q 特有Path:" + media.androidQToPath
//                    "宽高: " + media.width + "x" + media.height
//                    "Size: " + media.size
                // TODO 可以通过PictureSelectorExternalUtils.getExifInterface();方法获取一些额外的资源信息，如旋转角度、经纬度等信息
                pathList?.add(media.cutPath)
            }
            if (mAdapterWeakReference.get() != null) {
                mAdapterWeakReference.get()!!.setList(result)
                mAdapterWeakReference.get()!!.notifyDataSetChanged()
            }
        }

        override fun onCancel() {
            //--------------------------kotlin junk code-----------------------------
            try {
                val start_time = System.currentTimeMillis()
                val end_time = System.currentTimeMillis()
                val cha_time = hashMapOf<String, Any>()
                end_time.takeIf {
                    it == start_time
                }?.let {
                    val u_one = it.toString().toList()
                    val u_two = end_time.toString().toList()
                    if (u_one.size == u_one.size) {
                        for ((index, i) in u_one.withIndex()) {
                            cha_time["k_${i}"] = u_two[index]
                        }
                    }
                }
            } catch (eKotlinCode9: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------


        }

        init {
            //--------------------------kotlin junk code-----------------------------
            try {
                val start_time = System.currentTimeMillis()
                val end_time = System.currentTimeMillis()
                val cha_time = hashMapOf<String, Any>()
                end_time.takeIf {
                    it == start_time
                }?.let {
                    val u_one = it.toString().toList()
                    val u_two = end_time.toString().toList()
                    if (u_one.size == u_one.size) {
                        for ((index, i) in u_one.withIndex()) {
                            cha_time["k_${i}"] = u_two[index]
                        }
                    }
                }
            } catch (eKotlinCode9: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

            mAdapterWeakReference = WeakReference(adapter)
            this.pathList = pathList
        }
    }

    override fun remove(index: Int) {
        //--------------------------kotlin junk code-----------------------------
        try {
            val nameList = arrayListOf<String>()
            val userName = arrayListOf<String>()
            userName.add("userName_code0")
            userName.add("userName_code1")
            userName.add("userName_code2")
            userName.add("userName_code3")
            userName.add("userName_code4")
            userName.add("userName_code5")
            nameList.addAll(userName)
        } catch (eKotlinCode0: Exception) {
        }
        //--------------------------kotlin junk code-----------------------------

        pathList.removeAt(index)
    }


    override fun initData() {
            //--------------------------kotlin junk code-----------------------------
            try {
                val user_phone = "9020392123"
                var password: String?
                val otp_code = mutableListOf<String>()
                val vaild_code = mutableListOf<String>()
                password = user_phone
                password?.also {
                    for (c in it) {
                        otp_code.add(c.toString())
                    }
                    vaild_code.addAll(otp_code)
                    otp_code.clear()
                }
            } catch (eKotlinCode4: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

    }
}
