package aegon.chrome.net.impl;

import aegon.chrome.net.BidirectionalStream;
import aegon.chrome.net.CronetEngine;
import aegon.chrome.net.CronetException;
import aegon.chrome.net.NetworkQualityRttListener;
import aegon.chrome.net.NetworkQualityThroughputListener;
import aegon.chrome.net.RequestFinishedInfo;
import aegon.chrome.net.UploadDataProvider;
import aegon.chrome.net.UploadDataSink;
import aegon.chrome.net.UrlRequest;
import aegon.chrome.net.UrlResponseInfo;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class VersionSafeCallbacks {

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static final class UrlRequestCallback extends UrlRequest.Callback {
        private final UrlRequest.Callback mWrappedCallback;

        public UrlRequestCallback(UrlRequest.Callback callback) {
            this.mWrappedCallback = callback;
        }

        @Override // aegon.chrome.net.UrlRequest.Callback
        public final void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            this.mWrappedCallback.onRedirectReceived(urlRequest, urlResponseInfo, str);
        }

        @Override // aegon.chrome.net.UrlRequest.Callback
        public final void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            this.mWrappedCallback.onResponseStarted(urlRequest, urlResponseInfo);
        }

        @Override // aegon.chrome.net.UrlRequest.Callback
        public final void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            this.mWrappedCallback.onReadCompleted(urlRequest, urlResponseInfo, byteBuffer);
        }

        @Override // aegon.chrome.net.UrlRequest.Callback
        public final void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            this.mWrappedCallback.onSucceeded(urlRequest, urlResponseInfo);
        }

        @Override // aegon.chrome.net.UrlRequest.Callback
        public final void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
            this.mWrappedCallback.onFailed(urlRequest, urlResponseInfo, cronetException);
        }

        @Override // aegon.chrome.net.UrlRequest.Callback
        public final void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            this.mWrappedCallback.onCanceled(urlRequest, urlResponseInfo);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static final class UrlRequestStatusListener extends UrlRequest.StatusListener {
        private final UrlRequest.StatusListener mWrappedListener;

        public UrlRequestStatusListener(UrlRequest.StatusListener statusListener) {
            this.mWrappedListener = statusListener;
        }

        @Override // aegon.chrome.net.UrlRequest.StatusListener
        public final void onStatus(int i) {
            this.mWrappedListener.onStatus(i);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static final class BidirectionalStreamCallback extends BidirectionalStream.Callback {
        private final BidirectionalStream.Callback mWrappedCallback;

        public BidirectionalStreamCallback(BidirectionalStream.Callback callback) {
            this.mWrappedCallback = callback;
        }

        @Override // aegon.chrome.net.BidirectionalStream.Callback
        public final void onStreamReady(BidirectionalStream bidirectionalStream) {
            this.mWrappedCallback.onStreamReady(bidirectionalStream);
        }

        @Override // aegon.chrome.net.BidirectionalStream.Callback
        public final void onResponseHeadersReceived(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) {
            this.mWrappedCallback.onResponseHeadersReceived(bidirectionalStream, urlResponseInfo);
        }

        @Override // aegon.chrome.net.BidirectionalStream.Callback
        public final void onReadCompleted(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer, boolean z) {
            this.mWrappedCallback.onReadCompleted(bidirectionalStream, urlResponseInfo, byteBuffer, z);
        }

        @Override // aegon.chrome.net.BidirectionalStream.Callback
        public final void onWriteCompleted(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer, boolean z) {
            this.mWrappedCallback.onWriteCompleted(bidirectionalStream, urlResponseInfo, byteBuffer, z);
        }

        @Override // aegon.chrome.net.BidirectionalStream.Callback
        public final void onResponseTrailersReceived(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, UrlResponseInfo.HeaderBlock headerBlock) {
            this.mWrappedCallback.onResponseTrailersReceived(bidirectionalStream, urlResponseInfo, headerBlock);
        }

        @Override // aegon.chrome.net.BidirectionalStream.Callback
        public final void onSucceeded(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) {
            this.mWrappedCallback.onSucceeded(bidirectionalStream, urlResponseInfo);
        }

        @Override // aegon.chrome.net.BidirectionalStream.Callback
        public final void onFailed(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
            this.mWrappedCallback.onFailed(bidirectionalStream, urlResponseInfo, cronetException);
        }

        @Override // aegon.chrome.net.BidirectionalStream.Callback
        public final void onCanceled(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) {
            this.mWrappedCallback.onCanceled(bidirectionalStream, urlResponseInfo);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static final class UploadDataProviderWrapper extends UploadDataProvider {
        private final UploadDataProvider mWrappedProvider;

        public UploadDataProviderWrapper(UploadDataProvider uploadDataProvider) {
            this.mWrappedProvider = uploadDataProvider;
        }

        @Override // aegon.chrome.net.UploadDataProvider
        public final long getLength() {
            return this.mWrappedProvider.getLength();
        }

        @Override // aegon.chrome.net.UploadDataProvider
        public final void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            this.mWrappedProvider.read(uploadDataSink, byteBuffer);
        }

        @Override // aegon.chrome.net.UploadDataProvider
        public final void rewind(UploadDataSink uploadDataSink) {
            this.mWrappedProvider.rewind(uploadDataSink);
        }

        @Override // aegon.chrome.net.UploadDataProvider, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            this.mWrappedProvider.close();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static final class RequestFinishedInfoListener extends RequestFinishedInfo.Listener {
        private final RequestFinishedInfo.Listener mWrappedListener;

        public RequestFinishedInfoListener(RequestFinishedInfo.Listener listener) {
            super(listener.getExecutor());
            this.mWrappedListener = listener;
        }

        @Override // aegon.chrome.net.RequestFinishedInfo.Listener
        public final void onRequestFinished(RequestFinishedInfo requestFinishedInfo) {
            this.mWrappedListener.onRequestFinished(requestFinishedInfo);
        }

        @Override // aegon.chrome.net.RequestFinishedInfo.Listener
        public final Executor getExecutor() {
            return this.mWrappedListener.getExecutor();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static final class NetworkQualityRttListenerWrapper extends NetworkQualityRttListener {
        private final NetworkQualityRttListener mWrappedListener;

        public NetworkQualityRttListenerWrapper(NetworkQualityRttListener networkQualityRttListener) {
            super(networkQualityRttListener.getExecutor());
            this.mWrappedListener = networkQualityRttListener;
        }

        @Override // aegon.chrome.net.NetworkQualityRttListener
        public final void onRttObservation(int i, long j, int i2) {
            this.mWrappedListener.onRttObservation(i, j, i2);
        }

        @Override // aegon.chrome.net.NetworkQualityRttListener
        public final Executor getExecutor() {
            return this.mWrappedListener.getExecutor();
        }

        public final int hashCode() {
            return this.mWrappedListener.hashCode();
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof NetworkQualityRttListenerWrapper)) {
                return false;
            }
            return this.mWrappedListener.equals(((NetworkQualityRttListenerWrapper) obj).mWrappedListener);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static final class NetworkQualityThroughputListenerWrapper extends NetworkQualityThroughputListener {
        private final NetworkQualityThroughputListener mWrappedListener;

        public NetworkQualityThroughputListenerWrapper(NetworkQualityThroughputListener networkQualityThroughputListener) {
            super(networkQualityThroughputListener.getExecutor());
            this.mWrappedListener = networkQualityThroughputListener;
        }

        @Override // aegon.chrome.net.NetworkQualityThroughputListener
        public final void onThroughputObservation(int i, long j, int i2) {
            this.mWrappedListener.onThroughputObservation(i, j, i2);
        }

        @Override // aegon.chrome.net.NetworkQualityThroughputListener
        public final Executor getExecutor() {
            return this.mWrappedListener.getExecutor();
        }

        public final int hashCode() {
            return this.mWrappedListener.hashCode();
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof NetworkQualityThroughputListenerWrapper)) {
                return false;
            }
            return this.mWrappedListener.equals(((NetworkQualityThroughputListenerWrapper) obj).mWrappedListener);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static final class LibraryLoader extends CronetEngine.Builder.LibraryLoader {
        private final CronetEngine.Builder.LibraryLoader mWrappedLoader;

        public LibraryLoader(CronetEngine.Builder.LibraryLoader libraryLoader) {
            this.mWrappedLoader = libraryLoader;
        }

        @Override // aegon.chrome.net.CronetEngine.Builder.LibraryLoader
        public final void loadLibrary(String str) {
            this.mWrappedLoader.loadLibrary(str);
        }
    }
}
