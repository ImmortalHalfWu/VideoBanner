package com.immortal.half.wu.videobannerview.beans.interfaces;

import android.os.Parcelable;

/**
 * Do :
 * Created : immortalHalfWu
 * Time : 2017/10/21  13:52
 */

public interface VideoModelInterface extends Parcelable {

    long getCurrentPosition();
    void setCurrentPosition(long currentPosition);
    long getMaxDuration();
    void setMaxDuration(long currentPosition);
    String getVideoUrl();
    String getVideoName();
    String getVideoCacheDir();

}
