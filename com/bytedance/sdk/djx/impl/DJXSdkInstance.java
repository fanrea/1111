package com.bytedance.sdk.djx.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.sdk.djx.DJXSdkConfig;
import com.bytedance.sdk.djx.IBaseStartListener;
import com.bytedance.sdk.djx.IDJXCave;
import com.bytedance.sdk.djx.IDJXService;
import com.bytedance.sdk.djx.IDJXUpdate;
import com.bytedance.sdk.djx.IDJXWidgetFactory;
import com.bytedance.sdk.djx.StartError;
import com.bytedance.sdk.djx.empty.EmptyDJXSdk;
import com.bytedance.sdk.djx.impl.DJXSdkStartHelper;
import com.bytedance.sdk.djx.internal.IDJXSdkInternal;
import com.bytedance.sdk.djx.internal.utils.AdSdkVersionCheckUtil;
import com.bytedance.sdk.djx.internal.utils.DJXLogger;
import com.bytedance.sdk.djx.log.DJXApiLazyReporter;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.utils.AdSdkUtils;
import com.bytedance.sdk.djx.utils.AssertHelper;
import com.bytedance.sdk.djx.utils.HostContext;
import com.nativekv.NativeKV;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXSdkInstance {
    public static final String TAG = "DJXSdkInstance";
    private static final AtomicBoolean sInited = new AtomicBoolean(false);
    private static final AtomicBoolean sIsStarting = new AtomicBoolean(false);
    private static final AtomicBoolean sStarted = new AtomicBoolean(false);
    private DJXSdkConfig mConfig;
    private String mConfigName;
    private Context mContext;
    public volatile IDJXSdkInternal mDJXSdkImpl;
    private final Handler mHandler;
    private final CopyOnWriteArrayList<IBaseStartListener> mStartListeners;

    private DJXSdkInstance() {
        this.mStartListeners = new CopyOnWriteArrayList<>();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mDJXSdkImpl = EmptyDJXSdk.getInstance();
    }

    public void init(Context context, String str, DJXSdkConfig dJXSdkConfig) {
        AssertHelper.throwNull(context, "context can not be null");
        AssertHelper.throwNull(str, "configName can not be null");
        AssertHelper.throwNull(dJXSdkConfig, "DJXSdkConfig can not be null");
        this.mContext = context;
        this.mConfigName = str;
        this.mConfig = dJXSdkConfig;
        DJXLogger.DEBUG = dJXSdkConfig.isDebug();
        HostContext.setContext(context);
        sInited.set(true);
    }

    public void start(IBaseStartListener iBaseStartListener) {
        DJXSdkStartHelper.sStartTime = SystemClock.elapsedRealtime();
        DJXApiLazyReporter.logEventSdkStartLaunchMonitor();
        DJXLogger.d(TAG, "start:");
        if (!sInited.get()) {
            sendSdkLaunchFailureLog("sdk未初始化，请先初始化sdk之后再启动sdk");
            if (iBaseStartListener != null) {
                iBaseStartListener.onStartComplete(false, "sdk未初始化，请先初始化sdk之后再启动sdk", DJXError.build(StartError.code("sdk未初始化，请先初始化sdk之后再启动sdk"), "sdk未初始化，请先初始化sdk之后再启动sdk"));
            }
            DJXLogger.e(TAG, "sdk未初始化，请先初始化sdk之后再启动sdk");
            return;
        }
        if (!AdSdkUtils.isInitSuccess()) {
            sendSdkLaunchFailureLog("广告sdk未初始化成功，请在广告sdk初始化成功后再初始化内容sdk");
            if (iBaseStartListener != null) {
                iBaseStartListener.onStartComplete(false, "广告sdk未初始化成功，请在广告sdk初始化成功后再初始化内容sdk", DJXError.build(StartError.code("广告sdk未初始化成功，请在广告sdk初始化成功后再初始化内容sdk"), "广告sdk未初始化成功，请在广告sdk初始化成功后再初始化内容sdk"));
            }
            DJXLogger.e(TAG, "广告sdk未初始化成功，请在广告sdk初始化成功后再初始化内容sdk");
            return;
        }
        if (!AdSdkVersionCheckUtil.checkOpenAdSdkVersion()) {
            sendSdkLaunchFailureLog("广告sdk版本不符合要求，推荐版本为：");
            if (iBaseStartListener != null) {
                iBaseStartListener.onStartComplete(false, "广告sdk版本不符合要求，推荐版本为：" + AdSdkVersionCheckUtil.MIN_OPEN_SDK_VERSION, DJXError.build(StartError.code("广告sdk版本不符合要求，推荐版本为："), "广告sdk版本不符合要求，推荐版本为："));
            }
            DJXLogger.e(TAG, "广告sdk版本不符合要求，推荐版本为：");
            return;
        }
        if (iBaseStartListener != null) {
            this.mStartListeners.add(iBaseStartListener);
        }
        if (!sIsStarting.compareAndSet(false, true)) {
            DJXLogger.d(TAG, "DJXSdk is starting, wait for the result of starting");
            return;
        }
        if (isStartSuccess()) {
            if (iBaseStartListener != null) {
                this.mStartListeners.remove(iBaseStartListener);
                iBaseStartListener.onStartComplete(true, "sdk启动成功", null);
            }
            DJXLogger.d(TAG, "DJXSdk has been started");
            return;
        }
        initComponent();
        DJXSdkStartHelper.getInstance().prepare(this.mContext, this.mConfigName, new DJXSdkStartHelper.DJXSdkPrepareListener() { // from class: com.bytedance.sdk.djx.impl.DJXSdkInstance.1
            @Override // com.bytedance.sdk.djx.impl.DJXSdkStartHelper.DJXSdkPrepareListener
            public void onPrepared(IDJXSdkInternal iDJXSdkInternal) {
                if (iDJXSdkInternal == null) {
                    DJXSdkInstance.this.sendSdkLaunchFailureLog("类加载失败");
                    DJXSdkInstance.this.onDJXSdkStartResult(false, "类加载失败", DJXError.build(StartError.code("类加载失败"), "类加载失败"));
                    DJXLogger.d(DJXSdkInstance.TAG, "DJXSdk impl is empty ");
                } else {
                    DJXSdkInstance.this.mDJXSdkImpl = iDJXSdkInternal;
                    DJXSdkInstance.this.mDJXSdkImpl.initialize(DJXSdkInstance.this.mContext, DJXSdkInstance.this.mConfigName, DJXSdkInstance.this.mConfig, new IBaseStartListener() { // from class: com.bytedance.sdk.djx.impl.DJXSdkInstance.1.1
                        @Override // com.bytedance.sdk.djx.IBaseStartListener
                        public void onStartComplete(boolean z, String str, DJXError dJXError) {
                            DJXSdkInstance.this.onDJXSdkStartResult(z, str, dJXError);
                        }
                    });
                }
            }
        });
        DJXApiLazyReporter.logEventSdkSynLaunchMonitor(SystemClock.elapsedRealtime() - DJXSdkStartHelper.sStartTime);
    }

    public void reStartFallback() {
        DJXLogger.d(TAG, "reStart: ");
        DJXSdkStartHelper.getInstance().rePrepare(new DJXSdkStartHelper.DJXSdkPrepareListener() { // from class: com.bytedance.sdk.djx.impl.DJXSdkInstance.2
            @Override // com.bytedance.sdk.djx.impl.DJXSdkStartHelper.DJXSdkPrepareListener
            public void onPrepared(IDJXSdkInternal iDJXSdkInternal) {
                DJXSdkInstance.this.mDJXSdkImpl = iDJXSdkInternal;
                if (!(iDJXSdkInternal instanceof EmptyDJXSdk)) {
                    DJXSdkInstance.this.mDJXSdkImpl.initialize(DJXSdkInstance.this.mContext, DJXSdkInstance.this.mConfigName, DJXSdkInstance.this.mConfig, new IBaseStartListener() { // from class: com.bytedance.sdk.djx.impl.DJXSdkInstance.2.1
                        @Override // com.bytedance.sdk.djx.IBaseStartListener
                        public void onStartComplete(boolean z, String str, DJXError dJXError) {
                            DJXSdkInstance.this.onDJXSdkStartResult(z, str, dJXError);
                        }
                    });
                } else {
                    DJXLogger.d(DJXSdkInstance.TAG, "DJXSdk impl is empty ");
                    DJXSdkInstance.this.onDJXSdkStartResult(false, "类加载失败", DJXError.build(StartError.code("类加载失败"), "类加载失败"));
                }
            }
        });
    }

    private void initComponent() {
        NativeKV.initialize(this.mContext);
    }

    public void onDJXSdkStartResult(boolean z, String str, DJXError dJXError) {
        sStarted.set(z);
        sIsStarting.set(false);
        DJXLogger.i(TAG, "start result = " + z + ", msg = " + str);
        if (dJXError != null) {
            DJXLogger.i(TAG, "start result = " + z + ", error = " + dJXError);
        }
        Iterator<IBaseStartListener> it = this.mStartListeners.iterator();
        while (it.hasNext()) {
            IBaseStartListener next = it.next();
            if (next != null) {
                next.onStartComplete(z, str, dJXError);
            }
        }
        this.mStartListeners.clear();
    }

    public boolean isStartSuccess() {
        return sStarted.get();
    }

    public IDJXWidgetFactory factory() {
        if (isStartSuccess()) {
            return this.mDJXSdkImpl.factory();
        }
        return null;
    }

    public IDJXService service() {
        if (isStartSuccess()) {
            return this.mDJXSdkImpl.service();
        }
        return null;
    }

    public IDJXCave cave() {
        if (isStartSuccess()) {
            return this.mDJXSdkImpl.cave();
        }
        return null;
    }

    public IDJXUpdate update() {
        if (isStartSuccess()) {
            return this.mDJXSdkImpl.update();
        }
        return null;
    }

    public static DJXSdkInstance getInstance() {
        return InnerHolder.instance;
    }

    private static class InnerHolder {
        private static final DJXSdkInstance instance = new DJXSdkInstance();

        private InnerHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSdkLaunchFailureLog(String str) {
        DJXApiLazyReporter.logEventSdkLaunchMonitor(false, DJXSdkStartHelper.sStartTime > 0 ? SystemClock.elapsedRealtime() - DJXSdkStartHelper.sStartTime : -1L, Integer.valueOf(StartError.code(str)), str);
    }
}
