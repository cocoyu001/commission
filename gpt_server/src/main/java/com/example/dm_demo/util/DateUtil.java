package com.example.dm_demo.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;


public class DateUtil {

    // ~ Static fields/initializers
    // =============================================

    private static Logger log = LoggerFactory.getLogger(DateUtil.class);
    private static String defaultDatePattern = null;
    private static String timePattern = "HH:mm";
    public static final String TS_FORMAT = DateUtil.getDatePattern() + " HH:mm:ss.S";
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat sdf3 = new SimpleDateFormat("EEEE");
    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
    private static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    private static final String PATTERN_DATE = "yyyy-MM-dd";

    // ~ Methods
    // ================================================================

    public DateUtil() {
    }

    /**
     * 获取当前服务器时间（yyyy-MM-dd HH:mm:ss:SSS）。
     */
    public static String getCurrentFullDateTime() {
        try {
            return sdf5.format(new Date());
        } catch (Exception e) {
            log.debug("DateUtil.getCurrentFullDateTime(): " + e.getMessage());
            return "";
        }
    }

    /**
     * 获得服务器当前日期及时间，以格式为：yyyy-MM-dd HH:mm:ss的日期字符串形式返回
     */
    public static String getStringDateTimeT(Date date) {
        try {
            return sdf4.format(date);
        } catch (Exception e) {
            log.debug("DateUtil.getDateTime():" + e.getMessage());
            return "";
        }
    }

    public static Date getDateTimeT(String times) {
        try {
            return sdf4.parse(times);
        } catch (Exception e) {
            log.debug("DateUtil.getDateTime():" + e.getMessage());
            return null;
        }
    }

    public static Date getDateTimeT2(String times) {
        try {
            return sdf.parse(times);
        } catch (Exception e) {
            log.debug("DateUtil.getDateTime():" + e.getMessage());
            return null;
        }
    }


    /**
     * 获得服务器当前日期及时间，以格式为：yyyy-MM-dd HH:mm:ss的日期字符串形式返回
     */
    public static String getDateTime() {
        Calendar cale = Calendar.getInstance();
        try {
            return sdf2.format(cale.getTime());
        } catch (Exception e) {
            log.debug("DateUtil.getDateTime():" + e.getMessage());
            return "";
        }
    }

    public static String getDateTime(Date date) {
        //Calendar cale = Calendar.getInstance();
        try {
            return sdf2.format(date.getTime());
        } catch (Exception e) {
            log.debug("DateUtil.getDateTime():" + e.getMessage());
            return "";
        }
    }

    /**
     * 获得服务器当前日期，以格式为：yyyy-MM-dd的日期字符串形式返回
     */
    public static String getDate() {
        Calendar cale = Calendar.getInstance();
        try {
            return sdf.format(cale.getTime());
        } catch (Exception e) {
            log.debug("DateUtil.getDate():" + e.getMessage());
            return "";
        }
    }

    /**
     * 获得服务器zuo日期，以格式为：yyyy-MM-dd的日期字符串形式返回
     */
    public static String getYesterdayDate() {
        Calendar cale = Calendar.getInstance();
        cale.add(Calendar.DATE, 0);
        try {
            return sdf.format(cale.getTime());
        } catch (Exception e) {
            log.debug("DateUtil.getDate():" + e.getMessage());
            return "";
        }
    }

    /**
     * 获得服务器当前时间，以格式为：HH:mm:ss的日期字符串形式返回
     */
    public static String getTime() {
        Calendar cale = Calendar.getInstance();
        String temp = "";
        try {
            temp += sdf1.format(cale.getTime());
            return temp;
        } catch (Exception e) {
            log.debug("DateUtil.getTime():" + e.getMessage());
            return "";
        }
    }

    /**
     * 获得服务器当前时间，以格式为：HH:mm:ss的日期字符串形式返回
     */
    public static Long getTimeLong() {
        Calendar cale = Calendar.getInstance();
        String temp = "";
        try {
            temp += sdf1.format(cale.getTime());
            return sdf1.parse(temp).getTime();
        } catch (Exception e) {
            log.debug("DateUtil.getTimeLong():" + e.getMessage());
            return 0L;
        }
    }

    /**
     * 统计时开始日期的默认值, 今年的开始时间
     */
    public static String getStartDate() {
        try {
            return getYear() + "-01-01";
        } catch (Exception e) {
            log.debug("DateUtil.getStartDate():" + e.getMessage());
            return "";
        }
    }

