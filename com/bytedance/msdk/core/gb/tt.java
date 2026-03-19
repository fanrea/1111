package com.bytedance.msdk.core.gb;

import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tt extends c {
    private long an;
    private long gb;
    private String h;

    public tt(String str, String str2, String str3, String str4, int i, String str5, String str6) {
        super(str, str2, str3, str4, i);
        this.gb = 0L;
        this.an = 0L;
        try {
            this.an = Long.parseLong(str5);
        } catch (Exception unused) {
        }
        this.h = str6;
    }

    public tt(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7) {
        this(str, str2, str3, str4, i, str5, str6);
        this.gb = 0L;
        try {
            this.gb = Long.parseLong(str7);
        } catch (Exception unused) {
        }
    }

    public void d(long j) {
        this.gb = j;
    }

    public long tt() {
        return this.an;
    }

    public String tc() {
        return this.h;
    }

    public long mk() {
        return this.gb;
    }

    public boolean mq() {
        return this.gb != 0;
    }

    @Override // com.bytedance.msdk.core.gb.c
    public boolean gb() {
        return (TextUtils.isEmpty(this.h) || this.an == 0) ? false : true;
    }

    @Override // com.bytedance.msdk.core.gb.c
    public String toString() {
        return "BaseIntervalBean{waterfallId='" + this.d + "', showRulesVersion='" + this.b + "', timingMode=" + this.u + "}IntervalPacingBean{pacing=" + this.an + ", pacingRuleId='" + this.h + "', effectiveTime=" + this.gb + '}';
    }
}
