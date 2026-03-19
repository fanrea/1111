package okhttp3.internal.a;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class d implements Closeable, Flushable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final Pattern zW = Pattern.compile("[a-z0-9_-]{1,120}");
    private final File Aa;
    private final File Ab;
    private final int Ac;
    final int Ad;
    BufferedSink Ae;
    int Ag;
    boolean Ah;
    boolean Ai;
    boolean Aj;
    boolean closed;
    private final Executor executor;
    boolean initialized;
    private long maxSize;
    final okhttp3.internal.d.a zX;
    final File zY;
    private final File zZ;
    private long size = 0;
    final LinkedHashMap<String, b> Af = new LinkedHashMap<>(0, 0.75f, true);
    private long Ak = 0;
    private final Runnable cleanupRunnable = new Runnable() { // from class: okhttp3.internal.a.d.1
        @Override // java.lang.Runnable
        public final void run() {
            synchronized (d.this) {
                if ((!d.this.initialized) || d.this.closed) {
                    return;
                }
                try {
                    d.this.trimToSize();
                } catch (IOException unused) {
                    d.this.Ai = true;
                }
                try {
                    if (d.this.gi()) {
                        d.this.gg();
                        d.this.Ag = 0;
                    }
                } catch (IOException unused2) {
                    d.this.Aj = true;
                    d.this.Ae = Okio.buffer(Okio.blackhole());
                }
            }
        }
    };

    private d(okhttp3.internal.d.a aVar, File file, int i, int i2, long j, Executor executor) {
        this.zX = aVar;
        this.zY = file;
        this.Ac = i;
        this.zZ = new File(file, "journal");
        this.Aa = new File(file, "journal.tmp");
        this.Ab = new File(file, "journal.bkp");
        this.Ad = i2;
        this.maxSize = j;
        this.executor = executor;
    }

    public final synchronized void initialize() {
        if (this.initialized) {
            return;
        }
        if (this.zX.g(this.Ab)) {
            if (this.zX.g(this.zZ)) {
                this.zX.f(this.Ab);
            } else {
                this.zX.a(this.Ab, this.zZ);
            }
        }
        if (this.zX.g(this.zZ)) {
            try {
                gd();
                gf();
                this.initialized = true;
                return;
            } catch (IOException e) {
                okhttp3.internal.e.e.hl().a(5, "DiskLruCache " + this.zY + " is corrupt: " + e.getMessage() + ", removing", e);
                try {
                    delete();
                    this.closed = false;
                } catch (Throwable th) {
                    this.closed = false;
                    throw th;
                }
            }
        }
        gg();
        this.initialized = true;
    }

    public static d a(okhttp3.internal.d.a aVar, File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        return new d(aVar, file, 201105, 2, j, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), okhttp3.internal.c.a("OkHttp DiskLruCache", true)));
    }

    private void gd() {
        BufferedSource bufferedSourceBuffer = Okio.buffer(this.zX.c(this.zZ));
        try {
            String utf8LineStrict = bufferedSourceBuffer.readUtf8LineStrict();
            String utf8LineStrict2 = bufferedSourceBuffer.readUtf8LineStrict();
            String utf8LineStrict3 = bufferedSourceBuffer.readUtf8LineStrict();
            String utf8LineStrict4 = bufferedSourceBuffer.readUtf8LineStrict();
            String utf8LineStrict5 = bufferedSourceBuffer.readUtf8LineStrict();
            if (!"libcore.io.DiskLruCache".equals(utf8LineStrict) || !"1".equals(utf8LineStrict2) || !Integer.toString(this.Ac).equals(utf8LineStrict3) || !Integer.toString(this.Ad).equals(utf8LineStrict4) || !"".equals(utf8LineStrict5)) {
                throw new IOException("unexpected journal header: [" + utf8LineStrict + ", " + utf8LineStrict2 + ", " + utf8LineStrict4 + ", " + utf8LineStrict5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    q(bufferedSourceBuffer.readUtf8LineStrict());
                    i++;
                } catch (EOFException unused) {
                    this.Ag = i - this.Af.size();
                    if (!bufferedSourceBuffer.exhausted()) {
                        gg();
                    } else {
                        this.Ae = ge();
                    }
                    okhttp3.internal.c.closeQuietly(bufferedSourceBuffer);
                    return;
                }
            }
        } catch (Throwable th) {
            okhttp3.internal.c.closeQuietly(bufferedSourceBuffer);
            throw th;
        }
    }

    private BufferedSink ge() {
        return Okio.buffer(new e(this.zX.e(this.zZ)) { // from class: okhttp3.internal.a.d.2
            static final /* synthetic */ boolean $assertionsDisabled = false;
        });
    }

    private void q(String str) throws IOException {
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
                this.Af.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        b bVar = this.Af.get(strSubstring);
        if (bVar == null) {
            bVar = new b(strSubstring);
            this.Af.put(strSubstring, bVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            bVar.Au = true;
            bVar.Av = null;
            bVar.b(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            bVar.Av = new a(bVar);
        } else {
            if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
                return;
            }
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void gf() {
        this.zX.f(this.Aa);
        Iterator<b> it = this.Af.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i = 0;
            if (next.Av == null) {
                while (i < this.Ad) {
                    this.size += next.Ar[i];
                    i++;
                }
            } else {
                next.Av = null;
                while (i < this.Ad) {
                    this.zX.f(next.As[i]);
                    this.zX.f(next.At[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    final synchronized void gg() {
        if (this.Ae != null) {
            this.Ae.close();
        }
        BufferedSink bufferedSinkBuffer = Okio.buffer(this.zX.d(this.Aa));
        try {
            bufferedSinkBuffer.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
            bufferedSinkBuffer.writeUtf8("1").writeByte(10);
            bufferedSinkBuffer.writeDecimalLong(this.Ac).writeByte(10);
            bufferedSinkBuffer.writeDecimalLong(this.Ad).writeByte(10);
            bufferedSinkBuffer.writeByte(10);
            for (b bVar : this.Af.values()) {
                if (bVar.Av != null) {
                    bufferedSinkBuffer.writeUtf8("DIRTY").writeByte(32);
                    bufferedSinkBuffer.writeUtf8(bVar.key);
                    bufferedSinkBuffer.writeByte(10);
                } else {
                    bufferedSinkBuffer.writeUtf8("CLEAN").writeByte(32);
                    bufferedSinkBuffer.writeUtf8(bVar.key);
                    bVar.a(bufferedSinkBuffer);
                    bufferedSinkBuffer.writeByte(10);
                }
            }
            bufferedSinkBuffer.close();
            if (this.zX.g(this.zZ)) {
                this.zX.a(this.zZ, this.Ab);
            }
            this.zX.a(this.Aa, this.zZ);
            this.zX.f(this.Ab);
            this.Ae = ge();
            this.Ah = false;
            this.Aj = false;
        } catch (Throwable th) {
            bufferedSinkBuffer.close();
            throw th;
        }
    }

    public final synchronized c r(String str) {
        initialize();
        checkNotClosed();
        u(str);
        b bVar = this.Af.get(str);
        if (bVar != null && bVar.Au) {
            c cVarGl = bVar.gl();
            if (cVarGl == null) {
                return null;
            }
            this.Ag++;
            this.Ae.writeUtf8("READ").writeByte(32).writeUtf8(str).writeByte(10);
            if (gi()) {
                this.executor.execute(this.cleanupRunnable);
            }
            return cVarGl;
        }
        return null;
    }

    public final a s(String str) {
        return a(str, -1L);
    }

    final synchronized a a(String str, long j) {
        initialize();
        checkNotClosed();
        u(str);
        b bVar = this.Af.get(str);
        if (j != -1 && (bVar == null || bVar.sequenceNumber != j)) {
            return null;
        }
        if (bVar != null && bVar.Av != null) {
            return null;
        }
        if (!this.Ai && !this.Aj) {
            this.Ae.writeUtf8("DIRTY").writeByte(32).writeUtf8(str).writeByte(10);
            this.Ae.flush();
            if (this.Ah) {
                return null;
            }
            if (bVar == null) {
                bVar = new b(str);
                this.Af.put(str, bVar);
            }
            a aVar = new a(bVar);
            bVar.Av = aVar;
            return aVar;
        }
        this.executor.execute(this.cleanupRunnable);
        return null;
    }

    public final File getDirectory() {
        return this.zY;
    }

    public final synchronized long gh() {
        return this.maxSize;
    }

    public final synchronized long size() {
        initialize();
        return this.size;
    }

    final synchronized void a(a aVar, boolean z) {
        b bVar = aVar.Ao;
        if (bVar.Av != aVar) {
            throw new IllegalStateException();
        }
        if (z && !bVar.Au) {
            for (int i = 0; i < this.Ad; i++) {
                if (!aVar.Ap[i]) {
                    aVar.abort();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                }
                if (!this.zX.g(bVar.At[i])) {
                    aVar.abort();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.Ad; i2++) {
            File file = bVar.At[i2];
            if (z) {
                if (this.zX.g(file)) {
                    File file2 = bVar.As[i2];
                    this.zX.a(file, file2);
                    long j = bVar.Ar[i2];
                    long jH = this.zX.h(file2);
                    bVar.Ar[i2] = jH;
                    this.size = (this.size - j) + jH;
                }
            } else {
                this.zX.f(file);
            }
        }
        this.Ag++;
        bVar.Av = null;
        if (bVar.Au | z) {
            bVar.Au = true;
            this.Ae.writeUtf8("CLEAN").writeByte(32);
            this.Ae.writeUtf8(bVar.key);
            bVar.a(this.Ae);
            this.Ae.writeByte(10);
            if (z) {
                long j2 = this.Ak;
                this.Ak = 1 + j2;
                bVar.sequenceNumber = j2;
            }
        } else {
            this.Af.remove(bVar.key);
            this.Ae.writeUtf8("REMOVE").writeByte(32);
            this.Ae.writeUtf8(bVar.key);
            this.Ae.writeByte(10);
        }
        this.Ae.flush();
        if (this.size > this.maxSize || gi()) {
            this.executor.execute(this.cleanupRunnable);
        }
    }

    final boolean gi() {
        int i = this.Ag;
        return i >= 2000 && i >= this.Af.size();
    }

    public final synchronized boolean t(String str) {
        initialize();
        checkNotClosed();
        u(str);
        b bVar = this.Af.get(str);
        if (bVar == null) {
            return false;
        }
        a(bVar);
        if (this.size <= this.maxSize) {
            this.Ai = false;
        }
        return true;
    }

    final boolean a(b bVar) throws IOException {
        if (bVar.Av != null) {
            bVar.Av.detach();
        }
        for (int i = 0; i < this.Ad; i++) {
            this.zX.f(bVar.As[i]);
            this.size -= bVar.Ar[i];
            bVar.Ar[i] = 0;
        }
        this.Ag++;
        this.Ae.writeUtf8("REMOVE").writeByte(32).writeUtf8(bVar.key).writeByte(10);
        this.Af.remove(bVar.key);
        if (gi()) {
            this.executor.execute(this.cleanupRunnable);
        }
        return true;
    }

    public final synchronized boolean isClosed() {
        return this.closed;
    }

    private synchronized void checkNotClosed() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Flushable
    public final synchronized void flush() {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            this.Ae.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.initialized && !this.closed) {
            for (b bVar : (b[]) this.Af.values().toArray(new b[this.Af.size()])) {
                if (bVar.Av != null) {
                    bVar.Av.abort();
                }
            }
            trimToSize();
            this.Ae.close();
            this.Ae = null;
            this.closed = true;
            return;
        }
        this.closed = true;
    }

    final void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            a(this.Af.values().iterator().next());
        }
        this.Ai = false;
    }

    public final void delete() {
        close();
        this.zX.i(this.zY);
    }

    public final synchronized void evictAll() {
        initialize();
        for (b bVar : (b[]) this.Af.values().toArray(new b[this.Af.size()])) {
            a(bVar);
        }
        this.Ai = false;
    }

    private static void u(String str) {
        if (zW.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public final synchronized Iterator<c> gj() {
        initialize();
        return new Iterator<c>() { // from class: okhttp3.internal.a.d.3
            c Am;
            c An;
            final Iterator<b> delegate;

            {
                this.delegate = new ArrayList(d.this.Af.values()).iterator();
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                if (this.Am != null) {
                    return true;
                }
                synchronized (d.this) {
                    if (d.this.closed) {
                        return false;
                    }
                    while (this.delegate.hasNext()) {
                        c cVarGl = this.delegate.next().gl();
                        if (cVarGl != null) {
                            this.Am = cVarGl;
                            return true;
                        }
                    }
                    return false;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.Iterator
            /* renamed from: gk, reason: merged with bridge method [inline-methods] */
            public c next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.An = this.Am;
                this.Am = null;
                return this.An;
            }

            @Override // java.util.Iterator
            public final void remove() {
                c cVar = this.An;
                if (cVar == null) {
                    throw new IllegalStateException("remove() before next()");
                }
                try {
                    d.this.t(cVar.key);
                } catch (IOException unused) {
                } finally {
                    this.An = null;
                }
            }
        };
    }

    public final class c implements Closeable {
        private final long[] Ar;
        private final Source[] Aw;
        private final String key;
        private final long sequenceNumber;

        c(String str, long j, Source[] sourceArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j;
            this.Aw = sourceArr;
            this.Ar = jArr;
        }

        public final a gm() {
            return d.this.a(this.key, this.sequenceNumber);
        }

        public final Source bt(int i) {
            return this.Aw[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (Source source : this.Aw) {
                okhttp3.internal.c.closeQuietly(source);
            }
        }
    }

    public final class a {
        final b Ao;
        final boolean[] Ap;
        private boolean done;

        a(b bVar) {
            this.Ao = bVar;
            this.Ap = bVar.Au ? null : new boolean[d.this.Ad];
        }

        final void detach() {
            if (this.Ao.Av == this) {
                for (int i = 0; i < d.this.Ad; i++) {
                    try {
                        d.this.zX.f(this.Ao.At[i]);
                    } catch (IOException unused) {
                    }
                }
                this.Ao.Av = null;
            }
        }

        public final Sink bs(int i) {
            synchronized (d.this) {
                if (this.done) {
                    throw new IllegalStateException();
                }
                if (this.Ao.Av != this) {
                    return Okio.blackhole();
                }
                if (!this.Ao.Au) {
                    this.Ap[i] = true;
                }
                try {
                    return new e(d.this.zX.d(this.Ao.At[i])) { // from class: okhttp3.internal.a.d.a.1
                    };
                } catch (FileNotFoundException unused) {
                    return Okio.blackhole();
                }
            }
        }

        public final void commit() {
            synchronized (d.this) {
                if (this.done) {
                    throw new IllegalStateException();
                }
                if (this.Ao.Av == this) {
                    d.this.a(this, true);
                }
                this.done = true;
            }
        }

        public final void abort() {
            synchronized (d.this) {
                if (this.done) {
                    throw new IllegalStateException();
                }
                if (this.Ao.Av == this) {
                    d.this.a(this, false);
                }
                this.done = true;
            }
        }
    }

    final class b {
        final long[] Ar;
        final File[] As;
        final File[] At;
        boolean Au;
        a Av;
        final String key;
        long sequenceNumber;

        b(String str) {
            this.key = str;
            this.Ar = new long[d.this.Ad];
            this.As = new File[d.this.Ad];
            this.At = new File[d.this.Ad];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < d.this.Ad; i++) {
                sb.append(i);
                this.As[i] = new File(d.this.zY, sb.toString());
                sb.append(".tmp");
                this.At[i] = new File(d.this.zY, sb.toString());
                sb.setLength(length);
            }
        }

        final void b(String[] strArr) throws IOException {
            if (strArr.length != d.this.Ad) {
                throw c(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.Ar[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw c(strArr);
                }
            }
        }

        final void a(BufferedSink bufferedSink) throws IOException {
            for (long j : this.Ar) {
                bufferedSink.writeByte(32).writeDecimalLong(j);
            }
        }

        private static IOException c(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        final c gl() {
            if (!Thread.holdsLock(d.this)) {
                throw new AssertionError();
            }
            Source[] sourceArr = new Source[d.this.Ad];
            long[] jArr = (long[]) this.Ar.clone();
            for (int i = 0; i < d.this.Ad; i++) {
                try {
                    sourceArr[i] = d.this.zX.c(this.As[i]);
                } catch (FileNotFoundException unused) {
                    for (int i2 = 0; i2 < d.this.Ad && sourceArr[i2] != null; i2++) {
                        okhttp3.internal.c.closeQuietly(sourceArr[i2]);
                    }
                    try {
                        d.this.a(this);
                        return null;
                    } catch (IOException unused2) {
                        return null;
                    }
                }
            }
            return d.this.new c(this.key, this.sequenceNumber, sourceArr, jArr);
        }
    }
}
