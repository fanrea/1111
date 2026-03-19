package lkxssdk.r;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class d {
    public static final char[] a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    public static char a(int i) throws lkxssdk.n.f {
        char[] cArr = a;
        if (i < cArr.length) {
            return cArr[i];
        }
        throw lkxssdk.n.f.a();
    }

    public static void a(lkxssdk.o.b bVar, StringBuilder sb, int i) throws lkxssdk.n.f {
        int iA;
        while (i >= 3) {
            if (bVar.a() < 10) {
                throw lkxssdk.n.f.a();
            }
            int iA2 = bVar.a(10);
            if (iA2 >= 1000) {
                throw lkxssdk.n.f.a();
            }
            sb.append(a(iA2 / 100));
            sb.append(a((iA2 / 10) % 10));
            sb.append(a(iA2 % 10));
            i -= 3;
        }
        if (i == 2) {
            if (bVar.a() < 7) {
                throw lkxssdk.n.f.a();
            }
            int iA3 = bVar.a(7);
            if (iA3 >= 100) {
                throw lkxssdk.n.f.a();
            }
            sb.append(a(iA3 / 10));
            iA = iA3 % 10;
        } else {
            if (i != 1) {
                return;
            }
            if (bVar.a() < 4) {
                throw lkxssdk.n.f.a();
            }
            iA = bVar.a(4);
            if (iA >= 10) {
                throw lkxssdk.n.f.a();
            }
        }
        sb.append(a(iA));
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00bd A[PHI: r10 r20
  0x00bd: PHI (r10v6 int) = (r10v1 int), (r10v5 int), (r10v1 int) binds: [B:49:0x009f, B:58:0x00b8, B:43:0x0091] A[DONT_GENERATE, DONT_INLINE]
  0x00bd: PHI (r20v6 byte[]) = (r20v5 byte[]), (r20v5 byte[]), (r20v7 byte[]) binds: [B:49:0x009f, B:58:0x00b8, B:43:0x0091] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(lkxssdk.o.b r21, java.lang.StringBuilder r22, int r23, lkxssdk.o.c r24, java.util.Collection<byte[]> r25, java.util.Map<lkxssdk.n.e, ?> r26) throws lkxssdk.n.f {
        /*
            Method dump skipped, instructions count: 411
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: lkxssdk.r.d.a(lkxssdk.o.b, java.lang.StringBuilder, int, lkxssdk.o.c, java.util.Collection, java.util.Map):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(lkxssdk.o.b r3, java.lang.StringBuilder r4, int r5, boolean r6) throws lkxssdk.n.f {
        /*
            int r0 = r4.length()
        L4:
            r1 = 1
            if (r5 <= r1) goto L2d
            int r1 = r3.a()
            r2 = 11
            if (r1 < r2) goto L28
            int r1 = r3.a(r2)
            int r2 = r1 / 45
            char r2 = a(r2)
            r4.append(r2)
            int r1 = r1 % 45
            char r1 = a(r1)
            r4.append(r1)
            int r5 = r5 + (-2)
            goto L4
        L28:
            lkxssdk.n.f r3 = lkxssdk.n.f.a()
            throw r3
        L2d:
            if (r5 != r1) goto L47
            int r5 = r3.a()
            r2 = 6
            if (r5 < r2) goto L42
            int r3 = r3.a(r2)
            char r3 = a(r3)
            r4.append(r3)
            goto L47
        L42:
            lkxssdk.n.f r3 = lkxssdk.n.f.a()
            throw r3
        L47:
            if (r6 == 0) goto L72
        L49:
            int r3 = r4.length()
            if (r0 >= r3) goto L72
            char r3 = r4.charAt(r0)
            r5 = 37
            if (r3 != r5) goto L6f
            int r3 = r4.length()
            int r3 = r3 - r1
            if (r0 >= r3) goto L6a
            int r3 = r0 + 1
            char r6 = r4.charAt(r3)
            if (r6 != r5) goto L6a
            r4.deleteCharAt(r3)
            goto L6f
        L6a:
            r3 = 29
            r4.setCharAt(r0, r3)
        L6f:
            int r0 = r0 + 1
            goto L49
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: lkxssdk.r.d.a(lkxssdk.o.b, java.lang.StringBuilder, int, boolean):void");
    }
}
