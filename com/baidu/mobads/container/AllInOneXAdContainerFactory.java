package com.baidu.mobads.container;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.mobads.container.l.g;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.IDManager;
import com.baidu.mobads.container.util.ba;
import com.baidu.mobads.container.util.bd;
import com.baidu.mobads.container.util.bl;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.cc;
import com.baidu.mobads.sdk.api.ICommonModuleObj;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class AllInOneXAdContainerFactory implements IXAdContainerFactory {
    public static final String TAG = "AllInOneXAdContainerFactory";
    public static final String TASK_MODULE_INIT_TIME = "sdk_init_time";
    private static final String a = "permission_module";
    private static final String b = "limitpersonalads_module";
    private static final String c = "clear_memory_cache";
    private Context d;
    private com.baidu.mobads.container.util.a e;
    private bd f;

    public AllInOneXAdContainerFactory(Context context) {
        this.d = context.getApplicationContext();
        try {
            com.baidu.mobads.container.util.x.a(this.d);
            com.baidu.mobads.container.config.b.a().a(this.d);
            IDManager.getInstance().a(this.d);
            if (this.d != null) {
                ba.b(this.d, h.k);
                ba.b(this.d, h.l);
                ba.b(this.d);
            }
        } catch (Throwable th) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IXAdContainerFactory
    public void initConfig(JSONObject jSONObject) {
        com.baidu.mobads.container.config.b.a().a(jSONObject);
        if (this.d != null) {
            com.baidu.mobads.container.config.b.a().b(this.d.getPackageName());
        }
        com.baidu.mobads.container.config.a.a().b(jSONObject.optBoolean(com.baidu.mobads.container.config.a.x));
        com.baidu.mobads.container.config.a.a().a(jSONObject.optBoolean(com.baidu.mobads.container.config.a.y));
        initDebugLog();
        com.baidu.mobads.container.config.a.a().c(jSONObject.optBoolean(com.baidu.mobads.container.config.a.u));
        com.baidu.mobads.container.config.a.a().d(jSONObject.optBoolean("sp_shake"));
        com.baidu.mobads.container.config.a.a().e(jSONObject.optString(com.baidu.mobads.container.config.a.w));
        com.baidu.mobads.container.config.a.a().d(jSONObject.optString(com.baidu.mobads.container.config.a.D, "-1"));
        com.baidu.mobads.container.config.a.a().c(jSONObject.optString(com.baidu.mobads.container.config.a.C, "-1"));
        a(jSONObject);
        if (jSONObject.length() > 1 && !TextUtils.isEmpty(DeviceUtils.getInstance().l(this.d))) {
            com.baidu.mobads.container.preload.b.a().a(this.d);
            com.baidu.mobads.container.y.j.a(this.d).a("");
            com.baidu.mobads.container.util.b.a.a(this.d).b(this.d);
            com.baidu.mobads.container.components.a.o.a().a(this.d);
            com.baidu.mobads.container.r.c.a(this.d);
            com.baidu.mobads.container.components.j.c.a().b();
            a();
            com.baidu.mobads.container.q.b.a().a(this.d);
            return;
        }
        com.baidu.mobads.container.l.g.b().e("检测到appsid为空：可能未初始化sdk或初始化时未传入appsid");
    }

    @Override // com.baidu.mobads.sdk.api.IXAdContainerFactory
    public double getRemoteVersion() {
        return j.b();
    }

    @Override // com.baidu.mobads.sdk.api.IXAdContainerFactory
    public Object getRemoteParam(String str, Object... objArr) {
        try {
            if ("encodedSn".equals(str)) {
                return DeviceUtils.getInstance().f((Context) objArr[0]);
            }
            if ("encodedCUID".equals(str)) {
                return DeviceUtils.getInstance().c((Context) objArr[0]);
            }
            if ("appsid".equals(str)) {
                return DeviceUtils.getInstance().l(this.d);
            }
            if ("appContext".equals(str)) {
                return com.baidu.mobads.container.config.b.a().c();
            }
            if ("baidu_cloudConfig".equals(str)) {
                return com.baidu.mobads.container.h.a.a().b((String) objArr[0]);
            }
            if ("appCommonConfig".equals(str)) {
                return com.baidu.mobads.container.config.a.a().g((String) objArr[0]);
            }
            if ("limitPersonalAds".equals(str)) {
                return Boolean.valueOf(com.baidu.mobads.container.util.az.a(this.d));
            }
            if ("get_cuid".equals(str)) {
                return IDManager.getInstance().a(this.d);
            }
            if ("get_imei".equals(str)) {
                return IDManager.getInstance().c(this.d);
            }
            if ("get_oaid".equals(str)) {
                return com.baidu.mobads.container.util.f.z.a(this.d);
            }
            if ("integrationInfo".equals(str)) {
                return Boolean.valueOf(cc.a(this.d, objArr));
            }
            if ("debugLogout".equals(str)) {
                return Boolean.valueOf(cc.b(this.d, objArr));
            }
            return null;
        } catch (Throwable th) {
            bq.a().a(TAG, th);
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.IXAdContainerFactory
    public void onTaskDistribute(String str, JSONObject jSONObject) {
        if ("permission_module".equals(str)) {
            bl.a(jSONObject);
            return;
        }
        if ("limitpersonalads_module".equals(str)) {
            if (jSONObject == null) {
                return;
            }
            try {
                com.baidu.mobads.container.util.az.a(this.d, jSONObject.optBoolean("permission_limitpersonalads"));
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if ("clear_memory_cache".equals(str)) {
            com.baidu.mobads.container.util.d.d.a(this.d).a();
            return;
        }
        if ("sdk_init_time".equals(str) && jSONObject != null) {
            String strOptString = jSONObject.optString("init_time", "");
            if ("-1".equals(com.baidu.mobads.container.config.a.a().l())) {
                com.baidu.mobads.container.config.a.a().f(strOptString);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.IXAdContainerFactory
    public void initCommonModuleObj(Object obj) {
        com.baidu.mobads.container.config.b.a().a((ICommonModuleObj) obj);
    }

    private void a(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject(com.baidu.mobads.container.components.command.j.g)) != null) {
            if (jSONObjectOptJSONObject.has(com.baidu.mobads.container.config.a.z)) {
                com.baidu.mobads.container.config.a.a().a(jSONObjectOptJSONObject.optString(com.baidu.mobads.container.config.a.z, "true"));
            }
            if (jSONObjectOptJSONObject.has(com.baidu.mobads.container.config.a.A)) {
                com.baidu.mobads.container.config.a.a().b(jSONObjectOptJSONObject.optString(com.baidu.mobads.container.config.a.A, "true"));
            }
        }
    }

    public static void initDebugLog() {
        closeDebugLog();
        if (h.b) {
            com.baidu.mobads.container.l.g.a((g.a) new com.baidu.mobads.container.l.e());
        } else if (com.baidu.mobads.container.config.a.a().c()) {
            com.baidu.mobads.container.l.g.a((g.a) new com.baidu.mobads.container.l.d());
        }
    }

    public static void closeDebugLog() {
        com.baidu.mobads.container.l.g.i("local");
        com.baidu.mobads.container.l.g.i("debug");
    }

    private void a() {
        if (!bl.a(bl.f)) {
            return;
        }
        try {
            a(this.d);
            b(this.d);
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.b(th);
        }
    }

    private void a(Context context) {
        if (com.baidu.mobads.container.h.a.a().B()) {
            if (this.e == null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
                intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                intentFilter.addDataScheme("package");
                this.e = new com.baidu.mobads.container.util.a();
                new com.component.c.b(context).a(this.e, intentFilter);
                return;
            }
            return;
        }
        if (this.e != null) {
            new com.component.c.b(context).a(this.e);
            this.e = null;
        }
    }

    private void b(Context context) {
        String strB = DeviceUtils.getInstance().b();
        if ("xiaomi".equalsIgnoreCase(strB) || "redmi".equalsIgnoreCase(strB)) {
            if (com.baidu.mobads.container.h.a.a().C()) {
                if (this.f == null) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(bd.a);
                    intentFilter.addAction(bd.b);
                    this.f = new bd();
                    new com.component.c.b(context).a(this.f, intentFilter);
                    return;
                }
                return;
            }
            if (this.f != null) {
                new com.component.c.b(context).a(this.f);
                this.f = null;
            }
        }
    }
}
