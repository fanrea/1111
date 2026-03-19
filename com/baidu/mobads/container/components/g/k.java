package com.baidu.mobads.container.components.g;

import com.baidu.mobads.container.util.bq;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class k {
    private final i a;
    private final InputStream b;
    private final int c;
    private final long d;
    private final String e;
    private final int f;
    private final String g;

    private k(a aVar) {
        this.b = aVar.b;
        this.a = aVar.a;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
    }

    public i a() {
        return this.a;
    }

    public int b() {
        return this.c;
    }

    public long c() {
        return this.d;
    }

    public String d() {
        return this.g;
    }

    public String e() throws IOException {
        if (this.b == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(this.c, 32));
            byte[] bArr = new byte[128];
            while (true) {
                int i = this.b.read(bArr);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toString();
                }
            }
        } finally {
            this.b.close();
        }
    }

    public InputStream f() {
        return this.b;
    }

    public void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                bq.a().c(th);
            }
        }
    }

    public String g() {
        return this.e;
    }

    public int h() {
        return this.f;
    }

    public static class a {
        private i a;
        private InputStream b;
        private int c = -1;
        private long d = -1;
        private String e = "";
        private int f;
        private String g;

        public k a() {
            return new k(this);
        }

        public a a(i iVar) {
            this.a = iVar;
            return this;
        }

        public a a(InputStream inputStream) {
            this.b = inputStream;
            return this;
        }

        public a a(int i) {
            this.c = i;
            return this;
        }

        public a a(long j) {
            this.d = j;
            return this;
        }

        public a a(String str) {
            this.e = str;
            return this;
        }

        public a b(int i) {
            this.f = i;
            return this;
        }

        public a b(String str) {
            this.g = str;
            return this;
        }
    }
}
