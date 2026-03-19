package com.bytedance.sdk.djx.core.business;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.djx.core.log.BLogAgent;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.core.settings.SettingData;
import com.bytedance.sdk.djx.core.util.VisibilityChecker;
import com.bytedance.sdk.djx.utils.WeakHandler;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ActiveLog implements WeakHandler.IHandler {
    public static final String API_COME = "outside";
    public static final int EVENT_SCANNING_INTERVAL = 1000;
    public static final String IMMERSION = "immersion";
    public static final String MODE_PLAYLET = "playlet";
    public static final int MSG_START_CHECKING = 1;
    public static final String SKIT_FEED = "skit_feed";
    public static final String SKIT_IMMERSION = "skit_immersion";
    public static final String SKIT_MIXED = "skit_mixed_feed";
    private static final String TAG = "ActiveLog";
    private String mCategory;
    private final Map<String, Object> mCommonParams;
    private String mContentStyle;
    private final View mContentView;
    private final Handler mCheckShowEventHandler = new WeakHandler(Looper.getMainLooper(), this);
    private final Map<String, Object> mParams = new HashMap();

    public ActiveLog(View view, String str, String str2, Map<String, Object> map) {
        this.mContentView = view;
        this.mCategory = str;
        this.mContentStyle = str2;
        this.mCommonParams = map;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void putParam(String str, Object obj) {
        this.mParams.put(str, obj);
    }

    public void setContentStyle(String str) {
        this.mContentStyle = str;
    }

    public void startCheckingShow() {
        this.mCheckShowEventHandler.sendEmptyMessage(1);
    }

    public void stopCheckingShow() {
        this.mCheckShowEventHandler.removeCallbacksAndMessages(null);
    }

    public void active() {
        if (TextUtils.isEmpty(this.mCategory) || TextUtils.isEmpty(this.mContentStyle)) {
            return;
        }
        BLogAgent bLogAgentPutString = BLogAgent.build(this.mCategory, ILogConst.E_OPEN_NEWS_APP_ACTIVATE, this.mCommonParams).putString("content_style", this.mContentStyle).putString("category", this.mCategory).putString(ILogConst.Keys.KEY_MODE, "playlet");
        for (Map.Entry<String, Object> entry : this.mParams.entrySet()) {
            Object value = entry.getValue();
            String key = entry.getKey();
            if (value instanceof String) {
                bLogAgentPutString.putString(key, (String) value);
            } else if (value instanceof Long) {
                bLogAgentPutString.putLong(key, ((Long) value).longValue());
            } else if (value instanceof Integer) {
                bLogAgentPutString.putInt(key, ((Integer) value).intValue());
            }
        }
        bLogAgentPutString.send();
    }

    public void handleMsg(Message message) {
        if (message.what == 1) {
            if (VisibilityChecker.isShow(this.mContentView, SettingData.getInstance().getDrawExposureValidPercent())) {
                stopCheckingShow();
                active();
            } else {
                this.mCheckShowEventHandler.sendEmptyMessageDelayed(1, 1000L);
            }
        }
    }
}
