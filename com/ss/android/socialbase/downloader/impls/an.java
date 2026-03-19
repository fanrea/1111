package com.ss.android.socialbase.downloader.impls;

import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class an implements com.ss.android.socialbase.downloader.tt.gb {
    @Override // com.ss.android.socialbase.downloader.tt.gb
    public com.ss.android.socialbase.downloader.tt.h d(String str, List<com.ss.android.socialbase.downloader.h.u> list) throws IOException {
        OkHttpClient okHttpClientYo = com.ss.android.socialbase.downloader.downloader.b.yo();
        if (okHttpClientYo == null) {
            throw new IOException("can't get httpClient");
        }
        Request.Builder builderHead = new Request.Builder().url(str).head();
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.h.u uVar : list) {
                builderHead.addHeader(uVar.d(), com.ss.android.socialbase.downloader.e.an.h(uVar.hc()));
            }
        }
        final Call callNewCall = okHttpClientYo.newCall(builderHead.build());
        final Response responseExecute = callNewCall.execute();
        if (responseExecute == null) {
            throw new IOException("can't get response");
        }
        if (com.ss.android.socialbase.downloader.e.d.d(2097152)) {
            responseExecute.close();
        }
        return new com.ss.android.socialbase.downloader.tt.h() { // from class: com.ss.android.socialbase.downloader.impls.an.1
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
        };
    }
}
