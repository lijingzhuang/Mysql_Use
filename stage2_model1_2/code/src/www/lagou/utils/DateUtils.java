package www.lagou.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    //日期格式
    public static String getDateFormat(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}
