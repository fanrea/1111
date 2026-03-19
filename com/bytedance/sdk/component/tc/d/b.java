package com.bytedance.sdk.component.tc.d;

import com.bytedance.sdk.component.tc.mk;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b implements Comparable<b>, Runnable {
    public static final AtomicInteger d = new AtomicInteger(0);
    public static boolean hc = false;
    public final Runnable b;
    private an c;
    private long gb;
    private boolean u = true;
    private boolean an = true;
    private final long h = System.currentTimeMillis();
    private int tt = 0;
    private int tc = 0;

    public b(Runnable runnable) {
        this.b = runnable;
    }

    public b(Runnable runnable, an anVar) {
        this.b = runnable;
        this.c = anVar;
    }

    public void d(an anVar) {
        this.c = anVar;
    }

    Runnable d() {
        return this.b;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:0|2|(13:4|42|5|6|11|(1:13)(1:14)|15|(1:19)|40|20|21|24|(1:26)(2:27|(2:31|(2:33|34)(3:(1:36)(1:37)|38|39))(1:44)))(1:9)|10|11|(0)(0)|15|(2:17|19)|40|20|21|24|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0085, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0086, code lost:
    
        r2 = false;
        com.bytedance.sdk.component.utils.mq.hc("BizRunnable", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 213
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.tc.d.b.run():void");
    }

    public void hc() {
        this.gb = System.currentTimeMillis() - this.h;
    }

    private boolean d(long j) {
        return this.tc == 1 ? j > mk.hc.w() : j > mk.hc.yo();
    }

    private void d(long j, long j2, String str, int i, int i2, int i3, com.bytedance.sdk.component.c.b bVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("create_time", this.h);
            jSONObject.put("is_wrap", this.b instanceof b);
            jSONObject.put("is_oom", hc);
            jSONObject.put("pool_wait_time", j);
            jSONObject.put("priority", i);
            jSONObject.put("wait_in_queue", this.gb);
            jSONObject.put("pool_type", this.tt);
            jSONObject.put("origin_pool_type", this.tc);
            jSONObject.put("run_cost", j2);
            jSONObject.put(ILogConst.Keys.KEY_TASK_NAME, str);
            jSONObject.put("thread_name", Thread.currentThread().getName());
            mk mkVar = mk.hc;
            jSONObject.put("little_active_count", i2);
            jSONObject.put("big_active_count", i3);
            jSONObject.put("is_crash", mkVar.k());
            jSONObject.put("auto_size", com.bytedance.sdk.component.tc.h.u());
            jSONObject.put("pri_task_in_little", d.get());
            jSONObject.put("core_count", mkVar.gb());
            jSONObject.put("max_pool_size", mkVar.mk());
            jSONObject.put("use_little_pool", mkVar.cb());
        } catch (Exception unused) {
        }
        bVar.d("task_run_cost", jSONObject);
    }

    private void b(boolean z) {
        an anVar = this.c;
        if (anVar != null) {
            anVar.d(this, z);
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(b bVar) {
        Class<?> cls = this.b.getClass();
        Class<?> cls2 = bVar.b.getClass();
        if (!cls.isAssignableFrom(cls2) && !cls2.isAssignableFrom(cls)) {
            return 0;
        }
        Runnable runnable = this.b;
        if (!(runnable instanceof Comparable)) {
            return 0;
        }
        Runnable runnable2 = bVar.b;
        if (runnable2 instanceof Comparable) {
            return ((Comparable) runnable).compareTo(runnable2);
        }
        return 0;
    }

    public void d(boolean z) {
        this.u = z;
    }

    public boolean b() {
        return this.an;
    }

    public void hc(boolean z) {
        this.an = z;
    }

    public void d(int i) {
        int i2 = this.tt;
        if (i2 == 0) {
            this.tc = i;
        } else {
            this.tc = i2;
        }
        this.tt = i;
    }

    public int c() {
        return this.tt;
    }
}
