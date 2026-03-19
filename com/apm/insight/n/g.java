package com.apm.insight.n;

import java.io.DataOutputStream;
import java.io.OutputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class g extends DataOutputStream {
    public g(OutputStream outputStream) {
        super(outputStream);
    }

    public void a() {
        super.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
