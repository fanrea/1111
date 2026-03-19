package com.bytedance.sdk.djx.net.k3.sse.internal;

import com.baidu.mobads.container.components.command.j;
import com.bytedance.sdk.djx.net.io.Buffer;
import com.bytedance.sdk.djx.net.io.BufferedSource;
import com.bytedance.sdk.djx.net.io.Okio;
import com.bytedance.sdk.djx.net.io.Source;
import com.bytedance.sdk.djx.net.io.Timeout;
import com.bytedance.sdk.djx.net.k3.MediaType;
import com.bytedance.sdk.djx.net.k3.ResponseBody;
import com.sigmob.sdk.base.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResponseUtil.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010H\u0016J\u0010\u0010\u0012\u001a\n \u0011*\u0004\u0018\u00010\u00130\u0013H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/sdk/djx/net/k3/sse/internal/UnreadableResponseBody;", "Lcom/bytedance/sdk/djx/net/k3/ResponseBody;", "Lcom/bytedance/sdk/djx/net/io/Source;", "mediaType", "Lcom/bytedance/sdk/djx/net/k3/MediaType;", j.i, "", "(Lcom/bytedance/sdk/djx/net/k3/MediaType;J)V", "close", "", "contentType", "read", "sink", "Lcom/bytedance/sdk/djx/net/io/Buffer;", "byteCount", n.l, "Lcom/bytedance/sdk/djx/net/io/BufferedSource;", "kotlin.jvm.PlatformType", "timeout", "Lcom/bytedance/sdk/djx/net/io/Timeout;", "net_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class UnreadableResponseBody extends ResponseBody implements Source {
    private final long contentLength;
    private final MediaType mediaType;

    @Override // com.bytedance.sdk.djx.net.k3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public UnreadableResponseBody(MediaType mediaType, long j) {
        this.mediaType = mediaType;
        this.contentLength = j;
    }

    @Override // com.bytedance.sdk.djx.net.k3.ResponseBody
    /* renamed from: contentType, reason: from getter */
    public MediaType getMediaType() {
        return this.mediaType;
    }

    @Override // com.bytedance.sdk.djx.net.k3.ResponseBody
    /* renamed from: contentLength, reason: from getter */
    public long getContentLength() {
        return this.contentLength;
    }

    @Override // com.bytedance.sdk.djx.net.k3.ResponseBody
    public BufferedSource source() {
        return Okio.buffer(this);
    }

    @Override // com.bytedance.sdk.djx.net.io.Source
    public long read(Buffer sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        throw new IllegalStateException("Unreadable ResponseBody! These Response objects have bodies that are stripped:\n * Response.cacheResponse\n * Response.networkResponse\n * Response.priorResponse\n * EventSourceListener\n * WebSocketListener\n(It is safe to call contentType() and contentLength() on these response bodies.)");
    }

    @Override // com.bytedance.sdk.djx.net.io.Source
    public Timeout timeout() {
        return Timeout.NONE;
    }
}
