package com.fendasz.moku.planet.entity;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface ApiDataCallBack<T> {
    void error(int i, String str) throws Exception;

    void success(int i, T t) throws Exception;
}
