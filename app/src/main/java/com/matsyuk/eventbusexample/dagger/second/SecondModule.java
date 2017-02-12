package com.matsyuk.eventbusexample.dagger.second;

import com.matsyuk.eventbusexample.ui.bus.RxBus;
import com.matsyuk.eventbusexample.ui.presenters.second.ISecondPresenter;
import com.matsyuk.eventbusexample.ui.presenters.second.SecondPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Евгений on 12.02.2017.
 */

@Module
public class SecondModule {

    @SecondScope
    @Provides
    public ISecondPresenter provideSecondPresenter(RxBus rxBus) {
        return new SecondPresenter(rxBus);
    }

}
