package com.bytedance.sdk.component.adexpress.u;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.d.yi;
import com.bytedance.sdk.component.utils.gb;
import com.bytedance.sdk.component.widget.SSWebView;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u {
    private static int an = 10;
    private static int h = 10;
    private static volatile u tt;
    private static final byte[] u = new byte[0];
    private final AtomicBoolean gb = new AtomicBoolean(false);
    private final List<SSWebView> d = new ArrayList();
    private final List<SSWebView> hc = new ArrayList();
    private final WeakHashMap<com.bytedance.sdk.component.uo.b, b> b = new WeakHashMap<>();
    private final WeakHashMap<com.bytedance.sdk.component.uo.b, c> c = new WeakHashMap<>();

    private u() {
        com.bytedance.sdk.component.adexpress.d.d.b bVarB = com.bytedance.sdk.component.adexpress.d.d.d.d().b();
        if (bVarB != null) {
            an = bVarB.gb();
            h = bVarB.tt();
        }
    }

    public static u d() {
        if (tt == null) {
            synchronized (u.class) {
                if (tt == null) {
                    tt = new u();
                }
            }
        }
        return tt;
    }

    public SSWebView d(Context context, String str) {
        SSWebView sSWebViewRemove;
        if (c() <= 0 || (sSWebViewRemove = this.hc.remove(0)) == null) {
            return null;
        }
        this.hc.size();
        return sSWebViewRemove;
    }

    public void d(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        if (this.hc.size() >= h) {
            sSWebView.destroy();
        } else {
            if (this.hc.contains(sSWebView)) {
                return;
            }
            this.hc.add(sSWebView);
            this.hc.size();
        }
    }

    public void hc(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        sSWebView.G_();
        an(sSWebView);
        d(sSWebView);
    }

    public SSWebView hc(Context context, String str) {
        SSWebView sSWebViewRemove;
        if (b() <= 0 || (sSWebViewRemove = this.d.remove(0)) == null) {
            return null;
        }
        b();
        return sSWebViewRemove;
    }

    public void b(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        sSWebView.G_();
        an(sSWebView);
        c(sSWebView);
    }

    public void c(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        if (this.d.size() >= an) {
            sSWebView.destroy();
        } else {
            if (this.d.contains(sSWebView)) {
                return;
            }
            this.d.add(sSWebView);
            b();
        }
    }

    public boolean u(SSWebView sSWebView) {
        if (sSWebView == null) {
            return false;
        }
        sSWebView.destroy();
        return true;
    }

    public void hc() {
        for (SSWebView sSWebView : this.d) {
            if (sSWebView != null) {
                sSWebView.destroy();
            }
        }
        this.d.clear();
        for (SSWebView sSWebView2 : this.hc) {
            if (sSWebView2 != null) {
                sSWebView2.destroy();
            }
        }
        this.hc.clear();
        synchronized (this.c) {
            this.c.clear();
        }
    }

    public int b() {
        return this.d.size();
    }

    public int c() {
        return this.hc.size();
    }

    public int u() {
        return this.d.size() + c();
    }

    public void d(SSWebView sSWebView, hc hcVar) {
        if (sSWebView == null || hcVar == null) {
            return;
        }
        b bVar = this.b.get(sSWebView);
        if (bVar != null) {
            bVar.d(hcVar);
        } else {
            bVar = new b(hcVar);
            this.b.put(sSWebView, bVar);
        }
        sSWebView.addJavascriptInterface(bVar, "SDK_INJECT_GLOBAL");
    }

    public void an(SSWebView sSWebView) {
        b bVar;
        if (sSWebView == null || (bVar = this.b.get(sSWebView)) == null) {
            return;
        }
        bVar.d(null);
    }

    private static void d(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            gb.hc().post(runnable);
        }
    }

    public void d(final com.bytedance.sdk.component.uo.b bVar, yi yiVar, final String str) {
        final c cVar;
        if (bVar == null || yiVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.c) {
            cVar = this.c.get(bVar);
            if (cVar != null) {
                cVar.d(yiVar);
            } else {
                cVar = new c(yiVar);
                this.c.put(bVar, cVar);
            }
        }
        d(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.u.u.1
            @Override // java.lang.Runnable
            public void run() {
                bVar.addJavascriptInterface(cVar, str);
            }
        });
    }

    public void d(final com.bytedance.sdk.component.uo.b bVar, final String str) {
        if (bVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.c) {
            c cVar = this.c.get(bVar);
            if (cVar != null) {
                cVar.d(null);
            }
        }
        d(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.u.u.2
            @Override // java.lang.Runnable
            public void run() {
                bVar.removeJavascriptInterface(str);
            }
        });
    }
}
