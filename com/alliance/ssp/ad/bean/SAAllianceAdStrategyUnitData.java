package com.alliance.ssp.ad.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class SAAllianceAdStrategyUnitData implements Parcelable {
    public static final Parcelable.Creator<SAAllianceAdStrategyUnitData> CREATOR = new a();
    private String appId;
    private String codeId;
    private String groupId;
    private String limitHour;
    private String limitInterval;
    private String limitTimes;
    private String originId;
    private String platformAppId;
    private String platformId;
    private String platformName;
    private String posId;
    private String screen;
    private String sortPrice;

    public class a implements Parcelable.Creator<SAAllianceAdStrategyUnitData> {
        @Override // android.os.Parcelable.Creator
        public SAAllianceAdStrategyUnitData createFromParcel(Parcel parcel) {
            return new SAAllianceAdStrategyUnitData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public SAAllianceAdStrategyUnitData[] newArray(int i) {
            return new SAAllianceAdStrategyUnitData[i];
        }
    }

    public SAAllianceAdStrategyUnitData(Parcel parcel) {
        this.appId = parcel.readString();
        this.codeId = parcel.readString();
        this.groupId = parcel.readString();
        this.originId = parcel.readString();
        this.platformAppId = parcel.readString();
        this.platformId = parcel.readString();
        this.platformName = parcel.readString();
        this.posId = parcel.readString();
        this.sortPrice = parcel.readString();
        this.screen = parcel.readString();
        this.limitHour = parcel.readString();
        this.limitInterval = parcel.readString();
        this.limitTimes = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getScreen() {
        return this.screen;
    }

    public String getappId() {
        return this.appId;
    }

    public String getcodeId() {
        return this.codeId;
    }

    public String getgroupId() {
        return this.groupId;
    }

    public String getlimitHour() {
        return this.limitHour;
    }

    public String getlimitInterval() {
        return this.limitInterval;
    }

    public String getlimitTimes() {
        return this.limitTimes;
    }

    public String getoriginId() {
        return this.originId;
    }

    public String getplatformAppId() {
        return this.platformAppId;
    }

    public String getplatformId() {
        return this.platformId;
    }

    public String getplatformName() {
        return this.platformName;
    }

    public String getposId() {
        return this.posId;
    }

    public String getsortPrice() {
        return this.sortPrice;
    }

    public void setScreen(String str) {
        this.screen = str;
    }

    public void setappId(String str) {
        this.appId = str;
    }

    public void setcodeId(String str) {
        this.codeId = str;
    }

    public void setgroupId(String str) {
        this.groupId = str;
    }

    public void setlimitHour(String str) {
        this.limitHour = str;
    }

    public void setlimitInterval(String str) {
        this.limitInterval = str;
    }

    public void setlimitTimes(String str) {
        this.limitTimes = str;
    }

    public void setoriginId(String str) {
        this.originId = str;
    }

    public void setplatformAppId(String str) {
        this.platformAppId = str;
    }

    public void setplatformId(String str) {
        this.platformId = str;
    }

    public void setplatformName(String str) {
        this.platformName = str;
    }

    public void setposId(String str) {
        this.posId = str;
    }

    public void setsortPrice(String str) {
        this.sortPrice = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.codeId);
        parcel.writeString(this.groupId);
        parcel.writeString(this.originId);
        parcel.writeString(this.platformAppId);
        parcel.writeString(this.platformId);
        parcel.writeString(this.platformName);
        parcel.writeString(this.posId);
        parcel.writeString(this.sortPrice);
        parcel.writeString(this.screen);
    }
}
