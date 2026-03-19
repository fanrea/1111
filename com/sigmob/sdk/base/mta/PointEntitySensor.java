package com.sigmob.sdk.base.mta;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class PointEntitySensor extends PointEnitySigmobBase {
    private String a;
    private String b;
    private String c;

    public String getMotion_after() {
        return this.b;
    }

    public String getMotion_before() {
        return this.a;
    }

    public String getMotion_interval() {
        return this.c;
    }

    public void setMotion_after(String motion_after) {
        this.b = motion_after;
    }

    public void setMotion_before(String motion_before) {
        this.a = motion_before;
    }

    public void setMotion_interval(String motion_interval) {
        this.c = motion_interval;
    }
}
