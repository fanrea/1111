package com.baidu.mobads.container.components.d;

import android.content.Context;
import com.baidu.mobads.container.components.command.j;
import com.baidu.mobads.container.landingpage.aq;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.bn;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobstat.forbes.Config;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a extends aq {
    public boolean a;
    private Context o;
    private j p;

    public a(Context context, j jVar) {
        super(jVar.h(), jVar.i(), jVar.k(), jVar.l(), jVar.m());
        this.a = true;
        this.o = context;
        this.p = jVar;
    }

    @Override // com.baidu.mobads.container.landingpage.aq
    protected HashMap<String, String> a() {
        String str = "" + bn.a().b();
        HashMap<String, String> map = new HashMap<>();
        try {
            map.put(j.c, this.a ? "true" : "false");
            map.put("pk", this.p.d());
            map.put(j.f, this.p.j());
            map.put("c", "0");
            map.put(j.u, str);
            map.put("clickTime", this.p.c() + "");
            map.put(j.i, "" + this.p.U);
            map.put(j.r, "" + this.p.an);
            map.put("dlTime", String.valueOf(System.currentTimeMillis() - this.p.c()));
            map.put(j.o, "3");
            map.put("dlWay", this.p.f() ? "1" : "0");
            map.put(j.F, String.valueOf(this.p.az));
            map.put("dl_type", this.p.ay);
            map.put("exp_id", "");
            map.put("exp2", "");
            map.put(Config.INPUT_DEF_PKG, this.p.d());
            map.put("typeProcId", str);
            map.put("url2", "");
            map.put("installtime", this.p.aC + "");
            map.put(j.B, this.p.av);
            map.putAll(this.p.am);
            map.put("sn", DeviceUtils.getInstance().f(this.o));
        } catch (Exception e) {
            bq.a().a(e);
        }
        return map;
    }
}
