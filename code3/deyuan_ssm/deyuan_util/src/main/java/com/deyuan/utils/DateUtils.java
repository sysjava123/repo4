package com.deyuan.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    //日期转字符串
    public static String Date2String(Date date,String patt){
        SimpleDateFormat format = new SimpleDateFormat(patt);
        String format1 = format.format(date);
        return format1;
    }
    //日期转字符串
    public static Date String2Date(String str,String patt){
        SimpleDateFormat format = new SimpleDateFormat(patt);
        try {
            Date parse  = format.parse(str);
            return parse;
        } catch (ParseException e) {
            throw new RuntimeException("日期转字符错误"+e);
        }

    }

}
