package android.support.v7.widget;

import android.support.v7.widget.e;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class ah {
    final a rm;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    interface a {
        e.b a(int i, int i2, int i3, Object obj);

        void g(e.b bVar);
    }

    ah(a aVar) {
        this.rm = aVar;
    }

    final void e(List<e.b> list) {
        while (true) {
            int iF = f(list);
            if (iF == -1) {
                return;
            } else {
                a(list, iF, iF + 1);
            }
        }
    }

    private void a(List<e.b> list, int i, int i2) {
        e.b bVar = list.get(i);
        e.b bVar2 = list.get(i2);
        int i3 = bVar2.mb;
        if (i3 == 1) {
            b(list, i, bVar, i2, bVar2);
        } else if (i3 == 2) {
            a(list, i, bVar, i2, bVar2);
        } else {
            if (i3 != 4) {
                return;
            }
            c(list, i, bVar, i2, bVar2);
        }
    }

    private void a(List<e.b> list, int i, e.b bVar, int i2, e.b bVar2) {
        boolean z;
        boolean z2 = false;
        if (bVar.mc < bVar.me) {
            if (bVar2.mc == bVar.mc && bVar2.me == bVar.me - bVar.mc) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (bVar2.mc == bVar.me + 1 && bVar2.me == bVar.mc - bVar.me) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        if (bVar.me < bVar2.mc) {
            bVar2.mc--;
        } else if (bVar.me < bVar2.mc + bVar2.me) {
            bVar2.me--;
            bVar.mb = 2;
            bVar.me = 1;
            if (bVar2.me == 0) {
                list.remove(i2);
                this.rm.g(bVar2);
                return;
            }
            return;
        }
        e.b bVarA = null;
        if (bVar.mc <= bVar2.mc) {
            bVar2.mc++;
        } else if (bVar.mc < bVar2.mc + bVar2.me) {
            bVarA = this.rm.a(2, bVar.mc + 1, (bVar2.mc + bVar2.me) - bVar.mc, null);
            bVar2.me = bVar.mc - bVar2.mc;
        }
        if (z2) {
            list.set(i, bVar2);
            list.remove(i2);
            this.rm.g(bVar);
            return;
        }
        if (z) {
            if (bVarA != null) {
                if (bVar.mc > bVarA.mc) {
                    bVar.mc -= bVarA.me;
                }
                if (bVar.me > bVarA.mc) {
                    bVar.me -= bVarA.me;
                }
            }
            if (bVar.mc > bVar2.mc) {
                bVar.mc -= bVar2.me;
            }
            if (bVar.me > bVar2.mc) {
                bVar.me -= bVar2.me;
            }
        } else {
            if (bVarA != null) {
                if (bVar.mc >= bVarA.mc) {
                    bVar.mc -= bVarA.me;
                }
                if (bVar.me >= bVarA.mc) {
                    bVar.me -= bVarA.me;
                }
            }
            if (bVar.mc >= bVar2.mc) {
                bVar.mc -= bVar2.me;
            }
            if (bVar.me >= bVar2.mc) {
                bVar.me -= bVar2.me;
            }
        }
        list.set(i, bVar2);
        if (bVar.mc != bVar.me) {
            list.set(i2, bVar);
        } else {
            list.remove(i2);
        }
        if (bVarA != null) {
            list.add(i, bVarA);
        }
    }

    private static void b(List<e.b> list, int i, e.b bVar, int i2, e.b bVar2) {
        int i3 = bVar.me < bVar2.mc ? -1 : 0;
        if (bVar.mc < bVar2.mc) {
            i3++;
        }
        if (bVar2.mc <= bVar.mc) {
            bVar.mc += bVar2.me;
        }
        if (bVar2.mc <= bVar.me) {
            bVar.me += bVar2.me;
        }
        bVar2.mc += i3;
        list.set(i, bVar2);
        list.set(i2, bVar);
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
    private void c(java.util.List<android.support.v7.widget.e.b> r8, int r9, android.support.v7.widget.e.b r10, int r11, android.support.v7.widget.e.b r12) {
        /*
            r7 = this;
            int r0 = r10.me
            int r1 = r12.mc
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 >= r1) goto Lf
            int r0 = r12.mc
            int r0 = r0 - r4
            r12.mc = r0
            goto L28
        Lf:
            int r0 = r10.me
            int r1 = r12.mc
            int r5 = r12.me
            int r1 = r1 + r5
            if (r0 >= r1) goto L28
            int r0 = r12.me
            int r0 = r0 - r4
            r12.me = r0
            android.support.v7.widget.ah$a r0 = r7.rm
            int r1 = r10.mc
            java.lang.Object r5 = r12.md
            android.support.v7.widget.e$b r0 = r0.a(r2, r1, r4, r5)
            goto L29
        L28:
            r0 = r3
        L29:
            int r1 = r10.mc
            int r5 = r12.mc
            if (r1 > r5) goto L35
            int r1 = r12.mc
            int r1 = r1 + r4
            r12.mc = r1
            goto L56
        L35:
            int r1 = r10.mc
            int r5 = r12.mc
            int r6 = r12.me
            int r5 = r5 + r6
            if (r1 >= r5) goto L56
            int r1 = r12.mc
            int r3 = r12.me
            int r1 = r1 + r3
            int r3 = r10.mc
            int r1 = r1 - r3
            android.support.v7.widget.ah$a r3 = r7.rm
            int r5 = r10.mc
            int r5 = r5 + r4
            java.lang.Object r4 = r12.md
            android.support.v7.widget.e$b r3 = r3.a(r2, r5, r1, r4)
            int r2 = r12.me
            int r2 = r2 - r1
            r12.me = r2
        L56:
            r8.set(r11, r10)
            int r10 = r12.me
            if (r10 <= 0) goto L61
            r8.set(r9, r12)
            goto L69
        L61:
            r8.remove(r9)
            android.support.v7.widget.ah$a r10 = r7.rm
            r10.g(r12)
        L69:
            if (r0 == 0) goto L6e
            r8.add(r9, r0)
        L6e:
            if (r3 == 0) goto L73
            r8.add(r9, r3)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ah.c(java.util.List, int, android.support.v7.widget.e$b, int, android.support.v7.widget.e$b):void");
    }

    private static int f(List<e.b> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).mb != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }
}
