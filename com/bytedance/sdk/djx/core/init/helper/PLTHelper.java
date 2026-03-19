package com.bytedance.sdk.djx.core.init.helper;

import com.bytedance.sdk.djx.impl.DJXSdkStartHelper;
import com.bytedance.sdk.djx.internal.IPLTInternal;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class PLTHelper {
    public void initHistory() {
        if (pltImpl() != null) {
            pltImpl().initDramaHistory();
        }
    }

    public void initVod() {
        if (pltImpl() != null) {
            pltImpl().initVod();
        }
    }

    public void syncHuoShan() {
        if (pltImpl() != null) {
            pltImpl().syncHuoShanHistory();
        }
    }

    public void refreshPreload2() {
        if (pltImpl() != null) {
            pltImpl().refreshPreload2();
        }
    }

    public void preload() {
        if (pltImpl() != null) {
            pltImpl().preload();
        }
    }

    public String getVodVersion() {
        return pltImpl() != null ? pltImpl().getVodVersion() : "0.0.0.0";
    }

    private IPLTInternal pltImpl() {
        try {
            return (IPLTInternal) DJXSdkStartHelper.getInstance().getDJXSdkClassLoader().loadClass("com.bytedance.sdk.djx.core.DJXPLTImpl").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static PLTHelper getInstance() {
        return InnerHolder.instance;
    }

    private static class InnerHolder {
        private static final PLTHelper instance = new PLTHelper();

        private InnerHolder() {
        }
    }
}
