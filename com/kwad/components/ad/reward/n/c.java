package com.kwad.components.ad.reward.n;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSRatingBar;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.sdk.core.download.a.a implements com.kwad.sdk.widget.e {
    private Runnable DA;
    private View Dn;
    private View Do;
    private Button Dp;
    private Button Dq;
    private TextView Dr;
    private ImageView Ds;
    private TextView Dt;
    private TextView Du;
    private KSRatingBar Dv;
    private KsAppTagsView Dw;
    private a Dx;
    private volatile boolean Dy = false;
    private com.kwad.components.ad.j.a Dz;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    public interface a {
        void d(boolean z, int i);
    }

    @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadStarted() {
    }

    public c(View view) {
        this.Dn = view;
        initView();
        this.Dz = new com.kwad.components.ad.j.a(view);
    }

    private void initView() {
        this.Dp = (Button) this.Dn.findViewById(R.id.ksad_reward_apk_info_install_action);
        this.Dq = (Button) this.Dn.findViewById(R.id.ksad_reward_apk_info_install_start);
        this.Do = this.Dn.findViewById(R.id.ksad_reward_apk_info_install_container);
        this.Ds = (ImageView) this.Dn.findViewById(R.id.ksad_reward_apk_info_icon);
        this.Dr = (TextView) this.Dn.findViewById(R.id.ksad_reward_apk_info_name);
        this.Dt = (TextView) this.Dn.findViewById(R.id.ksad_reward_apk_info_desc);
        this.Dv = (KSRatingBar) this.Dn.findViewById(R.id.ksad_reward_apk_info_score);
        this.Dw = (KsAppTagsView) this.Dn.findViewById(R.id.ksad_reward_apk_info_tags);
    }

    public final void c(AdTemplate adTemplate, boolean z) {
        this.mAdTemplate = adTemplate;
        b bVarZ = b.Z(adTemplate);
        if (bVarZ == null) {
            return;
        }
        KSImageLoader.loadAppIcon(this.Ds, bVarZ.iconUrl, adTemplate, 12);
        this.Dr.setText(bVarZ.appName);
        this.Dt.setText(bVarZ.uM);
        this.Dv.setStar(bVarZ.DC);
        if (com.kwad.sdk.core.response.b.e.k(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.eP(adTemplate)))) {
            this.Dq.setText(com.kwad.sdk.core.response.b.a.aH(com.kwad.sdk.core.response.b.e.eP(adTemplate)));
            this.Dv.setVisibility(0);
        } else {
            this.Dq.setText("查看详情");
            this.Dv.setVisibility(8);
        }
        this.Dp.setText(bVarZ.lf());
        this.Dp.setClickable(true);
        this.Dq.setClickable(true);
        this.Do.setClickable(true);
        new com.kwad.sdk.widget.j(this.Dp, this);
        new com.kwad.sdk.widget.j(this.Dq, this);
        new com.kwad.sdk.widget.j(this.Do, this);
        List<String> list = bVarZ.DD;
        if (z && list.size() == 0) {
            this.Dt.setVisibility(8);
            TextView textView = (TextView) this.Dn.findViewById(R.id.ksad_reward_apk_info_desc_2);
            this.Du = textView;
            textView.setVisibility(0);
            this.Du.setText(bVarZ.uM);
        }
        if (list.size() == 0) {
            this.Dw.setVisibility(8);
        }
        this.Dw.setAppTags(list);
        if (this.DA == null) {
            this.DA = new Runnable() { // from class: com.kwad.components.ad.reward.n.c.1
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    com.kwad.sdk.core.d.c.d("ApkInfoCardViewHelper", hashCode() + " parentHeight: " + c.this.Do.getHeight());
                    if (c.this.Dy) {
                        return;
                    }
                    c.this.Dz.ji();
                }
            };
        }
        this.Do.postDelayed(this.DA, 1600L);
    }

    public final void a(com.kwad.components.core.e.d.c cVar) {
        this.mApkDownloadHelper = cVar;
        if (cVar != null) {
            cVar.b(this);
        }
    }

    public final void ld() {
        Runnable runnable;
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this);
        }
        com.kwad.components.ad.j.a aVar = this.Dz;
        if (aVar != null) {
            aVar.ld();
        }
        View view = this.Do;
        if (view == null || (runnable = this.DA) == null) {
            return;
        }
        view.removeCallbacks(runnable);
        this.DA = null;
    }

    public final void le() {
        this.Dz.nJ();
    }

    public final void a(a aVar) {
        this.Dx = aVar;
    }

    public final void j(String str, int i) {
        Button button = this.Dq;
        if (button == null || str == null || i == 0) {
            return;
        }
        button.setText(str);
    }

    @Override // com.kwad.sdk.widget.e
    public final void a(View view) {
        e(view, true);
    }

    @Override // com.kwad.sdk.widget.e
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.eE(this.mAdTemplate)) {
            e(view, false);
        }
    }

    private void e(View view, boolean z) {
        int id = view.getId();
        if (id == R.id.ksad_reward_apk_info_install_container || id == R.id.ksad_reward_apk_info_install_action || id == R.id.ksad_reward_apk_info_install_start) {
            com.kwad.sdk.core.d.c.d("ApkInfoCardViewHelper", "onClick install");
            this.Dy = true;
            a aVar = this.Dx;
            if (aVar != null) {
                aVar.d(z, 1);
            }
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onIdle() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.Dq.setText(adTemplate != null ? com.kwad.sdk.core.response.b.a.aH(com.kwad.sdk.core.response.b.e.eP(adTemplate)) : "立即下载");
    }

    @Override // com.kwad.sdk.core.download.a.a
    public final void onPaused(int i) {
        super.onPaused(i);
        if (i != 0) {
            this.Dz.nJ();
            this.Dq.setText(com.kwad.sdk.core.response.b.a.fv(i));
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onProgressUpdate(int i) {
        if (i != 0) {
            this.Dz.nJ();
            this.Dq.setText(com.kwad.sdk.core.response.b.a.ft(i));
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFinished() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.Dq.setText(adTemplate == null ? "" : com.kwad.sdk.core.response.b.a.cB(adTemplate));
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onInstalled() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.Dq.setText(adTemplate != null ? com.kwad.sdk.core.response.b.a.ae(com.kwad.sdk.core.response.b.e.eP(adTemplate)) : "立即打开");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFailed() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.Dq.setText(adTemplate != null ? com.kwad.sdk.core.response.b.a.aH(com.kwad.sdk.core.response.b.e.eP(adTemplate)) : "立即下载");
    }

    static class b {
        private float DC;
        private List<String> DD;
        private int DE = 15;
        private String DF;
        private String appName;
        private String iconUrl;
        private String uM;

        b() {
        }

        public static b Z(AdTemplate adTemplate) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
            b bVar = new b();
            if (com.kwad.sdk.core.response.b.e.P(adTemplate)) {
                bVar.appName = com.kwad.sdk.core.response.b.a.aA(adInfoEP);
            } else {
                bVar.appName = com.kwad.sdk.core.response.b.a.ay(adInfoEP);
            }
            bVar.DC = com.kwad.sdk.core.response.b.a.aF(adInfoEP);
            bVar.uM = com.kwad.sdk.core.response.b.a.aw(adInfoEP);
            if (com.kwad.sdk.core.response.b.e.P(adTemplate)) {
                bVar.iconUrl = com.kwad.sdk.core.response.b.a.dc(adInfoEP);
            } else {
                bVar.iconUrl = com.kwad.sdk.core.response.b.a.cC(adInfoEP);
            }
            if (com.kwad.sdk.core.response.b.e.k(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.eP(adTemplate)))) {
                bVar.DE = com.kwad.components.ad.reward.a.b.hF();
                bVar.DF = "安装并体验%s秒  可领取奖励";
            } else {
                bVar.DE = com.kwad.sdk.core.config.e.Yp();
                bVar.DF = "浏览详情页%s秒，领取奖励";
            }
            bVar.DD = com.kwad.sdk.core.response.b.d.eG(adTemplate);
            return bVar;
        }

        public final String lf() {
            return String.format(this.DF, Integer.valueOf(this.DE));
        }
    }
}
