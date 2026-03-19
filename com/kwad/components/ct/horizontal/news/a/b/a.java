package com.kwad.components.ct.horizontal.news.a.b;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.horizontal.news.a.a.a implements View.OnClickListener {
    private TextView Fa;
    private TextView Pc;
    private KsLogoView aFP;
    private ImageView aFw;
    private ColorDrawable aMm;
    private ImageView aNF;
    private TextView abx;
    private View apQ;
    private KSFrameLayout awm;
    private KsAppDownloadListener fJ;
    private AdInfo mAdInfo;
    private CtAdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.awm = (KSFrameLayout) findViewById(R.id.ksad_news_item_root);
        this.Pc = (TextView) findViewById(R.id.ksad_news_item_title);
        this.aFw = (ImageView) findViewById(R.id.ksad_ad_cover_img);
        this.Fa = (TextView) findViewById(R.id.ksad_news_item_author_name);
        this.aFP = (KsLogoView) findViewById(R.id.ksad_news_item_ad_label);
        this.abx = (TextView) findViewById(R.id.ksad_news_item_convert_btn);
        this.aNF = (ImageView) findViewById(R.id.ksad_news_item_convert_icon);
        this.apQ = findViewById(R.id.ksad_news_item_close);
        this.aMm = com.kwad.sdk.c.a.a.k(getContext(), R.color.ksad_default_img_color);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        com.kwad.components.core.e.d.c cVar;
        super.ay();
        CtAdTemplate ctAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.horizontal.news.a.a.b) this.cdN).cdM;
        this.mAdTemplate = ctAdTemplate;
        this.mAdInfo = com.kwad.components.ct.response.a.a.eP(ctAdTemplate);
        this.mApkDownloadHelper = ((com.kwad.components.ct.horizontal.news.a.a.b) this.cdN).mApkDownloadHelper;
        String strAN = com.kwad.components.ct.response.a.a.aN(this.mAdTemplate);
        if (TextUtils.isEmpty(strAN)) {
            this.Pc.setVisibility(8);
        } else {
            this.Pc.setText(strAN);
            this.Pc.setVisibility(0);
        }
        com.kwad.sdk.glide.c.h(((com.kwad.components.ct.horizontal.news.a.a.b) this.cdN).alG).hh(com.kwad.components.ct.response.a.a.aE(this.mAdTemplate)).d(this.aMm).f(this.aMm).b(this.aFw);
        this.Fa.setText(com.kwad.components.ct.response.a.a.aL(this.mAdTemplate));
        this.aFP.aQ(this.mAdTemplate);
        this.abx.setText(com.kwad.sdk.core.response.b.a.aH(this.mAdInfo));
        int color = Color.parseColor(com.kwad.sdk.core.response.b.a.bD(this.mAdInfo));
        this.abx.setTextColor(color);
        if (com.kwad.sdk.core.response.b.a.aJ(this.mAdInfo)) {
            this.aNF.setImageResource(R.drawable.ksad_convert_app_small_icon_blue);
        } else {
            this.aNF.setImageResource(R.drawable.ksad_convert_h5_small_icon_blue);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.aNF.setImageTintList(ColorStateList.valueOf(color));
        }
        if (com.kwad.sdk.core.response.b.a.aJ(this.mAdInfo) && (cVar = this.mApkDownloadHelper) != null) {
            cVar.b(getAppDownloadListener());
        }
        this.Pc.setOnClickListener(this);
        this.Fa.setOnClickListener(this);
        this.abx.setOnClickListener(this);
        this.aNF.setOnClickListener(this);
        this.aFw.setOnClickListener(this);
        this.apQ.setOnClickListener(this);
        this.awm.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.fJ);
        }
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.fJ == null) {
            this.fJ = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ct.horizontal.news.a.b.a.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    a.this.abx.setText(com.kwad.sdk.core.response.b.a.aH(a.this.mAdInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    a.this.abx.setText("下载中..." + i + "%");
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i) {
                    super.onPaused(i);
                    a.this.abx.setText(com.kwad.sdk.core.response.b.a.fv(i));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    a.this.abx.setText(com.kwad.sdk.core.response.b.a.cB(a.this.mAdTemplate));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    a.this.abx.setText(com.kwad.sdk.core.response.b.a.aH(a.this.mAdInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    a.this.abx.setText(com.kwad.sdk.core.response.b.a.ae(a.this.mAdInfo));
                }
            };
        }
        return this.fJ;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.apQ) {
            ac.ae(getContext(), "操作成功，将减少此类推荐");
            com.kwad.sdk.core.adlog.c.cg(this.mAdTemplate);
            return;
        }
        if (view == this.Pc) {
            j(false, 122);
            return;
        }
        if (view == this.Fa) {
            j(false, 82);
            return;
        }
        if (view == this.abx || view == this.aNF) {
            j(true, 83);
        } else if (view == this.aFw) {
            j(false, 121);
        } else {
            j(false, 108);
        }
    }

    private void j(boolean z, int i) {
        com.kwad.components.core.e.d.a.a(new a.C0469a(getContext()).aC(this.mAdTemplate).b(this.mApkDownloadHelper).aG(2).aq(z).aF(i).d(this.awm.getTouchCoords()).as(true));
    }
}
