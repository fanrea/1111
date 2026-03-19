package com.tachikoma.component;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b implements com.tk.core.manager.a.b {
    private static final String[] AH = {"Path", "TKImageView", "Canvas2D", "TKImageLoadParam", "RoundRectView", "Paint", "TKAnimatedImage", "TKLottieImageView", "ViewPager2", "TKNetwork", "ImageResource", "ListView", "ScrollView", "Dialog", "TKBlurImage", "ReboundView", "Canvas2DView", "TKImage"};
    private final ConcurrentHashMap<String, com.tk.core.manager.a.a<?>> AI = new ConcurrentHashMap<>(25);

    @Override // com.tk.core.manager.a.b
    public final String[] hI() {
        return AH;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d1  */
    @Override // com.tk.core.manager.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean i(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case -1347805719: goto Lc7;
                case -844637104: goto Lbc;
                case -541155036: goto Lb1;
                case -427392073: goto La6;
                case -41096758: goto L9c;
                case 2480197: goto L92;
                case 27573236: goto L87;
                case 76875838: goto L7d;
                case 909616015: goto L72;
                case 1239681667: goto L68;
                case 1410352259: goto L5c;
                case 1749892161: goto L51;
                case 1824159337: goto L45;
                case 1831574653: goto L39;
                case 1871115850: goto L2e;
                case 2046749032: goto L22;
                case 2059813682: goto L16;
                case 2134855223: goto Lb;
                default: goto L9;
            }
        L9:
            goto Ld1
        Lb:
            java.lang.String r0 = "RoundRectView"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 4
            goto Ld2
        L16:
            java.lang.String r0 = "ScrollView"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 12
            goto Ld2
        L22:
            java.lang.String r0 = "Dialog"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 13
            goto Ld2
        L2e:
            java.lang.String r0 = "TKLottieImageView"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 7
            goto Ld2
        L39:
            java.lang.String r0 = "TKBlurImage"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 14
            goto Ld2
        L45:
            java.lang.String r0 = "ImageResource"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 10
            goto Ld2
        L51:
            java.lang.String r0 = "TKAnimatedImage"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 6
            goto Ld2
        L5c:
            java.lang.String r0 = "ListView"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 11
            goto Ld2
        L68:
            java.lang.String r0 = "TKImageLoadParam"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 3
            goto Ld2
        L72:
            java.lang.String r0 = "Canvas2DView"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 16
            goto Ld2
        L7d:
            java.lang.String r0 = "Paint"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 5
            goto Ld2
        L87:
            java.lang.String r0 = "ViewPager2"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 8
            goto Ld2
        L92:
            java.lang.String r0 = "Path"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 0
            goto Ld2
        L9c:
            java.lang.String r0 = "Canvas2D"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 2
            goto Ld2
        La6:
            java.lang.String r0 = "TKNetwork"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 9
            goto Ld2
        Lb1:
            java.lang.String r0 = "TKImage"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 17
            goto Ld2
        Lbc:
            java.lang.String r0 = "ReboundView"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 15
            goto Ld2
        Lc7:
            java.lang.String r0 = "TKImageView"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto Ld1
            r4 = 1
            goto Ld2
        Ld1:
            r4 = -1
        Ld2:
            switch(r4) {
                case 0: goto Ld6;
                case 1: goto Ld6;
                case 2: goto Ld6;
                case 3: goto Ld6;
                case 4: goto Ld6;
                case 5: goto Ld6;
                case 6: goto Ld6;
                case 7: goto Ld6;
                case 8: goto Ld6;
                case 9: goto Ld6;
                case 10: goto Ld6;
                case 11: goto Ld6;
                case 12: goto Ld6;
                case 13: goto Ld6;
                case 14: goto Ld6;
                case 15: goto Ld6;
                case 16: goto Ld6;
                case 17: goto Ld6;
                default: goto Ld5;
            }
        Ld5:
            return r2
        Ld6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tachikoma.component.b.i(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011e A[PHI: r2
  0x011e: PHI (r2v74 java.lang.String) = (r2v1 java.lang.String), (r2v2 java.lang.String), (r2v75 java.lang.String) binds: [B:57:0x0119, B:54:0x010e, B:4:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.tk.core.manager.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.tk.core.manager.a.a j(java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 678
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tachikoma.component.b.j(java.lang.String):com.tk.core.manager.a.a");
    }

    @Override // com.tk.core.manager.b
    public final void ae() {
        for (String str : AH) {
            if (!this.AI.contains(str)) {
                j(str);
            }
        }
    }

    @Override // com.tk.core.manager.b
    public final ConcurrentHashMap<String, com.tk.core.manager.a.a<?>> hJ() {
        return this.AI;
    }
}
