package com.bytedance.sdk.djx.core;

import com.bytedance.sdk.djx.core.business.budrama.DramaManager;
import com.bytedance.sdk.djx.core.business.budrama.draw.DrawPreload;
import com.bytedance.sdk.djx.core.business.budrama.draw.DrawPreload2;
import com.bytedance.sdk.djx.core.util.SyncHistoryHelper;
import com.bytedance.sdk.djx.core.vod.DefaultVideoService;
import com.bytedance.sdk.djx.core.vod.IVideoService;
import com.bytedance.sdk.djx.internal.IPLTInternal;
import com.bytedance.sdk.djx.proguard.a.d;
import com.bytedance.sdk.djx.utils.AdSdkUtils;
import com.bytedance.sdk.djx.utils.service.ServiceManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXPLTImpl implements IPLTInternal {
    private static final String TTPLAYER_CLASS = "com.ss.ttvideoengine.TTVideoEngine";

    @Override // com.bytedance.sdk.djx.internal.IPLTInternal
    public void initDramaHistory() {
        DramaManager.getInstance();
    }

    @Override // com.bytedance.sdk.djx.internal.IPLTInternal
    public void initVod() {
        registerVideoServiceFirst();
        ((IVideoService) ServiceManager.getInstance().getService(IVideoService.class)).init();
    }

    @Override // com.bytedance.sdk.djx.internal.IPLTInternal
    public void syncHuoShanHistory() {
        registerVideoServiceFirst();
        SyncHistoryHelper.init();
    }

    @Override // com.bytedance.sdk.djx.internal.IPLTInternal
    public void refreshPreload2() {
        registerVideoServiceFirst();
        DrawPreload2.getInstance().refresh();
    }

    @Override // com.bytedance.sdk.djx.internal.IPLTInternal
    public void preload() {
        registerVideoServiceFirst();
        DrawPreload.getInstance().preload();
    }

    @Override // com.bytedance.sdk.djx.internal.IPLTInternal
    public String getVodVersion() {
        registerVideoServiceFirst();
        return ((IVideoService) ServiceManager.getInstance().getService(IVideoService.class)).getVersion();
    }

    public static DJXPLTImpl getInstance() {
        return InnerHolder.instance;
    }

    private void registerVideoServiceFirst() {
        if (ServiceManager.getInstance().getService(IVideoService.class) == null) {
            ServiceManager.getInstance().registerDefaultService(IVideoService.class, new DefaultVideoService());
            if (!AdSdkUtils.isExist(TTPLAYER_CLASS) || DevInfo.sDisableTTPlayer) {
                return;
            }
            ServiceManager.getInstance().registerService(IVideoService.class, new d());
        }
    }

    private static class InnerHolder {
        private static final DJXPLTImpl instance = new DJXPLTImpl();

        private InnerHolder() {
        }
    }
}
