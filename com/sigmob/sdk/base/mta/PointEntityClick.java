package com.sigmob.sdk.base.mta;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PointEntityClick extends PointEnitySigmobBase {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;

    public String getClick_duration() {
        return this.b;
    }

    public String getIs_valid_click() {
        return this.c;
    }

    public String getLocation() {
        return this.a;
    }

    public String getPressure() {
        return this.e;
    }

    public String getTouchSize() {
        return this.f;
    }

    public String getTouchType() {
        return this.d;
    }

    public void setClick_duration(String click_duration) {
        this.b = click_duration;
    }

    public void setIs_valid_click(String is_valid_click) {
        this.c = is_valid_click;
    }

    public void setLocation(String location) {
        this.a = location;
    }

    public void setPressure(String pressure) {
        this.e = pressure;
    }

    public void setTouchSize(String touchSize) {
        this.f = touchSize;
    }

    public void setTouchType(String touchType) {
        this.d = touchType;
    }
}
