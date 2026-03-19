package com.kwad.lottie.model.content;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class MergePaths implements b {
    private final MergePathsMode bnS;
    private final String name;

    public enum MergePathsMode {
        Merge,
        Add,
        Subtract,
        Intersect,
        ExcludeIntersections;

        public static MergePathsMode forId(int i) {
            if (i == 1) {
                return Merge;
            }
            if (i == 2) {
                return Add;
            }
            if (i == 3) {
                return Subtract;
            }
            if (i == 4) {
                return Intersect;
            }
            if (i == 5) {
                return ExcludeIntersections;
            }
            return Merge;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode) {
        this.name = str;
        this.bnS = mergePathsMode;
    }

    public final String getName() {
        return this.name;
    }

    public final MergePathsMode RI() {
        return this.bnS;
    }

    @Override // com.kwad.lottie.model.content.b
    public final com.kwad.lottie.a.a.b a(com.kwad.lottie.f fVar, com.kwad.lottie.model.layer.a aVar) {
        if (!fVar.Qn()) {
            com.kwad.lottie.c.df("Animation contains merge paths but they are disabled.");
            return null;
        }
        return new com.kwad.lottie.a.a.k(this);
    }

    public final String toString() {
        return "MergePaths{mode=" + this.bnS + '}';
    }
}
