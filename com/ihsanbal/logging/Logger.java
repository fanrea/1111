package com.ihsanbal.logging;

import com.baidu.mobads.container.components.j.a;
import kotlin.Metadata;
import okhttp3.internal.platform.Platform;

/* compiled from: Logger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ*\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&¨\u0006\n"}, d2 = {"Lcom/ihsanbal/logging/Logger;", "", a.b, "", "level", "", "tag", "", "msg", "Companion", "lib"}, k = 1, mv = {1, 1, 16})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface Logger {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void log(int level, String tag, String msg);

    /* compiled from: Logger.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public static final class DefaultImpls {
        public static /* synthetic */ void log$default(Logger logger, int i, String str, String str2, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
            }
            if ((i2 & 1) != 0) {
                i = 4;
            }
            if ((i2 & 2) != 0) {
                str = null;
            }
            if ((i2 & 4) != 0) {
                str2 = null;
            }
            logger.log(i, str, str2);
        }
    }

    /* compiled from: Logger.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/ihsanbal/logging/Logger$Companion;", "", "()V", "DEFAULT", "Lcom/ihsanbal/logging/Logger;", "getDEFAULT", "()Lcom/ihsanbal/logging/Logger;", "lib"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Logger DEFAULT = new Logger() { // from class: com.ihsanbal.logging.Logger$Companion$DEFAULT$1
            @Override // com.ihsanbal.logging.Logger
            public void log(int level, String tag, String msg) {
                Platform.Companion.get().log(String.valueOf(msg), level, null);
            }
        };

        private Companion() {
        }

        public final Logger getDEFAULT() {
            return DEFAULT;
        }
    }
}
