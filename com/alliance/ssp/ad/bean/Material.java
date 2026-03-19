package com.alliance.ssp.ad.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class Material implements Parcelable {
    public static final Parcelable.Creator<Material> CREATOR = new a();
    private String adm;
    private String apkname;
    private String appIntro;
    private String appPublisher;
    private String crid;
    private String deeplink;
    private String desc;
    private int duration;
    private String h;
    private String iconurl;
    private List<String> imgurl;
    private String ldp;
    private int ldptype;
    private String packagename;
    private String permissionUrl;
    private String privacyUrl;
    private String tempid;
    private String title;
    private String versionName;
    private String videourl;
    private String w;

    public class a implements Parcelable.Creator<Material> {
        @Override // android.os.Parcelable.Creator
        public Material createFromParcel(Parcel parcel) {
            return new Material(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Material[] newArray(int i) {
            return new Material[i];
        }
    }

    public Material(Parcel parcel) {
        try {
            this.crid = parcel.readString();
            this.ldptype = parcel.readInt();
            this.ldp = parcel.readString();
            this.deeplink = parcel.readString();
            this.tempid = parcel.readString();
            this.apkname = parcel.readString();
            this.packagename = parcel.readString();
            this.videourl = parcel.readString();
            this.duration = parcel.readInt();
            this.imgurl = parcel.createStringArrayList();
            this.w = parcel.readString();
            this.h = parcel.readString();
            this.desc = parcel.readString();
            this.title = parcel.readString();
            this.adm = parcel.readString();
            this.iconurl = parcel.readString();
            this.appPublisher = parcel.readString();
            this.versionName = parcel.readString();
            this.appIntro = parcel.readString();
            this.permissionUrl = parcel.readString();
            this.privacyUrl = parcel.readString();
        } catch (Exception unused) {
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdm() {
        return this.adm;
    }

    public String getApkname() {
        return this.apkname;
    }

    public String getAppIntro() {
        return this.appIntro;
    }

    public String getAppPublisher() {
        return this.appPublisher;
    }

    public String getCrid() {
        return this.crid;
    }

    public String getDeeplink() {
        return this.deeplink;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getH() {
        if (this.h == null) {
            this.h = "";
        }
        return this.h;
    }

    public String getIconurl() {
        return this.iconurl;
    }

    public List<String> getImgurl() {
        return this.imgurl;
    }

    public String getLdp() {
        return this.ldp;
    }

    public int getLdptype() {
        return this.ldptype;
    }

    public String getPackagename() {
        return this.packagename;
    }

    public String getPermissionUrl() {
        return this.permissionUrl;
    }

    public String getPrivacyUrl() {
        return this.privacyUrl;
    }

    public String getTempid() {
        return this.tempid;
    }

    public String getTitle() {
        return this.title;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public String getVideourl() {
        String str = this.videourl;
        if (str == null || str.isEmpty()) {
            return null;
        }
        return this.videourl;
    }

    public String getW() {
        if (this.w == null) {
            this.w = "";
        }
        return this.w;
    }

    public void setAdm(String str) {
        this.adm = str;
    }

    public void setApkname(String str) {
        this.apkname = str;
    }

    public void setAppIntro(String str) {
        this.appIntro = str;
    }

    public void setAppPublisher(String str) {
        this.appPublisher = str;
    }

    public void setCrid(String str) {
        this.crid = str;
    }

    public void setDeeplink(String str) {
        this.deeplink = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setH(String str) {
        this.h = str;
    }

    public void setIconurl(String str) {
        this.iconurl = str;
    }

    public void setImgurl(List<String> list) {
        this.imgurl = list;
    }

    public void setLdp(String str) {
        this.ldp = str;
    }

    public void setLdptype(int i) {
        this.ldptype = i;
    }

    public void setPackagename(String str) {
        this.packagename = str;
    }

    public void setPermissionUrl(String str) {
        this.permissionUrl = str;
    }

    public void setPrivacyUrl(String str) {
        this.privacyUrl = str;
    }

    public void setTempid(String str) {
        this.tempid = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }

    public void setVideourl(String str) {
        this.videourl = str;
    }

    public void setW(String str) {
        this.w = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.crid);
        parcel.writeInt(this.ldptype);
        parcel.writeString(this.ldp);
        parcel.writeString(this.deeplink);
        parcel.writeString(this.tempid);
        parcel.writeString(this.apkname);
        parcel.writeString(this.packagename);
        parcel.writeString(this.videourl);
        parcel.writeInt(this.duration);
        parcel.writeStringList(this.imgurl);
        parcel.writeString(this.w);
        parcel.writeString(this.h);
        parcel.writeString(this.desc);
        parcel.writeString(this.title);
        parcel.writeString(this.adm);
        parcel.writeString(this.iconurl);
        parcel.writeString(this.appPublisher);
        parcel.writeString(this.versionName);
        parcel.writeString(this.appIntro);
        parcel.writeString(this.permissionUrl);
        parcel.writeString(this.privacyUrl);
    }
}
