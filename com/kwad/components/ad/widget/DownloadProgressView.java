package com.kwad.components.ad.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DownloadProgressView extends FrameLayout {
    protected TextView Op;
    private int Oq;
    private int Or;
    private int Os;
    private int Ot;
    protected Drawable Ou;
    protected Drawable Ov;
    private String Ow;
    private final KsAppDownloadListener fJ;
    protected TextProgressBar hC;
    protected AdInfo mAdInfo;
    protected AdTemplate mAdTemplate;

    public DownloadProgressView(Context context) {
        this(context, null);
    }

    public DownloadProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadProgressView(Context context, AttributeSet attributeSet, int i) {
        super(m.wrapContextIfNeed(context), attributeSet, i);
        this.fJ = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.widget.DownloadProgressView.2
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                DownloadProgressView.this.Op.setText(com.kwad.sdk.core.response.b.a.aH(DownloadProgressView.this.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i2) {
                DownloadProgressView.this.Op.setVisibility(8);
                DownloadProgressView.this.hC.setVisibility(0);
                DownloadProgressView.this.hC.e(com.kwad.sdk.core.response.b.a.I(i2, DownloadProgressView.this.Ow), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                DownloadProgressView.this.Op.setVisibility(8);
                DownloadProgressView.this.hC.setVisibility(0);
                DownloadProgressView.this.hC.e(com.kwad.sdk.core.response.b.a.cB(DownloadProgressView.this.mAdTemplate), DownloadProgressView.this.hC.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                DownloadProgressView.this.Op.setText(com.kwad.sdk.core.response.b.a.aH(DownloadProgressView.this.mAdInfo));
                DownloadProgressView.this.Op.setVisibility(0);
                DownloadProgressView.this.hC.setVisibility(8);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                DownloadProgressView.this.Op.setVisibility(8);
                DownloadProgressView.this.hC.setVisibility(0);
                DownloadProgressView.this.hC.e(com.kwad.sdk.core.response.b.a.ae(DownloadProgressView.this.mAdInfo), DownloadProgressView.this.hC.getMax());
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i2) {
                DownloadProgressView.this.Op.setVisibility(8);
                DownloadProgressView.this.hC.setVisibility(0);
                DownloadProgressView.this.hC.e(com.kwad.sdk.core.response.b.a.abJ(), i2);
            }
        };
        initAttrs(context, attributeSet);
        initView();
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_DownloadProgressView);
        this.Oq = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadTextColor, -117146);
        this.Or = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadLeftTextColor, -1);
        this.Os = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadRightTextColor, -117146);
        this.Ot = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_DownloadProgressView_ksad_downloadTextSize, com.kwad.sdk.c.a.a.a(getContext(), 11.0f));
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ksad_DownloadProgressView_ksad_progressDrawable);
        this.Ou = drawable;
        if (drawable == null) {
            nS();
        }
        Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ksad_DownloadProgressView_ksad_backgroundDrawable);
        this.Ov = drawable2;
        if (drawable2 == null) {
            nT();
        }
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.ksad_DownloadProgressView_ksad_downloadingFormat);
        this.Ow = string;
        if (string == null) {
            this.Ow = "下载中  %s%%";
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    protected void nR() {
        m.inflate(getContext(), R.layout.ksad_download_progress_layout, this);
    }

    protected void nS() {
        this.Ou = getResources().getDrawable(R.drawable.ksad_feed_download_progress);
    }

    protected void nT() {
        this.Ov = getResources().getDrawable(R.drawable.ksad_feed_app_download_before_bg);
    }

    private void initView() {
        nR();
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_progress_bar);
        this.hC = textProgressBar;
        textProgressBar.setTextDimen(this.Ot);
        this.hC.setTextColor(this.Or, this.Os);
        this.hC.setProgressDrawable(this.Ou);
        TextView textView = (TextView) findViewById(R.id.ksad_normal_text);
        this.Op = textView;
        textView.setTextColor(this.Oq);
        this.Op.setTextSize(0, this.Ot);
        this.Op.setVisibility(0);
        this.Op.setBackground(this.Ov);
        findViewById(R.id.ksad_foreground_cover).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.widget.DownloadProgressView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadProgressView.this.performClick();
            }
        });
    }

    public final void au(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo adInfoEP = e.eP(adTemplate);
        this.mAdInfo = adInfoEP;
        this.Op.setText(com.kwad.sdk.core.response.b.a.aH(adInfoEP));
        this.hC.setVisibility(8);
        this.Op.setVisibility(0);
    }

    public KsAppDownloadListener getAppDownloadListener() {
        return this.fJ;
    }
}
