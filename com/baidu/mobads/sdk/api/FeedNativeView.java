package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.av;
import com.baidu.mobads.sdk.internal.bt;
import com.baidu.mobads.sdk.internal.z;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class FeedNativeView extends RelativeLayout {
    private View mAdView;
    private Context mContext;
    private ClassLoader mLoader;

    public FeedNativeView(Context context) {
        super(context);
        init(context);
    }

    public FeedNativeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public FeedNativeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public void setAdData(XAdNativeResponse xAdNativeResponse) {
        if (this.mAdView != null) {
            av.a(z.e, this.mAdView, this.mLoader, "setAdResponse", new Class[]{Object.class}, xAdNativeResponse);
        }
    }

    public void changeViewLayoutParams(Object obj) {
        if (this.mAdView != null) {
            av.a(z.e, this.mAdView, this.mLoader, "changeLayoutParams", new Class[]{Object.class}, obj);
        }
    }

    private void init(Context context) {
        this.mContext = context;
        this.mLoader = bt.a(context);
        View view = (View) av.a(z.e, this.mLoader, (Class<?>[]) new Class[]{Context.class}, context);
        this.mAdView = view;
        if (view != null) {
            addView(view, new RelativeLayout.LayoutParams(-2, -2));
        }
    }

    public int getAdContainerWidth() {
        if (this.mAdView != null) {
            Object objA = av.a(z.e, this.mAdView, this.mLoader, "getAdContainerWidth", new Class[0], new Object[0]);
            if (objA instanceof Number) {
                return ((Integer) objA).intValue();
            }
        }
        return 0;
    }

    public int getAdContainerHeight() {
        if (this.mAdView != null) {
            Object objA = av.a(z.e, this.mAdView, this.mLoader, "getAdContainerHeight", new Class[0], new Object[0]);
            if (objA instanceof Number) {
                return ((Integer) objA).intValue();
            }
        }
        return 0;
    }

    public RelativeLayout getContainerView() {
        if (this.mAdView != null) {
            return (RelativeLayout) av.a(z.e, this.mAdView, this.mLoader, "getAdView", new Class[0], new Object[0]);
        }
        return null;
    }
}
