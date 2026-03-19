package com.ss.ttm.utils;

import android.content.Context;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AVErrorInfo {
    public static final String CRASH = "crash";
    public static final String ERROR = "error";
    private static StringBuilder PHONE_INFO;

    public static final void setupPhoneInfo(Context context, StringBuilder sb) throws Throwable {
        String[] version = VersionInfo.getVersion();
        if (version != null) {
            sb.append(String.format("version:%s,%s,%s\r\n", version[0], version[1], version[2])).append("\r\n");
        }
        long[] romMemroy = MemoryInfo.getRomMemroy();
        if (romMemroy != null) {
            sb.append(String.format(Locale.US, "rom memory totle:%d,availe:%d\r\n", Long.valueOf(romMemroy[0]), Long.valueOf(romMemroy[1]))).append("\r\n");
        }
        long availMemory = MemoryInfo.getAvailMemory(context);
        sb.append(String.format(Locale.US, "ram memory totle:%d,availe:%d\r\n", Long.valueOf(MemoryInfo.getTolalMemory()), Long.valueOf(availMemory))).append("\r\n");
        long[] sDCardSize = HardWareInfo.getSDCardSize(context);
        if (sDCardSize != null) {
            sb.append(String.format(Locale.US, "sdcard totle:%d,availe:%d\r\n", Long.valueOf(sDCardSize[0]), Long.valueOf(sDCardSize[1]))).append("\r\n");
        }
    }

    public static void setupErrorInfo(Context context, StringBuilder sb, String str, String str2, String str3) throws Throwable {
        if (PHONE_INFO == null) {
            StringBuilder sb2 = new StringBuilder();
            PHONE_INFO = sb2;
            setupPhoneInfo(context, sb2);
        }
        sb.append((CharSequence) PHONE_INFO);
        sb.append("\r\n").append(str).append(":").append(str2);
    }
}
