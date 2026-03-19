package com.netease.htprotect.p010Ooo.p017oO;

import java.util.Locale;

/* renamed from: com.netease.htprotect.〇Ooo.〇oO.〇O8, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class O8 {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static final Locale f522O8oO888 = new Locale("", "");

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static int m1061O8oO888(Locale locale, Locale locale2) {
        if (locale == null) {
            return -1;
        }
        if (!locale.getLanguage().equals(locale2.getLanguage())) {
            return (locale2.getCountry().isEmpty() || locale2.getLanguage().isEmpty()) ? 1 : 0;
        }
        if (locale.getCountry().equals(locale2.getCountry())) {
            return 3;
        }
        return locale2.getCountry().isEmpty() ? 2 : 0;
    }
}
