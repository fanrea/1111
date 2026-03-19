package com.kwai.video.ksliveplayer.model;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LiveAdaptionModel implements Serializable {
    public static final String QUALITY_AUTO = "AUTO";
    public static final String QUALITY_BLUE_RAY = "BLUE_RAY";
    public static final String QUALITY_HIGH = "HIGH";
    public static final String QUALITY_SMOOTH = "SMOOTH";
    public static final String QUALITY_STANDARD = "STANDARD";
    public static final String QUALITY_SUPER = "SUPER";
    private static Map<String, String> sQualityTypeAndNameMap = null;
    private static final long serialVersionUID = 7696545516532977237L;
    public int mBitrate;
    public int mId;
    public boolean mIsDefaultSelect;
    public int mLevel;
    public String mMediaType;
    public String mName;
    public String mQualityType;
    public String mUrl;

    public LiveAdaptionModel() {
    }

    public LiveAdaptionModel(String str, int i, int i2, String str2, String str3, String str4, int i3, boolean z) {
        this.mUrl = str;
        this.mId = i;
        this.mBitrate = i2;
        this.mQualityType = str2;
        this.mMediaType = str3;
        this.mName = str4;
        this.mLevel = i3;
        this.mIsDefaultSelect = z;
    }

    public static String getNameByQualityType(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (sQualityTypeAndNameMap == null) {
            HashMap map = new HashMap();
            sQualityTypeAndNameMap = map;
            map.put(QUALITY_SMOOTH, "流畅");
            sQualityTypeAndNameMap.put(QUALITY_STANDARD, "高清");
            sQualityTypeAndNameMap.put(QUALITY_HIGH, "超清");
            sQualityTypeAndNameMap.put(QUALITY_BLUE_RAY, "蓝光");
            sQualityTypeAndNameMap.put(QUALITY_SUPER, "蓝光 4M");
        }
        return sQualityTypeAndNameMap.get(str);
    }

    public static LiveAdaptionModel copyOf(String str, LiveAdaptionModel liveAdaptionModel) {
        return new LiveAdaptionModel(str, liveAdaptionModel.mId, liveAdaptionModel.mBitrate, liveAdaptionModel.mQualityType, liveAdaptionModel.mMediaType, liveAdaptionModel.mName, liveAdaptionModel.mLevel, liveAdaptionModel.mIsDefaultSelect);
    }
}
