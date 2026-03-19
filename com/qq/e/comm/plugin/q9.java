package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.n9;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class q9 extends n9 {
    @Override // com.qq.e.comm.plugin.n9
    o9 a(n9.b bVar, String str, String str2, int i) throws Exception {
        int contentLength;
        m9 m9Var = new m9((short) (Math.random() * 65535.0d), i, str2);
        byte[] bArrB = m9Var.b();
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
        httpsURLConnection.setConnectTimeout(3000);
        httpsURLConnection.setReadTimeout(this.d * 1000);
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setRequestMethod("POST");
        httpsURLConnection.setRequestProperty("Content-Type", "application/dns-message");
        httpsURLConnection.setRequestProperty("Accept", "application/dns-message");
        httpsURLConnection.setRequestProperty("Accept-Encoding", "");
        DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
        bVar.a(new a(dataOutputStream, httpsURLConnection));
        dataOutputStream.write(bArrB);
        dataOutputStream.close();
        if (httpsURLConnection.getResponseCode() != 200 || (contentLength = httpsURLConnection.getContentLength()) <= 0 || contentLength > 1048576) {
            return null;
        }
        InputStream inputStream = httpsURLConnection.getInputStream();
        byte[] bArr = new byte[contentLength];
        int i2 = inputStream.read(bArr);
        inputStream.close();
        if (i2 <= 0) {
            return null;
        }
        return new o9(str, 3, m9Var, bArr);
    }

    public q9(String[] strArr, int i, int i2, ExecutorService executorService) {
        super(strArr, i, i2, executorService);
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ DataOutputStream a;
        final /* synthetic */ HttpsURLConnection b;

        a(DataOutputStream dataOutputStream, HttpsURLConnection httpsURLConnection) {
            this.a = dataOutputStream;
            this.b = httpsURLConnection;
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            try {
                this.a.close();
            } catch (Exception unused) {
            }
            try {
                this.b.disconnect();
            } catch (Exception unused2) {
            }
        }
    }
}
