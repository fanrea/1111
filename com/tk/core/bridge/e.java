package com.tk.core.bridge;

import android.util.Log;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.o.t;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class e implements com.tk.core.manager.a.a<d> {
    @Override // com.tk.core.manager.a.a
    public final void a(Object obj, Map<String, Object> map) {
    }

    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        switch (i) {
            case 0:
                return "env";
            case 1:
                return "removeEventListener";
            case 2:
                return "registerViewFactory";
            case 3:
                return "registerView";
            case 4:
                return "render";
            case 5:
                return "isDark";
            case 6:
                return "getColorFromKSResource";
            case 7:
                return "viewToImage";
            case 8:
                return "getRootView";
            case 9:
                return "removeFile";
            case 10:
                return "dp2Px";
            case 11:
                return "getBundleInfo";
            case 12:
                return "px2Dp";
            case 13:
                return "addEventListener";
            case 14:
                return "reload";
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
        return "2#env#0,4#removeEventListener#1,4#registerViewFactory#2,4#registerView#3,4#render#4,8#isDark#5,8#getColorFromKSResource#6,4#viewToImage#7,8#getRootView#8,4#removeFile#9,8#dp2Px#10,8#getBundleInfo#11,8#px2Dp#12,4#addEventListener#13,4#reload#14";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ d b(NativeModuleInitParams nativeModuleInitParams) {
        return ae(nativeModuleInitParams);
    }

    private static d ae(NativeModuleInitParams nativeModuleInitParams) {
        return new d(nativeModuleInitParams);
    }

    @Override // com.tk.core.manager.a.a
    public final boolean g(String str) {
        return ((str.hashCode() == 100589 && str.equals("env")) ? (char) 0 : (char) 65535) == 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a2  */
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
                case -1707682840: goto L97;
                case -1184724677: goto L8c;
                case -1180578880: goto L82;
                case -934641255: goto L77;
                case -934592106: goto L6c;
                case -625809843: goto L61;
                case -541487286: goto L57;
                case 95739342: goto L4d;
                case 107059542: goto L43;
                case 1032979405: goto L39;
                case 1079160902: goto L2e;
                case 1098154016: goto L22;
                case 1911106589: goto L17;
                case 2067415042: goto Lc;
                default: goto La;
            }
        La:
            goto La2
        Lc:
            java.lang.String r0 = "registerViewFactory"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto La2
            r5 = 7
            goto La3
        L17:
            java.lang.String r0 = "getRootView"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto La2
            r5 = 2
            goto La3
        L22:
            java.lang.String r0 = "removeFile"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto La2
            r5 = 11
            goto La3
        L2e:
            java.lang.String r0 = "getBundleInfo"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto La2
            r5 = 4
            goto La3
        L39:
            java.lang.String r0 = "getColorFromKSResource"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto La2
            r5 = 1
            goto La3
        L43:
            java.lang.String r0 = "px2Dp"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto La2
            r5 = 5
            goto La3
        L4d:
            java.lang.String r0 = "dp2Px"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto La2
            r5 = 3
            goto La3
        L57:
            java.lang.String r0 = "removeEventListener"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto La2
            r5 = 6
            goto La3
        L61:
            java.lang.String r0 = "addEventListener"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto La2
            r5 = 12
            goto La3
        L6c:
            java.lang.String r0 = "render"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto La2
            r5 = 9
            goto La3
        L77:
            java.lang.String r0 = "reload"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto La2
            r5 = 13
            goto La3
        L82:
            java.lang.String r0 = "isDark"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto La2
            r5 = 0
            goto La3
        L8c:
            java.lang.String r0 = "viewToImage"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto La2
            r5 = 10
            goto La3
        L97:
            java.lang.String r0 = "registerView"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto La2
            r5 = 8
            goto La3
        La2:
            r5 = -1
        La3:
            switch(r5) {
                case 0: goto La8;
                case 1: goto La8;
                case 2: goto La8;
                case 3: goto La8;
                case 4: goto La8;
                case 5: goto La8;
                case 6: goto La7;
                case 7: goto La7;
                case 8: goto La7;
                case 9: goto La7;
                case 10: goto La7;
                case 11: goto La7;
                case 12: goto La7;
                case 13: goto La7;
                default: goto La6;
            }
        La6:
            return r3
        La7:
            return r1
        La8:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.bridge.e.h(java.lang.String):int");
    }

    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        try {
            str.hashCode();
            if (!t.isDebug()) {
                return false;
            }
            Log.e("TachikomaGlobalObject", "call applyProp() with unsupported prop: " + str);
            return false;
        } catch (Exception e) {
            throw new RuntimeException("TachikomaGlobalObject apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + b.z(obj2), e);
        }
    }

    @Override // com.tk.core.manager.a.a
    public final Object a(Object obj, String str) {
        d dVar = (d) obj;
        if (((str.hashCode() == 100589 && str.equals("env")) ? (char) 0 : (char) 65535) == 0) {
            return dVar.pC();
        }
        if (!t.isDebug()) {
            return null;
        }
        Log.e("TachikomaGlobalObject", "call getProp() with unsupported prop: " + str);
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a3  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r5, java.lang.String r6, java.lang.Object[] r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 462
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.bridge.e.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
