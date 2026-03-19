package com.bytedance.sdk.djx.core;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.sdk.djx.DJXSdkConfig;
import com.bytedance.sdk.djx.IBaseStartListener;
import com.bytedance.sdk.djx.IDJXCave;
import com.bytedance.sdk.djx.IDJXService;
import com.bytedance.sdk.djx.IDJXUpdate;
import com.bytedance.sdk.djx.IDJXWidgetFactory;
import com.bytedance.sdk.djx.core.init.InitTaskPool;
import com.bytedance.sdk.djx.core.log.BLogAgent;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.impl.DJXSdkStartHelper;
import com.bytedance.sdk.djx.internal.IDJXSdkInternal;
import com.bytedance.sdk.djx.internal.utils.DJXLogger;
import com.bytedance.sdk.djx.settings.DJXGlobalSettings;
import com.bytedance.sdk.djx.utils.LG;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class DJXSdkImpl implements IDJXSdkInternal {
    private static final String NAME_START_TASK = "StartTask";
    private static final String TAG = "DJXSdkImpl";

    DJXSdkImpl() {
    }

    @Override // com.bytedance.sdk.djx.internal.IDJXSdkInternal
    public void initialize(Context context, String str, DJXSdkConfig dJXSdkConfig, IBaseStartListener iBaseStartListener) {
        LG.d(TAG, "DJXSdkImpl start");
        sendStartTaskLog();
        InitTaskPool.getInstance().initialize(context, str, dJXSdkConfig, iBaseStartListener);
    }

    @Override // com.bytedance.sdk.djx.internal.IDJXSdkInternal
    public IDJXWidgetFactory factory() {
        return djxImpl().factory();
    }

    @Override // com.bytedance.sdk.djx.internal.IDJXSdkInternal
    public IDJXService service() {
        return djxImpl().service();
    }

    @Override // com.bytedance.sdk.djx.internal.IDJXSdkInternal
    public IDJXCave cave() {
        return djxImpl().cave();
    }

    @Override // com.bytedance.sdk.djx.internal.IDJXSdkInternal
    public IDJXUpdate update() {
        return djxImpl().update();
    }

    private IDJXSdkInternal djxImpl() {
        try {
            return (IDJXSdkInternal) DJXSdkStartHelper.getInstance().getDJXSdkClassLoader().loadClass("com.bytedance.sdk.djx.core.DJXSdkImpl2").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            DJXLogger.d(TAG, "DJXSdkImpl class load failed");
            e.printStackTrace();
            return null;
        }
    }

    @Deprecated
    protected void sendStartTaskLog() {
        long jElapsedRealtime = DJXSdkStartHelper.sStartTime > 0 ? SystemClock.elapsedRealtime() - DJXSdkStartHelper.sStartTime : -1L;
        LG.d(TAG, "StartTask cost = " + jElapsedRealtime);
        BLogAgent.build("hotsoon_video_detail_draw", ILogConst.E_INIT_TASK_EVENT, null).putString(ILogConst.Keys.KEY_TASK_NAME, NAME_START_TASK).putLong("cost", jElapsedRealtime).putInt(ILogConst.Keys.KEY_IS_ASYNC, 0).putInt("is_activate", !DJXGlobalSettings.getInstance().getHasInitSuccess() ? 1 : 0).send();
    }

    public static DJXSdkImpl getInstance() {
        return InnerHolder.instance;
    }

    private static class InnerHolder {
        private static final DJXSdkImpl instance = new DJXSdkImpl();

        private InnerHolder() {
        }
    }
}
