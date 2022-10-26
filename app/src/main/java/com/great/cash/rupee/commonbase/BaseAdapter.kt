package com.great.cash.rupee.commonbase

import android.content.Context
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.IntRange
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T> : RecyclerView.Adapter<BaseAdapter.BaseViewHolder>() {
    private var checkBoxVisibility = false
    var list: MutableList<T> = mutableListOf()
    lateinit var context: Context
    fun getData(): MutableList<T> = list

    //增加一列数据
    fun addData(newData: List<T>?) {
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

        if (newData == null || newData.isEmpty()) return
        list.addAll(newData)
        notifyItemRangeInserted(list.size - newData.size, newData.size)
        compatibilityDataSizeChanged(newData.size)
    }

    //根据position插入集合
    fun addData(@IntRange(from = 0) position: Int, newData: Collection<T>) {
        if (newData == null || newData.isEmpty()) return
        list.addAll(position, newData)
        notifyItemRangeInserted(position, newData.size)
        compatibilityDataSizeChanged(newData.size)
    }

    fun addData(@IntRange(from = 0) position: Int, newData: List<T>) {
        if (newData == null || newData.isEmpty()) return
        list.addAll(position, newData)
        compatibilityDataSizeChanged(newData.size)
    }

    //增加一条数据
    fun addData(data: T?) {
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

        if (data == null) return
        list.add(data)
        notifyItemInserted(list.size)
        compatibilityDataSizeChanged(1)
    }

    //下拉刷新使用,如果null，需要清除list
    fun setData(data: MutableList<T>?) {
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

        list.clear()
        if (data == null || data.isEmpty()) return
        list.addAll(data)
        notifyDataSetChanged()
    }

    //根据position插入item
    fun setData(@IntRange(from = 0) index: Int, data: T) {
        list[index] = data
        notifyItemChanged(index)
    }

    private fun compatibilityDataSizeChanged(size: Int) {
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

        val dataSize =  list.size
        if (dataSize == size) {
            notifyDataSetChanged()
        }
    }

    fun setCheckBoxVisibility(visibility: Boolean) {
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

        this.checkBoxVisibility = visibility
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = if (list.isNotEmpty()) list.size else 0

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
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

        onBindViewHolderImpl(holder, position, list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
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

        this.context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(getLayoutId(viewType), parent, false)
        return BaseViewHolder(view)
    }

    abstract fun getLayoutId(viewType: Int): Int

    abstract fun onBindViewHolderImpl(holder: BaseViewHolder, position: Int, t: T)

    open class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val views: SparseArray<View>? = null

        fun <T : View> getView(@IdRes viewId: Int): T? {
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

            var view: View? = views?.get(viewId)
            if (view == null) {
                view = itemView.findViewById(viewId)
                if (view == null) return null
                views?.put(viewId, view)
            }
            return view as T
        }

    }
}

