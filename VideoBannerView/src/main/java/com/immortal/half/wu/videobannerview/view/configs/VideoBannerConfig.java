package com.immortal.half.wu.videobannerview.view.configs;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;

import com.immortal.half.wu.videobannerview.beans.BaseBean;
import com.immortal.half.wu.videobannerview.beans.ModelFactory;
import com.immortal.half.wu.videobannerview.beans.interfaces.ImageModelInterface;
import com.immortal.half.wu.videobannerview.beans.interfaces.ModelInterface;
import com.immortal.half.wu.videobannerview.beans.interfaces.VideoModelInterface;
import com.immortal.half.wu.videobannerview.distributers.FragmentDistributer;
import com.immortal.half.wu.videobannerview.enums.BannerType;
import com.immortal.half.wu.videobannerview.utils.Loging;

import java.util.ArrayList;
import java.util.List;

/**
 * Do : VideoBanner配置器
 * Created : immortalHalfWu
 * Time : 2017/10/20  16:38
 */

public class VideoBannerConfig {

    private final List<Fragment> fragments = new ArrayList<>();
    private String CacheDir = "";
    private boolean changePageAnimotion = true;
    private boolean changePageOnUser = true;

    public VideoBannerConfig() {}

    public void addFragment(@NonNull Fragment fragment){
        fragments.add(fragment);
    }

    public List<Fragment> getFragments(){
        return fragments;
    }

    public String getCacheDir() {
        return CacheDir;
    }

    public void setCacheDir(String cacheDir) {
        CacheDir = cacheDir;
    }

    public boolean isChangePageAnimotion() {
        return changePageAnimotion;
    }

    public void setChangePageAnimotion(boolean changePageAnimotion) {
        this.changePageAnimotion = changePageAnimotion;
    }

    public boolean isChangePageOnUser() {
        return changePageOnUser;
    }

    public void setChangePageOnUser(boolean changePageOnUser) {
        this.changePageOnUser = changePageOnUser;
    }

    /**
     * VideoBanner配置构造器
     */
    public static final class VideoBannerConfigBuilder{

        private static VideoBannerConfigBuilder videoBannerConfigBuilder;

        private final VideoBannerConfig videoBannerConfig;

        public VideoBannerConfigBuilder() {
            videoBannerConfig = new VideoBannerConfig();
        }

        public VideoBannerConfigBuilder(VideoBannerConfig videoBannerConfig){
            this.videoBannerConfig = videoBannerConfig;
        }

        // TODO: 2017/10/20 添加视频广告页
        public VideoBannerConfigBuilder registVideoBanner(@NonNull String videoUrl,@NonNull String videoName){
            VideoModelInterface videoModel = ModelFactory.instance().createVideoModel(videoBannerConfig.getCacheDir(), videoUrl, videoName);
            Loging.log("imageModelInterface instanceof ModelInterface == " + (videoModel instanceof ModelInterface));
            if (videoModel instanceof ModelInterface){
                Fragment fragment = FragmentDistributer.instance().toFragment((ModelInterface<BannerType, BaseBean>) videoModel);
                videoBannerConfig.addFragment(fragment);
            }
            return this;
        }

        // TODO: 2017/10/20 添加图片广告页
        public VideoBannerConfigBuilder registImageBanner(@NonNull String imageUrl){
            ImageModelInterface imageModelInterface = ModelFactory.instance().createImageModel(imageUrl);
            Loging.log("imageModelInterface instanceof ModelInterface == " + (imageModelInterface instanceof ModelInterface));
            if (imageModelInterface instanceof ModelInterface){
                Fragment fragment = FragmentDistributer.instance().toFragment((ModelInterface<BannerType, BaseBean>) imageModelInterface);
                videoBannerConfig.addFragment(fragment);
            }
            return this;
        }

        // TODO: 2017/10/20 添加自定义广告页
        public VideoBannerConfigBuilder registCustomBanner(@NonNull Fragment fragment){
            videoBannerConfig.addFragment(fragment);
            return this;
        }

        // TODO: 2017/10/21 清空广告列表
        public VideoBannerConfigBuilder clearBanner(){
            videoBannerConfig.getFragments().clear();
            return this;
        }

        // TODO: 2017/10/20 设置视频缓存至本地路径，未设置则不缓存本地
        public VideoBannerConfigBuilder setCacheDir(@NonNull String dirPath){
            videoBannerConfig.setCacheDir(dirPath);
            return this;
        }

        // TODO: 2017/10/20 页面切换是否有过渡动画
        public VideoBannerConfigBuilder setChangePageAnimotion(boolean hasAnimotion){
            videoBannerConfig.setChangePageAnimotion(hasAnimotion);
            return this;
        }
        // TODO: 2017/10/20 是否可以手动滚动页面
        public VideoBannerConfigBuilder setChangePageOnUser(boolean hasUser){
            videoBannerConfig.setChangePageOnUser(hasUser);
            return this;
        }

        public VideoBannerConfig build(){
            if (TextUtils.isEmpty(videoBannerConfig.getCacheDir()))
                throw new IllegalAccessError("must set video CacheDir,user VideoBannerConfigBuilder.setCacheDir(String dirPath)");
            return videoBannerConfig;
        }

    }

}
