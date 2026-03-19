package com.tk.core.n;

import com.bytedance.applog.aggregation.MetricsSQLiteCacheKt;
import com.tk.core.component.timer.TKTimer;
import com.tk.core.o.p;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a {
    public static void p(final List<TKTimer.a> list) {
        p.execute(new Runnable() { // from class: com.tk.core.n.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    for (int i = 0; i < list.size(); i++) {
                        JSONObject jSONObject2 = new JSONObject();
                        TKTimer.a aVar = (TKTimer.a) list.get(i);
                        jSONObject2.put("now", aVar.ahn);
                        jSONObject2.put("id", aVar.id);
                        jSONObject2.put("key", aVar.key);
                        jSONObject2.put(MetricsSQLiteCacheKt.METRICS_INTERVAL, aVar.ahp);
                        jSONObject2.put("repeat", aVar.ahq);
                        jSONObject2.put("bundleId", aVar.bundleId);
                        jSONObject2.put("tKJsContextTag", aVar.aho);
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("timerData", jSONArray.toString());
                    com.tk.core.a.oP();
                } catch (Throwable th) {
                    com.tk.core.i.a.a("TKEventReporterUtils", "reportTKTimerEvent exception", th);
                }
            }
        });
    }
}
