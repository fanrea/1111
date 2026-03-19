package com.apm.insight.runtime.a;

import android.content.Context;
import com.apm.insight.CrashType;
import com.apm.insight.entity.Header;
import com.apm.insight.runtime.a.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class f {
    private static volatile f a;
    private Context b;
    private Map<CrashType, c> c = new HashMap();
    private b d;
    private d e;

    /* renamed from: com.apm.insight.runtime.a.f$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[CrashType.values().length];
            a = iArr;
            try {
                iArr[CrashType.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[CrashType.LAUNCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[CrashType.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[CrashType.ANR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[CrashType.DART.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[CrashType.CUSTOM_JAVA.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[CrashType.BLOCK.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[CrashType.ENSURE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[CrashType.EXIT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[CrashType.PORTRAIT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    private f(Context context) {
        this.b = context;
        try {
            this.d = b.d();
            this.e = new d(this.b);
        } catch (Throwable th) {
            com.apm.insight.b.a().a("NPTH_CATCH", th);
        }
    }

    private c a(CrashType crashType) {
        c lVar = this.c.get(crashType);
        if (lVar != null) {
            return lVar;
        }
        switch (AnonymousClass1.a[crashType.ordinal()]) {
            case 1:
                lVar = new l(this.b, this.d, this.e);
                break;
            case 2:
                lVar = new m(this.b, this.d, this.e);
                break;
            case 3:
                lVar = new n(this.b, this.d, this.e);
                break;
            case 4:
                lVar = new a(this.b, this.d, this.e);
                break;
            case 5:
                lVar = new i(this.b, this.d, this.e);
                break;
            case 6:
                lVar = new h(this.b, this.d, this.e);
                break;
            case 7:
                lVar = new e(this.b, this.d, this.e);
                break;
            case 8:
                lVar = new j(this.b, this.d, this.e);
                break;
            case 9:
                lVar = new k(this.b, this.d, this.e);
                break;
            case 10:
                lVar = new g(this.b, this.d, this.e);
                break;
        }
        if (lVar != null) {
            this.c.put(crashType, lVar);
        }
        return lVar;
    }

    public static f a() {
        if (a == null) {
            Context contextF = com.apm.insight.g.f();
            if (contextF == null) {
                throw new IllegalArgumentException("NpthBus not init");
            }
            a = new f(contextF);
        }
        return a;
    }

    public com.apm.insight.entity.a a(CrashType crashType, com.apm.insight.entity.a aVar) {
        c cVarA;
        return (crashType == null || (cVarA = a(crashType)) == null) ? aVar : cVarA.a(aVar, null, false);
    }

    public com.apm.insight.entity.a a(CrashType crashType, com.apm.insight.entity.a aVar, c.a aVar2, boolean z) {
        c cVarA;
        return (crashType == null || (cVarA = a(crashType)) == null) ? aVar : cVarA.a(aVar, aVar2, z);
    }

    public com.apm.insight.entity.a a(List<com.apm.insight.entity.a> list, JSONArray jSONArray) throws JSONException {
        if (list == null || list.isEmpty()) {
            return null;
        }
        com.apm.insight.entity.a aVar = new com.apm.insight.entity.a();
        JSONArray jSONArray2 = new JSONArray();
        Iterator<com.apm.insight.entity.a> it = list.iterator();
        while (it.hasNext()) {
            jSONArray2.put(it.next().h());
        }
        aVar.a("data", (Object) jSONArray2);
        aVar.a("all_data", (Object) jSONArray);
        Header headerA = Header.a(this.b);
        Header.a(headerA);
        headerA.c();
        headerA.d();
        headerA.e();
        Header.b(headerA);
        aVar.a(headerA);
        return aVar;
    }
}
