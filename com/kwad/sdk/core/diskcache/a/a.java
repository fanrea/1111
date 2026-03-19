package com.kwad.sdk.core.diskcache.a;

import com.kwad.sdk.utils.w;
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
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a implements Closeable {
    static final Pattern bAO = Pattern.compile("[a-z0-9_-]{1,64}");
    private static final OutputStream bBd = new OutputStream() { // from class: com.kwad.sdk.core.diskcache.a.a.3
        @Override // java.io.OutputStream
        public final void write(int i) {
        }
    };
    private final File bAP;
    private final File bAQ;
    private final File bAR;
    private final File bAS;
    private final int bAT;
    private int bAU;
    private final int bAV;
    private Writer bAX;
    private int bAZ;
    private long maxSize;
    private long size = 0;
    private int bAW = 0;
    private final LinkedHashMap<String, b> bAY = new LinkedHashMap<>(0, 0.75f, true);
    private long bBa = 0;
    final ThreadPoolExecutor bBb = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.core.diskcache.a.a.1
        private final AtomicInteger bin = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ksad-DiskLruCache-" + this.bin.getAndIncrement());
        }
    });
    private final Callable<Void> bBc = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.a.a.2
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: Zy, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (a.this) {
                if (a.this.bAX == null) {
                    return null;
                }
                a.this.trimToSize();
                a.this.ZD();
                if (a.this.ZC()) {
                    a.this.ZB();
                    a.a(a.this, 0);
                }
                return null;
            }
        }
    };

    static /* synthetic */ int a(a aVar, int i) {
        aVar.bAZ = 0;
        return 0;
    }

    private a(File file, int i, int i2, long j, int i3) {
        this.bAP = file;
        this.bAT = i;
        this.bAQ = new File(file, "journal");
        this.bAR = new File(file, "journal.tmp");
        this.bAS = new File(file, "journal.bkp");
        this.bAV = i2;
        this.maxSize = j;
        this.bAU = i3;
    }

    public static a a(File file, int i, int i2, long j) {
        return a(file, 1, 1, j, Integer.MAX_VALUE);
    }

    private static a a(File file, int i, int i2, long j, int i3) throws IOException {
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
                a(file2, file3, false);
            }
        }
        a aVar = new a(file, i, i2, j, Integer.MAX_VALUE);
        if (aVar.bAQ.exists()) {
            try {
                aVar.Zz();
                aVar.ZA();
                aVar.bAX = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aVar.bAQ, true), com.kwad.sdk.crash.utils.a.US_ASCII));
                return aVar;
            } catch (IOException e) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                aVar.delete();
            }
        }
        file.mkdirs();
        a aVar2 = new a(file, i, i2, j, Integer.MAX_VALUE);
        aVar2.ZB();
        return aVar2;
    }

    private void Zz() {
        com.kwad.sdk.core.diskcache.a.b bVar = new com.kwad.sdk.core.diskcache.a.b(new FileInputStream(this.bAQ), com.kwad.sdk.crash.utils.a.US_ASCII);
        try {
            String line = bVar.readLine();
            String line2 = bVar.readLine();
            String line3 = bVar.readLine();
            String line4 = bVar.readLine();
            String line5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(line) || !"1".equals(line2) || !Integer.toString(this.bAT).equals(line3) || !Integer.toString(this.bAV).equals(line4) || !"".equals(line5)) {
                throw new IOException("unexpected journal header: [" + line + ", " + line2 + ", " + line4 + ", " + line5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    eR(bVar.readLine());
                    i++;
                } catch (EOFException unused) {
                    this.bAZ = i - this.bAY.size();
                    com.kwad.sdk.crash.utils.b.closeQuietly(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(bVar);
            throw th;
        }
    }

    private void eR(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.bAY.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        b bVar = this.bAY.get(strSubstring);
        byte b2 = 0;
        if (bVar == null) {
            bVar = new b(this, strSubstring, b2);
            this.bAY.put(strSubstring, bVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            b.a(bVar, true);
            bVar.bBm = null;
            bVar.d(strArrSplit);
            return;
        }
        if (iIndexOf2 != -1 || iIndexOf != 5 || !str.startsWith("DIRTY")) {
            if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
            return;
        }
        bVar.bBm = new C0579a(this, bVar, b2);
    }

    private void ZA() throws IOException {
        p(this.bAR);
        Iterator<b> it = this.bAY.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i = 0;
            if (next.bBm == null) {
                while (i < this.bAV) {
                    this.size += next.bBk[i];
                    this.bAW++;
                    i++;
                }
            } else {
                next.bBm = null;
                while (i < this.bAV) {
                    p(next.fg(i));
                    p(next.fh(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ZB() {
        Writer writer = this.bAX;
        if (writer != null) {
            com.kwad.sdk.crash.utils.b.closeQuietly(writer);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.bAR), com.kwad.sdk.crash.utils.a.US_ASCII));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.bAT));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.bAV));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (b bVar : this.bAY.values()) {
                if (bVar.bBm != null) {
                    bufferedWriter.write("DIRTY " + bVar.key + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + bVar.key + bVar.ZF() + '\n');
                }
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedWriter);
            if (this.bAQ.exists()) {
                a(this.bAQ, this.bAS, true);
            }
            a(this.bAR, this.bAQ, false);
            this.bAS.delete();
            this.bAX = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.bAQ, true), com.kwad.sdk.crash.utils.a.US_ASCII));
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedWriter);
            throw th;
        }
    }

    private static void p(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            p(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public final synchronized c eS(String str) {
        InputStream inputStream;
        if (this.bAX == null) {
            return null;
        }
        eU(str);
        b bVar = this.bAY.get(str);
        if (bVar == null) {
            return null;
        }
        if (!bVar.bBl) {
            return null;
        }
        int i = this.bAV;
        File[] fileArr = new File[i];
        InputStream[] inputStreamArr = new InputStream[i];
        for (int i2 = 0; i2 < this.bAV; i2++) {
            try {
                File fileFg = bVar.fg(i2);
                fileArr[i2] = fileFg;
                inputStreamArr[i2] = new FileInputStream(fileFg);
            } catch (FileNotFoundException unused) {
                for (int i3 = 0; i3 < this.bAV && (inputStream = inputStreamArr[i3]) != null; i3++) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                }
                return null;
            }
        }
        this.bAZ++;
        this.bAX.append((CharSequence) ("READ " + str + '\n'));
        if (ZC()) {
            this.bBb.submit(this.bBc);
        }
        return new c(this, str, bVar.bBn, fileArr, inputStreamArr, bVar.bBk, (byte) 0);
    }

    public final C0579a eT(String str) {
        return f(str, -1L);
    }

    private synchronized C0579a f(String str, long j) {
        checkNotClosed();
        eU(str);
        b bVar = this.bAY.get(str);
        byte b2 = 0;
        if (bVar == null) {
            bVar = new b(this, str, b2);
            this.bAY.put(str, bVar);
        } else if (bVar.bBm != null) {
            return null;
        }
        C0579a c0579a = new C0579a(this, bVar, b2);
        bVar.bBm = c0579a;
        this.bAX.write("DIRTY " + str + '\n');
        this.bAX.flush();
        return c0579a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(C0579a c0579a, boolean z) {
        b bVar = c0579a.bBf;
        if (bVar.bBm != c0579a) {
            throw new IllegalStateException();
        }
        if (z && !bVar.bBl) {
            for (int i = 0; i < this.bAV; i++) {
                if (!c0579a.bBg[i]) {
                    c0579a.abort();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                }
                if (!bVar.fh(i).exists()) {
                    c0579a.abort();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.bAV; i2++) {
            File fileFh = bVar.fh(i2);
            if (z) {
                if (fileFh.exists()) {
                    File fileFg = bVar.fg(i2);
                    fileFh.renameTo(fileFg);
                    long j = bVar.bBk[i2];
                    long length = fileFg.length();
                    bVar.bBk[i2] = length;
                    this.size = (this.size - j) + length;
                    this.bAW++;
                }
            } else {
                p(fileFh);
            }
        }
        this.bAZ++;
        bVar.bBm = null;
        if (bVar.bBl | z) {
            b.a(bVar, true);
            this.bAX.write("CLEAN " + bVar.key + bVar.ZF() + '\n');
            if (z) {
                long j2 = this.bBa;
                this.bBa = 1 + j2;
                bVar.bBn = j2;
            }
        } else {
            this.bAY.remove(bVar.key);
            this.bAX.write("REMOVE " + bVar.key + '\n');
        }
        this.bAX.flush();
        if (this.size > this.maxSize || this.bAW > this.bAU || ZC()) {
            this.bBb.submit(this.bBc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ZC() {
        int i = this.bAZ;
        return i >= 2000 && i >= this.bAY.size();
    }

    public final synchronized boolean remove(String str) {
        checkNotClosed();
        eU(str);
        b bVar = this.bAY.get(str);
        if (bVar != null && bVar.bBm == null) {
            for (int i = 0; i < this.bAV; i++) {
                File fileFg = bVar.fg(i);
                if (fileFg.exists() && !fileFg.delete()) {
                    throw new IOException("failed to delete " + fileFg);
                }
                this.size -= bVar.bBk[i];
                this.bAW--;
                bVar.bBk[i] = 0;
            }
            this.bAZ++;
            this.bAX.append((CharSequence) ("REMOVE " + str + '\n'));
            this.bAY.remove(str);
            if (ZC()) {
                this.bBb.submit(this.bBc);
            }
            return true;
        }
        return false;
    }

    private void checkNotClosed() {
        if (this.bAX == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void flush() {
        checkNotClosed();
        trimToSize();
        ZD();
        this.bAX.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.bAX == null) {
            return;
        }
        Iterator it = new ArrayList(this.bAY.values()).iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.bBm != null) {
                bVar.bBm.abort();
            }
        }
        trimToSize();
        ZD();
        com.kwad.sdk.crash.utils.b.closeQuietly(this.bAX);
        this.bAX = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.maxSize) {
            remove(this.bAY.entrySet().iterator().next().getKey());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZD() {
        while (this.bAW > this.bAU) {
            remove(this.bAY.entrySet().iterator().next().getKey());
        }
    }

    public final void delete() {
        close();
        w.deleteContents(this.bAP);
    }

    private static void eU(String str) {
        if (!bAO.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
        }
    }

    public final class c implements Closeable {
        private final long[] bBk;
        private final long bBn;
        private File[] bBo;
        private final InputStream[] bBp;
        private final String key;

        /* synthetic */ c(a aVar, String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr, byte b) {
            this(str, j, fileArr, inputStreamArr, jArr);
        }

        private c(String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.bBn = j;
            this.bBo = fileArr;
            this.bBp = inputStreamArr;
            this.bBk = jArr;
        }

        public final File fe(int i) {
            return this.bBo[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.bBp) {
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            }
        }
    }

    /* renamed from: com.kwad.sdk.core.diskcache.a.a$a, reason: collision with other inner class name */
    public final class C0579a {
        private final b bBf;
        private final boolean[] bBg;
        private boolean bBh;
        private boolean bBi;

        /* synthetic */ C0579a(a aVar, b bVar, byte b) {
            this(bVar);
        }

        static /* synthetic */ boolean b(C0579a c0579a, boolean z) {
            c0579a.bBh = true;
            return true;
        }

        private C0579a(b bVar) {
            this.bBf = bVar;
            this.bBg = bVar.bBl ? null : new boolean[a.this.bAV];
        }

        public final File fe(int i) {
            File fileFh;
            synchronized (a.this) {
                if (this.bBf.bBm != this) {
                    throw new IllegalStateException();
                }
                if (!this.bBf.bBl) {
                    this.bBg[0] = true;
                }
                fileFh = this.bBf.fh(0);
                if (!a.this.bAP.exists()) {
                    a.this.bAP.mkdirs();
                }
            }
            return fileFh;
        }

        public final OutputStream ff(int i) {
            FileOutputStream fileOutputStream;
            C0580a c0580a;
            synchronized (a.this) {
                if (this.bBf.bBm != this) {
                    throw new IllegalStateException();
                }
                byte b = 0;
                if (!this.bBf.bBl) {
                    this.bBg[0] = true;
                }
                File fileFh = this.bBf.fh(0);
                try {
                    fileOutputStream = new FileOutputStream(fileFh);
                } catch (FileNotFoundException unused) {
                    a.this.bAP.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(fileFh);
                    } catch (FileNotFoundException unused2) {
                        return a.bBd;
                    }
                }
                c0580a = new C0580a(this, fileOutputStream, b);
            }
            return c0580a;
        }

        public final void commit() {
            if (this.bBh) {
                a.this.a(this, false);
                a.this.remove(this.bBf.key);
            } else {
                a.this.a(this, true);
            }
            this.bBi = true;
        }

        public final void abort() {
            a.this.a(this, false);
        }

        public final void abortUnlessCommitted() {
            if (this.bBi) {
                return;
            }
            try {
                abort();
            } catch (IOException unused) {
            }
        }

        /* renamed from: com.kwad.sdk.core.diskcache.a.a$a$a, reason: collision with other inner class name */
        class C0580a extends FilterOutputStream {
            /* synthetic */ C0580a(C0579a c0579a, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            private C0580a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i) throws IOException {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    C0579a.b(C0579a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i, int i2) throws IOException {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C0579a.b(C0579a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() throws IOException {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    C0579a.b(C0579a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() throws IOException {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    C0579a.b(C0579a.this, true);
                }
            }
        }
    }

    final class b {
        private final long[] bBk;
        private boolean bBl;
        private C0579a bBm;
        private long bBn;
        private final String key;

        /* synthetic */ b(a aVar, String str, byte b) {
            this(str);
        }

        static /* synthetic */ boolean a(b bVar, boolean z) {
            bVar.bBl = true;
            return true;
        }

        private b(String str) {
            this.key = str;
            this.bBk = new long[a.this.bAV];
        }

        public final String ZF() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.bBk) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(String[] strArr) throws IOException {
            if (strArr.length != a.this.bAV) {
                throw e(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.bBk[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw e(strArr);
                }
            }
        }

        private static IOException e(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final File fg(int i) {
            return new File(a.this.bAP, this.key + i);
        }

        public final File fh(int i) {
            return new File(a.this.bAP, this.key + i + ".tmp");
        }
    }
}
