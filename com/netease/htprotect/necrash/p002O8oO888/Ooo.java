package com.netease.htprotect.necrash.p002O8oO888;

import android.content.Context;
import android.text.TextUtils;
import com.netease.htprotect.necrash.nis.crashreport.O8oO888;
import java.util.Map;
import java.util.regex.Pattern;

/* renamed from: com.netease.htprotect.necrash.O8〇oO8〇88.〇Ooo, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class Ooo extends O8oO888 {

    /* renamed from: 〇O, reason: contains not printable characters */
    private static final Pattern f77O = Pattern.compile("^\\s*#.*\\bpc\\b .*libNetHTProtect\\.so.*");

    /* renamed from: 〇o〇0O〇0O, reason: contains not printable characters */
    private static final String f78o0O0O = "libNetHTProtect.so";

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private Context f79O8oO888;
    private String Oo0;

    /* renamed from: 〇O8, reason: contains not printable characters */
    private String f80O8;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private long f81Ooo;

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private String f82o0o0;

    /* renamed from: 〇oO, reason: contains not printable characters */
    private String f83oO;

    @Override // com.netease.htprotect.necrash.nis.crashreport.O8oO888
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    protected final Map mo539O8oO888() {
        return null;
    }

    @Override // com.netease.htprotect.necrash.nis.crashreport.O8oO888
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    protected final Map mo540O8oO888(String str) {
        return com.netease.htprotect.necrash.p006Ooo.O8oO888.m626O8oO888(this.f79O8oO888, str, "ndk", this.f83oO, this.Oo0, this.f80O8, this.f82o0o0, this.f81Ooo);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void m541O8oO888(Context context, String str, String str2, String str3, String str4, long j) throws Throwable {
        this.f79O8oO888 = context;
        this.f80O8 = com.netease.htprotect.necrash.p005O8.O8oO888.m620Ooo(context);
        this.f82o0o0 = com.netease.htprotect.necrash.p005O8.O8oO888.m613O8oO888(context);
        this.f83oO = str3;
        this.Oo0 = str4;
        this.f81Ooo = j;
        super.m610O8oO888(str, str2);
    }

    @Override // com.netease.htprotect.necrash.nis.crashreport.O8oO888
    /* renamed from: 〇Ooo, reason: contains not printable characters */
    protected final boolean mo542Ooo(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String[] strArrSplit = str.split("\n");
        if (strArrSplit.length == 0) {
            return true;
        }
        for (String str2 : strArrSplit) {
            if (!TextUtils.isEmpty(str2) && str2.contains(f78o0O0O) && f77O.matcher(str2).find()) {
                return false;
            }
        }
        return true;
    }
}
