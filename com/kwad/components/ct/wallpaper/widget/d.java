package com.kwad.components.ct.wallpaper.widget;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.p.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends FrameLayout {
    private SectorProgressView bap;
    private TextView baq;

    public d(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        m.a(getContext(), R.layout.ksad_progress_panel_layout, this, true);
        this.baq = (TextView) findViewById(R.id.ksad_progress_panel_text);
        SectorProgressView sectorProgressView = (SectorProgressView) findViewById(R.id.ksad_progress_panel_progress);
        this.bap = sectorProgressView;
        sectorProgressView.setCustomStrokeWidth(com.kwad.sdk.c.a.a.a(getContext(), 1.5f));
        this.bap.setOvalSpaceScale(3.33f);
    }

    public final void setProgress(int i) {
        this.bap.setPercent(i);
        this.baq.setText(String.format("%s%%", String.format(getContext().getString(R.string.ksad_progress_panel_text_format), Integer.valueOf(i))));
    }
}
