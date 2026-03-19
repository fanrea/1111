package com.sigmob.sdk.base.mta;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PointEntityActive extends PointEntitySigmobSuper {
    private String a;
    private String b;
    private String c;
    private String d;

    public static PointEntityActive ActiveTracking(String category, String activeId, String duration, String activeTime) {
        PointEntityActive pointEntityActive = new PointEntityActive();
        pointEntityActive.setAc_type(PointType.WIND_ACTIVE);
        pointEntityActive.setCategory(category);
        pointEntityActive.setActive_id(activeId);
        pointEntityActive.setDuration(duration);
        pointEntityActive.setTimestamp(activeTime);
        pointEntityActive.commit();
        return pointEntityActive;
    }

    public String getActive_id() {
        return this.a;
    }

    public String getDuration() {
        return this.d;
    }

    public String getRequest_id() {
        return this.b;
    }

    public String getVid() {
        return this.c;
    }

    public void setActive_id(String active_id) {
        this.a = active_id;
    }

    public void setDuration(String duration) {
        this.d = duration;
    }

    public void setRequest_id(String request_id) {
        this.b = request_id;
    }

    public void setVid(String vid) {
        this.c = vid;
    }
}
