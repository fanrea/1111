package com.baidu.mobads.container.s;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.util.animation.a;
import com.baidu.mobads.container.util.d.d;
import com.component.a.g.a;
import com.component.a.g.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class p extends RelativeLayout {
    private static final float a = 0.19419643f;
    private static final int b = 96;
    private static final int c = 16;
    private static final int d = 35;
    private static final int e = 17;
    private Context f;
    private Boolean g;
    private com.baidu.mobads.container.k h;
    private com.baidu.mobads.container.adrequest.j i;
    private final a j;
    private b k;
    private Handler l;
    private Runnable m;

    public interface b {
        void a(View view, com.component.a.f.d dVar);
    }

    public p(Context context, a aVar, com.baidu.mobads.container.k kVar, com.baidu.mobads.container.adrequest.j jVar) throws JSONException {
        super(context);
        this.g = false;
        this.l = new Handler();
        this.m = new q(this);
        this.f = context;
        this.j = aVar;
        this.h = kVar;
        this.i = jVar;
        if (a(kVar, jVar)) {
            b();
            this.l.removeCallbacks(this.m);
            this.l.postDelayed(this.m, this.j.b() * 1000);
        }
    }

    public void a(b bVar) {
        this.k = bVar;
    }

    private void b() throws JSONException {
        com.component.a.g.d dVar = new com.component.a.g.d(this.h, this.i);
        dVar.a(new a.C0317a().a(new r(this, this.h, this.i)));
        List<String> listC = this.j.c();
        try {
            if (this.j.a() == 0) {
                for (int i = 0; i < 5; i++) {
                    JSONObject jSONObject = new JSONObject(listC.get(i));
                    jSONObject.put("click", "");
                    listC.set(i, jSONObject.toString());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < listC.size(); i2++) {
            arrayList.add(com.component.a.i.n.b(listC.get(i2)));
        }
        com.baidu.mobads.container.util.ab.b(this.f, this.h.getAdContainerContext().v().getWidth());
        int iB = com.baidu.mobads.container.util.ab.b(this.f, this.h.getAdContainerContext().v().getHeight());
        if (iB == 0) {
            com.baidu.mobads.container.util.ab.b(this.f, com.baidu.mobads.container.util.ab.b(this.f));
            iB = com.baidu.mobads.container.util.ab.b(this.f, com.baidu.mobads.container.util.ab.c(this.f));
        }
        int iB2 = (int) (com.baidu.mobads.container.util.ab.b(this.f, com.baidu.mobads.container.util.ab.c(this.f)) * a);
        LinearLayout linearLayout = new LinearLayout(this.f);
        linearLayout.setOrientation(1);
        float f = ((iB - iB2) - 96) / 3;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.mobads.container.util.ab.a(this.f, f) * 3);
        layoutParams.setMargins(0, com.baidu.mobads.container.util.ab.a(this.f, 96.0f), 0, com.baidu.mobads.container.util.ab.a(this.f, iB2));
        addView(linearLayout, layoutParams);
        RelativeLayout[] relativeLayoutArr = new RelativeLayout[3];
        for (int i3 = 0; i3 < 3; i3++) {
            relativeLayoutArr[i3] = new RelativeLayout(this.f);
            relativeLayoutArr[i3].setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.mobads.container.util.ab.a(this.f, f)));
            linearLayout.addView(relativeLayoutArr[i3]);
        }
        int iA = com.baidu.mobads.container.util.ab.a(this.f, r1 - 32);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams2.setMargins(0, 0, com.baidu.mobads.container.util.ab.a(this.f, 35.0f), 0);
        layoutParams2.addRule(15, -1);
        layoutParams2.addRule(11, -1);
        View viewA = dVar.a(relativeLayoutArr[0], (JSONObject) arrayList.get(3), (d.c) null);
        viewA.setLayoutParams(layoutParams2);
        relativeLayoutArr[0].addView(viewA);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams3.addRule(15, -1);
        layoutParams3.addRule(9, -1);
        View viewA2 = dVar.a(relativeLayoutArr[1], (JSONObject) arrayList.get(1), (d.c) null);
        viewA2.setLayoutParams(layoutParams3);
        relativeLayoutArr[1].addView(viewA2);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams4.setMargins(0, 0, com.baidu.mobads.container.util.ab.a(this.f, 17.0f), 0);
        layoutParams4.addRule(15, -1);
        layoutParams4.addRule(11, -1);
        View viewA3 = dVar.a(relativeLayoutArr[1], (JSONObject) arrayList.get(2), (d.c) null);
        viewA3.setLayoutParams(layoutParams4);
        relativeLayoutArr[1].addView(viewA3);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams5.addRule(15, -1);
        layoutParams5.addRule(9, -1);
        View viewA4 = dVar.a(relativeLayoutArr[2], (JSONObject) arrayList.get(0), (d.c) null);
        viewA4.setLayoutParams(layoutParams5);
        relativeLayoutArr[2].addView(viewA4);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams6.addRule(15, -1);
        View viewA5 = dVar.a(relativeLayoutArr[2], (JSONObject) arrayList.get(4), (d.c) null);
        viewA5.setLayoutParams(layoutParams6);
        layoutParams6.addRule(11, -1);
        relativeLayoutArr[2].addView(viewA5);
    }

    private boolean a(com.baidu.mobads.container.k kVar, com.baidu.mobads.container.adrequest.j jVar) {
        if (com.baidu.mobads.container.util.x.a(null).a() <= 25) {
            return this.g.booleanValue();
        }
        if (kVar != null && jVar != null && com.baidu.mobads.container.util.d.d.a(this.f).b(com.baidu.mobads.container.u.n.h, d.e.COMMON)) {
            this.g = true;
        }
        return this.g.booleanValue();
    }

    public void a() {
        com.baidu.mobads.container.util.animation.a.a(this).a(200).a(new JSONArray().put("alpha")).a(a.b.EXIT).i();
    }

    public static class a {
        private int a = 1;
        private int b = 5;
        private List<String> c;

        public int a() {
            return this.a;
        }

        public a a(int i) {
            this.a = i;
            return this;
        }

        public int b() {
            return this.b;
        }

        public a b(int i) {
            this.b = i;
            return this;
        }

        public List<String> c() {
            return this.c;
        }

        public a a(List<String> list) {
            this.c = list;
            return this;
        }
    }
}
