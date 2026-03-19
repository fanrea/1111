package com.dhylive.app.net;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseResp.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0016\u0018\u0000 \u0010*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0001\u0010B%\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0003\u001a\u0004\u0018\u00018\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/dhylive/app/net/BaseResp;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Serializable;", "data", "code", "", "msg", "", "(Ljava/lang/Object;ILjava/lang/String;)V", "getCode", "()I", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getMsg", "()Ljava/lang/String;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class BaseResp<T> implements Serializable {
    public static final int REQUEST_LOGIN_VERIFICATION_FAILED = 10015;
    public static final int REQUEST_SUCCESS_CODE = 0;
    public static final String REQUEST_SUCCESS_MSG = "请求成功";
    public static final int REQUEST_TOKEN_INVALID = 1005;
    public static final int REQUEST_USER_FORBIDDEN = 10021;

    @SerializedName(alternate = {"errorCode"}, value = "code")
    private final int code;
    private final T data;

    @SerializedName(alternate = {"errorMsg"}, value = "msg")
    private final String msg;

    public BaseResp() {
        this(null, 0, null, 7, null);
    }

    public BaseResp(T t, int i, String str) {
        Intrinsics.checkNotNullParameter(str, "msg");
        this.data = t;
        this.code = i;
        this.msg = str;
    }

    public /* synthetic */ BaseResp(Object obj, int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : obj, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? REQUEST_SUCCESS_MSG : str);
    }

    public T getData() {
        return this.data;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
