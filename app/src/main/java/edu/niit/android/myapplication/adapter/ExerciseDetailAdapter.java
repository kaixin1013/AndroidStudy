package edu.niit.android.myapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.niit.android.myapplication.R;
import edu.niit.android.myapplication.entity.ExerciseDetail;

public class ExerciseDetailAdapter extends RecyclerView.Adapter<ExerciseDetailAdapter.ViewHolder>{
    private List<ExerciseDetail> details;
    private List<String> selextedPos;
    private OnSelectListener onSelectListener;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView subject,tvA,tvB,tvC,tvD;
        ImageView ivA,ivB,ivC,ivD;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            subject=itemView.findViewById(R.id.tv_subject);
            tvA=itemView.findViewById(R.id.tv_a);
            tvB=itemView.findViewById(R.id.tv_b);
            tvC=itemView.findViewById(R.id.tv_c);
            tvD=itemView.findViewById(R.id.tv_d);
            ivA=itemView.findViewById(R.id.iv_a);
            ivB=itemView.findViewById(R.id.iv_b);
            ivC=itemView.findViewById(R.id.iv_c);
            ivD=itemView.findViewById(R.id.iv_d);
        }
        public interface OnSeleceListener{
            void onSelectA(int position,ImageView ivA,ImageView ivB,ImageView ivC,ImageView ivD);
            void onSelectB(int position,ImageView ivA,ImageView ivB,ImageView ivC,ImageView ivD);
            void onSelectC(int position,ImageView ivA,ImageView ivB,ImageView ivC,ImageView ivD);
            void onSelectD(int position,ImageView ivA,ImageView ivB,ImageView ivC,ImageView ivD);
        }
        p
    }

}
