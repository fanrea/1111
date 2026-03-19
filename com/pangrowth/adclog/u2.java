package com.pangrowth.adclog;

import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class u2 {
    public static String[] a() throws Throwable {
        BufferedReader bufferedReader;
        String[] strArr = {"", ""};
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader2, 8192);
            } catch (IOException unused) {
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
            try {
                String[] strArrSplit = bufferedReader.readLine().split("\\s+");
                for (int i = 2; i < strArrSplit.length; i++) {
                    strArr[0] = strArr[0] + strArrSplit[i] + " ";
                }
                strArr[1] = strArr[1] + bufferedReader.readLine().split("\\s+")[2];
                i.a(bufferedReader);
                i.a(fileReader2);
            } catch (IOException unused2) {
                fileReader = fileReader2;
                i.a(bufferedReader);
                i.a(fileReader);
                return strArr;
            } catch (Throwable th2) {
                th = th2;
                fileReader = fileReader2;
                i.a(bufferedReader);
                i.a(fileReader);
                throw th;
            }
        } catch (IOException unused3) {
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
        return strArr;
    }

    public static long[] b() {
        long[] jArr = new long[2];
        if (com.component.c.c.a.equals(Environment.getExternalStorageState())) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long blockSize = statFs.getBlockSize();
            long blockCount = statFs.getBlockCount();
            long availableBlocks = statFs.getAvailableBlocks();
            jArr[0] = ((blockCount * blockSize) / 1024) / 1024;
            jArr[1] = ((blockSize * availableBlocks) / 1024) / 1024;
        }
        return jArr;
    }

    public static String[] c() throws Throwable {
        BufferedReader bufferedReader;
        String[] strArr = {ILogConst.CACHE_PLAY_REASON_NULL, ILogConst.CACHE_PLAY_REASON_NULL, ILogConst.CACHE_PLAY_REASON_NULL, ILogConst.CACHE_PLAY_REASON_NULL};
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader("/proc/version");
            try {
                bufferedReader = new BufferedReader(fileReader2, 8192);
            } catch (IOException unused) {
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
            try {
                strArr[0] = bufferedReader.readLine().split("\\s+")[2];
                i.a(bufferedReader);
                i.a(fileReader2);
            } catch (IOException unused2) {
                fileReader = fileReader2;
                i.a(bufferedReader);
                i.a(fileReader);
                strArr[1] = Build.VERSION.RELEASE;
                strArr[2] = Build.MODEL;
                strArr[3] = Build.DISPLAY;
                return strArr;
            } catch (Throwable th2) {
                th = th2;
                fileReader = fileReader2;
                i.a(bufferedReader);
                i.a(fileReader);
                throw th;
            }
        } catch (IOException unused3) {
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
        strArr[1] = Build.VERSION.RELEASE;
        strArr[2] = Build.MODEL;
        strArr[3] = Build.DISPLAY;
        return strArr;
    }
}
