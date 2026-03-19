package com.apm.insight;

import com.baidu.mobads.container.rewardvideo.NativeRewardActivity;
import com.baidu.mobstat.forbes.Config;
import com.fendasz.moku.planet.constants.MokuConstants;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public enum CrashType {
    LAUNCH(Config.LAUNCH),
    JAVA("java"),
    NATIVE("native"),
    ASAN("asan"),
    TSAN("tsan"),
    ANR("anr"),
    BLOCK("block"),
    ENSURE("ensure"),
    DART("dart"),
    CUSTOM_JAVA("custom_java"),
    OOM("oom"),
    ALL(MokuConstants.TASK_TAG_ALL),
    EXIT(com.alipay.sdk.m.x.d.z),
    PORTRAIT(NativeRewardActivity.SCREEN_PORTRAIT);

    private String mName;

    CrashType(String str) {
        this.mName = str;
    }

    public String getName() {
        return this.mName;
    }

    @Override // java.lang.Enum
    public String toString() {
        return getName();
    }
}
