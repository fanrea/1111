package com.kwai.video.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.kwai.video.cache.AwesomeCache;
import com.kwai.video.hodor.util.Timber;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PlayerPreferrenceUtil {
    private static final String VOD_ADAPTIVE_PREFERENCE_HISTORY_DATA_KEY_NAME = "history_data";
    private static final String VOD_ADAPTIVE_PREFERENCE_NAME = "vod_adaptive_data";
    private static PlayerPreferrenceUtil instance;
    private Context mContext;
    private String vodAdaptiveHisData = "";
    private Boolean mInited = Boolean.FALSE;

    public static PlayerPreferrenceUtil getInstance() {
        if (instance == null) {
            instance = new PlayerPreferrenceUtil();
        }
        return instance;
    }

    private PlayerPreferrenceUtil() {
    }

    private void init(Context context) {
        if (this.mInited.booleanValue() || context == null) {
            return;
        }
        this.mContext = context.getApplicationContext();
        this.mInited = Boolean.TRUE;
        Timber.d("PlayerPreferrenceUtil init", new Object[0]);
    }

    public String getVodAdaptiveData(Context context) {
        init(context);
        if (this.mInited.booleanValue()) {
            this.vodAdaptiveHisData = this.mContext.getSharedPreferences(VOD_ADAPTIVE_PREFERENCE_NAME, 0).getString(VOD_ADAPTIVE_PREFERENCE_HISTORY_DATA_KEY_NAME, "");
        }
        Timber.d("PlayerPreferrenceUtil getVodAdaptiveData mInited:" + this.mInited + ", historyData: " + this.vodAdaptiveHisData, new Object[0]);
        return this.vodAdaptiveHisData;
    }

    public void saveVodAdaptiveData() {
        String historyData = AwesomeCache.VodAdaptive.getHistoryData();
        if (!this.mInited.booleanValue() || TextUtils.isEmpty(historyData)) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.mContext.getSharedPreferences(VOD_ADAPTIVE_PREFERENCE_NAME, 0).edit();
        editorEdit.putString(VOD_ADAPTIVE_PREFERENCE_HISTORY_DATA_KEY_NAME, historyData);
        editorEdit.apply();
    }
}
