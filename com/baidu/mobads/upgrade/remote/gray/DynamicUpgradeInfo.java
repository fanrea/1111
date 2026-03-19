package com.baidu.mobads.upgrade.remote.gray;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class DynamicUpgradeInfo implements Parcelable {
    public static final Parcelable.Creator<DynamicUpgradeInfo> CREATOR = new b();
    private JSONObject a;
    private double b;
    private String c;
    private String d;
    private String e;

    /* synthetic */ DynamicUpgradeInfo(Parcel parcel, b bVar) {
        this(parcel);
    }

    public DynamicUpgradeInfo(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.a = new JSONObject(str);
            this.b = this.a.optDouble(Config.INPUT_DEF_VERSION);
            this.c = this.a.optString("url");
            this.d = this.a.optString("sign");
            this.e = this.a.optString("config");
        } catch (Throwable th) {
        }
    }

    private DynamicUpgradeInfo(Parcel parcel) {
        try {
            this.d = parcel.readString();
            this.c = parcel.readString();
            this.b = parcel.readDouble();
            this.e = parcel.readString();
        } catch (Throwable th) {
        }
    }

    public String a() {
        return this.d;
    }

    public String b() {
        return this.c;
    }

    public double c() {
        return this.b;
    }

    public String d() {
        return this.e;
    }

    public String toString() {
        if (this.a != null) {
            return this.a.toString();
        }
        return "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeString(this.d);
            parcel.writeString(this.c);
            parcel.writeDouble(this.b);
            parcel.writeString(this.e);
        } catch (Throwable th) {
        }
    }
}
