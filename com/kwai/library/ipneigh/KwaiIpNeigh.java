package com.kwai.library.ipneigh;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class KwaiIpNeigh {
    private static final String TAG = "KwaiIpNeigh";

    private static native int getARPTableFromJni(int i);

    private static native int getARPTableFromJni2(int i);

    KwaiIpNeigh() {
    }

    static {
        System.loadLibrary("ipneigh-android");
    }

    public static String j(String str, boolean z) {
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream;
        int iDetachFd;
        String line;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe = ParcelFileDescriptor.createPipe();
            ParcelFileDescriptor parcelFileDescriptor = parcelFileDescriptorArrCreatePipe[0];
            ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptorArrCreatePipe[1];
            autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
            iDetachFd = parcelFileDescriptor2.detachFd();
        } catch (Throwable th) {
            th.printStackTrace();
            Log.e(TAG, "getARPResult exception:" + th.getMessage());
        }
        if ((z ? getARPTableFromJni2(iDetachFd) : getARPTableFromJni(iDetachFd)) != 0) {
            Log.e(TAG, "ARP table reading failed, are you using targetSdk 32 and an Android 13 device?");
            return "";
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(autoCloseInputStream, StandardCharsets.UTF_8));
        do {
            line = bufferedReader.readLine();
            if (line == null) {
                return "";
            }
        } while (!aJ(line, str));
        return line;
    }

    private static boolean aJ(String str, String str2) {
        if (str == null) {
            return false;
        }
        String[] strArrSplit = str.split("\\s+");
        if (strArrSplit.length < 2) {
            return false;
        }
        return strArrSplit[0].equals(str2);
    }
}
