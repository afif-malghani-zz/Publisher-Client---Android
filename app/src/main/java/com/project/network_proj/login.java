package com.project.network_proj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class login extends AppCompatActivity {

    public send_data s;
    EditText user, passwrd, userid;
    Switch new_usr;
    boolean  whatever;
    String usr,pas,uid,chick;
    Button log;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = (EditText) findViewById(R.id.user);
        passwrd = (EditText) findViewById(R.id.pass);
        userid = (EditText) findViewById(R.id.usr_ID);
        log = findViewById(R.id.login_bn);
        new_usr = (Switch) findViewById(R.id.new_usr);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                usr = user.getText().toString();
                pas =passwrd.getText().toString();
                uid = userid.getText().toString();
                whatever = new_usr.isChecked();
                chick = Boolean.toString(whatever);


                if(usr.length()>10)
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Username Exceeds the limit";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else while(usr.length()<10)
                {
                    usr=usr.concat(" ");
                    System.out.println(usr);
                }
                System.out.println(usr);


                if(pas.length()>10)
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Password Limit Exceeded";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else while(pas.length()<10)
                {
                    pas=pas.concat(" ");
                }
                if(uid.length()>1)
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Enter smaller password";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else {
                    uid = uid.concat(usr);
                    uid = uid.concat(pas);
                    if (chick == "false")
                        uid = uid.concat("1");
                    else
                        uid = uid.concat("0");
                }

                s = new send_data();
                System.out.println(uid);
                s.execute(uid);
                Intent pub_pge = new Intent(login.this,pub.class);
                pub_pge.putExtra("socket", uid);
                startActivity(pub_pge);
                 // wait for reply;

                // if reply "OK"
                // send_data s;
                // s.execute(pas)
                /*
                Intent wlcm_pge = new Intent(login.this,MainActivity.class);
                startActivity(wlcm_pge);
                */
                // else toast failed
            }
        });

    }
}
