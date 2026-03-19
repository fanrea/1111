package io.netty.util.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
abstract class MpscLinkedQueueTailRef<E> extends MpscLinkedQueuePad1<E> {
    private static final AtomicReferenceFieldUpdater<MpscLinkedQueueTailRef, MpscLinkedQueueNode> UPDATER;
    private static final long serialVersionUID = 8717072462993327429L;
    private volatile transient MpscLinkedQueueNode<E> tailRef;

    MpscLinkedQueueTailRef() {
    }

    static {
        AtomicReferenceFieldUpdater<MpscLinkedQueueTailRef, MpscLinkedQueueNode> atomicReferenceFieldUpdaterNewAtomicReferenceFieldUpdater = PlatformDependent.newAtomicReferenceFieldUpdater(MpscLinkedQueueTailRef.class, "tailRef");
        if (atomicReferenceFieldUpdaterNewAtomicReferenceFieldUpdater == null) {
            atomicReferenceFieldUpdaterNewAtomicReferenceFieldUpdater = AtomicReferenceFieldUpdater.newUpdater(MpscLinkedQueueTailRef.class, MpscLinkedQueueNode.class, "tailRef");
        }
        UPDATER = atomicReferenceFieldUpdaterNewAtomicReferenceFieldUpdater;
    }

    protected final MpscLinkedQueueNode<E> tailRef() {
        return this.tailRef;
    }

    protected final void setTailRef(MpscLinkedQueueNode<E> mpscLinkedQueueNode) {
        this.tailRef = mpscLinkedQueueNode;
    }

    protected final MpscLinkedQueueNode<E> getAndSetTailRef(MpscLinkedQueueNode<E> mpscLinkedQueueNode) {
        return UPDATER.getAndSet(this, mpscLinkedQueueNode);
    }
}
