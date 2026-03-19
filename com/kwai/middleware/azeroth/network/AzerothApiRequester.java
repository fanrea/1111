package com.kwai.middleware.azeroth.network;

import android.net.Uri;
import android.util.Pair;
import com.alipay.sdk.m.l.a;
import com.kwai.middleware.azeroth.Azeroth;
import com.kwai.middleware.azeroth.async.Async;
import com.kwai.middleware.azeroth.interfaces.JsonAdapter;
import com.kwai.middleware.azeroth.network.interceptor.HeadersInterceptor;
import com.kwai.middleware.azeroth.network.interceptor.ParamsInterceptor;
import com.kwai.middleware.azeroth.utils.Callback;
import com.kwai.middleware.azeroth.utils.CloseableUtils;
import com.kwai.middleware.azeroth.utils.SSLUtils;
import com.kwai.middleware.azeroth.utils.TextUtils;
import com.kwai.middleware.azeroth.utils.Utils;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class AzerothApiRequester {
    public static final int DEFAULT_API_TIMEOUT_MS = 15000;
    private static final int DEFAULT_DELAY_RETRY_MS = 2000;
    private static final int DEFAULT_MAX_RETRY_COUNT = 3;
    private static final String KEY_CONTENT_TYPE = "Content-Type";
    private static final String PREFIX_URL_PATH = "/rest/zt/%s/%s";
    private static final String PREFIX_URL_PATH_STARTS_WITH = "/rest/";
    private static final String VALUE_CONTENT_TYPE = "application/octet-stream";
    private final AzerothApiParams mApiParams;
    private final IApiRouter mApiRouter;
    private final Uri mBaseHttpUrl;
    private final Executor mExecutor;
    private final HeadersInterceptor mHeadersInterceptor;
    private final boolean mIgnorePathVerify;
    private final int mMaxRetryCount;
    private final boolean mObserveOnMainThread;
    private final ParamsInterceptor mParamsInterceptor;
    private final String mSdkName;
    private final String mSpecialHost;
    private final String mSubBiz;
    private final boolean mUseHttps;
    private static final ThreadPoolExecutor NETWORKING_EXECUTOR = Async.newFixedThreadPoolExecutor("azeroth-api-thread", 4);
    private static final IApiRouter DEFAULT_API_ROUTER = new AzerothApiRouter();

    private AzerothApiRequester(String str, String str2, String str3, boolean z, boolean z2, Executor executor, boolean z3, IApiRouter iApiRouter, int i, AzerothApiParams azerothApiParams) {
        this.mSdkName = str2;
        this.mSubBiz = str;
        this.mSpecialHost = str3;
        this.mUseHttps = z;
        this.mIgnorePathVerify = z2;
        this.mExecutor = executor;
        this.mObserveOnMainThread = z3;
        this.mApiRouter = iApiRouter;
        this.mMaxRetryCount = i;
        this.mApiParams = azerothApiParams;
        this.mParamsInterceptor = new ParamsInterceptor(this.mApiParams);
        this.mHeadersInterceptor = new HeadersInterceptor(this.mApiParams);
        str3 = TextUtils.isEmpty(str3) ? this.mApiRouter.getHost() : str3;
        Utils.checkNotNullOrEmpty(str3, "host cannot be null");
        if (!str3.startsWith(a.r)) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.mUseHttps ? "https://" : "http://");
            sb.append(str3);
            str3 = sb.toString();
        }
        this.mBaseHttpUrl = Uri.parse(str3);
        Utils.checkNotNullOrEmpty(this.mBaseHttpUrl, "host cannot parse to HttpUrl");
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public <T extends JsonAdapter> void doGetRequest(String str, Map<String, String> map, Class<T> cls, Callback<T> callback) {
        doRequest(str, "GET", null, map, null, cls, callback);
    }

    public <T extends JsonAdapter> void doPostRequest(String str, Map<String, String> map, Class<T> cls, Callback<T> callback) {
        doPostRequest(str, null, map, cls, callback);
    }

    public <T extends JsonAdapter> void doPostRequest(String str, Map<String, String> map, Map<String, String> map2, Class<T> cls, Callback<T> callback) {
        doRequest(str, "POST", null, map, map2, cls, callback);
    }

    public <T extends JsonAdapter> void doPostStreamRequest(String str, Map<String, String> map, byte[] bArr, Class<T> cls, Callback<T> callback) {
        HashMap map2 = new HashMap();
        map2.put(KEY_CONTENT_TYPE, "application/octet-stream");
        doRequest(str, "POST", map2, map, null, bArr, cls, callback);
    }

    public <T extends JsonAdapter> void doRequest(String str, String str2, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Class<T> cls, Callback<T> callback) {
        doRequest(str, str2, map, map2, map3, null, cls, callback);
    }

    public <T extends JsonAdapter> void doRequest(final String str, final String str2, final Map<String, String> map, final Map<String, String> map2, final Map<String, String> map3, final byte[] bArr, final Class<T> cls, final Callback<T> callback) {
        this.mExecutor.execute(new Runnable() { // from class: com.kwai.middleware.azeroth.network.AzerothApiRequester.1
            @Override // java.lang.Runnable
            public void run() throws InterruptedException {
                Throwable th;
                Uri uriProcessRequestInternal = AzerothApiRequester.this.mBaseHttpUrl;
                int i = 0;
                do {
                    th = null;
                    try {
                        uriProcessRequestInternal = AzerothApiRequester.this.processRequestInternal(uriProcessRequestInternal, str, str2, map, map2, map3, bArr, cls, callback);
                    } catch (Throwable th2) {
                        th = th2;
                        if (TextUtils.isEmpty(AzerothApiRequester.this.mSpecialHost)) {
                            AzerothApiRequester.this.mApiRouter.switchHost();
                        }
                    }
                    try {
                        Thread.sleep(Utils.random(((long) Math.pow(2.0d, i)) * 2000));
                    } catch (InterruptedException unused) {
                    }
                    i++;
                    if (th == null) {
                        break;
                    }
                } while (i <= AzerothApiRequester.this.mMaxRetryCount);
                if (th != null) {
                    AzerothApiRequester.this.onFailure(callback, th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends JsonAdapter> Uri processRequestInternal(Uri uri, String str, String str2, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, byte[] bArr, Class<T> cls, Callback<T> callback) throws IOException {
        Utils.checkNotNullOrEmpty(str, "url cannot be null or empty");
        Utils.checkNotNull(str2, "http method cannot be null");
        Utils.checkNotNull(cls, "modelClass cannot be null");
        Utils.checkNotNull(callback, "callback cannot be null");
        Uri uri2 = Uri.parse(str);
        Utils.checkNotNullOrEmpty(uri2, "urlPath cannot parse success");
        if (!TextUtils.isEmpty(uri2.getScheme())) {
            throw new IllegalArgumentException("urlPath cannot contains scheme. You can only assign host by method AzerothApiRequester.Builder().specialHost()!");
        }
        String encodedPath = uri2.getEncodedPath();
        Uri.Builder builderBuildUpon = uri.buildUpon();
        if (!this.mIgnorePathVerify && !encodedPath.startsWith(PREFIX_URL_PATH_STARTS_WITH)) {
            encodedPath = String.format(Locale.US, PREFIX_URL_PATH, this.mSdkName, encodedPath);
        }
        String encodedPath2 = this.mBaseHttpUrl.getEncodedPath();
        if (!TextUtils.isEmpty(encodedPath2)) {
            if (encodedPath2.endsWith("/")) {
                encodedPath2 = encodedPath2.substring(0, encodedPath2.length() - 1);
            }
            encodedPath = encodedPath2 + encodedPath;
        }
        builderBuildUpon.encodedPath(encodedPath);
        if (map2 == null) {
            map2 = new HashMap<>();
        }
        if (!android.text.TextUtils.isEmpty(this.mSubBiz)) {
            map2.put("subBiz", this.mSubBiz);
        }
        interceptBase(builderBuildUpon);
        interceptParams(builderBuildUpon, map2);
        Set<String> queryParameterNames = uri2.getQueryParameterNames();
        if (queryParameterNames != null && !queryParameterNames.isEmpty()) {
            for (String str3 : queryParameterNames) {
                builderBuildUpon.appendQueryParameter(str3, uri2.getQueryParameter(str3));
            }
        }
        Pair<Uri.Builder, Map<String, String>> pairIntercept = this.mParamsInterceptor.intercept(builderBuildUpon.build(), str2, map2, map3);
        if (bArr != null && pairIntercept.second != null && !((Map) pairIntercept.second).isEmpty()) {
            for (Map.Entry entry : ((Map) pairIntercept.second).entrySet()) {
                ((Uri.Builder) pairIntercept.first).appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
            }
        }
        Uri uriBuild = ((Uri.Builder) pairIntercept.first).build();
        URL url = new URL(uriBuild.toString());
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        interceptBase(httpURLConnection, str2);
        interceptHeaders(httpURLConnection, map);
        try {
            httpURLConnection.connect();
            if ("POST".equals(str2)) {
                if (bArr != null) {
                    interceptPostBody(httpURLConnection, bArr);
                } else {
                    interceptPostBody(httpURLConnection, RequestUtil.paramsToString((Map) pairIntercept.second));
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                processResponse(RequestUtil.read(httpURLConnection.getInputStream()), cls, callback);
                return uriBuild;
            }
            throw new IOException("responseCode: " + responseCode + ", method: " + str2 + ", url: " + url + ", connection.errorMsg: " + RequestUtil.read(httpURLConnection.getErrorStream()));
        } finally {
            CloseableUtils.closeQuietly(httpURLConnection.getInputStream());
            CloseableUtils.closeQuietly(httpURLConnection.getErrorStream());
            httpURLConnection.disconnect();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T extends JsonAdapter> void processResponse(String str, Class<T> cls, Callback<T> callback) {
        Response<T> responseFromJson = new Response(cls).fromJson(str);
        if (responseFromJson != null && responseFromJson.isSuccessful()) {
            onSuccess(callback, responseFromJson.data());
        } else {
            onFailure(callback, new AzerothResponseException(responseFromJson));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends JsonAdapter> void onFailure(final Callback<T> callback, final Throwable th) {
        if (this.mObserveOnMainThread) {
            Utils.runOnUiThread(new Runnable() { // from class: com.kwai.middleware.azeroth.network.AzerothApiRequester.2
                @Override // java.lang.Runnable
                public void run() {
                    callback.onFailure(th);
                }
            });
        } else {
            callback.onFailure(th);
        }
    }

    private <T extends JsonAdapter> void onSuccess(final Callback<T> callback, final T t) {
        if (this.mObserveOnMainThread) {
            Utils.runOnUiThread(new Runnable() { // from class: com.kwai.middleware.azeroth.network.AzerothApiRequester.3
                @Override // java.lang.Runnable
                public void run() {
                    callback.onSuccess(t);
                }
            });
        } else {
            callback.onSuccess(t);
        }
    }

    private void interceptBase(Uri.Builder builder) {
        String host;
        if (!TextUtils.isEmpty(this.mSpecialHost)) {
            host = this.mSpecialHost;
        } else {
            host = this.mApiRouter.getHost();
        }
        Uri uriBuild = builder.build();
        Uri uri = Uri.parse(host);
        if (!TextUtils.isEmpty(uri.getScheme()) && !TextUtils.equals(uri.getScheme(), uriBuild.getScheme())) {
            builder.scheme(uri.getScheme());
        }
        if (!TextUtils.isEmpty(uri.getHost())) {
            host = uri.getHost();
        }
        if (TextUtils.isEmpty(host) || TextUtils.equals(host, uriBuild.getHost())) {
            return;
        }
        builder.authority(host);
    }

    private void interceptBase(HttpURLConnection httpURLConnection, String str) throws ProtocolException {
        httpURLConnection.setReadTimeout(15000);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setRequestMethod(str);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(true);
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            if (Azeroth.get().getInitParams().getApiRequesterParams().useStandardSSLSocketFactory()) {
                httpsURLConnection.setSSLSocketFactory(SSLUtils.getStandardSocketFactory());
            } else {
                httpsURLConnection.setSSLSocketFactory(SSLUtils.getIgnoreAllSocketFactory());
            }
        }
    }

    private void interceptParams(Uri.Builder builder, Map<String, String> map) {
        if (map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builder.appendQueryParameter(entry.getKey(), entry.getValue());
        }
    }

    private void interceptHeaders(HttpURLConnection httpURLConnection, Map<String, String> map) {
        this.mHeadersInterceptor.intercept(httpURLConnection);
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private void interceptPostBody(HttpURLConnection httpURLConnection, String str) throws Throwable {
        OutputStreamWriter outputStreamWriter;
        BufferedWriter bufferedWriter;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        BufferedWriter bufferedWriter2 = null;
        try {
            outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream());
            try {
                bufferedWriter = new BufferedWriter(outputStreamWriter);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            outputStreamWriter = null;
        }
        try {
            bufferedWriter.write(str);
            bufferedWriter.flush();
            CloseableUtils.closeQuietly(bufferedWriter);
            CloseableUtils.closeQuietly(outputStreamWriter);
            CloseableUtils.closeQuietly(httpURLConnection.getOutputStream());
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter2 = bufferedWriter;
            CloseableUtils.closeQuietly(bufferedWriter2);
            CloseableUtils.closeQuietly(outputStreamWriter);
            CloseableUtils.closeQuietly(httpURLConnection.getOutputStream());
            throw th;
        }
    }

    private void interceptPostBody(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        if (bArr == null) {
            return;
        }
        OutputStream outputStream = httpURLConnection.getOutputStream();
        try {
            outputStream.write(bArr);
            outputStream.flush();
        } finally {
            CloseableUtils.closeQuietly(outputStream);
        }
    }

    public Builder toBuilder() {
        return new Builder();
    }

    public static class Builder {
        private AzerothApiParams mApiParams;
        private IApiRouter mApiRouter;
        private Executor mExecutor;
        private boolean mIgnorePathVerify;
        private int mMaxRetryCount;
        private boolean mObserveOnMainThread;
        private String mSdkName;
        private String mSpecialHost;
        private String mSubBiz;
        private boolean mUseHttps;

        public Builder(String str) {
            this.mObserveOnMainThread = true;
            this.mApiRouter = AzerothApiRequester.DEFAULT_API_ROUTER;
            this.mMaxRetryCount = 3;
            this.mApiParams = new BaseApiParams();
            this.mSdkName = str;
            this.mUseHttps = Azeroth.get().getInitParams().getApiRequesterParams().useHttps();
            this.mExecutor = AzerothApiRequester.NETWORKING_EXECUTOR;
        }

        private Builder(AzerothApiRequester azerothApiRequester) {
            this.mObserveOnMainThread = true;
            this.mApiRouter = AzerothApiRequester.DEFAULT_API_ROUTER;
            this.mMaxRetryCount = 3;
            this.mApiParams = new BaseApiParams();
            this.mSubBiz = azerothApiRequester.mSubBiz;
            this.mSdkName = azerothApiRequester.mSdkName;
            this.mSpecialHost = azerothApiRequester.mSpecialHost;
            this.mUseHttps = azerothApiRequester.mUseHttps;
            this.mIgnorePathVerify = azerothApiRequester.mIgnorePathVerify;
            this.mExecutor = azerothApiRequester.mExecutor;
            this.mObserveOnMainThread = azerothApiRequester.mObserveOnMainThread;
            this.mApiRouter = azerothApiRequester.mApiRouter;
            this.mMaxRetryCount = azerothApiRequester.mMaxRetryCount;
            this.mApiParams = azerothApiRequester.mApiParams;
        }

        public Builder setAzerothApiParams(AzerothApiParams azerothApiParams) {
            this.mApiParams = azerothApiParams;
            return this;
        }

        public Builder setSubBiz(String str) {
            this.mSubBiz = str;
            return this;
        }

        public Builder specialHost(String str) {
            this.mSpecialHost = str;
            return this;
        }

        public Builder setUseHttps(boolean z) {
            this.mUseHttps = z;
            return this;
        }

        public Builder ignoreUrlPathVerify() {
            this.mIgnorePathVerify = true;
            return this;
        }

        public Builder needRetry(boolean z) {
            setMaxRetryCount(z ? 3 : 0);
            return this;
        }

        public Builder setMaxRetryCount(int i) {
            this.mMaxRetryCount = i;
            return this;
        }

        public Builder setExecutor(Executor executor) {
            this.mExecutor = executor;
            return this;
        }

        public Builder setObserveOnMainThread(boolean z) {
            this.mObserveOnMainThread = z;
            return this;
        }

        public Builder setApiRouter(IApiRouter iApiRouter) {
            this.mApiRouter = iApiRouter;
            return this;
        }

        public AzerothApiRequester build() {
            return new AzerothApiRequester(this.mSubBiz, this.mSdkName, this.mSpecialHost, this.mUseHttps, this.mIgnorePathVerify, this.mExecutor, this.mObserveOnMainThread, this.mApiRouter, this.mMaxRetryCount, this.mApiParams);
        }
    }
}
