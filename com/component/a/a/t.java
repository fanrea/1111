package com.component.a.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.component.a.a.f;
import com.component.a.f.e;
import com.component.lottie.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class t {
    private final Context a;
    private final List<e.h> b;
    private final a c = new a();
    private final Map<String, f> d = new HashMap();
    private final Map<String, List<f.b>> e = new HashMap();
    private final Set<String> f = new HashSet();
    private b g;

    public interface b {
        void a(e.h hVar, f fVar);

        void a(e.h hVar, String str);
    }

    public t(Context context, List<e.h> list) {
        this.a = context.getApplicationContext();
        this.b = list;
        Iterator<e.h> it = list.iterator();
        while (it.hasNext()) {
            String strB = it.next().b("");
            if (!TextUtils.isEmpty(strB)) {
                this.f.add(strB);
            }
        }
    }

    public void a() {
        Iterator<e.h> it = this.b.iterator();
        while (it.hasNext()) {
            com.component.lottie.k.a(this.a, it.next(), this.c);
        }
    }

    public void a(b bVar) {
        this.g = bVar;
    }

    public View a(String str, View view) {
        if (TextUtils.isEmpty(str) || !this.f.contains(str)) {
            return view;
        }
        try {
            if (view instanceof ViewGroup) {
                view = a((ViewGroup) view);
            }
            if (view instanceof f) {
                List<f.b> list = this.e.get(str);
                if (list != null) {
                    for (f.b bVar : list) {
                        ((f) view).a(bVar.a(), bVar.b());
                        if (this.g != null) {
                            this.g.a(bVar.a(), (f) view);
                        }
                        com.component.lottie.g.c.a("Bind lottie view: id[" + str + "] with [" + bVar.a().g("") + "]");
                    }
                } else {
                    this.d.put(str, (f) view);
                    com.component.lottie.g.c.a("Cache lottie view: [" + str + "]");
                }
                return view;
            }
        } catch (Throwable th) {
            com.component.lottie.g.c.c("Error bind lottie view.", th);
        }
        return view;
    }

    private class a implements k.b {
        private a() {
        }

        @Override // com.component.lottie.k.b
        public void a(e.h hVar, com.component.lottie.t tVar) {
            if (hVar != null && tVar != null) {
                f fVar = (f) t.this.d.get(hVar.b(""));
                if (fVar != null && tVar == fVar.c()) {
                    com.component.lottie.g.c.a("Lottie [" + hVar.g("") + "] cached success, start playing.");
                    fVar.F();
                }
            }
        }

        @Override // com.component.lottie.k.b
        public void b(e.h hVar, com.component.lottie.t tVar) {
            if (hVar != null && tVar != null) {
                String strB = hVar.b("");
                f fVar = (f) t.this.d.get(strB);
                if (fVar != null) {
                    fVar.a(hVar, tVar);
                    if (t.this.g != null) {
                        t.this.g.a(hVar, fVar);
                    }
                    com.component.lottie.g.c.a("Bind lottie view from cache: id[" + strB + "] with [" + hVar.g("") + "]");
                    return;
                }
                f.b bVar = new f.b(hVar, tVar);
                List list = (List) t.this.e.get(strB);
                if (list != null) {
                    list.add(bVar);
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(bVar);
                    t.this.e.put(strB, arrayList);
                }
                com.component.lottie.g.c.a("Cache lottie json: [" + hVar.g("") + "]");
            }
        }

        @Override // com.component.lottie.k.b
        public void a(e.h hVar, String str) {
            if (t.this.g != null) {
                t.this.g.a(hVar, str);
            }
        }
    }

    private View a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        f fVar = new f(this.a, null);
        fVar.setVisibility(4);
        viewGroup.addView(fVar, new ViewGroup.LayoutParams(-1, -1));
        return fVar;
    }
}
