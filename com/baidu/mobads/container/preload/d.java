package com.baidu.mobads.container.preload;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.bu;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.container.util.d.d;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d {
    private static String a;
    private Context b;
    private String c = "preload";

    public void a(String str, Context context) {
        this.b = context;
        a = DeviceUtils.getInstance().l(context);
        if (!TextUtils.isEmpty(str)) {
            try {
                List<XAdMaterialsInfo> listA = XAdMaterialsInfo.a(new JSONObject(str).optJSONArray(this.c));
                if (listA != null && listA.size() != 0) {
                    for (int i = 0; i < listA.size(); i++) {
                        XAdMaterialsInfo xAdMaterialsInfo = listA.get(i);
                        if (xAdMaterialsInfo != null && a(xAdMaterialsInfo)) {
                            String strA = xAdMaterialsInfo.a();
                            if (!com.baidu.mobads.container.util.d.d.a(this.b).g(strA)) {
                                a(strA);
                            } else {
                                by.a = String.valueOf(System.currentTimeMillis());
                                by.b = String.valueOf(System.currentTimeMillis());
                                by.a(this.b, bu.aL, "material_has_loaded", strA);
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void a(String str) {
        try {
            com.baidu.mobads.container.util.d.d.a(this.b).a(str, (d.InterfaceC0136d<?>) new e(this));
        } catch (Exception e) {
        }
    }

    private boolean a(XAdMaterialsInfo xAdMaterialsInfo) {
        try {
            long j = Integer.parseInt(a(new Date()));
            long j2 = Integer.parseInt(xAdMaterialsInfo.c());
            if (xAdMaterialsInfo.b().equals(a) && j2 >= j) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private static String a(Date date) {
        return new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(date);
    }
}
