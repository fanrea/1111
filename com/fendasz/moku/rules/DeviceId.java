package com.fendasz.moku.rules;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.system.ErrnoException;
import android.system.Os;
import android.text.TextUtils;
import android.util.Log;
import com.fendasz.moku.utils.AESUtil;
import com.fendasz.moku.utils.Base64;
import com.fendasz.moku.utils.MD5Util;
import com.fendasz.moku.utils.SHA1Util;
import com.kuaishou.socket.nano.SocketMessages;
import com.sigmob.sdk.archives.tar.e;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.crypto.Cipher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class DeviceId {
    private static final String ACTION_GLAXY_CUID = "com.baidu.intent.action.GALAXY";
    private static final String AES_KEY = new String(Base64.decode(new byte[]{77, 122, 65, 121, 77, 84, 73, e.R, 77, 68, 73, 61})) + new String(Base64.decode(new byte[]{90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, 61}));
    private static final boolean CONFIG_WRITE_V1_STORAGE = false;
    private static final boolean DEBUG = false;
    private static final String DEFAULT_TM_DEVICEID = "";
    private static final String EXT_DIR = "backups/.SystemConfig";
    private static final String EXT_FILE = ".cuid";
    private static final String EXT_FILE_V2 = ".cuid2";
    private static final String KEY_DEVICE_ID = "com.baidu.deviceid";
    private static final String KEY_DEVICE_ID_V2 = "com.baidu.deviceid.v2";
    private static final String KEY_FLAG = "bd_setting_i";
    private static final String META_KEY_GALAXY_SF = "galaxy_sf";
    private static final String META_KEY_GLAXY_DATA = "galaxy_data";
    private static final String OLD_EXT_DIR = "baidu";
    private static final String RSA_ALGORITHM = "RSA/ECB/PKCS1Padding";
    private static final int SDK_ANDROID_M = 23;
    private static final String SELF_CUID_FILE = "libcuid.so";
    private static final int STORAGE_SDCARD_V1 = 4;
    private static final int STORAGE_SDCARD_V2 = 8;
    private static final int STORAGE_SELF_FILE = 16;
    private static final int STORAGE_SYSTEM_SETTING_V1 = 1;
    private static final int STORAGE_SYSTEM_SETTING_V2 = 2;
    private static final int S_IRGRP = 32;
    private static final int S_IROTH = 4;
    private static final int S_IRUSR = 256;
    private static final int S_IRWXG = 56;
    private static final int S_IRWXO = 7;
    private static final int S_IRWXU = 448;
    private static final int S_IWGRP = 16;
    private static final int S_IWOTH = 2;
    private static final int S_IWUSR = 128;
    private static final int S_IXGRP = 8;
    private static final int S_IXOTH = 1;
    private static final int S_IXUSR = 64;
    private static final String TAG = "DeviceId";
    private static CUIDInfo sCachedCuidInfo = null;
    private static final String sDEncoded = "ZGV2aWNlaWQ=";
    private static boolean sDataCuidInfoShable = true;
    private static final String sIEncoded = "aW1laQ==";
    private static final String sVEncoded = "dmVy";
    private final Context mContext;
    private PublicKey mPublicKey;
    private int mSaveMask = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public String getDefaultFlag(String str) {
        return "0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleThrowable(Throwable th) {
    }

    private DeviceId(Context context) throws Throwable {
        this.mContext = context.getApplicationContext();
        initPublicKey();
    }

    private static String byte2hex(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
        }
        String str = "";
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                str = str + "0" + hexString;
            } else {
                str = str + hexString;
            }
        }
        return str.toLowerCase();
    }

    public static void setCuidDataShable(Context context, boolean z) {
        File file = new File(context.getApplicationContext().getFilesDir(), SELF_CUID_FILE);
        Context applicationContext = context.getApplicationContext();
        if (file.exists() && (sCachedCuidInfo == null || sDataCuidInfoShable != z)) {
            tryToModifyChmodForSelfFile(applicationContext, z);
        }
        sDataCuidInfoShable = z;
    }

    private String[] formatAndroidSigArray(Signature[] signatureArr) {
        int length = signatureArr.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = byte2hex(SHA1Util.sha1(signatureArr[i].toByteArray()));
        }
        return strArr;
    }

    private static byte[] decryptByPublicKey(byte[] bArr, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(2, publicKey);
        return cipher.doFinal(bArr);
    }

    private void initPublicKey() throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            try {
                byteArrayInputStream = new ByteArrayInputStream(CuidCertStore.getCertBytes());
            } catch (Exception unused) {
            } catch (Throwable th2) {
                byteArrayInputStream = null;
                th = th2;
            }
            try {
                this.mPublicKey = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream).getPublicKey();
                byteArrayInputStream.close();
            } catch (Exception unused2) {
                byteArrayInputStream2 = byteArrayInputStream;
                if (byteArrayInputStream2 != null) {
                    byteArrayInputStream2.close();
                }
            } catch (Throwable th3) {
                th = th3;
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception e) {
                        handleThrowable(e);
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            handleThrowable(e2);
        }
    }

    private List<CUIDBuddyInfo> collectBuddyInfos(Intent intent, boolean z) throws JSONException, PackageManager.NameNotFoundException {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = this.mContext.getPackageManager();
        List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (listQueryBroadcastReceivers != null) {
            for (ResolveInfo resolveInfo : listQueryBroadcastReceivers) {
                if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.applicationInfo != null) {
                    try {
                        Bundle bundle = packageManager.getReceiverInfo(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name), 128).metaData;
                        if (bundle != null) {
                            String string = bundle.getString(META_KEY_GLAXY_DATA);
                            if (!TextUtils.isEmpty(string)) {
                                byte[] bArrDecode = Base64.decode(string.getBytes("utf-8"));
                                JSONObject jSONObject = new JSONObject(new String(bArrDecode));
                                CUIDBuddyInfo cUIDBuddyInfo = new CUIDBuddyInfo();
                                cUIDBuddyInfo.priority = jSONObject.getInt("priority");
                                cUIDBuddyInfo.appInfo = resolveInfo.activityInfo.applicationInfo;
                                if (this.mContext.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                                    cUIDBuddyInfo.isSelf = true;
                                }
                                if (z) {
                                    String string2 = bundle.getString(META_KEY_GALAXY_SF);
                                    if (!TextUtils.isEmpty(string2)) {
                                        PackageInfo packageInfo = packageManager.getPackageInfo(resolveInfo.activityInfo.applicationInfo.packageName, 64);
                                        JSONArray jSONArray = jSONObject.getJSONArray("sigs");
                                        int length = jSONArray.length();
                                        String[] strArr = new String[length];
                                        for (int i = 0; i < length; i++) {
                                            strArr[i] = jSONArray.getString(i);
                                        }
                                        if (isSigsEqual(strArr, formatAndroidSigArray(packageInfo.signatures))) {
                                            byte[] bArrDecryptByPublicKey = decryptByPublicKey(Base64.decode(string2.getBytes()), this.mPublicKey);
                                            if (bArrDecryptByPublicKey != null && Arrays.equals(bArrDecryptByPublicKey, SHA1Util.sha1(bArrDecode))) {
                                                cUIDBuddyInfo.sigMatched = true;
                                            }
                                        }
                                    }
                                }
                                arrayList.add(cUIDBuddyInfo);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        Collections.sort(arrayList, new Comparator<CUIDBuddyInfo>() { // from class: com.fendasz.moku.rules.DeviceId.1
            @Override // java.util.Comparator
            public int compare(CUIDBuddyInfo cUIDBuddyInfo2, CUIDBuddyInfo cUIDBuddyInfo3) {
                int i2 = cUIDBuddyInfo3.priority - cUIDBuddyInfo2.priority;
                if (i2 == 0) {
                    if (cUIDBuddyInfo2.isSelf && cUIDBuddyInfo3.isSelf) {
                        return 0;
                    }
                    if (cUIDBuddyInfo2.isSelf) {
                        return -1;
                    }
                    if (cUIDBuddyInfo3.isSelf) {
                        return 1;
                    }
                }
                return i2;
            }
        });
        return arrayList;
    }

    private boolean isSigsEqual(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            hashSet.add(str);
        }
        HashSet hashSet2 = new HashSet();
        for (String str2 : strArr2) {
            hashSet2.add(str2);
        }
        return hashSet.equals(hashSet2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean writeToCuidFile(String str) throws IOException {
        int i = (!sDataCuidInfoShable || Build.VERSION.SDK_INT >= 24) ? 0 : 1;
        FileOutputStream fileOutputStreamOpenFileOutput = null;
        try {
            try {
                fileOutputStreamOpenFileOutput = this.mContext.openFileOutput(SELF_CUID_FILE, i);
                fileOutputStreamOpenFileOutput.write(str.getBytes());
                fileOutputStreamOpenFileOutput.flush();
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (Exception e) {
                        handleThrowable(e);
                    }
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    if (i == 0 && sDataCuidInfoShable) {
                        return TargetApiSupport.doChmodSafely(new File(this.mContext.getFilesDir(), SELF_CUID_FILE).getAbsolutePath(), SocketMessages.PayloadType.SC_MIC_SEATS_APPLY_INFO);
                    }
                    if (!sDataCuidInfoShable) {
                        return TargetApiSupport.doChmodSafely(new File(this.mContext.getFilesDir(), SELF_CUID_FILE).getAbsolutePath(), 432);
                    }
                }
                return true;
            } catch (Throwable th) {
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (Exception e2) {
                        handleThrowable(e2);
                    }
                }
                throw th;
            }
        } catch (Exception e3) {
            handleThrowable(e3);
            if (fileOutputStreamOpenFileOutput != null) {
                try {
                    fileOutputStreamOpenFileOutput.close();
                } catch (Exception e4) {
                    handleThrowable(e4);
                }
            }
            return false;
        }
    }

    private static boolean tryToModifyChmodForSelfFile(Context context, boolean z) {
        File file = new File(context.getApplicationContext().getFilesDir(), SELF_CUID_FILE);
        if (!file.exists()) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 21) {
            try {
                if (z) {
                    return file.setReadable(true, false);
                }
                return file.setReadable(false, false) && file.setReadable(true, true);
            } catch (Exception e) {
                handleThrowable(e);
                return false;
            }
        }
        return TargetApiSupport.doChmodSafely(file.getAbsolutePath(), z ? SocketMessages.PayloadType.SC_MIC_SEATS_APPLY_INFO : 432);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSystemSettingValue(String str) {
        try {
            return Settings.System.getString(this.mContext.getContentResolver(), str);
        } catch (Exception e) {
            handleThrowable(e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tryPutSystemSettingValue(String str, String str2) {
        try {
            return Settings.System.putString(this.mContext.getContentResolver(), str, str2);
        } catch (Exception e) {
            handleThrowable(e);
            return false;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0030 -> B:36:0x0033). Please report as a decompilation issue!!! */
    private static void writeToFile(File file, byte[] bArr) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
        } catch (IOException e) {
            handleThrowable(e);
        }
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                } catch (IOException e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    handleThrowable(e);
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (SecurityException e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    handleThrowable(e);
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            handleThrowable(e4);
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
            } catch (SecurityException e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:41:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getFileContent(java.io.File r5) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            r5 = 8192(0x2000, float:1.148E-41)
            char[] r5 = new char[r5]     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L3b
            java.io.CharArrayWriter r2 = new java.io.CharArrayWriter     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L3b
            r2.<init>()     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L3b
        Lf:
            int r3 = r1.read(r5)     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L3b
            if (r3 <= 0) goto L1a
            r4 = 0
            r2.write(r5, r4, r3)     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L3b
            goto Lf
        L1a:
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L3b
            r1.close()     // Catch: java.lang.Exception -> L22
            goto L26
        L22:
            r0 = move-exception
            handleThrowable(r0)
        L26:
            return r5
        L27:
            r5 = move-exception
            goto L2d
        L29:
            r5 = move-exception
            goto L3d
        L2b:
            r5 = move-exception
            r1 = r0
        L2d:
            handleThrowable(r5)     // Catch: java.lang.Throwable -> L3b
            if (r1 == 0) goto L3a
            r1.close()     // Catch: java.lang.Exception -> L36
            goto L3a
        L36:
            r5 = move-exception
            handleThrowable(r5)
        L3a:
            return r0
        L3b:
            r5 = move-exception
            r0 = r1
        L3d:
            if (r0 == 0) goto L47
            r0.close()     // Catch: java.lang.Exception -> L43
            goto L47
        L43:
            r0 = move-exception
            handleThrowable(r0)
        L47:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fendasz.moku.rules.DeviceId.getFileContent(java.io.File):java.lang.String");
    }

    public static String getCUID(Context context) {
        return getOrCreateCUIDInfo(context).getFinalCUID();
    }

    private static CUIDInfo getOrCreateCUIDInfo(Context context) {
        if (sCachedCuidInfo == null) {
            synchronized (CUIDInfo.class) {
                if (sCachedCuidInfo == null) {
                    SystemClock.uptimeMillis();
                    sCachedCuidInfo = new DeviceId(context).getCUIDInfo();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return sCachedCuidInfo;
    }

    public static String getDeviceID(Context context) {
        return getOrCreateCUIDInfo(context).deviceId;
    }

    private static String getAndroidId(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        return TextUtils.isEmpty(string) ? "" : string;
    }

    private CUIDInfo getCUIDInfo() throws Throwable {
        boolean z;
        String defaultFlag;
        String str;
        List<CUIDBuddyInfo> listCollectBuddyInfos = collectBuddyInfos(new Intent(ACTION_GLAXY_CUID).setPackage(this.mContext.getPackageName()), true);
        boolean z2 = false;
        if (listCollectBuddyInfos == null || listCollectBuddyInfos.size() == 0) {
            for (int i = 0; i < 3; i++) {
                Log.w(TAG, "galaxy lib host missing meta-data,make sure you know the right way to integrate galaxy");
            }
            z = false;
        } else {
            CUIDBuddyInfo cUIDBuddyInfo = listCollectBuddyInfos.get(0);
            z = cUIDBuddyInfo.sigMatched;
            if (!cUIDBuddyInfo.sigMatched) {
                for (int i2 = 0; i2 < 3; i2++) {
                    Log.w(TAG, "galaxy config err, In the release version of the signature should be matched");
                }
            }
        }
        File file = new File(this.mContext.getFilesDir(), SELF_CUID_FILE);
        CUIDInfo cUIDInfoCreateFromJson = file.exists() ? CUIDInfo.createFromJson(decryptCUIDInfo(getFileContent(file))) : null;
        if (cUIDInfoCreateFromJson == null) {
            this.mSaveMask |= 16;
            List<CUIDBuddyInfo> listCollectBuddyInfos2 = collectBuddyInfos(new Intent(ACTION_GLAXY_CUID), z);
            if (listCollectBuddyInfos2 != null) {
                String name = "files";
                File filesDir = this.mContext.getFilesDir();
                if (!"files".equals(filesDir.getName())) {
                    Log.e(TAG, "fetal error:: app files dir name is unexpectedly :: " + filesDir.getAbsolutePath());
                    name = filesDir.getName();
                }
                for (CUIDBuddyInfo cUIDBuddyInfo2 : listCollectBuddyInfos2) {
                    if (!cUIDBuddyInfo2.isSelf) {
                        File file2 = new File(new File(cUIDBuddyInfo2.appInfo.dataDir, name), SELF_CUID_FILE);
                        if (file2.exists() && (cUIDInfoCreateFromJson = CUIDInfo.createFromJson(decryptCUIDInfo(getFileContent(file2)))) != null) {
                            break;
                        }
                    }
                }
            }
        }
        if (cUIDInfoCreateFromJson == null) {
            cUIDInfoCreateFromJson = CUIDInfo.createFromJson(decryptCUIDInfo(getSystemSettingValue(KEY_DEVICE_ID_V2)));
        }
        boolean zCheckSelfPermission = checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE");
        if (cUIDInfoCreateFromJson == null && zCheckSelfPermission) {
            this.mSaveMask |= 2;
            cUIDInfoCreateFromJson = getCuidInfoFromExternalV2();
        }
        if (cUIDInfoCreateFromJson == null) {
            this.mSaveMask |= 8;
            cUIDInfoCreateFromJson = getCUidInfoFromSystemSettingV1();
        }
        if (cUIDInfoCreateFromJson == null && zCheckSelfPermission) {
            this.mSaveMask |= 1;
            String defaultFlag2 = getDefaultFlag("");
            z2 = true;
            defaultFlag = defaultFlag2;
            cUIDInfoCreateFromJson = getExternalV1DeviceId(defaultFlag2);
        } else {
            defaultFlag = null;
        }
        if (cUIDInfoCreateFromJson == null) {
            this.mSaveMask |= 4;
            if (!z2) {
                defaultFlag = getDefaultFlag("");
            }
            cUIDInfoCreateFromJson = new CUIDInfo();
            String androidId = getAndroidId(this.mContext);
            if (Build.VERSION.SDK_INT < 23) {
                str = defaultFlag + androidId + UUID.randomUUID().toString();
            } else {
                str = "com.baidu" + androidId;
            }
            cUIDInfoCreateFromJson.deviceId = MD5Util.toMd5(str.getBytes(), true);
            cUIDInfoCreateFromJson.flag = defaultFlag;
        }
        fixCUIDInfoByIE(cUIDInfoCreateFromJson);
        writeJobThread(cUIDInfoCreateFromJson);
        return cUIDInfoCreateFromJson;
    }

    private synchronized void writeJobThread(CUIDInfo cUIDInfo) {
        new Thread(getWriteRunnable(cUIDInfo)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fixCUIDInfoByIE(CUIDInfo cUIDInfo) {
        if (cUIDInfo.isIENormal()) {
            cUIDInfo.flag = "O";
            return true;
        }
        if (!cUIDInfo.isIENull()) {
            return false;
        }
        cUIDInfo.flag = "0";
        return true;
    }

    private Runnable getWriteRunnable(final CUIDInfo cUIDInfo) {
        return new Runnable() { // from class: com.fendasz.moku.rules.DeviceId.2
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                CUIDInfo cUIDInfo2 = new CUIDInfo();
                cUIDInfo2.flag = cUIDInfo.flag;
                cUIDInfo2.deviceId = cUIDInfo.deviceId;
                File file = new File(DeviceId.this.mContext.getFilesDir(), DeviceId.SELF_CUID_FILE);
                String strEncryptCUIDInfo = DeviceId.encryptCUIDInfo(cUIDInfo2.toPersitString());
                if (!file.exists()) {
                    DeviceId.this.writeToCuidFile(strEncryptCUIDInfo);
                } else {
                    CUIDInfo cUIDInfoCreateFromJson = CUIDInfo.createFromJson(DeviceId.decryptCUIDInfo(DeviceId.getFileContent(file)));
                    if (cUIDInfoCreateFromJson != null) {
                        if (DeviceId.this.fixCUIDInfoByIE(cUIDInfoCreateFromJson)) {
                            DeviceId.this.writeToCuidFile(DeviceId.encryptCUIDInfo(cUIDInfoCreateFromJson.toPersitString()));
                        }
                    } else if (cUIDInfoCreateFromJson == null) {
                        DeviceId.this.writeToCuidFile(strEncryptCUIDInfo);
                    }
                }
                boolean zHasWriteSettingsPermission = DeviceId.this.hasWriteSettingsPermission();
                if (zHasWriteSettingsPermission) {
                    String systemSettingValue = DeviceId.this.getSystemSettingValue(DeviceId.KEY_DEVICE_ID_V2);
                    if (TextUtils.isEmpty(systemSettingValue)) {
                        DeviceId.this.tryPutSystemSettingValue(DeviceId.KEY_DEVICE_ID_V2, strEncryptCUIDInfo);
                    } else {
                        CUIDInfo cUIDInfoCreateFromJson2 = CUIDInfo.createFromJson(DeviceId.decryptCUIDInfo(systemSettingValue));
                        if (cUIDInfoCreateFromJson2 != null) {
                            if (DeviceId.this.fixCUIDInfoByIE(cUIDInfoCreateFromJson2)) {
                                DeviceId.this.tryPutSystemSettingValue(DeviceId.KEY_DEVICE_ID_V2, DeviceId.encryptCUIDInfo(cUIDInfoCreateFromJson2.toPersitString()));
                            }
                        } else if (cUIDInfoCreateFromJson2 == null) {
                            DeviceId.this.tryPutSystemSettingValue(DeviceId.KEY_DEVICE_ID_V2, strEncryptCUIDInfo);
                        }
                    }
                }
                boolean zCheckSelfPermission = DeviceId.this.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
                if (zCheckSelfPermission) {
                    if (!new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2").exists()) {
                        DeviceId.setExternalV2DeviceId(strEncryptCUIDInfo);
                    } else {
                        CUIDInfo cuidInfoFromExternalV2 = DeviceId.this.getCuidInfoFromExternalV2();
                        if (cuidInfoFromExternalV2 != null) {
                            if (DeviceId.this.fixCUIDInfoByIE(cuidInfoFromExternalV2)) {
                                DeviceId.setExternalV2DeviceId(DeviceId.encryptCUIDInfo(cuidInfoFromExternalV2.toPersitString()));
                            }
                        } else if (cuidInfoFromExternalV2 == null) {
                            DeviceId.setExternalV2DeviceId(strEncryptCUIDInfo);
                        }
                    }
                }
                if (zHasWriteSettingsPermission) {
                    String systemSettingValue2 = DeviceId.this.getSystemSettingValue(DeviceId.KEY_FLAG);
                    if (CUIDInfo.isIENormal(TextUtils.isEmpty(systemSettingValue2) ? 0 : systemSettingValue2.length())) {
                        DeviceId.this.tryPutSystemSettingValue(DeviceId.KEY_FLAG, "O");
                    } else if (CUIDInfo.isIENull(systemSettingValue2)) {
                        DeviceId.this.tryPutSystemSettingValue(DeviceId.KEY_FLAG, "0");
                    }
                }
                if (zCheckSelfPermission && new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid").exists()) {
                    CUIDInfo externalV1DeviceId = DeviceId.this.getExternalV1DeviceId(DeviceId.this.getDefaultFlag(""));
                    if (externalV1DeviceId == null || !DeviceId.this.fixCUIDInfoByIE(externalV1DeviceId)) {
                        return;
                    }
                    DeviceId.setExternalDeviceId(externalV1DeviceId.flag, externalV1DeviceId.deviceId);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasWriteSettingsPermission() {
        return checkSelfPermission("android.permission.WRITE_SETTINGS");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkSelfPermission(String str) {
        return this.mContext.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    private CUIDInfo getCUidInfoFromSystemSettingV1() {
        return CUIDInfo.createCuidInfoFromV1Cache(getSystemSettingValue(KEY_DEVICE_ID), getSystemSettingValue(KEY_FLAG));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CUIDInfo getCuidInfoFromExternalV2() throws Throwable {
        File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
        if (!file.exists()) {
            return null;
        }
        String fileContent = getFileContent(file);
        if (TextUtils.isEmpty(fileContent)) {
            return null;
        }
        try {
            String str = AES_KEY;
            return CUIDInfo.createFromJson(new String(AESUtil.decrypt(str, str, Base64.decode(fileContent.getBytes()))));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CUIDInfo getExternalV1DeviceId(String str) throws IOException {
        String str2;
        String[] strArrSplit;
        String str3 = "";
        File file = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
        if (!file.exists()) {
            file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
                sb.append("\r\n");
            }
            bufferedReader.close();
            String str4 = AES_KEY;
            strArrSplit = new String(AESUtil.decrypt(str4, str4, Base64.decode(sb.toString().getBytes()))).split("=");
        } catch (FileNotFoundException | IOException | Exception unused) {
        }
        if (strArrSplit == null || strArrSplit.length != 2) {
            str2 = "";
        } else {
            str2 = strArrSplit[0];
            try {
                str3 = strArrSplit[1];
            } catch (FileNotFoundException | IOException | Exception unused2) {
            }
        }
        return CUIDInfo.createCuidInfoFromV1Cache(str3, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String encryptCUIDInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String str2 = AES_KEY;
            return Base64.encode(AESUtil.encrypt(str2, str2, str.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException e) {
            handleThrowable(e);
            return "";
        } catch (Exception e2) {
            handleThrowable(e2);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String decryptCUIDInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String str2 = AES_KEY;
            return new String(AESUtil.decrypt(str2, str2, Base64.decode(str.getBytes())));
        } catch (Exception e) {
            handleThrowable(e);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setExternalV2DeviceId(String str) {
        File file;
        File file2 = new File(Environment.getExternalStorageDirectory(), EXT_DIR);
        File file3 = new File(file2, EXT_FILE_V2);
        try {
            if (file2.exists() && !file2.isDirectory()) {
                Random random = new Random();
                File parentFile = file2.getParentFile();
                String name = file2.getName();
                do {
                    file = new File(parentFile, name + random.nextInt() + ".tmp");
                } while (file.exists());
                file2.renameTo(file);
                file.delete();
            }
            file2.mkdirs();
            FileWriter fileWriter = new FileWriter(file3, false);
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException | Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setExternalDeviceId(String str, String str2) {
        File file;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file2 = new File(Environment.getExternalStorageDirectory(), EXT_DIR);
        File file3 = new File(file2, EXT_FILE);
        try {
            if (file2.exists() && !file2.isDirectory()) {
                Random random = new Random();
                File parentFile = file2.getParentFile();
                String name = file2.getName();
                do {
                    file = new File(parentFile, name + random.nextInt() + ".tmp");
                } while (file.exists());
                file2.renameTo(file);
                file.delete();
            }
            file2.mkdirs();
            FileWriter fileWriter = new FileWriter(file3, false);
            String str3 = AES_KEY;
            fileWriter.write(Base64.encode(AESUtil.encrypt(str3, str3, (str + "=" + str2).getBytes()), "utf-8"));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException | Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getBase64DecodeStr(String str) {
        return new String(Base64.decode(str.getBytes()));
    }

    static class CUIDInfo {
        public static final String I_EMPTY = "0";
        public static final String I_FIXED = "O";
        public static final int PROTOCAL_MAX_LENGTH = 14;
        private static final int VERSION_DEF = 2;
        public String deviceId;
        public String flag;
        public int oldValueLength;
        public int version;

        public static boolean isIENormal(int i) {
            return i >= 14;
        }

        private CUIDInfo() {
            this.version = 2;
            this.oldValueLength = 0;
        }

        public boolean isIENull() {
            return isIENull(this.flag);
        }

        public boolean isIENormal() {
            return isIENormal(this.oldValueLength);
        }

        public static boolean isIENull(String str) {
            return TextUtils.isEmpty(str);
        }

        public static CUIDInfo createFromJson(String str) throws JSONException {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> itKeys = jSONObject.keys();
                String str2 = "0";
                String strOptString = "0";
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!DeviceId.getBase64DecodeStr(DeviceId.sDEncoded).equals(next) && !DeviceId.getBase64DecodeStr(DeviceId.sVEncoded).equals(next)) {
                        strOptString = jSONObject.optString(next, "0");
                    }
                }
                String string = jSONObject.getString(DeviceId.getBase64DecodeStr(DeviceId.sDEncoded));
                int i = jSONObject.getInt(DeviceId.getBase64DecodeStr(DeviceId.sVEncoded));
                int length = TextUtils.isEmpty(strOptString) ? 0 : strOptString.length();
                if (!TextUtils.isEmpty(string)) {
                    CUIDInfo cUIDInfo = new CUIDInfo();
                    cUIDInfo.deviceId = string;
                    cUIDInfo.version = i;
                    cUIDInfo.oldValueLength = length;
                    if (length < 14) {
                        if (!TextUtils.isEmpty(strOptString)) {
                            str2 = strOptString;
                        }
                        cUIDInfo.flag = str2;
                    }
                    return cUIDInfo;
                }
            } catch (JSONException e) {
                DeviceId.handleThrowable(e);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static CUIDInfo createCuidInfoFromV1Cache(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            CUIDInfo cUIDInfo = new CUIDInfo();
            cUIDInfo.deviceId = str;
            int length = TextUtils.isEmpty(str2) ? 0 : str2.length();
            cUIDInfo.oldValueLength = length;
            if (length < 14) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "0";
                }
                cUIDInfo.flag = str2;
            }
            return cUIDInfo;
        }

        public String toPersitString() {
            try {
                return new JSONObject().put(DeviceId.getBase64DecodeStr(DeviceId.sDEncoded), this.deviceId).put(DeviceId.getBase64DecodeStr(DeviceId.sIEncoded), this.flag).put(DeviceId.getBase64DecodeStr(DeviceId.sVEncoded), this.version).toString();
            } catch (JSONException e) {
                DeviceId.handleThrowable(e);
                return null;
            }
        }

        public String getFinalCUID() {
            String str = this.flag;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            return this.deviceId + "|" + str;
        }
    }

    static class TargetApiSupport {
        TargetApiSupport() {
        }

        static boolean doChmodSafely(String str, int i) throws ErrnoException {
            try {
                Os.chmod(str, i);
                return true;
            } catch (ErrnoException e) {
                DeviceId.handleThrowable(e);
                return false;
            } catch (Exception e2) {
                DeviceId.handleThrowable(e2);
                return false;
            }
        }
    }

    static class CUIDBuddyInfo {
        public ApplicationInfo appInfo;
        public boolean isSelf;
        public int priority;
        public boolean sigMatched;

        private CUIDBuddyInfo() {
            this.priority = 0;
            this.sigMatched = false;
            this.isSelf = false;
        }
    }
}
