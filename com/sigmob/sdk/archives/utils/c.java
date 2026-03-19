package com.sigmob.sdk.archives.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c {
    private c() {
    }

    public static long a(final InputStream input, final OutputStream output) throws IOException {
        return a(input, output, 8024);
    }

    public static long a(final InputStream input, final OutputStream output, int buffersize) throws IOException {
        byte[] bArr = new byte[buffersize];
        long j = 0;
        while (true) {
            int i = input.read(bArr);
            if (-1 == i) {
                return j;
            }
            output.write(bArr, 0, i);
            j += i;
        }
    }
}
