package com.tk.core.g;

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
            return "removeListener";
        }
        if (i == 1) {
            return "removeAllListeners";
        }
        if (i == 2) {
            return "addListener";
        }
        if (i != 3) {
            return null;
        }
        return "dismiss";
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
        return "4#removeListener#0,4#removeAllListeners#1,4#addListener#2,4#dismiss#3";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ a b(NativeModuleInitParams nativeModuleInitParams) {
        return au(nativeModuleInitParams);
    }

    private static a au(NativeModuleInitParams nativeModuleInitParams) {
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
                case -1786354622: goto L2a;
                case -248292008: goto L20;
                case 371880053: goto L16;
                case 1671672458: goto Lc;
                default: goto Lb;
            }
        Lb:
            goto L34
        Lc:
            java.lang.String r0 = "dismiss"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L34
            r6 = 3
            goto L35
        L16:
            java.lang.String r0 = "addListener"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L34
            r6 = 2
            goto L35
        L20:
            java.lang.String r0 = "removeListener"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L34
            r6 = 0
            goto L35
        L2a:
            java.lang.String r0 = "removeAllListeners"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L34
            r6 = 1
            goto L35
        L34:
            r6 = -1
        L35:
            if (r6 == 0) goto L3e
            if (r6 == r4) goto L3e
            if (r6 == r3) goto L3e
            if (r6 == r2) goto L3e
            return r1
        L3e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.g.b.h(java.lang.String):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r7, java.lang.String r8, java.lang.Object[] r9) {
        /*
            r6 = this;
            com.tk.core.g.a r7 = (com.tk.core.g.a) r7
            int r0 = r8.hashCode()
            r1 = 3
            r2 = 2
            r3 = 0
            r4 = 1
            switch(r0) {
                case -1786354622: goto L2c;
                case -248292008: goto L22;
                case 371880053: goto L18;
                case 1671672458: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L36
        Le:
            java.lang.String r0 = "dismiss"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L36
            r0 = 3
            goto L37
        L18:
            java.lang.String r0 = "addListener"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L36
            r0 = 2
            goto L37
        L22:
            java.lang.String r0 = "removeListener"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L36
            r0 = 0
            goto L37
        L2c:
            java.lang.String r0 = "removeAllListeners"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L36
            r0 = 1
            goto L37
        L36:
            r0 = -1
        L37:
            r5 = 0
            if (r0 == 0) goto L78
            if (r0 == r4) goto L6e
            if (r0 == r2) goto L5e
            if (r0 == r1) goto L5a
            boolean r7 = com.tk.core.o.t.isDebug()
            if (r7 == 0) goto L59
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r9 = "can't find method ---> "
            r7.<init>(r9)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "Keyboard"
            android.util.Log.e(r8, r7)
        L59:
            return r5
        L5a:
            r7.dismiss()
            return r5
        L5e:
            java.lang.Object r8 = com.tk.core.o.a.b(r9, r3)
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = com.tk.core.o.a.b(r9, r4)
            com.tkruntime.v8.V8Function r9 = (com.tkruntime.v8.V8Function) r9
            r7.n(r8, r9)
            return r5
        L6e:
            java.lang.Object r8 = com.tk.core.o.a.b(r9, r3)
            java.lang.String r8 = (java.lang.String) r8
            r7.cA(r8)
            return r5
        L78:
            java.lang.Object r8 = com.tk.core.o.a.b(r9, r3)
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = com.tk.core.o.a.b(r9, r4)
            com.tkruntime.v8.V8Function r9 = (com.tkruntime.v8.V8Function) r9
            r7.o(r8, r9)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.g.b.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
