package com.example.tacompanion.tacompanion.activities;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tacompanion.tacompanion.R;
import com.example.tacompanion.tacompanion.model.User;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Pedro Lanzagorta M on 11/23/2016.
 */
public class SignInActivity extends AppCompatActivity {
    private static final int RESULT_LOAD_IMAGE = 1;
    private String picturePath;
    de.hdodenhof.circleimageview.CircleImageView circleImageView;
    EditText name,username,password,rptPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        circleImageView = (CircleImageView) findViewById(R.id.profile_image);
        name= (EditText) findViewById(R.id.et_name);
        username = (EditText) findViewById(R.id.et_username);
        password = (EditText) findViewById(R.id.et_password);
        rptPassword = (EditText) findViewById(R.id.et_rptPassword);
    }


    public void goToMainActivity(View view) {
        int v=notifyValidation();
        if( v==0)
            this.finish();
    }

    public void setProfilePicture(View view) {
        Intent i = new Intent(
                Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);
            cursor.close();

            // String picturePath contains the path of selected Image

            circleImageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
    }

    public int validateRegistration(){
        if(name.length()==0||username.length()==0)
            return 1;
        if(password.length()<6)
            return 2;
        if(!password.getText().toString().equals(rptPassword.getText().toString()))
            return 3;
        else {
            User.getInstance(name.getText().toString(), username.getText().toString(), password.getText().toString(),picturePath==null?"":picturePath);
            return 0;
        }



    }
    public  int notifyValidation(){
        int v= validateRegistration();
        String msg;
        switch (v){
            case 0:
                msg="Registration was successful";
                break;
            case 1:
                msg="Dont be shy! Write something.";
                break;
            case 2:
                msg="Passwords must be at least 6 characters long.";
                break;
            case 3:
                msg="Ops! Passwords don't match.";
                break;
            default:
                msg="There's something wrong with your data, please try again.";

        }
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
        return v;
    }
}
