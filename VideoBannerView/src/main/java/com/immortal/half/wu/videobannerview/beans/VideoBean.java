package com.immortal.half.wu.videobannerview.beans;

import android.os.Parcel;
import android.support.annotation.NonNull;

import com.immortal.half.wu.videobannerview.beans.interfaces.VideoModelInterface;
import com.immortal.half.wu.videobannerview.enums.BannerType;

import java.io.File;

/**
 * Do : Video Model 类， 对应video属性
 * Created : immortalHalfWu
 * Time : 2017/10/21  10:17
 */
class VideoBean extends BaseBean<VideoModelInterface> implements VideoModelInterface{

    /**
     * 视频url
     */
    private final String videoUrl;
    /**
     * 视频名称
     */
    private final String videoName;
    /**
     * 播放进度
     */
    private long CurrentPosition = 0;
    /**
     * 最大进度
     */
    private long maxDuration = 0;
    /**
     * 本地缓存路径
     */
    private String videoCacheDir;

    VideoBean(@NonNull String videoUrl, @NonNull String videoCacheDir) {
        this(videoUrl,videoUrl.split(File.separator)[videoUrl.split(File.separator).length-1],videoCacheDir);
    }

    VideoBean(@NonNull String videoUrl, @NonNull String videoName, @NonNull String videoCacheDir) {
        super(BannerType.TYPE_VIDEO);
        this.videoUrl = videoUrl;
        this.videoName = videoName;
        this.videoCacheDir = videoCacheDir;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public long getCurrentPosition() {
        return CurrentPosition;
    }

    public void setCurrentPosition(long currentPosition) {
        CurrentPosition = currentPosition;
    }

    public long getMaxDuration() {
        return maxDuration;
    }

    @Override
    public void setMaxDuration(long maxDuration) {
        this.maxDuration = maxDuration;
    }

    public String getVideoName() {
        return videoName;
    }

    @Override
    public String getVideoCacheDir() {
        return videoCacheDir;
    }

    @NonNull
    @Override
    public VideoModelInterface getModel() {
        return this;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.videoUrl);
        dest.writeString(this.videoName);
        dest.writeLong(this.CurrentPosition);
        dest.writeLong(this.maxDuration);
        dest.writeString(this.videoCacheDir);
    }

    protected VideoBean(Parcel in) {
        super(BannerType.TYPE_VIDEO);
        this.videoUrl = in.readString();
        this.videoName = in.readString();
        this.CurrentPosition = in.readLong();
        this.maxDuration = in.readLong();
        this.videoCacheDir = in.readString();
    }

    public static final Creator<VideoBean> CREATOR = new Creator<VideoBean>() {
        @Override
        public VideoBean createFromParcel(Parcel source) {
            return new VideoBean(source);
        }

        @Override
        public VideoBean[] newArray(int size) {
            return new VideoBean[size];
        }
    };
}
