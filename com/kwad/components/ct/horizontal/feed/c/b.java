package com.kwad.components.ct.horizontal.feed.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.glide.load.resource.bitmap.p;
import com.kwad.sdk.utils.bx;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class b extends com.kwad.components.core.widget.b<CtAdResultData, CtAdTemplate> implements View.OnClickListener {
    private ImageView EZ;
    private TextView Fa;
    private ImageView aFB;
    private ImageView aFw;
    private ColorDrawable aMm;
    protected View aNp;
    private View aNq;
    private final Runnable aNr;
    private final com.kwad.sdk.core.download.a.a aNs;
    private TextView abx;
    private TextView jt;
    private ImageView jv;
    protected com.kwad.components.core.e.d.c mApkDownloadHelper;
    private KsLogoView mLogoView;
    private ImageView nh;

    protected int getDefaultConvertBg() {
        return 0;
    }

    public b(Context context) {
        super(context);
        this.aNr = new Runnable() { // from class: com.kwad.components.ct.horizontal.feed.c.b.1
            @Override // java.lang.Runnable
            public final void run() {
                b.this.aNq.setBackgroundColor(Color.parseColor(com.kwad.sdk.core.response.b.a.bD(b.this.mAdInfo)));
                if (com.kwad.sdk.core.response.b.a.aJ(b.this.mAdInfo)) {
                    b.this.nh.setImageResource(R.drawable.ksad_convert_app_icon_white);
                } else {
                    b.this.nh.setImageResource(R.drawable.ksad_convert_h5_icon_white);
                }
                b.this.abx.setTextColor(-1);
            }
        };
        this.aNs = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ct.horizontal.feed.c.b.2
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                b.this.abx.setText(com.kwad.sdk.core.response.b.a.aH(b.this.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                b.this.abx.setText(com.kwad.sdk.core.response.b.a.fu(i));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                b.this.abx.setText(com.kwad.sdk.core.response.b.a.cB(b.this.mAdTemplate));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                b.this.abx.setText(com.kwad.sdk.core.response.b.a.ae(b.this.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                b.this.abx.setText(com.kwad.sdk.core.response.b.a.aH(b.this.mAdInfo));
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                b.this.abx.setText(com.kwad.sdk.core.response.b.a.abJ());
            }
        };
    }

    @Override // com.kwad.components.core.widget.b
    public void bB() {
        this.jt = (TextView) findViewById(R.id.ksad_ad_desc);
        this.EZ = (ImageView) findViewById(R.id.ksad_ad_author_icon);
        this.Fa = (TextView) findViewById(R.id.ksad_ad_author_name);
        this.aNp = findViewById(R.id.ksad_ad_cover_container);
        this.aFB = (ImageView) findViewById(R.id.ksad_ad_cover_bg);
        this.aFw = (ImageView) findViewById(R.id.ksad_ad_cover_img);
        this.aNq = findViewById(R.id.ksad_ad_convert_container);
        this.abx = (TextView) findViewById(R.id.ksad_ad_convert_text);
        this.nh = (ImageView) findViewById(R.id.ksad_ad_convert_icon);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_ad_logo);
        this.jv = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.aMm = com.kwad.sdk.c.a.a.k(getContext(), R.color.ksad_default_img_color);
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.j.c
    public void by() {
        super.by();
        if (this.aNq != null) {
            bx.a(this.aNr, "", 2000L);
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.j.c
    public final void bz() {
        super.bz();
        if (this.aNq != null) {
            bx.d(this.aNr);
        }
    }

    @Override // com.kwad.components.core.widget.b
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void d(CtAdResultData ctAdResultData) throws Resources.NotFoundException {
        super.d((b) ctAdResultData);
        cs();
        this.mLogoView.aQ(com.kwad.sdk.core.response.b.c.s(ctAdResultData));
        this.jt.setOnClickListener(this);
        this.aNp.setOnClickListener(this);
        this.aNq.setOnClickListener(this);
        this.abx.setOnClickListener(this);
        ImageView imageView = this.EZ;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        this.Fa.setOnClickListener(this);
        this.jv.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.components.core.widget.b
    public void cv() {
        super.cv();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.aNs);
        }
    }

    public void onClick(View view) {
        if (view == this.jv) {
            wy();
            return;
        }
        if (view == this.jt) {
            j(false, 122);
            return;
        }
        if (view == this.EZ) {
            j(false, 13);
            return;
        }
        if (view == this.Fa) {
            j(false, 82);
            return;
        }
        if (view == this.abx || view == this.aNq) {
            j(true, 83);
        } else if (view == this.aNp) {
            j(false, 121);
        } else {
            j(false, 108);
        }
    }

    private void cs() throws Resources.NotFoundException {
        this.jt.setText(com.kwad.sdk.core.response.b.a.aw(this.mAdInfo));
        this.Fa.setText(com.kwad.components.ct.response.a.a.aL((CtAdTemplate) this.mAdTemplate));
        if (this.EZ != null) {
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon);
            com.kwad.sdk.glide.c.cy(getContext()).hh(com.kwad.components.ct.response.a.a.bf(this.mAdTemplate)).d(drawable).f(drawable).a(new p(1.0f, Color.parseColor("#eaeaea"))).b(this.EZ);
        }
        this.aNq.setBackgroundColor(getDefaultConvertBg());
        this.abx.setTextColor(Color.parseColor("#222222"));
        this.abx.setText(com.kwad.sdk.core.response.b.a.aH(this.mAdInfo));
        if (com.kwad.sdk.core.response.b.a.aJ(this.mAdInfo)) {
            this.nh.setImageResource(R.drawable.ksad_convert_app_icon_blank);
        } else {
            this.nh.setImageResource(R.drawable.ksad_convert_h5_icon_blank);
        }
        com.kwad.sdk.glide.c.cy(getContext()).hh(com.kwad.components.ct.response.a.a.be(this.mAdTemplate)).b(this.aFB);
        com.kwad.sdk.glide.c.cy(getContext()).hh(com.kwad.components.ct.response.a.a.aE((CtAdTemplate) this.mAdTemplate)).d(this.aMm).f(this.aMm).b(this.aFw);
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        this.mApkDownloadHelper = cVar;
        cVar.b(this.aNs);
        this.mApkDownloadHelper.d(this.aNs);
    }

    protected final void j(boolean z, int i) {
        com.kwad.components.core.e.d.a.a(new a.C0469a(getContext()).aC(this.mAdTemplate).aq(z).aG(2).as(true).aF(i).d(getTouchCoords()).a(new a.b() { // from class: com.kwad.components.ct.horizontal.feed.c.b.3
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                b.this.wx();
            }
        }));
    }
}
