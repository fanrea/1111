package com.alliance.ssp.ad.manager.applist;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Base64;
import android.util.Log;
import com.alipay.sdk.m.u.n;
import com.alliance.ssp.ad.a.a;
import com.alliance.ssp.ad.d0.f;
import com.alliance.ssp.ad.manager.applist.bean.InitConfigBean;
import com.alliance.ssp.ad.o0.i;
import com.alliance.ssp.ad.o0.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class InitConfigManager {
    public static List<String> f = new ArrayList<String>() { // from class: com.alliance.ssp.ad.manager.applist.InitConfigManager.1
        {
            add("com.sankuai.meituan");
            add("com.xunmeng.pinduoduo");
            add("com.sankuai.meituan.takeoutnew");
            add("com.jingdong.app.mall");
            add("com.smile.gifmaker");
            add("com.kuaishou.nebula");
            add(n.b);
            add("com.ss.android.ugc.aweme.lite");
            add("com.ss.android.ugc.aweme");
            add("com.taobao.taobao");
            add("com.jd.jrapp");
            add("com.baidu.searchbox");
            add("com.xingin.xhs");
            add("ctrip.android.view");
        }
    };
    public static final InitConfigManager g = new InitConfigManager();
    public SharedPreferences a;
    public SharedPreferences.Editor b;
    public Context c;
    public InitConfigBean d;
    public boolean e = false;

    public static void a(String str, Exception exc) throws JSONException, PackageManager.NameNotFoundException, IOException {
        new f().a(0, 0, "004", a.a(exc, new StringBuilder().append("NMNativeFeedAdImpl ").append(str)), exc);
    }

    public static String b(String str) {
        if (!a(str)) {
            return "";
        }
        try {
            byte[] bArrEncode = Base64.encode(str.getBytes("UTF-8"), 0);
            return bArrEncode == null ? "" : new String(bArrEncode, "UTF-8");
        } catch (Exception e) {
            Log.e("SAAppListManager", "encryptBase64: ", e);
            return "";
        }
    }

    public final void c(String str) throws JSONException, PackageManager.NameNotFoundException, IOException {
        long j = this.a.getLong("yt_sdk_2_last_report_list_time", 0L);
        if (j > 0 && i.a(j)) {
            int i = l.a;
        } else if (a(str)) {
            int i2 = l.a;
            new f().a(2, 0, str, (String) null);
            this.b.putLong("yt_sdk_2_last_report_list_time", System.currentTimeMillis());
            this.b.apply();
        }
    }

    public static boolean a(String... strArr) {
        for (String str : strArr) {
            if (str == null || str.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @SafeVarargs
    public static boolean a(List<String>... listArr) {
        for (List<String> list : listArr) {
            if (list == null || list.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static String a(String str) {
        if (!a(str)) {
            return "";
        }
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            return bArrDecode == null ? "" : new String(bArrDecode, "UTF-8");
        } catch (Exception e) {
            Log.e("SAAppListManager", "decryptBase64: ", e);
            return "";
        }
    }
}
