package com.tk.core.e.b;

import android.util.Log;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.o.t;
import com.tkruntime.v8.utils.V8ObjectUtilsQuick;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class k implements com.tk.core.manager.a.a<j>, com.tk.core.manager.a.c {
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
            return "data";
        }
        if (i == 1) {
            return "motionType";
        }
        if (i == 2) {
            return "type";
        }
        if (i == 3) {
            return "eventState";
        }
        if (i != 4) {
            return null;
        }
        return "direction";
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
        return "2#data#0,2#motionType#1,2#type#2,2#eventState#3,2#direction#4,";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "1";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ j b(NativeModuleInitParams nativeModuleInitParams) {
        return rI();
    }

    private static j rI() {
        return new j();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean g(java.lang.String r7) {
        /*
            r6 = this;
            int r0 = r7.hashCode()
            r1 = 0
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r0) {
                case -962590849: goto L35;
                case -720898032: goto L2b;
                case 3076010: goto L21;
                case 3575610: goto L17;
                case 973271575: goto Ld;
                default: goto Lc;
            }
        Lc:
            goto L3f
        Ld:
            java.lang.String r0 = "eventState"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L3f
            r7 = 3
            goto L40
        L17:
            java.lang.String r0 = "type"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L3f
            r7 = 2
            goto L40
        L21:
            java.lang.String r0 = "data"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L3f
            r7 = 0
            goto L40
        L2b:
            java.lang.String r0 = "motionType"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L3f
            r7 = 1
            goto L40
        L35:
            java.lang.String r0 = "direction"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L3f
            r7 = 4
            goto L40
        L3f:
            r7 = -1
        L40:
            if (r7 == 0) goto L4b
            if (r7 == r5) goto L4b
            if (r7 == r4) goto L4b
            if (r7 == r3) goto L4b
            if (r7 == r2) goto L4b
            return r1
        L4b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.e.b.k.g(java.lang.String):boolean");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        j jVar = (j) obj;
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -962590849:
                    if (str.equals("direction")) {
                        c = 4;
                        break;
                    }
                    break;
                case -720898032:
                    if (str.equals("motionType")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3076010:
                    if (str.equals("data")) {
                        c = 0;
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
                        c = 3;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                jVar.n((HashMap) V8ObjectUtilsQuick.getValue(obj2));
            } else if (c == 1) {
                jVar.setState(com.tk.core.manager.a.f.h((Number) obj2));
            } else if (c == 2) {
                jVar.bX((String) obj2);
            } else if (c == 3) {
                jVar.setState(com.tk.core.manager.a.f.h((Number) obj2));
            } else if (c == 4) {
                jVar.cy((String) obj2);
            } else {
                if (!t.isDebug()) {
                    return false;
                }
                Log.e("TKSwipeEvent", "call applyProp() with unsupported prop: " + str);
                return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("TKSwipeEvent apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r6, java.lang.String r7) {
        /*
            r5 = this;
            com.tk.core.e.b.j r6 = (com.tk.core.e.b.j) r6
            int r0 = r7.hashCode()
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case -962590849: goto L36;
                case -720898032: goto L2c;
                case 3076010: goto L22;
                case 3575610: goto L18;
                case 973271575: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L40
        Le:
            java.lang.String r0 = "eventState"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L40
            r0 = 3
            goto L41
        L18:
            java.lang.String r0 = "type"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L40
            r0 = 2
            goto L41
        L22:
            java.lang.String r0 = "data"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L40
            r0 = 0
            goto L41
        L2c:
            java.lang.String r0 = "motionType"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L40
            r0 = 1
            goto L41
        L36:
            java.lang.String r0 = "direction"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L40
            r0 = 4
            goto L41
        L40:
            r0 = -1
        L41:
            if (r0 == 0) goto L7a
            if (r0 == r4) goto L73
            if (r0 == r3) goto L70
            if (r0 == r2) goto L69
            if (r0 == r1) goto L66
            boolean r6 = com.tk.core.o.t.isDebug()
            if (r6 == 0) goto L64
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r0 = "call getProp() with unsupported prop: "
            r6.<init>(r0)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "TKSwipeEvent"
            android.util.Log.e(r7, r6)
        L64:
            r6 = 0
            return r6
        L66:
            java.lang.String r6 = r6.ahT
            return r6
        L69:
            int r6 = r6.ahQ
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            return r6
        L70:
            java.lang.String r6 = r6.type
            return r6
        L73:
            int r6 = r6.state
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            return r6
        L7a:
            java.util.HashMap<java.lang.String, java.lang.Object> r6 = r6.ahP
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.e.b.k.a(java.lang.Object, java.lang.String):java.lang.Object");
    }

    @Override // com.tk.core.manager.a.c
    public final Map<String, Object> I(Object obj) {
        HashMap map = new HashMap();
        j jVar = (j) obj;
        map.put("data", jVar.ahP);
        map.put("motionType", Integer.valueOf(jVar.state));
        map.put("type", jVar.type);
        map.put("eventState", Integer.valueOf(jVar.ahQ));
        map.put("direction", jVar.ahT);
        return map;
    }
}
