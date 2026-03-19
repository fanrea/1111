package lkxssdk.w;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class h implements lkxssdk.y.c {
    public lkxssdk.w.b a;
    public lkxssdk.w.a b;
    public d g;
    public final Object h = new Object();
    public BroadcastReceiver k = new a();
    public e i = new e();
    public List<g> f = new ArrayList();
    public List<g> c = new ArrayList();
    public HashMap<String, g> d = new HashMap<>();
    public Handler j = new Handler(Looper.getMainLooper());
    public HashMap<String, CountDownTimer> e = new HashMap<>();

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            h hVar;
            String schemeSpecificPart;
            boolean z;
            if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED") || intent.getAction().equals("android.intent.action.PACKAGE_REPLACED")) {
                hVar = h.this;
                schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                z = true;
            } else {
                if (!intent.getAction().equals("android.intent.action.PACKAGE_REMOVED") && !intent.getAction().equals("android.intent.action.PACKAGE_FULLY_REMOVED")) {
                    return;
                }
                hVar = h.this;
                schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                z = false;
            }
            h.a(hVar, schemeSpecificPart, z);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ String a;

        public class a extends CountDownTimer {
            public a(long j, long j2) {
                super(j, j2);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                b bVar = b.this;
                h.this.e.remove(bVar.a);
                b bVar2 = b.this;
                g gVar = h.this.d.get(bVar2.a);
                if (gVar != null) {
                    lkxssdk.h0.c.c("DownloadTaskManager", "taskKey:" + b.this.a + ",retry download");
                    gVar.a(true);
                    h.this.a.d.i.execute(gVar);
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }
        }

        public b(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            if (hVar.a.d.f > 1000) {
                CountDownTimer countDownTimerStart = new a(h.this.a.d.f, 1000L).start();
                lkxssdk.h0.c.c("DownloadTaskManager", "taskKey:" + this.a + ",retry download:" + h.this.a.d.f + " ms later");
                h.this.e.put(this.a, countDownTimerStart);
            } else {
                g gVar = hVar.d.get(this.a);
                if (gVar != null) {
                    lkxssdk.h0.c.c("DownloadTaskManager", "taskKey:" + this.a + ",retry download");
                    gVar.a(true);
                    h.this.a.d.i.execute(gVar);
                }
            }
        }
    }

    public h(lkxssdk.w.a aVar) {
        this.b = aVar;
        this.a = new lkxssdk.w.b(aVar);
        this.g = new d(aVar.a);
        a();
    }

    public static void a(h hVar, String str, boolean z) {
        hVar.getClass();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (hVar.h) {
            for (g gVar : hVar.f) {
                String str2 = gVar.b.i.d;
                if (!TextUtils.isEmpty(str2) && str2.equals(str)) {
                    if (z) {
                        gVar.f.a(gVar.a, str);
                    } else {
                        gVar.q = false;
                        gVar.i = null;
                        gVar.f.k(gVar.a);
                    }
                    gVar.e();
                } else if (!TextUtils.isEmpty(null)) {
                    throw null;
                }
            }
        }
    }

    public final String a(String str, String str2) {
        StringBuilder sbAppend = new StringBuilder().append(str);
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        return lkxssdk.a0.c.a(sbAppend.append(str2).toString());
    }

    public final g a(String str, List<g> list) {
        if (!TextUtils.isEmpty(str) && list != null && list.size() != 0) {
            for (g gVar : list) {
                if (gVar.b.a.equals(str)) {
                    return gVar;
                }
            }
        }
        return null;
    }

    public void a(String str, boolean z) {
        synchronized (this.h) {
            if (z) {
                this.j.post(new b(str));
            } else {
                this.d.remove(str);
                if (this.c.size() > 0) {
                    g gVarRemove = this.c.remove(0);
                    this.d.put(gVarRemove.b.a, gVarRemove);
                    gVarRemove.a(false);
                    this.a.d.i.execute(gVarRemove);
                }
            }
        }
    }

    public final void a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_FULLY_REMOVED");
        intentFilter.addDataScheme("package");
        this.a.d.a.registerReceiver(this.k, intentFilter);
    }
}
