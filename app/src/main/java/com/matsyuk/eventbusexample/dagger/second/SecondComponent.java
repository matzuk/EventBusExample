package com.matsyuk.eventbusexample.dagger.second;

import com.matsyuk.eventbusexample.ui.view.second.SecondScreen;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by Евгений on 12.02.2017.
 */

@Subcomponent(modules = {SecondModule.class})
@SecondScope
public interface SecondComponent {

    @Subcomponent.Builder
    interface Builder {
        SecondComponent build();
    }

    void inject(SecondScreen secondScreen);

}
