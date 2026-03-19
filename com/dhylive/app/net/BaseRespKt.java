package com.dhylive.app.net;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseResp.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a5\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u001d\u0010\u0005\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\b¨\u0006\t"}, d2 = {"convertEmpty", "Lcom/dhylive/app/net/BaseResp;", ExifInterface.GPS_DIRECTION_TRUE, "parseData", "", "listenerBuilder", "Lkotlin/Function1;", "Lcom/dhylive/app/net/ResultBuilder;", "Lkotlin/ExtensionFunctionType;", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class BaseRespKt {
    public static final <T> void parseData(BaseResp<? extends T> baseResp, Function1<? super ResultBuilder<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(baseResp, "<this>");
        Intrinsics.checkNotNullParameter(function1, "listenerBuilder");
        ResultBuilder resultBuilder = new ResultBuilder();
        function1.invoke(resultBuilder);
        if (baseResp instanceof SuccessResp) {
            resultBuilder.getOnSuccess().invoke(((SuccessResp) baseResp).getData());
        } else if (baseResp instanceof EmptyResp) {
            resultBuilder.getOnEmpty().invoke();
        } else if (baseResp instanceof ErrorResp) {
            resultBuilder.getOnError().invoke(Integer.valueOf(baseResp.getCode()), baseResp.getMsg());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> BaseResp<T> convertEmpty(BaseResp<? extends T> baseResp) {
        Intrinsics.checkNotNullParameter(baseResp, "<this>");
        return baseResp.getCode() == 0 ? new EmptyResp() : baseResp;
    }
}
