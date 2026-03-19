package com.bytedance.sdk.djx.net.k3.sse;

import com.bytedance.sdk.djx.net.k3.Call;
import com.bytedance.sdk.djx.net.k3.OkHttpClient;
import com.bytedance.sdk.djx.net.k3.Request;
import com.bytedance.sdk.djx.net.k3.Response;
import com.bytedance.sdk.djx.net.k3.sse.EventSource;
import com.bytedance.sdk.djx.net.k3.sse.internal.RealEventSource;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EventSources.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007¨\u0006\u000f"}, d2 = {"Lcom/bytedance/sdk/djx/net/k3/sse/EventSources;", "", "()V", "createFactory", "Lcom/bytedance/sdk/djx/net/k3/sse/EventSource$Factory;", "callFactory", "Lcom/bytedance/sdk/djx/net/k3/Call$Factory;", "client", "Lcom/bytedance/sdk/djx/net/k3/OkHttpClient;", "processResponse", "", "response", "Lcom/bytedance/sdk/djx/net/k3/Response;", "listener", "Lcom/bytedance/sdk/djx/net/k3/sse/EventSourceListener;", "net_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class EventSources {
    public static final EventSources INSTANCE = new EventSources();

    private EventSources() {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "required for binary-compatibility!")
    @JvmStatic
    public static final /* synthetic */ EventSource.Factory createFactory(OkHttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        return createFactory((Call.Factory) client);
    }

    @JvmStatic
    public static final EventSource.Factory createFactory(final Call.Factory callFactory) {
        Intrinsics.checkNotNullParameter(callFactory, "callFactory");
        return new EventSource.Factory() { // from class: com.bytedance.sdk.djx.net.k3.sse.EventSources$$ExternalSyntheticLambda0
            @Override // com.bytedance.sdk.djx.net.k3.sse.EventSource.Factory
            public final EventSource newEventSource(Request request, EventSourceListener eventSourceListener) {
                return EventSources.m366createFactory$lambda1(callFactory, request, eventSourceListener);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createFactory$lambda-1, reason: not valid java name */
    public static final EventSource m366createFactory$lambda1(Call.Factory factory, Request request, EventSourceListener eventSourceListener) {
        Intrinsics.checkNotNullParameter(factory, "$callFactory");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(eventSourceListener, "listener");
        if (request.header("Accept") == null) {
            request = request.newBuilder().addHeader("Accept", "text/event-stream").build();
        }
        Intrinsics.checkNotNullExpressionValue(request, "actualRequest");
        RealEventSource realEventSource = new RealEventSource(request, eventSourceListener);
        realEventSource.connect(factory);
        return realEventSource;
    }

    @JvmStatic
    public static final void processResponse(Response response, EventSourceListener listener) {
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Request request = response.request;
        Intrinsics.checkNotNullExpressionValue(request, "response.request");
        new RealEventSource(request, listener).processResponse(response);
    }
}
