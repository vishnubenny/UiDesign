package lv.com.home.model.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import lv.com.home.R;

public class SlidingUpdatesAdapter extends PagerAdapter {
    private final ArrayList<String> mUpdateTitleList;
    private final ArrayList<String> mUpdatesSubTitleList;
    private ArrayList<Integer> images;
    private LayoutInflater inflater;
    private Context context;

    public SlidingUpdatesAdapter(Context context, ArrayList<Integer> images, ArrayList<String> updateTitleList,
                                 ArrayList<String> updatesSubTitleList) {
        this.context = context;
        this.images = images;
        this.mUpdateTitleList = updateTitleList;
        this.mUpdatesSubTitleList = updatesSubTitleList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View myImageLayout = inflater.inflate(R.layout.slide, view, false);
        ImageView myImage = (ImageView) myImageLayout.findViewById(R.id.image);
        TextView updateTitleTextView = (TextView) myImageLayout.findViewById(R.id.update_data_title_text_view);
        TextView updateSubTitleTextView = (TextView) myImageLayout.findViewById(R.id.update_data_sub_title_text_view);
        myImage.setImageResource(images.get(position));
        updateTitleTextView.setText(mUpdateTitleList.get(position));
        updateSubTitleTextView.setText(mUpdatesSubTitleList.get(position));
        view.addView(myImageLayout, 0);
        return myImageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}
