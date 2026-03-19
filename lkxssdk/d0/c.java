package lkxssdk.d0;

import android.view.View;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class c implements a {
    public Reference<View> a;

    public c(View view) {
        this.a = new WeakReference(view);
    }

    @Override // lkxssdk.d0.a
    public boolean a() {
        return this.a.get() == null;
    }

    @Override // lkxssdk.d0.a
    public View b() {
        return this.a.get();
    }

    @Override // lkxssdk.d0.a
    public int getId() {
        View view = this.a.get();
        return view == null ? hashCode() : view.hashCode();
    }
}
