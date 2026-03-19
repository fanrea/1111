package com.kwad.a;

import com.kuaishou.tk.export.NativeModuleInitParams;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class e implements com.tk.core.manager.a.a<b> {
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
                return "isFile";
            case 1:
                return "mkdirsAsync";
            case 2:
                return "canExecute";
            case 3:
                return com.component.a.f.d.b;
            case 4:
                return "mkdir";
            case 5:
                return "lastModified";
            case 6:
                return "mkdirAsync";
            case 7:
                return "exists";
            case 8:
                return "mkdirs";
            case 9:
                return "deleteAsync";
            case 10:
                return "canWrite";
            case 11:
                return "delete";
            case 12:
                return "isDirectory";
            case 13:
                return "canRead";
            case 14:
                return "length";
            case 15:
                return "list";
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
        return "8#isFile#0,4#mkdirsAsync#1,8#canExecute#2,8#create#3,8#mkdir#4,8#lastModified#5,4#mkdirAsync#6,8#exists#7,8#mkdirs#8,4#deleteAsync#9,8#canWrite#10,8#delete#11,8#isDirectory#12,8#canRead#13,8#length#14,8#list#15";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ b b(NativeModuleInitParams nativeModuleInitParams) {
        return c(nativeModuleInitParams);
    }

    private static b c(NativeModuleInitParams nativeModuleInitParams) {
        return new b(nativeModuleInitParams);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ba  */
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
                case -1352294148: goto Lb0;
                case -1335458389: goto La5;
                case -1289358244: goto L9b;
                case -1180511802: goto L91;
                case -1149542511: goto L86;
                case -1106363674: goto L7b;
                case -1072489436: goto L71;
                case -133871121: goto L67;
                case 3322014: goto L5c;
                case 103950895: goto L52;
                case 144043405: goto L46;
                case 215834723: goto L3a;
                case 549709190: goto L2e;
                case 1555492024: goto L22;
                case 1571267973: goto L17;
                case 1959003007: goto Lc;
                default: goto La;
            }
        La:
            goto Lba
        Lc:
            java.lang.String r0 = "lastModified"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lba
            r5 = 4
            goto Lbb
        L17:
            java.lang.String r0 = "canExecute"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lba
            r5 = 1
            goto Lbb
        L22:
            java.lang.String r0 = "mkdirsAsync"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lba
            r5 = 13
            goto Lbb
        L2e:
            java.lang.String r0 = "canRead"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lba
            r5 = 10
            goto Lbb
        L3a:
            java.lang.String r0 = "isDirectory"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lba
            r5 = 9
            goto Lbb
        L46:
            java.lang.String r0 = "mkdirAsync"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lba
            r5 = 14
            goto Lbb
        L52:
            java.lang.String r0 = "mkdir"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lba
            r5 = 3
            goto Lbb
        L5c:
            java.lang.String r0 = "list"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lba
            r5 = 12
            goto Lbb
        L67:
            java.lang.String r0 = "canWrite"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lba
            r5 = 7
            goto Lbb
        L71:
            java.lang.String r0 = "mkdirs"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lba
            r5 = 6
            goto Lbb
        L7b:
            java.lang.String r0 = "length"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lba
            r5 = 11
            goto Lbb
        L86:
            java.lang.String r0 = "deleteAsync"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lba
            r5 = 15
            goto Lbb
        L91:
            java.lang.String r0 = "isFile"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lba
            r5 = 0
            goto Lbb
        L9b:
            java.lang.String r0 = "exists"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lba
            r5 = 5
            goto Lbb
        La5:
            java.lang.String r0 = "delete"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lba
            r5 = 8
            goto Lbb
        Lb0:
            java.lang.String r0 = "create"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lba
            r5 = 2
            goto Lbb
        Lba:
            r5 = -1
        Lbb:
            switch(r5) {
                case 0: goto Lc0;
                case 1: goto Lc0;
                case 2: goto Lc0;
                case 3: goto Lc0;
                case 4: goto Lc0;
                case 5: goto Lc0;
                case 6: goto Lc0;
                case 7: goto Lc0;
                case 8: goto Lc0;
                case 9: goto Lc0;
                case 10: goto Lc0;
                case 11: goto Lc0;
                case 12: goto Lc0;
                case 13: goto Lbf;
                case 14: goto Lbf;
                case 15: goto Lbf;
                default: goto Lbe;
            }
        Lbe:
            return r3
        Lbf:
            return r1
        Lc0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.a.e.h(java.lang.String):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ba  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r4, java.lang.String r5, java.lang.Object[] r6) {
        /*
            Method dump skipped, instructions count: 464
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.a.e.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
