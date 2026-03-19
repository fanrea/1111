package com.kwad.sdk.crash.report;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.container.util.cm;
import com.kwad.sdk.crash.message.Backtrace;
import com.kwad.sdk.crash.message.JavaBackTraceElement;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.utils.q;
import com.kwad.sdk.utils.w;
import io.reactivex.annotations.SchedulerSupport;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class d {
    protected e mUploader;
    protected String mErrorMessage = "";
    private final ConcurrentHashMap<String, Pattern> bOA = new ConcurrentHashMap<>();

    protected abstract ExceptionMessage a(File file, File file2, File file3, File file4, File file5);

    public final void a(e eVar) {
        this.mUploader = eVar;
    }

    public final Pattern gY(String str) {
        if (!this.bOA.containsKey(str)) {
            if (str.equals(".*at\\s+(.*)\\.(.*)\\(((.*):(-?\\d+)|Native method)\\)") || str.equals(".*(Mterp|ExecuteMterp|(art::|_ZN3art11)(interpreter|.*Invoke)|art_?interpreter|art_?quick|ZN3art9ArtMethod6Invoke|art::ArtMethod::Invoke).*")) {
                this.bOA.put(str, Pattern.compile(str, 66));
            } else {
                this.bOA.put(str, Pattern.compile(str));
            }
        }
        return this.bOA.get(str);
    }

    public void D(File file) {
        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "reportException dir =" + file);
        File[] fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.report.d.1
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "reportException file =" + file2.getName());
                return file2.isDirectory();
            }
        });
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                a(file2, (CountDownLatch) null);
            }
        }
    }

    public void a(File file, CountDownLatch countDownLatch) {
        File[] fileArr;
        int i;
        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploadExceptionEventAndLog dumpFile=" + file.getPath());
        File file2 = new File(file, com.sigmob.sdk.archives.d.c);
        File file3 = new File(file, cm.V);
        File file4 = new File(file, com.baidu.mobads.container.components.j.a.b);
        File file5 = new File(file, "logcat");
        File file6 = new File(file, "logcat_backup");
        File file7 = new File(file, "message_parsed");
        ArrayList arrayList = new ArrayList();
        try {
            ExceptionMessage exceptionMessageA = a(file2, file3, file4, file5, file);
            if (exceptionMessageA == null) {
                try {
                    w.delete(file2.getPath());
                    w.delete(file4.getPath());
                    w.delete(file6.getPath());
                    w.delete(file3.getPath());
                    w.delete(file7.getPath());
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        w.delete(((File) it.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.G(file);
                    w.delete(file.getPath());
                    com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                    return;
                }
            }
            File file8 = new File(file, "anr_happened");
            if (file.getPath().contains("anr_log") && Build.VERSION.SDK_INT > 33 && !file8.exists()) {
                com.kwad.sdk.core.d.c.w("AnrAndNativeAdExceptionCollector", "not real anr");
                try {
                    w.delete(file2.getPath());
                    w.delete(file4.getPath());
                    w.delete(file6.getPath());
                    w.delete(file3.getPath());
                    w.delete(file7.getPath());
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        w.delete(((File) it2.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.G(file);
                    w.delete(file.getPath());
                    com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                    return;
                }
            }
            com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "message.mCrashSource=" + exceptionMessageA.mCrashSource);
            if (exceptionMessageA.mCrashSource == 2) {
                try {
                    w.delete(file2.getPath());
                    w.delete(file4.getPath());
                    w.delete(file6.getPath());
                    w.delete(file3.getPath());
                    w.delete(file7.getPath());
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        w.delete(((File) it3.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.G(file);
                    w.delete(file.getPath());
                    com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th3) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th3);
                    return;
                }
            }
            this.mUploader.a(exceptionMessageA, countDownLatch);
            if (this instanceof f) {
                com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", " java crash 不上传文件");
                try {
                    w.delete(file2.getPath());
                    w.delete(file4.getPath());
                    w.delete(file6.getPath());
                    w.delete(file3.getPath());
                    w.delete(file7.getPath());
                    Iterator it4 = arrayList.iterator();
                    while (it4.hasNext()) {
                        w.delete(((File) it4.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.G(file);
                    w.delete(file.getPath());
                    com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th4) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th4);
                    return;
                }
            }
            com.kwad.sdk.crash.utils.g.F(file6);
            List<File> arrayList2 = new ArrayList<>();
            int i2 = 0;
            Collections.addAll(arrayList2, file4, file6);
            Iterator<File> it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                if (!it5.next().exists()) {
                    it5.remove();
                }
            }
            File file9 = new File(file2.getParentFile().getParent(), SchedulerSupport.CUSTOM);
            if (file9.exists()) {
                File[] fileArrListFiles = file9.listFiles();
                int length = fileArrListFiles.length;
                while (i2 < length) {
                    File file10 = fileArrListFiles[i2];
                    if (file10.isDirectory()) {
                        fileArr = fileArrListFiles;
                        i = length;
                    } else {
                        fileArr = fileArrListFiles;
                        i = length;
                        if (file10.getName().startsWith(exceptionMessageA.mLogUUID) || file10.getName().startsWith(gZ(exceptionMessageA.mLogUUID))) {
                            arrayList.add(file10);
                        }
                    }
                    i2++;
                    fileArrListFiles = fileArr;
                    length = i;
                }
                arrayList2.addAll(arrayList);
            }
            a(exceptionMessageA, arrayList2, countDownLatch);
            try {
                w.delete(file2.getPath());
                w.delete(file4.getPath());
                w.delete(file6.getPath());
                w.delete(file3.getPath());
                w.delete(file7.getPath());
                Iterator it6 = arrayList.iterator();
                while (it6.hasNext()) {
                    w.delete(((File) it6.next()).getPath());
                }
                com.kwad.sdk.crash.utils.g.G(file);
                w.delete(file.getPath());
                com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
            } catch (Throwable th5) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th5);
            }
        } catch (Throwable th6) {
            try {
                com.kwad.sdk.core.d.c.e("AnrAndNativeAdExceptionCollector", Log.getStackTraceString(th6));
                com.kwad.sdk.core.d.c.printStackTraceOnly(th6);
                com.kwad.sdk.crash.utils.g.y(th6);
                try {
                    w.delete(file2.getPath());
                    w.delete(file4.getPath());
                    w.delete(file6.getPath());
                    w.delete(file3.getPath());
                    w.delete(file7.getPath());
                    Iterator it7 = arrayList.iterator();
                    while (it7.hasNext()) {
                        w.delete(((File) it7.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.G(file);
                    w.delete(file.getPath());
                    com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
                } catch (Throwable th7) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th7);
                }
            } catch (Throwable th8) {
                try {
                    w.delete(file2.getPath());
                    w.delete(file4.getPath());
                    w.delete(file6.getPath());
                    w.delete(file3.getPath());
                    w.delete(file7.getPath());
                    Iterator it8 = arrayList.iterator();
                    while (it8.hasNext()) {
                        w.delete(((File) it8.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.G(file);
                    w.delete(file.getPath());
                    com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
                    throw th8;
                } catch (Throwable th9) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th9);
                    throw th8;
                }
            }
        }
    }

    protected final void a(ExceptionMessage exceptionMessage, List<File> list, CountDownLatch countDownLatch) throws Throwable {
        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "compressAndUpload");
        File fileAea = this.mUploader.aea();
        if (!fileAea.exists()) {
            fileAea.mkdir();
        }
        File file = new File(fileAea, exceptionMessage.mLogUUID + ".zip");
        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "compressAndUpload zipFile=" + file.getPath());
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
        }
        q.a((File[]) list.toArray(new File[0]), file.getPath());
        if (file.length() > 0) {
            HashMap map = new HashMap();
            map.put("mLogUUID", exceptionMessage.mLogUUID);
            new JSONObject(map);
            b(file, countDownLatch);
            return;
        }
        w.ae(file);
    }

    private static void b(File file, CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.upload.d.a(file, true, countDownLatch);
    }

    protected static String gZ(String str) {
        return (str == null || !str.contains("-")) ? str : str.substring(0, str.lastIndexOf(45));
    }

    public final void a(String str, Backtrace backtrace, boolean z) {
        if (backtrace.getFrame() > 256) {
            return;
        }
        JavaBackTraceElement javaBackTraceElement = new JavaBackTraceElement(str, backtrace.getFrame());
        Matcher matcher = gY(".*at\\s+(.*)\\.(.*)\\(((.*):(-?\\d+)|Native method)\\)").matcher(str);
        if (matcher.lookingAt()) {
            javaBackTraceElement.setDeclaringClass(matcher.group(1));
            javaBackTraceElement.setMethodName(matcher.group(2));
            if (matcher.groupCount() >= 5) {
                String strGroup = matcher.group(4);
                if (strGroup != null) {
                    javaBackTraceElement.setFileName(strGroup);
                } else {
                    javaBackTraceElement.setIsNative(true);
                }
                String strGroup2 = matcher.group(5);
                if (strGroup2 != null) {
                    try {
                        javaBackTraceElement.setLineNumber(Long.parseLong(strGroup2));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            backtrace.getFrame();
            if (str.startsWith("Caused by: ")) {
                javaBackTraceElement.setIsCausedBy(true);
            }
        }
        if (javaBackTraceElement.isTitle() || javaBackTraceElement.isCausedBy() || javaBackTraceElement.isNative()) {
            javaBackTraceElement.setNeedClustering(false);
        }
        backtrace.setFrame(backtrace.getFrame() + 1);
        backtrace.getBacktraces().add(javaBackTraceElement);
    }

    protected final void a(File file, ExceptionMessage exceptionMessage) throws Throwable {
        String str;
        String str2;
        String str3;
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                boolean z = false;
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line != null) {
                            if (!z && line.contains("JNI DETECTED ERROR IN APPLICATION")) {
                                exceptionMessage.mJNIError = line.substring(line.indexOf("JNI DETECTED ERROR IN APPLICATION"));
                                z = true;
                            } else if (line.contains("Waiting for a blocking GC ") || line.contains("WaitForGcToComplete")) {
                                exceptionMessage.mGCInfo = (TextUtils.isEmpty(exceptionMessage.mGCInfo) ? new StringBuilder().append(line).append("\n") : new StringBuilder().append(exceptionMessage.mGCInfo).append(line).append("\n")).toString();
                            } else if (line.contains("dvm_lock_sample")) {
                                exceptionMessage.mLockInfo = (TextUtils.isEmpty(exceptionMessage.mLockInfo) ? new StringBuilder().append(line).append("\n") : new StringBuilder().append(exceptionMessage.mLockInfo).append(line).append("\n")).toString();
                            } else if (line.contains("Long monitor")) {
                                if (TextUtils.isEmpty(exceptionMessage.mMonitorInfo)) {
                                    str = line + "\n";
                                } else {
                                    str = exceptionMessage.mMonitorInfo + line + "\n";
                                }
                                exceptionMessage.mMonitorInfo = str;
                            } else if (line.contains("Slow Looper")) {
                                if (TextUtils.isEmpty(exceptionMessage.mSlowLooper)) {
                                    str2 = line + "\n";
                                } else {
                                    str2 = exceptionMessage.mSlowLooper + line + "\n";
                                }
                                exceptionMessage.mSlowLooper = str2;
                            } else if (line.contains("Slow Operation")) {
                                if (TextUtils.isEmpty(exceptionMessage.mSlowOperation)) {
                                    str3 = line + "\n";
                                } else {
                                    str3 = exceptionMessage.mSlowOperation + line + "\n";
                                }
                                exceptionMessage.mSlowOperation = str3;
                            }
                        } else {
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                            return;
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        this.mErrorMessage += e + "\n";
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return;
                    } catch (IOException e2) {
                        e = e2;
                        bufferedReader = bufferedReader2;
                        this.mErrorMessage += e + "\n";
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        throw th;
                    }
                }
            } catch (FileNotFoundException e3) {
                e = e3;
            } catch (IOException e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
