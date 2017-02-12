package com.matsyuk.eventbusexample.dagger.common;

import com.matsyuk.eventbusexample.dagger.first.FirstComponent;
import com.matsyuk.eventbusexample.dagger.second.SecondComponent;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Евгений on 12.02.2017.
 */
@Component(modules = {BusModule.class})
@Singleton
public interface CommonComponent {

    FirstComponent.Builder firstComponentBuilder();
    SecondComponent.Builder secondComponentBuilder();

}
