package android.support.v7.widget;

import android.support.v4.d.i;
import android.support.v7.widget.ah;
import android.support.v7.widget.aj;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class e implements ah.a {
    private i.a<b> lT;
    final ArrayList<b> lU;
    final ArrayList<b> lV;
    final a lW;
    Runnable lX;
    final boolean lY;
    final ah lZ;
    private int ma;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    interface a {
        aj.x Z(int i);

        void b(int i, int i2, Object obj);

        void h(b bVar);

        void i(b bVar);

        void s(int i, int i2);

        void t(int i, int i2);

        void u(int i, int i2);

        void v(int i, int i2);
    }

    e(a aVar) {
        this(aVar, false);
    }

    private e(a aVar, boolean z) {
        this.lT = new i.b(30);
        this.lU = new ArrayList<>();
        this.lV = new ArrayList<>();
        this.ma = 0;
        this.lW = aVar;
        this.lY = false;
        this.lZ = new ah(this);
    }

    final void reset() {
        c(this.lU);
        c(this.lV);
        this.ma = 0;
    }

    final void cy() {
        this.lZ.e(this.lU);
        int size = this.lU.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.lU.get(i);
            int i2 = bVar.mb;
            if (i2 == 1) {
                e(bVar);
            } else if (i2 == 2) {
                b(bVar);
            } else if (i2 == 4) {
                c(bVar);
            } else if (i2 == 8) {
                a(bVar);
            }
            Runnable runnable = this.lX;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.lU.clear();
    }

    final void cz() {
        int size = this.lV.size();
        for (int i = 0; i < size; i++) {
            this.lW.i(this.lV.get(i));
        }
        c(this.lV);
        this.ma = 0;
    }

    private void a(b bVar) {
        f(bVar);
    }

    private void b(b bVar) {
        boolean z;
        char c;
        int i = bVar.mc;
        int i2 = bVar.mc + bVar.me;
        int i3 = bVar.mc;
        int i4 = 0;
        char c2 = 65535;
        while (i3 < i2) {
            if (this.lW.Z(i3) != null || V(i3)) {
                if (c2 == 0) {
                    d(a(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                c = 1;
            } else {
                if (c2 == 1) {
                    f(a(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                c = 0;
            }
            if (z) {
                i3 -= i4;
                i2 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i3++;
            c2 = c;
        }
        if (i4 != bVar.me) {
            g(bVar);
            bVar = a(2, i, i4, null);
        }
        if (c2 == 0) {
            d(bVar);
        } else {
            f(bVar);
        }
    }

    private void c(b bVar) {
        int i = bVar.mc;
        int i2 = bVar.mc + bVar.me;
        int i3 = i;
        int i4 = 0;
        char c = 65535;
        for (int i5 = bVar.mc; i5 < i2; i5++) {
            if (this.lW.Z(i5) != null || V(i5)) {
                if (c == 0) {
                    d(a(4, i3, i4, bVar.md));
                    i3 = i5;
                    i4 = 0;
                }
                c = 1;
            } else {
                if (c == 1) {
                    f(a(4, i3, i4, bVar.md));
                    i3 = i5;
                    i4 = 0;
                }
                c = 0;
            }
            i4++;
        }
        if (i4 != bVar.me) {
            Object obj = bVar.md;
            g(bVar);
            bVar = a(4, i3, i4, obj);
        }
        if (c == 0) {
            d(bVar);
        } else {
            f(bVar);
        }
    }

    private void d(b bVar) {
        int i;
        if (bVar.mb == 1 || bVar.mb == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iO = o(bVar.mc, bVar.mb);
        int i2 = bVar.mc;
        int i3 = bVar.mb;
        if (i3 == 2) {
            i = 0;
        } else {
            if (i3 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i = 1;
        }
        int i4 = iO;
        int i5 = i2;
        int i6 = 1;
        for (int i7 = 1; i7 < bVar.me; i7++) {
            int iO2 = o(bVar.mc + (i * i7), bVar.mb);
            int i8 = bVar.mb;
            if (i8 == 2 ? iO2 == i4 : i8 == 4 && iO2 == i4 + 1) {
                i6++;
            } else {
                b bVarA = a(bVar.mb, i4, i6, bVar.md);
                a(bVarA, i5);
                g(bVarA);
                if (bVar.mb == 4) {
                    i5 += i6;
                }
                i4 = iO2;
                i6 = 1;
            }
        }
        Object obj = bVar.md;
        g(bVar);
        if (i6 > 0) {
            b bVarA2 = a(bVar.mb, i4, i6, obj);
            a(bVarA2, i5);
            g(bVarA2);
        }
    }

    private void a(b bVar, int i) {
        this.lW.h(bVar);
        int i2 = bVar.mb;
        if (i2 == 2) {
            this.lW.s(i, bVar.me);
        } else {
            if (i2 == 4) {
                this.lW.b(i, bVar.me, bVar.md);
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private int o(int i, int i2) {
        int i3;
        int i4;
        for (int size = this.lV.size() - 1; size >= 0; size--) {
            b bVar = this.lV.get(size);
            if (bVar.mb == 8) {
                if (bVar.mc < bVar.me) {
                    i3 = bVar.mc;
                    i4 = bVar.me;
                } else {
                    i3 = bVar.me;
                    i4 = bVar.mc;
                }
                if (i >= i3 && i <= i4) {
                    if (i3 == bVar.mc) {
                        if (i2 == 1) {
                            bVar.me++;
                        } else if (i2 == 2) {
                            bVar.me--;
                        }
                        i++;
                    } else {
                        if (i2 == 1) {
                            bVar.mc++;
                        } else if (i2 == 2) {
                            bVar.mc--;
                        }
                        i--;
                    }
                } else if (i < bVar.mc) {
                    if (i2 == 1) {
                        bVar.mc++;
                        bVar.me++;
                    } else if (i2 == 2) {
                        bVar.mc--;
                        bVar.me--;
                    }
                }
            } else if (bVar.mc <= i) {
                if (bVar.mb == 1) {
                    i -= bVar.me;
                } else if (bVar.mb == 2) {
                    i += bVar.me;
                }
            } else if (i2 == 1) {
                bVar.mc++;
            } else if (i2 == 2) {
                bVar.mc--;
            }
        }
        for (int size2 = this.lV.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.lV.get(size2);
            if (bVar2.mb == 8) {
                if (bVar2.me == bVar2.mc || bVar2.me < 0) {
                    this.lV.remove(size2);
                    g(bVar2);
                }
            } else if (bVar2.me <= 0) {
                this.lV.remove(size2);
                g(bVar2);
            }
        }
        return i;
    }

    private boolean V(int i) {
        int size = this.lV.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.lV.get(i2);
            if (bVar.mb == 8) {
                if (p(bVar.me, i2 + 1) == i) {
                    return true;
                }
            } else if (bVar.mb == 1) {
                int i3 = bVar.mc + bVar.me;
                for (int i4 = bVar.mc; i4 < i3; i4++) {
                    if (p(i4, i2 + 1) == i) {
                        return true;
                    }
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void e(b bVar) {
        f(bVar);
    }

    private void f(b bVar) {
        this.lV.add(bVar);
        int i = bVar.mb;
        if (i == 1) {
            this.lW.u(bVar.mc, bVar.me);
            return;
        }
        if (i == 2) {
            this.lW.t(bVar.mc, bVar.me);
            return;
        }
        if (i == 4) {
            this.lW.b(bVar.mc, bVar.me, bVar.md);
        } else if (i == 8) {
            this.lW.v(bVar.mc, bVar.me);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    final boolean cA() {
        return this.lU.size() > 0;
    }

    final boolean W(int i) {
        return (i & this.ma) != 0;
    }

    final int X(int i) {
        return p(i, 0);
    }

    private int p(int i, int i2) {
        int size = this.lV.size();
        while (i2 < size) {
            b bVar = this.lV.get(i2);
            if (bVar.mb == 8) {
                if (bVar.mc == i) {
                    i = bVar.me;
                } else {
                    if (bVar.mc < i) {
                        i--;
                    }
                    if (bVar.me <= i) {
                        i++;
                    }
                }
            } else if (bVar.mc > i) {
                continue;
            } else if (bVar.mb == 2) {
                if (i < bVar.mc + bVar.me) {
                    return -1;
                }
                i -= bVar.me;
            } else if (bVar.mb == 1) {
                i += bVar.me;
            }
            i2++;
        }
        return i;
    }

    final boolean a(int i, int i2, Object obj) {
        if (i2 <= 0) {
            return false;
        }
        this.lU.add(a(4, i, i2, obj));
        this.ma |= 4;
        return this.lU.size() == 1;
    }

    final boolean q(int i, int i2) {
        if (i2 <= 0) {
            return false;
        }
        this.lU.add(a(1, i, i2, null));
        this.ma |= 1;
        return this.lU.size() == 1;
    }

    final boolean r(int i, int i2) {
        if (i2 <= 0) {
            return false;
        }
        this.lU.add(a(2, i, i2, null));
        this.ma |= 2;
        return this.lU.size() == 1;
    }

    final boolean d(int i, int i2, int i3) {
        if (i == i2) {
            return false;
        }
        if (i3 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.lU.add(a(8, i, i2, null));
        this.ma |= 8;
        return this.lU.size() == 1;
    }

    final void cB() {
        cz();
        int size = this.lU.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.lU.get(i);
            int i2 = bVar.mb;
            if (i2 == 1) {
                this.lW.i(bVar);
                this.lW.u(bVar.mc, bVar.me);
            } else if (i2 == 2) {
                this.lW.i(bVar);
                this.lW.s(bVar.mc, bVar.me);
            } else if (i2 == 4) {
                this.lW.i(bVar);
                this.lW.b(bVar.mc, bVar.me, bVar.md);
            } else if (i2 == 8) {
                this.lW.i(bVar);
                this.lW.v(bVar.mc, bVar.me);
            }
            Runnable runnable = this.lX;
            if (runnable != null) {
                runnable.run();
            }
        }
        c(this.lU);
        this.ma = 0;
    }

    public final int Y(int i) {
        int size = this.lU.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.lU.get(i2);
            int i3 = bVar.mb;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 8) {
                        if (bVar.mc == i) {
                            i = bVar.me;
                        } else {
                            if (bVar.mc < i) {
                                i--;
                            }
                            if (bVar.me <= i) {
                                i++;
                            }
                        }
                    }
                } else if (bVar.mc > i) {
                    continue;
                } else {
                    if (bVar.mc + bVar.me > i) {
                        return -1;
                    }
                    i -= bVar.me;
                }
            } else if (bVar.mc <= i) {
                i += bVar.me;
            }
        }
        return i;
    }

    final boolean cC() {
        return (this.lV.isEmpty() || this.lU.isEmpty()) ? false : true;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class b {
        int mb;
        int mc;
        Object md;
        int me;

        b(int i, int i2, int i3, Object obj) {
            this.mb = i;
            this.mc = i2;
            this.me = i3;
            this.md = obj;
        }

        private String cD() {
            int i = this.mb;
            return i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : com.kuaishou.weapon.p0.t.w : "add";
        }

        public final String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + cD() + ",s:" + this.mc + "c:" + this.me + ",p:" + this.md + "]";
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i = this.mb;
            if (i != bVar.mb) {
                return false;
            }
            if (i == 8 && Math.abs(this.me - this.mc) == 1 && this.me == bVar.mc && this.mc == bVar.me) {
                return true;
            }
            if (this.me != bVar.me || this.mc != bVar.mc) {
                return false;
            }
            Object obj2 = this.md;
            if (obj2 != null) {
                if (!obj2.equals(bVar.md)) {
                    return false;
                }
            } else if (bVar.md != null) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return (((this.mb * 31) + this.mc) * 31) + this.me;
        }
    }

    @Override // android.support.v7.widget.ah.a
    public final b a(int i, int i2, int i3, Object obj) {
        b bVarV = this.lT.V();
        if (bVarV == null) {
            return new b(i, i2, i3, obj);
        }
        bVarV.mb = i;
        bVarV.mc = i2;
        bVarV.me = i3;
        bVarV.md = obj;
        return bVarV;
    }

    @Override // android.support.v7.widget.ah.a
    public final void g(b bVar) {
        if (this.lY) {
            return;
        }
        bVar.md = null;
        this.lT.release(bVar);
    }

    private void c(List<b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            g(list.get(i));
        }
        list.clear();
    }
}
