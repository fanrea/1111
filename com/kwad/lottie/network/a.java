package com.kwad.lottie.network;

import android.content.Context;
import androidx.core.util.Pair;
import com.kwad.lottie.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final class a {
    private final Context bpl;
    private final String url;

    a(Context context, String str) {
        this.bpl = context.getApplicationContext();
        this.url = str;
    }

    final Pair<FileExtension, InputStream> Ss() {
        FileExtension fileExtension;
        try {
            File fileDs = ds(this.url);
            if (fileDs == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(fileDs);
            if (fileDs.getAbsolutePath().endsWith(".zip")) {
                fileExtension = FileExtension.Zip;
            } else {
                fileExtension = FileExtension.Json;
            }
            c.de("Cache hit for " + this.url + " at " + fileDs.getAbsolutePath());
            return new Pair<>(fileExtension, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    final File a(InputStream inputStream, FileExtension fileExtension) throws Throwable {
        FileOutputStream fileOutputStream;
        Throwable th;
        File file = new File(this.bpl.getCacheDir(), a(this.url, fileExtension, true));
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th2) {
            fileOutputStream = null;
            th = th2;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    fileOutputStream.flush();
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                    return file;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
            throw th;
        }
    }

    final void a(FileExtension fileExtension) {
        File file = new File(this.bpl.getCacheDir(), a(this.url, fileExtension, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean zRenameTo = file.renameTo(file2);
        c.de("Copying temp file to real file (" + file2 + ")");
        if (zRenameTo) {
            return;
        }
        c.df("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }

    private File ds(String str) {
        File file = new File(this.bpl.getCacheDir(), a(str, FileExtension.Json, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(this.bpl.getCacheDir(), a(str, FileExtension.Zip, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private static String a(String str, FileExtension fileExtension, boolean z) {
        return "lottie_cache_" + str.replaceAll("\\W+", "") + (z ? fileExtension.extension : fileExtension.tempExtension());
    }
}
