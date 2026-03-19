package com.bytedance.sdk.djx.net.img;

import android.graphics.Bitmap;
import android.net.NetworkInfo;
import com.bytedance.sdk.djx.net.img.Downloader;
import com.bytedance.sdk.djx.net.img.Picasso;
import com.bytedance.sdk.djx.net.img.RequestHandler;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class NetworkRequestHandler extends RequestHandler {
    static final int RETRY_COUNT = 2;
    private static final String SCHEME_HTTP = "http";
    private static final String SCHEME_HTTPS = "https";
    private final Downloader downloader;
    private final Stats stats;

    @Override // com.bytedance.sdk.djx.net.img.RequestHandler
    int getRetryCount() {
        return 2;
    }

    @Override // com.bytedance.sdk.djx.net.img.RequestHandler
    boolean supportsReplay() {
        return true;
    }

    public NetworkRequestHandler(Downloader downloader, Stats stats) {
        this.downloader = downloader;
        this.stats = stats;
    }

    @Override // com.bytedance.sdk.djx.net.img.RequestHandler
    public boolean canHandleRequest(Request request) {
        String scheme = request.uri.getScheme();
        return "http".equals(scheme) || "https".equals(scheme);
    }

    @Override // com.bytedance.sdk.djx.net.img.RequestHandler
    public RequestHandler.Result load(Request request, int i) throws IOException {
        Downloader.Response responseLoad = this.downloader.load(request.uri, request.networkPolicy);
        if (responseLoad == null) {
            return null;
        }
        Picasso.LoadedFrom loadedFrom = responseLoad.cached ? Picasso.LoadedFrom.DISK : Picasso.LoadedFrom.NETWORK;
        Bitmap bitmap = responseLoad.getBitmap();
        if (bitmap != null) {
            return new RequestHandler.Result(bitmap, loadedFrom);
        }
        InputStream inputStream = responseLoad.getInputStream();
        if (inputStream == null) {
            return null;
        }
        if (loadedFrom == Picasso.LoadedFrom.DISK && responseLoad.getContentLength() == 0) {
            Utils.closeQuietly(inputStream);
            throw new ContentLengthException("Received response with 0 content-length header.");
        }
        if (loadedFrom == Picasso.LoadedFrom.NETWORK && responseLoad.getContentLength() > 0) {
            this.stats.dispatchDownloadFinished(responseLoad.getContentLength());
        }
        return new RequestHandler.Result(inputStream, loadedFrom);
    }

    @Override // com.bytedance.sdk.djx.net.img.RequestHandler
    boolean shouldRetry(boolean z, NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }

    static class ContentLengthException extends IOException {
        public ContentLengthException(String str) {
            super(str);
        }
    }
}
