package com.bytedance.applog.log;

import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class GlobalLoggerImpl extends LoggerImpl {
    @Override // com.bytedance.applog.log.AbstractAppLogLogger, com.bytedance.applog.log.IAppLogLogger
    public void setAppId(String str) {
        warn("You should not set appId on global logger instance", new Object[0]);
    }

    @Override // com.bytedance.applog.log.AbstractAppLogLogger
    protected void process(int i, int i2, List<String> list, Throwable th, String str, Object... objArr) {
        if (LogProcessorHolder.noAnyProcessor()) {
            return;
        }
        LogInfo logInfoBuild = LogInfo.builder().category(i).level(i2).thread(Thread.currentThread().getName()).throwable(th).tags(getTags(list)).message(format(str, objArr)).build();
        LogProcessorHolder.commonProcess(logInfoBuild);
        Iterator<ILogProcessor> appProcessors = LogProcessorHolder.getAppProcessors();
        while (appProcessors.hasNext()) {
            appProcessors.next().onLog(logInfoBuild);
        }
    }
}
