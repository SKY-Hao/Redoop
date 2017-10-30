package common.utils;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.hibernate.boot.jaxb.SourceType;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
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


            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(sdf.format(date));
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(sdf.format(date));



    }


}
