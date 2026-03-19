package kotlin.reflect.jvm.internal.impl.descriptors;

import com.baidu.mobads.container.util.cm;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InvalidModuleException.kt */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class InvalidModuleException extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidModuleException(String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, cm.V);
    }
}
