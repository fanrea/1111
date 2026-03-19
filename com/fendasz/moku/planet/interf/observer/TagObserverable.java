package com.fendasz.moku.planet.interf.observer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface TagObserverable {
    void notifyObserver();

    void registerObserver(TagObserver tagObserver);

    void removeObserver(TagObserver tagObserver);
}
