package com.bytedance.adsdk.ugeno.widget.scroll;

import android.content.Context;
import android.widget.ScrollView;
import com.bytedance.adsdk.ugeno.hc.d;
import com.bytedance.adsdk.ugeno.widget.frame.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends com.bytedance.adsdk.ugeno.hc.d<ScrollView> {
    public d(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    /* renamed from: xp, reason: merged with bridge method [inline-methods] */
    public ScrollView d() {
        UGScrollView uGScrollView = new UGScrollView(this.hc);
        uGScrollView.d(this);
        return uGScrollView;
    }

    @Override // com.bytedance.adsdk.ugeno.hc.d
    public d.C0176d gb() {
        return new d.C0179d(this);
    }
}
