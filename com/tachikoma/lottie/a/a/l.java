package com.tachikoma.lottie.a.a;

import android.graphics.Path;
import android.os.Build;
import com.tachikoma.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class l implements j, m {
    private final MergePaths Jj;
    private final String name;
    private final Path Jh = new Path();
    private final Path Ji = new Path();
    private final Path Iz = new Path();
    private final List<m> IQ = new ArrayList();

    public l(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.name = mergePaths.getName();
        this.Jj = mergePaths;
    }

    @Override // com.tachikoma.lottie.a.a.j
    public final void a(ListIterator<c> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            c cVarPrevious = listIterator.previous();
            if (cVarPrevious instanceof m) {
                this.IQ.add((m) cVarPrevious);
                listIterator.remove();
            }
        }
    }

    @Override // com.tachikoma.lottie.a.a.c
    public final void b(List<c> list, List<c> list2) {
        for (int i = 0; i < this.IQ.size(); i++) {
            this.IQ.get(i).b(list, list2);
        }
    }

    @Override // com.tachikoma.lottie.a.a.m
    public final Path getPath() {
        this.Iz.reset();
        if (this.Jj.isHidden()) {
            return this.Iz;
        }
        int i = AnonymousClass1.Jk[this.Jj.lf().ordinal()];
        if (i == 1) {
            jU();
        } else if (i == 2) {
            a(Path.Op.UNION);
        } else if (i == 3) {
            a(Path.Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            a(Path.Op.INTERSECT);
        } else if (i == 5) {
            a(Path.Op.XOR);
        }
        return this.Iz;
    }

    /* renamed from: com.tachikoma.lottie.a.a.l$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Jk = new int[MergePaths.MergePathsMode.values().length];

        static {
            try {
                Jk[MergePaths.MergePathsMode.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Jk[MergePaths.MergePathsMode.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Jk[MergePaths.MergePathsMode.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Jk[MergePaths.MergePathsMode.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                Jk[MergePaths.MergePathsMode.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // com.tachikoma.lottie.a.a.c
    public final String getName() {
        return this.name;
    }

    private void jU() {
        for (int i = 0; i < this.IQ.size(); i++) {
            this.Iz.addPath(this.IQ.get(i).getPath());
        }
    }

    private void a(Path.Op op) {
        this.Ji.reset();
        this.Jh.reset();
        for (int size = this.IQ.size() - 1; size > 0; size--) {
            m mVar = this.IQ.get(size);
            if (mVar instanceof d) {
                d dVar = (d) mVar;
                List<m> listJP = dVar.jP();
                for (int size2 = listJP.size() - 1; size2 >= 0; size2--) {
                    Path path = listJP.get(size2).getPath();
                    path.transform(dVar.jQ());
                    this.Ji.addPath(path);
                }
            } else {
                this.Ji.addPath(mVar.getPath());
            }
        }
        m mVar2 = this.IQ.get(0);
        if (mVar2 instanceof d) {
            d dVar2 = (d) mVar2;
            List<m> listJP2 = dVar2.jP();
            for (int i = 0; i < listJP2.size(); i++) {
                Path path2 = listJP2.get(i).getPath();
                path2.transform(dVar2.jQ());
                this.Jh.addPath(path2);
            }
        } else {
            this.Jh.set(mVar2.getPath());
        }
        this.Iz.op(this.Jh, this.Ji, op);
    }
}
