package com.tk.component.d;

import android.util.Log;
import com.alipay.sdk.m.p.e;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.manager.a.f;
import com.tk.core.o.t;
import com.tkruntime.v8.utils.V8ObjectUtilsQuick;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b implements com.tk.core.manager.a.a<a> {
    @Override // com.tk.core.manager.a.a
    public final void a(Object obj, Map<String, Object> map) {
    }

    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        switch (i) {
            case 0:
                return "params";
            case 1:
                return "isAddCommonParameters";
            case 2:
                return "url";
            case 3:
                return "parts";
            case 4:
                return "businessName";
            case 5:
                return e.s;
            case 6:
                return "headers";
            case 7:
                return "isAddExtraParameters";
            case 8:
                return "fileKey";
            case 9:
                return "upload";
            case 10:
                return "timeout";
            case 11:
                return "localFilePath";
            case 12:
                return "paramString";
            case 13:
                return "sourceRequest";
            case 14:
                return "cancel";
            case 15:
                return "request";
            default:
                return null;
        }
    }

    @Override // com.tk.core.manager.a.a
    public final boolean f(String str) {
        return false;
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "2#params#0,2#isAddCommonParameters#1,2#url#2,2#parts#3,2#businessName#4,2#method#5,2#headers#6,2#isAddExtraParameters#7,2#fileKey#8,2#upload#9,2#timeout#10,2#localFilePath#11,2#paramString#12,8#sourceRequest#13,4#cancel#14,8#request#15";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "1";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ a b(NativeModuleInitParams nativeModuleInitParams) {
        return Z(nativeModuleInitParams);
    }

    private static a Z(NativeModuleInitParams nativeModuleInitParams) {
        return new a(nativeModuleInitParams);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0095  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean g(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case -2102347261: goto L8b;
                case -1313911455: goto L80;
                case -1077554975: goto L76;
                case -995427962: goto L6c;
                case -855019709: goto L61;
                case -838595071: goto L56;
                case -672936341: goto L4c;
                case 116079: goto L42;
                case 106437344: goto L38;
                case 795307910: goto L2e;
                case 820971262: goto L22;
                case 1460125548: goto L17;
                case 2121422924: goto Lb;
                default: goto L9;
            }
        L9:
            goto L95
        Lb:
            java.lang.String r0 = "localFilePath"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L95
            r4 = 11
            goto L96
        L17:
            java.lang.String r0 = "isAddCommonParameters"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L95
            r4 = 1
            goto L96
        L22:
            java.lang.String r0 = "paramString"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L95
            r4 = 12
            goto L96
        L2e:
            java.lang.String r0 = "headers"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L95
            r4 = 6
            goto L96
        L38:
            java.lang.String r0 = "parts"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L95
            r4 = 3
            goto L96
        L42:
            java.lang.String r0 = "url"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L95
            r4 = 2
            goto L96
        L4c:
            java.lang.String r0 = "businessName"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L95
            r4 = 4
            goto L96
        L56:
            java.lang.String r0 = "upload"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L95
            r4 = 9
            goto L96
        L61:
            java.lang.String r0 = "fileKey"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L95
            r4 = 8
            goto L96
        L6c:
            java.lang.String r0 = "params"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L95
            r4 = 0
            goto L96
        L76:
            java.lang.String r0 = "method"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L95
            r4 = 5
            goto L96
        L80:
            java.lang.String r0 = "timeout"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L95
            r4 = 10
            goto L96
        L8b:
            java.lang.String r0 = "isAddExtraParameters"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L95
            r4 = 7
            goto L96
        L95:
            r4 = -1
        L96:
            switch(r4) {
                case 0: goto L9a;
                case 1: goto L9a;
                case 2: goto L9a;
                case 3: goto L9a;
                case 4: goto L9a;
                case 5: goto L9a;
                case 6: goto L9a;
                case 7: goto L9a;
                case 8: goto L9a;
                case 9: goto L9a;
                case 10: goto L9a;
                case 11: goto L9a;
                case 12: goto L9a;
                default: goto L99;
            }
        L99:
            return r2
        L9a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.d.b.g(java.lang.String):boolean");
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
            r1 = -1367724422(0xffffffffae7a2e7a, float:-5.68847E-11)
            r2 = 0
            r3 = 2
            r4 = 1
            if (r0 == r1) goto L2b
            r1 = 1095692943(0x414ef28f, float:12.934218)
            if (r0 == r1) goto L21
            r1 = 1190256116(0x46f1ddf4, float:30958.977)
            if (r0 == r1) goto L17
            goto L35
        L17:
            java.lang.String r0 = "sourceRequest"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L35
            r6 = 0
            goto L36
        L21:
            java.lang.String r0 = "request"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L35
            r6 = 1
            goto L36
        L2b:
            java.lang.String r0 = "cancel"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L35
            r6 = 2
            goto L36
        L35:
            r6 = -1
        L36:
            if (r6 == 0) goto L3e
            if (r6 == r4) goto L3e
            if (r6 == r3) goto L3d
            return r2
        L3d:
            return r4
        L3e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.d.b.h(java.lang.String):int");
    }

    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        a aVar = (a) obj;
        try {
            switch (str) {
                case "params":
                    aVar.b((Map<String, Object>) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "isAddCommonParameters":
                    aVar.ce(f.h((Number) obj2));
                    break;
                case "url":
                    aVar.setUrl((String) obj2);
                    break;
                case "parts":
                    aVar.e((Map) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "businessName":
                    aVar.setBusinessName((String) obj2);
                    break;
                case "method":
                    aVar.setMethod((String) obj2);
                    break;
                case "headers":
                    aVar.c((Map<String, String>) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "isAddExtraParameters":
                    aVar.Uk = f.h((Number) obj2);
                    break;
                case "fileKey":
                    aVar.aU((String) obj2);
                    break;
                case "upload":
                    aVar.ae(((Boolean) obj2).booleanValue());
                    break;
                case "timeout":
                    aVar.setTimeout(f.h((Number) obj2));
                    break;
                case "localFilePath":
                    aVar.aT((String) obj2);
                    break;
                case "paramString":
                    aVar.v((String) obj2);
                    break;
                default:
                    if (!t.isDebug()) {
                        return false;
                    }
                    Log.e("TKNetwork", "call applyProp() with unsupported prop: " + str);
                    return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("TKNetwork apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0095  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r2, java.lang.String r3) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.d.b.a(java.lang.Object, java.lang.String):java.lang.Object");
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
            com.tk.component.d.a r6 = (com.tk.component.d.a) r6
            int r0 = r7.hashCode()
            r1 = -1367724422(0xffffffffae7a2e7a, float:-5.68847E-11)
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 == r1) goto L2d
            r1 = 1095692943(0x414ef28f, float:12.934218)
            if (r0 == r1) goto L23
            r1 = 1190256116(0x46f1ddf4, float:30958.977)
            if (r0 == r1) goto L19
            goto L37
        L19:
            java.lang.String r0 = "sourceRequest"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L37
            r0 = 0
            goto L38
        L23:
            java.lang.String r0 = "request"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L37
            r0 = 2
            goto L38
        L2d:
            java.lang.String r0 = "cancel"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L37
            r0 = 1
            goto L38
        L37:
            r0 = -1
        L38:
            if (r0 == 0) goto L68
            r1 = 0
            if (r0 == r3) goto L64
            if (r0 == r2) goto L59
            boolean r6 = com.tk.core.o.t.isDebug()
            if (r6 == 0) goto L58
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "can't find method ---> "
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "TKNetwork"
            android.util.Log.e(r7, r6)
        L58:
            return r1
        L59:
            java.lang.Object r7 = com.tk.core.o.a.b(r8, r4)
            com.tkruntime.v8.V8Function r7 = (com.tkruntime.v8.V8Function) r7
            java.lang.Object r6 = r6.ar(r7)
            return r6
        L64:
            r6.cancel()
            return r1
        L68:
            java.lang.Object r7 = com.tk.core.o.a.b(r8, r4)
            com.tkruntime.v8.V8Function r7 = (com.tkruntime.v8.V8Function) r7
            java.lang.Object r6 = r6.as(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.d.b.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
