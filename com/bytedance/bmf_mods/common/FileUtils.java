package com.bytedance.bmf_mods.common;

import android.content.Context;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.sigmob.sdk.base.n;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FileUtils.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001a\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0007J\u0010\u0010\u0013\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0007J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/bmf_mods/common/FileUtils;", "", "()V", "HEX_DIGITS_LOWER", "", "checkFileReady", "", n.z, "Ljava/io/File;", TKDownloadReason.KSAD_TK_MD5, "", "deleteIfExist", "", "getFileMd5", "", "getModelDownloadDir", "context", "Landroid/content/Context;", "dirName", "isFileValid", "unzipFile", "sourceFile", "destPath", "unzipFileWithConfig", "bmf_mods_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class FileUtils {
    public static final FileUtils INSTANCE = new FileUtils();
    private static final char[] HEX_DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private FileUtils() {
    }

    @JvmStatic
    public static final File getModelDownloadDir(Context context, String dirName) {
        Intrinsics.checkNotNullParameter(dirName, "dirName");
        if (context != null) {
            return new File(context.getFilesDir().toString() + File.separator + "bmf_mods_lite_models", dirName);
        }
        return new File(new File("/data/local/tmp/bmf_mods_lite_models"), dirName);
    }

    @JvmStatic
    public static final boolean unzipFileWithConfig(File sourceFile, File destPath) throws JSONException, IOException {
        Object obj;
        JSONObject jSONObject;
        File file = destPath;
        Intrinsics.checkNotNullParameter(sourceFile, "sourceFile");
        Intrinsics.checkNotNullParameter(file, "destPath");
        if (!destPath.exists()) {
            destPath.mkdirs();
        }
        File fileResolveSibling = FilesKt.resolveSibling(sourceFile, sourceFile.getName() + "_config.json");
        Object obj2 = null;
        try {
            Result.Companion companion = Result.Companion;
            if (fileResolveSibling.exists()) {
                jSONObject = new JSONObject(FilesKt.readText$default(fileResolveSibling, (Charset) null, 1, (Object) null));
            } else {
                jSONObject = new JSONObject();
            }
            obj = Result.constructor-impl(jSONObject);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        JSONObject jSONObject2 = new JSONObject();
        if (Result.isFailure-impl(obj)) {
            obj = jSONObject2;
        }
        JSONObject jSONObject3 = (JSONObject) obj;
        boolean z = false;
        try {
            String strMd5 = INSTANCE.md5(sourceFile);
            if (!jSONObject3.has(sourceFile.getName()) || !Intrinsics.areEqual(jSONObject3.get(sourceFile.getName()), strMd5)) {
                jSONObject3.put(sourceFile.getName(), strMd5);
                jSONObject3.remove("file_list");
            }
            JSONObject jSONObjectOptJSONObject = jSONObject3.optJSONObject("file_list");
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
            }
            ZipFile zipFile = new ZipFile(sourceFile);
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            while (enumerationEntries.hasMoreElements()) {
                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                String name = zipEntryNextElement.getName();
                Intrinsics.checkNotNullExpressionValue(name, "entry.name");
                if (StringsKt.contains$default(name, "__MACOSX", z, 2, obj2)) {
                    file = destPath;
                } else {
                    File file2 = new File(file, zipEntryNextElement.getName());
                    if (zipEntryNextElement.isDirectory() && !file2.exists()) {
                        file2.mkdirs();
                    } else {
                        if (jSONObjectOptJSONObject.has(zipEntryNextElement.getName())) {
                            FileUtils fileUtils = INSTANCE;
                            Object obj3 = jSONObjectOptJSONObject.get(zipEntryNextElement.getName());
                            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
                            if (fileUtils.checkFileReady(file2, (String) obj3)) {
                                obj2 = null;
                            }
                        }
                        if (jSONObjectOptJSONObject.has(zipEntryNextElement.getName())) {
                            FileUtils fileUtils2 = INSTANCE;
                            Object obj4 = jSONObjectOptJSONObject.get(zipEntryNextElement.getName());
                            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.String");
                            if (!fileUtils2.checkFileReady(file2, (String) obj4)) {
                                jSONObjectOptJSONObject.remove(zipEntryNextElement.getName());
                            }
                        }
                        INSTANCE.deleteIfExist(file2);
                        try {
                            FileOutputStream inputStream = zipFile.getInputStream(zipEntryNextElement);
                            try {
                                InputStream inputStream2 = inputStream;
                                inputStream = new FileOutputStream(file2);
                                try {
                                    FileOutputStream fileOutputStream = inputStream;
                                    byte[] bArr = new byte[8192];
                                    while (true) {
                                        int i = inputStream2.read(bArr);
                                        if (i <= 0) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, i);
                                        enumerationEntries = enumerationEntries;
                                    }
                                    Enumeration<? extends ZipEntry> enumeration = enumerationEntries;
                                    fileOutputStream.flush();
                                    Unit unit = Unit.INSTANCE;
                                    CloseableKt.closeFinally(inputStream, (Throwable) null);
                                    Unit unit2 = Unit.INSTANCE;
                                    CloseableKt.closeFinally(inputStream, (Throwable) null);
                                    jSONObjectOptJSONObject.put(zipEntryNextElement.getName(), INSTANCE.md5(file2));
                                    obj2 = null;
                                    file = destPath;
                                    enumerationEntries = enumeration;
                                    z = false;
                                } finally {
                                }
                            } finally {
                            }
                        } catch (IOException e) {
                            Logging.e("unzip model " + sourceFile.getName() + " failed, " + e.getMessage());
                            return false;
                        }
                    }
                }
            }
            zipFile.close();
            jSONObject3.put("file_list", jSONObjectOptJSONObject);
            String string = jSONObject3.toString();
            Intrinsics.checkNotNullExpressionValue(string, "jobj.toString()");
            FilesKt.writeText$default(fileResolveSibling, string, (Charset) null, 2, (Object) null);
            Logging.d("unzip model " + sourceFile.getName() + " success");
            return true;
        } catch (IOException e2) {
            Logging.e("unzip model " + sourceFile.getName() + " failed, " + e2.getMessage());
            return false;
        }
    }

    @JvmStatic
    public static final boolean unzipFile(File sourceFile, File destPath) throws IOException {
        Intrinsics.checkNotNullParameter(sourceFile, "sourceFile");
        Intrinsics.checkNotNullParameter(destPath, "destPath");
        if (!destPath.exists()) {
            destPath.mkdirs();
        }
        try {
            ZipFile zipFile = new ZipFile(sourceFile);
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            while (enumerationEntries.hasMoreElements()) {
                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                String name = zipEntryNextElement.getName();
                Intrinsics.checkNotNullExpressionValue(name, "entry.name");
                if (!StringsKt.contains$default((CharSequence) name, (CharSequence) "__MACOSX", false, 2, (Object) null)) {
                    File file = new File(destPath, zipEntryNextElement.getName());
                    if (zipEntryNextElement.isDirectory()) {
                        file.mkdirs();
                    } else {
                        try {
                            FileOutputStream inputStream = zipFile.getInputStream(zipEntryNextElement);
                            try {
                                InputStream inputStream2 = inputStream;
                                inputStream = new FileOutputStream(file);
                                try {
                                    FileOutputStream fileOutputStream = inputStream;
                                    byte[] bArr = new byte[8192];
                                    while (true) {
                                        int i = inputStream2.read(bArr);
                                        if (i <= 0) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, i);
                                    }
                                    fileOutputStream.flush();
                                    Unit unit = Unit.INSTANCE;
                                    CloseableKt.closeFinally(inputStream, (Throwable) null);
                                    Unit unit2 = Unit.INSTANCE;
                                    CloseableKt.closeFinally(inputStream, (Throwable) null);
                                } catch (Throwable th) {
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        throw th2;
                                    }
                                }
                            } finally {
                            }
                        } catch (IOException e) {
                            Logging.e("unzip model " + sourceFile.getName() + " failed, " + e.getMessage());
                            return false;
                        }
                    }
                }
            }
            zipFile.close();
            Logging.d("unzip model " + sourceFile.getName() + " success");
            return true;
        } catch (IOException e2) {
            Logging.e("unzip model " + sourceFile.getName() + " failed, " + e2.getMessage());
            return false;
        }
    }

    public final boolean isFileValid(File file) {
        return file != null && file.exists() && file.isFile() && file.length() > 0;
    }

    public final void deleteIfExist(File file) {
        if (file != null && file.isFile() && file.exists()) {
            file.delete();
        }
    }

    public final String md5(File file) {
        byte[] fileMd5;
        int length;
        Intrinsics.checkNotNullParameter(file, n.z);
        if (!isFileValid(file) || (fileMd5 = getFileMd5(file)) == null || (length = fileMd5.length) <= 0) {
            return "";
        }
        char[] cArr = new char[length << 1];
        int i = 0;
        for (byte b : fileMd5) {
            int i2 = i + 1;
            char[] cArr2 = HEX_DIGITS_LOWER;
            cArr[i] = cArr2[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0044: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:30:0x0044 */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0047 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0036 A[EXC_TOP_SPLITTER, PHI: r2
  0x0036: PHI (r2v4 java.security.DigestInputStream) = (r2v3 java.security.DigestInputStream), (r2v5 java.security.DigestInputStream) binds: [B:26:0x003f, B:20:0x0034] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final byte[] getFileMd5(java.io.File r4) throws java.lang.Throwable {
        /*
            r3 = this;
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f java.security.NoSuchAlgorithmException -> L3a
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f java.security.NoSuchAlgorithmException -> L3a
            java.lang.String r4 = "MD5"
            java.security.MessageDigest r4 = java.security.MessageDigest.getInstance(r4)     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f java.security.NoSuchAlgorithmException -> L3a
            java.security.DigestInputStream r2 = new java.security.DigestInputStream     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f java.security.NoSuchAlgorithmException -> L3a
            java.io.InputStream r1 = (java.io.InputStream) r1     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f java.security.NoSuchAlgorithmException -> L3a
            r2.<init>(r1, r4)     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f java.security.NoSuchAlgorithmException -> L3a
            r4 = 262144(0x40000, float:3.67342E-40)
            byte[] r4 = new byte[r4]     // Catch: java.io.IOException -> L29 java.security.NoSuchAlgorithmException -> L2b java.lang.Throwable -> L43
        L17:
            int r1 = r2.read(r4)     // Catch: java.io.IOException -> L29 java.security.NoSuchAlgorithmException -> L2b java.lang.Throwable -> L43
            if (r1 > 0) goto L17
            java.security.MessageDigest r4 = r2.getMessageDigest()     // Catch: java.io.IOException -> L29 java.security.NoSuchAlgorithmException -> L2b java.lang.Throwable -> L43
            byte[] r4 = r4.digest()     // Catch: java.io.IOException -> L29 java.security.NoSuchAlgorithmException -> L2b java.lang.Throwable -> L43
            r2.close()     // Catch: java.io.IOException -> L28
        L28:
            return r4
        L29:
            r4 = move-exception
            goto L31
        L2b:
            r4 = move-exception
            goto L3c
        L2d:
            r4 = move-exception
            goto L45
        L2f:
            r4 = move-exception
            r2 = r0
        L31:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L43
            if (r2 == 0) goto L42
        L36:
            r2.close()     // Catch: java.io.IOException -> L42
            goto L42
        L3a:
            r4 = move-exception
            r2 = r0
        L3c:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L43
            if (r2 == 0) goto L42
            goto L36
        L42:
            return r0
        L43:
            r4 = move-exception
            r0 = r2
        L45:
            if (r0 == 0) goto L4a
            r0.close()     // Catch: java.io.IOException -> L4a
        L4a:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bmf_mods.common.FileUtils.getFileMd5(java.io.File):byte[]");
    }

    public final boolean checkFileReady(File file, String md5) {
        Intrinsics.checkNotNullParameter(file, n.z);
        Intrinsics.checkNotNullParameter(md5, TKDownloadReason.KSAD_TK_MD5);
        return isFileValid(file) && Intrinsics.areEqual(md5(file), md5);
    }
}
