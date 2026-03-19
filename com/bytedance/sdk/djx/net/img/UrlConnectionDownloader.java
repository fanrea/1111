package com.bytedance.sdk.djx.net.img;

import android.content.Context;
import android.net.Uri;
import android.net.http.HttpResponseCache;
import android.os.Build;
import com.bytedance.sdk.djx.net.img.Downloader;
import io.netty.util.internal.StringUtil;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class UrlConnectionDownloader implements Downloader {
    private static final String FORCE_CACHE = "only-if-cached,max-age=2147483647";
    static final String RESPONSE_SOURCE = "X-Android-Response-Source";
    static volatile Object cache;
    private final File cacheDir;
    private final Context context;
    private static final Object lock = new Object();
    private static final ThreadLocal<StringBuilder> CACHE_HEADER_BUILDER = new ThreadLocal<StringBuilder>() { // from class: com.bytedance.sdk.djx.net.img.UrlConnectionDownloader.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    };

    public UrlConnectionDownloader(Context context) {
        this(context, null);
    }

    public UrlConnectionDownloader(Context context, File file) {
        this.context = context.getApplicationContext();
        this.cacheDir = file;
    }

    protected HttpURLConnection openConnection(Uri uri) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(20000);
        return httpURLConnection;
    }

    @Override // com.bytedance.sdk.djx.net.img.Downloader
    public Downloader.Response load(Uri uri, int i) throws IOException {
        String string;
        if (Build.VERSION.SDK_INT >= 14) {
            installCacheIfNeeded(this.context, this.cacheDir);
        }
        HttpURLConnection httpURLConnectionOpenConnection = openConnection(uri);
        httpURLConnectionOpenConnection.setUseCaches(true);
        if (i != 0) {
            if (NetworkPolicy.isOfflineOnly(i)) {
                string = FORCE_CACHE;
            } else {
                StringBuilder sb = CACHE_HEADER_BUILDER.get();
                sb.setLength(0);
                if (!NetworkPolicy.shouldReadFromDiskCache(i)) {
                    sb.append("no-cache");
                }
                if (!NetworkPolicy.shouldWriteToDiskCache(i)) {
                    if (sb.length() > 0) {
                        sb.append(StringUtil.COMMA);
                    }
                    sb.append("no-store");
                }
                string = sb.toString();
            }
            httpURLConnectionOpenConnection.setRequestProperty("Cache-Control", string);
        }
        int responseCode = httpURLConnectionOpenConnection.getResponseCode();
        if (responseCode >= 300) {
            httpURLConnectionOpenConnection.disconnect();
            throw new Downloader.ResponseException(responseCode + " " + httpURLConnectionOpenConnection.getResponseMessage(), i, responseCode);
        }
        return new Downloader.Response(httpURLConnectionOpenConnection.getInputStream(), Utils.parseResponseSourceHeader(httpURLConnectionOpenConnection.getHeaderField(RESPONSE_SOURCE)), httpURLConnectionOpenConnection.getHeaderFieldInt("Content-Length", -1));
    }

    @Override // com.bytedance.sdk.djx.net.img.Downloader
    public void shutdown() throws IOException {
        if (Build.VERSION.SDK_INT < 14 || cache == null) {
            return;
        }
        ResponseCacheIcs.close(cache);
    }

    private static void installCacheIfNeeded(Context context, File file) {
        if (cache == null) {
            try {
                synchronized (lock) {
                    if (cache == null) {
                        cache = ResponseCacheIcs.install(context, file);
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    private static class ResponseCacheIcs {
        private ResponseCacheIcs() {
        }

        static Object install(Context context, File file) throws IOException {
            if (file == null) {
                file = Utils.createDefaultCacheDir(context);
            }
            HttpResponseCache installed = HttpResponseCache.getInstalled();
            return installed == null ? HttpResponseCache.install(file, Utils.calculateDiskCacheSize(file)) : installed;
        }

        static void close(Object obj) throws IOException {
            try {
                ((HttpResponseCache) obj).close();
            } catch (IOException unused) {
            }
        }
    }
}
