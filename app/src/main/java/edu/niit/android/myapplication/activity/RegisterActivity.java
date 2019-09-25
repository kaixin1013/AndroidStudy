package edu.niit.android.myapplication.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import edu.niit.android.myapplication.R;
import edu.niit.android.myapplication.utils.MD5Utils;

public class RegisterActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText etUsername, etPaaword, etPwdAgain;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //1. 获取界面上的控件
        //initToolBar();
        initView();
        //2. button的点击事件的监听
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //3. 处理点击事件
                //3.1 获取控件的值
                String username = etUsername.getText().toString();
                String password = etPaaword.getText().toString();
                String passwordAgain = etPwdAgain.getText().toString();
                //3.2 检查控件的有效性
                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(RegisterActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(password) || TextUtils.isEmpty(passwordAgain)) {
                    Toast.makeText(RegisterActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(passwordAgain)) {
                    Toast.makeText(RegisterActivity.this, "两次密码必须一致", Toast.LENGTH_SHORT).show();
                } else {
                    //3.3 将注册信息存储
                    savePref(username, MD5Utils.md5(password));
                    //3.4 跳转登录页面
                    // 给bnt1添加点击响应事件
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    intent.putExtra("username", username);
                    //启动
                    startActivity(intent);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });
    }

//    private void initToolBar() {
//        toolbar = findViewById(R.id.title_toolbar);
//        toolbar.setTitle("注册");
//        setSupportActionBar(toolbar);
//
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setDisplayHomeAsUpEnabled(true);//设置返回键
////           actionBar.setHomeButtonEnabled(true);//设置是否是首页
//        }
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                RegisterActivity.this.finish();
//            }
//        });
//    }

    private void savePref(String username, String password) {
        SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.apply();
    }

    private void initView() {
        etUsername = findViewById(R.id.et_user_name);
        etPaaword = findViewById(R.id.et_psw);
        etPwdAgain = findViewById(R.id.et_pwd_again);
        btnRegister = findViewById(R.id.btn_register);
    }
    private boolean isExist(String username){

        SharedPreferences sp=getSharedPreferences("userInfo",MODE_PRIVATE);
        String pwd=sp.getString(username,"");
        return !TextUtils.isEmpty(pwd);
    }
}