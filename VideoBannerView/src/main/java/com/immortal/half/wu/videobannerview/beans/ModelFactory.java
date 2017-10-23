package com.immortal.half.wu.videobannerview.beans;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.immortal.half.wu.videobannerview.beans.interfaces.ImageModelInterface;
import com.immortal.half.wu.videobannerview.beans.interfaces.ModelFactoryInterface;
import com.immortal.half.wu.videobannerview.beans.interfaces.VideoModelInterface;

/**
 * Do :
 * Created : immortalHalfWu
 * Time : 2017/10/21  14:58
 */

public class ModelFactory implements ModelFactoryInterface{

    private ModelFactory() {
    }

    private static ModelFactory modelFactory;

    public static ModelFactory instance(){
        return modelFactory == null ? modelFactory = new ModelFactory() : modelFactory;
    }

    @NonNull
    @Override
    public VideoModelInterface createVideoModel(@NonNull String videoCacheDir, @NonNull String videoUrl, @Nullable String videoName) {
        if (TextUtils.isEmpty(videoName)){
            return new VideoBean(videoUrl,videoCacheDir);
        }
        return new VideoBean(videoUrl,videoName,videoCacheDir);
    }

    @NonNull
    @Override
    public ImageModelInterface createImageModel(@NonNull String imageUrl,long pauseTime) {
        return new ImageBean(imageUrl,pauseTime);
    }

    @NonNull
    @Override
    public ImageModelInterface createImageModel(@DrawableRes int imageId,long pauseTime) {
        return new ImageBean(imageId,pauseTime);
    }
}
