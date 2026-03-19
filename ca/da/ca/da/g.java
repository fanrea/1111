package ca.da.ca.da;

import android.os.Bundle;
import android.text.TextUtils;
import ca.da.ca.ia.h;
import ca.da.ca.ia.j;
import ca.da.ca.ia.m;
import ca.da.ca.ja.r;
import com.apm.applog.AppLog;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.apm.common.utility.NetworkUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/* compiled from: Session.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class g {
    public static long n;
    public static long o;
    public static b p;
    public final ca.da.ca.da.b a;
    public final AppLog b;
    public j c;
    public j d;
    public String e;
    public volatile long f;
    public int g;
    public long h = -1;
    public volatile boolean i;
    public long j;
    public int k;
    public String l;
    public volatile String m;

    /* compiled from: Session.java */
    public static class b extends m {
        public /* synthetic */ b(a aVar) {
        }
    }

    public g(ca.da.ca.da.b bVar) {
        this.a = bVar;
        this.b = AppLog.getInstance(bVar.f.a());
    }

    public static long d() {
        long j = o + 1;
        o = j;
        return j;
    }

    public synchronized Bundle a(long j, long j2) {
        Bundle bundle;
        bundle = null;
        long j3 = this.f;
        if (this.a.c.b.isPlayEnable() && b() && j3 > 0) {
            long j4 = j - j3;
            if (j4 > j2) {
                bundle = new Bundle();
                bundle.putInt("session_no", this.k);
                int i = this.g + 1;
                this.g = i;
                bundle.putInt("send_times", i);
                bundle.putLong("current_duration", j4 / 1000);
                bundle.putString("session_start_time", ca.da.ca.ia.b.k.format(new Date(this.h)));
                this.f = j;
            }
        }
        return bundle;
    }

    public boolean b() {
        return this.i && this.j == 0;
    }

    public void c() {
        try {
            this.e = UUID.randomUUID().toString();
            this.i = ca.da.ca.ca.a.a() != null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean b(ca.da.ca.ia.b bVar) {
        if (bVar instanceof j) {
            return ((j) bVar).h();
        }
        return false;
    }

    public synchronized h a(ca.da.ca.ia.b bVar, ArrayList<ca.da.ca.ia.b> arrayList, boolean z) {
        h hVar;
        long j = bVar instanceof b ? -1L : bVar.b;
        this.e = UUID.randomUUID().toString();
        if (z && !this.a.r && TextUtils.isEmpty(this.m)) {
            this.m = this.e;
        }
        o = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
        this.h = j;
        this.i = z;
        this.j = 0L;
        this.f = 0L;
        if (z) {
            Calendar calendar = Calendar.getInstance();
            String string = ca.ca.ca.ca.a.a("").append(calendar.get(1)).append(calendar.get(2)).append(calendar.get(5)).toString();
            ca.da.ca.fa.g gVar = this.a.c;
            if (TextUtils.isEmpty(this.l)) {
                this.l = gVar.d.getString("session_last_day", "");
                this.k = gVar.d.getInt("session_order", 0);
            }
            if (!string.equals(this.l)) {
                this.l = string;
                this.k = 1;
            } else {
                this.k++;
            }
            gVar.d.edit().putString("session_last_day", string).putInt("session_order", this.k).apply();
            this.g = 0;
            this.f = bVar.b;
        }
        hVar = null;
        if (j != -1) {
            hVar = new h();
            hVar.d = this.e;
            hVar.n = !this.i;
            hVar.c = d();
            hVar.a(this.h);
            hVar.m = this.a.f.i();
            hVar.l = this.a.f.h();
            hVar.e = n;
            hVar.f = this.b.getUserUniqueID();
            hVar.g = this.b.getSsid();
            hVar.h = this.b.getAbSdkVersion();
            if (z) {
                this.a.c.g();
            }
            hVar.p = 0;
            if (z && hVar.p == 1) {
                this.a.c.l();
            }
            arrayList.add(hVar);
        }
        if (AppLog.sLaunchFrom <= 0) {
            AppLog.sLaunchFrom = 6;
        }
        r.a(ca.ca.ca.ca.a.a("startSession, ").append(this.i ? "fg" : "bg").append(", ").append(this.e).toString());
        return hVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(ca.da.ca.ia.b r17, java.util.ArrayList<ca.da.ca.ia.b> r18) {
        /*
            Method dump skipped, instructions count: 235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ca.da.ca.da.g.a(ca.da.ca.ia.b, java.util.ArrayList):boolean");
    }

    public void a(ca.da.ca.ia.b bVar) {
        if (bVar != null) {
            bVar.e = n;
            bVar.f = this.b.getUserUniqueID();
            bVar.g = this.b.getSsid();
            bVar.d = this.e;
            bVar.c = d();
            bVar.h = this.b.getAbSdkVersion();
            bVar.i = NetworkUtils.NetworkType.UNKNOWN.getValue();
        }
    }

    public Map<String, String> a() {
        try {
            return AppLog.getInstance(this.a.c.c()).getSessionTags();
        } catch (Throwable unused) {
            return null;
        }
    }
}
