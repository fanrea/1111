package com.bytedance.sdk.component.b.hc.d.d;

import com.bytedance.sdk.component.b.d.mq;
import com.bytedance.sdk.component.b.d.rf;
import com.bytedance.sdk.component.b.d.yo;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class c implements Closeable, Flushable {
    static final Pattern d = Pattern.compile("[a-z0-9_-]{1,120}");
    static final /* synthetic */ boolean uo = true;
    final LinkedHashMap<String, hc> an;
    final File b;
    final int c;
    private final File cb;
    private final Runnable de;
    private final File e;
    boolean gb;
    int h;
    final com.bytedance.sdk.component.b.hc.d.an.d hc;
    private long jh;
    private final File k;
    boolean mk;
    boolean mq;
    private long rf;
    private final Executor sy;
    boolean tc;
    boolean tt;
    com.bytedance.sdk.component.b.d.c u;
    private final int w;
    private long yo;

    public synchronized void d() throws IOException {
        if (!uo && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (this.tt) {
            return;
        }
        if (this.hc.c(this.cb)) {
            if (this.hc.c(this.k)) {
                this.hc.delete(this.cb);
            } else {
                this.hc.d(this.cb, this.k);
            }
        }
        if (this.hc.c(this.k)) {
            try {
                an();
                gb();
                this.tt = true;
                return;
            } catch (IOException e) {
                com.bytedance.sdk.component.b.hc.d.h.u.hc().d(5, "DiskLruCache " + this.b + " is corrupt: " + e.getMessage() + ", removing", e);
                try {
                    delete();
                    this.tc = false;
                } catch (Throwable th) {
                    this.tc = false;
                    throw th;
                }
            }
        }
        hc();
        this.tt = true;
    }

    private void an() throws IOException {
        com.bytedance.sdk.component.b.d.u uVarD = mq.d(this.hc.d(this.k));
        try {
            String strCb = uVarD.cb();
            String strCb2 = uVarD.cb();
            String strCb3 = uVarD.cb();
            String strCb4 = uVarD.cb();
            String strCb5 = uVarD.cb();
            if (!"libcore.io.DiskLruCache".equals(strCb) || !"1".equals(strCb2) || !Integer.toString(this.w).equals(strCb3) || !Integer.toString(this.c).equals(strCb4) || !"".equals(strCb5)) {
                throw new IOException("unexpected journal header: [" + strCb + ", " + strCb2 + ", " + strCb4 + ", " + strCb5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    d(uVarD.cb());
                    i++;
                } catch (EOFException unused) {
                    this.h = i - this.an.size();
                    if (!uVarD.u()) {
                        hc();
                    } else {
                        this.u = h();
                    }
                    com.bytedance.sdk.component.b.hc.d.b.d(uVarD);
                    return;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.b.hc.d.b.d(uVarD);
            throw th;
        }
    }

    private com.bytedance.sdk.component.b.d.c h() throws FileNotFoundException {
        return mq.d(new u(this.hc.b(this.k)) { // from class: com.bytedance.sdk.component.b.hc.d.d.c.1
            static final /* synthetic */ boolean d = true;

            @Override // com.bytedance.sdk.component.b.hc.d.d.u
            protected void d(IOException iOException) {
                if (!d && !Thread.holdsLock(c.this)) {
                    throw new AssertionError();
                }
                c.this.gb = true;
            }
        });
    }

    private void d(String str) throws IOException {
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
                this.an.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        hc hcVar = this.an.get(strSubstring);
        if (hcVar == null) {
            hcVar = new hc(strSubstring);
            this.an.put(strSubstring, hcVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            hcVar.u = true;
            hcVar.an = null;
            hcVar.d(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            hcVar.an = new d(hcVar);
        } else if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
        }
    }

    private void gb() throws IOException {
        this.hc.delete(this.e);
        Iterator<hc> it = this.an.values().iterator();
        while (it.hasNext()) {
            hc next = it.next();
            int i = 0;
            if (next.an == null) {
                while (i < this.c) {
                    this.rf += next.hc[i];
                    i++;
                }
            } else {
                next.an = null;
                while (i < this.c) {
                    this.hc.delete(next.b[i]);
                    this.hc.delete(next.c[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    synchronized void hc() throws IOException {
        com.bytedance.sdk.component.b.d.c cVar = this.u;
        if (cVar != null) {
            cVar.close();
        }
        com.bytedance.sdk.component.b.d.c cVarD = mq.d(this.hc.hc(this.e));
        try {
            cVarD.hc("libcore.io.DiskLruCache").tt(10);
            cVarD.hc("1").tt(10);
            cVarD.mq(this.w).tt(10);
            cVarD.mq(this.c).tt(10);
            cVarD.tt(10);
            for (hc hcVar : this.an.values()) {
                if (hcVar.an != null) {
                    cVarD.hc("DIRTY").tt(32);
                    cVarD.hc(hcVar.d);
                    cVarD.tt(10);
                } else {
                    cVarD.hc("CLEAN").tt(32);
                    cVarD.hc(hcVar.d);
                    hcVar.d(cVarD);
                    cVarD.tt(10);
                }
            }
            cVarD.close();
            if (this.hc.c(this.k)) {
                this.hc.d(this.k, this.cb);
            }
            this.hc.d(this.e, this.k);
            this.hc.delete(this.cb);
            this.u = h();
            this.gb = false;
            this.mq = false;
        } catch (Throwable th) {
            cVarD.close();
            throw th;
        }
    }

    synchronized d d(String str, long j) throws IOException {
        d();
        tt();
        hc(str);
        hc hcVar = this.an.get(str);
        if (j != -1 && (hcVar == null || hcVar.h != j)) {
            return null;
        }
        if (hcVar != null && hcVar.an != null) {
            return null;
        }
        if (!this.mk && !this.mq) {
            this.u.hc("DIRTY").tt(32).hc(str).tt(10);
            this.u.flush();
            if (this.gb) {
                return null;
            }
            if (hcVar == null) {
                hcVar = new hc(str);
                this.an.put(str, hcVar);
            }
            d dVar = new d(hcVar);
            hcVar.an = dVar;
            return dVar;
        }
        this.sy.execute(this.de);
        return null;
    }

    synchronized void d(d dVar, boolean z) throws IOException {
        hc hcVar = dVar.d;
        if (hcVar.an != dVar) {
            throw new IllegalStateException();
        }
        if (z && !hcVar.u) {
            for (int i = 0; i < this.c; i++) {
                if (!dVar.hc[i]) {
                    dVar.b();
                    throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
                }
                if (!this.hc.c(hcVar.c[i])) {
                    dVar.b();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.c; i2++) {
            File file = hcVar.c[i2];
            if (z) {
                if (this.hc.c(file)) {
                    File file2 = hcVar.b[i2];
                    this.hc.d(file, file2);
                    long j = hcVar.hc[i2];
                    long jU = this.hc.u(file2);
                    hcVar.hc[i2] = jU;
                    this.rf = (this.rf - j) + jU;
                }
            } else {
                this.hc.delete(file);
            }
        }
        this.h++;
        hcVar.an = null;
        if (hcVar.u | z) {
            hcVar.u = true;
            this.u.hc("CLEAN").tt(32);
            this.u.hc(hcVar.d);
            hcVar.d(this.u);
            this.u.tt(10);
            if (z) {
                long j2 = this.jh;
                this.jh = 1 + j2;
                hcVar.h = j2;
            }
        } else {
            this.an.remove(hcVar.d);
            this.u.hc("REMOVE").tt(32);
            this.u.hc(hcVar.d);
            this.u.tt(10);
        }
        this.u.flush();
        if (this.rf > this.yo || b()) {
            this.sy.execute(this.de);
        }
    }

    boolean b() {
        int i = this.h;
        return i >= 2000 && i >= this.an.size();
    }

    boolean d(hc hcVar) throws IOException {
        if (hcVar.an != null) {
            hcVar.an.d();
        }
        for (int i = 0; i < this.c; i++) {
            this.hc.delete(hcVar.b[i]);
            this.rf -= hcVar.hc[i];
            hcVar.hc[i] = 0;
        }
        this.h++;
        this.u.hc("REMOVE").tt(32).hc(hcVar.d).tt(10);
        this.an.remove(hcVar.d);
        if (b()) {
            this.sy.execute(this.de);
        }
        return true;
    }

    public synchronized boolean c() {
        return this.tc;
    }

    private synchronized void tt() {
        if (c()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.tt) {
            tt();
            u();
            this.u.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.tt && !this.tc) {
            for (hc hcVar : (hc[]) this.an.values().toArray(new hc[this.an.size()])) {
                if (hcVar.an != null) {
                    hcVar.an.b();
                }
            }
            u();
            this.u.close();
            this.u = null;
            this.tc = true;
            return;
        }
        this.tc = true;
    }

    void u() throws IOException {
        while (this.rf > this.yo) {
            d(this.an.values().iterator().next());
        }
        this.mk = false;
    }

    public void delete() throws IOException {
        close();
        this.hc.an(this.b);
    }

    private void hc(String str) {
        if (!d.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    public final class b implements Closeable {
        private final long b;
        private final rf[] c;
        final /* synthetic */ c d;
        private final String hc;

        public d d() throws IOException {
            return this.d.d(this.hc, this.b);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            for (rf rfVar : this.c) {
                com.bytedance.sdk.component.b.hc.d.b.d(rfVar);
            }
        }
    }

    public final class d {
        private boolean c;
        final hc d;
        final boolean[] hc;

        d(hc hcVar) {
            this.d = hcVar;
            this.hc = hcVar.u ? null : new boolean[c.this.c];
        }

        void d() {
            if (this.d.an == this) {
                for (int i = 0; i < c.this.c; i++) {
                    try {
                        c.this.hc.delete(this.d.c[i]);
                    } catch (IOException unused) {
                    }
                }
                this.d.an = null;
            }
        }

        public yo d(int i) {
            synchronized (c.this) {
                if (this.c) {
                    throw new IllegalStateException();
                }
                if (this.d.an != this) {
                    return mq.d();
                }
                if (!this.d.u) {
                    this.hc[i] = true;
                }
                try {
                    return new u(c.this.hc.hc(this.d.c[i])) { // from class: com.bytedance.sdk.component.b.hc.d.d.c.d.1
                        @Override // com.bytedance.sdk.component.b.hc.d.d.u
                        protected void d(IOException iOException) {
                            synchronized (c.this) {
                                d.this.d();
                            }
                        }
                    };
                } catch (FileNotFoundException unused) {
                    return mq.d();
                }
            }
        }

        public void hc() throws IOException {
            synchronized (c.this) {
                if (this.c) {
                    throw new IllegalStateException();
                }
                if (this.d.an == this) {
                    c.this.d(this, true);
                }
                this.c = true;
            }
        }

        public void b() throws IOException {
            synchronized (c.this) {
                if (this.c) {
                    throw new IllegalStateException();
                }
                if (this.d.an == this) {
                    c.this.d(this, false);
                }
                this.c = true;
            }
        }
    }

    private final class hc {
        d an;
        final File[] b;
        final File[] c;
        final String d;
        long h;
        final long[] hc;
        boolean u;

        hc(String str) {
            this.d = str;
            this.hc = new long[c.this.c];
            this.b = new File[c.this.c];
            this.c = new File[c.this.c];
            StringBuilder sbAppend = new StringBuilder(str).append('.');
            int length = sbAppend.length();
            for (int i = 0; i < c.this.c; i++) {
                sbAppend.append(i);
                this.b[i] = new File(c.this.b, sbAppend.toString());
                sbAppend.append(".tmp");
                this.c[i] = new File(c.this.b, sbAppend.toString());
                sbAppend.setLength(length);
            }
        }

        void d(String[] strArr) throws IOException {
            if (strArr.length != c.this.c) {
                throw hc(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.hc[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw hc(strArr);
                }
            }
        }

        void d(com.bytedance.sdk.component.b.d.c cVar) throws IOException {
            for (long j : this.hc) {
                cVar.tt(32).mq(j);
            }
        }

        private IOException hc(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }
}
