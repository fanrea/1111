package com.kwad.tachikoma;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class f implements com.tk.core.a.e {
    SharedPreferences Ba;
    Context mContext;

    public f(Context context) {
        this.mContext = context;
        this.Ba = this.mContext.getSharedPreferences("KSAdTKCacheKey", 0);
    }

    @Override // com.tk.core.a.e
    public final void set(String str, Object obj) {
        if (str == null || str.length() == 0 || obj == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.Ba.edit();
        editorEdit.putString(str, obj.toString());
        editorEdit.apply();
    }

    @Override // com.tk.core.a.e
    public final Object get(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return this.Ba.getString(str, null);
    }

    @Override // com.tk.core.a.e
    public final void remove(String str) {
        if (str == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.Ba.edit();
        editorEdit.remove(str);
        editorEdit.apply();
    }

    @Override // com.tk.core.a.e
    public final boolean exist(String str) {
        if (str == null) {
            return false;
        }
        return this.Ba.contains(str);
    }
}
