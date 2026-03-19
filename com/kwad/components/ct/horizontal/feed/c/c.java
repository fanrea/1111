package com.kwad.components.ct.horizontal.feed.c;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.view.KsRadiusStrokeTextView;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.core.widget.b<CtAdResultData, CtAdTemplate> implements View.OnClickListener {
    private com.kwad.sdk.core.download.a.a aNs;
    private KsRadiusStrokeTextView aNu;
    private TextView jt;
    private ImageView jv;
    private RoundAngleImageView ki;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private KsLogoView mLogoView;

    public c(Context context) {
        super(context);
        this.aNs = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ct.horizontal.feed.c.c.2
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                c.this.aNu.setText(c.o(com.kwad.sdk.core.response.b.a.aH(c.this.mAdInfo), 12));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                c.this.aNu.setText(c.o(com.kwad.sdk.core.response.b.a.fu(i), 12));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                c.this.aNu.setText(c.o(com.kwad.sdk.core.response.b.a.cB(c.this.mAdTemplate), 12));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                c.this.aNu.setText(c.o(com.kwad.sdk.core.response.b.a.ae(c.this.mAdInfo), 12));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                c.this.aNu.setText(c.o(com.kwad.sdk.core.response.b.a.aH(c.this.mAdInfo), 12));
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                c.this.aNu.setText(c.o(com.kwad.sdk.core.response.b.a.abJ(), 12));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.widget.b
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void d(CtAdResultData ctAdResultData) {
        String strAE;
        super.d((c) ctAdResultData);
        String strAw = com.kwad.sdk.core.response.b.a.aw(this.mAdInfo);
        if (bq.isNullString(strAw)) {
            strAw = getContext().getString(R.string.ksad_ad_default_adDescription_normal);
        }
        this.jt.setText(strAw);
        List<String> listBg = com.kwad.sdk.core.response.b.a.bg(this.mAdInfo);
        if (listBg.size() > 0) {
            strAE = listBg.get(0);
        } else {
            com.kwad.sdk.core.d.c.e("FeedContentTextRightImageView", "getImageUrlList size less than one");
            strAE = "";
        }
        if (TextUtils.isEmpty(strAE)) {
            strAE = com.kwad.components.ct.response.a.a.aE((CtAdTemplate) this.mAdTemplate);
            if (TextUtils.isEmpty(strAE)) {
                strAE = com.kwad.components.ct.response.a.a.aF((CtAdTemplate) this.mAdTemplate);
            }
        }
        com.kwad.sdk.glide.c.cy(getContext()).hh(strAE).d(new ColorDrawable(Color.parseColor("#F2F2F2"))).f(new ColorDrawable(Color.parseColor("#F2F2F2"))).b(this.ki);
        cs();
        this.jv.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.components.core.widget.b
    public final void cv() {
        super.cv();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.aNs);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.jv) {
            wy();
        } else {
            bX(view == this.aNu);
        }
    }

    private void bX(boolean z) {
        com.kwad.components.core.e.d.a.a(new a.C0469a(this.mContext).aC(this.mAdTemplate).aq(z).aG(2).as(true).d(getTouchCoords()).a(new a.b() { // from class: com.kwad.components.ct.horizontal.feed.c.c.1
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                c.this.wx();
            }
        }));
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_content_text_right_image;
    }

    @Override // com.kwad.components.core.widget.b
    public final void bB() {
        this.jt = (TextView) findViewById(R.id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.5600000023841858d);
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.ksad_ad_image);
        this.ki = roundAngleImageView;
        roundAngleImageView.setRadius(com.kwad.sdk.c.a.a.a(getContext(), 3.0f));
        this.jv = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.aNu = (KsRadiusStrokeTextView) findViewById(R.id.ksad_app_download_btn_text);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_feed_logo);
    }

    public static String o(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < str.length(); i4++) {
            char cCharAt = str.charAt(i4);
            i2 = cCharAt < 128 ? i2 + 1 : i2 + 2;
            if (12 == i2 || (cCharAt >= 128 && 13 == i2)) {
                i3 = i4;
            }
        }
        return i2 <= 12 ? str : str.substring(0, i3) + "...";
    }

    private void cs() {
        this.mLogoView.aQ(this.mAdTemplate);
        this.aNu.setTextColor(Color.parseColor("#222222"));
        this.aNu.setText(o(com.kwad.sdk.core.response.b.a.aH(this.mAdInfo), 12));
        int iA = com.kwad.sdk.c.a.a.a(getContext(), 2.0f);
        int iA2 = com.kwad.sdk.c.a.a.a(getContext(), 1.0f);
        this.aNu.b(iA, iA, iA, iA);
        this.aNu.J(iA2, Color.parseColor(com.kwad.sdk.core.response.b.a.bD(this.mAdInfo)));
        this.aNu.setTextColor(Color.parseColor(com.kwad.sdk.core.response.b.a.bD(this.mAdInfo)));
        this.aNu.setOnClickListener(this);
        if (com.kwad.sdk.core.response.b.a.aJ(this.mAdInfo)) {
            com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, this.aNs);
            this.mApkDownloadHelper = cVar;
            cVar.d(this.aNs);
        }
    }
}
