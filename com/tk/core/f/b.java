package com.tk.core.f;

import android.util.Log;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.o.t;
import com.tkruntime.v8.utils.V8ObjectUtilsQuick;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b implements com.tk.core.manager.a.a<a> {
    @Override // com.tk.core.manager.a.a
    public final Object a(Object obj, String str, Object[] objArr) {
        return null;
    }

    @Override // com.tk.core.manager.a.a
    public final void a(Object obj, Map<String, Object> map) {
    }

    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        if (i == 0) {
            return "featureFactorList";
        }
        if (i != 1) {
            return null;
        }
        return "lineHeightFactor";
    }

    @Override // com.tk.core.manager.a.a
    public final boolean f(String str) {
        return false;
    }

    @Override // com.tk.core.manager.a.a
    public final int h(String str) {
        return 0;
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "2#featureFactorList#0,2#lineHeightFactor#1,";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ a b(NativeModuleInitParams nativeModuleInitParams) {
        return at(nativeModuleInitParams);
    }

    private static a at(NativeModuleInitParams nativeModuleInitParams) {
        return new a(nativeModuleInitParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean g(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = -1775930518(0xffffffff9625736a, float:-1.3365012E-25)
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L1b
            r1 = -1772848605(0xffffffff96547a23, float:-1.7163763E-25)
            if (r0 == r1) goto L11
            goto L25
        L11:
            java.lang.String r0 = "featureFactorList"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L25
            r5 = 0
            goto L26
        L1b:
            java.lang.String r0 = "lineHeightFactor"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L25
            r5 = 1
            goto L26
        L25:
            r5 = -1
        L26:
            if (r5 == 0) goto L2b
            if (r5 == r3) goto L2b
            return r2
        L2b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.f.b.g(java.lang.String):boolean");
    }

    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        a aVar = (a) obj;
        char c = 65535;
        try {
            int iHashCode = str.hashCode();
            if (iHashCode != -1775930518) {
                if (iHashCode == -1772848605 && str.equals("featureFactorList")) {
                    c = 0;
                }
            } else if (str.equals("lineHeightFactor")) {
                c = 1;
            }
            if (c == 0) {
                aVar.ahY = (List) V8ObjectUtilsQuick.getValue(obj2);
            } else if (c == 1) {
                aVar.ahX = ((Boolean) obj2).booleanValue();
            } else {
                if (!t.isDebug()) {
                    return false;
                }
                Log.e("KDSFeature", "call applyProp() with unsupported prop: " + str);
                return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("KDSFeature apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r4, java.lang.String r5) {
        /*
            r3 = this;
            com.tk.core.f.a r4 = (com.tk.core.f.a) r4
            int r0 = r5.hashCode()
            r1 = -1775930518(0xffffffff9625736a, float:-1.3365012E-25)
            r2 = 1
            if (r0 == r1) goto L1c
            r1 = -1772848605(0xffffffff96547a23, float:-1.7163763E-25)
            if (r0 == r1) goto L12
            goto L26
        L12:
            java.lang.String r0 = "featureFactorList"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L26
            r0 = 0
            goto L27
        L1c:
            java.lang.String r0 = "lineHeightFactor"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L26
            r0 = 1
            goto L27
        L26:
            r0 = -1
        L27:
            if (r0 == 0) goto L4d
            if (r0 == r2) goto L46
            boolean r4 = com.tk.core.o.t.isDebug()
            if (r4 == 0) goto L44
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r0 = "call getProp() with unsupported prop: "
            r4.<init>(r0)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "KDSFeature"
            android.util.Log.e(r5, r4)
        L44:
            r4 = 0
            return r4
        L46:
            boolean r4 = r4.ahX
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            return r4
        L4d:
            java.util.List<java.lang.String> r4 = r4.ahY
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.f.b.a(java.lang.Object, java.lang.String):java.lang.Object");
    }
}
