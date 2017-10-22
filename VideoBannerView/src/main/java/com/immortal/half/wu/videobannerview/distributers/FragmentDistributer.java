package com.immortal.half.wu.videobannerview.distributers;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.immortal.half.wu.videobannerview.beans.BaseBean;
import com.immortal.half.wu.videobannerview.beans.interfaces.ImageModelInterface;
import com.immortal.half.wu.videobannerview.beans.interfaces.ModelInterface;
import com.immortal.half.wu.videobannerview.beans.interfaces.VideoModelInterface;
import com.immortal.half.wu.videobannerview.distributers.interfaces.DistributeInterface;
import com.immortal.half.wu.videobannerview.enums.BannerType;
import com.immortal.half.wu.videobannerview.fragments.FragmentFractory;

/**
 * Do : Distribute 实现层，bean to fragment
 * Created : immortalHalfWu
 * Time : 2017/10/21  10:36
 */
public class FragmentDistributer implements DistributeInterface<BannerType,BaseBean> {

    private FragmentDistributer() {}

    private static FragmentDistributer fragmentDistributer;
    public static FragmentDistributer instance(){
        return fragmentDistributer == null ? fragmentDistributer = new FragmentDistributer() : fragmentDistributer;
    }

    @Override
    public @NonNull Fragment toFragment(ModelInterface<BannerType,BaseBean> modelInterface) {
        BannerType type = modelInterface.getType();
        Fragment fragment;
        switch (type){
            case TYPE_VIDEO:
                if (!(modelInterface.getModel() instanceof VideoModelInterface))
                    throw new IllegalAccessError("ModelInterface.getType() is video, but ModelInterface.getModel() not is VideoModelInterface instance");
                fragment = FragmentFractory.instans().createVideoFragment((VideoModelInterface) modelInterface.getModel());
                break;
            case TYPE_IMAGE:
                if (!(modelInterface.getModel() instanceof ImageModelInterface))
                    throw new IllegalAccessError("ModelInterface.getType() is image, but ModelInterface.getModel() not is ImageModelInterface instance");
                fragment = FragmentFractory.instans().createImageFragment((ImageModelInterface) modelInterface.getModel());
                break;
            default:
                throw new IllegalAccessError("ModelInterface.getType() only is BannerType instance");
        }
        return fragment;
    }

    @Override
    public BannerType toType(Fragment fragment) {
        return null;
    }
}
