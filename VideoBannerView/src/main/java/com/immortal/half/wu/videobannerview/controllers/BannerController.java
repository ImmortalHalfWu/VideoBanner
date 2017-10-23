package com.immortal.half.wu.videobannerview.controllers;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.immortal.half.wu.videobannerview.adapters.BannerViewPagerAdapter;
import com.immortal.half.wu.videobannerview.beans.BaseBean;
import com.immortal.half.wu.videobannerview.beans.ModelFactory;
import com.immortal.half.wu.videobannerview.beans.interfaces.ImageModelInterface;
import com.immortal.half.wu.videobannerview.beans.interfaces.ModelInterface;
import com.immortal.half.wu.videobannerview.beans.interfaces.VideoModelInterface;
import com.immortal.half.wu.videobannerview.controllers.interfaces.ControllerInterfaces;
import com.immortal.half.wu.videobannerview.distributers.FragmentDistributer;
import com.immortal.half.wu.videobannerview.enums.BannerType;
import com.immortal.half.wu.videobannerview.fragments.ImageFragment;
import com.immortal.half.wu.videobannerview.fragments.VideoFragment2;
import com.immortal.half.wu.videobannerview.fragments.interfaces.FragmentCallBack;
import com.immortal.half.wu.videobannerview.utils.FileUtil;
import com.immortal.half.wu.videobannerview.view.CustomViewPager;
import com.immortal.half.wu.videobannerview.view.configs.VideoBannerConfig;

import java.io.File;
import java.util.List;

/**
 * Do :
 * Created : immortalHalfWu
 * Time : 2017/10/21  15:31
 */

public class BannerController implements ControllerInterfaces{

    private BannerController(@NonNull CustomViewPager viewPager, @NonNull FragmentManager fragmentManager) {
        FileUtil.instance(viewPager.getContext());
        this.viewPager = viewPager;
        this.fragmentManager = fragmentManager;
        videoBannerConfig = new VideoBannerConfig();
        videoBannerConfig.setCacheDir(FileUtil.getAppVidioFilePath());
    }

    public static BannerController newInstance(@NonNull CustomViewPager viewPager, @NonNull FragmentManager fragmentManager){
        return new BannerController(viewPager,fragmentManager);
    }

    private CustomViewPager viewPager;
    private BannerViewPagerAdapter viewPagerAdapter;
    private FragmentManager fragmentManager;
    private VideoBannerConfig videoBannerConfig;

    private FragmentCallBack videoFragmentCallBack = new FragmentCallBack() {
        @Override
        public void over(@NonNull Fragment fragment) {
            if (!videoBannerConfig.getFragments().contains(fragment)){
                throw new IllegalAccessError("Banner list not find this fragment : " + fragment);
            }
            int size = videoBannerConfig.getFragments().size();
            int index = videoBannerConfig.getFragments().indexOf(fragment);

            viewPager.setCurrentItem(size-1 <= index ? 0 : index+1,videoBannerConfig.isChangePageAnimotion());
        }

        @Override
        public void erro(@NonNull Fragment fragment) {
            if (!videoBannerConfig.getFragments().contains(fragment)){
                throw new IllegalAccessError("Banner list not find this fragment : " + fragment);
            }
            int index = videoBannerConfig.getFragments().indexOf(fragment);
            videoBannerConfig.getFragments().remove(index);
            notifyDataSetChanged();
            viewPager.setCurrentItem(videoBannerConfig.getFragments().size()-1 <= index ? 0 : index,videoBannerConfig.isChangePageAnimotion());
        }
    };

    private FragmentCallBack imageFragmentCallBack = new FragmentCallBack() {
        @Override
        public void over(@NonNull Fragment fragment) {
            videoFragmentCallBack.over(fragment);
        }

        @Override
        public void erro(@NonNull Fragment fragment) {
            videoFragmentCallBack.erro(fragment);
        }
    };

    @Override
    public ControllerInterfaces registVideoBanner(@NonNull String videoUrl, @NonNull String videoName) {
        VideoModelInterface videoModel = ModelFactory.instance().createVideoModel(videoBannerConfig.getCacheDir(), videoUrl, videoName);
//        Loging.log("imageModelInterface instanceof ModelInterface == " + (videoModel instanceof ModelInterface));
        if (videoModel instanceof ModelInterface){
            Fragment fragment = FragmentDistributer.instance().toFragment((ModelInterface<BannerType, BaseBean>) videoModel);
            if (fragment instanceof VideoFragment2){
                VideoFragment2 videoFragment2 = (VideoFragment2) fragment;
                videoFragment2.registCallBack(videoFragmentCallBack);
            }
            videoBannerConfig.addFragment(fragment);
        }
        return this;
    }

