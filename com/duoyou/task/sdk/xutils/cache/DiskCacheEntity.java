package com.duoyou.task.sdk.xutils.cache;

import androidx.core.location.LocationRequestCompat;
import com.duoyou.task.sdk.xutils.db.annotation.Column;
import com.duoyou.task.sdk.xutils.db.annotation.Table;
import java.util.Date;

@Table(name = "disk_cache")
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class DiskCacheEntity {

    @Column(name = "bytesContent")
    private byte[] bytesContent;

    @Column(name = "etag")
    private String etag;

    @Column(name = "expires")
    private long expires = LocationRequestCompat.PASSIVE_INTERVAL;

    @Column(name = "hits")
    private long hits;

    @Column(isId = true, name = "id")
    private long id;

    @Column(name = "key", property = "UNIQUE")
    private String key;

    @Column(name = "lastAccess")
    private long lastAccess;

    @Column(name = "lastModify")
    private Date lastModify;

    @Column(name = "path")
    private String path;

    @Column(name = "textContent")
    private String textContent;

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public String getTextContent() {
        return this.textContent;
    }

    public void setTextContent(String str) {
        this.textContent = str;
    }

    public byte[] getBytesContent() {
        return this.bytesContent;
    }

    public void setBytesContent(byte[] bArr) {
        this.bytesContent = bArr;
    }

    public long getExpires() {
        return this.expires;
    }

    public void setExpires(long j) {
        this.expires = j;
    }

    public String getEtag() {
        return this.etag;
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    public long getHits() {
        return this.hits;
    }

    public void setHits(long j) {
        this.hits = j;
    }

    public Date getLastModify() {
        return this.lastModify;
    }

    public void setLastModify(Date date) {
        this.lastModify = date;
    }

    public long getLastAccess() {
        long j = this.lastAccess;
        return j == 0 ? System.currentTimeMillis() : j;
    }

    public void setLastAccess(long j) {
        this.lastAccess = j;
    }
}
