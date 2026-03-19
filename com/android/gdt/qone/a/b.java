package com.android.gdt.qone.a;

import android.text.TextUtils;
import com.android.gdt.qone.strategy.terminal.ITerminalStrategy;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class b implements ITerminalStrategy {
    public final /* synthetic */ com.android.gdt.qone.av.a a;

    public b(com.android.gdt.qone.av.a aVar) {
        this.a = aVar;
    }

    @Override // com.android.gdt.qone.strategy.terminal.ITerminalStrategy
    public final ITerminalStrategy enableAndroidId(boolean z) {
        this.a.b = z;
        return this;
    }

    @Override // com.android.gdt.qone.strategy.terminal.ITerminalStrategy
    public final ITerminalStrategy enableBuildModel(boolean z) {
        this.a.d = z;
        return this;
    }

    @Override // com.android.gdt.qone.strategy.terminal.ITerminalStrategy
    public final ITerminalStrategy enableOAID(boolean z) {
        this.a.a = z;
        return this;
    }

    @Override // com.android.gdt.qone.strategy.terminal.ITerminalStrategy
    public final ITerminalStrategy enableProcessInfo(boolean z) {
        this.a.c = z;
        return this;
    }

    @Override // com.android.gdt.qone.strategy.terminal.ITerminalStrategy
    public final ITerminalStrategy setAndroidId(String str) {
        this.a.j = str;
        return this;
    }

    @Override // com.android.gdt.qone.strategy.terminal.ITerminalStrategy
    public final ITerminalStrategy setBuildModel(String str) {
        this.a.k = str;
        return this;
    }

    @Override // com.android.gdt.qone.strategy.terminal.ITerminalStrategy
    public final ITerminalStrategy setOAID(String str) {
        this.a.i = str;
        return this;
    }

    @Override // com.android.gdt.qone.strategy.terminal.ITerminalStrategy
    public final ITerminalStrategy setQoneSoPath(String str) {
        com.android.gdt.qone.av.a aVar = this.a;
        synchronized (com.android.gdt.qone.w.a.class) {
            if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(com.android.gdt.qone.w.a.b)) {
                com.android.gdt.qone.w.a.b = str;
            }
        }
        aVar.h = str;
        return this;
    }

    @Override // com.android.gdt.qone.strategy.terminal.ITerminalStrategy
    public final ITerminalStrategy setReportDomain(String str) {
        this.a.g = str;
        return this;
    }

    @Override // com.android.gdt.qone.strategy.terminal.ITerminalStrategy
    public final ITerminalStrategy setSoLoadedFlag(boolean z) {
        this.a.f = z;
        return this;
    }

    @Override // com.android.gdt.qone.strategy.terminal.ITerminalStrategy
    public final ITerminalStrategy setUserAgreePrivacy(boolean z) {
        this.a.e = z;
        return this;
    }
}
