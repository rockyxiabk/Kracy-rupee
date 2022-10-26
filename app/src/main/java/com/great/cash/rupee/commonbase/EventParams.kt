package com.great.cash.rupee.commonbase
class EventParams {
    companion object {
        const val EVENT_INSTALL = "event_install"
        const val EVENT_IN = "event_in"
        const val EVENT_PERMISSION = "event_permission"
        const val EVENT_HOME = "event_home"
        const val EVENT_APPLY_NO_AUTH = "event_apply_no_auth"
        const val EVENT_APPLY = "event_apply"
        const val EVENT_AUTH_TOTAL = "event_auth_total"
        const val EVENT_AUTH_OCR = "event_auth_ocr"
        const val EVENT_AUTH_INFO = "event_auth_info"
        const val EVENT_AUTH_CONTACT = "event_auth_contact"
        const val EVENT_AUTH_BANK = "event_auth_bank"
        const val EVENT_REGISTER_BEGIN = "event_register_begin"
        const val EVENT_REGISTER_END = "event_register_end"
        const val EVENT_LOGIN_BEGIN = "event_login_begin"
        const val EVENT_LOGIN_END = "event_login_end"

        const val EVENT_FRONT_CLICK = "event_card_front_click"
        const val EVENT_FRONT_SUCCESS = "event_card_front_success"
        const val EVENT_FRONT_FAILED = "event_card_front_failed"

        const val EVENT_BACK_CLICK = "event_card_back_click"
        const val EVENT_BACK_SUCCESS = "event_card_back_success"
        const val EVENT_BACK_FAILED = "event_card_back_failed"

        const val EVENT_PAN_CLICK = "event_pan_card_click"
        const val EVENT_PAN_SUCCESS = "event_pan_card_success"
        const val EVENT_PAN_FAILED = "event_pan_card_failed"

        const val EVENT_LIVE_CLICK = "event_live_click_click"
        const val EVENT_LIVE_SUCCESS = "event_live_success"
        const val EVENT_LIVE_FAILED = "event_live_failed"

        const val EVENT_REPAY_CLICK="add_repay_click"

        const val EVENT_OCR_CLICK="add_ocr_click"
        const val EVENT_OCR_SUCCESS="add_ocr_success"
        const val EVENT_OCR_FAILED="add_ocr_failed"

        const val EVENT_INFO_CLICK="add_info_click"
        const val EVENT_INFO_SUCCESS="add_info_success"
        const val EVENT_INFO_FAILED="add_info_failed"

        const val EVENT_CONTACTS_CLICK="add_contacts_click"
        const val EVENT_CONTACTS_SUCCESS="add_contacts_success"
        const val EVENT_CONTACTS_FAILED="add_contacts_failed"

        const val EVENT_BANK_CLICK="add_bank_click"
        const val EVENT_BANK_success="add_bank_success"
        const val EVENT_BANK_failed="add_bank_failed"

        const val EVENT_IN_DESC = "打开app"
        const val EVENT_INSTALL_DESC = "首次安装"
        const val EVENT_PERMISSION_DESC = "进入权限页"
        const val EVENT_HOME_DESC = "进入首页"
        const val EVENT_APPLY_NO_AUTH_DESC = "没认证时点申请"
        const val EVENT_APPLY_DESC = "认证完成点击申请"
        const val EVENT_AUTH_TOTAL_DESC = "进入认证总页面"
        const val EVENT_AUTH_OCR_DESC = "进入OCR认证页面"
        const val EVENT_AUTH_INFO_DESC = "进入个人信息认证页面"
        const val EVENT_AUTH_CONTACT_DESC = "进入联系人认证页面"
        const val EVENT_AUTH_BANK_DESC = "进入银行卡认证页面"
        const val EVENT_REGISTER_BEGIN_DESC = "进入注册页面"
        const val EVENT_REGISTER_END_DESC = "注册完成"
        const val EVENT_LOGIN_BEGIN_DESC = "进入登录/注册页"
        const val EVENT_LOGIN_END_DESC = "登录成功"


        const val EVENT_FRONT_DESC_CLICK = "身份证正面点击"
        const val EVENT_FRONT_DESC_SUCCESS = "身份证正面认证成功"
        const val EVENT_FRONT_DESC_FAILED = "身份证正面认证失败"

        const val EVENT_BACK_DESC_CLICK = "身份证反面点击"
        const val EVENT_BACK_DESC_SUCCESS = "身份证反面认证成功"
        const val EVENT_BACK_DESC_FAILED = "身份证反面认证失败"

        const val EVENT_PAN_DESC_CLICK = "pan卡点击"
        const val EVENT_PAN_DESC_SUCCESS = "pan卡认证成功"
        const val EVENT_PAN_DESC_FAILED = "pan卡认证失败"

        const val EVENT_LIVE_DESC_CLICK = "活体点击"
        const val EVENT_LIVE_DESC_SUCCESS = "活体调起成功"
        const val EVENT_LIVE_DESC_FAILED = "活体调起失败"


        const val EVENT_REPAY_CLICK_DESC="用户点击还款"

        const val EVENT_OCR_CLICK_DESC="用户点击保存ocr"
        const val EVENT_OCR_SUCCESS_DESC="用户保存ocr成功"
        const val EVENT_OCR_FAILED_DESC="用户保存ocr失败"

        const val EVENT_INFO_CLICK_DESC="用户点击保存基本信息"
        const val EVENT_INFO_SUCCESS_DESC="用户保存基本信息成功"
        const val EVENT_INFO_FAILED_DESC="用户保存基本信息失败"

        const val EVENT_CONTACTS_CLICK_DESC="用户点击保存联系人信息"
        const val EVENT_CONTACTS_SUCCESS_DESC="用户保存联系人信息成功"
        const val EVENT_CONTACTS_FAILED_DESC="用户保存联系人信息失败"

        const val EVENT_BANK_CLICK_DESC="用户点击保存银行卡信息"
        const val EVENT_BANK_success_DESC="用户保存银行卡信息成功"
        const val EVENT_BANK_failed_DESC="用户保存银行卡信息失败"

    }
}
