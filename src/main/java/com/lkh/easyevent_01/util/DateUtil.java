package com.lkh.easyevent_01.util;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @author lkh
 * @create 2022-07-05-10:39
 */
public class DateUtil {
    public static Date formatToDate(String date){
        TemporalAccessor ta = DateTimeFormatter.ISO_INSTANT.parse(date);
        Instant i = Instant.from(ta);
        return Date.from(i);
    }

    public static String formatToString(Date date){
        return date.toInstant().atOffset(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT);
    }
}
