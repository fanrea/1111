package com.kwad.components.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.kwad.sdk.R;
import com.kwad.sdk.p.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class BiserialDownloadProgressView extends DownloadProgressView {
    public BiserialDownloadProgressView(Context context) {
        super(context);
    }

    public BiserialDownloadProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BiserialDownloadProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.kwad.components.ad.widget.DownloadProgressView
    protected final void nR() {
        m.inflate(getContext(), R.layout.ksad_download_progress_biserial_layout, this);
    }

    @Override // com.kwad.components.ad.widget.DownloadProgressView
    protected final void nS() {
        this.Ou = getResources().getDrawable(R.drawable.ksad_feed_download_progress_novel);
    }

    @Override // com.kwad.components.ad.widget.DownloadProgressView
    protected final void nT() {
        this.Ov = getResources().getDrawable(R.drawable.ksad_feed_actionbar_before_bg);
    }
}
