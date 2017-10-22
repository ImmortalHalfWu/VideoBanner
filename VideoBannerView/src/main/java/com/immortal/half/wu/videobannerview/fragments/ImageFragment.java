package com.immortal.half.wu.videobannerview.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.immortal.half.wu.videobannerview.R;
import com.immortal.half.wu.videobannerview.beans.interfaces.ImageModelInterface;

public class ImageFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";

    private ImageModelInterface mParam1;
    private SimpleDraweeView draweeView;

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
        draweeView = view.findViewById(R.id.imageView2);
        draweeView.setImageURI(mParam1.getImageUrl());
    }
}
