package lkxssdk.q0;

import com.lingku.xuanshang.xutils.common.util.LogUtil;
import com.lingku.xuanshang.xutils.db.sqlite.WhereBuilder;
import com.lingku.xuanshang.xutils.http.cookie.DbCookieStore;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class b implements Runnable {
    public final /* synthetic */ DbCookieStore a;

    public b(DbCookieStore dbCookieStore) {
        this.a = dbCookieStore;
    }

    @Override // java.lang.Runnable
    public void run() {
        List listFindAll;
        DbCookieStore dbCookieStore = this.a;
        DbCookieStore dbCookieStore2 = DbCookieStore.INSTANCE;
        dbCookieStore.a();
        long jCurrentTimeMillis = System.currentTimeMillis();
        DbCookieStore dbCookieStore3 = this.a;
        if (jCurrentTimeMillis - dbCookieStore3.d < 1000) {
            return;
        }
        dbCookieStore3.d = jCurrentTimeMillis;
        try {
            dbCookieStore3.b.delete(a.class, WhereBuilder.b("expiry", "<", Long.valueOf(System.currentTimeMillis())).and("expiry", "!=", -1L));
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
        try {
            int iCount = (int) this.a.b.selector(a.class).count();
            if (iCount <= 5010 || (listFindAll = this.a.b.selector(a.class).where("expiry", "!=", -1L).orderBy("expiry").limit(iCount - 5000).findAll()) == null) {
                return;
            }
            this.a.b.delete(listFindAll);
        } catch (Throwable th2) {
            LogUtil.e(th2.getMessage(), th2);
        }
    }
}
