package com.kwai.middleware.azeroth.utils;

import com.kwai.middleware.azeroth.Azeroth;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class SSLUtils {
    public static SSLSocketFactory getStandardSocketFactory() throws NoSuchAlgorithmException, KeyManagementException {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLSv1");
            sSLContext.init(null, null, null);
            return sSLContext.getSocketFactory();
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static SSLSocketFactory getIgnoreAllSocketFactory() throws NoSuchAlgorithmException, KeyManagementException {
        try {
            TrustManager[] trustManagerArr = {new X509TrustManager() { // from class: com.kwai.middleware.azeroth.utils.SSLUtils.1
                @Override // javax.net.ssl.X509TrustManager
                public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
                }

                @Override // javax.net.ssl.X509TrustManager
                public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
                }

                @Override // javax.net.ssl.X509TrustManager
                public final X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            }};
            SSLContext sSLContext = SSLContext.getInstance("TLSv1");
            sSLContext.init(null, trustManagerArr, null);
            return sSLContext.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void configureKeyStore(KeyStore keyStore, int i, String str) throws IOException {
        InputStream inputStreamOpenRawResource = null;
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            inputStreamOpenRawResource = Azeroth.get().getContext().getResources().openRawResource(i);
            keyStore.setCertificateEntry(str, certificateFactory.generateCertificate(inputStreamOpenRawResource));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseableUtils.closeQuietly(inputStreamOpenRawResource);
        }
    }
}
