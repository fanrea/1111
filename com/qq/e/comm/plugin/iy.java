package com.qq.e.comm.plugin;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qq.e.comm.plugin.w40;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class iy extends RecyclerView.Adapter<a> {
    private final boolean a;
    private final t40 b;
    private final z10[] c;
    private final hy d;
    private JSONArray f;
    private int g;
    private w40.d i;
    private final List<JSONObject> e = new ArrayList();
    private boolean h = false;

    iy(boolean z, z10[] z10VarArr, t40 t40Var, hy hyVar) {
        this.a = z;
        this.c = z10VarArr;
        this.b = t40Var;
        this.d = hyVar;
        if (z) {
            return;
        }
        this.g = z10VarArr.length;
    }

    public boolean a() {
        return this.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        w40 w40VarA;
        if (i >= 0 && (w40VarA = this.b.a(this.d.D(), this.c[i], this.d, i)) != null) {
            this.d.d(w40VarA);
            w40VarA.a(this.d.D());
            w40VarA.H();
            this.d.c(w40VarA);
            w40VarA.v().a(viewGroup.getMeasuredWidth(), viewGroup.getMeasuredHeight(), this.d.D().d(), this.d.D().f());
            return new a(w40VarA);
        }
        return new a(new View(viewGroup.getContext()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int i = this.g;
        if (i <= 0) {
            return 0;
        }
        if (this.h) {
            return Integer.MAX_VALUE;
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int i2 = this.g;
        if (i2 <= 0) {
            return -1;
        }
        int i3 = i % i2;
        return this.a ? this.f.optJSONObject(i3).optInt("childIndex") : i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a aVar, int i) {
        w40 w40Var = aVar.a;
        if (w40Var == null) {
            return;
        }
        int i2 = this.g;
        if (i2 > 0) {
            if (this.a) {
                w40Var.c(this.f.optJSONObject(i % i2));
            } else {
                Iterator<JSONObject> it = this.e.iterator();
                while (it.hasNext()) {
                    aVar.a.c(it.next());
                }
            }
        }
        w40.d dVar = this.i;
        aVar.c = dVar;
        if (dVar != null) {
            aVar.a.a(aVar.b);
        }
    }

    /* compiled from: A */
    static class a extends RecyclerView.ViewHolder {
        public final w40 a;
        public final w40.d b;
        public w40.d c;

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.iy$a$a, reason: collision with other inner class name */
        class C0712a implements w40.d {
            C0712a() {
            }

            @Override // com.qq.e.comm.plugin.gk
            public void c(w40 w40Var, h8 h8Var) throws JSONException {
                if (a.this.c == null) {
                    return;
                }
                h8Var.a("viewIndex", Integer.valueOf(a()));
                a.this.c.c(w40Var, h8Var);
            }

            @Override // com.qq.e.comm.plugin.gk
            public boolean b(w40 w40Var, h8 h8Var) throws JSONException {
                if (a.this.c == null) {
                    return false;
                }
                h8Var.a("viewIndex", Integer.valueOf(a()));
                return a.this.c.b(w40Var, h8Var);
            }

            private int a() {
                return a.this.getLayoutPosition() % ((iy) ((RecyclerView) a.this.itemView.getParent()).getAdapter()).g;
            }

            @Override // com.qq.e.comm.plugin.gk
            public void a(w40 w40Var, h8 h8Var) throws JSONException {
                if (a.this.c == null) {
                    return;
                }
                h8Var.a("viewIndex", Integer.valueOf(a()));
                a.this.c.a(w40Var, h8Var);
            }

            @Override // com.qq.e.comm.plugin.gk
            public void a(w40 w40Var, h8 h8Var, float f) throws JSONException {
                if (a.this.c == null) {
                    return;
                }
                h8Var.a("viewIndex", Integer.valueOf(a()));
                a.this.c.a(w40Var, h8Var, f);
            }
        }

        public a(View view) {
            super(view);
            this.b = new C0712a();
            this.a = null;
        }

        public a(w40 w40Var) {
            super(w40Var.A());
            this.b = new C0712a();
            this.a = w40Var;
        }
    }

    public void a(Object obj) {
        if (this.a) {
            JSONArray jSONArray = (JSONArray) obj;
            this.f = jSONArray;
            this.g = jSONArray == null ? 0 : jSONArray.length();
        } else {
            this.e.add((JSONObject) obj);
        }
        notifyDataSetChanged();
    }

    public void a(w40.d dVar) {
        if (dVar == this.i) {
            return;
        }
        this.i = dVar;
        notifyDataSetChanged();
    }

    public void a(boolean z) {
        this.h = z;
    }
}
