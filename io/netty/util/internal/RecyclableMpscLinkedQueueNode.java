package io.netty.util.internal;

import io.netty.util.Recycler;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class RecyclableMpscLinkedQueueNode<T> extends MpscLinkedQueueNode<T> {
    private final Recycler.Handle handle;

    protected RecyclableMpscLinkedQueueNode(Recycler.Handle<? extends RecyclableMpscLinkedQueueNode<T>> handle) {
        if (handle == null) {
            throw new NullPointerException("handle");
        }
        this.handle = handle;
    }

    @Override // io.netty.util.internal.MpscLinkedQueueNode
    final void unlink() {
        super.unlink();
        this.handle.recycle(this);
    }
}
