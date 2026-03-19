package com.baidu.mobads.sdk.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mobstat.forbes.Config;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class by implements Parcelable {
    public static final String a = "MD5";
    public static final Parcelable.Creator<by> b = new bz();
    private JSONObject c;
    private double d;
    private String e;
    private String f;
    private String g;
    private int h;
    private int i;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ by(Parcel parcel, bz bzVar) {
        this(parcel);
    }

    public by(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.c = jSONObject;
            this.d = jSONObject.getDouble(Config.INPUT_DEF_VERSION);
            this.e = this.c.getString("url");
            this.f = this.c.getString("sign");
            this.i = 1;
            this.g = "";
            this.h = 0;
        } catch (JSONException unused) {
            this.i = 0;
        }
        this.i = c() == null ? 0 : 1;
    }

    public by(by byVar, String str, Boolean bool) {
        this.d = byVar.b();
        this.e = byVar.c();
        this.f = byVar.d();
        this.i = byVar.a().booleanValue() ? 1 : 0;
        this.g = str;
        this.h = bool.booleanValue() ? 1 : 0;
    }

    private by(Parcel parcel) {
        this.f = parcel.readString();
        this.i = parcel.readInt();
        this.e = parcel.readString();
        this.d = parcel.readDouble();
        this.g = parcel.readString();
        this.h = parcel.readInt();
    }

    public Boolean a() {
        return Boolean.valueOf(this.i == 1);
    }

    public double b() {
        return this.d;
    }

    public String c() {
        return cr.a().c(this.e);
    }

    public String d() {
        return this.f;
    }

    public String e() {
        return this.g;
    }

    public Boolean f() {
        return Boolean.valueOf(this.h == 1);
    }

    public String toString() {
        return this.c.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f);
        parcel.writeInt(this.i);
        parcel.writeString(this.e);
        parcel.writeDouble(this.d);
        parcel.writeString(this.g);
        parcel.writeInt(this.h);
    }
}
