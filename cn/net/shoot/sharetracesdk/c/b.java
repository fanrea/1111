package cn.net.shoot.sharetracesdk.c;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.g;
import com.baidu.mobstat.forbes.Config;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b {
    public static b v;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public List<String> i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public Context t;
    public HashMap<String, String> u;

    public b() throws InterruptedException {
        Application applicationA = cn.net.shoot.sharetracesdk.f.a.c().a();
        this.t = applicationA;
        this.b = applicationA.getPackageName();
        this.d = String.valueOf(cn.net.shoot.sharetracesdk.a.a.f());
        this.a = "";
        this.c = cn.net.shoot.sharetracesdk.a.a.e();
        this.e = cn.net.shoot.sharetracesdk.b.a.d().b();
        this.r = cn.net.shoot.sharetracesdk.b.a.d().a();
        this.f = cn.net.shoot.sharetracesdk.a.a.a(this.t, "traceId");
        this.g = String.valueOf(cn.net.shoot.sharetracesdk.a.a.b(this.t));
        this.h = String.valueOf(cn.net.shoot.sharetracesdk.a.a.a(this.t));
        this.i = cn.net.shoot.sharetracesdk.a.a.b();
        this.j = cn.net.shoot.sharetracesdk.a.a.a();
        this.l = "2.1.7";
        this.k = cn.net.shoot.sharetracesdk.a.a.d();
        cn.net.shoot.sharetracesdk.d.a aVarA = cn.net.shoot.sharetracesdk.d.d.b().a();
        if (aVarA != null) {
            this.m = aVarA.a;
            this.n = aVarA.b;
        }
        this.o = TextUtils.isEmpty(this.f) ? this.e : this.f;
        this.p = "";
        this.q = cn.net.shoot.sharetracesdk.a.a.c();
        this.s = cn.net.shoot.sharetracesdk.a.a.a(this.t, "st_channel");
    }

    public static b b() {
        if (v == null) {
            synchronized (b.class) {
                if (v == null) {
                    v = new b();
                }
            }
        }
        return v;
    }

    public HashMap<String, String> a() {
        if (this.u == null) {
            this.u = new HashMap<>();
        }
        this.u.put("di", this.a);
        this.u.put(Config.INPUT_DEF_PKG, this.b);
        this.u.put("osvn", this.c);
        this.u.put("vc", this.d);
        this.u.put("clip", this.e);
        this.u.put("rclip", this.r);
        this.u.put("ai", this.f);
        this.u.put(g.f719K, this.g);
        this.u.put("sh", this.h);
        this.u.put("br", this.j);
        this.u.put("gr", this.m);
        this.u.put("gv", this.n);
        this.u.put(Config.FEED_LIST_PART, this.o);
        this.u.put("svn", this.l);
        this.u.put(LiveConfigKey.MEDIUM, this.k);
        this.u.put("os", "android");
        this.u.put("aid", this.p);
        this.u.put("sn", this.q);
        this.u.put("ch", this.s);
        List<String> list = this.i;
        if (list != null && list.size() > 0) {
            this.u.put("lis", TextUtils.join(",", this.i));
        }
        return this.u;
    }
}
