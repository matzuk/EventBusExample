package com.matsyuk.eventbusexample.ui.view.first;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.matsyuk.eventbusexample.MyApplication;
import com.matsyuk.eventbusexample.R;
import com.matsyuk.eventbusexample.ui.presenters.first.IFirstPresenter;
import com.matsyuk.eventbusexample.ui.view.second.SecondScreen;

import javax.inject.Inject;

public class FirstScreen extends AppCompatActivity implements IFirstView {

    @Inject
    IFirstPresenter firstPresenter;

    private TextView messageFromSecondTV;
    private EditText messageToSecondET;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // dagger init
        MyApplication.getInstance().getCommonComponent()
                .firstComponentBuilder().build()
                .inject(this);
        // ui init
        setContentView(R.layout.first);
        messageFromSecondTV = (TextView)findViewById(R.id.message);
        messageToSecondET = (EditText) findViewById(R.id.editText);
        sendButton = (Button) findViewById(R.id.send_button);
        // presenter
        firstPresenter.bindView(this);
        sendButton.setOnClickListener(v -> firstPresenter.sendMessageToSecond(messageToSecondET.getText().toString()));
    }

    @Override
    public void showMessageFromSecondScreen(@NonNull String message) {
        messageFromSecondTV.setText(message);
    }

    @Override
    public void goToSecondScreen() {
        startActivity(new Intent(FirstScreen.this, SecondScreen.class));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        firstPresenter.unbindView();
    }

}
