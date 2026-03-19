package com.bytedance.sdk.component.b.hc.d.h;

import com.bytedance.sdk.component.b.hc.d.tt.an;
import com.bytedance.sdk.component.b.hc.np;
import com.bytedance.sdk.component.b.hc.v;
import com.bytedance.sdk.component.utils.mq;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u {
    private static final u d = d();
    private static final Logger hc = Logger.getLogger(v.class.getName());

    public String b() {
        return "OkHttp";
    }

    public String d(SSLSocket sSLSocket) {
        return null;
    }

    public void d(SSLSocket sSLSocket, String str, List<np> list) {
    }

    public void hc(SSLSocket sSLSocket) {
    }

    public boolean hc(String str) {
        return true;
    }

    public static u hc() {
        return d;
    }

    public void d(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public void d(int i, String str, Throwable th) {
        hc.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object d(String str) {
        if (hc.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void d(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        d(5, str, (Throwable) obj);
    }

    public static List<String> d(List<np> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            np npVar = list.get(i);
            if (npVar != np.HTTP_1_0) {
                arrayList.add(npVar.toString());
            }
        }
        return arrayList;
    }

    public com.bytedance.sdk.component.b.hc.d.tt.b d(X509TrustManager x509TrustManager) {
        return new com.bytedance.sdk.component.b.hc.d.tt.d(hc(x509TrustManager));
    }

    private static u d() {
        u uVarD = d.d();
        if (uVarD != null) {
            return uVarD;
        }
        hc hcVarD = hc.d();
        if (hcVarD != null) {
            return hcVarD;
        }
        u uVarD2 = b.d();
        return uVarD2 != null ? uVarD2 : new u();
    }

    static byte[] hc(List<np> list) {
        com.bytedance.sdk.component.b.d.b bVar = new com.bytedance.sdk.component.b.d.b();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            np npVar = list.get(i);
            if (npVar != np.HTTP_1_0) {
                bVar.tt(npVar.toString().length());
                bVar.hc(npVar.toString());
            }
        }
        try {
            return bVar.w();
        } catch (IOException e) {
            mq.d(e);
            return null;
        }
    }

    public an hc(X509TrustManager x509TrustManager) {
        return new com.bytedance.sdk.component.b.hc.d.tt.hc(x509TrustManager.getAcceptedIssuers());
    }
}
