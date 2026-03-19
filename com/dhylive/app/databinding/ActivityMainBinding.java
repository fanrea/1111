package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.dhylive.app.R;
import com.noober.background.view.BLImageView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class ActivityMainBinding extends ViewDataBinding {
    public final FrameLayout flContainer;
    public final BLImageView ivDrama;
    public final AppCompatImageView ivGame;
    public final AppCompatImageView ivMoney;
    public final AppCompatImageView ivMy;
    public final AppCompatImageView ivNovel;
    public final AppCompatImageView ivShop;
    public final AppCompatImageView ivTask;
    public final AppCompatImageView ivVideo;
    public final AppCompatImageView ivVideoKs;
    public final LinearLayout llDrama;
    public final LinearLayout llGame;
    public final LinearLayout llMoney;
    public final LinearLayout llMy;
    public final LinearLayout llNovel;
    public final LinearLayout llShop;
    public final LinearLayout llTab;
    public final LinearLayout llTask;
    public final LinearLayout llVideo;
    public final LinearLayout llVideoKs;
    public final TextView tvDrama;
    public final TextView tvGame;
    public final TextView tvMoney;
    public final TextView tvMy;
    public final TextView tvNovel;
    public final TextView tvShop;
    public final TextView tvTask;
    public final TextView tvVideo;
    public final TextView tvVideoKs;
    public final ViewPager2 viewPage;

    protected ActivityMainBinding(Object obj, View view, int i, FrameLayout frameLayout, BLImageView bLImageView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatImageView appCompatImageView5, AppCompatImageView appCompatImageView6, AppCompatImageView appCompatImageView7, AppCompatImageView appCompatImageView8, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, LinearLayout linearLayout8, LinearLayout linearLayout9, LinearLayout linearLayout10, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.flContainer = frameLayout;
        this.ivDrama = bLImageView;
        this.ivGame = appCompatImageView;
        this.ivMoney = appCompatImageView2;
        this.ivMy = appCompatImageView3;
        this.ivNovel = appCompatImageView4;
        this.ivShop = appCompatImageView5;
        this.ivTask = appCompatImageView6;
        this.ivVideo = appCompatImageView7;
        this.ivVideoKs = appCompatImageView8;
        this.llDrama = linearLayout;
        this.llGame = linearLayout2;
        this.llMoney = linearLayout3;
        this.llMy = linearLayout4;
        this.llNovel = linearLayout5;
        this.llShop = linearLayout6;
        this.llTab = linearLayout7;
        this.llTask = linearLayout8;
        this.llVideo = linearLayout9;
        this.llVideoKs = linearLayout10;
        this.tvDrama = textView;
        this.tvGame = textView2;
        this.tvMoney = textView3;
        this.tvMy = textView4;
        this.tvNovel = textView5;
        this.tvShop = textView6;
        this.tvTask = textView7;
        this.tvVideo = textView8;
        this.tvVideoKs = textView9;
        this.viewPage = viewPager2;
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityMainBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_main, viewGroup, z, obj);
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityMainBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_main, null, false, obj);
    }

    public static ActivityMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMainBinding bind(View view, Object obj) {
        return (ActivityMainBinding) bind(obj, view, R.layout.activity_main);
    }
}
