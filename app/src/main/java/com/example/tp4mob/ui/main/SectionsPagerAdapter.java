package com.example.tp4mob.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.Locale;

import com.example.tp4mob.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    //@StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return SeasonFragment.newInstance(0, mContext.getString(R.string.titre1));
            case 1:
                return SeasonFragment.newInstance(1, mContext.getString(R.string.titre2));
            case 2:
                return SeasonFragment.newInstance(2, mContext.getString(R.string.titre3));
            case 3:
                return SeasonFragment.newInstance(3, mContext.getString(R.string.titre4));
        }
        return null;
        //     return PlaceholderFragment.newInstance(position + 1);
    }



    public static int getImage(String s){
        if(s.equals("hiver"))     return R.drawable.hiver;
        if(s.equals("printemps")) return R.drawable.printemps;
        if(s.equals("été"))       return R.drawable.ete;
        if(s.equals("automne"))   return R.drawable.automne;
        return 0;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        switch (position) {
            case 0:
                return mContext.getString(R.string.titre1).toUpperCase(l);
            case 1:
                return mContext.getString(R.string.titre2).toUpperCase(l);
            case 2:
                return mContext.getString(R.string.titre3).toUpperCase(l);
            case 3:
                return mContext.getString(R.string.titre4).toUpperCase(l);
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}