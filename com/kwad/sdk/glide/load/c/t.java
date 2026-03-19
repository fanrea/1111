package com.kwad.sdk.glide.load.c;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class t implements com.kwad.sdk.glide.load.a<InputStream> {
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b bQO;

    @Override // com.kwad.sdk.glide.load.a
    public final /* synthetic */ boolean a(InputStream inputStream, File file, com.kwad.sdk.glide.load.f fVar) {
        return b(inputStream, file);
    }

    public t(com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.bQO = bVar;
    }

    private boolean b(InputStream inputStream, File file) throws Throwable {
        byte[] bArr = (byte[]) this.bQO.a(65536, byte[].class);
        boolean z = false;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                while (true) {
                    try {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, i);
                    } catch (IOException e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        if (Log.isLoggable("StreamEncoder", 3)) {
                            Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                        this.bQO.put(bArr);
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                        this.bQO.put(bArr);
                        throw th;
                    }
                }
                z = true;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream2);
            } catch (IOException e2) {
                e = e2;
            }
            this.bQO.put(bArr);
            return z;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
