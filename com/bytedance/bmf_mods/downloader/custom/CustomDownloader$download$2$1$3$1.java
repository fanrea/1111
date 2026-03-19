package com.bytedance.bmf_mods.downloader.custom;

import com.bytedance.bmf_mods_api.IDownloadCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CustomDownloader.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.bytedance.bmf_mods.downloader.custom.CustomDownloader$download$2$1$3$1", f = "CustomDownloader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class CustomDownloader$download$2$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IDownloadCallback $downloadCallback;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CustomDownloader$download$2$1$3$1(IDownloadCallback iDownloadCallback, Continuation<? super CustomDownloader$download$2$1$3$1> continuation) {
        super(2, continuation);
        this.$downloadCallback = iDownloadCallback;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CustomDownloader$download$2$1$3$1(this.$downloadCallback, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$downloadCallback.callback(-100040);
        return Unit.INSTANCE;
    }
}
