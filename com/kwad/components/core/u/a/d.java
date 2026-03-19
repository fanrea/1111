package com.kwad.components.core.u.a;

import android.app.Fragment;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends Fragment {
    private Map<String, List<b>> abh = new HashMap();
    private boolean abi;

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    final void c(String[] strArr) {
        com.kwad.sdk.core.d.c.d("RxPermissions", "requestPermissions permission is  " + strArr.toString());
        requestPermissions(strArr, 42);
    }

    @Override // android.app.Fragment
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        com.kwad.sdk.core.d.c.d("RxPermissions", "onRequestPermissionsResult permission is  " + strArr.toString());
        if (i != 42) {
            return;
        }
        boolean[] zArr = new boolean[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            zArr[i2] = shouldShowRequestPermissionRationale(strArr[i2]);
        }
        a(strArr, iArr, zArr);
    }

    private void a(String[] strArr, int[] iArr, boolean[] zArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            aS("onRequestPermissionsResult  " + strArr[i]);
            List<b> list = this.abh.get(strArr[i]);
            if (list == null || list.isEmpty()) {
                com.kwad.sdk.core.d.c.e("RxPermissions", "RxPermissions.onRequestPermissionsResult invoked but didn't find the corresponding permission request.");
                return;
            }
            this.abh.remove(strArr[i]);
            boolean z = iArr[i] == 0;
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                it.next().a(new a(strArr[i], z, zArr[i]));
            }
        }
    }

    final boolean aQ(String str) {
        return getActivity().checkSelfPermission(str) == 0;
    }

    final boolean aR(String str) {
        return getActivity().getPackageManager().isPermissionRevokedByPolicy(str, getActivity().getPackageName());
    }

    public final List<b> b(String str, b bVar) {
        List<b> arrayList = this.abh.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(bVar);
        return this.abh.put(str, arrayList);
    }

    final void aS(String str) {
        if (this.abi) {
            com.kwad.sdk.core.d.c.d("RxPermissions", str);
        }
    }
}
