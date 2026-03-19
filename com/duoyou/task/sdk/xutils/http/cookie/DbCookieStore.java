package com.duoyou.task.sdk.xutils.http.cookie;

import android.text.TextUtils;
import com.alipay.sdk.m.l.a;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.duoyou.task.sdk.xutils.DbManager;
import com.duoyou.task.sdk.xutils.common.task.PriorityExecutor;
import com.duoyou.task.sdk.xutils.common.util.LogUtil;
import com.duoyou.task.sdk.xutils.config.DbConfigs;
import com.duoyou.task.sdk.xutils.db.Selector;
import com.duoyou.task.sdk.xutils.db.sqlite.WhereBuilder;
import com.duoyou.task.sdk.xutils.db.table.DbModel;
import com.duoyou.task.sdk.xutils.x;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public enum DbCookieStore implements CookieStore {
    INSTANCE;

    private static final int LIMIT_COUNT = 5000;
    private static final long TRIM_TIME_SPAN = 1000;
    private DbManager db;
    private final Executor trimExecutor = new PriorityExecutor(1, true);
    private long lastTrimTime = 0;

    DbCookieStore() {
        x.task().run(new Runnable() { // from class: com.duoyou.task.sdk.xutils.http.cookie.DbCookieStore.1
            @Override // java.lang.Runnable
            public void run() {
                DbCookieStore.this.tryInit();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryInit() {
        if (this.db == null) {
            synchronized (this) {
                if (this.db == null) {
                    try {
                        DbManager db = x.getDb(DbConfigs.COOKIE.getConfig());
                        this.db = db;
                        db.delete(CookieEntity.class, WhereBuilder.b("expiry", "=", -1L));
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
        tryInit();
        try {
            this.db.replace(new CookieEntity(getEffectiveURI(uri), httpCookie));
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
        trimSize();
    }

    @Override // java.net.CookieStore
    public List<HttpCookie> get(URI uri) {
        if (uri == null) {
            throw new NullPointerException("uri is null");
        }
        tryInit();
        URI effectiveURI = getEffectiveURI(uri);
        ArrayList arrayList = new ArrayList();
        try {
            Selector selector = this.db.selector(CookieEntity.class);
            WhereBuilder whereBuilderB = WhereBuilder.b();
            String host = effectiveURI.getHost();
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
            String path = effectiveURI.getPath();
            if (!TextUtils.isEmpty(path)) {
                WhereBuilder whereBuilderOr2 = WhereBuilder.b("path", "=", path).or("path", "=", "/").or("path", "=", null);
                int iLastIndexOf2 = path.lastIndexOf("/");
                while (iLastIndexOf2 > 0) {
                    path = path.substring(0, iLastIndexOf2);
                    whereBuilderOr2.or("path", "=", path);
                    iLastIndexOf2 = path.lastIndexOf("/");
                }
                whereBuilderB.and(whereBuilderOr2);
            }
            whereBuilderB.or(ContentProviderManager.PROVIDER_URI, "=", effectiveURI.toString());
            List<CookieEntity> listFindAll = selector.where(whereBuilderB).findAll();
            if (listFindAll != null) {
                for (CookieEntity cookieEntity : listFindAll) {
                    if (!cookieEntity.isExpired()) {
                        arrayList.add(cookieEntity.toHttpCookie());
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
        tryInit();
        ArrayList arrayList = new ArrayList();
        try {
            List<CookieEntity> listFindAll = this.db.findAll(CookieEntity.class);
            if (listFindAll != null) {
                for (CookieEntity cookieEntity : listFindAll) {
                    if (!cookieEntity.isExpired()) {
                        arrayList.add(cookieEntity.toHttpCookie());
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
        tryInit();
        ArrayList arrayList = new ArrayList();
        try {
            List<DbModel> listFindAll = this.db.selector(CookieEntity.class).select(ContentProviderManager.PROVIDER_URI).findAll();
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
                                this.db.delete(CookieEntity.class, WhereBuilder.b(ContentProviderManager.PROVIDER_URI, "=", string));
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
        tryInit();
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
            this.db.delete(CookieEntity.class, whereBuilderB);
            return true;
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
            return false;
        }
    }

    @Override // java.net.CookieStore
    public boolean removeAll() {
        tryInit();
        try {
            this.db.delete(CookieEntity.class);
            return true;
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
            return true;
        }
    }

    private void trimSize() {
        this.trimExecutor.execute(new Runnable() { // from class: com.duoyou.task.sdk.xutils.http.cookie.DbCookieStore.2
            @Override // java.lang.Runnable
            public void run() {
                List listFindAll;
                DbCookieStore.this.tryInit();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - DbCookieStore.this.lastTrimTime < 1000) {
                    return;
                }
                DbCookieStore.this.lastTrimTime = jCurrentTimeMillis;
                try {
                    DbCookieStore.this.db.delete(CookieEntity.class, WhereBuilder.b("expiry", "<", Long.valueOf(System.currentTimeMillis())).and("expiry", "!=", -1L));
                } catch (Throwable th) {
                    LogUtil.e(th.getMessage(), th);
                }
                try {
                    int iCount = (int) DbCookieStore.this.db.selector(CookieEntity.class).count();
                    if (iCount <= 5010 || (listFindAll = DbCookieStore.this.db.selector(CookieEntity.class).where("expiry", "!=", -1L).orderBy("expiry").limit(iCount - 5000).findAll()) == null) {
                        return;
                    }
                    DbCookieStore.this.db.delete(listFindAll);
                } catch (Throwable th2) {
                    LogUtil.e(th2.getMessage(), th2);
                }
            }
        });
    }

    private URI getEffectiveURI(URI uri) {
        try {
            return new URI(a.r, uri.getHost(), uri.getPath(), null, null);
        } catch (Throwable th) {
            LogUtil.w(th.getMessage(), th);
            return uri;
        }
    }
}
