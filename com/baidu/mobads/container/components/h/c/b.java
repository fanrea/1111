package com.baidu.mobads.container.components.h.c;

import android.text.TextUtils;
import com.baidu.mobads.container.XAdInstanceInfoExt;
import com.baidu.mobads.container.adrequest.j;
import com.baidu.mobstat.forbes.Config;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b {
    private static final String a = ",";

    public static String a(j jVar) {
        if (!(jVar instanceof XAdInstanceInfoExt)) {
            return "";
        }
        XAdInstanceInfoExt xAdInstanceInfoExt = (XAdInstanceInfoExt) jVar;
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(xAdInstanceInfoExt.getClickThroughUrl())) {
            a(sb, "curl");
        }
        if (xAdInstanceInfoExt.getImpressionUrls() == null || xAdInstanceInfoExt.getImpressionUrls().size() < 1) {
            a(sb, "winurl");
        }
        if (xAdInstanceInfoExt.getActionType() == 512) {
            if (TextUtils.isEmpty(xAdInstanceInfoExt.getAppOpenStrs())) {
                a(sb, "apo");
            }
        } else if (xAdInstanceInfoExt.getActionType() == 2) {
            if (TextUtils.isEmpty(xAdInstanceInfoExt.getAppPackageName())) {
                a(sb, "pk");
            }
            if (TextUtils.isEmpty(xAdInstanceInfoExt.getAppVersion())) {
                a(sb, Config.INPUT_DEF_VERSION);
            }
            if (TextUtils.isEmpty(xAdInstanceInfoExt.getPermissionLink())) {
                a(sb, "permissionlink");
            }
            if (TextUtils.isEmpty(xAdInstanceInfoExt.getPrivacyLink())) {
                a(sb, "privacylink");
            }
            if (TextUtils.isEmpty(xAdInstanceInfoExt.getPublisher())) {
                a(sb, com.baidu.mobads.container.components.command.j.I);
            }
            if (TextUtils.isEmpty(xAdInstanceInfoExt.getAppName())) {
                a(sb, "appname");
            }
        }
        if (xAdInstanceInfoExt.getCreativeType() == j.a.STATIC_IMAGE) {
            if (TextUtils.isEmpty(xAdInstanceInfoExt.getMainPictureUrl()) && xAdInstanceInfoExt.getMultiPics() == null) {
                a(sb, "imageurl");
            }
        } else if (xAdInstanceInfoExt.getCreativeType() == j.a.VIDEO && TextUtils.isEmpty(xAdInstanceInfoExt.getVideoUrl())) {
            a(sb, "vurl");
        }
        String string = sb.toString();
        return (TextUtils.isEmpty(string) || !string.startsWith(a)) ? "" : string.substring(1);
    }

    private static StringBuilder a(StringBuilder sb, String str) {
        return sb.append(a).append(str);
    }
}
