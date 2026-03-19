package com.dhylive.app.net;

import androidx.exifinterface.media.ExifInterface;
import com.blankj.utilcode.util.LogUtils;
import com.dhylive.app.AppApplication;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.CancellationException;
import javax.net.ssl.SSLException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.json.JSONException;
import retrofit2.HttpException;

/* compiled from: BaseManager.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\"\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004H\u0002JA\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00040\u000b\"\u0004\b\u0000\u0010\u00052\"\u0010\f\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00040\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/dhylive/app/net/BaseManager;", "", "()V", "handleHttpError", "Lcom/dhylive/app/net/BaseResp;", ExifInterface.GPS_DIRECTION_TRUE, "e", "", "handleHttpSuccess", "response", "request", "Lkotlinx/coroutines/flow/Flow;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class BaseManager {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: BaseManager.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/dhylive/app/net/BaseResp;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.net.BaseManager$request$1", f = "BaseManager.kt", i = {1, 2}, l = {33, 36, 39, 42}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
    /* renamed from: com.dhylive.app.net.BaseManager$request$1, reason: invalid class name */
    static final class AnonymousClass1<T> extends SuspendLambda implements Function2<FlowCollector<? super BaseResp<? extends T>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super BaseResp<? extends T>>, Object> $block;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ BaseManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function1<? super Continuation<? super BaseResp<? extends T>>, ? extends Object> function1, BaseManager baseManager, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$block = function1;
            this.this$0 = baseManager;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1<>(this.$block, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(FlowCollector<? super BaseResp<? extends T>> flowCollector, Continuation<? super Unit> continuation) {
            return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00a0  */
        /* JADX WARN: Type inference failed for: r1v11, types: [kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Object, kotlinx.coroutines.flow.FlowCollector] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L37
                if (r1 == r5) goto L32
                if (r1 == r4) goto L28
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                goto L32
            L15:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1d:
                java.lang.Object r1 = r7.L$1
                java.lang.Object r3 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r3 = (kotlinx.coroutines.flow.FlowCollector) r3
                kotlin.ResultKt.throwOnFailure(r8)
                goto L97
            L28:
                java.lang.Object r1 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L30
                goto L69
            L30:
                r8 = move-exception
                goto L70
            L32:
                kotlin.ResultKt.throwOnFailure(r8)
                goto Lb5
            L37:
                kotlin.ResultKt.throwOnFailure(r8)
                java.lang.Object r8 = r7.L$0
                r1 = r8
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                boolean r8 = com.blankj.utilcode.util.NetworkUtils.isConnected()
                if (r8 != 0) goto L5a
                com.dhylive.app.net.ErrorResp r8 = new com.dhylive.app.net.ErrorResp
                com.dhylive.app.net.NetError r2 = com.dhylive.app.net.NetError.NET_NOT_CONNECTED
                r8.<init>(r2)
                com.dhylive.app.net.BaseResp r8 = (com.dhylive.app.net.BaseResp) r8
                r2 = r7
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r7.label = r5
                java.lang.Object r8 = r1.emit(r8, r2)
                if (r8 != r0) goto Lb5
                return r0
            L5a:
                kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super com.dhylive.app.net.BaseResp<? extends T>>, java.lang.Object> r8 = r7.$block
                kotlin.Result$Companion r5 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L30
                r7.L$0 = r1     // Catch: java.lang.Throwable -> L30
                r7.label = r4     // Catch: java.lang.Throwable -> L30
                java.lang.Object r8 = r8.invoke(r7)     // Catch: java.lang.Throwable -> L30
                if (r8 != r0) goto L69
                return r0
            L69:
                com.dhylive.app.net.BaseResp r8 = (com.dhylive.app.net.BaseResp) r8     // Catch: java.lang.Throwable -> L30
                java.lang.Object r8 = kotlin.Result.constructor-impl(r8)     // Catch: java.lang.Throwable -> L30
                goto L7a
            L70:
                kotlin.Result$Companion r4 = kotlin.Result.Companion
                java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)
                java.lang.Object r8 = kotlin.Result.constructor-impl(r8)
            L7a:
                r6 = r1
                r1 = r8
                r8 = r6
                com.dhylive.app.net.BaseManager r4 = r7.this$0
                java.lang.Throwable r5 = kotlin.Result.exceptionOrNull-impl(r1)
                if (r5 == 0) goto L98
                com.dhylive.app.net.BaseResp r4 = com.dhylive.app.net.BaseManager.access$handleHttpError(r4, r5)
                r7.L$0 = r8
                r7.L$1 = r1
                r7.label = r3
                java.lang.Object r3 = r8.emit(r4, r7)
                if (r3 != r0) goto L96
                return r0
            L96:
                r3 = r8
            L97:
                r8 = r3
            L98:
                com.dhylive.app.net.BaseManager r3 = r7.this$0
                boolean r4 = kotlin.Result.isSuccess-impl(r1)
                if (r4 == 0) goto Lb5
                r4 = r1
                com.dhylive.app.net.BaseResp r4 = (com.dhylive.app.net.BaseResp) r4
                com.dhylive.app.net.BaseResp r3 = com.dhylive.app.net.BaseManager.access$handleHttpSuccess(r3, r4)
                r7.L$0 = r1
                r1 = 0
                r7.L$1 = r1
                r7.label = r2
                java.lang.Object r8 = r8.emit(r3, r7)
                if (r8 != r0) goto Lb5
                return r0
            Lb5:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dhylive.app.net.BaseManager.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final <T> Flow<BaseResp<T>> request(Function1<? super Continuation<? super BaseResp<? extends T>>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(block, this, null)), Dispatchers.getIO());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> BaseResp<T> handleHttpSuccess(BaseResp<? extends T> response) {
        int code = response.getCode();
        if (code != 0) {
            if (code == 1005 || code == 10015 || code == 10021) {
                AppApplication.INSTANCE.getInstance().logout();
                return new ErrorResp(response.getCode(), response.getMsg());
            }
            return new ErrorResp(response.getCode(), response.getMsg());
        }
        T data = response.getData();
        if (data == null || ((data instanceof List) && ((List) data).isEmpty())) {
            return new EmptyResp();
        }
        return new SuccessResp(data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> BaseResp<T> handleHttpError(Throwable e) {
        LogUtils.e(e);
        if (e instanceof UnknownHostException) {
            return new ErrorResp(NetError.NET_ERROR);
        }
        if (e instanceof JSONException ? true : e instanceof JsonIOException ? true : e instanceof JsonParseException) {
            return new ErrorResp(NetError.CONVERT_ERROR);
        }
        if (e instanceof SocketTimeoutException) {
            return new ErrorResp(NetError.TIMEOUT_ERROR);
        }
        if (e instanceof ConnectException) {
            return new ErrorResp(NetError.NET_CONNECT_ERROR);
        }
        if (e instanceof HttpException) {
            return new ErrorResp(NetError.HTTP_ERROR.getCode(), NetError.HTTP_ERROR.getMsg() + ((HttpException) e).code());
        }
        if (e instanceof SSLException) {
            return new ErrorResp(NetError.SSL_ERROR);
        }
        if (e instanceof CancellationException) {
            return new ErrorResp(NetError.CANCEL);
        }
        return new ErrorResp(NetError.UNKNOWN);
    }
}
