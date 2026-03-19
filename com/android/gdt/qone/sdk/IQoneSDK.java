package com.android.gdt.qone.sdk;

import android.content.Context;
import com.android.gdt.qone.log.IObservableLog;
import com.android.gdt.qone.sdk.debug.IDebugger;
import com.android.gdt.qone.strategy.terminal.ITerminalStrategy;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public interface IQoneSDK {
    IQoneSDK addUserId(String str, String str2);

    IDebugger getDebugger();

    Qone getQone();

    void getQone(IAsyncQoneListener iAsyncQoneListener);

    String getSdkVersion();

    ITerminalStrategy getStrategy();

    String getToken();

    boolean init(Context context);

    @Deprecated
    boolean init(Context context, IQoneNetworkAdapter iQoneNetworkAdapter);

    IQoneSDK setAppVersion(String str);

    IQoneSDK setChannelID(String str);

    IQoneSDK setLogAble(boolean z);

    IQoneSDK setLogObserver(IObservableLog iObservableLog);

    IQoneSDK setSdkName(String str);
}
