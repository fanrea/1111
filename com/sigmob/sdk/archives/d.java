package com.sigmob.sdk.archives;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d {
    public static final String a = "ar";
    public static final String b = "cpio";
    public static final String c = "dump";
    public static final String d = "jar";
    public static final String e = "zip";
    private static final String f = "tar";

    public c a(final InputStream in) throws b, IOException {
        if (in == null) {
            throw new IllegalArgumentException("Stream must not be null.");
        }
        if (!in.markSupported()) {
            throw new IllegalArgumentException("Mark is not supported.");
        }
        byte[] bArr = new byte[12];
        in.mark(12);
        try {
            in.read(bArr);
            in.reset();
            in.mark(32);
            in.read(new byte[32]);
            in.reset();
            byte[] bArr2 = new byte[512];
            in.mark(512);
            int i = in.read(bArr2);
            in.reset();
            if (com.sigmob.sdk.archives.tar.b.a(bArr2, i)) {
                return new com.sigmob.sdk.archives.tar.b(in);
            }
            new com.sigmob.sdk.archives.tar.b(new ByteArrayInputStream(bArr2)).a();
            return new com.sigmob.sdk.archives.tar.b(in);
        } catch (IOException e2) {
            throw new b("Could not use reset and mark operations.", e2);
        }
    }

    public c a(final String archiverName, final InputStream in) throws b {
        if (archiverName == null) {
            throw new IllegalArgumentException("Archivername must not be null.");
        }
        if (in == null) {
            throw new IllegalArgumentException("InputStream must not be null.");
        }
        if (f.equalsIgnoreCase(archiverName)) {
            return new com.sigmob.sdk.archives.tar.b(in);
        }
        throw new b("Archiver: " + archiverName + " not found.");
    }
}
