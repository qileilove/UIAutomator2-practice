package com.example.android.testing.uiautomator.BasicSample;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;

import static junit.framework.Assert.fail;

/**
 * Created by lqi on 09/10/2017.
 */

public class findBy {
    UiDevice mDevice =null;
    UiObject2 MobileElement =null;
    public UiObject2 getElement(String packagename,String locator ,String path) throws InterruptedException {


        switch (locator){
            case "ByXpath" :
                MobileElement=waitForObject(By.res("com.example.app:id/numboard_pwd_edittext"));
                break;
            case "ById":
                MobileElement=waitForObject(By.res(packagename+":id/"+path));
                break;
            case "ByCssSelector":
                MobileElement=mDevice.findObject(By.cssSelector( path));
                break;
            case "ByName":
                MobileElement=mDevice.findObject(By.name( path));
                break;
            case "ByClassName":
                MobileElement=mDevice.findObject(By.className( path));
                break;
            case "ByLinkText":
                MobileElement=mDevice.findObject(By.linkText( path));
                break;
            case "ByPartialLinkText":
                MobileElement=mDevice.findObject(By.partialLinkText( path));
                break;
            case "ByTagName":
                MobileElement=mDevice.findObject(By.tagName( path));
                break;
            case "ByIosNsPredicateString":
                MobileElement=mDevice.findObject(MobileBy.iOSNsPredicateString( path));
                break;
            case "ByIosUIAutomation":
                MobileElement=mDevice.findObject(MobileBy.IosUIAutomation( path));
                break;
            case "ByIosClassChain":
                MobileElement=mDevice.findObject(MobileBy.iOSClassChain( path));
                break;
            case "ByAndroidUIAutomator":
                MobileElement=mDevice.findObject(MobileBy.AndroidUIAutomator( path));
                break;

        }
        return MobileElement;    }

    private UiObject2 waitForObject(BySelector selector) throws InterruptedException {
        UiObject2 object = null;
        int timeout = 30000;
        int delay = 1000;
        long time = System.currentTimeMillis();
        while (object == null) {
            object = mDevice.findObject(selector);
            Thread.sleep(delay);
            if (System.currentTimeMillis() - timeout > time) {
                fail();
            }
        }
        return object;
    }
}
