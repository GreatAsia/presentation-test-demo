package com.okay.presentationdemo;

import android.app.Presentation;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.BatteryManager;
import android.os.Looper;
import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.content.ContentValues.TAG;
import static android.content.Context.BATTERY_SERVICE;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    public DifferentDisplay presentation;
    Context appContext = InstrumentationRegistry.getTargetContext();
    UiDevice mDevices = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());


    @Rule
    public ActivityTestRule<MainActivity> mMainActivityRule = new ActivityTestRule(MainActivity.class);

    @Before
    public void beforetest() {

        presentation = mMainActivityRule.getActivity().presentation;
    }


    @Test
    public void presentationTest() {

        UiObject2 uiObject2 = mDevices.findObject(By.text("PresentationDemo"));
        uiObject2.click();
        SystemClock.sleep(3000);
        Button button = presentation.findViewById(R.id.testbutton);
        Boolean result = button.callOnClick();
        SystemClock.sleep(5000);
        String text = button.getText().toString();

        Log.i(TAG, "buttontext: " + text);
    }


    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        BatteryManager batteryManager = (BatteryManager) appContext.getSystemService(BATTERY_SERVICE);
        Log.i("bassery", "useAppContext: " + batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CHARGE_COUNTER));
        Log.i("bassery", "useAppContext: " + batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CURRENT_AVERAGE));
        System.out.println(batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CURRENT_NOW));


        assertEquals("com.okay.presentationdemo", appContext.getPackageName());


    }
}
