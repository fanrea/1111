package com.baidu.mobads.sdk.internal.a;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface a extends IOAdEvent {
    IAdInterListener getDelegator();

    Object handleEvent(String str, String str2, Object[] objArr);
}
