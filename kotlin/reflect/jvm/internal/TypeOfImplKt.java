package kotlin.reflect.jvm.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: typeOfImpl.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\bH\u0002¨\u0006\t"}, d2 = {"createMutableCollectionKType", "Lkotlin/reflect/KType;", "type", "createNothingType", "createPlatformKType", "lowerBound", "upperBound", "readOnlyToMutable", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "kotlin-reflection"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class TypeOfImplKt {
    public static final KType createPlatformKType(KType kType, KType kType2) {
        Intrinsics.checkNotNullParameter(kType, "lowerBound");
        Intrinsics.checkNotNullParameter(kType2, "upperBound");
        return new KTypeImpl(KotlinTypeFactory.flexibleType((SimpleType) ((KTypeImpl) kType).getType(), (SimpleType) ((KTypeImpl) kType2).getType()), null, 2, null);
    }

    public static final KType createMutableCollectionKType(KType kType) {
        Intrinsics.checkNotNullParameter(kType, "type");
        KotlinType type = ((KTypeImpl) kType).getType();
        if (!(type instanceof SimpleType)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Non-simple type cannot be a mutable collection type: ", kType).toString());
        }
        ClassifierDescriptor classifierDescriptorMo1672getDeclarationDescriptor = type.getConstructor().mo1672getDeclarationDescriptor();
        ClassDescriptor classDescriptor = classifierDescriptorMo1672getDeclarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) classifierDescriptorMo1672getDeclarationDescriptor : null;
        if (classDescriptor == null) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Non-class type cannot be a mutable collection type: ", kType));
        }
        SimpleType simpleType = (SimpleType) type;
        TypeConstructor typeConstructor = readOnlyToMutable(classDescriptor).getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "classifier.readOnlyToMutable().typeConstructor");
        return new KTypeImpl(KotlinTypeFactory.simpleType$default(simpleType, (Annotations) null, typeConstructor, (List) null, false, 26, (Object) null), null, 2, null);
    }

    private static final ClassDescriptor readOnlyToMutable(ClassDescriptor classDescriptor) {
        ClassDescriptor classDescriptor2 = classDescriptor;
        FqName onlyToMutable = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(DescriptorUtilsKt.getFqNameUnsafe(classDescriptor2));
        if (onlyToMutable == null) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Not a readonly collection: ", classDescriptor));
        }
        ClassDescriptor builtInClassByFqName = DescriptorUtilsKt.getBuiltIns(classDescriptor2).getBuiltInClassByFqName(onlyToMutable);
        Intrinsics.checkNotNullExpressionValue(builtInClassByFqName, "builtIns.getBuiltInClassByFqName(fqName)");
        return builtInClassByFqName;
    }

    public static final KType createNothingType(KType kType) {
        Intrinsics.checkNotNullParameter(kType, "type");
        KotlinType type = ((KTypeImpl) kType).getType();
        if (!(type instanceof SimpleType)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Non-simple type cannot be a Nothing type: ", kType).toString());
        }
        SimpleType simpleType = (SimpleType) type;
        TypeConstructor typeConstructor = TypeUtilsKt.getBuiltIns(type).getNothing().getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "kotlinType.builtIns.nothing.typeConstructor");
        return new KTypeImpl(KotlinTypeFactory.simpleType$default(simpleType, (Annotations) null, typeConstructor, (List) null, false, 26, (Object) null), null, 2, null);
    }
}
