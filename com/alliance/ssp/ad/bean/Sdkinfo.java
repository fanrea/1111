package com.alliance.ssp.ad.bean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class Sdkinfo implements Comparable<Sdkinfo> {
    private int inflag;
    private String logo;
    private String nopa;
    private String ntagid;
    private String originid;
    private int sdkdelay;
    private String sdkid;
    private int sdkpri;
    public String groupId = "";
    public String platformId = "";
    public String sortPrice = "";

    public int getInflag() {
        return this.inflag;
    }

    public String getLogo() {
        return this.logo;
    }

    public String getNopa() {
        return this.nopa;
    }

    public String getNtagid() {
        return this.ntagid;
    }

    public String getOriginid() {
        return this.originid;
    }

    public int getSdkdelay() {
        return this.sdkdelay;
    }

    public String getSdkid() {
        return this.sdkid;
    }

    public int getSdkpri() {
        return this.sdkpri;
    }

    public void setInflag(int i) {
        this.inflag = i;
    }

    public void setLogo(String str) {
        this.logo = str;
    }

    public void setNopa(String str) {
        this.nopa = str;
    }

    public void setNtagid(String str) {
        this.ntagid = str;
    }

    public void setOriginid(String str) {
        this.originid = str;
    }

    public void setSdkdelay(int i) {
        this.sdkdelay = i;
    }

    public void setSdkid(String str) {
        this.sdkid = str;
    }

    public void setSdkpri(int i) {
        this.sdkpri = i;
    }

    @Override // java.lang.Comparable
    public int compareTo(Sdkinfo sdkinfo) {
        return this.sdkpri - sdkinfo.getSdkpri();
    }
}
