package com.immortal.half.wu.videobannerview.beans;

import android.support.annotation.NonNull;

import com.immortal.half.wu.videobannerview.beans.interfaces.ModelInterface;
import com.immortal.half.wu.videobannerview.enums.BannerType;

/**
 * Do : baseBean，只为解耦
 * Created : immortalHalfWu
 * Time : 2017/10/21  10:30
 */

public abstract class BaseBean<M> implements ModelInterface<BannerType,M> {

    private final BannerType type;

    BaseBean(@NonNull BannerType type) {
        this.type = type;
    }

    @NonNull
    @Override
    public BannerType getType() {
        return this.type;
    }
}
