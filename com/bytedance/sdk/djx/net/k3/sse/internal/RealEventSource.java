package com.bytedance.sdk.djx.net.k3.sse.internal;

import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.djx.net.io.BufferedSource;
import com.bytedance.sdk.djx.net.io.Timeout;
import com.bytedance.sdk.djx.net.k3.Call;
import com.bytedance.sdk.djx.net.k3.Callback;
import com.bytedance.sdk.djx.net.k3.MediaType;
import com.bytedance.sdk.djx.net.k3.Request;
import com.bytedance.sdk.djx.net.k3.Response;
import com.bytedance.sdk.djx.net.k3.ResponseBody;
import com.bytedance.sdk.djx.net.k3.sse.EventSource;
import com.bytedance.sdk.djx.net.k3.sse.EventSourceListener;
import com.bytedance.sdk.djx.net.k3.sse.internal.ServerSentEventReader;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RealEventSource.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J$\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u000e\u0010 \u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u0004\u001a\u00020\u0005H\u0016J\f\u0010!\u001a\u00020\f*\u00020\"H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/sdk/djx/net/k3/sse/internal/RealEventSource;", "Lcom/bytedance/sdk/djx/net/k3/sse/EventSource;", "Lcom/bytedance/sdk/djx/net/k3/sse/internal/ServerSentEventReader$Callback;", "Lcom/bytedance/sdk/djx/net/k3/Callback;", "request", "Lcom/bytedance/sdk/djx/net/k3/Request;", "listener", "Lcom/bytedance/sdk/djx/net/k3/sse/EventSourceListener;", "(Lcom/bytedance/sdk/djx/net/k3/Request;Lcom/bytedance/sdk/djx/net/k3/sse/EventSourceListener;)V", NotificationCompat.CATEGORY_CALL, "Lcom/bytedance/sdk/djx/net/k3/Call;", "canceled", "", "cancel", "", "connect", "callFactory", "Lcom/bytedance/sdk/djx/net/k3/Call$Factory;", "onEvent", "id", "", "type", "data", "onFailure", "e", "Ljava/io/IOException;", "onResponse", "response", "Lcom/bytedance/sdk/djx/net/k3/Response;", "onRetryChange", "timeMs", "", "processResponse", "isEventStream", "Lcom/bytedance/sdk/djx/net/k3/ResponseBody;", "net_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class RealEventSource implements Callback, EventSource, ServerSentEventReader.Callback {
    private Call call;
    private volatile boolean canceled;
    private final EventSourceListener listener;
    private final Request request;

    @Override // com.bytedance.sdk.djx.net.k3.sse.internal.ServerSentEventReader.Callback
    public void onRetryChange(long timeMs) {
    }

    public RealEventSource(Request request, EventSourceListener eventSourceListener) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(eventSourceListener, "listener");
        this.request = request;
        this.listener = eventSourceListener;
    }

    public final void connect(Call.Factory callFactory) {
        Intrinsics.checkNotNullParameter(callFactory, "callFactory");
        Call callNewCall = callFactory.newCall(this.request);
        callNewCall.enqueue(this);
        this.call = callNewCall;
    }

    @Override // com.bytedance.sdk.djx.net.k3.Callback
    public void onResponse(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(response, "response");
        processResponse(response);
    }

    public final void processResponse(Response response) {
        Timeout timeout;
        Intrinsics.checkNotNullParameter(response, "response");
        Response response2 = response;
        try {
            if (!response.isSuccessful()) {
                this.listener.onFailure(this, null, response);
                CloseableKt.closeFinally(response2, (Throwable) null);
                return;
            }
            ResponseBody responseBody = response.body;
            Intrinsics.checkNotNullExpressionValue(responseBody, "body");
            if (!isEventStream(responseBody)) {
                this.listener.onFailure(this, new IllegalStateException(Intrinsics.stringPlus("Invalid content-type: ", responseBody.getMediaType())), response);
                CloseableKt.closeFinally(response2, (Throwable) null);
                return;
            }
            Call call = this.call;
            if (call != null && (timeout = call.timeout()) != null) {
                timeout.cancel();
            }
            Response responseStripBody = ResponseUtilKt.stripBody(response);
            BufferedSource bufferedSourceSource = responseBody.source();
            Intrinsics.checkNotNullExpressionValue(bufferedSourceSource, "body.source()");
            ServerSentEventReader serverSentEventReader = new ServerSentEventReader(bufferedSourceSource, this);
            try {
                if (!this.canceled) {
                    this.listener.onOpen(this, responseStripBody);
                    while (!this.canceled && serverSentEventReader.processNextEvent()) {
                    }
                }
                if (this.canceled) {
                    this.listener.onFailure(this, new IOException("canceled"), responseStripBody);
                } else {
                    this.listener.onClosed(this);
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(response2, (Throwable) null);
            } catch (Exception e) {
                e = e;
                if (this.canceled) {
                    e = new IOException("canceled", e);
                }
                this.listener.onFailure(this, e, responseStripBody);
                CloseableKt.closeFinally(response2, (Throwable) null);
            }
        } finally {
        }
    }

    private final boolean isEventStream(ResponseBody responseBody) {
        MediaType mediaType = responseBody.getMediaType();
        return mediaType != null && Intrinsics.areEqual(mediaType.type, "text") && Intrinsics.areEqual(mediaType.subtype, "event-stream");
    }

    @Override // com.bytedance.sdk.djx.net.k3.Callback
    public void onFailure(Call call, IOException e) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(e, "e");
        this.listener.onFailure(this, e, null);
    }

    @Override // com.bytedance.sdk.djx.net.k3.sse.EventSource
    /* renamed from: request, reason: from getter */
    public Request getRequest() {
        return this.request;
    }

    @Override // com.bytedance.sdk.djx.net.k3.sse.EventSource
    public void cancel() {
        if (this.canceled) {
            return;
        }
        this.canceled = true;
        Call call = this.call;
        if (call == null) {
            return;
        }
        call.cancel();
    }

    @Override // com.bytedance.sdk.djx.net.k3.sse.internal.ServerSentEventReader.Callback
    public void onEvent(final String id, final String type, final String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.canceled) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.djx.net.k3.sse.internal.RealEventSource$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                RealEventSource.m367onEvent$lambda2(this.f$0, id, type, data);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onEvent$lambda-2, reason: not valid java name */
    public static final void m367onEvent$lambda2(RealEventSource realEventSource, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(realEventSource, "this$0");
        Intrinsics.checkNotNullParameter(str3, "$data");
        realEventSource.listener.onEvent(realEventSource, str, str2, str3);
    }
}
