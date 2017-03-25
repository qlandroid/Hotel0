package cn.yizhupingtai.android.hotel;

import android.content.Intent;
import android.os.SystemClock;
import android.test.InstrumentationTestCase;
import android.view.View;
import android.widget.EditText;

import cn.yizhupingtai.android.hotel.ui.aty.OrderedFlatLongAty;

/**
 * Created by Administrator on 2017-2-25.
 */
public class AbcTest extends InstrumentationTestCase {
    private EditText etAccount;
    private OrderedFlatLongAty loginAty;
    private EditText etPassword;
    private View tvLogin;

    public void test() throws Exception{
        assertEquals('a','a');
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent();
        intent.setClassName("cn.yizhupingtai.android.hotel", OrderedFlatLongAty.class.getName());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        loginAty = (OrderedFlatLongAty) getInstrumentation().startActivitySync(intent);
    }

    public void testActivity()throws Exception{

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                loginAty.addList();
            }
        });
        SystemClock.sleep(1000);
        SystemClock.sleep(1000);
        SystemClock.sleep(11000);
    }

    @Override
    protected void tearDown() throws Exception {
        //loginAty.finish();
        super.tearDown();
    }
}
