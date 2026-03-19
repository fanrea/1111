package com.kwad.components.ad.feed.widget;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.utils.bh;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f extends b {
    public f(Context context) {
        super(context);
        setmIsShowComplianceView(false);
        setRadiusDp(4);
    }

    @Override // com.kwad.components.ad.feed.widget.b, com.kwad.components.core.widget.b
    public final void bB() {
        super.bB();
        View viewFindViewById = findViewById(R.id.ksad_feed_biserial_image);
        if (Build.VERSION.SDK_INT < 21 || viewFindViewById == null) {
            return;
        }
        viewFindViewById.setClipToOutline(true);
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_biserial_image;
    }

    @Override // com.kwad.components.core.widget.b
    public final void setMargin(int i) {
        if (com.kwad.sdk.core.config.e.YU()) {
            return;
        }
        setBackgroundColor(-1);
    }

    @Override // com.kwad.components.ad.feed.widget.b
    public final void cq() {
        this.ju.post(new bh() { // from class: com.kwad.components.ad.feed.widget.f.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                ViewGroup.LayoutParams layoutParams = f.this.jw.getLayoutParams();
                layoutParams.width = f.this.getWidth();
                f.this.jw.setRatio(1.7857142686843872d);
                f.this.jw.setLayoutParams(layoutParams);
                List<String> listBg = com.kwad.sdk.core.response.b.a.bg(f.this.mAdInfo);
                if (listBg.size() > 0) {
                    f.this.jm = SystemClock.elapsedRealtime();
                    KSImageLoader.loadFeeImage(f.this.ju, listBg.get(0), f.this.mAdTemplate, f.this.jr);
                    return;
                }
                com.kwad.sdk.core.d.c.e("FeedBiserialImageView", "getImageUrlList size less than one");
            }
        });
    }
}
