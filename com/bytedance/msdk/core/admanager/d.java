package com.bytedance.msdk.core.admanager;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.SplashAd;
import com.bytedance.msdk.an.hc.hc;
import com.bytedance.msdk.d.d.c;
import com.bytedance.msdk.d.u.b;
import com.bytedance.sdk.component.utils.mq;
import com.kwad.sdk.api.model.AdnName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static final ArrayList<String> b;
    private static final ArrayList<String> c;
    private static final ArrayList<C0232d> d = new ArrayList<>();
    private static final String[] hc;

    /* renamed from: com.bytedance.msdk.core.admanager.d$d, reason: collision with other inner class name */
    private static class C0232d {
        String b;
        String d;
        int hc;

        C0232d(String str, int i, String str2) {
            this.d = str;
            this.hc = i;
            this.b = str2;
        }
    }

    static {
        String[] strArr = {"TTTransparentActivity", "openadsdk", "com.bykv", "com.qq", "com.kwad", AdnName.BAIDU, "mbridge", "sigmob", "unity", "klevin"};
        hc = strArr;
        b = new ArrayList<>(Arrays.asList(strArr));
        c = new ArrayList<>();
    }

    public static boolean d(String str, int i, int i2) {
        ArrayList<C0232d> arrayList = d;
        if (arrayList.size() <= 0) {
            return TextUtils.equals(AdnName.BAIDU, str);
        }
        Iterator<C0232d> it = arrayList.iterator();
        while (it.hasNext()) {
            C0232d next = it.next();
            if (next != null && TextUtils.equals(next.d, str) && i2 == next.hc) {
                String str2 = next.b;
                c cVarD = hc.d().d(str);
                String strHc = cVarD != null ? cVarD.hc() : null;
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(strHc)) {
                    if (str2.startsWith("<=")) {
                        return d(strHc, str2);
                    }
                    if (str2.startsWith(">=")) {
                        return hc(strHc, str2);
                    }
                }
            }
        }
        return false;
    }

    private static boolean d(String str, String str2) {
        return b(str, str2) <= 0;
    }

    private static boolean hc(String str, String str2) {
        return b(str, str2) >= 0;
    }

    private static int b(String str, String str2) {
        String strSubstring = str2.substring(2);
        if (str.startsWith("v") || str.startsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
            str = str.substring(1);
        }
        return str.compareTo(strSubstring);
    }

    public static void d(String str) {
        ArrayList<String> arrayList;
        List listAsList;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            try {
                JSONObject jSONObject = new JSONObject(str);
                b.clear();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("act_str");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        String strOptString = jSONArrayOptJSONArray.optString(i);
                        if (!TextUtils.isEmpty(strOptString)) {
                            b.add(strOptString);
                        }
                    }
                }
                c.clear();
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("not_act_str");
                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                        String strOptString2 = jSONArrayOptJSONArray2.optString(i2);
                        if (!TextUtils.isEmpty(strOptString2)) {
                            c.add(strOptString2);
                        }
                    }
                }
                d.clear();
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("not_support");
                if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray3.optJSONObject(i3);
                        if (jSONObjectOptJSONObject != null) {
                            d.add(new C0232d(jSONObjectOptJSONObject.optString(SplashAd.KEY_BIDFAIL_ADN), jSONObjectOptJSONObject.optInt("subtype"), jSONObjectOptJSONObject.optString("versions")));
                        }
                    }
                }
                arrayList = b;
                listAsList = Arrays.asList(hc);
            } catch (JSONException e) {
                mq.d(e);
                arrayList = b;
                listAsList = Arrays.asList(hc);
            }
            arrayList.addAll(listAsList);
        } catch (Throwable th) {
            b.addAll(Arrays.asList(hc));
            throw th;
        }
    }

    public static boolean hc(String str) {
        b.hc("TTMediationSDK", "--==--- activityStr: ".concat(String.valueOf(str)));
        Iterator<String> it = b.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return b(str);
            }
        }
        return false;
    }

    private static boolean b(String str) {
        ArrayList<String> arrayList = c;
        if (arrayList.size() == 0) {
            return true;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return false;
            }
        }
        return true;
    }
}
