package com.kuaishou.common.async;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class RunnableInfo {
    final long findSourceCost;
    final String source;
    final long startTimestamp = System.currentTimeMillis();
    final String threadName;

    RunnableInfo(String str, String str2, long j) {
        this.source = str;
        this.threadName = str2;
        this.findSourceCost = j;
    }
}
