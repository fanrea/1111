package android.support.v7.widget;

import android.support.v4.d.j;
import android.support.v7.widget.al;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
final class bf {
    final android.support.v4.d.a<al.x, a> Ah = new android.support.v4.d.a<>();
    final android.support.v4.d.e<al.x> Ai = new android.support.v4.d.e<>();

    interface b {
        void c(al.x xVar, al.f.b bVar, al.f.b bVar2);

        void d(al.x xVar, al.f.b bVar, al.f.b bVar2);

        void e(al.x xVar, al.f.b bVar, al.f.b bVar2);

        void l(al.x xVar);
    }

    bf() {
    }

    final void clear() {
        this.Ah.clear();
        this.Ai.clear();
    }

    final void b(al.x xVar, al.f.b bVar) {
        a aVarHo = this.Ah.get(xVar);
        if (aVarHo == null) {
            aVarHo = a.ho();
            this.Ah.put(xVar, aVarHo);
        }
        aVarHo.Aj = bVar;
        aVarHo.flags |= 4;
    }

    final boolean E(al.x xVar) {
        a aVar = this.Ah.get(xVar);
        return (aVar == null || (aVar.flags & 1) == 0) ? false : true;
    }

    final al.f.b F(al.x xVar) {
        return d(xVar, 4);
    }

    final al.f.b G(al.x xVar) {
        return d(xVar, 8);
    }

    private al.f.b d(al.x xVar, int i) {
        a aVarValueAt;
        al.f.b bVar;
        int iIndexOfKey = this.Ah.indexOfKey(xVar);
        if (iIndexOfKey < 0 || (aVarValueAt = this.Ah.valueAt(iIndexOfKey)) == null || (aVarValueAt.flags & i) == 0) {
            return null;
        }
        aVarValueAt.flags &= i ^ (-1);
        if (i == 4) {
            bVar = aVarValueAt.Aj;
        } else if (i == 8) {
            bVar = aVarValueAt.Ak;
        } else {
            throw new IllegalArgumentException("Must provide flag PRE or POST");
        }
        if ((aVarValueAt.flags & 12) == 0) {
            this.Ah.removeAt(iIndexOfKey);
            a.a(aVarValueAt);
        }
        return bVar;
    }

    final void a(long j, al.x xVar) {
        this.Ai.put(j, xVar);
    }

    final void c(al.x xVar, al.f.b bVar) {
        a aVarHo = this.Ah.get(xVar);
        if (aVarHo == null) {
            aVarHo = a.ho();
            this.Ah.put(xVar, aVarHo);
        }
        aVarHo.flags |= 2;
        aVarHo.Aj = bVar;
    }

    final boolean H(al.x xVar) {
        a aVar = this.Ah.get(xVar);
        return (aVar == null || (aVar.flags & 4) == 0) ? false : true;
    }

    final al.x j(long j) {
        return this.Ai.get(j);
    }

    final void d(al.x xVar, al.f.b bVar) {
        a aVarHo = this.Ah.get(xVar);
        if (aVarHo == null) {
            aVarHo = a.ho();
            this.Ah.put(xVar, aVarHo);
        }
        aVarHo.Ak = bVar;
        aVarHo.flags |= 8;
    }

    final void I(al.x xVar) {
        a aVarHo = this.Ah.get(xVar);
        if (aVarHo == null) {
            aVarHo = a.ho();
            this.Ah.put(xVar, aVarHo);
        }
        aVarHo.flags |= 1;
    }

    final void J(al.x xVar) {
        a aVar = this.Ah.get(xVar);
        if (aVar == null) {
            return;
        }
        aVar.flags &= -2;
    }

    final void a(b bVar) {
        for (int size = this.Ah.size() - 1; size >= 0; size--) {
            al.x xVarKeyAt = this.Ah.keyAt(size);
            a aVarRemoveAt = this.Ah.removeAt(size);
            if ((aVarRemoveAt.flags & 3) == 3) {
                bVar.l(xVarKeyAt);
            } else if ((aVarRemoveAt.flags & 1) != 0) {
                if (aVarRemoveAt.Aj == null) {
                    bVar.l(xVarKeyAt);
                } else {
                    bVar.c(xVarKeyAt, aVarRemoveAt.Aj, aVarRemoveAt.Ak);
                }
            } else if ((aVarRemoveAt.flags & 14) == 14) {
                bVar.d(xVarKeyAt, aVarRemoveAt.Aj, aVarRemoveAt.Ak);
            } else if ((aVarRemoveAt.flags & 12) == 12) {
                bVar.e(xVarKeyAt, aVarRemoveAt.Aj, aVarRemoveAt.Ak);
            } else if ((aVarRemoveAt.flags & 4) != 0) {
                bVar.c(xVarKeyAt, aVarRemoveAt.Aj, null);
            } else if ((aVarRemoveAt.flags & 8) != 0) {
                bVar.d(xVarKeyAt, aVarRemoveAt.Aj, aVarRemoveAt.Ak);
            }
            a.a(aVarRemoveAt);
        }
    }

    final void K(al.x xVar) {
        int size = this.Ai.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            if (xVar == this.Ai.valueAt(size)) {
                this.Ai.removeAt(size);
                break;
            }
            size--;
        }
        a aVarRemove = this.Ah.remove(xVar);
        if (aVarRemove != null) {
            a.a(aVarRemove);
        }
    }

    static void onDetach() {
        a.hp();
    }

    public final void L(al.x xVar) {
        J(xVar);
    }

    static class a {
        static j.a<a> Al = new j.b(20);
        al.f.b Aj;
        al.f.b Ak;
        int flags;

        private a() {
        }

        static a ho() {
            a aVarG = Al.G();
            return aVarG == null ? new a() : aVarG;
        }

        static void a(a aVar) {
            aVar.flags = 0;
            aVar.Aj = null;
            aVar.Ak = null;
            Al.j(aVar);
        }

        static void hp() {
            while (Al.G() != null) {
            }
        }
    }
}
