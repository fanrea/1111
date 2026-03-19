package com.bytedance.sdk.djx.net.k3.internal.cache;

import com.bytedance.sdk.djx.net.io.Sink;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface CacheRequest {
    void abort();

    Sink body() throws IOException;
}
