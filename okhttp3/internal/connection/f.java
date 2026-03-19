package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class f {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Route AA;
    private final Object AT;
    private final e AU;
    private int AV;
    private c AW;
    private boolean AX;
    private boolean AY;
    private okhttp3.internal.b.c AZ;
    public final Address address;
    private final ConnectionPool connectionPool;

    public f(ConnectionPool connectionPool, Address address, Object obj) {
        this.connectionPool = connectionPool;
        this.address = address;
        this.AU = new e(address, gx());
        this.AT = obj;
    }

    public final okhttp3.internal.b.c a(OkHttpClient okHttpClient, boolean z) {
        try {
            okhttp3.internal.b.c cVarA = a(okHttpClient.connectTimeoutMillis(), okHttpClient.readTimeoutMillis(), okHttpClient.writeTimeoutMillis(), okHttpClient.retryOnConnectionFailure(), z).a(okHttpClient, this);
            synchronized (this.connectionPool) {
                this.AZ = cVarA;
            }
            return cVarA;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    private c a(int i, int i2, int i3, boolean z, boolean z2) throws Throwable {
        while (true) {
            c cVarC = c(i, i2, i3, z);
            synchronized (this.connectionPool) {
                if (cVarC.successCount == 0) {
                    return cVarC;
                }
                if (cVarC.H(z2)) {
                    return cVarC;
                }
                gz();
            }
        }
    }

    private c c(int i, int i2, int i3, boolean z) throws Throwable {
        c cVar;
        synchronized (this.connectionPool) {
            if (this.AX) {
                throw new IllegalStateException("released");
            }
            if (this.AZ != null) {
                throw new IllegalStateException("codec != null");
            }
            if (this.AY) {
                throw new IOException("Canceled");
            }
            c cVar2 = this.AW;
            if (cVar2 != null && !cVar2.AE) {
                return cVar2;
            }
            okhttp3.internal.a.instance.get(this.connectionPool, this.address, this);
            if (this.AW != null) {
                return this.AW;
            }
            Route routeGp = this.AA;
            if (routeGp == null) {
                routeGp = this.AU.gp();
            }
            synchronized (this.connectionPool) {
                this.AA = routeGp;
                this.AV = 0;
                cVar = new c(this.connectionPool, routeGp);
                a(cVar);
                if (this.AY) {
                    throw new IOException("Canceled");
                }
            }
            cVar.b(i, i2, i3, z);
            gx().b(cVar.getRoute());
            Socket socketDeduplicate = null;
            synchronized (this.connectionPool) {
                okhttp3.internal.a.instance.put(this.connectionPool, cVar);
                if (cVar.go()) {
                    socketDeduplicate = okhttp3.internal.a.instance.deduplicate(this.connectionPool, this.address, this);
                    cVar = this.AW;
                }
            }
            okhttp3.internal.c.a(socketDeduplicate);
            return cVar;
        }
    }

    public final void a(boolean z, okhttp3.internal.b.c cVar) {
        Socket socketA;
        synchronized (this.connectionPool) {
            if (cVar != null) {
                if (cVar == this.AZ) {
                    if (!z) {
                        this.AW.successCount++;
                    }
                    socketA = a(z, false, true);
                }
            }
            throw new IllegalStateException("expected " + this.AZ + " but was " + cVar);
        }
        okhttp3.internal.c.a(socketA);
    }

    public final okhttp3.internal.b.c gw() {
        okhttp3.internal.b.c cVar;
        synchronized (this.connectionPool) {
            cVar = this.AZ;
        }
        return cVar;
    }

    private d gx() {
        return okhttp3.internal.a.instance.routeDatabase(this.connectionPool);
    }

    public final synchronized c gy() {
        return this.AW;
    }

    public final void release() throws IOException {
        Socket socketA;
        synchronized (this.connectionPool) {
            socketA = a(false, true, false);
        }
        okhttp3.internal.c.a(socketA);
    }

    public final void gz() throws IOException {
        Socket socketA;
        synchronized (this.connectionPool) {
            socketA = a(true, false, false);
        }
        okhttp3.internal.c.a(socketA);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.net.Socket a(boolean r2, boolean r3, boolean r4) {
        /*
            r1 = this;
            r0 = 0
            if (r4 == 0) goto L5
            r1.AZ = r0
        L5:
            r4 = 1
            if (r3 == 0) goto La
            r1.AX = r4
        La:
            okhttp3.internal.connection.c r3 = r1.AW
            if (r3 == 0) goto L4e
            if (r2 == 0) goto L12
            r3.AE = r4
        L12:
            okhttp3.internal.b.c r2 = r1.AZ
            if (r2 != 0) goto L4e
            boolean r2 = r1.AX
            if (r2 != 0) goto L20
            okhttp3.internal.connection.c r2 = r1.AW
            boolean r2 = r2.AE
            if (r2 == 0) goto L4e
        L20:
            okhttp3.internal.connection.c r2 = r1.AW
            r1.b(r2)
            okhttp3.internal.connection.c r2 = r1.AW
            java.util.List<java.lang.ref.Reference<okhttp3.internal.connection.f>> r2 = r2.AG
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L4a
            okhttp3.internal.connection.c r2 = r1.AW
            long r3 = java.lang.System.nanoTime()
            r2.AH = r3
            okhttp3.internal.a r2 = okhttp3.internal.a.instance
            okhttp3.ConnectionPool r3 = r1.connectionPool
            okhttp3.internal.connection.c r4 = r1.AW
            boolean r2 = r2.connectionBecameIdle(r3, r4)
            if (r2 == 0) goto L4a
            okhttp3.internal.connection.c r2 = r1.AW
            java.net.Socket r2 = r2.socket()
            goto L4b
        L4a:
            r2 = r0
        L4b:
            r1.AW = r0
            goto L4f
        L4e:
            r2 = r0
        L4f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.f.a(boolean, boolean, boolean):java.net.Socket");
    }

    public final void cancel() throws IOException {
        okhttp3.internal.b.c cVar;
        c cVar2;
        synchronized (this.connectionPool) {
            this.AY = true;
            cVar = this.AZ;
            cVar2 = this.AW;
        }
        if (cVar != null) {
            cVar.cancel();
        } else if (cVar2 != null) {
            cVar2.cancel();
        }
    }

    public final void b(IOException iOException) throws IOException {
        boolean z;
        Socket socketA;
        synchronized (this.connectionPool) {
            if (iOException instanceof StreamResetException) {
                StreamResetException streamResetException = (StreamResetException) iOException;
                if (streamResetException.errorCode == ErrorCode.REFUSED_STREAM) {
                    this.AV++;
                }
                if (streamResetException.errorCode != ErrorCode.REFUSED_STREAM || this.AV > 1) {
                    this.AA = null;
                    z = true;
                }
                z = false;
            } else {
                if (this.AW != null && (!this.AW.go() || (iOException instanceof ConnectionShutdownException))) {
                    if (this.AW.successCount == 0) {
                        if (this.AA != null && iOException != null) {
                            this.AU.a(this.AA, iOException);
                        }
                        this.AA = null;
                    }
                    z = true;
                }
                z = false;
            }
            socketA = a(z, false, true);
        }
        okhttp3.internal.c.a(socketA);
    }

    public final void a(c cVar) {
        if (this.AW != null) {
            throw new IllegalStateException();
        }
        this.AW = cVar;
        cVar.AG.add(new a(this, this.AT));
    }

    private void b(c cVar) {
        int size = cVar.AG.size();
        for (int i = 0; i < size; i++) {
            if (cVar.AG.get(i).get() == this) {
                cVar.AG.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public final Socket c(c cVar) {
        if (this.AZ != null || this.AW.AG.size() != 1) {
            throw new IllegalStateException();
        }
        Reference<f> reference = this.AW.AG.get(0);
        Socket socketA = a(true, false, false);
        this.AW = cVar;
        cVar.AG.add(reference);
        return socketA;
    }

    public final boolean gA() {
        return this.AA != null || this.AU.hasNext();
    }

    public final String toString() {
        c cVarGy = gy();
        return cVarGy != null ? cVarGy.toString() : this.address.toString();
    }

    public static final class a extends WeakReference<f> {
        public final Object AT;

        a(f fVar, Object obj) {
            super(fVar);
            this.AT = obj;
        }
    }
}
