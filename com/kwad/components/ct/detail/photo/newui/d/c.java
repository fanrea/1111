package com.kwad.components.ct.detail.photo.newui.d;

import com.kwad.components.ct.home.config.item.AvatarGuiderConfigItem;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class c {
    private static volatile c auz;
    private boolean auu;
    private int auv;
    private int auw;
    private int aux;
    private int auy = 0;

    public static c Aw() {
        if (auz == null) {
            synchronized (c.class) {
                if (auz == null) {
                    auz = new c();
                }
            }
        }
        return auz;
    }

    private c() {
        this.auu = com.kwad.components.ct.home.config.a.aHW.getValue().intValue() == 1;
        AvatarGuiderConfigItem.AvatarGuiderConfig value = com.kwad.components.ct.home.config.a.aHV.getValue();
        if (value != null) {
            com.kwad.sdk.core.d.c.d("AvatarGuiderManager", value.toJson().toString());
            this.auv = value.showByPlayRate;
            this.auw = value.showTimeLength;
            this.aux = value.showMaxTimes;
        }
    }

    public final int Ax() {
        return this.auv;
    }

    public final synchronized void Ay() {
        this.auy++;
    }

    public final synchronized boolean Az() {
        return this.auy < this.aux;
    }

    public final int AA() {
        return this.auw;
    }

    public final boolean AB() {
        return this.auu;
    }
}
