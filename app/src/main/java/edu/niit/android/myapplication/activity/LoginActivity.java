package edu.niit.android.myapplication.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.niit.android.myapplication.R;

public class LoginActivity extends AppCompatActivity {
    private EditText userName,password;
    private Button btnLogin;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        // initToolbar();
        initData();
    }

    private void initData() {
        String username=readPref();
        if (!TextUtils.isEmpty(username)){
            userName.setText(username);
        }
    }

    private String readPref() {
        SharedPreferences sp=getSharedPreferences("userInfo",MODE_PRIVATE);
        return sp.getString("username","");
    }

    private void initView() {
        userName=findViewById(R.id.et_user_name);
        password=findViewById(R.id.et_psw);

        TextView tvRegister=findViewById(R.id.tv_register);
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void saveLoginStatus(String username,boolean isLogin){
        getSharedPreferences("userInfo",MODE_PRIVATE)
                .edit()
                .putString("LoginUser",username)
                .putBoolean("isLogin",isLogin)
                .apply();
    }
    private String readPwd(String username){
        SharedPreferences sp=getSharedPreferences("userInfo",MODE_PRIVATE);
        return sp.getString(username,"");
    }
@Override
    protected  void  onActivityResult(int requestCode,
                                      int resultCode,
                                      @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==1&& requestCode==RESULT_OK&& data!=null){
            String username=data.getStringExtra("username");
        if (!TextUtils.isEmpty(username)){
                userName.setText(username);
                userName.setSelection(username.length());

            }
        }
}
//    private void initToolbar() {
//        Toolbar toolbar=findViewById(R.id.title_toolbar);
//        toolbar.setTitle("登录");
//        setSupportActionBar(toolbar);
//
//        ActionBar actionBar=getSupportActionBar();
//        if (actionBar!=null){
//            actionBar.setDisplayHomeAsUpEnabled(true);
//        }
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                                        LoginActivity.this.finish();
//            }
//        });
    //   }
}