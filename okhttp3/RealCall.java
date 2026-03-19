package okhttp3;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.util.ArrayList;
import okhttp3.internal.b;
import okhttp3.internal.b.a;
import okhttp3.internal.b.g;
import okhttp3.internal.b.j;
import okhttp3.internal.connection.f;
import okhttp3.internal.e.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class RealCall implements Call {
    final OkHttpClient client;
    private boolean executed;
    final boolean forWebSocket;
    final Request originalRequest;
    final j retryAndFollowUpInterceptor;

    RealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        this.client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = z;
        this.retryAndFollowUpInterceptor = new j(okHttpClient, z);
    }

    @Override // okhttp3.Call
    public final Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.Call
    public final Response execute() {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        captureCallStackTrace();
        try {
            this.client.dispatcher().executed(this);
            Response responseWithInterceptorChain = getResponseWithInterceptorChain();
            if (responseWithInterceptorChain != null) {
                return responseWithInterceptorChain;
            }
            throw new IOException("Canceled");
        } finally {
            this.client.dispatcher().finished(this);
        }
    }

    private void captureCallStackTrace() {
        this.retryAndFollowUpInterceptor.q(e.hl().E("response.body().close()"));
    }

    @Override // okhttp3.Call
    public final void enqueue(Callback callback) {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        captureCallStackTrace();
        this.client.dispatcher().enqueue(new AsyncCall(callback));
    }

    @Override // okhttp3.Call
    public final void cancel() {
        this.retryAndFollowUpInterceptor.cancel();
    }

    @Override // okhttp3.Call
    public final synchronized boolean isExecuted() {
        return this.executed;
    }

    @Override // okhttp3.Call
    /* renamed from: isCanceled */
    public final boolean getCanceled() {
        return this.retryAndFollowUpInterceptor.isCanceled();
    }

    @Override // okhttp3.Call
    public final RealCall clone() {
        return new RealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    final f streamAllocation() {
        return this.retryAndFollowUpInterceptor.streamAllocation();
    }

    final class AsyncCall extends b {
        private final Callback responseCallback;

        AsyncCall(Callback callback) {
            super("OkHttp %s", RealCall.this.redactedUrl());
            this.responseCallback = callback;
        }

        final String host() {
            return RealCall.this.originalRequest.url().host();
        }

        final Request request() {
            return RealCall.this.originalRequest;
        }

        final RealCall get() {
            return RealCall.this;
        }

        @Override // okhttp3.internal.b
        public final void execute() {
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
                        if (z) {
                            e.hl().a(4, "Callback failure for " + RealCall.this.toLoggableString(), e);
                        } else {
                            this.responseCallback.onFailure(RealCall.this, e);
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

    final String toLoggableString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getCanceled() ? "canceled " : "");
        sb.append(this.forWebSocket ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(redactedUrl());
        return sb.toString();
    }

    final String redactedUrl() {
        return this.originalRequest.url().redact();
    }

    final Response getResponseWithInterceptorChain() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.client.interceptors());
        arrayList.add(this.retryAndFollowUpInterceptor);
        arrayList.add(new a(this.client.cookieJar()));
        arrayList.add(new okhttp3.internal.a.a(this.client.internalCache()));
        arrayList.add(new okhttp3.internal.connection.a(this.client));
        if (!this.forWebSocket) {
            arrayList.addAll(this.client.networkInterceptors());
        }
        arrayList.add(new okhttp3.internal.b.b(this.forWebSocket));
        return new g(arrayList, null, null, null, 0, this.originalRequest).proceed(this.originalRequest);
    }
}
