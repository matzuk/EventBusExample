package com.matsyuk.eventbusexample.ui.view.second;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.matsyuk.eventbusexample.MyApplication;
import com.matsyuk.eventbusexample.R;
import com.matsyuk.eventbusexample.ui.presenters.second.ISecondPresenter;

import javax.inject.Inject;

/**
 * Created by Евгений on 12.02.2017.
 */

public class SecondScreen extends AppCompatActivity implements ISecondView {

    @Inject
    ISecondPresenter secondPresenter;

    private TextView messageFromFirstTV;
    private EditText messageToFirstET;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // dagger init
        MyApplication.getInstance().getCommonComponent()
                .secondComponentBuilder().build()
                .inject(this);
        // ui init
        setContentView(R.layout.second);
        messageFromFirstTV = (TextView)findViewById(R.id.message);
        messageToFirstET = (EditText) findViewById(R.id.editText);
        sendButton = (Button) findViewById(R.id.send_button);
        // presenter
        secondPresenter.bindView(this);
        sendButton.setOnClickListener(v -> secondPresenter.sendMessageToFirst(messageToFirstET.getText().toString()));
    }

    @Override
    public void showMessageFromFirstScreen(@NonNull String message) {
        messageFromFirstTV.setText(message);
    }

    @Override
    public void goToFirstScreen() {
        finish();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        secondPresenter.unbindView();
    }

}