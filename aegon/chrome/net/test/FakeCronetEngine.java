package aegon.chrome.net.test;

import aegon.chrome.net.BidirectionalStream;
import aegon.chrome.net.ExperimentalBidirectionalStream;
import aegon.chrome.net.NetworkQualityRttListener;
import aegon.chrome.net.NetworkQualityThroughputListener;
import aegon.chrome.net.RequestFinishedInfo;
import aegon.chrome.net.UrlRequest;
import aegon.chrome.net.impl.CronetEngineBase;
import aegon.chrome.net.impl.CronetEngineBuilderImpl;
import aegon.chrome.net.impl.ImplVersion;
import aegon.chrome.net.impl.UrlRequestBase;
import android.content.Context;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandlerFactory;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final class FakeCronetEngine extends CronetEngineBase {
    private int mActiveRequestCount;
    private final FakeCronetController mController;
    private boolean mIsShutdown;
    private final Object mLock;

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

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    static class Builder extends CronetEngineBuilderImpl {
        private FakeCronetController mController;

        Builder(Context context) {
            super(context);
        }

        @Override // aegon.chrome.net.ICronetEngineBuilder
        public FakeCronetEngine build() {
            return new FakeCronetEngine(this);
        }

        void setController(FakeCronetController fakeCronetController) {
            this.mController = fakeCronetController;
        }
    }

    private FakeCronetEngine(Builder builder) {
        this.mLock = new Object();
        if (builder.mController != null) {
            this.mController = builder.mController;
        } else {
            this.mController = new FakeCronetController();
        }
        FakeCronetController.addFakeCronetEngine(this);
    }

    final FakeCronetController getController() {
        return this.mController;
    }

    @Override // aegon.chrome.net.ExperimentalCronetEngine
    public final ExperimentalBidirectionalStream.Builder newBidirectionalStreamBuilder(String str, BidirectionalStream.Callback callback, Executor executor) {
        synchronized (this.mLock) {
            if (this.mIsShutdown) {
                throw new IllegalStateException("This instance of CronetEngine has been shutdown and can no longer be used.");
            }
            throw new UnsupportedOperationException("The bidirectional stream API is not supported by the Fake implementation of CronetEngine.");
        }
    }

    @Override // aegon.chrome.net.CronetEngine
    public final String getVersionString() {
        return "FakeCronet/" + ImplVersion.getCronetVersionWithLastChange();
    }

    @Override // aegon.chrome.net.CronetEngine
    public final void shutdown() {
        synchronized (this.mLock) {
            if (this.mActiveRequestCount != 0) {
                throw new IllegalStateException("Cannot shutdown with active requests.");
            }
            this.mIsShutdown = true;
        }
        FakeCronetController.removeFakeCronetEngine(this);
    }

    @Override // aegon.chrome.net.CronetEngine
    public final URLConnection openConnection(URL url) {
        throw new UnsupportedOperationException("The openConnection API is not supported by the Fake implementation of CronetEngine.");
    }

    @Override // aegon.chrome.net.ExperimentalCronetEngine
    public final URLConnection openConnection(URL url, Proxy proxy) {
        throw new UnsupportedOperationException("The openConnection API is not supported by the Fake implementation of CronetEngine.");
    }

    @Override // aegon.chrome.net.CronetEngine
    public final URLStreamHandlerFactory createURLStreamHandlerFactory() {
        throw new UnsupportedOperationException("The URLStreamHandlerFactory API is not supported by the Fake implementation of CronetEngine.");
    }

    @Override // aegon.chrome.net.impl.CronetEngineBase
    public final UrlRequestBase createRequest(String str, UrlRequest.Callback callback, Executor executor, int i, Collection<Object> collection, boolean z, boolean z2, boolean z3, boolean z4, int i2, boolean z5, int i3, RequestFinishedInfo.Listener listener) {
        synchronized (this.mLock) {
            if (this.mIsShutdown) {
                throw new IllegalStateException("This instance of CronetEngine has been shutdown and can no longer be used.");
            }
            throw new UnsupportedOperationException("The UrlRequest API is not supported by the Fake implementation of CronetEngine.");
        }
    }

    @Override // aegon.chrome.net.impl.CronetEngineBase
    public final ExperimentalBidirectionalStream createBidirectionalStream(String str, BidirectionalStream.Callback callback, Executor executor, String str2, List<Map.Entry<String, String>> list, int i, boolean z, Collection<Object> collection, boolean z2, int i2, boolean z3, int i3) {
        synchronized (this.mLock) {
            if (this.mIsShutdown) {
                throw new IllegalStateException("This instance of CronetEngine has been shutdown and can no longer be used.");
            }
            throw new UnsupportedOperationException("The BidirectionalStream API is not supported by the Fake implementation of CronetEngine.");
        }
    }

    final boolean startRequest() {
        synchronized (this.mLock) {
            if (this.mIsShutdown) {
                return false;
            }
            this.mActiveRequestCount++;
            return true;
        }
    }

    final void onRequestDestroyed() {
        synchronized (this.mLock) {
            if (this.mIsShutdown) {
                throw new IllegalStateException("This instance of CronetEngine was shutdown. All requests must have been complete.");
            }
            this.mActiveRequestCount--;
        }
    }
}
