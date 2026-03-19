package com.kwad.tachikoma.n;

import com.kuaishou.tk.export.NativeModuleInitParams;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b implements com.tk.core.manager.a.a<a> {
    @Override // com.tk.core.manager.a.a
    public final Object a(Object obj, String str) {
        return null;
    }

    @Override // com.tk.core.manager.a.a
    public final void a(Object obj, Map<String, Object> map) {
    }

    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        return false;
    }

    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        if (i == 0) {
            return "getPackageInfo";
        }
        if (i == 1) {
            return "queryIntentActivities";
        }
        if (i != 2) {
            return null;
        }
        return "getLaunchIntentForPackage";
    }

    @Override // com.tk.core.manager.a.a
    public final boolean f(String str) {
        return false;
    }

    @Override // com.tk.core.manager.a.a
    public final boolean g(String str) {
        return false;
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "8#getPackageInfo#0,8#queryIntentActivities#1,8#getLaunchIntentForPackage#2";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ a b(NativeModuleInitParams nativeModuleInitParams) {
        return x(nativeModuleInitParams);
    }

    private static a x(NativeModuleInitParams nativeModuleInitParams) {
        return new a(nativeModuleInitParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int h(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = -1477209150(0xffffffffa7f393c2, float:-6.760625E-15)
            r2 = 0
            r3 = 1
            r4 = 2
            if (r0 == r1) goto L2b
            r1 = 268353758(0xffec0de, float:2.5120623E-29)
            if (r0 == r1) goto L21
            r1 = 1374193809(0x51e88891, float:1.2484045E11)
            if (r0 == r1) goto L17
            goto L35
        L17:
            java.lang.String r0 = "queryIntentActivities"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L35
            r6 = 1
            goto L36
        L21:
            java.lang.String r0 = "getPackageInfo"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L35
            r6 = 0
            goto L36
        L2b:
            java.lang.String r0 = "getLaunchIntentForPackage"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L35
            r6 = 2
            goto L36
        L35:
            r6 = -1
        L36:
            if (r6 == 0) goto L3d
            if (r6 == r3) goto L3d
            if (r6 == r4) goto L3d
            return r2
        L3d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.n.b.h(java.lang.String):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r6, java.lang.String r7, java.lang.Object[] r8) {
        /*
            r5 = this;
            com.kwad.tachikoma.n.a r6 = (com.kwad.tachikoma.n.a) r6
            int r0 = r7.hashCode()
            r1 = -1477209150(0xffffffffa7f393c2, float:-6.760625E-15)
            r2 = 2
            r3 = 0
            r4 = 1
            if (r0 == r1) goto L2d
            r1 = 268353758(0xffec0de, float:2.5120623E-29)
            if (r0 == r1) goto L23
            r1 = 1374193809(0x51e88891, float:1.2484045E11)
            if (r0 == r1) goto L19
            goto L37
        L19:
            java.lang.String r0 = "queryIntentActivities"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L37
            r0 = 1
            goto L38
        L23:
            java.lang.String r0 = "getPackageInfo"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L37
            r0 = 0
            goto L38
        L2d:
            java.lang.String r0 = "getLaunchIntentForPackage"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L37
            r0 = 2
            goto L38
        L37:
            r0 = -1
        L38:
            if (r0 == 0) goto L79
            if (r0 == r4) goto L64
            if (r0 == r2) goto L59
            boolean r6 = com.tk.core.o.t.isDebug()
            if (r6 == 0) goto L57
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "can't find method ---> "
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "TKPackageManager"
            android.util.Log.e(r7, r6)
        L57:
            r6 = 0
            return r6
        L59:
            java.lang.Object r7 = com.tk.core.o.a.b(r8, r3)
            java.lang.String r7 = (java.lang.String) r7
            com.tkruntime.v8.V8Object r6 = r6.C(r7)
            return r6
        L64:
            java.lang.Object r7 = com.tk.core.o.a.b(r8, r3)
            com.tkruntime.v8.V8Object r7 = (com.tkruntime.v8.V8Object) r7
            java.lang.Object r8 = com.tk.core.o.a.c(r8, r4)
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = com.tk.core.manager.a.f.h(r8)
            java.util.List r6 = r6.a(r7, r8)
            return r6
        L79:
            java.lang.Object r7 = com.tk.core.o.a.b(r8, r3)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = com.tk.core.o.a.c(r8, r4)
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = com.tk.core.manager.a.f.h(r8)
            java.util.Map r6 = r6.f(r7, r8)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.n.b.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
