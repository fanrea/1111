package com.alliance.ssp.ad.a;

import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.alliance.ssp.ad.activity.AppInfoViewActivity;

/* compiled from: AppInfoViewActivity.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ ScrollView a;
    public final /* synthetic */ LinearLayout b;

    public c(AppInfoViewActivity appInfoViewActivity, ScrollView scrollView, LinearLayout linearLayout) {
        this.a = scrollView;
        this.b = linearLayout;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.a.getLayoutParams().height = this.b.getHeight();
        this.a.requestLayout();
    }
}
