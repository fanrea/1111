package com.bytedance.bdtracker;

import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.log.LoggerImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class m0 extends Throwable {
    @Override // java.lang.Throwable
    public void printStackTrace() {
        String string;
        IAppLogLogger iAppLogLoggerGlobal = LoggerImpl.global();
        StringBuilder sbA = a.a("AppLog assert failed: ");
        Throwable cause = getCause();
        if (cause == null || (string = cause.getMessage()) == null) {
            StackTraceElement[] stackTrace = getStackTrace();
            Intrinsics.checkExpressionValueIsNotNull(stackTrace, "stackTrace");
            string = (stackTrace.length == 0) ^ true ? getStackTrace()[0].toString() : "function interrupt";
        }
        iAppLogLoggerGlobal.ast(sbA.append((Object) string).toString(), getCause(), new Object[0]);
    }
}
