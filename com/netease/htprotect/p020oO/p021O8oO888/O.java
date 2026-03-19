package com.netease.htprotect.p020oO.p021O8oO888;

import android.os.Build;
import com.netease.htprotect.p020oO.p021O8oO888.O8;

/* renamed from: com.netease.htprotect.〇oO.O8〇oO8〇88.〇O, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class O implements O8.Ooo {
    O() {
    }

    @Override // com.netease.htprotect.p020oO.p021O8oO888.O8.Ooo
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void mo1111O8oO888(String str) {
        System.loadLibrary(str);
    }

    @Override // com.netease.htprotect.p020oO.p021O8oO888.O8.Ooo
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final String[] mo1112O8oO888() {
        return (Build.VERSION.SDK_INT < 21 || Build.SUPPORTED_ABIS.length <= 0) ? !o0O0O.m1140O8oO888(Build.CPU_ABI2) ? new String[]{Build.CPU_ABI, Build.CPU_ABI2} : new String[]{Build.CPU_ABI} : Build.SUPPORTED_ABIS;
    }

    @Override // com.netease.htprotect.p020oO.p021O8oO888.O8.Ooo
    /* renamed from: 〇O8, reason: contains not printable characters */
    public final String mo1113O8(String str) {
        return (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
    }

    @Override // com.netease.htprotect.p020oO.p021O8oO888.O8.Ooo
    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public final void mo1114Ooo(String str) {
        System.load(str);
    }

    @Override // com.netease.htprotect.p020oO.p021O8oO888.O8.Ooo
    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    public final String mo1115o0o0(String str) {
        return str.substring(3, str.length() - 3);
    }
}
