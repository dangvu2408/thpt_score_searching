package com.example.tracuudiemthi.tracuu.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.tracuudiemthi.tracuu.Fragment.ThongKeFrag;
import com.example.tracuudiemthi.tracuu.Fragment.TraCuuFrag;

public class TabLayoutAdapter extends FragmentStatePagerAdapter {
    public TabLayoutAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TraCuuFrag();
            case 1:
                return new ThongKeFrag();
            default:
                return new TraCuuFrag();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

}
