package com.kwad.components.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.kwad.sdk.R;
import com.kwad.sdk.p.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class NovelDownloadProgressView extends DownloadProgressView {
    public NovelDownloadProgressView(Context context) {
        super(context);
    }

    public NovelDownloadProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NovelDownloadProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.kwad.components.ad.widget.DownloadProgressView
    protected final void nR() {
        m.inflate(getContext(), R.layout.ksad_download_progress_novel_layout, this);
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
