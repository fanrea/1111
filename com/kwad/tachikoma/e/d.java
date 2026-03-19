package com.kwad.tachikoma.e;

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
        switch (i) {
            case 0:
                return "isClosed";
            case 1:
                return "getColumnName";
            case 2:
                return "moveToPrevious";
            case 3:
                return "getShort";
            case 4:
                return "moveToLast";
            case 5:
                return "getInt";
            case 6:
                return "getFloat";
            case 7:
                return "close";
            case 8:
                return "getString";
            case 9:
                return "getPosition";
            case 10:
                return "moveToNext";
            case 11:
                return "moveToFirst";
            case 12:
                return "getColumnCount";
            case 13:
                return "getLong";
            case 14:
                return "getDouble";
            case 15:
                return "getColumnIndex";
            case 16:
                return "getCount";
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
        return "8#isClosed#0,8#getColumnName#1,8#moveToPrevious#2,8#getShort#3,8#moveToLast#4,8#getInt#5,8#getFloat#6,4#close#7,8#getString#8,8#getPosition#9,8#moveToNext#10,8#moveToFirst#11,8#getColumnCount#12,8#getLong#13,8#getDouble#14,8#getColumnIndex#15,8#getCount#16";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ c b(NativeModuleInitParams nativeModuleInitParams) {
        return l(nativeModuleInitParams);
    }

    private static c l(NativeModuleInitParams nativeModuleInitParams) {
        return new c(nativeModuleInitParams);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c6  */
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
                case -1557616926: goto Lbc;
                case -1557553345: goto Lb1;
                case -1501005277: goto La6;
                case -1495510554: goto L9b;
                case -1469262177: goto L90;
                case -1249359687: goto L86;
                case -1046788124: goto L7b;
                case -683486410: goto L71;
                case -75354382: goto L66;
                case 94756344: goto L5b;
                case 168741187: goto L50;
                case 370056903: goto L44;
                case 804029191: goto L39;
                case 1891557111: goto L2e;
                case 1950676825: goto L22;
                case 1953351846: goto L17;
                case 1965238982: goto Lc;
                default: goto La;
            }
        La:
            goto Lc6
        Lc:
            java.lang.String r0 = "getShort"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lc6
            r5 = 3
            goto Lc7
        L17:
            java.lang.String r0 = "getFloat"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lc6
            r5 = 6
            goto Lc7
        L22:
            java.lang.String r0 = "getCount"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lc6
            r5 = 15
            goto Lc7
        L2e:
            java.lang.String r0 = "getColumnName"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lc6
            r5 = 1
            goto Lc7
        L39:
            java.lang.String r0 = "getString"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lc6
            r5 = 7
            goto Lc7
        L44:
            java.lang.String r0 = "getDouble"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lc6
            r5 = 13
            goto Lc7
        L50:
            java.lang.String r0 = "moveToPrevious"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lc6
            r5 = 2
            goto Lc7
        L5b:
            java.lang.String r0 = "close"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lc6
            r5 = 16
            goto Lc7
        L66:
            java.lang.String r0 = "getLong"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lc6
            r5 = 12
            goto Lc7
        L71:
            java.lang.String r0 = "isClosed"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lc6
            r5 = 0
            goto Lc7
        L7b:
            java.lang.String r0 = "moveToFirst"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lc6
            r5 = 10
            goto Lc7
        L86:
            java.lang.String r0 = "getInt"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lc6
            r5 = 5
            goto Lc7
        L90:
            java.lang.String r0 = "getPosition"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lc6
            r5 = 8
            goto Lc7
        L9b:
            java.lang.String r0 = "getColumnIndex"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lc6
            r5 = 14
            goto Lc7
        La6:
            java.lang.String r0 = "getColumnCount"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lc6
            r5 = 11
            goto Lc7
        Lb1:
            java.lang.String r0 = "moveToNext"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lc6
            r5 = 9
            goto Lc7
        Lbc:
            java.lang.String r0 = "moveToLast"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lc6
            r5 = 4
            goto Lc7
        Lc6:
            r5 = -1
        Lc7:
            switch(r5) {
                case 0: goto Lcc;
                case 1: goto Lcc;
                case 2: goto Lcc;
                case 3: goto Lcc;
                case 4: goto Lcc;
                case 5: goto Lcc;
                case 6: goto Lcc;
                case 7: goto Lcc;
                case 8: goto Lcc;
                case 9: goto Lcc;
                case 10: goto Lcc;
                case 11: goto Lcc;
                case 12: goto Lcc;
                case 13: goto Lcc;
                case 14: goto Lcc;
                case 15: goto Lcc;
                case 16: goto Lcb;
                default: goto Lca;
            }
        Lca:
            return r3
        Lcb:
            return r1
        Lcc:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.e.d.h(java.lang.String):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c6  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r4, java.lang.String r5, java.lang.Object[] r6) {
        /*
            Method dump skipped, instructions count: 536
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.e.d.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
