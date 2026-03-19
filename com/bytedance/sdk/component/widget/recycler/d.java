package com.bytedance.sdk.component.widget.recycler;

import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.component.widget.recycler.d.hc.c;
import com.bytedance.sdk.component.widget.recycler.h;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class d implements h.d {
    final h an;
    final InterfaceC0289d b;
    Runnable c;
    final ArrayList<hc> d;
    private int gb;
    private c.d<hc> h;
    final ArrayList<hc> hc;
    final boolean u;

    /* renamed from: com.bytedance.sdk.component.widget.recycler.d$d, reason: collision with other inner class name */
    interface InterfaceC0289d {
        void b(int i, int i2);

        void c(int i, int i2);

        RecyclerView.v d(int i);

        void d(int i, int i2);

        void d(int i, int i2, Object obj);

        void hc(int i, int i2);
    }

    d(InterfaceC0289d interfaceC0289d) {
        this(interfaceC0289d, false);
    }

    d(InterfaceC0289d interfaceC0289d, boolean z) {
        this.h = new c.hc(30);
        this.d = new ArrayList<>();
        this.hc = new ArrayList<>();
        this.gb = 0;
        this.b = interfaceC0289d;
        this.u = z;
        this.an = new h(this);
    }

    void d() {
        d(this.d);
        d(this.hc);
        this.gb = 0;
    }

    void hc() {
        this.an.d(this.d);
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            hc hcVar = this.d.get(i);
            int i2 = hcVar.d;
            if (i2 == 1) {
                an(hcVar);
            } else if (i2 == 2) {
                b(hcVar);
            } else if (i2 == 4) {
                c(hcVar);
            } else if (i2 == 8) {
                hc(hcVar);
            }
            Runnable runnable = this.c;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.d.clear();
    }

    void b() {
        int size = this.hc.size();
        for (int i = 0; i < size; i++) {
            this.hc.get(i);
        }
        d(this.hc);
        this.gb = 0;
    }

    private void hc(hc hcVar) {
        h(hcVar);
    }

    private void b(hc hcVar) {
        boolean z;
        char c;
        int i = hcVar.hc;
        int i2 = hcVar.hc + hcVar.c;
        int i3 = hcVar.hc;
        char c2 = 65535;
        int i4 = 0;
        while (i3 < i2) {
            if (this.b.d(i3) != null || c(i3)) {
                if (c2 == 0) {
                    u(d(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                c = 1;
            } else {
                if (c2 == 1) {
                    h(d(2, i, i4, null));
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
        if (i4 != hcVar.c) {
            d(hcVar);
            hcVar = d(2, i, i4, null);
        }
        if (c2 == 0) {
            u(hcVar);
        } else {
            h(hcVar);
        }
    }

    private void c(hc hcVar) {
        int i = hcVar.hc;
        int i2 = hcVar.hc + hcVar.c;
        char c = 65535;
        int i3 = 0;
        for (int i4 = hcVar.hc; i4 < i2; i4++) {
            if (this.b.d(i4) != null || c(i4)) {
                if (c == 0) {
                    u(d(4, i, i3, hcVar.b));
                    i = i4;
                    i3 = 0;
                }
                c = 1;
            } else {
                if (c == 1) {
                    h(d(4, i, i3, hcVar.b));
                    i = i4;
                    i3 = 0;
                }
                c = 0;
            }
            i3++;
        }
        if (i3 != hcVar.c) {
            Object obj = hcVar.b;
            d(hcVar);
            hcVar = d(4, i, i3, obj);
        }
        if (c == 0) {
            u(hcVar);
        } else {
            h(hcVar);
        }
    }

    private void u(hc hcVar) {
        int i;
        if (hcVar.d != 1 && hcVar.d != 8) {
            int iHc = hc(hcVar.hc, hcVar.d);
            int i2 = hcVar.hc;
            int i3 = hcVar.d;
            if (i3 == 2) {
                i = 0;
            } else {
                if (i3 != 4) {
                    throw new IllegalArgumentException("op should be remove or update.".concat(String.valueOf(hcVar)));
                }
                i = 1;
            }
            int i4 = 1;
            for (int i5 = 1; i5 < hcVar.c; i5++) {
                int iHc2 = hc(hcVar.hc + (i * i5), hcVar.d);
                int i6 = hcVar.d;
                if (i6 == 2 ? iHc2 == iHc : i6 == 4 && iHc2 == iHc + 1) {
                    i4++;
                } else {
                    hc hcVarD = d(hcVar.d, iHc, i4, hcVar.b);
                    d(hcVarD, i2);
                    d(hcVarD);
                    if (hcVar.d == 4) {
                        i2 += i4;
                    }
                    i4 = 1;
                    iHc = iHc2;
                }
            }
            Object obj = hcVar.b;
            d(hcVar);
            if (i4 > 0) {
                hc hcVarD2 = d(hcVar.d, iHc, i4, obj);
                d(hcVarD2, i2);
                d(hcVarD2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    void d(hc hcVar, int i) {
        int i2 = hcVar.d;
        if (i2 == 2) {
            this.b.d(i, hcVar.c);
        } else {
            if (i2 == 4) {
                this.b.d(i, hcVar.c, hcVar.b);
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private int hc(int i, int i2) {
        int i3;
        int i4;
        for (int size = this.hc.size() - 1; size >= 0; size--) {
            hc hcVar = this.hc.get(size);
            if (hcVar.d == 8) {
                if (hcVar.hc < hcVar.c) {
                    i3 = hcVar.hc;
                    i4 = hcVar.c;
                } else {
                    i3 = hcVar.c;
                    i4 = hcVar.hc;
                }
                if (i >= i3 && i <= i4) {
                    if (i3 == hcVar.hc) {
                        if (i2 == 1) {
                            hcVar.c++;
                        } else if (i2 == 2) {
                            hcVar.c--;
                        }
                        i++;
                    } else {
                        if (i2 == 1) {
                            hcVar.hc++;
                        } else if (i2 == 2) {
                            hcVar.hc--;
                        }
                        i--;
                    }
                } else if (i < hcVar.hc) {
                    if (i2 == 1) {
                        hcVar.hc++;
                        hcVar.c++;
                    } else if (i2 == 2) {
                        hcVar.hc--;
                        hcVar.c--;
                    }
                }
            } else if (hcVar.hc <= i) {
                if (hcVar.d == 1) {
                    i -= hcVar.c;
                } else if (hcVar.d == 2) {
                    i += hcVar.c;
                }
            } else if (i2 == 1) {
                hcVar.hc++;
            } else if (i2 == 2) {
                hcVar.hc--;
            }
        }
        for (int size2 = this.hc.size() - 1; size2 >= 0; size2--) {
            hc hcVar2 = this.hc.get(size2);
            if (hcVar2.d == 8) {
                if (hcVar2.c == hcVar2.hc || hcVar2.c < 0) {
                    this.hc.remove(size2);
                    d(hcVar2);
                }
            } else if (hcVar2.c <= 0) {
                this.hc.remove(size2);
                d(hcVar2);
            }
        }
        return i;
    }

    private boolean c(int i) {
        int size = this.hc.size();
        for (int i2 = 0; i2 < size; i2++) {
            hc hcVar = this.hc.get(i2);
            if (hcVar.d == 8) {
                if (d(hcVar.c, i2 + 1) == i) {
                    return true;
                }
            } else if (hcVar.d == 1) {
                int i3 = hcVar.hc + hcVar.c;
                for (int i4 = hcVar.hc; i4 < i3; i4++) {
                    if (d(i4, i2 + 1) == i) {
                        return true;
                    }
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void an(hc hcVar) {
        h(hcVar);
    }

    private void h(hc hcVar) {
        this.hc.add(hcVar);
        int i = hcVar.d;
        if (i == 1) {
            this.b.b(hcVar.hc, hcVar.c);
            return;
        }
        if (i == 2) {
            this.b.hc(hcVar.hc, hcVar.c);
        } else if (i == 4) {
            this.b.d(hcVar.hc, hcVar.c, hcVar.b);
        } else {
            if (i != 8) {
                throw new IllegalArgumentException("Unknown update op type for ".concat(String.valueOf(hcVar)));
            }
            this.b.c(hcVar.hc, hcVar.c);
        }
    }

    boolean c() {
        return this.d.size() > 0;
    }

    boolean d(int i) {
        return (i & this.gb) != 0;
    }

    int hc(int i) {
        return d(i, 0);
    }

    int d(int i, int i2) {
        int size = this.hc.size();
        while (i2 < size) {
            hc hcVar = this.hc.get(i2);
            if (hcVar.d == 8) {
                if (hcVar.hc == i) {
                    i = hcVar.c;
                } else {
                    if (hcVar.hc < i) {
                        i--;
                    }
                    if (hcVar.c <= i) {
                        i++;
                    }
                }
            } else if (hcVar.hc > i) {
                continue;
            } else if (hcVar.d == 2) {
                if (i < hcVar.hc + hcVar.c) {
                    return -1;
                }
                i -= hcVar.c;
            } else if (hcVar.d == 1) {
                i += hcVar.c;
            }
            i2++;
        }
        return i;
    }

    boolean d(int i, int i2, Object obj) {
        if (i2 <= 0) {
            return false;
        }
        this.d.add(d(4, i, i2, obj));
        this.gb |= 4;
        return this.d.size() == 1;
    }

    void u() {
        b();
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            hc hcVar = this.d.get(i);
            int i2 = hcVar.d;
            if (i2 == 1) {
                this.b.b(hcVar.hc, hcVar.c);
            } else if (i2 == 2) {
                this.b.d(hcVar.hc, hcVar.c);
            } else if (i2 == 4) {
                this.b.d(hcVar.hc, hcVar.c, hcVar.b);
            } else if (i2 == 8) {
                this.b.c(hcVar.hc, hcVar.c);
            }
            Runnable runnable = this.c;
            if (runnable != null) {
                runnable.run();
            }
        }
        d(this.d);
        this.gb = 0;
    }

    public int b(int i) {
        int size = this.d.size();
        for (int i2 = 0; i2 < size; i2++) {
            hc hcVar = this.d.get(i2);
            int i3 = hcVar.d;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 8) {
                        if (hcVar.hc == i) {
                            i = hcVar.c;
                        } else {
                            if (hcVar.hc < i) {
                                i--;
                            }
                            if (hcVar.c <= i) {
                                i++;
                            }
                        }
                    }
                } else if (hcVar.hc > i) {
                    continue;
                } else {
                    if (hcVar.hc + hcVar.c > i) {
                        return -1;
                    }
                    i -= hcVar.c;
                }
            } else if (hcVar.hc <= i) {
                i += hcVar.c;
            }
        }
        return i;
    }

    boolean an() {
        return (this.hc.isEmpty() || this.d.isEmpty()) ? false : true;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.h.d
    public hc d(int i, int i2, int i3, Object obj) {
        hc hcVarD = this.h.d();
        if (hcVarD == null) {
            return new hc(i, i2, i3, obj);
        }
        hcVarD.d = i;
        hcVarD.hc = i2;
        hcVarD.c = i3;
        hcVarD.b = obj;
        return hcVarD;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.h.d
    public void d(hc hcVar) {
        if (this.u) {
            return;
        }
        hcVar.b = null;
        this.h.d(hcVar);
    }

    void d(List<hc> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            d(list.get(i));
        }
        list.clear();
    }

    static class hc {
        Object b;
        int c;
        int d;
        int hc;

        hc(int i, int i2, int i3, Object obj) {
            this.d = i;
            this.hc = i2;
            this.c = i3;
            this.b = obj;
        }

        String d() {
            int i = this.d;
            return i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : t.w : "add";
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + d() + ",s:" + this.hc + "c:" + this.c + ",p:" + this.b + "]";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            hc hcVar = (hc) obj;
            int i = this.d;
            if (i != hcVar.d) {
                return false;
            }
            if (i == 8 && Math.abs(this.c - this.hc) == 1 && this.c == hcVar.hc && this.hc == hcVar.c) {
                return true;
            }
            if (this.c != hcVar.c || this.hc != hcVar.hc) {
                return false;
            }
            Object obj2 = this.b;
            if (obj2 != null) {
                if (!obj2.equals(hcVar.b)) {
                    return false;
                }
            } else if (hcVar.b != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.d * 31) + this.hc) * 31) + this.c;
        }
    }
}
