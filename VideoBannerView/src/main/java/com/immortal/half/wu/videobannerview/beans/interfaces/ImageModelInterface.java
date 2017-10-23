package com.immortal.half.wu.videobannerview.beans.interfaces;

import android.os.Parcelable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

/**
 * Do :
 * Created : immortalHalfWu
 * Time : 2017/10/21  13:53
 */

public interface ImageModelInterface extends Parcelable {
    @NonNull String getImageUrl();
    @DrawableRes int getImageId();
    long getPauseTime();
}
