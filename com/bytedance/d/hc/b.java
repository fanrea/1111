package com.bytedance.d.hc;

import com.baidu.mobstat.forbes.Config;
import com.fendasz.moku.planet.constants.MokuConstants;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public enum b {
    LAUNCH(Config.LAUNCH),
    JAVA("java"),
    NATIVE("native"),
    ANR("anr"),
    BLOCK("block"),
    ENSURE("ensure"),
    DART("dart"),
    CUSTOM_JAVA("custom_java"),
    ALL(MokuConstants.TASK_TAG_ALL);

    private String tc;

    b(String str) {
        this.tc = str;
    }

    public String d() {
        return this.tc;
    }
}
