package com.permissionx.guolindev;

import android.os.Build;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.permissionx.guolindev.PermissionX;
import com.permissionx.guolindev.dialog.PermissionMapKt;
import com.permissionx.guolindev.request.PermissionBuilder;
import com.permissionx.guolindev.request.RequestBackgroundLocationPermission;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionMediator.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001f\u0010\b\u001a\u00020\t2\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000b¢\u0006\u0002\u0010\fJ\u0014\u0010\b\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000b0\rR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/permissionx/guolindev/PermissionMediator;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "permissions", "Lcom/permissionx/guolindev/request/PermissionBuilder;", "", "", "([Ljava/lang/String;)Lcom/permissionx/guolindev/request/PermissionBuilder;", "", "permissionx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class PermissionMediator {
    private FragmentActivity activity;
    private Fragment fragment;

    public PermissionMediator(FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        this.activity = fragmentActivity;
    }

    public PermissionMediator(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragment = fragment;
    }

    public final PermissionBuilder permissions(List<String> permissions) {
        int i;
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        int i2 = Build.VERSION.SDK_INT;
        FragmentActivity fragmentActivity = this.activity;
        if (fragmentActivity != null) {
            Intrinsics.checkNotNull(fragmentActivity);
            i = fragmentActivity.getApplicationInfo().targetSdkVersion;
        } else {
            Fragment fragment = this.fragment;
            Intrinsics.checkNotNull(fragment);
            i = fragment.requireContext().getApplicationInfo().targetSdkVersion;
        }
        for (String str : permissions) {
            if (PermissionMapKt.getAllSpecialPermissions().contains(str)) {
                linkedHashSet2.add(str);
            } else {
                linkedHashSet.add(str);
            }
        }
        if (linkedHashSet2.contains(RequestBackgroundLocationPermission.ACCESS_BACKGROUND_LOCATION) && (i2 == 29 || (i2 == 30 && i < 30))) {
            linkedHashSet2.remove(RequestBackgroundLocationPermission.ACCESS_BACKGROUND_LOCATION);
            linkedHashSet.add(RequestBackgroundLocationPermission.ACCESS_BACKGROUND_LOCATION);
        }
        if (linkedHashSet2.contains(PermissionX.permission.POST_NOTIFICATIONS) && i2 >= 33 && i >= 33) {
            linkedHashSet2.remove(PermissionX.permission.POST_NOTIFICATIONS);
            linkedHashSet.add(PermissionX.permission.POST_NOTIFICATIONS);
        }
        return new PermissionBuilder(this.activity, this.fragment, linkedHashSet, linkedHashSet2);
    }

    public final PermissionBuilder permissions(String... permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        return permissions(CollectionsKt.listOf(Arrays.copyOf(permissions, permissions.length)));
    }
}
