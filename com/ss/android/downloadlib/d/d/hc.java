package com.ss.android.downloadlib.d.d;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class hc implements Parcelable {
    public static final Parcelable.Creator<hc> CREATOR = new Parcelable.Creator<hc>() { // from class: com.ss.android.downloadlib.d.d.hc.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public hc createFromParcel(Parcel parcel) {
            return new hc(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public hc[] newArray(int i) {
            return new hc[i];
        }
    };
    public String an;
    public String b;
    public int c;
    public int d;
    public int hc;
    public String u;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "";
    }

    public hc() {
        this.b = "";
        this.u = "";
        this.an = "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.d);
        parcel.writeInt(this.hc);
        parcel.writeString(this.b);
        parcel.writeString(this.u);
        parcel.writeString(this.an);
        parcel.writeInt(this.c);
    }

    protected hc(Parcel parcel) {
        this.b = "";
        this.u = "";
        this.an = "";
        this.d = parcel.readInt();
        this.hc = parcel.readInt();
        this.b = parcel.readString();
        this.u = parcel.readString();
        this.an = parcel.readString();
        this.c = parcel.readInt();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            hc hcVar = (hc) obj;
            if (this.d == hcVar.d && this.hc == hcVar.hc) {
                String str = this.b;
                if (str != null) {
                    return str.equals(hcVar.b);
                }
                if (hcVar.b == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i = ((this.d * 31) + this.hc) * 31;
        String str = this.b;
        return i + (str != null ? str.hashCode() : 0);
    }
}
