package com.component.feed;

import android.view.View;
import com.baidu.mobads.container.o.j;
import com.baidu.mobads.container.util.cm;
import com.component.a.a.b;
import com.component.a.g.d;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ah extends d.c {
    private View a;
    private View b;
    private View c;
    private final com.baidu.mobads.container.adrequest.t d;
    private final com.baidu.mobads.container.adrequest.j e;

    public ah(com.baidu.mobads.container.adrequest.t tVar, com.baidu.mobads.container.adrequest.j jVar) {
        this.d = tVar;
        this.e = jVar;
    }

    @Override // com.component.a.g.d.c
    public void a(View view, String str, String str2) {
        if ("gesture_view".equals(str2)) {
            this.a = view;
        } else if ("gesture_lottie".equals(str2)) {
            ((com.component.a.a.f) view).a(new ai(this));
        } else if ("slide_view".equals(str2) || "front_slide_view".equals(str2)) {
            this.b = view;
        } else if ("coupon_float".equals(str2)) {
            this.c = view;
        }
        a(this.e, view, str, str2);
    }

    @Override // com.component.a.g.d.c
    public void a(View view, String str) {
        super.a(view, str);
        if (view == this.b) {
            a();
        } else if ("close".equals(str) && "coupon_float_close_view".equals(com.component.a.i.f.c(view).m(""))) {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.a != null) {
            this.a.setVisibility(4);
        }
        if (this.d != null) {
            HashMap map = new HashMap();
            map.put("type", "dismiss");
            map.put("uniqueId", this.e.getUniqueId());
            this.d.s().dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.Q, (HashMap<String, Object>) map));
        }
    }

    private void b() {
        if (this.c != null) {
            this.c.setVisibility(4);
        }
        if (this.d != null) {
            HashMap map = new HashMap();
            map.put("type", "coupon_float_dismiss");
            map.put("uniqueId", this.e.getUniqueId());
            this.d.s().dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.Q, (HashMap<String, Object>) map));
        }
    }

    private void a(com.baidu.mobads.container.adrequest.j jVar, View view, String str, String str2) {
        if ("native_slide_view".equals(str)) {
            com.component.a.i.n.a(com.component.a.i.f.c(view), new aj(this, jVar));
            return;
        }
        if ("coupon_flip_page".equals(str2)) {
            String strC = j.a.COUPON_FLIP_PAGE.c();
            com.baidu.mobads.container.adrequest.n.e(jVar, strC, com.baidu.mobads.container.o.j.f(strC, view));
            return;
        }
        if ("coupon_float".equals(str2)) {
            com.baidu.mobads.container.adrequest.n.e(jVar, str2, com.baidu.mobads.container.o.j.a(jVar.getOriginJsonObject(), str2, view));
            return;
        }
        if ("native_bullet_view".equals(str)) {
            String[] strArr = new String[2];
            com.component.a.f.e eVarC = com.component.a.i.f.c(view);
            if (eVarC != null) {
                JSONObject jSONObjectC = eVarC.c();
                if (jSONObjectC != null) {
                    strArr[0] = jSONObjectC.optString(b.e.c, "");
                    strArr[1] = jSONObjectC.optString("duration", "");
                }
                com.baidu.mobads.container.adrequest.n.a(jVar, j.a.DYNAMIC_BARRAGE.b(), strArr);
            }
        }
    }
}
