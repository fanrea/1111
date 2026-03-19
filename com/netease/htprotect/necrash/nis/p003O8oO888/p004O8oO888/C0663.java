package com.netease.htprotect.necrash.nis.p003O8oO888.p004O8oO888;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.netease.htprotect.necrash.nis.O8〇oO8〇88.O8〇oO8〇88.〇〇, reason: contains not printable characters */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class C0663 implements FilenameFilter {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    final /* synthetic */ Oo0 f111O8oO888;

    C0663(Oo0 oo0) {
        this.f111O8oO888 = oo0;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        if (str.startsWith("tombstone_")) {
            return str.endsWith(".native.crash");
        }
        return false;
    }
}
