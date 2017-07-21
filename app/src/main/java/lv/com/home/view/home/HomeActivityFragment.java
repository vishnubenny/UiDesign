package lv.com.home.view.home;

import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import lv.com.home.R;
import lv.com.home.model.adapter.SlidingUpdatesAdapter;
import lv.com.home.model.adapter.ViewPagerAdapter;
import me.relex.circleindicator.CircleIndicator;

public class HomeActivityFragment extends Fragment {
    private static ViewPager mPager;
    private static int currentPage = 0;

    private ViewPager viewPager;
    private TabLayout tabLayout;

    private static final Integer[] XMEN = {R.drawable.chainsmoker, R.drawable.chainsmoker, R.drawable.chainsmoker, R.drawable.chainsmoker, R.drawable.chainsmoker};
    private final ArrayList<String> mUpdatesSubTitleList = new ArrayList<>();
    private ArrayList<String> mUpdatesDataList = new ArrayList<>();
    private ArrayList<Integer> mUpdatesImageList = new ArrayList<>();

    public HomeActivityFragment() {
        for (Integer aXMEN : XMEN) {
            mUpdatesImageList.add(aXMEN);
            mUpdatesDataList.add("chain smoker new album 2016");
            mUpdatesSubTitleList.add("Ft. rihana and user");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        cacheWidget(rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View rootView, @Nullable Bundle savedInstanceState) {
        handleWidget(rootView);
    }

    private void handleWidget(View rootView) {
        mPager.setAdapter(new SlidingUpdatesAdapter(getContext(), mUpdatesImageList, mUpdatesDataList, mUpdatesSubTitleList));
        CircleIndicator indicator = (CircleIndicator) rootView.findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == XMEN.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);

        setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFrag(new VideosHomeTabFragment(), "VIDEOS");
        adapter.addFrag(new ImagesHomeTabFragment(), "IMAGES");
        adapter.addFrag(new MilestoneHomeTabFragment(), "MILESTONE");
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private void setupTabIcons() {
        TextView tabOne = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab, null);
        tabOne.setText("VIDEOS");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab_video, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab, null);
        tabTwo.setText("IMAGES");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab_image, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab, null);
        tabThree.setText("MILESTONE");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab_milestone, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);
    }

    private void cacheWidget(View rootView) {
        mPager = (ViewPager) rootView.findViewById(R.id.pager);

        viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
    }
}
