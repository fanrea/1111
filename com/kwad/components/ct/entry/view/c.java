package com.kwad.components.ct.entry.view;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends KSFrameLayout {
    private com.kwad.components.ct.response.model.a.a aCR;
    private h aDT;
    private RoundAngleImageView aDU;
    private CtAdTemplate mAdTemplate;

    public c(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.aDU = new RoundAngleImageView(getContext());
        float fA = com.kwad.sdk.c.a.a.a(getContext(), 4.0f);
        this.aDU.setRadius(new float[]{fA, fA, 0.0f, 0.0f, 0.0f, 0.0f, fA, fA});
        this.aDU.setScaleType(ImageView.ScaleType.MATRIX);
        addView(this.aDU, new FrameLayout.LayoutParams(-1, -1));
        h hVar = new h(getContext());
        this.aDT = hVar;
        hVar.setTextSize(12.0f);
        this.aDT.setGravity(17);
        this.aDT.setTextColor(Color.parseColor("#9C9C9C"));
        this.aDT.setText("点击查看更多视频");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.aDT.setLayoutParams(layoutParams);
        addView(this.aDT);
    }

    public final void setBlackStyle(boolean z) {
        if (z) {
            this.aDT.setBackgroundResource(R.drawable.ksad_entry_bg_black_selector);
        } else {
            this.aDT.setBackgroundResource(R.drawable.ksad_entry_bg_gray_selector);
        }
    }

    public final void j(CtAdTemplate ctAdTemplate) {
        this.mAdTemplate = ctAdTemplate;
        if (ctAdTemplate == null) {
            return;
        }
        com.kwad.sdk.glide.c.cy(getContext()).hh(com.kwad.components.ct.response.a.a.aE(ctAdTemplate)).b(this.aDU);
    }

    public final void setReportEntranceData(com.kwad.components.ct.response.model.a.a aVar) {
        this.aCR = aVar;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.m
    public final void E(View view) {
        super.E(view);
        com.kwad.components.ct.e.b.JK().d(this.aCR);
    }
}
