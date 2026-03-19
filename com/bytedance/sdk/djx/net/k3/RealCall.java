package com.bytedance.sdk.djx.net.k3;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.djx.net.io.AsyncTimeout;
import com.bytedance.sdk.djx.net.io.Timeout;
import com.bytedance.sdk.djx.net.k3.internal.NamedRunnable;
import com.bytedance.sdk.djx.net.k3.internal.cache.CacheInterceptor;
import com.bytedance.sdk.djx.net.k3.internal.connection.ConnectInterceptor;
import com.bytedance.sdk.djx.net.k3.internal.connection.StreamAllocation;
import com.bytedance.sdk.djx.net.k3.internal.http.BridgeInterceptor;
import com.bytedance.sdk.djx.net.k3.internal.http.CallServerInterceptor;
import com.bytedance.sdk.djx.net.k3.internal.http.RealInterceptorChain;
import com.bytedance.sdk.djx.net.k3.internal.http.RetryAndFollowUpInterceptor;
import com.bytedance.sdk.djx.net.k3.internal.platform.Platform;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class RealCall implements Call {
    final OkHttpClient client;
    private EventListener eventListener;
    private boolean executed;
    final boolean forWebSocket;
    final Request originalRequest;
    final RetryAndFollowUpInterceptor retryAndFollowUpInterceptor;
    private AsyncTimeout timeout = new AsyncTimeout() { // from class: com.bytedance.sdk.djx.net.k3.RealCall.1
        @Override // com.bytedance.sdk.djx.net.io.AsyncTimeout
        protected void timedOut() throws IOException {
            RealCall.this.cancel();
        }
    };

    private RealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        this.client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = z;
        this.retryAndFollowUpInterceptor = new RetryAndFollowUpInterceptor(okHttpClient, z);
    }

    static RealCall newRealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        RealCall realCall = new RealCall(okHttpClient, request, z);
        realCall.eventListener = okHttpClient.eventListenerFactory().create(realCall);
        return realCall;
    }

    @Override // com.bytedance.sdk.djx.net.k3.Call
    public Request request() {
        return this.originalRequest;
    }

    @Override // com.bytedance.sdk.djx.net.k3.Call
    public Response execute() throws IOException {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        captureCallStackTrace();
        this.eventListener.callStart(this);
        try {
            try {
                this.client.dispatcher().executed(this);
                Response responseWithInterceptorChain = getResponseWithInterceptorChain();
                if (responseWithInterceptorChain != null) {
                    return responseWithInterceptorChain;
                }
                throw new IOException("Canceled");
            } catch (IOException e) {
                this.eventListener.callFailed(this, e);
                throw e;
            }
        } finally {
            this.client.dispatcher().finished(this);
        }
    }

    private void captureCallStackTrace() {
        this.retryAndFollowUpInterceptor.setCallStackTrace(Platform.get().getStackTraceForCloseable("response.body().close()"));
    }

    @Override // com.bytedance.sdk.djx.net.k3.Call
    public void enqueue(Callback callback) {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        captureCallStackTrace();
        this.eventListener.callStart(this);
        this.client.dispatcher().enqueue(new AsyncCall(callback));
    }

    @Override // com.bytedance.sdk.djx.net.k3.Call
    public void cancel() throws IOException {
        this.retryAndFollowUpInterceptor.cancel();
    }

    @Override // com.bytedance.sdk.djx.net.k3.Call
    public synchronized boolean isExecuted() {
        return this.executed;
    }

    @Override // com.bytedance.sdk.djx.net.k3.Call
    public boolean isCanceled() {
        return this.retryAndFollowUpInterceptor.isCanceled();
    }

    @Override // com.bytedance.sdk.djx.net.k3.Call
    public Timeout timeout() {
        return this.timeout.timeout(this.client.connectTimeout, TimeUnit.MILLISECONDS);
    }

    @Override // com.bytedance.sdk.djx.net.k3.Call
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public RealCall m365clone() {
        return newRealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    StreamAllocation streamAllocation() {
        return this.retryAndFollowUpInterceptor.streamAllocation();
    }

    final class AsyncCall extends NamedRunnable {
        private final Callback responseCallback;

        AsyncCall(Callback callback) {
            super("OkHttp %s", RealCall.this.redactedUrl());
            this.responseCallback = callback;
        }

        String host() {
            return RealCall.this.originalRequest.url().host();
        }

        Request request() {
            return RealCall.this.originalRequest;
        }

        RealCall get() {
            return RealCall.this;
        }

        @Override // com.bytedance.sdk.djx.net.k3.internal.NamedRunnable
        protected void execute() {
            IOException e;
            boolean z = true;
            try {
                try {
                    Response responseWithInterceptorChain = RealCall.this.getResponseWithInterceptorChain();
                    try {
                        if (RealCall.this.retryAndFollowUpInterceptor.isCanceled()) {
                            this.responseCallback.onFailure(RealCall.this, new IOException("Canceled"));
                        } else {
                            this.responseCallback.onResponse(RealCall.this, responseWithInterceptorChain);
                        }
                    } catch (IOException e2) {
                        e = e2;
                        if (!z) {
                            RealCall.this.eventListener.callFailed(RealCall.this, e);
                            this.responseCallback.onFailure(RealCall.this, e);
                        } else {
                            Platform.get().log(4, "Callback failure for " + RealCall.this.toLoggableString(), e);
                        }
                    }
                } finally {
                    RealCall.this.client.dispatcher().finished(this);
                }
            } catch (IOException e3) {
                e = e3;
                z = false;
            }
        }
    }

    String toLoggableString() {
        return (isCanceled() ? "canceled " : "") + (this.forWebSocket ? "web socket" : NotificationCompat.CATEGORY_CALL) + " to " + redactedUrl();
    }

    String redactedUrl() {
        return this.originalRequest.url().redact();
    }

    Response getResponseWithInterceptorChain() throws IOException {
        ArrayList arrayList = new ArrayList(this.client.interceptors());
        arrayList.add(this.retryAndFollowUpInterceptor);
        arrayList.add(new BridgeInterceptor(this.client.cookieJar()));
        arrayList.add(new CacheInterceptor(this.client.internalCache()));
        arrayList.add(new ConnectInterceptor(this.client));
        if (!this.forWebSocket) {
            arrayList.addAll(this.client.networkInterceptors());
        }
        arrayList.add(new CallServerInterceptor(this.forWebSocket));
        return new RealInterceptorChain(arrayList, null, null, null, 0, this.originalRequest, this, this.eventListener, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis()).proceed(this.originalRequest);
    }
}
