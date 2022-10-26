package com.great.cash.rupee.commonbase

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.great.cash.rupee.view.TabEntity

class VPAdapter : FragmentPagerAdapter {
    private var list: List<Fragment>? = null
    private var title: List<TabEntity>? = null

    constructor(fm: FragmentManager?) : super(fm!!) {}
    constructor(
        fm: FragmentManager?,
        list: List<Fragment>?
    ) : super(fm!!) {
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

        this.list = list
    }

    constructor(
        fm: FragmentManager?,
        list: List<Fragment>?,
        title: List<TabEntity>?
    ) : super(fm!!) {
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

        this.list = list
        this.title = title
    }

    override fun getItem(position: Int): Fragment {
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

        return list!![position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
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

        return if (null != title) {
            title!![position].title
        } else {
            super.getPageTitle(position)
        }
    }

    override fun getCount(): Int {
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

        var ret = 0
        if (list != null) {
            ret = list!!.size
        }
        return ret
    }
}
