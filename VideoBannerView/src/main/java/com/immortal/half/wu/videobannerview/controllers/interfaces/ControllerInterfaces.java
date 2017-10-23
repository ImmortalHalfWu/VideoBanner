package com.immortal.half.wu.videobannerview.controllers.interfaces;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import java.util.List;

/**
 * Do :
 * Created : immortalHalfWu
 * Time : 2017/10/21  15:32
 */

public interface ControllerInterfaces {

    ControllerInterfaces registVideoBanner(@NonNull String videoUrl,@NonNull String videoName);
    ControllerInterfaces registImageBanner(@NonNull String imageUrl,long pauseTime);
    ControllerInterfaces registImageBanner(@DrawableRes int imageId,long pauseTime);
    ControllerInterfaces registCustomBanner(@NonNull Fragment fragment);
    List<Fragment> getBannerFragments();
    ControllerInterfaces clearBanner();
    ControllerInterfaces setCacheDir(@NonNull String dirPath);
    ControllerInterfaces setChangePageAnimotion(boolean hasAnimotion);
    ControllerInterfaces setChangePageOnUser(boolean hasUser);
    ControllerInterfaces notifyDataSetChanged();
    ControllerInterfaces start();
    void clearCacheVideo();
    long getCacheVideoSize();

}
