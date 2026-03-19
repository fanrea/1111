package com.baidu.mobads.container.landingpage;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mobads.container.XAdInstanceInfoExt;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public abstract class XAdRemoteCommandExtraInfo implements Parcelable {
    public String a;
    public XAdInstanceInfoExt b;
    public int c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public boolean i;
    public boolean j;
    public String k;
    public String l;
    public String m;
    public Boolean n;
    public String o;
    public String p;
    public String q;
    public Boolean r;
    public String s;
    public Boolean t;

    public XAdRemoteCommandExtraInfo(String str, XAdInstanceInfoExt xAdInstanceInfoExt) {
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = false;
        this.j = true;
        this.k = "-1";
        this.l = "";
        this.m = "";
        this.n = true;
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = true;
        this.s = "";
        this.t = true;
        this.c = 999;
        this.d = "this is the test string";
        this.a = str;
        this.b = xAdInstanceInfoExt;
    }

    protected XAdRemoteCommandExtraInfo(Parcel parcel) {
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = false;
        this.j = true;
        this.k = "-1";
        this.l = "";
        this.m = "";
        this.n = true;
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = true;
        this.s = "";
        this.t = true;
        this.b = (XAdInstanceInfoExt) parcel.readParcelable(XAdInstanceInfoExt.class.getClassLoader());
        this.a = parcel.readString();
        this.c = parcel.readInt();
        this.d = parcel.readString();
    }

    public com.baidu.mobads.container.adrequest.j a() {
        return this.b;
    }

    public Boolean b() {
        return Boolean.valueOf("-1".equalsIgnoreCase(this.k));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.b, i);
        parcel.writeString(this.a);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
    }
}
