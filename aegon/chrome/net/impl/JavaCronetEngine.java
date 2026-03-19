package aegon.chrome.net.impl;

import aegon.chrome.net.BidirectionalStream;
import aegon.chrome.net.ExperimentalBidirectionalStream;
import aegon.chrome.net.NetworkQualityRttListener;
import aegon.chrome.net.NetworkQualityThroughputListener;
import aegon.chrome.net.RequestFinishedInfo;
import aegon.chrome.net.UrlRequest;
import android.os.Process;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class JavaCronetEngine extends CronetEngineBase {
    private final ExecutorService mExecutorService;
    private final String mUserAgent;

    @Override // aegon.chrome.net.ExperimentalCronetEngine
    public final void addRequestFinishedListener(RequestFinishedInfo.Listener listener) {
    }

    @Override // aegon.chrome.net.ExperimentalCronetEngine
    public final void addRttListener(NetworkQualityRttListener networkQualityRttListener) {
    }

    @Override // aegon.chrome.net.ExperimentalCronetEngine
    public final void addThroughputListener(NetworkQualityThroughputListener networkQualityThroughputListener) {
    }

    @Override // aegon.chrome.net.ExperimentalCronetEngine
    public final void configureNetworkQualityEstimatorForTesting(boolean z, boolean z2, boolean z3) {
    }

    @Override // aegon.chrome.net.ExperimentalCronetEngine
    public final int getDownstreamThroughputKbps() {
        return -1;
    }

    @Override // aegon.chrome.net.ExperimentalCronetEngine
    public final int getEffectiveConnectionType() {
        return 0;
    }

    @Override // aegon.chrome.net.CronetEngine
    public final byte[] getGlobalMetricsDeltas() {
        return new byte[0];
    }

    @Override // aegon.chrome.net.ExperimentalCronetEngine
    public final int getHttpRttMs() {
        return -1;
    }

    @Override // aegon.chrome.net.ExperimentalCronetEngine
    public final int getTransportRttMs() {
        return -1;
    }

    @Override // aegon.chrome.net.ExperimentalCronetEngine
    public final void removeRequestFinishedListener(RequestFinishedInfo.Listener listener) {
    }

    @Override // aegon.chrome.net.ExperimentalCronetEngine
    public final void removeRttListener(NetworkQualityRttListener networkQualityRttListener) {
    }

    @Override // aegon.chrome.net.ExperimentalCronetEngine
    public final void removeThroughputListener(NetworkQualityThroughputListener networkQualityThroughputListener) {
    }

    @Override // aegon.chrome.net.ExperimentalCronetEngine
    public final void startNetLogToDisk(String str, boolean z, int i) {
    }

    @Override // aegon.chrome.net.CronetEngine
    public final void startNetLogToFile(String str, boolean z) {
    }

    @Override // aegon.chrome.net.CronetEngine
    public final void stopNetLog() {
    }

    public JavaCronetEngine(CronetEngineBuilderImpl cronetEngineBuilderImpl) {
        final int iThreadPriority = cronetEngineBuilderImpl.threadPriority(9);
        this.mUserAgent = cronetEngineBuilderImpl.getUserAgent();
        this.mExecutorService = new ThreadPoolExecutor(10, 20, 50L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: aegon.chrome.net.impl.JavaCronetEngine.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(final Runnable runnable) {
                return Executors.defaultThreadFactory().newThread(new Runnable() { // from class: aegon.chrome.net.impl.JavaCronetEngine.1.1
                    @Override // java.lang.Runnable
                    public void run() throws SecurityException, IllegalArgumentException {
                        Thread.currentThread().setName("JavaCronetEngine");
                        Process.setThreadPriority(iThreadPriority);
                        runnable.run();
                    }
                });
            }
        });
    }

    @Override // aegon.chrome.net.impl.CronetEngineBase
    public final UrlRequestBase createRequest(String str, UrlRequest.Callback callback, Executor executor, int i, Collection<Object> collection, boolean z, boolean z2, boolean z3, boolean z4, int i2, boolean z5, int i3, RequestFinishedInfo.Listener listener) {
        return new JavaUrlRequest(callback, this.mExecutorService, executor, str, this.mUserAgent, z3, z4, i2, z5, i3);
    }

    @Override // aegon.chrome.net.impl.CronetEngineBase
    protected final ExperimentalBidirectionalStream createBidirectionalStream(String str, BidirectionalStream.Callback callback, Executor executor, String str2, List<Map.Entry<String, String>> list, int i, boolean z, Collection<Object> collection, boolean z2, int i2, boolean z3, int i3) {
        throw new UnsupportedOperationException("Can't create a bidi stream - httpurlconnection doesn't have those APIs");
    }

    @Override // aegon.chrome.net.ExperimentalCronetEngine
    public final ExperimentalBidirectionalStream.Builder newBidirectionalStreamBuilder(String str, BidirectionalStream.Callback callback, Executor executor) {
        throw new UnsupportedOperationException("The bidirectional stream API is not supported by the Java implementation of Cronet Engine");
    }

    @Override // aegon.chrome.net.CronetEngine
    public final String getVersionString() {
        return "CronetHttpURLConnection/" + ImplVersion.getCronetVersionWithLastChange();
    }

    @Override // aegon.chrome.net.CronetEngine
    public final void shutdown() {
        this.mExecutorService.shutdown();
    }

    @Override // aegon.chrome.net.CronetEngine
    public final URLConnection openConnection(URL url) {
        return url.openConnection();
    }

    @Override // aegon.chrome.net.ExperimentalCronetEngine
    public final URLConnection openConnection(URL url, Proxy proxy) {
        return url.openConnection(proxy);
    }

    @Override // aegon.chrome.net.CronetEngine
    public final URLStreamHandlerFactory createURLStreamHandlerFactory() {
        return new URLStreamHandlerFactory() { // from class: aegon.chrome.net.impl.JavaCronetEngine.2
            @Override // java.net.URLStreamHandlerFactory
            public URLStreamHandler createURLStreamHandler(String str) {
                return null;
            }
        };
    }
}
