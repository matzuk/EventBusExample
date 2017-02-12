package com.matsyuk.eventbusexample.ui.presenters.second;

import android.support.annotation.NonNull;

import com.matsyuk.eventbusexample.ui.bus.RxBus;
import com.matsyuk.eventbusexample.ui.view.second.ISecondView;

/**
 * Created by Евгений on 12.02.2017.
 */

public class SecondPresenter implements ISecondPresenter {

    private RxBus rxBus;
    // without @Nullable because ReOrientation was disabled
    private ISecondView secondView;

    public SecondPresenter(RxBus rxBus) {
        this.rxBus = rxBus;
    }

    @Override
    public void bindView(@NonNull ISecondView secondView) {
        this.secondView = secondView;
        listenSecondScreen();
    }

    private void listenSecondScreen() {
        rxBus.listenFirstScreen()
                .subscribe(secondView::showMessageFromFirstScreen, throwable -> {});
    }

    @Override
    public void unbindView() {
        secondView = null;
    }

    @Override
    public void sendMessageToFirst(@NonNull String message) {
        rxBus.fromSecondToFirstSendMessage(message);
        secondView.goToFirstScreen();
    }

}
