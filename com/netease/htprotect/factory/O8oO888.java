package com.netease.htprotect.factory;

import android.content.Context;
import com.netease.htprotect.HTProtectConfig;
import com.netease.htprotect.callback.HTPCallback;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.netease.htprotect.factory.O8〇oO8〇88, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class O8oO888 {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private JNIFactory f51O8oO888 = JNIFactory.m518O8oO888();

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private String m519Ooo(int i, String str) {
        return this.f51O8oO888.w3facf96be4b4fd19(i, str);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final int m520O8oO888(String str, String str2, String str3, String str4, String str5, int i, String str6) {
        return this.f51O8oO888.t76euy9fu8bv485zh(str, str2, str3, str4, str5, i, str6);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final InputStream m521O8oO888(InputStream inputStream) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i <= 0) {
                    return new ByteArrayInputStream(this.f51O8oO888.e3aa07afb863c1kva(byteArrayOutputStream.toByteArray()));
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (Exception unused) {
            return inputStream;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final String m522O8oO888(int i, String str) {
        return this.f51O8oO888.d0f149b4da6ec477(i, str);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final String m523O8oO888(String str, int i) {
        return this.f51O8oO888.d8f5300ec791da421(str, i);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void m524O8oO888() {
        this.f51O8oO888.f190da6241bff18bf();
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void m525O8oO888(Context context, String str, HTPCallback hTPCallback, HTProtectConfig hTProtectConfig) {
        this.f51O8oO888.hccd63688a790ca65(context, str, hTPCallback, hTProtectConfig);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void m526O8oO888(boolean z, int i, int i2, int i3, int i4, int i5) {
        this.f51O8oO888.u233ace17d63ca9e(z, i, i2, i3, i4, i5);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final byte[] m527O8oO888(String str) {
        return this.f51O8oO888.aebd1811194e82d9(str);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final byte[] m528O8oO888(String str, int i, boolean z) {
        return this.f51O8oO888.r25d273c7ad4065c1(str, i, z);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final byte[] m529O8oO888(byte[] bArr, int i, int i2, boolean z, int i3, boolean z2) {
        return this.f51O8oO888.r25d273c7ad4065c3(bArr, i, i2, z, i3, z2);
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    public final String m530O8(String str, int i) {
        return this.f51O8oO888.r316e12523620efb7(str, i);
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public final String m531Ooo(String str, int i) {
        return this.f51O8oO888.e9edd62242ad7aecf(str, i);
    }
}
