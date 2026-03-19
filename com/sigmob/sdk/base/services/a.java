package com.sigmob.sdk.base.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.ai;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.n;
import com.sigmob.sdk.base.o;
import com.sigmob.sdk.base.utils.i;
import com.sigmob.windad.WindAdError;
import java.io.File;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class a extends BroadcastReceiver {
    a() {
    }

    private void a(Context context, PackageInfo info, String action) {
        ac.a((BaseAdUnit) null, PointCategory.APP_INSTALL_MONITOR, info, action);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Context context, BaseAdUnit baseAdUnit) {
        FileUtil.deleteFile(new File(i.a(context.getApplicationContext()), baseAdUnit.getApkName()).getAbsolutePath());
    }

    private void a(final Context context, final BaseAdUnit adUnit, final PackageInfo info) {
        com.sigmob.sdk.base.network.g.a(adUnit, com.sigmob.sdk.base.common.a.J);
        ac.a(adUnit, PointCategory.APP_INSTALL_END, info, "1");
        HashMap map = new HashMap();
        map.put("result", "1");
        BaseBroadcastReceiver.a(context, adUnit.getUuid(), map, IntentActions.ACTION_INTERSTITIAL_INSTALL_END);
        adUnit.setApkPackageName(info.packageName);
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new Runnable() { // from class: com.sigmob.sdk.base.services.a$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                a.a(context, adUnit);
            }
        });
        TextUtils.isEmpty(adUnit.getDeeplinkUrl());
    }

    protected String a(PackageManager pm, PackageInfo info) {
        if (pm != null && info != null) {
            try {
                return String.valueOf(pm.getApplicationLabel(info.applicationInfo));
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        PackageInfo packageInfo;
        BaseAdUnit baseAdUnit;
        BaseAdUnit baseAdUnit2;
        try {
            PackageManager packageManager = context.getPackageManager();
            Uri data = intent.getData();
            String action = intent.getAction();
            if (data != null && action != null) {
                String schemeSpecificPart = data.getSchemeSpecificPart();
                SigmobLog.d(String.format("onReceive: packageName = %s, action = %s", schemeSpecificPart, action));
                boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
                String strEncodeToString = Base64.encodeToString(action.getBytes(), 2);
                if (!strEncodeToString.equals(n.H) || booleanExtra) {
                    if (!com.sigmob.sdk.base.i.a().i() || o.a().T()) {
                        packageInfo = null;
                    } else {
                        packageInfo = packageManager.getPackageInfo(schemeSpecificPart, 0);
                        try {
                            ac.a(packageInfo, 1);
                        } catch (Exception unused) {
                        }
                    }
                    if (TextUtils.isEmpty(schemeSpecificPart)) {
                        baseAdUnit = null;
                    } else {
                        String absolutePath = new File(i.g(), schemeSpecificPart + ".log").getAbsolutePath();
                        Object fromCache = FileUtil.readFromCache(absolutePath);
                        if (fromCache == null || !(fromCache instanceof BaseAdUnit)) {
                            baseAdUnit2 = null;
                        } else {
                            baseAdUnit2 = (BaseAdUnit) fromCache;
                            BaseAdUnit baseAdUnitC = com.sigmob.sdk.base.common.g.c(baseAdUnit2.getUuid());
                            if (baseAdUnitC != null) {
                                baseAdUnit2 = baseAdUnitC;
                            }
                        }
                        FileUtil.deleteFile(absolutePath);
                        baseAdUnit = baseAdUnit2;
                    }
                    if (baseAdUnit == null) {
                        return;
                    }
                    String appName = baseAdUnit.getAppName();
                    if (TextUtils.isEmpty(appName)) {
                        String strA = a(packageManager, packageInfo);
                        if (!TextUtils.isEmpty(strA)) {
                            schemeSpecificPart = strA;
                        }
                        appName = schemeSpecificPart;
                    }
                    char c = 65535;
                    switch (strEncodeToString.hashCode()) {
                        case -1380358613:
                            if (strEncodeToString.equals(n.J)) {
                                c = 2;
                                break;
                            }
                            break;
                        case -248756734:
                            if (strEncodeToString.equals(n.H)) {
                                c = 1;
                                break;
                            }
                            break;
                        case 1293128098:
                            if (strEncodeToString.equals(n.I)) {
                                c = 0;
                                break;
                            }
                            break;
                        case 1931663641:
                            if (strEncodeToString.equals(n.L)) {
                                c = 3;
                                break;
                            }
                            break;
                    }
                    if (c != 0) {
                        if (c != 1) {
                            if (c != 2) {
                                if (c != 3) {
                                    return;
                                }
                                if (n.f.booleanValue()) {
                                    ai.a(context, appName + " 安装失败", 0).show();
                                }
                                ac.a(baseAdUnit, PointCategory.APP_INSTALL_END, packageInfo, WindAdError.ERROR_SIGMOB_INSTALL_FAIL + ",System");
                                ac.a(PointCategory.APP_INSTALL_END, WindAdError.ERROR_SIGMOB_INSTALL_FAIL.getErrorCode(), "system", baseAdUnit);
                                HashMap map = new HashMap();
                                map.put("result", "0");
                                BaseBroadcastReceiver.a(context, baseAdUnit.getUuid(), map, IntentActions.ACTION_INTERSTITIAL_INSTALL_END);
                                return;
                            }
                            if (n.f.booleanValue()) {
                                ai.a(context, appName + " 替换成功", 1).show();
                            }
                        } else {
                            if (!booleanExtra) {
                                if (n.f.booleanValue()) {
                                    ai.a(context, appName + " 卸载成功", 1).show();
                                    return;
                                }
                                return;
                            }
                            ai.a(context, appName + " 替换成功", 1).show();
                        }
                    } else if (n.f.booleanValue()) {
                        ai.a(context, appName + " 安装成功", 1).show();
                    }
                    a(context, baseAdUnit, packageInfo);
                    return;
                }
                return;
            }
            SigmobLog.e("data or action is null");
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }
}
