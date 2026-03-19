package com.netease.htprotect.necrash.nis.p003O8oO888.p004O8oO888;

import java.io.File;
import java.util.Comparator;

/* renamed from: com.netease.htprotect.necrash.nis.O8〇oO8〇88.O8〇oO8〇88.〇o〇0O〇0O, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class o0O0O implements Comparator {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    final /* synthetic */ Oo0 f110O8oO888;

    o0O0O(Oo0 oo0) {
        this.f110O8oO888 = oo0;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static int m574O8oO888(File file, File file2) {
        return file.getName().compareTo(file2.getName());
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((File) obj).getName().compareTo(((File) obj2).getName());
    }
}
