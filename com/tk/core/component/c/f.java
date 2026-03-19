package com.tk.core.component.c;

import com.google.android.material.badge.BadgeDrawable;
import com.kuaishou.tk.export.NativeModuleInitParams;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class f extends c {
    public int aee;
    public int aef;

    @Override // com.tk.core.component.c.c
    protected final boolean isSingleLine() {
        return false;
    }

    public f(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        getView().setGravity(BadgeDrawable.TOP_START);
    }

    public final void dD(int i) {
        setMaxLines(i);
        this.ade.setMaxLines(i);
    }

    public final void dE(int i) {
        dD(i);
    }

    public final void dL(int i) {
        this.aee = i;
        dK(i);
    }

    public final void dM(int i) {
        if (i < 0) {
            i = Integer.MAX_VALUE;
        }
        this.aef = i;
        dJ(i);
    }
}
