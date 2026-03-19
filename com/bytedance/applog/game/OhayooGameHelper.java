package com.bytedance.applog.game;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.log.LoggerImpl;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class OhayooGameHelper {
    public static final String GAME_ACTIVITY = "ohayoo_game_activity";
    public static final String GAME_BUTTONCLICK = "ohayoo_game_buttonclick";
    public static final String GAME_GUILD = "ohayoo_game_guild";
    public static final String GAME_RANK = "ohayoo_game_rank";
    public static final String GAME_SHARE = "ohayoo_game_share";
    public static final String GAME_SNS = "ohayoo_game_sns";
    public static final String GAME_TASK = "ohayoo_game_task";
    public static final String GAME_UNLOCK = "ohayoo_game_unlock";
    public static final String KEY_LEVEL = "ohayoo_level";
    public static final String KEY_PACKAGE_CHANNEL = "ohayoo_packagechannel";
    public static final String KEY_ROLE_ID = "ohayoo_roleid";
    public static final String KEY_SDK_OPEN_ID = "ohayoo_sdk_open_id";
    public static final String KEY_SERVER_ID = "ohayoo_serverid";
    public static final String KEY_USER_TYPE = "ohayoo_usertype";
    public static final String KEY_ZONE_ID = "ohayoo_zoneid";

    public static void fillOtherParams(HashMap<String, Object> map, JSONObject jSONObject) throws JSONException {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public static void onEventGameActivity(String str, String str2, String str3, String str4, int i, String str5, long j, long j2, HashMap<String, Object> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("activitytype", str);
            jSONObject.put("actid", str2);
            jSONObject.put("actname", str3);
            jSONObject.put("actdesc", str4);
            jSONObject.put("actresult", i);
            jSONObject.put("actreward", str5);
            jSONObject.put("starttime", j);
            jSONObject.put("endtime", j2);
            fillOtherParams(map, jSONObject);
            AppLog.onEventV3(GAME_ACTIVITY, jSONObject);
        } catch (JSONException e) {
            LoggerImpl.global().error(Collections.singletonList("OhayooGameHelper"), "JSON handle failed", e, new Object[0]);
        }
    }

    public static void onEventGameButtonClick(String str, String str2, String str3, int i, HashMap<String, Object> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("buttontype", str);
            jSONObject.put("buttonid", str2);
            jSONObject.put("buttonname", str3);
            jSONObject.put("buttonresult", i);
            fillOtherParams(map, jSONObject);
            AppLog.onEventV3(GAME_BUTTONCLICK, jSONObject);
        } catch (JSONException e) {
            LoggerImpl.global().error(Collections.singletonList("OhayooGameHelper"), "JSON handle failed", e, new Object[0]);
        }
    }

    public static void onEventGameGuild(String str, String str2, String str3, int i, int i2, int i3, HashMap<String, Object> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("membergrade", str);
            jSONObject.put("guildid", str2);
            jSONObject.put("guildname", str3);
            jSONObject.put("guildlevel", i);
            jSONObject.put("guildresult", i2);
            jSONObject.put("guildrank", i3);
            fillOtherParams(map, jSONObject);
            AppLog.onEventV3(GAME_GUILD, jSONObject);
        } catch (JSONException e) {
            LoggerImpl.global().error(Collections.singletonList("OhayooGameHelper"), "JSON handle failed", e, new Object[0]);
        }
    }

    public static void onEventGameRank(String str, int i, int i2, int i3, int i4, int i5, int i6, HashMap<String, Object> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ranktype", str);
            jSONObject.put("rankid", i);
            jSONObject.put("rank", i2);
            jSONObject.put("befrank", i3);
            jSONObject.put(Config.EVENT_HEAT_POINT, i4);
            jSONObject.put("befpoint", i5);
            jSONObject.put("allpoint", i6);
            fillOtherParams(map, jSONObject);
            AppLog.onEventV3(GAME_RANK, jSONObject);
        } catch (JSONException e) {
            LoggerImpl.global().error(Collections.singletonList("OhayooGameHelper"), "JSON handle failed", e, new Object[0]);
        }
    }

    public static void onEventGameShare(String str, String str2, int i, String str3, String str4, HashMap<String, Object> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sharetype", str);
            jSONObject.put("sharefocus", str2);
            jSONObject.put("shareresult", i);
            jSONObject.put("shareid", str3);
            jSONObject.put("shareidentify", str4);
            fillOtherParams(map, jSONObject);
            AppLog.onEventV3(GAME_SHARE, jSONObject);
        } catch (JSONException e) {
            LoggerImpl.global().error(Collections.singletonList("OhayooGameHelper"), "JSON handle failed", e, new Object[0]);
        }
    }

    public static void onEventGameSns(int i, int i2, String str, String str2, HashMap<String, Object> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("recnum", i);
            jSONObject.put("count", i2);
            jSONObject.put("snstype", str);
            jSONObject.put("snssubtype", str2);
            fillOtherParams(map, jSONObject);
            AppLog.onEventV3(GAME_SNS, jSONObject);
        } catch (JSONException e) {
            LoggerImpl.global().error(Collections.singletonList("OhayooGameHelper"), "JSON handle failed", e, new Object[0]);
        }
    }

    public static void onEventGameTask(String str, String str2, String str3, String str4, int i, HashMap<String, Object> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tasktype", str);
            jSONObject.put("taskid", str2);
            jSONObject.put("taskname", str3);
            jSONObject.put("taskdesc", str4);
            jSONObject.put("taskresult", i);
            fillOtherParams(map, jSONObject);
            AppLog.onEventV3(GAME_TASK, jSONObject);
        } catch (JSONException e) {
            LoggerImpl.global().error(Collections.singletonList("OhayooGameHelper"), "JSON handle failed", e, new Object[0]);
        }
    }

    public static void onEventGameUnlock(String str, String str2, String str3, HashMap<String, Object> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("unlocktype", str);
            jSONObject.put("unlockid", str2);
            jSONObject.put("unlockname", str3);
            fillOtherParams(map, jSONObject);
            AppLog.onEventV3(GAME_UNLOCK, jSONObject);
        } catch (JSONException e) {
            LoggerImpl.global().error(Collections.singletonList("OhayooGameHelper"), "JSON handle failed", e, new Object[0]);
        }
    }

    public static void setOhayooCustomHeader(String str, Object obj) {
        AppLog.setHeaderInfo(str, obj);
    }
}
