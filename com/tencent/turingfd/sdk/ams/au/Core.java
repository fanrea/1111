package com.tencent.turingfd.sdk.ams.au;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Core implements Parcelable {
    public int a;
    public byte[] b;
    public int c;

    public Core(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.createByteArray();
        this.c = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeByteArray(this.b);
        parcel.writeInt(this.c);
    }
}
