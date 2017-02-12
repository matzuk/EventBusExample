package com.matsyuk.eventbusexample.ui.view.first;

import android.support.annotation.NonNull;

/**
 * Created by Евгений on 12.02.2017.
 */

public interface IFirstView {
    void showMessageFromSecondScreen(@NonNull String message);
    void goToSecondScreen();
}
