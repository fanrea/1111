package lkxssdk.q0;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.lingku.xuanshang.xutils.db.annotation.Column;
import com.lingku.xuanshang.xutils.db.annotation.Table;
import java.net.HttpCookie;
import java.net.URI;

@Table(name = "cookie", onCreated = "CREATE UNIQUE INDEX index_cookie_unique ON cookie(\"name\",\"domain\",\"path\")")
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class a {
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

    @Column(name = com.alipay.sdk.m.p0.b.d)
    private String value;

    @Column(name = Config.INPUT_DEF_VERSION)
    private int version;

    public a() {
        this.expiry = MAX_EXPIRY;
        this.version = 1;
    }

    public a(URI uri, HttpCookie httpCookie) {
        String path;
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
            }
            path = httpCookie.getPath();
            this.path = path;
            if (!TextUtils.isEmpty(path) && this.path.length() > 1 && this.path.endsWith("/")) {
                String str = this.path;
                this.path = str.substring(0, str.length() - 1);
            }
            this.portList = httpCookie.getPortlist();
            this.secure = httpCookie.getSecure();
            this.version = httpCookie.getVersion();
        }
        j = -1;
        this.expiry = j;
        path = httpCookie.getPath();
        this.path = path;
        if (!TextUtils.isEmpty(path)) {
            String str2 = this.path;
            this.path = str2.substring(0, str2.length() - 1);
        }
        this.portList = httpCookie.getPortlist();
        this.secure = httpCookie.getSecure();
        this.version = httpCookie.getVersion();
    }

    public long getId() {
        return this.id;
    }

    public String getUri() {
        return this.uri;
    }

    public boolean isExpired() {
        long j = this.expiry;
        return j != -1 && j < System.currentTimeMillis();
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setUri(String str) {
        this.uri = str;
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
}
