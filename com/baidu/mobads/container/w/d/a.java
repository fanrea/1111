package com.baidu.mobads.container.w.d;

import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.system.Os;
import android.system.OsConstants;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static final int a = -1;
    public static int b = -1;
    private static final int c = 100;
    private long d = 0;
    private long e = SystemClock.uptimeMillis();

    public static int a() {
        if (b != -1) {
            return b;
        }
        try {
            int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
            if (iAvailableProcessors > 0) {
                b = iAvailableProcessors;
                return b;
            }
        } catch (Throwable th) {
        }
        int iD = d();
        b = iD;
        return iD;
    }

    private static int d() {
        File[] fileArrListFiles;
        try {
            File file = new File("/sys/devices/system/cpu/");
            if (file.exists() && (fileArrListFiles = file.listFiles(new b())) != null) {
                return fileArrListFiles.length;
            }
            return 0;
        } catch (Throwable th) {
            return 0;
        }
    }

    public static long b() {
        if (Build.VERSION.SDK_INT >= 21) {
            return Os.sysconf(OsConstants._SC_CLK_TCK);
        }
        return 100L;
    }

    public float c() throws IOException {
        RandomAccessFile randomAccessFile;
        Throwable th;
        try {
            randomAccessFile = new RandomAccessFile("/proc/" + Process.myPid() + "/stat", t.k);
        } catch (Throwable th2) {
            randomAccessFile = null;
            th = th2;
        }
        try {
            String[] strArrSplit = randomAccessFile.readLine().split(" ");
            long j = Long.parseLong(strArrSplit[13]) + Long.parseLong(strArrSplit[14]);
            long j2 = j - this.d;
            long jUptimeMillis = SystemClock.uptimeMillis();
            float fB = ((jUptimeMillis - this.e) / 1000.0f) * b();
            this.d = j;
            this.e = jUptimeMillis;
            float fA = ((j2 / fB) * 100.0f) / a();
            try {
                randomAccessFile.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return fA;
        } catch (Throwable th3) {
            th = th3;
            try {
                th.printStackTrace();
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                        return 0.0f;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return 0.0f;
                    }
                }
                return 0.0f;
            } catch (Throwable th4) {
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                throw th4;
            }
        }
    }
}
