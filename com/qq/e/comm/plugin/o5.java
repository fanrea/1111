package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.qq.e.comm.pi.ACTD;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class o5 {
    public static boolean b(h4 h4Var, String str) {
        return a(str, h4Var, 3);
    }

    public static boolean a(String str, h4 h4Var) throws JSONException {
        f5 f5VarA = f5.a(h4Var);
        long jH0 = h4Var.h0();
        boolean zA = a30.a(str, h4Var.x());
        try {
            qn.a(4003033, zA, 1, f5VarA, jH0);
            return a(str, h4Var, 2);
        } catch (Exception unused) {
            qn.a(4003035, zA, 1, f5VarA, jH0);
            return false;
        }
    }

    public static boolean b(String str, h4 h4Var) {
        return a(str, h4Var, 0);
    }

    public static boolean a(h4 h4Var, String str) {
        return a(str, h4Var, 1);
    }

    public static boolean a(String str) {
        return a(str, null, 0);
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.addFlags(268435456);
        Context contextA = r1.d().a();
        if (intent.resolveActivity(contextA.getPackageManager()) == null) {
            intent.toString();
            return false;
        }
        contextA.startActivity(intent);
        return true;
    }

    private static boolean a(String str, h4 h4Var, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Context contextA = r1.d().a();
        Intent intent = new Intent();
        intent.setClassName(contextA, wx.a());
        intent.putExtra(ACTD.DELEGATE_NAME_KEY, wm.INNER_BROWSER);
        intent.putExtra("url", str);
        intent.putExtra("appid", r1.d().b().a());
        intent.putExtra("web_page_type", i);
        if (h4Var != null) {
            intent.putExtra("objectId", h4Var.s0());
            ((k1) zm.a(h4Var.s0(), k1.class)).a(h4Var);
            intent.putExtra("landingPageStartTime", h4Var.h0());
            intent.putExtra("posId", h4Var.y0());
            intent.putExtra("adType", h4Var.k().e());
        }
        intent.addFlags(268435456);
        i20.a().c(3).a();
        try {
            contextA.startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
