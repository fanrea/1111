package com.bytedance.sdk.component.adexpress.dynamic.c;

import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.c.hc;
import com.bytedance.sdk.component.utils.mq;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mk {
    private static final Set<String> d = Collections.unmodifiableSet(new HashSet(Arrays.asList("dislike", "close", "close-fill", "webview-close")));
    private static String hc;

    /* JADX WARN: Removed duplicated region for block: B:218:0x0484  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0492 A[Catch: Exception -> 0x04a3, JSONException -> 0x04a8, TryCatch #2 {JSONException -> 0x04a8, blocks: (B:177:0x03a4, B:179:0x0404, B:181:0x0409, B:183:0x0411, B:191:0x0426, B:193:0x042d, B:195:0x0439, B:197:0x0441, B:200:0x0448, B:204:0x0452, B:210:0x0466, B:212:0x046e, B:214:0x0474, B:216:0x047c, B:228:0x04a3, B:219:0x0488, B:221:0x0492, B:226:0x049c, B:206:0x045b), top: B:276:0x03a4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bytedance.sdk.component.adexpress.dynamic.c.hc.b d(java.lang.String r20, java.lang.String r21, java.lang.String r22, boolean r23, boolean r24, int r25, com.bytedance.sdk.component.adexpress.dynamic.b.gb r26, double r27, int r29, double r30, java.lang.String r32, com.bytedance.sdk.component.adexpress.hc.uo r33) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 1361
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.c.mk.d(java.lang.String, java.lang.String, java.lang.String, boolean, boolean, int, com.bytedance.sdk.component.adexpress.dynamic.b.gb, double, int, double, java.lang.String, com.bytedance.sdk.component.adexpress.hc.uo):com.bytedance.sdk.component.adexpress.dynamic.c.hc$b");
    }

    public static String d(String str) {
        String[] strArrSplit;
        return (TextUtils.isEmpty(str) || (strArrSplit = str.split("adx:")) == null || strArrSplit.length < 2) ? "" : strArrSplit[1];
    }

    private static hc.b d(hc.b bVar, String str, String str2, String str3) {
        if (str.contains("union")) {
            bVar.d = 0.0f;
            bVar.hc = 0.0f;
        } else {
            if (TextUtils.isEmpty(str3)) {
                str3 = d(str);
            }
            if (TextUtils.isEmpty(str3)) {
                bVar.d = 0.0f;
                bVar.hc = 0.0f;
            } else {
                return d(str3, str2);
            }
        }
        return bVar;
    }

    public static hc.b d(String str, String str2) {
        return d(str, str2, false);
    }

    public static hc.b d(String str, String str2, boolean z) {
        hc.b bVar = new hc.b();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int[] iArrD = d(str, (float) hc(str2), z);
            bVar.d = iArrD[0];
            bVar.hc = iArrD[1];
            if (jSONObject.optDouble("lineHeight", 1.0d) == 0.0d) {
                bVar.hc = 0.0f;
            }
        } catch (Exception e) {
            mq.d(e);
        }
        return bVar;
    }

    public static double hc(String str) {
        try {
            return Double.parseDouble(new JSONObject(str).optString("fontSize"));
        } catch (Throwable unused) {
            return 0.0d;
        }
    }

    public static int[] d(String str, float f, boolean z) {
        int[] iArrHc = hc(str, f, z);
        return new int[]{com.bytedance.sdk.component.adexpress.c.gb.hc(com.bytedance.sdk.component.adexpress.c.getContext(), iArrHc[0]), com.bytedance.sdk.component.adexpress.c.gb.hc(com.bytedance.sdk.component.adexpress.c.getContext(), iArrHc[1])};
    }

    public static int[] hc(String str, float f, boolean z) {
        try {
            TextView textView = new TextView(com.bytedance.sdk.component.adexpress.c.getContext());
            textView.setTextSize(f);
            textView.setText(str);
            textView.setIncludeFontPadding(false);
            if (z) {
                textView.setSingleLine();
            }
            textView.measure(-2, -2);
            return new int[]{textView.getMeasuredWidth() + 2, textView.getMeasuredHeight() + 2};
        } catch (Exception unused) {
            return new int[]{0, 0};
        }
    }

    public static String d() {
        return hc;
    }

    public static boolean hc() {
        return !TextUtils.isEmpty(hc);
    }
}
