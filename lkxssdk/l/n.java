package lkxssdk.l;

import android.text.TextUtils;
import com.lingku.xuanshang.core.ui.base.BaseActivity;
import com.permissionx.guolindev.request.RequestManageExternalStoragePermission;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class n extends lkxssdk.h.b {
    public final /* synthetic */ lkxssdk.h.c a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ String c;
    public final /* synthetic */ q d;

    public n(q qVar, lkxssdk.h.c cVar, boolean z, String str) {
        this.d = qVar;
        this.a = cVar;
        this.b = z;
        this.c = str;
    }

    @Override // lkxssdk.h.b
    public void a() {
        this.a.a();
        this.d.a(1);
    }

    @Override // lkxssdk.h.b
    public void b() {
        this.a.a();
        this.d.a(1);
    }

    @Override // lkxssdk.h.b
    public void c() {
        this.a.a();
        if (!this.b) {
            q qVar = this.d;
            qVar.d = true;
            lkxssdk.j0.d.a(qVar.b, new l(qVar));
        } else {
            this.d.c = true;
            if (!TextUtils.equals(this.c, RequestManageExternalStoragePermission.MANAGE_EXTERNAL_STORAGE)) {
                lkxssdk.j0.d.c(lkxssdk.a.a.d());
            } else {
                BaseActivity baseActivity = this.d.b;
                baseActivity.startActivityForResult(lkxssdk.j0.d.a(baseActivity.getApplicationContext()), 555);
            }
        }
    }
}
