package lkxssdk.e;

import android.text.TextUtils;
import com.lingku.xuanshang.core.ui.base.BaseActivity;
import com.permissionx.guolindev.request.RequestManageExternalStoragePermission;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class w extends lkxssdk.h.b {
    public final /* synthetic */ lkxssdk.h.c a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ String c;
    public final /* synthetic */ v d;

    public w(v vVar, lkxssdk.h.c cVar, boolean z, String str) {
        this.d = vVar;
        this.a = cVar;
        this.b = z;
        this.c = str;
    }

    @Override // lkxssdk.h.b
    public void a() {
        this.a.a();
    }

    @Override // lkxssdk.h.b
    public void b() {
        this.a.a();
    }

    @Override // lkxssdk.h.b
    public void c() {
        this.a.a();
        if (!this.b) {
            this.d.a();
            return;
        }
        this.d.d = true;
        if (!TextUtils.equals(this.c, RequestManageExternalStoragePermission.MANAGE_EXTERNAL_STORAGE)) {
            lkxssdk.j0.d.c(this.d.a.getApplicationContext());
        } else {
            BaseActivity baseActivity = this.d.a;
            baseActivity.startActivityForResult(lkxssdk.j0.d.a(baseActivity.getApplicationContext()), 555);
        }
    }
}
