package com.bytedance.sdk.component.b.hc.d.h;

import com.bytedance.sdk.component.b.hc.np;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class hc extends u {
    final Method d;
    final Method hc;

    hc(Method method, Method method2) {
        this.d = method;
        this.hc = method2;
    }

    @Override // com.bytedance.sdk.component.b.hc.d.h.u
    public void d(SSLSocket sSLSocket, String str, List<np> list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> listD = d(list);
            this.d.invoke(sSLParameters, listD.toArray(new String[listD.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.bytedance.sdk.component.b.hc.d.b.d("unable to set ssl parameters", (Exception) e);
        }
    }

    @Override // com.bytedance.sdk.component.b.hc.d.h.u
    public String d(SSLSocket sSLSocket) {
        try {
            String str = (String) this.hc.invoke(sSLSocket, new Object[0]);
            if (str == null) {
                return null;
            }
            if (str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.bytedance.sdk.component.b.hc.d.b.d("unable to get selected protocols", (Exception) e);
        }
    }

    public static hc d() {
        try {
            return new hc(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
