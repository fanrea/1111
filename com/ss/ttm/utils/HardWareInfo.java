package com.ss.ttm.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import com.component.c.c;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class HardWareInfo {
    private static final int ATOM = 1;
    public static final int CPU_FAMILY_ARM = 1;
    public static final int CPU_FAMILY_MIPS = 3;
    public static final int CPU_FAMILY_UNKNOWN = 0;
    public static final int CPU_FAMILY_X86 = 2;
    private static final int NEON = 0;
    private static int[] mArmArchitecture = new int[3];
    private static int mCpuType;

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006f, code lost:
    
        com.ss.ttm.utils.HardWareInfo.mArmArchitecture[0] = 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int[] getCpuInfo() throws java.io.IOException {
        /*
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch: java.lang.Exception -> Ldd
            java.lang.String r1 = "/proc/cpuinfo"
            r0.<init>(r1)     // Catch: java.lang.Exception -> Ldd
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> Ldd
            r1.<init>(r0)     // Catch: java.lang.Exception -> Ldd
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Exception -> Ldd
            r2.<init>(r1)     // Catch: java.lang.Exception -> Ldd
            java.lang.String r3 = "processor"
            java.lang.String r4 = "features"
            java.lang.String r5 = "model name"
        L17:
            java.lang.String r6 = r2.readLine()     // Catch: java.lang.Throwable -> Ld2
            if (r6 != 0) goto L1f
            goto Lc8
        L1f:
            java.lang.String r7 = "\t"
            java.lang.String r8 = ""
            java.lang.String r6 = r6.replaceAll(r7, r8)     // Catch: java.lang.Throwable -> Ld2
            java.util.Locale r7 = java.util.Locale.US     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r6 = r6.toLowerCase(r7)     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r7 = ":"
            java.lang.String[] r6 = r6.split(r7)     // Catch: java.lang.Throwable -> Ld2
            int r7 = r6.length     // Catch: java.lang.Throwable -> Ld2
            r8 = 2
            if (r7 == r8) goto L38
            goto L17
        L38:
            r7 = 0
            r9 = r6[r7]     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r9 = r9.trim()     // Catch: java.lang.Throwable -> Ld2
            r10 = 1
            r6 = r6[r10]     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r6 = r6.trim()     // Catch: java.lang.Throwable -> Ld2
            if (r6 == 0) goto L17
            if (r9 != 0) goto L4b
            goto L17
        L4b:
            int r11 = r9.compareTo(r3)     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r12 = "intel"
            if (r11 != 0) goto L74
            java.lang.String r9 = "armv"
            boolean r9 = r6.contains(r9)     // Catch: java.lang.Throwable -> Ld2
            if (r9 != 0) goto L6f
            java.lang.String r9 = "aarch64"
            boolean r9 = r6.contains(r9)     // Catch: java.lang.Throwable -> Ld2
            if (r9 == 0) goto L64
            goto L6f
        L64:
            boolean r6 = r6.contains(r12)     // Catch: java.lang.Throwable -> Ld2
            if (r6 == 0) goto L17
            int[] r3 = com.ss.ttm.utils.HardWareInfo.mArmArchitecture     // Catch: java.lang.Throwable -> Ld2
            r3[r7] = r8     // Catch: java.lang.Throwable -> Ld2
            goto Lc8
        L6f:
            int[] r3 = com.ss.ttm.utils.HardWareInfo.mArmArchitecture     // Catch: java.lang.Throwable -> Ld2
            r3[r7] = r10     // Catch: java.lang.Throwable -> Ld2
            goto Lc8
        L74:
            int r11 = r9.compareToIgnoreCase(r4)     // Catch: java.lang.Throwable -> Ld2
            if (r11 != 0) goto Lab
            java.lang.String r8 = "neon"
            boolean r8 = r6.contains(r8)     // Catch: java.lang.Throwable -> Ld2
            if (r8 != 0) goto La5
            java.lang.String r8 = "thumb"
            boolean r8 = r6.contains(r8)     // Catch: java.lang.Throwable -> Ld2
            if (r8 != 0) goto La5
            java.lang.String r8 = "vfpv"
            boolean r8 = r6.contains(r8)     // Catch: java.lang.Throwable -> Ld2
            if (r8 != 0) goto La5
            java.lang.String r8 = "asimd"
            boolean r8 = r6.contains(r8)     // Catch: java.lang.Throwable -> Ld2
            if (r8 != 0) goto La5
            java.lang.String r8 = "simd"
            boolean r6 = r6.contains(r8)     // Catch: java.lang.Throwable -> Ld2
            if (r6 == 0) goto L17
        La5:
            int[] r6 = com.ss.ttm.utils.HardWareInfo.mArmArchitecture     // Catch: java.lang.Throwable -> Ld2
            r6[r7] = r10     // Catch: java.lang.Throwable -> Ld2
            goto L17
        Lab:
            int r9 = r9.compareToIgnoreCase(r5)     // Catch: java.lang.Throwable -> Ld2
            if (r9 != 0) goto L17
            boolean r9 = r6.contains(r12)     // Catch: java.lang.Throwable -> Ld2
            if (r9 == 0) goto Lbc
            int[] r3 = com.ss.ttm.utils.HardWareInfo.mArmArchitecture     // Catch: java.lang.Throwable -> Ld2
            r3[r7] = r8     // Catch: java.lang.Throwable -> Ld2
            goto Lc8
        Lbc:
            java.lang.String r8 = "arm"
            boolean r6 = r6.contains(r8)     // Catch: java.lang.Throwable -> Ld2
            if (r6 == 0) goto L17
            int[] r3 = com.ss.ttm.utils.HardWareInfo.mArmArchitecture     // Catch: java.lang.Throwable -> Ld2
            r3[r7] = r10     // Catch: java.lang.Throwable -> Ld2
        Lc8:
            r2.close()     // Catch: java.lang.Exception -> Ldd
            r1.close()     // Catch: java.lang.Exception -> Ldd
            r0.close()     // Catch: java.lang.Exception -> Ldd
            goto Le1
        Ld2:
            r3 = move-exception
            r2.close()     // Catch: java.lang.Exception -> Ldd
            r1.close()     // Catch: java.lang.Exception -> Ldd
            r0.close()     // Catch: java.lang.Exception -> Ldd
            throw r3     // Catch: java.lang.Exception -> Ldd
        Ldd:
            r0 = move-exception
            r0.printStackTrace()
        Le1:
            int[] r0 = com.ss.ttm.utils.HardWareInfo.mArmArchitecture
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttm.utils.HardWareInfo.getCpuInfo():int[]");
    }

    public static int[] getCpuArchitecture() throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/cpuinfo");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    String[] strArrSplit = line.replace("\t", "").split(":");
                    if (strArrSplit.length == 2) {
                        String strTrim = strArrSplit[0].trim();
                        String strTrim2 = strArrSplit[1].trim();
                        if (strTrim.compareTo("Processor") == 0) {
                            StringBuilder sb = new StringBuilder();
                            for (int iIndexOf = strTrim2.indexOf("ARMv") + 4; iIndexOf < strTrim2.length(); iIndexOf++) {
                                String str = strTrim2.charAt(iIndexOf) + "";
                                if (!str.matches("\\d")) {
                                    break;
                                }
                                sb.append(str);
                            }
                            int[] iArr = mArmArchitecture;
                            iArr[0] = 1;
                            iArr[1] = Integer.parseInt(sb.toString());
                        } else if (strTrim.compareToIgnoreCase("Features") == 0) {
                            if (strTrim2.contains("neon")) {
                                mArmArchitecture[2] = 0;
                            }
                        } else if (strTrim.compareToIgnoreCase("model name") == 0) {
                            if (strTrim2.contains("Intel")) {
                                int[] iArr2 = mArmArchitecture;
                                iArr2[0] = 2;
                                iArr2[2] = 1;
                            }
                        } else if (strTrim.compareToIgnoreCase("cpu family") == 0) {
                            mArmArchitecture[1] = Integer.parseInt(strTrim2);
                        }
                    }
                } finally {
                    bufferedReader.close();
                    inputStreamReader.close();
                    fileInputStream.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mArmArchitecture;
    }

    private static boolean isAndroidJB2() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private static long getDirectoryAvailableSize(String str) {
        long blockSize;
        long availableBlocks;
        try {
            StatFs statFs = new StatFs(str);
            if (isAndroidJB2()) {
                blockSize = statFs.getBlockSizeLong();
                availableBlocks = statFs.getAvailableBlocksLong();
            } else {
                blockSize = statFs.getBlockSize();
                availableBlocks = statFs.getAvailableBlocks();
            }
            return blockSize * availableBlocks;
        } catch (IllegalArgumentException unused) {
            return -1L;
        }
    }

    private static long getDirectoryTotalSize(String str) {
        long blockSize;
        long blockCount;
        try {
            StatFs statFs = new StatFs(str);
            if (isAndroidJB2()) {
                blockSize = statFs.getBlockSizeLong();
                blockCount = statFs.getBlockCountLong();
            } else {
                blockSize = statFs.getBlockSize();
                blockCount = statFs.getBlockCount();
            }
            return blockSize * blockCount;
        } catch (IllegalArgumentException unused) {
            return -1L;
        }
    }

    private static long getTotalStorageSize(Context context) {
        if (context == null || Environment.getDataDirectory() == null) {
            return -1L;
        }
        return getDirectoryTotalSize(context.getFilesDir().getParent());
    }

    private static long getAvailableStorageSize(Context context) {
        if (context == null || Environment.getDataDirectory() == null) {
            return -1L;
        }
        return getDirectoryAvailableSize(context.getFilesDir().getParent());
    }

    public static long[] getSDCardSize(Context context) {
        long[] jArr = new long[2];
        if (c.a.equals(Environment.getExternalStorageState())) {
            long availableStorageSize = getAvailableStorageSize(context);
            jArr[0] = getTotalStorageSize(context);
            jArr[1] = availableStorageSize;
        }
        return jArr;
    }

    public static long getProcessCpuInfo() throws Throwable {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/stat")), 1000);
            try {
                String line = bufferedReader2.readLine();
                bufferedReader2.close();
                String[] strArrSplit = line.split(" ");
                try {
                    bufferedReader2.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    return Long.parseLong(strArrSplit[13]) + Long.parseLong(strArrSplit[14]) + Long.parseLong(strArrSplit[15]) + Long.parseLong(strArrSplit[16]);
                } catch (ArrayIndexOutOfBoundsException unused) {
                    return 0L;
                }
            } catch (IOException unused2) {
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                return 0L;
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException unused3) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static int getCpuFamily() throws IOException {
        if (mCpuType == 0) {
            getCpuInfo();
            mCpuType = mArmArchitecture[0];
        }
        return mCpuType;
    }
}
