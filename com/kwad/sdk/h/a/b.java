package com.kwad.sdk.h.a;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.kwad.sdk.utils.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    public String biL;
    public String cbm;
    public String cbn;
    public long cbo;
    public boolean cbp;
    public int loadType;
    public String packageId;
    public int packageType;
    public String packageUrl;
    public String version;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (bq.isEquals(this.packageId, bVar.packageId) && bq.isEquals(this.biL, bVar.biL) && bq.isEquals(this.version, bVar.version)) {
                return true;
            }
        }
        return false;
    }

    public final long akg() {
        return this.cbo;
    }

    public final void bt(long j) {
        this.cbo = j;
    }

    public int hashCode() {
        StringBuilder sbAppend = new StringBuilder().append(this.packageId).append(Config.replace).append(this.biL).append(Config.replace).append(this.version);
        return TextUtils.isEmpty(sbAppend.toString()) ? super.hashCode() : sbAppend.toString().hashCode();
    }

    @Override // com.kwad.sdk.core.response.a.a
    public String toString() {
        return "PackageInfoBean{packageId='" + this.packageId + "', zipFileName='" + this.cbm + "', zipPath='" + this.cbn + "', startDownloadTime=" + this.cbo + ", packageUrl='" + this.packageUrl + "', version='" + this.version + "', checksum='" + this.biL + "', loadType=" + this.loadType + ", packageType=" + this.packageType + ", isPublic=" + this.cbp + '}';
    }

    public final boolean isValid() {
        return (TextUtils.isEmpty(this.packageId) || TextUtils.isEmpty(this.packageUrl) || TextUtils.isEmpty(this.version) || TextUtils.isEmpty(this.cbm)) ? false : true;
    }
}
