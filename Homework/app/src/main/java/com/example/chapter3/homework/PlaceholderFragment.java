package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ListView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class PlaceholderFragment extends Fragment {
    private LottieAnimationView animationView;
    private AnimatorSet animatorSet;
    private ItemAdapter mAdapter;
    private RecyclerView mNumbersListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_place holder，添加 loading控件和列表视图控件

        View view = inflater.inflate(R.layout.fragment_placeholder, container, false);
        animationView=view.findViewById(R.id.animation_view);
        mNumbersListView = view.findViewById(R.id.rv_list);
        mAdapter=new ItemAdapter(getActivity());
        mNumbersListView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        mNumbersListView.setItemAnimator(new DefaultItemAnimator());
        mNumbersListView.setAdapter(mAdapter);
        mNumbersListView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        mNumbersListView.setVisibility(View.GONE);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
//                animationView.pauseAnimation();
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(animationView,
                        "alpha",1,0);
                animator1.setDuration(800);

                ObjectAnimator animator2 = ObjectAnimator.ofFloat(mNumbersListView,
                        "alpha",0,1);
                animator2.setDuration(800);

                mNumbersListView.setVisibility(View.VISIBLE);
                animatorSet = new AnimatorSet();
                animatorSet.playTogether(animator1, animator2);
                animatorSet.start();
            }
        }, 5000);
    }
}
