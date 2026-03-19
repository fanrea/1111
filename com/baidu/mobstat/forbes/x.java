package com.baidu.mobstat.forbes;

import android.app.Activity;
import android.graphics.PointF;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobads.sdk.internal.cm;
import com.baidu.mobstat.forbes.af;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class x implements af.b {
    /* JADX WARN: Code restructure failed: missing block: B:37:0x01de, code lost:
    
        r15.put(com.baidu.mobstat.forbes.Config.EVENT_SDK_NAME, 2);
        r15.put(com.baidu.mobstat.forbes.Config.EVENT_LOGO_PROD, 1);
     */
    @Override // com.baidu.mobstat.forbes.af.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.view.View r31, boolean r32, android.app.Activity r33) throws org.json.JSONException, android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 751
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.forbes.x.a(android.view.View, boolean, android.app.Activity):void");
    }

    private JSONObject a(Activity activity, View view, PointF pointF) throws JSONException {
        if (pointF == null) {
            return null;
        }
        view.getLocationOnScreen(new int[2]);
        float f = pointF.x - r1[0];
        float f2 = pointF.y - r1[1];
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        float fB = d.b(activity, f);
        float fB2 = d.b(activity, f2);
        float fA = d.a(activity, ae.o(view));
        float fA2 = d.a(activity, ae.p(view));
        if (fA == 0.0f || fA2 == 0.0f) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            DecimalFormat decimalFormat = new DecimalFormat(cm.d);
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
            decimalFormatSymbols.setDecimalSeparator('.');
            decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
            jSONObject.put("x", decimalFormat.format(fB));
            jSONObject.put("y", decimalFormat.format(fB2));
            jSONObject.put(Config.EVENT_HEAT_XP, decimalFormat.format((fB * 100.0f) / fA));
            jSONObject.put(Config.EVENT_HEAT_YP, decimalFormat.format((fB2 * 100.0f) / fA2));
        } catch (Exception e) {
        }
        return jSONObject;
    }

    private String a(Activity activity, View view) {
        View viewA;
        View viewN;
        if (activity == null || view == null || (viewN = ae.n((viewA = ae.a(view, activity)))) == null) {
            return "";
        }
        String strA = n.a().a(activity, viewA, viewN);
        if (TextUtils.isEmpty(strA)) {
            return "";
        }
        return strA;
    }
}
