package com.example.tacompanion.tacompanion.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tacompanion.tacompanion.R;
import com.example.tacompanion.tacompanion.model.User;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.et_username);
        password = (EditText) findViewById(R.id.et_password);
    }

    public void goToSignInActivity(View view) {
        Intent i = new Intent(this,SignInActivity.class);
        startActivity(i);
    }

    public void goToUserPageActivity(View view) {
        Intent i = new Intent(this, UserPageActivity.class);
        if(notifyValidation()==0)
            startActivity(i);
    }
    public int validateRegistration(){
        int err=-1;
        if(User.getCurrentUser()!=null)
            if(!username.getText().toString().equals(User.getInstance().getUsername())
                ||!password.getText().toString().equals(User.getInstance().getPassword()))
                err=1;
            else
                err=0;

        return err;
    }
    public  int notifyValidation(){
        int v= validateRegistration();
        String msg;
        switch (v){
            case 0:
                msg="Welcome "+User.getInstance().getName();
                break;
            case 1:
                msg="Ups! Are you sure you got your inputs correct?";
                break;
            default:
                msg="There's something wrong with your data, please try again.";
                break;

        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        return v;
    }
}
