package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an {
    public static File d(Context context, boolean z, String str, String str2) {
        String strConcat;
        String strHc = hc(context);
        if (z) {
            strConcat = d(context) + "-" + str;
        } else {
            strConcat = "/".concat(String.valueOf(str));
        }
        String str3 = ((strHc == null || strHc.endsWith(File.separator)) ? "" : strHc + File.separator) + strConcat;
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str3, str2);
    }

    public static File hc(Context context, boolean z, String str, String str2) {
        String strB = b(context);
        if (z) {
            str = d(context) + "-" + str;
        }
        if (strB != null && !strB.endsWith(File.separator)) {
            strB = strB + File.separator;
        }
        String str3 = strB + str;
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str3, str2);
    }

    public static File d(Context context, boolean z, String str) {
        String strHc = hc(context);
        if (z) {
            str = d(context) + "-" + str;
        }
        File file = new File(((strHc == null || strHc.endsWith(File.separator)) ? "" : strHc + File.separator) + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File hc(Context context, boolean z, String str) {
        String absolutePath = com.bytedance.sdk.openadsdk.api.plugin.hc.hc(context).getAbsolutePath();
        if (z) {
            str = d(context) + "-" + str;
        }
        if (absolutePath != null && !absolutePath.endsWith(File.separator)) {
            absolutePath = absolutePath + File.separator;
        }
        File file = new File(absolutePath + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String hc(android.content.Context r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            r1 = 0
            java.lang.String r2 = "mounted"
            java.lang.String r3 = android.os.Environment.getExternalStorageState()     // Catch: java.lang.Throwable -> L19
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Throwable -> L19
            if (r2 != 0) goto L17
            boolean r2 = android.os.Environment.isExternalStorageRemovable()     // Catch: java.lang.Throwable -> L19
            if (r2 != 0) goto L1d
        L17:
            r1 = 1
            goto L1d
        L19:
            r2 = move-exception
            com.bytedance.sdk.component.utils.mq.d(r2)
        L1d:
            if (r1 == 0) goto L26
            java.io.File r1 = com.bytedance.sdk.openadsdk.api.plugin.hc.b(r4)     // Catch: java.lang.Throwable -> L24
            goto L27
        L24:
            r1 = r0
            goto L2d
        L26:
            r1 = r0
        L27:
            if (r1 != 0) goto L2d
            java.io.File r1 = com.bytedance.sdk.openadsdk.api.plugin.hc.hc(r4)     // Catch: java.lang.Throwable -> L2d
        L2d:
            if (r1 != 0) goto L30
            return r0
        L30:
            java.lang.String r4 = r1.getPath()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.utils.an.hc(android.content.Context):java.lang.String");
    }

    private static String b(Context context) {
        File fileHc;
        if (context == null || (fileHc = com.bytedance.sdk.openadsdk.api.plugin.hc.hc(context)) == null) {
            return null;
        }
        return fileHc.getPath();
    }

    public static List<File> d(File file) {
        LinkedList linkedList = new LinkedList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return linkedList;
        }
        List<File> listAsList = Arrays.asList(fileArrListFiles);
        Collections.sort(listAsList, new d(null));
        return listAsList;
    }

    public static void hc(File file) throws IOException {
        if (file.exists()) {
            mq.c("splashLoadAd", "update file modify time");
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(jCurrentTimeMillis)) {
                return;
            }
            u(file);
            if (file.lastModified() < jCurrentTimeMillis) {
                mq.hc("Files", "Last modified date " + new Date(file.lastModified()) + " is not set for file " + file.getAbsolutePath());
            }
        }
    }

    public static void b(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            try {
                file.delete();
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    b(file2);
                } else {
                    try {
                        file2.delete();
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
        try {
            file.delete();
        } catch (Throwable unused3) {
        }
    }

    private static void u(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        long j;
        long length = file.length();
        if (length == 0) {
            an(file);
            return;
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rwd");
            j = length - 1;
        } catch (Throwable unused) {
        }
        try {
            randomAccessFile.seek(j);
            byte b = randomAccessFile.readByte();
            randomAccessFile.seek(j);
            randomAccessFile.write(b);
            randomAccessFile.close();
        } catch (Throwable unused2) {
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
        }
    }

    private static void an(File file) throws IOException {
        if (!file.delete() || !file.createNewFile()) {
            throw new IOException("Error recreate zero-size file ".concat(String.valueOf(file)));
        }
    }

    private static final class d implements Comparator<File> {
        private int d(long j, long j2) {
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }

        private d() {
        }

        /* synthetic */ d(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Comparator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return d(file.lastModified(), file2.lastModified());
        }
    }

    public static byte[] c(File file) {
        FileInputStream fileInputStream;
        if (file != null && file.isFile() && file.exists() && file.canRead() && file.length() > 0) {
            try {
                Long lValueOf = Long.valueOf(file.length());
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[lValueOf.intValue()];
                    if (fileInputStream.read(bArr) == lValueOf.longValue()) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused) {
                        }
                        return bArr;
                    }
                } catch (Throwable unused2) {
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return null;
                }
            } catch (Throwable unused3) {
                fileInputStream = null;
            }
            try {
                fileInputStream.close();
            } catch (Throwable unused4) {
            }
        }
        return null;
    }

    /* renamed from: com.bytedance.sdk.component.utils.an$1, reason: invalid class name */
    static class AnonymousClass1 implements Comparator<File> {
        @Override // java.util.Comparator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            long jLastModified = file2.lastModified() - file.lastModified();
            if (jLastModified == 0) {
                return 0;
            }
            return jLastModified < 0 ? -1 : 1;
        }
    }

    public static String d(Context context) {
        String strD = yo.d(context);
        return (TextUtils.isEmpty(strD) || !strD.contains(":")) ? strD : strD.replace(":", "-");
    }
}
