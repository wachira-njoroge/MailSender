package com.example.emailsender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.security.KeyStore;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText mail,subject,message;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mail = findViewById(R.id.email);
        subject = findViewById(R.id.subject);
        message = findViewById(R.id.message);
        send = findViewById(R.id.send);
        send.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        sendmail();
    }

    private void sendmail() {
        String recepientlist = mail.getText().toString();
        //use a regular expression to separate the email addresses if you`ve got several.
        String[] recepient = recepientlist.split(",");
        //get the subject from the subject EditText.
        String subjct = subject.getText().toString();
        //get the message.
        String msg = message.getText().toString();
        //
        //start an Intent to send the email.
        Intent i = new Intent(Intent.ACTION_SEND);
        i.putExtra(Intent.EXTRA_EMAIL,recepient);
        i.putExtra(Intent.EXTRA_SUBJECT,subjct);
        i.putExtra(Intent.EXTRA_TEXT,msg);

        i.setType("message/rfc822");
        startActivity(Intent.createChooser(i,"Choose email client"));
        //clear data in the edittexts.
        mail.getText().clear();
        subject.getText().clear();
        message.getText().clear();

    }
}
