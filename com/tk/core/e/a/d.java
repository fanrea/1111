package com.tk.core.e.a;

import android.util.Log;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.manager.a.f;
import com.tk.core.o.t;
import com.tkruntime.v8.utils.V8ObjectUtilsQuick;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d implements com.tk.core.manager.a.a<c>, com.tk.core.manager.a.c {
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
            return "eventState";
        }
        if (i == 1) {
            return "data";
        }
        if (i == 2) {
            return "type";
        }
        if (i != 3) {
            return null;
        }
        return "motionType";
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
        return "2#eventState#0,2#data#1,2#type#2,2#motionType#3,";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "1";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ c b(NativeModuleInitParams nativeModuleInitParams) {
        return rD();
    }

    private static c rD() {
        return new c();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean g(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = 0
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case -720898032: goto L2a;
                case 3076010: goto L20;
                case 3575610: goto L16;
                case 973271575: goto Lc;
                default: goto Lb;
            }
        Lb:
            goto L34
        Lc:
            java.lang.String r0 = "eventState"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L34
            r6 = 0
            goto L35
        L16:
            java.lang.String r0 = "type"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L34
            r6 = 2
            goto L35
        L20:
            java.lang.String r0 = "data"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L34
            r6 = 1
            goto L35
        L2a:
            java.lang.String r0 = "motionType"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L34
            r6 = 3
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
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.e.a.d.g(java.lang.String):boolean");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        c cVar = (c) obj;
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -720898032:
                    if (str.equals("motionType")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3076010:
                    if (str.equals("data")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3575610:
                    if (str.equals("type")) {
                        c = 2;
                        break;
                    }
                    break;
                case 973271575:
                    if (str.equals("eventState")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                cVar.setState(f.h((Number) obj2));
            } else if (c == 1) {
                cVar.n((HashMap) V8ObjectUtilsQuick.getValue(obj2));
            } else if (c == 2) {
                cVar.bX((String) obj2);
            } else if (c == 3) {
                cVar.setState(f.h((Number) obj2));
            } else {
                if (!t.isDebug()) {
                    return false;
                }
                Log.e("TKBaseEvent", "call applyProp() with unsupported prop: " + str);
                return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("TKBaseEvent apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r5, java.lang.String r6) {
        /*
            r4 = this;
            com.tk.core.e.a.c r5 = (com.tk.core.e.a.c) r5
            int r0 = r6.hashCode()
            r1 = 3
            r2 = 2
            r3 = 1
            switch(r0) {
                case -720898032: goto L2b;
                case 3076010: goto L21;
                case 3575610: goto L17;
                case 973271575: goto Ld;
                default: goto Lc;
            }
        Lc:
            goto L35
        Ld:
            java.lang.String r0 = "eventState"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L35
            r0 = 0
            goto L36
        L17:
            java.lang.String r0 = "type"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L35
            r0 = 2
            goto L36
        L21:
            java.lang.String r0 = "data"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L35
            r0 = 1
            goto L36
        L2b:
            java.lang.String r0 = "motionType"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L35
            r0 = 3
            goto L36
        L35:
            r0 = -1
        L36:
            if (r0 == 0) goto L66
            if (r0 == r3) goto L63
            if (r0 == r2) goto L60
            if (r0 == r1) goto L59
            boolean r5 = com.tk.core.o.t.isDebug()
            if (r5 == 0) goto L57
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r0 = "call getProp() with unsupported prop: "
            r5.<init>(r0)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "TKBaseEvent"
            android.util.Log.e(r6, r5)
        L57:
            r5 = 0
            return r5
        L59:
            int r5 = r5.state
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            return r5
        L60:
            java.lang.String r5 = r5.type
            return r5
        L63:
            java.util.HashMap<java.lang.String, java.lang.Object> r5 = r5.ahP
            return r5
        L66:
            int r5 = r5.ahQ
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.e.a.d.a(java.lang.Object, java.lang.String):java.lang.Object");
    }

    @Override // com.tk.core.manager.a.c
    public final Map<String, Object> I(Object obj) {
        HashMap map = new HashMap();
        c cVar = (c) obj;
        map.put("eventState", Integer.valueOf(cVar.ahQ));
        map.put("data", cVar.ahP);
        map.put("type", cVar.type);
        map.put("motionType", Integer.valueOf(cVar.state));
        return map;
    }
}
