package com.dhylive.app.net;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseResp.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0015\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/dhylive/app/net/ErrorResp;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/dhylive/app/net/BaseResp;", "netError", "Lcom/dhylive/app/net/NetError;", "(Lcom/dhylive/app/net/NetError;)V", "code", "", "msg", "", "(ILjava/lang/String;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class ErrorResp<T> extends BaseResp<T> {
    private final int code;
    private final String msg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ErrorResp(int i, String str) {
        super(null, 0, null, 7, null);
        Intrinsics.checkNotNullParameter(str, "msg");
        this.code = i;
        this.msg = str;
    }

    @Override // com.dhylive.app.net.BaseResp
    public int getCode() {
        return this.code;
    }

    @Override // com.dhylive.app.net.BaseResp
    public String getMsg() {
        return this.msg;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ErrorResp(NetError netError) {
        this(netError.getCode(), netError.getMsg());
        Intrinsics.checkNotNullParameter(netError, "netError");
    }
}
