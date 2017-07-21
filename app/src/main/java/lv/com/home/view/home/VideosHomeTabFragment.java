package lv.com.home.view.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import lv.com.home.R;
import lv.com.home.model.adapter.VideoAdapter;
import lv.com.home.model.pojo.VideoDataPojo;


public class VideosHomeTabFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private ArrayList<VideoDataPojo> mVideoDataPojoList;
    private VideoAdapter mVideoAdapter;
    private LinearLayoutManager mLayoutManager;

    private ArrayList<VideoDataPojo> getSampleVideoDataPojoList() {
        //Load from url or from local storage

        ArrayList<VideoDataPojo> videoDataPojoArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            VideoDataPojo videoDataPojo = new VideoDataPojo();
            videoDataPojo.setContent(getActivity().getString(R.string.string_lorem_ipsum));
            videoDataPojo.setImageUrl(getActivity().getString(R.string.string_image_url));
            videoDataPojo.setTime("18 hours ago");
            videoDataPojo.setTitle("The Heart Wants What It Wants Selena Gomez");
            videoDataPojoArrayList.add(videoDataPojo);
        }
        return videoDataPojoArrayList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_one, container, false);
        cacheWidget(rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        handleWidget();
    }

    private void handleWidget() {
        mVideoAdapter = new VideoAdapter(mVideoDataPojoList, getActivity());
        mRecyclerView.setAdapter(mVideoAdapter);
    }

    private void cacheWidget(View rootView) {
        mVideoDataPojoList = getSampleVideoDataPojoList();

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

}
