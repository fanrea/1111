package com.dhylive.app.base;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.dhylive.app.net.BaseResp;
import com.dhylive.app.net.ErrorResp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: BaseViewModel.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JH\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u0013*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00130\u00150\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00072\u0018\u0010\u0017\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00130\u0015\u0012\u0004\u0012\u00020\u00120\u0018H\u0084@¢\u0006\u0002\u0010\u0019R\u0018\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001b\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/dhylive/app/base/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_errorLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/dhylive/app/net/ErrorResp;", "_loadingLiveData", "", "Lcom/dhylive/app/base/Loading;", "activityLoadingLiveData", "Landroidx/lifecycle/LiveData;", "getActivityLoadingLiveData", "()Landroidx/lifecycle/LiveData;", "errorLiveData", "getErrorLiveData", "fragmentLoadingLiveData", "getFragmentLoadingLiveData", "collectLoading", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "Lcom/dhylive/app/net/BaseResp;", "loading", "action", "Lkotlin/Function1;", "(Lkotlinx/coroutines/flow/Flow;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class BaseViewModel extends ViewModel {
    private final MutableLiveData<ErrorResp<?>> _errorLiveData;
    private final MutableLiveData<Boolean> _loadingLiveData;
    private final LiveData<Boolean> activityLoadingLiveData;
    private final LiveData<ErrorResp<?>> errorLiveData;
    private final LiveData<Boolean> fragmentLoadingLiveData;

    public BaseViewModel() {
        MutableLiveData<ErrorResp<?>> mutableLiveData = new MutableLiveData<>();
        this._errorLiveData = mutableLiveData;
        this.errorLiveData = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this._loadingLiveData = mutableLiveData2;
        this.activityLoadingLiveData = mutableLiveData2;
        this.fragmentLoadingLiveData = mutableLiveData2;
    }

    public final LiveData<ErrorResp<?>> getErrorLiveData() {
        return this.errorLiveData;
    }

    public final LiveData<Boolean> getActivityLoadingLiveData() {
        return this.activityLoadingLiveData;
    }

    public final LiveData<Boolean> getFragmentLoadingLiveData() {
        return this.fragmentLoadingLiveData;
    }

    public static /* synthetic */ Object collectLoading$default(BaseViewModel baseViewModel, Flow flow, boolean z, Function1 function1, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: collectLoading");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        return baseViewModel.collectLoading(flow, z, function1, continuation);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: BaseViewModel.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/dhylive/app/net/BaseResp;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.base.BaseViewModel$collectLoading$2", f = "BaseViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.base.BaseViewModel$collectLoading$2, reason: invalid class name */
    static final class AnonymousClass2<T> extends SuspendLambda implements Function2<FlowCollector<? super BaseResp<? extends T>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $loading;
        int label;
        final /* synthetic */ BaseViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(boolean z, BaseViewModel baseViewModel, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$loading = z;
            this.this$0 = baseViewModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2<>(this.$loading, this.this$0, continuation);
        }

        public final Object invoke(FlowCollector<? super BaseResp<? extends T>> flowCollector, Continuation<? super Unit> continuation) {
            return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (this.$loading) {
                this.this$0._loadingLiveData.setValue(Boxing.boxBoolean(true));
            }
            return Unit.INSTANCE;
        }
    }

    protected final <T> Object collectLoading(Flow<? extends BaseResp<? extends T>> flow, boolean z, Function1<? super BaseResp<? extends T>, Unit> function1, Continuation<? super Unit> continuation) {
        Object objCollectLatest = FlowKt.collectLatest(FlowKt.onCompletion(FlowKt.onStart(flow, new AnonymousClass2(z, this, null)), new AnonymousClass3(z, this, null)), new AnonymousClass4(function1, null), continuation);
        return objCollectLatest == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollectLatest : Unit.INSTANCE;
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: BaseViewModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/dhylive/app/net/BaseResp;", "it", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.base.BaseViewModel$collectLoading$3", f = "BaseViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.base.BaseViewModel$collectLoading$3, reason: invalid class name */
    static final class AnonymousClass3<T> extends SuspendLambda implements Function3<FlowCollector<? super BaseResp<? extends T>>, Throwable, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $loading;
        int label;
        final /* synthetic */ BaseViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(boolean z, BaseViewModel baseViewModel, Continuation<? super AnonymousClass3> continuation) {
            super(3, continuation);
            this.$loading = z;
            this.this$0 = baseViewModel;
        }

        public final Object invoke(FlowCollector<? super BaseResp<? extends T>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            return new AnonymousClass3(this.$loading, this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (this.$loading) {
                this.this$0._loadingLiveData.setValue(Boxing.boxBoolean(false));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: BaseViewModel.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "it", "Lcom/dhylive/app/net/BaseResp;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.base.BaseViewModel$collectLoading$4", f = "BaseViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.base.BaseViewModel$collectLoading$4, reason: invalid class name */
    static final class AnonymousClass4<T> extends SuspendLambda implements Function2<BaseResp<? extends T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<BaseResp<? extends T>, Unit> $action;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass4(Function1<? super BaseResp<? extends T>, Unit> function1, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$action = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass4 = BaseViewModel.this.new AnonymousClass4<>(this.$action, continuation);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        public final Object invoke(BaseResp<? extends T> baseResp, Continuation<? super Unit> continuation) {
            return create(baseResp, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            BaseResp baseResp = (BaseResp) this.L$0;
            if (baseResp instanceof ErrorResp) {
                BaseViewModel.this._errorLiveData.setValue(baseResp);
            }
            this.$action.invoke(baseResp);
            return Unit.INSTANCE;
        }
    }
}
