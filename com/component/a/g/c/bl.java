package com.component.a.g.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.component.a.g.c.e;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class bl extends e {
    private static final String b = "recommend_view";
    private ArrayList<String> a;

    public bl(Context context, com.baidu.mobads.container.adrequest.j jVar, e.a aVar) {
        super(context, jVar, aVar);
    }

    @Override // com.component.a.g.c.e
    public void onCreateView(com.component.a.f.d dVar) {
        if (dVar == null) {
            return;
        }
        com.component.a.f.e eVarF = dVar.f();
        View viewE = dVar.e();
        if (eVarF == null || viewE == null) {
            return;
        }
        try {
            if (b.equals(eVarF.m("")) && (viewE instanceof com.component.a.d.a)) {
                Map<View, com.component.a.f.e> mapA = com.component.a.i.n.a(viewE);
                for (View view : mapA.keySet()) {
                    com.component.a.f.e eVar = mapA.get(view);
                    if (view != null && eVar != null && (view instanceof TextView) && TextUtils.isEmpty(eVar.o(""))) {
                        ((TextView) view).setText(a());
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    private String a() {
        String str = "经典热门";
        try {
            if (this.a == null || this.a.size() < 1) {
                b();
            }
            int size = this.a.size() - 1;
            double dRandom = Math.random();
            double d = size;
            Double.isNaN(d);
            int i = (int) (dRandom * d);
            String str2 = this.a.get(i);
            try {
                this.a.remove(i);
                return str2;
            } catch (Exception e) {
                e = e;
                str = str2;
                e.printStackTrace();
                return str;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private void b() {
        if (this.a == null) {
            this.a = new ArrayList<>();
        }
        this.a.add("星标优选");
        this.a.add("口碑推荐");
        this.a.add("热门排行");
        this.a.add("社区优选");
        this.a.add("平台推荐");
        this.a.add("人气极佳");
        this.a.add("实时排行");
    }
}