    /**
     * 统计时结束日期的默认值
     */
    public static String getEndDate() {
        try {
            return getDate();
        } catch (Exception e) {
            log.debug("DateUtil.getEndDate():" + e.getMessage());
            return "";
        }
    }

    /**
     * 获得服务器当前日期的年份
     */
    public static String getYear() {
        Calendar cale = Calendar.getInstance();
        try {
            // 返回的int型，需要字符串转换
            return String.valueOf(cale.get(Calendar.YEAR));
        } catch (Exception e) {
            log.debug("DateUtil.getYear():" + e.getMessage());
            return "";
        }
    }

    /**
     * 获得服务器当前日期的年份
     */
    public static String getWeek() {
        Calendar cale = Calendar.getInstance();
        try {
            // 返回的int型，需要字符串转换
            return sdf3.format(cale.getTime());
        } catch (Exception e) {
            log.debug("DateUtil.getYear():" + e.getMessage());
            return "";
        }
    }

    /**
     * 获得服务器当前日期的月份
     */
    public static String getMonth() {
        Calendar cale = Calendar.getInstance();
        try {
            // 一个数字格式，非常好
            java.text.DecimalFormat df = new java.text.DecimalFormat();
            df.applyPattern("00");
            return df.format((cale.get(Calendar.MONTH) + 1));
            // return String.valueOf(cale.get(Calendar.MONTH) + 1);
        } catch (Exception e) {
            log.debug("DateUtil.getMonth():" + e.getMessage());
            return "";
        }
    }

    /**
     * 获得服务器在当前月中天数
     */
    public static String getDay() {
        Calendar cale = Calendar.getInstance();
        try {
            return String.valueOf(cale.get(Calendar.DAY_OF_MONTH));
        } catch (Exception e) {
            log.debug("DateUtil.getDay():" + e.getMessage());
            return "";
        }
    }

