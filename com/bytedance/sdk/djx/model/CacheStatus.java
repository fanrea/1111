package com.bytedance.sdk.djx.model;

import com.alipay.sdk.m.f0.c;
import com.alipay.sdk.m.p0.b;
import kotlin.Metadata;

/* compiled from: CacheStatus.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/sdk/djx/model/CacheStatus;", "", b.d, "", "(Ljava/lang/String;II)V", "getValue", "()I", "TASK_NOT_COMPLETE", c.p, "FAIL_NO_CACHE_IN_HISTORY", "FAIL_CACHE_REMOVED", "model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public enum CacheStatus {
    TASK_NOT_COMPLETE(-1),
    SUCCESS(1),
    FAIL_NO_CACHE_IN_HISTORY(2),
    FAIL_CACHE_REMOVED(3);

    private final int value;

    CacheStatus(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
