package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import com.tencent.turingfd.sdk.ams.au.Csynchronized;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Foxnut {
    public static Foxnut F;
    public static final Centaurus G = new Cdo();
    public CanisMajor D;
    public CanisMinor a;
    public Centaurus b;
    public ITuringDeviceInfoProvider c;
    public ITuringPkgProvider d;
    public ITuringIoTFeatureMap e;
    public int f = 0;
    public String g = "";
    public boolean h = true;
    public String[] i = null;
    public int j = 10000;
    public String k = "";
    public String l = "";
    public String m = "";
    public int n = 0;
    public String o = "";
    public Map<Integer, String> p = new HashMap();
    public String q = "";
    public boolean r = true;
    public boolean s = false;
    public boolean t = true;
    public boolean u = true;
    public boolean v = false;
    public long w = 5000;
    public long x = 60000;
    public int y = 3;
    public boolean z = false;
    public boolean A = false;
    public boolean B = false;
    public boolean C = false;
    public boolean E = false;

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Foxnut$do, reason: invalid class name */
    public class Cdo implements Centaurus {
        @Override // com.tencent.turingfd.sdk.ams.au.Centaurus
        public boolean a() {
            return false;
        }
    }

    public final void a() {
        String[] strArr = this.i;
        if (strArr != null) {
            if (strArr.length == 0) {
                this.i = null;
            } else {
                ArrayList arrayList = new ArrayList();
                for (String str : this.i) {
                    if (str != null && !str.isEmpty()) {
                        arrayList.add(str);
                    }
                }
                this.i = arrayList.isEmpty() ? null : (String[]) arrayList.toArray(new String[0]);
            }
        }
        if (this.i == null) {
            this.i = new String[]{"https://tdid.m.qq.com?mc=2"};
        }
        if (this.a != null) {
            this.z = true;
            return;
        }
        if (this.j < 1000) {
            this.j = 10000;
        }
        String[] strArr2 = this.i;
        int i = this.j;
        Csynchronized.Cdo cdo = new Csynchronized.Cdo(strArr2);
        if (strArr2.length > 1) {
            Cpackage.a.submit(new Cinstanceof(cdo, i));
        }
        this.a = cdo;
    }

    public final Context b() {
        Context context;
        synchronized (Ccase.class) {
            context = Ccase.a;
        }
        return context;
    }

    public Centaurus c() {
        Centaurus centaurus = this.b;
        return centaurus == null ? G : centaurus;
    }

    public final void a(Context context) {
        Ccase.a(context);
    }
}
