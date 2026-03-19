package com.dhylive.app.net;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* compiled from: BaseResp.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0003\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/dhylive/app/net/SuccessResp;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/dhylive/app/net/BaseResp;", "data", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class SuccessResp<T> extends BaseResp<T> {
    private final T data;

    public SuccessResp(T t) {
        super(null, 0, null, 7, null);
        this.data = t;
    }

    @Override // com.dhylive.app.net.BaseResp
    public T getData() {
        return this.data;
    }
}
