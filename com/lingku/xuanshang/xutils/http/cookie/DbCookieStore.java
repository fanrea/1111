package com.lingku.xuanshang.xutils.http.cookie;

import android.text.TextUtils;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.lingku.xuanshang.xutils.DbManager;
import com.lingku.xuanshang.xutils.common.task.PriorityExecutor;
import com.lingku.xuanshang.xutils.common.util.LogUtil;
import com.lingku.xuanshang.xutils.config.DbConfigs;
import com.lingku.xuanshang.xutils.db.Selector;
import com.lingku.xuanshang.xutils.db.sqlite.WhereBuilder;
import com.lingku.xuanshang.xutils.db.table.DbModel;
import com.lingku.xuanshang.xutils.x;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import lkxssdk.q0.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public enum DbCookieStore implements CookieStore {
    INSTANCE;

    public DbManager b;
    public final Executor c = new PriorityExecutor(1, true);
    public long d = 0;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DbCookieStore dbCookieStore = DbCookieStore.this;
            DbCookieStore dbCookieStore2 = DbCookieStore.INSTANCE;
            dbCookieStore.a();
        }
    }

    DbCookieStore() {
        x.task().run(new a());
    }

    public final URI a(URI uri) {
        try {
            return new URI(com.alipay.sdk.m.l.a.r, uri.getHost(), uri.getPath(), null, null);
        } catch (Throwable th) {
            LogUtil.w(th.getMessage(), th);
            return uri;
        }
    }

    public final void a() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    try {
                        DbManager db = x.getDb(DbConfigs.COOKIE.getConfig());
                        this.b = db;
                        db.delete(lkxssdk.q0.a.class, WhereBuilder.b("expiry", "=", -1L));
                    } catch (Throwable th) {
                        LogUtil.e(th.getMessage(), th);
                    }
                }
            }
        }
    }

    @Override // java.net.CookieStore
    public void add(URI uri, HttpCookie httpCookie) {
        if (httpCookie == null) {
            return;
        }
        a();
        try {
            this.b.replace(new lkxssdk.q0.a(a(uri), httpCookie));
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
        this.c.execute(new b(this));
    }

    @Override // java.net.CookieStore
    public List<HttpCookie> get(URI uri) {
        if (uri == null) {
            throw new NullPointerException("uri is null");
        }
        a();
        URI uriA = a(uri);
        ArrayList arrayList = new ArrayList();
        try {
            Selector selector = this.b.selector(lkxssdk.q0.a.class);
            WhereBuilder whereBuilderB = WhereBuilder.b();
            String host = uriA.getHost();
            if (!TextUtils.isEmpty(host)) {
                WhereBuilder whereBuilderOr = WhereBuilder.b("domain", "=", host).or("domain", "=", "." + host);
                int iIndexOf = host.indexOf(".");
                int iLastIndexOf = host.lastIndexOf(".");
                if (iIndexOf > 0 && iLastIndexOf > iIndexOf) {
                    String strSubstring = host.substring(iIndexOf, host.length());
                    if (!TextUtils.isEmpty(strSubstring)) {
                        whereBuilderOr.or("domain", "=", strSubstring);
                    }
                }
                whereBuilderB.and(whereBuilderOr);
            }
            String path = uriA.getPath();
            if (!TextUtils.isEmpty(path)) {
                WhereBuilder whereBuilderOr2 = WhereBuilder.b("path", "=", path).or("path", "=", "/").or("path", "=", null);
                while (true) {
                    int iLastIndexOf2 = path.lastIndexOf("/");
                    if (iLastIndexOf2 <= 0) {
                        break;
                    }
                    path = path.substring(0, iLastIndexOf2);
                    whereBuilderOr2.or("path", "=", path);
                }
                whereBuilderB.and(whereBuilderOr2);
            }
            whereBuilderB.or(ContentProviderManager.PROVIDER_URI, "=", uriA.toString());
            List<lkxssdk.q0.a> listFindAll = selector.where(whereBuilderB).findAll();
            if (listFindAll != null) {
                for (lkxssdk.q0.a aVar : listFindAll) {
                    if (!aVar.isExpired()) {
                        arrayList.add(aVar.toHttpCookie());
                    }
                }
            }
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
        return arrayList;
    }

    @Override // java.net.CookieStore
    public List<HttpCookie> getCookies() {
        a();
        ArrayList arrayList = new ArrayList();
        try {
            List<lkxssdk.q0.a> listFindAll = this.b.findAll(lkxssdk.q0.a.class);
            if (listFindAll != null) {
                for (lkxssdk.q0.a aVar : listFindAll) {
                    if (!aVar.isExpired()) {
                        arrayList.add(aVar.toHttpCookie());
                    }
                }
            }
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
        return arrayList;
    }

    @Override // java.net.CookieStore
    public List<URI> getURIs() {
        a();
        ArrayList arrayList = new ArrayList();
        try {
            List<DbModel> listFindAll = this.b.selector(lkxssdk.q0.a.class).select(ContentProviderManager.PROVIDER_URI).findAll();
            if (listFindAll != null) {
                Iterator<DbModel> it = listFindAll.iterator();
                while (it.hasNext()) {
                    String string = it.next().getString(ContentProviderManager.PROVIDER_URI);
                    if (!TextUtils.isEmpty(string)) {
                        try {
                            arrayList.add(new URI(string));
                        } catch (Throwable th) {
                            LogUtil.e(th.getMessage(), th);
                            try {
                                this.b.delete(lkxssdk.q0.a.class, WhereBuilder.b(ContentProviderManager.PROVIDER_URI, "=", string));
                            } catch (Throwable th2) {
                                LogUtil.e(th2.getMessage(), th2);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            LogUtil.e(th3.getMessage(), th3);
        }
        return arrayList;
    }

    @Override // java.net.CookieStore
    public boolean remove(URI uri, HttpCookie httpCookie) {
        if (httpCookie == null) {
            return true;
        }
        a();
        try {
            WhereBuilder whereBuilderB = WhereBuilder.b("name", "=", httpCookie.getName());
            String domain = httpCookie.getDomain();
            if (!TextUtils.isEmpty(domain)) {
                whereBuilderB.and("domain", "=", domain);
            }
            String path = httpCookie.getPath();
            if (!TextUtils.isEmpty(path)) {
                if (path.length() > 1 && path.endsWith("/")) {
                    path = path.substring(0, path.length() - 1);
                }
                whereBuilderB.and("path", "=", path);
            }
            this.b.delete(lkxssdk.q0.a.class, whereBuilderB);
            return true;
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
            return false;
        }
    }

    @Override // java.net.CookieStore
    public boolean removeAll() {
        a();
        try {
            this.b.delete(lkxssdk.q0.a.class);
            return true;
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
            return true;
        }
    }
}
