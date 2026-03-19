package com.sigmob.sdk.downloader.core.file;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface a {

    /* renamed from: com.sigmob.sdk.downloader.core.file.a$a, reason: collision with other inner class name */
    public interface InterfaceC0735a {
        a a(Context context, Uri uri, int flushBufferSize) throws FileNotFoundException;

        a a(Context context, File file, int flushBufferSize) throws FileNotFoundException;

        boolean a();
    }

    void a() throws IOException;

    void a(long offset) throws IOException;

    void a(byte[] b, int off, int len) throws IOException;

    void b() throws IOException;

    void b(long newLength) throws IOException;
}
