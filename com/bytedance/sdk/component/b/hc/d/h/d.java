package com.bytedance.sdk.component.b.hc.d.h;

import android.net.ssl.SSLSockets;
import android.os.Build;
import android.util.Log;
import com.bytedance.sdk.component.b.hc.d.tt.an;
import com.bytedance.sdk.component.b.hc.np;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.djx.core.api.req.FeedReqParams;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class d extends u {
    private final b an = b.d();
    private final c<Socket> b;
    private final c<Socket> c;
    private final Class<?> d;
    private final c<Socket> hc;
    private final c<Socket> u;

    d(Class<?> cls, c<Socket> cVar, c<Socket> cVar2, c<Socket> cVar3, c<Socket> cVar4) {
        this.d = cls;
        this.hc = cVar;
        this.b = cVar2;
        this.c = cVar3;
        this.u = cVar4;
    }

    @Override // com.bytedance.sdk.component.b.hc.d.h.u
    public void d(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (!com.bytedance.sdk.component.b.hc.d.b.d(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (ClassCastException e2) {
            if (Build.VERSION.SDK_INT == 26) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e2);
                throw iOException;
            }
            throw e2;
        } catch (SecurityException e3) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e3);
            throw iOException2;
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.b.hc.d.h.u
    public void d(SSLSocket sSLSocket, String str, List<np> list) {
        if (str != null) {
            if (Build.VERSION.SDK_INT >= 30) {
                try {
                    SSLSockets.setUseSessionTickets(sSLSocket, true);
                    SNIHostName sNIHostName = new SNIHostName(str);
                    SSLParameters sSLParameters = sSLSocket.getSSLParameters();
                    sSLParameters.setServerNames(Collections.singletonList(sNIHostName));
                    sSLSocket.setSSLParameters(sSLParameters);
                } catch (Throwable unused) {
                }
            } else {
                this.hc.hc(sSLSocket, Boolean.TRUE);
                this.b.hc(sSLSocket, str);
            }
        }
        c<Socket> cVar = this.u;
        if (cVar == null || !cVar.d((c<Socket>) sSLSocket)) {
            return;
        }
        this.u.c(sSLSocket, hc(list));
    }

    @Override // com.bytedance.sdk.component.b.hc.d.h.u
    public String d(SSLSocket sSLSocket) {
        byte[] bArr;
        c<Socket> cVar = this.c;
        if (cVar == null || !cVar.d((c<Socket>) sSLSocket) || (bArr = (byte[]) this.c.c(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, com.bytedance.sdk.component.b.hc.d.b.u);
    }

    @Override // com.bytedance.sdk.component.b.hc.d.h.u
    public void d(int i, String str, Throwable th) {
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
                mq.d(i2, "OkHttp", str.substring(i3, iMin));
                if (iMin >= iIndexOf) {
                    break;
                } else {
                    i3 = iMin;
                }
            }
            i3 = iMin + 1;
        }
    }

    @Override // com.bytedance.sdk.component.b.hc.d.h.u
    public Object d(String str) {
        return this.an.d(str);
    }

    @Override // com.bytedance.sdk.component.b.hc.d.h.u
    public void d(String str, Object obj) {
        if (this.an.d(obj)) {
            return;
        }
        d(5, str, (Throwable) null);
    }

    @Override // com.bytedance.sdk.component.b.hc.d.h.u
    public boolean hc(String str) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return d(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.hc(str);
        } catch (IllegalAccessException e) {
            e = e;
            throw com.bytedance.sdk.component.b.hc.d.b.d("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e2) {
            e = e2;
            throw com.bytedance.sdk.component.b.hc.d.b.d("unable to determine cleartext support", e);
        } catch (NoClassDefFoundError unused2) {
            if (Build.VERSION.SDK_INT < 23) {
                return super.hc(str);
            }
            return false;
        } catch (InvocationTargetException e3) {
            e = e3;
            throw com.bytedance.sdk.component.b.hc.d.b.d("unable to determine cleartext support", e);
        }
    }

    private boolean d(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return hc(str, cls, obj);
        }
    }

    private boolean hc(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.hc(str);
        }
    }

    private static boolean c() throws ClassNotFoundException {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.component.b.hc.d.h.u
    public com.bytedance.sdk.component.b.hc.d.tt.b d(X509TrustManager x509TrustManager) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0274d(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.d(x509TrustManager);
        }
    }

    public static u d() {
        Class<?> cls;
        c cVar;
        c cVar2;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            c cVar3 = new c(null, "setUseSessionTickets", Boolean.TYPE);
            c cVar4 = new c(null, "setHostname", String.class);
            if (c()) {
                c cVar5 = new c(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                cVar2 = new c(null, "setAlpnProtocols", byte[].class);
                cVar = cVar5;
            } else {
                cVar = null;
                cVar2 = null;
            }
            return new d(cls2, cVar3, cVar4, cVar, cVar2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.b.hc.d.h.u
    public an hc(X509TrustManager x509TrustManager) throws NoSuchMethodException, SecurityException {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new hc(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.hc(x509TrustManager);
        }
    }

    /* renamed from: com.bytedance.sdk.component.b.hc.d.h.d$d, reason: collision with other inner class name */
    static final class C0274d extends com.bytedance.sdk.component.b.hc.d.tt.b {
        private final Object d;
        private final Method hc;

        public int hashCode() {
            return 0;
        }

        C0274d(Object obj, Method method) {
            this.d = obj;
            this.hc = method;
        }

        @Override // com.bytedance.sdk.component.b.hc.d.tt.b
        public List<Certificate> d(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.hc.invoke(this.d, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), com.alipay.sdk.m.n.d.a, str);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0274d;
        }
    }

    static final class b {
        private final Method b;
        private final Method d;
        private final Method hc;

        b(Method method, Method method2, Method method3) {
            this.d = method;
            this.hc = method2;
            this.b = method3;
        }

        Object d(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Method method = this.d;
            if (method != null) {
                try {
                    Object objInvoke = method.invoke(null, new Object[0]);
                    this.hc.invoke(objInvoke, str);
                    return objInvoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        boolean d(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (obj == null) {
                return false;
            }
            try {
                this.b.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        static b d() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
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

    static final class hc implements an {
        private final X509TrustManager d;
        private final Method hc;

        hc(X509TrustManager x509TrustManager, Method method) {
            this.hc = method;
            this.d = x509TrustManager;
        }

        @Override // com.bytedance.sdk.component.b.hc.d.tt.an
        public X509Certificate d(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.hc.invoke(this.d, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
            } catch (IllegalAccessException e) {
                throw com.bytedance.sdk.component.b.hc.d.b.d("unable to get issues and signature", (Exception) e);
            } catch (InvocationTargetException unused) {
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof hc)) {
                return false;
            }
            hc hcVar = (hc) obj;
            return this.d.equals(hcVar.d) && this.hc.equals(hcVar.hc);
        }

        public int hashCode() {
            return this.d.hashCode() + (this.hc.hashCode() * 31);
        }
    }
}
