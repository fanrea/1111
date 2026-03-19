package com.bytedance.sdk.djx.net.k3.sse.internal;

import com.bytedance.sdk.djx.net.io.Buffer;
import com.bytedance.sdk.djx.net.io.BufferedSource;
import com.bytedance.sdk.djx.net.io.ByteString;
import com.bytedance.sdk.djx.net.io.ByteStringUtilKt;
import com.bytedance.sdk.djx.net.io.Options;
import com.sigmob.sdk.base.n;
import com.ss.texturerender.TextureRenderKeys;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServerSentEventReader.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0002\u0011\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/sdk/djx/net/k3/sse/internal/ServerSentEventReader;", "", n.l, "Lcom/bytedance/sdk/djx/net/io/BufferedSource;", TextureRenderKeys.KEY_IS_CALLBACK, "Lcom/bytedance/sdk/djx/net/k3/sse/internal/ServerSentEventReader$Callback;", "(Lcom/bytedance/sdk/djx/net/io/BufferedSource;Lcom/bytedance/sdk/djx/net/k3/sse/internal/ServerSentEventReader$Callback;)V", "lastId", "", "completeEvent", "", "id", "type", "data", "Lcom/bytedance/sdk/djx/net/io/Buffer;", "processNextEvent", "", "Callback", "Companion", "net_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class ServerSentEventReader {
    private final Callback callback;
    private String lastId;
    private final BufferedSource source;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Options options = Options.of(ByteStringUtilKt.encodeUtf8("\r\n"), ByteStringUtilKt.encodeUtf8("\r"), ByteStringUtilKt.encodeUtf8("\n"), ByteStringUtilKt.encodeUtf8("data: "), ByteStringUtilKt.encodeUtf8("data:"), ByteStringUtilKt.encodeUtf8("data\r\n"), ByteStringUtilKt.encodeUtf8("data\r"), ByteStringUtilKt.encodeUtf8("data\n"), ByteStringUtilKt.encodeUtf8("id: "), ByteStringUtilKt.encodeUtf8("id:"), ByteStringUtilKt.encodeUtf8("id\r\n"), ByteStringUtilKt.encodeUtf8("id\r"), ByteStringUtilKt.encodeUtf8("id\n"), ByteStringUtilKt.encodeUtf8("event: "), ByteStringUtilKt.encodeUtf8("event:"), ByteStringUtilKt.encodeUtf8("event\r\n"), ByteStringUtilKt.encodeUtf8("event\r"), ByteStringUtilKt.encodeUtf8("event\n"), ByteStringUtilKt.encodeUtf8("retry: "), ByteStringUtilKt.encodeUtf8("retry:"));
    private static final ByteString CRLF = ByteStringUtilKt.encodeUtf8("\r\n");

    /* compiled from: ServerSentEventReader.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/sdk/djx/net/k3/sse/internal/ServerSentEventReader$Callback;", "", "onEvent", "", "id", "", "type", "data", "onRetryChange", "timeMs", "", "net_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Callback {
        void onEvent(String id, String type, String data);

        void onRetryChange(long timeMs);
    }

    public ServerSentEventReader(BufferedSource bufferedSource, Callback callback) {
        Intrinsics.checkNotNullParameter(bufferedSource, n.l);
        Intrinsics.checkNotNullParameter(callback, TextureRenderKeys.KEY_IS_CALLBACK);
        this.source = bufferedSource;
        this.callback = callback;
    }

    /* JADX WARN: Code restructure failed: missing block: B:88:0x0008, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean processNextEvent() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.djx.net.k3.sse.internal.ServerSentEventReader.processNextEvent():boolean");
    }

    private final void completeEvent(String id, String type, Buffer data) throws IOException {
        if (data.size() != 0) {
            this.lastId = id;
            data.skip(1L);
            Callback callback = this.callback;
            String utf8 = data.readUtf8();
            Intrinsics.checkNotNullExpressionValue(utf8, "data.readUtf8()");
            callback.onEvent(id, type, utf8);
        }
    }

    /* compiled from: ServerSentEventReader.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\f\u0010\u000f\u001a\u00020\u0010*\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/sdk/djx/net/k3/sse/internal/ServerSentEventReader$Companion;", "", "()V", "CRLF", "Lcom/bytedance/sdk/djx/net/io/ByteString;", "options", "Lcom/bytedance/sdk/djx/net/io/Options;", "kotlin.jvm.PlatformType", "getOptions", "()Lcom/bytedance/sdk/djx/net/io/Options;", "readData", "", "Lcom/bytedance/sdk/djx/net/io/BufferedSource;", "data", "Lcom/bytedance/sdk/djx/net/io/Buffer;", "readRetryMs", "", "net_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Options getOptions() {
            return ServerSentEventReader.options;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void readData(BufferedSource bufferedSource, Buffer buffer) throws IOException {
            buffer.writeByte(10);
            bufferedSource.readFully(buffer, bufferedSource.indexOfElement(ServerSentEventReader.CRLF));
            bufferedSource.select(getOptions());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long readRetryMs(BufferedSource bufferedSource) throws IOException {
            String utf8LineStrict = bufferedSource.readUtf8LineStrict();
            Intrinsics.checkNotNullExpressionValue(utf8LineStrict, "retryString");
            return ByteStringUtilKt.toLongOrDefault(utf8LineStrict, -1L);
        }
    }
}
