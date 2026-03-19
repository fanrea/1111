package com.kwad.components.core.webview.tachikoma;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.u.j;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.components.core.webview.jshandler.ax;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.bd;
import com.kwad.components.core.webview.jshandler.be;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.b.s;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.b.v;
import com.kwad.components.core.webview.tachikoma.b.x;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.c.z;
import com.kwad.components.core.webview.tachikoma.d.e;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TKDownloadListener;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.components.offline.api.tk.model.report.TKPerformMsg;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.components.l;
import com.kwad.sdk.components.m;
import com.kwad.sdk.components.n;
import com.kwad.sdk.components.o;
import com.kwad.sdk.components.q;
import com.kwad.sdk.components.r;
import com.kwad.sdk.components.s;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.export.proxy.AdHttpBodyBuilder;
import com.kwad.sdk.export.proxy.AdHttpFormDataBuilder;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.utils.w;
import com.pandora.common.Constants;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class i implements com.kwad.components.core.e.e.f, q, com.kwad.sdk.core.view.f, com.kwad.sdk.core.webview.d.a.a {
    private static Map<Integer, WeakReference<com.kwad.components.core.webview.tachikoma.d.e>> ahB = new HashMap();
    private final z BC;
    protected long CF;
    private long KA;
    private StyleTemplate ZR;
    private long aaL;
    private long aaM;
    private ax adE;
    private com.kwad.sdk.core.download.e adF;
    private Map<String, Object> ahA;
    private int ahC;
    private int ahD;
    private boolean ahE;
    private String ahF;
    private String ahG;
    private boolean ahH;
    protected com.kwad.sdk.core.webview.d ahI;
    private o ahJ;
    private int ahK;
    private long ahL;
    private long ahM;
    private long ahN;
    private long ahO;
    private long ahP;
    private com.kwad.components.core.webview.tachikoma.a.e ahQ;
    private KsAdWebView.b ahR;
    private a ahS;
    private r ahT;
    private com.kwad.sdk.components.k ahU;
    private final Runnable ahV;
    private final Runnable ahW;
    private WeakReference<Activity> ahh;
    private com.kwad.components.core.webview.tachikoma.d.e ahi;
    protected j ahj;
    private com.kwad.sdk.core.webview.c.g ahk;
    private com.kwad.components.core.p.a.e.c ahl;
    private Future<?> ahm;
    private t ahn;
    private p aho;
    private az ahp;
    private bd ahq;
    private com.kwad.sdk.core.view.h ahr;
    private TextView ahs;
    private boolean aht;
    private boolean ahu;
    private boolean ahv;
    private boolean ahw;
    private boolean ahx;
    private int ahy;
    private long ahz;
    private ba gE;
    private final com.kwad.components.core.video.o lv;
    private AdResultData mAdResultData;
    protected final Context mContext;

    interface a {
        void onFailed();

        void onSuccess();
    }

    protected void a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, t tVar, ViewGroup viewGroup) {
    }

    protected void f(String str, String str2) {
    }

    protected void g(String str, String str2) {
    }

    protected boolean oX() {
        return false;
    }

    static /* synthetic */ boolean a(i iVar, boolean z) {
        iVar.aht = true;
        return true;
    }

    static /* synthetic */ boolean b(i iVar, boolean z) {
        iVar.ahu = true;
        return true;
    }

    static /* synthetic */ boolean c(i iVar, boolean z) {
        iVar.ahx = true;
        return true;
    }

    public i(Context context) {
        this(context, true);
    }

    public i(Context context, boolean z) {
        this.aht = false;
        this.ahu = false;
        this.ahv = false;
        this.ahw = false;
        this.ahx = false;
        this.ahy = 0;
        this.CF = -1L;
        this.ahC = 1000;
        this.ahD = 0;
        this.ahE = true;
        this.ahI = new com.kwad.sdk.core.webview.d();
        this.ahR = new KsAdWebView.b() { // from class: com.kwad.components.core.webview.tachikoma.i.1
            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                if (i.this.adE != null) {
                    i.this.adE.onSuccess();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                if (i.this.adE != null) {
                    i.this.adE.onFailed();
                }
            }
        };
        this.ahS = new a() { // from class: com.kwad.components.core.webview.tachikoma.i.47
            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onSuccess() {
                com.kwad.sdk.core.d.c.d("TKLoadController", "JS执行成功");
            }

            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onFailed() {
                i.this.b(TKRenderFailReason.RENDER_ERROR);
                com.kwad.sdk.core.d.c.d("TKLoadController", "JS执行失败");
            }
        };
        this.ahT = new r() { // from class: com.kwad.components.core.webview.tachikoma.i.4
            @Override // com.kwad.sdk.components.r
            public final void a(l lVar) {
                Activity activityVx = i.this.vx();
                if (activityVx == null) {
                    com.kwad.sdk.core.c.b.aaf();
                    activityVx = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (activityVx == null || activityVx.isFinishing()) {
                    lVar.callbackPageStatus(false, "no host activity");
                    return;
                }
                StyleTemplate styleTemplate = null;
                final String viewKey = lVar.getViewKey();
                if (viewKey == null) {
                    styleTemplate = new StyleTemplate();
                    try {
                        styleTemplate.parseJson(styleTemplate, new JSONObject(lVar.getStyleTemplate()));
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.c.printStackTrace(th);
                        lVar.callbackPageStatus(false, "template parse failed");
                        return;
                    }
                }
                e.b bVar = new e.b();
                bVar.a(i.this.mAdResultData);
                bVar.c(lVar);
                if (styleTemplate != null) {
                    bVar.a(styleTemplate);
                }
                if (viewKey != null) {
                    bVar.a(new k() { // from class: com.kwad.components.core.webview.tachikoma.i.4.1
                        @Override // com.kwad.components.core.webview.tachikoma.k
                        public final o a(Object... objArr) {
                            if (i.this.ahn != null) {
                                return i.this.ahn.a(viewKey, objArr);
                            }
                            return null;
                        }
                    });
                }
                com.kwad.components.core.webview.tachikoma.d.e eVarB = com.kwad.components.core.webview.tachikoma.d.e.b(bVar);
                eVarB.show(activityVx.getFragmentManager(), "");
                i.ahB.put(Integer.valueOf(lVar.getDialogId()), new WeakReference(eVarB));
            }

            @Override // com.kwad.sdk.components.r
            public final void b(l lVar) {
                WeakReference weakReference = (WeakReference) i.ahB.get(Integer.valueOf(lVar.getDialogId()));
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                ((com.kwad.components.core.webview.tachikoma.d.e) weakReference.get()).dismiss();
            }

            /* JADX WARN: Removed duplicated region for block: B:6:0x0011  */
            @Override // com.kwad.sdk.components.r
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void a(com.kwad.sdk.components.n r8) {
                /*
                    r7 = this;
                    com.kwad.components.core.webview.tachikoma.i r0 = com.kwad.components.core.webview.tachikoma.i.this
                    android.app.Activity r0 = com.kwad.components.core.webview.tachikoma.i.f(r0)
                    if (r0 == 0) goto L11
                    com.kwad.sdk.core.c.b.aaf()
                    android.app.Activity r1 = com.kwad.sdk.core.c.b.getCurrentActivity()
                    if (r0 == r1) goto L18
                L11:
                    com.kwad.sdk.core.c.b.aaf()
                    android.app.Activity r0 = com.kwad.sdk.core.c.b.getCurrentActivity()
                L18:
                    r1 = 0
                    if (r0 != 0) goto L21
                    java.lang.String r0 = "no host activity"
                    r8.callbackPageStatus(r1, r0)
                    return
                L21:
                    android.content.Intent r2 = r8.getIntent()
                    java.lang.Class<com.kwad.sdk.api.proxy.app.FeedDownloadActivity> r3 = com.kwad.sdk.api.proxy.app.FeedDownloadActivity.class
                    java.lang.String r4 = r8.getTemplateString()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 == 0) goto L62
                    java.lang.String r4 = r8.getViewKey()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 != 0) goto L3c
                    goto L62
                L3c:
                    java.lang.String r4 = r8.getClassName()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 != 0) goto Lb9
                    java.lang.String r4 = r8.getClassName()     // Catch: java.lang.ClassNotFoundException -> L59
                    java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.ClassNotFoundException -> L59
                    com.kwad.sdk.service.c.g(r3, r4)
                    com.kwad.components.core.webview.tachikoma.i r4 = com.kwad.components.core.webview.tachikoma.i.this
                    android.content.Context r4 = r4.mContext
                    r2.setClass(r4, r3)
                    goto Lb9
                L59:
                    r0 = move-exception
                    java.lang.String r0 = r0.getMessage()
                    r8.callbackPageStatus(r1, r0)
                    return
                L62:
                    java.lang.Class<com.kwad.components.core.t.a.a> r4 = com.kwad.components.core.t.a.a.class
                    com.kwad.sdk.service.c.g(r3, r4)
                    int r4 = com.kwad.components.core.t.a.a.th()
                    java.lang.String r5 = "native_intent"
                    com.kwad.components.core.t.a.a.a(r4, r5, r8)
                    com.kwad.components.core.webview.tachikoma.i r5 = com.kwad.components.core.webview.tachikoma.i.this
                    com.kwad.sdk.core.response.model.AdResultData r5 = com.kwad.components.core.webview.tachikoma.i.g(r5)
                    if (r5 == 0) goto L8b
                    com.kwad.components.core.c.f r5 = com.kwad.components.core.c.f.ot()
                    com.kwad.components.core.webview.tachikoma.i r6 = com.kwad.components.core.webview.tachikoma.i.this
                    com.kwad.sdk.core.response.model.AdResultData r6 = com.kwad.components.core.webview.tachikoma.i.g(r6)
                    int r5 = r5.l(r6)
                    java.lang.String r6 = "ad_result_cache_idx"
                    r2.putExtra(r6, r5)
                L8b:
                    java.lang.String r5 = r8.getTemplateString()
                    boolean r5 = android.text.TextUtils.isEmpty(r5)
                    if (r5 != 0) goto L9f
                    java.lang.String r5 = r8.getTemplateString()
                    java.lang.String r6 = "tk_style_template"
                    r2.putExtra(r6, r5)
                    goto Lad
                L9f:
                    java.lang.String r5 = r8.getViewKey()
                    com.kwad.components.core.webview.tachikoma.i$4$2 r6 = new com.kwad.components.core.webview.tachikoma.i$4$2
                    r6.<init>()
                    java.lang.String r5 = "tk_view_holder"
                    com.kwad.components.core.t.a.a.a(r4, r5, r6)
                Lad:
                    java.lang.String r5 = "tk_id"
                    r2.putExtra(r5, r4)
                    com.kwad.components.core.webview.tachikoma.i r4 = com.kwad.components.core.webview.tachikoma.i.this
                    android.content.Context r4 = r4.mContext
                    r2.setClass(r4, r3)
                Lb9:
                    java.lang.String r3 = r8.getUrl()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 != 0) goto Le5
                    java.lang.String r3 = r8.getUrl()
                    android.net.Uri r3 = android.net.Uri.parse(r3)
                    r2.setData(r3)
                    java.lang.String r3 = "adCacheId"
                    int r3 = r2.getIntExtra(r3, r1)
                    if (r3 <= 0) goto Le5
                    com.kwad.sdk.core.response.model.AdResultData r3 = com.kwad.components.core.p.a.e.a.a.aO(r3)
                    com.kwad.sdk.core.response.model.AdTemplate r3 = com.kwad.sdk.core.response.b.c.s(r3)
                    com.kwad.components.core.proxy.launchdialog.e r4 = com.kwad.components.core.proxy.launchdialog.e.sq()
                    r4.aG(r3)
                Le5:
                    r0.startActivity(r2)     // Catch: java.lang.Throwable -> Lee
                    r0 = 1
                    r2 = 0
                    r8.callbackPageStatus(r0, r2)     // Catch: java.lang.Throwable -> Lee
                    return
                Lee:
                    r0 = move-exception
                    com.kwad.sdk.core.d.c.printStackTraceOnly(r0)
                    java.lang.String r0 = r0.getMessage()
                    r8.callbackPageStatus(r1, r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.webview.tachikoma.i.AnonymousClass4.a(com.kwad.sdk.components.n):void");
            }
        };
        this.ahU = new com.kwad.sdk.components.k() { // from class: com.kwad.components.core.webview.tachikoma.i.5
            @Override // com.kwad.sdk.components.k
            public final com.kwad.sdk.components.j bp(int i) {
                return i.this.aO(com.kwad.sdk.core.response.b.c.s(com.kwad.components.core.p.a.e.a.a.aO(i)));
            }

            @Override // com.kwad.sdk.components.k
            public final com.kwad.sdk.components.j bn(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    AdTemplate adTemplate = new AdTemplate();
                    adTemplate.parseJson(jSONObject);
                    return i.this.aO(adTemplate);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                    return null;
                }
            }
        };
        this.ahV = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.7
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.c.d("TKLoadController", "已经超时" + i.this.ahj.getTkTemplateId());
                i.this.vS();
                i.a(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.ahW = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.8
            @Override // java.lang.Runnable
            public final void run() {
                i.b(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.lv = new com.kwad.components.core.video.o() { // from class: com.kwad.components.core.webview.tachikoma.i.39
            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPreparing() {
                j(0.0d);
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayProgress(long j, long j2) {
                j(j2);
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayStart() {
                j(0.0d);
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayCompleted() {
                i.this.BC.Yk = true;
                i.this.BC.ajo = false;
                i.this.BC.sp = com.kwad.sdk.core.response.b.a.M(com.kwad.sdk.core.response.b.e.eP(i.this.vL()));
                ki();
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayError(int i, int i2) {
                i.this.BC.ajo = true;
                i.this.BC.Yk = false;
                ki();
            }

            private void j(double d) {
                i.this.BC.ajo = false;
                i.this.BC.Yk = false;
                i.this.BC.sp = (int) ((d / 1000.0d) + 0.5d);
                ki();
            }

            private void ki() {
                if (i.this.aho == null || i.this.BC == null) {
                    return;
                }
                i.this.aho.a(i.this.BC);
            }
        };
        this.mContext = context;
        this.CF = -1L;
        this.ahC = 1000;
        this.ahE = z;
        this.BC = new z();
    }

    public i(long j, Context context) {
        this.aht = false;
        this.ahu = false;
        this.ahv = false;
        this.ahw = false;
        this.ahx = false;
        this.ahy = 0;
        this.CF = -1L;
        this.ahC = 1000;
        this.ahD = 0;
        this.ahE = true;
        this.ahI = new com.kwad.sdk.core.webview.d();
        this.ahR = new KsAdWebView.b() { // from class: com.kwad.components.core.webview.tachikoma.i.1
            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                if (i.this.adE != null) {
                    i.this.adE.onSuccess();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                if (i.this.adE != null) {
                    i.this.adE.onFailed();
                }
            }
        };
        this.ahS = new a() { // from class: com.kwad.components.core.webview.tachikoma.i.47
            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onSuccess() {
                com.kwad.sdk.core.d.c.d("TKLoadController", "JS执行成功");
            }

            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onFailed() {
                i.this.b(TKRenderFailReason.RENDER_ERROR);
                com.kwad.sdk.core.d.c.d("TKLoadController", "JS执行失败");
            }
        };
        this.ahT = new r() { // from class: com.kwad.components.core.webview.tachikoma.i.4
            @Override // com.kwad.sdk.components.r
            public final void a(l lVar) {
                Activity activityVx = i.this.vx();
                if (activityVx == null) {
                    com.kwad.sdk.core.c.b.aaf();
                    activityVx = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (activityVx == null || activityVx.isFinishing()) {
                    lVar.callbackPageStatus(false, "no host activity");
                    return;
                }
                StyleTemplate styleTemplate = null;
                final String viewKey = lVar.getViewKey();
                if (viewKey == null) {
                    styleTemplate = new StyleTemplate();
                    try {
                        styleTemplate.parseJson(styleTemplate, new JSONObject(lVar.getStyleTemplate()));
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.c.printStackTrace(th);
                        lVar.callbackPageStatus(false, "template parse failed");
                        return;
                    }
                }
                e.b bVar = new e.b();
                bVar.a(i.this.mAdResultData);
                bVar.c(lVar);
                if (styleTemplate != null) {
                    bVar.a(styleTemplate);
                }
                if (viewKey != null) {
                    bVar.a(new k() { // from class: com.kwad.components.core.webview.tachikoma.i.4.1
                        @Override // com.kwad.components.core.webview.tachikoma.k
                        public final o a(Object... objArr) {
                            if (i.this.ahn != null) {
                                return i.this.ahn.a(viewKey, objArr);
                            }
                            return null;
                        }
                    });
                }
                com.kwad.components.core.webview.tachikoma.d.e eVarB = com.kwad.components.core.webview.tachikoma.d.e.b(bVar);
                eVarB.show(activityVx.getFragmentManager(), "");
                i.ahB.put(Integer.valueOf(lVar.getDialogId()), new WeakReference(eVarB));
            }

            @Override // com.kwad.sdk.components.r
            public final void b(l lVar) {
                WeakReference weakReference = (WeakReference) i.ahB.get(Integer.valueOf(lVar.getDialogId()));
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                ((com.kwad.components.core.webview.tachikoma.d.e) weakReference.get()).dismiss();
            }

            @Override // com.kwad.sdk.components.r
            public final void a(n v) {
                /*
                    this = this;
                    com.kwad.components.core.webview.tachikoma.i r0 = com.kwad.components.core.webview.tachikoma.i.this
                    android.app.Activity r0 = com.kwad.components.core.webview.tachikoma.i.f(r0)
                    if (r0 == 0) goto L11
                    com.kwad.sdk.core.c.b.aaf()
                    android.app.Activity r1 = com.kwad.sdk.core.c.b.getCurrentActivity()
                    if (r0 == r1) goto L18
                L11:
                    com.kwad.sdk.core.c.b.aaf()
                    android.app.Activity r0 = com.kwad.sdk.core.c.b.getCurrentActivity()
                L18:
                    r1 = 0
                    if (r0 != 0) goto L21
                    java.lang.String r0 = "no host activity"
                    r8.callbackPageStatus(r1, r0)
                    return
                L21:
                    android.content.Intent r2 = r8.getIntent()
                    java.lang.Class<com.kwad.sdk.api.proxy.app.FeedDownloadActivity> r3 = com.kwad.sdk.api.proxy.app.FeedDownloadActivity.class
                    java.lang.String r4 = r8.getTemplateString()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 == 0) goto L62
                    java.lang.String r4 = r8.getViewKey()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 != 0) goto L3c
                    goto L62
                L3c:
                    java.lang.String r4 = r8.getClassName()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 != 0) goto Lb9
                    java.lang.String r4 = r8.getClassName()     // Catch: java.lang.ClassNotFoundException -> L59
                    java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.ClassNotFoundException -> L59
                    com.kwad.sdk.service.c.g(r3, r4)
                    com.kwad.components.core.webview.tachikoma.i r4 = com.kwad.components.core.webview.tachikoma.i.this
                    android.content.Context r4 = r4.mContext
                    r2.setClass(r4, r3)
                    goto Lb9
                L59:
                    r0 = move-exception
                    java.lang.String r0 = r0.getMessage()
                    r8.callbackPageStatus(r1, r0)
                    return
                L62:
                    java.lang.Class<com.kwad.components.core.t.a.a> r4 = com.kwad.components.core.t.a.a.class
                    com.kwad.sdk.service.c.g(r3, r4)
                    int r4 = com.kwad.components.core.t.a.a.th()
                    java.lang.String r5 = "native_intent"
                    com.kwad.components.core.t.a.a.a(r4, r5, r8)
                    com.kwad.components.core.webview.tachikoma.i r5 = com.kwad.components.core.webview.tachikoma.i.this
                    com.kwad.sdk.core.response.model.AdResultData r5 = com.kwad.components.core.webview.tachikoma.i.g(r5)
                    if (r5 == 0) goto L8b
                    com.kwad.components.core.c.f r5 = com.kwad.components.core.c.f.ot()
                    com.kwad.components.core.webview.tachikoma.i r6 = com.kwad.components.core.webview.tachikoma.i.this
                    com.kwad.sdk.core.response.model.AdResultData r6 = com.kwad.components.core.webview.tachikoma.i.g(r6)
                    int r5 = r5.l(r6)
                    java.lang.String r6 = "ad_result_cache_idx"
                    r2.putExtra(r6, r5)
                L8b:
                    java.lang.String r5 = r8.getTemplateString()
                    boolean r5 = android.text.TextUtils.isEmpty(r5)
                    if (r5 != 0) goto L9f
                    java.lang.String r5 = r8.getTemplateString()
                    java.lang.String r6 = "tk_style_template"
                    r2.putExtra(r6, r5)
                    goto Lad
                L9f:
                    java.lang.String r5 = r8.getViewKey()
                    com.kwad.components.core.webview.tachikoma.i$4$2 r6 = new com.kwad.components.core.webview.tachikoma.i$4$2
                    r6.<init>()
                    java.lang.String r5 = "tk_view_holder"
                    com.kwad.components.core.t.a.a.a(r4, r5, r6)
                Lad:
                    java.lang.String r5 = "tk_id"
                    r2.putExtra(r5, r4)
                    com.kwad.components.core.webview.tachikoma.i r4 = com.kwad.components.core.webview.tachikoma.i.this
                    android.content.Context r4 = r4.mContext
                    r2.setClass(r4, r3)
                Lb9:
                    java.lang.String r3 = r8.getUrl()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 != 0) goto Le5
                    java.lang.String r3 = r8.getUrl()
                    android.net.Uri r3 = android.net.Uri.parse(r3)
                    r2.setData(r3)
                    java.lang.String r3 = "adCacheId"
                    int r3 = r2.getIntExtra(r3, r1)
                    if (r3 <= 0) goto Le5
                    com.kwad.sdk.core.response.model.AdResultData r3 = com.kwad.components.core.p.a.e.a.a.aO(r3)
                    com.kwad.sdk.core.response.model.AdTemplate r3 = com.kwad.sdk.core.response.b.c.s(r3)
                    com.kwad.components.core.proxy.launchdialog.e r4 = com.kwad.components.core.proxy.launchdialog.e.sq()
                    r4.aG(r3)
                Le5:
                    r0.startActivity(r2)     // Catch: java.lang.Throwable -> Lee
                    r0 = 1
                    r2 = 0
                    r8.callbackPageStatus(r0, r2)     // Catch: java.lang.Throwable -> Lee
                    return
                Lee:
                    r0 = move-exception
                    com.kwad.sdk.core.d.c.printStackTraceOnly(r0)
                    java.lang.String r0 = r0.getMessage()
                    r8.callbackPageStatus(r1, r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.webview.tachikoma.i.AnonymousClass4.a(com.kwad.sdk.components.n):void");
            }
        };
        this.ahU = new com.kwad.sdk.components.k() { // from class: com.kwad.components.core.webview.tachikoma.i.5
            @Override // com.kwad.sdk.components.k
            public final com.kwad.sdk.components.j bp(int i) {
                return i.this.aO(com.kwad.sdk.core.response.b.c.s(com.kwad.components.core.p.a.e.a.a.aO(i)));
            }

            @Override // com.kwad.sdk.components.k
            public final com.kwad.sdk.components.j bn(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    AdTemplate adTemplate = new AdTemplate();
                    adTemplate.parseJson(jSONObject);
                    return i.this.aO(adTemplate);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                    return null;
                }
            }
        };
        this.ahV = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.7
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.c.d("TKLoadController", "已经超时" + i.this.ahj.getTkTemplateId());
                i.this.vS();
                i.a(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.ahW = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.8
            @Override // java.lang.Runnable
            public final void run() {
                i.b(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.lv = new com.kwad.components.core.video.o() { // from class: com.kwad.components.core.webview.tachikoma.i.39
            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPreparing() {
                j(0.0d);
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayProgress(long j2, long j22) {
                j(j22);
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayStart() {
                j(0.0d);
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayCompleted() {
                i.this.BC.Yk = true;
                i.this.BC.ajo = false;
                i.this.BC.sp = com.kwad.sdk.core.response.b.a.M(com.kwad.sdk.core.response.b.e.eP(i.this.vL()));
                ki();
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayError(int i, int i2) {
                i.this.BC.ajo = true;
                i.this.BC.Yk = false;
                ki();
            }

            private void j(double d) {
                i.this.BC.ajo = false;
                i.this.BC.Yk = false;
                i.this.BC.sp = (int) ((d / 1000.0d) + 0.5d);
                ki();
            }

            private void ki() {
                if (i.this.aho == null || i.this.BC == null) {
                    return;
                }
                i.this.aho.a(i.this.BC);
            }
        };
        this.mContext = context;
        this.CF = j;
        this.BC = new z();
    }

    public i(Context context, int i, int i2) {
        this.aht = false;
        this.ahu = false;
        this.ahv = false;
        this.ahw = false;
        this.ahx = false;
        this.ahy = 0;
        this.CF = -1L;
        this.ahC = 1000;
        this.ahD = 0;
        this.ahE = true;
        this.ahI = new com.kwad.sdk.core.webview.d();
        this.ahR = new KsAdWebView.b() { // from class: com.kwad.components.core.webview.tachikoma.i.1
            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                if (i.this.adE != null) {
                    i.this.adE.onSuccess();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                if (i.this.adE != null) {
                    i.this.adE.onFailed();
                }
            }
        };
        this.ahS = new a() { // from class: com.kwad.components.core.webview.tachikoma.i.47
            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onSuccess() {
                com.kwad.sdk.core.d.c.d("TKLoadController", "JS执行成功");
            }

            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onFailed() {
                i.this.b(TKRenderFailReason.RENDER_ERROR);
                com.kwad.sdk.core.d.c.d("TKLoadController", "JS执行失败");
            }
        };
        this.ahT = new r() { // from class: com.kwad.components.core.webview.tachikoma.i.4
            @Override // com.kwad.sdk.components.r
            public final void a(l lVar) {
                Activity activityVx = i.this.vx();
                if (activityVx == null) {
                    com.kwad.sdk.core.c.b.aaf();
                    activityVx = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (activityVx == null || activityVx.isFinishing()) {
                    lVar.callbackPageStatus(false, "no host activity");
                    return;
                }
                StyleTemplate styleTemplate = null;
                final String viewKey = lVar.getViewKey();
                if (viewKey == null) {
                    styleTemplate = new StyleTemplate();
                    try {
                        styleTemplate.parseJson(styleTemplate, new JSONObject(lVar.getStyleTemplate()));
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.c.printStackTrace(th);
                        lVar.callbackPageStatus(false, "template parse failed");
                        return;
                    }
                }
                e.b bVar = new e.b();
                bVar.a(i.this.mAdResultData);
                bVar.c(lVar);
                if (styleTemplate != null) {
                    bVar.a(styleTemplate);
                }
                if (viewKey != null) {
                    bVar.a(new k() { // from class: com.kwad.components.core.webview.tachikoma.i.4.1
                        @Override // com.kwad.components.core.webview.tachikoma.k
                        public final o a(Object... objArr) {
                            if (i.this.ahn != null) {
                                return i.this.ahn.a(viewKey, objArr);
                            }
                            return null;
                        }
                    });
                }
                com.kwad.components.core.webview.tachikoma.d.e eVarB = com.kwad.components.core.webview.tachikoma.d.e.b(bVar);
                eVarB.show(activityVx.getFragmentManager(), "");
                i.ahB.put(Integer.valueOf(lVar.getDialogId()), new WeakReference(eVarB));
            }

            @Override // com.kwad.sdk.components.r
            public final void b(l lVar) {
                WeakReference weakReference = (WeakReference) i.ahB.get(Integer.valueOf(lVar.getDialogId()));
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                ((com.kwad.components.core.webview.tachikoma.d.e) weakReference.get()).dismiss();
            }

            @Override // com.kwad.sdk.components.r
            public final void a(n v) {
                /*
                    this = this;
                    com.kwad.components.core.webview.tachikoma.i r0 = com.kwad.components.core.webview.tachikoma.i.this
                    android.app.Activity r0 = com.kwad.components.core.webview.tachikoma.i.f(r0)
                    if (r0 == 0) goto L11
                    com.kwad.sdk.core.c.b.aaf()
                    android.app.Activity r1 = com.kwad.sdk.core.c.b.getCurrentActivity()
                    if (r0 == r1) goto L18
                L11:
                    com.kwad.sdk.core.c.b.aaf()
                    android.app.Activity r0 = com.kwad.sdk.core.c.b.getCurrentActivity()
                L18:
                    r1 = 0
                    if (r0 != 0) goto L21
                    java.lang.String r0 = "no host activity"
                    r8.callbackPageStatus(r1, r0)
                    return
                L21:
                    android.content.Intent r2 = r8.getIntent()
                    java.lang.Class<com.kwad.sdk.api.proxy.app.FeedDownloadActivity> r3 = com.kwad.sdk.api.proxy.app.FeedDownloadActivity.class
                    java.lang.String r4 = r8.getTemplateString()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 == 0) goto L62
                    java.lang.String r4 = r8.getViewKey()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 != 0) goto L3c
                    goto L62
                L3c:
                    java.lang.String r4 = r8.getClassName()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 != 0) goto Lb9
                    java.lang.String r4 = r8.getClassName()     // Catch: java.lang.ClassNotFoundException -> L59
                    java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.ClassNotFoundException -> L59
                    com.kwad.sdk.service.c.g(r3, r4)
                    com.kwad.components.core.webview.tachikoma.i r4 = com.kwad.components.core.webview.tachikoma.i.this
                    android.content.Context r4 = r4.mContext
                    r2.setClass(r4, r3)
                    goto Lb9
                L59:
                    r0 = move-exception
                    java.lang.String r0 = r0.getMessage()
                    r8.callbackPageStatus(r1, r0)
                    return
                L62:
                    java.lang.Class<com.kwad.components.core.t.a.a> r4 = com.kwad.components.core.t.a.a.class
                    com.kwad.sdk.service.c.g(r3, r4)
                    int r4 = com.kwad.components.core.t.a.a.th()
                    java.lang.String r5 = "native_intent"
                    com.kwad.components.core.t.a.a.a(r4, r5, r8)
                    com.kwad.components.core.webview.tachikoma.i r5 = com.kwad.components.core.webview.tachikoma.i.this
                    com.kwad.sdk.core.response.model.AdResultData r5 = com.kwad.components.core.webview.tachikoma.i.g(r5)
                    if (r5 == 0) goto L8b
                    com.kwad.components.core.c.f r5 = com.kwad.components.core.c.f.ot()
                    com.kwad.components.core.webview.tachikoma.i r6 = com.kwad.components.core.webview.tachikoma.i.this
                    com.kwad.sdk.core.response.model.AdResultData r6 = com.kwad.components.core.webview.tachikoma.i.g(r6)
                    int r5 = r5.l(r6)
                    java.lang.String r6 = "ad_result_cache_idx"
                    r2.putExtra(r6, r5)
                L8b:
                    java.lang.String r5 = r8.getTemplateString()
                    boolean r5 = android.text.TextUtils.isEmpty(r5)
                    if (r5 != 0) goto L9f
                    java.lang.String r5 = r8.getTemplateString()
                    java.lang.String r6 = "tk_style_template"
                    r2.putExtra(r6, r5)
                    goto Lad
                L9f:
                    java.lang.String r5 = r8.getViewKey()
                    com.kwad.components.core.webview.tachikoma.i$4$2 r6 = new com.kwad.components.core.webview.tachikoma.i$4$2
                    r6.<init>()
                    java.lang.String r5 = "tk_view_holder"
                    com.kwad.components.core.t.a.a.a(r4, r5, r6)
                Lad:
                    java.lang.String r5 = "tk_id"
                    r2.putExtra(r5, r4)
                    com.kwad.components.core.webview.tachikoma.i r4 = com.kwad.components.core.webview.tachikoma.i.this
                    android.content.Context r4 = r4.mContext
                    r2.setClass(r4, r3)
                Lb9:
                    java.lang.String r3 = r8.getUrl()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 != 0) goto Le5
                    java.lang.String r3 = r8.getUrl()
                    android.net.Uri r3 = android.net.Uri.parse(r3)
                    r2.setData(r3)
                    java.lang.String r3 = "adCacheId"
                    int r3 = r2.getIntExtra(r3, r1)
                    if (r3 <= 0) goto Le5
                    com.kwad.sdk.core.response.model.AdResultData r3 = com.kwad.components.core.p.a.e.a.a.aO(r3)
                    com.kwad.sdk.core.response.model.AdTemplate r3 = com.kwad.sdk.core.response.b.c.s(r3)
                    com.kwad.components.core.proxy.launchdialog.e r4 = com.kwad.components.core.proxy.launchdialog.e.sq()
                    r4.aG(r3)
                Le5:
                    r0.startActivity(r2)     // Catch: java.lang.Throwable -> Lee
                    r0 = 1
                    r2 = 0
                    r8.callbackPageStatus(r0, r2)     // Catch: java.lang.Throwable -> Lee
                    return
                Lee:
                    r0 = move-exception
                    com.kwad.sdk.core.d.c.printStackTraceOnly(r0)
                    java.lang.String r0 = r0.getMessage()
                    r8.callbackPageStatus(r1, r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.webview.tachikoma.i.AnonymousClass4.a(com.kwad.sdk.components.n):void");
            }
        };
        this.ahU = new com.kwad.sdk.components.k() { // from class: com.kwad.components.core.webview.tachikoma.i.5
            @Override // com.kwad.sdk.components.k
            public final com.kwad.sdk.components.j bp(int i3) {
                return i.this.aO(com.kwad.sdk.core.response.b.c.s(com.kwad.components.core.p.a.e.a.a.aO(i3)));
            }

            @Override // com.kwad.sdk.components.k
            public final com.kwad.sdk.components.j bn(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    AdTemplate adTemplate = new AdTemplate();
                    adTemplate.parseJson(jSONObject);
                    return i.this.aO(adTemplate);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                    return null;
                }
            }
        };
        this.ahV = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.7
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.c.d("TKLoadController", "已经超时" + i.this.ahj.getTkTemplateId());
                i.this.vS();
                i.a(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.ahW = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.8
            @Override // java.lang.Runnable
            public final void run() {
                i.b(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.lv = new com.kwad.components.core.video.o() { // from class: com.kwad.components.core.webview.tachikoma.i.39
            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPreparing() {
                j(0.0d);
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayProgress(long j2, long j22) {
                j(j22);
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayStart() {
                j(0.0d);
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayCompleted() {
                i.this.BC.Yk = true;
                i.this.BC.ajo = false;
                i.this.BC.sp = com.kwad.sdk.core.response.b.a.M(com.kwad.sdk.core.response.b.e.eP(i.this.vL()));
                ki();
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayError(int i3, int i22) {
                i.this.BC.ajo = true;
                i.this.BC.Yk = false;
                ki();
            }

            private void j(double d) {
                i.this.BC.ajo = false;
                i.this.BC.Yk = false;
                i.this.BC.sp = (int) ((d / 1000.0d) + 0.5d);
                ki();
            }

            private void ki() {
                if (i.this.aho == null || i.this.BC == null) {
                    return;
                }
                i.this.aho.a(i.this.BC);
            }
        };
        this.mContext = context;
        this.ahC = i;
        this.BC = new z();
        this.ahD = i2;
    }

    public final void a(StyleTemplate styleTemplate) {
        this.ZR = styleTemplate;
    }

    public final com.kwad.sdk.core.webview.b vw() {
        return this.ahI;
    }

    public void a(Activity activity, AdResultData adResultData, j jVar) {
        this.ahh = new WeakReference<>(activity);
        this.mAdResultData = adResultData;
        this.ahI.a(adResultData);
        this.ahj = jVar;
        this.ahF = jVar.getTkTemplateId();
        this.ahG = this.ahj.getTKReaderScene();
        vG();
        FrameLayout tKContainer = this.ahj.getTKContainer();
        if (tKContainer != null) {
            tKContainer.removeAllViews();
        }
        if (!com.kwad.sdk.core.config.e.Yc()) {
            b(TKRenderFailReason.SWITCH_CLOSE);
            return;
        }
        this.ahl = (com.kwad.components.core.p.a.e.c) com.kwad.sdk.components.d.g(com.kwad.components.core.p.a.e.c.class);
        vN();
        com.kwad.sdk.core.d.c.d("TKLoadController", "bind mTKPlugin: " + this.ahl);
        if (TextUtils.isEmpty(this.ahF)) {
            com.kwad.sdk.commercial.e.a.e(vL(), this.ahG);
        }
        if (this.ahl != null) {
            if (vE()) {
                vy();
                return;
            } else {
                vH();
                return;
            }
        }
        b(TKRenderFailReason.PLUGIN_NOT_READY);
        f(this.ahF, TKPerformMsg.ERROR_REASON.KSAD_TK_OFFLINE_FAILED);
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.ahy).setRenderState(4).setErrorReason(TKPerformMsg.ERROR_REASON.KSAD_TK_OFFLINE_FAILED).setTemplateId(this.ahF).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity vx() {
        WeakReference<Activity> weakReference = this.ahh;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.ahh.get();
    }

    private void vy() {
        StyleTemplate styleTemplateVJ = vJ();
        if (styleTemplateVJ == null) {
            bj("no template");
            return;
        }
        int iB = b(styleTemplateVJ);
        this.ahK = iB;
        try {
            t tVarA = com.kwad.components.core.u.j.a(Integer.valueOf(iB));
            if (tVarA != null) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.ahz = jElapsedRealtime;
                this.ahO = jElapsedRealtime;
                a(tVarA);
                return;
            }
            if (com.kwad.components.core.webview.tachikoma.e.b.wo().bu(this.ahK)) {
                vH();
            } else {
                this.ahL = SystemClock.elapsedRealtime();
                com.kwad.components.core.webview.tachikoma.e.b.wo().a(this.ahK, new com.kwad.components.core.webview.tachikoma.f.f() { // from class: com.kwad.components.core.webview.tachikoma.i.12
                    @Override // com.kwad.components.core.webview.tachikoma.f.f
                    public final void vY() {
                        i.this.c(TKRenderFailReason.RENDER_ERROR);
                        i.this.bm(TKPerformMsg.ERROR_REASON.KSAD_TK_RENDER_FAIL);
                    }

                    @Override // com.kwad.components.core.webview.tachikoma.f.f
                    public final void vZ() {
                        j.a aVarB = com.kwad.components.core.u.j.b(Integer.valueOf(i.this.ahK));
                        t tVarTD = aVarB.tD();
                        i.this.aaL = aVarB.tz();
                        i.this.aaM = aVarB.tB();
                        i.this.KA = aVarB.tA();
                        i.this.ahM = aVarB.tC();
                        i.this.ahz = SystemClock.elapsedRealtime();
                        i iVar = i.this;
                        iVar.ahO = iVar.ahz;
                        i.this.vz();
                        i.this.a(tVarTD);
                    }
                });
            }
        } catch (Exception e) {
            b(TKRenderFailReason.RENDER_ERROR);
            bm(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vz() {
        long j = this.ahL;
        long j2 = this.ahM;
        if (j >= j2) {
            this.aaL = 0L;
            this.aaM = 0L;
            this.KA = 0L;
            this.ahN = 0L;
            return;
        }
        long j3 = this.aaM;
        long j4 = this.aaL;
        if (j >= j3 + j4) {
            this.aaL = 0L;
            this.aaM = 0L;
            this.KA = 0L;
            this.ahN = j2 - j;
            this.ahz = j2;
            return;
        }
        if (j3 >= j && j >= this.KA) {
            this.KA = j;
        } else if (j3 + j4 > j) {
            this.aaL = (j3 + j4) - this.KA;
            this.aaM = 0L;
            this.KA = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(t tVar) {
        try {
            if (this.ZR == null) {
                this.ZR = vJ();
            }
            if (tVar == null) {
                return;
            }
            this.ahn = tVar;
            vO();
            int iHashCode = this.mAdResultData.hashCode();
            com.kwad.components.core.p.a.e.a.a.a(iHashCode, this.mAdResultData);
            this.mAdResultData.mAdCacheId = iHashCode;
            com.kwad.sdk.core.d.c.d("TKLoadController", "renderTKTemplate tachikomaContext is not null");
            o oVarA = tVar.a(this.ahj.getRegisterViewKey(), new ag.a(this.mAdResultData).toJson().toString(), vB(), vA());
            this.ahJ = oVarA;
            vC();
            View view = oVarA.getView();
            if (view != null) {
                FrameLayout tKContainer = this.ahj.getTKContainer();
                if (tKContainer != 0 && this.ahE) {
                    if (tKContainer instanceof com.kwad.sdk.core.view.h) {
                        com.kwad.sdk.core.view.h hVar = (com.kwad.sdk.core.view.h) tKContainer;
                        this.ahr = hVar;
                        hVar.getWindowFocusChangeHelper().a(this);
                    }
                    view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    tKContainer.addView(view);
                }
                d(vJ());
                vW();
                return;
            }
            com.kwad.components.core.u.j.c(Integer.valueOf(this.ahK));
            b(TKRenderFailReason.RENDER_ERROR);
            bm(TKPerformMsg.ERROR_REASON.KSAD_TK_RENDER_FAIL);
        } catch (Exception e) {
            com.kwad.components.core.u.j.c(Integer.valueOf(this.ahK));
            b(TKRenderFailReason.RENDER_ERROR);
            bm(e.getMessage());
            ServiceProvider.reportSdkCaughtException(e);
        }
    }

    private static String vA() {
        aj.a aVar = new aj.a();
        aVar.screenOrientation = !aq.isOrientationPortrait() ? 1 : 0;
        return aVar.toJson().toString();
    }

    private String vB() {
        ae.a aVar = new ae.a();
        j jVar = this.ahj;
        if (jVar != null) {
            jVar.a(aVar);
        } else {
            aVar.width = this.ahI.Vu.getWidth();
            aVar.height = this.ahI.Vu.getHeight();
        }
        return aVar.toJson().toString();
    }

    private void vC() {
        vK();
        this.ahj.aG();
        vD();
        a("setCloseAction", (String) null, new com.kwad.components.core.webview.tachikoma.a.b() { // from class: com.kwad.components.core.webview.tachikoma.i.23
            @Override // com.kwad.components.core.webview.tachikoma.a.b
            public final void c(WebCloseStatus webCloseStatus) {
                if (i.this.ahj != null) {
                    i.this.ahj.a(webCloseStatus);
                }
            }
        });
        a("setAdOutClickCallback", (String) null, new com.kwad.components.core.webview.tachikoma.a.c() { // from class: com.kwad.components.core.webview.tachikoma.i.34
            @Override // com.kwad.components.core.webview.tachikoma.a.c
            public final void b(a.C0490a c0490a) {
                if (i.this.ahj != null) {
                    i.this.ahj.a(c0490a);
                }
            }
        });
        a("setUpdatePositionCallback", (String) null, new com.kwad.components.core.webview.tachikoma.a.f() { // from class: com.kwad.components.core.webview.tachikoma.i.43
            @Override // com.kwad.components.core.webview.tachikoma.a.f
            public final void a(am.a aVar) {
                i.this.b(aVar);
            }
        });
        a("setCancelDownloadCallback", (String) null, new com.kwad.components.core.webview.tachikoma.a.d() { // from class: com.kwad.components.core.webview.tachikoma.i.44
            @Override // com.kwad.components.core.webview.tachikoma.a.d
            public final AdTemplate wa() {
                return i.this.vL();
            }
        });
    }

    private void vD() {
        com.kwad.components.core.e.d.c cVar = vL() != null ? new com.kwad.components.core.e.d.c(vL()) : null;
        this.ahQ = new com.kwad.components.core.webview.tachikoma.a.e(cVar, this.ahI, this.ahJ);
        a("setClickAction", (String) null, new com.kwad.components.core.webview.tachikoma.a.a(vw(), cVar, this, true));
    }

    private static int b(StyleTemplate styleTemplate) {
        if (styleTemplate == null) {
            return 0;
        }
        return (styleTemplate.templateId + " " + styleTemplate.templateVersionCode).hashCode();
    }

    public final Object a(String str, String str2, m mVar) {
        o oVar = this.ahJ;
        if (oVar != null) {
            return oVar.b(str, str2, mVar);
        }
        return null;
    }

    private boolean vE() {
        try {
            boolean z = (this.ahG.equals("tk_feed_tk_card") && com.kwad.sdk.core.config.e.YZ()) || this.ahG.equals("tk_draw_card");
            this.ahH = z;
            return z;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean vF() {
        return this.ahH;
    }

    public final void a(com.kwad.sdk.core.webview.c.g gVar) {
        this.ahk = gVar;
    }

    private void vG() {
        this.ahv = false;
        this.ahw = false;
        this.aht = false;
        this.ahu = false;
        this.ahx = false;
        this.KA = 0L;
        this.aaM = 0L;
        this.aaL = 0L;
        this.ahz = 0L;
    }

    private void vH() {
        if (isLocalDebugEnable()) {
            this.ahC = 2000;
            this.ahD = 3000;
        }
        bx.runOnUiThreadDelay(this.ahV, this.ahC);
        int i = this.ahD;
        if (i > 0) {
            bx.runOnUiThreadDelay(this.ahW, i);
        }
        this.ahm = GlobalThreadPools.ach().submit(new bh() { // from class: com.kwad.components.core.webview.tachikoma.i.45
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                i.this.KA = SystemClock.elapsedRealtime();
                com.kwad.sdk.core.d.c.d("TKLoadController", "开始读取模板 id: " + i.this.ahj.getTkTemplateId());
                i.this.a(new TKDownloadListener() { // from class: com.kwad.components.core.webview.tachikoma.i.45.1
                    @Override // com.kwad.components.offline.api.tk.TKDownloadListener
                    public final void onSuccess(StyleTemplate styleTemplate) {
                        i.this.c(styleTemplate);
                    }

                    @Override // com.kwad.components.offline.api.tk.TKDownloadListener
                    public final void onFailed(String str) {
                        i.this.bj(str);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final StyleTemplate styleTemplate) {
        com.kwad.sdk.utils.k.b("", "renderType_tk", styleTemplate.templateId, styleTemplate.templateUrl);
        com.kwad.sdk.core.d.c.d("TKLoadController", "读取完毕，总耗时" + (SystemClock.elapsedRealtime() - this.KA) + ", 读取成功" + styleTemplate.templateId);
        if (this.aht) {
            return;
        }
        com.kwad.sdk.core.d.c.d("TKLoadController", "没有超时");
        bx.d(this.ahV);
        bx.runOnUiThread(new bh() { // from class: com.kwad.components.core.webview.tachikoma.i.46
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                i iVar = i.this;
                iVar.a(styleTemplate, iVar.ahS);
            }
        });
        ViewParent tKContainer = this.ahj.getTKContainer();
        if (tKContainer instanceof com.kwad.sdk.core.view.h) {
            com.kwad.sdk.core.view.h hVar = (com.kwad.sdk.core.view.h) tKContainer;
            this.ahr = hVar;
            hVar.getWindowFocusChangeHelper().a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(String str) {
        b(TKRenderFailReason.TK_FILE_LOAD_ERROR);
        bl(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TKDownloadListener tKDownloadListener) {
        StyleTemplate styleTemplateVJ = vJ();
        if (styleTemplateVJ == null) {
            tKDownloadListener.onFailed("no template");
            return;
        }
        if (!isLocalDebugEnable()) {
            String strN = h.vu().n(styleTemplateVJ.templateId, styleTemplateVJ.templateVersionCode);
            if (!TextUtils.isEmpty(strN) && !isLocalDebugEnable()) {
                styleTemplateVJ.jsStr = strN;
                styleTemplateVJ.tkSouce = 4;
                com.kwad.sdk.core.d.c.d("TKLoadController", "使用TK模板缓存");
                tKDownloadListener.onSuccess(styleTemplateVJ);
                return;
            }
        }
        this.ahl.loadTkFileByTemplateId(this.mContext, styleTemplateVJ.templateId, styleTemplateVJ.templateMd5, styleTemplateVJ.templateUrl, styleTemplateVJ.templateVersionCode, tKDownloadListener);
    }

    private static boolean isLocalDebugEnable() {
        com.kwad.sdk.components.d.g(DevelopMangerComponents.class);
        return false;
    }

    private static boolean vI() {
        com.kwad.sdk.components.d.g(DevelopMangerComponents.class);
        return false;
    }

    private static StyleTemplate bk(String str) {
        com.kwad.sdk.components.d.g(DevelopMangerComponents.class);
        return null;
    }

    private StyleTemplate vJ() {
        AdMatrixInfo.MatrixTemplate matrixTemplateK;
        String tkTemplateId = this.ahj.getTkTemplateId();
        StyleTemplate styleTemplate = this.ZR;
        if (styleTemplate != null) {
            tkTemplateId = styleTemplate.templateId;
        }
        StyleTemplate styleTemplateBk = bk(tkTemplateId);
        if (styleTemplateBk != null) {
            return styleTemplateBk;
        }
        if (isLocalDebugEnable()) {
            StyleTemplate styleTemplate2 = new StyleTemplate();
            styleTemplate2.templateId = tkTemplateId;
            styleTemplate2.templateVersion = "1.0.4";
            styleTemplate2.templateVersionCode = 104;
            if (vI()) {
                styleTemplate2.templateUrl = "http://" + OfflineHostProvider.getApi().env().localIpAddress() + ":24680/" + tkTemplateId + ".104.coverage.zip";
            } else {
                styleTemplate2.templateUrl = "http://" + OfflineHostProvider.getApi().env().localIpAddress() + ":24680/" + tkTemplateId + ".104.zip";
            }
            return styleTemplate2;
        }
        StyleTemplate styleTemplate3 = this.ZR;
        if (styleTemplate3 != null) {
            return styleTemplate3;
        }
        AdTemplate adTemplateVL = vL();
        if (adTemplateVL == null || (matrixTemplateK = com.kwad.sdk.core.response.b.b.k(adTemplateVL, this.ahj.getTkTemplateId())) == null) {
            return null;
        }
        com.kwad.components.core.p.a.e.c cVar = this.ahl;
        if (cVar == null) {
            StyleTemplate styleTemplate4 = new StyleTemplate();
            styleTemplate4.templateId = matrixTemplateK.templateId;
            styleTemplate4.templateMd5 = matrixTemplateK.templateMd5;
            styleTemplate4.templateUrl = matrixTemplateK.templateUrl;
            styleTemplate4.templateVersionCode = (int) matrixTemplateK.templateVersionCode;
            styleTemplate4.tkSouce = 0;
            return styleTemplate4;
        }
        return cVar.checkStyleTemplateById(this.mContext, matrixTemplateK.templateId, matrixTemplateK.templateMd5, matrixTemplateK.templateUrl, (int) matrixTemplateK.templateVersionCode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StyleTemplate styleTemplate, a aVar) {
        this.ZR = styleTemplate;
        com.kwad.sdk.core.d.c.w("TKLoadController", "addTKView mTKPlugin.getState(): " + this.ahl.getState());
        if (this.ahl.getState() == ITkOfflineCompo.TKState.SO_FAIL) {
            bl(TKPerformMsg.ERROR_REASON.KSAD_TK_SO_FAIL);
            if (aVar != null) {
                aVar.onFailed();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(styleTemplate.jsStr)) {
            bm(TKPerformMsg.ERROR_REASON.KSAD_TK_NO_TEMPLATE);
            if (aVar != null) {
                aVar.onFailed();
                return;
            }
            return;
        }
        try {
            if (this.ahH) {
                b(styleTemplate, aVar);
            } else {
                c(styleTemplate, aVar);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            h(th);
            if (aVar != null) {
                aVar.onFailed();
            }
        }
    }

    private void b(StyleTemplate styleTemplate, final a aVar) {
        vO();
        this.aaM = SystemClock.elapsedRealtime();
        t tVarA = this.ahl.a(this.mContext, styleTemplate.templateId, styleTemplate.templateVersionCode, styleTemplate.tkSouce, this.ahE);
        com.kwad.components.core.p.a.e.a.a.a(this.mAdResultData.hashCode(), this.mAdResultData);
        tVarA.a(this.ahT);
        tVarA.a(this.ahU);
        if (this.ZR != null) {
            vT().put("styleTemplate", this.ZR.toJson().toString());
        }
        vT().put("appId", ServiceProvider.getAppId());
        vT().put("isDebug", com.kwad.components.core.a.qr);
        vT().put("newRenderType", Boolean.valueOf(this.ahH));
        tVarA.setCustomEnv(vT());
        this.ahn = tVarA;
        com.kwad.sdk.core.c.b.aaf();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        if (currentActivity != null) {
            ViewGroup viewGroup = (ViewGroup) currentActivity.getWindow().getDecorView();
            vT().put("isImmersiveMode", Boolean.valueOf(com.kwad.sdk.c.a.a.V(viewGroup) && com.kwad.sdk.c.a.a.bu(currentActivity) == viewGroup.getHeight()));
        }
        tVarA.setCustomEnv(vT());
        com.kwad.sdk.core.webview.c.g gVar = this.ahk;
        if (gVar != null) {
            tVarA.b(gVar);
        }
        this.aaL = SystemClock.elapsedRealtime() - this.aaM;
        this.ahz = SystemClock.elapsedRealtime();
        c(tVarA);
        tVarA.a(styleTemplate.jsStr, new File(this.ahl.getJsBaseDir(this.mContext, this.ahj.getTkTemplateId())).getAbsolutePath() + "/", new s() { // from class: com.kwad.components.core.webview.tachikoma.i.2
            @Override // com.kwad.sdk.components.s
            public final void onSuccess() {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onSuccess();
                }
            }

            @Override // com.kwad.sdk.components.s
            public final void onFailed(Throwable th) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onFailed();
                }
                i.this.h(th);
            }
        });
    }

    private void c(StyleTemplate styleTemplate, final a aVar) {
        vO();
        this.aaM = SystemClock.elapsedRealtime();
        t tVarA = this.ahl.a(this.mContext, styleTemplate.templateId, styleTemplate.templateVersionCode, styleTemplate.tkSouce, this.ahE);
        com.kwad.components.core.p.a.e.a.a.a(tVarA.getUniqId(), this.mAdResultData);
        tVarA.a(this.ahT);
        tVarA.a(this.ahU);
        AdResultData adResultData = this.mAdResultData;
        if (adResultData != null && com.kwad.sdk.core.response.b.c.s(adResultData).mAdScene != null) {
            vT().put("adStyle", Integer.valueOf(com.kwad.sdk.core.response.b.c.s(this.mAdResultData).mAdScene.getAdStyle()));
            vT().put("adScene", com.kwad.sdk.core.response.b.c.s(this.mAdResultData).mAdScene.toJson().toString());
        }
        if (this.ZR != null) {
            vT().put("styleTemplate", this.ZR.toJson().toString());
        }
        vT().put("adCacheId", Integer.valueOf(tVarA.getUniqId()));
        vT().put("appId", ServiceProvider.getAppId());
        vT().put("isDebug", com.kwad.components.core.a.qr);
        vT().put("newRenderType", Boolean.valueOf(this.ahH));
        tVarA.setCustomEnv(vT());
        this.ahn = tVarA;
        com.kwad.sdk.core.c.b.aaf();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        if (currentActivity != null) {
            ViewGroup viewGroup = (ViewGroup) currentActivity.getWindow().getDecorView();
            vT().put("isImmersiveMode", Boolean.valueOf(com.kwad.sdk.c.a.a.V(viewGroup) && com.kwad.sdk.c.a.a.bu(currentActivity) == viewGroup.getHeight()));
        }
        tVarA.setCustomEnv(vT());
        com.kwad.sdk.core.webview.c.g gVar = this.ahk;
        if (gVar != null) {
            tVarA.b(gVar);
        }
        this.aaL = SystemClock.elapsedRealtime() - this.aaM;
        this.ahz = SystemClock.elapsedRealtime();
        vK();
        b(tVarA);
        tVarA.a(styleTemplate.jsStr, new File(this.ahl.getJsBaseDir(this.mContext, this.ahj.getTkTemplateId())).getAbsolutePath() + "/", new s() { // from class: com.kwad.components.core.webview.tachikoma.i.3
            @Override // com.kwad.sdk.components.s
            public final void onSuccess() {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onSuccess();
                }
            }

            @Override // com.kwad.sdk.components.s
            public final void onFailed(Throwable th) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onFailed();
                }
                i.this.h(th);
            }
        });
        FrameLayout tKContainer = this.ahj.getTKContainer();
        if (tKContainer == null || !this.ahE) {
            return;
        }
        View view = tVarA.getView();
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        tKContainer.addView(view);
        d(styleTemplate);
    }

    private void d(StyleTemplate styleTemplate) {
        if (com.kwad.components.core.a.qr.booleanValue() && this.ahj.getTKContainer() != null) {
            if (this.ahs == null) {
                TextView textView = new TextView(this.mContext);
                this.ahs = textView;
                textView.setTextSize(12.0f);
                this.ahs.setTextColor(SupportMenu.CATEGORY_MASK);
                this.ahj.getTKContainer().addView(this.ahs);
            }
            this.ahs.setText(styleTemplate.templateId + " " + styleTemplate.templateVersionCode);
            this.ahs.setVisibility(0);
        }
    }

    private void vK() {
        this.ahI.a(!aq.apb() ? 1 : 0, this.ahj.getTouchCoordsView(), this.ahj.getTKContainer(), this.ahj.getTkTemplateId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kwad.sdk.components.j aO(final AdTemplate adTemplate) {
        final com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(adTemplate);
        cVar.pP();
        return new com.kwad.sdk.components.j() { // from class: com.kwad.components.core.webview.tachikoma.i.6
            @Override // com.kwad.sdk.components.j
            public final void setCustomReportParam(String str) {
                try {
                    cVar.d(new JSONObject(str));
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }

            @Override // com.kwad.sdk.components.j
            public final void a(final com.kwad.sdk.components.i iVar) {
                cVar.b(new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.tachikoma.i.6.1
                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onIdle() {
                        iVar.onIdle();
                    }

                    @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadStarted() {
                        iVar.onDownloadStarted();
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onProgressUpdate(int i) {
                        long j;
                        long j2;
                        AdTemplate adTemplate2 = i.this.ahI.getAdTemplate();
                        if (adTemplate2 != null) {
                            j = com.kwad.sdk.core.response.b.e.eP(adTemplate2).totalBytes;
                            j2 = com.kwad.sdk.core.response.b.e.eP(adTemplate2).soFarBytes;
                        } else {
                            j = 0;
                            j2 = 0;
                        }
                        iVar.onProgressUpdate(i, j, j2);
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadFinished() {
                        iVar.onDownloadFinished();
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onInstalled() {
                        iVar.onInstalled();
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadFailed() {
                        iVar.onDownloadFailed();
                    }

                    @Override // com.kwad.sdk.core.download.a.a
                    public final void onPaused(int i) {
                        long j;
                        long j2;
                        AdTemplate adTemplate2 = i.this.ahI.getAdTemplate();
                        if (adTemplate2 != null) {
                            j = com.kwad.sdk.core.response.b.e.eP(adTemplate2).totalBytes;
                            j2 = com.kwad.sdk.core.response.b.e.eP(adTemplate2).soFarBytes;
                        } else {
                            j = 0;
                            j2 = 0;
                        }
                        iVar.onPaused(i, j, j2);
                    }
                });
            }

            @Override // com.kwad.sdk.components.j
            public final void startDownload() {
                cVar.pV();
            }

            @Override // com.kwad.sdk.components.j
            public final void pauseDownload() {
                cVar.pW();
            }

            @Override // com.kwad.sdk.components.j
            public final void resumeDownload() {
                cVar.pX();
            }

            @Override // com.kwad.sdk.components.j
            public final void stopDownload() {
                cVar.pW();
            }

            @Override // com.kwad.sdk.components.j
            public final void cancelDownload() {
                com.kwad.sdk.core.download.a.fb(com.kwad.sdk.core.response.b.e.eS(adTemplate));
            }

            @Override // com.kwad.sdk.components.j
            public final void installApp() {
                cVar.pU();
            }

            @Override // com.kwad.sdk.components.j
            public final void openApp() {
                cVar.pS();
            }
        };
    }

    protected final AdTemplate vL() {
        return this.ahI.getAdTemplate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final TKRenderFailReason tKRenderFailReason) {
        bx.postOnUiThread(new bh() { // from class: com.kwad.components.core.webview.tachikoma.i.9
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                if (i.this.ahx) {
                    return;
                }
                i.c(i.this, true);
                i.this.ahj.a(tKRenderFailReason);
                com.kwad.components.core.e.e.g.qh().b(i.this);
                com.kwad.components.core.webview.tachikoma.e.c.wq().t(i.this.ahF, i.this.ahG);
                com.kwad.components.core.webview.tachikoma.e.b.wo().c(i.this.ahK, i.this.ahF, i.this.ahG);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final TKRenderFailReason tKRenderFailReason) {
        bx.postOnUiThread(new bh() { // from class: com.kwad.components.core.webview.tachikoma.i.10
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                if (i.this.ahx) {
                    return;
                }
                i.c(i.this, true);
                i.this.ahj.a(tKRenderFailReason);
                com.kwad.components.core.e.e.g.qh().b(i.this);
                com.kwad.components.core.webview.tachikoma.e.c.wq().t(i.this.ahF, i.this.ahG);
            }
        });
    }

    private void b(t tVar) {
        com.kwad.components.core.e.d.c cVar = vL() != null ? new com.kwad.components.core.e.d.c(vL()) : null;
        this.ahj.a(tVar, this.ahI);
        a(tVar, new com.kwad.components.core.webview.jshandler.q());
        a(tVar, new com.kwad.components.core.webview.jshandler.r());
        com.kwad.components.core.webview.tachikoma.b.s sVar = new com.kwad.components.core.webview.tachikoma.b.s();
        sVar.a(new s.a() { // from class: com.kwad.components.core.webview.tachikoma.i.11
            @Override // com.kwad.components.core.webview.tachikoma.b.s.a
            public final void a(com.kwad.components.core.webview.tachikoma.c.t tVar2) {
                if (TextUtils.isEmpty(tVar2.message)) {
                    return;
                }
                ac.d(i.this.mContext, tVar2.message, 0L);
            }
        });
        a(tVar, sVar);
        a(tVar, c(this.ahI));
        a(tVar, new com.kwad.components.core.webview.jshandler.n(this.ahI));
        a(tVar, new com.kwad.components.core.webview.jshandler.o(this.ahI));
        a(tVar, new com.kwad.sdk.core.webview.d.a());
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.f());
        a(tVar, new x());
        if (oX()) {
            com.kwad.components.core.webview.jshandler.z zVar = new com.kwad.components.core.webview.jshandler.z(this.ahI, cVar, this);
            if (!this.ahF.equals(com.kwad.sdk.core.response.b.b.dC(this.ahI.getAdTemplate()))) {
                com.kwad.components.core.e.e.g.qh().a(this);
            }
            a(tVar, zVar);
        } else {
            a(tVar, new com.kwad.components.core.webview.jshandler.ac(this.ahI, cVar, this, (byte) 0));
        }
        a(tVar, new ab(this.ahI));
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.k());
        a(tVar, new ag(this.ahI));
        a(tVar, new aj(this.ahI));
        a(tVar, new as(this.mContext, vL()));
        ae aeVar = new ae(this.ahI);
        aeVar.a(new ae.b() { // from class: com.kwad.components.core.webview.tachikoma.i.13
            @Override // com.kwad.components.core.webview.jshandler.ae.b
            public final void c(ae.a aVar) {
                i.this.ahj.a(aVar);
            }
        });
        a(tVar, aeVar);
        a(tVar, new be(this.ahI, new be.a() { // from class: com.kwad.components.core.webview.tachikoma.i.14
            @Override // com.kwad.components.core.webview.jshandler.be.a
            public final void g(AdTemplate adTemplate) {
                try {
                    i.this.ahI.xc().remove(0);
                    i.this.ahI.xc().add(adTemplate);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(adTemplate);
                    AdResultData adResultData = new AdResultData();
                    adResultData.setAdTemplateList(arrayList);
                    adResultData.llsid = adTemplate.llsid;
                    i.this.mAdResultData = adResultData;
                    i.this.ahj.g(com.kwad.sdk.core.response.b.c.s(i.this.mAdResultData));
                    if (i.this.ahn != null) {
                        com.kwad.components.core.p.a.e.a.a.a(i.this.ahn.getUniqId(), i.this.mAdResultData);
                    }
                    i.this.ahq.setApkDownloadHelper(new com.kwad.components.core.e.d.c(adTemplate));
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
        }));
        a(tVar, new am(this.ahI, new am.b() { // from class: com.kwad.components.core.webview.tachikoma.i.15
            @Override // com.kwad.components.core.webview.jshandler.am.b
            public final void a(am.a aVar) {
                i.this.b(aVar);
            }
        }));
        a(tVar, new at(new at.b() { // from class: com.kwad.components.core.webview.tachikoma.i.16
            @Override // com.kwad.components.core.webview.jshandler.at.b
            public final void a(at.a aVar) {
                if (aVar.status != 1) {
                    i.this.b(TKRenderFailReason.RENDER_ERROR);
                    i.this.bm(aVar.errorMsg);
                } else {
                    i.this.vW();
                }
            }
        }));
        ba baVar = new ba();
        this.gE = baVar;
        a(tVar, baVar);
        this.ahj.a(this.gE);
        az azVar = new az();
        this.ahp = azVar;
        a(tVar, azVar);
        bd bdVar = new bd(this.ahI, cVar);
        this.ahq = bdVar;
        a(tVar, bdVar);
        p pVar = new p();
        this.aho = pVar;
        a(tVar, pVar);
        this.ahj.a(this.aho);
        a(tVar, new com.kwad.components.core.webview.jshandler.a(new a.b() { // from class: com.kwad.components.core.webview.tachikoma.i.17
            @Override // com.kwad.components.core.webview.jshandler.a.b
            public final void c(a.C0490a c0490a) {
                i.this.ahj.a(c0490a);
            }
        }));
        if (vL() != null && com.kwad.sdk.core.response.b.a.aJ(com.kwad.sdk.core.response.b.e.eP(vL()))) {
            final com.kwad.components.core.webview.tachikoma.b.l lVar = new com.kwad.components.core.webview.tachikoma.b.l();
            a(tVar, lVar);
            this.adF = new com.kwad.sdk.core.download.e(vL()) { // from class: com.kwad.components.core.webview.tachikoma.i.18
                @Override // com.kwad.sdk.core.download.e, com.kwad.sdk.core.download.d
                public final void b(String str, String str2, com.kwad.sdk.core.download.f fVar) {
                    super.b(str, str2, fVar);
                    com.kwad.components.core.webview.tachikoma.c.b bVar = new com.kwad.components.core.webview.tachikoma.c.b();
                    bVar.aiU = 1;
                    lVar.a(bVar);
                }
            };
            com.kwad.sdk.core.download.c.ZJ().a(this.adF, vL());
        }
        com.kwad.components.core.webview.tachikoma.b.t tVar2 = new com.kwad.components.core.webview.tachikoma.b.t();
        tVar2.a(new t.a() { // from class: com.kwad.components.core.webview.tachikoma.i.19
            @Override // com.kwad.components.core.webview.tachikoma.b.t.a
            public final void b(u uVar) {
                i.this.ahj.a(uVar);
            }
        });
        a(tVar, tVar2);
        v vVar = new v();
        vVar.a(new v.a() { // from class: com.kwad.components.core.webview.tachikoma.i.20
            @Override // com.kwad.components.core.webview.tachikoma.b.v.a
            public final void b(com.kwad.components.core.webview.tachikoma.c.n nVar) {
                i.this.ahj.a(nVar);
            }
        });
        a(tVar, vVar);
        com.kwad.components.core.webview.tachikoma.b.o oVar = new com.kwad.components.core.webview.tachikoma.b.o();
        a(tVar, oVar);
        this.ahj.a(oVar);
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.r() { // from class: com.kwad.components.core.webview.tachikoma.i.21
            @Override // com.kwad.components.core.webview.tachikoma.b.r
            public final void a(com.kwad.components.core.webview.tachikoma.c.s sVar2) {
                super.a(sVar2);
                Activity activityVx = i.this.vx();
                if (activityVx == null) {
                    com.kwad.sdk.core.c.b.aaf();
                    activityVx = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (activityVx == null || activityVx.isFinishing()) {
                    return;
                }
                if (i.this.ahi != null) {
                    i.this.ahi.dismiss();
                }
                e.b bVar = new e.b();
                bVar.a(i.this.mAdResultData);
                bVar.bo(sVar2.templateId);
                i.this.ahi = com.kwad.components.core.webview.tachikoma.d.e.b(bVar);
                i.this.ahi.show(activityVx.getFragmentManager(), "");
            }
        });
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.c() { // from class: com.kwad.components.core.webview.tachikoma.i.22
            @Override // com.kwad.components.core.webview.tachikoma.b.c
            public final void kl() {
                super.kl();
                if (i.this.ahi != null) {
                    i.this.ahi.dismiss();
                }
                if (i.this.ahj != null) {
                    i.this.ahj.aF();
                }
            }
        });
        a(tVar, new aa(new com.kwad.sdk.core.webview.d.a.b() { // from class: com.kwad.components.core.webview.tachikoma.i.24
            @Override // com.kwad.sdk.core.webview.d.a.b
            public final void b(WebCloseStatus webCloseStatus) {
                i.this.ahj.a(webCloseStatus);
            }
        }));
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.d() { // from class: com.kwad.components.core.webview.tachikoma.i.25
            @Override // com.kwad.components.core.webview.tachikoma.b.d
            public final void a(com.kwad.components.core.webview.tachikoma.c.g gVar) {
                AdTemplate adTemplateA = gVar.adS >= 0 ? com.kwad.sdk.core.response.b.c.a(com.kwad.components.core.p.a.e.a.a.aO(gVar.adS), gVar.PD) : null;
                if (adTemplateA == null) {
                    adTemplateA = i.this.vL();
                }
                com.kwad.components.core.q.a.ss().a(gVar.actionType, adTemplateA, gVar.QX);
            }
        });
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.j() { // from class: com.kwad.components.core.webview.tachikoma.i.26
            @Override // com.kwad.components.core.webview.tachikoma.b.j
            public final void a(com.kwad.components.core.webview.tachikoma.c.o oVar2) {
                super.a(oVar2);
                AdWebViewActivityProxy.launch(i.this.mContext, new AdWebViewActivityProxy.a.C0479a().aE(oVar2.title).aF(oVar2.url).aI(!oVar2.ajh).q(i.this.mAdResultData).rk());
            }
        });
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.a(vL()));
        a(tVar, new com.kwad.components.core.webview.tachikoma.a(vL()));
        a(this.ahI, cVar, tVar, this.ahj.getTKContainer());
        a(tVar, new com.kwad.components.core.webview.jshandler.a.f(this.mContext));
        a(tVar, new com.kwad.components.core.webview.jshandler.a.d(this.mContext));
        a(tVar, new com.kwad.components.core.webview.jshandler.a.a());
        a(tVar, new com.kwad.components.core.webview.jshandler.a.e(this.mContext));
        ax axVar = new ax();
        this.adE = axVar;
        a(tVar, axVar);
        a(tVar, new com.kwad.components.core.webview.jshandler.c(this.ahI));
    }

    private void c(final com.kwad.sdk.components.t tVar) {
        com.kwad.components.core.e.d.c cVar = vL() != null ? new com.kwad.components.core.e.d.c(vL()) : null;
        this.ahj.a(tVar, this.ahI);
        a(tVar, new com.kwad.components.core.webview.jshandler.q());
        a(tVar, new com.kwad.components.core.webview.jshandler.r());
        com.kwad.components.core.webview.tachikoma.b.s sVar = new com.kwad.components.core.webview.tachikoma.b.s();
        sVar.a(new s.a() { // from class: com.kwad.components.core.webview.tachikoma.i.27
            @Override // com.kwad.components.core.webview.tachikoma.b.s.a
            public final void a(com.kwad.components.core.webview.tachikoma.c.t tVar2) {
                if (TextUtils.isEmpty(tVar2.message)) {
                    return;
                }
                ac.d(i.this.mContext, tVar2.message, 0L);
            }
        });
        a(tVar, sVar);
        a(tVar, c(this.ahI));
        a(tVar, new com.kwad.sdk.core.webview.d.a());
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.f());
        a(tVar, new x());
        if (oX()) {
            com.kwad.components.core.webview.jshandler.z zVar = new com.kwad.components.core.webview.jshandler.z(this.ahI, cVar, this);
            if (!this.ahF.equals(com.kwad.sdk.core.response.b.b.dC(this.ahI.getAdTemplate()))) {
                com.kwad.components.core.e.e.g.qh().a(this);
            }
            a(tVar, zVar);
        } else {
            a(tVar, new com.kwad.components.core.webview.jshandler.ac(this.ahI, cVar, this, (byte) 0));
        }
        a(tVar, new ab(this.ahI));
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.k());
        a(tVar, new as(this.mContext, vL()));
        a(tVar, new be(this.ahI, new be.a() { // from class: com.kwad.components.core.webview.tachikoma.i.28
            @Override // com.kwad.components.core.webview.jshandler.be.a
            public final void g(AdTemplate adTemplate) {
                try {
                    i.this.ahI.xc().remove(0);
                    i.this.ahI.xc().add(adTemplate);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(adTemplate);
                    AdResultData adResultData = new AdResultData();
                    adResultData.setAdTemplateList(arrayList);
                    adResultData.llsid = adTemplate.llsid;
                    i.this.mAdResultData = adResultData;
                    i.this.ahj.g(com.kwad.sdk.core.response.b.c.s(i.this.mAdResultData));
                    if (i.this.ahn != null) {
                        com.kwad.components.core.p.a.e.a.a.a(i.this.ahn.getUniqId(), i.this.mAdResultData);
                    }
                    i.this.ahq.setApkDownloadHelper(new com.kwad.components.core.e.d.c(adTemplate));
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
        }));
        a(tVar, new at(new at.b() { // from class: com.kwad.components.core.webview.tachikoma.i.29
            @Override // com.kwad.components.core.webview.jshandler.at.b
            public final void a(at.a aVar) {
                if (aVar.status == 2 && i.this.ahH) {
                    try {
                        i.this.ahM = SystemClock.elapsedRealtime();
                        i iVar = i.this;
                        iVar.ahO = iVar.ahM;
                        i iVar2 = i.this;
                        iVar2.ahN = iVar2.ahM - i.this.ahz;
                        com.kwad.sdk.core.d.c.d("WebCardPageStatusHandler", "registerTKContext");
                        com.kwad.components.core.u.j.a(Integer.valueOf(i.this.ahK), tVar, i.this.aaL, i.this.KA, i.this.aaM, i.this.ahM);
                        i.this.a(tVar);
                        com.kwad.components.core.webview.tachikoma.e.b.wo().bw(i.this.ahK);
                        return;
                    } catch (Exception e) {
                        com.kwad.components.core.u.j.c(Integer.valueOf(i.this.ahK));
                        i.this.b(TKRenderFailReason.RENDER_ERROR);
                        i.this.bm(e.getMessage());
                        return;
                    }
                }
                if (aVar.status == 0) {
                    i.this.b(TKRenderFailReason.RENDER_ERROR);
                    i.this.bm(aVar.errorMsg);
                }
            }
        }));
        az azVar = new az();
        this.ahp = azVar;
        a(tVar, azVar);
        p pVar = new p();
        this.aho = pVar;
        a(tVar, pVar);
        this.ahj.a(this.aho);
        if (vL() != null && com.kwad.sdk.core.response.b.a.aJ(com.kwad.sdk.core.response.b.e.eP(vL()))) {
            final com.kwad.components.core.webview.tachikoma.b.l lVar = new com.kwad.components.core.webview.tachikoma.b.l();
            a(tVar, lVar);
            this.adF = new com.kwad.sdk.core.download.e(vL()) { // from class: com.kwad.components.core.webview.tachikoma.i.30
                @Override // com.kwad.sdk.core.download.e, com.kwad.sdk.core.download.d
                public final void b(String str, String str2, com.kwad.sdk.core.download.f fVar) {
                    super.b(str, str2, fVar);
                    com.kwad.components.core.webview.tachikoma.c.b bVar = new com.kwad.components.core.webview.tachikoma.c.b();
                    bVar.aiU = 1;
                    lVar.a(bVar);
                }
            };
            com.kwad.sdk.core.download.c.ZJ().a(this.adF, vL());
        }
        com.kwad.components.core.webview.tachikoma.b.t tVar2 = new com.kwad.components.core.webview.tachikoma.b.t();
        tVar2.a(new t.a() { // from class: com.kwad.components.core.webview.tachikoma.i.31
            @Override // com.kwad.components.core.webview.tachikoma.b.t.a
            public final void b(u uVar) {
                i.this.ahj.a(uVar);
            }
        });
        a(tVar, tVar2);
        v vVar = new v();
        vVar.a(new v.a() { // from class: com.kwad.components.core.webview.tachikoma.i.32
            @Override // com.kwad.components.core.webview.tachikoma.b.v.a
            public final void b(com.kwad.components.core.webview.tachikoma.c.n nVar) {
                i.this.ahj.a(nVar);
            }
        });
        a(tVar, vVar);
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.r() { // from class: com.kwad.components.core.webview.tachikoma.i.33
            @Override // com.kwad.components.core.webview.tachikoma.b.r
            public final void a(com.kwad.components.core.webview.tachikoma.c.s sVar2) {
                super.a(sVar2);
                Activity activityVx = i.this.vx();
                if (activityVx == null) {
                    com.kwad.sdk.core.c.b.aaf();
                    activityVx = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (activityVx == null || activityVx.isFinishing()) {
                    return;
                }
                if (i.this.ahi != null) {
                    i.this.ahi.dismiss();
                }
                e.b bVar = new e.b();
                bVar.a(i.this.mAdResultData);
                bVar.bo(sVar2.templateId);
                i.this.ahi = com.kwad.components.core.webview.tachikoma.d.e.b(bVar);
                i.this.ahi.show(activityVx.getFragmentManager(), "");
            }
        });
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.c() { // from class: com.kwad.components.core.webview.tachikoma.i.35
            @Override // com.kwad.components.core.webview.tachikoma.b.c
            public final void kl() {
                super.kl();
                if (i.this.ahi != null) {
                    i.this.ahi.dismiss();
                }
                if (i.this.ahj != null) {
                    i.this.ahj.aF();
                }
            }
        });
        a(tVar, new aa(new com.kwad.sdk.core.webview.d.a.b() { // from class: com.kwad.components.core.webview.tachikoma.i.36
            @Override // com.kwad.sdk.core.webview.d.a.b
            public final void b(WebCloseStatus webCloseStatus) {
                i.this.ahj.a(webCloseStatus);
            }
        }));
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.d() { // from class: com.kwad.components.core.webview.tachikoma.i.37
            @Override // com.kwad.components.core.webview.tachikoma.b.d
            public final void a(com.kwad.components.core.webview.tachikoma.c.g gVar) {
                AdTemplate adTemplateA = gVar.adS >= 0 ? com.kwad.sdk.core.response.b.c.a(com.kwad.components.core.p.a.e.a.a.aO(gVar.adS), gVar.PD) : null;
                if (adTemplateA == null) {
                    adTemplateA = i.this.vL();
                }
                com.kwad.components.core.q.a.ss().a(gVar.actionType, adTemplateA, gVar.QX);
            }
        });
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.j() { // from class: com.kwad.components.core.webview.tachikoma.i.38
            @Override // com.kwad.components.core.webview.tachikoma.b.j
            public final void a(com.kwad.components.core.webview.tachikoma.c.o oVar) {
                super.a(oVar);
                AdWebViewActivityProxy.launch(i.this.mContext, new AdWebViewActivityProxy.a.C0479a().aE(oVar.title).aF(oVar.url).aI(!oVar.ajh).q(i.this.mAdResultData).rk());
            }
        });
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.a(vL()));
        a(tVar, new com.kwad.components.core.webview.tachikoma.a(vL()));
        a(this.ahI, cVar, tVar, this.ahj.getTKContainer());
        a(tVar, new com.kwad.components.core.webview.jshandler.a.f(this.mContext));
        a(tVar, new com.kwad.components.core.webview.jshandler.a.d(this.mContext));
        a(tVar, new com.kwad.components.core.webview.jshandler.a.a());
        a(tVar, new com.kwad.components.core.webview.jshandler.a.e(this.mContext));
        ax axVar = new ax();
        this.adE = axVar;
        a(tVar, axVar);
    }

    private static void a(com.kwad.sdk.components.t tVar, com.kwad.sdk.core.webview.c.a aVar) {
        tVar.c(aVar);
    }

    protected an c(com.kwad.sdk.core.webview.b bVar) {
        return new an(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(am.a aVar) {
        FrameLayout tKContainer = this.ahj.getTKContainer();
        if (tKContainer != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tKContainer.getLayoutParams();
            layoutParams.height = com.kwad.sdk.c.a.a.a(this.mContext, aVar.height);
            layoutParams.leftMargin = com.kwad.sdk.c.a.a.a(this.mContext, aVar.leftMargin);
            layoutParams.rightMargin = com.kwad.sdk.c.a.a.a(this.mContext, aVar.rightMargin);
            layoutParams.bottomMargin = com.kwad.sdk.c.a.a.a(this.mContext, aVar.bottomMargin);
            layoutParams.width = -1;
            tKContainer.setLayoutParams(layoutParams);
        }
    }

    private int vM() {
        return com.kwad.sdk.core.config.e.dz(new StringBuffer().append(this.ahj.getTkTemplateId()).append("#").append(vJ() != null ? vJ().templateVersionCode : 0).toString());
    }

    private void vN() {
        StyleTemplate styleTemplateVJ = vJ();
        if (styleTemplateVJ == null) {
            return;
        }
        this.ahy = styleTemplateVJ.tkSouce;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.ahy).setRenderState(-1).setTemplateId(this.ahj.getTkTemplateId()).setVersionCode(String.valueOf(styleTemplateVJ.templateVersionCode)).setTKPublishType(vM()).setRenderType(vQ()).setRenderIdleTime(vR()).toJson());
    }

    private void bl(String str) {
        f(this.ahj.getTkTemplateId(), str);
        StyleTemplate styleTemplateVJ = vJ();
        if (styleTemplateVJ == null) {
            return;
        }
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.ahy).setRenderState(4).setErrorReason(str).setTemplateId(this.ahj.getTkTemplateId()).setVersionCode(String.valueOf(styleTemplateVJ.templateVersionCode)).setTKPublishType(vM()).setRenderType(vQ()).setRenderIdleTime(vR()).toJson());
    }

    private void vO() {
        if (this.ahv) {
            return;
        }
        this.ahv = true;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.ahy).setRenderState(0).setTemplateId(this.ahj.getTkTemplateId()).setVersionCode(String.valueOf(this.ZR.templateVersionCode)).setTKPublishType(vM()).setRenderType(vQ()).setRenderIdleTime(vR()).toJson());
    }

    private void vP() {
        StringBuilder sbAppend = new StringBuilder("logTkRenderSuccess, templateId = ").append(this.ahj.getTkTemplateId()).append(":");
        StyleTemplate styleTemplate = this.ZR;
        com.kwad.sdk.core.d.c.d("TKLoadController", sbAppend.append(styleTemplate != null ? styleTemplate.templateVersionCode : 0).toString());
        if (!this.ahv || this.ahw) {
            return;
        }
        this.ahw = true;
        long jElapsedRealtime = this.ahz > 0 ? SystemClock.elapsedRealtime() - this.ahz : 0L;
        com.kwad.sdk.core.d.c.d("TKLoadController", "render time, templateId = " + this.ahj.getTkTemplateId() + " init:" + this.aaL + " load:" + (this.aaM - this.KA) + " render:" + jElapsedRealtime);
        if (this.ahH) {
            this.ahP = SystemClock.elapsedRealtime() - this.ahO;
        }
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.ahy).setRenderState(1).setRenderTime(jElapsedRealtime).setTemplateId(this.ahj.getTkTemplateId()).setLoadTime(this.aaM - this.KA).setInitTime(this.aaL).setRegisterEndTime(this.ahN).setGetViewEndTime(this.ahP).setTemplateId(this.ahj.getTkTemplateId()).setVersionCode(String.valueOf(this.ZR.templateVersionCode)).setTKPublishType(vM()).setRenderType(vQ()).setRenderIdleTime(vR()).toJson());
    }

    private int vQ() {
        return this.ahH ? 1 : 0;
    }

    private long vR() {
        if (vQ() == 1) {
            return com.kwad.sdk.core.config.e.Za().longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(String str) {
        com.kwad.sdk.core.d.c.d("TKLoadController", "logTkRenderFail : " + str + ", templateId = " + this.ahj.getTkTemplateId());
        g(this.ahj.getTkTemplateId(), str);
        if (!this.ahv || this.ahw) {
            return;
        }
        this.ahw = true;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.ahy).setRenderState(2).setErrorReason(str).setTemplateId(this.ahj.getTkTemplateId()).setVersionCode(String.valueOf(this.ZR.templateVersionCode)).setTKPublishType(vM()).setRenderType(vQ()).setRenderIdleTime(vR()).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vS() {
        com.kwad.sdk.core.d.c.d("TKLoadController", "logTkRenderFail : timeout, templateId = " + this.ahj.getTkTemplateId());
        StyleTemplate styleTemplateVJ = vJ();
        if (styleTemplateVJ == null) {
            return;
        }
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.ahy).setRenderState(3).setErrorReason("timeout").setTemplateId(this.ahj.getTkTemplateId()).setVersionCode(String.valueOf(styleTemplateVJ.templateVersionCode)).setTKPublishType(vM()).setRenderType(vQ()).setRenderIdleTime(vR()).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Throwable th) {
        com.kwad.sdk.core.d.c.d("TKLoadController", "logTkRenderFail : " + th + ", templateId = " + this.ahj.getTkTemplateId());
        g(this.ahj.getTkTemplateId(), "error:" + th.toString());
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.ahy).setRenderState(3).setErrorReason(th.toString()).setTemplateId(this.ahj.getTkTemplateId()).setVersionCode(String.valueOf(this.ZR.templateVersionCode)).setTKPublishType(vM()).setRenderType(vQ()).setRenderIdleTime(vR()).toJson());
    }

    @Override // com.kwad.sdk.components.q
    public final void callJS(String str) {
        com.kwad.sdk.components.t tVar = this.ahn;
        if (tVar != null) {
            tVar.a(str, null, null);
        }
    }

    private Map<String, Object> vT() {
        if (this.ahA == null) {
            HashMap map = new HashMap();
            this.ahA = map;
            map.put("TKVersion", "6.1.7");
            this.ahA.put("SDKVersion", BuildConfig.VERSION_NAME);
            this.ahA.put("sdkType", 2);
        }
        return this.ahA;
    }

    public final void a(String str, Object obj) {
        vT().put(str, obj);
    }

    @Override // com.kwad.sdk.core.webview.d.a.a
    public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
        j jVar = this.ahj;
        if (jVar != null) {
            jVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.view.f
    public final void i(View view, boolean z) {
        az azVar;
        FrameLayout tKContainer = this.ahj.getTKContainer();
        if (tKContainer == null || !tKContainer.equals(view) || (azVar = this.ahp) == null) {
            return;
        }
        azVar.bb(z);
    }

    @Override // com.kwad.components.core.e.e.f
    public void show() {
        ba baVar = this.gE;
        if (baVar != null) {
            baVar.vi();
        }
    }

    @Override // com.kwad.components.core.e.e.f
    public void dismiss() {
        ba baVar = this.gE;
        if (baVar != null) {
            baVar.vh();
        }
    }

    public void kD() {
        if (this.ahh != null) {
            this.ahh = null;
        }
        com.kwad.sdk.core.view.h hVar = this.ahr;
        if (hVar != null) {
            hVar.getWindowFocusChangeHelper().b(this);
            this.ahr = null;
        }
        Future<?> future = this.ahm;
        if (future != null) {
            future.cancel(true);
        }
        bx.d(this.ahV);
        bx.d(this.ahW);
        com.kwad.components.core.e.e.g.qh().b(this);
        if (this.adF != null) {
            com.kwad.sdk.core.download.c.ZJ().a(this.adF);
        }
        com.kwad.components.core.webview.tachikoma.d.e eVar = this.ahi;
        if (eVar != null) {
            eVar.dismiss();
        }
        if (com.kwad.components.core.a.qr.booleanValue()) {
            vU();
        }
        com.kwad.components.core.p.a.e.c cVar = this.ahl;
        if (cVar != null) {
            cVar.onDestroy();
        }
        final com.kwad.sdk.components.t tVar = this.ahn;
        if (tVar != null) {
            this.ahn = null;
            if (this.ahH) {
                com.kwad.components.core.u.j.c(Integer.valueOf(this.ahK));
            } else {
                bx.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.40
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.components.t tVar2 = tVar;
                        if (tVar2 != null) {
                            tVar2.onDestroy();
                        }
                    }
                });
            }
        }
    }

    private void vU() {
        if (this.ahl == null || this.ahn == null) {
            return;
        }
        File file = new File(new File(this.ahl.getJsBaseDir(this.mContext, this.ahj.getTkTemplateId())), "kcov.json");
        if (file.exists()) {
            try {
                String strAg = w.ag(file);
                if (TextUtils.isEmpty(strAg)) {
                    return;
                }
                com.kwad.sdk.core.d.c.d("TKLoadController", "kcov.json:" + strAg);
                JSONObject jSONObject = new JSONObject(strAg);
                final String string = jSONObject.getString("gitHeadCommit");
                final String string2 = jSONObject.getString("coverageApi");
                final String string3 = jSONObject.getString("coverageTaskId");
                final String string4 = jSONObject.getString("currentBranch");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string4)) {
                    com.kwad.sdk.core.d.c.d("TKLoadController", new StringBuilder("尝试获取覆盖率统计... ").append(this.ZR).toString() != null ? this.ZR.templateId : "");
                    Object objExecute = this.ahn.execute("JSON.stringify(this.__coverage__)");
                    if (objExecute instanceof String) {
                        final String str = (String) objExecute;
                        com.kwad.sdk.utils.h.execute(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.41
                            @Override // java.lang.Runnable
                            public final void run() throws JSONException {
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put("coverage_task_id", Integer.valueOf(string3));
                                    jSONObject2.put("user", "");
                                    jSONObject2.put(com.alipay.sdk.m.t.a.k, System.currentTimeMillis() / 1000);
                                    jSONObject2.put("branch_name", string4);
                                    jSONObject2.put(Config.INPUT_DEF_VERSION, BuildConfig.VERSION_NAME);
                                    jSONObject2.put("tk_version", String.valueOf(i.this.ZR.templateVersionCode));
                                    jSONObject2.put("tk_template_ids", i.this.ZR.templateId);
                                } catch (JSONException e) {
                                    com.kwad.sdk.core.d.c.printStackTrace(e);
                                }
                                com.kwad.sdk.core.network.c cVarDoPost = com.kwad.sdk.g.ST().doPost(string2 + "/analysis/add/pkg/info", (Map<String, String>) null, jSONObject2);
                                if (cVarDoPost.aao()) {
                                    com.kwad.sdk.core.d.c.d("TKLoadController", "上传TK覆盖率pkg完成:" + cVarDoPost.bCs);
                                } else {
                                    com.kwad.sdk.core.d.c.d("TKLoadController", "上传覆盖率pkg失败");
                                }
                                com.kwad.sdk.core.network.c cVarDoPost2 = com.kwad.sdk.g.ST().doPost(string2 + "/attachment/ec", (Map<String, String>) null, new AdHttpBodyBuilder() { // from class: com.kwad.components.core.webview.tachikoma.i.41.1
                                    @Override // com.kwad.sdk.export.proxy.AdHttpBodyBuilder
                                    public final void buildFormData(AdHttpFormDataBuilder adHttpFormDataBuilder) {
                                        adHttpFormDataBuilder.addFormDataPart("task_id", string3);
                                        adHttpFormDataBuilder.addFormDataPart("os_build_model", Build.MODEL);
                                        adHttpFormDataBuilder.addFormDataPart("os_build_serial", "unknown");
                                        adHttpFormDataBuilder.addFormDataPart("os_build_brand", Build.BRAND);
                                        adHttpFormDataBuilder.addFormDataPart("app_version", BuildConfig.VERSION_NAME);
                                        adHttpFormDataBuilder.addFormDataPart("git_head_commit", string);
                                        adHttpFormDataBuilder.addFormDataPart("execute_type", "manual_qa");
                                        adHttpFormDataBuilder.addFormDataPart(Config.CUSTOM_USER_ID, "");
                                        adHttpFormDataBuilder.addFormDataPart(Constants.APPLog.DEVICE_ID, com.kwad.sdk.utils.be.getDeviceId());
                                        adHttpFormDataBuilder.addFormDataPart("execute_user", "");
                                        adHttpFormDataBuilder.addFormDataPart("url_type", "transform");
                                        try {
                                            adHttpFormDataBuilder.addFormDataPart(com.sigmob.sdk.base.n.z, UUID.randomUUID().toString() + ".json", MediaTypeUtils.APPLICATION_OCTET_STREAM, str.getBytes("UTF-8"));
                                        } catch (UnsupportedEncodingException e2) {
                                            com.kwad.sdk.core.d.c.printStackTrace(e2);
                                        }
                                    }
                                });
                                if (cVarDoPost2.aao()) {
                                    com.kwad.sdk.core.d.c.d("TKLoadController", "上传TK覆盖率完成:" + cVarDoPost2.bCs);
                                } else {
                                    com.kwad.sdk.core.d.c.d("TKLoadController", "上传TK覆盖率失败");
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                com.kwad.sdk.core.d.c.d("TKLoadController", "kcov.json数据不合法，缺少关键字段gitHeadCommit | coverageApi | coverageTaskId | currentBranch");
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
    }

    public final String getTkTemplateId() {
        j jVar = this.ahj;
        if (jVar == null) {
            return null;
        }
        return jVar.getTkTemplateId();
    }

    public final o vV() {
        return this.ahJ;
    }

    public final void vW() {
        if (this.ahu) {
            b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            return;
        }
        bx.d(this.ahW);
        vP();
        if (this.ahj != null) {
            bx.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.42
                @Override // java.lang.Runnable
                public final void run() {
                    i.this.ahj.aE();
                }
            });
            com.kwad.components.core.webview.tachikoma.e.c.wq().c(this.ahj.getTkTemplateId(), this.aaM - this.KA, this.aaL, this.ahz > 0 ? SystemClock.elapsedRealtime() - this.ahz : 0L);
        }
    }
}
