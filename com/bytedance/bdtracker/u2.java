package com.bytedance.bdtracker;

import androidx.core.app.NotificationCompat;
import com.bytedance.applog.monitor.MonitorSampling;
import com.bytedance.bdtracker.l0;
import com.bytedance.bdtracker.q2;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class u2 implements v2 {
    public int a = -1;
    public final long b;
    public final String c;
    public final long d;

    public u2(long j, String str, long j2) {
        this.b = j;
        this.c = str;
        this.d = j2;
    }

    @Override // com.bytedance.bdtracker.p2
    public List<String> a() {
        return this.a == -1 ? CollectionsKt.listOf(new String[]{"metrics_category", "metrics_name", "dims_0", "launch_id", "process_id"}) : CollectionsKt.listOf(new String[]{"metrics_category", "metrics_name", "dims_0", "launch_id", "process_id", "err_code"});
    }

    @Override // com.bytedance.bdtracker.q2
    public void a(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkParameterIsNotNull(jSONObject, "params");
        jSONObject.put("dims_0", this.b);
        jSONObject.put("process_id", this.c);
        jSONObject.put("launch_id", MonitorSampling.INSTANCE.getGlobalColdLaunchId$agent_liteChinaRelease());
        if (this.b == 13) {
            jSONObject.put("err_code", this.a);
        }
    }

    @Override // com.bytedance.bdtracker.q2
    public String b() {
        return "event_process";
    }

    @Override // com.bytedance.bdtracker.p2
    public int c() {
        return 7;
    }

    @Override // com.bytedance.bdtracker.q2
    public JSONObject d() {
        return q2.a.a(this);
    }

    @Override // com.bytedance.bdtracker.q2
    public String e() {
        return NotificationCompat.CATEGORY_EVENT;
    }

    @Override // com.bytedance.bdtracker.p2
    public List<Number> f() {
        return l0.b.d();
    }

    @Override // com.bytedance.bdtracker.q2
    public Object g() {
        return Long.valueOf(this.d);
    }
}
