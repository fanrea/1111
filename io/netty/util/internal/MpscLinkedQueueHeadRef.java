package io.netty.util.internal;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
abstract class MpscLinkedQueueHeadRef<E> extends MpscLinkedQueuePad0<E> implements Serializable {
    private static final AtomicReferenceFieldUpdater<MpscLinkedQueueHeadRef, MpscLinkedQueueNode> UPDATER;
    private static final long serialVersionUID = 8467054865577874285L;
    private volatile transient MpscLinkedQueueNode<E> headRef;

    MpscLinkedQueueHeadRef() {
    }

    static {
        AtomicReferenceFieldUpdater<MpscLinkedQueueHeadRef, MpscLinkedQueueNode> atomicReferenceFieldUpdaterNewAtomicReferenceFieldUpdater = PlatformDependent.newAtomicReferenceFieldUpdater(MpscLinkedQueueHeadRef.class, "headRef");
        if (atomicReferenceFieldUpdaterNewAtomicReferenceFieldUpdater == null) {
            atomicReferenceFieldUpdaterNewAtomicReferenceFieldUpdater = AtomicReferenceFieldUpdater.newUpdater(MpscLinkedQueueHeadRef.class, MpscLinkedQueueNode.class, "headRef");
        }
        UPDATER = atomicReferenceFieldUpdaterNewAtomicReferenceFieldUpdater;
    }

    protected final MpscLinkedQueueNode<E> headRef() {
        return this.headRef;
    }

    protected final void setHeadRef(MpscLinkedQueueNode<E> mpscLinkedQueueNode) {
        this.headRef = mpscLinkedQueueNode;
    }

    protected final void lazySetHeadRef(MpscLinkedQueueNode<E> mpscLinkedQueueNode) {
        UPDATER.lazySet(this, mpscLinkedQueueNode);
    }
}
