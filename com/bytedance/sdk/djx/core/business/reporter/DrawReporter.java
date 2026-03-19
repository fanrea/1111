package com.bytedance.sdk.djx.core.business.reporter;

import com.baidu.mobads.container.adrequest.g;
import com.bytedance.sdk.djx.core.log.BLogAgent;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.model.Feed;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DrawReporter {
    public static final String PAGE_NAME_DRAW = "draw";

    public static String getCategoryName() {
        return "hotsoon_video_detail_draw";
    }

    public static String getEnterFrom() {
        return ILogConst.FROM_CATEGORY;
    }

    public static void reportAdRequestEngine(String str) {
        BLogAgent.build(str, ILogConst.E_AD_REQUEST_ENGINE, null).send();
    }

    public static void reportAdRequestEngineSuccess(String str, int i, String str2) {
        BLogAgent.build(str, ILogConst.E_AD_REQUEST_ENGINE_SUCCESS, null).putInt(PointParamKey.AD_COUNT, i).putString(g.o, str2).send();
    }

    public static void reportAdRequestEngineFail(String str, String str2, int i, String str3) {
        BLogAgent.build(str, ILogConst.E_AD_REQUEST_ENGINE_FAIL, null).putString(g.o, str2).putInt("err_code", i).putString("err_msg", str3).send();
    }

    public static void reportAppEvoke(String str, Feed feed, Map<String, Object> map) {
        reportAppEvoke(str, feed, getEnterFrom(), map);
    }

    public static void sendPlayFirstEvent(Object obj, String str, long j, String str2, String str3, Map<String, Object> map) {
        if (obj == null) {
            return;
        }
        boolean z = obj instanceof Feed;
        if (z) {
        }
        BLogAgent bLogAgentPutString = BLogAgent.build(str, ILogConst.E_VIDEO_PLAY_DRAW_FIRST, map).putLong("group_id", z ? ((Feed) obj).getGroupId() : 0L).putLong("item_id", z ? ((Feed) obj).getItemId() : 0L).putString("feed_type", getFeedType(obj)).putInt("group_source", z ? ((Feed) obj).getGroupSource() : 0).putString(ILogConst.Keys.KEY_CATEGORY_NAME, getCategoryName()).putString(ILogConst.Keys.KEY_ENTER_FROM, getEnterFrom()).putString("position", "detail").putLong("duration", j).putString("video_play_type", str2).putString("cache_play_reason", str3);
        if (z) {
            Feed feed = (Feed) obj;
            bLogAgentPutString.putString("category_server", feed.getCategoryName());
            if (feed.getDrama() != null) {
                bLogAgentPutString.putInt("index", feed.getDrama().index);
            }
        }
        bLogAgentPutString.send();
    }

    public static void reportAppEvoke(String str, Feed feed, String str2, Map<String, Object> map) {
        BLogAgent bLogAgentPutString = BLogAgent.build(str, ILogConst.E_APP_EVOKE, map).putString(ILogConst.Keys.KEY_ENTER_FROM, getEnterFrom()).putString("sdk_version", "2.9.0.2").putString("position", "detail");
        if (feed != null) {
            bLogAgentPutString.putLong("group_id", feed.getGroupId()).putLong("item_id", feed.getItemId()).putInt("group_source", feed.getGroupSource()).putString("category_server", feed.getCategoryName());
            if (feed.getDrama() != null) {
                bLogAgentPutString.putInt("index", feed.getDrama().index);
            }
        }
        bLogAgentPutString.send();
    }

    public static void reportStayOtherPage(String str, String str2, long j, Map<String, Object> map) {
        BLogAgent.build(str, ILogConst.E_STAY_OTHER_PAGE, map).putString("sdk_version", "2.9.0.2").putString("page_name", str2).putLong("stay_time", j).send();
    }

    public static String getFeedType(Object obj) {
        return (!(obj instanceof Feed) || ((Feed) obj).isType4Ad()) ? "ads" : "video";
    }
}
