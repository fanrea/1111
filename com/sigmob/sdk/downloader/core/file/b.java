package com.sigmob.sdk.downloader.core.file;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.sigmob.sdk.downloader.core.file.a;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b implements com.sigmob.sdk.downloader.core.file.a {
    final ParcelFileDescriptor a;
    final BufferedOutputStream b;
    final FileOutputStream c;
    private final FileChannel d;

    public static class a implements a.InterfaceC0735a {
        @Override // com.sigmob.sdk.downloader.core.file.a.InterfaceC0735a
        public com.sigmob.sdk.downloader.core.file.a a(Context context, Uri uri, int flushBufferSize) throws FileNotFoundException {
            return new b(context, uri, flushBufferSize);
        }

        @Override // com.sigmob.sdk.downloader.core.file.a.InterfaceC0735a
        public com.sigmob.sdk.downloader.core.file.a a(Context context, File file, int flushBufferSize) throws FileNotFoundException {
            return new b(context, Uri.fromFile(file), flushBufferSize);
        }

        @Override // com.sigmob.sdk.downloader.core.file.a.InterfaceC0735a
        public boolean a() {
            return true;
        }
    }

    public b(Context context, Uri uri, int bufferSize) throws FileNotFoundException {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "rw");
        if (parcelFileDescriptorOpenFileDescriptor == null) {
            throw new FileNotFoundException("result of " + uri + " is null!");
        }
        this.a = parcelFileDescriptorOpenFileDescriptor;
        FileOutputStream fileOutputStream = new FileOutputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
        this.c = fileOutputStream;
        this.d = fileOutputStream.getChannel();
        this.b = new BufferedOutputStream(fileOutputStream, bufferSize);
    }

    b(FileChannel channel, ParcelFileDescriptor pdf, FileOutputStream fos, BufferedOutputStream out) {
        this.d = channel;
        this.a = pdf;
        this.c = fos;
        this.b = out;
    }

    @Override // com.sigmob.sdk.downloader.core.file.a
    public void a() throws IOException {
        this.b.close();
        this.c.close();
        this.a.close();
    }

    @Override // com.sigmob.sdk.downloader.core.file.a
    public void a(long offset) throws IOException {
        this.d.position(offset);
    }

    @Override // com.sigmob.sdk.downloader.core.file.a
    public void a(byte[] b, int off, int len) throws IOException {
        this.b.write(b, off, len);
    }

    @Override // com.sigmob.sdk.downloader.core.file.a
    public void b() throws IOException {
        this.b.flush();
        this.a.getFileDescriptor().sync();
    }

    @Override // com.sigmob.sdk.downloader.core.file.a
    public void b(long newLength) {
        StringBuilder sb;
        StringBuilder sbAppend;
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Os.posix_fallocate(this.a.getFileDescriptor(), 0L, newLength);
                return;
            } catch (Throwable th) {
                th = th;
                if (th instanceof ErrnoException) {
                    ErrnoException errnoException = th;
                    if (errnoException.errno == OsConstants.ENOSYS || errnoException.errno == OsConstants.ENOTSUP) {
                        com.sigmob.sdk.downloader.core.c.a("DownloadUriOutputStream", "fallocate() not supported; falling back to ftruncate()");
                        try {
                            Os.ftruncate(this.a.getFileDescriptor(), newLength);
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            sb = new StringBuilder();
                            sbAppend = sb.append("It can't pre-allocate length(").append(newLength).append(") on the sdk version(").append(Build.VERSION.SDK_INT).append("), because of ").append(th);
                            com.sigmob.sdk.downloader.core.c.a("DownloadUriOutputStream", sbAppend.toString());
                        }
                    }
                    return;
                }
                sb = new StringBuilder();
                sbAppend = sb.append("It can't pre-allocate length(").append(newLength).append(") on the sdk version(").append(Build.VERSION.SDK_INT).append("), because of ").append(th);
            }
        } else {
            sbAppend = new StringBuilder().append("It can't pre-allocate length(").append(newLength).append(") on the sdk version(").append(Build.VERSION.SDK_INT).append(")");
        }
        com.sigmob.sdk.downloader.core.c.a("DownloadUriOutputStream", sbAppend.toString());
    }
}
