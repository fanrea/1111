package com.kwad.sdk.api.proxy.app;

import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.kwad.sdk.api.core.KSLifecycleObserver;
import com.kwad.sdk.api.loader.b;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AdSdkFileProvider extends FileProvider {
    private static final String SP_INSTALLER_CHECK_PKG_AB_SWITCH = "installerCheckPkgAbSwitch";
    private static final String SP_INSTALLER_EXTRA_PKGS_KEY = "installerCheckExtraPkgs";
    private static final String SP_OPEN_FILE_RECORD = "SP_OPEN_FILE_RECORD";
    private static final String TAG = "AdSdkFileProvider";
    public static long sLaunchTime;
    private static Set<String> sSystemInstallers;

    static {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        sSystemInstallers = copyOnWriteArraySet;
        copyOnWriteArraySet.add("com.android.packageinstaller");
        sSystemInstallers.add("com.google.android.packageinstaller");
    }

    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        boolean zContains;
        String string;
        new StringBuilder("openFile uri:").append(uri).append(" mode:").append(str);
        if (!isInstallerPkgCheckOpen() || Build.VERSION.SDK_INT < 19) {
            zContains = true;
        } else {
            checkLocalConfig();
            String callingPackage = getCallingPackage();
            zContains = sSystemInstallers.contains(callingPackage);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("callingPkg", callingPackage);
                jSONObject.put("checkResult", String.valueOf(zContains));
                jSONObject.put(ContentProviderManager.PROVIDER_URI, uri.toString());
                String strB = b.b(getContext(), SP_OPEN_FILE_RECORD, "");
                if (!TextUtils.isEmpty(strB)) {
                    JSONArray jSONArray = new JSONArray(strB);
                    jSONArray.put(jSONObject);
                    string = jSONArray.toString();
                } else {
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put(jSONObject);
                    string = jSONArray2.toString();
                }
                new StringBuilder("openFile saveRecord:").append(string);
                b.c(getContext(), SP_OPEN_FILE_RECORD, string);
            } catch (Throwable unused) {
            }
        }
        if (zContains) {
            return super.openFile(uri, str);
        }
        return null;
    }

    private void checkLocalConfig() {
        try {
            String string = ApiConfigUtils.readString(getContext(), SP_INSTALLER_EXTRA_PKGS_KEY, "");
            new StringBuilder("checkLocalConfig extraPkgs:").append(string);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            String decodeString = getDecodeString(string);
            new StringBuilder("checkLocalConfig extraPkgs decoded: ").append(decodeString);
            JSONArray jSONArray = new JSONArray(decodeString);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                String string2 = jSONArray.getString(i);
                if (!TextUtils.isEmpty(string2)) {
                    sSystemInstallers.add(string2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static String getDecodeString(String str) {
        return (TextUtils.isEmpty(str) || !ApiBase64.isEncodeKsSdk(str)) ? str : ApiBase64.decodeKsSdk(str);
    }

    private boolean isInstallerPkgCheckOpen() {
        int i;
        try {
            i = ApiConfigUtils.readInt(getContext(), SP_INSTALLER_CHECK_PKG_AB_SWITCH, 0);
            new StringBuilder("isInstallerPkgCheckOpen abSwitch:").append(i);
        } catch (Throwable unused) {
        }
        return i == 1;
    }

    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public boolean onCreate() {
        sLaunchTime = System.currentTimeMillis();
        try {
            KSLifecycleObserver.getInstance().init(getContext().getApplicationContext());
        } catch (Throwable unused) {
        }
        return super.onCreate();
    }
}
