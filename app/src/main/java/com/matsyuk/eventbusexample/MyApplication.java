package com.matsyuk.eventbusexample;

import android.app.Application;

import com.matsyuk.eventbusexample.dagger.common.CommonComponent;
import com.matsyuk.eventbusexample.dagger.common.DaggerCommonComponent;

/**
 * Created by Евгений on 12.02.2017.
 */

public class MyApplication extends Application {

    public static MyApplication getInstance() {
        return instance;
    }

    private static MyApplication instance;

    private CommonComponent commonComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        // init dagger2 AppComponent
        commonComponent = DaggerCommonComponent.builder().build();
    }

    public CommonComponent getCommonComponent() {
        return commonComponent;
    }

}
