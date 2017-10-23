package com.immortal.half.wu.videobannerview.fragments.interfaces;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

/**
 * Do :
 * Created : immortalHalfWu
 * Time : 2017/10/21  15:35
 */

public interface FragmentCallBack {

    void over(@NonNull Fragment fragment);
    void erro(@NonNull Fragment fragment);

}
