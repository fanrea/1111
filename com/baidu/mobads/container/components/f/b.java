package com.baidu.mobads.container.components.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.components.command.j;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.container.util.t;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b implements a {
    private static final long a = 60000;
    private static final long b = 5000;
    private j c;
    private boolean d = false;
    private boolean e = false;
    private long f = System.currentTimeMillis();
    private long g;
    private Context h;

    public b(Context context, j jVar) {
        this.h = context.getApplicationContext();
        this.c = jVar;
    }

    @Override // com.baidu.mobads.container.components.f.a
    public boolean a() {
        if (this.c == null || TextUtils.isEmpty(this.c.Z)) {
            return true;
        }
        boolean zF = t.f(this.h, this.h.getPackageName());
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.d) {
            if (zF) {
                this.e = true;
                b();
                return true;
            }
        } else {
            if (jCurrentTimeMillis - this.f > 5000) {
                b();
                return true;
            }
            if (!zF) {
                this.d = true;
                this.g = System.currentTimeMillis();
            }
        }
        if (jCurrentTimeMillis - this.f > 60000) {
            b();
            return true;
        }
        return false;
    }

    private void b() {
        try {
            by.a.a(this.h).a(530).a("qk", this.c.ae).a("adid", this.c.ag).a(j.f, this.c.af).a("prod", this.c.ai).a(this.c.aj).a("pk", this.c.Z).a(j.c, this.c.ac).a(j.B, a(this.c.av)).a("cooperation", this.c.aw).a("cooperation", this.c.ax).a("apoOpen", this.c.as).a("mobileConfirmed", this.c.ao).a("dl_type", b("dl_type")).a("cur_qk", b("cur_qk")).a("cur_adid", b("cur_adid")).a("cur_buyer", b("cur_buyer")).a("cur_apid", b("cur_apid")).a("act", b("act")).a("isInstallStart", this.d).a("isInstallFinish", this.e).a("isApkInstall", com.baidu.mobads.container.util.j.b(this.h, this.c.Z)).a("mst", "" + this.f).a("ist", "" + this.g).f();
        } catch (Throwable th) {
        }
    }

    private String a(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 64) {
            return str.substring(0, 64);
        }
        return str;
    }

    private String b(String str) {
        if (this.c != null && this.c.am != null) {
            return this.c.am.get(str);
        }
        return "";
    }
}
