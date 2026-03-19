package com.sigmob.sdk.videoAd;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.utils.Dips;
import com.sigmob.sdk.base.views.y;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class h extends ImageView {
    private y a;
    private final int b;

    public h(final Context context) {
        super(context);
        y yVar = new y(context);
        this.a = yVar;
        setImageDrawable(yVar);
        this.b = Dips.dipsToIntPixels(2.0f, context);
    }

    public void a() {
        this.a.a();
        this.a.a(0);
    }

    public void a(final int progress) {
        this.a.a(progress);
    }

    public void a(final int duration, final int skipOffset) {
        this.a.a(duration, skipOffset);
        setVisibility(0);
    }

    @Deprecated
    y getImageViewDrawable() {
        return this.a;
    }

    public void setAnchorId(final int anchorId) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.b);
        layoutParams.addRule(8, anchorId);
        setLayoutParams(layoutParams);
    }

    @Deprecated
    void setImageViewDrawable(y drawable) {
        this.a = drawable;
    }
}
