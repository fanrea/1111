package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;

/* compiled from: InlineClassRepresentation.kt */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class InlineClassRepresentation<Type extends SimpleTypeMarker> {
    private final Name underlyingPropertyName;
    private final Type underlyingType;

    public InlineClassRepresentation(Name name, Type type) {
        Intrinsics.checkNotNullParameter(name, "underlyingPropertyName");
        Intrinsics.checkNotNullParameter(type, "underlyingType");
        this.underlyingPropertyName = name;
        this.underlyingType = type;
    }

    public final Name getUnderlyingPropertyName() {
        return this.underlyingPropertyName;
    }

    public final Type getUnderlyingType() {
        return this.underlyingType;
    }
}
