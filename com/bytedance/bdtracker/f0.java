package com.bytedance.bdtracker;

import com.baidu.mobads.container.rewardvideo.NativeRewardActivity;
import com.bytedance.applog.util.HardwareUtils;
import java.util.Collections;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class f0 {
    public final e0 a;

    public f0(e0 e0Var) {
        this.a = e0Var;
    }

    public void a(t3 t3Var) {
        try {
            JSONObject jSONObject = t3Var.o != null ? t3Var.o : new JSONObject();
            if (this.a.e.c.isScreenOrientationEnabled()) {
                jSONObject.put("$screen_orientation", HardwareUtils.getScreenOrientation(this.a.d.n) == 2 ? NativeRewardActivity.SCREEN_LANDSCAPE : NativeRewardActivity.SCREEN_PORTRAIT);
            }
            s sVar = this.a.d.B;
            if (sVar != null) {
                jSONObject.put("$longitude", sVar.a);
                jSONObject.put("$latitude", sVar.b);
                jSONObject.put("$geo_coordinate_system", sVar.c);
            }
            if (jSONObject.length() > 0) {
                t3Var.o = jSONObject;
            }
        } catch (Throwable th) {
            this.a.d.D.error(4, Collections.singletonList("LifeHook"), "Do beforeEventSave failed", th, new Object[0]);
        }
    }
}
