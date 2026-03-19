package com.tachikoma.lottie.model.content;

import com.tachikoma.lottie.a.a.l;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class MergePaths implements b {
    private final boolean IO;
    private final MergePathsMode LI;
    private final String name;

    public enum MergePathsMode {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static MergePathsMode forId(int i) {
            if (i == 1) {
                return MERGE;
            }
            if (i == 2) {
                return ADD;
            }
            if (i == 3) {
                return SUBTRACT;
            }
            if (i == 4) {
                return INTERSECT;
            }
            if (i == 5) {
                return EXCLUDE_INTERSECTIONS;
            }
            return MERGE;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode, boolean z) {
        this.name = str;
        this.LI = mergePathsMode;
        this.IO = z;
    }

    public final String getName() {
        return this.name;
    }

    public final MergePathsMode lf() {
        return this.LI;
    }

    public final boolean isHidden() {
        return this.IO;
    }

    @Override // com.tachikoma.lottie.model.content.b
    public final com.tachikoma.lottie.a.a.c a(com.tachikoma.lottie.g gVar, com.tachikoma.lottie.model.layer.a aVar) {
        if (!gVar.jC()) {
            com.tachikoma.lottie.c.R("Animation contains merge paths but they are disabled.");
            return null;
        }
        return new l(this);
    }

    public final String toString() {
        return "MergePaths{mode=" + this.LI + '}';
    }
}
