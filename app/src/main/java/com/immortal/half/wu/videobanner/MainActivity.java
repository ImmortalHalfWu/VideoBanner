package com.immortal.half.wu.videobanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.immortal.half.wu.videobannerview.controllers.interfaces.ControllerInterfaces;
import com.immortal.half.wu.videobannerview.view.VideoBannerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {

        VideoBannerView videoBannerView = (VideoBannerView) findViewById(R.id.videoBannerView);

        ControllerInterfaces build = videoBannerView.build(getSupportFragmentManager());
        build.registImageBanner(R.drawable.ic_launcher,3000);
        build.registImageBanner("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1508654240832&di=3f9721e52de95d3c9d3220dd74212c9b&imgtype=0&src=http%3A%2F%2Fimg2.niutuku.com%2Fdesk%2F130220%2F37%2F37-niutuku.com-927.jpg",3000);
        build.registVideoBanner("http://112.253.22.157/17/z/z/y/u/zzyuasjwufnqerzvyxgkuigrkcatxr/hc.yinyuetai.com/D046015255134077DDB3ACA0D7E68D45.flv","D046015255134077DDB3ACA0D7E68D45.flv");
//        build.registImageBanner("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1508654240832&di=3f9721e52de95d3c9d3220dd74212c9b&imgtype=0&src=http%3A%2F%2Fimg2.niutuku.com%2Fdesk%2F130220%2F37%2F37-niutuku.com-927.jpg");
        build.registVideoBanner("http://flashmedia.eastday.com/newdate/news/2016-11/shznews1125-19.mp4","shznews1125-19.mp4");
//        build.registImageBanner("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1508654240832&di=3f9721e52de95d3c9d3220dd74212c9b&imgtype=0&src=http%3A%2F%2Fimg2.niutuku.com%2Fdesk%2F130220%2F37%2F37-niutuku.com-927.jpg");
        build.registVideoBanner("http://112.253.22.157/17/z/z/y/u/zzyuasjwufnqerzvyxgkuigrkcatxr/hc.yinyuetai.com/D046015255134077DDB3ACA0D7E68D45.flv","D046015255134077DDB3ACA0D7E68D45.flv");
//        build.registImageBanner("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1508654240832&di=3f9721e52de95d3c9d3220dd74212c9b&imgtype=0&src=http%3A%2F%2Fimg2.niutuku.com%2Fdesk%2F130220%2F37%2F37-niutuku.com-927.jpg");

        build.registVideoBanner("http://flashmedia.eastday.com/newdate/news/2016-11/shznews1125-19.mp4","shznews1125-19.mp4");
//        build.registImageBanner("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1508654240832&di=3f9721e52de95d3c9d3220dd74212c9b&imgtype=0&src=http%3A%2F%2Fimg2.niutuku.com%2Fdesk%2F130220%2F37%2F37-niutuku.com-927.jpg");

        build.registVideoBanner("http://112.253.22.157/17/z/z/y/u/zzyuasjwufnqerzvyxgkuigrkcatxr/hc.yinyuetai.com/D046015255134077DDB3ACA0D7E68D45.flv","D046015255134077DDB3ACA0D7E68D45.flv");
        build.registVideoBanner("http://flashmedia.eastday.com/newdate/news/2016-11/shznews1125-19.mp4","shznews1125-19.mp4");


        build.start();
    }
}
