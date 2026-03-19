package com.baidu.mobads.upgrade.remote.mtj;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.IDManager;
import com.baidu.mobads.container.util.ap;
import com.baidu.mobads.container.util.b;
import com.baidu.mobads.container.util.bl;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.f.z;
import com.baidu.mobads.container.util.x;
import com.baidu.mobstat.forbes.PermissionEnum;
import com.baidu.mobstat.forbes.StatService;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    private static a c = null;
    private static final String d = "@mobads$";
    private static String b = a.class.getSimpleName();
    public static Boolean a = false;

    public static a a() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    private a() {
        bq.a().a(b, "create MTJUtils");
    }

    public void a(Context context) {
        if (context == null || x.a(context).a() <= 21) {
            return;
        }
        try {
            Context applicationContext = context.getApplicationContext();
            boolean zD = b.a().d(applicationContext);
            boolean zE = b.a().e(applicationContext);
            if (!zD && !zE) {
                bq.a().a(b, "MTJUtils  MTJ Switch all false");
                return;
            }
            StatService.setOn(applicationContext, 16);
            if (a.booleanValue()) {
                bq.a().a(b, "MTJUtils already init");
                return;
            }
            bq.a().a(b, "MTJUtils do init ");
            a = true;
            StatService.setDebugOn(false);
            String packageName = applicationContext.getPackageName();
            String strA = ap.a(packageName + d);
            bq.a().a(b, packageName + ", generator AppKEY : " + strA);
            StatService.setAppKey(strA);
            String strL = DeviceUtils.getInstance().l(applicationContext);
            StatService.setOaid(applicationContext, z.a(applicationContext));
            StatService.setAppChannel(applicationContext, strL, true);
            String strA2 = IDManager.getInstance().a(applicationContext);
            if (TextUtils.isEmpty(StatService.getCuid(applicationContext)) && !TextUtils.isEmpty(strA2)) {
                StatService.setCuid(strA2);
            }
            StatService.setCollectTitleMaxLevel(b.a().f(applicationContext));
            StatService.setAndroidVersion(x.a(applicationContext).a());
            StatService.initLogSenderHandler();
            StatService.setFullPointDistinguishLogo(com.baidu.mobads.container.h.a.a().w() ? 1 : 0);
            StatService.setUseNullAccessibilityDelegate(com.baidu.mobads.container.h.a.a().x() ? 1 : 0);
            StatService.setActivityContentSwitch(com.baidu.mobads.container.h.a.a().y() ? 1 : 0);
            String strZ = com.baidu.mobads.container.h.a.a().z();
            if (!TextUtils.isEmpty(strZ)) {
                StatService.setActivityExposureString(strZ);
            }
            ArrayList arrayList = new ArrayList();
            if (bl.a("permission_app_list")) {
                arrayList.add(PermissionEnum.APP_LIST);
            }
            if (com.baidu.mobads.container.h.a.a().f()) {
                arrayList.add(PermissionEnum.LOCATION);
            }
            if (bl.a("permission_storage")) {
                arrayList.add(PermissionEnum.STORAGE);
            }
            StatService.setPermissionList(arrayList);
            StatService.setOtherId(applicationContext, "v9.27");
            if (zE) {
                StatService.autoTrace(applicationContext, true, true);
            } else {
                StatService.autoTrace(applicationContext);
            }
        } catch (Exception e) {
            bq.a().c(e);
        } catch (Throwable th) {
            bq.a().c(th);
        }
    }

    public void a(Context context, Map<String, String> map) {
        if (b.a().d(context) && a.booleanValue() && map != null && map.containsKey("cuid") && TextUtils.isEmpty(StatService.getCuid(context))) {
            StatService.setCuid(map.get("cuid"));
        }
    }

    public void b() {
        StatService.closeTrace();
    }

    public void a(JSONObject jSONObject) {
        StatService.saveBqtLog(jSONObject);
    }
}
