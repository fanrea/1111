package com.bytedance.bdtracker;

import com.bytedance.applog.ILogger;
import com.bytedance.applog.log.ILogProcessor;
import com.bytedance.applog.log.LogInfo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class i1 implements ILogProcessor {
    public final ILogger a;

    public i1(ILogger iLogger) {
        this.a = iLogger;
    }

    @Override // com.bytedance.applog.log.ILogProcessor
    public void onLog(LogInfo logInfo) {
        ILogger iLogger = this.a;
        if (iLogger != null) {
            iLogger.log(logInfo.getMessage(), logInfo.getThrowable());
        }
    }
}
