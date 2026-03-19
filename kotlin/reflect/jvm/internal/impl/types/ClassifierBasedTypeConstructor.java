package kotlin.reflect.jvm.internal.impl.types;

import com.baidu.mobstat.forbes.Config;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;

/* compiled from: ClassifierBasedTypeConstructor.kt */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public abstract class ClassifierBasedTypeConstructor implements TypeConstructor {
    private int hashCode;

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* renamed from: getDeclarationDescriptor */
    public abstract ClassifierDescriptor mo1672getDeclarationDescriptor();

    protected abstract boolean isSameClassifier(ClassifierDescriptor classifierDescriptor);

    public int hashCode() {
        int iIdentityHashCode;
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        ClassifierDescriptor classifierDescriptorMo1672getDeclarationDescriptor = mo1672getDeclarationDescriptor();
        if (hasMeaningfulFqName(classifierDescriptorMo1672getDeclarationDescriptor)) {
            iIdentityHashCode = DescriptorUtils.getFqName(classifierDescriptorMo1672getDeclarationDescriptor).hashCode();
        } else {
            iIdentityHashCode = System.identityHashCode(this);
        }
        this.hashCode = iIdentityHashCode;
        return iIdentityHashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypeConstructor) || obj.hashCode() != hashCode()) {
            return false;
        }
        TypeConstructor typeConstructor = (TypeConstructor) obj;
        if (typeConstructor.getParameters().size() != getParameters().size()) {
            return false;
        }
        ClassifierDescriptor classifierDescriptorMo1672getDeclarationDescriptor = mo1672getDeclarationDescriptor();
        ClassifierDescriptor classifierDescriptorMo1672getDeclarationDescriptor2 = typeConstructor.mo1672getDeclarationDescriptor();
        if (classifierDescriptorMo1672getDeclarationDescriptor2 != null && hasMeaningfulFqName(classifierDescriptorMo1672getDeclarationDescriptor) && hasMeaningfulFqName(classifierDescriptorMo1672getDeclarationDescriptor2)) {
            return isSameClassifier(classifierDescriptorMo1672getDeclarationDescriptor2);
        }
        return false;
    }

    protected final boolean areFqNamesEqual(ClassifierDescriptor classifierDescriptor, ClassifierDescriptor classifierDescriptor2) {
        Intrinsics.checkNotNullParameter(classifierDescriptor, Config.TRACE_VISIT_FIRST);
        Intrinsics.checkNotNullParameter(classifierDescriptor2, "second");
        if (!Intrinsics.areEqual(classifierDescriptor.getName(), classifierDescriptor2.getName())) {
            return false;
        }
        DeclarationDescriptor containingDeclaration = classifierDescriptor.getContainingDeclaration();
        for (DeclarationDescriptor containingDeclaration2 = classifierDescriptor2.getContainingDeclaration(); containingDeclaration != null && containingDeclaration2 != null; containingDeclaration2 = containingDeclaration2.getContainingDeclaration()) {
            if (containingDeclaration instanceof ModuleDescriptor) {
                return containingDeclaration2 instanceof ModuleDescriptor;
            }
            if (containingDeclaration2 instanceof ModuleDescriptor) {
                return false;
            }
            if (containingDeclaration instanceof PackageFragmentDescriptor) {
                return (containingDeclaration2 instanceof PackageFragmentDescriptor) && Intrinsics.areEqual(((PackageFragmentDescriptor) containingDeclaration).getFqName(), ((PackageFragmentDescriptor) containingDeclaration2).getFqName());
            }
            if ((containingDeclaration2 instanceof PackageFragmentDescriptor) || !Intrinsics.areEqual(containingDeclaration.getName(), containingDeclaration2.getName())) {
                return false;
            }
            containingDeclaration = containingDeclaration.getContainingDeclaration();
        }
        return true;
    }

    private final boolean hasMeaningfulFqName(ClassifierDescriptor classifierDescriptor) {
        ClassifierDescriptor classifierDescriptor2 = classifierDescriptor;
        return (ErrorUtils.isError(classifierDescriptor2) || DescriptorUtils.isLocal(classifierDescriptor2)) ? false : true;
    }
}
