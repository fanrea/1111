package com.android.gdt.qone.aj;

import com.android.gdt.qone.ag.o;
import com.android.gdt.qone.foundation.net.protocol.CMD;
import com.android.gdt.qone.report.beat.BeatType;
import com.android.gdt.qone.uin.U;
import com.android.gdt.qone.z.d;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class a implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ BeatType b;
    public final /* synthetic */ String c;

    public a(String str, BeatType beatType, String str2) {
        this.a = str;
        this.b = beatType;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException, InterruptedException {
        String string;
        if (com.android.gdt.qone.w.a.g()) {
            String str = this.a;
            BeatType beatType = this.b;
            String str2 = this.c;
            JSONObject jSONObject = new JSONObject();
            String strC = !U.e() ? o.a(str).c() : "";
            try {
                jSONObject.put("1", beatType.b());
                jSONObject.put("2", String.valueOf(System.currentTimeMillis()));
                jSONObject.put("3", strC);
                jSONObject.put("4", str2);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(com.alipay.sdk.m.s.a.w, com.android.gdt.qone.w.a.f());
                    jSONObject2.put("ch", com.android.gdt.qone.w.a.a());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                jSONObject.put("5", jSONObject2.toString());
                string = jSONObject.toString();
            } catch (JSONException e2) {
                com.android.gdt.qone.af.c.a(e2);
                string = null;
            }
            String str3 = string != null ? string : "";
            String str4 = this.a;
            CMD cmd = CMD.BEAT;
            String strA = U.a(str4, str3, cmd.b(), cmd.a());
            if (!new d(strA).a()) {
                String str5 = this.a;
                PriorityQueue priorityQueue = new PriorityQueue();
                Random random = new Random(com.android.gdt.qone.ae.d.class.hashCode());
                for (int i = 0; i < 3; i++) {
                    priorityQueue.offer(Integer.valueOf(random.nextInt(5) + 10));
                }
                Iterator it = priorityQueue.iterator();
                while (it.hasNext()) {
                    Integer num = (Integer) it.next();
                    it.remove();
                    try {
                        TimeUnit.SECONDS.sleep(num.intValue());
                    } catch (Exception unused) {
                    }
                    CMD cmd2 = CMD.BEAT;
                    String strA2 = U.a(str5, str3, cmd2.b(), cmd2.a());
                    com.android.gdt.qone.af.c.b("c", "%s Beat data has been retry over,response = %s", str5, strA2);
                    if (new d(strA2).a()) {
                        break;
                    }
                }
            }
            ConcurrentHashMap concurrentHashMap = c.a;
            com.android.gdt.qone.af.c.b("c", "%s Beat data has been reported over, type:%s response = %s", this.a, Integer.valueOf(this.b.b()), strA);
        }
    }
}
