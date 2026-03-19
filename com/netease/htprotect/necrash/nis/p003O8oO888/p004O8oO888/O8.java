package com.netease.htprotect.necrash.nis.p003O8oO888.p004O8oO888;

import com.netease.htprotect.necrash.nis.p003O8oO888.Ooo;
import com.netease.htprotect.necrash.nis.p003O8oO888.o8o0;

/* renamed from: com.netease.htprotect.necrash.nis.O8〇oO8〇88.O8〇oO8〇88.〇O8, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class O8 implements Ooo.O8oO888 {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    final /* synthetic */ String f103O8oO888;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    final /* synthetic */ O8oO888 f104Ooo;

    O8(O8oO888 o8oO888, String str) {
        this.f104Ooo = o8oO888;
        this.f103O8oO888 = str;
    }

    @Override // com.netease.htprotect.necrash.nis.p003O8oO888.Ooo.O8oO888
    /* renamed from: O8〇oO8〇88 */
    public final void mo569O8oO888(int i, String str) {
        o8o0.m579O8("upload crash info failed,error code:" + i + " msg:" + str);
    }

    @Override // com.netease.htprotect.necrash.nis.p003O8oO888.Ooo.O8oO888
    /* renamed from: O8〇oO8〇88 */
    public final void mo570O8oO888(String str) {
        o8o0.m581Ooo("upload crash info success" + this.f103O8oO888);
        Oo0 unused = this.f104Ooo.f88oO;
        Oo0.m563O8(this.f103O8oO888);
    }
}
