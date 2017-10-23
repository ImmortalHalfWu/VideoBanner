package com.immortal.half.wu.videobannerview.beans;

import android.os.Parcel;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

import com.immortal.half.wu.videobannerview.beans.interfaces.ImageModelInterface;
import com.immortal.half.wu.videobannerview.enums.BannerType;

/**
 * Do : image Model类
 * Created : immortalHalfWu
 * Time : 2017/10/21  10:17
 */

class ImageBean extends BaseBean<ImageModelInterface> implements ImageModelInterface{

    private String imageURl;
    private @DrawableRes int imageId = -1;
    private long pauseTime;

    private ImageBean(long pauseTime){
        super(BannerType.TYPE_IMAGE);
        this.pauseTime =pauseTime;
    }

    ImageBean(@NonNull String imageURl,long pauseTime) {
        this(pauseTime);
        this.imageURl = imageURl;
    }

    ImageBean(@DrawableRes int imageId,long pauseTime) {
        this(pauseTime);
        this.imageId = imageId;
    }

    @NonNull
    @Override
    public ImageModelInterface getModel() {
        return this;
    }


    @NonNull
    @Override
    public String getImageUrl() {
        return imageURl;
    }

    @Override
    public int getImageId() {
        return imageId;
    }

    @Override
    public long getPauseTime() {
        return pauseTime;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imageURl);
        dest.writeInt(this.imageId);
        dest.writeLong(this.pauseTime);
    }

    protected ImageBean(Parcel in) {
        super(BannerType.TYPE_IMAGE);
        this.imageURl = in.readString();
        this.imageId = in.readInt();
        this.pauseTime = in.readLong();
    }

    public static final Creator<ImageBean> CREATOR = new Creator<ImageBean>() {
        @Override
        public ImageBean createFromParcel(Parcel source) {
            return new ImageBean(source);
        }

        @Override
        public ImageBean[] newArray(int size) {
            return new ImageBean[size];
        }
    };
}
