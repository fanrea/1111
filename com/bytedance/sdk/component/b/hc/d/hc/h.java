package com.bytedance.sdk.component.b.hc.d.hc;

import com.bytedance.sdk.component.b.hc.cb;
import com.bytedance.sdk.component.b.hc.d.hc.an;
import com.bytedance.sdk.component.b.hc.d.u.e;
import com.bytedance.sdk.component.b.hc.jh;
import com.bytedance.sdk.component.b.hc.tc;
import com.bytedance.sdk.component.b.hc.us;
import com.bytedance.sdk.component.b.hc.v;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class h {
    static final /* synthetic */ boolean c = true;
    private us an;
    public final cb b;
    public final com.bytedance.sdk.component.b.hc.d d;
    private com.bytedance.sdk.component.b.hc.d.b.b e;
    private final Object gb;
    private final tc h;
    public final com.bytedance.sdk.component.b.hc.u hc;
    private boolean k;
    private b mk;
    private boolean mq;
    private int tc;
    private final an tt;
    private an.d u;
    private boolean uo;

    public h(tc tcVar, com.bytedance.sdk.component.b.hc.d dVar, com.bytedance.sdk.component.b.hc.u uVar, cb cbVar, Object obj) throws IOException {
        this.h = tcVar;
        this.d = dVar;
        this.hc = uVar;
        this.b = cbVar;
        this.tt = new an(dVar, gb(), uVar, cbVar);
        this.gb = obj;
    }

    public com.bytedance.sdk.component.b.hc.d.b.b d(v vVar, jh.d dVar, boolean z) {
        try {
            com.bytedance.sdk.component.b.hc.d.b.b bVarD = d(dVar.hc(), dVar.b(), dVar.c(), vVar.yo(), z).d(vVar, dVar, this);
            synchronized (this.h) {
                this.e = bVarD;
            }
            return bVarD;
        } catch (IOException e) {
            throw new u(e);
        }
    }

    private b d(int i, int i2, int i3, boolean z, boolean z2) throws Throwable {
        while (true) {
            b bVarD = d(i, i2, i3, z);
            synchronized (this.h) {
                if (bVarD.hc == 0) {
                    return bVarD;
                }
                if (bVarD.d(z2)) {
                    return bVarD;
                }
                c();
            }
        }
    }

    private b d(int i, int i2, int i3, boolean z) throws Throwable {
        Socket socketH;
        b bVar;
        Socket socketD;
        us usVarHc;
        boolean z2;
        boolean z3;
        an.d dVar;
        synchronized (this.h) {
            if (this.uo) {
                throw new IllegalStateException("released");
            }
            if (this.e != null) {
                throw new IllegalStateException("codec != null");
            }
            if (this.k) {
                throw new IOException("Canceled");
            }
            socketH = h();
            bVar = this.mk;
            socketD = null;
            if (bVar == null) {
                bVar = null;
            }
            if (bVar == null) {
                com.bytedance.sdk.component.b.hc.d.d.d.d(this.h, this.d, this, null);
                b bVar2 = this.mk;
                if (bVar2 != null) {
                    z2 = true;
                    bVar = bVar2;
                    usVarHc = null;
                } else {
                    usVarHc = this.an;
                }
            } else {
                usVarHc = null;
            }
            z2 = false;
        }
        com.bytedance.sdk.component.b.hc.d.b.d(socketH);
        if (bVar != null) {
            return bVar;
        }
        if (usVarHc != null || ((dVar = this.u) != null && dVar.d())) {
            z3 = false;
        } else {
            this.u = this.tt.hc();
            z3 = true;
        }
        synchronized (this.h) {
            if (this.k) {
                throw new IOException("Canceled");
            }
            if (z3) {
                List<us> listB = this.u.b();
                int size = listB.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size) {
                        break;
                    }
                    us usVar = listB.get(i4);
                    com.bytedance.sdk.component.b.hc.d.d.d.d(this.h, this.d, this, usVar);
                    b bVar3 = this.mk;
                    if (bVar3 != null) {
                        this.an = usVar;
                        z2 = true;
                        bVar = bVar3;
                        break;
                    }
                    i4++;
                }
            }
            if (!z2) {
                if (usVarHc == null) {
                    usVarHc = this.u.hc();
                }
                this.an = usVarHc;
                this.tc = 0;
                bVar = new b(this.h, usVarHc);
                d(bVar, false);
            }
        }
        if (z2) {
            return bVar;
        }
        bVar.d(i, i2, i3, z, this.hc, this.b);
        gb().hc(bVar.d());
        synchronized (this.h) {
            this.mq = true;
            com.bytedance.sdk.component.b.hc.d.d.d.hc(this.h, bVar);
            if (bVar.u()) {
                socketD = com.bytedance.sdk.component.b.hc.d.d.d.d(this.h, this.d, this);
                bVar = this.mk;
            }
        }
        com.bytedance.sdk.component.b.hc.d.b.d(socketD);
        return bVar;
    }

    private Socket h() {
        if (!c && !Thread.holdsLock(this.h)) {
            throw new AssertionError();
        }
        b bVar = this.mk;
        if (bVar == null || !bVar.d) {
            return null;
        }
        return d(false, false, true);
    }

    public void d(boolean z, com.bytedance.sdk.component.b.hc.d.b.b bVar, long j, IOException iOException) throws IOException {
        Socket socketD;
        synchronized (this.h) {
            if (bVar != null) {
                if (bVar == this.e) {
                    if (!z) {
                        this.mk.hc++;
                    }
                    socketD = d(z, false, true);
                }
            }
            throw new IllegalStateException("expected " + this.e + " but was " + bVar);
        }
        com.bytedance.sdk.component.b.hc.d.b.d(socketD);
        if (iOException != null) {
            this.b.d(this.hc, iOException);
        }
    }

    public com.bytedance.sdk.component.b.hc.d.b.b d() {
        com.bytedance.sdk.component.b.hc.d.b.b bVar;
        synchronized (this.h) {
            bVar = this.e;
        }
        return bVar;
    }

    private c gb() {
        return com.bytedance.sdk.component.b.hc.d.d.d.d(this.h);
    }

    public synchronized b hc() {
        return this.mk;
    }

    public void b() throws IOException {
        Socket socketD;
        synchronized (this.h) {
            socketD = d(false, true, false);
        }
        com.bytedance.sdk.component.b.hc.d.b.d(socketD);
    }

    public void c() throws IOException {
        Socket socketD;
        synchronized (this.h) {
            socketD = d(true, false, false);
        }
        com.bytedance.sdk.component.b.hc.d.b.d(socketD);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.net.Socket d(boolean r2, boolean r3, boolean r4) {
        /*
            r1 = this;
            boolean r0 = com.bytedance.sdk.component.b.hc.d.hc.h.c
            if (r0 != 0) goto L13
            com.bytedance.sdk.component.b.hc.tc r0 = r1.h
            boolean r0 = java.lang.Thread.holdsLock(r0)
            if (r0 == 0) goto Ld
            goto L13
        Ld:
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>()
            throw r2
        L13:
            r0 = 0
            if (r4 == 0) goto L18
            r1.e = r0
        L18:
            r4 = 1
            if (r3 == 0) goto L1d
            r1.uo = r4
        L1d:
            com.bytedance.sdk.component.b.hc.d.hc.b r3 = r1.mk
            if (r3 == 0) goto L61
            if (r2 == 0) goto L25
            r3.d = r4
        L25:
            com.bytedance.sdk.component.b.hc.d.b.b r2 = r1.e
            if (r2 != 0) goto L61
            boolean r2 = r1.uo
            if (r2 != 0) goto L33
            com.bytedance.sdk.component.b.hc.d.hc.b r2 = r1.mk
            boolean r2 = r2.d
            if (r2 == 0) goto L61
        L33:
            com.bytedance.sdk.component.b.hc.d.hc.b r2 = r1.mk
            r1.hc(r2)
            com.bytedance.sdk.component.b.hc.d.hc.b r2 = r1.mk
            java.util.List<java.lang.ref.Reference<com.bytedance.sdk.component.b.hc.d.hc.h>> r2 = r2.c
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L5d
            com.bytedance.sdk.component.b.hc.d.hc.b r2 = r1.mk
            long r3 = java.lang.System.nanoTime()
            r2.u = r3
            com.bytedance.sdk.component.b.hc.d.d r2 = com.bytedance.sdk.component.b.hc.d.d.d
            com.bytedance.sdk.component.b.hc.tc r3 = r1.h
            com.bytedance.sdk.component.b.hc.d.hc.b r4 = r1.mk
            boolean r2 = r2.d(r3, r4)
            if (r2 == 0) goto L5d
            com.bytedance.sdk.component.b.hc.d.hc.b r2 = r1.mk
            java.net.Socket r2 = r2.b()
            goto L5e
        L5d:
            r2 = r0
        L5e:
            r1.mk = r0
            r0 = r2
        L61:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.b.hc.d.hc.h.d(boolean, boolean, boolean):java.net.Socket");
    }

    public void u() throws IOException {
        com.bytedance.sdk.component.b.hc.d.b.b bVar;
        b bVar2;
        synchronized (this.h) {
            this.k = true;
            bVar = this.e;
            bVar2 = this.mk;
        }
        if (bVar != null) {
            bVar.b();
        } else if (bVar2 != null) {
            bVar2.hc();
        }
    }

    public void d(IOException iOException) throws IOException {
        boolean z;
        Socket socketD;
        synchronized (this.h) {
            if (iOException instanceof e) {
                e eVar = (e) iOException;
                if (eVar.d == com.bytedance.sdk.component.b.hc.d.u.hc.REFUSED_STREAM) {
                    this.tc++;
                }
                if (eVar.d != com.bytedance.sdk.component.b.hc.d.u.hc.REFUSED_STREAM || this.tc > 1) {
                    this.an = null;
                    z = true;
                }
                z = false;
            } else {
                b bVar = this.mk;
                if (bVar != null && (!bVar.u() || (iOException instanceof com.bytedance.sdk.component.b.hc.d.u.d))) {
                    if (this.mk.hc == 0) {
                        us usVar = this.an;
                        if (usVar != null && iOException != null) {
                            this.tt.d(usVar, iOException);
                        }
                        this.an = null;
                    }
                    z = true;
                }
                z = false;
            }
            socketD = d(z, false, true);
        }
        com.bytedance.sdk.component.b.hc.d.b.d(socketD);
    }

    public void d(b bVar, boolean z) {
        if (!c && !Thread.holdsLock(this.h)) {
            throw new AssertionError();
        }
        if (this.mk != null) {
            throw new IllegalStateException();
        }
        this.mk = bVar;
        this.mq = z;
        bVar.c.add(new d(this, this.gb));
    }

    private void hc(b bVar) {
        int size = bVar.c.size();
        for (int i = 0; i < size; i++) {
            if (bVar.c.get(i).get() == this) {
                bVar.c.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public Socket d(b bVar) {
        if (!c && !Thread.holdsLock(this.h)) {
            throw new AssertionError();
        }
        if (this.e != null || this.mk.c.size() != 1) {
            throw new IllegalStateException();
        }
        Reference<h> reference = this.mk.c.get(0);
        Socket socketD = d(true, false, false);
        this.mk = bVar;
        bVar.c.add(reference);
        return socketD;
    }

    public boolean an() {
        if (this.an != null) {
            return true;
        }
        an.d dVar = this.u;
        return (dVar != null && dVar.d()) || this.tt.d();
    }

    public String toString() {
        b bVarHc = hc();
        return bVarHc != null ? bVarHc.toString() : this.d.toString();
    }

    public static final class d extends WeakReference<h> {
        public final Object d;

        d(h hVar, Object obj) {
            super(hVar);
            this.d = obj;
        }
    }
}
