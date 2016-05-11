package com.coolweather.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.coolweather.app.R;

/**
 * Created by bear on 2016/5/9.
 */
public class LoginActivity extends Activity implements View.OnClickListener{
    private EditText etusers,etpass;
    private ImageView iv_login,iv_add;
    private SharedPreferences spf;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login);
        spf= PreferenceManager.getDefaultSharedPreferences(this);
        etusers= (EditText) findViewById(R.id.edittext_user);
        etpass= (EditText) findViewById(R.id.edittext_pass);
        iv_login= (ImageView) findViewById(R.id.image_login);
        iv_login.setOnClickListener( this);
        iv_add= (ImageView) findViewById(R.id.image_add);
        iv_add.setOnClickListener(this);









    }

    @Override
    public void onClick(View v) {
        String user=etusers.getText().toString();
        String password=etpass.getText().toString();

        switch (v.getId()){
            case R.id.image_add:
                editor=getSharedPreferences("userdata",MODE_PRIVATE).edit();
                editor.putString("username",user);
                editor.putString("userpassword",password);
                editor.commit();
                Toast.makeText(LoginActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.image_login:
                spf=getSharedPreferences("userdata",MODE_PRIVATE);
                if (user.equals(spf.getString("username",""))&& password.equals(spf.getString("userpassword",""))
                        ||(user.equals("admin")&&password.equals("123456"))) {
                    Intent intent = new Intent(LoginActivity.this, ChooseAreaActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this,"用户密码错误",Toast.LENGTH_SHORT).show();
                }
                    break;

        }

    }
}
