package com.matsyuk.eventbusexample.dagger.first;

import com.matsyuk.eventbusexample.ui.view.first.FirstScreen;

import dagger.Subcomponent;

/**
 * Created by Евгений on 12.02.2017.
 */
@Subcomponent(modules = {FirstModule.class})
@FirstScope
public interface FirstComponent {

    @Subcomponent.Builder
    interface Builder {
        FirstComponent build();
    }

    void inject(FirstScreen firstScreen);

}
