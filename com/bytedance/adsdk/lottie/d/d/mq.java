package com.bytedance.adsdk.lottie.d.d;

import android.graphics.Path;
import android.os.Build;
import com.bytedance.adsdk.lottie.model.hc.tt;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mq implements tc, uo {
    private final com.bytedance.adsdk.lottie.model.hc.tt an;
    private final String c;
    private final Path d = new Path();
    private final Path hc = new Path();
    private final Path b = new Path();
    private final List<uo> u = new ArrayList();

    public mq(com.bytedance.adsdk.lottie.model.hc.tt ttVar) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.c = ttVar.d();
        this.an = ttVar;
    }

    @Override // com.bytedance.adsdk.lottie.d.d.tc
    public void d(ListIterator<b> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            b bVarPrevious = listIterator.previous();
            if (bVarPrevious instanceof uo) {
                this.u.add((uo) bVarPrevious);
                listIterator.remove();
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.d.d.b
    public void d(List<b> list, List<b> list2) {
        for (int i = 0; i < this.u.size(); i++) {
            this.u.get(i).d(list, list2);
        }
    }

    @Override // com.bytedance.adsdk.lottie.d.d.uo
    public Path c() {
        this.b.reset();
        if (this.an.b()) {
            return this.b;
        }
        int i = AnonymousClass1.d[this.an.hc().ordinal()];
        if (i == 1) {
            d();
        } else if (i == 2) {
            d(Path.Op.UNION);
        } else if (i == 3) {
            d(Path.Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            d(Path.Op.INTERSECT);
        } else if (i == 5) {
            d(Path.Op.XOR);
        }
        return this.b;
    }

    /* renamed from: com.bytedance.adsdk.lottie.d.d.mq$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] d;

        static {
            int[] iArr = new int[tt.d.values().length];
            d = iArr;
            try {
                iArr[tt.d.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                d[tt.d.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                d[tt.d.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                d[tt.d.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                d[tt.d.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private void d() {
        for (int i = 0; i < this.u.size(); i++) {
            this.b.addPath(this.u.get(i).c());
        }
    }

    private void d(Path.Op op) {
        this.hc.reset();
        this.d.reset();
        for (int size = this.u.size() - 1; size > 0; size--) {
            uo uoVar = this.u.get(size);
            if (uoVar instanceof c) {
                c cVar = (c) uoVar;
                List<uo> listHc = cVar.hc();
                for (int size2 = listHc.size() - 1; size2 >= 0; size2--) {
                    Path pathC = listHc.get(size2).c();
                    pathC.transform(cVar.b());
                    this.hc.addPath(pathC);
                }
            } else {
                this.hc.addPath(uoVar.c());
            }
        }
        uo uoVar2 = this.u.get(0);
        if (uoVar2 instanceof c) {
            c cVar2 = (c) uoVar2;
            List<uo> listHc2 = cVar2.hc();
            for (int i = 0; i < listHc2.size(); i++) {
                Path pathC2 = listHc2.get(i).c();
                pathC2.transform(cVar2.b());
                this.d.addPath(pathC2);
            }
        } else {
            this.d.set(uoVar2.c());
        }
        this.b.op(this.d, this.hc, op);
    }
}
