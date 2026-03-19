package com.bytedance.sdk.djx.net.k3.sse;

import com.bytedance.sdk.djx.net.k3.Request;
import kotlin.Metadata;

/* compiled from: EventSource.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0006J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/sdk/djx/net/k3/sse/EventSource;", "", "cancel", "", "request", "Lcom/bytedance/sdk/djx/net/k3/Request;", "Factory", "net_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface EventSource {

    /* compiled from: EventSource.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/sdk/djx/net/k3/sse/EventSource$Factory;", "", "newEventSource", "Lcom/bytedance/sdk/djx/net/k3/sse/EventSource;", "request", "Lcom/bytedance/sdk/djx/net/k3/Request;", "listener", "Lcom/bytedance/sdk/djx/net/k3/sse/EventSourceListener;", "net_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        EventSource newEventSource(Request request, EventSourceListener listener);
    }

    void cancel();

    Request request();
}
