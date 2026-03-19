package okhttp3.internal.e;

import android.util.Log;
import com.bytedance.sdk.djx.core.api.req.FeedReqParams;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class a extends e {
    private final Class<?> Do;
    private final d<Socket> Dp;
    private final d<Socket> Dq;
    private final d<Socket> Dr;
    private final d<Socket> Ds;
    private final b Dt = b.hj();

    private a(Class<?> cls, d<Socket> dVar, d<Socket> dVar2, d<Socket> dVar3, d<Socket> dVar4) {
        this.Do = cls;
        this.Dp = dVar;
        this.Dq = dVar2;
        this.Dr = dVar3;
        this.Ds = dVar4;
    }

    @Override // okhttp3.internal.e.e
    public final void a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (!okhttp3.internal.c.a(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (SecurityException e2) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e2);
            throw iOException;
        }
    }

    @Override // okhttp3.internal.e.e
    public final X509TrustManager a(SSLSocketFactory sSLSocketFactory) {
        Object objA = a(sSLSocketFactory, this.Do, "sslParameters");
        if (objA == null) {
            try {
                objA = a(sSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
            } catch (ClassNotFoundException unused) {
                return super.a(sSLSocketFactory);
            }
        }
        X509TrustManager x509TrustManager = (X509TrustManager) a(objA, X509TrustManager.class, "x509TrustManager");
        return x509TrustManager != null ? x509TrustManager : (X509TrustManager) a(objA, X509TrustManager.class, "trustManager");
    }

    @Override // okhttp3.internal.e.e
    public final void a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        if (str != null) {
            this.Dp.b(sSLSocket, Boolean.TRUE);
            this.Dq.b(sSLSocket, str);
        }
        d<Socket> dVar = this.Ds;
        if (dVar == null || !dVar.s(sSLSocket)) {
            return;
        }
        this.Ds.c(sSLSocket, m(list));
    }

    @Override // okhttp3.internal.e.e
    public final String c(SSLSocket sSLSocket) {
        byte[] bArr;
        d<Socket> dVar = this.Dr;
        if (dVar == null || !dVar.s(sSLSocket) || (bArr = (byte[]) this.Dr.c(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, okhttp3.internal.c.UTF_8);
    }

    @Override // okhttp3.internal.e.e
    public final void a(int i, String str, Throwable th) {
        int iMin;
        int i2 = i != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int iIndexOf = str.indexOf(10, i3);
            if (iIndexOf == -1) {
                iIndexOf = length;
            }
            while (true) {
                iMin = Math.min(iIndexOf, i3 + 4000);
                Log.println(i2, "OkHttp", str.substring(i3, iMin));
                if (iMin >= iIndexOf) {
                    break;
                } else {
                    i3 = iMin;
                }
            }
            i3 = iMin + 1;
        }
    }

    @Override // okhttp3.internal.e.e
    public final Object E(String str) {
        return this.Dt.F(str);
    }

    @Override // okhttp3.internal.e.e
    public final void a(String str, Object obj) {
        if (this.Dt.r(obj)) {
            return;
        }
        a(5, str, (Throwable) null);
    }

    @Override // okhttp3.internal.e.e
    public final boolean isCleartextTrafficPermitted(String str) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), str)).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.isCleartextTrafficPermitted(str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
            throw new AssertionError();
        }
    }

    @Override // okhttp3.internal.e.e
    public final okhttp3.internal.f.b a(X509TrustManager x509TrustManager) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0853a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.a(x509TrustManager);
        }
    }

    public static e hi() {
        Class<?> cls;
        d dVar;
        d dVar2;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            d dVar3 = new d(null, "setUseSessionTickets", Boolean.TYPE);
            d dVar4 = new d(null, "setHostname", String.class);
            try {
                Class.forName("android.net.Network");
                dVar = new d(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                try {
                    dVar2 = new d(null, "setAlpnProtocols", byte[].class);
                } catch (ClassNotFoundException unused2) {
                    dVar2 = null;
                    return new a(cls2, dVar3, dVar4, dVar, dVar2);
                }
            } catch (ClassNotFoundException unused3) {
                dVar = null;
            }
            return new a(cls2, dVar3, dVar4, dVar, dVar2);
        } catch (ClassNotFoundException unused4) {
            return null;
        }
    }

    /* renamed from: okhttp3.internal.e.a$a, reason: collision with other inner class name */
    static final class C0853a extends okhttp3.internal.f.b {
        private final Object Du;
        private final Method Dv;

        public final int hashCode() {
            return 0;
        }

        C0853a(Object obj, Method method) {
            this.Du = obj;
            this.Dv = method;
        }

        @Override // okhttp3.internal.f.b
        public final List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.Dv.invoke(this.Du, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), com.alipay.sdk.m.n.d.a, str);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            }
        }

        public final boolean equals(Object obj) {
            return obj instanceof C0853a;
        }
    }

    static final class b {
        private final Method Dw;
        private final Method Dx;
        private final Method Dy;

        private b(Method method, Method method2, Method method3) {
            this.Dw = method;
            this.Dx = method2;
            this.Dy = method3;
        }

        final Object F(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Method method = this.Dw;
            if (method != null) {
                try {
                    Object objInvoke = method.invoke(null, new Object[0]);
                    this.Dx.invoke(objInvoke, str);
                    return objInvoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        final boolean r(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (obj == null) {
                return false;
            }
            try {
                this.Dy.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        static b hj() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method2 = cls.getMethod(FeedReqParams.REQ_TYPE_OPEN, String.class);
                method = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new b(method3, method2, method);
        }
    }
}