    /**
     * 字符串转换成日期
     *
     * @param str
     * @return date
     */
    public static Date StrToHhMmSs(String str) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
     *
     * @param nowTime   当前时间
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     * @author jqlin
     */
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
            || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断时间是否在时间段内
     *
     * @param nowTime
     * @param beginTime
     * @param endTime
     * @return
     */
    public static boolean belongCalendar(Date nowTime, Date beginTime,
                                         Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

    public static String dateToHhMmSs(Date date) {
        if (date != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            String tablename = dateFormat.format(date);
            return tablename;
        }
        return null;
    }

    /**
     * 根据两个时间判断当前时间是否在两个时间范围内
     *
     * @param begin
     * @param end
     * @return
     */
    public Boolean ifDateInner(Date begin, Date end) {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");// 设置日期格式
        Date now = null;
        Date beginTime = null;
        Date endTime = null;
        try {
            now = df.parse(df.format(new Date()));
            beginTime = df.parse(dateToHhMmSs(begin));
            endTime = df.parse(dateToHhMmSs(end));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return belongCalendar(now, beginTime, endTime);
    }

    /**
     * 比较两个日期相差的天数, 第一个日期要比第二个日期要晚
     */
    public static int getMargin(String date1, String date2) {
        int margin;
        try {
            ParsePosition pos = new ParsePosition(0);
            ParsePosition pos1 = new ParsePosition(0);
            Date dt1 = sdf.parse(date1, pos);
            Date dt2 = sdf.parse(date2, pos1);
            long l = dt1.getTime() - dt2.getTime();
            margin = (int) (l / (24 * 60 * 60 * 1000));
            return margin;
        } catch (Exception e) {
            log.debug("DateUtil.getMargin():" + e.toString());
            return 0;
        }
    }

    /**
     * 比较两个日期相差的天数，格式不一样 第一个日期要比第二个日期要晚
     */
    public static double getDoubleMargin(String date1, String date2) {
        double margin;
        try {
            ParsePosition pos = new ParsePosition(0);
            ParsePosition pos1 = new ParsePosition(0);
            Date dt1 = sdf2.parse(date1, pos);
            Date dt2 = sdf2.parse(date2, pos1);
            long l = dt1.getTime() - dt2.getTime();
            margin = (l / (24 * 60 * 60 * 1000.00));
            return margin;
        } catch (Exception e) {
            log.debug("DateUtil.getMargin():" + e.toString());
            return 0;
        }
    }

    /**
     * 比较两个日期相差的天数，格式不一样 第一个日期要比第二个日期要晚
     */
    public static double getDoubleHoursMargin(String date1, String date2) {
        double margin;
        try {
            ParsePosition pos = new ParsePosition(0);
            ParsePosition pos1 = new ParsePosition(0);
            Date dt1 = sdf2.parse(date1, pos);
            Date dt2 = sdf2.parse(date2, pos1);
            long l = dt1.getTime() - dt2.getTime();
            margin = (l / (60 * 60 * 1000.00));
            return margin;
        } catch (Exception e) {
            log.debug("DateUtil.getMargin():" + e.toString());
            return 0;
        }
    }

    /**
     * 比较两个日期相差的月数
     */
    public static int getMonthMargin(String date1, String date2) {
        int margin;
        try {
            margin = (Integer.parseInt(date2.substring(0, 4)) - Integer
                .parseInt(date1.substring(0, 4))) * 12;
            margin += (Integer.parseInt(date2.substring(4, 7).replaceAll("-0",
                "-")) - Integer.parseInt(date1.substring(4, 7).replaceAll(
                "-0", "-")));
            return margin;
        } catch (Exception e) {
            log.debug("DateUtil.getMargin():" + e.toString());
            return 0;
        }
    }

    /**
     * 返回日期加X天后的日期
     */
    public static String addDay(String date, int i) {
        try {
            GregorianCalendar gCal = new GregorianCalendar(
                Integer.parseInt(date.substring(0, 4)),
                Integer.parseInt(date.substring(5, 7)) - 1,
                Integer.parseInt(date.substring(8, 10)));
            gCal.add(GregorianCalendar.DATE, i);
            return sdf.format(gCal.getTime());
        } catch (Exception e) {
            log.debug("DateUtil.addDay():" + e.toString());
            return getDate();
        }
    }

    /**
     * 返回日期加X月后的日期
     */
    public static String addMonth(String date, int i) {
        try {
            GregorianCalendar gCal = new GregorianCalendar(
                Integer.parseInt(date.substring(0, 4)),
                Integer.parseInt(date.substring(5, 7)) - 1,
                Integer.parseInt(date.substring(8, 10)));
            gCal.add(GregorianCalendar.MONTH, i);
            return sdf.format(gCal.getTime());
        } catch (Exception e) {
            log.debug("DateUtil.addMonth():" + e.toString());
            return getDate();
        }
    }

    /**
     * 返回日期加X年后的日期
     */
    public static String addYear(String date, int i) {
        try {
            GregorianCalendar gCal = new GregorianCalendar(
                Integer.parseInt(date.substring(0, 4)),
                Integer.parseInt(date.substring(5, 7)) - 1,
                Integer.parseInt(date.substring(8, 10)));
            gCal.add(GregorianCalendar.YEAR, i);
            return sdf.format(gCal.getTime());
        } catch (Exception e) {
            log.debug("DateUtil.addYear():" + e.toString());
            return "";
        }
    }

    /**
     * 返回某年某月中的最大天
     */
    public static int getMaxDay(String year, String month) {
        int day = 0;
        try {
            int iyear = Integer.parseInt(year);
            int imonth = Integer.parseInt(month);
            if (imonth == 1 || imonth == 3 || imonth == 5 || imonth == 7
                || imonth == 8 || imonth == 10 || imonth == 12) {
                day = 31;
            } else if (imonth == 4 || imonth == 6 || imonth == 9
                || imonth == 11) {
                day = 30;
            } else if ((0 == (iyear % 4)) && (0 != (iyear % 100))
                || (0 == (iyear % 400))) {
                day = 29;
            } else {
                day = 28;
            }
            return day;
        } catch (Exception e) {
            log.debug("DateUtil.getMonthDay():" + e.toString());
            return 1;
        }
    }

    /**
     * 格式化日期
     */
    @SuppressWarnings("static-access")
    public String rollDate(String orgDate, int Type, int Span) {
        try {
            String temp = "";
            int iyear, imonth, iday;
            int iPos = 0;
            char seperater = '-';
            if (orgDate == null || orgDate.length() < 6) {
                return "";
            }

            iPos = orgDate.indexOf(seperater);
            if (iPos > 0) {
                iyear = Integer.parseInt(orgDate.substring(0, iPos));
                temp = orgDate.substring(iPos + 1);
            } else {
                iyear = Integer.parseInt(orgDate.substring(0, 4));
                temp = orgDate.substring(4);
            }

            iPos = temp.indexOf(seperater);
            if (iPos > 0) {
                imonth = Integer.parseInt(temp.substring(0, iPos));
                temp = temp.substring(iPos + 1);
            } else {
                imonth = Integer.parseInt(temp.substring(0, 2));
                temp = temp.substring(2);
            }

            imonth--;
            if (imonth < 0 || imonth > 11) {
                imonth = 0;
            }

            iday = Integer.parseInt(temp);
            if (iday < 1 || iday > 31)
                iday = 1;

            Calendar orgcale = Calendar.getInstance();
            orgcale.set(iyear, imonth, iday);
            temp = this.rollDate(orgcale, Type, Span);
            return temp;
        } catch (Exception e) {
            return "";
        }
    }

    public static String rollDate(Calendar cal, int Type, int Span) {
        try {
            String temp = "";
            Calendar rolcale;
            rolcale = cal;
            rolcale.add(Type, Span);
            temp = sdf.format(rolcale.getTime());
            return temp;
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 返回默认的日期格式
     */
    public static synchronized String getDatePattern() {
        defaultDatePattern = "yyyy-MM-dd";
        return defaultDatePattern;
    }

    /**
     * 将指定日期按默认格式进行格式代化成字符串后输出如：yyyy-MM-dd
     */
    public static final String getDate(Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate != null) {
            df = new SimpleDateFormat(getDatePattern());
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

    /**
     * 取得给定日期的时间字符串，格式为当前默认时间格式
     */
    public static String getTimeNow(Date theTime) {
        return getDateTime(timePattern, theTime);
    }

    /**
     * 取得给定日期的时间字符串，格式为当前默认时间格式
     */
    public static String getTimeNowSs(Date theTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(theTime);
        return time;
    }

    /**
     * 取得当前时间的Calendar日历对象
     */
    public Calendar getToday() throws ParseException {
        Date today = new Date();
        SimpleDateFormat df = new SimpleDateFormat(getDatePattern());
        String todayAsString = df.format(today);
        Calendar cal = new GregorianCalendar();
        cal.setTime(convertStringToDate(todayAsString));
        return cal;
    }

    /**
     * 将日期类转换成指定格式的字符串形式
     */
    public static final String getDateTime(String aMask, Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate == null) {
            log.error("aDate is null!");
        } else {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }
        return (returnValue);
    }

    /**
     * 将指定的日期转换成默认格式的字符串形式
     */
    public static final String convertDateToString(Date aDate) {
        return getDateTime(getDatePattern(), aDate);
    }

    /**
     * 将日期字符串按指定格式转换成日期类型
     *
     * @param aMask   指定的日期格式，如:yyyy-MM-dd
     * @param strDate 待转换的日期字符串
     */

    public static final Date convertStringToDate(String aMask, String strDate)
        throws ParseException {
        SimpleDateFormat df = null;
        Date date = null;
        df = new SimpleDateFormat(aMask);

        if (log.isDebugEnabled()) {
            log.debug("converting '" + strDate + "' to date with mask '"
                + aMask + "'");
        }
        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            log.error("ParseException: " + pe);
            throw pe;
        }
        return (date);
    }

    /**
     * 将日期字符串按默认格式转换成日期类型
     */
    public static Date convertStringToDate(String strDate)
        throws ParseException {
        Date aDate = null;

        try {
            if (log.isDebugEnabled()) {
                log.debug("converting date with pattern: " + getDatePattern());
            }
            aDate = convertStringToDate(getDatePattern(), strDate);
        } catch (ParseException pe) {
            log.error("Could not convert '" + strDate
                + "' to a date, throwing exception");
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());

        }

        return aDate;
    }

    /**
     * 返回一个JAVA简单类型的日期字符串
     */
    public static String getSimpleDateFormat() {
        SimpleDateFormat formatter = new SimpleDateFormat();
        String NDateTime = formatter.format(new Date());
        return NDateTime;
    }

    /**
     * 将两个字符串格式的日期进行比较
     *
     * @param last 要比较的第一个日期字符串
     * @param now  要比较的第二个日期格式字符串
     * @return true(last 在now 日期之前), false(last 在now 日期之后)
     */
    public static boolean compareTo(String last, String now) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
            Date temp1 = formatter.parse(last);
            Date temp2 = formatter.parse(now);
            if (temp1.after(temp2))
                return false;
            else if (temp1.before(temp2))
                return true;
        } catch (ParseException e) {
            log.debug(e.getMessage());
        }
        return false;
    }


