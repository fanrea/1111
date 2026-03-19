package com.kwad.sdk.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.components.p;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.utils.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b {
    private static final Map<String, String> bte = new HashMap();
    private final AtomicBoolean btf;
    private final AtomicBoolean btg;
    private final AtomicBoolean bth;
    private final AtomicBoolean bti;
    private final List<String> btj;
    private final List<String> btk;
    private final d btl;
    private final BroadcastReceiver btm;
    private Context mContext;
    private final List<com.kwad.sdk.app.a> mListeners;

    /* synthetic */ b(byte b) {
        this();
    }

    static class a {
        private static final b btp = new b(0);
    }

    private b() {
        this.btf = new AtomicBoolean();
        this.btg = new AtomicBoolean();
        this.bth = new AtomicBoolean();
        this.bti = new AtomicBoolean();
        this.mListeners = new CopyOnWriteArrayList();
        this.btj = new CopyOnWriteArrayList();
        this.btk = new CopyOnWriteArrayList();
        this.btl = new d() { // from class: com.kwad.sdk.app.b.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                try {
                    b.this.Wh();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
        this.btm = new BroadcastReceiver() { // from class: com.kwad.sdk.app.b.3
            Intent bto;

            private boolean d(Intent intent) {
                boolean z = TextUtils.equals(this.bto.getAction(), intent.getAction()) && TextUtils.equals(this.bto.getPackage(), intent.getPackage()) && this.bto.getFlags() == intent.getFlags() && TextUtils.equals(this.bto.getDataString(), intent.getDataString());
                this.bto = intent;
                return z;
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                Uri data;
                try {
                    c.d("AppInstallManager", "onReceive intent: " + intent.toString());
                    if (intent == null) {
                        return;
                    }
                    if (this.bto == null) {
                        this.bto = intent;
                    } else if (d(intent)) {
                        return;
                    }
                    String action = intent.getAction();
                    if (TextUtils.isEmpty(action) || (data = intent.getData()) == null) {
                        return;
                    }
                    String schemeSpecificPart = data.getSchemeSpecificPart();
                    if (TextUtils.isEmpty(schemeSpecificPart)) {
                        return;
                    }
                    b.this.mContext = context;
                    if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", action)) {
                        b.this.K(context, schemeSpecificPart);
                    } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", action)) {
                        b.this.dM(schemeSpecificPart);
                    }
                } catch (Throwable th) {
                    c.printStackTrace(th);
                }
            }
        };
    }

    public static b Wd() {
        return a.btp;
    }

    public final synchronized void init() {
        try {
            if (this.btg.get()) {
                return;
            }
            Wg();
            if (((h) ServiceProvider.get(h.class)).Uz()) {
                com.kwad.sdk.core.c.b.aaf();
                if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                    Wj();
                }
                We();
            } else {
                Wj();
            }
            this.btg.set(true);
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
        }
    }

    private void We() {
        com.kwad.sdk.core.c.b.aaf();
        com.kwad.sdk.core.c.b.a(new d() { // from class: com.kwad.sdk.app.b.2
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                try {
                    b.this.Wi();
                } catch (Throwable th) {
                    c.printStackTraceOnly(th);
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                try {
                    b.this.Wh();
                    b.this.Wj();
                } catch (Throwable th) {
                    c.printStackTraceOnly(th);
                }
            }
        });
    }

    private void Wf() {
        if (this.bti.get()) {
            return;
        }
        com.kwad.sdk.core.c.b.aaf();
        com.kwad.sdk.core.c.b.a(this.btl);
        this.bti.set(true);
    }

    private void Wg() {
        if (this.bti.get()) {
            com.kwad.sdk.core.c.b.aaf();
            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this.btl);
            this.bti.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wh() {
        Context contextAnu = ServiceProvider.anu();
        bs(contextAnu);
        Iterator<AdTemplate> it = ((f) ServiceProvider.get(f.class)).TW().iterator();
        while (it.hasNext()) {
            AdInfo adInfoEP = e.eP(it.next());
            int iBK = com.kwad.sdk.core.response.b.a.bK(adInfoEP);
            String strAB = com.kwad.sdk.core.response.b.a.aB(adInfoEP);
            if (iBK != 12) {
                if (as.aF(contextAnu, strAB)) {
                    K(contextAnu, strAB);
                }
            } else if (!as.aF(contextAnu, strAB)) {
                dM(strAB);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wi() {
        if (this.bth.get()) {
            ServiceProvider.anu().unregisterReceiver(this.btm);
            this.bth.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wj() {
        if (this.bth.get()) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        ServiceProvider.anu().registerReceiver(this.btm, intentFilter);
        this.bth.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(Context context, String str) {
        c.d("AppInstallManager", "installApp packageName: " + str);
        N(context, str);
        dP(str);
        L(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dM(String str) {
        c.d("AppInstallManager", "unInstallApp packageName: " + str);
        dR(str);
        dQ(str);
        dN(str);
    }

    private void L(Context context, String str) {
        com.kwad.sdk.core.c.b.aaf();
        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
            M(context, str);
            return;
        }
        this.btj.add(str);
        com.kwad.sdk.core.c.b.aaf();
        com.kwad.sdk.core.c.b.a(new d() { // from class: com.kwad.sdk.app.b.4
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                if (b.this.btj.size() > 0) {
                    for (int i = 0; i < b.this.btj.size(); i++) {
                        b.M(b.this.mContext, (String) b.this.btj.get(i));
                    }
                    b.this.btj.clear();
                }
                com.kwad.sdk.core.c.b.aaf();
                com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            }
        });
    }

    private void dN(String str) {
        com.kwad.sdk.core.c.b.aaf();
        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
            dO(str);
            return;
        }
        this.btk.add(str);
        com.kwad.sdk.core.c.b.aaf();
        com.kwad.sdk.core.c.b.a(new d() { // from class: com.kwad.sdk.app.b.5
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                if (b.this.btk.size() > 0) {
                    for (int i = 0; i < b.this.btk.size(); i++) {
                        b.dO((String) b.this.btk.get(i));
                    }
                    b.this.btk.clear();
                }
                com.kwad.sdk.core.c.b.aaf();
                com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void M(Context context, String str) {
        try {
            p pVar = (p) com.kwad.sdk.components.d.g(p.class);
            if (pVar == null || !s.aob()) {
                return;
            }
            ((com.kwad.sdk.service.a.b) ServiceProvider.get(com.kwad.sdk.service.a.b.class)).e(pVar.e(context, str), 1);
        } catch (Throwable th) {
            c.printStackTrace(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dO(String str) {
        try {
            p pVar = (p) com.kwad.sdk.components.d.g(p.class);
            if (pVar == null || !s.aob()) {
                return;
            }
            ((com.kwad.sdk.service.a.b) ServiceProvider.get(com.kwad.sdk.service.a.b.class)).e(pVar.E(str), 2);
        } catch (Throwable th) {
            c.printStackTrace(th);
        }
    }

    public final void a(com.kwad.sdk.app.a aVar) {
        if (aVar == null) {
            return;
        }
        Wf();
        this.mListeners.add(aVar);
    }

    public final void b(com.kwad.sdk.app.a aVar) {
        if (aVar == null) {
            return;
        }
        Wf();
        this.mListeners.remove(aVar);
    }

    private void dP(String str) {
        Iterator<com.kwad.sdk.app.a> it = this.mListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().W(str);
            } catch (Throwable th) {
                c.printStackTrace(th);
            }
        }
    }

    private void dQ(String str) {
        Iterator<com.kwad.sdk.app.a> it = this.mListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().X(str);
            } catch (Throwable th) {
                c.printStackTrace(th);
            }
        }
    }

    public final String getVersion(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        br(context);
        return bte.get(str);
    }

    private synchronized void br(Context context) {
        if (this.btf.get()) {
            return;
        }
        N(context, "com.smile.gifmaker");
        N(context, "com.kuaishou.nebula");
        N(context, "com.tencent.mm");
        this.btf.set(true);
    }

    private void bs(Context context) {
        if (this.btf.get()) {
            for (String str : bte.keySet()) {
                String str2 = bte.get(str);
                String strAc = m.ac(context, str);
                if (!TextUtils.isEmpty(strAc) && !TextUtils.equals(str2, strAc)) {
                    K(context, str);
                } else if (TextUtils.isEmpty(strAc) && !TextUtils.isEmpty(str2)) {
                    dM(str);
                }
            }
        }
    }

    private static void N(Context context, String str) {
        str.hashCode();
        switch (str) {
            case "com.tencent.mm":
                bte.put("com.tencent.mm", m.ac(context, "com.tencent.mm"));
                break;
            case "com.kuaishou.nebula":
                bte.put("com.kuaishou.nebula", m.ac(context, "com.kuaishou.nebula"));
                break;
            case "com.smile.gifmaker":
                bte.put("com.smile.gifmaker", m.ac(context, "com.smile.gifmaker"));
                break;
        }
    }

    private static void dR(String str) {
        str.hashCode();
        switch (str) {
            case "com.tencent.mm":
                bte.put("com.tencent.mm", "");
                break;
            case "com.kuaishou.nebula":
                bte.put("com.kuaishou.nebula", "");
                break;
            case "com.smile.gifmaker":
                bte.put("com.smile.gifmaker", "");
                break;
        }
    }
}
