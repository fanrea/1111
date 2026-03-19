package com.kwad.sdk.glide.load.c;

import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.utils.ax;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class g implements com.kwad.sdk.glide.load.c {
    private int bUb;
    private final h bWk;
    private final String bWl;
    private String bWm;
    private URL bWn;
    private volatile byte[] bWo;
    private final URL url;

    public g(URL url) {
        this(url, h.bWq);
    }

    public g(String str) {
        this(str, h.bWq);
    }

    private g(URL url, h hVar) {
        this.url = (URL) ax.checkNotNull(url);
        this.bWl = null;
        this.bWk = (h) ax.checkNotNull(hVar);
    }

    private g(String str, h hVar) {
        this.url = null;
        this.bWl = ax.iA(str);
        this.bWk = (h) ax.checkNotNull(hVar);
    }

    public final URL toURL() {
        return ahx();
    }

    private URL ahx() {
        if (this.bWn == null) {
            this.bWn = new URL(ahy());
        }
        return this.bWn;
    }

    private String ahy() {
        if (TextUtils.isEmpty(this.bWm)) {
            String string = this.bWl;
            if (TextUtils.isEmpty(string)) {
                string = ((URL) ax.checkNotNull(this.url)).toString();
            }
            this.bWm = Uri.encode(string, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.bWm;
    }

    public final Map<String, String> getHeaders() {
        return this.bWk.getHeaders();
    }

    private String getCacheKey() {
        String str = this.bWl;
        return str != null ? str : ((URL) ax.checkNotNull(this.url)).toString();
    }

    public String toString() {
        return getCacheKey();
    }

    @Override // com.kwad.sdk.glide.load.c
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ahz());
    }

    private byte[] ahz() {
        if (this.bWo == null) {
            this.bWo = getCacheKey().getBytes(bRy);
        }
        return this.bWo;
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (getCacheKey().equals(gVar.getCacheKey()) && this.bWk.equals(gVar.bWk)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        if (this.bUb == 0) {
            int iHashCode = getCacheKey().hashCode();
            this.bUb = iHashCode;
            this.bUb = (iHashCode * 31) + this.bWk.hashCode();
        }
        return this.bUb;
    }
}
