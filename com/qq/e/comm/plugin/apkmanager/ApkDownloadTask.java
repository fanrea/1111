package com.qq.e.comm.plugin.apkmanager;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.mobads.container.rewardvideo.RemoteRewardActivity;
import com.qq.e.comm.plugin.h4;
import com.qq.e.comm.plugin.jn;
import com.qq.e.comm.plugin.l3;
import com.qq.e.comm.plugin.u20;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class ApkDownloadTask implements Parcelable {
    public static final Parcelable.Creator<ApkDownloadTask> CREATOR = new a();
    private int a;
    private final int b;
    private int c;
    private String d;
    private int e;
    private String f;
    private String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;
    private final String o;
    private final long p;
    private int q;
    private final Bundle r;
    private boolean s;
    private transient Bitmap t;
    private JSONObject u;
    private String v;
    private h4 w;

    class a implements Parcelable.Creator<ApkDownloadTask> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ApkDownloadTask createFromParcel(Parcel parcel) {
            return new ApkDownloadTask(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ApkDownloadTask[] newArray(int i) {
            return new ApkDownloadTask[i];
        }
    }

    private Bundle n() {
        return this.r;
    }

    public int b() {
        return this.e;
    }

    public String c() {
        return this.i;
    }

    public int d() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.p;
    }

    public void f(String str) {
        a("failReason", str);
    }

    public String g() {
        return this.l;
    }

    public String h() {
        return this.v;
    }

    public int i() {
        return this.q;
    }

    public Bitmap j() {
        return this.t;
    }

    public String k() {
        return this.j;
    }

    public JSONObject l() {
        String strD = d("launchParam");
        try {
            if (TextUtils.isEmpty(strD)) {
                return null;
            }
            return new JSONObject(strD);
        } catch (JSONException unused) {
            return null;
        }
    }

    public String m() {
        return this.f;
    }

    public int o() {
        return this.c;
    }

    public String p() {
        return this.n;
    }

    public String q() {
        return this.h;
    }

    public String r() {
        return this.o;
    }

    public String s() {
        return this.m;
    }

    public int t() {
        return this.a;
    }

    public String toString() {
        return "ApkDownloadTask{taskId=" + this.a + ", createNetType=" + this.b + ", status=" + this.c + ", targetAppName='" + this.n + "', targetPkgName='" + this.o + "', createTime=" + this.p + ", isReturned=" + this.s + '}';
    }

    public String u() {
        return this.k;
    }

    public String w() {
        return this.g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(a());
        parcel.writeInt(b());
        parcel.writeString(m());
        parcel.writeString(w());
        parcel.writeString(q());
        parcel.writeString(c());
        parcel.writeString(k());
        parcel.writeString(s());
        parcel.writeString(p());
        parcel.writeString(r());
        parcel.writeBundle(n());
        parcel.writeInt(d());
        parcel.writeLong(e());
        parcel.writeInt(o());
        parcel.writeString(u());
        parcel.writeString(g());
        parcel.writeInt(t());
        parcel.writeInt(i());
    }

    public boolean x() {
        return (this.q & 1) != 0;
    }

    public boolean y() {
        return this.s;
    }

    Bundle z() {
        Bundle bundle = new Bundle();
        bundle.putString("adId", this.d);
        bundle.putInt("adType", this.e);
        bundle.putString("posId", this.f);
        bundle.putString("traceId", this.g);
        bundle.putInt("taskId", this.a);
        bundle.putString("targetId", this.h);
        bundle.putString("clickId", this.i);
        bundle.putString("iconUrl", this.j);
        bundle.putString("targetUrl", this.m);
        bundle.putString("targetAppName", this.n);
        bundle.putString("targetPkgName", this.o);
        bundle.putInt("createNetType", this.b);
        bundle.putLong("createTime", this.p);
        bundle.putInt("status", this.c);
        bundle.putInt("flag", this.q);
        bundle.putBundle("property", this.r);
        bundle.putString("title", this.k);
        bundle.putString(RemoteRewardActivity.JSON_BANNER_DESC_ID, this.l);
        return bundle;
    }

    public void b(int i) {
        this.q = i;
    }

    public void c(int i) {
        this.c = i;
    }

    public void d(int i) {
        this.a = i;
    }

    public void e(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.v = str;
            a("extra", str);
            this.u = new jn(str).a();
        }
        this.w = u20.a(this.d, this.f, this.e, this.g, this.u);
    }

    public String f() {
        JSONObject jSONObjectL = l();
        if (jSONObjectL != null) {
            return jSONObjectL.optString("customized_invoke_url");
        }
        return null;
    }

    public int b(String str) {
        return this.r.getInt(str);
    }

    public long c(String str) {
        return this.r.getLong(str);
    }

    public String d(String str) {
        return this.r.getString(str);
    }

    public ApkDownloadTask(h4 h4Var, String str, String str2, String str3, String str4, String str5, int i) {
        this(h4Var.g(), h4Var.k().d(), h4Var.y0(), h4Var.N(), h4Var.A0(), str, str2, str3, str4, str5, new Bundle(), i, System.currentTimeMillis(), 0, h4Var.R0(), h4Var.H());
        a(h4Var);
    }

    public ApkDownloadTask a(h4 h4Var) {
        if (h4Var == null) {
            return this;
        }
        this.d = h4Var.g();
        this.f = h4Var.y0();
        this.g = h4Var.N();
        this.e = h4Var.k().d();
        l3 l3VarO = h4Var.o();
        if (l3VarO != null) {
            a("pkg_size", l3VarO.f());
        }
        this.w = h4Var;
        JSONObject jSONObjectA = u20.a(h4Var);
        this.u = jSONObjectA;
        String string = jSONObjectA.toString();
        this.v = string;
        a("extra", string);
        return this;
    }

    public void a(boolean z) {
        this.s = z;
    }

    public String a() {
        return this.d;
    }

    public void a(int i) {
        this.q = i | this.q;
    }

    public boolean a(String str) {
        return this.r.getBoolean(str);
    }

    public void a(String str, int i) {
        this.r.putInt(str, i);
    }

    public void a(String str, long j) {
        this.r.putLong(str, j);
    }

    public void a(String str, boolean z) {
        this.r.putBoolean(str, z);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.r.putString(str, str2);
    }

    public void a(Bitmap bitmap) {
        this.t = bitmap;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            a("launchParam", jSONObject.toString());
        }
    }

    public void a(String str, JSONObject jSONObject, boolean z) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("customized_invoke_url", str);
            jSONObject2.put("reportUrl", jSONObject);
            jSONObject2.put("appInstall", z);
        } catch (JSONException unused) {
        }
        a("launchParam", jSONObject2.toString());
    }

    public h4 v() {
        return this.w;
    }

    static ApkDownloadTask a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return new ApkDownloadTask(bundle);
    }

    public ApkDownloadTask(String str, h4 h4Var) {
        this(str);
        a(h4Var);
    }

    /* synthetic */ ApkDownloadTask(Parcel parcel, a aVar) {
        this(parcel);
    }

    public ApkDownloadTask(String str) {
        this(null, 0, null, null, null, null, null, null, null, str, null, 0, System.currentTimeMillis(), 0, null, null);
    }

    public ApkDownloadTask(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Bundle bundle, int i2, long j, int i3, String str10, String str11) {
        this.q = 0;
        this.d = str;
        this.e = i;
        this.f = str2;
        this.g = str3;
        this.h = str4;
        this.i = str5;
        this.j = str6;
        this.m = str7;
        this.n = str8;
        this.o = str9;
        this.b = i2;
        this.c = i3;
        this.p = j;
        this.k = str10;
        this.l = str11;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        this.r = bundle2;
        a("notifyId", 0);
        a("notifyTag", "GDT_DOWNLOAD_NOTIFY_TAG_" + r());
        a("appInstall", true);
        e(bundle2.getString("extra"));
    }

    private ApkDownloadTask(Bundle bundle) {
        this(bundle.getString("adId"), bundle.getInt("adType"), bundle.getString("posId"), bundle.getString("traceId"), bundle.getString("targetId"), bundle.getString("clickId"), bundle.getString("iconUrl"), bundle.getString("targetUrl"), bundle.getString("targetAppName"), bundle.getString("targetPkgName"), bundle.getBundle("property"), bundle.getInt("createNetType"), bundle.getLong("createTime"), bundle.getInt("status"), bundle.getString("title"), bundle.getString(RemoteRewardActivity.JSON_BANNER_DESC_ID));
        d(bundle.getInt("taskId"));
        b(bundle.getInt("flag"));
    }

    private ApkDownloadTask(Parcel parcel) {
        this(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readBundle(), parcel.readInt(), parcel.readLong(), parcel.readInt(), parcel.readString(), parcel.readString());
        d(parcel.readInt());
        b(parcel.readInt());
    }
}
