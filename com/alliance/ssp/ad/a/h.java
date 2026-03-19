package com.alliance.ssp.ad.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.alliance.ssp.ad.activity.NMRewardVideoActivity;
import com.alliance.ssp.ad.o0.l;
import com.alliance.ssp.ad.r.i;

/* compiled from: NMRewardVideoActivity.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class h implements i.a {
    public final /* synthetic */ NMRewardVideoActivity a;

    public h(NMRewardVideoActivity nMRewardVideoActivity) {
        this.a = nMRewardVideoActivity;
    }

    @Override // com.alliance.ssp.ad.r.i.a
    public void a(String str, Bitmap bitmap) {
        ImageView imageView = this.a.g0;
        if (imageView != null) {
            imageView.setImageBitmap(NMRewardVideoActivity.a(bitmap, 80, 80, 16));
            this.a.i0.setImageBitmap(NMRewardVideoActivity.a(bitmap, 80, 80, 16));
            this.a.h0.setImageBitmap(NMRewardVideoActivity.a(bitmap, 80, 80, 16));
        }
    }

    @Override // com.alliance.ssp.ad.r.i.a
    public void a(String str, Exception exc) {
        int i = l.a;
    }
}
