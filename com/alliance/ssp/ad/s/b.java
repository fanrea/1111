package com.alliance.ssp.ad.s;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: DiskLruCache.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class b implements Closeable {
    public final File a;
    public final File b;
    public final File c;
    public final int d;
    public final long e;
    public final int f;
    public Writer h;
    public int j;
    public long g = 0;
    public final LinkedHashMap<String, c> i = new LinkedHashMap<>(0, 0.75f, true);
    public long k = 0;
    public final ExecutorService l = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    public final Callable<Void> m = new a();

    /* compiled from: DiskLruCache.java */
    public class a implements Callable<Void> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() {
            synchronized (b.this) {
                b bVar = b.this;
                if (bVar.h == null) {
                    return null;
                }
                bVar.g();
                if (b.this.c()) {
                    b.this.f();
                    b.this.j = 0;
                }
                return null;
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.alliance.ssp.ad.s.b$b, reason: collision with other inner class name */
    public final class C0097b {
        public final c a;
        public boolean b;

        public C0097b(c cVar) {
            this.a = cVar;
        }

        public void b() {
            if (!this.b) {
                b.a(b.this, this, true);
            } else {
                b.a(b.this, this, false);
                b.this.d(this.a.a);
            }
        }

        public OutputStream a(int i) {
            a aVar;
            synchronized (b.this) {
                if (this.a.d != this) {
                    throw new IllegalStateException();
                }
                aVar = new a(new FileOutputStream(this.a.b(i)));
            }
            return aVar;
        }

        /* compiled from: DiskLruCache.java */
        /* renamed from: com.alliance.ssp.ad.s.b$b$a */
        public class a extends FilterOutputStream {
            public a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C0097b.this.b = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() throws IOException {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C0097b.this.b = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) throws IOException {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    C0097b.this.b = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) throws IOException {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C0097b.this.b = true;
                }
            }
        }

        public void a() {
            b.a(b.this, this, false);
        }
    }

    /* compiled from: DiskLruCache.java */
    public final class c {
        public final String a;
        public final long[] b;
        public boolean c;
        public C0097b d;
        public long e;

        public c(String str) {
            this.a = str;
            this.b = new long[b.this.f];
        }

        public File b(int i) {
            return new File(b.this.a, this.a + "." + i + ".tmp");
        }

        public String a() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.b) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        public File a(int i) {
            return new File(b.this.a, this.a + "." + i);
        }
    }

    /* compiled from: DiskLruCache.java */
    public final class d implements Closeable {
        public final InputStream[] a;

        public d(b bVar, String str, long j, InputStream[] inputStreamArr) {
            this.a = inputStreamArr;
        }

        public InputStream a(int i) {
            return this.a[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            for (InputStream inputStream : this.a) {
                b.a((Closeable) inputStream);
            }
        }
    }

    static {
        Charset.forName("UTF-8");
    }

    public b(File file, int i, int i2, long j) {
        this.a = file;
        this.d = i;
        this.b = new File(file, "journal");
        this.c = new File(file, "journal.tmp");
        this.f = i2;
        this.e = j;
    }

    public static void a(b bVar, C0097b c0097b, boolean z) {
        synchronized (bVar) {
            c cVar = c0097b.a;
            if (cVar.d != c0097b) {
                throw new IllegalStateException();
            }
            if (z && !cVar.c) {
                for (int i = 0; i < bVar.f; i++) {
                    if (!cVar.b(i).exists()) {
                        c0097b.a();
                        throw new IllegalStateException("edit didn't create file " + i);
                    }
                }
            }
            for (int i2 = 0; i2 < bVar.f; i2++) {
                File fileB = cVar.b(i2);
                if (!z) {
                    b(fileB);
                } else if (fileB.exists()) {
                    File fileA = cVar.a(i2);
                    fileB.renameTo(fileA);
                    long j = cVar.b[i2];
                    long length = fileA.length();
                    cVar.b[i2] = length;
                    bVar.g = (bVar.g - j) + length;
                }
            }
            bVar.j++;
            cVar.d = null;
            if (cVar.c || z) {
                cVar.c = true;
                bVar.h.write("CLEAN " + cVar.a + cVar.a() + '\n');
                if (z) {
                    long j2 = bVar.k;
                    bVar.k = 1 + j2;
                    cVar.e = j2;
                }
            } else {
                bVar.i.remove(cVar.a);
                bVar.h.write("REMOVE " + cVar.a + '\n');
            }
            if (bVar.g > bVar.e || bVar.c()) {
                bVar.l.submit(bVar.m);
            }
        }
    }

    public static void b(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public final void c(String str) throws IOException {
        String[] strArrSplit = str.split(" ");
        if (strArrSplit.length < 2) {
            throw new IOException("unexpected journal line: " + str);
        }
        String str2 = strArrSplit[1];
        if (strArrSplit[0].equals("REMOVE") && strArrSplit.length == 2) {
            this.i.remove(str2);
            return;
        }
        c cVar = this.i.get(str2);
        if (cVar == null) {
            cVar = new c(str2);
            this.i.put(str2, cVar);
        }
        if (!strArrSplit[0].equals("CLEAN") || strArrSplit.length != this.f + 2) {
            if (strArrSplit[0].equals("DIRTY") && strArrSplit.length == 2) {
                cVar.d = new C0097b(cVar);
                return;
            } else {
                if (!strArrSplit[0].equals("READ") || strArrSplit.length != 2) {
                    throw new IOException("unexpected journal line: " + str);
                }
                return;
            }
        }
        cVar.c = true;
        cVar.d = null;
        int length = strArrSplit.length;
        int length2 = strArrSplit.length;
        if (2 > length) {
            throw new IllegalArgumentException();
        }
        if (2 > length2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i = length - 2;
        int iMin = Math.min(i, length2 - 2);
        Object[] objArr = (Object[]) Array.newInstance(strArrSplit.getClass().getComponentType(), i);
        System.arraycopy(strArrSplit, 2, objArr, 0, iMin);
        String[] strArr = (String[]) objArr;
        if (strArr.length != b.this.f) {
            throw new IOException(com.alliance.ssp.ad.a.b.a("unexpected journal line: ").append(Arrays.toString(strArr)).toString());
        }
        for (int i2 = 0; i2 < strArr.length; i2++) {
            try {
                cVar.b[i2] = Long.parseLong(strArr[i2]);
            } catch (NumberFormatException unused) {
                throw new IOException(com.alliance.ssp.ad.a.b.a("unexpected journal line: ").append(Arrays.toString(strArr)).toString());
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.h == null) {
            return;
        }
        Iterator it = new ArrayList(this.i.values()).iterator();
        while (it.hasNext()) {
            C0097b c0097b = ((c) it.next()).d;
            if (c0097b != null) {
                c0097b.a();
            }
        }
        g();
        this.h.close();
        this.h = null;
    }

    public final void d() throws IOException {
        b(this.c);
        Iterator<c> it = this.i.values().iterator();
        while (it.hasNext()) {
            c next = it.next();
            int i = 0;
            if (next.d == null) {
                while (i < this.f) {
                    this.g += next.b[i];
                    i++;
                }
            } else {
                next.d = null;
                while (i < this.f) {
                    b(next.a(i));
                    b(next.b(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    public final void e() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.b), 8192);
        try {
            String strA = a((InputStream) bufferedInputStream);
            String strA2 = a((InputStream) bufferedInputStream);
            String strA3 = a((InputStream) bufferedInputStream);
            String strA4 = a((InputStream) bufferedInputStream);
            String strA5 = a((InputStream) bufferedInputStream);
            if (!"libcore.io.DiskLruCache".equals(strA) || !"1".equals(strA2) || !Integer.toString(this.d).equals(strA3) || !Integer.toString(this.f).equals(strA4) || !"".equals(strA5)) {
                throw new IOException("unexpected journal header: [" + strA + ", " + strA2 + ", " + strA4 + ", " + strA5 + "]");
            }
            while (true) {
                try {
                    c(a((InputStream) bufferedInputStream));
                } catch (EOFException unused) {
                    return;
                }
            }
        } finally {
            a((Closeable) bufferedInputStream);
        }
    }

    public final synchronized void f() {
        Writer writer = this.h;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.c), 8192);
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.d));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (c cVar : this.i.values()) {
            if (cVar.d != null) {
                bufferedWriter.write(com.alliance.ssp.ad.a.b.a("DIRTY ").append(cVar.a).append('\n').toString());
            } else {
                bufferedWriter.write(com.alliance.ssp.ad.a.b.a("CLEAN ").append(cVar.a).append(cVar.a()).append('\n').toString());
            }
        }
        bufferedWriter.close();
        this.c.renameTo(this.b);
        this.h = new BufferedWriter(new FileWriter(this.b, true), 8192);
    }

    public final void g() {
        while (this.g > this.e) {
            d(this.i.entrySet().iterator().next().getKey());
        }
    }

    public synchronized d b(String str) {
        a();
        e(str);
        c cVar = this.i.get(str);
        if (cVar == null) {
            return null;
        }
        if (!cVar.c) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.f];
        for (int i = 0; i < this.f; i++) {
            try {
                inputStreamArr[i] = new FileInputStream(cVar.a(i));
            } catch (FileNotFoundException unused) {
                return null;
            }
        }
        this.j++;
        this.h.append((CharSequence) ("READ " + str + '\n'));
        if (c()) {
            this.l.submit(this.m);
        }
        return new d(this, str, cVar.e, inputStreamArr);
    }

    public synchronized boolean d(String str) {
        a();
        e(str);
        c cVar = this.i.get(str);
        if (cVar != null && cVar.d == null) {
            for (int i = 0; i < this.f; i++) {
                File fileA = cVar.a(i);
                if (fileA.delete()) {
                    long j = this.g;
                    long[] jArr = cVar.b;
                    this.g = j - jArr[i];
                    jArr[i] = 0;
                } else {
                    throw new IOException("failed to delete " + fileA);
                }
            }
            this.j++;
            this.h.append((CharSequence) ("REMOVE " + str + '\n'));
            this.i.remove(str);
            if (c()) {
                this.l.submit(this.m);
            }
            return true;
        }
        return false;
    }

    public synchronized void b() {
        a();
        g();
        this.h.flush();
    }

    public final void e(String str) {
        if (str.contains(" ") || str.contains("\n") || str.contains("\r")) {
            throw new IllegalArgumentException("keys must not contain spaces or newlines: \"" + str + "\"");
        }
    }

    public static String a(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder(80);
        while (true) {
            int i = inputStream.read();
            if (i == -1) {
                throw new EOFException();
            }
            if (i == 10) {
                int length = sb.length();
                if (length > 0) {
                    int i2 = length - 1;
                    if (sb.charAt(i2) == '\r') {
                        sb.setLength(i2);
                    }
                }
                return sb.toString();
            }
            sb.append((char) i);
        }
    }

    public final boolean c() {
        int i = this.j;
        return i >= 2000 && i >= this.i.size();
    }

    public static void a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static void a(File file) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    a(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete file: " + file2);
                }
            }
            return;
        }
        throw new IllegalArgumentException("not a directory: " + file);
    }

    public static b a(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 > 0) {
            b bVar = new b(file, i, i2, j);
            if (bVar.b.exists()) {
                try {
                    bVar.e();
                    bVar.d();
                    bVar.h = new BufferedWriter(new FileWriter(bVar.b, true), 8192);
                    return bVar;
                } catch (IOException unused) {
                    bVar.close();
                    a(bVar.a);
                }
            }
            file.mkdirs();
            b bVar2 = new b(file, i, i2, j);
            bVar2.f();
            return bVar2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    public C0097b a(String str) {
        synchronized (this) {
            a();
            e(str);
            c cVar = this.i.get(str);
            if (cVar == null) {
                cVar = new c(str);
                this.i.put(str, cVar);
            } else if (cVar.d != null) {
                return null;
            }
            C0097b c0097b = new C0097b(cVar);
            cVar.d = c0097b;
            this.h.write("DIRTY " + str + '\n');
            this.h.flush();
            return c0097b;
        }
    }

    public final void a() {
        if (this.h == null) {
            throw new IllegalStateException("cache is closed");
        }
    }
}
