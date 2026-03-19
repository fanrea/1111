package com.ss.android.downloadlib.hc;

import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.android.downloadlib.addownload.mq;
import com.ss.android.downloadlib.h.uo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d {
    private static final String d = "d";

    public static boolean d(com.ss.android.downloadlib.addownload.hc.u uVar) throws JSONException {
        boolean z;
        com.ss.android.d.d.u.hc hcVarZw = uVar.hc.zw();
        String strHc = hcVarZw == null ? null : hcVarZw.hc();
        JSONObject jSONObjectD = com.ss.android.downloadlib.h.an.d(new JSONObject(), uVar);
        uo.d(jSONObjectD, "applink_source", "click_by_sdk");
        com.ss.android.downloadlib.c.d.d().hc("applink_click", jSONObjectD, uVar);
        com.ss.android.downloadlib.addownload.hc.h hVarD = com.ss.android.downloadlib.h.tt.d(strHc, uVar);
        if (hVarD.getType() == 2) {
            if (!TextUtils.isEmpty(strHc)) {
                hc("by_url", hVarD, jSONObjectD, uVar);
            }
            hVarD = com.ss.android.downloadlib.h.tt.d(mq.getContext(), uVar.hc.he(), uVar);
        }
        boolean z2 = false;
        if (d(uVar.d) && mq.tt().optInt("link_ad_click_event") == 1) {
            if (uVar.hc instanceof com.ss.android.hc.d.d.b) {
                ((com.ss.android.hc.d.d.b) uVar.hc).b(4);
            }
            com.ss.android.downloadlib.c.d.d().d(uVar.d, 0);
            z = true;
        } else {
            z = false;
        }
        int type = hVarD.getType();
        if (type == 1) {
            hc("by_url", jSONObjectD, uVar);
        } else if (type == 3) {
            d("by_package", jSONObjectD, uVar);
        } else {
            if (type == 4) {
                d("by_package", hVarD, jSONObjectD, uVar);
            } else {
                com.ss.android.downloadlib.u.b.d().hc("AppLinkClick default");
            }
            if (z2 && !z && ((com.ss.android.downloadlib.c.b.d().hc() && !com.ss.android.downloadlib.c.b.d().hc(uVar.d, uVar.hc.yi())) || com.ss.android.downloadlib.c.b.d().b())) {
                com.ss.android.downloadlib.c.d.d().d(uVar.d, 2);
            }
            return z2;
        }
        z2 = true;
        if (z2) {
            com.ss.android.downloadlib.c.d.d().d(uVar.d, 2);
        }
        return z2;
    }

    public static void d(com.ss.android.hc.d.hc.hc hcVar) throws JSONException {
        String strAn = hcVar.an();
        JSONObject jSONObjectD = com.ss.android.downloadlib.h.an.d(new JSONObject(), hcVar);
        uo.d(jSONObjectD, "applink_source", "notify_click_by_sdk");
        com.ss.android.downloadlib.c.d.d().hc("applink_click", jSONObjectD, hcVar);
        com.ss.android.downloadlib.addownload.hc.h hVarD = com.ss.android.downloadlib.h.tt.d(strAn, hcVar);
        if (hVarD.getType() == 2) {
            if (!TextUtils.isEmpty(strAn)) {
                hc("notify_by_url", hVarD, jSONObjectD, hcVar);
            }
            hVarD = com.ss.android.downloadlib.h.tt.d(mq.getContext(), hcVar.u(), hcVar);
        }
        int type = hVarD.getType();
        if (type == 1) {
            hc("notify_by_url", jSONObjectD, hcVar);
            return;
        }
        if (type == 3) {
            d("notify_by_package", jSONObjectD, hcVar);
        } else if (type == 4) {
            d("notify_by_package", hVarD, jSONObjectD, hcVar);
        } else {
            com.ss.android.downloadlib.u.b.d().hc("AppLinkClickNotification default");
        }
    }

    public static void hc(com.ss.android.hc.d.hc.hc hcVar) {
        if (hcVar == null) {
            return;
        }
        String strAn = com.ss.android.socialbase.downloader.uo.d.b().hc("app_link_opt") == 1 ? hcVar.an() : null;
        JSONObject jSONObjectD = com.ss.android.downloadlib.h.an.d(new JSONObject(), hcVar);
        uo.d(jSONObjectD, "applink_source", "dialog_click_by_sdk");
        com.ss.android.downloadlib.c.d.d().hc("applink_click", jSONObjectD, hcVar);
        com.ss.android.downloadlib.addownload.hc.h hVarD = com.ss.android.downloadlib.h.tt.d(strAn, hcVar);
        if (hVarD.getType() == 2) {
            if (!TextUtils.isEmpty(strAn)) {
                hc("dialog_by_url", hVarD, jSONObjectD, hcVar);
            }
            hVarD = com.ss.android.downloadlib.h.tt.d(mq.getContext(), hcVar.u(), hcVar);
        }
        int type = hVarD.getType();
        if (type == 1) {
            hc("dialog_by_url", jSONObjectD, hcVar);
            return;
        }
        if (type == 3) {
            d("dialog_by_package", jSONObjectD, hcVar);
        } else if (type == 4) {
            d("dialog_by_package", hVarD, jSONObjectD, hcVar);
        } else {
            com.ss.android.downloadlib.u.b.d().hc("AppLinkClickDialog default");
        }
    }

    public static boolean d(String str, com.ss.android.hc.d.hc.hc hcVar) throws JSONException {
        if (!com.ss.android.downloadlib.addownload.tt.hc(hcVar.nv())) {
            return false;
        }
        if (TextUtils.isEmpty(hcVar.an()) && TextUtils.isEmpty(str)) {
            return false;
        }
        com.ss.android.socialbase.downloader.notification.hc.d().an(hcVar.rf());
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.h.an.d(jSONObject, hcVar);
        uo.d(jSONObject, "applink_source", "auto_click");
        com.ss.android.downloadlib.c.d.d().hc("applink_click", hcVar);
        com.ss.android.downloadlib.addownload.hc.h hVarD = com.ss.android.downloadlib.h.tt.d(hcVar, hcVar.an(), hcVar.u());
        int type = hVarD.getType();
        if (type == 1) {
            hc("auto_by_url", jSONObject, hcVar);
            return true;
        }
        if (type == 2) {
            hc("auto_by_url", hVarD, jSONObject, hcVar);
            return false;
        }
        if (type == 3) {
            d("auto_by_package", jSONObject, hcVar);
            return true;
        }
        if (type != 4) {
            return false;
        }
        d("auto_by_package", hVarD, jSONObject, hcVar);
        return false;
    }

    public static void d(String str, final JSONObject jSONObject, final com.ss.android.hc.d.hc.d dVar) throws JSONException {
        uo.d(jSONObject, "applink_source", str);
        uo.d(jSONObject, "download_scene", Integer.valueOf(dVar.jh()));
        com.ss.android.downloadlib.c.d.d().hc("deeplink_app_open", jSONObject, dVar);
        str.hashCode();
        switch (str) {
            case "notify_by_package":
            case "auto_by_package":
            case "by_package":
            case "dialog_by_package":
                if ((mq.tt().optInt("check_applink_mode") & 1) != 0) {
                    uo.d(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    u.d().d(new c() { // from class: com.ss.android.downloadlib.hc.d.1
                        @Override // com.ss.android.downloadlib.hc.c
                        public void d(boolean z) {
                            com.ss.android.downloadlib.c.d.d().hc(z ? "deeplink_success" : "deeplink_failed", jSONObject, dVar);
                            if (z) {
                                mq.sy();
                                mq.getContext();
                                dVar.sy();
                                dVar.v();
                                dVar.de();
                            }
                        }
                    });
                    break;
                } else {
                    mq.hc();
                    mq.getContext();
                    dVar.sy();
                    dVar.v();
                    dVar.de();
                    break;
                }
        }
    }

    public static void hc(String str, final JSONObject jSONObject, final com.ss.android.hc.d.hc.d dVar) throws JSONException {
        uo.d(jSONObject, "applink_source", str);
        uo.d(jSONObject, "download_scene", Integer.valueOf(dVar.jh()));
        com.ss.android.downloadlib.c.d.d().hc("deeplink_url_open", jSONObject, dVar);
        str.hashCode();
        switch (str) {
            case "auto_by_url":
            case "by_url":
            case "notify_by_url":
            case "dialog_by_url":
                if ((mq.tt().optInt("check_applink_mode") & 1) != 0) {
                    uo.d(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    u.d().d(new c() { // from class: com.ss.android.downloadlib.hc.d.2
                        @Override // com.ss.android.downloadlib.hc.c
                        public void d(boolean z) {
                            com.ss.android.downloadlib.c.d.d().hc(z ? "deeplink_success" : "deeplink_failed", jSONObject, dVar);
                            if (z) {
                                mq.sy();
                                mq.getContext();
                                dVar.sy();
                                dVar.v();
                                dVar.de();
                            }
                        }
                    });
                    break;
                } else {
                    mq.hc();
                    mq.getContext();
                    dVar.sy();
                    dVar.v();
                    dVar.de();
                    break;
                }
        }
    }

    public static void d(String str, com.ss.android.downloadlib.addownload.hc.h hVar, JSONObject jSONObject, com.ss.android.hc.d.hc.d dVar) throws JSONException {
        uo.d(jSONObject, "applink_source", str);
        uo.d(jSONObject, "error_code", Integer.valueOf(hVar.d()));
        uo.d(jSONObject, "download_scene", Integer.valueOf(dVar.jh()));
        com.ss.android.downloadlib.c.d.d().hc("deeplink_app_open_fail", jSONObject, dVar);
    }

    public static void hc(String str, com.ss.android.downloadlib.addownload.hc.h hVar, JSONObject jSONObject, com.ss.android.hc.d.hc.d dVar) throws JSONException {
        uo.d(jSONObject, "applink_source", str);
        uo.d(jSONObject, "error_code", Integer.valueOf(hVar.d()));
        uo.d(jSONObject, "download_scene", Integer.valueOf(dVar.jh()));
        com.ss.android.downloadlib.c.d.d().hc("deeplink_url_open_fail", jSONObject, dVar);
    }

    public static boolean d(com.ss.android.downloadlib.addownload.hc.u uVar, int i) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        uo.d(jSONObject, "download_scene", Integer.valueOf(uVar.jh()));
        com.ss.android.downloadlib.c.d.d().hc("market_click_open", jSONObject, uVar);
        com.ss.android.downloadlib.addownload.hc.h hVarD = com.ss.android.downloadlib.h.tt.d(mq.getContext(), uVar, uVar.hc.he());
        String strD = uo.d(hVarD.hc(), PointCategory.OPEN_MARKET);
        int type = hVarD.getType();
        if (type == 5) {
            d(strD, jSONObject, uVar, true);
        } else {
            if (type == 6) {
                uo.d(jSONObject, "error_code", Integer.valueOf(hVarD.d()));
                uo.d(jSONObject, "download_scene", Integer.valueOf(uVar.jh()));
                com.ss.android.downloadlib.c.d.d().hc("market_open_failed", jSONObject, uVar);
                return false;
            }
            if (type != 7) {
                return false;
            }
        }
        com.ss.android.downloadlib.c.d.d().d(uVar.d, i);
        return true;
    }

    public static void d(final String str, final JSONObject jSONObject, final com.ss.android.downloadlib.addownload.hc.u uVar, boolean z) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception e) {
                com.ss.android.downloadlib.u.b.d().d(e, "onMarketSuccess");
                return;
            }
        }
        uo.d(jSONObject, "applink_source", str);
        uo.d(jSONObject, "download_scene", Integer.valueOf(uVar.jh()));
        if (z) {
            com.ss.android.downloadlib.c.d.d().hc("market_open_success", jSONObject, uVar);
        }
        if ((mq.tt().optInt("check_applink_mode") & 4) != 0) {
            u.d().hc(new c() { // from class: com.ss.android.downloadlib.hc.d.3
                @Override // com.ss.android.downloadlib.hc.c
                public void d(boolean z2) {
                    if (!z2 && !PointCategory.OPEN_MARKET.equals(str)) {
                        d.d(com.ss.android.downloadlib.h.tt.d(mq.getContext(), Uri.parse("market://details?id=" + uVar.u())), uVar, false);
                    }
                    com.ss.android.downloadlib.c.d.d().d(z2 ? "market_delay_success" : "market_delay_failed", jSONObject, uVar);
                    if (z2) {
                        mq.sy();
                        mq.getContext();
                    }
                }
            });
        } else {
            mq.hc();
            mq.getContext();
        }
        com.ss.android.hc.d.hc.hc hcVarD = com.ss.android.downloadlib.addownload.hc.an.d().d(uVar.hc.he());
        if (hcVarD != null) {
            com.ss.android.downloadlib.h.mq.d().d(d, "onMarketSuccess", "商店场景,缓存中已有NativeDownloadModel记录,进行复用");
        } else {
            com.ss.android.downloadlib.h.mq.d().d(d, "onMarketSuccess", "商店场景,缓存中没有相应的NativeDownloadModel,需要新建");
            hcVarD = new com.ss.android.hc.d.hc.hc(uVar.hc, uVar.b, uVar.c);
        }
        hcVarD.u(2);
        hcVarD.an(System.currentTimeMillis());
        hcVarD.gb(4);
        hcVarD.tt(2);
        com.ss.android.downloadlib.addownload.hc.an.d().d(hcVarD);
        com.ss.android.downloadlib.h.mq.d().d(d, "onMarketSuccess", "检测到跳商店成功事件,准备开始检测安装行为");
        com.ss.android.downloadlib.tt.d().d(uVar, hcVarD);
    }

    public static void d(com.ss.android.downloadlib.addownload.hc.h hVar, com.ss.android.downloadlib.addownload.hc.u uVar, boolean z) {
        String strD = uo.d(hVar.hc(), PointCategory.OPEN_MARKET);
        JSONObject jSONObject = new JSONObject();
        uo.d(jSONObject, "ttdownloader_type", LiveConfigKey.BACKUP);
        int type = hVar.getType();
        if (type == 5) {
            d(strD, jSONObject, uVar, z);
        } else {
            if (type != 6) {
                return;
            }
            uo.d(jSONObject, "error_code", Integer.valueOf(hVar.d()));
            uo.d(jSONObject, "download_scene", Integer.valueOf(uVar.jh()));
            com.ss.android.downloadlib.c.d.d().hc("market_open_failed", jSONObject, uVar);
        }
    }

    public static boolean d(long j) {
        return com.ss.android.downloadlib.addownload.hc.an.d().c(j) == null;
    }
}
