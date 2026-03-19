package com.fendasz.moku.planet.entity;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface ApiOperationCallBack {
    void copyContent(OperationEnum operationEnum, String str);

    void downloadProgress(OperationEnum operationEnum, String str);

    void listenerTime(OperationEnum operationEnum, int i);

    void taskStatus(OperationEnum operationEnum);
}
