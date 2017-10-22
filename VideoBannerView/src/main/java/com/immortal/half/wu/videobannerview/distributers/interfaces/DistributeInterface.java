package com.immortal.half.wu.videobannerview.distributers.interfaces;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.immortal.half.wu.videobannerview.beans.interfaces.ModelInterface;

/**
 * Do : model to fragment distribute
 * Created : immortalHalfWu
 * Time : 2017/10/21  10:24
 */

public interface DistributeInterface<T,M> {

    /**
     * model to view
     * @param modelInterface model
     * @return view
     */
    @NonNull Fragment toFragment(ModelInterface<T,M> modelInterface);

    /**
     * view to model
     * @param fragment  view
     * @return model
     */
    @Nullable T toType(Fragment fragment);

}
