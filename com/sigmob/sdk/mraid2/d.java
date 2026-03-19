package com.sigmob.sdk.mraid2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.IntentUtil;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.mraid2.c;
import com.sigmob.sdk.mraid2.d;
import com.sigmob.sdk.mraid2.g;
import com.sigmob.windad.WindAdError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d {
    private final FrameLayout a;
    private boolean b = false;
    private b c;
    private g d;
    private LinearLayout e;
    private l f;
    private c g;
    private final List<g> h;
    private final List<BaseAdUnit> i;
    private com.sigmob.sdk.base.common.f j;
    private WindowInsets k;
    private final g.b l;

    /* renamed from: com.sigmob.sdk.mraid2.d$2, reason: invalid class name */
    class AnonymousClass2 implements g.b {
        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(g gVar, int i, int i2) throws JSONException {
            com.sigmob.sdk.mraid2.c mraidBridge;
            if (gVar == null || (mraidBridge = gVar.getMraidBridge()) == null) {
                return;
            }
            mraidBridge.a(i, i2);
        }

        @Override // com.sigmob.sdk.mraid2.g.b
        public LinearLayout a(g mraid2WebView, int orientation) {
            if (d.this.e == null) {
                d.this.e = new LinearLayout(d.this.f());
            }
            if (d.this.f == null) {
                if (orientation == 1) {
                    d.this.f = new j(d.this.f());
                    d.this.e.setOrientation(0);
                } else {
                    d.this.f = new o(d.this.f());
                    d.this.e.setOrientation(1);
                }
                d.this.f.setPageChangedListener(new c.InterfaceC0744c() { // from class: com.sigmob.sdk.mraid2.d$2$$ExternalSyntheticLambda0
                    @Override // com.sigmob.sdk.mraid2.c.InterfaceC0744c
                    public final void onPageChanged(g gVar, int i, int i2) throws JSONException {
                        d.AnonymousClass2.a(gVar, i, i2);
                    }
                });
                d.this.f.getView().addView(d.this.e, new ViewGroup.LayoutParams(-1, -1));
                d.this.a.addView(d.this.f.getView(), 0, new ViewGroup.LayoutParams(-1, -1));
            }
            if (mraid2WebView != null && mraid2WebView.getScrollTouchListener() == null) {
                mraid2WebView.setScrollTouchListener(new g.c() { // from class: com.sigmob.sdk.mraid2.d.2.1
                    @Override // com.sigmob.sdk.mraid2.g.c
                    public void a(g view, JSONObject args) {
                        int iOptInt = args.optInt("x");
                        int iOptInt2 = args.optInt("y");
                        if (d.this.f == null) {
                            return;
                        }
                        d.this.f.a(view, Dips.asIntPixels(iOptInt, d.this.f()), Dips.asIntPixels(iOptInt2, d.this.f()));
                    }

                    @Override // com.sigmob.sdk.mraid2.g.c
                    public void a(JSONObject args) {
                        int iOptInt = args.optInt("x");
                        int iOptInt2 = args.optInt("y");
                        if (d.this.f == null) {
                            return;
                        }
                        d.this.f.a(Dips.asIntPixels(iOptInt, d.this.f()), Dips.asIntPixels(iOptInt2, d.this.f()));
                    }

                    @Override // com.sigmob.sdk.mraid2.g.c
                    public void b(JSONObject args) {
                        int iOptInt = args.optInt("x");
                        int iOptInt2 = args.optInt("y");
                        if (d.this.f == null) {
                            return;
                        }
                        d.this.f.b(Dips.asIntPixels(iOptInt, d.this.f()), Dips.asIntPixels(iOptInt2, d.this.f()));
                    }
                });
            }
            return d.this.e;
        }

        @Override // com.sigmob.sdk.mraid2.g.b
        public g a(g parentWebView, JSONObject args) {
            d dVar = d.this;
            g gVarA = dVar.a(dVar.f(), parentWebView, args);
            d.this.h.add(gVarA);
            return gVarA;
        }

        @Override // com.sigmob.sdk.mraid2.g.b
        public void a() {
            if (d.this.c == null) {
                return;
            }
            d.this.c.d();
        }

        @Override // com.sigmob.sdk.mraid2.g.b
        public void a(g webView) {
            if (d.this.c != null) {
                d.this.c.b();
            }
            if (d.this.h.isEmpty()) {
                return;
            }
            for (int i = 0; i < d.this.h.size(); i++) {
                ((g) d.this.h.get(i)).a();
            }
        }

        @Override // com.sigmob.sdk.mraid2.g.b
        public void a(g webView, BaseAdUnit adUnit, JSONObject args) {
            if (d.this.c == null) {
                return;
            }
            d.this.c.a(webView, adUnit, args);
        }

        @Override // com.sigmob.sdk.mraid2.g.b
        public void b(g webView) {
            if (d.this.c == null) {
                return;
            }
            d.this.c.c();
        }

        @Override // com.sigmob.sdk.mraid2.g.b
        public void b(g webView, JSONObject args) {
            d.this.b = args.optBoolean("flag");
            if (d.this.c == null) {
                return;
            }
            d.this.c.a(d.this.b);
        }
    }

    public interface a {
        void a();

        void a(int red, int green, int blue, int alpha);

        void a(BaseAdUnit adUnit);

        boolean a(final ConsoleMessage consoleMessage);

        boolean a(String message, JsResult result);

        void b();

        void c();

        void d();
    }

    public interface b {
        void a();

        void a(View view);

        void a(g webView, BaseAdUnit adUnit, JSONObject args);

        void a(final WindAdError error);

        void a(boolean useCustomClose);

        void b();

        void c();

        void d();
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

        public void a(final Context context) {
            Preconditions.checkNotNull(context);
            Context applicationContext = context.getApplicationContext();
            this.b = applicationContext;
            if (applicationContext == null) {
                return;
            }
            IntentUtil.registerReceiver(applicationContext, this, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws JSONException {
            int screenOrientation;
            if (this.b == null || !"android.intent.action.CONFIGURATION_CHANGED".equals(intent.getAction()) || (screenOrientation = ClientMetadata.getInstance().getScreenOrientation(d.this.f())) == this.c) {
                return;
            }
            this.c = screenOrientation;
            d.this.a(screenOrientation);
        }
    }

    public d(Context context, List<BaseAdUnit> adUnitList) {
        ArrayList arrayList = new ArrayList();
        this.h = arrayList;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        this.l = anonymousClass2;
        Preconditions.checkNotNull(context);
        this.i = adUnitList;
        FrameLayout frameLayout = new FrameLayout(context);
        this.a = frameLayout;
        frameLayout.setBackgroundColor(0);
        c cVar = new c();
        this.g = cVar;
        cVar.a(context);
        g gVar = new g(context, adUnitList, frameLayout);
        this.d = gVar;
        gVar.setLoadListener(new g.a() { // from class: com.sigmob.sdk.mraid2.d.1
            @Override // com.sigmob.sdk.mraid2.g.a
            public void a(g webView) {
                if (d.this.c == null) {
                    return;
                }
                try {
                    d.this.c.a(d.this.d);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.sigmob.sdk.mraid2.g.a
            public void a(WindAdError errorCode) {
                if (d.this.c == null) {
                    return;
                }
                try {
                    d.this.c.a(errorCode);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        this.d.setNextWebViewListener(anonymousClass2);
        arrayList.clear();
        arrayList.add(this.d);
        frameLayout.addView(this.d, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g a(Context context, g parentWebView, JSONObject args) {
        g gVar = new g(context, this.i, this.a, parentWebView, args);
        gVar.setAdSize(this.j);
        gVar.setNextWebViewListener(this.l);
        return gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context f() {
        FrameLayout frameLayout = this.a;
        if (frameLayout == null) {
            return null;
        }
        return frameLayout.getContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        SigmobLog.d("onShow end");
        b bVar = this.c;
        if (bVar == null) {
            return;
        }
        bVar.a(this.b);
    }

    public void a() throws JSONException {
        if (com.sigmob.sdk.base.utils.e.a(this.h)) {
            return;
        }
        for (int i = 0; i < this.h.size(); i++) {
            com.sigmob.sdk.mraid2.c mraidBridge = this.h.get(i).getMraidBridge();
            if (mraidBridge != null) {
                mraidBridge.a(false);
            }
        }
    }

    void a(int currentRotation) throws JSONException {
        SigmobLog.i("handleOrientationChange " + currentRotation);
        if (com.sigmob.sdk.base.utils.e.a(this.h)) {
            return;
        }
        for (int i = 0; i < this.h.size(); i++) {
            com.sigmob.sdk.mraid2.c mraidBridge = this.h.get(i).getMraidBridge();
            if (mraidBridge != null) {
                mraidBridge.e();
                mraidBridge.a(this.j);
            }
        }
    }

    public void a(WindowInsets windowInsets, boolean isLoaded) {
        this.k = windowInsets;
        SigmobLog.d("updateWindowInsets " + windowInsets);
        if (!isLoaded || com.sigmob.sdk.base.utils.e.a(this.h)) {
            return;
        }
        com.sigmob.sdk.base.utils.h hVarA = com.sigmob.sdk.videoplayer.c.a(windowInsets);
        for (int i = 0; i < this.h.size(); i++) {
            com.sigmob.sdk.mraid2.c mraidBridge = this.h.get(i).getMraidBridge();
            if (mraidBridge != null) {
                mraidBridge.a(hVarA.a(), hVarA.b(), hVarA.c(), hVarA.d());
            }
        }
    }

    public void a(com.sigmob.sdk.base.common.f adSize) {
        this.j = adSize;
        this.d.setAdSize(adSize);
        this.d.k();
    }

    public void a(BaseAdUnit adUnit) {
        SigmobLog.d("onShow start");
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.sigmob.sdk.mraid2.d$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.g();
            }
        }, 5 * 1000);
    }

    public void a(a mraid2ControllerListener) {
        this.d.getMraidBridge().a(mraid2ControllerListener);
    }

    public void a(b mraidListener) {
        this.c = mraidListener;
    }

    public void b() throws JSONException {
        if (com.sigmob.sdk.base.utils.e.a(this.h)) {
            return;
        }
        for (int i = 0; i < this.h.size(); i++) {
            g gVar = this.h.get(i);
            gVar.j();
            com.sigmob.sdk.mraid2.c mraidBridge = gVar.getMraidBridge();
            if (mraidBridge != null) {
                mraidBridge.a(true);
            }
        }
    }

    public g c() {
        return this.d;
    }

    public void d() {
        c cVar = this.g;
        if (cVar != null) {
            cVar.a();
            this.g = null;
        }
        try {
            Iterator<g> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            this.h.clear();
            this.d = null;
            this.c = null;
        } catch (Throwable unused) {
        }
    }

    public FrameLayout e() {
        return this.a;
    }
}
