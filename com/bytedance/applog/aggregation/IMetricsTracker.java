package com.bytedance.applog.aggregation;

import com.alipay.sdk.m.p0.b;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: Defines.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/applog/aggregation/IMetricsTracker;", "", "track", "", b.d, "params", "Lorg/json/JSONObject;", "aggregation_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface IMetricsTracker {
    void track(Object value, JSONObject params);

    /* compiled from: Defines.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public static final class DefaultImpls {
        public static /* synthetic */ void track$default(IMetricsTracker iMetricsTracker, Object obj, JSONObject jSONObject, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: track");
            }
            if ((i & 2) != 0) {
                jSONObject = null;
            }
            iMetricsTracker.track(obj, jSONObject);
        }
    }
}
