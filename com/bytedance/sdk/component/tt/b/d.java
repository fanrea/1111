package com.bytedance.sdk.component.tt.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mobads.container.util.cm;
import com.bytedance.sdk.component.tc.tc;
import com.bytedance.sdk.component.tt.d;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.component.utils.zw;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d implements zw.d {
    private static boolean gb;
    private static ThreadPoolExecutor tt;
    private final boolean hc;
    private int k;
    private final Context mk;
    private com.bytedance.sdk.component.tt.d uo;
    private volatile boolean b = false;
    private boolean c = true;
    private boolean u = false;
    private long an = 0;
    private long h = 0;
    private AtomicBoolean tc = new AtomicBoolean(false);
    private volatile boolean mq = false;
    final zw d = com.bytedance.sdk.component.tc.hc.d.d().d(this, "tt-net");

    public d(Context context, int i) {
        this.mk = context;
        this.hc = w.d(context);
        this.k = i;
    }

    public void d() {
        d(false);
    }

    public synchronized void d(boolean z) {
        if (this.hc) {
            c(z);
            return;
        }
        if (this.an <= 0) {
            try {
                h().execute(new Runnable() { // from class: com.bytedance.sdk.component.tt.b.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.hc();
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    public static void hc(boolean z) {
        gb = z;
    }

    public Context getContext() {
        return this.mk;
    }

    public static void d(Context context, int i) {
        d dVarD;
        if (gb && (dVarD = h.d().d(i, context)) != null) {
            if (w.d(context)) {
                dVarD.d(true);
            } else {
                dVarD.d();
            }
        }
    }

    synchronized void hc() {
        if (System.currentTimeMillis() - this.an > 3600000) {
            this.an = System.currentTimeMillis();
            try {
                if (h.d().d(this.k).gb() != null) {
                    h.d().d(this.k).gb().hc();
                }
            } catch (Exception unused) {
            }
        }
    }

    private void c(boolean z) {
        if (this.u) {
            return;
        }
        if (this.c) {
            this.c = false;
            this.an = 0L;
            this.h = 0L;
        }
        long j = z ? 360000L : 43200000L;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.an > j) {
            if (jCurrentTimeMillis - this.h > 120000 || !this.mq) {
                b();
            }
        }
    }

    public boolean b() {
        com.bytedance.sdk.component.tt.c.b.hc("TNCManager", "doRefresh: updating state " + this.tc.get());
        h().execute(new Runnable() { // from class: com.bytedance.sdk.component.tt.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                boolean zD = com.bytedance.sdk.component.tt.c.an.d(d.this.mk);
                if (zD) {
                    d.this.h = System.currentTimeMillis();
                    if (!d.this.tc.compareAndSet(false, true)) {
                        com.bytedance.sdk.component.tt.c.b.hc("TNCManager", "doRefresh, already running");
                    } else {
                        d.this.b(zD);
                    }
                }
            }
        });
        return true;
    }

    @Override // com.bytedance.sdk.component.utils.zw.d
    public void d(Message message) {
        int i = message.what;
        if (i == 101) {
            this.u = false;
            this.an = System.currentTimeMillis();
            com.bytedance.sdk.component.tt.c.b.hc("TNCManager", "doRefresh, succ");
            if (this.c) {
                d();
            }
            this.tc.set(false);
            return;
        }
        if (i != 102) {
            return;
        }
        this.u = false;
        if (this.c) {
            d();
        }
        com.bytedance.sdk.component.tt.c.b.hc("TNCManager", "doRefresh, error");
        this.tc.set(false);
    }

    public synchronized void c() {
        if (this.mq) {
            return;
        }
        this.mq = true;
        long j = com.bytedance.sdk.openadsdk.api.plugin.hc.hc(this.mk, "ss_app_config", 0).getLong("last_refresh_time", 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (j > jCurrentTimeMillis) {
            j = jCurrentTimeMillis;
        }
        this.an = j;
        try {
            if (h.d().d(this.k).gb() != null) {
                h.d().d(this.k).gb().d();
            }
        } catch (Exception unused) {
        }
    }

    public void u() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        try {
            if (this.hc) {
                c();
            } else {
                hc();
            }
        } catch (Throwable unused) {
        }
    }

    void b(boolean z) {
        com.bytedance.sdk.component.tt.c.b.hc("TNCManager", "doRefresh, actual request");
        c();
        this.u = true;
        if (!z) {
            this.d.sendEmptyMessage(102);
            return;
        }
        try {
            gb();
        } catch (Exception unused) {
            this.tc.set(false);
        }
    }

    public String[] an() {
        String[] strArrAn = h.d().d(this.k).c() != null ? h.d().d(this.k).c().an() : null;
        return (strArrAn == null || strArrAn.length <= 0) ? new String[0] : strArrAn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(Object obj) throws Exception {
        JSONObject jSONObject;
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            jSONObject = new JSONObject(str);
            if (!"success".equals(jSONObject.getString(cm.V))) {
                return false;
            }
        } else {
            jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
        }
        if (jSONObject == null) {
            return false;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        synchronized (this) {
            SharedPreferences.Editor editorEdit = com.bytedance.sdk.openadsdk.api.plugin.hc.hc(this.mk, "ss_app_config", 0).edit();
            editorEdit.putLong("last_refresh_time", System.currentTimeMillis());
            editorEdit.apply();
        }
        if (h.d().d(this.k).gb() == null) {
            return true;
        }
        h.d().d(this.k).gb().d(jSONObject2);
        return true;
    }

    private boolean gb() {
        String[] strArrAn = an();
        if (strArrAn != null && strArrAn.length != 0) {
            d(0);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final int i) {
        String[] strArrAn = an();
        if (strArrAn == null || strArrAn.length <= i) {
            hc(102);
            return;
        }
        String str = strArrAn[i];
        if (TextUtils.isEmpty(str)) {
            hc(102);
            return;
        }
        try {
            String strD = d(str);
            if (TextUtils.isEmpty(strD)) {
                hc(102);
                return;
            }
            com.bytedance.sdk.component.tt.hc.b bVarB = tt().b();
            bVarB.d(strD);
            d(bVarB);
            bVarB.d(new com.bytedance.sdk.component.tt.d.d() { // from class: com.bytedance.sdk.component.tt.b.d.3
                @Override // com.bytedance.sdk.component.tt.d.d
                public void d(com.bytedance.sdk.component.tt.hc.c cVar, com.bytedance.sdk.component.tt.hc hcVar) throws JSONException {
                    JSONObject jSONObject;
                    if (hcVar == null || !hcVar.gb()) {
                        d.this.d(i + 1);
                        return;
                    }
                    String string = null;
                    try {
                        jSONObject = new JSONObject(hcVar.c());
                    } catch (Exception unused) {
                        jSONObject = null;
                    }
                    if (jSONObject == null) {
                        d.this.d(i + 1);
                        return;
                    }
                    try {
                        string = jSONObject.getString(cm.V);
                    } catch (Exception unused2) {
                    }
                    if (!"success".equals(string)) {
                        d.this.d(i + 1);
                        return;
                    }
                    try {
                        if (d.this.d(jSONObject)) {
                            d.this.hc(101);
                        } else {
                            d.this.d(i + 1);
                        }
                    } catch (Exception unused3) {
                    }
                }

                @Override // com.bytedance.sdk.component.tt.d.d
                public void d(com.bytedance.sdk.component.tt.hc.c cVar, IOException iOException) {
                    d.this.d(i + 1);
                }
            });
        } catch (Throwable th) {
            com.bytedance.sdk.component.tt.c.b.hc("AppConfig", "try app config exception: ".concat(String.valueOf(th)));
        }
    }

    private com.bytedance.sdk.component.tt.d tt() {
        if (this.uo == null) {
            this.uo = new d.C0286d().d(10L, TimeUnit.SECONDS).hc(10L, TimeUnit.SECONDS).b(10L, TimeUnit.SECONDS).d();
        }
        return this.uo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc(int i) {
        zw zwVar = this.d;
        if (zwVar != null) {
            zwVar.sendEmptyMessage(i);
        }
    }

    private String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("https://").append(str).append("/get_domains/v4/");
        return sb.toString();
    }

    private void d(com.bytedance.sdk.component.tt.hc.b bVar) {
        String str;
        if (bVar == null) {
            return;
        }
        Address addressD = h.d().d(this.k).c() != null ? h.d().d(this.k).c().d(this.mk) : null;
        if (addressD != null && addressD.hasLatitude() && addressD.hasLongitude()) {
            bVar.d("latitude", new StringBuilder().append(addressD.getLatitude()).toString());
            bVar.d("longitude", new StringBuilder().append(addressD.getLongitude()).toString());
            String locality = addressD.getLocality();
            if (!TextUtils.isEmpty(locality)) {
                bVar.d("city", Uri.encode(locality));
            }
        }
        if (this.b) {
            bVar.d("force", "1");
        }
        try {
            if (Build.VERSION.SDK_INT < 21) {
                str = Build.CPU_ABI;
            } else {
                str = Build.SUPPORTED_ABIS[0];
            }
            bVar.d("abi", str);
        } catch (Throwable th) {
            mq.d(th);
        }
        if (h.d().d(this.k).c() != null) {
            bVar.d("aid", new StringBuilder().append(h.d().d(this.k).c().d()).toString());
            bVar.d("device_platform", h.d().d(this.k).c().b());
            bVar.d("channel", h.d().d(this.k).c().hc());
            bVar.d("version_code", new StringBuilder().append(h.d().d(this.k).c().c()).toString());
            bVar.d("custom_info_1", h.d().d(this.k).c().u());
        }
    }

    public static ThreadPoolExecutor h() {
        if (tt == null) {
            synchronized (d.class) {
                if (tt == null) {
                    com.bytedance.sdk.component.tc.c.c cVar = new com.bytedance.sdk.component.tc.c.c(2, 2, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new tc("tnc/AppConfig"));
                    tt = cVar;
                    cVar.allowCoreThreadTimeOut(true);
                }
            }
        }
        return tt;
    }

    public static void d(ThreadPoolExecutor threadPoolExecutor) {
        tt = threadPoolExecutor;
    }
}
