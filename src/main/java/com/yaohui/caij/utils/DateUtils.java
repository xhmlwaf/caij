package com.yaohui.caij.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    private static final String DATE_FORMAT_DATEONLY = "yyyy-MM-dd"; // 年/月/日
    private static final String DATE_FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss"; // 年/月/日

    /**
     * 得到时间戳格式字串
     */
    public static String date2Str(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_DATETIME);
        return sdf.format(date);

    }

    public static void main(String[] args) {
//    try {
//      Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2018-07-11");
//      Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse("2018-07-20");
//      System.out.println(differentDaysByMillisecond(date1,date2));
//
//      Date date3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-07-11 09:10:12");
//      Date date4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-07-20 07:11:01");
//      System.out.println(differentDaysByMillisecond(date3,date4));
//
//      Date date5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-07-11 19:10:12");
//      Date date6 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-07-20 07:11:01");
//      System.out.println(differentDaysByMillisecond(date5,date6));
//
//      Date date7 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-07-11 19:10:12");
//      Date date8 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-07-20 23:11:01");
//      System.out.println(differentDaysByMillisecond(date7,date8));
//
//    }catch (Exception e){
//
//    }

    }

    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     */
    public static int differentDaysByMillisecond(Date beginDate, Date endDate) {
        Calendar beginCalendar = Calendar.getInstance();
        beginCalendar.setTime(beginDate);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);
        long beginTime = beginCalendar.getTime().getTime();
        long endTime = endCalendar.getTime().getTime();
        int betweenDays = (int) ((endTime - beginTime) / (1000 * 60 * 60 * 24));//先算出两时间的毫秒数之差大于一天的天数

        endCalendar.add(Calendar.DAY_OF_MONTH, -betweenDays);//使endCalendar减去这些天数，将问题转换为两时间的毫秒数之差不足一天的情况
        endCalendar.add(Calendar.DAY_OF_MONTH, -1);//再使endCalendar减去1天
        if (beginCalendar.get(Calendar.DAY_OF_MONTH) == endCalendar.get(Calendar.DAY_OF_MONTH))//比较两日期的DAY_OF_MONTH是否相等
            return betweenDays + 1;    //相等说明确实跨天了
        else
            return betweenDays + 0;    //不相等说明确实未跨天
    }


}
