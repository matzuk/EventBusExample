package com.matsyuk.eventbusexample.dagger.common;

import com.matsyuk.eventbusexample.ui.bus.RxBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Евгений on 12.02.2017.
 */

@Module
public class BusModule {

    @Singleton
    @Provides
    public RxBus provideRxBus() {
        return new RxBus();
    }

}
