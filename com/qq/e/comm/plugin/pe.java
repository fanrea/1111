package com.qq.e.comm.plugin;

import android.text.TextUtils;
import android.util.Pair;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class pe {
    private final String a;
    private long b;
    private String c;
    private final File d;
    private RandomAccessFile e;
    private long f;
    private a g;

    /* compiled from: A */
    interface a {
        void a(boolean z);
    }

    private void c() {
        Pair<String, Long> pairC = fb.a().c(this.a);
        if (pairC != null) {
            this.c = (String) pairC.first;
            this.b = ((Long) pairC.second).longValue();
        }
    }

    public boolean g() {
        return fb.a().e(this.a);
    }

    pe(String str) throws vu {
        this.a = str;
        File fileD = fb.a().d(str);
        this.d = fileD;
        if (g()) {
            return;
        }
        qm$h$$ExternalSyntheticBackport0.m(fileD);
        try {
            this.e = new RandomAccessFile(fileD, com.kuaishou.weapon.p0.t.k);
            c();
        } catch (FileNotFoundException e) {
            throw new vu("Error opening connection, open file for " + str, e);
        }
    }

    public long h() {
        if (this.b <= 0) {
            c();
        }
        return this.b;
    }

    String d() {
        if (TextUtils.isEmpty(this.c)) {
            c();
        }
        return this.c;
    }

    public long a() throws IOException {
        return this.e.length();
    }

    boolean f() throws IOException {
        return a() == this.b;
    }

    public void b() throws IOException, vu {
        RandomAccessFile randomAccessFile = this.e;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException e) {
                throw new vu("Error closing file for " + this.a, e);
            }
        }
    }

    boolean e() throws IOException {
        File file = this.d;
        if (file != null && this.e != null) {
            long jA = a();
            if (this.f >= jA) {
                return false;
            }
            this.f = jA;
            return true;
        }
        qm$h$$ExternalSyntheticBackport0.m(file);
        qm$h$$ExternalSyntheticBackport0.m(this.e);
        return false;
    }

    public int a(byte[] bArr, long j, int i) throws IOException, vu {
        if (this.e != null) {
            if (g()) {
                a aVar = this.g;
                if (aVar != null) {
                    aVar.a(true);
                }
                throw new vu("File download error");
            }
            a aVar2 = this.g;
            if (aVar2 != null) {
                aVar2.a(false);
            }
            try {
                this.e.seek(j);
                return this.e.read(bArr, 0, i);
            } catch (IOException unused) {
                throw new vu("Error reading data from " + this.a + " read exception");
            }
        }
        throw new vu("Error reading data from " + this.a + " file is null");
    }

    void a(a aVar) {
        this.g = aVar;
    }
}
