package com.bytedance.sdk.djx.core.business.budrama.detail;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailLoadFromCacheTask;
import com.bytedance.sdk.djx.model.CacheStatus;
import com.bytedance.sdk.djx.model.DramaDetail;
import com.bytedance.sdk.djx.utils.thread.TTExecutor;
import com.bytedance.sdk.djx.utils.thread.TTRunnable;
import com.ss.texturerender.TextureRenderKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DramaNetCacheManager.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/sdk/djx/core/business/budrama/detail/DramaDetailLoadFromCacheTask;", "", "dramaId", "", "index", "", TextureRenderKeys.KEY_IS_CALLBACK, "Lcom/bytedance/sdk/djx/core/business/budrama/detail/IDramaDetailLoadFromCacheCallback;", "(JILcom/bytedance/sdk/djx/core/business/budrama/detail/IDramaDetailLoadFromCacheCallback;)V", "getCallback", "()Lcom/bytedance/sdk/djx/core/business/budrama/detail/IDramaDetailLoadFromCacheCallback;", "canceled", "", "detail", "Lcom/bytedance/sdk/djx/model/DramaDetail;", "getIndex", "()I", "status", "Lcom/bytedance/sdk/djx/model/CacheStatus;", "cancel", "", "getStatus", "start", "sdk_core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class DramaDetailLoadFromCacheTask {
    private final IDramaDetailLoadFromCacheCallback callback;
    private boolean canceled;
    private DramaDetail detail;
    private final long dramaId;
    private final int index;
    private CacheStatus status;

    public DramaDetailLoadFromCacheTask(long j, int i, IDramaDetailLoadFromCacheCallback iDramaDetailLoadFromCacheCallback) {
        Intrinsics.checkNotNullParameter(iDramaDetailLoadFromCacheCallback, TextureRenderKeys.KEY_IS_CALLBACK);
        this.dramaId = j;
        this.index = i;
        this.callback = iDramaDetailLoadFromCacheCallback;
        this.status = CacheStatus.TASK_NOT_COMPLETE;
    }

    public final IDramaDetailLoadFromCacheCallback getCallback() {
        return this.callback;
    }

    public final int getIndex() {
        return this.index;
    }

    /* compiled from: DramaNetCacheManager.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/bytedance/sdk/djx/core/business/budrama/detail/DramaDetailLoadFromCacheTask$start$1", "Lcom/bytedance/sdk/djx/utils/thread/TTRunnable;", "run", "", "sdk_core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* renamed from: com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailLoadFromCacheTask$start$1, reason: invalid class name */
    public static final class AnonymousClass1 extends TTRunnable {
        AnonymousClass1() {
        }

        public void run() {
            CacheStatus cacheStatus;
            DramaDetailLoadFromCacheTask.this.detail = DramaNetCacheManager.INSTANCE.loadFromCache(DramaDetailLoadFromCacheTask.this.dramaId, DramaDetailLoadFromCacheTask.this.getIndex());
            DramaDetailLoadFromCacheTask dramaDetailLoadFromCacheTask = DramaDetailLoadFromCacheTask.this;
            if (dramaDetailLoadFromCacheTask.detail == null) {
                if (DramaNetCacheManager.INSTANCE.inHistory(DramaDetailLoadFromCacheTask.this.dramaId, DramaDetailLoadFromCacheTask.this.getIndex())) {
                    cacheStatus = CacheStatus.FAIL_CACHE_REMOVED;
                } else {
                    cacheStatus = CacheStatus.FAIL_NO_CACHE_IN_HISTORY;
                }
            } else {
                cacheStatus = CacheStatus.SUCCESS;
            }
            dramaDetailLoadFromCacheTask.status = cacheStatus;
            if (DramaDetailLoadFromCacheTask.this.canceled) {
                return;
            }
            Handler handler = new Handler(Looper.getMainLooper());
            final DramaDetailLoadFromCacheTask dramaDetailLoadFromCacheTask2 = DramaDetailLoadFromCacheTask.this;
            handler.post(new Runnable() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailLoadFromCacheTask$start$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DramaDetailLoadFromCacheTask.AnonymousClass1.m355run$lambda0(dramaDetailLoadFromCacheTask2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: run$lambda-0, reason: not valid java name */
        public static final void m355run$lambda0(DramaDetailLoadFromCacheTask dramaDetailLoadFromCacheTask) {
            Intrinsics.checkNotNullParameter(dramaDetailLoadFromCacheTask, "this$0");
            dramaDetailLoadFromCacheTask.getCallback().onLoadComplete(dramaDetailLoadFromCacheTask.detail);
        }
    }

    public final void start() {
        TTExecutor.get().executeDefaultTask(new AnonymousClass1());
    }

    public final CacheStatus getStatus() {
        return this.status;
    }

    public final void cancel() {
        this.canceled = true;
    }
}
