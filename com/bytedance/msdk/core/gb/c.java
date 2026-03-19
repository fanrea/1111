package com.bytedance.msdk.core.gb;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class c {
    private boolean an;
    protected String b;
    protected String c;
    protected String d;
    protected String hc;
    protected int u;

    public boolean d() {
        return this.an;
    }

    public String hc() {
        return this.d;
    }

    public String b() {
        return this.hc;
    }

    public String c() {
        return TextUtils.isEmpty(this.hc) ? this.d : this.d + Config.replace + this.hc;
    }

    public String u() {
        return this.b;
    }

    public String an() {
        return this.c;
    }

    public int h() {
        return this.u;
    }

    public c(String str, String str2, String str3, String str4, int i) {
        this.d = str;
        this.b = str3;
        this.u = i;
        this.hc = str2;
        this.an = !TextUtils.isEmpty(str2);
        this.c = str4;
    }

    public boolean gb() {
        return this.u == 1;
    }

    public String toString() {
        return "BaseIntervalBean{waterfallId='" + this.d + "', showRulesVersion='" + this.b + "', timingMode=" + this.u + '}';
    }
}
