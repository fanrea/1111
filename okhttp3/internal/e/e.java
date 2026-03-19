package okhttp3.internal.e;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okio.Buffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class e {
    private static final e DK = hm();
    private static final Logger logger = Logger.getLogger(OkHttpClient.class.getName());

    public static String getPrefix() {
        return "OkHttp";
    }

    public void a(SSLSocket sSLSocket, String str, List<Protocol> list) {
    }

    public String c(SSLSocket sSLSocket) {
        return null;
    }

    public void d(SSLSocket sSLSocket) {
    }

    public boolean isCleartextTrafficPermitted(String str) {
        return true;
    }

    public static e hl() {
        return DK;
    }

    public X509TrustManager a(SSLSocketFactory sSLSocketFactory) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Object objA = a(sSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
            if (objA == null) {
                return null;
            }
            return (X509TrustManager) a(objA, X509TrustManager.class, "trustManager");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public void a(int i, String str, Throwable th) {
        logger.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object E(String str) {
        if (logger.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        a(5, str, (Throwable) obj);
    }

    public static List<String> l(List<Protocol> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                arrayList.add(protocol.getProtocol());
            }
        }
        return arrayList;
    }

    public okhttp3.internal.f.b a(X509TrustManager x509TrustManager) {
        return new okhttp3.internal.f.a(okhttp3.internal.f.e.c(x509TrustManager));
    }

    private static e hm() {
        e eVarHi = a.hi();
        if (eVarHi != null) {
            return eVarHi;
        }
        b bVarHk = b.hk();
        if (bVarHk != null) {
            return bVarHk;
        }
        e eVarHi2 = c.hi();
        return eVarHi2 != null ? eVarHi2 : new e();
    }

    static byte[] m(List<Protocol> list) {
        Buffer buffer = new Buffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                buffer.writeByte(protocol.getProtocol().length());
                buffer.writeUtf8(protocol.getProtocol());
            }
        }
        return buffer.readByteArray();
    }

    static <T> T a(Object obj, Class<T> cls, String str) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        do {
            for (Class<?> superclass = obj.getClass(); superclass != Object.class; superclass = superclass.getSuperclass()) {
                try {
                    Field declaredField = superclass.getDeclaredField(str);
                    declaredField.setAccessible(true);
                    Object obj2 = declaredField.get(obj);
                    if (obj2 != null && cls.isInstance(obj2)) {
                        return cls.cast(obj2);
                    }
                    return null;
                } catch (IllegalAccessException unused) {
                    throw new AssertionError();
                } catch (NoSuchFieldException unused2) {
                }
            }
            if (str.equals("delegate")) {
                break;
            }
            obj = a(obj, (Class<Object>) Object.class, "delegate");
        } while (obj != null);
        return null;
    }
}
