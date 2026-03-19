package com.kwad.tachikoma.a;

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
            return "registerAppLifeCycleCallback";
        }
        if (i == 1) {
            return "getCurrentAppState";
        }
        if (i == 2) {
            return "unregisterAppLifeCycleCallback";
        }
        if (i != 3) {
            return null;
        }
        return "getCurrentPage";
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
        return "8#registerAppLifeCycleCallback#0,8#getCurrentAppState#1,4#unregisterAppLifeCycleCallback#2,8#getCurrentPage#3";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ a b(NativeModuleInitParams nativeModuleInitParams) {
        return e(nativeModuleInitParams);
    }

    private static a e(NativeModuleInitParams nativeModuleInitParams) {
        return new a(nativeModuleInitParams);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int h(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = 0
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case -1455001391: goto L2a;
                case -1348079277: goto L20;
                case -1199239190: goto L16;
                case -39160206: goto Lc;
                default: goto Lb;
            }
        Lb:
            goto L34
        Lc:
            java.lang.String r0 = "getCurrentPage"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L34
            r6 = 2
            goto L35
        L16:
            java.lang.String r0 = "unregisterAppLifeCycleCallback"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L34
            r6 = 3
            goto L35
        L20:
            java.lang.String r0 = "getCurrentAppState"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L34
            r6 = 1
            goto L35
        L2a:
            java.lang.String r0 = "registerAppLifeCycleCallback"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L34
            r6 = 0
            goto L35
        L34:
            r6 = -1
        L35:
            if (r6 == 0) goto L3f
            if (r6 == r4) goto L3f
            if (r6 == r3) goto L3f
            if (r6 == r2) goto L3e
            return r1
        L3e:
            return r4
        L3f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.a.b.h(java.lang.String):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r6, java.lang.String r7, java.lang.Object[] r8) {
        /*
            r5 = this;
            com.kwad.tachikoma.a.a r6 = (com.kwad.tachikoma.a.a) r6
            int r0 = r7.hashCode()
            r1 = 3
            r2 = 2
            r3 = 1
            r4 = 0
            switch(r0) {
                case -1455001391: goto L2c;
                case -1348079277: goto L22;
                case -1199239190: goto L18;
                case -39160206: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L36
        Le:
            java.lang.String r0 = "getCurrentPage"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L36
            r0 = 3
            goto L37
        L18:
            java.lang.String r0 = "unregisterAppLifeCycleCallback"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L36
            r0 = 2
            goto L37
        L22:
            java.lang.String r0 = "getCurrentAppState"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L36
            r0 = 1
            goto L37
        L2c:
            java.lang.String r0 = "registerAppLifeCycleCallback"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L36
            r0 = 0
            goto L37
        L36:
            r0 = -1
        L37:
            if (r0 == 0) goto L76
            if (r0 == r3) goto L6d
            r3 = 0
            if (r0 == r2) goto L5f
            if (r0 == r1) goto L5a
            boolean r6 = com.tk.core.o.t.isDebug()
            if (r6 == 0) goto L59
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "can't find method ---> "
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "TKApp"
            android.util.Log.e(r7, r6)
        L59:
            return r3
        L5a:
            java.lang.Object r6 = r6.hY()
            return r6
        L5f:
            java.lang.Object r7 = com.tk.core.o.a.c(r8, r4)
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = com.tk.core.manager.a.f.h(r7)
            r6.bP(r7)
            return r3
        L6d:
            int r6 = com.kwad.tachikoma.a.a.hZ()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            return r6
        L76:
            java.lang.Object r7 = com.tk.core.o.a.b(r8, r4)
            com.tkruntime.v8.V8Function r7 = (com.tkruntime.v8.V8Function) r7
            int r6 = r6.e(r7)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.a.b.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
