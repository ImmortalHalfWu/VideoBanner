package io.vov.vitamio.demo;

import android.support.v4.app.FragmentActivity;

/**
 * Do :
 * <br></br>Name : VitamioViewPagerActivity
 * <br></br>Create : immmortalHalfWu
 * <br></br>Time : 2017/10/21  10:04
 *
 *
 *
 * question:
 * 1,页面之前切换，加载视频有一下卡顿，出现在32M视频上（爱奇艺），测试与跳帧无关，推测是文件过大的问题
 */
public class VitamioViewPagerActivity extends FragmentActivity {

//    private CustomViewPager viewPager;
//    private List<Fragment> fragments;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        initVitamio();
//        setContentView(R.layout.activity_vitamio_view_pager);
//        FileUtil2.instance(this);
//        initVitamio();
//        initView();
//
//    }
//
//    private void initVitamio() {
//        if (!LibsChecker.checkVitamioLibs(this)){
//            loging("vitamio 初始化失败");
//            Toast.makeText(this, "vitamio 初始化失败", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    private void initView() {
//        viewPager = (CustomViewPager) findViewById(R.id.viewPager);
//        viewPager.setOffscreenPageLimit(getFragments().size());
////        viewPager.setOffscreenPageLimit(0);
//        viewPager.setTouchenabled(false);
//        final MyViewPager myViewPager = new MyViewPager(getSupportFragmentManager(), getFragments());
//        viewPager.setAdapter(myViewPager);
////        viewPager.postDelayed(new Runnable() {
////            @Override
////            public void run() {
////                myViewPager.notifyDataSetChanged();
////            }
////        },100);
//    }
//
//    public List<Fragment> getFragments() {
//        if (fragments == null){
//            fragments = new ArrayList<Fragment>();
//            fragments.add(new VideoViewFragment(new VideoBean("http://flashmedia.eastday.com/newdate/news/2016-11/shznews1125-19.mp4"),videoCallBack));
//            fragments.add(new VideoViewFragment(new VideoBean("http://flashmedia.eastday.com/newdate/news/2016-11/shznews1125-19.mp4"),videoCallBack));
//            fragments.add(new VideoViewFragment(new VideoBean("http://flashmedia.eastday.com/newdate/news/2016-11/shznews1125-19.mp4"),videoCallBack));
//            fragments.add(new VideoViewFragment(new VideoBean("http://flashmedia.eastday.com/newdate/news/2016-11/shznews1125-19.mp4"),videoCallBack));
//            fragments.add(new VideoViewFragment(new VideoBean("http://112.253.22.157/17/z/z/y/u/zzyuasjwufnqerzvyxgkuigrkcatxr/hc.yinyuetai.com/D046015255134077DDB3ACA0D7E68D45.flv"),videoCallBack));
//            fragments.add(new VideoViewFragment(new VideoBean("http://flashmedia.eastday.com/newdate/news/2016-11/shznews1125-19.mp4"),videoCallBack));
//            fragments.add(new VideoViewFragment(new VideoBean("http://112.253.22.157/17/z/z/y/u/zzyuasjwufnqerzvyxgkuigrkcatxr/hc.yinyuetai.com/D046015255134077DDB3ACA0D7E68D45.flv"),videoCallBack));
//            fragments.add(new VideoViewFragment(new VideoBean("http://flashmedia.eastday.com/newdate/news/2016-11/shznews1125-19.mp4"),videoCallBack));
//            fragments.add(new VideoViewFragment(new VideoBean("http://112.253.22.157/17/z/z/y/u/zzyuasjwufnqerzvyxgkuigrkcatxr/hc.yinyuetai.com/D046015255134077DDB3ACA0D7E68D45.flv"),videoCallBack));
//            fragments.add(new VideoViewFragment(new VideoBean("http://112.253.22.157/17/z/z/y/u/zzyuasjwufnqerzvyxgkuigrkcatxr/hc.yinyuetai.com/D046015255134077DDB3ACA0D7E68D45.flv"),videoCallBack));
//            fragments.add(new VideoViewFragment(new VideoBean("http://112.253.22.157/17/z/z/y/u/zzyuasjwufnqerzvyxgkuigrkcatxr/hc.yinyuetai.com/D046015255134077DDB3ACA0D7E68D45.flv"),videoCallBack));
//            fragments.add(new VideoViewFragment(new VideoBean("http://112.253.22.157/17/z/z/y/u/zzyuasjwufnqerzvyxgkuigrkcatxr/hc.yinyuetai.com/D046015255134077DDB3ACA0D7E68D45.flv"),videoCallBack));
//        }
//        return fragments;
//    }
//
//    private VideoViewFragment.VideoCallBack videoCallBack = new VideoViewFragment.VideoCallBack() {
//
//        @Override
//        public void over(Fragment fragment) {
//            if (!getFragments().contains(fragment))
//                return;
//            int size = getFragments().size();
//            int index = getFragments().indexOf(fragment);
//
//            viewPager.setCurrentItem(size-1 == index ? 0 : index+1,false);
//        }
//
//        @Override
//        public void erro(Fragment fragment) {
//            if (!getFragments().contains(fragment))
//                return;
//            int i = getFragments().indexOf(fragment);
//            viewPager.setCurrentItem(i,false);
//            getFragments().remove(i);
//        }
//    };
//
//    private final static class MyViewPager extends FragmentPagerAdapter{
//
//        private final List<Fragment> fragments;
//
//        public MyViewPager(FragmentManager fm, List<Fragment> fragments) {
//            super(fm);
//            this.fragments =fragments;
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            return fragments.get(position);
//        }
//
//        @Override
//        public int getCount() {
//            return fragments == null ? 0 : fragments.size() ;
//        }
//    }
//
//
//
//    public static class VideoViewFragment extends Fragment implements MediaPlayer.OnPreparedListener,MediaPlayer.OnErrorListener,MediaPlayer.OnInfoListener,MediaPlayer.OnCompletionListener{
//
//        protected static int index = 1;
//        private int mIndex = index++;
//        private final VideoBean videoBean;
//        private VideoView videoView;
//        private final VideoCallBack callBack;
//
//        public VideoViewFragment(VideoBean videoBean,VideoCallBack callBack){
//            super();
//            this.videoBean = videoBean;
//            this.callBack = callBack;
//        }
//
//        @Override
//        public void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            Log.i(TAG, mIndex + "onCreate: " +  "___videoView == null ? " + (videoView == null));
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//            Log.i(TAG, mIndex + "onCreateView: " +  "___videoView == null ? " + (videoView == null));
//            return inflater.inflate(R.layout.fragment_videoview,container,false);
//        }
//
//        @Override
//        public void onViewCreated(View view, Bundle savedInstanceState) {
//            Log.i(TAG, mIndex + "onViewCreated: " +  "___videoView == null ? " + (videoView == null));
//            videoView = (VideoView) view.findViewById(R.id.videoView);
//            videoView.setOnInfoListener(this);
//            videoView.setOnErrorListener(this);
//            videoView.setOnCompletionListener(this);
//            videoView.setOnPreparedListener(this);
////            videoView.setVideoURI(videoBean.getVideoUri());
////            videoView.setVideoLayout(VideoView.VIDEO_LAYOUT_ORIGIN,0);
//
//            view.findViewById(R.id.open).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
////                    videoView.setVideoURI(videoBean.getVideoUri());
//                    callBack.over(VideoViewFragment.this);
//                }
//            });
////
//            view.findViewById(R.id.pause).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (videoView.isValid() && videoView.isPlaying())
//                        videoView.pause();
//                }
//            });
////
////            view.findViewById(R.id.resume).setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View view) {
////                    if (videoView.isValid() && !videoView.isPlaying())
////                        videoView.start();
////                }
////            });
////
////            view.findViewById(R.id.clear).setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View view) {
////                    videoView.stopPlayback();
////                }
////            });
//
//            super.onViewCreated(view, savedInstanceState);
//        }
//
//        @Override
//        public void onResume() {
//            Log.i(TAG, mIndex + " ____onResume: " +  "___videoView == null ? " + (videoView == null));
//            if (isVisibleToUser && videoView != null){
//                videoView.setVideoURI(videoBean.getVideoUri());
//                videoView.seekTo(videoBean.getCurrentPosition());
//                videoView.start();
//            }
////            videoView.start();
//            super.onResume();
//        }
//
//        private boolean isVisibleToUser;
//
//        @Override
//        public void setUserVisibleHint(boolean isVisibleToUser) {
//            this.isVisibleToUser = isVisibleToUser;
//            Log.i(TAG, mIndex + " __ visible = " + isVisibleToUser + "___videoView == null ? " + (videoView == null));
//            if (videoView!=null){
//////                Log.i(TAG, mIndex +" 最大进"+videoView.getDuration()+"__播放进度: "+videoView.getCurrentPosition());
//////                Log.i(TAG, mIndex +" 最大进"+videoBean.getMaxDuration()+"__播放进度: "+videoBean.getCurrentPosition());
//////                Log.i(TAG, mIndex + " isVisibleToUser ? " + isVisibleToUser + "___videoView.isValid() ? " + videoView.isValid());
//                if (isVisibleToUser && videoView.isValid()){
//                    videoView.setVideoURI(videoBean.getVideoUri());
//                    videoView.seekTo(videoBean.getCurrentPosition());
//                    videoView.start();
//                }else {
//                    videoView.stopPlayback();
//                }
//            }
//            super.setUserVisibleHint(isVisibleToUser);
//        }
//
//        public VideoBean getVideoBean() {
//            return videoBean;
//        }
//
//        @Override
//        public boolean onInfo(MediaPlayer mp, int what, int extra) {
//            if (what == MEDIA_INFO_DOWNLOAD_RATE_CHANGED){
//                videoBean.setCurrentPosition(mp.getCurrentPosition());
//            }
////            Log.i(TAG, "onInfo:what"+what+" 最大进度="+mp.getDuration() + "__当前进度=" + mp.getCurrentPosition());
//            return false;
//        }
//
//        @Override
//        public void onCompletion(MediaPlayer mp) {
//            videoBean.setCurrentPosition(0);
//            if (callBack != null)
//                callBack.over(this);
//        }
//
//        @Override
//        public boolean onError(MediaPlayer mp, int what, int extra) {
//            if (callBack != null){
//                callBack.erro(this);
//            }
//            return true;
//        }
//
//        @Override
//        public void onPrepared(MediaPlayer mp) {
////            Log.i(TAG, "onPrepared___" + mIndex +" 最大进"+mp.getDuration()+"__播放进度: "+mp.getCurrentPosition());
//            videoBean.setMaxDuration(mp.getDuration());
////            mp.set
//        }
//
//        public interface VideoCallBack{
//            void over(Fragment fragment);
//            void erro(Fragment fragment);
//        }
//
//    }
//
//    static class VideoBean{
//
//        private final String videoUrl;
//        private Uri videoUri;
//        private long CurrentPosition = 0;
//        private long maxDuration = 0;
//
//        public VideoBean(String videoUrl) {
//            this.videoUrl = videoUrl;
//        }
//
//        public String getVideoUrl() {
//            return videoUrl;
//        }
//
//        public Uri getVideoUri() {
//            String[] split = videoUrl.split(File.separator);
//            File file = new File(FileUtil2.getAppVidioFilePath() + split[split.length-1]);
//            if (file.exists()){
//                videoUri = Uri.parse(file.getAbsolutePath());
//            }else {
//                videoUri = Uri.parse("cache:" + FileUtil2.getAppVidioFilePath() + split[split.length-1]+":" + videoUrl);
//            }
//            Log.i(TAG, "getVideoUri: " + videoUri.toString());
//            return videoUri;
//        }
//
//        public long getCurrentPosition() {
//            return CurrentPosition;
//        }
//
//        public void setCurrentPosition(long currentPosition) {
//            CurrentPosition = currentPosition;
//        }
//
//        public long getMaxDuration() {
//            return maxDuration;
//        }
//
//        public void setMaxDuration(long maxDuration) {
//            this.maxDuration = maxDuration;
//        }
//    }
//
//    private static final String TAG = "66666";
//    private void loging(String value){
//        Log.i(TAG, value);
//    }

}
