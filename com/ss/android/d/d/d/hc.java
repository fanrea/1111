package com.ss.android.d.d.d;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.ss.android.d.d.hc.tc;
import com.ss.android.d.d.hc.v;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class hc implements tc {
    private v d;

    @Override // com.ss.android.d.d.hc.tc
    public void d(Activity activity, String[] strArr, v vVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.d = vVar;
            activity.requestPermissions(strArr, 1);
        } else if (vVar != null) {
            vVar.d();
        }
    }

    @Override // com.ss.android.d.d.hc.tc
    public boolean d(Context context, String str) {
        return (context == null || str == null || context.checkPermission(str, Process.myPid(), Process.myUid()) != 0) ? false : true;
    }

    @Override // com.ss.android.d.d.hc.tc
    public void d(Activity activity, int i, String[] strArr, int[] iArr) {
        v vVar;
        if (iArr.length <= 0 || (vVar = this.d) == null) {
            return;
        }
        int i2 = iArr[0];
        if (i2 == -1) {
            vVar.d(strArr[0]);
        } else if (i2 == 0) {
            vVar.d();
        }
    }
}
