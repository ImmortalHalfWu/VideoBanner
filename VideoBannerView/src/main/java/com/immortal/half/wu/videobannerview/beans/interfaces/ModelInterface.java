package com.immortal.half.wu.videobannerview.beans.interfaces;

import android.support.annotation.NonNull;

/**
 * Do : Model顶层接口，指明Model为那种类型Banner
 * Created : immortalHalfWu
 * Time : 2017/10/21  10:25
 */

public interface ModelInterface<T,M> {

    /**
     * Do : 每个model指代一种banner类型
     * <br></br>Create : immmortalHalfWu
     * <br></br>Time : 2017/10/21  10:29
     */
    @NonNull T getType();

    @NonNull M getModel();

}
