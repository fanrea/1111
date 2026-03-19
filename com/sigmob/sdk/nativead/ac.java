package com.sigmob.sdk.nativead;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ac implements Parcelable {
    public static final Parcelable.Creator<ac> CREATOR = new Parcelable.Creator<ac>() { // from class: com.sigmob.sdk.nativead.ac.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ac createFromParcel(Parcel in) {
            return new ac(in);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ac[] newArray(int size) {
            return new ac[size];
        }
    };
    private int a;
    private int b;
    private int c;
    private int d;

    public ac() {
    }

    protected ac(Parcel in) {
        this.a = in.readInt();
        this.b = in.readInt();
        this.c = in.readInt();
        this.d = in.readInt();
    }

    public int a() {
        return this.a;
    }

    public void a(int x) {
        this.a = x;
    }

    public int b() {
        return this.b;
    }

    public void b(int y) {
        this.b = y;
    }

    public int c() {
        return this.c;
    }

    public void c(int width) {
        this.c = width;
    }

    public int d() {
        return this.d;
    }

    public void d(int height) {
        this.d = height;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.a);
        dest.writeInt(this.b);
        dest.writeInt(this.c);
        dest.writeInt(this.d);
    }
}
