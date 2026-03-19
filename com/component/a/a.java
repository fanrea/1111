package com.component.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.util.cf;
import com.baidu.mobads.container.util.x;
import com.component.a.i.p;
import com.component.a.i.w;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    private final com.component.a.f.e a;
    private View b;
    private AbstractC0311a c;

    public a(JSONObject jSONObject) {
        this.a = new com.component.a.f.e(jSONObject);
    }

    public a(com.component.a.f.e eVar) {
        this.a = eVar;
    }

    public a a(String str, JSONObject jSONObject) {
        this.a.a(new com.component.a.f.c(str, jSONObject));
        return this;
    }

    public a a(com.component.a.c.a aVar) {
        this.a.a(aVar);
        return this;
    }

    public a a(Context context, AbstractC0311a abstractC0311a) {
        return a(context, null, abstractC0311a);
    }

    public a a(Context context, w wVar, AbstractC0311a abstractC0311a) {
        if (context != null) {
            this.b = new c(wVar).a(abstractC0311a).a(context, this.a);
            this.c = abstractC0311a;
        }
        return this;
    }

    public void a(ViewGroup viewGroup, RelativeLayout.LayoutParams layoutParams) {
        if (this.c != null && this.b != null) {
            this.c.a(new com.component.a.f.d(this.b, com.component.a.f.d.e, this.a), viewGroup);
        }
        if (viewGroup == null || this.b == null || this.b.getParent() != null) {
            return;
        }
        if (layoutParams != null) {
            viewGroup.addView(this.b, layoutParams);
            return;
        }
        int iA = cf.a();
        if (viewGroup instanceof com.component.a.d.c) {
            ((com.component.a.d.c) viewGroup).a(this.b, this.a, iA);
        } else if (x.a(viewGroup.getContext()).a() < 24) {
            a(viewGroup, this.b, this.a, iA);
        } else {
            p.a(viewGroup, new b(this, viewGroup, iA));
        }
    }

    public static void a(ViewGroup viewGroup, View view, com.component.a.f.e eVar, int i) {
        com.component.a.d.c cVar = new com.component.a.d.c(viewGroup.getContext().getApplicationContext(), null);
        cVar.a(view, eVar, i);
        viewGroup.addView(cVar, new ViewGroup.LayoutParams(-1, -1));
    }

    public com.component.a.f.e a() {
        return this.a;
    }

    public View b() {
        return this.b;
    }

    /* renamed from: com.component.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0311a {
        public abstract void c(com.component.a.f.d dVar);

        public boolean a(com.component.a.f.d dVar) {
            return true;
        }

        public View b(com.component.a.f.d dVar) {
            if (dVar != null) {
                return dVar.e();
            }
            return null;
        }

        public void a(com.component.a.f.d dVar, ViewGroup viewGroup) {
        }
    }
}
