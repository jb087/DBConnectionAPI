package dbconnection;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertTrue;


public class DateTest {

    private Date date1;
    private Date date2;

    @Before
    public void initialize() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date1 = simpleDateFormat.parse("2019-01-01 10:10:10");
        date2 = simpleDateFormat.parse("2019-01-01 10:10:11");
    }

    @Test
    public void dateCompareTest() {
       assertTrue(date1.before(date2));
    }
}
