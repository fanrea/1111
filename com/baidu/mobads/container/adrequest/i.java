package com.baidu.mobads.container.adrequest;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public interface i {
    void addEventListener(String str, IOAdEventListener iOAdEventListener);

    void dispatchEvent(IOAdEvent iOAdEvent);

    boolean hasEventListener(String str);

    void removeAllListeners();

    void removeEventListener(String str, IOAdEventListener iOAdEventListener);

    void removeEventListeners(String str);
}
