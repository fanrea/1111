package com.tk.core.e.c;

import android.util.Log;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.manager.a.f;
import com.tk.core.o.t;
import com.tkruntime.v8.utils.V8ObjectUtilsQuick;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b implements com.tk.core.manager.a.a<a>, com.tk.core.manager.a.c {
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
            return "motionType";
        }
        if (i == 1) {
            return "state";
        }
        if (i == 2) {
            return "data";
        }
        if (i == 3) {
            return "text";
        }
        if (i == 4) {
            return "type";
        }
        if (i != 5) {
            return null;
        }
        return "eventState";
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
        return "2#motionType#0,2#state#1,2#data#2,2#text#3,2#type#4,2#eventState#5,";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "1";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ a b(NativeModuleInitParams nativeModuleInitParams) {
        return rL();
    }

    private static a rL() {
        return new a();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean g(java.lang.String r8) {
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
                case -720898032: goto L40;
                case 3076010: goto L36;
                case 3556653: goto L2c;
                case 3575610: goto L22;
                case 109757585: goto L18;
                case 973271575: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L4a
        Le:
            java.lang.String r0 = "eventState"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 5
            goto L4b
        L18:
            java.lang.String r0 = "state"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 1
            goto L4b
        L22:
            java.lang.String r0 = "type"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 4
            goto L4b
        L2c:
            java.lang.String r0 = "text"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 3
            goto L4b
        L36:
            java.lang.String r0 = "data"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 2
            goto L4b
        L40:
            java.lang.String r0 = "motionType"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 0
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
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.e.c.b.g(java.lang.String):boolean");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        a aVar = (a) obj;
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -720898032:
                    if (str.equals("motionType")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3076010:
                    if (str.equals("data")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3556653:
                    if (str.equals("text")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3575610:
                    if (str.equals("type")) {
                        c = 4;
                        break;
                    }
                    break;
                case 109757585:
                    if (str.equals("state")) {
                        c = 1;
                        break;
                    }
                    break;
                case 973271575:
                    if (str.equals("eventState")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            if (c == 0 || c == 1) {
                aVar.setState(f.h((Number) obj2));
            } else if (c == 2) {
                aVar.n((HashMap) V8ObjectUtilsQuick.getValue(obj2));
            } else if (c == 3) {
                aVar.setText((String) obj2);
            } else if (c == 4) {
                aVar.bX((String) obj2);
            } else if (c == 5) {
                aVar.setState(f.h((Number) obj2));
            } else {
                if (!t.isDebug()) {
                    return false;
                }
                Log.e("TKInputEvent", "call applyProp() with unsupported prop: " + str);
                return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("TKInputEvent apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004b  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r7, java.lang.String r8) {
        /*
            r6 = this;
            com.tk.core.e.c.a r7 = (com.tk.core.e.c.a) r7
            int r0 = r8.hashCode()
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r0) {
                case -720898032: goto L41;
                case 3076010: goto L37;
                case 3556653: goto L2d;
                case 3575610: goto L23;
                case 109757585: goto L19;
                case 973271575: goto Lf;
                default: goto Le;
            }
        Le:
            goto L4b
        Lf:
            java.lang.String r0 = "eventState"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L4b
            r0 = 5
            goto L4c
        L19:
            java.lang.String r0 = "state"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L4b
            r0 = 1
            goto L4c
        L23:
            java.lang.String r0 = "type"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L4b
            r0 = 4
            goto L4c
        L2d:
            java.lang.String r0 = "text"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L4b
            r0 = 3
            goto L4c
        L37:
            java.lang.String r0 = "data"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L4b
            r0 = 2
            goto L4c
        L41:
            java.lang.String r0 = "motionType"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L4b
            r0 = 0
            goto L4c
        L4b:
            r0 = -1
        L4c:
            if (r0 == 0) goto L8a
            if (r0 == r5) goto L83
            if (r0 == r4) goto L80
            if (r0 == r3) goto L7d
            if (r0 == r2) goto L7a
            if (r0 == r1) goto L73
            boolean r7 = com.tk.core.o.t.isDebug()
            if (r7 == 0) goto L71
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "call getProp() with unsupported prop: "
            r7.<init>(r0)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "TKInputEvent"
            android.util.Log.e(r8, r7)
        L71:
            r7 = 0
            return r7
        L73:
            int r7 = r7.ahQ
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            return r7
        L7a:
            java.lang.String r7 = r7.type
            return r7
        L7d:
            java.lang.String r7 = r7.KE
            return r7
        L80:
            java.util.HashMap<java.lang.String, java.lang.Object> r7 = r7.ahP
            return r7
        L83:
            int r7 = r7.ahU
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            return r7
        L8a:
            int r7 = r7.state
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.e.c.b.a(java.lang.Object, java.lang.String):java.lang.Object");
    }

    @Override // com.tk.core.manager.a.c
    public final Map<String, Object> I(Object obj) {
        HashMap map = new HashMap();
        a aVar = (a) obj;
        map.put("motionType", Integer.valueOf(aVar.state));
        map.put("state", Integer.valueOf(aVar.ahU));
        map.put("data", aVar.ahP);
        map.put("text", aVar.KE);
        map.put("type", aVar.type);
        map.put("eventState", Integer.valueOf(aVar.ahQ));
        return map;
    }
}
