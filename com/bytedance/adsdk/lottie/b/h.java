package com.bytedance.adsdk.lottie.b;

import android.util.Pair;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h {
    private final u d;

    public h(u uVar) {
        this.d = uVar;
    }

    Pair<b, InputStream> d(String str) {
        b bVar;
        try {
            File fileHc = hc(str);
            if (fileHc == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(fileHc);
            if (fileHc.getAbsolutePath().endsWith(".zip")) {
                bVar = b.ZIP;
            } else {
                bVar = b.JSON;
            }
            com.bytedance.adsdk.lottie.u.u.d("Cache hit for " + str + " at " + fileHc.getAbsolutePath());
            return new Pair<>(bVar, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    File d(String str, InputStream inputStream, b bVar) throws IOException {
        File file = new File(d(), d(str, bVar, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i != -1) {
                        fileOutputStream.write(bArr, 0, i);
                    } else {
                        fileOutputStream.flush();
                        return file;
                    }
                }
            } finally {
                fileOutputStream.close();
            }
        } finally {
            inputStream.close();
        }
    }

    void d(String str, b bVar) {
        File file = new File(d(), d(str, bVar, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean zRenameTo = file.renameTo(file2);
        com.bytedance.adsdk.lottie.u.u.d("Copying temp file to real file (" + file2 + ")");
        if (zRenameTo) {
            return;
        }
        com.bytedance.adsdk.lottie.u.u.hc("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }

    private File hc(String str) throws FileNotFoundException {
        File file = new File(d(), d(str, b.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(d(), d(str, b.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private File d() {
        File fileD = this.d.d();
        if (fileD.isFile()) {
            fileD.delete();
        }
        if (!fileD.exists()) {
            fileD.mkdirs();
        }
        return fileD;
    }

    private static String d(String str, b bVar, boolean z) {
        return "lottie_cache_" + str.replaceAll("\\W+", "") + (z ? bVar.d() : bVar.b);
    }
}
