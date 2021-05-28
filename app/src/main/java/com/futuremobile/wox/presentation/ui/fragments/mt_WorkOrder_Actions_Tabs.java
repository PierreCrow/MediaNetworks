package com.futuremobile.wox.presentation.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.futuremobile.wox.R;
import com.futuremobile.wox.domain.model.LineaTiempo;
import com.futuremobile.wox.presentation.presenter.LineaTiempoPresenter;
import com.futuremobile.wox.presentation.view.LineaTiempoView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class mt_WorkOrder_Actions_Tabs extends BaseFragment implements LineaTiempoView {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 3;
    public static final int TAB_ANTES = 0, TAB_DURANTE = 1, TAB_DESPUES = 2;
    LineaTiempoPresenter lineaTiempoPresenter;
    public static ArrayList<LineaTiempo> lineaTiempos;
    View x;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        x = inflater.inflate(R.layout.mt_workorder_actions_tabs, null);
        loadPresenter();
        setFieldViewPagerTabs();
        return x;
    }

    private void initUI(View x) {
        viewPager = (ViewPager) x.findViewById(R.id.viewpager_WorkOrder_Actions);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs_WorkOrder_Actions);
    }


    void loadPresenter() {
        lineaTiempoPresenter = new LineaTiempoPresenter();
        lineaTiempoPresenter.addView(this);
        lineaTiempoPresenter.getLineaTiempos();
    }



    private void setFieldViewPagerTabs() {
        //tut1.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.shapeactivo) );
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case TAB_ANTES:
                        break;
                    case TAB_DURANTE:
                        break;
                    case TAB_DESPUES:
                        break;
                    default:
                        // fab.hide();
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void lineaTiempoListSuccess(ArrayList<LineaTiempo> lineaTiempos) {

     //   this.lineaTiempos=lineaTiempos;


        this.lineaTiempos = new ArrayList<>();

        for (LineaTiempo lineaTiempo : lineaTiempos) {
            if (lineaTiempo.getOrden_id() == HomeFragment.ID_WORK_ORDER) {
                this.lineaTiempos.add(lineaTiempo);
            }
        }

        initUI(x);

    }

    @Override
    public void lineaTiemposCreateSuccess(boolean success) {

    }

    @Override
    public void lineaTiemposIniAccionSuccess(boolean success) {

    }

    @Override
    public void lineaTiemposFinAccionSuccess(boolean success) {

    }

    @Override
    public void lineaTiempoUpdateSuccess(LineaTiempo lineaTiempo) {

    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }


    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case TAB_ANTES:
                    return new mt_WorkOder_Actions_Antes_Tab();
                case TAB_DURANTE:
                    return new mt_WorkOder_Actions_Durante_Tab();
                case TAB_DESPUES:
                    return new mt_WorkOder_Actions_Despues_Tab();
            }
            return null;
        }

        @Override
        public int getCount() {
            return int_items;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case TAB_ANTES:
                    return "Antes";
                case TAB_DURANTE:
                    return "Durante";
                case TAB_DESPUES:
                    return "Despues";
            }
            return null;
        }
    }


}
