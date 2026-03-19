package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: functions.kt */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class FunctionsKt {
    private static final Function1<Object, Object> IDENTITY = new Function1<Object, Object>() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$IDENTITY$1
        public final Object invoke(Object obj) {
            return obj;
        }
    };
    private static final Function1<Object, Boolean> ALWAYS_TRUE = new Function1<Object, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$ALWAYS_TRUE$1
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m1732invoke(Object obj) {
            return true;
        }
    };
    private static final Function1<Object, Object> ALWAYS_NULL = new Function1() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$ALWAYS_NULL$1
        public final Void invoke(Object obj) {
            return null;
        }
    };
    private static final Function1<Object, Unit> DO_NOTHING = new Function1<Object, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$DO_NOTHING$1
        /* renamed from: invoke, reason: collision with other method in class */
        public final void m1733invoke(Object obj) {
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m1733invoke(obj);
            return Unit.INSTANCE;
        }
    };
    private static final Function2<Object, Object, Unit> DO_NOTHING_2 = new Function2<Object, Object, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$DO_NOTHING_2$1
        /* renamed from: invoke, reason: collision with other method in class */
        public final void m1734invoke(Object obj, Object obj2) {
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            m1734invoke(obj, obj2);
            return Unit.INSTANCE;
        }
    };
    private static final Function3<Object, Object, Object, Unit> DO_NOTHING_3 = new Function3<Object, Object, Object, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$DO_NOTHING_3$1
        /* renamed from: invoke, reason: collision with other method in class */
        public final void m1735invoke(Object obj, Object obj2, Object obj3) {
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            m1735invoke(obj, obj2, obj3);
            return Unit.INSTANCE;
        }
    };

    public static final <T> Function1<T, Boolean> alwaysTrue() {
        return (Function1<T, Boolean>) ALWAYS_TRUE;
    }

    public static final Function3<Object, Object, Object, Unit> getDO_NOTHING_3() {
        return DO_NOTHING_3;
    }
}
