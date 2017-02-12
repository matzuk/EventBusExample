package com.matsyuk.eventbusexample.ui.presenters.first;

import android.support.annotation.NonNull;

import com.matsyuk.eventbusexample.ui.view.first.IFirstView;

/**
 * Created by Евгений on 12.02.2017.
 */

public interface IFirstPresenter {
    void bindView(@NonNull IFirstView firstView);
    void unbindView();
    void sendMessageToSecond(@NonNull String message);
}
