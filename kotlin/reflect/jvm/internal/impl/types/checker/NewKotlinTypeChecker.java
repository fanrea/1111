package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: NewKotlinTypeChecker.kt */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public interface NewKotlinTypeChecker extends KotlinTypeChecker {
    public static final Companion Companion = Companion.$$INSTANCE;

    KotlinTypeRefiner getKotlinTypeRefiner();

    OverridingUtil getOverridingUtil();

    /* compiled from: NewKotlinTypeChecker.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final NewKotlinTypeCheckerImpl Default;

        private Companion() {
        }

        static {
            KotlinTypePreparator kotlinTypePreparator = null;
            Default = new NewKotlinTypeCheckerImpl(KotlinTypeRefiner.Default.INSTANCE, kotlinTypePreparator, 2, kotlinTypePreparator);
        }

        public final NewKotlinTypeCheckerImpl getDefault() {
            return Default;
        }
    }
}
