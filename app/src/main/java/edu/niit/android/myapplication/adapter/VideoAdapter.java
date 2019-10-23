package edu.niit.android.myapplication.adapter;

import android.graphics.Color;
import android.provider.MediaStore;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.niit.android.myapplication.R;


public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {
    private List<MediaStore.Video> videos;

    private int selected;
    private OnItemClickListener itemClickListener;

    public VideoAdapter(List<MediaStore.Video> videos) {
        this.videos = videos;
        this.selected = -1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        MediaStore.Video video = videos.get(position);
        holder.ivIcon.setImageResource(R.mipmap.ic_play_record);
        holder.tvTitle.setText(video.getVideoTitle());

        // 改变选中项的图标和文本颜色
        if(selected == position) {
            holder.ivIcon.setImageResource(R.mipmap.ic_video_play);
            holder.tvTitle.setTextColor(Color.parseColor("#009958"));
        } else {
            holder.ivIcon.setImageResource(R.mipmap.ic_play_record);
            holder.tvTitle.setTextColor(Color.parseColor("#333333"));
        }

        // 设置选项监听
        if (itemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClick(holder.itemView, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView ivIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            ivIcon = itemView.findViewById(R.id.iv_play);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}