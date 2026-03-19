package lkxssdk.e;

import android.text.TextUtils;
import com.fendasz.moku.planet.utils.PermissionUtils;
import com.lingku.xuanshang.core.ui.base.BaseActivity;
import com.permissionx.guolindev.request.RequestManageExternalStoragePermission;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class v {
    public BaseActivity a;
    public c b;
    public int c;
    public boolean d;

    public class a implements lkxssdk.j0.a {
        public a() {
        }

        @Override // lkxssdk.j0.a
        public void a() {
            v.this.b.a();
        }

        @Override // lkxssdk.j0.a
        public void a(List<String> list, boolean z) {
            v.a(v.this, list.get(0), z);
        }
    }

    public class b implements lkxssdk.j0.a {
        public b() {
        }

        @Override // lkxssdk.j0.a
        public void a() {
            v.this.b.a();
        }

        @Override // lkxssdk.j0.a
        public void a(List<String> list, boolean z) {
            v.a(v.this, list.get(0), z);
        }
    }

    public interface c {
        void a();
    }

    public v(BaseActivity baseActivity) {
        this.a = baseActivity;
    }

    public static void a(v vVar, String str, boolean z) {
        String str2;
        lkxssdk.h.c cVar = new lkxssdk.h.c(vVar.a);
        cVar.a(2, new w(vVar, cVar, z, str));
        String str3 = "";
        cVar.d("");
        int i = vVar.c;
        if (z) {
            if (i == 2) {
                str3 = "拍摄照片需要相机权限,请在\"应用详情\\权限管理\"开启";
            } else if (i == 1) {
                str3 = TextUtils.equals(str, RequestManageExternalStoragePermission.MANAGE_EXTERNAL_STORAGE) ? "获取照片需要所有文件访问权限,请在\"特殊权限\\所有文件访问权限\"开启" : "获取照片需要sdcard权限,请在\"应用详情\\权限管理\"开启";
            }
            cVar.a(str3);
            str2 = "设置";
        } else {
            cVar.a(i == 1 ? "获取照片需要sdcard权限" : "拍摄照片需要相机权限");
            str2 = "授权";
        }
        cVar.c(str2);
        cVar.b("取消");
        cVar.a(false);
        cVar.b();
    }

    public final void a() {
        int i = this.c;
        if (i == 2) {
            lkxssdk.j0.d.a(this.a, new String[]{PermissionUtils.PERMISSION_CAMERA}, new a());
        } else if (i == 1) {
            lkxssdk.j0.d.a(this.a, new b());
        }
    }
}
