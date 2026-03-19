package com.kwad.components.ct.wallpaper.c;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.View;
import android.widget.TextView;
import com.kwad.components.ct.c.a.b;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.request.e;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.wallpaper.widget.a;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bc;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.detail.b {
    private TextView aZJ;
    private com.kwad.components.ct.c.a aZK;
    private KsRewardVideoAd aZL;
    private long aZM;
    private com.kwad.components.core.k.a aoQ = new com.kwad.components.core.k.b() { // from class: com.kwad.components.ct.wallpaper.c.b.1
        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qy() {
            super.qy();
            com.kwad.components.ct.e.b.JK().m(b.this.aop.mAdTemplate, 196);
        }
    };
    private SlidePlayViewPager aok;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aZJ = (TextView) findViewById(R.id.ksad_photo_detail_wallpaper_enter);
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aok = this.aop.aok;
        this.aop.aoq.add(this.aoQ);
        this.aZJ.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.wallpaper.c.b.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (com.kwad.sdk.c.a.a.Wl()) {
                    return;
                }
                com.kwad.components.ct.e.b.JK().m(b.this.aop.mAdTemplate, 197);
                if (!com.kwad.components.ct.wallpaper.d.b.Lp()) {
                    ac.ae(b.this.getContext(), "抱歉，当前品牌手机暂不支持该功能");
                    return;
                }
                b.this.aok.h(false, 7);
                b bVar = b.this;
                bVar.aZM = ag.dR(bVar.getContext());
                if (b.this.aZM <= 0) {
                    b.this.Li();
                    b.this.aZK.aJ(b.this.getContext());
                    b.this.aZK.show();
                    com.kwad.components.ct.e.b.JK().JQ();
                    return;
                }
                b.this.Lj();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Li() {
        if (this.aZK != null) {
            return;
        }
        com.kwad.components.ct.c.a aVar = new com.kwad.components.ct.c.a(getContext(), new b.a() { // from class: com.kwad.components.ct.wallpaper.c.b.4
            @Override // com.kwad.components.ct.c.a.b.a
            public final void e(int i, long j) {
                if (i != 1 || j <= 0) {
                    return;
                }
                ag.i(b.this.getContext(), j);
                b.this.aZM = j;
                com.kwad.components.ct.e.b.JK().JR();
            }
        });
        this.aZK = aVar;
        aVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kwad.components.ct.wallpaper.c.b.5
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                if (b.this.aZM > 0) {
                    b.this.Lj();
                } else if (b.this.aok != null) {
                    b.this.aok.h(true, 7);
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aop.aoq.remove(this.aoQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lj() {
        com.kwad.components.ct.wallpaper.d.b.a(getActivity(), this.aop.mAdTemplate, "android.permission.WRITE_EXTERNAL_STORAGE", new com.kwad.components.core.u.a.b() { // from class: com.kwad.components.ct.wallpaper.c.b.6
            @Override // com.kwad.components.core.u.a.b
            public final void a(com.kwad.components.core.u.a.a aVar) {
                if (!aVar.abd) {
                    ac.ae(b.this.getContext(), "请开启存储权限，以正常设置壁纸，此选项可在手机设置中更改");
                    b.this.aok.h(true, 7);
                    com.kwad.sdk.core.d.c.d("PhotoWallpaperEnter", "checkStoragePermission permission is null granted ");
                } else {
                    com.kwad.sdk.core.d.c.d("PhotoWallpaperEnter", "checkStoragePermission permission is  " + aVar.abd);
                    b.this.Lk();
                }
            }
        });
    }

    public final void Lk() {
        if (com.kwad.components.ct.wallpaper.d.b.k(getActivity())) {
            com.kwad.components.ct.wallpaper.d.b.a(getActivity(), this.aop.mAdTemplate, new com.kwad.sdk.core.download.b() { // from class: com.kwad.components.ct.wallpaper.c.b.7
                @Override // com.kwad.sdk.core.download.b
                public final void a(DownloadTask downloadTask, int i, int i2) {
                    super.a(downloadTask, i, i2);
                    com.kwad.components.ct.e.b.JK().m(b.this.aop.mAdTemplate, 205);
                    b.this.aok.h(true, 7);
                }

                @Override // com.kwad.sdk.core.download.b
                public final void a(DownloadTask downloadTask, Throwable th) {
                    super.a(downloadTask, th);
                    com.kwad.components.ct.e.b.JK().m(b.this.aop.mAdTemplate, 205);
                    ac.ae(b.this.getContext(), "设置失败，请稍后重试");
                    b.this.aok.h(true, 7);
                }

                @Override // com.kwad.sdk.core.download.b
                public final void a(DownloadTask downloadTask) {
                    super.a(downloadTask);
                    com.kwad.components.ct.e.b.JK().m(b.this.aop.mAdTemplate, 205);
                    b.this.aok.h(true, 7);
                }

                @Override // com.kwad.sdk.core.download.b
                public final void b(DownloadTask downloadTask) {
                    super.b(downloadTask);
                    com.kwad.components.ct.e.b.JK().m(b.this.aop.mAdTemplate, 204);
                    b.this.aok.h(true, 7);
                }

                @Override // com.kwad.sdk.core.download.b
                public final void c(DownloadTask downloadTask) {
                    com.kwad.components.ct.e.b.JK().m(b.this.aop.mAdTemplate, 203);
                    super.c(downloadTask);
                }
            });
        } else {
            bh(this.aop.mAdTemplate);
            com.kwad.components.ct.wallpaper.d.b.b(getActivity(), this.aop.mAdTemplate, new com.kwad.sdk.core.download.b() { // from class: com.kwad.components.ct.wallpaper.c.b.8
                @Override // com.kwad.sdk.core.download.b
                public final void a(DownloadTask downloadTask, int i, int i2) {
                    super.a(downloadTask, i, i2);
                    ac.ae(b.this.getContext(), "设置失败，请稍后重试");
                    com.kwad.components.ct.e.b.JK().m(b.this.aop.mAdTemplate, 212);
                    b.this.aok.h(true, 7);
                }

                @Override // com.kwad.sdk.core.download.b
                public final void a(DownloadTask downloadTask, Throwable th) {
                    super.a(downloadTask, th);
                    ac.ae(b.this.getContext(), "设置失败，请稍后重试");
                    com.kwad.components.ct.e.b.JK().m(b.this.aop.mAdTemplate, 212);
                    b.this.aok.h(true, 7);
                }

                @Override // com.kwad.sdk.core.download.b
                public final void a(DownloadTask downloadTask) {
                    super.a(downloadTask);
                    ac.ae(b.this.getContext(), "设置失败，请稍后重试");
                    com.kwad.components.ct.e.b.JK().m(b.this.aop.mAdTemplate, 212);
                    b.this.aok.h(true, 7);
                }

                @Override // com.kwad.sdk.core.download.b
                public final void A(String str, String str2) {
                    super.A(str, str2);
                    com.kwad.components.ct.e.b.JK().m(b.this.aop.mAdTemplate, 211);
                    b.this.ci(str2);
                }

                @Override // com.kwad.sdk.core.download.b
                public final void c(DownloadTask downloadTask) {
                    super.c(downloadTask);
                    com.kwad.components.ct.e.b.JK().m(b.this.aop.mAdTemplate, 209);
                    com.kwad.components.ct.e.b.JK().m(b.this.aop.mAdTemplate, 210);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ci(final String str) {
        if (this.aZL == null) {
            com.kwad.components.ct.wallpaper.d.b.a(getActivity(), cj(str), Ln());
            this.aok.h(true, 7);
            return;
        }
        com.kwad.components.ct.wallpaper.widget.b bVar = new com.kwad.components.ct.wallpaper.widget.b();
        bVar.ZS = "下载成功";
        bVar.bah = "设置壁纸，请您观看一段广告";
        bVar.bag = "放弃";
        bVar.baf = "继续设置";
        bVar.bai = R.drawable.ksad_reward_dialog_image;
        new com.kwad.components.ct.wallpaper.widget.a(getActivity(), bVar, new a.InterfaceC0544a() { // from class: com.kwad.components.ct.wallpaper.c.b.9
            @Override // com.kwad.components.ct.wallpaper.widget.a.InterfaceC0544a
            public final void c(Dialog dialog) {
                dialog.dismiss();
                ac.ae(b.this.getContext(), "已取消");
                com.kwad.components.ct.e.b.JK().m(b.this.aop.mAdTemplate, 215);
                b.this.aok.h(true, 7);
            }

            /* JADX WARN: Removed duplicated region for block: B:9:0x0043  */
            @Override // com.kwad.components.ct.wallpaper.widget.a.InterfaceC0544a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void b(android.app.Dialog r4) {
                /*
                    r3 = this;
                    r4.dismiss()
                    com.kwad.components.ct.e.b r4 = com.kwad.components.ct.e.b.JK()
                    com.kwad.components.ct.wallpaper.c.b r0 = com.kwad.components.ct.wallpaper.c.b.this
                    com.kwad.components.ct.detail.c r0 = com.kwad.components.ct.wallpaper.c.b.D(r0)
                    com.kwad.components.ct.response.model.CtAdTemplate r0 = r0.mAdTemplate
                    r1 = 214(0xd6, float:3.0E-43)
                    r4.m(r0, r1)
                    com.kwad.components.ct.wallpaper.c.b r4 = com.kwad.components.ct.wallpaper.c.b.this
                    com.kwad.sdk.api.KsRewardVideoAd r4 = com.kwad.components.ct.wallpaper.c.b.E(r4)
                    if (r4 == 0) goto L5e
                    com.kwad.components.ct.wallpaper.c.b r4 = com.kwad.components.ct.wallpaper.c.b.this
                    com.kwad.sdk.api.KsRewardVideoAd r4 = com.kwad.components.ct.wallpaper.c.b.E(r4)
                    java.lang.Class<com.kwad.components.ad.b.h> r0 = com.kwad.components.ad.b.h.class
                    com.kwad.sdk.components.b r0 = com.kwad.sdk.components.d.g(r0)
                    com.kwad.components.ad.b.h r0 = (com.kwad.components.ad.b.h) r0
                    if (r0 == 0) goto L43
                    com.kwad.components.ad.b.h$a r0 = r0.V()
                    boolean r1 = r0.a(r4)
                    if (r1 == 0) goto L43
                    com.kwad.sdk.core.response.model.AdInfo r1 = r0.b(r4)
                    boolean r1 = com.kwad.sdk.core.response.b.a.co(r1)
                    r2 = 2
                    r0.a(r4, r2)
                    goto L44
                L43:
                    r1 = 0
                L44:
                    com.kwad.components.core.internal.api.VideoPlayConfigImpl r4 = new com.kwad.components.core.internal.api.VideoPlayConfigImpl
                    r4.<init>()
                    r4.setVideoSoundEnable(r1)
                    com.kwad.components.ct.wallpaper.c.b r0 = com.kwad.components.ct.wallpaper.c.b.this
                    com.kwad.sdk.api.KsRewardVideoAd r1 = com.kwad.components.ct.wallpaper.c.b.E(r0)
                    java.lang.String r2 = r2
                    com.kwad.components.ct.wallpaper.c.b.a(r0, r1, r4, r2)
                    com.kwad.components.ct.wallpaper.c.b r4 = com.kwad.components.ct.wallpaper.c.b.this
                    r0 = 0
                    com.kwad.components.ct.wallpaper.c.b.a(r4, r0)
                    return
                L5e:
                    com.kwad.components.ct.wallpaper.c.b r4 = com.kwad.components.ct.wallpaper.c.b.this
                    com.kwad.components.ct.detail.viewpager.SlidePlayViewPager r4 = com.kwad.components.ct.wallpaper.c.b.d(r4)
                    r0 = 1
                    r1 = 7
                    r4.h(r0, r1)
                    com.kwad.components.ct.wallpaper.c.b r4 = com.kwad.components.ct.wallpaper.c.b.this
                    android.app.Activity r4 = r4.getActivity()
                    com.kwad.components.ct.wallpaper.c.b r0 = com.kwad.components.ct.wallpaper.c.b.this
                    java.lang.String r1 = r2
                    java.lang.String r0 = com.kwad.components.ct.wallpaper.c.b.b(r0, r1)
                    com.kwad.components.ct.wallpaper.c.b r1 = com.kwad.components.ct.wallpaper.c.b.this
                    java.lang.String r1 = com.kwad.components.ct.wallpaper.c.b.F(r1)
                    com.kwad.components.ct.wallpaper.d.b.a(r4, r0, r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ct.wallpaper.c.b.AnonymousClass9.b(android.app.Dialog):void");
            }
        }).show();
        com.kwad.components.ct.e.b.JK().m(this.aop.mAdTemplate, 213);
    }

    private void bh(CtAdTemplate ctAdTemplate) {
        if (com.kwad.components.ct.wallpaper.a.b.Lh() && this.aZL == null) {
            e.a(ctAdTemplate, new KsLoadManager.RewardVideoAdListener() { // from class: com.kwad.components.ct.wallpaper.c.b.10
                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public final void onRewardVideoResult(List<KsRewardVideoAd> list) {
                }

                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public final void onError(int i, String str) {
                    b.this.aZL = null;
                }

                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public final void onRewardVideoAdLoad(List<KsRewardVideoAd> list) {
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    b.this.aZL = list.get(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(KsRewardVideoAd ksRewardVideoAd, KsVideoPlayConfig ksVideoPlayConfig, final String str) {
        this.aok.h(true, 7);
        if (ksRewardVideoAd != null && ksRewardVideoAd.isAdEnable()) {
            ksRewardVideoAd.setRewardAdInteractionListener(new KsRewardVideoAd.RewardAdInteractionListener() { // from class: com.kwad.components.ct.wallpaper.c.b.2
                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onAdClicked() {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onExtraRewardVerify(int i) {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onPageDismiss() {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onRewardStepVerify(int i, int i2) {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onRewardVerify(Map<String, Object> map) {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoPlayEnd() {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoPlayError(int i, int i2) {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoPlayStart() {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoSkipToEnd(long j) {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onRewardVerify() {
                    com.kwad.components.ct.wallpaper.d.b.a(b.this.getActivity(), b.this.cj(str), b.this.Ln());
                }
            });
            ksRewardVideoAd.showRewardVideoAd(getActivity(), ksVideoPlayConfig);
        } else {
            com.kwad.components.ct.wallpaper.d.b.a(getActivity(), cj(str), Ln());
        }
    }

    private static boolean Ll() {
        return (bc.anS() || bc.anT()) && Build.VERSION.SDK_INT > 29;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cj(String str) {
        return Ll() ? Lm() : str;
    }

    private String Lm() {
        CtAdTemplate ctAdTemplate = this.aop.mAdTemplate;
        if (com.kwad.components.ct.response.a.a.eH(ctAdTemplate)) {
            return com.kwad.sdk.core.response.b.a.L(com.kwad.components.ct.response.a.a.eP(ctAdTemplate));
        }
        return com.kwad.components.ct.response.a.c.d((PhotoInfo) com.kwad.components.ct.response.a.a.ay(ctAdTemplate));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Ln() {
        return String.valueOf(com.kwad.components.ct.response.a.c.j((PhotoInfo) com.kwad.components.ct.response.a.a.ay(this.aop.mAdTemplate)));
    }
}
