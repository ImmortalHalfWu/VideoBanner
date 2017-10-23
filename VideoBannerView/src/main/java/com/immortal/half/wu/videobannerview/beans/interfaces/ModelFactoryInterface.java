package com.immortal.half.wu.videobannerview.beans.interfaces;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Do :
 * Created : immortalHalfWu
 * Time : 2017/10/21  14:15
 */
public interface ModelFactoryInterface {

    @NonNull VideoModelInterface createVideoModel(@NonNull String VideoCacheDir,@NonNull String videoUrl, @Nullable String videoName);
    @NonNull ImageModelInterface createImageModel(@NonNull String imageUrl,long pauseTime);
    @NonNull ImageModelInterface createImageModel(@DrawableRes int imageId,long pauseTime);

}
