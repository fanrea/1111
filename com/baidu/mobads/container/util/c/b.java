package com.baidu.mobads.container.util.c;

import android.app.Activity;
import com.baidu.mobads.container.adrequest.j;
import com.baidu.mobads.container.adrequest.t;
import com.baidu.mobads.container.components.b.e;
import com.baidu.mobads.container.util.f;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class b implements e {
    final /* synthetic */ int a;
    final /* synthetic */ t b;
    final /* synthetic */ j c;
    final /* synthetic */ HashMap d;
    final /* synthetic */ String e;
    final /* synthetic */ JSONObject f;
    final /* synthetic */ com.baidu.mobads.container.components.k.a g;
    final /* synthetic */ a h;

    b(a aVar, int i, t tVar, j jVar, HashMap map, String str, JSONObject jSONObject, com.baidu.mobads.container.components.k.a aVar2) {
        this.h = aVar;
        this.a = i;
        this.b = tVar;
        this.c = jVar;
        this.d = map;
        this.e = str;
        this.f = jSONObject;
        this.g = aVar2;
    }

    @Override // com.baidu.mobads.container.components.b.e
    public void a(Activity activity) {
    }

    @Override // com.baidu.mobads.container.components.b.e
    public void b(Activity activity) {
    }

    @Override // com.baidu.mobads.container.components.b.e
    public void c(Activity activity) {
    }

    @Override // com.baidu.mobads.container.components.b.e
    public void d(Activity activity) {
        int iOptInt;
        this.h.i = System.currentTimeMillis() - this.h.i;
        this.h.f = true;
        if (this.h.i < 600) {
        }
        if (a.a > this.a) {
            this.h.a(this.b, this.c, (HashMap<String, String>) this.d, this);
            return;
        }
        f.a().a(this.h.j, this.e, !this.h.d);
        if (this.f == null) {
            iOptInt = 0;
        } else {
            iOptInt = this.f.optInt("fb_act", 0);
            this.h.g = this.f.optInt("dp_fl_tp", 0);
            this.d.put("aggr_dp_t", String.valueOf(this.f.optInt("aggr_dp_t", 8000)));
            this.d.put("nor_dp_t", String.valueOf(this.f.optInt("nor_dp_t", 3000)));
        }
        switch (this.h.g) {
            case 0:
            case 2:
                if (!this.h.d && iOptInt == 1) {
                    this.g.a(false);
                }
                this.h.a(this.b, this.c, (HashMap<String, String>) this.d, this);
                break;
            case 1:
                if (iOptInt == 1) {
                    this.g.a(false);
                }
                this.h.a(this.b, this.c, (HashMap<String, String>) this.d, this);
                break;
            default:
                this.h.a(this.b, this.c, (HashMap<String, String>) this.d, this);
                break;
        }
    }

    @Override // com.baidu.mobads.container.components.b.e
    public void e(Activity activity) {
        this.h.i = System.currentTimeMillis();
        this.h.e = true;
    }

    @Override // com.baidu.mobads.container.components.b.e
    public void f(Activity activity) {
        this.h.d = true;
        this.h.h = System.currentTimeMillis() - this.h.i;
    }
}
