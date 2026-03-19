package com.netease.htprotect.necrash.nis.crashreport;

import com.netease.htprotect.necrash.nis.p003O8oO888.Ooo;
import com.netease.htprotect.necrash.nis.p003O8oO888.o8o0;

/* renamed from: com.netease.htprotect.necrash.nis.crashreport.〇o0〇o0, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class o0o0 implements Ooo.O8oO888 {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    final /* synthetic */ String f175O8oO888;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    final /* synthetic */ O8oO888 f176Ooo;

    o0o0(O8oO888 o8oO888, String str) {
        this.f176Ooo = o8oO888;
        this.f175O8oO888 = str;
    }

    @Override // com.netease.htprotect.necrash.nis.p003O8oO888.Ooo.O8oO888
    /* renamed from: O8〇oO8〇88 */
    public final void mo569O8oO888(int i, String str) {
        o8o0.m579O8("upload crash info failed,error code:" + i + " msg:" + str);
    }

    @Override // com.netease.htprotect.necrash.nis.p003O8oO888.Ooo.O8oO888
    /* renamed from: O8〇oO8〇88 */
    public final void mo570O8oO888(String str) {
        o8o0.m581Ooo("upload crash info success" + this.f175O8oO888);
        com.netease.htprotect.necrash.nis.p003O8oO888.p004O8oO888.Oo0.m563O8(this.f175O8oO888);
    }
}
