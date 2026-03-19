package com.bytedance.android.openliveplugin.process;

import android.content.Context;
import com.bytedance.android.live.base.api.ILiveHostContextParam;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface ILiveInit {
    void initLiveInMain(ILiveHostContextParam iLiveHostContextParam, String str, Boolean bool);

    void initLiveProcess(Context context);

    void registerSubProcessStub();
}
