package com.dhylive.app.net;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseResp.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u001e\u001a\u00020\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J>\u0010 \u001a\u00020\u000626\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00060\fJ)\u0010!\u001a\u00020\u00062!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00060\u0018R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nRJ\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00060\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R5\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00060\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/dhylive/app/net/ResultBuilder;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "onEmpty", "Lkotlin/Function0;", "", "getOnEmpty", "()Lkotlin/jvm/functions/Function0;", "setOnEmpty", "(Lkotlin/jvm/functions/Function0;)V", "onError", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "errorCode", "", "errorMsg", "getOnError", "()Lkotlin/jvm/functions/Function2;", "setOnError", "(Lkotlin/jvm/functions/Function2;)V", "onSuccess", "Lkotlin/Function1;", "data", "getOnSuccess", "()Lkotlin/jvm/functions/Function1;", "setOnSuccess", "(Lkotlin/jvm/functions/Function1;)V", "empty", "block", "error", "success", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class ResultBuilder<T> {
    private Function1<? super T, Unit> onSuccess = new Function1<T, Unit>() { // from class: com.dhylive.app.net.ResultBuilder$onSuccess$1
        /* renamed from: invoke, reason: collision with other method in class */
        public final void m378invoke(T t) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m378invoke((ResultBuilder$onSuccess$1<T>) obj);
            return Unit.INSTANCE;
        }
    };
    private Function0<Unit> onEmpty = new Function0<Unit>() { // from class: com.dhylive.app.net.ResultBuilder$onEmpty$1
        /* renamed from: invoke, reason: collision with other method in class */
        public final void m377invoke() {
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m377invoke();
            return Unit.INSTANCE;
        }
    };
    private Function2<? super Integer, ? super String, Unit> onError = new Function2<Integer, String, Unit>() { // from class: com.dhylive.app.net.ResultBuilder$onError$1
        public final void invoke(int i, String str) {
            Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke(((Number) obj).intValue(), (String) obj2);
            return Unit.INSTANCE;
        }
    };

    public final Function1<T, Unit> getOnSuccess() {
        return this.onSuccess;
    }

    public final void setOnSuccess(Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onSuccess = function1;
    }

    public final Function0<Unit> getOnEmpty() {
        return this.onEmpty;
    }

    public final void setOnEmpty(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onEmpty = function0;
    }

    public final Function2<Integer, String, Unit> getOnError() {
        return this.onError;
    }

    public final void setOnError(Function2<? super Integer, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.onError = function2;
    }

    public final void success(Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.onSuccess = block;
    }

    public final void error(Function2<? super Integer, ? super String, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.onError = block;
    }

    public final void empty(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.onEmpty = block;
    }
}
