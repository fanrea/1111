package com.ss.android.socialbase.downloader.u;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d extends Exception implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() { // from class: com.ss.android.socialbase.downloader.u.d.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public d[] newArray(int i) {
            return new d[i];
        }
    };
    private String b;
    private int d;
    private String hc;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public d() {
        this.b = "";
    }

    public d(int i, String str) {
        super("[d-ex]:".concat(String.valueOf(str)));
        this.b = "";
        this.hc = "[d-ex]:".concat(String.valueOf(str));
        this.d = i;
    }

    public void d(String str) {
        this.hc = str;
    }

    public d(int i, Throwable th) {
        this(i, com.ss.android.socialbase.downloader.e.an.tc(th));
    }

    protected d(Parcel parcel) {
        this.b = "";
        d(parcel);
    }

    public void d(Parcel parcel) {
        this.d = parcel.readInt();
        this.hc = parcel.readString();
        this.b = parcel.readString();
    }

    public int d() {
        return this.d;
    }

    public String hc() {
        return this.hc;
    }

    public String b() {
        return this.b;
    }

    public void hc(String str) {
        this.b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.d);
        parcel.writeString(this.hc);
        parcel.writeString(this.b);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "BaseException{errorCode=" + this.d + ", errorMsg='" + this.hc + "'}";
    }
}
