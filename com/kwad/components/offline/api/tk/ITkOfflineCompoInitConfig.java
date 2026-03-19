package com.kwad.components.offline.api.tk;

import android.content.Context;
import com.kwad.components.offline.api.IOfflineCompoInitConfig;
import com.kwad.components.offline.api.core.soloader.ISoLoader;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface ITkOfflineCompoInitConfig extends IOfflineCompoInitConfig {
    String getSpKeyTkSoLoadTimes();

    String getSpNameSoLoadTimes();

    String getTkJsFileDir(Context context, String str);

    String getTkJsRootDir(Context context);

    String getTkVersion();

    boolean isLocalDebugEnable();

    ISoLoader soLoader();

    boolean useTkLite();

    boolean useTkSoAll();
}
