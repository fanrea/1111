package com.kwad.components.ad.feed.widget;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.kwad.components.ad.feed.d;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.l.a;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.bc;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.c.y;
import com.kwad.components.core.widget.b;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.utils.ca;
import com.kwad.sdk.widget.KSFrameLayout;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class s extends com.kwad.components.core.widget.b<AdResultData, AdTemplate> implements com.kwad.sdk.widget.e {
    private KsAdVideoPlayConfig dG;
    private com.kwad.components.core.webview.tachikoma.b.o eL;
    private com.kwad.components.core.webview.tachikoma.i hF;
    private a.b ho;
    private d.b iY;
    private d.InterfaceC0409d iZ;
    private long jm;
    private float jn;
    private float jo;
    private b.a kI;
    private KSFrameLayout kS;
    private ba kT;
    private com.kwad.sdk.core.webview.c.c kU;
    private a kV;
    private FrameLayout.LayoutParams kW;
    private com.kwad.components.core.widget.b ky;
    private boolean kz;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private int mHeight;
    private boolean mIsNative;
    private int mWidth;

    public interface a {
        void d(int i, String str);
    }

    @Override // com.kwad.sdk.widget.e
    public final void a(View view) {
    }

    @Override // com.kwad.sdk.widget.e
    public final void b(View view) {
    }

    public s(Context context) {
        this(context, null);
    }

    private s(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private s(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        this.mWidth = getContext().getResources().getDisplayMetrics().widthPixels;
        this.mIsNative = false;
        this.kI = new b.a() { // from class: com.kwad.components.ad.feed.widget.s.9
            @Override // com.kwad.components.core.widget.b.a
            public final void onAdClicked() {
                if (s.this.akg != null) {
                    s.this.akg.onAdClicked();
                }
                com.kwad.components.ad.feed.monitor.b.a(s.this.mAdTemplate, 1, s.this.getStayTime());
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onAdShow() {
                if (s.this.mIsNative) {
                    if (s.this.akg != null) {
                        s.this.akg.onAdShow();
                    }
                    com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                    a.C0576a c0576a = new a.C0576a();
                    FeedType feedTypeFromInt = FeedType.fromInt(s.this.mAdTemplate.type, s.this.mAdTemplate.defaultType);
                    if (feedTypeFromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                        feedTypeFromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                    }
                    c0576a.templateId = String.valueOf(feedTypeFromInt.getType());
                    c0576a.bvk = String.valueOf(feedTypeFromInt.getFeedDefaultType() == null ? 0 : feedTypeFromInt.getFeedDefaultType().getDefaultType());
                    bVar.b(c0576a);
                    bVar.G(s.this.getHeight(), s.this.mWidth);
                    com.kwad.components.core.u.b.tq().a(s.this.mAdTemplate, null, bVar);
                    com.kwad.components.ad.feed.monitor.b.c(s.this.mAdTemplate, 1, 3);
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDislikeClicked() {
                if (s.this.akg != null) {
                    s.this.akg.onDislikeClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogShow() {
                if (s.this.akg != null) {
                    s.this.akg.onDownloadTipsDialogShow();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogDismiss() {
                if (s.this.akg != null) {
                    s.this.akg.onDownloadTipsDialogDismiss();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        int iA = com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.bzm);
        final WeakReference weakReference = new WeakReference(com.kwad.sdk.p.m.fb(context));
        this.hF = new com.kwad.components.core.webview.tachikoma.i(context, iA, iA);
        com.kwad.sdk.core.c.b.aaf();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.ad.feed.widget.s.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityDestroyed */
            public final void b(Activity activity) {
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 == null || !activity2.equals(activity)) {
                    return;
                }
                s.this.onRelease();
                com.kwad.sdk.core.c.b.aaf();
                com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRelease() {
        com.kwad.components.core.webview.tachikoma.i iVar = this.hF;
        if (iVar != null) {
            iVar.kD();
        }
        ba baVar = this.kT;
        if (baVar != null) {
            baVar.onDestroy();
        }
        d.InterfaceC0409d interfaceC0409d = this.iZ;
        if (interfaceC0409d != null) {
            com.kwad.components.ad.feed.d.a(interfaceC0409d);
        }
        d.b bVar = this.iY;
        if (bVar != null) {
            com.kwad.components.ad.feed.d.a(bVar);
        }
        com.kwad.components.ad.feed.d.D(this.mContext);
        com.kwad.components.ad.feed.d.E(this.mContext);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bB() {
        this.kS = (KSFrameLayout) findViewById(R.id.ksad_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cS() {
        if (this.kS != null) {
            this.kW = new FrameLayout.LayoutParams(this.kS.getLayoutParams());
        }
    }

    public final void setWidth(int i) {
        if (i <= 0) {
            i = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        this.mWidth = i;
    }

    public final void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.dG = ksAdVideoPlayConfig;
        cU();
        cV();
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.j.c
    public final void by() {
        super.by();
        com.kwad.components.core.l.a.qD().a(getCurrentVoiceItem());
        ba baVar = this.kT;
        if (baVar != null) {
            baVar.vh();
        }
        setLifeStatue("pageVisiable");
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.j.c
    public final void bz() {
        super.bz();
        ba baVar = this.kT;
        if (baVar != null) {
            baVar.vi();
            com.kwad.components.core.l.a.qD().c(this.ho);
        }
        setLifeStatue("pageInvisiable");
    }

    @Override // com.kwad.components.core.widget.b
    public final void d(AdResultData adResultData) {
        super.d((s) adResultData);
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        this.mApkDownloadHelper = cVar;
        cVar.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        this.jm = SystemClock.elapsedRealtime();
        if (com.kwad.sdk.core.response.b.b.dy(this.mAdTemplate) > 0.0d) {
            this.mHeight = (int) (this.mWidth * com.kwad.sdk.core.response.b.b.dy(this.mAdTemplate));
        } else {
            this.mHeight = this.kS.getHeight();
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.hF.a(com.kwad.sdk.p.m.fb(this.mContext), adResultData, new com.kwad.components.core.webview.tachikoma.j() { // from class: com.kwad.components.ad.feed.widget.s.5
            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(com.kwad.components.core.webview.tachikoma.b.p pVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(com.kwad.components.core.webview.tachikoma.c.n nVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(u uVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void aF() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void g(AdTemplate adTemplate) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final String getRegisterViewKey() {
                return "ksad-feed-card";
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final String getTKReaderScene() {
                return "tk_feed_tk_card";
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final com.kwad.sdk.widget.i getTouchCoordsView() {
                return null;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final String getTkTemplateId() {
                return com.kwad.sdk.core.response.b.b.et(s.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final FrameLayout getTKContainer() {
                s.this.cS();
                return s.this.kS;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(TKRenderFailReason tKRenderFailReason) {
                s.this.cW();
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void aE() {
                if (s.this.kV != null) {
                    s.this.kV.d(3, "");
                }
                com.kwad.sdk.core.d.c.d("TKFeedView", "TK load success, cost time: " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
                if (s.this.hF.vF()) {
                    return;
                }
                tVar.c(new com.kwad.components.core.webview.tachikoma.b.n() { // from class: com.kwad.components.ad.feed.widget.s.5.1
                    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
                    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar2) {
                        super.a(str, cVar2);
                        s.this.kU = cVar2;
                        s.this.cU();
                    }
                });
                tVar.c(new x() { // from class: com.kwad.components.ad.feed.widget.s.5.2
                    @Override // com.kwad.components.core.webview.jshandler.x
                    public final void b(y yVar) {
                        super.b(yVar);
                        if (com.kwad.components.core.u.a.aC(s.this.mContext).to() && s.this.eL != null) {
                            com.kwad.components.core.webview.tachikoma.c.n nVar = new com.kwad.components.core.webview.tachikoma.c.n();
                            nVar.ajg = true;
                            s.this.eL.c(nVar);
                        }
                        com.kwad.components.core.l.a.qD().a(s.this.getCurrentVoiceItem());
                        com.kwad.components.ad.feed.monitor.b.a(s.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.b.a.L(s.this.mAdInfo), null, SystemClock.elapsedRealtime() - s.this.jm);
                    }

                    @Override // com.kwad.components.core.webview.jshandler.x
                    public final void a(y yVar) {
                        super.a(yVar);
                        com.kwad.components.ad.feed.monitor.b.a(s.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.b.a.L(s.this.mAdInfo), yVar.errorReason, SystemClock.elapsedRealtime() - s.this.jm);
                        com.kwad.components.core.q.a.ss().g(s.this.mAdTemplate, yVar.errorCode, yVar.wg());
                    }

                    @Override // com.kwad.components.core.webview.jshandler.x
                    public final void c(y yVar) {
                        super.c(yVar);
                        com.kwad.components.core.l.a.qD().c(s.this.ho);
                    }
                });
                bc bcVar = new bc(new bc.a() { // from class: com.kwad.components.ad.feed.widget.s.5.3
                    @Override // com.kwad.components.core.webview.jshandler.bc.a
                    public final void cQ() {
                        s.this.cK();
                    }
                });
                ay ayVar = new ay(new ay.a() { // from class: com.kwad.components.ad.feed.widget.s.5.4
                    @Override // com.kwad.components.core.webview.jshandler.ay.a
                    public final void c(com.kwad.components.core.webview.tachikoma.f.d dVar) {
                        s.this.a(dVar);
                    }

                    @Override // com.kwad.components.core.webview.jshandler.ay.a
                    public final void d(com.kwad.components.core.webview.tachikoma.f.d dVar) {
                        s.this.b(dVar);
                    }

                    @Override // com.kwad.components.core.webview.jshandler.ay.a
                    public final void e(com.kwad.components.core.webview.tachikoma.f.d dVar) {
                        s.this.a(dVar);
                        s.this.b(dVar);
                    }
                });
                tVar.c(bcVar);
                tVar.c(ayVar);
                tVar.c(new z(bVar, s.this.mApkDownloadHelper, (com.kwad.sdk.core.webview.d.a.a) s.this.hF, true));
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (s.this.akg != null) {
                    s.this.akg.onAdClicked();
                }
                s.this.cL();
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(ae.a aVar) {
                aVar.width = com.kwad.sdk.c.a.a.px2dip(s.this.mContext, s.this.mWidth);
                aVar.height = com.kwad.sdk.c.a.a.px2dip(s.this.mContext, s.this.mHeight);
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(com.kwad.components.core.webview.tachikoma.b.o oVar) {
                s.this.eL = oVar;
                s.this.eL.a(new o.a() { // from class: com.kwad.components.ad.feed.widget.s.5.5
                    @Override // com.kwad.components.core.webview.tachikoma.b.o.a
                    public final boolean isMuted() {
                        return s.this.getMuteStatus();
                    }
                });
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(WebCloseStatus webCloseStatus) {
                if (s.this.kT != null) {
                    s.this.kT.vf();
                    s.this.kT.vg();
                }
                s.this.setLifeStatue("hideStart");
                s.this.setLifeStatue("hideEnd");
                bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.feed.widget.s.5.6
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        s.this.wy();
                    }
                });
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(ba baVar) {
                s.this.kT = baVar;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(a.C0490a c0490a) {
                if (s.this.akg != null) {
                    String str = c0490a.adW;
                    str.hashCode();
                    switch (str) {
                        case "adShowCallback":
                            s.this.akg.onAdShow();
                            break;
                        case "adDownloadConfirmTipCancel":
                        case "adDownloadConfirmTipDismiss":
                            s.this.akg.onDownloadTipsDialogDismiss();
                            break;
                        case "adCloseCallback":
                            s.this.akg.onDislikeClicked();
                            break;
                        case "adDownloadConfirmTipShow":
                            s.this.akg.onDownloadTipsDialogShow();
                            break;
                        case "adClickCallback":
                            s.this.akg.onAdClicked();
                            break;
                    }
                }
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void aG() {
                s.this.hF.a("setSensorMotionType", (String) null, new com.kwad.sdk.components.m() { // from class: com.kwad.components.ad.feed.widget.s.5.7
                    @Override // com.kwad.sdk.components.m
                    public final Object call(Object... objArr) {
                        if (objArr != null && objArr.length != 0) {
                            try {
                                Object obj = objArr[0];
                                if (obj instanceof Integer) {
                                    int iIntValue = ((Integer) obj).intValue();
                                    if (iIntValue == 1) {
                                        s.this.cX();
                                    } else if (iIntValue == 2) {
                                        s.this.cY();
                                    } else if (iIntValue == 3) {
                                        s.this.cX();
                                        s.this.cY();
                                    }
                                }
                            } catch (Throwable unused) {
                            }
                        }
                        return null;
                    }
                });
                s.this.cV();
                s.this.cT();
                s.this.bS();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bS() {
        com.kwad.components.core.webview.tachikoma.c.n nVar = new com.kwad.components.core.webview.tachikoma.c.n();
        nVar.ajg = getMuteStatus();
        this.hF.a("setVideoMuteStateListener", nVar.toJson().toString(), (com.kwad.sdk.components.m) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cT() {
        this.hF.a("setVideoPlayStatusCallback", (String) null, new com.kwad.components.core.webview.tachikoma.a.g() { // from class: com.kwad.components.ad.feed.widget.s.6
            @Override // com.kwad.components.core.webview.tachikoma.a.g
            public final void bU() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.g
            public final void bV() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.g
            public final void a(y yVar) {
                com.kwad.components.ad.feed.monitor.b.a(s.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.b.a.L(s.this.mAdInfo), yVar.errorReason, SystemClock.elapsedRealtime() - s.this.jm);
                com.kwad.components.core.q.a.ss().g(s.this.mAdTemplate, yVar.errorCode, yVar.wg());
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.g
            public final void bW() {
                com.kwad.components.core.l.a.qD().c(s.this.ho);
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.g
            public final void bX() {
                if (com.kwad.components.core.u.a.aC(s.this.mContext).to() && s.this.hF != null) {
                    com.kwad.components.core.webview.tachikoma.c.n nVar = new com.kwad.components.core.webview.tachikoma.c.n();
                    nVar.ajg = s.this.getMuteStatus();
                    s.this.hF.a("setVideoMuteStateListener", nVar.toJson().toString(), (com.kwad.sdk.components.m) null);
                }
                com.kwad.components.core.l.a.qD().a(s.this.getCurrentVoiceItem());
                com.kwad.components.ad.feed.monitor.b.a(s.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.b.a.L(s.this.mAdInfo), null, SystemClock.elapsedRealtime() - s.this.jm);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0044 A[PHI: r1
  0x0044: PHI (r1v4 boolean) = (r1v0 boolean), (r1v1 boolean), (r1v0 boolean), (r1v0 boolean) binds: [B:18:0x0040, B:20:0x0043, B:10:0x0021, B:5:0x0011] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean getMuteStatus() {
        /*
            r3 = this;
            boolean r0 = com.kwad.sdk.core.config.e.hG()
            r1 = 1
            if (r0 != 0) goto L14
            android.content.Context r0 = r3.mContext
            com.kwad.components.core.u.a r0 = com.kwad.components.core.u.a.aC(r0)
            boolean r0 = r0.to()
            if (r0 == 0) goto L14
            goto L44
        L14:
            com.kwad.components.core.l.a$b r0 = r3.ho
            if (r0 == 0) goto L24
            com.kwad.components.core.l.a.qD()
            com.kwad.components.core.l.a$b r0 = r3.ho
            boolean r0 = com.kwad.components.core.l.a.b(r0)
            if (r0 != 0) goto L24
            goto L44
        L24:
            com.kwad.sdk.api.KsAdVideoPlayConfig r0 = r3.dG
            boolean r2 = r0 instanceof com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl
            if (r2 == 0) goto L3a
            com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl r0 = (com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl) r0
            int r0 = r0.getVideoSoundValue()
            if (r0 == 0) goto L3a
            com.kwad.sdk.api.KsAdVideoPlayConfig r0 = r3.dG
            boolean r0 = r0.isVideoSoundEnable()
            r0 = r0 ^ r1
            goto L45
        L3a:
            com.kwad.sdk.core.response.model.AdInfo r0 = r3.mAdInfo
            boolean r0 = com.kwad.sdk.core.response.b.a.cj(r0)
            if (r0 != 0) goto L43
            goto L44
        L43:
            r1 = 0
        L44:
            r0 = r1
        L45:
            R extends com.kwad.sdk.core.response.model.AdTemplate r1 = r3.mAdTemplate
            if (r1 == 0) goto L4f
            R extends com.kwad.sdk.core.response.model.AdTemplate r1 = r3.mAdTemplate
            r2 = r0 ^ 1
            r1.mIsAudioEnable = r2
        L4f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.feed.widget.s.getMuteStatus():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cU() {
        if (this.kU == null) {
            return;
        }
        bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.feed.widget.s.7
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                com.kwad.components.core.webview.tachikoma.c.d dVar = new com.kwad.components.core.webview.tachikoma.c.d();
                boolean zIsNetworkConnected = ao.isNetworkConnected(s.this.mContext);
                boolean zIsWifiConnected = ao.isWifiConnected(s.this.mContext);
                if (s.this.dG instanceof KSAdVideoPlayConfigImpl) {
                    KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) s.this.dG;
                    dVar.aiW = s.this.a(zIsNetworkConnected, zIsWifiConnected, kSAdVideoPlayConfigImpl, kSAdVideoPlayConfigImpl.getVideoAutoPlayType());
                } else {
                    dVar.aiW = s.this.a(zIsNetworkConnected, zIsWifiConnected);
                }
                s.this.kU.a(dVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cV() {
        com.kwad.components.core.webview.tachikoma.i iVar = this.hF;
        if (iVar == null || iVar.vV() == null) {
            return;
        }
        bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.feed.widget.s.8
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                com.kwad.components.core.webview.tachikoma.c.d dVar = new com.kwad.components.core.webview.tachikoma.c.d();
                boolean zIsNetworkConnected = ao.isNetworkConnected(s.this.mContext);
                boolean zIsWifiConnected = ao.isWifiConnected(s.this.mContext);
                if (s.this.dG instanceof KSAdVideoPlayConfigImpl) {
                    KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) s.this.dG;
                    dVar.aiW = s.this.a(zIsNetworkConnected, zIsWifiConnected, kSAdVideoPlayConfigImpl, kSAdVideoPlayConfigImpl.getVideoAutoPlayType());
                } else {
                    dVar.aiW = s.this.a(zIsNetworkConnected, zIsWifiConnected);
                }
                if (s.this.hF != null) {
                    s.this.hF.a("setVideoAutoPlayListener", dVar.toJson().toString(), (com.kwad.sdk.components.m) null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(boolean z, boolean z2, KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl, int i) {
        if (i == 1) {
            return z;
        }
        if (i == 2) {
            return z2;
        }
        if (i == 3) {
            return false;
        }
        if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
            return kSAdVideoPlayConfigImpl.isDataFlowAutoStart() ? z : z2;
        }
        return a(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(boolean z, boolean z2) {
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate);
        if (com.kwad.sdk.core.response.b.a.cl(adInfoEP)) {
            return z;
        }
        if (com.kwad.sdk.core.response.b.a.cm(adInfoEP)) {
            return z2;
        }
        if (com.kwad.sdk.core.response.b.a.cn(adInfoEP)) {
            return false;
        }
        return com.kwad.sdk.core.config.e.Ym() ? z : z2;
    }

    @Override // com.kwad.components.core.widget.b
    public final void aa() {
        if (this.mAdTemplate.mPvReported || this.mAdTemplate.mHasAdShow) {
            return;
        }
        ba baVar = this.kT;
        if (baVar != null) {
            baVar.vd();
            this.kT.ve();
            com.kwad.components.ad.feed.monitor.b.c(this.mAdTemplate, 3, 3);
        }
        if (this.hF.vV() != null) {
            setLifeStatue("showStart");
            setLifeStatue("showEnd");
            com.kwad.components.ad.feed.monitor.b.c(this.mAdTemplate, 3, 3);
        }
        if (this.akg != null) {
            this.akg.onAdShow();
            this.mAdTemplate.mHasAdShow = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cW() {
        if (this.ky == null) {
            this.mIsNative = true;
            com.kwad.components.core.widget.b bVarA = com.kwad.components.ad.feed.b.a(this.mContext, FeedType.fromInt(this.mAdTemplate.type, this.mAdTemplate.defaultType), com.kwad.sdk.core.response.b.a.bk(this.mAdInfo));
            this.ky = bVarA;
            if (bVarA != null) {
                int iA = com.kwad.sdk.c.a.a.a(this.mContext, 16.0f);
                FrameLayout.LayoutParams layoutParams = this.kW;
                if (layoutParams != null) {
                    this.kS.setLayoutParams(layoutParams);
                }
                this.ky.setMargin(iA);
                this.kS.removeAllViews();
                this.ky.setInnerAdInteractionListener(this.kI);
                this.kS.addView(this.ky);
                a aVar = this.kV;
                if (aVar != null) {
                    aVar.d(1, "");
                }
                this.ky.d(this.mAdResultData);
                com.kwad.components.core.widget.b bVar = this.ky;
                if (bVar instanceof c) {
                    ((c) bVar).b(this.dG);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cL() {
        if (this.kz) {
            return;
        }
        this.kz = true;
        com.kwad.components.ad.feed.monitor.b.a(this.mAdTemplate, 3, getStayTime());
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_tkview;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (!com.kwad.sdk.core.config.e.Yz() || !com.kwad.sdk.core.response.b.d.eE(this.mAdTemplate)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (com.kwad.sdk.core.response.b.b.cI(this.mAdTemplate) == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        b(motionEvent);
        if ((action == 2 || action == 3) && this.kS != null && !this.mIsNative && Math.abs(motionEvent.getX() - this.jn) > 0.0f) {
            this.kS.requestDisallowInterceptTouchEvent(true);
            double dAbs = Math.abs(motionEvent.getX() - this.jn);
            double dAbs2 = Math.abs(motionEvent.getY() - this.jo);
            if (Math.tan(r1.maxRange) * dAbs < dAbs2 || Math.tan(r1.minRange) * dAbs < dAbs2) {
                this.kS.requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void ae() {
        super.ae();
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void af() {
        super.af();
    }

    private void b(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.jn = motionEvent.getX();
            this.jo = motionEvent.getY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.b getCurrentVoiceItem() {
        if (this.ho == null) {
            this.ho = new a.b(new a.c() { // from class: com.kwad.components.ad.feed.widget.s.10
                @Override // com.kwad.components.core.l.a.c
                public final void bK() {
                }
            });
        }
        return this.ho;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cK() {
        float fDv = com.kwad.sdk.core.response.b.b.dv(this.mAdTemplate);
        if (this.iZ == null) {
            this.iZ = new d.InterfaceC0409d() { // from class: com.kwad.components.ad.feed.widget.s.11
                @Override // com.kwad.components.ad.feed.d.InterfaceC0409d
                public final boolean e(final double d) {
                    if (!ca.v(s.this.kS, (int) (com.kwad.sdk.core.config.e.Yu() * 100.0f)) || !s.this.fv() || !com.kwad.components.ad.feed.d.cd()) {
                        return false;
                    }
                    com.kwad.components.core.e.d.a.a(new a.C0469a(s.this.getContext()).aC(s.this.mAdTemplate).b(s.this.mApkDownloadHelper).aG(2).aq(false).as(false).aF(157).aE(5).au(true).a(new a.b() { // from class: com.kwad.components.ad.feed.widget.s.11.1
                        @Override // com.kwad.components.core.e.d.a.b
                        public final void onAdClicked() {
                            com.kwad.sdk.core.d.c.d("TKFeedView", "convertEnable End" + com.kwad.sdk.core.response.b.e.eV(s.this.mAdTemplate));
                            com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                            bVar.o(d);
                            bVar.eP(157);
                            s.this.c(bVar);
                        }
                    }));
                    return true;
                }
            };
        }
        com.kwad.components.ad.feed.d.a(fDv, this.mContext, this.iZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cX() {
        AdMatrixInfo.RotateInfo rotateInfoDK = com.kwad.sdk.core.response.b.b.dK(this.mAdTemplate);
        if (this.iY == null) {
            this.iY = new d.b() { // from class: com.kwad.components.ad.feed.widget.s.12
                @Override // com.kwad.components.ad.feed.d.b
                public final boolean s(String str) {
                    if (!ca.v(s.this.kS, (int) (com.kwad.sdk.core.config.e.Yu() * 100.0f)) || !s.this.fv() || !com.kwad.components.ad.feed.d.cd()) {
                        return false;
                    }
                    s.this.hF.a("setSensorParams", new com.kwad.components.core.webview.tachikoma.c.i(1, str).toJson().toString(), (com.kwad.sdk.components.m) null);
                    return true;
                }
            };
        }
        com.kwad.components.ad.feed.d.a(rotateInfoDK, this.mContext, this.iY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cY() {
        float fDv = com.kwad.sdk.core.response.b.b.dv(this.mAdTemplate);
        if (this.iZ == null) {
            this.iZ = new d.InterfaceC0409d() { // from class: com.kwad.components.ad.feed.widget.s.2
                @Override // com.kwad.components.ad.feed.d.InterfaceC0409d
                public final boolean e(double d) {
                    if (!ca.v(s.this.kS, (int) (com.kwad.sdk.core.config.e.Yu() * 100.0f)) || !s.this.fv() || !com.kwad.components.ad.feed.d.cd()) {
                        return false;
                    }
                    s.this.hF.a("setSensorParams", new com.kwad.components.core.webview.tachikoma.c.i(2, Double.toString(d)).toJson().toString(), (com.kwad.sdk.components.m) null);
                    return true;
                }
            };
        }
        com.kwad.components.ad.feed.d.a(fDv, this.mContext, this.iZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.components.core.webview.tachikoma.f.d dVar) {
        float fDv = com.kwad.sdk.core.response.b.b.dv(this.mAdTemplate);
        if (this.iZ == null) {
            this.iZ = new d.InterfaceC0409d() { // from class: com.kwad.components.ad.feed.widget.s.3
                @Override // com.kwad.components.ad.feed.d.InterfaceC0409d
                public final boolean e(double d) {
                    if (!ca.v(s.this.kS, (int) (com.kwad.sdk.core.config.e.Yu() * 100.0f)) || !s.this.fv() || !com.kwad.components.ad.feed.d.cd()) {
                        return false;
                    }
                    dVar.p(2, Double.toString(d));
                    return true;
                }
            };
        }
        com.kwad.components.ad.feed.d.a(fDv, this.mContext, this.iZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.kwad.components.core.webview.tachikoma.f.d dVar) {
        AdMatrixInfo.RotateInfo rotateInfoDK = com.kwad.sdk.core.response.b.b.dK(this.mAdTemplate);
        if (this.iY == null) {
            this.iY = new d.b() { // from class: com.kwad.components.ad.feed.widget.s.4
                @Override // com.kwad.components.ad.feed.d.b
                public final boolean s(String str) {
                    if (!ca.v(s.this.kS, (int) (com.kwad.sdk.core.config.e.Yu() * 100.0f)) || !s.this.fv() || !com.kwad.components.ad.feed.d.cd()) {
                        return false;
                    }
                    dVar.p(1, str);
                    return true;
                }
            };
        }
        com.kwad.components.ad.feed.d.a(rotateInfoDK, this.mContext, this.iY);
    }

    public final void setLifeStatue(String str) {
        com.kwad.components.core.webview.tachikoma.i iVar = this.hF;
        if (iVar != null) {
            iVar.a("setLifeStatus", str, (com.kwad.sdk.components.m) null);
        }
    }

    public final void setTKLoadListener(a aVar) {
        a aVar2 = this.kV;
        if (aVar2 != null) {
            aVar2.d(this.mIsNative ? 1 : 3, "");
        }
        this.kV = aVar;
    }
}
