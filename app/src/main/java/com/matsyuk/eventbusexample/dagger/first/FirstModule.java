package com.matsyuk.eventbusexample.dagger.first;

import com.matsyuk.eventbusexample.ui.bus.RxBus;
import com.matsyuk.eventbusexample.ui.presenters.first.FirstPresenter;
import com.matsyuk.eventbusexample.ui.presenters.first.IFirstPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Евгений on 12.02.2017.
 */
@Module
public class FirstModule {

    @FirstScope
    @Provides
    public IFirstPresenter provideFirstPresenter(RxBus rxBus) {
        return new FirstPresenter(rxBus);
    }

}
