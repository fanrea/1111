package com.bytedance.applog.monitor;

import com.alipay.sdk.m.p0.b;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.bdtracker.a;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR,\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00048\u0006@FX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/bytedance/applog/monitor/MonitorSampling;", "", "()V", "DEFAULT_SAMPLING_PERCENT", "", "globalColdLaunchId", "", "getGlobalColdLaunchId$agent_liteChinaRelease", "()Ljava/lang/String;", "isSampling", "", "isSampling$agent_liteChinaRelease", "()Z", "setSampling$agent_liteChinaRelease", "(Z)V", b.d, "samplingPercent", "samplingPercent$annotations", "getSamplingPercent", "()I", "setSamplingPercent", "(I)V", "reCheckIsSampling", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class MonitorSampling {
    public static final MonitorSampling INSTANCE;
    public static int a = 5;
    public static final String b;
    public static boolean c;

    static {
        MonitorSampling monitorSampling = new MonitorSampling();
        INSTANCE = monitorSampling;
        String string = UUID.randomUUID().toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "UUID.randomUUID().toString()");
        b = string;
        c = monitorSampling.a();
    }

    public static final int getSamplingPercent() {
        return a;
    }

    @JvmStatic
    public static /* synthetic */ void samplingPercent$annotations() {
    }

    public static final void setSamplingPercent(int i) {
        if (i < 0 || i > 100) {
            i = 5;
        }
        a = i;
        c = INSTANCE.a();
    }

    public final boolean a() {
        int iAbs = Math.abs(b.hashCode() % 100);
        LoggerImpl.global().debug("MonitorSampling hash " + iAbs, new Object[0]);
        LoggerImpl.global().debug(a.a("MonitorSampling samplingPercent ").append(a).toString(), new Object[0]);
        return iAbs <= a;
    }

    public final String getGlobalColdLaunchId$agent_liteChinaRelease() {
        return b;
    }

    public final boolean isSampling$agent_liteChinaRelease() {
        return c;
    }

    public final void setSampling$agent_liteChinaRelease(boolean z) {
        c = z;
    }
}
