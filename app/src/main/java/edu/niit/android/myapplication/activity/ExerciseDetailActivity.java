package edu.niit.android.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import edu.niit.android.myapplication.R;
import edu.niit.android.myapplication.entity.ExerciseDetail;
import edu.niit.android.myapplication.utils.IOUtils;
import edu.niit.android.myapplication.utils.StatusUtils;

public class ExerciseDetailActivity extends AppCompatActivity {
    private int id;
    private String title;
    private List<ExerciseDetail> details;
    private RecyclerView lvDetails;
    private ExerciseDetailAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_detail);
        initData();
        initView();
        //自定义标题栏
        StatusUtils.initToolbar(this,title,true,false);
    }

    private void initData(){
        id=getIntent().getIntExtra("id",0);
        title =getIntent().getStringExtra("title");

        details = new ArrayList<>();
        try {
            InputStream is = getResources().getAssets().open("chapter" + id + ".xml");
            details=IOUtils.getXmlContents(is);
            is.close();
        }

    }
    private void initView() {
        lvDetails=findViewById(R.id.lv_details);
        LinearLayoutManager manager = new LinearLayoutManager(this)

    }
}
