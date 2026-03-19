package com.bytedance.sdk.djx.core.business.ad;

import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.sdk.djx.core.log.BLogAgent;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.core.settings.SettingData;
import com.bytedance.sdk.djx.model.ev.BEAdSdkInit;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.WeakHandler;
import com.bytedance.sdk.djx.utils.bus.DJXBus;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class AdSdkInitManager implements WeakHandler.IHandler {
    private static final int MSG_POLL_INIT_COMPLETE = 2;
    private static final int MSG_POLL_INIT_STATE = 1;
    private static final long POLL_INTERVAL = 50;
    private static final long POLL_MAX_DELAY = 500;
    private static final String TAG = "AdSdkInitManager";
    private static AdSdkInitManager sInstance;
    private long mStartTime = -1;
    private boolean mHasReport = false;
    private boolean isPollComplete = false;
    private boolean mNeedDelay4NoMix = true;
    private final WeakHandler mHandler = new WeakHandler(Looper.getMainLooper(), this);

    public static AdSdkInitManager inst() {
        if (sInstance == null) {
            synchronized (AdSdkInitManager.class) {
                if (sInstance == null) {
                    sInstance = new AdSdkInitManager();
                }
            }
        }
        return sInstance;
    }

    private AdSdkInitManager() {
    }

    public void startPolling() {
        if (AdSdkUtils.isAdSdkExist()) {
            if (!AdSdkUtils.isInitSuccess()) {
                LG.d(TAG, "startPolling: ");
                this.mHandler.sendEmptyMessage(1);
                this.mHandler.sendEmptyMessageDelayed(2, POLL_MAX_DELAY);
                return;
            }
            LG.d(TAG, "startPolling: no need");
        }
    }

    public void handleMsg(Message message) {
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            this.isPollComplete = true;
            LG.d(TAG, "handleMsg: init failed");
            DJXBus.getInstance().sendEvent(new BEAdSdkInit());
            return;
        }
        if (AdSdkUtils.isInitSuccess()) {
            this.mHandler.removeMessages(2);
            this.isPollComplete = true;
            DJXBus.getInstance().sendEvent(new BEAdSdkInit());
            LG.d(TAG, "handleMsg: init success");
            return;
        }
        this.mHandler.sendEmptyMessageDelayed(1, POLL_INTERVAL);
        LG.d(TAG, "handleMsg: start next poll ");
    }

    public boolean needWaitSdkInit() {
        return SettingData.getInstance().isMixAdLogic() && !this.isPollComplete && AdSdkUtils.isAdSdkExist() && !AdSdkUtils.isInitSuccess();
    }

    public void setStartTime(long j) {
        if (this.mHasReport) {
            return;
        }
        this.mStartTime = j;
    }

    public void reportInitDelayDuration() {
        if (AdSdkUtils.isAdSdkExist() && !this.mHasReport) {
            long jElapsedRealtime = this.mStartTime > 0 ? SystemClock.elapsedRealtime() - this.mStartTime : 0L;
            BLogAgent.build("", ILogConst.E_AD_INIT_DELAY_DURATION, null).putInt("is_success", AdSdkUtils.isInitSuccess() ? 1 : 0).putLong("duration", jElapsedRealtime).putInt("is_plugin", AdSdkUtils.isPluginSdk() ? 1 : 0).putString("ad_sdk_version", AdSdkUtils.getVersion()).putInt("is_oppo", AdSdkUtils.isOppo() ? 1 : 0).send();
            LG.d(TAG, "reportInitDelayDuration: duration = " + jElapsedRealtime);
            this.mHasReport = true;
        }
    }

    public long getDelay4NoMix() {
        if (!this.mNeedDelay4NoMix) {
            return 0L;
        }
        this.mNeedDelay4NoMix = false;
        return POLL_MAX_DELAY;
    }
}
