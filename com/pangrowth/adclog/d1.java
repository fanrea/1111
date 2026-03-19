package com.pangrowth.adclog;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d1 implements x {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    public d1(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public Map<String, String> a() {
        HashMap map = new HashMap();
        map.put("aid", this.a);
        map.put(com.baidu.mobads.upgrade.remote.gray.c.l, this.b);
        map.put("device_platform", "android");
        return map;
    }
}
