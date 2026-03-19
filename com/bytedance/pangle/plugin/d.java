package com.bytedance.pangle.plugin;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.h;
import com.bytedance.pangle.util.uo;
import java.io.File;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends Plugin {
    private com.bytedance.pangle.b.d d;

    public d(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public void d(com.bytedance.pangle.b.d dVar) {
        this.d = dVar;
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public JSONObject getJsonConfig() {
        com.bytedance.pangle.b.d dVar = this.d;
        if (dVar == null) {
            return null;
        }
        return dVar.an();
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public String toString() {
        return "DexPlugin{pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", life=" + this.mLifeCycle + '}';
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0052 A[Catch: Exception -> 0x005a, all -> 0x00d8, TRY_LEAVE, TryCatch #0 {Exception -> 0x005a, blocks: (B:20:0x0044, B:22:0x0047, B:23:0x0052), top: B:52:0x0044, outer: #1 }] */
    @Override // com.bytedance.pangle.plugin.Plugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void init() {
        /*
            r9 = this;
            boolean r0 = r9.mInitialized
            if (r0 == 0) goto L5
            return
        L5:
            java.lang.Object r0 = r9.initializeLock
            monitor-enter(r0)
            boolean r1 = r9.mInitialized     // Catch: java.lang.Throwable -> Ld8
            if (r1 == 0) goto Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Ld8
            return
        Le:
            android.app.Application r1 = com.bytedance.pangle.Zeus.getAppApplication()     // Catch: java.lang.Throwable -> Ld8
            boolean r1 = com.bytedance.pangle.u.c.hc(r1)     // Catch: java.lang.Throwable -> Ld8
            r2 = 1
            if (r1 == 0) goto Ld1
            r9.deleteIfNeeded()     // Catch: java.lang.Throwable -> Ld8
            com.bytedance.pangle.util.uo r1 = com.bytedance.pangle.util.uo.d()     // Catch: java.lang.Throwable -> Ld8
            java.lang.String r3 = r9.mPkgName     // Catch: java.lang.Throwable -> Ld8
            java.lang.String r1 = r1.mk(r3)     // Catch: java.lang.Throwable -> Ld8
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> Ld8
            if (r3 == 0) goto L2e
            java.lang.String r1 = r9.mPkgName     // Catch: java.lang.Throwable -> Ld8
        L2e:
            int r3 = com.bytedance.pangle.b.hc.d(r1)     // Catch: java.lang.Throwable -> Ld8
            r4 = -1
            if (r3 == r4) goto Lcd
            java.io.File[] r4 = com.bytedance.pangle.u.b.mk(r1, r3)     // Catch: java.lang.Throwable -> Ld8
            java.lang.String r1 = com.bytedance.pangle.u.b.mq(r1, r3)     // Catch: java.lang.Throwable -> Ld8
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> Ld8
            r5.<init>(r1)     // Catch: java.lang.Throwable -> Ld8
            if (r4 == 0) goto L52
            int r1 = r4.length     // Catch: java.lang.Exception -> L5a java.lang.Throwable -> Ld8
            if (r1 <= 0) goto L52
            java.util.List r1 = java.util.Arrays.asList(r4)     // Catch: java.lang.Exception -> L5a java.lang.Throwable -> Ld8
            com.bytedance.pangle.b.d r1 = com.bytedance.pangle.b.hc.d(r5, r1)     // Catch: java.lang.Exception -> L5a java.lang.Throwable -> Ld8
            r9.d = r1     // Catch: java.lang.Exception -> L5a java.lang.Throwable -> Ld8
            goto L6d
        L52:
            java.lang.String r1 = "Zeus/install_pangle"
            java.lang.String r6 = "DexPlugin initDexPlugins unDexZip fail throw exception"
            com.bytedance.pangle.log.ZeusLogger.w(r1, r6)     // Catch: java.lang.Exception -> L5a java.lang.Throwable -> Ld8
            goto L6d
        L5a:
            r1 = move-exception
            java.lang.String r6 = "Zeus/install_pangle"
            java.lang.String r7 = "DexPlugin initDexPlugins fail throw exception "
            java.lang.String r8 = java.lang.String.valueOf(r1)     // Catch: java.lang.Throwable -> Ld8
            java.lang.String r7 = r7.concat(r8)     // Catch: java.lang.Throwable -> Ld8
            com.bytedance.pangle.log.ZeusLogger.w(r6, r7)     // Catch: java.lang.Throwable -> Ld8
            com.bytedance.sdk.openadsdk.api.an.d(r1)     // Catch: java.lang.Throwable -> Ld8
        L6d:
            r1 = 0
            if (r4 == 0) goto L85
            int r4 = r4.length     // Catch: java.lang.Throwable -> Ld8
            if (r4 <= 0) goto L85
            boolean r4 = r5.isFile()     // Catch: java.lang.Throwable -> Ld8
            if (r4 == 0) goto L85
            com.bytedance.pangle.b.d r4 = r9.d     // Catch: java.lang.Throwable -> Ld8
            if (r4 == 0) goto L85
            boolean r4 = r4.d()     // Catch: java.lang.Throwable -> Ld8
            if (r4 == 0) goto L85
            r4 = r2
            goto L86
        L85:
            r4 = r1
        L86:
            if (r4 == 0) goto L8c
            r9.updateToInstalled(r3)     // Catch: java.lang.Throwable -> Ld8
            goto L8d
        L8c:
            r3 = r1
        L8d:
            r9.d(r3)     // Catch: java.lang.Throwable -> Ld8
            java.lang.String r1 = "Zeus/init_pangle"
            java.lang.String r3 = "DexPlugin initDexPlugins result="
            java.lang.String r4 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> Ld8
            java.lang.String r3 = r3.concat(r4)     // Catch: java.lang.Throwable -> Ld8
            com.bytedance.pangle.log.ZeusLogger.i(r1, r3)     // Catch: java.lang.Throwable -> Ld8
            com.bytedance.pangle.util.uo r1 = com.bytedance.pangle.util.uo.d()     // Catch: java.lang.Throwable -> Ld8
            java.lang.String r3 = r9.mPkgName     // Catch: java.lang.Throwable -> Ld8
            r1.d(r3)     // Catch: java.lang.Throwable -> Ld8
            com.bytedance.pangle.util.uo r1 = com.bytedance.pangle.util.uo.d()     // Catch: java.lang.Throwable -> Ld8
            java.lang.String r3 = r9.mPkgName     // Catch: java.lang.Throwable -> Ld8
            r1.c(r3)     // Catch: java.lang.Throwable -> Ld8
            com.bytedance.pangle.util.uo r1 = com.bytedance.pangle.util.uo.d()     // Catch: java.lang.Throwable -> Ld8
            java.lang.String r3 = r9.mPkgName     // Catch: java.lang.Throwable -> Ld8
            android.app.Application r4 = com.bytedance.pangle.Zeus.getAppApplication()     // Catch: java.lang.Throwable -> Ld8
            java.lang.String r4 = com.bytedance.pangle.util.hc.d(r4)     // Catch: java.lang.Throwable -> Ld8
            r1.d(r3, r4)     // Catch: java.lang.Throwable -> Ld8
            com.bytedance.pangle.util.uo r1 = com.bytedance.pangle.util.uo.d()     // Catch: java.lang.Throwable -> Ld8
            java.lang.String r3 = r9.mPkgName     // Catch: java.lang.Throwable -> Ld8
            int r4 = r9.mApiVersionCode     // Catch: java.lang.Throwable -> Ld8
            r1.d(r3, r4)     // Catch: java.lang.Throwable -> Ld8
        Lcd:
            r9.d()     // Catch: java.lang.Throwable -> Ld8
            goto Ld4
        Ld1:
            r9.updateInstallStateFromMainProcess()     // Catch: java.lang.Throwable -> Ld8
        Ld4:
            r9.mInitialized = r2     // Catch: java.lang.Throwable -> Ld8
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Ld8
            return
        Ld8:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Ld8
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.plugin.d.init():void");
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    boolean install(File file, com.bytedance.pangle.h.d.u uVar) {
        boolean zD = false;
        if (uVar != null) {
            try {
                if (uVar.b != null) {
                    com.bytedance.pangle.b.d dVar = uVar.b;
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin thread name=" + Thread.currentThread().getName() + " install dex from config " + dVar);
                    String strHc = dVar.hc();
                    int iB = dVar.b();
                    synchronized (this.installLock) {
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin synchronized begin, packageName=" + strHc + " plugin=" + this);
                        boolean zD2 = dVar.d();
                        if (zD2 && (zD = com.bytedance.pangle.b.hc.d(dVar, SystemClock.elapsedRealtime()))) {
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin markPluginInstalled, packageName=" + strHc + " version=" + iB);
                        }
                        synchronized (this) {
                            if (zD2) {
                                if (this.mLifeCycle == 3) {
                                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin Dex LIFE_LOADED " + strHc + ":" + this.mVersionCode);
                                } else if (zD) {
                                    updateToInstalled(iB);
                                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin Dex INSTALLED_SUCCESS " + strHc + ":" + iB);
                                } else {
                                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin Dex INSTALL_FAILED " + strHc + ":" + iB);
                                }
                            } else {
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin Dex invalid " + strHc + ":" + iB);
                            }
                            h.d(file);
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin Dex deleting unDexZip pkgName=" + strHc + " version=" + iB + " apkFile=" + file);
                        }
                    }
                }
            } catch (Throwable th) {
                ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "DexPlugin DEX ZIP IMPOSSIBLE!!!", th);
            }
        }
        return zD;
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    protected void deleteIfNeeded() {
        if (com.bytedance.pangle.u.c.hc(Zeus.getAppApplication()) && uo.d().tt(this.mPkgName)) {
            uo.d().gb(this.mPkgName);
            String strD = com.bytedance.pangle.u.b.d(this.mPkgName);
            h.d(strD);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "DexPlugin deleteIfNeeded " + this.mPkgName + " dir=" + strD);
            hc();
            b();
        }
    }

    private void hc() {
        List<String> listUo = uo.d().uo(this.mPkgName);
        if (listUo == null || listUo.size() <= 0) {
            return;
        }
        for (String str : listUo) {
            if (!TextUtils.isEmpty(str)) {
                int iD = com.bytedance.pangle.b.hc.d(str);
                if (iD != -1) {
                    uo.d().hc(str, iD, false);
                }
                h.d(com.bytedance.pangle.u.b.d(str));
            }
        }
        uo.d().k(this.mPkgName);
        ZeusLogger.w(ZeusLogger.TAG_INIT, "DexPlugin deleteAliasLastTimePackageName list=".concat(String.valueOf(listUo)));
    }

    private void b() {
        String strMk = uo.d().mk(this.mPkgName);
        if (TextUtils.isEmpty(strMk)) {
            return;
        }
        String strD = com.bytedance.pangle.u.b.d(strMk);
        h.d(strD);
        uo.d().mq(this.mPkgName);
        ZeusLogger.w(ZeusLogger.TAG_INIT, "DexPlugin deleteA_PackageName dir=".concat(String.valueOf(strD)));
    }

    private void d(int i) {
        if (com.bytedance.pangle.u.c.hc(Zeus.getAppApplication())) {
            hc();
            String strMk = uo.d().mk(this.mPkgName);
            if (!TextUtils.isEmpty(strMk)) {
                com.bytedance.pangle.b.hc.d(strMk, i);
            } else {
                com.bytedance.pangle.b.hc.d(this.mPkgName, i);
            }
        }
    }

    public void d() {
        String strD = com.bytedance.pangle.u.b.d(this.mPkgName);
        if (TextUtils.isEmpty(strD)) {
            return;
        }
        File[] fileArrListFiles = new File(strD).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            ZeusLogger.d(ZeusLogger.TAG_LOAD, "DexPlugin clear install file, packageName=" + this.mPkgName + " no children files,need delete dir=" + strD);
            h.d(strD);
        }
    }
}
