package com.baidu.mobads.container.l;

import com.baidu.mobads.container.l.g;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d extends g.a {
    public static final String a = "debug";

    @Override // com.baidu.mobads.container.l.g.a
    String a() {
        return "debug";
    }

    @Override // com.baidu.mobads.container.l.g.a
    protected boolean a(String str, int i) {
        return "bqt_ad_tag".equals(str);
    }

    @Override // com.baidu.mobads.container.l.g.a
    protected void a(int i, String str, String str2, Throwable th) {
        i.a(i, str, str2);
    }
}