    /**
     * 取得当前时间的日戳
     *
     * @return
     */
    @SuppressWarnings("deprecation")
    public static String getTimestamp() {
        Date date = new Date();
        String timestamp = "" + (date.getYear() + 1900) + date.getMonth()
            + date.getDate() + date.getMinutes() + date.getSeconds()
            + date.getTime();
        return timestamp;
    }

    /*
     * 将10 or 13 位时间戳转为时间字符串
     * convert the number 1407449951 1407499055617 to date/time format timestamp
     */
    public static String timestamp2Date(String str_num, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if (str_num.length() == 13) {
            String date = sdf.format(new Date(Long.parseLong(str_num)));
//			LogUtil.debug("timestamp2Date"+ "将13位时间戳:" + str_num + "转化为字符串:", date);
            return date;
        } else {
            String date = sdf.format(new Date(Integer.parseInt(str_num) * 1000L));
//			LogUtil.debug("timestamp2Date" + "将10位时间戳:" + str_num + "转化为字符串:", date);
            return date;
        }
    }

    //	/**
//	 * 时间戳转时间(10位时间戳)
//	 * @param time
//	 * @return
//	 */
    public static String timestampToDate(long time) {
//		String dateTime;
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//		long timeLong = Long.valueOf(time);
//		dateTime = simpleDateFormat.format(new Date(timeLong * 1000L));

        long timeStamp = (long) time * 1000;//直接是时间戳
//            long timeStamp = System.currentTimeMillis();  //获取当前时间戳,也可以是你自已给的一个随机的或是别人给你的时间戳(一定是long型的数据)
        System.out.println(timeStamp);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//这个是你要转成后的时间的格式
        String sd = sdf.format(new Date(timeStamp));   // 时间戳转换成时间
        return sd;
    }

//	public static String timestampToDate(String s){
//		String res;
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		long lt = new Long(s);
//		Date date = new Date(lt);
//		res = simpleDateFormat.format(date);
//		return res;
//	}


