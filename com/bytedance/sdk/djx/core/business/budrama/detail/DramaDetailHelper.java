package com.bytedance.sdk.djx.core.business.budrama.detail;

import com.baidu.mobads.container.rewardvideo.RemoteRewardActivity;
import com.bytedance.sdk.djx.IDJXDramaDetailDelegate;
import com.bytedance.sdk.djx.core.act.DJXDramaDetailActivity;
import com.bytedance.sdk.djx.model.DJXDramaDetailConfig;
import com.bytedance.sdk.djx.model.Drama;
import com.bytedance.sdk.djx.model.DramaDetail;
import com.bytedance.sdk.djx.params.DJXWidgetDramaDetailParams;
import com.bytedance.sdk.djx.utils.InnerManager;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DramaDetailHelper {
    private static volatile DramaDetailHelper sInstance;

    public void start(Drama drama, int i, DJXWidgetDramaDetailParams.DJXDramaEnterFrom dJXDramaEnterFrom, String str, DJXDramaDetailConfig dJXDramaDetailConfig, IDJXDramaDetailDelegate iDJXDramaDetailDelegate) {
        DJXWidgetDramaDetailParams.DJXDramaEnterFrom dJXDramaEnterFrom2 = DJXWidgetDramaDetailParams.DJXDramaEnterFrom.DEFAULT;
        if (dJXDramaEnterFrom == null) {
            dJXDramaEnterFrom = dJXDramaEnterFrom2;
        }
        if (str == null || str.isEmpty()) {
            str = "";
        }
        if (iDJXDramaDetailDelegate != null) {
            iDJXDramaDetailDelegate.onEnter(InnerManager.getContext(), drama, i);
        } else {
            DJXDramaDetailActivity.startWithParams(DJXWidgetDramaDetailParams.obtain(drama.id, drama.index, dJXDramaDetailConfig).from(dJXDramaEnterFrom).fromGid(str).currentDuration(i));
        }
    }

    public static DramaDetailHelper getInstance() {
        if (sInstance == null) {
            synchronized (DramaDetailHelper.class) {
                if (sInstance == null) {
                    sInstance = new DramaDetailHelper();
                }
            }
        }
        return sInstance;
    }

    public static Map<String, Object> createParamsMap(DramaDetail dramaDetail, Drama drama) {
        Map<String, Object> map = dramaDetail.toMap();
        if (drama != null) {
            map.put("cover_image", drama.coverImage);
            map.put("type", drama.type);
            map.put(RemoteRewardActivity.JSON_BANNER_DESC_ID, drama.desc);
            map.put("script_author", drama.scriptAuthor);
            map.put("script_name", drama.scriptName);
            map.put("icpNumber", drama.icpNumber);
            map.put("unlock_index", Integer.valueOf(drama.unlockIndex));
        }
        return map;
    }
}
