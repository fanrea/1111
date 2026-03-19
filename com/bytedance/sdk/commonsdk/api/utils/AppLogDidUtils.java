package com.bytedance.sdk.commonsdk.api.utils;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.IAppLogInstance;
import com.bytedance.applog.IDataObserver;
import com.bytedance.sdk.commonsdk.api.utils.WeakHandler;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class AppLogDidUtils implements WeakHandler.IHandler {
    private static final long LOOP_DID_GAP = 500;
    private static final int MAX_GAP = 20000;
    private static final String TAG = "AppLogDidUtils";
    private static final int WHAT_MSG_LOOP = 61;
    private static volatile HashMap<String, AppLogDidUtils> sInstanceMap = new HashMap<>();
    private IAppLogInstance mAppLogInstance;
    private final CopyOnWriteArrayList<Callback> mCallbackList = new CopyOnWriteArrayList<>();
    private final AtomicInteger mLoopCount = new AtomicInteger(0);
    private final WeakHandler mHandler = new WeakHandler(Looper.getMainLooper(), this);
    public boolean hasCallbackResult = false;
    private final IDataObserver mDataObserver = new IDataObserver() { // from class: com.bytedance.sdk.commonsdk.api.utils.AppLogDidUtils.1
        @Override // com.bytedance.applog.IDataObserver
        public void onIdLoaded(String str, String str2, String str3) {
            LGBase.d(AppLogDidUtils.TAG, String.format("onIdLoaded, s = %s, s1 = %s, s2 = %s", str, str2, str3));
            if (TextUtils.isEmpty(AppLogDidUtils.this.getDid())) {
                return;
            }
            AppLogDidUtils.this.onDidLoaded();
        }

        @Override // com.bytedance.applog.IDataObserver
        public void onRemoteIdGet(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
            LGBase.d(AppLogDidUtils.TAG, "onRemoteIdGet");
            if (TextUtils.isEmpty(AppLogDidUtils.this.getDid())) {
                return;
            }
            AppLogDidUtils.this.onDidLoaded();
        }

        @Override // com.bytedance.applog.IDataObserver
        public void onRemoteConfigGet(boolean z, JSONObject jSONObject) {
            LGBase.d(AppLogDidUtils.TAG, "onRemoteConfigGet");
        }

        @Override // com.bytedance.applog.IDataObserver
        public void onRemoteAbConfigGet(boolean z, JSONObject jSONObject) {
            LGBase.d(AppLogDidUtils.TAG, "onRemoteAbConfigGet");
        }

        @Override // com.bytedance.applog.IDataObserver
        public void onAbVidsChange(String str, String str2) {
            LGBase.d(AppLogDidUtils.TAG, "onAbVidsChange");
        }
    };

    public interface Callback {
        void onDidResult(boolean z);
    }

    public static AppLogDidUtils getInstance(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("DevInfo.sAppId isEmpty, 请确保 initParamsTask 在 initApplog 之前执行");
        }
        if (!sInstanceMap.containsKey(str)) {
            synchronized (AppLogDidUtils.class) {
                if (!sInstanceMap.containsKey(str)) {
                    sInstanceMap.put(str, new AppLogDidUtils());
                }
            }
        }
        return sInstanceMap.get(str);
    }

    private AppLogDidUtils() {
    }

    public void setDidListener(IAppLogInstance iAppLogInstance, Callback callback) {
        this.mAppLogInstance = iAppLogInstance;
        this.mCallbackList.add(callback);
        this.mHandler.removeCallbacksAndMessages(null);
        this.mLoopCount.set(0);
        String did = getDid();
        if (TextUtils.isEmpty(did)) {
            this.mHandler.sendEmptyMessageDelayed(61, LOOP_DID_GAP);
            IAppLogInstance iAppLogInstance2 = this.mAppLogInstance;
            if (iAppLogInstance2 != null) {
                iAppLogInstance2.addDataObserver(this.mDataObserver);
                return;
            }
            return;
        }
        onDidLoaded();
        LGBase.d(TAG, "get did = " + did);
    }

    public void addDidListener(Callback callback) {
        if (callback == null || this.mCallbackList.contains(callback)) {
            return;
        }
        if (this.hasCallbackResult) {
            callback.onDidResult(!TextUtils.isEmpty(getDid()));
        } else {
            this.mCallbackList.add(callback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDid() {
        IAppLogInstance iAppLogInstance = this.mAppLogInstance;
        return iAppLogInstance != null ? iAppLogInstance.getDid() : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDidLoaded() {
        String did = getDid();
        LGBase.d(TAG, "onDidLoaded");
        LGBase.d(TAG, "instance get did = " + did);
        LGBase.d(TAG, "applog get did = " + AppLog.getDid());
        this.hasCallbackResult = true;
        this.mHandler.removeCallbacksAndMessages(null);
        handleCallback(did);
        IAppLogInstance iAppLogInstance = this.mAppLogInstance;
        if (iAppLogInstance != null) {
            iAppLogInstance.removeDataObserver(this.mDataObserver);
        }
    }

    private void handleCallback(String str) {
        if (this.mCallbackList.isEmpty()) {
            return;
        }
        Iterator<Callback> it = this.mCallbackList.iterator();
        while (it.hasNext()) {
            Callback next = it.next();
            if (next != null) {
                next.onDidResult(!TextUtils.isEmpty(str));
            }
        }
        this.mCallbackList.clear();
    }

    @Override // com.bytedance.sdk.commonsdk.api.utils.WeakHandler.IHandler
    public void handleMsg(Message message) {
        if (message.what == 61) {
            int andIncrement = this.mLoopCount.getAndIncrement();
            if (andIncrement * LOOP_DID_GAP > 20000) {
                onDidLoaded();
                LGBase.d(TAG, "Get did timeout: ");
            } else if (TextUtils.isEmpty(getDid())) {
                this.mHandler.sendEmptyMessageDelayed(61, LOOP_DID_GAP);
                LGBase.d(TAG, "Get did loop: " + andIncrement);
            } else {
                onDidLoaded();
            }
        }
    }
}
