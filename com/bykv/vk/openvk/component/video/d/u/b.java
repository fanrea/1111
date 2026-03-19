package com.bykv.vk.openvk.component.video.d.u;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    public static long d(String str, String str2) {
        File fileB = b(str, str2);
        if (fileB.exists()) {
            return fileB.length();
        }
        File fileHc = hc(str, str2);
        if (fileHc.exists()) {
            return fileHc.length();
        }
        return 0L;
    }

    public static File hc(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2 + ".temp");
    }

    public static File b(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2);
    }

    public static boolean d(RandomAccessFile randomAccessFile, byte[] bArr, long j, int i) throws IOException {
        try {
            randomAccessFile.seek(j);
            randomAccessFile.write(bArr, 0, i);
            return true;
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.an.b.d("VideoFilesUtils", "append failed", th);
            return false;
        }
    }
}
