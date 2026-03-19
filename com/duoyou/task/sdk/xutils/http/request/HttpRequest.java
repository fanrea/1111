package com.duoyou.task.sdk.xutils.http.request;

import android.text.TextUtils;
import androidx.core.location.LocationRequestCompat;
import com.alipay.sdk.m.s.a;
import com.duoyou.task.sdk.xutils.cache.DiskCacheEntity;
import com.duoyou.task.sdk.xutils.cache.LruDiskCache;
import com.duoyou.task.sdk.xutils.common.util.IOUtil;
import com.duoyou.task.sdk.xutils.common.util.KeyValue;
import com.duoyou.task.sdk.xutils.common.util.LogUtil;
import com.duoyou.task.sdk.xutils.http.HttpMethod;
import com.duoyou.task.sdk.xutils.http.RequestParams;
import com.duoyou.task.sdk.xutils.http.cookie.DbCookieStore;
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

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class HttpRequest extends UriRequest {
    private static final CookieManager COOKIE_MANAGER = new CookieManager(DbCookieStore.INSTANCE, CookiePolicy.ACCEPT_ALL);
    private String cacheKey;
    private HttpURLConnection connection;
    private InputStream inputStream;
    private boolean isLoading;
    private int responseCode;

    public HttpRequest(RequestParams requestParams, Type type) {
        super(requestParams, type);
        this.cacheKey = null;
        this.isLoading = false;
        this.inputStream = null;
        this.connection = null;
        this.responseCode = 0;
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
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

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public String getRequestUri() {
        URL url;
        String str = this.queryUrl;
        HttpURLConnection httpURLConnection = this.connection;
        return (httpURLConnection == null || (url = httpURLConnection.getURL()) == null) ? str : url.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0183  */
    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void sendRequest() throws java.net.ProtocolException, com.duoyou.task.sdk.xutils.ex.HttpException {
        /*
            Method dump skipped, instructions count: 568
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duoyou.task.sdk.xutils.http.request.HttpRequest.sendRequest():void");
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public boolean isLoading() {
        return this.isLoading;
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public String getCacheKey() {
        if (this.cacheKey == null) {
            String cacheKey = this.params.getCacheKey();
            this.cacheKey = cacheKey;
            if (TextUtils.isEmpty(cacheKey)) {
                this.cacheKey = this.params.toString();
            }
        }
        return this.cacheKey;
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public Object loadResult() {
        this.isLoading = true;
        return super.loadResult();
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public Object loadResultFromCache() {
        this.isLoading = true;
        DiskCacheEntity diskCacheEntity = LruDiskCache.getDiskCache(this.params.getCacheDirName()).setMaxSize(this.params.getCacheSize()).get(getCacheKey());
        if (diskCacheEntity == null) {
            return null;
        }
        if (HttpMethod.permitsCache(this.params.getMethod())) {
            Date lastModify = diskCacheEntity.getLastModify();
            if (lastModify.getTime() > 0) {
                this.params.setHeader("If-Modified-Since", toGMTString(lastModify));
            }
            String etag = diskCacheEntity.getEtag();
            if (!TextUtils.isEmpty(etag)) {
                this.params.setHeader("If-None-Match", etag);
            }
        }
        return this.loader.loadFromCache(diskCacheEntity);
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public void clearCacheHeader() {
        this.params.setHeader("If-Modified-Since", null);
        this.params.setHeader("If-None-Match", null);
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public InputStream getInputStream() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection != null && this.inputStream == null) {
            this.inputStream = httpURLConnection.getResponseCode() >= 400 ? this.connection.getErrorStream() : this.connection.getInputStream();
        }
        return this.inputStream;
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InputStream inputStream = this.inputStream;
        if (inputStream != null) {
            IOUtil.closeQuietly(inputStream);
            this.inputStream = null;
        }
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public long getContentLength() throws NumberFormatException {
        HttpURLConnection httpURLConnection = this.connection;
        long j = -1;
        if (httpURLConnection != null) {
            try {
                String headerField = httpURLConnection.getHeaderField("content-length");
                if (headerField != null) {
                    j = Long.parseLong(headerField);
                }
            } catch (Throwable th) {
                LogUtil.e(th.getMessage(), th);
            }
        }
        if (j >= 1) {
            return j;
        }
        try {
            return getInputStream().available();
        } catch (Throwable unused) {
            return j;
        }
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public int getResponseCode() {
        if (this.connection != null) {
            return this.responseCode;
        }
        return getInputStream() != null ? 200 : 404;
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public String getResponseMessage() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection != null) {
            return URLDecoder.decode(httpURLConnection.getResponseMessage(), this.params.getCharset());
        }
        return null;
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public long getExpiration() {
        HttpURLConnection httpURLConnection = this.connection;
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
            jCurrentTimeMillis = this.connection.getExpiration();
        }
        if (jCurrentTimeMillis <= 0 && this.params.getCacheMaxAge() > 0) {
            jCurrentTimeMillis = System.currentTimeMillis() + this.params.getCacheMaxAge();
        }
        return jCurrentTimeMillis <= 0 ? LocationRequestCompat.PASSIVE_INTERVAL : jCurrentTimeMillis;
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public long getLastModified() {
        return getHeaderFieldDate("Last-Modified", System.currentTimeMillis());
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public String getETag() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderField("ETag");
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public String getResponseHeader(String str) {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderField(str);
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public Map<String, List<String>> getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    @Override // com.duoyou.task.sdk.xutils.http.request.UriRequest
    public long getHeaderFieldDate(String str, long j) {
        HttpURLConnection httpURLConnection = this.connection;
        return httpURLConnection == null ? j : httpURLConnection.getHeaderFieldDate(str, j);
    }

    private static String toGMTString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM y HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(date);
    }
}
