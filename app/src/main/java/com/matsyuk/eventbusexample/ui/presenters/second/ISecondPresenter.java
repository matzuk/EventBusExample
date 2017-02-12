package com.matsyuk.eventbusexample.ui.presenters.second;

import android.support.annotation.NonNull;

import com.matsyuk.eventbusexample.ui.view.second.ISecondView;

/**
 * Created by Евгений on 12.02.2017.
 */

public interface ISecondPresenter {
    void bindView(@NonNull ISecondView secondView);
    void unbindView();
    void sendMessageToFirst(@NonNull String message);
}
