package com.kwad.components.core.g;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.WindowManager;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.l.a.d;
import com.kwad.sdk.live.audience.KSLiveNetwork;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.bs;
import com.kwad.sdk.utils.r;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.sdk.commercial.c.a {
    public int RV;
    public boolean RW;
    public boolean RX;
    public boolean RZ;
    public String Sa;
    public boolean Sb;
    public long Sd;
    public double Se;
    public boolean Sf;
    public List<String> Sg;
    public double Sh;
    public int Si;
    public int Sj;
    public int Sk;
    public int Sl;
    public int defaultType;
    public int RY = -1;
    public int Sc = -1;
    private boolean Sm = false;
    private boolean Sn = false;
    private boolean So = false;
    private Context mContext = ServiceProvider.anu();

    private b() {
    }

    public static b qr() {
        b bVar = new b();
        bVar.RV = bs.eJ(bVar.mContext);
        bVar.Sa = ap(bVar.mContext);
        bVar.RY = as(bVar.mContext);
        bVar.Sb = qs();
        bVar.Sc = SystemUtil.eI(bVar.mContext);
        bVar.Sd = bs.eK(bVar.mContext);
        bVar.Se = SystemUtil.eH(bVar.mContext);
        bVar.Sl = aq(bVar.mContext);
        bVar.Sj = getScreenHeight(bVar.mContext);
        bVar.Sk = getScreenWidth(bVar.mContext);
        a(bVar);
        bVar.defaultType = 1;
        return bVar;
    }

    private static void a(b bVar) {
        try {
            String strZf = e.Zf();
            if (TextUtils.isEmpty(strZf)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strZf);
            if (jSONObject.optBoolean("enableSlidingTrajectory", false)) {
                Pair<List<String>, Double> pairWW = com.kwad.sdk.core.e.WW();
                bVar.Sg = (List) pairWW.first;
                bVar.Sh = ((Double) pairWW.second).doubleValue();
                bVar.Sm = true;
            }
            if (jSONObject.optBoolean("enableAccessibility", false)) {
                bVar.RW = ((Boolean) bs.eW(bVar.mContext).first).booleanValue();
                bVar.RX = ((Boolean) bs.eW(bVar.mContext).second).booleanValue();
                bVar.Sn = true;
            }
            if (jSONObject.optBoolean("enableKeyguardSecure", false)) {
                bVar.Sf = ar(bVar.mContext);
                bVar.So = true;
            }
        } catch (Throwable th) {
            c.printStackTrace(th);
        }
    }

    private static String ap(Context context) {
        int iD = ao.d(context, be.el(context), bd.useNetworkStateDisable());
        return iD != 1 ? iD != 2 ? iD != 3 ? "unknown" : KSLiveNetwork.LIANTONG_OPERATOR_NAME : KSLiveNetwork.DIANXIN_OPERATOR_NAME : KSLiveNetwork.YIDONG_OPERATOR_NAME;
    }

    private static int getScreenWidth(Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    private static int getScreenHeight(Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    private static int aq(Context context) {
        if (context == null) {
            return -1;
        }
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    private static boolean ar(Context context) {
        try {
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (keyguardManager != null) {
                return keyguardManager.isKeyguardSecure();
            }
            return false;
        } catch (Throwable th) {
            c.printStackTrace(th);
            return false;
        }
    }

    private static boolean qs() {
        d dVarAnV = r.anV();
        return dVarAnV != null && dVarAnV.cjy == 1;
    }

    public final b aE(boolean z) {
        this.RZ = z;
        return this;
    }

    public final b aN(int i) {
        this.Si = i;
        return this;
    }

    private static int as(Context context) {
        if (e.aH(512L)) {
            return -1;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, intentFilter);
            if (intentRegisterReceiver == null) {
                return -1;
            }
            int intExtra = intentRegisterReceiver.getIntExtra("plugged", -1);
            if (intExtra == 2) {
                return 2;
            }
            if (intExtra == 1) {
                return 1;
            }
            if (intExtra == 4) {
                return 4;
            }
            return intExtra == 0 ? 0 : -1;
        } catch (Exception e) {
            c.printStackTrace(e);
            return -1;
        }
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        return b(this);
    }

    private static JSONObject b(b bVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            aa.putValue(jSONObject, "c_batterylevel", bVar.RV);
            aa.putValue(jSONObject, "c_charging", bVar.RY);
            aa.putValue(jSONObject, "is_cheat_user", bVar.RZ);
            aa.putValue(jSONObject, "c_operator", bVar.Sa);
            aa.putValue(jSONObject, "t_root", bVar.Sb);
            aa.putValue(jSONObject, "c_screenlight", bVar.Sc);
            aa.putValue(jSONObject, "c_total_memory", bVar.Sd);
            aa.putValue(jSONObject, "c_volume", bVar.Se);
            aa.putValue(jSONObject, "c_screen_height", bVar.Sj);
            aa.putValue(jSONObject, "c_screen_width", bVar.Sk);
            aa.putValue(jSONObject, "density_dpi", bVar.Sl);
            aa.putValue(jSONObject, "default_type", bVar.defaultType);
            if (bVar.Sm) {
                if (!bVar.Sg.isEmpty()) {
                    aa.putValue(jSONObject, "s_origin_points", bVar.Sg);
                }
                double d = bVar.Sh;
                if (d != 0.0d) {
                    aa.putValue(jSONObject, "s_swipe_max_curvature", d);
                }
            }
            if (bVar.Sn) {
                aa.putValue(jSONObject, "t_accessibility_enabled", bVar.RW);
                aa.putValue(jSONObject, "t_accessibility_service_existed", bVar.RX);
            }
            if (bVar.So) {
                aa.putValue(jSONObject, "t_is_keyguard_secure", bVar.Sf);
            }
        } catch (Throwable th) {
            c.printStackTrace(th);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        a(this, jSONObject);
    }

    private static void a(b bVar, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                bVar.RV = jSONObject.optInt("c_batterylevel");
                bVar.RW = jSONObject.optBoolean("t_accessibility_enabled");
                bVar.RX = jSONObject.optBoolean("t_accessibility_service_existed");
                bVar.RY = jSONObject.optInt("c_charging");
                bVar.RZ = jSONObject.optBoolean("is_cheat_user");
                bVar.Sa = jSONObject.optString("c_operator");
                bVar.Sb = jSONObject.optBoolean("t_root");
                bVar.Sc = jSONObject.optInt("c_screenlight");
                bVar.Sd = jSONObject.optLong("c_total_memory");
                bVar.Se = jSONObject.optDouble("c_volume");
                bVar.Sf = jSONObject.optBoolean("t_is_keyguard_secure");
                bVar.Sg = aa.h(jSONObject.optJSONArray("s_origin_points"));
                bVar.Sh = jSONObject.optDouble("s_swipe_max_curvature");
                bVar.Sl = jSONObject.optInt("density_dpi");
                bVar.Sj = jSONObject.optInt("c_screen_height");
                bVar.Sk = jSONObject.optInt("c_screen_width");
                bVar.defaultType = jSONObject.optInt("default_type");
            } catch (Throwable th) {
                c.printStackTrace(th);
            }
        }
    }
}
