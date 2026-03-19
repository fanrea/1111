package com.tk.component.a;

import com.baidu.mobads.container.util.animation.j;
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
                return j.a;
            case 1:
                return "save";
            case 2:
                return "drawText";
            case 3:
                return "drawRoundRect";
            case 4:
                return "drawCircle";
            case 5:
                return "scale";
            case 6:
                return "rotate";
            case 7:
                return "clipPath";
            case 8:
                return "drawPath";
            case 9:
                return "drawImage";
            case 10:
                return "drawColor";
            case 11:
                return "skew";
            case 12:
                return "drawArc";
            case 13:
                return "restore";
            case 14:
                return "drawOval";
            case 15:
                return "drawLine";
            case 16:
                return "drawRect";
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
        return "4#translate#0,4#save#1,4#drawText#2,4#drawRoundRect#3,4#drawCircle#4,4#scale#5,4#rotate#6,4#clipPath#7,4#drawPath#8,4#drawImage#9,4#drawColor#10,4#skew#11,4#drawArc#12,4#restore#13,4#drawOval#14,4#drawLine#15,4#drawRect#16";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "1";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ a b(NativeModuleInitParams nativeModuleInitParams) {
        return J(nativeModuleInitParams);
    }

    private static a J(NativeModuleInitParams nativeModuleInitParams) {
        return new a(nativeModuleInitParams);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c5  */
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
                case -925180581: goto Lbb;
                case -827125928: goto Lb0;
                case -827024458: goto La5;
                case -827014263: goto L9a;
                case -826951352: goto L8f;
                case -826891119: goto L85;
                case -556608716: goto L7b;
                case 3522941: goto L71;
                case 3532042: goto L66;
                case 109250890: goto L5c;
                case 120765567: goto L50;
                case 126236279: goto L44;
                case 137996206: goto L39;
                case 917656469: goto L2e;
                case 1052832078: goto L23;
                case 1097519758: goto L17;
                case 1912970862: goto Lb;
                default: goto L9;
            }
        L9:
            goto Lc5
        Lb:
            java.lang.String r0 = "drawArc"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 12
            goto Lc6
        L17:
            java.lang.String r0 = "restore"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 13
            goto Lc6
        L23:
            java.lang.String r0 = "translate"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 0
            goto Lc6
        L2e:
            java.lang.String r0 = "clipPath"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 7
            goto Lc6
        L39:
            java.lang.String r0 = "drawRoundRect"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 3
            goto Lc6
        L44:
            java.lang.String r0 = "drawImage"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 9
            goto Lc6
        L50:
            java.lang.String r0 = "drawColor"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 10
            goto Lc6
        L5c:
            java.lang.String r0 = "scale"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 5
            goto Lc6
        L66:
            java.lang.String r0 = "skew"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 11
            goto Lc6
        L71:
            java.lang.String r0 = "save"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 1
            goto Lc6
        L7b:
            java.lang.String r0 = "drawCircle"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 4
            goto Lc6
        L85:
            java.lang.String r0 = "drawText"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 2
            goto Lc6
        L8f:
            java.lang.String r0 = "drawRect"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 16
            goto Lc6
        L9a:
            java.lang.String r0 = "drawPath"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 8
            goto Lc6
        La5:
            java.lang.String r0 = "drawOval"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 14
            goto Lc6
        Lb0:
            java.lang.String r0 = "drawLine"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 15
            goto Lc6
        Lbb:
            java.lang.String r0 = "rotate"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Lc5
            r4 = 6
            goto Lc6
        Lc5:
            r4 = -1
        Lc6:
            switch(r4) {
                case 0: goto Lca;
                case 1: goto Lca;
                case 2: goto Lca;
                case 3: goto Lca;
                case 4: goto Lca;
                case 5: goto Lca;
                case 6: goto Lca;
                case 7: goto Lca;
                case 8: goto Lca;
                case 9: goto Lca;
                case 10: goto Lca;
                case 11: goto Lca;
                case 12: goto Lca;
                case 13: goto Lca;
                case 14: goto Lca;
                case 15: goto Lca;
                case 16: goto Lca;
                default: goto Lc9;
            }
        Lc9:
            return r2
        Lca:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.a.b.h(java.lang.String):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00cb  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r8, java.lang.String r9, java.lang.Object[] r10) {
        /*
            Method dump skipped, instructions count: 736
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.a.b.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
