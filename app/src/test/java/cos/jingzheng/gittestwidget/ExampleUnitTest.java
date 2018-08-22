package cos.jingzheng.gittestwidget;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    public static final DateFormat FORMATOR_HMS = new SimpleDateFormat("HH:mm:ss");
    static String t = "00:07:53";
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }


    public static void main(String[] args) {
        long r = getMilliSecondFromHms(t);
        System.out.print(r);
    }

    public static long getMilliSecondFromHms(String time) {
        long times = 0L;
        try {
            times = FORMATOR_HMS.parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return times;
    }
}