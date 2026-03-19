package com.bytedance.sdk.djx.net.k3.internal.cache;

import com.bytedance.sdk.djx.net.io.Buffer;
import com.bytedance.sdk.djx.net.io.ForwardingSink;
import com.bytedance.sdk.djx.net.io.Sink;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class FaultHidingSink extends ForwardingSink {
    private boolean hasErrors;

    protected void onException(IOException iOException) {
    }

    FaultHidingSink(Sink sink) {
        super(sink);
    }

    @Override // com.bytedance.sdk.djx.net.io.ForwardingSink, com.bytedance.sdk.djx.net.io.Sink
    public void write(Buffer buffer, long j) throws IOException {
        if (this.hasErrors) {
            buffer.skip(j);
            return;
        }
        try {
            super.write(buffer, j);
        } catch (IOException e) {
            this.hasErrors = true;
            onException(e);
        }
    }

    @Override // com.bytedance.sdk.djx.net.io.ForwardingSink, com.bytedance.sdk.djx.net.io.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e) {
            this.hasErrors = true;
            onException(e);
        }
    }

    @Override // com.bytedance.sdk.djx.net.io.ForwardingSink, com.bytedance.sdk.djx.net.io.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.hasErrors) {
            return;
        }
        try {
            super.close();
        } catch (IOException e) {
            this.hasErrors = true;
            onException(e);
        }
    }
}
