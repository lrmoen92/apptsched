package apptsched.common;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Logan.Moen on 7/25/2017.
 */
public abstract class DateHelper {

    public static Date dateConstructor(int year, int month, int day, boolean curTime){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.DAY_OF_MONTH, day);
        if(!curTime) {
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
        }

        return cal.getTime();
    }

    public static Date dateAndTimeConstructor(int year, int month, int day, int hour, int minute, int sec, int millisec){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, sec);
        cal.set(Calendar.MILLISECOND, millisec);

        return cal.getTime();
    }
}
