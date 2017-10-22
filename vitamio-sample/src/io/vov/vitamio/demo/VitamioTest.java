package io.vov.vitamio.demo;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.VideoView;

public class VitamioTest extends Activity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVideoPlay();
        setContentView(R.layout.activity_vitamio_test);

        FileUtil2.instance(getApplicationContext());
        initView();
        
    }

    private void initVideoPlay() {
        if (!LibsChecker.checkVitamioLibs(this)){
            show("初始化失败");
        }
    }

    private void initView() {
        videoView = (VideoView) findViewById(R.id.videoView);
        videoView.setVideoQuality(MediaPlayer.VIDEOQUALITY_HIGH);
        videoView.setBufferSize(1020*10);
        videoView.requestFocus();
//        videoView.setVideoLayout(VideoView.VIDEO_LAYOUT_STRETCH,0.0f);
        initListener();

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPlay();
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pausePlay();
            }

        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                videoView.setVideoPath(VideoURL.videoUrlString);
                File file = new File(FileUtil2.getAppVidioFilePath() + "xinwen.mp4");
                if (file.exists()){
                    videoView.setVideoPath(file.getAbsolutePath());
                }else {
                    Uri parse = Uri.parse("cache:" + FileUtil2.getAppVidioFilePath() + "xinwen.mp4:" + VideoURL.VideoUri);
                    loging(parse.toString());
                    videoView.setVideoURI(parse);
                }

            }
        });

        findViewById(R.id.button9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoView.stopPlayback();
            }
        });

    }

    private void initListener() {
        //缓冲进度监听
        videoView.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(MediaPlayer mp, int percent) {
                //percent 进度， 百分比
//                loging(percent + "%");
            }
        });
        //结束监听
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
//                show("播放完成");
            }
        });
        //错误监听
        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
//                show("erro监听" + extra);
                return true;//返回意味着是否消费掉此次事件
            }
        });
        //缓冲详细信息，设置此接口，则设置Video path后不会自动播放，反之亦然
        videoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {
//                switch (what){
//                    case MediaPlayer.MEDIA_INFO_BUFFERING_START://开始缓冲
//                        loging("开始缓冲：extra = " + extra);
//                        break;
//                    case MediaPlayer.MEDIA_INFO_BUFFERING_END://缓冲完成
//                        loging("缓冲完成：extra = " + extra);
//                        break;
//                    case MediaPlayer.MEDIA_INFO_DOWNLOAD_RATE_CHANGED://缓冲中，extra为网速kb
//                        loging("缓冲ing：extra = " + extra);
//                        break;
//                }
                return false;
            }
        });
        //视频预处理完成，可获得视频宽高
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                loging(mp.getVideoHeight() + "_w_" + mp.getVideoWidth());
            }
        });
//        videoView.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() {
//            @Override
//            public void onSeekComplete(MediaPlayer mp) {
//
//            }
//        });
//        videoView.setOnTimedTextListener(new MediaPlayer.OnTimedTextListener() {
//            @Override
//            public void onTimedText(String text) {
//                loging(text);
//            }
//
//            @Override
//            public void onTimedTextUpdate(byte[] pixels, int width, int height) {
//                loging(pixels.length+"__w"+width+"__h"+height);
//            }
//        });
    }

    private void pausePlay() {
        if (!videoViewIsValid()){
            return;
        }
        if (!videoView.isPlaying()){
            show("is pause");
            return;
        }
        show("pause");
        videoView.pause();
    }

    private void startPlay() {

        if (!videoViewIsValid()){
            return;
        }

        if (videoView.isPlaying()){
            show("is playing");
            return;
        }
        show("startPlay");

        videoView.start();
    }

    private boolean videoViewIsValid(){
        if (!videoView.isValid()){
            show("videoView.isValid false");
        }
        return videoView.isValid();
    }


    private static final String TAG = "123VitamioTest";
    private void show(String value){
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
        Log.i(TAG, "show: " + value);
    }

    private void loging(String value){
        Log.i(TAG,  value);
    }

}
