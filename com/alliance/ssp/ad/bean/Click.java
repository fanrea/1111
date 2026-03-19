package com.alliance.ssp.ad.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class Click implements Parcelable {
    public static final Parcelable.Creator<Click> CREATOR = new a();
    public Float clickCountdownTime;
    public String limitation;
    public Float probability;

    public class a implements Parcelable.Creator<Click> {
        @Override // android.os.Parcelable.Creator
        public Click createFromParcel(Parcel parcel) {
            return new Click(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Click[] newArray(int i) {
            return new Click[i];
        }
    }

    public Click(Parcel parcel) {
        try {
            this.limitation = parcel.readString();
            this.probability = Float.valueOf(parcel.readFloat());
            if (this.clickCountdownTime != null) {
                this.clickCountdownTime = Float.valueOf(parcel.readFloat());
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.limitation);
        parcel.writeFloat(this.probability.floatValue());
        Float f = this.clickCountdownTime;
        if (f != null) {
            parcel.writeFloat(f.floatValue());
        }
    }
}
