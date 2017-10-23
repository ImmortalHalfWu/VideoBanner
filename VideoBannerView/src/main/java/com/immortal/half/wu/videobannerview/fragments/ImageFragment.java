package com.immortal.half.wu.videobannerview.fragments;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.immortal.half.wu.videobannerview.R;
import com.immortal.half.wu.videobannerview.beans.interfaces.ImageModelInterface;
import com.immortal.half.wu.videobannerview.fragments.interfaces.FragmentCallBack;
import com.squareup.picasso.Picasso;

public class ImageFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";

    private ImageModelInterface mParam1;
    private FragmentCallBack callBack;
    private Handler mainHandler = new Handler();

    public ImageFragment() {}

    public static ImageFragment newInstance(@NonNull ImageModelInterface imageModelInterface) {
        ImageFragment fragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, imageModelInterface);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() == null || getArguments().getParcelable(ARG_PARAM1) == null){
            throw new IllegalAccessError("ImageModelInterface == null");
        }
        if (getArguments() != null) {
            mParam1 = getArguments().getParcelable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_image, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = view.findViewById(R.id.imageView);
        // TODO: 2017/10/23 此处对于图片url类型的判断应该封装
        if (mParam1.getImageId() == -1){
            Picasso.with(getContext()).load(mParam1.getImageUrl()).into(imageView);
        }else {
            Picasso.with(getContext()).load(mParam1.getImageId()).into(imageView);
        }
    }

    @Override
    public void onResume() {
        if (getUserVisibleHint()){
//            Loging.log(hashCode() + " onResume timeback run___" + mParam1.getPauseTime());
            mainHandler.postDelayed(timeBackRunnable,mParam1.getPauseTime());
        }
        super.onResume();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {

        mainHandler.removeCallbacks(timeBackRunnable);
        if (isVisibleToUser && mParam1 != null){
//            Loging.log(hashCode() +  "setUserVisibleHint timeback run___" + mParam1.getPauseTime());
            mainHandler.postDelayed(timeBackRunnable,mParam1.getPauseTime());
        }

        super.setUserVisibleHint(isVisibleToUser);
    }

    public ImageFragment registCallBack(@NonNull FragmentCallBack callBack) {
        this.callBack = callBack;
        return this;
    }

    private Runnable timeBackRunnable  = new Runnable() {
        @Override
        public void run() {
            if (callBack != null) {
//                Loging.log(ImageFragment.this.hashCode() + "___run___" + mParam1.getPauseTime());
                callBack.over(ImageFragment.this);
            }
        }
    };

}
