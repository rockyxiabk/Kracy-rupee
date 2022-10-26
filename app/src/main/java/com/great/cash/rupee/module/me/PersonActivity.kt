package com.great.cash.rupee.module.me

import ai.advance.liveness.lib.GuardianLivenessDetectionSDK
import ai.advance.liveness.lib.LivenessResult
import ai.advance.liveness.lib.Market
import ai.advance.liveness.sdk.activity.LivenessActivity
import android.Manifest
import android.app.Activity
import android.content.ContentResolver
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.*
import android.provider.MediaStore
import android.provider.OpenableColumns
import android.text.TextUtils
import android.util.Log
import android.view.View
import androidx.annotation.Nullable
import androidx.core.content.FileProvider
import androidx.core.net.toFile
import androidx.core.os.EnvironmentCompat
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.great.cash.rupee.R
import com.great.cash.rupee.module.model.PersonModel
import com.great.cash.rupee.utils.*
import com.great.cash.rupee.commonbase.BaseAct
import com.great.cash.rupee.commonbase.EventParams
import com.google.gson.Gson
import com.great.cash.rupee.databinding.ActPersonBinding
import com.great.cash.rupee.utils.Constant
import com.great.cash.rupee.utils.load
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.functions.Consumer
import top.zibin.luban.Luban
import top.zibin.luban.OnCompressListener
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class PersonActivity : BaseAct<ActPersonBinding, PersonModel>(PersonModel::class.java) {
    private var frontPaht: File? = null
    private var facePaht: File? = null
    private var panPaht: File? = null
    private var backPaht: File? = null
    private var frontJson: String = ""
    private var backJson: String = ""
    private var rxPermission:RxPermissions?=null
    private var panJson: String = ""
    private val REQUEST_CODE_LIVENESS_ = 1010
    private val REQUEST_CODE_FRONT = 1011
    private val REQUEST_CODE_BACK = 1012
    private val REQUEST_CODE_PAN = 1013
    private val isAndroidQ =
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q

    /**
     * 用于保存拍照图片的uri
     */
    private var mFrontCardUri: Uri? = null
    private var mBackCardUri: Uri? = null
    private var mPanCardUri: Uri? = null

    /**
     * 用于保存图片的文件路径，Android 10以下使用图片路径访问图片
     */
    private var mFrontCardImagePath: String? = null
    private var mBackCardmagePath: String? = null
    private var mPanCardmagePath: String? = null

    private var state: String? = null
    private var matchSuccess: Boolean = false

    override fun getLayout(): Int {
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

        return R.layout.act_person
    }

    override fun initView(savedInstanceState: Bundle?) {
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

        setLightBar(true)
        dataBing?.clickListener = this
        rxPermission = RxPermissions(this)
        viewModel.statisticsEvent(EventParams.EVENT_AUTH_OCR, EventParams.EVENT_AUTH_OCR_DESC)
    }

    override fun initData() {
            //--------------------------kotlin junk code-----------------------------
            try {
                var sign = "asdqw676ezxc6hx82jxmztlxnge8bk"
                val key = arrayListOf<String>()
                sign.run {
                    val s = toString() + length
                    val indexOf = s.indexOf("s")
                    val substring = substring(indexOf)
                    sign += substring
                }
                sign.apply {
                    for (c in this) {
                        key.add(c.toString())
                    }
                }
            } catch (eKotlinCode6: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

        state = intent.getBundleExtra(Constant.BUNDLE_DATA)!!.getString("state");
        if (state.equals("30")) {
            viewModel.getPerinfo().observe(this, Observer {
                if (it == null) return@Observer
                dataBing?.name?.setText(it.realName)
                dataBing?.panNo?.setText(it.panCode)
                dataBing?.adahaarNo?.setText(it.idNo)
                dataBing?.dataBirth?.setText(it.dateOfBirth)
                dataBing?.sex?.setText(it.sex)
                dataBing?.pinCode?.setText(it.pinCode)
                dataBing?.detailAddress?.setText(it.idAddr)
                load(this, it.frontImg, dataBing?.cardFront)
                load(this, it.backImg, dataBing?.cardBack)
                load(this, it.panImg, dataBing?.pan)
                load(this, it.livingImg, dataBing?.face)
                dataBing?.submit?.visibility = View.GONE
            })
        }
        GuardianLivenessDetectionSDK.init(
            application,
            "f641d49f874a7500",
            "9e8088b13e27c286",
            Market.India
        );
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

        when (view?.id) {
            R.id.iv_back -> {
                finish()
            }
            R.id.card_front -> {
                if (state.equals("30")) return
                viewModel.statisticsEvent(
                    EventParams.EVENT_FRONT_CLICK,
                    EventParams.EVENT_FRONT_DESC_CLICK
                )
                startCardFront()
            }
            R.id.card_back -> {
                if (state.equals("30")) return
                viewModel.statisticsEvent(
                    EventParams.EVENT_BACK_CLICK,
                    EventParams.EVENT_BACK_DESC_CLICK
                )
                startCardBack()
            }
            R.id.pan -> {
                if (state.equals("30")) return
                viewModel.statisticsEvent(
                    EventParams.EVENT_PAN_CLICK,
                    EventParams.EVENT_PAN_DESC_CLICK
                )
                startPanFront()
            }
            R.id.face -> {
                if (state.equals("30")) return
                viewModel.statisticsEvent(
                    EventParams.EVENT_LIVE_CLICK,
                    EventParams.EVENT_LIVE_DESC_CLICK
                )
                startFace()
            }
            R.id.submit -> {
                if (state.equals("30")) return
                viewModel.statisticsEvent(
                    EventParams.EVENT_OCR_CLICK,
                    EventParams.EVENT_OCR_CLICK_DESC
                )
                submitInfo()
            }
        }
    }

    private fun submitInfo() {
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

        if (frontPaht == null || backPaht == null) {
            showMsg("Please scan your aadhaar first")
            return
        }
        if (panPaht == null) {
            showMsg("Please improve your PAN first")
            return
        }
        if (!matchSuccess) {
            showMsg("The ID photo is not match with the face recognition, please try again")
            return
        }
        checkInfoAndSubmit()
    }

    private fun checkInfoAndSubmit() {
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

        val nameStr = dataBing?.name?.text.toString()
        val panNoString = dataBing?.panNo?.text.toString()
        val aadString = dataBing?.adahaarNo?.text.toString()
        val birthString = dataBing?.dataBirth?.text.toString()
        val sexString = dataBing?.sex?.text.toString()
        val pinString = dataBing?.pinCode?.text.toString()
        val addString = dataBing?.detailAddress?.text.toString()

        if (nameStr.isNullOrEmpty()) {
            showMsg("Please enter your name")
            return
        }

        if (panNoString.isNullOrEmpty()) {
            showMsg("Please enter your pan code")
            return
        }

        if (aadString.isNullOrEmpty()) {
            showMsg("Please enter your Aadhaar NO")
            return
        }

        if (birthString.isNullOrEmpty()) {
            showMsg("Please enter your date of birth")
            return
        }

        if (sexString.isNullOrEmpty()) {
            showMsg("Please input your gender")
            return
        }

        if (pinString.isNullOrEmpty()) {
            showMsg("Please enter your pin code")
            return
        }

        if (addString.isNullOrEmpty()) {
            showMsg("Please enter your Aadhaar address")
            return
        }
        showDialog()
        viewModel.saveInfo(
            nameStr,
            panNoString,
            aadString,
            birthString,
            sexString,
            pinString,
            addString,
            frontJson,
            backJson,
            panJson,
            frontPaht,
            backPaht,
            panPaht,
            facePaht
        ).observe(this, Observer {
            dismissDialog()
            if (it) {
                viewModel.statisticsEvent(
                    EventParams.EVENT_OCR_SUCCESS,
                    EventParams.EVENT_OCR_SUCCESS_DESC
                )
                showMsg("save success")
                finish()
            }
        })
    }

    private fun startFace() {
            //--------------------------kotlin junk code-----------------------------
            try {
                var sign = "asdqw676ezxc6hx82jxmztlxnge8bk"
                val key = arrayListOf<String>()
                sign.run {
                    val s = toString() + length
                    val indexOf = s.indexOf("s")
                    val substring = substring(indexOf)
                    sign += substring
                }
                sign.apply {
                    for (c in this) {
                        key.add(c.toString())
                    }
                }
            } catch (eKotlinCode6: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

        if (frontPaht == null || backPaht == null) {
            showMsg("Please scan your Aadhaar first")
            return
        }
        if (panPaht == null) {
            showMsg("Please improve your PAN first")
            return
        }
        val intent = Intent(this, LivenessActivity::class.java)
        startActivityForResult(intent, REQUEST_CODE_LIVENESS_)
    }

    private fun matchPanface() {
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

        if (frontPaht == null || panPaht == null || facePaht == null) {
            return
        }
        showDialog()
        viewModel.matchFace(frontPaht!!, panPaht!!, facePaht!!).observe(this, Observer {
            dismissDialog()
            matchSuccess = it
        })
    }

    private fun startPanFront() {
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

        openCameraWithPermission(REQUEST_CODE_PAN)
    }

    private fun startCardBack() {
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

        openCameraWithPermission(REQUEST_CODE_BACK)
    }

    private fun startCardFront() {
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

        openCameraWithPermission(REQUEST_CODE_FRONT)
    }

    private fun openCameraWithPermission(requestCode: Int) {
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

        rxPermission?.request(
            Manifest.permission.CAMERA
        )?.subscribe(Consumer {
            if (it){
                openCamera(requestCode)
            }else{
                showMsg("Sorry, you do not have camera permission")
            }
        })
    }

    /**
     * 调起相机拍照
     */
    private fun openCamera(requestCode: Int) {
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

        val captureIntent =
            Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        // 判断是否有相机
        if (captureIntent.resolveActivity(packageManager) != null) {
            var photoFile: File? = null
            var photoUri: Uri? = null
            if (isAndroidQ) {
                // 适配android 10
                photoUri = createImageUri()
            } else {
                try {
                    photoFile = createImageFile()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
                if (photoFile != null) {
                    if (requestCode == REQUEST_CODE_FRONT) {
                        mFrontCardImagePath = photoFile.absolutePath
                    } else if (requestCode == REQUEST_CODE_BACK) {
                        mBackCardmagePath = photoFile.absolutePath
                    } else {
                        mPanCardmagePath = photoFile.absolutePath
                    }
                    photoUri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        //适配Android 7.0文件权限，通过FileProvider创建一个content类型的Uri
                        FileProvider.getUriForFile(
                            this,
                            "$packageName.fileprovider",
                            photoFile
                        )
                    } else {
                        Uri.fromFile(photoFile)
                    }
                }
            }
            if (requestCode == REQUEST_CODE_FRONT) {
                mFrontCardUri = photoUri
            } else if (requestCode == REQUEST_CODE_BACK) {
                mBackCardUri = photoUri
            } else {
                mPanCardUri = photoUri
            }
            if (photoUri != null) {
                captureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri)
                captureIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
                startActivityForResult(captureIntent, requestCode)
            }
        }
    }

    private fun createImageUri(): Uri? {
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

        val status: String = Environment.getExternalStorageState()
        // 判断是否有SD卡,优先使用SD卡存储,当没有SD卡时使用手机存储
        return if (status == Environment.MEDIA_MOUNTED) {
            contentResolver.insert(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                ContentValues()
            )
        } else {
            contentResolver.insert(
                MediaStore.Images.Media.INTERNAL_CONTENT_URI,
                ContentValues()
            )
        }
    }

    @Throws(IOException::class)
    private fun createImageFile(): File? {
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

        val imageName: String =
            SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val storageDir =
            getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        if (!storageDir!!.exists()) {
            storageDir.mkdir()
        }
        val tempFile = File(storageDir, imageName)
        return if (Environment.MEDIA_MOUNTED != EnvironmentCompat.getStorageState(tempFile)) {
            null
        } else tempFile
    }

    private var livenessId: String? = null
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        @Nullable data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
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

        if (requestCode == REQUEST_CODE_FRONT) {
            if (resultCode == Activity.RESULT_OK) {
                lubanCompress(REQUEST_CODE_FRONT)
            }
        } else if (requestCode == REQUEST_CODE_BACK) {
            if (resultCode == Activity.RESULT_OK) {
                lubanCompress(REQUEST_CODE_BACK)
            }
        } else if (requestCode == REQUEST_CODE_PAN) {
            if (resultCode == Activity.RESULT_OK) {
                lubanCompress(REQUEST_CODE_PAN)
            }
        } else if (requestCode == REQUEST_CODE_LIVENESS_) {
            if (LivenessResult.isSuccess()) {// 活体检测成功
                viewModel.statisticsEvent(EventParams.EVENT_LIVE_SUCCESS, EventParams.EVENT_LIVE_DESC_SUCCESS)
                livenessId = LivenessResult.getLivenessId();// 本次活体id
                val livenessBitmap = LivenessResult.getLivenessBitmap();// 本次活体图片
                lubanCompressBitmap(livenessBitmap)
            } else {// 活体检测失败
                val errorCode = LivenessResult.getErrorCode();// 失败错误码
                val errorMsg = LivenessResult.getErrorMsg();// 失败原因
                viewModel.statisticsEvent(EventParams.EVENT_LIVE_FAILED, EventParams.EVENT_LIVE_DESC_FAILED+errorMsg)
                Log.e("----------", "$errorCode,$errorMsg")
                showMsg(errorMsg)
            }
        }
    }

    private fun lubanCompress(imageType: Int) {
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

        when (imageType) {
            REQUEST_CODE_FRONT -> {
                if (mFrontCardUri == null && mFrontCardImagePath == null) {
                    showMsg("Please scan Aadhaar front first")
                    return
                }
            }
            REQUEST_CODE_BACK -> {
                if (mBackCardUri == null && mBackCardmagePath == null) {
                    showMsg("Please scan Aadhaar back first")
                    return
                }
            }
            REQUEST_CODE_PAN -> {
                if (mPanCardUri == null && mPanCardmagePath == null) {
                    showMsg("Please scan PAN card first")
                    return
                }
            }
        }
        var file: File? = null
        when (imageType) {
            REQUEST_CODE_FRONT -> {
                file = if (isAndroidQ) {
                    uriToFile(this, mFrontCardUri!!)
                } else {
                    File(mFrontCardImagePath!!)
                }
            }
            REQUEST_CODE_BACK -> {
                file = if (isAndroidQ) {
                    uriToFile(this, mBackCardUri!!)
                } else {
                    File(mBackCardmagePath!!)
                }
            }
            REQUEST_CODE_PAN -> {
                file = if (isAndroidQ) {
                    uriToFile(this, mPanCardUri!!)
                } else {
                    File(mPanCardmagePath!!)
                }
            }
        }
        Luban.with(this)
            .load(file)
            .ignoreBy(100)
            .filter { path ->
                !(TextUtils.isEmpty(path) || path.toLowerCase().endsWith(".gif"))
            }
            .setCompressListener(object : OnCompressListener {
                override fun onSuccess(file: File?) {
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

                    when (imageType) {
                        REQUEST_CODE_FRONT -> {
                            frontPaht = file
                            handle.sendEmptyMessage(REQUEST_CODE_FRONT)
                        }
                        REQUEST_CODE_BACK -> {
                            backPaht = file
                            handle.sendEmptyMessage(REQUEST_CODE_BACK)
                        }
                        REQUEST_CODE_PAN -> {
                            panPaht = file
                            handle.sendEmptyMessage(REQUEST_CODE_PAN)
                        }
                    }
                }

                override fun onError(e: Throwable?) {
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

                    showMsg(e?.message)
                }

                override fun onStart() {
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

                }
            }).launch()
    }

    private fun lubanCompressBitmap(bitmap: Bitmap?) {
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

        Luban.with(this)
            .load(saveBitmapFile(bitmap))
            .ignoreBy(100)
            .filter { path ->
                !(TextUtils.isEmpty(path) || path?.toLowerCase()?.endsWith(".gif")!!)
            }
            .setCompressListener(object : OnCompressListener {
                override fun onSuccess(file: File?) {
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

                    file?.let {
                        facePaht = it
                        viewModel.getFaceScore(livenessId).observe(this@PersonActivity, Observer {
                            showFace();
                        })
                    }
                }

                override fun onError(e: Throwable?) {
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

                    showMsg(e?.message)
                }

                override fun onStart() {
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

                }
            }).launch()
    }

    private fun showFace() {
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

        Glide.with(this@PersonActivity).load(facePaht).into(dataBing?.face!!)
        matchPanface()
    }

    private fun uriToFile(context: Context, uri: Uri): File? = when (uri.scheme) {
        ContentResolver.SCHEME_FILE -> uri.toFile()
        ContentResolver.SCHEME_CONTENT -> {
            val cursor = context.contentResolver.query(uri, null, null, null, null)
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        //保存到本地
                        val ois = context.contentResolver.openInputStream(uri)
                        val displayName =
                            cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))
                        ois?.let {
                            val file = File(
                                context.externalCacheDir!!.absolutePath,
                                "${System.currentTimeMillis()}$displayName"
                            )
                            val fos = FileOutputStream(file)
                            val buffer = ByteArray(1024)
                            var len: Int = ois.read(buffer)
                            while (len != -1) {
                                fos.write(buffer, 0, len)
                                len = ois.read(buffer)
                            }
                            fos.close()
                            it.close()
                            file
                        }
                    } else
                    //直接转换
                        File(cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA)))
                } else {
                    cursor.close()
                    null
                }
            } else {
                null
            }
        }
        else -> null
    }

    private fun saveBitmapFile(bitmap: Bitmap?): File? {
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

        var file: File? = null
        try {
            file = File(filesDir, "${System.currentTimeMillis()}_face.jpg")
            val bos = BufferedOutputStream(FileOutputStream(file));
            bitmap?.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();
            return file
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    private val handle: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
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

            when (msg.what) {
                REQUEST_CODE_FRONT -> {
                    getCardInfo(REQUEST_CODE_FRONT, frontPaht!!)
                }
                REQUEST_CODE_BACK -> {
                    getCardInfo(REQUEST_CODE_BACK, backPaht!!)
                }
                REQUEST_CODE_PAN -> {
                    getCardInfo(REQUEST_CODE_PAN, panPaht!!)
                }
            }
        }
    }

    private fun getCardInfo(imageType: Int, path: File) {
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

        showDialog()
        viewModel.getCardInfo(imageType, path).observe(this, Observer {
            dismissDialog()
            if (!it.success) {
                when (it.type) {
                    REQUEST_CODE_FRONT -> {
                        viewModel.statisticsEvent(
                            EventParams.EVENT_FRONT_FAILED,
                            EventParams.EVENT_FRONT_DESC_FAILED + it.msg
                        )
                    }
                    REQUEST_CODE_BACK -> {
                        viewModel.statisticsEvent(
                            EventParams.EVENT_BACK_FAILED,
                            EventParams.EVENT_BACK_DESC_FAILED + it.msg
                        )
                    }
                    REQUEST_CODE_PAN -> {
                        viewModel.statisticsEvent(
                            EventParams.EVENT_PAN_FAILED,
                            EventParams.EVENT_PAN_DESC_FAILED + it.msg
                        )
                    }
                }
                return@Observer
            }
            when (it.type) {
                REQUEST_CODE_FRONT -> {
                    viewModel.statisticsEvent(
                        EventParams.EVENT_FRONT_SUCCESS,
                        EventParams.EVENT_FRONT_DESC_SUCCESS
                    )
                    frontJson = Gson().toJson(it)
                    dataBing?.name?.setText(it.name)
                    dataBing?.sex?.setText(it.gender)
                    dataBing?.adahaarNo?.setText(it.idNumber)
                    Glide.with(this@PersonActivity).load(frontPaht)
                        .into(dataBing!!.cardFront)
                    matchPanface()
                }
                REQUEST_CODE_BACK -> {
                    viewModel.statisticsEvent(
                        EventParams.EVENT_BACK_SUCCESS,
                        EventParams.EVENT_BACK_DESC_SUCCESS
                    )
                    backJson = Gson().toJson(it)
                    dataBing?.pinCode?.setText(it.pin)
                    dataBing?.detailAddress?.setText(it.addressAll)
                    Glide.with(this@PersonActivity).load(backPaht)
                        .into(dataBing!!.cardBack);
                    matchPanface()
                }
                REQUEST_CODE_PAN -> {
                    viewModel.statisticsEvent(
                        EventParams.EVENT_PAN_SUCCESS,
                        EventParams.EVENT_PAN_DESC_SUCCESS
                    )
                    panJson = Gson().toJson(it)
                    dataBing?.dataBirth?.setText(it.birthday)
                    dataBing?.panNo?.setText(it.idNumber)
                    Glide.with(this@PersonActivity).load(panPaht)
                        .into(dataBing!!.pan)
                    matchPanface()
                }
            }
        })
    }
}
