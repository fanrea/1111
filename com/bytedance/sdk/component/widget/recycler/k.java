package com.bytedance.sdk.component.widget.recycler;

import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.component.widget.recycler.d.hc.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class k {
    final com.bytedance.sdk.component.widget.recycler.d.hc.d<RecyclerView.v, d> d = new com.bytedance.sdk.component.widget.recycler.d.hc.d<>();
    final com.bytedance.sdk.component.widget.recycler.d.hc.b<RecyclerView.v> hc = new com.bytedance.sdk.component.widget.recycler.d.hc.b<>();

    interface hc {
        void b(RecyclerView.v vVar, RecyclerView.an.hc hcVar, RecyclerView.an.hc hcVar2);

        void d(RecyclerView.v vVar);

        void d(RecyclerView.v vVar, RecyclerView.an.hc hcVar, RecyclerView.an.hc hcVar2);

        void hc(RecyclerView.v vVar, RecyclerView.an.hc hcVar, RecyclerView.an.hc hcVar2);
    }

    k() {
    }

    void d() {
        this.d.clear();
        this.hc.b();
    }

    void d(RecyclerView.v vVar, RecyclerView.an.hc hcVar) {
        d dVarD = this.d.get(vVar);
        if (dVarD == null) {
            dVarD = d.d();
            this.d.put(vVar, dVarD);
        }
        dVarD.hc = hcVar;
        dVarD.d |= 4;
    }

    boolean d(RecyclerView.v vVar) {
        d dVar = this.d.get(vVar);
        return (dVar == null || (dVar.d & 1) == 0) ? false : true;
    }

    RecyclerView.an.hc hc(RecyclerView.v vVar) {
        return d(vVar, 4);
    }

    RecyclerView.an.hc b(RecyclerView.v vVar) {
        return d(vVar, 8);
    }

    private RecyclerView.an.hc d(RecyclerView.v vVar, int i) {
        d dVarHc;
        RecyclerView.an.hc hcVar;
        int iD = this.d.d(vVar);
        if (iD < 0 || (dVarHc = this.d.hc(iD)) == null || (dVarHc.d & i) == 0) {
            return null;
        }
        dVarHc.d &= ~i;
        if (i == 4) {
            hcVar = dVarHc.hc;
        } else {
            if (i != 8) {
                throw new IllegalArgumentException("Must provide flag PRE or POST");
            }
            hcVar = dVarHc.b;
        }
        if ((dVarHc.d & 12) == 0) {
            this.d.b(iD);
            d.d(dVarHc);
        }
        return hcVar;
    }

    void d(long j, RecyclerView.v vVar) {
        this.hc.hc(j, vVar);
    }

    void hc(RecyclerView.v vVar, RecyclerView.an.hc hcVar) {
        d dVarD = this.d.get(vVar);
        if (dVarD == null) {
            dVarD = d.d();
            this.d.put(vVar, dVarD);
        }
        dVarD.d |= 2;
        dVarD.hc = hcVar;
    }

    boolean c(RecyclerView.v vVar) {
        d dVar = this.d.get(vVar);
        return (dVar == null || (dVar.d & 4) == 0) ? false : true;
    }

    RecyclerView.v d(long j) {
        return this.hc.d(j);
    }

    void b(RecyclerView.v vVar, RecyclerView.an.hc hcVar) {
        d dVarD = this.d.get(vVar);
        if (dVarD == null) {
            dVarD = d.d();
            this.d.put(vVar, dVarD);
        }
        dVarD.b = hcVar;
        dVarD.d |= 8;
    }

    void u(RecyclerView.v vVar) {
        d dVarD = this.d.get(vVar);
        if (dVarD == null) {
            dVarD = d.d();
            this.d.put(vVar, dVarD);
        }
        dVarD.d |= 1;
    }

    void an(RecyclerView.v vVar) {
        d dVar = this.d.get(vVar);
        if (dVar != null) {
            dVar.d &= -2;
        }
    }

    void d(hc hcVar) {
        for (int size = this.d.size() - 1; size >= 0; size--) {
            RecyclerView.v vVarD = this.d.d(size);
            d dVarB = this.d.b(size);
            if ((dVarB.d & 3) == 3) {
                hcVar.d(vVarD);
            } else if ((dVarB.d & 1) != 0) {
                if (dVarB.hc == null) {
                    hcVar.d(vVarD);
                } else {
                    hcVar.d(vVarD, dVarB.hc, dVarB.b);
                }
            } else if ((dVarB.d & 14) == 14) {
                hcVar.hc(vVarD, dVarB.hc, dVarB.b);
            } else if ((dVarB.d & 12) == 12) {
                hcVar.b(vVarD, dVarB.hc, dVarB.b);
            } else if ((dVarB.d & 4) != 0) {
                hcVar.d(vVarD, dVarB.hc, null);
            } else if ((dVarB.d & 8) != 0) {
                hcVar.hc(vVarD, dVarB.hc, dVarB.b);
            }
            d.d(dVarB);
        }
    }

    void h(RecyclerView.v vVar) {
        int iHc = this.hc.hc() - 1;
        while (true) {
            if (iHc < 0) {
                break;
            }
            if (vVar == this.hc.b(iHc)) {
                this.hc.d(iHc);
                break;
            }
            iHc--;
        }
        d dVarRemove = this.d.remove(vVar);
        if (dVarRemove != null) {
            d.d(dVarRemove);
        }
    }

    void hc() {
        d.hc();
    }

    public void gb(RecyclerView.v vVar) {
        an(vVar);
    }

    static class d {
        static c.d<d> c = new c.hc(20);
        RecyclerView.an.hc b;
        int d;
        RecyclerView.an.hc hc;

        private d() {
        }

        static d d() {
            d dVarD = c.d();
            return dVarD == null ? new d() : dVarD;
        }

        static void d(d dVar) {
            dVar.d = 0;
            dVar.hc = null;
            dVar.b = null;
            c.d(dVar);
        }

        static void hc() {
            while (c.d() != null) {
            }
        }
    }
}
