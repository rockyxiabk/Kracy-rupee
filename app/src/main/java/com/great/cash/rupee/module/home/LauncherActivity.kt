package com.great.cash.rupee.module.home

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.great.cash.rupee.R
import com.great.cash.rupee.module.model.MainModel
import com.great.cash.rupee.utils.LocationUtil
import com.great.cash.rupee.commonbase.BaseFragAct
import com.great.cash.rupee.commonbase.EventParams
import com.great.cash.rupee.commonbase.VPAdapter
import com.flyco.tablayout.listener.OnTabSelectListener
import com.great.cash.rupee.databinding.ActHomeBinding
import com.great.cash.rupee.utils.StatusBarUtil
import kotlin.system.exitProcess

class LauncherActivity : BaseFragAct<ActHomeBinding, MainModel>(MainModel::class.java),
    ViewPager.OnPageChangeListener {
    private var adapter: VPAdapter? = null
    override fun getLayout(): Int {
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

        return R.layout.act_home
    }

    override fun initView(savedInstanceState: Bundle?) {
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

        StatusBarUtil.setLightMode(this)
        adapter = VPAdapter(supportFragmentManager, viewModel.fragments)
        dataBing!!.viewpagerContainer.offscreenPageLimit = 2
        dataBing!!.viewpagerContainer.adapter = adapter
        dataBing!!.viewpagerContainer.currentItem = 0
        dataBing!!.viewpagerContainer.setCanScroll(false)
        dataBing!!.viewpagerContainer.addOnPageChangeListener(this)
        dataBing!!.tabBottom.setTabData(viewModel.tabEntities)
        dataBing!!.tabBottom.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
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

                dataBing!!.viewpagerContainer.currentItem = position
            }

            override fun onTabReselect(position: Int) {
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

            }
        })
        viewModel.statisticsEvent(EventParams.EVENT_HOME, EventParams.EVENT_HOME_DESC);
    }

    override fun initData() {
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

        viewModel.loadH5List()
        LocationUtil.initLocation(this)
    }

    override fun onViewClick(view: View?) {
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

    private var exitTime: Long = 0
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
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

        if (keyCode == KeyEvent.KEYCODE_BACK && event.action == KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - exitTime > 2000) {
                exitTime = System.currentTimeMillis()
                showMsg(getString(R.string.exit_app_tips))
                return false
            } else {
                finish()
                exitProcess(0)
            }
        }
        return false
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
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

    }

    override fun onPageSelected(position: Int) {
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

        dataBing!!.viewpagerContainer.currentItem = position
        dataBing!!.tabBottom.currentTab = position
    }

    override fun onPageScrollStateChanged(position: Int) {
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

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
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

        setIntent(intent)
        val position = intent?.getIntExtra("pos", 0)
        if (position != null) {
            onPageSelected(position)
        }
    }
}
