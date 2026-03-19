package com.bytedance.bdtracker;

import android.content.Context;
import android.os.Looper;
import com.bytedance.applog.aggregation.IAggregation;
import com.bytedance.applog.aggregation.IAggregationFlushCallback;
import com.bytedance.applog.aggregation.IMetricsTracker;
import com.bytedance.applog.aggregation.Metrics;
import com.bytedance.applog.aggregation.MetricsSQLiteCache;
import com.bytedance.applog.aggregation.MetricsSQLiteCacheKt;
import com.ss.texturerender.TextureRenderKeys;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\u0015\u001a\u00020\u00162\u0018\u0010\u0017\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0004\u0012\u00020\u00160\u0018J\u000e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR'\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/bytedance/applog/monitor/MetricsTrackerHelper;", "", "looper", "Landroid/os/Looper;", "appId", "", "context", "Landroid/content/Context;", "(Landroid/os/Looper;Ljava/lang/String;Landroid/content/Context;)V", "aggregation", "Lcom/bytedance/applog/aggregation/IAggregation;", "getAggregation", "()Lcom/bytedance/applog/aggregation/IAggregation;", "aggregation$delegate", "Lkotlin/Lazy;", "trackMap", "", "Lcom/bytedance/applog/aggregation/IMetricsTracker;", "getTrackMap", "()Ljava/util/Map;", "trackMap$delegate", "flush", "", TextureRenderKeys.KEY_IS_CALLBACK, "Lkotlin/Function1;", "", "Lcom/bytedance/applog/aggregation/Metrics;", "metricsTracker", "data", "Lcom/bytedance/applog/monitor/model/BaseTrace;", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class j2 {
    public static final /* synthetic */ KProperty[] c = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(j2.class), "aggregation", "getAggregation()Lcom/bytedance/applog/aggregation/IAggregation;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(j2.class), "trackMap", "getTrackMap()Ljava/util/Map;"))};
    public final Lazy a;
    public final Lazy b;

    public static final class a extends Lambda implements Function0<IAggregation> {
        public final /* synthetic */ String a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ Looper c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Context context, Looper looper) {
            super(0);
            this.a = str;
            this.b = context;
            this.c = looper;
        }

        public Object invoke() {
            return IAggregation.INSTANCE.newInstance(new MetricsSQLiteCache(this.b, com.bytedance.bdtracker.a.a("applog-aggregation-").append(this.a).toString()), this.c);
        }
    }

    public static final class b implements IAggregationFlushCallback {
        public final /* synthetic */ Function1 a;

        public b(Function1 function1) {
            this.a = function1;
        }

        @Override // com.bytedance.applog.aggregation.IAggregationFlushCallback
        public void onFinish(List<Metrics> list) {
            Intrinsics.checkParameterIsNotNull(list, MetricsSQLiteCacheKt.METRICS_TABLE_NAME);
            this.a.invoke(list);
        }
    }

    public static final class c extends Lambda implements Function0<Map<String, IMetricsTracker>> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        public Object invoke() {
            return new LinkedHashMap();
        }
    }

    public j2(Looper looper, String str, Context context) {
        Intrinsics.checkParameterIsNotNull(looper, "looper");
        Intrinsics.checkParameterIsNotNull(str, "appId");
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.a = LazyKt.lazy(new a(str, context, looper));
        this.b = LazyKt.lazy(c.a);
    }

    public final void a(Function1<? super List<Metrics>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, TextureRenderKeys.KEY_IS_CALLBACK);
        Lazy lazy = this.a;
        KProperty kProperty = c[0];
        ((IAggregation) lazy.getValue()).flush(new b(function1));
    }

    public final IMetricsTracker a(q2 q2Var) {
        Intrinsics.checkParameterIsNotNull(q2Var, "data");
        Lazy lazy = this.b;
        KProperty[] kPropertyArr = c;
        KProperty kProperty = kPropertyArr[1];
        IMetricsTracker iMetricsTracker = (IMetricsTracker) ((Map) lazy.getValue()).get(Intrinsics.stringPlus(Reflection.getOrCreateKotlinClass(q2Var.getClass()).getSimpleName(), q2Var.a()));
        if (iMetricsTracker != null) {
            return iMetricsTracker;
        }
        Lazy lazy2 = this.a;
        KProperty kProperty2 = kPropertyArr[0];
        IAggregation iAggregation = (IAggregation) lazy2.getValue();
        String simpleName = q2Var.getClass().getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "data::class.java.simpleName");
        IMetricsTracker iMetricsTrackerNewMetricsTracker = iAggregation.newMetricsTracker(simpleName, q2Var.c(), q2Var.a(), q2Var.f());
        Lazy lazy3 = this.b;
        KProperty kProperty3 = kPropertyArr[1];
        ((Map) lazy3.getValue()).put(Intrinsics.stringPlus(Reflection.getOrCreateKotlinClass(q2Var.getClass()).getSimpleName(), q2Var.a()), iMetricsTrackerNewMetricsTracker);
        return iMetricsTrackerNewMetricsTracker;
    }
}
