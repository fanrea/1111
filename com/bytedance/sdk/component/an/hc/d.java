package com.bytedance.sdk.component.an.hc;

import com.bytedance.sdk.component.utils.mq;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d implements com.bytedance.sdk.component.an.c<c> {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v7 */
    @Override // com.bytedance.sdk.component.an.c
    public c<byte[]> call(com.bytedance.sdk.component.an.u uVar) throws Throwable {
        Closeable closeable;
        InputStream inputStream;
        byte[] byteArray;
        ByteArrayOutputStream byteArrayOutputStream;
        String message;
        Closeable closeable2;
        HttpURLConnection httpURLConnection;
        int i = 0;
        InputStream inputStream2 = null;
        Map<String, String> mapD = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(uVar.d()).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.connect();
                inputStream = httpURLConnection.getInputStream();
            } catch (MalformedURLException e) {
                e = e;
                inputStream = null;
                byteArray = null;
            } catch (IOException e2) {
                e = e2;
                inputStream = null;
                byteArray = null;
            } catch (Throwable th) {
                th = th;
                closeable = null;
                com.bytedance.sdk.component.an.b.b.hc.d(inputStream2);
                com.bytedance.sdk.component.an.b.b.hc.d(closeable);
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    try {
                        int i2 = inputStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i2);
                    } catch (MalformedURLException e3) {
                        e = e3;
                        byteArray = null;
                    } catch (IOException e4) {
                        e = e4;
                        byteArray = null;
                    }
                }
                i = 200;
                byteArray = byteArrayOutputStream.toByteArray();
            } catch (MalformedURLException e5) {
                e = e5;
                byteArray = null;
                byteArrayOutputStream = byteArray;
                mq.hc("InternalHttpClient", "MalformedURLException:" + e.getMessage());
                message = e.getMessage();
                closeable2 = byteArrayOutputStream;
                com.bytedance.sdk.component.an.b.b.hc.d(inputStream);
                com.bytedance.sdk.component.an.b.b.hc.d(closeable2);
                return new c<>(i, byteArray, message, mapD);
            } catch (IOException e6) {
                e = e6;
                byteArray = null;
                byteArrayOutputStream = byteArray;
                mq.hc("InternalHttpClient", "IOException:" + e.getMessage());
                message = e.getMessage();
                closeable2 = byteArrayOutputStream;
                com.bytedance.sdk.component.an.b.b.hc.d(inputStream);
                com.bytedance.sdk.component.an.b.b.hc.d(closeable2);
                return new c<>(i, byteArray, message, mapD);
            } catch (Throwable th2) {
                th = th2;
                closeable = null;
                inputStream2 = inputStream;
                com.bytedance.sdk.component.an.b.b.hc.d(inputStream2);
                com.bytedance.sdk.component.an.b.b.hc.d(closeable);
                throw th;
            }
            try {
                mapD = uVar.hc() ? d(httpURLConnection) : null;
                com.bytedance.sdk.component.an.b.b.hc.d(inputStream);
                com.bytedance.sdk.component.an.b.b.hc.d(byteArrayOutputStream);
                message = "success";
            } catch (MalformedURLException e7) {
                e = e7;
                mq.hc("InternalHttpClient", "MalformedURLException:" + e.getMessage());
                message = e.getMessage();
                closeable2 = byteArrayOutputStream;
                com.bytedance.sdk.component.an.b.b.hc.d(inputStream);
                com.bytedance.sdk.component.an.b.b.hc.d(closeable2);
                return new c<>(i, byteArray, message, mapD);
            } catch (IOException e8) {
                e = e8;
                mq.hc("InternalHttpClient", "IOException:" + e.getMessage());
                message = e.getMessage();
                closeable2 = byteArrayOutputStream;
                com.bytedance.sdk.component.an.b.b.hc.d(inputStream);
                com.bytedance.sdk.component.an.b.b.hc.d(closeable2);
                return new c<>(i, byteArray, message, mapD);
            }
            return new c<>(i, byteArray, message, mapD);
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private Map<String, String> d(HttpURLConnection httpURLConnection) {
        HashMap map = new HashMap();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        for (String str : headerFields.keySet()) {
            List<String> list = headerFields.get(str);
            if (list != null && list.size() > 0) {
                map.put(str, list.get(0));
            }
        }
        return map;
    }
}
