package com.bytedance.sdk.component.an.b.d.d;

import com.bytedance.sdk.component.utils.mq;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class d implements Closeable {
    private final File an;
    private final File c;
    private final int gb;
    private final File h;
    final ExecutorService hc;
    private int k;
    private Writer mq;
    private final int tc;
    private long tt;
    private final File u;
    static final Pattern d = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final OutputStream b = new OutputStream() { // from class: com.bytedance.sdk.component.an.b.d.d.d.2
        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
        }
    };
    private long mk = 0;
    private final LinkedHashMap<String, hc> uo = new LinkedHashMap<>(0, 0.75f, true);
    private long e = -1;
    private long cb = 0;
    private final Callable<Void> w = new Callable<Void>() { // from class: com.bytedance.sdk.component.an.b.d.d.d.1
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (d.this) {
                if (d.this.mq == null) {
                    return null;
                }
                d.this.h();
                if (d.this.u()) {
                    d.this.c();
                    d.this.k = 0;
                }
                return null;
            }
        }
    };

    private d(File file, int i, int i2, long j, ExecutorService executorService) {
        this.c = file;
        this.gb = i;
        this.u = new File(file, "journal");
        this.an = new File(file, "journal.tmp");
        this.h = new File(file, "journal.bkp");
        this.tc = i2;
        this.tt = j;
        this.hc = executorService;
    }

    public static d d(File file, int i, int i2, long j, ExecutorService executorService) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                d(file2, file3, false);
            }
        }
        d dVar = new d(file, i, i2, j, executorService);
        if (dVar.u.exists()) {
            try {
                dVar.hc();
                dVar.b();
                return dVar;
            } catch (IOException e) {
                mq.hc("DiskLruCache ", file + " is corrupt: " + e.getMessage() + ", removing");
                dVar.delete();
            }
        }
        file.mkdirs();
        d dVar2 = new d(file, i, i2, j, executorService);
        dVar2.c();
        return dVar2;
    }

    private void hc() throws IOException {
        com.bytedance.sdk.component.an.b.d.d.b bVar = new com.bytedance.sdk.component.an.b.d.d.b(new FileInputStream(this.u), c.d);
        try {
            String strD = bVar.d();
            String strD2 = bVar.d();
            String strD3 = bVar.d();
            String strD4 = bVar.d();
            String strD5 = bVar.d();
            if (!"libcore.io.DiskLruCache".equals(strD) || !"1".equals(strD2) || !Integer.toString(this.gb).equals(strD3) || !Integer.toString(this.tc).equals(strD4) || !"".equals(strD5)) {
                throw new IOException("unexpected journal header: [" + strD + ", " + strD2 + ", " + strD4 + ", " + strD5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    c(bVar.d());
                    i++;
                } catch (EOFException unused) {
                    this.k = i - this.uo.size();
                    if (bVar.hc()) {
                        c();
                    } else {
                        this.mq = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.u, true), c.d));
                    }
                    com.bytedance.sdk.component.an.b.b.hc.d(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.an.b.b.hc.d(bVar);
            throw th;
        }
    }

    private void c(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.uo.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        hc hcVar = this.uo.get(strSubstring);
        if (hcVar == null) {
            hcVar = new hc(strSubstring);
            this.uo.put(strSubstring, hcVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            hcVar.c = true;
            hcVar.u = null;
            hcVar.d(strArrSplit);
            return;
        }
        if (iIndexOf2 != -1 || iIndexOf != 5 || !str.startsWith("DIRTY")) {
            if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
            }
            return;
        }
        hcVar.u = new C0270d(hcVar);
    }

    private void b() throws IOException {
        d(this.an);
        Iterator<hc> it = this.uo.values().iterator();
        while (it.hasNext()) {
            hc next = it.next();
            int i = 0;
            if (next.u == null) {
                while (i < this.tc) {
                    this.mk += next.b[i];
                    i++;
                }
            } else {
                next.u = null;
                while (i < this.tc) {
                    d(next.d(i));
                    d(next.hc(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c() throws IOException {
        Writer writer = this.mq;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.an), c.d));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.gb));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.tc));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (hc hcVar : this.uo.values()) {
                if (hcVar.u != null) {
                    bufferedWriter.write("DIRTY " + hcVar.hc + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + hcVar.hc + hcVar.d() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.u.exists()) {
                d(this.u, this.h, true);
            }
            d(this.an, this.u, false);
            this.h.delete();
            this.mq = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.u, true), c.d));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    private static void d(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void d(File file, File file2, boolean z) throws IOException {
        if (z) {
            d(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public synchronized b d(String str) throws IOException {
        InputStream inputStream;
        an();
        u(str);
        hc hcVar = this.uo.get(str);
        if (hcVar == null) {
            return null;
        }
        if (!hcVar.c) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.tc];
        for (int i = 0; i < this.tc; i++) {
            try {
                inputStreamArr[i] = new FileInputStream(hcVar.d(i));
            } catch (FileNotFoundException unused) {
                for (int i2 = 0; i2 < this.tc && (inputStream = inputStreamArr[i2]) != null; i2++) {
                    com.bytedance.sdk.component.an.b.b.hc.d(inputStream);
                }
                return null;
            }
        }
        this.k++;
        this.mq.append((CharSequence) ("READ " + str + '\n'));
        if (u()) {
            this.hc.submit(this.w);
        }
        return new b(str, hcVar.an, inputStreamArr, hcVar.b);
    }

    public C0270d hc(String str) throws IOException {
        return d(str, -1L);
    }

    private synchronized C0270d d(String str, long j) throws IOException {
        an();
        u(str);
        hc hcVar = this.uo.get(str);
        if (j != -1 && (hcVar == null || hcVar.an != j)) {
            return null;
        }
        if (hcVar == null) {
            hcVar = new hc(str);
            this.uo.put(str, hcVar);
        } else if (hcVar.u != null) {
            return null;
        }
        C0270d c0270d = new C0270d(hcVar);
        hcVar.u = c0270d;
        this.mq.write("DIRTY " + str + '\n');
        this.mq.flush();
        return c0270d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(C0270d c0270d, boolean z) throws IOException {
        hc hcVar = c0270d.hc;
        if (hcVar.u != c0270d) {
            throw new IllegalStateException();
        }
        if (z && !hcVar.c) {
            for (int i = 0; i < this.tc; i++) {
                if (!c0270d.b[i]) {
                    c0270d.hc();
                    throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
                }
                if (!hcVar.hc(i).exists()) {
                    c0270d.hc();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.tc; i2++) {
            File fileHc = hcVar.hc(i2);
            if (z) {
                if (fileHc.exists()) {
                    File fileD = hcVar.d(i2);
                    fileHc.renameTo(fileD);
                    long j = hcVar.b[i2];
                    long length = fileD.length();
                    hcVar.b[i2] = length;
                    this.mk = (this.mk - j) + length;
                }
            } else {
                d(fileHc);
            }
        }
        this.k++;
        hcVar.u = null;
        if (hcVar.c | z) {
            hcVar.c = true;
            this.mq.write("CLEAN " + hcVar.hc + hcVar.d() + '\n');
            if (z) {
                long j2 = this.cb;
                this.cb = 1 + j2;
                hcVar.an = j2;
            }
        } else {
            this.uo.remove(hcVar.hc);
            this.mq.write("REMOVE " + hcVar.hc + '\n');
        }
        this.mq.flush();
        if (this.mk > this.tt || u()) {
            this.hc.submit(this.w);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u() {
        int i = this.k;
        return i >= 2000 && i >= this.uo.size();
    }

    public synchronized boolean b(String str) throws IOException {
        an();
        u(str);
        hc hcVar = this.uo.get(str);
        if (hcVar != null && hcVar.u == null) {
            for (int i = 0; i < this.tc; i++) {
                File fileD = hcVar.d(i);
                if (fileD.exists() && !fileD.delete()) {
                    throw new IOException("failed to delete ".concat(String.valueOf(fileD)));
                }
                this.mk -= hcVar.b[i];
                hcVar.b[i] = 0;
            }
            this.k++;
            this.mq.append((CharSequence) ("REMOVE " + str + '\n'));
            this.uo.remove(str);
            if (u()) {
                this.hc.submit(this.w);
            }
            return true;
        }
        return false;
    }

    private void an() {
        if (this.mq == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void d() throws IOException {
        an();
        h();
        this.mq.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.mq == null) {
            return;
        }
        Iterator it = new ArrayList(this.uo.values()).iterator();
        while (it.hasNext()) {
            hc hcVar = (hc) it.next();
            if (hcVar.u != null) {
                hcVar.u.hc();
            }
        }
        h();
        this.mq.close();
        this.mq = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() throws IOException {
        long j = this.tt;
        long j2 = this.e;
        if (j2 >= 0) {
            j = j2;
        }
        while (this.mk > j) {
            b(this.uo.entrySet().iterator().next().getKey());
        }
        this.e = -1L;
    }

    public void d(long j) {
        this.e = j;
        this.hc.submit(this.w);
    }

    public void delete() throws IOException {
        close();
        c.d(this.c);
    }

    private void u(String str) {
        if (!d.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    public final class b implements Closeable {
        private final long b;
        private final InputStream[] c;
        private final String hc;
        private final long[] u;

        private b(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.hc = str;
            this.b = j;
            this.c = inputStreamArr;
            this.u = jArr;
        }

        public InputStream d(int i) {
            return this.c[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            for (InputStream inputStream : this.c) {
                com.bytedance.sdk.component.an.b.b.hc.d(inputStream);
            }
        }
    }

    /* renamed from: com.bytedance.sdk.component.an.b.d.d.d$d, reason: collision with other inner class name */
    public final class C0270d {
        private final boolean[] b;
        private boolean c;
        private final hc hc;
        private boolean u;

        private C0270d(hc hcVar) {
            this.hc = hcVar;
            this.b = hcVar.c ? null : new boolean[d.this.tc];
        }

        public OutputStream d(int i) throws IOException {
            FileOutputStream fileOutputStream;
            C0271d c0271d;
            if (i < 0 || i >= d.this.tc) {
                throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + d.this.tc);
            }
            synchronized (d.this) {
                if (this.hc.u != this) {
                    throw new IllegalStateException();
                }
                if (!this.hc.c) {
                    this.b[i] = true;
                }
                File fileHc = this.hc.hc(i);
                try {
                    fileOutputStream = new FileOutputStream(fileHc);
                } catch (FileNotFoundException unused) {
                    d.this.c.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(fileHc);
                    } catch (FileNotFoundException unused2) {
                        return d.b;
                    }
                }
                c0271d = new C0271d(fileOutputStream);
            }
            return c0271d;
        }

        public void d() throws IOException {
            if (this.c) {
                d.this.d(this, false);
                d.this.b(this.hc.hc);
            } else {
                d.this.d(this, true);
            }
            this.u = true;
        }

        public void hc() throws IOException {
            d.this.d(this, false);
        }

        /* renamed from: com.bytedance.sdk.component.an.b.d.d.d$d$d, reason: collision with other inner class name */
        private class C0271d extends FilterOutputStream {
            private C0271d(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) throws IOException {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    C0270d.this.c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) throws IOException {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C0270d.this.c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    C0270d.this.c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() throws IOException {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    C0270d.this.c = true;
                }
            }
        }
    }

    private final class hc {
        private long an;
        private final long[] b;
        private boolean c;
        private final String hc;
        private C0270d u;

        private hc(String str) {
            this.hc = str;
            this.b = new long[d.this.tc];
        }

        public String d() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.b) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(String[] strArr) throws IOException {
            if (strArr.length != d.this.tc) {
                throw hc(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.b[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw hc(strArr);
                }
            }
        }

        private IOException hc(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File d(int i) {
            return new File(d.this.c, this.hc + "." + i);
        }

        public File hc(int i) {
            return new File(d.this.c, this.hc + "." + i + ".tmp");
        }
    }
}
