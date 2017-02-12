package com.matsyuk.eventbusexample.ui.bus;

import android.support.annotation.MainThread;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by Евгений on 12.02.2017.
 */

public class RxBus {

    private BehaviorSubject<String> fromFirstToSecondChannel = BehaviorSubject.create();
    private BehaviorSubject<String> fromSecondToFirstChannel = BehaviorSubject.create();

    @MainThread
    public void fromFirstToSecondSendMessage(String text) {
        fromFirstToSecondChannel.onNext(text);
    }

    @MainThread
    public void fromSecondToFirstSendMessage(String text) {
        fromSecondToFirstChannel.onNext(text);
    }

    @MainThread
    public Observable<String> listenFirstScreen() {
        return fromFirstToSecondChannel;
    }

    @MainThread
    public Observable<String> listenSecondScreen() {
        return fromSecondToFirstChannel;
    }

}
