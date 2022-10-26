package com.great.cash.rupee.module.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.flyco.tablayout.listener.CustomTabEntity
import com.great.cash.rupee.App
import com.great.cash.rupee.R
import com.great.cash.rupee.entity.BaseResultArray
import com.great.cash.rupee.entity.ListData
import com.great.cash.rupee.entity.PageBean
import com.great.cash.rupee.entity.ProtocolResp
import com.great.cash.rupee.commonbase.BaseViewModel
import com.great.cash.rupee.network.BaseArrayObserver
import com.great.cash.rupee.network.NetworkStart
import com.great.cash.rupee.utils.ConstantsParams
import com.great.cash.rupee.utils.debug
import com.great.cash.rupee.module.home.HomeFragment
import com.great.cash.rupee.module.me.MeFragment
import com.great.cash.rupee.network.CommonApi
import com.great.cash.rupee.view.TabEntity
import java.util.*

class MainModel : BaseViewModel() {
    private var titles = mutableListOf(
        App.instance!!.getString(R.string.home),
        App.instance!!.getString(R.string.me)
    )
    private val mIconSelectIds = arrayOf(
        R.mipmap.loans,
        R.mipmap.profiles
    )
    private val mIconUnselectIds = arrayOf(
        R.mipmap.loan,
        R.mipmap.profile
    )
    var fragments = mutableListOf(HomeFragment(), MeFragment())
    val tabEntities = ArrayList<CustomTabEntity>()

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

        for (i in titles.indices) {
            tabEntities.add(TabEntity(titles[i], mIconSelectIds[i], mIconUnselectIds[i]))
        }
    }

    fun loadH5List(): LiveData<Boolean> {
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

        val liveData = MutableLiveData<Boolean>()
        NetworkStart.subscribe(
            NetworkStart.createApi(CommonApi::class.java).helpList(),
            object : BaseArrayObserver<ProtocolResp?>() {
                override fun onSuccess(result: ListData<ProtocolResp?>?, page: PageBean?) {
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

                    result?.list?.map {
                        ConstantsParams.protocolRespList.add(
                            ProtocolResp(
                                it!!.name,
                                it.code,
                                it.value
                            )
                        )
                    }
                    debug(ConstantsParams.protocolRespList.toString())
                    liveData.postValue(true)
                }

                override fun onFailed(result: BaseResultArray<ProtocolResp?>?) {
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

                    liveData.postValue(false)
                }
            })
        return liveData
    }
}
