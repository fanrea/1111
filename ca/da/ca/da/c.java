package ca.da.ca.da;

import android.text.TextUtils;
import ca.da.ca.ia.h;
import java.util.ArrayList;

/* compiled from: Engine.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c implements Runnable {
    public final /* synthetic */ b a;

    /* compiled from: Engine.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = c.this.a;
            bVar.a(bVar.i);
        }
    }

    public c(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        h hVarA = this.a.a();
        if (hVarA != null) {
            try {
                ArrayList<ca.da.ca.ia.b> arrayList = new ArrayList<>();
                arrayList.add(hVarA);
                this.a.b().a(arrayList);
                String strB = this.a.f.b();
                if (this.a.g == null || TextUtils.isEmpty(strB)) {
                    return;
                }
                this.a.g.post(new a());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
