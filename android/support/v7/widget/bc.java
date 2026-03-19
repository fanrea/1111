package android.support.v7.widget;

import android.support.v4.d.i;
import android.support.v7.widget.aj;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class bc {
    final android.support.v4.d.a<aj.x, a> wM = new android.support.v4.d.a<>();
    final android.support.v4.d.e<aj.x> wN = new android.support.v4.d.e<>();

    interface b {
        void a(aj.x xVar, aj.f.b bVar, aj.f.b bVar2);

        void b(aj.x xVar, aj.f.b bVar, aj.f.b bVar2);

        void c(aj.x xVar, aj.f.b bVar, aj.f.b bVar2);

        void g(aj.x xVar);
    }

    bc() {
    }

    final void clear() {
        this.wM.clear();
        this.wN.clear();
    }

    final void a(aj.x xVar, aj.f.b bVar) {
        a aVarFH = this.wM.get(xVar);
        if (aVarFH == null) {
            aVarFH = a.fH();
            this.wM.put(xVar, aVarFH);
        }
        aVarFH.wO = bVar;
        aVarFH.flags |= 4;
    }

    final boolean y(aj.x xVar) {
        a aVar = this.wM.get(xVar);
        return (aVar == null || (aVar.flags & 1) == 0) ? false : true;
    }

    final aj.f.b z(aj.x xVar) {
        return a(xVar, 4);
    }

    final aj.f.b A(aj.x xVar) {
        return a(xVar, 8);
    }

    private aj.f.b a(aj.x xVar, int i) {
        a aVarValueAt;
        aj.f.b bVar;
        int iIndexOfKey = this.wM.indexOfKey(xVar);
        if (iIndexOfKey < 0 || (aVarValueAt = this.wM.valueAt(iIndexOfKey)) == null || (aVarValueAt.flags & i) == 0) {
            return null;
        }
        aVarValueAt.flags &= i ^ (-1);
        if (i == 4) {
            bVar = aVarValueAt.wO;
        } else if (i == 8) {
            bVar = aVarValueAt.wP;
        } else {
            throw new IllegalArgumentException("Must provide flag PRE or POST");
        }
        if ((aVarValueAt.flags & 12) == 0) {
            this.wM.removeAt(iIndexOfKey);
            a.a(aVarValueAt);
        }
        return bVar;
    }

    final void a(long j, aj.x xVar) {
        this.wN.put(j, xVar);
    }

    final void b(aj.x xVar, aj.f.b bVar) {
        a aVarFH = this.wM.get(xVar);
        if (aVarFH == null) {
            aVarFH = a.fH();
            this.wM.put(xVar, aVarFH);
        }
        aVarFH.flags |= 2;
        aVarFH.wO = bVar;
    }

    final boolean B(aj.x xVar) {
        a aVar = this.wM.get(xVar);
        return (aVar == null || (aVar.flags & 4) == 0) ? false : true;
    }

    final aj.x i(long j) {
        return this.wN.get(j);
    }

    final void c(aj.x xVar, aj.f.b bVar) {
        a aVarFH = this.wM.get(xVar);
        if (aVarFH == null) {
            aVarFH = a.fH();
            this.wM.put(xVar, aVarFH);
        }
        aVarFH.wP = bVar;
        aVarFH.flags |= 8;
    }

    final void C(aj.x xVar) {
        a aVarFH = this.wM.get(xVar);
        if (aVarFH == null) {
            aVarFH = a.fH();
            this.wM.put(xVar, aVarFH);
        }
        aVarFH.flags |= 1;
    }

    final void D(aj.x xVar) {
        a aVar = this.wM.get(xVar);
        if (aVar == null) {
            return;
        }
        aVar.flags &= -2;
    }

    final void a(b bVar) {
        for (int size = this.wM.size() - 1; size >= 0; size--) {
            aj.x xVarKeyAt = this.wM.keyAt(size);
            a aVarRemoveAt = this.wM.removeAt(size);
            if ((aVarRemoveAt.flags & 3) == 3) {
                bVar.g(xVarKeyAt);
            } else if ((aVarRemoveAt.flags & 1) != 0) {
                if (aVarRemoveAt.wO == null) {
                    bVar.g(xVarKeyAt);
                } else {
                    bVar.a(xVarKeyAt, aVarRemoveAt.wO, aVarRemoveAt.wP);
                }
            } else if ((aVarRemoveAt.flags & 14) == 14) {
                bVar.b(xVarKeyAt, aVarRemoveAt.wO, aVarRemoveAt.wP);
            } else if ((aVarRemoveAt.flags & 12) == 12) {
                bVar.c(xVarKeyAt, aVarRemoveAt.wO, aVarRemoveAt.wP);
            } else if ((aVarRemoveAt.flags & 4) != 0) {
                bVar.a(xVarKeyAt, aVarRemoveAt.wO, null);
            } else if ((aVarRemoveAt.flags & 8) != 0) {
                bVar.b(xVarKeyAt, aVarRemoveAt.wO, aVarRemoveAt.wP);
            }
            a.a(aVarRemoveAt);
        }
    }

    final void E(aj.x xVar) {
        int size = this.wN.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            if (xVar == this.wN.valueAt(size)) {
                this.wN.removeAt(size);
                break;
            }
            size--;
        }
        a aVarRemove = this.wM.remove(xVar);
        if (aVarRemove != null) {
            a.a(aVarRemove);
        }
    }

    static void onDetach() {
        a.fI();
    }

    public final void F(aj.x xVar) {
        D(xVar);
    }

    static class a {
        static i.a<a> wQ = new i.b(20);
        int flags;
        aj.f.b wO;
        aj.f.b wP;

        private a() {
        }

        static a fH() {
            a aVarV = wQ.V();
            return aVarV == null ? new a() : aVarV;
        }

        static void a(a aVar) {
            aVar.flags = 0;
            aVar.wO = null;
            aVar.wP = null;
            wQ.release(aVar);
        }

        static void fI() {
            while (wQ.V() != null) {
            }
        }
    }
}
