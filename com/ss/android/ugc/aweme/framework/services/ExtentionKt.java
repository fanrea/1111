package com.ss.android.ugc.aweme.framework.services;

import androidx.exifinterface.media.ExifInterface;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: Extention.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\u001a&\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0086\b¢\u0006\u0002\u0010\u0004\u001a&\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0086\b¢\u0006\u0002\u0010\u0006\u001a%\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00010\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0086\b\u001a%\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00010\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0086\b¨\u0006\t"}, d2 = {"getService", ExifInterface.GPS_DIRECTION_TRUE, "", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "getServices", "", "spi_release"}, k = 2, mv = {1, 1, 15})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ExtentionKt {
    public static final /* synthetic */ <T> T getService(KClass<T> kClass) {
        Intrinsics.checkParameterIsNotNull(kClass, "$this$getService");
        ServiceManager serviceManager = ServiceManager.get();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) serviceManager.getService(Object.class);
    }

    public static final /* synthetic */ <T> T getService(Class<T> cls) {
        Intrinsics.checkParameterIsNotNull(cls, "$this$getService");
        ServiceManager serviceManager = ServiceManager.get();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) serviceManager.getService(Object.class);
    }

    public static final /* synthetic */ <T> Set<T> getServices(KClass<T> kClass) {
        Intrinsics.checkParameterIsNotNull(kClass, "$this$getServices");
        ServiceManager serviceManager = ServiceManager.get();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Set<T> services = serviceManager.getServices(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(services, "ServiceManager.get().getServices(T::class.java)");
        return services;
    }

    public static final /* synthetic */ <T> Set<T> getServices(Class<T> cls) {
        Intrinsics.checkParameterIsNotNull(cls, "$this$getServices");
        ServiceManager serviceManager = ServiceManager.get();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Set<T> services = serviceManager.getServices(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(services, "ServiceManager.get().getServices(T::class.java)");
        return services;
    }
}
