package io.netty.util.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class MpscLinkedQueueNode<T> {
    private static final AtomicReferenceFieldUpdater<MpscLinkedQueueNode, MpscLinkedQueueNode> nextUpdater;
    private volatile MpscLinkedQueueNode<T> next;

    public abstract T value();

    static {
        AtomicReferenceFieldUpdater<MpscLinkedQueueNode, MpscLinkedQueueNode> atomicReferenceFieldUpdaterNewAtomicReferenceFieldUpdater = PlatformDependent.newAtomicReferenceFieldUpdater(MpscLinkedQueueNode.class, "next");
        if (atomicReferenceFieldUpdaterNewAtomicReferenceFieldUpdater == null) {
            atomicReferenceFieldUpdaterNewAtomicReferenceFieldUpdater = AtomicReferenceFieldUpdater.newUpdater(MpscLinkedQueueNode.class, MpscLinkedQueueNode.class, "next");
        }
        nextUpdater = atomicReferenceFieldUpdaterNewAtomicReferenceFieldUpdater;
    }

    final MpscLinkedQueueNode<T> next() {
        return this.next;
    }

    final void setNext(MpscLinkedQueueNode<T> mpscLinkedQueueNode) {
        nextUpdater.lazySet(this, mpscLinkedQueueNode);
    }

    protected T clearMaybe() {
        return value();
    }

    void unlink() {
        setNext(null);
    }
}
