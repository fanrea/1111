package com.bytedance.sdk.djx.core.business.budrama.history;

import com.baidu.mobads.container.adrequest.g;
import com.bytedance.sdk.djx.core.log.BLogAgent;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.model.DJXDramaDetailConfig;
import com.bytedance.sdk.djx.model.Drama;
import com.bytedance.sdk.djx.params.DJXWidgetDramaHistoryParam;
import com.bytedance.sdk.djx.utils.LG;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DramaHistoryReporter {
    private static final String TAG = "DramaHistoryReporter";

    public static void clientShow(DJXWidgetDramaHistoryParam dJXWidgetDramaHistoryParam, Drama drama, long j, long j2, Map<String, Object> map) {
        DJXDramaDetailConfig dJXDramaDetailConfig = dJXWidgetDramaHistoryParam.mDramaDetailConfig;
        BLogAgent.build(ILogConst.CATEGORY_ME_DRAMA_HISTORY, ILogConst.E_NEWS_LIST_SHOW, null).putString(ILogConst.Keys.KEY_CATEGORY_NAME, ILogConst.CATEGORY_ME_DRAMA_HISTORY).putString("position", "detail").putString(g.o, drama.reqId).putString(ILogConst.Keys.KEY_MODE, "playlet").putLong(ILogConst.Keys.KEY_SKIT_ID, drama.id).putLong("duration", j).putLong("max_duration", j2).send();
        LG.d("drama history client show skitId = " + drama.id + ", duration = " + j + ", maxDuration = " + j2);
    }
}
