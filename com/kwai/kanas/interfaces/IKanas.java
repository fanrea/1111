package com.kwai.kanas.interfaces;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface IKanas {
    void addCustomProtoEvent(CustomProtoEvent customProtoEvent);

    void addCustomStatEvent(CustomStatEvent customStatEvent);

    KanasConfig getConfig();

    void setSessionIdAutoUpdate(boolean z);

    void startWithConfig(KanasConfig kanasConfig);
}
