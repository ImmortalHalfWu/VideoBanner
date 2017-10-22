package com.immortal.half.wu.videobannerview.view;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.immortal.half.wu.videobannerview.controllers.BannerController;
import com.immortal.half.wu.videobannerview.controllers.interfaces.ControllerInterfaces;
import com.immortal.half.wu.videobannerview.utils.Loging;

import io.vov.vitamio.LibsChecker;

/**
 * Do : 视频轮播广告页，支持单图片、视频混排，支持自定义fragment
 * Created : immortalHalfWu
 * Time : 2017/10/18 14:22
 */

public class VideoBannerView extends RelativeLayout {

    public VideoBannerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public VideoBannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public VideoBannerView(Context context) {
        super(context);
        init(context);
    }

    private Context context;
    private CustomViewPager viewPager;

    private ControllerInterfaces controllerInterfaces;

    private void init(Context context) {
        this.context = context;
        initVitamio();
        initViewPager();
    }

    private void initVitamio() {

        if (context instanceof Activity && !LibsChecker.checkVitamioLibs((Activity) context)){
            Loging.log("vitamio 初始化失败");
        }
        Fresco.initialize(context.getApplicationContext());
    }

    public ControllerInterfaces build(@NonNull FragmentManager fm) {
        if (controllerInterfaces == null)
            controllerInterfaces = BannerController.newInstance(viewPager,fm);
        return controllerInterfaces;
    }

    private void initViewPager() {

        viewPager = new CustomViewPager(context);
        viewPager.setId(viewPager.hashCode());
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        addView(viewPager,layoutParams);

    }

}
