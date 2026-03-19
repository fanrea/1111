package com.bytedance.applog.game;

import android.text.TextUtils;
import com.alipay.sdk.m.p.e;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.log.LoggerImpl;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class WhalerGameHelper {
    public static final String GT_AD_BUTTON_CLICK = "gt_ad_button_click";
    public static final String GT_AD_SHOW = "gt_ad_show";
    public static final String GT_AD_SHOW_END = "gt_ad_show_end";
    public static final String GT_COST_COINS = "gt_cost_coins";
    public static final String GT_END_PLAY = "gt_end_play";
    public static final String GT_GET_COINS = "gt_get_coins";
    public static final String GT_INIT_INFO = "gt_init_info";
    public static final String GT_LEVELUP = "gt_levelup";
    public static final String GT_START_PLAY = "gt_start_play";
    public static final String PURCHASE = "purchase";

    public enum Result {
        UNCOMPLETED("uncompleted"),
        SUCCESS("success"),
        FAIL("fail");

        public final String gameResult;

        Result(String str) {
            this.gameResult = str;
        }
    }

    public static void adButtonClick(String str, String str2, String str3, HashMap<String, Object> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            fillOtherParams(map, jSONObject);
            jSONObject.put("ad_type", str);
            jSONObject.put("ad_position_type", str2);
            jSONObject.put("ad_position", str3);
        } catch (JSONException e) {
            LoggerImpl.global().error(Collections.singletonList("WhalerGameHelper"), "JSON handle failed", e, new Object[0]);
        }
        AppLog.onEventV3(GT_AD_BUTTON_CLICK, jSONObject, 1);
    }

    public static void adShow(String str, String str2, String str3, HashMap<String, Object> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            fillOtherParams(map, jSONObject);
            jSONObject.put("ad_type", str);
            jSONObject.put("ad_position_type", str2);
            jSONObject.put("ad_position", str3);
        } catch (JSONException e) {
            LoggerImpl.global().error(Collections.singletonList("WhalerGameHelper"), "JSON handle failed", e, new Object[0]);
        }
        AppLog.onEventV3(GT_AD_SHOW, jSONObject, 1);
    }

    public static void adShowEnd(String str, String str2, String str3, String str4, HashMap<String, Object> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            fillOtherParams(map, jSONObject);
            jSONObject.put("ad_type", str);
            jSONObject.put("ad_position_type", str2);
            jSONObject.put("ad_position", str3);
            jSONObject.put("result", str4);
        } catch (JSONException e) {
            LoggerImpl.global().error(Collections.singletonList("WhalerGameHelper"), "JSON handle failed", e, new Object[0]);
        }
        AppLog.onEventV3(GT_AD_SHOW_END, jSONObject, 1);
    }

    public static void costCoins(String str, String str2, int i, HashMap<String, Object> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            fillOtherParams(map, jSONObject);
            jSONObject.put("coin_type", str);
            jSONObject.put(e.s, str2);
            jSONObject.put("coin_num", i);
        } catch (JSONException e) {
            LoggerImpl.global().error(Collections.singletonList("WhalerGameHelper"), "JSON handle failed", e, new Object[0]);
        }
        AppLog.onEventV3(GT_COST_COINS, jSONObject, 1);
    }

    public static void endPlay(String str, Result result, int i, HashMap<String, Object> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            fillOtherParams(map, jSONObject);
            jSONObject.put("ectype_name", str);
            jSONObject.put("result", result.gameResult);
            jSONObject.put("duration", i);
        } catch (JSONException e) {
            LoggerImpl.global().error(Collections.singletonList("WhalerGameHelper"), "JSON handle failed", e, new Object[0]);
        }
        AppLog.onEventV3(GT_END_PLAY, jSONObject, 1);
    }

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

    public static void gameInitInfo(int i, String str, int i2, HashMap<String, Object> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            fillOtherParams(map, jSONObject);
            jSONObject.put("coin_type", str);
            jSONObject.put("coin_left", i2);
            jSONObject.put("lev", i);
        } catch (JSONException e) {
            LoggerImpl.global().error(Collections.singletonList("WhalerGameHelper"), "JSON handle failed", e, new Object[0]);
        }
        AppLog.onEventV3(GT_INIT_INFO, jSONObject, 1);
    }

    public static void getCoins(String str, String str2, int i, HashMap<String, Object> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            fillOtherParams(map, jSONObject);
            jSONObject.put("coin_type", str);
            jSONObject.put(e.s, str2);
            jSONObject.put("coin_num", i);
        } catch (JSONException e) {
            LoggerImpl.global().error(Collections.singletonList("WhalerGameHelper"), "JSON handle failed", e, new Object[0]);
        }
        AppLog.onEventV3(GT_GET_COINS, jSONObject, 1);
    }

    public static void levelUp(int i, int i2, String str, int i3, HashMap<String, Object> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            fillOtherParams(map, jSONObject);
            jSONObject.put("get_exp", i2);
            jSONObject.put(e.s, str);
            jSONObject.put("aflev", i3);
            jSONObject.put("lev", i);
        } catch (JSONException e) {
            LoggerImpl.global().error(Collections.singletonList("WhalerGameHelper"), "JSON handle failed", e, new Object[0]);
        }
        AppLog.onEventV3(GT_LEVELUP, jSONObject, 1);
    }

    public static void purchase(String str, String str2, String str3, int i, String str4, String str5, String str6, int i2, HashMap<String, Object> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            fillOtherParams(map, jSONObject);
            jSONObject.put("content_type", str);
            jSONObject.put("content_name", str2);
            jSONObject.put("content_num", i);
            jSONObject.put("content_id", str3);
            jSONObject.put("payment_channel", str4);
            jSONObject.put("currency", str5);
            jSONObject.put("is_success", str6);
            jSONObject.put("currency_amount", i2);
        } catch (JSONException e) {
            LoggerImpl.global().error(Collections.singletonList("WhalerGameHelper"), "JSON handle failed", e, new Object[0]);
        }
        AppLog.onEventV3("purchase", jSONObject, 1);
    }

    public static void startPlay(String str, HashMap<String, Object> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            fillOtherParams(map, jSONObject);
            jSONObject.put("ectype_name", str);
        } catch (JSONException e) {
            LoggerImpl.global().error(Collections.singletonList("WhalerGameHelper"), "JSON handle failed", e, new Object[0]);
        }
        AppLog.onEventV3(GT_START_PLAY, jSONObject, 1);
    }
}
