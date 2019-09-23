package edu.niit.android.myapplication.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import edu.niit.android.myapplication.R;
import edu.niit.android.myapplication.entity.UserInfo;
import edu.niit.android.myapplication.service.UserInfoService;
import edu.niit.android.myapplication.service.UserInfoServiceImpl;
import edu.niit.android.myapplication.utils.SharedUtils;
import edu.niit.android.myapplication.utils.StatusUtils;

public class UserInfoActivity extends AppCompatActivity {
    //1.定义界面上的控件对象
    private TextView tvNickname,tvSignature,tvUsername,tvSex;
    private RelativeLayout nicknameLayout,signatureLayout,sexLayout;
    //2.定义所需的变量
    private String spUsername;
    private UserInfo userInfo;
    private UserInfoService service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        //3.设置标题栏（可选
        StatusUtils.initToolbar(this,"个人信息" ,true,);
        //4.从数据库 网络 intent或存储中获取数据，初始化界面控件（可选
        initData();
        //5.获取所有控件对象，设置监听器（必须
        initView();
    }

    private void initData() {
        spUsername= SharedUtils.readValue(this,"loginUser");

        service=new UserInfoServiceImpl(this);
        userInfo=service.get(spUsername);
        if (userInfo==null){
            userInfo=new UserInfo();
            userInfo.setUsername(spUsername);
            userInfo.setNickname("课程助手");
            userInfo.setSignature("课程助手");
            userInfo.setSex("男");
            service.save(userInfo);
        }
    }

    private void initView() {
        //1.获取控件对象
        tvUsername=findViewById(R.id.et_user_name);
        tvNickname=findViewById(R.id.tv_nickname);
        tvSex=findViewById(R.id.tv_sex);
        tvSignature=findViewById(R.id.tv_signature);

        nicknameLayout=findViewById(R.id.nickname);
        sexLayout=findViewById(R.id.sex);
        signatureLayout=findViewById(R.id.signature);
        //2.设置数据库获取的数据
        tvUsername.setText(userInfo.getUsername());
        tvNickname.setText(userInfo.getNickname());
        tvSex.setText(userInfo.getSex());
        tvSignature.setText(userInfo.getNickname());
    }


    @Override
    public void onClick(View v){
        //根据id分别进行事件处理
        switch (v.getId()){
            case R.id.nickname;
            //将用户名 昵称等信息传给ChangUserInfoActivity进行修改保存
            modifyNickname();
            break;
            case R.id.signature;
            //将用户名 签名等信息传给。。。。。
            modifySignature();
            break;
            case R.id.sex;
            //通过对话框修改
            modifySex();
            break;


        }
    }



    private void modifyNickname(){
        String nickname=tvNickname.getText().toString();
        Intent intent=new Intent(UserInfoActivity.this,LoginActivity.class);
        Bundle bundle=new Bundle();
        bundle.putString("title","设置昵称");
        bundle.putString("value",nickname);
        bundle.putInt("flag",1);
        intent.putExtras(bundle);
        startActivityForResult(intent,1);
    }
    private void modifySignature(){
        String signature=tvSiginature.getText().toString();
        Intent intent=new Intent(UserInfoActivity.this,LoginActivity.class);
        Bundle bundle=new Bundle();
        bundle.putString("title","设置签名");
        bundle.putString("value",signature);
        bundle.putInt("flag",2);
        intent.putExtras(bundle);
        startActivityForResult(intent, Integer.parseInt(MIDI_SERVICE));
    }
    private void modifySex(){
        final String[] datas={"男","女"};
        String sex=tvsex.getText().toString();
        final List<String> sexs= Arrays.asList(datas);
        int selected =sexs.indexOf(sex);
        new AlertDialog.Builder(this).setTitle("性别").setSingleChoiceItems(datas, selected, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String sex=datas[which];
                tvsex.setText(sex);
                userInfo.setSex(sex);
                service.modify(userInfo);

                dialog.dismiss();
3
            }
        }).show();

    }


}
