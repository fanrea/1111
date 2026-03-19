package com.fendasz.moku.liulishuo.okdownload.core.connection;

import com.fendasz.moku.liulishuo.okdownload.IRedirectHandler;
import com.fendasz.moku.liulishuo.okdownload.RedirectUtil;
import com.fendasz.moku.liulishuo.okdownload.core.Util;
import com.fendasz.moku.liulishuo.okdownload.core.connection.DownloadConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DownloadUrlConnection implements DownloadConnection, DownloadConnection.Connected {
    private static final String TAG = "DownloadUrlConnection";
    private Configuration configuration;
    protected URLConnection connection;
    private IRedirectHandler redirectHandler;
    private URL url;

    DownloadUrlConnection(URLConnection uRLConnection) {
        this(uRLConnection, new RedirectHandler());
    }

    DownloadUrlConnection(URLConnection uRLConnection, IRedirectHandler iRedirectHandler) {
        this.connection = uRLConnection;
        this.url = uRLConnection.getURL();
        this.redirectHandler = iRedirectHandler;
    }

    public DownloadUrlConnection(String str, Configuration configuration) throws IOException {
        this(new URL(str), configuration);
    }

    public DownloadUrlConnection(URL url, Configuration configuration) throws IOException {
        this(url, configuration, new RedirectHandler());
    }

    public DownloadUrlConnection(URL url, Configuration configuration, IRedirectHandler iRedirectHandler) throws IOException {
        this.configuration = configuration;
        this.url = url;
        this.redirectHandler = iRedirectHandler;
        configUrlConnection();
    }

    public DownloadUrlConnection(String str) throws IOException {
        this(str, (Configuration) null);
    }

    void configUrlConnection() throws IOException {
        Util.d(TAG, "config connection for " + this.url);
        Configuration configuration = this.configuration;
        if (configuration == null || configuration.proxy == null) {
            this.connection = this.url.openConnection();
        } else {
            this.connection = this.url.openConnection(this.configuration.proxy);
        }
        URLConnection uRLConnection = this.connection;
        if (uRLConnection instanceof HttpURLConnection) {
            ((HttpURLConnection) uRLConnection).setInstanceFollowRedirects(false);
        }
        Configuration configuration2 = this.configuration;
        if (configuration2 != null) {
            if (configuration2.readTimeout != null) {
                this.connection.setReadTimeout(this.configuration.readTimeout.intValue());
            }
            if (this.configuration.connectTimeout != null) {
                this.connection.setConnectTimeout(this.configuration.connectTimeout.intValue());
            }
        }
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.connection.DownloadConnection
    public void addHeader(String str, String str2) {
        this.connection.addRequestProperty(str, str2);
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.connection.DownloadConnection
    public DownloadConnection.Connected execute() throws IOException {
        Map<String, List<String>> requestProperties = getRequestProperties();
        this.connection.connect();
        this.redirectHandler.handleRedirect(this, this, requestProperties);
        return this;
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.connection.DownloadConnection.Connected
    public int getResponseCode() throws IOException {
        URLConnection uRLConnection = this.connection;
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        }
        return 0;
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.connection.DownloadConnection.Connected
    public InputStream getInputStream() throws IOException {
        return this.connection.getInputStream();
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.connection.DownloadConnection
    public boolean setRequestMethod(String str) throws ProtocolException {
        URLConnection uRLConnection = this.connection;
        if (!(uRLConnection instanceof HttpURLConnection)) {
            return false;
        }
        ((HttpURLConnection) uRLConnection).setRequestMethod(str);
        return true;
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.connection.DownloadConnection.Connected
    public Map<String, List<String>> getResponseHeaderFields() {
        return this.connection.getHeaderFields();
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.connection.DownloadConnection.Connected
    public String getResponseHeaderField(String str) {
        return this.connection.getHeaderField(str);
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.connection.DownloadConnection.Connected
    public String getRedirectLocation() {
        return this.redirectHandler.getRedirectLocation();
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.connection.DownloadConnection
    public void release() throws IOException {
        try {
            InputStream inputStream = this.connection.getInputStream();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException unused) {
        }
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.connection.DownloadConnection
    public Map<String, List<String>> getRequestProperties() {
        return this.connection.getRequestProperties();
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.connection.DownloadConnection
    public String getRequestProperty(String str) {
        return this.connection.getRequestProperty(str);
    }

    public static class Factory implements DownloadConnection.Factory {
        private final Configuration configuration;

        public Factory() {
            this(null);
        }

        public Factory(Configuration configuration) {
            this.configuration = configuration;
        }

        DownloadConnection create(URL url) throws IOException {
            return new DownloadUrlConnection(url, this.configuration);
        }

        @Override // com.fendasz.moku.liulishuo.okdownload.core.connection.DownloadConnection.Factory
        public DownloadConnection create(String str) throws IOException {
            return new DownloadUrlConnection(str, this.configuration);
        }
    }

    public static class Configuration {
        private Integer connectTimeout;
        private Proxy proxy;
        private Integer readTimeout;

        public Configuration proxy(Proxy proxy) {
            this.proxy = proxy;
            return this;
        }

        public Configuration readTimeout(int i) {
            this.readTimeout = Integer.valueOf(i);
            return this;
        }

        public Configuration connectTimeout(int i) {
            this.connectTimeout = Integer.valueOf(i);
            return this;
        }
    }

    static final class RedirectHandler implements IRedirectHandler {
        String redirectLocation;

        RedirectHandler() {
        }

        @Override // com.fendasz.moku.liulishuo.okdownload.IRedirectHandler
        public void handleRedirect(DownloadConnection downloadConnection, DownloadConnection.Connected connected, Map<String, List<String>> map) throws IOException {
            DownloadUrlConnection downloadUrlConnection = (DownloadUrlConnection) downloadConnection;
            int i = 0;
            for (int responseCode = connected.getResponseCode(); RedirectUtil.isRedirect(responseCode); responseCode = downloadUrlConnection.getResponseCode()) {
                downloadUrlConnection.release();
                i++;
                if (i > 10) {
                    throw new ProtocolException("Too many redirect requests: " + i);
                }
                this.redirectLocation = RedirectUtil.getRedirectedUrl(connected, responseCode);
                downloadUrlConnection.url = new URL(this.redirectLocation);
                downloadUrlConnection.configUrlConnection();
                Util.addRequestHeaderFields(map, downloadUrlConnection);
                downloadUrlConnection.connection.connect();
            }
        }

        @Override // com.fendasz.moku.liulishuo.okdownload.IRedirectHandler
        public String getRedirectLocation() {
            return this.redirectLocation;
        }
    }
}
