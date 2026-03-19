package com.kwad.tachikoma.c;

import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tkruntime.v8.V8Trace;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c implements com.tk.core.manager.a.a<a> {
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
        switch (i) {
            case 0:
                return "exportInstance";
            case 1:
                return V8Trace.SECTION_LOAD_BUNDLE;
            case 2:
                return "unloadBundle";
            case 3:
                return "getInstance";
            case 4:
                return "destroyInstance";
            case 5:
                return "loadBundleWithString";
            case 6:
                return "exportCreator";
            default:
                return null;
        }
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
        return "4#exportInstance#0,4#loadBundle#1,4#unloadBundle#2,8#getInstance#3,4#destroyInstance#4,4#loadBundleWithString#5,4#exportCreator#6";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ a b(NativeModuleInitParams nativeModuleInitParams) {
        return i(nativeModuleInitParams);
    }

    private static a i(NativeModuleInitParams nativeModuleInitParams) {
        return new a(nativeModuleInitParams);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int h(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = 1
            r2 = 2
            r3 = 0
            switch(r0) {
                case -1661939189: goto L47;
                case -701686520: goto L3d;
                case -210429847: goto L33;
                case 1243881375: goto L29;
                case 1250557615: goto L1f;
                case 1419935841: goto L15;
                case 2112238040: goto Lb;
                default: goto La;
            }
        La:
            goto L51
        Lb:
            java.lang.String r0 = "exportCreator"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L51
            r5 = 6
            goto L52
        L15:
            java.lang.String r0 = "unloadBundle"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L51
            r5 = 3
            goto L52
        L1f:
            java.lang.String r0 = "destroyInstance"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L51
            r5 = 4
            goto L52
        L29:
            java.lang.String r0 = "loadBundleWithString"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L51
            r5 = 5
            goto L52
        L33:
            java.lang.String r0 = "exportInstance"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L51
            r5 = 1
            goto L52
        L3d:
            java.lang.String r0 = "loadBundle"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L51
            r5 = 2
            goto L52
        L47:
            java.lang.String r0 = "getInstance"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L51
            r5 = 0
            goto L52
        L51:
            r5 = -1
        L52:
            switch(r5) {
                case 0: goto L57;
                case 1: goto L56;
                case 2: goto L56;
                case 3: goto L56;
                case 4: goto L56;
                case 5: goto L56;
                case 6: goto L56;
                default: goto L55;
            }
        L55:
            return r3
        L56:
            return r1
        L57:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.c.c.h(java.lang.String):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0053  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r6, java.lang.String r7, java.lang.Object[] r8) {
        /*
            r5 = this;
            com.kwad.tachikoma.c.a r6 = (com.kwad.tachikoma.c.a) r6
            int r0 = r7.hashCode()
            r1 = 2
            r2 = 1
            r3 = 0
            switch(r0) {
                case -1661939189: goto L49;
                case -701686520: goto L3f;
                case -210429847: goto L35;
                case 1243881375: goto L2b;
                case 1250557615: goto L21;
                case 1419935841: goto L17;
                case 2112238040: goto Ld;
                default: goto Lc;
            }
        Lc:
            goto L53
        Ld:
            java.lang.String r0 = "exportCreator"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L53
            r0 = 6
            goto L54
        L17:
            java.lang.String r0 = "unloadBundle"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L53
            r0 = 2
            goto L54
        L21:
            java.lang.String r0 = "destroyInstance"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L53
            r0 = 4
            goto L54
        L2b:
            java.lang.String r0 = "loadBundleWithString"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L53
            r0 = 5
            goto L54
        L35:
            java.lang.String r0 = "exportInstance"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L53
            r0 = 0
            goto L54
        L3f:
            java.lang.String r0 = "loadBundle"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L53
            r0 = 1
            goto L54
        L49:
            java.lang.String r0 = "getInstance"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L53
            r0 = 3
            goto L54
        L53:
            r0 = -1
        L54:
            r4 = 0
            switch(r0) {
                case 0: goto Lcb;
                case 1: goto Lbb;
                case 2: goto Lb1;
                case 3: goto L9c;
                case 4: goto L92;
                case 5: goto L82;
                case 6: goto L72;
                default: goto L58;
            }
        L58:
            boolean r6 = com.tk.core.o.t.isDebug()
            if (r6 == 0) goto Lda
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "can't find method ---> "
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "TKBundleService"
            android.util.Log.e(r7, r6)
            goto Lda
        L72:
            java.lang.Object r7 = com.tk.core.o.a.b(r8, r3)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = com.tk.core.o.a.b(r8, r2)
            com.tkruntime.v8.V8Function r8 = (com.tkruntime.v8.V8Function) r8
            r6.d(r7, r8)
            return r4
        L82:
            java.lang.Object r7 = com.tk.core.o.a.b(r8, r3)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = com.tk.core.o.a.b(r8, r2)
            com.tkruntime.v8.V8Function r8 = (com.tkruntime.v8.V8Function) r8
            r6.c(r7, r8)
            return r4
        L92:
            java.lang.Object r6 = com.tk.core.o.a.b(r8, r3)
            com.tkruntime.v8.V8Object r6 = (com.tkruntime.v8.V8Object) r6
            com.kwad.tachikoma.c.a.f(r6)
            return r4
        L9c:
            java.lang.Object r7 = com.tk.core.o.a.b(r8, r3)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r0 = com.tk.core.o.a.b(r8, r2)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r8 = com.tk.core.o.a.b(r8, r1)
            com.tkruntime.v8.V8Value r6 = r6.a(r7, r0, r8)
            return r6
        Lb1:
            java.lang.Object r6 = com.tk.core.o.a.b(r8, r3)
            java.lang.String r6 = (java.lang.String) r6
            com.kwad.tachikoma.c.a.unloadBundle(r6)
            return r4
        Lbb:
            java.lang.Object r7 = com.tk.core.o.a.b(r8, r3)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = com.tk.core.o.a.b(r8, r2)
            com.tkruntime.v8.V8Function r8 = (com.tkruntime.v8.V8Function) r8
            r6.b(r7, r8)
            return r4
        Lcb:
            java.lang.Object r7 = com.tk.core.o.a.b(r8, r3)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = com.tk.core.o.a.b(r8, r2)
            com.tkruntime.v8.V8Object r8 = (com.tkruntime.v8.V8Object) r8
            r6.a(r7, r8)
        Lda:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.c.c.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
