
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.hibernate.boot.jaxb.SourceType;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by Administrator on 2017/10/25.
 */
public class Stest {
    public static void main(String[] args) throws ParseException {
       /* String string = "2016-10-24 21:59:06";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.parse(string));*/

       /* String dateString = "2012-12-06 ";
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
            Date date = sdf.parse(dateString);
            System.out.println(date);
        }
        catch (ParseException e)
        {
            System.out.println(e.getMessage());
        }*/

      /*  String dateString = "2012-12-06";
        String da="2017-10-25";

        Date   date = null;
        Date    date1=null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            date = simpleDateFormat.parse(dateString);
              date1 = simpleDateFormat.parse(da);
            System.out.println(date);
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
*/

/*
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(sdf.format(date));
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(sdf.format(date));*/

            Date time=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式
            Calendar cal = Calendar.getInstance();
            cal.setTime(time);
            //判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
            int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
            if(1 == dayWeek) {
                    cal.add(Calendar.DAY_OF_MONTH, -1);
            }
            System.out.println("要计算日期为:"+sdf.format(cal.getTime())); //输出要计算日期
            cal.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
            int day = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
            cal.add(Calendar.DATE, cal.getFirstDayOfWeek()-day);//根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
            String imptimeBegin = sdf.format(cal.getTime());
            System.out.println("所在周星期一的日期："+imptimeBegin);
            cal.add(Calendar.DATE, 6);
            String imptimeEnd = sdf.format(cal.getTime());
            System.out.println("所在周星期日的日期："+imptimeEnd);



            //获取前几天的时间
            Date date=new Date();//取时间
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            calendar.add(calendar.DATE,-7);//把日期往前减少一天，若想把日期向后推一天则将负数改为正数
            date=calendar.getTime();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = formatter.format(date);
            System.out.println("前一天:"+dateString);


    }


}
