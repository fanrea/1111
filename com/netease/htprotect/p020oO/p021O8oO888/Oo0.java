package com.netease.htprotect.p020oO.p021O8oO888;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class Oo0 implements FilenameFilter {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    final /* synthetic */ String f568O8oO888;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    final /* synthetic */ o0o0 f569Ooo;

    Oo0(o0o0 o0o0Var, String str) {
        this.f569Ooo = o0o0Var;
        this.f568O8oO888 = str;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return str.startsWith(this.f568O8oO888);
    }
}
