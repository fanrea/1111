package com.tachikoma.core;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b implements com.tk.core.manager.a.b {
    private static final String[] AH = {"TKPinchEvent", "TKUpEvent", "TKProgressBar", "TKSwipeEvent", "TKSpanItem", "TKInputEvent", "TKButton", "TKTextArea", "TKKeyframeAnimation", "TKBasicAnimation", "TKText", "TKView", "TKLongPressEvent", "TKEvent", "TKTapEvent", "TKToast", "TKBaseBridge", "TKLocalStorage", "TKInput", "TKPanEvent", "TKMarqueeText", "TKRouter", "TKSwitch", "TKDownEvent", "TKSpan", "TKClock"};
    private final ConcurrentHashMap<String, com.tk.core.manager.a.a<?>> AI = new ConcurrentHashMap<>(35);

    @Override // com.tk.core.manager.a.b
    public final String[] hI() {
        return AH;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0132  */
    @Override // com.tk.core.manager.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean i(java.lang.String r4) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tachikoma.core.b.i(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:83:0x019d A[PHI: r2
  0x019d: PHI (r2v114 java.lang.String) = (r2v1 java.lang.String), (r2v2 java.lang.String), (r2v115 java.lang.String) binds: [B:81:0x0198, B:78:0x018d, B:4:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.tk.core.manager.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.tk.core.manager.a.a j(java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 972
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tachikoma.core.b.j(java.lang.String):com.tk.core.manager.a.a");
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
