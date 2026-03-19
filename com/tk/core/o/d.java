package com.tk.core.o;

import com.baidu.mobstat.forbes.Config;
import com.kuaishou.tk.export.NativeModuleInitParams;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d implements com.tk.core.manager.a.a<c> {
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
            return Config.TRACE_PART;
        }
        if (i == 1) {
            return "debug";
        }
        if (i == 2) {
            return "warn";
        }
        if (i == 3) {
            return "error";
        }
        if (i == 4) {
            return Config.LAUNCH_INFO;
        }
        if (i != 5) {
            return null;
        }
        return com.baidu.mobads.container.components.j.a.b;
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
        return "4#trace#0,4#debug#1,4#warn#2,4#error#3,4#info#4,4#log#5";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ c b(NativeModuleInitParams nativeModuleInitParams) {
        return ay(nativeModuleInitParams);
    }

    private static c ay(NativeModuleInitParams nativeModuleInitParams) {
        return new c(nativeModuleInitParams);
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
                case 107332: goto L40;
                case 3237038: goto L36;
                case 3641990: goto L2c;
                case 95458899: goto L22;
                case 96784904: goto L18;
                case 110620997: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L4a
        Le:
            java.lang.String r0 = "trace"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 0
            goto L4b
        L18:
            java.lang.String r0 = "error"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 3
            goto L4b
        L22:
            java.lang.String r0 = "debug"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 1
            goto L4b
        L2c:
            java.lang.String r0 = "warn"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 2
            goto L4b
        L36:
            java.lang.String r0 = "info"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 4
            goto L4b
        L40:
            java.lang.String r0 = "log"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 5
            goto L4b
        L4a:
            r8 = -1
        L4b:
            if (r8 == 0) goto L58
            if (r8 == r6) goto L58
            if (r8 == r5) goto L58
            if (r8 == r4) goto L58
            if (r8 == r3) goto L58
            if (r8 == r2) goto L58
            return r1
        L58:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.o.d.h(java.lang.String):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004b  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r8, java.lang.String r9, java.lang.Object[] r10) {
        /*
            r7 = this;
            com.tk.core.o.c r8 = (com.tk.core.o.c) r8
            int r0 = r9.hashCode()
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r0) {
                case 107332: goto L41;
                case 3237038: goto L37;
                case 3641990: goto L2d;
                case 95458899: goto L23;
                case 96784904: goto L19;
                case 110620997: goto Lf;
                default: goto Le;
            }
        Le:
            goto L4b
        Lf:
            java.lang.String r0 = "trace"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L4b
            r0 = 0
            goto L4c
        L19:
            java.lang.String r0 = "error"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L4b
            r0 = 3
            goto L4c
        L23:
            java.lang.String r0 = "debug"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L4b
            r0 = 1
            goto L4c
        L2d:
            java.lang.String r0 = "warn"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L4b
            r0 = 2
            goto L4c
        L37:
            java.lang.String r0 = "info"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L4b
            r0 = 4
            goto L4c
        L41:
            java.lang.String r0 = "log"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L4b
            r0 = 5
            goto L4c
        L4b:
            r0 = -1
        L4c:
            r6 = 0
            if (r0 == 0) goto L87
            if (r0 == r5) goto L83
            if (r0 == r4) goto L7f
            if (r0 == r3) goto L7b
            if (r0 == r2) goto L77
            if (r0 == r1) goto L73
            boolean r8 = com.tk.core.o.t.isDebug()
            if (r8 == 0) goto L72
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r10 = "can't find method ---> "
            r8.<init>(r10)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.String r9 = "Console"
            android.util.Log.e(r9, r8)
        L72:
            return r6
        L73:
            r8.c(r10)
            return r6
        L77:
            r8.d(r10)
            return r6
        L7b:
            r8.h(r10)
            return r6
        L7f:
            r8.e(r10)
            return r6
        L83:
            r8.f(r10)
            return r6
        L87:
            r8.g(r10)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.o.d.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
