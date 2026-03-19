package com.kwad.lottie.a.a;

import android.graphics.Path;
import android.os.Build;
import com.kwad.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class k implements i, l {
    private final MergePaths blQ;
    private final String name;
    private final Path blO = new Path();
    private final Path blP = new Path();
    private final Path blk = new Path();
    private final List<l> blz = new ArrayList();

    public k(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.name = mergePaths.getName();
        this.blQ = mergePaths;
    }

    @Override // com.kwad.lottie.a.a.i
    public final void a(ListIterator<b> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            b bVarPrevious = listIterator.previous();
            if (bVarPrevious instanceof l) {
                this.blz.add((l) bVarPrevious);
                listIterator.remove();
            }
        }
    }

    @Override // com.kwad.lottie.a.a.b
    public final void b(List<b> list, List<b> list2) {
        for (int i = 0; i < this.blz.size(); i++) {
            this.blz.get(i).b(list, list2);
        }
    }

    @Override // com.kwad.lottie.a.a.l
    public final Path getPath() {
        this.blk.reset();
        int i = AnonymousClass1.blR[this.blQ.RI().ordinal()];
        if (i == 1) {
            QF();
        } else if (i == 2) {
            a(Path.Op.UNION);
        } else if (i == 3) {
            a(Path.Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            a(Path.Op.INTERSECT);
        } else if (i == 5) {
            a(Path.Op.XOR);
        }
        return this.blk;
    }

    /* renamed from: com.kwad.lottie.a.a.k$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] blR;

        static {
            int[] iArr = new int[MergePaths.MergePathsMode.values().length];
            blR = iArr;
            try {
                iArr[MergePaths.MergePathsMode.Merge.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                blR[MergePaths.MergePathsMode.Add.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                blR[MergePaths.MergePathsMode.Subtract.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                blR[MergePaths.MergePathsMode.Intersect.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                blR[MergePaths.MergePathsMode.ExcludeIntersections.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // com.kwad.lottie.a.a.b
    public final String getName() {
        return this.name;
    }

    private void QF() {
        for (int i = 0; i < this.blz.size(); i++) {
            this.blk.addPath(this.blz.get(i).getPath());
        }
    }

    private void a(Path.Op op) {
        this.blP.reset();
        this.blO.reset();
        for (int size = this.blz.size() - 1; size > 0; size--) {
            l lVar = this.blz.get(size);
            if (lVar instanceof c) {
                c cVar = (c) lVar;
                List<l> listQA = cVar.QA();
                for (int size2 = listQA.size() - 1; size2 >= 0; size2--) {
                    Path path = listQA.get(size2).getPath();
                    path.transform(cVar.QB());
                    this.blP.addPath(path);
                }
            } else {
                this.blP.addPath(lVar.getPath());
            }
        }
        l lVar2 = this.blz.get(0);
        if (lVar2 instanceof c) {
            c cVar2 = (c) lVar2;
            List<l> listQA2 = cVar2.QA();
            for (int i = 0; i < listQA2.size(); i++) {
                Path path2 = listQA2.get(i).getPath();
                path2.transform(cVar2.QB());
                this.blO.addPath(path2);
            }
        } else {
            this.blO.set(lVar2.getPath());
        }
        this.blk.op(this.blO, this.blP, op);
    }
}
