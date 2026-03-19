package com.bytedance.sdk.djx.core.business.reporter;

import com.baidu.mobads.container.adrequest.g;
import com.bytedance.sdk.djx.core.log.BLogAgent;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.model.Drama;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DramaReporter {
    public static void reportEnterCategory(String str) {
        BLogAgent.build(str, "enter_category", null).putString(ILogConst.Keys.KEY_CATEGORY_NAME, str).putString("sdk_version", "2.9.0.2").putString(ILogConst.Keys.KEY_ENTER_FROM, ILogConst.FROM_CATEGORY).putString(ILogConst.Keys.KEY_MODE, "playlet").send();
    }

    public static void reportStayCategory(String str, long j) {
        BLogAgent.build(str, "stay_category", null).putString(ILogConst.Keys.KEY_CATEGORY_NAME, str).putLong("stay_time", j).putString("sdk_version", "2.9.0.2").putString(ILogConst.Keys.KEY_ENTER_FROM, ILogConst.FROM_CATEGORY).putString(ILogConst.Keys.KEY_MODE, "playlet").send();
    }

    public static void reportClientShow(String str, String str2, long j, long j2, Drama drama) {
        BLogAgent.build(str, ILogConst.E_NEWS_LIST_SHOW, null).putString(ILogConst.Keys.KEY_CATEGORY_NAME, str).putString("module", str2).putString("position", "detail").putString(g.o, drama.reqId).putString(ILogConst.Keys.KEY_MODE, "playlet").putLong(ILogConst.Keys.KEY_SKIT_ID, drama.id).putLong("duration", j).putLong("max_duration", j2).putLong("group_id", drama.groupId).putInt("index", drama.index).putString(ILogConst.Keys.INTERFACE_TYPE, "sdk").send();
    }

    public static void reportRecShow(String str, String str2, Drama drama, float f) {
        BLogAgent.build(str, "rec_show", null).putString(ILogConst.Keys.KEY_CATEGORY_NAME, str).putString("request_id", drama.reqId).putLong("shortplay_id", drama.id).putLong("episode_id", drama.groupId).putInt("index", drama.index).putString("module", str2).putInt("pct", Math.min(Float.valueOf(f).intValue() * 100, 100)).putInt("provider_id", drama.providerId).putInt("rank_id", drama.rankId).putLong("channel_id", drama.channelId).send();
    }

    public static void reportClickContent(String str, String str2, Drama drama) {
        BLogAgent.build(str, ILogConst.E_CLICK_CONTENT, null).putString(ILogConst.Keys.KEY_CATEGORY_NAME, str).putString("module", str2).putString("position", "detail").putString(g.o, drama.reqId).putString(ILogConst.Keys.KEY_MODE, "playlet").putLong(ILogConst.Keys.KEY_SKIT_ID, drama.id).putLong("group_id", drama.groupId).putInt("index", drama.index).putString(ILogConst.Keys.INTERFACE_TYPE, "sdk").send();
    }

    public static void reportRecClick(String str, Drama drama) {
        BLogAgent.build(str, "rec_click", null).putString(ILogConst.Keys.KEY_CATEGORY_NAME, str).putString("request_id", drama.reqId).putLong("shortplay_id", drama.id).putLong("episode_id", drama.groupId).putInt("index", drama.index).putInt("provider_id", drama.providerId).putInt("rank_id", drama.rankId).putLong("channel_id", drama.channelId).send();
    }
}
