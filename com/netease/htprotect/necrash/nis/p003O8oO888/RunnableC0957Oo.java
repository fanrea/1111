package com.netease.htprotect.necrash.nis.p003O8oO888;

import com.netease.htprotect.necrash.nis.p003O8oO888.Ooo;
import java.util.Map;

/* renamed from: com.netease.htprotect.necrash.nis.O8〇oO8〇88.O〇〇〇o, reason: invalid class name and case insensitive filesystem */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class RunnableC0957Oo implements Runnable {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    final /* synthetic */ String f127O8oO888;

    /* renamed from: 〇O8, reason: contains not printable characters */
    final /* synthetic */ Map f128O8 = null;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    final /* synthetic */ Map f129Ooo;

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    final /* synthetic */ Ooo.O8oO888 f130o0o0;

    RunnableC0957Oo(String str, Map map, Ooo.O8oO888 o8oO888) {
        this.f127O8oO888 = str;
        this.f129Ooo = map;
        this.f130o0o0 = o8oO888;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            o8o0.m576O8oO888("post request url:" + this.f127O8oO888 + " args:" + Ooo.m589O8oO888(this.f129Ooo, "utf-8"));
            Ooo.m594O8oO888(this.f127O8oO888, true, false, Ooo.m589O8oO888(this.f129Ooo, "utf-8"), this.f128O8, null, new C80(this));
        } catch (Exception e) {
            o8o0.m579O8(e.getMessage());
            this.f130o0o0.mo569O8oO888(10001, "网络请求出现异常:" + e.toString());
        }
    }
}
