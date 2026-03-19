package io.netty.util.internal;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface PriorityQueueNode<T> extends Comparable<T> {
    public static final int INDEX_NOT_IN_QUEUE = -1;

    int priorityQueueIndex();

    void priorityQueueIndex(int i);
}
