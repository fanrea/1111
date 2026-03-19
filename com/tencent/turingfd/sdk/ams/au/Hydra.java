package com.tencent.turingfd.sdk.ams.au;

import java.util.LinkedList;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Hydra<E> {
    public final int a;
    public final LinkedList<E> b = new LinkedList<>();

    public Hydra(int i) {
        this.a = i;
    }

    public void a(E e) {
        if (this.b.size() >= this.a) {
            this.b.poll();
        }
        this.b.offer(e);
    }
}
