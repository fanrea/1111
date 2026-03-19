package com.baidu.mobads.container.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.container.rewardvideo.RemoteRewardActivity;
import com.baidu.mobads.container.util.ab;
import com.component.a.g.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class t extends d.c {
    final /* synthetic */ com.baidu.mobads.container.adrequest.j a;
    final /* synthetic */ l b;

    t(l lVar, com.baidu.mobads.container.adrequest.j jVar) {
        this.b = lVar;
        this.a = jVar;
    }

    @Override // com.component.a.g.d.c
    public void a(View view, String str, String str2) {
        if ("video_view".equals(str2) && (view instanceof RelativeLayout)) {
            this.b.X = view;
            ((RelativeLayout) view).addView(this.b.b, 0, new RelativeLayout.LayoutParams(-1, -1));
            if (this.b.f()) {
                this.b.b.l();
            }
        }
        if (("video_cover".equals(str2) || "video_blur".equals(str2)) && (view instanceof ImageView)) {
            this.b.Y.add((ImageView) view);
        }
        if ("mute_view".equals(str2) && (view instanceof ImageView)) {
            if ("true".equals(this.a.getMute())) {
                this.b.a((ImageView) view);
            } else {
                this.b.b((ImageView) view);
            }
        }
        if ("brand_view".equals(str2) && (view instanceof TextView)) {
            this.b.u = (TextView) view;
        }
        if ("desc_view".equals(str2) && (view instanceof TextView)) {
            this.b.v = (TextView) view;
        }
        if (this.b.u != null && this.b.v != null && this.b.u.getText().toString().equals(this.b.v.getText().toString())) {
            this.b.u.setText("精选推荐");
        }
        if (RemoteRewardActivity.JSON_BANNER_RATING_ID.equals(str2) && (view instanceof TextView)) {
            ((TextView) view).setText(this.b.x + "");
        }
        if (str2 != null && str2.contains("recommend_view") && (view instanceof TextView)) {
            ((TextView) view).setText(this.b.g());
        }
        this.b.a(str2, view);
    }

    @Override // com.component.a.g.d.c
    public void a(View view, String str) {
        if ("volume".equals(str) && (view instanceof ImageView) && this.b.b != null) {
            if (this.b.b.g()) {
                this.b.b.b(false);
                this.b.b((ImageView) view);
            } else {
                this.b.b.b(true);
                this.b.a((ImageView) view);
            }
        }
        if ("privacy".equals(str) || "permission".equals(str)) {
            com.baidu.mobads.container.activity.e.a().a(this.b.c);
            if ("privacy".equals(str)) {
                com.baidu.mobads.container.activity.e.a().a(5);
                this.b.a(this.b.mAppContext);
            }
        }
        if (com.component.a.g.b.k.equals(str) && this.b.b != null && this.b.v()) {
            this.b.S = 4;
            this.b.a(this.b.S);
        }
        if ("ad_click".equals(str) && this.b.b != null && this.b.v() && this.b.mAdInstanceInfo != null) {
            ab.a aVarA = com.baidu.mobads.container.util.ab.a(this.b.mAppContext, this.b.mAdInstanceInfo);
            if (aVarA.equals(ab.a.LANDING_PAGE) || aVarA.equals(ab.a.DEEP_LINK)) {
                this.b.S = 1;
                this.b.a(this.b.S);
            }
        }
        if ("dismiss".equals(str)) {
            this.b.c();
        }
    }

    @Override // com.component.a.g.d.c
    public void a(com.component.a.f.d dVar) {
        if (com.component.a.g.c.bm.h.equals(dVar.d())) {
            if (this.b.g != null) {
                com.baidu.mobads.container.util.h.a(new u(this));
                this.b.mClickTracker.a(this.b.g);
            }
            this.b.mClickTracker.a(2);
            this.b.a(this.b.q);
            this.b.a(this.b.mAdInstanceInfo, dVar);
        }
    }
}
