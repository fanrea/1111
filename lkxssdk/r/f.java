package lkxssdk.r;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public enum f {
    L(1),
    M(0),
    Q(3),
    H(2);

    public static final f[] e;

    static {
        f fVar = L;
        f fVar2 = M;
        f fVar3 = Q;
        e = new f[]{fVar2, fVar, H, fVar3};
    }

    f(int i) {
    }

    public static f a(int i) {
        if (i >= 0) {
            f[] fVarArr = e;
            if (i < fVarArr.length) {
                return fVarArr[i];
            }
        }
        throw new IllegalArgumentException();
    }
}
