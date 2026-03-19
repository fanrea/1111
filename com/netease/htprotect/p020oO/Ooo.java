package com.netease.htprotect.p020oO;

import android.content.Context;
import com.netease.htprotect.p020oO.p021O8oO888.O8;

/* renamed from: com.netease.htprotect.〇oO.〇Ooo, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class Ooo implements O8oO888 {
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static String m1141O8oO888(String str, String str2) {
        char[] charArray = str2.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            stringBuffer.append((char) (str.charAt(i) ^ charArray[i % charArray.length]));
        }
        return stringBuffer.toString();
    }

    @Override // com.netease.htprotect.p020oO.O8oO888
    /* renamed from: O8〇oO8〇88 */
    public final int mo1091O8oO888(Context context) throws Throwable {
        if (context == null) {
            return 0;
        }
        char[] charArray = "1?@\u0011".toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 12; i++) {
            stringBuffer.append((char) ("\u007fZ4Yeo2~EZ#e".charAt(i) ^ charArray[i % charArray.length]));
        }
        O8.m1121O8oO888(context, stringBuffer.toString(), null, null);
        return 1;
    }

    @Override // com.netease.htprotect.p020oO.O8oO888
    /* renamed from: 〇Ooo */
    public final void mo1092Ooo(Context context) throws Throwable {
        char[] charArray = "1?@\u0011".toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 12; i++) {
            stringBuffer.append((char) ("\u007fZ4Yeo2~EZ#e".charAt(i) ^ charArray[i % charArray.length]));
        }
        O8.m1121O8oO888(context, stringBuffer.toString(), null, null);
    }
}
