package lkxssdk.l;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import com.lingku.xuanshang.core.ui.base.BaseActivity;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class d extends Thread {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ e b;

    public class a implements Runnable {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            lkxssdk.h0.c.a("thirds apps:" + this.a);
            d.this.b.b.b(this.a);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.b.b.b("");
        }
    }

    public d(e eVar, boolean z) {
        this.b = eVar;
        this.a = z;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, UnsupportedEncodingException, InvocationTargetException {
        super.run();
        e eVar = this.b;
        Application applicationD = lkxssdk.a.a.d();
        eVar.getClass();
        HashMap map = new HashMap();
        PackageManager packageManager = applicationD.getPackageManager();
        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
        int i = 0;
        while (true) {
            String str = "";
            if (i >= installedPackages.size()) {
                break;
            }
            PackageInfo packageInfo = installedPackages.get(i);
            if (packageManager.getLaunchIntentForPackage(packageInfo.applicationInfo.packageName) != null || (packageInfo.applicationInfo.flags & 1) == 0) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if ((applicationInfo.flags & 1) == 0) {
                    String strTrim = ((String) applicationInfo.loadLabel(packageManager)).trim();
                    if (!TextUtils.isEmpty(strTrim)) {
                        try {
                            str = new String(Base64.encode(strTrim.getBytes(), 2), "UTF-8");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                    map.put(packageInfo.applicationInfo.packageName, str);
                }
            }
            i++;
        }
        String strA = lkxssdk.a0.c.a(map.toString());
        String string = lkxssdk.l0.d.a().b.getSharedPreferences("FCLibSetting", 0).getString("app_md5s", "");
        if (!this.a && !TextUtils.isEmpty(string) && strA.equals(string)) {
            this.b.a.runOnUiThread(new b());
            return;
        }
        BaseActivity baseActivity = this.b.a;
        if (baseActivity != null && !baseActivity.isFinishing()) {
            this.b.a.runOnUiThread(new a(lkxssdk.a.a.d(new JSONObject(map).toString())));
        }
        SharedPreferences.Editor editorEdit = lkxssdk.l0.d.a().b.getSharedPreferences("FCLibSetting", 0).edit();
        editorEdit.putString("app_md5s", strA);
        editorEdit.commit();
    }
}
