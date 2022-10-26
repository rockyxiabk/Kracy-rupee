package com.yinlan.newdatasyc.bean;


import java.util.List;

public class DeviceData {
    /**
     * 必填项
     */
    //内存可用
    public String cashCanUse;
    //内存总共
    public String cashTotal;
    //是否有内置sd卡
    public String containSd;
    //imei设备标识
    public String imei;
    //mac地址（手机）
    public String mac;
    //操作系统
    public String operatingSystem;
    //ram可用
    public String ramCanUse;
    //ram总共
    public String ramTotal;
    //是否root
    public String rooted;
    //系统版本
    public String systemVersions;
    //安卓id
    public String androidId;
    //是否有外置SD卡
    public String extraSd;
    // 出厂时间
    public String productionDate;
    /**
     * 选填项
     */
    //运营商的名称
    public String phoneBrand;
    //设备型号
    public String phoneType;
    //硬件设备序列号
    public String hardwareSerial;
    //应用build号
    public String buildId;
    //应用版本号
    public String buildName;
    //分辨率宽
    public String deviceWidth;
    //分辨率高
    public String deviceHeight;
    //设备语言
    public String defaultLanguage;
    //本机号码
    public String localPhone;
    //运营商
    public String carrier;
    //sdk版本
    public String sdkVersion;
    //蜂窝网络IP
    public String netIp;
    //wifi IP地址
    public String wifiIp;
    // 电池状态
    public String batteryStatus;
    //电池电量
    public String batteryLevel;
    //APP安装时间
    public long appInstallTime;
    //设备名称
    public String deviceName;
    //gps经度
    public String gpsLongitude;
    //gps纬度
    public String gpsLatitude;
    //设备当前时间
    public long deviceTime;
    //网络类型
    public String networkType;
    //是否使用vpn
    public String useVpn;
    //是否模拟器
    public String isSimulator;
    //google广告id
    public String gaid;
    public String ssid;
    public String wifiMac;
    public int linkSpeed;

    //3.1新增字段
    //设备最大电量
    public String batteryMax;
    // 手机主板名
    public String board;
    //CPU总数
    public int cpuNum;
    // 当前设备的手机号
    public String phone;
    //开机总时长
    public long openElapsedTime;
    //开机总时长非休眠
    public long openUptime;
    //用户当前时区
    public String timeZone;

    //3.2新增
    //============新增设备数据============
    //@ApiModelProperty("物理尺寸 （从这里开始及以下的字段是2.0版本新增的）")
    public String physicalSize;
    //@ApiModelProperty("内存卡大小")
    public String memoryCardSize;
    //@ApiModelProperty("内存卡可使用量")
    public String memoryCardUsableSize;
    //@ApiModelProperty("内存卡已使用量")
    public String memoryCardUsedSize;
    //@ApiModelProperty("语言环境的三字母缩写")
    public String localsLanguageAbbreviation;
    //@ApiModelProperty("此用户显示的语言环境语⾔的名称")
    public String localsLanguageName;
    //ApiModelProperty("此地区的国家/地区的缩写")
    public String countryOrAreaAbbreviation;
    //@ApiModelProperty("时区的ID")
    public String timeZoneId;
    //@ApiModelProperty("是否使用代理 0:否，1：是")
    public String whetherUseProxy;
    //@ApiModelProperty("是否开启 debug 调试 0:否，1：是")
    public String whetherEnableDebugMode;
    //@ApiModelProperty("传感器信息")
    public String sensorInfo;
    //@ApiModelProperty("开机时间到现在的毫秒数")
    public String timeToPresent;
    //@ApiModelProperty("最后⼀次启动时间")
    public String lastStartTime;
    //@ApiModelProperty("连接到设备的键盘的种类")
    public String keyboardType;
    //@ApiModelProperty("手机的信号强度")
    public String bssid;
    //@ApiModelProperty("是否 USB 充电 0:否，1：是")
    public String whetherUsbCharging;
    //@ApiModelProperty("是否交流充电")
    public String whetherAcCharging;
    //@ApiModelProperty("音频内部文件个数")
    public String internalAudioFilesNum;
    //@ApiModelProperty("图片内部文件个数")
    public String internalPicFilesNum;
    //@ApiModelProperty("视频内部文件个数 （从这里开始及以上的字段是2.0版本新增的）")
    public String internalVideoFilesNum;
    //@ApiModelProperty("wifi数量")
    public String wifiCount;
    //@ApiModelProperty("当前wifi的名称")
    public String wifiName;

    public List<WifiData> configuredWifi;
    //app最大占用内存
    public String appMaxMemory;
    //app当前可用内存
    public String appAvailableMemory;
    //app可释放内存
    public String appFreeMemory;

    public static class WifiData {
        public String bssid;
        public String ssid;
        public String wifiMac;
        public String wifiName;
    }
}
