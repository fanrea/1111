package com.tk.core.b;

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
            return "exist";
        }
        if (i == 1) {
            return "remove";
        }
        if (i == 2) {
            return "set";
        }
        if (i == 3) {
            return "get";
        }
        if (i == 4) {
            return "getAsync";
        }
        if (i != 5) {
            return null;
        }
        return "existAsync";
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
        return "8#exist#0,4#remove#1,4#set#2,8#get#3,4#getAsync#4,4#existAsync#5";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ a b(NativeModuleInitParams nativeModuleInitParams) {
        return af(nativeModuleInitParams);
    }

    private static a af(NativeModuleInitParams nativeModuleInitParams) {
        return new a(nativeModuleInitParams);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int h(java.lang.String r8) {
        /*
            r7 = this;
            int r0 = r8.hashCode()
            r1 = 0
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r0) {
                case -934610812: goto L40;
                case 102230: goto L36;
                case 113762: goto L2c;
                case 96955127: goto L22;
                case 160557509: goto L18;
                case 1948952774: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L4a
        Le:
            java.lang.String r0 = "getAsync"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 4
            goto L4b
        L18:
            java.lang.String r0 = "existAsync"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 5
            goto L4b
        L22:
            java.lang.String r0 = "exist"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 0
            goto L4b
        L2c:
            java.lang.String r0 = "set"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 3
            goto L4b
        L36:
            java.lang.String r0 = "get"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 1
            goto L4b
        L40:
            java.lang.String r0 = "remove"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 2
            goto L4b
        L4a:
            r8 = -1
        L4b:
            if (r8 == 0) goto L59
            if (r8 == r6) goto L59
            if (r8 == r5) goto L58
            if (r8 == r4) goto L58
            if (r8 == r3) goto L58
            if (r8 == r2) goto L58
            return r1
        L58:
            return r6
        L59:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.b.b.h(java.lang.String):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r9, java.lang.String r10, java.lang.Object[] r11) {
        /*
            r8 = this;
            com.tk.core.b.a r9 = (com.tk.core.b.a) r9
            int r0 = r10.hashCode()
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            switch(r0) {
                case -934610812: goto L42;
                case 102230: goto L38;
                case 113762: goto L2e;
                case 96955127: goto L24;
                case 160557509: goto L1a;
                case 1948952774: goto L10;
                default: goto Lf;
            }
        Lf:
            goto L4c
        L10:
            java.lang.String r0 = "getAsync"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L4c
            r0 = 4
            goto L4d
        L1a:
            java.lang.String r0 = "existAsync"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L4c
            r0 = 5
            goto L4d
        L24:
            java.lang.String r0 = "exist"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L4c
            r0 = 0
            goto L4d
        L2e:
            java.lang.String r0 = "set"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L4c
            r0 = 2
            goto L4d
        L38:
            java.lang.String r0 = "get"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L4c
            r0 = 3
            goto L4d
        L42:
            java.lang.String r0 = "remove"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L4c
            r0 = 1
            goto L4d
        L4c:
            r0 = -1
        L4d:
            if (r0 == 0) goto Lb7
            r7 = 0
            if (r0 == r5) goto Lad
            if (r0 == r4) goto L9f
            if (r0 == r3) goto L94
            if (r0 == r2) goto L84
            if (r0 == r1) goto L74
            boolean r9 = com.tk.core.o.t.isDebug()
            if (r9 == 0) goto L73
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r11 = "can't find method ---> "
            r9.<init>(r11)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.String r10 = "TKLocalStorage"
            android.util.Log.e(r10, r9)
        L73:
            return r7
        L74:
            java.lang.Object r10 = com.tk.core.o.a.b(r11, r6)
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = com.tk.core.o.a.b(r11, r5)
            com.tkruntime.v8.V8Function r11 = (com.tkruntime.v8.V8Function) r11
            r9.l(r10, r11)
            return r7
        L84:
            java.lang.Object r10 = com.tk.core.o.a.b(r11, r6)
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = com.tk.core.o.a.b(r11, r5)
            com.tkruntime.v8.V8Function r11 = (com.tkruntime.v8.V8Function) r11
            r9.k(r10, r11)
            return r7
        L94:
            java.lang.Object r9 = com.tk.core.o.a.b(r11, r6)
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r9 = com.tk.core.b.a.get(r9)
            return r9
        L9f:
            java.lang.Object r9 = com.tk.core.o.a.b(r11, r6)
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = com.tk.core.o.a.b(r11, r5)
            com.tk.core.b.a.set(r9, r10)
            return r7
        Lad:
            java.lang.Object r9 = com.tk.core.o.a.b(r11, r6)
            java.lang.String r9 = (java.lang.String) r9
            com.tk.core.b.a.remove(r9)
            return r7
        Lb7:
            java.lang.Object r9 = com.tk.core.o.a.b(r11, r6)
            java.lang.String r9 = (java.lang.String) r9
            boolean r9 = com.tk.core.b.a.exist(r9)
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.b.b.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
