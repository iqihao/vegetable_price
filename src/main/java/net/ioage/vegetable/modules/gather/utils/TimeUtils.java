package net.ioage.vegetable.modules.gather.utils;

import net.ioage.vegetable.modules.gather.service.GatherServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ by qihao on 2018/5/5.
 */
public class TimeUtils {

    private static final Logger logger = LoggerFactory.getLogger(GatherServiceImpl.class);

    /**
     * 将字符串格式的时间转换为DATE对象
     * @param s 规定格式的时间字符串
     * @return Date 对象
     */
    public static Date sting2Date(String s) {
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(s);
        } catch (ParseException e) {
            logger.error("Parse Exception {}", s);
        }
        return date;
    }
}
