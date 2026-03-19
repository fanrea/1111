package com.netease.htprotect.necrash.nis.p003O8oO888.p004O8oO888;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.netease.htprotect.necrash.nis.O8〇oO8〇88.O8〇oO8〇88.〇O, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class O implements FilenameFilter {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    final /* synthetic */ Oo0 f102O8oO888;

    O(Oo0 oo0) {
        this.f102O8oO888 = oo0;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        if (str.startsWith("tombstone_")) {
            return str.endsWith(".java.crash");
        }
        return false;
    }
}
