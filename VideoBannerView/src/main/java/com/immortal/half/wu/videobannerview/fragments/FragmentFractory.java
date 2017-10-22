package com.immortal.half.wu.videobannerview.fragments;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.immortal.half.wu.videobannerview.beans.interfaces.ImageModelInterface;
import com.immortal.half.wu.videobannerview.beans.interfaces.VideoModelInterface;

/**
 * Do :
 * Created : immortalHalfWu
 * Time : 2017/10/21  13:41
 */

public class FragmentFractory {

    private FragmentFractory() {}

    private static volatile FragmentFractory instans;

    public static FragmentFractory instans(){
        return instans == null ? instans = new FragmentFractory() : instans;
    }

    public Fragment createVideoFragment(@NonNull VideoModelInterface videoModelInterface){
        return VideoFragment2.newInstance(videoModelInterface);
    }

    public Fragment createImageFragment(@NonNull ImageModelInterface imageModelInterface){
        return ImageFragment.newInstance(imageModelInterface);
    }

}
