package com.ihsanbal.logging;

import com.baidu.mobads.container.components.j.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: I.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0010\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/ihsanbal/logging/I;", "", "()V", "Companion", "lib"}, k = 1, mv = {1, 1, 16})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class I {
    private static int index;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String[] prefix = {". ", " ."};

    /* compiled from: I.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/ihsanbal/logging/I$Companion;", "", "()V", "index", "", "prefix", "", "", "[Ljava/lang/String;", "getFinalTag", "tag", "isLogHackEnable", "", a.b, "", "type", "msg", "lib"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void log(int type, String tag, String msg, boolean isLogHackEnable) {
            Intrinsics.checkParameterIsNotNull(tag, "tag");
            String finalTag = getFinalTag(tag, isLogHackEnable);
            if (isLogHackEnable) {
                tag = finalTag;
            }
            java.util.logging.Logger logger = java.util.logging.Logger.getLogger(tag);
            if (type == 4) {
                logger.log(java.util.logging.Level.INFO, msg);
            } else {
                logger.log(java.util.logging.Level.WARNING, msg);
            }
        }

        private final String getFinalTag(String tag, boolean isLogHackEnable) {
            if (!isLogHackEnable) {
                return tag;
            }
            I.index ^= 1;
            return I.prefix[I.index] + tag;
        }
    }

    protected I() {
        throw new UnsupportedOperationException();
    }
}
