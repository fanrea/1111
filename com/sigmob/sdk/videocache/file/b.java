package com.sigmob.sdk.videocache.file;

import com.kuaishou.weapon.p0.t;
import com.sigmob.sdk.videocache.q;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b implements com.sigmob.sdk.videocache.c {
    private static final String b = ".download";
    public File a;
    private final a c;
    private RandomAccessFile d;

    public b(File file) throws q {
        this(file, new i());
    }

    public b(File file, a diskUsage) throws q {
        try {
            if (diskUsage == null) {
                throw new NullPointerException();
            }
            this.c = diskUsage;
            d.a(file.getParentFile());
            boolean zExists = file.exists();
            this.a = zExists ? file : new File(file.getParentFile(), file.getName() + b);
            this.d = new RandomAccessFile(this.a, zExists ? t.k : "rw");
        } catch (IOException e) {
            throw new q("Error using file " + file + " as disc cache", e);
        }
    }

    private boolean a(File file) {
        return file.getName().endsWith(b);
    }

    @Override // com.sigmob.sdk.videocache.c
    public synchronized int a(byte[] buffer, long offset, int length) throws q {
        try {
            this.d.seek(offset);
        } catch (IOException e) {
            throw new q(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(length), Long.valueOf(offset), Long.valueOf(a()), Integer.valueOf(buffer.length)), e);
        }
        return this.d.read(buffer, 0, length);
    }

    @Override // com.sigmob.sdk.videocache.c
    public synchronized long a() throws q {
        try {
        } catch (IOException e) {
            throw new q("Error reading length of file " + this.a, e);
        }
        return (int) this.d.length();
    }

    @Override // com.sigmob.sdk.videocache.c
    public synchronized void a(byte[] data, int length) throws q {
        try {
            if (d()) {
                throw new q("Error append cache: cache file " + this.a + " is completed!");
            }
            this.d.seek(a());
            this.d.write(data, 0, length);
        } catch (IOException e) {
            throw new q(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(length), this.d, Integer.valueOf(data.length)), e);
        }
    }

    @Override // com.sigmob.sdk.videocache.c
    public synchronized void b() throws q {
        try {
            this.d.close();
            this.c.a(this.a);
        } catch (IOException e) {
            throw new q("Error closing file " + this.a, e);
        }
    }

    @Override // com.sigmob.sdk.videocache.c
    public synchronized void c() throws q {
        if (d()) {
            return;
        }
        b();
        File file = new File(this.a.getParentFile(), this.a.getName().substring(0, this.a.getName().length() - 9));
        if (!this.a.renameTo(file)) {
            throw new q("Error renaming file " + this.a + " to " + file + " for completion!");
        }
        this.a = file;
        try {
            this.d = new RandomAccessFile(this.a, t.k);
            this.c.a(this.a);
        } catch (IOException e) {
            throw new q("Error opening " + this.a + " as disc cache", e);
        }
    }

    @Override // com.sigmob.sdk.videocache.c
    public synchronized boolean d() {
        return !a(this.a);
    }

    public File e() {
        return this.a;
    }
}
