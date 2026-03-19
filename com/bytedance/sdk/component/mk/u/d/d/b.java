package com.bytedance.sdk.component.mk.u.d.d;

import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b implements com.bytedance.sdk.component.mk.u.d.d {
    @Override // com.bytedance.sdk.component.mk.u.d.d
    public Object d(Class cls, String str) {
        if (TextUtils.isEmpty(str)) {
            return ' ';
        }
        return Character.valueOf(str.charAt(0));
    }
}
