package com.alliance.ssp.ad.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class SAAllianceAdStrategyData implements Parcelable {
    public static final Parcelable.Creator<SAAllianceAdStrategyData> CREATOR = new a();
    private List<SAAllianceAdStrategyUnitData> ads;
    private String isNewUser;
    private String registerTime;
    private String serialflag;
    private String sposid;

    public class a implements Parcelable.Creator<SAAllianceAdStrategyData> {
        @Override // android.os.Parcelable.Creator
        public SAAllianceAdStrategyData createFromParcel(Parcel parcel) {
            return new SAAllianceAdStrategyData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public SAAllianceAdStrategyData[] newArray(int i) {
            return new SAAllianceAdStrategyData[i];
        }
    }

    public SAAllianceAdStrategyData(Parcel parcel) {
        this.ads = parcel.readArrayList(SAAllianceAdStrategyUnitData.class.getClassLoader());
        this.isNewUser = parcel.readString();
        this.registerTime = parcel.readString();
        this.serialflag = parcel.readString();
        this.sposid = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getSerialflag() {
        return this.serialflag;
    }

    public String getSposid() {
        return this.sposid;
    }

    public List<SAAllianceAdStrategyUnitData> getStrategyUnitdatas() {
        return this.ads;
    }

    public String getisNewUser() {
        return this.isNewUser;
    }

    public String getregisterTime() {
        return this.registerTime;
    }

    public void setSerialflag(String str) {
        this.serialflag = str;
    }

    public void setSposid(String str) {
        this.sposid = str;
    }

    public void setStrategyUnitdatas(List<SAAllianceAdStrategyUnitData> list) {
        this.ads = list;
    }

    public void setisNewUser(String str) {
        this.isNewUser = str;
    }

    public void setregisterTime(String str) {
        this.registerTime = this.registerTime;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.isNewUser);
        parcel.writeString(this.registerTime);
        parcel.writeString(this.sposid);
        parcel.writeString(this.serialflag);
        parcel.writeTypedList(this.ads);
    }
}
