package com.example.classdifficultyfrontend;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import class_list.classlistFragment;

public class TabsAdapter extends FragmentStateAdapter {

    public TabsAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new classlistFragment();
       // if (position == 0) return new classlistFragment();
        //else if (position == 1) return new Favorites();
        //else return new SettingsFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
