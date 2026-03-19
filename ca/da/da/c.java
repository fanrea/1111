package ca.da.da;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import ca.da.da.n;
import ca.da.da.v;
import com.bytedance.apm.common.utility.PackageUtils;

/* compiled from: BaseOaidImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class c<SERVICE> implements n {
    public final String a;
    public b<Boolean> b = new a();

    /* compiled from: BaseOaidImpl.java */
    public class a extends b<Boolean> {
        public a() {
        }

        @Override // ca.da.da.b
        public Boolean a(Object[] objArr) {
            return Boolean.valueOf(PackageUtils.existsPackage((Context) objArr[0], c.this.a));
        }
    }

    public c(String str) {
        this.a = str;
    }

    @Override // ca.da.da.n
    public n.a a(Context context) {
        String str = (String) new v(context, c(context), a()).a();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        n.a aVar = new n.a();
        aVar.a = str;
        return aVar;
    }

    public abstract v.b<SERVICE, String> a();

    @Override // ca.da.da.n
    public boolean b(Context context) {
        if (context == null) {
            return false;
        }
        return this.b.b(context).booleanValue();
    }

    public abstract Intent c(Context context);
}
