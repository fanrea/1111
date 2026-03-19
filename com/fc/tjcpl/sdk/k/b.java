package com.fc.tjcpl.sdk.k;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import com.fc.tjcpl.sdk.TJActivity;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends Fragment {
    public a a;

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ArrayList<String> stringArrayList = getArguments().getStringArrayList("request_permissions");
        if (stringArrayList == null || stringArrayList.size() == 0 || Build.VERSION.SDK_INT < 23) {
            return;
        }
        requestPermissions((String[]) stringArrayList.toArray(new String[stringArrayList.size()]), getArguments().getInt("request_code"));
    }

    @Override // android.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        a aVar = this.a;
        if (aVar == null) {
            return;
        }
        if (i == 110) {
            if (strArr.length > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    if (iArr[i2] == -1) {
                        arrayList.add(strArr[i2]);
                    }
                }
                if (arrayList.size() <= 0) {
                    ((TJActivity.a) this.a).a();
                } else if (Build.VERSION.SDK_INT >= 23) {
                    if (shouldShowRequestPermissionRationale((String) arrayList.get(0))) {
                        ((TJActivity.a) this.a).a(arrayList, false);
                    } else {
                        ((TJActivity.a) this.a).a(arrayList, true);
                    }
                }
            } else {
                ((TJActivity.a) aVar).a(null, true);
            }
        }
        getFragmentManager().beginTransaction().remove(this).commit();
    }
}
