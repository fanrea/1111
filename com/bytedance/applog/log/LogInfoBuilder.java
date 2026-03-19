package com.bytedance.applog.log;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class LogInfoBuilder {
    private final LogInfo logInfo = new LogInfo();

    public LogInfoBuilder() {
        time(System.currentTimeMillis());
    }

    public LogInfoBuilder time(long j) {
        this.logInfo.setTime(j);
        return this;
    }

    public LogInfoBuilder appId(String str) {
        this.logInfo.setAppId(str);
        return this;
    }

    public LogInfoBuilder thread(String str) {
        this.logInfo.setThread(str);
        return this;
    }

    public LogInfoBuilder level(int i) {
        this.logInfo.setLevel(i);
        return this;
    }

    public LogInfoBuilder category(int i) {
        this.logInfo.setCategory(i);
        return this;
    }

    public LogInfoBuilder tags(List<String> list) {
        this.logInfo.setTags(list);
        return this;
    }

    public LogInfoBuilder message(String str) {
        this.logInfo.setMessage(str);
        return this;
    }

    public LogInfoBuilder throwable(Throwable th) {
        this.logInfo.setThrowable(th);
        return this;
    }

    public LogInfo build() {
        return this.logInfo;
    }
}
