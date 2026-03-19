package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class TuringSDK extends Foxnut {

    /* compiled from: A */
    public static final class Builder {
        public Context a;
        public ITuringPrivacyPolicy s;
        public ITuringDeviceInfoProvider t;
        public ITuringPkgProvider u;
        public ITuringIoTFeatureMap v;
        public String b = "";
        public int c = 5000;
        public long d = 60000;
        public int e = 3;
        public String f = "";
        public String g = "";
        public int h = 0;
        public String i = "";
        public int j = 0;
        public Map<Integer, String> k = new HashMap();
        public boolean l = true;
        public String m = "";
        public String n = "";
        public boolean o = true;
        public boolean p = true;
        public boolean q = false;
        public boolean r = true;
        public boolean w = false;
        public boolean x = false;
        public boolean y = false;
        public boolean z = false;
        public ITuringPermissionRuntime A = null;
        public boolean B = false;

        public Builder(Context context, ITuringPrivacyPolicy iTuringPrivacyPolicy) {
            this.a = context.getApplicationContext();
            this.s = iTuringPrivacyPolicy;
        }

        public final Builder a(String str) {
            this.m = str;
            return this;
        }

        public final Builder b() {
            this.B = true;
            return this;
        }

        public final TuringSDK a() {
            return new TuringSDK(this);
        }

        public final Builder b(boolean z) {
            this.o = z;
            return this;
        }

        public final Builder a(boolean z) {
            this.l = z;
            return this;
        }

        public final Builder a(ITuringPermissionRuntime iTuringPermissionRuntime) {
            this.A = iTuringPermissionRuntime;
            return this;
        }

        public final Builder a(ITuringDeviceInfoProvider iTuringDeviceInfoProvider) {
            this.t = iTuringDeviceInfoProvider;
            return this;
        }
    }

    public TuringSDK(Builder builder) {
        a(builder.a);
        this.g = builder.b;
        this.w = builder.c;
        this.x = builder.d;
        this.y = builder.e;
        this.m = builder.g;
        this.l = builder.f;
        this.n = builder.h;
        this.o = builder.i;
        this.p = builder.k;
        this.f = builder.j;
        this.h = builder.l;
        this.q = builder.m;
        this.k = builder.n;
        this.t = builder.o;
        this.r = builder.p;
        this.s = builder.q;
        this.u = builder.r;
        this.b = builder.s;
        this.c = builder.t;
        this.d = builder.u;
        this.e = builder.v;
        this.v = builder.w;
        this.A = builder.x;
        this.B = builder.y;
        this.E = builder.z;
        this.D = builder.A;
        this.C = builder.B;
        a();
    }

    public static Builder a(Context context, ITuringPrivacyPolicy iTuringPrivacyPolicy) {
        return new Builder(context, iTuringPrivacyPolicy);
    }

    public int d() {
        AtomicBoolean atomicBoolean = Melon.c;
        synchronized (atomicBoolean) {
            if (atomicBoolean.get()) {
                return 0;
            }
            if (Build.VERSION.SDK_INT == 23) {
                String strA = Date.a("M String fixed1".getBytes(), "UTF-8");
                if (strA == null) {
                    strA = "M String fixed1 failed";
                }
                Log.i("TuringFdJava", strA);
                String strA2 = Date.a("M String fixed2".getBytes(), null);
                if (strA2 == null) {
                    strA2 = "M String fixed2 failed";
                }
                Log.i("TuringFdJava", strA2);
            }
            int i = this.f;
            if (i > 0) {
                Casaba.a = i;
            }
            if (Casaba.a == 0) {
                Log.e("TuringFdJava", "please input valid channel!");
                return -10018;
            }
            Casaba.b = this.A;
            synchronized (Foxnut.class) {
                Foxnut.F = this;
            }
            Log.i("TuringFdJava", Melon.b());
            AtomicReference<String> atomicReference = Cdefault.a;
            if (!TextUtils.isEmpty(null)) {
                AtomicReference<String> atomicReference2 = Cdefault.a;
                synchronized (atomicReference2) {
                    atomicReference2.set(null);
                }
            }
            System.currentTimeMillis();
            int iB = Melon.b(this);
            if (iB == 0) {
                iB = Melon.c(this);
                if (iB == 0) {
                    Loquat.b.a = this;
                    Melon.a(this);
                    atomicBoolean.set(true);
                    return 0;
                }
            }
            return iB;
        }
    }
}
