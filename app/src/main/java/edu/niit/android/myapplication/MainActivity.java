package edu.niit.android.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.Space;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTitles();
        initFragment();
    }

    private void initTitles() {
    }

    private void initFragment() {
        //1.创建Fragment的列表
        fragments=new SparseArray<>();
        fragments.put(R.id.btn_my,MySettingFragment.newInstance());
        //2.加载默认的fragment
        replaceFragment(fragments.get(R.id.btn_my));
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction ft=manager.beginTransaction();
        ft.replace(R.id.main_body,fragment);
        ft.commit();
    }

    private SparseArray<Fragment> fragments;

}