    @Override
    public ControllerInterfaces registImageBanner(@NonNull String imageUrl,long pauseTime) {
        ImageModelInterface imageModelInterface = ModelFactory.instance().createImageModel(imageUrl,pauseTime);
//        Loging.log("imageModelInterface instanceof ModelInterface == " + (imageModelInterface instanceof ModelInterface));
//        if (imageModelInterface instanceof ModelInterface){
//            Fragment fragment = FragmentDistributer.instance().toFragment((ModelInterface<BannerType, BaseBean>) imageModelInterface);
//            videoBannerConfig.addFragment(addImageFragment(imageModelInterface));
//        }
        addImageFragment(imageModelInterface);
        return this;
    }

    @Override
    public ControllerInterfaces registImageBanner(@DrawableRes int imageId,long pauseTime) {
        ImageModelInterface imageModelInterface = ModelFactory.instance().createImageModel(imageId,pauseTime);
//        Loging.log("imageModelInterface instanceof ModelInterface == " + (imageModelInterface instanceof ModelInterface));
//        if (imageModelInterface instanceof ModelInterface){
//            Fragment fragment = FragmentDistributer.instance().toFragment((ModelInterface<BannerType, BaseBean>) imageModelInterface);
//            videoBannerConfig.addFragment(addImageFragment(imageModelInterface));
//        }
        addImageFragment(imageModelInterface);
        return this;
    }

    private void addImageFragment(ImageModelInterface imageModelInterface){
        if (!(imageModelInterface instanceof ModelInterface)){
            throw new IllegalAccessError("imageModelInterface instanceof ModelInterface is false");
        }
        Fragment fragment = FragmentDistributer.instance().toFragment((ModelInterface<BannerType, BaseBean>) imageModelInterface);
        if (fragment instanceof ImageFragment){
            ImageFragment imageFragment = (ImageFragment) fragment;
            imageFragment.registCallBack(imageFragmentCallBack);
        }
        videoBannerConfig.addFragment(fragment);
    }

    @Override
    public ControllerInterfaces registCustomBanner(@NonNull Fragment fragment) {
        videoBannerConfig.addFragment(fragment);
        return this;
    }

    @Override
    public List<Fragment> getBannerFragments() {
        return videoBannerConfig.getFragments();
    }

    @Override
    public ControllerInterfaces clearBanner() {
        videoBannerConfig.getFragments().clear();
        return this;
    }

    @Override
    public ControllerInterfaces setCacheDir(@NonNull String dirPath) {
        videoBannerConfig.setCacheDir(dirPath);
        return this;
    }

    @Override
    public ControllerInterfaces setChangePageAnimotion(boolean hasAnimotion) {
        videoBannerConfig.setChangePageAnimotion(hasAnimotion);
        return this;
    }

    @Override
    public ControllerInterfaces setChangePageOnUser(boolean hasUser) {
        videoBannerConfig.setChangePageOnUser(hasUser);
        viewPager.setTouchenabled(hasUser);
        return this;
    }

    @Override
    public ControllerInterfaces notifyDataSetChanged() {
        viewPagerAdapter.notifyDataSetChanged();
        return this;
    }

    @Override
    public ControllerInterfaces start() {

//        if (TextUtils.isEmpty(videoBannerConfig.getCacheDir()))
//            throw new IllegalAccessError("must set video CacheDir,user VideoBannerConfigBuilder.setCacheDir(String dirPath)");

        if (viewPagerAdapter == null){
            viewPagerAdapter = new BannerViewPagerAdapter(fragmentManager,videoBannerConfig.getFragments());
            viewPager.setOffscreenPageLimit(videoBannerConfig.getFragments().size());
            viewPager.setAdapter(viewPagerAdapter);
        }else
            notifyDataSetChanged();
        return this;
    }

    @Override
    public void clearCacheVideo() {
        File cacheDir = new File(videoBannerConfig.getCacheDir());
        if (cacheDir.exists()){
            FileUtil.deleteFolderFile(cacheDir.getAbsolutePath(),false);
        }
    }

    @Override
    public long getCacheVideoSize() {
        File cacheDir = new File(videoBannerConfig.getCacheDir());
        return FileUtil.getFolderSize(cacheDir);
    }

}
