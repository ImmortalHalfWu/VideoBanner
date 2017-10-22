package com.immortal.half.wu.videobannerview.fragments;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.immortal.half.wu.videobannerview.R;
import com.immortal.half.wu.videobannerview.beans.interfaces.VideoModelInterface;
import com.immortal.half.wu.videobannerview.fragments.interfaces.VideoFragmentCallBack;
import com.immortal.half.wu.videobannerview.utils.Loging;

import java.io.File;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.VideoView;

import static io.vov.vitamio.MediaPlayer.MEDIA_INFO_DOWNLOAD_RATE_CHANGED;

public class VideoFragment2 extends Fragment implements MediaPlayer.OnPreparedListener,MediaPlayer.OnErrorListener,MediaPlayer.OnInfoListener,MediaPlayer.OnCompletionListener{
    private static int tag = 1;
    private int mIndex = tag++;
    private static final String ARG_PARAM1 = "param1";

    private VideoModelInterface mParam1;

    private VideoFragmentCallBack callBack = new VideoFragmentCallBack() {
        @Override
        public void over(@NonNull Fragment fragment) {

        }

        @Override
        public void erro(@NonNull Fragment fragment) {

        }
    };

    private VideoView videoView;

    private boolean isVisibleToUser;

    public VideoFragment2() {}

    public static VideoFragment2 newInstance(VideoModelInterface videoModelInterface) {
        VideoFragment2 fragment = new VideoFragment2();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, videoModelInterface);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() == null || getArguments().getParcelable(ARG_PARAM1) == null){
            throw new IllegalAccessError("VideoModelInterface == null");
        }
        mParam1 = getArguments().getParcelable(ARG_PARAM1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_video_fragment2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        videoView = view.findViewById(R.id.videoView);
        videoView.setOnInfoListener(this);
        videoView.setOnErrorListener(this);
        videoView.setOnCompletionListener(this);
        videoView.setOnPreparedListener(this);
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void onResume() {
        Loging.log(mIndex + " ____onResume: " +  "___videoView == null ? " + (videoView == null));
        if (isVisibleToUser && videoView != null){
            videoView.setVideoURI(getVideoUri(mParam1.getVideoUrl()));
            videoView.seekTo(mParam1.getCurrentPosition());
            videoView.start();
        }
//            videoView.start();
        super.onResume();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.isVisibleToUser = isVisibleToUser;
        Loging.log(mIndex + " __ visible = " + isVisibleToUser + "___videoView == null ? " + (videoView == null));
        if (videoView!=null){
////                Log.i(TAG, mIndex +" 最大进"+videoView.getDuration()+"__播放进度: "+videoView.getCurrentPosition());
////                Log.i(TAG, mIndex +" 最大进"+videoBean.getMaxDuration()+"__播放进度: "+videoBean.getCurrentPosition());
////                Log.i(TAG, mIndex + " isVisibleToUser ? " + isVisibleToUser + "___videoView.isValid() ? " + videoView.isValid());
            if (isVisibleToUser && videoView.isValid()){
                videoView.setVideoURI(getVideoUri(mParam1.getVideoUrl()));
                videoView.seekTo(mParam1.getCurrentPosition());
                videoView.start();
            }else {
                videoView.pause();
                videoView.stopPlayback();
            }
        }
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        mParam1.setCurrentPosition(0);
        callBack.over(this);
    }

    @Override
    public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
        callBack.erro(this);
        return true;
    }

    @Override
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i1) {
        if (i == MEDIA_INFO_DOWNLOAD_RATE_CHANGED)
            mParam1.setCurrentPosition(mediaPlayer.getCurrentPosition());
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        mParam1.setMaxDuration(mediaPlayer.getDuration());
    }


    /**
     * url转uri， 若本地已有缓存文件，则直接读取本地文件
     * @param videoUrl
     * @return
     */
    private Uri getVideoUri(@NonNull String videoUrl){
        Uri videoUri;
        String[] split = videoUrl.split(File.separator);
        File file = new File(mParam1.getVideoCacheDir() + split[split.length-1]);
        if (file.exists()){
            videoUri = Uri.parse(file.getAbsolutePath());
        }else {
            videoUri = Uri.parse("cache:" + mParam1.getVideoCacheDir() + split[split.length-1]+":" + videoUrl);
        }
        Loging.log("getVideoUri: " + videoUri.toString());
        return videoUri;
    }

    public VideoFragment2 registCallBack(@NonNull VideoFragmentCallBack callBack) {
        this.callBack = callBack;
        return this;
    }
}
