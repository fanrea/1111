package com.bytedance.sdk.component.tt.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.m.l.a;
import com.bytedance.sdk.component.hc.d.cb;
import com.bytedance.sdk.component.hc.d.k;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u {
    private d b;
    private boolean c;
    private c gb;
    private Context h;
    private int rf;
    private hc u;
    private long hc = 0;
    private boolean an = false;
    private int tt = 0;
    private long tc = 19700101000L;
    private int mk = 0;
    private HashMap<String, Integer> mq = new HashMap<>();
    private HashMap<String, Integer> uo = new HashMap<>();
    private int k = 0;
    private HashMap<String, Integer> e = new HashMap<>();
    private HashMap<String, Integer> cb = new HashMap<>();
    private boolean w = true;
    private Map<String, Integer> yo = new HashMap();
    Handler d = new Handler(Looper.getMainLooper()) { // from class: com.bytedance.sdk.component.tt.b.u.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 10000) {
                return;
            }
            u.this.hc(message.arg1 != 0);
        }
    };

    private boolean d(int i) {
        return i >= 200 && i < 400;
    }

    private u() {
    }

    public u(int i) {
        this.rf = i;
    }

    public String d() {
        return "ttnet_tnc_config" + this.rf;
    }

    public d hc() {
        return this.b;
    }

    public void d(boolean z) {
        this.c = z;
    }

    public void d(hc hcVar) {
        this.u = hcVar;
    }

    public boolean b() {
        return this.c;
    }

    public hc c() {
        return this.u;
    }

    public void u() {
        this.yo.clear();
    }

    public synchronized void d(Context context, boolean z) {
        if (!this.an) {
            this.h = context;
            this.w = z;
            this.gb = new c(context, z, this.rf);
            if (z) {
                tt();
            }
            com.bytedance.sdk.component.tt.c.b.hc("TNCManager", "initTnc, isMainProc: " + z + " probeCmd: " + this.tt + " probeVersion: " + this.tc);
            this.b = h.d().d(this.rf, this.h);
            this.an = true;
        }
    }

    private void tt() {
        SharedPreferences sharedPreferencesHc = com.bytedance.sdk.openadsdk.api.plugin.hc.hc(this.h, d(), 0);
        this.tt = sharedPreferencesHc.getInt("tnc_probe_cmd", 0);
        this.tc = sharedPreferencesHc.getLong("tnc_probe_version", 19700101000L);
    }

    public b an() {
        c cVar = this.gb;
        if (cVar != null) {
            return cVar.b();
        }
        return null;
    }

    public Map<String, String> h() {
        b bVarAn = an();
        if (bVarAn != null) {
            return bVarAn.c;
        }
        return null;
    }

    public c gb() {
        return this.gb;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String d(java.lang.String r7) {
        /*
            r6 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 != 0) goto Le2
            java.lang.String r0 = "/network/get_network"
            boolean r0 = r7.contains(r0)
            if (r0 != 0) goto Le2
            java.lang.String r0 = "/get_domains/v4"
            boolean r0 = r7.contains(r0)
            if (r0 != 0) goto Le2
            java.lang.String r0 = "/ies/speed"
            boolean r0 = r7.contains(r0)
            if (r0 == 0) goto L20
            goto Le2
        L20:
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L31
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L31
            java.lang.String r2 = r1.getProtocol()     // Catch: java.lang.Throwable -> L31
            java.lang.String r0 = r1.getHost()     // Catch: java.lang.Throwable -> L2f
            goto L36
        L2f:
            r1 = move-exception
            goto L33
        L31:
            r1 = move-exception
            r2 = r0
        L33:
            com.bytedance.sdk.component.utils.mq.d(r1)
        L36:
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto Le2
            java.lang.String r1 = "http"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L4c
            java.lang.String r1 = "https"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto Le2
        L4c:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L54
            goto Le2
        L54:
            boolean r1 = r6.c(r0)
            java.lang.String r3 = "TNCManager"
            if (r1 == 0) goto L6a
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "handleHostMapping, TNC host faild num over limit: "
            java.lang.String r0 = r1.concat(r0)
            com.bytedance.sdk.component.tt.c.b.hc(r3, r0)
            return r7
        L6a:
            java.util.Map r1 = r6.h()
            if (r1 == 0) goto Ld5
            boolean r4 = r1.containsKey(r0)
            if (r4 != 0) goto L77
            goto Ld5
        L77:
            java.lang.Object r1 = r1.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 == 0) goto L84
            return r7
        L84:
            java.lang.String r4 = java.lang.String.valueOf(r7)
            java.lang.String r5 = "handleHostMapping, match, origin: "
            java.lang.String r4 = r5.concat(r4)
            com.bytedance.sdk.component.tt.c.b.hc(r3, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.StringBuilder r4 = r4.append(r2)
            java.lang.String r5 = "://"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r0 = r4.append(r0)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.StringBuilder r2 = r4.append(r2)
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r1 = r1.toString()
            boolean r2 = r7.startsWith(r0)
            if (r2 == 0) goto Lc7
            java.lang.String r7 = r7.replaceFirst(r0, r1)
        Lc7:
            java.lang.String r0 = java.lang.String.valueOf(r7)
            java.lang.String r1 = "handleHostMapping, target: "
            java.lang.String r0 = r1.concat(r0)
            com.bytedance.sdk.component.tt.c.b.hc(r3, r0)
            return r7
        Ld5:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "handleHostMapping, nomatch: "
            java.lang.String r0 = r1.concat(r0)
            com.bytedance.sdk.component.tt.c.b.hc(r3, r0)
        Le2:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.tt.b.u.d(java.lang.String):java.lang.String");
    }

    public synchronized void d(k kVar, cb cbVar) {
        if (kVar == null || cbVar == null) {
            return;
        }
        if (this.w) {
            if (com.bytedance.sdk.component.tt.c.an.d(this.h)) {
                URL urlD = null;
                try {
                    urlD = kVar.hc().d();
                } catch (Exception unused) {
                }
                if (urlD == null) {
                    return;
                }
                String protocol = urlD.getProtocol();
                String host = urlD.getHost();
                String path = urlD.getPath();
                String strD = d(kVar);
                int iB = cbVar.b();
                if (a.r.equals(protocol) || "https".equals(protocol)) {
                    if (TextUtils.isEmpty(strD)) {
                        return;
                    }
                    com.bytedance.sdk.component.tt.c.b.hc("TNCManager", "onResponse, url: " + protocol + "://" + host + "#" + strD + "#" + iB);
                    b bVarAn = an();
                    if (bVarAn != null && bVarAn.hc) {
                        d(cbVar, host);
                    }
                    if (bVarAn == null) {
                        return;
                    }
                    com.bytedance.sdk.component.tt.c.b.hc("TNCManager", "onResponse, url matched: " + protocol + "://" + host + "#" + strD + "#" + iB + " " + this.mk + "#" + this.mq.size() + "#" + this.uo.size() + " " + this.k + "#" + this.e.size() + "#" + this.cb.size());
                    if (iB > 0) {
                        if (d(iB)) {
                            if (this.mk > 0 || this.k > 0) {
                                tc();
                            }
                            b(host);
                            return;
                        }
                        if (!hc(iB)) {
                            this.k++;
                            this.e.put(path, 0);
                            this.cb.put(strD, 0);
                            if (this.k >= bVarAn.gb && this.e.size() >= bVarAn.tt && this.cb.size() >= bVarAn.tc) {
                                com.bytedance.sdk.component.tt.c.b.hc("TNCManager", "onResponse, url doUpdate: " + protocol + "://" + host + "#" + strD + "#" + iB);
                                d(false, 0L);
                                tc();
                            }
                            hc(host);
                        }
                    }
                }
            }
        }
    }

    private String d(k kVar) {
        if (kVar == null || kVar.hc() == null || kVar.hc().d() == null) {
            return "";
        }
        try {
            return InetAddress.getByName(kVar.hc().d().getHost()).getHostAddress();
        } catch (Exception unused) {
            return "";
        }
    }

    private void hc(String str) {
        Map<String, String> mapH;
        if (TextUtils.isEmpty(str) || (mapH = h()) == null || !mapH.containsValue(str)) {
            return;
        }
        if (this.yo.get(str) == null) {
            this.yo.put(str, 1);
        } else {
            this.yo.put(str, Integer.valueOf(this.yo.get(str).intValue() + 1));
        }
    }

    private void b(String str) {
        if (!TextUtils.isEmpty(str) && this.yo.containsKey(str)) {
            this.yo.put(str, 0);
        }
    }

    private boolean c(String str) {
        Map<String, String> mapH = h();
        if (mapH == null) {
            return false;
        }
        String str2 = mapH.get(str);
        if (TextUtils.isEmpty(str2) || this.yo.get(str2) == null || this.yo.get(str2).intValue() < 3) {
            return false;
        }
        com.bytedance.sdk.component.tt.c.b.hc("TNCManager", "handleHostMapping, TNC host faild num over limit: ".concat(String.valueOf(str)));
        return true;
    }

    public synchronized void d(k kVar, Exception exc) {
        if (kVar != null) {
            if (kVar.hc() != null && exc != null) {
                if (this.w) {
                    if (com.bytedance.sdk.component.tt.c.an.d(this.h)) {
                        URL urlD = null;
                        try {
                            urlD = kVar.hc().d();
                        } catch (Exception unused) {
                        }
                        if (urlD == null) {
                            return;
                        }
                        String protocol = urlD.getProtocol();
                        String host = urlD.getHost();
                        String path = urlD.getPath();
                        String strD = d(kVar);
                        if (a.r.equals(protocol) || "https".equals(protocol)) {
                            b bVarAn = an();
                            if (bVarAn == null) {
                                return;
                            }
                            com.bytedance.sdk.component.tt.c.b.hc("TNCManager", "onError, url matched: " + protocol + "://" + host + "#" + strD + "# " + this.mk + "#" + this.mq.size() + "#" + this.uo.size() + " " + this.k + "#" + this.e.size() + "#" + this.cb.size());
                            this.mk++;
                            this.mq.put(path, 0);
                            this.uo.put(strD, 0);
                            if (this.mk >= bVarAn.u && this.mq.size() >= bVarAn.an && this.uo.size() >= bVarAn.h) {
                                com.bytedance.sdk.component.tt.c.b.hc("TNCManager", "onError, url doUpate: " + protocol + "://" + host + "#" + strD);
                                d(false, 0L);
                                tc();
                            }
                            hc(host);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0099 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(com.bytedance.sdk.component.hc.d.cb r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.tt.b.u.d(com.bytedance.sdk.component.hc.d.cb, java.lang.String):void");
    }

    private void d(boolean z, long j) {
        if (this.d.hasMessages(10000)) {
            return;
        }
        Message messageObtainMessage = this.d.obtainMessage();
        messageObtainMessage.what = 10000;
        messageObtainMessage.arg1 = z ? 1 : 0;
        if (j > 0) {
            this.d.sendMessageDelayed(messageObtainMessage, j);
        } else {
            this.d.sendMessage(messageObtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc(boolean z) {
        if (an() == null) {
            return;
        }
        com.bytedance.sdk.component.tt.c.b.hc("TNCManager", "doUpdateRemote, ".concat(String.valueOf(z)));
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (!z && this.hc + (r0.mk * 1000) > jElapsedRealtime) {
            com.bytedance.sdk.component.tt.c.b.hc("TNCManager", "doUpdateRemote, time limit");
        } else {
            this.hc = jElapsedRealtime;
            h.d().d(this.rf, this.h).b();
        }
    }

    private void tc() {
        com.bytedance.sdk.component.tt.c.b.hc("TNCManager", "resetTNCControlState");
        this.mk = 0;
        this.mq.clear();
        this.uo.clear();
        this.k = 0;
        this.e.clear();
        this.cb.clear();
    }

    private boolean hc(int i) {
        if (i < 100 || i >= 1000) {
            return true;
        }
        b bVarAn = an();
        return (bVarAn == null || TextUtils.isEmpty(bVarAn.uo) || !bVarAn.uo.contains(String.valueOf(i))) ? false : true;
    }
}
