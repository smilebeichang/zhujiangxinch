package net.wanho.utils;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by songb on 2019/9/30.
 */
public class CustomGlobalStrToDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {

        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(source);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

}
