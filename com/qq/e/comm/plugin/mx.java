package com.qq.e.comm.plugin;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.pandora.common.Constants;
import com.sigmob.sdk.base.mta.PointCategory;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class mx {
    public static JSONObject b(qa qaVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (qaVar != null) {
            jSONObject.putOpt(Constants.APPLog.DEVICE_ID, qaVar.j());
            jSONObject.putOpt(LiveConfigKey.MEDIUM, qaVar.j);
            jSONObject.putOpt("lg", qaVar.m());
            jSONObject.putOpt("w", Integer.valueOf(qaVar.k()));
            jSONObject.putOpt("h", Integer.valueOf(qaVar.i()));
            jSONObject.putOpt(Config.DEVICE_ID_SEC, Integer.valueOf(qaVar.h()));
            jSONObject.putOpt("apil", Integer.valueOf(qaVar.t()));
            jSONObject.putOpt("os", "android");
            jSONObject.putOpt(Config.OPERATOR, qaVar.q());
            jSONObject.putOpt("mf", Build.MANUFACTURER);
            c20.a(jSONObject, "/launch");
        }
        return jSONObject;
    }

    public static JSONObject a(b0 b0Var) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (b0Var != null) {
            jSONObject.putOpt(com.alipay.sdk.m.s.a.u, b0Var.b());
            jSONObject.putOpt(com.alipay.sdk.m.s.a.r, b0Var.a());
            jSONObject.putOpt("appv", b0Var.d());
            jSONObject.putOpt("appn", b0Var.c());
        }
        return jSONObject;
    }

    public static JSONObject a(vx vxVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (vxVar != null) {
            jSONObject.putOpt("suid", vxVar.e());
            jSONObject.putOpt(com.baidu.mobads.container.components.h.b.e.a, vxVar.d());
        }
        return jSONObject;
    }

    public static JSONObject a(qa qaVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (qaVar != null) {
            jSONObject.putOpt("so", qaVar.s());
            jSONObject.putOpt(Config.DEVICE_NAME, qaVar.g());
            String strC = as.c();
            if (!TextUtils.isEmpty(strC)) {
                jSONObject.putOpt("cell_native", strC);
            }
        }
        return jSONObject;
    }

    public static JSONObject a(vx vxVar, hu huVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (vxVar != null) {
            jSONObject.putOpt(PointCategory.APP, vxVar.a());
            jSONObject.putOpt("sdk", vxVar.b());
        }
        if (huVar != null) {
            jSONObject.putOpt(com.sigmob.sdk.archives.d.d, huVar.a());
            jSONObject.putOpt(ILogConst.Keys.KEY_PLUGIN_VERSION, Integer.valueOf(huVar.b()));
        }
        return jSONObject;
    }

    public static JSONObject a() throws JSONException {
        r1 r1VarD = r1.d();
        JSONObject jSONObjectA = a(r1VarD.f());
        jSONObjectA.put(PointCategory.APP, a(r1VarD.b()));
        jSONObjectA.put("c", a(r1VarD.c()));
        jSONObjectA.put("sdk", a(r1VarD.e()));
        return jSONObjectA;
    }

    public static JSONObject a(hu huVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("sdkv", su.i());
        jSONObject.putOpt("pv", Integer.valueOf(huVar.b()));
        jSONObject.putOpt("sdk_st", Integer.valueOf(su.g()));
        jSONObject.putOpt("sdk_cnl", Integer.valueOf(su.d()));
        if (!TextUtils.isEmpty(su.e())) {
            jSONObject.putOpt("sdk_ex1", su.e());
        }
        if (!TextUtils.isEmpty(su.f())) {
            jSONObject.putOpt("sdk_ex2", su.f());
        }
        return jSONObject;
    }
}
