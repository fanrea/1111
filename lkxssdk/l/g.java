package lkxssdk.l;

import android.location.LocationManager;
import com.lingku.xuanshang.core.ui.base.BaseActivity;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.List;
import lkxssdk.i.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class g {
    public BaseActivity a;
    public b b;
    public boolean c;

    public interface b {
    }

    public final void a() {
        if (b()) {
            lkxssdk.j0.d.a(this.a, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, new a());
            return;
        }
        lkxssdk.h.c cVar = new lkxssdk.h.c(this.a);
        cVar.a(2, new i(this, cVar));
        cVar.d("当前功能需要获取地理位置信息，请开启手机位置服务");
        cVar.a("");
        cVar.b("关闭");
        cVar.c("去开启");
        cVar.a(false);
        lkxssdk.h.a aVar = cVar.a;
        if (aVar != null) {
            aVar.setCancelable(false);
        }
        cVar.b();
    }

    public boolean b() {
        LocationManager locationManager = (LocationManager) lkxssdk.a.a.d().getSystemService("location");
        return locationManager.isProviderEnabled(PointCategory.NETWORK) || locationManager.isProviderEnabled("gps");
    }

    public class a implements lkxssdk.j0.a {
        public a() {
        }

        @Override // lkxssdk.j0.a
        public void a(List<String> list, boolean z) {
            if (!z) {
                b bVar = g.this.b;
                if (bVar != null) {
                    ((e.a) bVar).a(3);
                    return;
                }
                return;
            }
            g gVar = g.this;
            lkxssdk.h.c cVar = new lkxssdk.h.c(gVar.a);
            cVar.a(2, new h(gVar, cVar));
            cVar.d("当前功能需使用“位置信息”权限，未开启可能会影响功能的正常使用。");
            cVar.a("");
            cVar.b("关闭");
            cVar.c("去开启");
            cVar.a(false);
            lkxssdk.h.a aVar = cVar.a;
            if (aVar != null) {
                aVar.setCancelable(false);
            }
            cVar.b();
        }

        @Override // lkxssdk.j0.a
        public void a() {
            b bVar = g.this.b;
            if (bVar != null) {
                e.a aVar = (e.a) bVar;
                lkxssdk.h0.c.b("tag", "onGeolocationPermissionsShowPrompt 1");
                aVar.a.invoke(aVar.b, true, false);
            }
        }
    }
}
