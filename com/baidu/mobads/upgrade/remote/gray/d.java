package com.baidu.mobads.upgrade.remote.gray;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.g;
import com.baidu.mobads.container.components.e.b;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.IDManager;
import com.baidu.mobads.container.util.SPUtils;
import com.baidu.mobads.container.util.bk;
import com.baidu.mobads.container.util.bl;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.container.util.cm;
import com.baidu.mobads.container.util.f.z;
import com.baidu.mobads.container.util.s;
import com.baidu.mobads.container.util.t;
import com.baidu.mobads.container.util.u;
import com.baidu.mobads.container.util.x;
import com.baidu.mobads.container.w.b.d;
import com.baidu.mobads.container.w.b.h;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.jar.JarFile;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d implements Observer {
    private static final String b = "https://mobads.baidu.com/ads/pa/8/gray/__pasys_remote_banner.php";
    private static final int c = 15;
    private Context e;
    private DynamicUpgradeInfo f;
    private a l;
    private static volatile d a = null;
    private static final String m = d.class.getName();
    private AtomicBoolean d = new AtomicBoolean(false);
    private String g = null;
    private String h = "baidu_sdk_remote";
    private String i = "__xadsdk__remote__final__";
    private String j = this.i + "downloaded__.jar";
    private String k = "remote_apk_gray_temp.jar";

    private d() {
    }

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    public void a(Context context) {
        if (this.d.get()) {
            return;
        }
        this.e = context;
        c();
        this.d.set(true);
        try {
            com.baidu.mobads.container.d.b.a().a(new e(this), 15L, TimeUnit.SECONDS);
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            d.a aVar = new d.a((Application) this.e.getApplicationContext());
            aVar.a(new h());
            aVar.a(new com.baidu.mobads.container.w.b.a());
            aVar.a(new f(this));
            com.baidu.mobads.container.w.b.d.a(aVar.a()).d();
        } catch (Throwable th) {
        }
    }

    private void c() {
        try {
            if (TextUtils.isEmpty(this.g)) {
                this.g = this.e.getDir(this.h, 0).getAbsolutePath() + "/";
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d() {
        return this.g + this.j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e() {
        return this.g + this.k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DynamicUpgradeInfo dynamicUpgradeInfo) {
        try {
            com.baidu.mobads.container.components.e.b bVarA = com.baidu.mobads.container.components.e.f.a(this.e).a(new URL(dynamicUpgradeInfo.b()), this.g, this.k, true);
            bVarA.addObserver(this);
            bVarA.d();
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> f() {
        HashMap<String, String> map = new HashMap<>();
        try {
            map.put("p_ver", com.baidu.mobads.container.f.c());
            map.put("v", "9.40");
            map.put("pk", t.f(this.e));
            map.put("appsid", DeviceUtils.getInstance().l(this.e));
            map.put("cuid", IDManager.getInstance().a(this.e));
            map.put("sn", DeviceUtils.getInstance().f(this.e));
            map.put("os", "android");
            map.put("osv", x.a(this.e).c());
            map.put("model", x.a(this.e).d());
            map.put("brand", DeviceUtils.getInstance().b());
            map.put("bdr", "" + x.a(this.e).a());
            map.put(c.l, z.a(this.e));
            map.put(c.m, "" + com.baidu.mobads.container.config.a.a().a(this.e));
        } catch (Throwable th) {
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, HashMap<String, String> map) {
        try {
            StringBuilder sb = new StringBuilder();
            if (map != null) {
                int i = 0;
                for (String str2 : map.keySet()) {
                    i++;
                    String str3 = map.get(str2);
                    if (i == 1) {
                        sb.append(str2).append("=").append(str3);
                    } else {
                        sb.append(com.alipay.sdk.m.s.a.n).append(str2).append("=").append(str3);
                    }
                }
            }
            return str + "?code2=" + u.a(sb.toString());
        } catch (Throwable th) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double a(String str) {
        JarFile jarFile = null;
        try {
            try {
                File file = new File(str);
                if (a(file)) {
                    JarFile jarFile2 = new JarFile(file);
                    try {
                        double d = Double.parseDouble(jarFile2.getManifest().getMainAttributes().getValue("Implementation-Version"));
                        if (d <= 0.0d) {
                            jarFile = jarFile2;
                        } else {
                            try {
                                jarFile2.close();
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                            return d;
                        }
                    } catch (Throwable th2) {
                        jarFile = jarFile2;
                        if (jarFile != null) {
                            jarFile.close();
                        }
                        return 0.0d;
                    }
                }
            } catch (Throwable th3) {
            }
            if (jarFile != null) {
                jarFile.close();
            }
        } catch (Throwable th4) {
            th4.printStackTrace();
        }
        return 0.0d;
    }

    private boolean a(File file) {
        if (file != null) {
            try {
                if (file.exists() && file.canRead()) {
                    return file.length() > 0;
                }
                return false;
            } catch (Throwable th) {
                return false;
            }
        }
        return false;
    }

    private void b(File file) {
        if (file != null) {
            try {
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable th) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        try {
            com.baidu.mobads.container.components.e.b bVar = (com.baidu.mobads.container.components.e.b) observable;
            if (bVar == null) {
                return;
            }
            String strB = this.f != null ? this.f.b() : "";
            File file = new File(this.g, this.k);
            if (!TextUtils.isEmpty(strB) && strB.equals(bVar.e())) {
                if (bVar.i() == b.a.COMPLETED) {
                    if (this.l != null && this.l.a()) {
                        File file2 = new File(d());
                        if (file.exists()) {
                            file.renameTo(file2);
                        }
                        return;
                    }
                    b(file);
                    return;
                }
                if (bVar.i() == b.a.ERROR) {
                    b(file);
                }
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        String str;
        int i;
        if (context != null) {
            try {
                if (context.getPackageManager() == null) {
                    return;
                }
                String strC = com.baidu.mobads.container.q.b.a().c();
                SPUtils sPUtils = new SPUtils(context);
                if (System.currentTimeMillis() - sPUtils.b("adn_find", 0L) < 86400000) {
                    return;
                }
                PackageInfo packageInfoA = bk.a(context, context.getPackageName(), 0);
                if (packageInfoA == null) {
                    str = "";
                    i = 0;
                } else {
                    i = packageInfoA.versionCode;
                    str = packageInfoA.versionName;
                }
                by.a aVarA = by.a.a(context).a(824).a("useHttpsConfig", com.baidu.mobads.container.h.a.a().e()).a("mediaHttpsConfig", com.baidu.mobads.container.config.b.a().d()).a("useLocationConfig", com.baidu.mobads.container.h.a.a().f()).a("mediaLocationConfig", bl.a(bl.a)).a("useImeiConfig", com.baidu.mobads.container.h.a.a().g()).a("mediaImeiConfig", bl.a(bl.d)).a("useCloseShakeConfig", com.baidu.mobads.container.h.a.a().h()).a("mediaCloseShakeConfig", com.baidu.mobads.container.config.a.a().f()).a("useOAIDConfig", com.baidu.mobads.container.h.a.a().i()).a(g.I, com.baidu.mobads.container.h.a.a().k()).a("num", com.baidu.mobads.container.util.b.a().b(context)).a("mediaOAIDConfig", bl.a(bl.e)).a("appVC", i).a("appVN", str).a("gmRS", s.a()).a("gmAS", s.a(context)).a("gmSS", com.baidu.mobads.container.config.a.a().h()).a("toRS", s.b()).a("toSS", com.baidu.mobads.container.config.a.a().i()).a("androidxRV", s.c()).a("androidxPlayer", s.e()).a("supportRV", s.d()).a("ir", t.c()).a("hs", "" + t.i(this.e)).a(cm.V, strC).a("maven_switch", false).a("dl_type", com.baidu.mobads.container.h.a.a().B()).a("duration", com.baidu.mobads.container.config.a.a().l());
                String strB = t.b();
                if (!TextUtils.isEmpty(strB)) {
                    aVarA.a("p_set", u.a(strB));
                }
                if (context.getApplicationContext() != null && context.getApplicationContext().getApplicationInfo() != null) {
                    aVarA.a("v_dur", "" + context.getApplicationContext().getApplicationInfo().targetSdkVersion);
                }
                aVarA.f();
                sPUtils.a("adn_find", System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
