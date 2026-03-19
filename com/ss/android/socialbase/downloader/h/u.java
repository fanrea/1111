package com.ss.android.socialbase.downloader.h;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class u implements Parcelable, Comparable {
    public static final Parcelable.Creator<u> CREATOR = new Parcelable.Creator<u>() { // from class: com.ss.android.socialbase.downloader.h.u.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public u createFromParcel(Parcel parcel) {
            return new u(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public u[] newArray(int i) {
            return new u[i];
        }
    };
    private final String d;
    private final String hc;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public u(String str, String str2) {
        this.d = str;
        this.hc = str2;
    }

    protected u(Parcel parcel) {
        this.d = parcel.readString();
        this.hc = parcel.readString();
    }

    public String d() {
        return this.d;
    }

    public String hc() {
        return this.hc;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.d);
        parcel.writeString(this.hc);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (!(obj instanceof u)) {
            return 1;
        }
        u uVar = (u) obj;
        if (TextUtils.equals(this.d, uVar.d())) {
            return 0;
        }
        String str = this.d;
        if (str == null) {
            return -1;
        }
        int iCompareTo = str.compareTo(uVar.d());
        if (iCompareTo > 0) {
            return 1;
        }
        return iCompareTo < 0 ? -1 : 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            u uVar = (u) obj;
            if (TextUtils.equals(this.d, uVar.d) && TextUtils.equals(this.hc, uVar.hc)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.d;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.hc;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "HttpHeader{name='" + this.d + "', value='" + this.hc + "'}";
    }
}
