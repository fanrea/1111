package com.bytedance.bdtracker;

import android.content.Context;
import com.pandora.common.Constants;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class y1 extends l1 {
    public final Context e;

    public y1(Context context) {
        super(true, true);
        this.e = context;
    }

    @Override // com.bytedance.bdtracker.l1
    public String a() {
        return "Locale";
    }

    @Override // com.bytedance.bdtracker.l1
    public boolean a(JSONObject jSONObject) throws JSONException {
        s1.a(jSONObject, "language", this.e.getResources().getConfiguration().locale.getLanguage());
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            rawOffset = 12;
        }
        jSONObject.put("timezone", rawOffset);
        s1.a(jSONObject, Constants.APPLog.APP_REGION, Locale.getDefault().getCountry());
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        s1.a(jSONObject, "tz_name", timeZone.getID());
        jSONObject.put("tz_offset", timeZone.getOffset(System.currentTimeMillis()) / 1000);
        return true;
    }
}
