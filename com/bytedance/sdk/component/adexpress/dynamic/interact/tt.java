package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.sigmob.sdk.base.mta.PointType;
import com.ss.ttm.player.MediaPlayer;
import io.netty.util.internal.StringUtil;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tt {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static h d(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.b.h hVar, com.bytedance.sdk.component.adexpress.dynamic.b.tc tcVar, com.bytedance.sdk.component.adexpress.hc.uo uoVar) {
        if (context == null || dynamicBaseWidget == null || hVar == null) {
            return null;
        }
        String strTr = hVar.tr();
        String strVv = uoVar.vv();
        strTr.hashCode();
        char c = 65535;
        switch (strTr.hashCode()) {
            case 48:
                if (strTr.equals("0")) {
                    c = 0;
                    break;
                }
                break;
            case 49:
                if (strTr.equals("1")) {
                    c = 1;
                    break;
                }
                break;
            case 50:
                if (strTr.equals("2")) {
                    c = 2;
                    break;
                }
                break;
            case 53:
                if (strTr.equals("5")) {
                    c = 3;
                    break;
                }
                break;
            case 54:
                if (strTr.equals("6")) {
                    c = 4;
                    break;
                }
                break;
            case 55:
                if (strTr.equals("7")) {
                    c = 5;
                    break;
                }
                break;
            case 56:
                if (strTr.equals(GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD)) {
                    c = 6;
                    break;
                }
                break;
            case 57:
                if (strTr.equals("9")) {
                    c = 7;
                    break;
                }
                break;
            case 1567:
                if (strTr.equals(PointType.SIGMOB_APP)) {
                    c = '\b';
                    break;
                }
                break;
            case 1568:
                if (strTr.equals("11")) {
                    c = '\t';
                    break;
                }
                break;
            case 1569:
                if (strTr.equals("12")) {
                    c = '\n';
                    break;
                }
                break;
            case 1570:
                if (strTr.equals(PointType.SIGMOB_REPORT_TRACKING)) {
                    c = 11;
                    break;
                }
                break;
            case 1571:
                if (strTr.equals("14")) {
                    c = '\f';
                    break;
                }
                break;
            case 1573:
                if (strTr.equals("16")) {
                    c = StringUtil.CARRIAGE_RETURN;
                    break;
                }
                break;
            case 1574:
                if (strTr.equals(PointType.LOAD_READY)) {
                    c = 14;
                    break;
                }
                break;
            case 1575:
                if (strTr.equals("18")) {
                    c = 15;
                    break;
                }
                break;
            case 1598:
                if (strTr.equals("20")) {
                    c = 16;
                    break;
                }
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_ADDITION_SUB_INFO /* 1600 */:
                if (strTr.equals("22")) {
                    c = 17;
                    break;
                }
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SUBTITLE_SENSE_BUFFERING /* 1601 */:
                if (strTr.equals("23")) {
                    c = 18;
                    break;
                }
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SUBTITLE_LAZY_LOADING /* 1602 */:
                if (strTr.equals("24")) {
                    c = 19;
                    break;
                }
                break;
            case 1603:
                if (strTr.equals("25")) {
                    c = 20;
                    break;
                }
                break;
            case 1607:
                if (strTr.equals("29")) {
                    c = 21;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new u(context, dynamicBaseWidget, hVar);
            case 1:
                return new b(context, dynamicBaseWidget, hVar);
            case 2:
                return new hc(context, dynamicBaseWidget, hVar);
            case 3:
                if (hVar.y() == 1) {
                    return new w(context, dynamicBaseWidget, hVar, hVar.nw());
                }
                return new cb(context, dynamicBaseWidget, hVar);
            case 4:
            case '\t':
                return new uo(context, dynamicBaseWidget, hVar);
            case 5:
            case '\f':
                return new mk(context, dynamicBaseWidget, hVar);
            case 6:
                return new mq(context, dynamicBaseWidget, hVar);
            case 7:
            case '\r':
                return new k(context, dynamicBaseWidget, hVar, strTr, tcVar, uoVar.tt(), uoVar.j());
            case '\b':
                return new c(context, dynamicBaseWidget, hVar);
            case '\n':
                return new cb(context, dynamicBaseWidget, hVar);
            case 11:
                return new w(context, dynamicBaseWidget, hVar);
            case 14:
            case 15:
                return new rf(context, dynamicBaseWidget, hVar, strTr, tcVar, uoVar.tt(), uoVar.j());
            case 16:
                if (com.bytedance.sdk.component.adexpress.c.d()) {
                    return new tc(context, dynamicBaseWidget, hVar, strVv + "static/lotties/glass-swipe/glass-swipe.json", "20");
                }
                return new tc(context, dynamicBaseWidget, hVar, TextUtils.isEmpty(strVv) ? null : strVv + "brush_mask.json", "20");
            case 17:
                if (com.bytedance.sdk.component.adexpress.c.d()) {
                    return new tc(context, dynamicBaseWidget, hVar, strVv + "static/lotties/202327swiper-up-star/index.json", "22");
                }
                return new yo(context, dynamicBaseWidget, hVar);
            case 18:
                if (com.bytedance.sdk.component.adexpress.c.d()) {
                    return new tc(context, dynamicBaseWidget, hVar, strVv + "static/lotties/202327swiper-up-star/click.json", "23");
                }
                return null;
            case 19:
                if (com.bytedance.sdk.component.adexpress.c.d()) {
                    return new d(context, dynamicBaseWidget, hVar);
                }
                return new tc(context, dynamicBaseWidget, hVar, TextUtils.isEmpty(strVv) ? null : strVv + "swiper_up_star.json", "24");
            case 20:
                if (com.bytedance.sdk.component.adexpress.c.d()) {
                    return new tc(context, dynamicBaseWidget, hVar, strVv + "static/lotties/gesture-slide.json", "25");
                }
                return null;
            case 21:
                return new an(context, dynamicBaseWidget, hVar, tcVar, uoVar.tt(), uoVar.j());
            default:
                return null;
        }
    }
}
