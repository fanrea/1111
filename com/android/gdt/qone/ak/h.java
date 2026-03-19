package com.android.gdt.qone.ak;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.android.gdt.qone.foundation.net.protocol.CMD;
import com.android.gdt.qone.report.beat.BeatType;
import com.android.gdt.qone.uin.U;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.sigmob.sdk.base.mta.PointType;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class h implements Runnable {
    public static final ConcurrentHashMap i = new ConcurrentHashMap();
    public static PriorityQueue j;
    public o a;
    public com.android.gdt.qone.u.b b;
    public final AtomicBoolean c;
    public long d;
    public long e;
    public boolean f;
    public final String g;
    public final g h;

    public h(String str) {
        new AtomicInteger();
        this.c = new AtomicBoolean(false);
        this.f = false;
        this.g = "";
        this.h = new g(new f(this));
        this.g = str;
        PriorityQueue priorityQueue = new PriorityQueue();
        Random random = new Random(com.android.gdt.qone.ae.d.class.hashCode());
        for (int i2 = 0; i2 < 3; i2++) {
            priorityQueue.offer(Integer.valueOf(random.nextInt(5) + 8));
        }
        j = priorityQueue;
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException {
        String string;
        com.android.gdt.qone.w.c cVar;
        long j2;
        long j3;
        Context context;
        Context context2;
        if (this.c.get()) {
            com.android.gdt.qone.af.c.b("QM", "QM is requesting,cancel this request(appKey: %s)", this.g);
            return;
        }
        this.c.set(true);
        if (!com.android.gdt.qone.ac.a.b()) {
            com.android.gdt.qone.af.c.b("QM", "no network,cancel QM request(appKey: %s)", this.g);
            this.c.set(false);
            return;
        }
        if (!com.android.gdt.qone.w.a.g()) {
            com.android.gdt.qone.at.a.a(this.g);
            com.android.gdt.qone.u.b bVar = new com.android.gdt.qone.u.b(this);
            this.b = bVar;
            bVar.a();
            c.a(this.g).a(com.android.gdt.qone.ap.f.b(this.g));
            b bVar2 = c.a(this.g).b;
            if (bVar2 != null && !bVar2.c()) {
                Process.myPid();
                new com.android.gdt.qone.ar.a(this.g).d();
                com.android.gdt.qone.u.b bVar3 = this.b;
                if (bVar3 != null && (context2 = bVar3.b) != null) {
                    try {
                        context2.unregisterReceiver(bVar3);
                        Process.myPid();
                    } catch (IllegalArgumentException e) {
                        com.android.gdt.qone.af.c.a(e);
                    }
                }
            }
            this.c.set(false);
            return;
        }
        this.d = SystemClock.uptimeMillis();
        String strA = e.a(this.g);
        if (TextUtils.isEmpty(strA)) {
            com.android.gdt.qone.af.c.b("QM", "The parameter to get the QM request is empty, cancel the QM request(appKey: %s)", this.g);
            String str = this.g;
            com.android.gdt.qone.ai.f fVarA = com.android.gdt.qone.ai.f.a();
            com.android.gdt.qone.ai.c cVarA = com.android.gdt.qone.r.b.a(fVarA);
            cVarA.a.put("6", "1007");
            fVarA.a(cVarA, com.alipay.sdk.m.x.c.d, str);
            this.c.set(false);
            return;
        }
        this.e = SystemClock.uptimeMillis();
        String str2 = this.g;
        CMD cmd = CMD.REGISTER;
        com.android.gdt.qone.z.d dVar = new com.android.gdt.qone.z.d(U.a(str2, strA, cmd.b(), cmd.a()));
        if (!dVar.a()) {
            if (dVar.i) {
                String str3 = dVar.e;
                int i2 = dVar.f;
                String str4 = dVar.g;
                com.android.gdt.qone.af.c.a("QM", "onFailure msg: %s,%d,%s. Waiting next query.", str3, Integer.valueOf(i2), str4);
                g gVar = this.h;
                if (gVar.c.get() > gVar.a - 1) {
                    String str5 = this.g;
                    String str6 = com.sigmob.sdk.base.n.i;
                    if (str3.equals("451")) {
                        str6 = "1001";
                    }
                    com.android.gdt.qone.ai.f fVarA2 = com.android.gdt.qone.ai.f.a();
                    com.android.gdt.qone.ai.c cVarA2 = com.android.gdt.qone.r.b.a(fVarA2);
                    cVarA2.a.put("6", str6);
                    cVarA2.a.put("7", "error code: " + i2 + ", msg:" + str4);
                    fVarA2.a(cVarA2, com.alipay.sdk.m.x.c.d, str5);
                }
                this.c.set(false);
                if (this.f) {
                    this.f = false;
                } else {
                    g gVar2 = this.h;
                    gVar2.c.getAndIncrement();
                    boolean z = gVar2.c.get() > gVar2.a;
                    if (z) {
                        gVar2.c.set(0);
                        f fVar = gVar2.b;
                        if (fVar != null) {
                            if (!com.android.gdt.qone.au.c.C.a((String) com.android.gdt.qone.at.b.a.get(com.android.gdt.qone.at.a.a(fVar.a.g).a.l)).isEmpty()) {
                                fVar.a.f = true;
                                com.android.gdt.qone.v.a.a().a(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, fVar.a);
                            }
                        }
                    }
                    if (!z) {
                        com.android.gdt.qone.v.a.a().a(j.peek() != null ? 1000 * ((Integer) j.poll()).longValue() : 0L, this);
                    }
                }
            }
            if (dVar.a() || TextUtils.isEmpty(dVar.c)) {
                string = "";
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(dVar.c, String.valueOf(dVar.b));
                } catch (JSONException unused) {
                }
                string = jSONObject.toString();
            }
            com.android.gdt.qone.aj.c.a(this.g, BeatType.REGISTER, string);
            com.android.gdt.qone.af.c.a("QM", "register qm failed,response err code is %s", string);
            return;
        }
        String str7 = TextUtils.isEmpty(dVar.d) ? "" : dVar.d;
        com.android.gdt.qone.af.c.b("QM", "(appKey: %s)QM response, %s", this.g, str7);
        c cVarA3 = c.a(this.g);
        b bVar4 = cVarA3.b;
        String str8 = this.g;
        int i3 = com.android.gdt.qone.ap.f.a;
        b bVar5 = new b(d.a.a(str7), d.b.a(str7), str8);
        if (bVar5.c()) {
            bVar5 = new b(d.c.a(str7), d.d.a(str7), str8);
        }
        cVarA3.a(bVar5);
        b bVar6 = cVarA3.b;
        boolean z2 = cVarA3.e;
        if (bVar4 != null && !bVar4.c()) {
            String str9 = bVar4.b;
            String str10 = bVar4.c;
            if (str9 != null && str10 != null && (str9.isEmpty() || !str10.isEmpty())) {
                String str11 = bVar6.b;
                String str12 = bVar6.c;
                if ((str11.isEmpty() || !str12.isEmpty()) && (!str9.equals(str11) || !str10.equals(str12))) {
                    String str13 = this.g;
                    com.android.gdt.qone.ai.f fVarA3 = com.android.gdt.qone.ai.f.a();
                    com.android.gdt.qone.ai.c cVarA4 = com.android.gdt.qone.r.b.a(fVarA3);
                    cVarA4.a.put("6", str9);
                    cVarA4.a.put("7", str10);
                    cVarA4.a.put(GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD, str11);
                    cVarA4.a.put("9", str12);
                    cVarA4.a.put(PointType.SIGMOB_APP, z2 ? "1" : "0");
                    fVarA3.a(cVarA4, "v3", str13);
                }
            }
        }
        b bVar7 = c.a(this.g).b;
        if (bVar7 == null || bVar7.c()) {
            String str14 = this.g;
            com.android.gdt.qone.ai.f fVarA4 = com.android.gdt.qone.ai.f.a();
            com.android.gdt.qone.ai.c cVarA5 = com.android.gdt.qone.r.b.a(fVarA4);
            cVarA5.a.put("6", "1004");
            cVarA5.a.put("7", "200");
            fVarA4.a(cVarA5, com.alipay.sdk.m.x.c.d, str14);
        }
        com.android.gdt.qone.af.c.b("QM", "(appKey: %s)QM response, data decryption result: %s", this.g, bVar6);
        b bVar8 = cVarA3.b;
        if (bVar8 == null || bVar8.c()) {
            com.android.gdt.qone.aj.c.a(this.g, BeatType.REGISTER, PointType.SIGMOB_CRASH);
        } else {
            new com.android.gdt.qone.ar.a(this.g).d();
            com.android.gdt.qone.u.b bVar9 = this.b;
            if (bVar9 != null && (context = bVar9.b) != null) {
                try {
                    context.unregisterReceiver(bVar9);
                    Process.myPid();
                } catch (IllegalArgumentException e2) {
                    com.android.gdt.qone.af.c.a(e2);
                }
            }
            String str15 = this.g;
            com.android.gdt.qone.w.a.a(str15, "lccNoCN", new com.android.gdt.qone.ap.b(str15, str7));
            String strA2 = !com.android.gdt.qone.au.d.a(com.android.gdt.qone.au.a.l, com.android.gdt.qone.at.a.a(com.android.gdt.qone.ag.o.a(cVarA3.a).a).a.l).booleanValue() ? "" : U.a();
            if (strA2 == null) {
                strA2 = "";
            }
            cVarA3.c = strA2;
            com.android.gdt.qone.ad.h.a(cVarA3.a).a("tt", cVarA3.c);
            com.android.gdt.qone.aj.c.a(this.g, BeatType.REGISTER, "0");
        }
        this.c.set(false);
        long j4 = dVar.h;
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j5 = jUptimeMillis - this.e;
        long j6 = jUptimeMillis - this.d;
        synchronized (com.android.gdt.qone.w.c.class) {
            cVar = com.android.gdt.qone.w.c.p;
        }
        long j7 = cVar.c;
        o oVar = this.a;
        if (oVar != null) {
            j3 = oVar.i;
            j2 = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
        } else {
            j2 = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            j3 = 0;
        }
        if (j5 < j2 && j6 < j2 && j7 < j2 && j3 < j2 && j4 < j2) {
            if (com.android.gdt.qone.ap.g.a.nextInt(101) > com.android.gdt.qone.au.d.a(com.android.gdt.qone.au.b.y, com.android.gdt.qone.at.a.a(this.g).a.l).intValue()) {
                return;
            }
        }
        String str16 = this.g;
        com.android.gdt.qone.ai.f fVarA5 = com.android.gdt.qone.ai.f.a();
        com.android.gdt.qone.ai.c cVarA6 = com.android.gdt.qone.r.b.a(fVarA5);
        cVarA6.a.put("6", String.valueOf(j5));
        cVarA6.a.put("7", String.valueOf(j6));
        cVarA6.a.put(GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD, String.valueOf(j7));
        cVarA6.a.put("9", String.valueOf(j3));
        cVarA6.a.put(PointType.SIGMOB_APP, String.valueOf(j4));
        fVarA5.a(cVarA6, com.alipay.sdk.m.x.c.c, str16);
    }
}
