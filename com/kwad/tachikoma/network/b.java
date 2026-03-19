package com.kwad.tachikoma.network;

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
                return "cancelDownload";
            case 1:
                return "getCurrentStatus";
            case 2:
                return "resumeDownload";
            case 3:
                return "stopDownload";
            case 4:
                return "clearFileCache";
            case 5:
                return "uninstallApp";
            case 6:
                return "getSoFarBytes";
            case 7:
                return "getTotalBytes";
            case 8:
                return "getRealProgress";
            case 9:
                return "addLoadStatusListener";
            case 10:
                return "getProgress";
            case 11:
                return "openApp";
            case 12:
                return "startDownload";
            case 13:
                return "installApp";
            case 14:
                return "pauseDownload";
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
        return "8#cancelDownload#0,8#getCurrentStatus#1,8#resumeDownload#2,8#stopDownload#3,8#clearFileCache#4,8#uninstallApp#5,8#getSoFarBytes#6,8#getTotalBytes#7,8#getRealProgress#8,4#addLoadStatusListener#9,8#getProgress#10,8#openApp#11,8#startDownload#12,8#installApp#13,8#pauseDownload#14";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ a b(NativeModuleInitParams nativeModuleInitParams) {
        return t(nativeModuleInitParams);
    }

    private static a t(NativeModuleInitParams nativeModuleInitParams) {
        return new a(nativeModuleInitParams);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
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
                case -1272932897: goto La4;
                case -1263222921: goto L99;
                case -1029761155: goto L8f;
                case -1018586163: goto L84;
                case -503430878: goto L7a;
                case -451216226: goto L6f;
                case 184711125: goto L65;
                case 254546602: goto L5b;
                case 773630470: goto L51;
                case 900412038: goto L46;
                case 1076821923: goto L3a;
                case 1125021461: goto L2f;
                case 1541932953: goto L24;
                case 1554935562: goto L18;
                case 1898615905: goto Lc;
                default: goto La;
            }
        La:
            goto Lae
        Lc:
            java.lang.String r0 = "getRealProgress"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lae
            r5 = 8
            goto Laf
        L18:
            java.lang.String r0 = "startDownload"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lae
            r5 = 11
            goto Laf
        L24:
            java.lang.String r0 = "clearFileCache"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lae
            r5 = 4
            goto Laf
        L2f:
            java.lang.String r0 = "getCurrentStatus"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lae
            r5 = 1
            goto Laf
        L3a:
            java.lang.String r0 = "getProgress"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lae
            r5 = 9
            goto Laf
        L46:
            java.lang.String r0 = "installApp"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lae
            r5 = 12
            goto Laf
        L51:
            java.lang.String r0 = "getSoFarBytes"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lae
            r5 = 6
            goto Laf
        L5b:
            java.lang.String r0 = "stopDownload"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lae
            r5 = 3
            goto Laf
        L65:
            java.lang.String r0 = "resumeDownload"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lae
            r5 = 2
            goto Laf
        L6f:
            java.lang.String r0 = "pauseDownload"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lae
            r5 = 13
            goto Laf
        L7a:
            java.lang.String r0 = "cancelDownload"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lae
            r5 = 0
            goto Laf
        L84:
            java.lang.String r0 = "addLoadStatusListener"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lae
            r5 = 14
            goto Laf
        L8f:
            java.lang.String r0 = "getTotalBytes"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lae
            r5 = 7
            goto Laf
        L99:
            java.lang.String r0 = "openApp"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lae
            r5 = 10
            goto Laf
        La4:
            java.lang.String r0 = "uninstallApp"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lae
            r5 = 5
            goto Laf
        Lae:
            r5 = -1
        Laf:
            switch(r5) {
                case 0: goto Lb4;
                case 1: goto Lb4;
                case 2: goto Lb4;
                case 3: goto Lb4;
                case 4: goto Lb4;
                case 5: goto Lb4;
                case 6: goto Lb4;
                case 7: goto Lb4;
                case 8: goto Lb4;
                case 9: goto Lb4;
                case 10: goto Lb4;
                case 11: goto Lb4;
                case 12: goto Lb4;
                case 13: goto Lb4;
                case 14: goto Lb3;
                default: goto Lb2;
            }
        Lb2:
            return r3
        Lb3:
            return r1
        Lb4:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.network.b.h(java.lang.String):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r4, java.lang.String r5, java.lang.Object[] r6) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.network.b.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
