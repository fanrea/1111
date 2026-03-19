package com.ss.android.downloadlib.addownload;

import android.content.Intent;
import android.text.TextUtils;
import com.ss.android.d.d.hc.w;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class tt {
    public static boolean d(int i) {
        return i == 0 || i == 1;
    }

    public static boolean hc(int i) {
        return i == 2 || i == 1;
    }

    public static boolean d(com.ss.android.d.d.b.b bVar) {
        return bVar.np() && (bVar instanceof com.ss.android.hc.d.d.b) && bVar.us() == 1;
    }

    public static boolean hc(com.ss.android.d.d.b.b bVar) {
        return bVar != null && bVar.us() == 2;
    }

    public static boolean d(com.ss.android.d.d.b.b bVar, w wVar) {
        return bVar.np() && wVar != null;
    }

    public static int d(com.ss.android.downloadlib.addownload.hc.u uVar, boolean z, com.ss.android.socialbase.appdownloader.an anVar) {
        int iD;
        if (anVar == null || TextUtils.isEmpty(anVar.d()) || anVar.getContext() == null) {
            return 0;
        }
        try {
            iD = d(anVar, anVar.d());
        } catch (Throwable th) {
            mq.jh().d(th, "redirectSavePathIfPossible");
            iD = 4;
        }
        anVar.d(iD);
        if (iD == 0) {
            anVar.d(new com.ss.android.downloadlib.b.d());
        }
        if (!anVar.ia()) {
            anVar.d(new com.ss.android.downloadlib.b.hc());
        }
        int iD2 = com.ss.android.socialbase.appdownloader.c.mk().d(anVar);
        com.ss.android.hc.d.hc.hc hcVarD = d(uVar, iD2);
        com.ss.android.downloadlib.addownload.hc.an.d().d(hcVarD);
        hcVarD.h(iD2);
        hcVarD.gb(System.currentTimeMillis());
        hcVarD.tt(0L);
        com.ss.android.socialbase.downloader.uo.d dVarD = com.ss.android.socialbase.downloader.uo.d.d(anVar.i());
        if (!d(anVar, dVarD, iD2) && uVar.hc.mk()) {
            String strBc = uVar.hc.bc();
            if (TextUtils.isEmpty(strBc)) {
                strBc = dVarD.b("download_start_toast_text");
            }
            if (TextUtils.isEmpty(strBc)) {
                strBc = z ? "已开始下载，可在\"我的\"里查看管理" : "已开始下载";
            }
            mq.b().d(2, anVar.getContext(), uVar.hc, strBc, null, 0);
        }
        return iD2;
    }

    private static com.ss.android.hc.d.hc.hc d(com.ss.android.downloadlib.addownload.hc.u uVar, int i) {
        com.ss.android.hc.d.hc.hc hcVar = new com.ss.android.hc.d.hc.hc(uVar.hc, uVar.b, uVar.c, i);
        boolean z = true;
        if (com.ss.android.socialbase.downloader.uo.d.d(i).d("download_event_opt", 1) > 1) {
            try {
                String strHe = uVar.hc.he();
                if (!TextUtils.isEmpty(strHe)) {
                    if (mq.getContext().getPackageManager().getPackageInfo(strHe, 0) == null) {
                        z = false;
                    }
                    hcVar.gb(z);
                }
            } catch (Throwable unused) {
            }
        }
        return hcVar;
    }

    private static boolean d(com.ss.android.socialbase.appdownloader.an anVar, com.ss.android.socialbase.downloader.uo.d dVar, int i) {
        String strOptString;
        JSONArray jSONArrayU = dVar.u("ah_plans");
        if (jSONArrayU != null && jSONArrayU.length() != 0) {
            int length = jSONArrayU.length();
            int i2 = 0;
            JSONObject jSONObject = null;
            while (true) {
                if (i2 < length) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayU.optJSONObject(i2);
                    if (jSONObjectOptJSONObject != null && ((strOptString = jSONObjectOptJSONObject.optString("type")) == "plan_c" || com.ss.android.socialbase.appdownloader.an.d.d(jSONObjectOptJSONObject))) {
                        strOptString.hashCode();
                        switch (strOptString) {
                            case "plan_a":
                            case "plan_b":
                            case "plan_e":
                            case "plan_f":
                                if (com.ss.android.socialbase.appdownloader.hc.d(jSONObjectOptJSONObject, dVar).hc != 0) {
                                    break;
                                } else {
                                    break;
                                }
                            case "plan_c":
                                jSONObject = jSONObjectOptJSONObject;
                                continue;
                            case "plan_g":
                                if (com.ss.android.socialbase.appdownloader.hc.hc(jSONObjectOptJSONObject, dVar).hc != 0) {
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                    i2++;
                }
            }
            if (jSONObject != null) {
                if (jSONObject.optInt("show_unknown_source_on_startup") == 1) {
                    return com.ss.android.socialbase.appdownloader.hc.d(com.ss.android.socialbase.downloader.downloader.b.tr(), (Intent) null, jSONObject, i, new com.ss.android.socialbase.appdownloader.d());
                }
            }
        }
        return false;
    }

    public static String d(com.ss.android.socialbase.downloader.h.b bVar) {
        if (bVar == null) {
            return null;
        }
        try {
            String strS = bVar.s();
            if (!TextUtils.isEmpty(strS)) {
                return new JSONObject(strS).optString("notification_jump_url", null);
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        return null;
    }

    private static int d(com.ss.android.socialbase.appdownloader.an anVar, String str) {
        com.ss.android.socialbase.downloader.uo.d dVarD = com.ss.android.socialbase.downloader.uo.d.d(anVar.i());
        JSONObject jSONObjectC = dVarD.c("download_dir");
        if (jSONObjectC == null || TextUtils.isEmpty(jSONObjectC.optString("dir_name"))) {
            return -1;
        }
        String strHc = anVar.hc();
        String strBc = anVar.bc();
        if (TextUtils.isEmpty(strBc)) {
            strBc = com.ss.android.socialbase.appdownloader.b.d(str, strHc, anVar.mq(), true);
        }
        if (strBc.length() > 255) {
            strBc = strBc.substring(strBc.length() - 255);
        }
        if (TextUtils.isEmpty(strHc)) {
            strHc = strBc;
        }
        String strB = anVar.b();
        if (TextUtils.isEmpty(strB)) {
            strB = com.ss.android.socialbase.appdownloader.b.hc();
        }
        String str2 = strB + File.separator + com.ss.android.socialbase.appdownloader.b.d(strHc, dVarD);
        com.ss.android.socialbase.downloader.h.b bVarD = com.ss.android.socialbase.appdownloader.c.mk().d(anVar.getContext(), str);
        if (bVarD != null && bVarD.nu()) {
            anVar.b(bVarD.mk());
            try {
                anVar.d(new JSONObject(bVarD.ru()));
                return 0;
            } catch (Throwable unused) {
                return 0;
            }
        }
        if (bVarD != null || !"application/vnd.android.package-archive".equalsIgnoreCase(com.ss.android.socialbase.appdownloader.c.mk().d(strBc, anVar.mq()))) {
            return bVarD != null ? 8 : 9;
        }
        int iD = com.ss.android.socialbase.appdownloader.hc.d(dVarD);
        if (iD != 0) {
            return iD;
        }
        anVar.b(str2);
        return iD;
    }

    public static String b(com.ss.android.d.d.b.b bVar) {
        try {
            if (TextUtils.isEmpty(bVar.yi())) {
                return null;
            }
            return new JSONObject(bVar.yi()).optString("clickid");
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return null;
        }
    }

    public static String c(com.ss.android.d.d.b.b bVar) {
        try {
            if (TextUtils.isEmpty(bVar.yi())) {
                return null;
            }
            return new JSONObject(bVar.yi()).optString("intent_extra");
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return null;
        }
    }
}
