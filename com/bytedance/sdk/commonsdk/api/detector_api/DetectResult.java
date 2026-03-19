package com.bytedance.sdk.commonsdk.api.detector_api;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IDetectCallback.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001a*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u001aB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\nJ4\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0015\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/sdk/commonsdk/api/detector_api/DetectResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "success", "", "errorCode", "", "data", "(ZILjava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getErrorCode", "()I", "getSuccess", "()Z", "component1", "component2", "component3", "copy", "(ZILjava/lang/Object;)Lcom/bytedance/sdk/commonsdk/api/detector_api/DetectResult;", "equals", "other", "hashCode", "toString", "", "Companion", "api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final /* data */ class DetectResult<T> {
    public static final int CODE_OK = 0;
    public static final int ERROR_CODE_INIT = 10001;
    private final T data;
    private final int errorCode;
    private final boolean success;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final DetectResult<Object> SDK_INIT_ERROR = new DetectResult<>(false, 10001, null);

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DetectResult copy$default(DetectResult detectResult, boolean z, int i, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            z = detectResult.success;
        }
        if ((i2 & 2) != 0) {
            i = detectResult.errorCode;
        }
        if ((i2 & 4) != 0) {
            obj = detectResult.data;
        }
        return detectResult.copy(z, i, obj);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component2, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    public final T component3() {
        return this.data;
    }

    public final DetectResult<T> copy(boolean success, int errorCode, T data) {
        return new DetectResult<>(success, errorCode, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DetectResult)) {
            return false;
        }
        DetectResult detectResult = (DetectResult) other;
        return this.success == detectResult.success && this.errorCode == detectResult.errorCode && Intrinsics.areEqual(this.data, detectResult.data);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.success;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int iHashCode = ((r0 * 31) + Integer.hashCode(this.errorCode)) * 31;
        T t = this.data;
        return iHashCode + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return "DetectResult(success=" + this.success + ", errorCode=" + this.errorCode + ", data=" + this.data + ')';
    }

    /* compiled from: IDetectCallback.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/sdk/commonsdk/api/detector_api/DetectResult$Companion;", "", "()V", "CODE_OK", "", "ERROR_CODE_INIT", "SDK_INIT_ERROR", "Lcom/bytedance/sdk/commonsdk/api/detector_api/DetectResult;", "getSDK_INIT_ERROR", "()Lcom/bytedance/sdk/commonsdk/api/detector_api/DetectResult;", "api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DetectResult<Object> getSDK_INIT_ERROR() {
            return DetectResult.SDK_INIT_ERROR;
        }
    }

    public DetectResult(boolean z, int i, T t) {
        this.success = z;
        this.errorCode = i;
        this.data = t;
    }

    public final T getData() {
        return this.data;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final boolean getSuccess() {
        return this.success;
    }
}
