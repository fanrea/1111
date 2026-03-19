package com.luck.picture.lib.interfaces;

import androidx.fragment.app.Fragment;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface OnPermissionsInterceptListener {
    boolean hasPermissions(Fragment fragment, String[] strArr);

    void requestPermission(Fragment fragment, String[] strArr, OnRequestPermissionListener onRequestPermissionListener);
}
