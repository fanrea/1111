package com.ss.android.socialbase.downloader.impls;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.GZIPInputStream;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class h implements com.ss.android.socialbase.downloader.tt.tc {
    private final com.ss.android.socialbase.downloader.e.gb<String, OkHttpClient> d = new com.ss.android.socialbase.downloader.e.gb<>(4, 8);

    @Override // com.ss.android.socialbase.downloader.tt.tc
    public com.ss.android.socialbase.downloader.tt.tt d(int i, String str, List<com.ss.android.socialbase.downloader.h.u> list) throws IOException {
        String strHc;
        OkHttpClient okHttpClientYo;
        Request.Builder builderUrl = new Request.Builder().url(str);
        if (list == null || list.size() <= 0) {
            strHc = null;
        } else {
            strHc = null;
            for (com.ss.android.socialbase.downloader.h.u uVar : list) {
                String strD = uVar.d();
                if (strHc == null && "ss_d_request_host_ip_114".equals(strD)) {
                    strHc = uVar.hc();
                } else {
                    builderUrl.addHeader(strD, com.ss.android.socialbase.downloader.e.an.h(uVar.hc()));
                }
            }
        }
        if (!TextUtils.isEmpty(strHc)) {
            okHttpClientYo = d(str, strHc);
        } else {
            okHttpClientYo = com.ss.android.socialbase.downloader.downloader.b.yo();
        }
        if (okHttpClientYo == null) {
            throw new IOException("can't get httpClient");
        }
        final Call callNewCall = okHttpClientYo.newCall(builderUrl.build());
        final Response responseExecute = callNewCall.execute();
        if (responseExecute == null) {
            throw new IOException("can't get response");
        }
        final ResponseBody responseBodyBody = responseExecute.body();
        if (responseBodyBody == null) {
            return null;
        }
        InputStream inputStreamByteStream = responseBodyBody.byteStream();
        String strHeader = responseExecute.header("Content-Encoding");
        final InputStream gZIPInputStream = (strHeader == null || !"gzip".equalsIgnoreCase(strHeader) || (inputStreamByteStream instanceof GZIPInputStream)) ? inputStreamByteStream : new GZIPInputStream(inputStreamByteStream);
        return new com.ss.android.socialbase.downloader.tt.u() { // from class: com.ss.android.socialbase.downloader.impls.h.1
            @Override // com.ss.android.socialbase.downloader.tt.d
            public String u() {
                return "";
            }

            @Override // com.ss.android.socialbase.downloader.tt.tt
            public InputStream d() throws IOException {
                return gZIPInputStream;
            }

            @Override // com.ss.android.socialbase.downloader.tt.h
            public String d(String str2) {
                return responseExecute.header(str2);
            }

            @Override // com.ss.android.socialbase.downloader.tt.h
            public int hc() throws IOException {
                return responseExecute.code();
            }

            @Override // com.ss.android.socialbase.downloader.tt.h
            public void b() {
                Call call = callNewCall;
                if (call == null || call.getCanceled()) {
                    return;
                }
                callNewCall.cancel();
            }

            @Override // com.ss.android.socialbase.downloader.tt.tt
            public void c() {
                try {
                    ResponseBody responseBody = responseBodyBody;
                    if (responseBody != null) {
                        responseBody.close();
                    }
                    Call call = callNewCall;
                    if (call == null || call.getCanceled()) {
                        return;
                    }
                    callNewCall.cancel();
                } catch (Throwable unused) {
                }
            }
        };
    }

    private OkHttpClient d(String str, final String str2) {
        try {
            final String host = Uri.parse(str).getHost();
            if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(str2)) {
                String str3 = host + Config.replace + str2;
                synchronized (this.d) {
                    OkHttpClient okHttpClient = this.d.get(str3);
                    if (okHttpClient != null) {
                        return okHttpClient;
                    }
                    OkHttpClient.Builder builderJh = com.ss.android.socialbase.downloader.downloader.b.jh();
                    builderJh.dns(new Dns() { // from class: com.ss.android.socialbase.downloader.impls.h.2
                    });
                    OkHttpClient okHttpClientBuild = builderJh.build();
                    synchronized (this.d) {
                        this.d.put(str3, okHttpClientBuild);
                    }
                    return okHttpClientBuild;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
        return com.ss.android.socialbase.downloader.downloader.b.yo();
    }
}
