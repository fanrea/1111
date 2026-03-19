package com.tk.component.a;

import com.kuaishou.tk.export.NativeModuleInitParams;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class h implements com.tk.core.manager.a.a<g> {
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
                return "quadTo";
            case 1:
                return "addPath";
            case 2:
                return "addRoundRect";
            case 3:
                return "close";
            case 4:
                return "reset";
            case 5:
                return "lineTo";
            case 6:
                return "addArc";
            case 7:
                return "addOval";
            case 8:
                return "moveTo";
            case 9:
                return "addRect";
            case 10:
                return "addCircle";
            case 11:
                return "arcTo";
            case 12:
                return "cubicTo";
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
        return "4#quadTo#0,4#addPath#1,4#addRoundRect#2,4#close#3,4#reset#4,4#lineTo#5,4#addArc#6,4#addOval#7,4#moveTo#8,4#addRect#9,4#addCircle#10,4#arcTo#11,4#cubicTo#12";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "1";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ g b(NativeModuleInitParams nativeModuleInitParams) {
        return M(nativeModuleInitParams);
    }

    private static g M(NativeModuleInitParams nativeModuleInitParams) {
        return new g(nativeModuleInitParams);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0095  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int h(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case -1422542351: goto L8b;
                case -1148718957: goto L81;
                case -1148708762: goto L77;
                case -1148645851: goto L6c;
                case -1102672497: goto L62;
                case -1068263892: goto L57;
                case -948832734: goto L4d;
                case -467376943: goto L42;
                case -143010575: goto L38;
                case 93075565: goto L2d;
                case 94756344: goto L22;
                case 108404047: goto L17;
                case 1111892837: goto Lb;
                default: goto L9;
            }
        L9:
            goto L95
        Lb:
            java.lang.String r0 = "cubicTo"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L95
            r4 = 12
            goto L96
        L17:
            java.lang.String r0 = "reset"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L95
            r4 = 4
            goto L96
        L22:
            java.lang.String r0 = "close"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L95
            r4 = 3
            goto L96
        L2d:
            java.lang.String r0 = "arcTo"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L95
            r4 = 11
            goto L96
        L38:
            java.lang.String r0 = "addRoundRect"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L95
            r4 = 2
            goto L96
        L42:
            java.lang.String r0 = "addCircle"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L95
            r4 = 10
            goto L96
        L4d:
            java.lang.String r0 = "quadTo"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L95
            r4 = 0
            goto L96
        L57:
            java.lang.String r0 = "moveTo"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L95
            r4 = 8
            goto L96
        L62:
            java.lang.String r0 = "lineTo"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L95
            r4 = 5
            goto L96
        L6c:
            java.lang.String r0 = "addRect"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L95
            r4 = 9
            goto L96
        L77:
            java.lang.String r0 = "addPath"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L95
            r4 = 1
            goto L96
        L81:
            java.lang.String r0 = "addOval"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L95
            r4 = 7
            goto L96
        L8b:
            java.lang.String r0 = "addArc"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L95
            r4 = 6
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
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.a.h.h(java.lang.String):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009c  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r9, java.lang.String r10, java.lang.Object[] r11) {
        /*
            Method dump skipped, instructions count: 586
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.a.h.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
