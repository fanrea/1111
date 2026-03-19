package com.bytedance.sdk.djx.core.business;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.djx.DJXDramaLog;
import com.bytedance.sdk.djx.core.log.BLogAgent;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.model.DJXDrama;
import com.bytedance.sdk.djx.utils.LG;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class CooperationLog {
    private static final String TAG = "CooperationLog";
    private static volatile CooperationLog sInstance;
    long categoryStartTime = -1;
    boolean hasEnterCategory = false;

    private CooperationLog() {
    }

    public static CooperationLog getInstance() {
        if (sInstance == null) {
            synchronized (CooperationLog.class) {
                if (sInstance == null) {
                    sInstance = new CooperationLog();
                }
            }
        }
        return sInstance;
    }

    public void uploadLog(String str, String str2, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        BLogAgent.build(str, str2, null).putAll(jSONObject).send();
    }

    public void uploadDramaLog(String str, DJXDramaLog dJXDramaLog) {
        if (TextUtils.isEmpty(str) || dJXDramaLog == null) {
            return;
        }
        DJXDrama drama = dJXDramaLog.getDrama();
        int i = AnonymousClass1.$SwitchMap$com$bytedance$sdk$djx$DJXDramaLog$DramaEvent[dJXDramaLog.getEvent().ordinal()];
        BLogAgent bLogAgentPutString = null;
        if (i == 1) {
            bLogAgentPutString = BLogAgent.build(str, ILogConst.E_OPEN_NEWS_APP_ACTIVATE, null).putString("content_style", ActiveLog.SKIT_FEED).putString("category", str).putString(ILogConst.Keys.KEY_MODE, "playlet").putString(ILogConst.Keys.INTERFACE_TYPE, "api");
        } else if (i != 2) {
            if (i == 3) {
                bLogAgentPutString = BLogAgent.build(str, "enter_category", null).putString(ILogConst.Keys.KEY_CATEGORY_NAME, str).putString("sdk_version", "2.9.0.2").putString(ILogConst.Keys.KEY_ENTER_FROM, ILogConst.FROM_CATEGORY).putString(ILogConst.Keys.KEY_MODE, "playlet").putString(ILogConst.Keys.INTERFACE_TYPE, "api");
                this.categoryStartTime = SystemClock.elapsedRealtime();
                this.hasEnterCategory = true;
            } else if (i == 4) {
                if (this.hasEnterCategory) {
                    bLogAgentPutString = BLogAgent.build(str, "stay_category", null).putString(ILogConst.Keys.KEY_CATEGORY_NAME, str).putLong("stay_time", SystemClock.elapsedRealtime() - this.categoryStartTime).putString("sdk_version", "2.9.0.2").putString(ILogConst.Keys.KEY_ENTER_FROM, ILogConst.FROM_CATEGORY).putString(ILogConst.Keys.KEY_MODE, "playlet").putString(ILogConst.Keys.INTERFACE_TYPE, "api");
                    this.hasEnterCategory = false;
                } else {
                    LG.e(TAG, "category is not entered, plz use ENTER_CATEGORY first");
                }
            }
        } else {
            if (drama == null || drama.id <= 0) {
                LG.w(TAG, "drama is null or invalid, plz set correct drama model in DJXDramaLog");
                return;
            }
            bLogAgentPutString = BLogAgent.build(str, ILogConst.E_NEWS_LIST_SHOW, null).putString(ILogConst.Keys.KEY_CATEGORY_NAME, str).putString("position", "detail").putString(ILogConst.Keys.KEY_MODE, "playlet").putLong(ILogConst.Keys.KEY_SKIT_ID, drama.id).putString(ILogConst.Keys.INTERFACE_TYPE, "api");
        }
        if (bLogAgentPutString != null) {
            bLogAgentPutString.send();
        }
    }

    /* renamed from: com.bytedance.sdk.djx.core.business.CooperationLog$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$sdk$djx$DJXDramaLog$DramaEvent;

        static {
            int[] iArr = new int[DJXDramaLog.DramaEvent.values().length];
            $SwitchMap$com$bytedance$sdk$djx$DJXDramaLog$DramaEvent = iArr;
            try {
                iArr[DJXDramaLog.DramaEvent.APP_ACTIVATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$sdk$djx$DJXDramaLog$DramaEvent[DJXDramaLog.DramaEvent.CLIENT_SHOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$sdk$djx$DJXDramaLog$DramaEvent[DJXDramaLog.DramaEvent.ENTER_CATEGORY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bytedance$sdk$djx$DJXDramaLog$DramaEvent[DJXDramaLog.DramaEvent.STAY_CATEGORY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
