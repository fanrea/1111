package lkxssdk.d0;

import android.text.TextUtils;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class b implements a {
    public final String a;

    public b(String str) {
        this.a = str;
    }

    @Override // lkxssdk.d0.a
    public boolean a() {
        return false;
    }

    @Override // lkxssdk.d0.a
    public View b() {
        return null;
    }

    @Override // lkxssdk.d0.a
    public int getId() {
        return TextUtils.isEmpty(this.a) ? hashCode() : this.a.hashCode();
    }
}
