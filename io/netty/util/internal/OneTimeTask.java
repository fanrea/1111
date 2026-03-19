package io.netty.util.internal;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class OneTimeTask extends MpscLinkedQueueNode<Runnable> implements Runnable {
    @Override // io.netty.util.internal.MpscLinkedQueueNode
    public Runnable value() {
        return this;
    }
}
