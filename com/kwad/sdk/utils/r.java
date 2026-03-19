package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.kwad.sdk.service.ServiceProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class r {
    public static com.kwad.sdk.l.a.d clD;

    static class b extends com.kwad.sdk.l.a.a {
    }

    static class c extends com.kwad.sdk.l.a.a {
    }

    public static synchronized com.kwad.sdk.l.a.d anV() {
        if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Ue()) {
            return null;
        }
        com.kwad.sdk.l.a.d dVar = clD;
        if (dVar != null) {
            return dVar;
        }
        Context applicationContext = ServiceProvider.getContext().getApplicationContext();
        com.kwad.sdk.l.a.d dVar2 = new com.kwad.sdk.l.a.d(applicationContext);
        boolean zCJ = new d().cJ(applicationContext);
        boolean zCJ2 = new e().cJ(applicationContext);
        boolean zCJ3 = new b().cJ(applicationContext);
        boolean zCJ4 = new a().cJ(applicationContext);
        boolean zCJ5 = new c().cJ(applicationContext);
        dVar2.dq(zCJ);
        dVar2.dr(zCJ2);
        dVar2.ds(zCJ3);
        dVar2.du(zCJ4);
        dVar2.dv(zCJ5);
        clD = dVar2;
        return dVar2;
    }

    public static String i(String[] strArr) {
        try {
            return com.kwad.sdk.crash.utils.h.d(Runtime.getRuntime().exec(strArr).getInputStream());
        } catch (Exception unused) {
            return null;
        }
    }

    static class d extends com.kwad.sdk.l.a.a {
        public d() {
            anW();
        }

        private void anW() {
            this.cju = new ArrayList();
            this.cju.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.r.d.1
                @Override // com.kwad.sdk.l.a.a
                public final boolean cK(Context context) {
                    return new File("/system/app/Superuser.apk").exists();
                }
            });
            this.cju.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.r.d.2
                @Override // com.kwad.sdk.l.a.a
                public final boolean cK(Context context) {
                    String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
                    for (int i = 0; i < 5; i++) {
                        if (new File(strArr[i] + "su").exists()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            this.cju.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.r.d.3
                @Override // com.kwad.sdk.l.a.a
                public final boolean cK(Context context) {
                    return !TextUtils.isEmpty(r.i(new String[]{"/system/xbin/which", "su"}));
                }
            });
            this.cju.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.r.d.4
                @Override // com.kwad.sdk.l.a.a
                public final boolean cK(Context context) {
                    Charset charsetForName = Charset.forName("UTF-8");
                    File file = new File("/data/su_test");
                    try {
                        w.a(file, "ok", charsetForName, false);
                        return w.a(file, charsetForName).equals("ok");
                    } catch (Throwable unused) {
                        return false;
                    }
                }
            });
        }
    }

    static class e extends com.kwad.sdk.l.a.a {
        public e() {
            anW();
        }

        private void anW() {
            this.cju = new ArrayList();
            this.cju.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.r.e.1
                @Override // com.kwad.sdk.l.a.a
                public final boolean cK(Context context) {
                    return as.aE(context, "de.robv.android.xposed.installer") || as.aE(context, "com.saurik.substrate");
                }
            });
            this.cju.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.r.e.2
                @Override // com.kwad.sdk.l.a.a
                public final boolean cK(Context context) throws Exception {
                    try {
                        throw new Exception("empty");
                    } catch (Exception e) {
                        boolean z = false;
                        int i = 0;
                        for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                            String className = stackTraceElement.getClassName();
                            String methodName = stackTraceElement.getMethodName();
                            if (className.equals("com.android.internal.os.ZygoteInit") && (i = i + 1) == 2) {
                                z = true;
                            }
                            if (className.equals("com.saurik.substrate.MS$2") && methodName.equals("invoked")) {
                                Log.wtf("HookDetection", "A method on the stack trace has been hooked using Substrate.");
                                z = true;
                            }
                            if (className.equals(com.kuaishou.weapon.p0.an.b) && methodName.equals(LiveConfigKey.MAIN)) {
                                z = true;
                            }
                            if (className.equals(com.kuaishou.weapon.p0.an.b) && methodName.equals("handleHookedMethod")) {
                                z = true;
                            }
                        }
                        return z;
                    }
                }
            });
            this.cju.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.r.e.3
                @Override // com.kwad.sdk.l.a.a
                public final boolean cK(Context context) throws Throwable {
                    BufferedReader bufferedReader;
                    FileReader fileReader;
                    Throwable th;
                    HashSet<String> hashSet;
                    BufferedReader bufferedReader2 = null;
                    boolean z = false;
                    try {
                        hashSet = new HashSet();
                        fileReader = new FileReader("/proc/" + Process.myPid() + "/maps");
                    } catch (Exception unused) {
                        fileReader = null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = null;
                        fileReader = null;
                    }
                    try {
                        bufferedReader = new BufferedReader(fileReader);
                        while (true) {
                            try {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                if (line.endsWith(".so") || line.endsWith(".jar")) {
                                    hashSet.add(line.substring(line.lastIndexOf(" ") + 1));
                                }
                            } catch (Exception unused2) {
                                bufferedReader2 = bufferedReader;
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                                com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                                return z;
                            } catch (Throwable th3) {
                                th = th3;
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                                com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                                throw th;
                            }
                        }
                        for (String str : hashSet) {
                            if (str.contains("com.saurik.substrate")) {
                                Log.wtf("HookDetection", "Substrate shared object found: " + str);
                                z = true;
                            }
                            if (str.contains("XposedBridge.jar")) {
                                Log.wtf("HookDetection", "Xposed JAR found: " + str);
                                z = true;
                            }
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    } catch (Exception unused3) {
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedReader = null;
                        th = th;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                        throw th;
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                    return z;
                }
            });
        }
    }

    static class a extends com.kwad.sdk.l.a.a {
        public a() {
            anW();
        }

        private void anW() {
            this.cju = new ArrayList();
            this.cju.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.r.a.1
                @Override // com.kwad.sdk.l.a.a
                public final boolean cK(Context context) {
                    int i = (Build.PRODUCT.contains("sdk") || Build.PRODUCT.contains("Andy") || Build.PRODUCT.contains("ttVM_Hdragon") || Build.PRODUCT.contains("google_sdk") || Build.PRODUCT.contains("Droid4X") || Build.PRODUCT.contains("nox") || Build.PRODUCT.contains("sdk_x86") || Build.PRODUCT.contains("sdk_google") || Build.PRODUCT.contains("vbox86p") || Build.PRODUCT.contains("aries")) ? 1 : 0;
                    if (Build.MANUFACTURER.equals("unknown") || Build.MANUFACTURER.equals("Genymotion") || Build.MANUFACTURER.contains("Andy") || Build.MANUFACTURER.contains("MIT") || Build.MANUFACTURER.contains("nox") || Build.MANUFACTURER.contains("TiantianVM")) {
                        i++;
                    }
                    if (Build.BRAND.equals("generic") || Build.BRAND.equals("generic_x86") || Build.BRAND.equals("TTVM") || Build.BRAND.contains("Andy")) {
                        i++;
                    }
                    if (Build.DEVICE.contains("generic") || Build.DEVICE.contains("generic_x86") || Build.DEVICE.contains("Andy") || Build.DEVICE.contains("ttVM_Hdragon") || Build.DEVICE.contains("Droid4X") || Build.DEVICE.contains("nox") || Build.DEVICE.contains("generic_x86_64") || Build.DEVICE.contains("vbox86p") || Build.DEVICE.contains("aries")) {
                        i++;
                    }
                    if (Build.MODEL.equals("sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.equals("google_sdk") || Build.MODEL.contains("Droid4X") || Build.MODEL.contains("TiantianVM") || Build.MODEL.contains("Andy") || Build.MODEL.equals("Android SDK built for x86_64") || Build.MODEL.equals("Android SDK built for x86")) {
                        i++;
                    }
                    if (Build.HARDWARE.equals("goldfish") || Build.HARDWARE.equals("vbox86") || Build.HARDWARE.contains("nox") || Build.HARDWARE.contains("ttVM_x86")) {
                        i++;
                    }
                    if (Build.FINGERPRINT.contains("generic/sdk/generic") || Build.FINGERPRINT.contains("generic_x86/sdk_x86/generic_x86") || Build.FINGERPRINT.contains("Andy") || Build.FINGERPRINT.contains("ttVM_Hdragon") || Build.FINGERPRINT.contains("generic_x86_64") || Build.FINGERPRINT.contains("generic/google_sdk/generic") || Build.FINGERPRINT.contains("vbox86p") || Build.FINGERPRINT.contains("generic/vbox86p/vbox86p")) {
                        i++;
                    }
                    try {
                        if (!bd.useStoragePermissionDisable()) {
                            if (new File(Environment.getExternalStorageDirectory().toString() + File.separatorChar + "windows" + File.separatorChar + "BstSharedFolder").exists()) {
                                i += 10;
                            }
                        }
                    } catch (Exception unused) {
                    }
                    return i > 3;
                }
            });
            this.cju.add(new com.kwad.sdk.l.a.a(this.enabled) { // from class: com.kwad.sdk.utils.r.a.2
                @Override // com.kwad.sdk.l.a.a
                public final boolean cK(Context context) {
                    return "1".equals(br.get("ro.kernel.qemu"));
                }
            });
        }
    }
}
