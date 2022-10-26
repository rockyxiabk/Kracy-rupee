package com.great.cash.rupee.module.me

import android.content.ContentResolver
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import androidx.lifecycle.Observer
import com.great.cash.rupee.R
import com.great.cash.rupee.entity.DictListResp
import com.great.cash.rupee.module.model.ReferenceModel
import com.great.cash.rupee.commonbase.BaseAct
import com.great.cash.rupee.commonbase.EventParams
import com.great.cash.rupee.databinding.ActReferenceBinding
import com.great.cash.rupee.module.adapter.SheetAdapter
import com.great.cash.rupee.module.adapter.SheetStringAdapter
import com.great.cash.rupee.utils.Constant
import com.great.cash.rupee.utils.SelectDialogUtil
import com.great.cash.rupee.utils.SelectStringDialogUtil

class ReferenceActivity :
    BaseAct<ActReferenceBinding, ReferenceModel>(ReferenceModel::class.java) {
    private var state: String = "10"
    var listData: List<DictListResp.TypeInfo> = ArrayList<DictListResp.TypeInfo>()

    override fun getLayout(): Int {
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

        return R.layout.act_reference
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

        setLightBar(true)
        dataBing?.clickListener = this
        viewModel.statisticsEvent(
            EventParams.EVENT_AUTH_CONTACT,
            EventParams.EVENT_AUTH_CONTACT_DESC
        )
    }

    override fun initData() {
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

        state = intent.getBundleExtra(Constant.BUNDLE_DATA)!!.getString("state").toString()
        if (state == "30") {
            viewModel.getRefData().observe(this, Observer {
                it.map {
                    if (it?.type == "10") {
                        dataBing?.releation?.text = it.relation
                        dataBing?.familyPhone?.text = it.phone
                        dataBing?.family?.setText(it.name)
                    } else {
                        dataBing?.friendPhone?.text = it?.phone
                        dataBing?.friendName?.setText(it?.name)
                    }
                }
            })
            dataBing?.btnSave?.visibility = View.GONE
            dataBing?.familyPhone?.setOnClickListener(null)
            dataBing?.friendPhone?.setOnClickListener(null)
            dataBing?.releation?.setOnClickListener(null)
        } else {
            viewModel.getSelData().observe(this, Observer {
                if (it != null) {
                    listData = it.kinsfolkRelationList!!
                }
            })
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

        when (view?.id) {
            R.id.iv_back -> {
                finish()
            }
            R.id.releation -> {
                showRelation()
            }
            R.id.friend_phone -> {
                selectPhone(1)
            }
            R.id.family_phone -> {
                selectPhone(2)
            }
            R.id.btn_save -> {
                saveInfo()
            }
        }
    }

    private fun saveInfo() {
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

        val relation = dataBing?.releation?.text
        val famName = dataBing?.family?.text.toString()
        val famPhone = dataBing?.familyPhone?.text
        val friName = dataBing?.friendName?.text
        val friPhone = dataBing?.friendPhone?.text
        if (relation.isNullOrEmpty()) {
            showMsg("Please Select Family Member")
            return
        }

        if (famName.isNullOrEmpty() || famPhone.isNullOrEmpty()) {
            showMsg("Please Select or Enter Family Contacts")
            return
        }

        if (friName.isNullOrEmpty() || friPhone.isNullOrEmpty()) {
            showMsg("Please Select or Enter Friends\' Contacts")
            return
        }
        var name = "$friName,$famName"
        var phone = "$friPhone,$famPhone"
        var rela = "friend,$relation"
        var type = "20,10"
        showDialog()
        viewModel.statisticsEvent(EventParams.EVENT_CONTACTS_CLICK, EventParams.EVENT_CONTACTS_CLICK_DESC)
        viewModel.saveRefData(name, phone, rela, type).observe(this, Observer {
            dismissDialog()
            if (it) {
                viewModel.statisticsEvent(EventParams.EVENT_CONTACTS_SUCCESS, EventParams.EVENT_CONTACTS_SUCCESS_DESC)
                showMsg("save success")
                finish()
            }
        })
    }

    private fun selectPhone(code: Int) {
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

        val intent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
        startActivityForResult(intent, code)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
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

        when (requestCode) {
            1 -> {
                val phoneList = data?.data?.let { getPhoneContacts(it) }
                if (phoneList.isNullOrEmpty()) return
                if (phoneList.size > 1) {
                    SelectStringDialogUtil.getInstance().show(this@ReferenceActivity,
                        phoneList,
                        dataBing?.friendPhone?.text.toString(),
                        SheetStringAdapter.ChooseItem {
                            dataBing?.friendPhone?.text = it
                        })
                } else {
                    dataBing?.friendPhone?.text = phoneList[0]
                }
            }
            2 -> {
                val phoneList = data?.data?.let { getPhoneContacts(it) }
                if (phoneList.isNullOrEmpty()) return
                if (phoneList.size > 1) {
                    SelectStringDialogUtil.getInstance().show(this@ReferenceActivity,
                        phoneList,
                        dataBing?.familyPhone?.text.toString(),
                        SheetStringAdapter.ChooseItem {
                            dataBing?.familyPhone?.text = it
                        })
                } else {
                    dataBing?.familyPhone?.text = phoneList[0]
                }
            }
        }
    }

    private fun getPhoneContacts(uri: Uri): ArrayList<String>? {
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

        val contact = ArrayList<String>()
        //得到ContentResolver对象**
        val cr: ContentResolver = contentResolver
        //取得电话本中开始一项的光标**
        val cursor: Cursor? = cr.query(uri, null, null, null, null)
        if (cursor != null) {
            cursor.moveToFirst()
            //取得联系人姓名**
//            val nameFieldColumnIndex: Int =
//                cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
//            contact.add(cursor.getString(nameFieldColumnIndex))
            //取得电话号码**
            val contactId: String =
                cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID))
            val phone: Cursor? = cr.query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,
                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + contactId,
                null,
                null
            )
            if (phone != null) {
                while (phone.moveToNext()) {
                    contact.add(phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)))
                }
            }
            phone?.close()
            cursor.close()
        } else {
            return null
        }
        return contact
    }

    private fun showRelation() {
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

        SelectDialogUtil.getInstance().show(this@ReferenceActivity,
            listData,
            dataBing?.releation?.text.toString(),
            SheetAdapter.ChooseItem {
                dataBing?.releation?.text = it.value
            })
    }
}
