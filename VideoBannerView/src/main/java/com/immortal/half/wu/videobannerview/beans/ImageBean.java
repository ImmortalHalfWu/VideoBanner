package com.immortal.half.wu.videobannerview.beans;

import android.os.Parcel;
import android.support.annotation.NonNull;

import com.immortal.half.wu.videobannerview.beans.interfaces.ImageModelInterface;
import com.immortal.half.wu.videobannerview.enums.BannerType;

/**
 * Do : image Model类
 * Created : immortalHalfWu
 * Time : 2017/10/21  10:17
 */

class ImageBean extends BaseBean<ImageModelInterface> implements ImageModelInterface{

    private final String imageURl;

    ImageBean(@NonNull String imageURl) {
        super(BannerType.TYPE_IMAGE);
        this.imageURl = imageURl;
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
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imageURl);
    }

    private ImageBean(Parcel in) {
        super(BannerType.TYPE_IMAGE);
        this.imageURl = in.readString();
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
