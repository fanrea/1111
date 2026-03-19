package com.baidu.mobstat.forbes;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class v extends u {
    private static v c = new v();
    private boolean b;

    private v() {
    }

    public static v c() {
        return c;
    }

    public void a(boolean z) {
        this.b = z;
    }

    @Override // com.baidu.mobstat.forbes.u
    public String a() {
        return "BaiduMobStat";
    }

    @Override // com.baidu.mobstat.forbes.u
    public boolean b() {
        return this.b;
    }
}
