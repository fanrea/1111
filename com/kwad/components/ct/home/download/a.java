package com.kwad.components.ct.home.download;

import android.text.TextUtils;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.crash.utils.b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.bf;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a {
    private static volatile a aIn;
    private File aIg;
    private File aIh;
    private File aIi;
    private File aIj;
    private File aIk;
    private Stack<HomeApkBannerData> aIc = new Stack<>();
    private Stack<HomeApkBannerData> aId = new Stack<>();
    private Map<String, Integer> aIe = new HashMap();
    private int aIl = 0;
    private boolean aIm = false;
    private String aIf = bf.eA(((f) ServiceProvider.get(f.class)).getContext());

    public a() {
        File file = new File(this.aIf);
        if (!file.exists()) {
            file.mkdir();
        }
        this.aIg = new File(this.aIf + File.separator + "download_uninstall");
        File file2 = new File(this.aIf + File.separator + "download_uninstall_apk_data");
        this.aIi = file2;
        if (!file2.exists()) {
            this.aIi.mkdir();
        }
        File file3 = new File(this.aIf + File.separator + "install_unopen_apk_data");
        this.aIj = file3;
        if (!file3.exists()) {
            this.aIj.mkdir();
        }
        this.aIh = new File(this.aIf + File.separator + "install_unopen");
        this.aIk = new File(this.aIf + File.separator + "app_has_show_banner_counts");
    }

    public static a Gc() {
        if (aIn == null) {
            synchronized (a.class) {
                if (aIn == null) {
                    aIn = new a();
                }
            }
        }
        return aIn;
    }

    public final void l(CtAdTemplate ctAdTemplate) {
        ObjectOutputStream objectOutputStream;
        HomeApkBannerData homeApkBannerDataConvertAdTemplateToHomeApkBannerData;
        synchronized (a.class) {
            ObjectOutputStream objectOutputStream2 = null;
            try {
                homeApkBannerDataConvertAdTemplateToHomeApkBannerData = HomeApkBannerData.convertAdTemplateToHomeApkBannerData(ctAdTemplate);
            } catch (Exception e) {
                e = e;
                objectOutputStream = null;
            } catch (Throwable th) {
                th = th;
                objectOutputStream = null;
            }
            if (homeApkBannerDataConvertAdTemplateToHomeApkBannerData == null) {
                b.closeQuietly((Closeable) null);
                b.closeQuietly((Closeable) null);
                return;
            }
            this.aIc.push(homeApkBannerDataConvertAdTemplateToHomeApkBannerData);
            ObjectOutputStream objectOutputStream3 = new ObjectOutputStream(new FileOutputStream(this.aIg));
            try {
                objectOutputStream3.writeObject(this.aIc);
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(b(homeApkBannerDataConvertAdTemplateToHomeApkBannerData, true)));
            } catch (Exception e2) {
                e = e2;
                objectOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream = null;
            }
            try {
                objectOutputStream.writeObject(ctAdTemplate);
                b.closeQuietly(objectOutputStream3);
            } catch (Exception e3) {
                e = e3;
                objectOutputStream2 = objectOutputStream3;
                try {
                    c.d("HomeApkBannerDataManager", " addApkDownloadedData e" + e);
                    b.closeQuietly(objectOutputStream2);
                    b.closeQuietly(objectOutputStream);
                } catch (Throwable th3) {
                    th = th3;
                    b.closeQuietly(objectOutputStream2);
                    b.closeQuietly(objectOutputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                objectOutputStream2 = objectOutputStream3;
                b.closeQuietly(objectOutputStream2);
                b.closeQuietly(objectOutputStream);
                throw th;
            }
            b.closeQuietly(objectOutputStream);
        }
    }

    public final void m(CtAdTemplate ctAdTemplate) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        Exception e;
        HomeApkBannerData homeApkBannerDataConvertAdTemplateToHomeApkBannerData;
        synchronized (a.class) {
            boolean z = false;
            try {
                homeApkBannerDataConvertAdTemplateToHomeApkBannerData = HomeApkBannerData.convertAdTemplateToHomeApkBannerData(ctAdTemplate);
            } catch (Throwable unused) {
            }
            if (homeApkBannerDataConvertAdTemplateToHomeApkBannerData == null) {
                return;
            }
            Iterator<HomeApkBannerData> it = this.aIc.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(homeApkBannerDataConvertAdTemplateToHomeApkBannerData.appPackageName, it.next().appPackageName)) {
                    it.remove();
                    z = true;
                }
            }
            if (z) {
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.aIg));
                } catch (Exception e2) {
                    objectOutputStream = null;
                    e = e2;
                } catch (Throwable th2) {
                    objectOutputStream = null;
                    th = th2;
                    b.closeQuietly(objectOutputStream);
                    throw th;
                }
                try {
                    try {
                        objectOutputStream.writeObject(this.aIc);
                    } catch (Throwable th3) {
                        th = th3;
                        b.closeQuietly(objectOutputStream);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    c.d("HomeApkBannerDataManager", " removeApkDownloadedData e" + e);
                    b.closeQuietly(objectOutputStream);
                }
                b.closeQuietly(objectOutputStream);
            }
        }
    }

    public final void n(CtAdTemplate ctAdTemplate) {
        ObjectOutputStream objectOutputStream;
        HomeApkBannerData homeApkBannerDataConvertAdTemplateToHomeApkBannerData;
        synchronized (a.class) {
            ObjectOutputStream objectOutputStream2 = null;
            try {
                homeApkBannerDataConvertAdTemplateToHomeApkBannerData = HomeApkBannerData.convertAdTemplateToHomeApkBannerData(ctAdTemplate);
            } catch (Exception e) {
                e = e;
                objectOutputStream = null;
            } catch (Throwable th) {
                th = th;
                objectOutputStream = null;
            }
            if (homeApkBannerDataConvertAdTemplateToHomeApkBannerData == null) {
                b.closeQuietly((Closeable) null);
                b.closeQuietly((Closeable) null);
                return;
            }
            this.aId.push(homeApkBannerDataConvertAdTemplateToHomeApkBannerData);
            ObjectOutputStream objectOutputStream3 = new ObjectOutputStream(new FileOutputStream(this.aIh));
            try {
                objectOutputStream3.writeObject(this.aId);
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(b(homeApkBannerDataConvertAdTemplateToHomeApkBannerData, false)));
            } catch (Exception e2) {
                e = e2;
                objectOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream = null;
            }
            try {
                objectOutputStream.writeObject(ctAdTemplate);
                b.closeQuietly(objectOutputStream3);
            } catch (Exception e3) {
                e = e3;
                objectOutputStream2 = objectOutputStream3;
                try {
                    c.d("HomeApkBannerDataManager", " addInstalledData e" + e);
                    b.closeQuietly(objectOutputStream2);
                    b.closeQuietly(objectOutputStream);
                } catch (Throwable th3) {
                    th = th3;
                    b.closeQuietly(objectOutputStream2);
                    b.closeQuietly(objectOutputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                objectOutputStream2 = objectOutputStream3;
                b.closeQuietly(objectOutputStream2);
                b.closeQuietly(objectOutputStream);
                throw th;
            }
            b.closeQuietly(objectOutputStream);
        }
    }

    public final void o(CtAdTemplate ctAdTemplate) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        Exception e;
        HomeApkBannerData homeApkBannerDataConvertAdTemplateToHomeApkBannerData;
        synchronized (a.class) {
            boolean z = false;
            try {
                homeApkBannerDataConvertAdTemplateToHomeApkBannerData = HomeApkBannerData.convertAdTemplateToHomeApkBannerData(ctAdTemplate);
            } catch (Throwable unused) {
            }
            if (homeApkBannerDataConvertAdTemplateToHomeApkBannerData == null) {
                return;
            }
            Iterator<HomeApkBannerData> it = this.aId.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(homeApkBannerDataConvertAdTemplateToHomeApkBannerData.appPackageName, it.next().appPackageName)) {
                    it.remove();
                    z = true;
                }
            }
            if (z) {
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.aIh));
                } catch (Exception e2) {
                    objectOutputStream = null;
                    e = e2;
                } catch (Throwable th2) {
                    objectOutputStream = null;
                    th = th2;
                    b.closeQuietly(objectOutputStream);
                    throw th;
                }
                try {
                    try {
                        objectOutputStream.writeObject(this.aId);
                    } catch (Throwable th3) {
                        th = th3;
                        b.closeQuietly(objectOutputStream);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    c.d("HomeApkBannerDataManager", " removeInstalledData e" + e);
                    b.closeQuietly(objectOutputStream);
                }
                b.closeQuietly(objectOutputStream);
            }
        }
    }

    public final void bO(String str) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        Exception e;
        synchronized (a.class) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int iIntValue = 1;
            this.aIl++;
            Integer num = this.aIe.get(str);
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            this.aIe.put(str, Integer.valueOf(iIntValue));
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.aIk));
            } catch (Exception e2) {
                objectOutputStream = null;
                e = e2;
            } catch (Throwable th2) {
                objectOutputStream = null;
                th = th2;
                b.closeQuietly(objectOutputStream);
                throw th;
            }
            try {
                try {
                    objectOutputStream.writeObject(this.aIe);
                } catch (Throwable th3) {
                    th = th3;
                    b.closeQuietly(objectOutputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                c.d("HomeApkBannerDataManager", " addAppShowCount e" + e);
                b.closeQuietly(objectOutputStream);
            }
            b.closeQuietly(objectOutputStream);
        }
    }

    public final CtAdTemplate Gd() {
        ObjectInputStream objectInputStream;
        Stack<HomeApkBannerData> stack;
        synchronized (a.class) {
            ObjectInputStream objectInputStream2 = null;
            try {
            } catch (Exception e) {
                e = e;
                objectInputStream = null;
            } catch (Throwable th) {
                th = th;
            }
            if (!this.aIg.exists()) {
                c.d("HomeApkBannerDataManager", "getCanShowDownloadBannerData mDownloadFile is not exists");
                b.closeQuietly((Closeable) null);
                return null;
            }
            this.aIc.clear();
            ObjectInputStream objectInputStream3 = new ObjectInputStream(new FileInputStream(this.aIg));
            try {
                stack = (Stack) objectInputStream3.readObject();
                this.aIc = stack;
            } catch (Exception e2) {
                objectInputStream = objectInputStream3;
                e = e2;
                try {
                    c.d("HomeApkBannerDataManager", " getCanShowDownloadBannerData e" + e);
                    b.closeQuietly(objectInputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    objectInputStream2 = objectInputStream;
                    b.closeQuietly(objectInputStream2);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                objectInputStream2 = objectInputStream3;
                b.closeQuietly(objectInputStream2);
                throw th;
            }
            if (stack.isEmpty()) {
                b.closeQuietly(objectInputStream3);
                return null;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            Stack stack2 = (Stack) this.aIc.clone();
            while (!stack2.isEmpty()) {
                HomeApkBannerData homeApkBannerData = (HomeApkBannerData) stack2.pop();
                if (homeApkBannerData != null) {
                    if (jCurrentTimeMillis - homeApkBannerData.mTimeStamp > 604800000) {
                        break;
                    }
                    if (a(homeApkBannerData, true)) {
                        CtAdTemplate ctAdTemplateA = a(b(homeApkBannerData, true), "getCanShowDownloadBannerData");
                        b.closeQuietly(objectInputStream3);
                        return ctAdTemplateA;
                    }
                }
            }
            b.closeQuietly(objectInputStream3);
            return null;
        }
    }

    private static CtAdTemplate a(File file, String str) throws Throwable {
        ObjectInputStream objectInputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                objectInputStream = new ObjectInputStream(fileInputStream);
            } catch (Exception e) {
                e = e;
                objectInputStream = null;
            } catch (Throwable th) {
                th = th;
                objectInputStream = null;
                fileInputStream2 = fileInputStream;
                b.closeQuietly(fileInputStream2);
                b.closeQuietly(objectInputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            objectInputStream = null;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            objectInputStream = null;
            b.closeQuietly(fileInputStream2);
            b.closeQuietly(objectInputStream);
            throw th;
        }
        try {
            try {
                CtAdTemplate ctAdTemplate = (CtAdTemplate) objectInputStream.readObject();
                b.closeQuietly(fileInputStream);
                b.closeQuietly(objectInputStream);
                return ctAdTemplate;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream2 = fileInputStream;
                b.closeQuietly(fileInputStream2);
                b.closeQuietly(objectInputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            c.d("HomeApkBannerDataManager", str + " get adTemplate e" + e);
            b.closeQuietly(fileInputStream);
            b.closeQuietly(objectInputStream);
            return null;
        }
    }

    public final CtAdTemplate Ge() {
        ObjectInputStream objectInputStream;
        Stack<HomeApkBannerData> stack;
        synchronized (a.class) {
            ObjectInputStream objectInputStream2 = null;
            try {
            } catch (Exception e) {
                e = e;
                objectInputStream = null;
            } catch (Throwable th) {
                th = th;
            }
            if (!this.aIh.exists()) {
                c.d("HomeApkBannerDataManager", "getCanShowInstalledBannerData mInstallFile is not exists");
                b.closeQuietly((Closeable) null);
                return null;
            }
            this.aId.clear();
            ObjectInputStream objectInputStream3 = new ObjectInputStream(new FileInputStream(this.aIh));
            try {
                stack = (Stack) objectInputStream3.readObject();
                this.aId = stack;
            } catch (Exception e2) {
                objectInputStream = objectInputStream3;
                e = e2;
                try {
                    c.d("HomeApkBannerDataManager", " getCanShowInstalledBannerData e" + e);
                    b.closeQuietly(objectInputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    objectInputStream2 = objectInputStream;
                    b.closeQuietly(objectInputStream2);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                objectInputStream2 = objectInputStream3;
                b.closeQuietly(objectInputStream2);
                throw th;
            }
            if (stack.isEmpty()) {
                b.closeQuietly(objectInputStream3);
                return null;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            Stack stack2 = (Stack) this.aId.clone();
            while (!stack2.isEmpty()) {
                HomeApkBannerData homeApkBannerData = (HomeApkBannerData) stack2.pop();
                if (homeApkBannerData != null) {
                    if (jCurrentTimeMillis - homeApkBannerData.mTimeStamp > 604800000) {
                        break;
                    }
                    if (a(homeApkBannerData, false)) {
                        CtAdTemplate ctAdTemplateA = a(b(homeApkBannerData, false), "getCanShowInstalledBannerData");
                        b.closeQuietly(objectInputStream3);
                        return ctAdTemplateA;
                    }
                }
            }
            b.closeQuietly(objectInputStream3);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0080 A[Catch: all -> 0x00a0, TryCatch #0 {all -> 0x00a0, blocks: (B:37:0x007a, B:39:0x0080, B:41:0x008e, B:43:0x009b), top: B:68:0x007a }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void Gf() {
        /*
            Method dump skipped, instructions count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ct.home.download.a.Gf():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007d A[Catch: all -> 0x00b4, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000e, B:9:0x0012, B:11:0x0014, B:13:0x001c, B:15:0x001e, B:17:0x0028, B:22:0x0033, B:23:0x0036, B:28:0x0052, B:38:0x0073, B:42:0x0089, B:44:0x0091, B:47:0x0095, B:49:0x00ac, B:48:0x009c, B:41:0x007d, B:53:0x00b0, B:54:0x00b3), top: B:58:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0091 A[Catch: all -> 0x00b4, DONT_GENERATE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000e, B:9:0x0012, B:11:0x0014, B:13:0x001c, B:15:0x001e, B:17:0x0028, B:22:0x0033, B:23:0x0036, B:28:0x0052, B:38:0x0073, B:42:0x0089, B:44:0x0091, B:47:0x0095, B:49:0x00ac, B:48:0x009c, B:41:0x007d, B:53:0x00b0, B:54:0x00b3), top: B:58:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(com.kwad.components.ct.home.download.HomeApkBannerData r10, boolean r11) {
        /*
            r9 = this;
            java.lang.Class<com.kwad.components.ct.home.download.a> r0 = com.kwad.components.ct.home.download.a.class
            monitor-enter(r0)
            int r1 = r9.aIl     // Catch: java.lang.Throwable -> Lb4
            com.kwad.sdk.core.config.item.InstallActivateReminderConfigItem r2 = com.kwad.sdk.core.config.c.bxF     // Catch: java.lang.Throwable -> Lb4
            int r2 = r2.Zo()     // Catch: java.lang.Throwable -> Lb4
            r3 = 0
            if (r1 < r2) goto L10
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb4
            return r3
        L10:
            if (r10 != 0) goto L14
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb4
            return r3
        L14:
            java.lang.String r1 = r10.appPackageName     // Catch: java.lang.Throwable -> Lb4
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> Lb4
            if (r2 == 0) goto L1e
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb4
            return r3
        L1e:
            java.io.File r2 = r9.b(r10, r11)     // Catch: java.lang.Throwable -> Lb4
            boolean r2 = r2.exists()     // Catch: java.lang.Throwable -> Lb4
            if (r2 != 0) goto L2a
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb4
            return r3
        L2a:
            r2 = 0
            java.io.File r4 = r9.aIk     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            boolean r4 = r4.exists()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            if (r4 != 0) goto L39
            com.kwad.sdk.crash.utils.b.closeQuietly(r2)     // Catch: java.lang.Throwable -> Lb4
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb4
            r10 = 1
            return r10
        L39:
            java.util.Map<java.lang.String, java.lang.Integer> r4 = r9.aIe     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            r4.clear()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            java.io.ObjectInputStream r4 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            java.io.File r6 = r9.aIk     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            java.lang.Object r2 = r4.readObject()     // Catch: java.lang.Exception -> L56 java.lang.Throwable -> Lae
            java.util.Map r2 = (java.util.Map) r2     // Catch: java.lang.Exception -> L56 java.lang.Throwable -> Lae
            r9.aIe = r2     // Catch: java.lang.Exception -> L56 java.lang.Throwable -> Lae
        L52:
            com.kwad.sdk.crash.utils.b.closeQuietly(r4)     // Catch: java.lang.Throwable -> Lb4
            goto L73
        L56:
            r2 = move-exception
            goto L5e
        L58:
            r10 = move-exception
            goto Lb0
        L5a:
            r4 = move-exception
            r8 = r4
            r4 = r2
            r2 = r8
        L5e:
            java.lang.String r5 = "HomeApkBannerDataManager"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lae
            java.lang.String r7 = " canShowBanner e"
            r6.<init>(r7)     // Catch: java.lang.Throwable -> Lae
            java.lang.StringBuilder r2 = r6.append(r2)     // Catch: java.lang.Throwable -> Lae
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Lae
            com.kwad.sdk.core.d.c.d(r5, r2)     // Catch: java.lang.Throwable -> Lae
            goto L52
        L73:
            java.util.Map<java.lang.String, java.lang.Integer> r2 = r9.aIe     // Catch: java.lang.Throwable -> Lb4
            java.lang.Object r2 = r2.get(r1)     // Catch: java.lang.Throwable -> Lb4
            if (r2 != 0) goto L7d
            r2 = r3
            goto L89
        L7d:
            java.util.Map<java.lang.String, java.lang.Integer> r2 = r9.aIe     // Catch: java.lang.Throwable -> Lb4
            java.lang.Object r2 = r2.get(r1)     // Catch: java.lang.Throwable -> Lb4
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch: java.lang.Throwable -> Lb4
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> Lb4
        L89:
            com.kwad.sdk.core.config.item.InstallActivateReminderConfigItem r4 = com.kwad.sdk.core.config.c.bxF     // Catch: java.lang.Throwable -> Lb4
            int r4 = r4.Zp()     // Catch: java.lang.Throwable -> Lb4
            if (r2 < r4) goto L93
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb4
            return r3
        L93:
            if (r11 == 0) goto L9c
            java.lang.String r10 = r10.mDownloadFilePath     // Catch: java.lang.Throwable -> Lb4
            boolean r10 = bP(r10)     // Catch: java.lang.Throwable -> Lb4
            goto Lac
        L9c:
            java.lang.Class<com.kwad.sdk.service.a.f> r10 = com.kwad.sdk.service.a.f.class
            java.lang.Object r10 = com.kwad.sdk.service.ServiceProvider.get(r10)     // Catch: java.lang.Throwable -> Lb4
            com.kwad.sdk.service.a.f r10 = (com.kwad.sdk.service.a.f) r10     // Catch: java.lang.Throwable -> Lb4
            android.content.Context r10 = r10.getContext()     // Catch: java.lang.Throwable -> Lb4
            boolean r10 = com.kwad.sdk.utils.as.aE(r10, r1)     // Catch: java.lang.Throwable -> Lb4
        Lac:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb4
            return r10
        Lae:
            r10 = move-exception
            r2 = r4
        Lb0:
            com.kwad.sdk.crash.utils.b.closeQuietly(r2)     // Catch: java.lang.Throwable -> Lb4
            throw r10     // Catch: java.lang.Throwable -> Lb4
        Lb4:
            r10 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb4
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ct.home.download.a.a(com.kwad.components.ct.home.download.HomeApkBannerData, boolean):boolean");
    }

    private static boolean bP(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    private File b(HomeApkBannerData homeApkBannerData, boolean z) {
        return new File((z ? this.aIi : this.aIj).getPath() + File.separator + homeApkBannerData.mAdTemplateUniqueId);
    }

    public final boolean Gg() {
        return this.aIm;
    }

    public final void bj(boolean z) {
        this.aIm = z;
    }
}
