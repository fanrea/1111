package com.sigmob.sdk.base.services;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.ai;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.utils.i;
import com.sigmob.sdk.base.utils.m;
import com.sigmob.windad.WindAdError;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class c extends BroadcastReceiver {
    c() {
    }

    private void a(final Context context, final long downId, final Object object) {
        BaseAdUnit baseAdUnitC = null;
        String str = "";
        if (object != null) {
            try {
                if (object instanceof BaseAdUnit) {
                    BaseAdUnit baseAdUnit = (BaseAdUnit) object;
                    try {
                        baseAdUnitC = com.sigmob.sdk.base.common.g.c(baseAdUnit.getUuid());
                    } catch (Exception unused) {
                    }
                    if (baseAdUnitC == null) {
                        baseAdUnitC = baseAdUnit;
                    }
                } else if (object instanceof String) {
                    str = (String) object;
                }
            } catch (Exception unused2) {
            }
        }
        Map<String, Object> mapA = o.a(downId);
        if (mapA == null) {
            return;
        }
        String str2 = (String) mapA.get("fileName");
        Object obj = mapA.get("status");
        Object obj2 = mapA.get("reason");
        if (obj == null || obj2 == null) {
            return;
        }
        int iIntValue = ((Integer) obj).intValue();
        int iIntValue2 = ((Integer) obj2).intValue();
        o.b(downId, str2);
        Uri uri = (Uri) mapA.get(ContentProviderManager.PROVIDER_URI);
        String str3 = "download info is null";
        if (uri == null || iIntValue != 8) {
            try {
                str3 = String.format(Locale.getDefault(), "status %d, reason %d", Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2));
                SigmobLog.i("handleDownloadComplete:fail:" + FileUtil.deleteFile(FileUtil.getRealFilePath(context, uri)));
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
            }
            if (baseAdUnitC != null) {
                ac.a(PointCategory.DOWNLOAD_FAILED, 2, str3, baseAdUnitC);
                ac.b(PointCategory.DOWNLOAD_END, "0", baseAdUnitC);
                HashMap map = new HashMap();
                map.put("result", "0");
                map.put("downloadId", Long.valueOf(downId));
                BaseBroadcastReceiver.a(context, baseAdUnitC.getUuid(), map, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_END);
            }
            try {
                ai.a(context, "下载失败", 0).show();
                return;
            } catch (Throwable th2) {
                SigmobLog.e(th2.getMessage());
                return;
            }
        }
        if (!m.a((CharSequence) str)) {
            try {
                String realFilePath = FileUtil.getRealFilePath(context, uri);
                ac.a(baseAdUnitC, PointCategory.DOWNLOAD_END, ClientMetadata.getPackageInfoWithUri(context, realFilePath), "1");
                HashMap map2 = new HashMap();
                map2.put("result", "1");
                map2.put("downloadId", Long.valueOf(downId));
                o.a(context, realFilePath, baseAdUnitC);
                return;
            } catch (Throwable th3) {
                SigmobLog.e(th3.getMessage());
                ac.a(PointCategory.APP_INSTALL_START, WindAdError.ERROR_SIGMOB_INSTALL_FAIL.getErrorCode(), th3.getMessage(), baseAdUnitC);
                ac.b(PointCategory.APP_INSTALL_START, "0", baseAdUnitC);
                return;
            }
        }
        if (baseAdUnitC != null) {
            com.sigmob.sdk.base.network.g.a(baseAdUnitC, com.sigmob.sdk.base.common.a.H);
            try {
                baseAdUnitC.enableUseDownloadApk(true);
                String realFilePath2 = FileUtil.getRealFilePath(context, uri);
                ac.a(baseAdUnitC, PointCategory.DOWNLOAD_END, ClientMetadata.getPackageInfoWithUri(context, realFilePath2), "1");
                HashMap map3 = new HashMap();
                map3.put("result", "1");
                map3.put("downloadId", Long.valueOf(downId));
                BaseBroadcastReceiver.a(context, baseAdUnitC.getUuid(), map3, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_END);
                o.a(context, realFilePath2, baseAdUnitC);
            } catch (Throwable th4) {
                SigmobLog.e(th4.getMessage());
                ac.a(PointCategory.APP_INSTALL_START, WindAdError.ERROR_SIGMOB_INSTALL_FAIL.getErrorCode(), th4.getMessage(), baseAdUnitC);
                ac.b(PointCategory.APP_INSTALL_START, "0", baseAdUnitC);
                ac.a(PointCategory.DOWNLOAD_FAILED, 2, "download info is null", baseAdUnitC);
                ac.b(PointCategory.DOWNLOAD_END, "0", baseAdUnitC);
                HashMap map4 = new HashMap();
                map4.put("result", "0");
                map4.put("downloadId", Long.valueOf(downId));
                BaseBroadcastReceiver.a(context, baseAdUnitC.getUuid(), map4, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_END);
            }
        }
    }

    DownloadManager a(Context context) {
        return (DownloadManager) context.getSystemService("download");
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        long longExtra = intent.getLongExtra("extra_download_id", -1L);
        File file = new File(i.g(), longExtra + ".log");
        Object fromCache = FileUtil.readFromCache(file.getAbsolutePath());
        o.b(longExtra, "");
        FileUtil.deleteFile(file.getAbsolutePath());
        if (m.a((CharSequence) intent.getAction(), (CharSequence) "android.intent.action.DOWNLOAD_COMPLETE")) {
            a(context, longExtra, fromCache);
        }
    }
}