    /**
     * 取得指定时间的日戳
     *
     * @return
     */
    @SuppressWarnings("deprecation")
    public static String getTimestamp(Date date) {
        String timestamp = "" + (date.getYear() + 1900) + date.getMonth()
            + date.getDate() + date.getMinutes() + date.getSeconds()
            + date.getTime();
        return timestamp;
    }

    public static String getMondayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat(PATTERN_DATE);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return dateFormat.format(calendar.getTime());
    }

    public static List<String> getQujianDateList(String startDate,
                                                 String endDate) throws ParseException {
        List<String> dateList = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date begin = sdf.parse(startDate);
        Date end = sdf.parse(endDate);
        double between = (end.getTime() - begin.getTime()) / 1000;// 除以1000是为了转换成秒
        double day = between / (24 * 3600);
        dateList.add(startDate);
        for (int i = 1; i <= day; i++) {

            Calendar cd = Calendar.getInstance();
            cd.setTime(sdf.parse(startDate));
            cd.add(Calendar.DATE, i);// 增加一天
            // cd.add(Calendar.MONTH, n);//增加一个月
//			 System.out.println(sdf.format(cd.getTime()));
            dateList.add(sdf.format(cd.getTime()));

        }
        return dateList;
    }

    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt * 1000L);
        res = simpleDateFormat.format(date);
        return res;
    }

    /*
     * 将时间戳转换为时间
     */
    public static String stamp13ToDate(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    /**
     * 根据传入的时间加上或减去若干秒
     *
     * @param date   Date 日期
     * @param Second Second 秒数
     * @return 返回相加后的日期
     */
    public static Date addSecond(Date date, Long Second) {
        Calendar calendar = Calendar.getInstance();
        long millis = getMillis(date) + Second * 1000;
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    /**
     * 功能描述：返回毫秒
     *
     * @param date 日期
     * @return 返回毫秒
     */
    public static long getMillis(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }


    /**
     * 返回日期加X天后的日期
     */
    public static String addHour(String day, int hour) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(day);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (date == null)
            return "";
        System.out.println("front:" + format.format(date)); //显示输入的日期
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hour);// 24小时制
        date = cal.getTime();
        System.out.println("after:" + format.format(date));  //显示更新后的日期
        return format.format(date);
    }


    /**
     * 获取指定的时间：yyyy-MM-dd
     * -1是昨天 0是当天 1是明天
     *
     * @param date
     * @return
     */
    public static String getYesterdayString(String format, Date date, int day) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.DAY_OF_MONTH, day);
        Date yesterdayDate = calendar.getTime();
        return sdf.format(yesterdayDate);
    }

    // 获取本周的开始时间
    public static Date getBeginDayOfWeek() {
        Date date = new Date();
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek);
        return getDayStartTime(cal.getTime());
    }

    // 获取上周的开始时间
    @SuppressWarnings("unused")
    public static Date getBeginDayOfLastWeek() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek - 7);
        return getDayStartTime(cal.getTime());
    }

    // 获取上周的结束时间
    public static Date getEndDayOfLastWeek() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getBeginDayOfLastWeek());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        Date weekEndSta = cal.getTime();
        return getDayEndTime(weekEndSta);
    }

    // 获取某个日期的结束时间
    public static Timestamp getDayEndTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d)
            calendar.setTime(d);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return new Timestamp(calendar.getTimeInMillis());
    }

    // 获取某个日期的开始时间
    public static Timestamp getDayStartTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d)
            calendar.setTime(d);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }


    /**
     * 获取当天的开始时间
     */
    public static Date getDayBegin() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取当天的结束时间
     */
    public static Date getDayEnd() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    /**
     * 获取昨天的开始时间
     */
    public static Date getBeginDayOfYesterday() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayBegin());
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }

    /**
     * 获取昨天的结束时间
     */
    public static Date getEndDayOfYesterDay() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayEnd());
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }

    /**
     * 获取明天的开始时间
     */
    public static Date getBeginDayOfTomorrow() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayBegin());
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    /**
     * 获取明天的结束时间
     */
    public static Date getEndDayOfTomorrow() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayEnd());
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }


    public static boolean openWithdrawal(Time beginTime, Time endTime, Timestamp now) {
        boolean flag = false;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date = new Date();
                long nows = now.getTime();
                long s = sdf.parse(sdf1.format(date) + " " + beginTime).getTime();
                long e = sdf.parse(sdf1.format(date) + " " + endTime).getTime();
                if (s < nows && e >= nows) {
                    flag = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                flag = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return flag;
    }


    public static boolean openJoin(String assemblyTime, Timestamp now) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            boolean flag = false;
            String value = assemblyTime.trim();
            if (value.equals("0")) {
                return false;
            } else if (value.equals("24")) {
                return true;
            }
            try {
                Date date = new Date();
                long nows = now.getTime();
                long s = sdf.parse(sdf1.format(date) + " " + (value.trim().split("-")[0]) + ":00").getTime();
                long e = sdf.parse(sdf1.format(date) + " " + (value.trim().split("-")[1]) + ":00").getTime();
                if (s < nows && e >= nows) {
                    flag = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                flag = false;
            }
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getNowDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String newDate = sdf.format(new Date());
        return newDate;
    }

    public static String getMyTimeFormat(Integer status) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
        String newDate = status + "&" + sdf.format(new Date());
        return newDate;
    }

    /**
     * String转Date
     */
    public static Date stringByData(String res) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd MM-dd HH:mm");//注意月份是MM
        Date date = null;
        try {
            date = simpleDateFormat.parse(res);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 在基础时间上加或者减一天
     *
     * @param date 当前时间
     * @param day  正数为加负数为减
     * @return
     */
    public static Date getNextDay(Date date, Integer day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);//+1今天的时间加一天
        date = calendar.getTime();
        return date;
    }

    public static SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    public static SimpleDateFormat format1 = new SimpleDateFormat(
        "yyyyMMdd HH:mm:ss");

    /**
     * 得到指定日期的一天的的最后时刻23:59:59
     *
     * @param date
     * @return
     */
    public static Date getFinallyDate(Date date) {
        String temp = format.format(date);
        temp += " 23:59:59";

        try {
            return format1.parse(temp);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 得到指定日期的一天的开始时刻00:00:00
     *
     * @param date
     * @return
     */
    public static Date getStartDate(Date date) {
        String temp = format.format(date);
        temp += " 00:00:00";

        try {
            return format1.parse(temp);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取{addDay}天后的0点
     *
     * @param addDay 多少天后，0当天
     * @return
     */
    public static Timestamp getDayStartTime(int addDay) {
        Calendar cal = Calendar.getInstance(Locale.CHINA);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.DAY_OF_MONTH, addDay);
        return new Timestamp(cal.getTimeInMillis());
    }

}
