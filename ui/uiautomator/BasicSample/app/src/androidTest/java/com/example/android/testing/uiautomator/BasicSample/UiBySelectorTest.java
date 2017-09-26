package com.example.android.testing.uiautomator.BasicSample;

/**
 * Created by lqi on 26/09/2017.
 */

import android.app.Instrumentation;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.regex.Pattern;

/**
 * Created by xushizhao on 15/11/10.
 */
@RunWith(AndroidJUnit4.class)
public class UiBySelectorTest {

    Instrumentation instrumentation;
    UiDevice device;

    @Before
    public void setUp(){

        instrumentation = InstrumentationRegistry.getInstrumentation();
        device = UiDevice.getInstance(instrumentation);

    }

    @Test
    public void testUiObject1() throws UiObjectNotFoundException, InterruptedException {
        Thread.sleep(3000);

        UiObject2 object2 ;
        //通过包含字符进行选取
        object2 = device.findObject(By.textContains("Home"));
        System.out.println(object2);
        object2.click();
        device.pressBack();
        device.pressBack();
        //休眠3秒
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1");

        //通过匹配第一个字符进行选取
        object2 = device.findObject(By.textStartsWith("T"));
        object2.click();
        device.pressBack();
        device.pressBack();
        //休眠3秒
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("2");

        //通过匹配最后一个字符进行选取
        object2 = device.findObject(By.textEndsWith("e"));
        object2.click();
        device.pressBack();
        device.pressBack();
        //休眠3秒
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("3");

        //通过匹配text属性进行选取
        object2 = device.findObject(By.text("TesterHome"));
        object2.click();
        device.pressBack();
        device.pressBack();
        System.out.println("4");

        //通过正则表达式进行匹配选取
        Pattern pt=Pattern.compile("([0-9]|\\.|\\-)*");
        object2 = device.findObject(By.text(pt));
        System.out.println("是否存在按钮:"+object2.isEnabled());

        object2 = device.findObject(By.text("TesterHome"));
        object2.click();
        //休眠3秒
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //通过class名称属性选取
        object2 = device.findObject(By.clazz("android.widget.ImageButton"));
        object2.click();
        device.pressBack();

        //通过package,class名称属性选取
        object2 = device.findObject(By.clazz("com.testerhome.nativeandroid","android.widget.ImageButto"));
        object2.click();
        device.pressBack();

        object2 = device.findObject(By.desc("Open navigation drawer"));
        System.out.println("----"+object2.isEnabled());
        object2.click();

        //通过下面二个方法可以看出,他们定位到的是同一个linearlayout
        //通过元素深度进行选取
        object2 = device.findObject(By.depth(7));
        System.out.println("============="+object2.getClassName());
        System.out.println("============="+object2.getApplicationPackage());

        //通过子元素进行匹配
        object2 = device.findObject(By.hasDescendant(By.text("TesterHome")));
        System.out.println("============="+object2.getClassName());
        System.out.println("============="+object2.getApplicationPackage());
        object2.click();

    }

}
