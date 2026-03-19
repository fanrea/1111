package com.bytedance.sdk.component.b.hc.d.d;

import com.bytedance.sdk.component.b.d.h;
import com.bytedance.sdk.component.b.d.yo;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class u extends h {
    private boolean d;

    protected void d(IOException iOException) {
    }

    u(yo yoVar) {
        super(yoVar);
    }

    @Override // com.bytedance.sdk.component.b.d.h, com.bytedance.sdk.component.b.d.yo
    public void a_(com.bytedance.sdk.component.b.d.b bVar, long j) throws IOException {
        if (this.d) {
            bVar.gb(j);
            return;
        }
        try {
            super.a_(bVar, j);
        } catch (IOException e) {
            this.d = true;
            d(e);
        }
    }

    @Override // com.bytedance.sdk.component.b.d.h, com.bytedance.sdk.component.b.d.yo, java.io.Flushable
    public void flush() throws IOException {
        if (this.d) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e) {
            this.d = true;
            d(e);
        }
    }

    @Override // com.bytedance.sdk.component.b.d.h, com.bytedance.sdk.component.b.d.yo, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.bytedance.sdk.component.b.d.rf
    public void close() throws IOException {
        if (this.d) {
            return;
        }
        try {
            super.close();
        } catch (IOException e) {
            this.d = true;
            d(e);
        }
    }
}
