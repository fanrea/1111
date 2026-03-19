package com.bytedance.embedapplog;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class wl extends zw {
    wl() {
        super(true, false);
    }

    @Override // com.bytedance.embedapplog.zw
    protected boolean d(JSONObject jSONObject) throws JSONException {
        StringBuilder sb = new StringBuilder(16);
        if (d()) {
            sb.append("MIUI-");
        } else if (hc()) {
            sb.append("FLYME-");
        } else {
            String strD = tt.d();
            if (tt.d(strD)) {
                sb.append("EMUI-");
            }
            if (!TextUtils.isEmpty(strD)) {
                sb.append(strD).append("-");
            }
        }
        sb.append(Build.VERSION.INCREMENTAL);
        jSONObject.put(Config.ROM, sb.toString());
        return true;
    }

    private boolean d() {
        try {
            return Class.forName("miui.os.Build").getName().length() > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean hc() {
        return (!TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.contains("Flyme")) || "flyme".equals(Build.USER);
    }
}
