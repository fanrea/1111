package com.bytedance.sdk.djx.core.business.budrama.card;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.g;
import com.bytedance.sdk.djx.core.log.BLogAgent;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.model.DramaDetail;
import com.bytedance.sdk.djx.utils.LG;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DramaCardReporter {
    private static final String TAG = "DramaCardReporter";
    private String mCategory;
    private Map<String, Object> mCommonParams;
    private boolean mHasSendAutoPlay = false;
    private boolean mHasSendAutoOver = false;

    public void setParams(String str, Map<String, Object> map) {
        this.mCategory = str;
        this.mCommonParams = map;
    }

    boolean sendAutoPlayEvent(DramaDetail dramaDetail) {
        if (dramaDetail == null || dramaDetail.getVideoModel() == null || this.mHasSendAutoPlay) {
            return false;
        }
        this.mHasSendAutoPlay = true;
        BLogAgent.build(this.mCategory, ILogConst.E_VIDEO_PLAY_AUTO, this.mCommonParams).putLong("group_id", dramaDetail.getGroupId()).putInt("index", dramaDetail.getIndex()).putString(ILogConst.Keys.KEY_CATEGORY_NAME, this.mCategory).putString(ILogConst.Keys.KEY_ENTER_FROM, ILogConst.FROM_DRAMA_CARD).putString("position", "detail").putString(g.o, dramaDetail.getReqId()).putString(ILogConst.Keys.KEY_MODE, "playlet").putString("resolution", dramaDetail.getVideoModel().getDefinition()).putLong(ILogConst.Keys.KEY_SKIT_ID, dramaDetail.getSkitId()).send();
        return true;
    }

    boolean sendAutoOverEvent(DramaDetail dramaDetail, long j, int i) {
        if (dramaDetail == null || !this.mHasSendAutoPlay || this.mHasSendAutoOver) {
            return false;
        }
        this.mHasSendAutoOver = true;
        BLogAgent.build(this.mCategory, ILogConst.E_VIDEO_OVER_AUTO, this.mCommonParams).putLong("group_id", dramaDetail.getGroupId()).putInt("index", dramaDetail.getIndex()).putString(ILogConst.Keys.KEY_CATEGORY_NAME, this.mCategory).putString(ILogConst.Keys.KEY_ENTER_FROM, ILogConst.FROM_DRAMA_CARD).putString("position", "detail").putString(g.o, dramaDetail.getReqId()).putString(ILogConst.Keys.KEY_MODE, "playlet").putLong(ILogConst.Keys.KEY_SKIT_ID, dramaDetail.getSkitId()).putLong("duration", j).putLong(ILogConst.Keys.KEY_PERCENT, i).send();
        return true;
    }

    void clientShow(DramaDetail dramaDetail, long j, long j2) {
        if (TextUtils.isEmpty(this.mCategory) || dramaDetail == null || dramaDetail.getGroupId() == -1) {
            LG.d(TAG, "author client show category or groupId exception");
        } else {
            BLogAgent.build(this.mCategory, ILogConst.E_NEWS_LIST_SHOW, this.mCommonParams).putString(ILogConst.Keys.KEY_CATEGORY_NAME, this.mCategory).putString("module", "banner").putString("position", "detail").putString(g.o, dramaDetail.getReqId()).putString(ILogConst.Keys.KEY_MODE, "playlet").putLong(ILogConst.Keys.KEY_SKIT_ID, dramaDetail.getSkitId()).putLong("duration", j).putLong("max_duration", j2).putLong("group_id", dramaDetail.getGroupId()).putInt("index", dramaDetail.getIndex()).send();
        }
    }
}
