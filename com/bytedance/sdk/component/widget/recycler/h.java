package com.bytedance.sdk.component.widget.recycler;

import com.bytedance.sdk.component.widget.recycler.d;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class h {
    final d d;

    interface d {
        d.hc d(int i, int i2, int i3, Object obj);

        void d(d.hc hcVar);
    }

    h(d dVar) {
        this.d = dVar;
    }

    void d(List<d.hc> list) {
        while (true) {
            int iHc = hc(list);
            if (iHc == -1) {
                return;
            } else {
                d(list, iHc, iHc + 1);
            }
        }
    }

    private void d(List<d.hc> list, int i, int i2) {
        d.hc hcVar = list.get(i);
        d.hc hcVar2 = list.get(i2);
        int i3 = hcVar2.d;
        if (i3 == 1) {
            b(list, i, hcVar, i2, hcVar2);
        } else if (i3 == 2) {
            d(list, i, hcVar, i2, hcVar2);
        } else {
            if (i3 != 4) {
                return;
            }
            hc(list, i, hcVar, i2, hcVar2);
        }
    }

    void d(List<d.hc> list, int i, d.hc hcVar, int i2, d.hc hcVar2) {
        boolean z;
        boolean z2 = false;
        if (hcVar.hc < hcVar.c) {
            if (hcVar2.hc == hcVar.hc && hcVar2.c == hcVar.c - hcVar.hc) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (hcVar2.hc == hcVar.c + 1 && hcVar2.c == hcVar.hc - hcVar.c) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        if (hcVar.c < hcVar2.hc) {
            hcVar2.hc--;
        } else if (hcVar.c < hcVar2.hc + hcVar2.c) {
            hcVar2.c--;
            hcVar.d = 2;
            hcVar.c = 1;
            if (hcVar2.c == 0) {
                list.remove(i2);
                this.d.d(hcVar2);
                return;
            }
            return;
        }
        d.hc hcVarD = null;
        if (hcVar.hc <= hcVar2.hc) {
            hcVar2.hc++;
        } else if (hcVar.hc < hcVar2.hc + hcVar2.c) {
            hcVarD = this.d.d(2, hcVar.hc + 1, (hcVar2.hc + hcVar2.c) - hcVar.hc, null);
            hcVar2.c = hcVar.hc - hcVar2.hc;
        }
        if (z2) {
            list.set(i, hcVar2);
            list.remove(i2);
            this.d.d(hcVar);
            return;
        }
        if (z) {
            if (hcVarD != null) {
                if (hcVar.hc > hcVarD.hc) {
                    hcVar.hc -= hcVarD.c;
                }
                if (hcVar.c > hcVarD.hc) {
                    hcVar.c -= hcVarD.c;
                }
            }
            if (hcVar.hc > hcVar2.hc) {
                hcVar.hc -= hcVar2.c;
            }
            if (hcVar.c > hcVar2.hc) {
                hcVar.c -= hcVar2.c;
            }
        } else {
            if (hcVarD != null) {
                if (hcVar.hc >= hcVarD.hc) {
                    hcVar.hc -= hcVarD.c;
                }
                if (hcVar.c >= hcVarD.hc) {
                    hcVar.c -= hcVarD.c;
                }
            }
            if (hcVar.hc >= hcVar2.hc) {
                hcVar.hc -= hcVar2.c;
            }
            if (hcVar.c >= hcVar2.hc) {
                hcVar.c -= hcVar2.c;
            }
        }
        list.set(i, hcVar2);
        if (hcVar.hc != hcVar.c) {
            list.set(i2, hcVar);
        } else {
            list.remove(i2);
        }
        if (hcVarD != null) {
            list.add(i, hcVarD);
        }
    }

    private void b(List<d.hc> list, int i, d.hc hcVar, int i2, d.hc hcVar2) {
        int i3 = hcVar.c < hcVar2.hc ? -1 : 0;
        if (hcVar.hc < hcVar2.hc) {
            i3++;
        }
        if (hcVar2.hc <= hcVar.hc) {
            hcVar.hc += hcVar2.c;
        }
        if (hcVar2.hc <= hcVar.c) {
            hcVar.c += hcVar2.c;
        }
        hcVar2.hc += i3;
        list.set(i, hcVar2);
        list.set(i2, hcVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void hc(java.util.List<com.bytedance.sdk.component.widget.recycler.d.hc> r8, int r9, com.bytedance.sdk.component.widget.recycler.d.hc r10, int r11, com.bytedance.sdk.component.widget.recycler.d.hc r12) {
        /*
            r7 = this;
            int r0 = r10.c
            int r1 = r12.hc
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 >= r1) goto Lf
            int r0 = r12.hc
            int r0 = r0 - r4
            r12.hc = r0
            goto L28
        Lf:
            int r0 = r10.c
            int r1 = r12.hc
            int r5 = r12.c
            int r1 = r1 + r5
            if (r0 >= r1) goto L28
            int r0 = r12.c
            int r0 = r0 - r4
            r12.c = r0
            com.bytedance.sdk.component.widget.recycler.h$d r0 = r7.d
            int r1 = r10.hc
            java.lang.Object r5 = r12.b
            com.bytedance.sdk.component.widget.recycler.d$hc r0 = r0.d(r2, r1, r4, r5)
            goto L29
        L28:
            r0 = r3
        L29:
            int r1 = r10.hc
            int r5 = r12.hc
            if (r1 > r5) goto L35
            int r1 = r12.hc
            int r1 = r1 + r4
            r12.hc = r1
            goto L56
        L35:
            int r1 = r10.hc
            int r5 = r12.hc
            int r6 = r12.c
            int r5 = r5 + r6
            if (r1 >= r5) goto L56
            int r1 = r12.hc
            int r3 = r12.c
            int r1 = r1 + r3
            int r3 = r10.hc
            int r1 = r1 - r3
            com.bytedance.sdk.component.widget.recycler.h$d r3 = r7.d
            int r5 = r10.hc
            int r5 = r5 + r4
            java.lang.Object r4 = r12.b
            com.bytedance.sdk.component.widget.recycler.d$hc r3 = r3.d(r2, r5, r1, r4)
            int r2 = r12.c
            int r2 = r2 - r1
            r12.c = r2
        L56:
            r8.set(r11, r10)
            int r10 = r12.c
            if (r10 <= 0) goto L61
            r8.set(r9, r12)
            goto L69
        L61:
            r8.remove(r9)
            com.bytedance.sdk.component.widget.recycler.h$d r10 = r7.d
            r10.d(r12)
        L69:
            if (r0 == 0) goto L6e
            r8.add(r9, r0)
        L6e:
            if (r3 == 0) goto L73
            r8.add(r9, r3)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.h.hc(java.util.List, int, com.bytedance.sdk.component.widget.recycler.d$hc, int, com.bytedance.sdk.component.widget.recycler.d$hc):void");
    }

    private int hc(List<d.hc> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).d != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }
}
