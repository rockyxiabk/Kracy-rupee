package com.yinlan.newdatasyc.bean;



import java.util.List;

public class CalendarData  {
    public List<CalendarInfo> data;



    public static class CalendarInfo {
        //提醒事件ID
        public String event_id;
        //提醒事件标题
        public String event_title;
        //提醒事件描述
        public String description;
        //事件开始时间 毫秒时间戳
        public long start_time;
        //事件结束时间 毫秒时间戳
        public long end_time;
        public List<ReminderInfo> reminders;

    }

    public static class ReminderInfo {
        //事件ID
        public String event_id;
        //提醒方式（1：METHOD_ALERT，2：METHOD_DEFAULT，3：METHOD_EMAIL，4：METHOD_SMS）
        public int method;
        //在事件发生之前多少分钟进行提醒
        public int minutes;
        //提醒ID
        public String reminder_id;

    }
}
