package com.destiny.model.util.date;

import org.joda.time.DateTime;

import java.util.Date;

public class DateUtils {



    public static Date getDateNow(){
        DateTime dateTime = new DateTime();
        return new Date(dateTime.getMillis());

    }



}
