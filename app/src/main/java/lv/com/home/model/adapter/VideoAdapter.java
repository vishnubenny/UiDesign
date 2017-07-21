package lv.com.home.model.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import lv.com.home.R;
import lv.com.home.model.pojo.VideoDataPojo;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VHolder> {
    private final ArrayList<VideoDataPojo> mVideoDataPojoList;
    private final Activity mActivity;

    public VideoAdapter(ArrayList<VideoDataPojo> mVideoDataPojoList, Activity activity) {
        this.mVideoDataPojoList = mVideoDataPojoList;
        this.mActivity = activity;
    }

    @Override
    public VideoAdapter.VHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);
        return new VideoAdapter.VHolder(rootView);
    }

    @Override
    public void onBindViewHolder(VideoAdapter.VHolder holder, int position) {
        VideoDataPojo videoDataPojo = mVideoDataPojoList.get(position);
        holder.mVideoTitleTextView.setText(videoDataPojo.getTitle());
        holder.mVideoTimeTextView.setText(videoDataPojo.getTime());
        holder.mVideoContentTextView.setText(videoDataPojo.getContent());
        Glide.with(mActivity).load(videoDataPojo.getImageUrl()).into(holder.mVideoThumbImageView);
    }

    @Override
    public int getItemCount() {
        Log.e("test", String.valueOf(mVideoDataPojoList.size()));
        return mVideoDataPojoList.size();
    }

    class VHolder extends RecyclerView.ViewHolder {
        private ImageView mVideoThumbImageView;
        private TextView mVideoTitleTextView;
        private TextView mVideoTimeTextView;
        private TextView mVideoContentTextView;


        VHolder(View itemView) {
            super(itemView);

            mVideoThumbImageView = (ImageView) itemView.findViewById(R.id.video_thumb_image_view);
            mVideoTitleTextView = (TextView) itemView.findViewById(R.id.video_title_text_view);
            mVideoTimeTextView = (TextView) itemView.findViewById(R.id.video_time_text_view);
            mVideoContentTextView = (TextView) itemView.findViewById(R.id.video_content_text_view);
        }
    }
}
