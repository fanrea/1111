package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: typeSignatureMapping.kt */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class TypeSignatureMappingKt {
    public static final <T> T boxTypeIfNeeded(JvmTypeFactory<T> jvmTypeFactory, T t, boolean z) {
        Intrinsics.checkNotNullParameter(jvmTypeFactory, "<this>");
        Intrinsics.checkNotNullParameter(t, "possiblyPrimitiveType");
        return z ? jvmTypeFactory.boxType(t) : t;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00a7 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> T mapBuiltInType(kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext r5, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r6, kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory<T> r7, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r8) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "typeFactory"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "mode"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r0 = r5.typeConstructor(r6)
            boolean r1 = r5.isClassTypeConstructor(r0)
            r2 = 0
            if (r1 != 0) goto L20
            return r2
        L20:
            kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType r1 = r5.getPrimitiveType(r0)
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L3f
            java.lang.Object r8 = r7.createPrimitiveType(r1)
            boolean r0 = r5.isNullableType(r6)
            if (r0 != 0) goto L3a
            boolean r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementUtilsKt.hasEnhancedNullability(r5, r6)
            if (r5 == 0) goto L39
            goto L3a
        L39:
            r3 = r4
        L3a:
            java.lang.Object r5 = boxTypeIfNeeded(r7, r8, r3)
            return r5
        L3f:
            kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType r6 = r5.getPrimitiveArrayType(r0)
            if (r6 == 0) goto L58
            kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType r5 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.get(r6)
            java.lang.String r5 = r5.getDesc()
            java.lang.String r6 = "["
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r6, r5)
            java.lang.Object r5 = r7.createFromString(r5)
            return r5
        L58:
            boolean r6 = r5.isUnderKotlinPackage(r0)
            if (r6 == 0) goto Lba
            kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe r5 = r5.getClassFqNameUnsafe(r0)
            if (r5 != 0) goto L66
            r5 = r2
            goto L6c
        L66:
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap r6 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.INSTANCE
            kotlin.reflect.jvm.internal.impl.name.ClassId r5 = r6.mapKotlinToJava(r5)
        L6c:
            if (r5 == 0) goto Lba
            boolean r6 = r8.getKotlinCollectionsToJavaCollections()
            if (r6 != 0) goto La8
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap r6 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.INSTANCE
            java.util.List r6 = r6.getMutabilityMappings()
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            boolean r8 = r6 instanceof java.util.Collection
            if (r8 == 0) goto L8b
            r8 = r6
            java.util.Collection r8 = (java.util.Collection) r8
            boolean r8 = r8.isEmpty()
            if (r8 == 0) goto L8b
        L89:
            r3 = r4
            goto La5
        L8b:
            java.util.Iterator r6 = r6.iterator()
        L8f:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L89
            java.lang.Object r8 = r6.next()
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap$PlatformMutabilityMapping r8 = (kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.PlatformMutabilityMapping) r8
            kotlin.reflect.jvm.internal.impl.name.ClassId r8 = r8.getJavaClass()
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r5)
            if (r8 == 0) goto L8f
        La5:
            if (r3 == 0) goto La8
            return r2
        La8:
            kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName r5 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName.byClassId(r5)
            java.lang.String r5 = r5.getInternalName()
            java.lang.String r6 = "byClassId(classId).internalName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            java.lang.Object r5 = r7.createObjectType(r5)
            return r5
        Lba:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.TypeSignatureMappingKt.mapBuiltInType(kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker, kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode):java.lang.Object");
    }
}
