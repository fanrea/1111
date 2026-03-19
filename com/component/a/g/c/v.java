package com.component.a.g.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.mobads.container.util.cf;
import com.component.a.a.t;
import com.component.a.f.e;
import com.component.a.g.c.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class v extends e {
    private final Map<String, a> a;

    public static class a {
        View a;
        com.component.a.a.f b;
        com.component.a.a.f c;
        MotionEvent d;
        private final com.component.a.f.e e;
        private final com.component.a.a.t f;
        private final e.a g;

        a(Context context, com.component.a.f.e eVar, e.a aVar) {
            this.e = eVar;
            this.f = new com.component.a.a.t(context, eVar.l());
            this.f.a(new C0318a(this, null));
            this.g = aVar;
        }

        public void a() {
            this.f.a();
        }

        public View a(String str, View view) {
            return this.f.a(str, view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            if (this.g != null && this.a != null && this.e != null) {
                com.component.a.f.d dVar = new com.component.a.f.d(this.a, com.component.a.f.d.d, this.e);
                dVar.a(this.a, 0, this.d, this.d);
                this.g.a(dVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.component.a.f.d a(View view, e.h hVar) {
            if (view != null && hVar != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("click", hVar.a(""));
                    return new com.component.a.f.d(view, "click", new com.component.a.f.e(jSONObject));
                } catch (Throwable th) {
                    com.baidu.mobads.container.util.bq.a().c(th);
                    return null;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.component.a.g.c.v$a$a, reason: collision with other inner class name */
        class C0318a implements t.b {
            private C0318a() {
            }

            /* synthetic */ C0318a(a aVar, w wVar) {
                this();
            }

            @Override // com.component.a.a.t.b
            public void a(e.h hVar, com.component.a.a.f fVar) {
                if (!TextUtils.isEmpty(hVar.a(""))) {
                    fVar.setOnClickListener(new x(this, hVar));
                }
                String strC = fVar.C();
                if (TextUtils.equals("guide", strC) && a.this.b == null) {
                    a.this.b = fVar;
                    cf.a(a.this.b, new y(this));
                    a.this.b.a(new z(this));
                } else if (TextUtils.equals("atmosphere", strC)) {
                    a.this.c = fVar;
                }
            }

            @Override // com.component.a.a.t.b
            public void a(e.h hVar, String str) {
                if (a.this.a != null) {
                    cf.b(a.this.a);
                }
                if (a.this.c != null) {
                    cf.b(a.this.c);
                }
            }
        }
    }

    public v(Context context, com.baidu.mobads.container.adrequest.j jVar, e.a aVar) {
        super(context, jVar, aVar);
        this.a = new HashMap();
    }

    @Override // com.component.a.g.c.e
    public View onPrepareView(View view, com.component.a.f.e eVar) {
        if (eVar == null || com.component.a.a.f.a) {
            return super.onPrepareView(view, eVar);
        }
        String strM = eVar.m("");
        if (TextUtils.equals("easter_egg", strM) || TextUtils.equals("front_easter_egg", strM)) {
            a aVar = new a(this.mAppContext, eVar, this.mFlyweight);
            this.a.put(eVar.l(""), aVar);
            aVar.a();
        }
        return super.onPrepareView(view, eVar);
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
        String strM = eVarF.m("");
        String strL = eVarF.l("");
        Iterator<a> it = this.a.values().iterator();
        while (it.hasNext()) {
            viewE = it.next().a(strL, viewE);
        }
        if (TextUtils.equals("easter_egg", strM) || TextUtils.equals("front_easter_egg", strM)) {
            if (com.component.a.a.f.a) {
                viewE.setVisibility(4);
                return;
            }
            a aVar = this.a.get(strL);
            if (aVar != null) {
                aVar.a = viewE;
            }
            com.component.a.i.t.a(viewE, false, new w(this, strL));
        }
    }
}
