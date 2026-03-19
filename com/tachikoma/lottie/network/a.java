package com.tachikoma.lottie.network;

import android.content.Context;
import android.support.v4.d.i;
import com.tachikoma.lottie.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a {
    private final Context Nd;
    private final String url;

    a(Context context, String str) {
        this.Nd = context.getApplicationContext();
        this.url = str;
    }

    final i<FileExtension, InputStream> lP() {
        FileExtension fileExtension;
        try {
            File fileE = e(this.Nd, this.url);
            if (fileE == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(fileE);
            if (fileE.getAbsolutePath().endsWith(".zip")) {
                fileExtension = FileExtension.ZIP;
            } else {
                fileExtension = FileExtension.JSON;
            }
            c.Q("Cache hit for " + this.url + " at " + fileE.getAbsolutePath());
            return new i(fileExtension, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    final File a(InputStream inputStream, FileExtension fileExtension) throws IOException {
        File file = new File(this.Nd.getCacheDir(), a(this.url, fileExtension, true));
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

    final void a(FileExtension fileExtension) {
        File file = new File(this.Nd.getCacheDir(), a(this.url, fileExtension, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean zRenameTo = file.renameTo(file2);
        c.Q("Copying temp file to real file (" + file2 + ")");
        if (zRenameTo) {
            return;
        }
        c.R("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }

    private static File e(Context context, String str) {
        File file = new File(context.getCacheDir(), a(str, FileExtension.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(context.getCacheDir(), a(str, FileExtension.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private static String a(String str, FileExtension fileExtension, boolean z) {
        StringBuilder sb = new StringBuilder("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? fileExtension.tempExtension() : fileExtension.extension);
        return sb.toString();
    }
}
