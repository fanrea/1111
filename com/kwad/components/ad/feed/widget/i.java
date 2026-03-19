package com.kwad.components.ad.feed.widget;

import android.content.Context;
import android.os.Build;
import android.view.View;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class i extends c {
    public i(Context context) {
        super(context);
        setRadiusDp(12);
    }

    @Override // com.kwad.components.ad.feed.widget.c, com.kwad.components.core.widget.b
    public final void bB() {
        super.bB();
        View viewFindViewById = findViewById(R.id.ksad_feed_novel_video);
        if (Build.VERSION.SDK_INT < 21 || viewFindViewById == null) {
            return;
        }
        viewFindViewById.setClipToOutline(true);
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_novel_regular_video;
    }

    @Override // com.kwad.components.core.widget.b
    public final void setMargin(int i) {
        if (com.kwad.sdk.core.config.e.YU()) {
            return;
        }
        setBackgroundColor(-1);
    }

    @Override // com.kwad.components.ad.feed.widget.c
    protected final void cw() {
        this.jE.setRatio(1.7857143f);
    }
}
