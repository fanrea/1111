package com.apm.insight.n;

import com.apm.applog.network.INetworkClient;
import com.apm.applog.network.NetworkResponse;
import com.bytedance.apm.common.utility.NetworkUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class h implements INetworkClient {
    private static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (-1 == i) {
                inputStream.close();
                try {
                    return byteArrayOutputStream.toByteArray();
                } finally {
                    com.apm.insight.o.l.a(byteArrayOutputStream);
                }
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    @Override // com.apm.applog.network.INetworkClient
    public NetworkResponse get(String str, Map<String, String> map) {
        return null;
    }

    @Override // com.apm.applog.network.INetworkClient
    public NetworkResponse post(String str, byte[] bArr, Map<String, String> map) {
        InputStream inputStream;
        GZIPInputStream gZIPInputStream;
        byte[] bArrA;
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection = null;
        GZIPInputStream gZIPInputStream2 = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                NetworkUtils.setupSSLFactory(httpURLConnection2);
                httpURLConnection2.setDoOutput(true);
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection2.setRequestMethod("POST");
                if (bArr != null && bArr.length > 0) {
                    try {
                        dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                    } catch (Throwable th) {
                        th = th;
                        dataOutputStream = null;
                    }
                    try {
                        dataOutputStream.write(bArr);
                        dataOutputStream.flush();
                        com.apm.insight.o.l.a(dataOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        com.apm.insight.o.l.a(dataOutputStream);
                        throw th;
                    }
                }
                int responseCode = httpURLConnection2.getResponseCode();
                if (responseCode != 200) {
                    NetworkResponse networkResponse = new NetworkResponse(206, ("http response code " + responseCode).getBytes());
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                        } catch (Exception unused) {
                        }
                    }
                    com.apm.insight.o.l.a((Closeable) null);
                    return networkResponse;
                }
                InputStream inputStream2 = httpURLConnection2.getInputStream();
                try {
                    if ("gzip".equalsIgnoreCase(httpURLConnection2.getContentEncoding())) {
                        try {
                            gZIPInputStream = new GZIPInputStream(inputStream2);
                        } catch (Throwable th3) {
                            th = th3;
                        }
                        try {
                            bArrA = a(gZIPInputStream);
                            com.apm.insight.o.l.a(gZIPInputStream);
                        } catch (Throwable th4) {
                            th = th4;
                            gZIPInputStream2 = gZIPInputStream;
                            com.apm.insight.o.l.a(gZIPInputStream2);
                            throw th;
                        }
                    } else {
                        bArrA = a(inputStream2);
                    }
                    NetworkResponse networkResponse2 = new NetworkResponse(200, bArrA);
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                        } catch (Exception unused2) {
                        }
                    }
                    com.apm.insight.o.l.a(inputStream2);
                    return networkResponse2;
                } catch (Throwable th5) {
                    httpURLConnection = httpURLConnection2;
                    inputStream = inputStream2;
                    th = th5;
                    try {
                        com.apm.insight.o.q.a(th);
                        return new NetworkResponse(207, ("http response " + th.getMessage()).getBytes());
                    } finally {
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception unused3) {
                            }
                        }
                        com.apm.insight.o.l.a(inputStream);
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                httpURLConnection = httpURLConnection2;
                inputStream = null;
            }
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
        }
    }
}
