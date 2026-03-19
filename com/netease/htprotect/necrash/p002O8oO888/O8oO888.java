package com.netease.htprotect.necrash.p002O8oO888;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;

/* renamed from: com.netease.htprotect.necrash.O8〇oO8〇88.O8〇oO8〇88, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class O8oO888 extends com.netease.htprotect.necrash.nis.p003O8oO888.p004O8oO888.O8oO888 {

    /* renamed from: 〇O, reason: contains not printable characters */
    private static final String[] f71O = {"com.netease.mobsec.xs.", "com.netease.htprotect."};

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private Context f72O8oO888;
    private String Oo0;

    /* renamed from: 〇O8, reason: contains not printable characters */
    private String f73O8;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private long f74Ooo;

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private String f75o0o0;

    /* renamed from: 〇oO, reason: contains not printable characters */
    private String f76oO;

    @Override // com.netease.htprotect.necrash.nis.p003O8oO888.p004O8oO888.O8oO888
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    protected final Map mo535O8oO888() {
        return null;
    }

    @Override // com.netease.htprotect.necrash.nis.p003O8oO888.p004O8oO888.O8oO888
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    protected final Map mo536O8oO888(String str) {
        return com.netease.htprotect.necrash.p006Ooo.O8oO888.m626O8oO888(this.f72O8oO888, str, "java", this.f76oO, this.Oo0, this.f73O8, this.f75o0o0, this.f74Ooo);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void m537O8oO888(Context context, String str, String str2, String str3, long j) {
        this.f72O8oO888 = context;
        this.f73O8 = com.netease.htprotect.necrash.p005O8.O8oO888.m620Ooo(context);
        this.f75o0o0 = com.netease.htprotect.necrash.p005O8.O8oO888.m613O8oO888(context);
        this.f76oO = str2;
        this.Oo0 = str3;
        this.f74Ooo = j;
        super.m556Ooo(str);
    }

    @Override // com.netease.htprotect.necrash.nis.p003O8oO888.p004O8oO888.O8oO888
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    protected final boolean mo538O8oO888(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null && stackTrace.length != 0) {
            int iMin = Math.min(stackTrace.length, 5);
            for (int i = 0; i < iMin; i++) {
                StackTraceElement stackTraceElement = stackTrace[i];
                if (stackTraceElement != null) {
                    String className = stackTraceElement.getClassName();
                    if (TextUtils.isEmpty(className)) {
                        continue;
                    } else {
                        for (String str : f71O) {
                            if (className.contains(str)) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
