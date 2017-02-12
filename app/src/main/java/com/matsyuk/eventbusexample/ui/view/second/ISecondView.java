package com.matsyuk.eventbusexample.ui.view.second;

import android.support.annotation.NonNull;

/**
 * Created by Евгений on 12.02.2017.
 */

public interface ISecondView {
    void showMessageFromFirstScreen(@NonNull String message);
    void goToFirstScreen();
}
