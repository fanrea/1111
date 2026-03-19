package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.baidu.mobstat.forbes.Config;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Annotations.kt */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class AnnotationsKt {
    public static final Annotations composeAnnotations(Annotations annotations, Annotations annotations2) {
        Intrinsics.checkNotNullParameter(annotations, Config.TRACE_VISIT_FIRST);
        Intrinsics.checkNotNullParameter(annotations2, "second");
        return annotations.isEmpty() ? annotations2 : annotations2.isEmpty() ? annotations : new CompositeAnnotations(annotations, annotations2);
    }
}
