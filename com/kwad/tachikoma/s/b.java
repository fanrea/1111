package com.kwad.tachikoma.s;

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
        switch (i) {
            case 0:
                return "playSound";
            case 1:
                return "stopVibrate";
            case 2:
                return "getLongSystemProperty";
            case 3:
                return "stopSound";
            case 4:
                return "getSystemProperty";
            case 5:
                return "getBUILD";
            case 6:
                return "getSystemTimeInMs";
            case 7:
                return "getBoolSystemProperty";
            case 8:
                return "getIntSystemProperty";
            case 9:
                return "getCurrentOrientation";
            case 10:
                return "loadSound";
            case 11:
                return "startVibrate";
            case 12:
                return "registerDeviceOrientListener";
            case 13:
                return "unregisterDeviceOrientListener";
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
        return "8#playSound#0,4#stopVibrate#1,8#getLongSystemProperty#2,4#stopSound#3,8#getSystemProperty#4,8#getBUILD#5,8#getSystemTimeInMs#6,8#getBoolSystemProperty#7,8#getIntSystemProperty#8,8#getCurrentOrientation#9,4#loadSound#10,4#startVibrate#11,4#registerDeviceOrientListener#12,4#unregisterDeviceOrientListener#13";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ a b(NativeModuleInitParams nativeModuleInitParams) {
        return D(nativeModuleInitParams);
    }

    private static a D(NativeModuleInitParams nativeModuleInitParams) {
        return new a(nativeModuleInitParams);
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
                case -1896067955: goto L98;
                case -1888735685: goto L8e;
                case -1476359342: goto L83;
                case -1220597141: goto L78;
                case -833462515: goto L6d;
                case 316864173: goto L62;
                case 397803101: goto L58;
                case 834018468: goto L4e;
                case 990114365: goto L44;
                case 1015939254: goto L3a;
                case 1378366409: goto L2e;
                case 1482351130: goto L23;
                case 1618903597: goto L17;
                case 1948935352: goto Lc;
                default: goto La;
            }
        La:
            goto La2
        Lc:
            java.lang.String r0 = "getBUILD"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto La2
            r5 = 3
            goto La3
        L17:
            java.lang.String r0 = "stopSound"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto La2
            r5 = 9
            goto La3
        L23:
            java.lang.String r0 = "getSystemProperty"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto La2
            r5 = 2
            goto La3
        L2e:
            java.lang.String r0 = "loadSound"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto La2
            r5 = 10
            goto La3
        L3a:
            java.lang.String r0 = "getLongSystemProperty"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto La2
            r5 = 1
            goto La3
        L44:
            java.lang.String r0 = "getIntSystemProperty"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto La2
            r5 = 6
            goto La3
        L4e:
            java.lang.String r0 = "getBoolSystemProperty"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto La2
            r5 = 5
            goto La3
        L58:
            java.lang.String r0 = "getSystemTimeInMs"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto La2
            r5 = 4
            goto La3
        L62:
            java.lang.String r0 = "startVibrate"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto La2
            r5 = 11
            goto La3
        L6d:
            java.lang.String r0 = "stopVibrate"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto La2
            r5 = 8
            goto La3
        L78:
            java.lang.String r0 = "unregisterDeviceOrientListener"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto La2
            r5 = 13
            goto La3
        L83:
            java.lang.String r0 = "registerDeviceOrientListener"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto La2
            r5 = 12
            goto La3
        L8e:
            java.lang.String r0 = "playSound"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto La2
            r5 = 0
            goto La3
        L98:
            java.lang.String r0 = "getCurrentOrientation"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto La2
            r5 = 7
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
                case 6: goto La8;
                case 7: goto La8;
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.s.b.h(java.lang.String):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a3  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r5, java.lang.String r6, java.lang.Object[] r7) {
        /*
            Method dump skipped, instructions count: 496
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.s.b.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
