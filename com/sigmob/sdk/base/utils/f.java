package com.sigmob.sdk.base.utils;

import android.os.AsyncTask;
import com.czhj.sdk.logger.SigmobLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class f {

    private static class a extends AsyncTask<String, Void, Boolean> {
        private final File a;
        private final File b;
        private final b c;

        a(final File inputFile, final File outputDir, b listener) {
            this.a = outputDir;
            this.b = inputFile;
            this.c = listener;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String[] params) {
            try {
                f.a(this.a, this.b);
                return true;
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean result) {
            b bVar = this.c;
            if (bVar != null) {
                bVar.a(result.booleanValue());
            }
        }
    }

    interface b {
        void a(boolean success);
    }

    public static List<File> a(final File inputFile, final File outputDir) throws com.sigmob.sdk.archives.b, IOException {
        GZIPInputStream gZIPInputStream;
        com.sigmob.sdk.archives.d dVar;
        com.sigmob.sdk.archives.c cVarA;
        SigmobLog.i(String.format("Untaring %s to dir %s.", inputFile.getAbsolutePath(), outputDir.getAbsolutePath()));
        LinkedList linkedList = new LinkedList();
        FileInputStream fileInputStream = new FileInputStream(inputFile);
        try {
            gZIPInputStream = new GZIPInputStream(fileInputStream);
        } catch (Throwable th) {
            fileInputStream.close();
            fileInputStream = new FileInputStream(inputFile);
            SigmobLog.e(th.getMessage());
            gZIPInputStream = null;
        }
        if (gZIPInputStream != null) {
            dVar = new com.sigmob.sdk.archives.d();
            cVarA = dVar.a("tar", gZIPInputStream);
        } else {
            dVar = new com.sigmob.sdk.archives.d();
            cVarA = dVar.a("tar", fileInputStream);
        }
        com.sigmob.sdk.archives.tar.b bVar = (com.sigmob.sdk.archives.tar.b) cVarA;
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }
        while (true) {
            com.sigmob.sdk.archives.tar.a aVar = (com.sigmob.sdk.archives.tar.a) bVar.a();
            if (aVar == null) {
                bVar.close();
                if (gZIPInputStream != null) {
                    gZIPInputStream.close();
                }
                fileInputStream.close();
                return linkedList;
            }
            File file = new File(outputDir, aVar.a());
            if (aVar.c()) {
                SigmobLog.i(String.format("Attempting to write output directory %s.", file.getAbsolutePath()));
                if (file.exists()) {
                    continue;
                } else {
                    SigmobLog.i(String.format("Attempting to create output directory %s.", file.getAbsolutePath()));
                    if (!file.mkdirs()) {
                        throw new IllegalStateException(String.format("Couldn't create directory %s.", file.getAbsolutePath()));
                    }
                }
            } else {
                SigmobLog.i(String.format("Creating output file %s.", file.getAbsolutePath()));
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                com.sigmob.sdk.archives.utils.c.a(bVar, fileOutputStream);
                fileOutputStream.close();
            }
            linkedList.add(file);
        }
    }

    public static void a(File inputFile, File outputDir, b unCompressAsyncTaskListener) {
        new a(inputFile, outputDir, unCompressAsyncTaskListener);
        SigmobLog.d("uncompressTarGzipAsync()  inputFile = [" + inputFile + "], outputDir = [" + outputDir + "], unCompressAsyncTaskListener = [" + unCompressAsyncTaskListener + "]");
    }

    public static byte[] a(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return null;
        }
        return a(str.getBytes("utf-8"));
    }

    private static byte[] a(byte[] data) throws IOException {
        if (data == null || data.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(data);
        gZIPOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static String b(String str) throws IOException {
        return (str == null || str.length() == 0) ? str : new String(b(str.getBytes("utf-8")));
    }

    private static byte[] b(byte[] data) throws IOException {
        if (data == null || data.length == 0) {
            return data;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr = new byte[256];
        while (true) {
            int i = gZIPInputStream.read(bArr);
            if (i < 0) {
                gZIPInputStream.close();
                byteArrayInputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }
}
