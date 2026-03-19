package com.kwad.components.ct.home.config;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class c {
    private static volatile c aHY;
    private Map<String, String> aHX = new HashMap();

    private c() {
    }

    public static c FX() {
        if (aHY == null) {
            synchronized (c.class) {
                if (aHY == null) {
                    aHY = new c();
                }
            }
        }
        return aHY;
    }

    public final synchronized String bN(String str) {
        return this.aHX.get(str);
    }
}
