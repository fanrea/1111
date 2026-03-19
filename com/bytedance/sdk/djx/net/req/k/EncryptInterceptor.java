package com.bytedance.sdk.djx.net.req.k;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.sdk.djx.net.ApiConstants;
import com.bytedance.sdk.djx.net.io.Buffer;
import com.bytedance.sdk.djx.net.k3.HttpUrl;
import com.bytedance.sdk.djx.net.k3.Interceptor;
import com.bytedance.sdk.djx.net.k3.Request;
import com.bytedance.sdk.djx.net.k3.RequestBody;
import com.bytedance.sdk.djx.net.k3.Response;
import com.bytedance.sdk.djx.net.k3.ResponseBody;
import com.bytedance.sdk.djx.net.token.TokenHelper;
import com.bytedance.sdk.djx.utils.AES;
import com.bytedance.sdk.djx.utils.Encrypt;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.TimeDiff;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class EncryptInterceptor implements Interceptor {
    private static final String TAG = "EncryptInterceptor";
    private static volatile EncryptInterceptor sInstance;
    private String partner;

    public static EncryptInterceptor build(String str) {
        if (sInstance == null) {
            sInstance = new EncryptInterceptor(str);
        }
        return sInstance;
    }

    private EncryptInterceptor(String str) {
        this.partner = str;
    }

    @Override // com.bytedance.sdk.djx.net.k3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response responseProceed = chain.proceed(handleRequest(chain.request()));
        handleServerTime(responseProceed);
        return handleResponse(responseProceed);
    }

    private void handleServerTime(Response response) {
        try {
            long jLongValue = Long.valueOf(response.header(ApiConstants.KEY_TIME, "0")).longValue();
            if (jLongValue > 0) {
                TimeDiff.getInstance().update((jLongValue * 1000) - System.currentTimeMillis());
            }
        } catch (Throwable unused) {
        }
    }

    private boolean isSafeUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String host = Uri.parse(ApiConstants.getHost()).getHost();
            String host2 = Uri.parse(str).getHost();
            if (host2 != null) {
                return host2.endsWith(host);
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private Response handleResponse(Response response) throws IOException {
        HttpUrl httpUrlUrl;
        String strHeader = response.header(ApiConstants.KEY_SALT);
        String strHeader2 = response.header(ApiConstants.KEY_LOGID);
        if (TextUtils.isEmpty(strHeader)) {
            return response;
        }
        try {
            ResponseBody responseBodyBody = response.body();
            byte[] bArrDecrypt = AES.decrypt(Base64.decode(responseBodyBody.bytes(), 0), Encrypt.buildAesKey(strHeader));
            if (bArrDecrypt == null) {
                bArrDecrypt = new byte[0];
                String str = null;
                if (response.request() != null && (httpUrlUrl = response.request().url()) != null) {
                    str = httpUrlUrl.host() + httpUrlUrl.encodedPath();
                }
                LG.e(TAG, "decrypt error, decodedBytes is null, request url: " + str);
            }
            return response.newBuilder().body(ResponseBody.create(responseBodyBody.getMediaType(), bArrDecrypt)).build();
        } catch (IllegalArgumentException e) {
            LG.e(TAG, "decrypt error, bad base-64, logid: " + strHeader2);
            throw new IOException("bad base-64", e);
        }
    }

    private Request handleRequest(Request request) throws IOException {
        String strEncodeToString;
        if (!"POST".equalsIgnoreCase(request.method())) {
            return request;
        }
        String strSalt = Encrypt.salt();
        String token = TokenHelper.getInstance().getToken();
        String strNonce = Encrypt.nonce();
        String strValueOf = String.valueOf(TimeDiff.getInstance().getServerTime() / 1000);
        boolean z = !TextUtils.isEmpty(strSalt);
        RequestBody requestBodyBody = request.body();
        Buffer buffer = new Buffer();
        requestBodyBody.writeTo(buffer);
        String utf8 = buffer.readUtf8();
        if (z) {
            strEncodeToString = Base64.encodeToString(AES.encrypt(utf8.getBytes(), Encrypt.buildAesKey(strSalt)), 0);
        } else {
            strEncodeToString = "";
        }
        String strSign2 = Encrypt.sign2(strValueOf, strNonce, utf8);
        HttpUrl httpUrlUrl = request.url();
        if (TextUtils.isEmpty(httpUrlUrl.queryParameter("siteid"))) {
            httpUrlUrl = httpUrlUrl.newBuilder().addQueryParameter("siteid", takeParam(requestBodyBody, "siteid")).build();
        }
        Request.Builder builderUrl = request.newBuilder().url(httpUrlUrl);
        if (z) {
            builderUrl.post(RequestBody.create(requestBodyBody.contentType(), strEncodeToString));
        }
        if (z) {
            builderUrl.addHeader(ApiConstants.KEY_SALT, strSalt);
        }
        if (!TextUtils.isEmpty(strNonce)) {
            builderUrl.addHeader(ApiConstants.KEY_NONCE, strNonce);
        }
        builderUrl.addHeader(ApiConstants.KEY_TIME, strValueOf);
        if (!TextUtils.isEmpty(token)) {
            builderUrl.addHeader(ApiConstants.KEY_TOKEN, token);
        }
        if (!TextUtils.isEmpty(strSign2)) {
            builderUrl.addHeader(ApiConstants.KEY_SIGN, strSign2);
        }
        return builderUrl.build();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
    
        r4.partner = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String takeParam(com.bytedance.sdk.djx.net.k3.RequestBody r5, java.lang.String r6) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.bytedance.sdk.djx.net.k3.FormBody     // Catch: java.lang.Throwable -> L27
            if (r0 == 0) goto L27
            com.bytedance.sdk.djx.net.k3.FormBody r5 = (com.bytedance.sdk.djx.net.k3.FormBody) r5     // Catch: java.lang.Throwable -> L27
            int r0 = r5.size()     // Catch: java.lang.Throwable -> L27
            r1 = 0
        Lb:
            if (r1 >= r0) goto L27
            java.lang.String r2 = r5.encodedName(r1)     // Catch: java.lang.Throwable -> L27
            boolean r2 = r6.equalsIgnoreCase(r2)     // Catch: java.lang.Throwable -> L27
            if (r2 == 0) goto L24
            java.lang.String r2 = r5.encodedValue(r1)     // Catch: java.lang.Throwable -> L27
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L27
            if (r3 != 0) goto L24
            r4.partner = r2     // Catch: java.lang.Throwable -> L27
            goto L27
        L24:
            int r1 = r1 + 1
            goto Lb
        L27:
            java.lang.String r5 = r4.partner
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.djx.net.req.k.EncryptInterceptor.takeParam(com.bytedance.sdk.djx.net.k3.RequestBody, java.lang.String):java.lang.String");
    }
}
