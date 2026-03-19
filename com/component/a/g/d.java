package com.component.a.g;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.adrequest.j;
import com.baidu.mobads.container.k;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.container.util.cf;
import com.component.a.a;
import com.component.a.g.a;
import com.component.a.g.g;
import com.component.a.i.n;
import com.component.a.i.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d {
    private final j a;
    private final Context b;
    private final Map<String, com.component.a.c.d> c;
    private final com.component.a.g.b d;
    private final by.b e;
    private final w f;
    private final g g;
    private final com.component.a.i.e h;
    private final com.component.a.h.d i;
    private a.C0317a j;

    public interface b {
        String a(String str);
    }

    public d(k kVar, j jVar) {
        this.h = new com.component.a.i.e();
        this.i = new com.component.a.h.d();
        this.c = new HashMap();
        this.a = jVar;
        this.b = kVar.getAdContainerContext().t();
        this.d = new a(kVar, jVar);
        this.e = new by.b(kVar.getAdContainerContext());
        this.f = new w(kVar.getAdContainerContext().s());
        this.g = new g();
    }

    public d(Context context, j jVar, com.component.a.g.b bVar, by.b bVar2) {
        this.h = new com.component.a.i.e();
        this.i = new com.component.a.h.d();
        this.c = new HashMap();
        this.a = jVar;
        this.b = context.getApplicationContext();
        this.d = bVar;
        this.e = bVar2;
        this.f = null;
        this.g = new g();
    }

    public static class a extends com.component.a.g.b {
        public a(k kVar, j jVar) {
            super(kVar, jVar);
        }
    }

    public void a(a.C0317a c0317a) {
        this.j = c0317a;
    }

    public JSONObject a(g.a aVar) {
        return a(aVar, null);
    }

    public JSONObject a(g.a aVar, g.b bVar) {
        JSONObject optimizedJson;
        if (this.a == null || this.a.getOriginJsonObject() == null) {
            return aVar.a();
        }
        try {
            optimizedJson = this.a.getOptimizedJson();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (optimizedJson != null && optimizedJson.length() > 0) {
            return optimizedJson;
        }
        JSONObject jSONObjectA = a(this.a.getOriginJsonObject().optJSONObject("st_op"), aVar, bVar);
        if (n.a(jSONObjectA)) {
            this.a.setOptimizedJson(jSONObjectA);
            return jSONObjectA;
        }
        return aVar.a();
    }

    public JSONObject a(JSONObject jSONObject, g.a aVar, g.b bVar) {
        try {
            return this.g.a(jSONObject, aVar, new e(this, bVar));
        } catch (Throwable th) {
            th.printStackTrace();
            return aVar.a();
        }
    }

    public boolean a(JSONObject jSONObject) {
        return true;
    }

    public View a(ViewGroup viewGroup, JSONObject jSONObject, c cVar) {
        return a(viewGroup, jSONObject, null, cVar);
    }

    public View a(ViewGroup viewGroup, JSONObject jSONObject, RelativeLayout.LayoutParams layoutParams, c cVar) {
        e eVar = null;
        if (jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        try {
            if (this.j == null) {
                this.j = new a.C0317a();
            }
            com.component.a.g.a aVar = new com.component.a.g.a(this.b, this.a, this.d, this.e, this.j.a(this.f));
            this.c.put(jSONObject.optString("id"), aVar);
            com.component.a.a aVarA = new com.component.a.a(jSONObject).a("AdInfo", this.a.getOriginJsonObject()).a(new com.component.a.g.c()).a(this.b, this.f, new C0319d(aVar, cVar, eVar));
            aVar.a(aVarA.b());
            aVarA.a(viewGroup, layoutParams);
            return aVarA.b();
        } catch (Throwable th) {
            bq.a().c(th);
            return null;
        }
    }

    public int a() {
        if (this.f != null) {
            return this.f.a();
        }
        return cf.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.component.a.g.d$d, reason: collision with other inner class name */
    static class C0319d extends a.AbstractC0311a {
        private final com.component.a.c.d a;
        private final c b;

        /* synthetic */ C0319d(com.component.a.c.d dVar, c cVar, e eVar) {
            this(dVar, cVar);
        }

        private C0319d(com.component.a.c.d dVar, c cVar) {
            this.a = dVar;
            this.b = cVar;
            this.a.a(new f(this));
        }

        @Override // com.component.a.a.AbstractC0311a
        public void c(com.component.a.f.d dVar) {
            if (this.a != null) {
                this.a.c(dVar);
            }
        }

        @Override // com.component.a.a.AbstractC0311a
        public boolean a(com.component.a.f.d dVar) {
            if (this.a != null) {
                return this.a.a(dVar);
            }
            return true;
        }

        @Override // com.component.a.a.AbstractC0311a
        public View b(com.component.a.f.d dVar) {
            if (this.a == null) {
                return null;
            }
            return this.a.b(dVar);
        }

        @Override // com.component.a.a.AbstractC0311a
        public void a(com.component.a.f.d dVar, ViewGroup viewGroup) {
            if (this.a != null) {
                this.a.a(dVar, viewGroup);
            }
        }
    }

    public void b() {
        Iterator<com.component.a.c.d> it = this.c.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public static abstract class c {
        public void a(View view, String str, String str2) {
        }

        public void a(View view, String str) {
        }

        public void a(com.component.a.f.d dVar) {
        }
    }
}
