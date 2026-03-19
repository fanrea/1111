package com.baidu.mobstat.forbes.util;

import android.text.TextUtils;
import com.sigmob.sdk.archives.tar.e;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class OkHttpRequestManager {

    public class GzipRequestInterceptor implements Interceptor {
        public GzipRequestInterceptor() {
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) {
            Request request = chain.request();
            if (request.body() == null) {
                return chain.proceed(request.newBuilder().header("Content-Encoding", "gzip").build());
            }
            if (request.header("Content-Encoding") != null) {
                return chain.proceed(request);
            }
            return chain.proceed(request.newBuilder().header("Content-Encoding", "gzip").method(request.method(), forceContentLength(gzip(request.body(), request.url().getUrl()))).build());
        }

        private RequestBody forceContentLength(final RequestBody requestBody) throws IOException {
            final Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);
            return new RequestBody() { // from class: com.baidu.mobstat.forbes.util.OkHttpRequestManager.GzipRequestInterceptor.1
                @Override // okhttp3.RequestBody
                /* renamed from: contentType */
                public MediaType getContentType() {
                    return requestBody.getContentType();
                }

                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return buffer.size();
                }

                @Override // okhttp3.RequestBody
                public void writeTo(BufferedSink bufferedSink) throws IOException {
                    bufferedSink.write(buffer.snapshot());
                }
            };
        }

        private RequestBody gzip(final RequestBody requestBody, final String str) {
            return new RequestBody() { // from class: com.baidu.mobstat.forbes.util.OkHttpRequestManager.GzipRequestInterceptor.2
                @Override // okhttp3.RequestBody
                /* renamed from: contentType */
                public MediaType getContentType() {
                    return requestBody.getContentType();
                }

                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return -1L;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(BufferedSink bufferedSink) throws IOException {
                    BufferedSink bufferedSinkBuffer = Okio.buffer(new GzipSink(bufferedSink));
                    if (!TextUtils.isEmpty(str) && str.contains("bplus.gif")) {
                        bufferedSinkBuffer.write(new byte[]{72, 77, e.H, e.I});
                        bufferedSinkBuffer.write(new byte[]{0, 0, 0, 1});
                        bufferedSinkBuffer.write(new byte[]{0, 0, 3, -14});
                        bufferedSinkBuffer.write(new byte[]{0, 0, 0, 0, 0, 0, 0, 0});
                        bufferedSinkBuffer.write(new byte[]{0, 2});
                        bufferedSinkBuffer.write(new byte[]{0, 0});
                        bufferedSinkBuffer.write(new byte[]{72, 77, e.H, e.I});
                    }
                    requestBody.writeTo(bufferedSinkBuffer);
                    bufferedSinkBuffer.close();
                }
            };
        }
    }
}
