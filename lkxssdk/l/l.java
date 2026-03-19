package lkxssdk.l;

import android.text.TextUtils;
import com.permissionx.guolindev.request.RequestManageExternalStoragePermission;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class l implements lkxssdk.j0.a {
    public final /* synthetic */ q a;

    public l(q qVar) {
        this.a = qVar;
    }

    @Override // lkxssdk.j0.a
    public void a(List<String> list, boolean z) {
        String str;
        q qVar = this.a;
        String str2 = list.get(0);
        qVar.getClass();
        if (TextUtils.equals(str2, RequestManageExternalStoragePermission.MANAGE_EXTERNAL_STORAGE)) {
            qVar.d = false;
        }
        lkxssdk.h.c cVar = new lkxssdk.h.c(qVar.b);
        cVar.a(2, new n(qVar, cVar, z, str2));
        if (z) {
            cVar.d("保存图片到您的手机相册,需要您授予手机存储权限，请前往设置开启");
            cVar.a("");
            cVar.b("取消");
            str = "前往设置";
        } else {
            cVar.d("保存图片到您的手机相册,需要您授予手机存储权限");
            cVar.a("");
            cVar.b("取消");
            str = "授权";
        }
        cVar.c(str);
        cVar.b();
    }

    @Override // lkxssdk.j0.a
    public void a() {
        q qVar = this.a;
        q.a(qVar, qVar.a);
    }
}
