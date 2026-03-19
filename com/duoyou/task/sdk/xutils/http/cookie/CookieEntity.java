package com.duoyou.task.sdk.xutils.http.cookie;

import android.text.TextUtils;
import com.alipay.sdk.m.p0.b;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.duoyou.task.sdk.xutils.db.annotation.Column;
import com.duoyou.task.sdk.xutils.db.annotation.Table;
import java.net.HttpCookie;
import java.net.URI;

@Table(name = "cookie", onCreated = "CREATE UNIQUE INDEX index_cookie_unique ON cookie(\"name\",\"domain\",\"path\")")
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class CookieEntity {
    private static final long MAX_EXPIRY = System.currentTimeMillis() + 3110400000000L;

    @Column(name = "comment")
    private String comment;

    @Column(name = "commentURL")
    private String commentURL;

    @Column(name = "discard")
    private boolean discard;

    @Column(name = "domain")
    private String domain;

    @Column(name = "expiry")
    private long expiry;

    @Column(isId = true, name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "path")
    private String path;

    @Column(name = "portList")
    private String portList;

    @Column(name = "secure")
    private boolean secure;

    @Column(name = ContentProviderManager.PROVIDER_URI)
    private String uri;

    @Column(name = b.d)
    private String value;

    @Column(name = Config.INPUT_DEF_VERSION)
    private int version;

    public CookieEntity() {
        this.expiry = MAX_EXPIRY;
        this.version = 1;
    }

    public CookieEntity(URI uri, HttpCookie httpCookie) {
        long j = MAX_EXPIRY;
        this.expiry = j;
        this.version = 1;
        this.uri = uri == null ? null : uri.toString();
        this.name = httpCookie.getName();
        this.value = httpCookie.getValue();
        this.comment = httpCookie.getComment();
        this.commentURL = httpCookie.getCommentURL();
        this.discard = httpCookie.getDiscard();
        this.domain = httpCookie.getDomain();
        long maxAge = httpCookie.getMaxAge();
        if (maxAge > 0) {
            long jCurrentTimeMillis = (maxAge * 1000) + System.currentTimeMillis();
            this.expiry = jCurrentTimeMillis;
            if (jCurrentTimeMillis < 0) {
                this.expiry = j;
            }
        } else {
            this.expiry = -1L;
        }
        String path = httpCookie.getPath();
        this.path = path;
        if (!TextUtils.isEmpty(path) && this.path.length() > 1 && this.path.endsWith("/")) {
            String str = this.path;
            this.path = str.substring(0, str.length() - 1);
        }
        this.portList = httpCookie.getPortlist();
        this.secure = httpCookie.getSecure();
        this.version = httpCookie.getVersion();
    }

    public HttpCookie toHttpCookie() {
        HttpCookie httpCookie = new HttpCookie(this.name, this.value);
        httpCookie.setComment(this.comment);
        httpCookie.setCommentURL(this.commentURL);
        httpCookie.setDiscard(this.discard);
        httpCookie.setDomain(this.domain);
        long j = this.expiry;
        if (j == -1) {
            httpCookie.setMaxAge(-1L);
        } else {
            httpCookie.setMaxAge((j - System.currentTimeMillis()) / 1000);
        }
        httpCookie.setPath(this.path);
        httpCookie.setPortlist(this.portList);
        httpCookie.setSecure(this.secure);
        httpCookie.setVersion(this.version);
        return httpCookie;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public String getUri() {
        return this.uri;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public boolean isExpired() {
        long j = this.expiry;
        return j != -1 && j < System.currentTimeMillis();
    }
}
