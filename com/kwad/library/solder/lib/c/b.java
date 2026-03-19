package com.kwad.library.solder.lib.c;

import java.util.HashMap;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b implements Comparable<b> {
    public String biI;
    public boolean biJ;
    public String bjd;
    public String bje;
    public long bjf;
    public String bjg;
    public boolean bjh = false;
    public boolean bji = true;
    public HashMap<String, String> bjj = new HashMap<>(10);
    public List<String> bjk;
    public List<String> bjl;
    public ClassLoader bjm;
    public boolean enable;
    public String version;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(b bVar) {
        return -this.version.compareTo(bVar.version);
    }

    public final String toString() {
        return "RemotePluginInfo{pluginId='" + this.bjd + "', version='" + this.version + "', downloadUrl='" + this.bje + "', fileSize=" + this.bjf + ", enable=" + this.enable + ", md5sum='" + this.bjg + "', onlyWifiDownload=" + this.bjh + ", onlyWifiRetryDownload=" + this.bji + ", soMd5s=" + this.bjj + ", hostPackages=" + this.bjk + ", hostInterfaces=" + this.bjl + '}';
    }
}
