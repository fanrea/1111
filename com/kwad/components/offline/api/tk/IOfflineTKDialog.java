package com.kwad.components.offline.api.tk;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface IOfflineTKDialog {
    void callTKBridge(String str);

    void callbackDialogDismiss();

    void callbackPageStatus(boolean z, String str);

    int getDialogId();

    String getStyleTemplate();

    String getViewKey();

    boolean isHideNavigationBar();

    void registerJSCallHandler(IOfflineTKCallHandler iOfflineTKCallHandler);
}
