package com.sigmob.sdk.mraid;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import com.baidu.mobads.container.rewardvideo.NativeRewardActivity;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.mta.DeviceContext;
import com.czhj.sdk.common.utils.IntentUtil;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.CurrentAppOrientation;
import com.sigmob.sdk.base.models.ExposureChange;
import com.sigmob.sdk.base.models.ExtensionEvent;
import com.sigmob.sdk.base.models.MraidEnv;
import com.sigmob.sdk.base.models.PlacementType;
import com.sigmob.sdk.base.models.VideoItem;
import com.sigmob.sdk.base.models.ViewState;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.mraid.a;
import com.sigmob.sdk.mraid.b;
import com.sigmob.sdk.nativead.APKStatusBroadcastReceiver;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAds;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d {
    private boolean A;
    private com.sigmob.sdk.base.common.f B;
    private WindowInsets C;
    private final PlacementType a;
    private final BaseAdUnit b;
    private final FrameLayout c;
    private final C0741d d;
    private final l e;
    private final com.sigmob.sdk.mraid.b f;
    private final i g;
    private boolean h;
    private Integer i;
    private String j;
    private ViewGroup k;
    private ViewState l;
    private a m;
    private e n;
    private r o;
    private f p;
    private p q;
    private c r;
    private Integer s;
    private boolean t;
    private k u;
    private boolean v;
    private final HashMap<String, j> w;
    private final b.c x;
    private final b.InterfaceC0739b y;
    private APKStatusBroadcastReceiver z;

    public interface a {
        void a();

        void a(float progress);

        void a(int width, int height, int offsetX, int offsetY, a.EnumC0738a closePosition, boolean allowOffscreen);

        void a(View view);

        void a(final WindAdError error);

        void a(String ext);

        void a(URI uri, int type, String ext);

        void a(boolean isMute);

        void b();

        void b(float progress);

        void c();

        void d();

        void e();

        void f();

        void g();

        void h();
    }

    public interface b {
        void onReady(final p webView, final com.sigmob.sdk.base.common.s viewabilityManager);
    }

    class c extends BroadcastReceiver {
        private Context b;
        private int c = -1;

        c() {
        }

        public void a() {
            Context context = this.b;
            if (context == null) {
                return;
            }
            context.unregisterReceiver(this);
            this.b = null;
        }

        public void a(Context context) {
            Preconditions.checkNotNull(context);
            Context applicationContext = context.getApplicationContext();
            this.b = applicationContext;
            if (applicationContext == null) {
                return;
            }
            IntentUtil.registerReceiver(applicationContext, this, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int iX;
            if (this.b == null || d.this.v || !"android.intent.action.CONFIGURATION_CHANGED".equals(intent.getAction()) || (iX = d.this.x()) == this.c) {
                return;
            }
            this.c = iX;
            d.this.a(iX);
        }
    }

    /* renamed from: com.sigmob.sdk.mraid.d$d, reason: collision with other inner class name */
    static class C0741d {
        private final Handler a = new Handler();
        private a b;

        /* renamed from: com.sigmob.sdk.mraid.d$d$a */
        static class a {
            int a;
            private final View[] b;
            private final Handler c;
            private Runnable d;
            private final Runnable e;

            private a(Handler handler, View[] views) {
                this.e = new Runnable() { // from class: com.sigmob.sdk.mraid.d.d.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (final View view : a.this.b) {
                            if (view.getHeight() > 0 || view.getWidth() > 0) {
                                a.this.b();
                            } else {
                                view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.sigmob.sdk.mraid.d.d.a.1.1
                                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                                    public boolean onPreDraw() {
                                        view.getViewTreeObserver().removeOnPreDrawListener(this);
                                        a.this.b();
                                        return true;
                                    }
                                });
                            }
                        }
                    }
                };
                this.c = handler;
                this.b = views;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void b() {
                Runnable runnable;
                int i = this.a - 1;
                this.a = i;
                if (i != 0 || (runnable = this.d) == null) {
                    return;
                }
                runnable.run();
                this.d = null;
            }

            void a() {
                this.c.removeCallbacks(this.e);
                this.d = null;
            }

            void a(Runnable successRunnable) {
                this.d = successRunnable;
                this.a = this.b.length;
                this.c.post(this.e);
            }
        }

        C0741d() {
        }

        a a(View... views) {
            a aVar = new a(this.a, views);
            this.b = aVar;
            return aVar;
        }

        void a() {
            a aVar = this.b;
            if (aVar == null) {
                return;
            }
            aVar.a();
            this.b = null;
        }
    }

    public interface e {
        void useCustomCloseChanged(boolean useCustomClose);
    }

    public interface f {
        void a();

        void a(Integer duration);

        void a(Map<String, String> params);

        void b();

        void b(Map<String, String> params);

        void c();

        void d();

        void e();

        void f();

        void g();

        void h();
    }

    public d(Context context, BaseAdUnit adUnit, PlacementType placementType) {
        this(context, adUnit, placementType, new com.sigmob.sdk.mraid.b(adUnit, placementType), null, new C0741d());
    }

    d(Context context, BaseAdUnit adUnit, PlacementType placementType, com.sigmob.sdk.mraid.b bridge, com.sigmob.sdk.mraid.b twoPartBridge, C0741d screenMetricsWaiter) {
        this.h = false;
        this.l = ViewState.LOADING;
        this.r = new c();
        this.t = true;
        this.u = k.NONE;
        this.v = false;
        this.w = new HashMap<>();
        b.c cVar = new b.c() { // from class: com.sigmob.sdk.mraid.d.1
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
            @Override // com.sigmob.sdk.mraid.b.c
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void a(java.lang.String r6, org.json.JSONObject r7) {
                /*
                    Method dump skipped, instructions count: 416
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.mraid.d.AnonymousClass1.a(java.lang.String, org.json.JSONObject):void");
            }

            @Override // com.sigmob.sdk.mraid.b.c
            public void b(String subEvent, JSONObject args) {
                j jVar;
                String strOptString = args.optString("uniqueId");
                if (TextUtils.isEmpty(strOptString) || (jVar = (j) d.this.w.get(strOptString)) == null || jVar.b() == null) {
                    return;
                }
                d.this.c.bringChildToFront(d.this.q);
            }

            @Override // com.sigmob.sdk.mraid.b.c
            public void c(String subEvent, JSONObject args) {
                j jVar;
                View viewB;
                String strOptString = args.optString("uniqueId");
                if (TextUtils.isEmpty(strOptString) || (jVar = (j) d.this.w.get(strOptString)) == null || (viewB = jVar.b()) == null) {
                    return;
                }
                com.sigmob.sdk.base.utils.o.a(viewB);
                d.this.c.addView(viewB);
            }

            @Override // com.sigmob.sdk.mraid.b.c
            public void d(String subEvent, JSONObject args) {
                com.sigmob.sdk.mraid2.f fVar;
                com.sigmob.sdk.mraid2.f fVar2;
                SigmobLog.d(" postMessage subEvent data:" + args);
                String strOptString = args.optString("uniqueId");
                if (TextUtils.isEmpty(strOptString)) {
                    SigmobLog.e(" onMotionViewEvent uniqueId is null:" + args);
                    return;
                }
                j jVar = (j) d.this.w.get(strOptString);
                fVar = jVar instanceof com.sigmob.sdk.mraid2.f ? (com.sigmob.sdk.mraid2.f) jVar : null;
                subEvent.hashCode();
                switch (subEvent) {
                    case "init_sensitivity_raw":
                        String strOptString2 = args.optString("type", "");
                        int iOptInt = args.optInt("sensitivity_raw", 0);
                        fVar2 = new com.sigmob.sdk.mraid2.f(strOptString, strOptString2);
                        fVar2.a(new com.sigmob.sdk.mraid2.i() { // from class: com.sigmob.sdk.mraid.d.1.3
                            @Override // com.sigmob.sdk.mraid2.i
                            public void a(String uniqueId, String type, String event, HashMap<String, Object> args2) throws JSONException {
                                if (d.this.f != null) {
                                    d.this.f.a(uniqueId, type, event, args2);
                                }
                            }
                        });
                        fVar2.b(iOptInt);
                        break;
                    case "init":
                        String strOptString3 = args.optString("type", "");
                        int iOptInt2 = args.optInt("sensitivity", 0);
                        fVar2 = new com.sigmob.sdk.mraid2.f(strOptString, strOptString3);
                        fVar2.a(new com.sigmob.sdk.mraid2.i() { // from class: com.sigmob.sdk.mraid.d.1.2
                            @Override // com.sigmob.sdk.mraid2.i
                            public void a(String uniqueId, String type, String event, HashMap<String, Object> args2) throws JSONException {
                                if (d.this.f != null) {
                                    d.this.f.a(uniqueId, type, event, args2);
                                }
                            }
                        });
                        fVar2.a(iOptInt2);
                        break;
                    case "destroy":
                        if (fVar != null) {
                            fVar.c();
                        }
                        d.this.w.remove(strOptString);
                        return;
                    default:
                        return;
                }
                fVar2.a();
                d.this.w.put(strOptString, fVar2);
            }

            @Override // com.sigmob.sdk.mraid.b.c
            public void e(String subEvent, JSONObject args) {
                h hVar;
                SigmobLog.d(" onMotionViewEvent event:" + subEvent);
                SigmobLog.d(" postMessage args:" + args);
                String strOptString = args.optString("uniqueId");
                if (TextUtils.isEmpty(strOptString)) {
                    SigmobLog.e(" onMotionViewEvent uniqueId is null:" + args);
                }
                j jVar = (j) d.this.w.get(strOptString);
                hVar = (jVar == null || !(jVar instanceof h)) ? null : (h) jVar;
                subEvent.hashCode();
                switch (subEvent) {
                    case "hidden":
                        if (hVar != null) {
                            hVar.a(args.optBoolean("hidden"));
                            break;
                        }
                        break;
                    case "init":
                        h hVar2 = new h(com.sigmob.sdk.b.h(), strOptString, args.optInt("type"));
                        hVar2.a(new com.sigmob.sdk.mraid2.i() { // from class: com.sigmob.sdk.mraid.d.1.4
                            @Override // com.sigmob.sdk.mraid2.i
                            public void a(String uniqueId, String type, String event, HashMap<String, Object> args2) throws JSONException {
                                if (d.this.f != null) {
                                    d.this.f.a(uniqueId, type, event, args2);
                                }
                            }
                        });
                        d.this.w.put(strOptString, hVar2);
                        break;
                    case "frame":
                        if (hVar != null) {
                            hVar.a(args);
                            break;
                        }
                        break;
                    case "start":
                        if (hVar != null) {
                            hVar.a();
                            break;
                        }
                        break;
                    case "sensitivity":
                        if (hVar != null) {
                            hVar.a(args.optInt("sensitivity"));
                            break;
                        }
                        break;
                    case "destroy":
                        if (hVar != null) {
                            hVar.c();
                        }
                        d.this.w.remove(strOptString);
                        break;
                    case "sensitivity_raw":
                        if (hVar != null) {
                            hVar.b(args.optInt("sensitivity_raw"));
                            break;
                        }
                        break;
                }
            }
        };
        this.x = cVar;
        b.InterfaceC0739b interfaceC0739b = new b.InterfaceC0739b() { // from class: com.sigmob.sdk.mraid.d.2
            @Override // com.sigmob.sdk.mraid.b.InterfaceC0739b
            public void a() {
                d.this.k();
                if (d.this.m != null) {
                    d.this.m.a(d.this.c);
                }
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0739b
            public void a(int width, int height, int offsetX, int offsetY, a.EnumC0738a closePosition, boolean allowOffscreen) {
                if (d.this.m != null) {
                    d.this.m.a(width, height, offsetX, offsetY, closePosition, allowOffscreen);
                }
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0739b
            public void a(final WindAdError errorCode) {
                d.this.a(errorCode);
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0739b
            public void a(String event, Map<String, String> params) {
                d.this.b(event, params);
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0739b
            public void a(final URI uri) {
                d.this.a(uri.toString());
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0739b
            public void a(final URI uri, int type, String ext) {
                d.this.a(uri, type, ext);
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0739b
            public void a(final URI uri, final boolean shouldUseCustomClose) throws com.sigmob.sdk.mraid.c {
                d.this.a(uri, shouldUseCustomClose);
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0739b
            public void a(final boolean isVisible) {
                d.this.f.a(isVisible);
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0739b
            public void a(boolean allowOrientationChange, k forceOrientation) throws com.sigmob.sdk.mraid.c {
                d.this.a(allowOrientationChange, forceOrientation);
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0739b
            public boolean a(final ConsoleMessage consoleMessage) {
                return d.this.a(consoleMessage);
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0739b
            public boolean a(final String message, final JsResult result) {
                return d.this.a(message, result);
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0739b
            public void b() {
                d.this.j();
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0739b
            public void b(String event, Map<String, String> params) {
                d.this.a(event, params);
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0739b
            public void b(final boolean shouldUseCustomClose) {
                d.this.e(shouldUseCustomClose);
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0739b
            public void c() {
                if (d.this.m != null) {
                    d.this.m.e();
                }
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0739b
            public void d() {
                d.this.n();
                d.this.m.h();
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0739b
            public void e() {
                if (d.this.m != null) {
                    d.this.m.f();
                }
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0739b
            public void f() {
                if (d.this.m != null) {
                    d.this.m.g();
                }
            }

            @Override // com.sigmob.sdk.mraid.b.InterfaceC0739b
            public void g() {
                if (d.this.m != null) {
                    d.this.m.c();
                }
            }
        };
        this.y = interfaceC0739b;
        Preconditions.checkNotNull(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.c = frameLayout;
        this.b = adUnit;
        this.a = placementType;
        this.f = bridge;
        this.d = screenMetricsWaiter;
        this.l = ViewState.LOADING;
        this.e = new l(context, context.getResources().getDisplayMetrics().density);
        frameLayout.setBackgroundColor(0);
        new View(context).setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.mraid.d.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        this.r.a(context);
        bridge.a(interfaceC0739b);
        bridge.a(cVar);
        this.g = new i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A() {
        e eVar = this.n;
        if (eVar != null) {
            eVar.useCustomCloseChanged(this.h);
        }
    }

    private float a(String value, float defaultValue) {
        if (TextUtils.isEmpty(value)) {
            return defaultValue;
        }
        try {
            return Float.parseFloat(value);
        } catch (Throwable unused) {
            return defaultValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Context context) {
        try {
            this.f.a(new MraidEnv());
            this.f.a(this.g.b(context), this.g.a(context), i.d(context), i.c(context), h(), true, true);
            this.f.a(this.a);
            this.f.a(this.b.getRvAdSetting());
            WindowInsets windowInsets = this.C;
            if (windowInsets != null) {
                com.sigmob.sdk.base.utils.h hVarA = com.sigmob.sdk.videoplayer.c.a(windowInsets);
                this.f.a(hVarA.a(), hVarA.b(), hVarA.c(), hVarA.d());
            }
            if (!TextUtils.isEmpty(this.b.getVideo_url())) {
                String proxyVideoUrl = this.b.getProxyVideoUrl();
                this.f.a(this.b.getMaterial().video_size != null ? new VideoItem(proxyVideoUrl, this.b.getMaterial().video_size.width.intValue(), this.b.getMaterial().video_size.height.intValue()) : new VideoItem(proxyVideoUrl, 0, 0));
                f();
            }
            MaterialMeta.Builder builderNewBuilder = this.b.getMaterial().newBuilder();
            if (!this.b.getMaterial().has_companion_endcard.booleanValue()) {
                builderNewBuilder = builderNewBuilder.companion(null);
            }
            this.f.a(builderNewBuilder.html_snippet(null).html_url(null).deeplink_url(null).landing_page(null).web_event_handle(null).endcard_url(null).build());
            this.f.a(this.b.getAd().newBuilder().materials(new LinkedList()).ad_tracking(new LinkedList()).build(), this.b.getSlotAdSetting());
        } catch (Throwable th) {
            SigmobLog.e("handleMraidLoad", th);
        }
        if (this.A) {
            k();
        }
    }

    static void a(a mraidListener, ViewState previousViewState, ViewState currentViewState) {
        Preconditions.checkNotNull(mraidListener);
        Preconditions.checkNotNull(previousViewState);
        Preconditions.checkNotNull(currentViewState);
    }

    private void a(Runnable successRunnable) {
        this.d.a();
        Context contextW = w();
        p pVarG = g();
        if (contextW == null || pVarG == null || this.v) {
            return;
        }
        DisplayMetrics displayMetrics = contextW.getResources().getDisplayMetrics();
        com.sigmob.sdk.base.common.f fVar = this.B;
        if (fVar == null) {
            this.e.a(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else {
            this.e.a(fVar.a(), this.B.b());
        }
        int[] iArr = new int[2];
        ViewGroup viewGroupZ = z();
        viewGroupZ.getLocationOnScreen(iArr);
        this.e.a(iArr[0], iArr[1], viewGroupZ.getWidth(), viewGroupZ.getHeight());
        this.e.c(iArr[0], iArr[1], viewGroupZ.getWidth(), viewGroupZ.getHeight());
        pVarG.getLocationOnScreen(iArr);
        this.e.b(iArr[0], iArr[1], pVarG.getWidth(), pVarG.getHeight());
        this.f.a(new CurrentAppOrientation(ClientMetadata.getInstance().getOrientationInt().intValue() == 1 ? NativeRewardActivity.SCREEN_PORTRAIT : NativeRewardActivity.SCREEN_LANDSCAPE, true));
        this.f.a(this.e);
        if (successRunnable != null) {
            successRunnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void a(String event, Map<String, String> params) {
        if (this.m == null) {
            return;
        }
        try {
            String strA = com.sigmob.sdk.mraid.b.a(params.get("ext"));
            String strA2 = com.sigmob.sdk.mraid.b.a(params.get("ctime"));
            String strA3 = com.sigmob.sdk.mraid.b.a(params.get("state"));
            char c2 = 65535;
            switch (event.hashCode()) {
                case -1610203128:
                    if (event.equals(ExtensionEvent.AD_ENDCARD_SHOW)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1102513700:
                    if (event.equals(ExtensionEvent.AD_COMPANION_CLICK)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -934326481:
                    if (event.equals("reward")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -900560382:
                    if (event.equals(ExtensionEvent.AD_SKIP)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 112386354:
                    if (event.equals(ExtensionEvent.AD_MUTE)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1293469449:
                    if (event.equals(ExtensionEvent.AD_SHOE_SKIP_TIME)) {
                        c2 = 5;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                this.m.b(a(strA2, 0.0f));
                return;
            }
            if (c2 == 1) {
                this.m.a(a(strA2, 0.0f));
                return;
            }
            if (c2 == 2) {
                if (com.sigmob.sdk.base.utils.n.b(strA3)) {
                    this.m.a(strA3.equalsIgnoreCase("true") || strA3.equalsIgnoreCase("1"));
                }
            } else if (c2 == 3) {
                this.m.a();
            } else if (c2 == 4) {
                this.m.a(strA);
            } else {
                if (c2 != 5) {
                    return;
                }
                this.m.b();
            }
        } catch (Throwable unused) {
        }
    }

    private void b(ViewState viewState) {
        SigmobLog.d("MRAID state set to " + viewState);
        ViewState viewState2 = this.l;
        this.l = viewState;
        this.f.a(viewState);
        a aVar = this.m;
        if (aVar != null) {
            a(aVar, viewState2, viewState);
        }
        SigmobLog.d("setViewState state set to " + viewState);
        a((Runnable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String event, Map<String, String> params) {
        if (this.p == null) {
        }
        event.hashCode();
        switch (event) {
            case "AdPaused":
                this.p.b();
                break;
            case "AdImpression":
                this.p.a();
                break;
            case "AdVideoThirdQuartile":
                this.p.f();
                break;
            case "AdVideoMidpoint":
                this.p.g();
                break;
            case "AdVideoComplete":
                this.p.d();
                break;
            case "AdVideoFirstQuartile":
                this.p.e();
                break;
            case "AdError":
                this.p.b(params);
                break;
            case "AdVideoStart":
                this.p.h();
                break;
            case "AdClickThru":
                this.p.a(params);
                break;
            case "AdPlaying":
                this.p.c();
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str) {
        Float fValueOf;
        try {
            if (str.equalsIgnoreCase(ILogConst.CACHE_PLAY_REASON_NULL) || str.equalsIgnoreCase("undefined") || (fValueOf = Float.valueOf(str)) == null || fValueOf.floatValue() <= 1.0E-5d) {
                return;
            }
            Integer numValueOf = Integer.valueOf((int) (fValueOf.floatValue() * 1000.0f));
            this.i = numValueOf;
            f fVar = this.p;
            if (fVar != null) {
                fVar.a(numValueOf);
            }
        } catch (Throwable unused) {
        }
    }

    private Context w() {
        FrameLayout frameLayout = this.c;
        if (frameLayout == null) {
            return null;
        }
        return frameLayout.getContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int x() {
        return ClientMetadata.getInstance().getScreenOrientation(w());
    }

    private void y() {
        this.f.b();
        this.q = null;
    }

    private ViewGroup z() {
        ViewGroup viewGroup = this.k;
        if (viewGroup != null) {
            return viewGroup;
        }
        View viewA = com.sigmob.sdk.base.utils.o.a(w(), this.c);
        ViewGroup viewGroup2 = viewA instanceof ViewGroup ? (ViewGroup) viewA : this.c;
        this.k = viewGroup2;
        return viewGroup2;
    }

    int a(int min, int target, int max) {
        return Math.max(min, Math.min(target, max));
    }

    public String a() {
        return this.f.a();
    }

    public void a(int currentRotation) {
        SigmobLog.i("handleOrientationChange " + currentRotation);
        a((Runnable) null);
    }

    @Deprecated
    void a(int width, int height) {
        this.e.a(0, 0, width, height);
    }

    void a(final int widthDips, final int heightDips, final int offsetXDips, final int offsetYDips, final a.EnumC0738a closePosition, final boolean allowOffscreen) throws com.sigmob.sdk.mraid.c {
    }

    public void a(Activity activity) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.sigmob.sdk.mraid.d$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.A();
            }
        }, 5000);
    }

    public void a(WindowInsets windowInsets) {
        this.C = windowInsets;
        SigmobLog.d("updateWindowInsets " + windowInsets);
        if (this.A) {
            com.sigmob.sdk.base.utils.h hVarA = com.sigmob.sdk.videoplayer.c.a(windowInsets);
            com.sigmob.sdk.mraid.b bVar = this.f;
            if (bVar != null) {
                bVar.a(hVarA.a(), hVarA.b(), hVarA.c(), hVarA.d());
            }
        }
    }

    public void a(ValueCallback callback) {
        this.f.a(callback);
    }

    public void a(com.sigmob.sdk.base.common.f adSize) {
        this.B = adSize;
    }

    @Deprecated
    void a(ViewState viewState) {
        this.l = viewState;
    }

    public void a(a mraidListener) {
        this.m = mraidListener;
    }

    @Deprecated
    void a(c receiver) {
        this.r = receiver;
    }

    public void a(e listener) {
        this.n = listener;
    }

    public void a(f vpaidEventListener) {
        this.p = vpaidEventListener;
    }

    public void a(r debugListener) {
        this.o = debugListener;
    }

    void a(WindAdError error) {
        a aVar = this.m;
        if (aVar == null) {
            return;
        }
        aVar.a(error);
    }

    void a(String videoUrl) {
    }

    public void a(String htmlData, b listener) {
        p pVar = new p(w());
        this.q = pVar;
        pVar.a(true);
        this.q.setBackgroundColor(0);
        if (listener != null) {
            listener.onReady(this.q, (com.sigmob.sdk.base.common.s) this.b.getSessionManager());
        }
        this.f.a(this.q);
        this.c.addView(this.q, new FrameLayout.LayoutParams(-1, -1));
        this.f.a(w(), htmlData);
    }

    public void a(String x, String y) {
        this.f.a(x, y);
    }

    public void a(String uniqueId, String type, String began, HashMap<String, Object> args) throws JSONException {
        this.f.a(uniqueId, type, began, args);
    }

    void a(URI uri, int interActionType, String ext) {
        a aVar = this.m;
        if (aVar == null) {
            return;
        }
        aVar.a(uri, interActionType, ext);
    }

    void a(URI uri, boolean shouldUseCustomClose) throws com.sigmob.sdk.mraid.c {
    }

    public void a(boolean result) {
        if (result) {
            this.f.f();
        } else {
            this.f.g();
        }
    }

    void a(boolean allowOrientationChange, k forceOrientation) throws com.sigmob.sdk.mraid.c {
        if (!a(forceOrientation)) {
            throw new com.sigmob.sdk.mraid.c("Unable to force orientation to " + forceOrientation);
        }
        this.t = allowOrientationChange;
        this.u = forceOrientation;
        if (this.l == ViewState.EXPANDED || (this.a == PlacementType.INTERSTITIAL && !this.v)) {
            o();
        }
    }

    boolean a(ConsoleMessage consoleMessage) {
        r rVar = this.o;
        if (rVar == null) {
            return true;
        }
        return rVar.a(consoleMessage);
    }

    boolean a(final k newOrientation) {
        if (newOrientation == k.NONE) {
            return true;
        }
        Activity activityC = com.sigmob.sdk.base.utils.o.c(this.c);
        if (activityC == null) {
            return false;
        }
        try {
            int i = activityC.getPackageManager().getActivityInfo(new ComponentName(activityC, activityC.getClass()), 0).screenOrientation;
            return i == -1 || i == newOrientation.a();
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    boolean a(String message, JsResult result) {
        r rVar = this.o;
        if (rVar != null) {
            return rVar.a(message, result);
        }
        result.confirm();
        return true;
    }

    public void b() {
        this.v = true;
        this.f.a(false);
    }

    void b(final int screenOrientation) throws com.sigmob.sdk.mraid.c {
        Activity activityC = com.sigmob.sdk.base.utils.o.c(this.c);
        if (activityC == null || !a(this.u)) {
            throw new com.sigmob.sdk.mraid.c("Attempted to lock orientation to unsupported value: " + this.u.name());
        }
        if (this.s == null) {
            this.s = Integer.valueOf(activityC.getRequestedOrientation());
        }
        try {
            activityC.setRequestedOrientation(screenOrientation);
        } catch (Exception e2) {
            SigmobLog.e("lockOrientation: " + e2.getMessage());
        }
    }

    public void b(String javascript) {
        this.f.c(javascript);
    }

    public void b(String url, b listener) {
        p pVar = new p(w());
        this.q = pVar;
        pVar.a(true);
        this.q.setBackgroundColor(0);
        if (listener != null) {
            listener.onReady(this.q, (com.sigmob.sdk.base.common.s) this.b.getSessionManager());
        }
        this.f.a(this.q);
        this.c.addView(this.q, new FrameLayout.LayoutParams(-1, -1));
        this.f.b(url);
    }

    public void b(boolean result) {
        if (result) {
            this.f.h();
        } else {
            this.f.g();
        }
    }

    public void c() {
        p pVar = this.q;
        if (pVar != null) {
            pVar.resumeTimers();
        }
        if (this.v) {
            this.f.a(true);
        }
        this.v = false;
    }

    public void c(boolean result) {
        if (result) {
            this.f.i();
        }
    }

    public void d() {
        this.f.a(new ExposureChange(100.0f, new Rect(0, 0, z().getWidth(), z().getHeight()), null));
    }

    public void d(boolean isFinishing) {
        this.v = true;
        p pVar = this.q;
        if (pVar != null) {
            pVar.b(isFinishing);
        }
    }

    public com.sigmob.sdk.mraid.b e() {
        return this.f;
    }

    protected void e(boolean useCustomClose) {
        this.h = useCustomClose;
        e eVar = this.n;
        if (eVar == null) {
            return;
        }
        eVar.useCustomCloseChanged(useCustomClose);
    }

    public Integer f() {
        Integer num = this.i;
        if (num != null) {
            return num;
        }
        this.f.b(new ValueCallback() { // from class: com.sigmob.sdk.mraid.d$$ExternalSyntheticLambda2
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                this.f$0.c((String) obj);
            }
        });
        return 0;
    }

    public p g() {
        return this.q;
    }

    boolean h() {
        Activity activityC = com.sigmob.sdk.base.utils.o.c(this.c);
        if (activityC == null || g() == null) {
            return false;
        }
        if (this.a != PlacementType.INLINE) {
            return true;
        }
        return this.g.a(activityC, g());
    }

    void i() {
        Context contextW = w();
        if (contextW == null) {
            return;
        }
        String str = ClientMetadata.getInstance().getOrientationInt().intValue() == 1 ? NativeRewardActivity.SCREEN_PORTRAIT : NativeRewardActivity.SCREEN_LANDSCAPE;
        DisplayMetrics displayMetrics = contextW.getResources().getDisplayMetrics();
        com.sigmob.sdk.base.common.f fVar = this.B;
        if (fVar == null) {
            this.e.a(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else {
            this.e.a(fVar.a(), this.B.b());
        }
        ViewGroup viewGroupZ = z();
        this.e.a(0, 0, viewGroupZ.getMeasuredWidth(), viewGroupZ.getMeasuredHeight());
        this.e.c(0, 0, viewGroupZ.getMeasuredWidth(), viewGroupZ.getMeasuredHeight());
        this.e.b(0, 0, viewGroupZ.getMeasuredWidth(), viewGroupZ.getMeasuredHeight());
        this.f.a(new CurrentAppOrientation(str, true));
        this.f.a(this.e);
    }

    void j() {
        final Context contextW = w();
        if (contextW == null) {
            return;
        }
        WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.mraid.d$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(contextW);
            }
        });
    }

    void k() {
        try {
            this.A = true;
            i();
            b(ViewState.DEFAULT);
            d();
            this.f.e();
            this.f.a(true);
            try {
                this.f.j();
                o();
                DeviceContext deviceContextB = com.sigmob.sdk.b.b();
                this.f.a(deviceContextB != null ? deviceContextB.getLocation() : ClientMetadata.getInstance().getLocation());
            } catch (Throwable unused) {
                SigmobLog.e("Failed to apply orientation.");
            }
        } catch (Throwable th) {
            SigmobLog.e("handlePageLoad error", th);
        }
    }

    public void l() {
        this.v = false;
        p pVar = this.q;
        if (pVar != null) {
            pVar.onResume();
        }
    }

    public void m() {
        this.d.a();
        this.n = null;
        this.m = null;
        Iterator<j> it = this.w.values().iterator();
        while (it.hasNext()) {
            it.next().c();
        }
        this.w.clear();
        try {
            this.r.a();
        } catch (Throwable unused) {
        }
        try {
            APKStatusBroadcastReceiver aPKStatusBroadcastReceiver = this.z;
            if (aPKStatusBroadcastReceiver != null) {
                aPKStatusBroadcastReceiver.b(aPKStatusBroadcastReceiver);
            }
        } catch (Throwable unused2) {
        }
        if (!this.v) {
            d(true);
        }
        y();
        p();
    }

    protected void n() {
        ViewState viewState;
        if (this.q == null || this.l == ViewState.LOADING || this.l == ViewState.HIDDEN) {
            return;
        }
        if (this.l == ViewState.EXPANDED || this.a == PlacementType.INTERSTITIAL) {
            p();
        }
        if (this.l == ViewState.RESIZED || this.l == ViewState.EXPANDED) {
            this.c.addView(this.q, new FrameLayout.LayoutParams(-1, -1));
            this.c.setVisibility(0);
            viewState = ViewState.DEFAULT;
        } else {
            if (this.l != ViewState.DEFAULT) {
                return;
            }
            this.c.setVisibility(4);
            viewState = ViewState.HIDDEN;
        }
        b(viewState);
    }

    void o() throws com.sigmob.sdk.mraid.c {
        int iA;
        if (this.u != k.NONE) {
            iA = this.u.a();
        } else {
            if (this.t) {
                p();
                return;
            }
            Activity activityC = com.sigmob.sdk.base.utils.o.c(this.c);
            if (activityC == null) {
                throw new com.sigmob.sdk.mraid.c("Unable to set MRAID expand orientation to 'none'; expected passed in Activity Context.");
            }
            iA = ClientMetadata.getInstance().getScreenOrientation(activityC);
        }
        b(iA);
    }

    void p() {
        Integer num;
        try {
            Activity activityC = com.sigmob.sdk.base.utils.o.c(this.c);
            if (activityC != null && (num = this.s) != null) {
                activityC.setRequestedOrientation(num.intValue());
            }
            this.s = null;
        } catch (Exception e2) {
            SigmobLog.e("unApplyOrientation: " + e2.getMessage());
        }
    }

    public FrameLayout q() {
        return this.c;
    }

    @Deprecated
    ViewState r() {
        return this.l;
    }

    @Deprecated
    Integer s() {
        return this.s;
    }

    @Deprecated
    boolean t() {
        return this.t;
    }

    @Deprecated
    k u() {
        return this.u;
    }

    @Deprecated
    p v() {
        return this.q;
    }
}
