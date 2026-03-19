package com.netease.htprotect.p001OO8;

import android.text.TextUtils;

/* renamed from: com.netease.htprotect.OO〇8.〇〇, reason: contains not printable characters */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class C0661 {
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static int m507O8oO888(byte[] bArr, byte[] bArr2, int i) {
        int length = bArr.length;
        if (bArr != null && bArr2 != null && bArr.length != 0 && bArr2.length != 0) {
            if (length > bArr.length) {
                length = bArr.length;
            }
            while (i < length) {
                if (bArr[i] == bArr2[0] && bArr2.length + i < length) {
                    int i2 = 1;
                    while (i2 < bArr2.length && bArr[i + i2] == bArr2[i2]) {
                        i2++;
                    }
                    if (i2 == bArr2.length) {
                        return i;
                    }
                }
                i++;
            }
        }
        return -1;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static int m508O8oO888(byte[] bArr, byte[] bArr2, int i, int i2) {
        if (bArr != null && bArr2 != null && bArr.length != 0 && bArr2.length != 0) {
            if (i2 > bArr.length) {
                i2 = bArr.length;
            }
            while (i < i2) {
                if (bArr[i] == bArr2[0] && bArr2.length + i < i2) {
                    int i3 = 1;
                    while (i3 < bArr2.length && bArr[i + i3] == bArr2[i3]) {
                        i3++;
                    }
                    if (i3 == bArr2.length) {
                        return i;
                    }
                }
                i++;
            }
        }
        return -1;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static boolean m509O8oO888(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 36) {
            return false;
        }
        return str.matches("^[0-9A-Fa-f]{8}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{12}$");
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static boolean m510Ooo(String str) {
        return (TextUtils.isEmpty(str) || str.length() < 16 || str.startsWith("00000000")) ? false : true;
    }
}
