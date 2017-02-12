package com.matsyuk.eventbusexample.ui.presenters.first;

import android.support.annotation.NonNull;

import com.matsyuk.eventbusexample.ui.bus.RxBus;
import com.matsyuk.eventbusexample.ui.view.first.IFirstView;

/**
 * Created by Евгений on 12.02.2017.
 */

public class FirstPresenter implements IFirstPresenter {

    private RxBus rxBus;
    // without @Nullable because ReOrientation was disabled
    private IFirstView firstView;

    public FirstPresenter(RxBus rxBus) {
        this.rxBus = rxBus;
    }

    @Override
    public void bindView(@NonNull IFirstView firstView) {
        this.firstView = firstView;
        listenSecondScreen();
    }

    private void listenSecondScreen() {
        rxBus.listenSecondScreen()
                .subscribe(firstView::showMessageFromSecondScreen, throwable -> {});
    }

    @Override
    public void unbindView() {
        firstView = null;
    }

    @Override
    public void sendMessageToSecond(@NonNull String message) {
        rxBus.fromFirstToSecondSendMessage(message);
        firstView.goToSecondScreen();
    }

}
