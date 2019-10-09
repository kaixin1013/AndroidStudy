package edu.niit.android.myapplication.adapter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


import java.util.ArrayList;
import java.util.List;

import edu.niit.android.myapplication.entity.AdImage;
import edu.niit.android.myapplication.fragment.AdBannerFragment;


// FragmentStatePagerAdapter：销毁不需要的fragment
// FragmentPagerAdapter：仅销毁fragment视图，不销毁fragment实例
public class AdBannerAdapter extends FragmentStatePagerAdapter {
    private List<AdImage> adImages;


    public AdBannerAdapter(FragmentManager fm) {
        this(fm, null);
        this.adImages = new ArrayList<>();
    }

    public AdBannerAdapter(FragmentManager fm, List<AdImage> adImages) {
        super(fm);
        this.adImages = adImages;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Bundle args = new Bundle();
        if (adImages.size() > 0) {
            args.putString("ad", adImages.get(position % adImages.size()).getImg());
        }
        return AdBannerFragment.newInstance(args);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    // 防止刷新时显示缓存数据
    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    /**
     * 返回数据集的真实容量大小
     */
    public int getSize() {
        return adImages.size();
    }
}