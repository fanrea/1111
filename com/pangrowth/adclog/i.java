package com.pangrowth.adclog;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.ad.android.alog.Alog;
import com.bytedance.sdk.djx.core.log.ILogConst;
import io.netty.util.internal.StringUtil;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class i {
    public static long a;
    public static long b;
    public static ArrayList<String> c;
    public static String d;
    public static Alog e;
    public static String f;

    public static String a(Bundle bundle) {
        if (bundle == null) {
            return ILogConst.CACHE_PLAY_REASON_NULL;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("Bundle[{");
        a(bundle, sb);
        sb.append("}]");
        return sb.toString();
    }

    public static String a(String str, String str2) {
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static String a(String str, Map<String, String> map) {
        if (!TextUtils.isDigitsOnly(str) && map != null && !map.isEmpty()) {
            if (str.indexOf("?") < 0) {
                str = str + "?";
            }
            str = (str.endsWith("?") ? new StringBuilder().append(str) : new StringBuilder().append(str).append(com.alipay.sdk.m.s.a.n)).append(a("sdk_version", "UTF-8")).append("=").append(a(String.valueOf(400), "UTF-8")).toString();
            if (map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (map.get(entry.getKey()) != null) {
                        str = (str.endsWith("?") ? new StringBuilder().append(str) : new StringBuilder().append(str).append(com.alipay.sdk.m.s.a.n)).append(a(entry.getKey().toString(), "UTF-8")).append("=").append(a(map.get(entry.getKey()).toString(), "UTF-8")).toString();
                    }
                }
            }
        }
        return str;
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable cause = th; cause != null; cause = cause.getCause()) {
            if (cause instanceof UnknownHostException) {
                return "ALOG:UnknownHostException";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            th.printStackTrace(printWriter);
        } catch (Throwable unused) {
        }
        printWriter.flush();
        return stringWriter.toString();
    }

    public static String a(Throwable th, int i) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (StackTraceElement stackTraceElement : stackTrace) {
            i2++;
            sb.append("\tat " + stackTraceElement.getClassName()).append(".").append(stackTraceElement.getMethodName()).append("(").append(stackTraceElement.getFileName()).append(":").append(stackTraceElement.getLineNumber()).append(")\n");
            if (i2 > i) {
                break;
            }
        }
        return sb.toString();
    }

    public static String a(HashMap<String, String> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    jSONObject.put(str, map.get(str));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public static void a(int i, String str, String str2) {
        Alog alog = e;
        if (alog != null) {
            alog.a(i, str, str2);
        }
    }

    public static void a(Bundle bundle, StringBuilder sb) {
        String strA;
        boolean z = true;
        for (String str : bundle.keySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(str).append(com.alipay.sdk.m.n.a.h);
            Object obj = bundle.get(str);
            if (obj instanceof int[]) {
                strA = Arrays.toString((int[]) obj);
            } else if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                strA = bArr.length < 102400 ? Arrays.toString(bArr) : "byte[] in Bundle is too long, limit for 100K";
            } else if (obj instanceof boolean[]) {
                strA = Arrays.toString((boolean[]) obj);
            } else if (obj instanceof short[]) {
                strA = Arrays.toString((short[]) obj);
            } else if (obj instanceof long[]) {
                strA = Arrays.toString((long[]) obj);
            } else if (obj instanceof float[]) {
                strA = Arrays.toString((float[]) obj);
            } else if (obj instanceof double[]) {
                strA = Arrays.toString((double[]) obj);
            } else if (obj instanceof String[]) {
                strA = Arrays.toString((String[]) obj);
            } else if (obj instanceof CharSequence[]) {
                strA = Arrays.toString((CharSequence[]) obj);
            } else if (obj instanceof Parcelable[]) {
                strA = Arrays.toString((Parcelable[]) obj);
            } else if (obj instanceof Bundle) {
                strA = a((Bundle) obj);
            } else {
                sb.append(obj);
                z = false;
            }
            sb.append(strA);
            z = false;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(File file, BufferedWriter bufferedWriter) throws IOException {
        HashMap map = new HashMap();
        bufferedWriter.write("{");
        bufferedWriter.newLine();
        File[] fileArrListFiles = file.listFiles();
        for (int i = 0; i < fileArrListFiles.length; i++) {
            map.clear();
            a(fileArrListFiles[i], (HashMap<String, Object>) map);
            if (!map.keySet().isEmpty()) {
                a((HashMap<String, Object>) map, 1, bufferedWriter);
                if (i + 1 < fileArrListFiles.length) {
                    bufferedWriter.write(",");
                }
            }
        }
        bufferedWriter.write(com.alipay.sdk.m.u.i.d);
        bufferedWriter.flush();
    }

    public static void a(File file, HashMap<String, Object> map) {
        if (file.getName().startsWith(".")) {
            return;
        }
        if (file.isFile()) {
            map.put(file.getName(), Long.valueOf(file.length()));
        }
        if (file.isDirectory()) {
            HashMap map2 = new HashMap();
            map.put(file.getName(), map2);
            for (String str : file.list()) {
                a(new File(file, str), (HashMap<String, Object>) map2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.util.HashMap<java.lang.String, java.lang.Object> r12, int r13, java.io.BufferedWriter r14) throws java.io.IOException {
        /*
            java.util.Set r0 = r12.keySet()
            int r0 = r0.size()
            java.util.Set r1 = r12.keySet()
            java.util.Iterator r1 = r1.iterator()
            r2 = 0
            r3 = r2
        L12:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L99
            java.lang.Object r4 = r1.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r12.get(r4)
            r6 = 1
            int r3 = r3 + r6
            boolean r7 = r5 instanceof java.lang.Long
            java.lang.String r8 = ""
            java.lang.String r9 = "\n"
            java.lang.String r10 = "\t"
            if (r7 == 0) goto L5a
            r7 = r2
        L2f:
            int r11 = r13 + 1
            if (r7 >= r11) goto L39
            r14.write(r10)
            int r7 = r7 + 1
            goto L2f
        L39:
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]
            java.lang.String r4 = r4.replaceAll(r9, r8)
            r7[r2] = r4
            java.lang.Long r5 = (java.lang.Long) r5
            long r4 = r5.longValue()
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r7[r6] = r4
            java.lang.String r4 = "\"%s\": %d"
            java.lang.String r4 = java.lang.String.format(r4, r7)
            r14.write(r4)
            if (r3 >= r0) goto L94
            goto L8f
        L5a:
            r7 = r2
        L5b:
            if (r7 >= r13) goto L63
            r14.write(r10)
            int r7 = r7 + 1
            goto L5b
        L63:
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.String r4 = r4.replaceAll(r9, r8)
            r6[r2] = r4
            java.lang.String r4 = "\"%s\": {"
            java.lang.String r4 = java.lang.String.format(r4, r6)
            r14.write(r4)
            r14.newLine()
            java.util.HashMap r5 = (java.util.HashMap) r5
            int r4 = r13 + 1
            a(r5, r4, r14)
            r5 = r2
        L7f:
            if (r5 >= r4) goto L87
            r14.write(r10)
            int r5 = r5 + 1
            goto L7f
        L87:
            java.lang.String r4 = "}"
            r14.write(r4)
            if (r3 >= r0) goto L94
        L8f:
            java.lang.String r4 = ","
            r14.write(r4)
        L94:
            r14.newLine()
            goto L12
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pangrowth.adclog.i.a(java.util.HashMap, int, java.io.BufferedWriter):void");
    }

    public static boolean a() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static File[] a(String str, String str2, long j, long j2) {
        String str3;
        Alog alog = e;
        if (alog == null) {
            return new File[0];
        }
        String str4 = alog.b;
        a = j;
        b = j2;
        d = null;
        c = null;
        if (j > j2) {
            str3 = "time interval is invalid";
        } else {
            File file = new File(str4);
            if (file.exists() && file.isDirectory()) {
                if (!TextUtils.isEmpty(null)) {
                    throw null;
                }
                Pattern patternCompile = Pattern.compile("^\\d{4}_\\d{2}_\\d{2}_(\\d+)__" + (TextUtils.isEmpty(null) ? "\\S+" : Pattern.quote(null)) + "__" + (TextUtils.isEmpty(null) ? "\\S+" : Pattern.quote(null)) + "\\.alog\\.hot$");
                ArrayList<String> arrayList = new ArrayList<>();
                File[] fileArrListFiles = file.listFiles(new u(arrayList, patternCompile, j2, j));
                if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                    d = "log file not found";
                    c = arrayList;
                }
                if (fileArrListFiles != null) {
                    return fileArrListFiles;
                }
                return new File[0];
            }
            str3 = "log dir not exists";
        }
        d = str3;
        return new File[0];
    }

    public static void a(Intent intent, StringBuilder sb) throws NoSuchMethodException, SecurityException {
        boolean z;
        Intent selector;
        String string;
        String action = intent.getAction();
        boolean z2 = false;
        if (action != null) {
            sb.append("act=").append(action);
            z = false;
        } else {
            z = true;
        }
        Set<String> categories = intent.getCategories();
        if (categories != null) {
            if (!z) {
                sb.append(' ');
            }
            sb.append("cat=[");
            boolean z3 = true;
            for (String str : categories) {
                if (!z3) {
                    sb.append(StringUtil.COMMA);
                }
                sb.append(str);
                z3 = false;
            }
            sb.append("]");
            z = false;
        }
        Uri data = intent.getData();
        if (data != null) {
            if (!z) {
                sb.append(' ');
            }
            sb.append("dat=");
            int i = Build.VERSION.SDK_INT;
            if (i < 14) {
                String scheme = data.getScheme();
                if (scheme != null) {
                    if (scheme.equalsIgnoreCase("tel")) {
                        string = "tel:xxx-xxx-xxxx";
                    } else if (scheme.equalsIgnoreCase("smsto")) {
                        string = "smsto:xxx-xxx-xxxx";
                    }
                }
                sb.append(data);
                z = false;
            } else if (i >= 14) {
                try {
                    Method declaredMethod = Uri.class.getDeclaredMethod("toSafeString", new Class[0]);
                    declaredMethod.setAccessible(true);
                    string = (String) declaredMethod.invoke(data, new Object[0]);
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (NoSuchMethodException e3) {
                    e3.printStackTrace();
                } catch (InvocationTargetException e4) {
                    e4.printStackTrace();
                }
            } else {
                string = data.toString();
            }
            sb.append(string);
            z = false;
        }
        String type = intent.getType();
        if (type != null) {
            if (!z) {
                sb.append(' ');
            }
            sb.append("typ=").append(type);
            z = false;
        }
        int flags = intent.getFlags();
        if (flags != 0) {
            if (!z) {
                sb.append(' ');
            }
            sb.append("flg=0x").append(Integer.toHexString(flags));
            z = false;
        }
        String str2 = intent.getPackage();
        if (str2 != null) {
            if (!z) {
                sb.append(' ');
            }
            sb.append("pkg=").append(str2);
            z = false;
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            if (!z) {
                sb.append(' ');
            }
            sb.append("cmp=").append(component.flattenToShortString());
            z = false;
        }
        Rect sourceBounds = intent.getSourceBounds();
        if (sourceBounds != null) {
            if (!z) {
                sb.append(' ');
            }
            sb.append("bnds=").append(sourceBounds.toShortString());
            z = false;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 16 || intent.getClipData() == null) {
            z2 = z;
        } else {
            if (!z) {
                sb.append(' ');
            }
            sb.append("(has clip)");
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            if (!z2) {
                sb.append(' ');
            }
            sb.append("extras={");
            a(extras, sb);
            sb.append('}');
        }
        if (i2 < 15 || (selector = intent.getSelector()) == null) {
            return;
        }
        sb.append(" sel=");
        a(selector, sb);
        sb.append(com.alipay.sdk.m.u.i.d);
    }

    public static void a(String str, String str2, int i, Map<String, String> map) {
        if (v.a()) {
            Log.d("cloudmessage", a0.a(new String[]{"report: commandId=" + str, ", message=" + str2, ", code=" + i, ", specificParams=" + map}));
        }
        q2 q2Var = new q2(0L, false, str, map != null ? new HashMap(map) : null);
        q2Var.d = i;
        q2Var.e = str2;
        n2.a(q2Var);
    }
}
