package com.lingku.xuanshang.xutils.http.request;

import android.text.TextUtils;
import androidx.core.location.LocationRequestCompat;
import com.alipay.sdk.m.s.a;
import com.lingku.xuanshang.xutils.cache.DiskCacheEntity;
import com.lingku.xuanshang.xutils.cache.LruDiskCache;
import com.lingku.xuanshang.xutils.common.util.IOUtil;
import com.lingku.xuanshang.xutils.common.util.KeyValue;
import com.lingku.xuanshang.xutils.common.util.LogUtil;
import com.lingku.xuanshang.xutils.http.HttpMethod;
import com.lingku.xuanshang.xutils.http.RequestParams;
import com.lingku.xuanshang.xutils.http.cookie.DbCookieStore;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TimeZone;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class HttpRequest extends UriRequest {
    public static final CookieManager a = new CookieManager(DbCookieStore.INSTANCE, CookiePolicy.ACCEPT_ALL);
    public String b;
    public boolean c;
    public InputStream d;
    public HttpURLConnection e;
    public int f;

    public HttpRequest(RequestParams requestParams, Type type) {
        super(requestParams, type);
        this.b = null;
        this.c = false;
        this.d = null;
        this.e = null;
        this.f = 0;
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public String buildQueryUrl(RequestParams requestParams) {
        String uri = requestParams.getUri();
        StringBuilder sb = new StringBuilder(uri);
        if (!uri.contains("?")) {
            sb.append("?");
        } else if (!uri.endsWith("?")) {
            sb.append(a.n);
        }
        List<KeyValue> queryStringParams = requestParams.getQueryStringParams();
        if (queryStringParams != null) {
            for (KeyValue keyValue : queryStringParams) {
                String str = keyValue.key;
                String valueStrOrNull = keyValue.getValueStrOrNull();
                if (!TextUtils.isEmpty(str) && valueStrOrNull != null) {
                    sb.append(URLEncoder.encode(str, requestParams.getCharset()).replaceAll("\\+", "%20")).append("=").append(URLEncoder.encode(valueStrOrNull, requestParams.getCharset()).replaceAll("\\+", "%20")).append(a.n);
                }
            }
        }
        if (sb.charAt(sb.length() - 1) == '&') {
            sb.deleteCharAt(sb.length() - 1);
        }
        if (sb.charAt(sb.length() - 1) == '?') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public void clearCacheHeader() {
        this.params.setHeader("If-Modified-Since", null);
        this.params.setHeader("If-None-Match", null);
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InputStream inputStream = this.d;
        if (inputStream != null) {
            IOUtil.closeQuietly(inputStream);
            this.d = null;
        }
        HttpURLConnection httpURLConnection = this.e;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public String getCacheKey() {
        if (this.b == null) {
            String cacheKey = this.params.getCacheKey();
            this.b = cacheKey;
            if (TextUtils.isEmpty(cacheKey)) {
                this.b = this.params.toString();
            }
        }
        return this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0019  */
    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long getContentLength() {
        /*
            r4 = this;
            java.net.HttpURLConnection r0 = r4.e
            if (r0 == 0) goto L19
            java.lang.String r1 = "content-length"
            java.lang.String r0 = r0.getHeaderField(r1)     // Catch: java.lang.Throwable -> L11
            if (r0 == 0) goto L19
            long r0 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Throwable -> L11
            goto L1b
        L11:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()
            com.lingku.xuanshang.xutils.common.util.LogUtil.e(r1, r0)
        L19:
            r0 = -1
        L1b:
            r2 = 1
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 >= 0) goto L2a
            java.io.InputStream r2 = r4.getInputStream()     // Catch: java.lang.Throwable -> L2a
            int r0 = r2.available()     // Catch: java.lang.Throwable -> L2a
            long r0 = (long) r0
        L2a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lingku.xuanshang.xutils.http.request.HttpRequest.getContentLength():long");
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public String getETag() {
        HttpURLConnection httpURLConnection = this.e;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderField("ETag");
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public long getExpiration() {
        HttpURLConnection httpURLConnection = this.e;
        long jCurrentTimeMillis = -1;
        if (httpURLConnection == null) {
            return -1L;
        }
        String headerField = httpURLConnection.getHeaderField("Cache-Control");
        if (!TextUtils.isEmpty(headerField)) {
            StringTokenizer stringTokenizer = new StringTokenizer(headerField, ",");
            while (true) {
                if (!stringTokenizer.hasMoreTokens()) {
                    break;
                }
                String lowerCase = stringTokenizer.nextToken().trim().toLowerCase();
                if (lowerCase.startsWith("max-age")) {
                    int iIndexOf = lowerCase.indexOf(61);
                    if (iIndexOf > 0) {
                        try {
                            long j = Long.parseLong(lowerCase.substring(iIndexOf + 1).trim());
                            if (j > 0) {
                                jCurrentTimeMillis = System.currentTimeMillis() + (j * 1000);
                            }
                        } catch (Throwable th) {
                            LogUtil.e(th.getMessage(), th);
                        }
                    }
                }
            }
        }
        if (jCurrentTimeMillis <= 0) {
            jCurrentTimeMillis = this.e.getExpiration();
        }
        if (jCurrentTimeMillis <= 0 && this.params.getCacheMaxAge() > 0) {
            jCurrentTimeMillis = System.currentTimeMillis() + this.params.getCacheMaxAge();
        }
        return jCurrentTimeMillis <= 0 ? LocationRequestCompat.PASSIVE_INTERVAL : jCurrentTimeMillis;
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public long getHeaderFieldDate(String str, long j) {
        HttpURLConnection httpURLConnection = this.e;
        return httpURLConnection == null ? j : httpURLConnection.getHeaderFieldDate(str, j);
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public InputStream getInputStream() {
        HttpURLConnection httpURLConnection = this.e;
        if (httpURLConnection != null && this.d == null) {
            this.d = httpURLConnection.getResponseCode() >= 400 ? this.e.getErrorStream() : this.e.getInputStream();
        }
        return this.d;
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public long getLastModified() {
        return getHeaderFieldDate("Last-Modified", System.currentTimeMillis());
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public String getRequestUri() {
        URL url;
        String str = this.queryUrl;
        HttpURLConnection httpURLConnection = this.e;
        return (httpURLConnection == null || (url = httpURLConnection.getURL()) == null) ? str : url.toString();
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public int getResponseCode() {
        return this.e != null ? this.f : getInputStream() != null ? 200 : 404;
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public String getResponseHeader(String str) {
        HttpURLConnection httpURLConnection = this.e;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderField(str);
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public Map<String, List<String>> getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.e;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public String getResponseMessage() {
        HttpURLConnection httpURLConnection = this.e;
        if (httpURLConnection != null) {
            return URLDecoder.decode(httpURLConnection.getResponseMessage(), this.params.getCharset());
        }
        return null;
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public boolean isLoading() {
        return this.c;
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public Object loadResult() {
        this.c = true;
        return super.loadResult();
    }

    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    public Object loadResultFromCache() {
        this.c = true;
        DiskCacheEntity diskCacheEntity = LruDiskCache.getDiskCache(this.params.getCacheDirName()).setMaxSize(this.params.getCacheSize()).get(getCacheKey());
        if (diskCacheEntity == null) {
            return null;
        }
        if (HttpMethod.permitsCache(this.params.getMethod())) {
            Date lastModify = diskCacheEntity.getLastModify();
            if (lastModify.getTime() > 0) {
                RequestParams requestParams = this.params;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM y HH:mm:ss 'GMT'", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                requestParams.setHeader("If-Modified-Since", simpleDateFormat.format(lastModify));
            }
            String etag = diskCacheEntity.getEtag();
            if (!TextUtils.isEmpty(etag)) {
                this.params.setHeader("If-None-Match", etag);
            }
        }
        return this.loader.loadFromCache(diskCacheEntity);
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0165  */
    @Override // com.lingku.xuanshang.xutils.http.request.UriRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void sendRequest() throws java.net.ProtocolException, com.lingku.xuanshang.xutils.ex.HttpException {
        /*
            Method dump skipped, instructions count: 558
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lingku.xuanshang.xutils.http.request.HttpRequest.sendRequest():void");
    }
}
