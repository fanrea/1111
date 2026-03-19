package com.bytedance.sdk.djx.core.api;

import com.bytedance.sdk.djx.net.ApiConstants;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ApiUrl {
    private static String getHost() {
        return ApiConstants.getHostWithPath();
    }

    public static String feed() {
        return getHost() + "/shortplay/stream";
    }

    public static String videoModel() {
        return getHost() + "/shortplay/video_model";
    }

    public static String userAction() {
        return getHost() + "/user/action_report";
    }

    public static String dramaList() {
        return getHost() + "/shortplay/list";
    }

    public static String dramaCategoryList() {
        return getHost() + "/shortplay/category_list";
    }

    public static String dramaAllList() {
        return getHost() + "/shortplay/mget";
    }

    public static String dramaDetail() {
        return getHost() + "/shortplay/detail";
    }

    public static String dramaSearch() {
        return getHost() + "/shortplay/search";
    }

    public static String dramaHistory() {
        return getHost() + "/shortplay/history_list";
    }

    public static String userConfigReport() {
        return getHost() + "/user/config_report";
    }

    public static String userInfo() {
        return getHost() + "/user/info";
    }

    public static String dramaAdUnlock() {
        return getHost() + "/pay/ad_unlock";
    }

    public static String dramaParamsCheck() {
        return getHost() + "/app/check_lock";
    }

    public static String favoriteAction() {
        return getHost() + "/shortplay/favorite";
    }

    public static String favoriteList() {
        return getHost() + "/shortplay/favorite_list";
    }

    public static String urlList() {
        return getHost() + "/shortplay/url_list";
    }

    public static String userShortplay() {
        return getHost() + "/user/get_user_shortplay";
    }
}
