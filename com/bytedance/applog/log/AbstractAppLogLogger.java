package com.bytedance.applog.log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class AbstractAppLogLogger implements IAppLogLogger {
    private static final char CHAR_PLACEHOLDER = ' ';
    private static final Map<String, IAppLogLogger> loggerMap = new ConcurrentHashMap();
    private String appId;
    private final List<String> loggerTags;

    public AbstractAppLogLogger() {
        ArrayList arrayList = new ArrayList();
        this.loggerTags = arrayList;
        arrayList.add("logger@" + hashCode());
    }

    @Override // com.bytedance.applog.log.IAppLogLogger
    public void setAppId(String str) {
        this.appId = str;
        loggerMap.put(str, this);
        debug("Current logger bind to appId {}", str);
    }

    public static IAppLogLogger getLogger(String str) {
        return loggerMap.get(str);
    }

    protected void process(int i, int i2, List<String> list, Throwable th, String str, Object... objArr) {
        if (LogProcessorHolder.noAnyProcessor()) {
            return;
        }
        LogInfo logInfoBuild = LogInfo.builder().appId(this.appId).category(i).level(i2).thread(Thread.currentThread().getName()).throwable(th).tags(getTags(list)).message(format(str, objArr)).build();
        LogProcessorHolder.commonProcess(logInfoBuild);
        ILogProcessor appProcessor = LogProcessorHolder.getAppProcessor(this.appId);
        if (appProcessor != null) {
            appProcessor.onLog(logInfoBuild);
        }
    }

    protected List<String> getTags(List<String> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.loggerTags);
            arrayList.addAll(list);
            return arrayList;
        }
        return this.loggerTags;
    }

    protected String format(String str, Object... objArr) {
        try {
            StringBuilder sb = new StringBuilder();
            if (objArr == null || objArr.length == 0 || !str.contains("{}")) {
                sb.append(str);
            } else {
                int length = str.length();
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    char cCharAt = str.charAt(i);
                    char cCharAt2 = i < length + (-1) ? str.charAt(i + 1) : CHAR_PLACEHOLDER;
                    if (cCharAt == '{' && cCharAt2 == '}') {
                        if (i2 < objArr.length) {
                            sb.append(toString(objArr[i2]));
                            i2++;
                        }
                        i++;
                    } else {
                        sb.append(cCharAt);
                    }
                    i++;
                }
            }
            return sb.toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    private String toString(Object obj) {
        return obj != null ? obj.toString() : "";
    }
}
