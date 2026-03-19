package com.tkruntime.v8;

import android.text.TextUtils;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class V8Trace {
    public static final String SECTION_ASYNC_INIT_CONTEXT = "asyncInitContext";
    public static final String SECTION_CREATE_CONTAINER = "createContainer";
    public static final String SECTION_CREATE_VIEW = "createView";
    public static final String SECTION_DESTROY_CONTAINER = "destroyContainer";
    public static final String SECTION_EXECUTE_JS = "executeJS";
    public static final String SECTION_INIT_CONTEXT = "initContext";
    public static final String SECTION_INSTALL_BUNDLE = "installBundle";
    public static final String SECTION_INVOKE_JS_FUNCTION = "invokeJSFunction";
    public static final String SECTION_JS_CALLBACK = "jsCallback_";
    public static final String SECTION_LOAD_BUNDLE = "loadBundle";
    public static final String SECTION_List_BIND_DATA = "listBindData_";
    public static final String SECTION_List_CREATE_VIEW = "listCreateView_";
    public static final String SECTION_NATIVE_CALLBACK = "nativeCallback_";
    public static final String SECTION_PRE_COMPILE = "preCompile";
    public static final String SECTION_SET_DATA = "setData";
    public static final int STATE_CALL_NATIVE_CALLBACK_BEGIN = 15;
    public static final int STATE_CALL_NATIVE_CALLBACK_END = 16;
    public static final int STATE_CALL_V8_FUNCTION_BEGIN = 9;
    public static final int STATE_CALL_V8_FUNCTION_END = 10;
    public static final int STATE_CREATE_VIEW_BEGIN = 3;
    public static final int STATE_CREATE_VIEW_END = 4;
    public static final int STATE_EXECUTE_JS_BEGIN = 1;
    public static final int STATE_EXECUTE_JS_END = 2;
    public static final int STATE_INVOKE_JS_FUNCTION_BEGIN = 7;
    public static final int STATE_INVOKE_JS_FUNCTION_END = 8;
    public static final int STATE_LIST_BIND_DATA_BEGIN = 13;
    public static final int STATE_LIST_BIND_DATA_END = 14;
    public static final int STATE_LIST_CREATE_VIEW_BEGIN = 11;
    public static final int STATE_LIST_CREATE_VIEW_END = 12;
    public static final int STATE_SET_DATA_BEGIN = 5;
    public static final int STATE_SET_DATA_END = 6;
    private static final int maxLength = 4000;
    private static ILogger sLogger;

    public interface ILogger {
        void addCommunicationCost(V8 v8, float f);

        void beginSection(V8 v8, String str, String str2);

        void beginSection(String str, String str2, String str3);

        void endSection(V8 v8);

        void endSection(String str, String str2, String str3);

        void logD(String str, String str2);

        void logI(String str, String str2);

        void setCompileScriptCost(V8 v8, float f);

        void traceLog(String str);
    }

    public static String createTraceTag(String str, String str2, String str3, String str4, String str5) {
        String str6 = "[" + str + "][" + str2 + "][" + str3 + "]";
        if (!TextUtils.isEmpty(str4)) {
            str6 = str6 + "[" + str4 + "]";
        }
        if (TextUtils.isEmpty(str5)) {
            return str6;
        }
        return str6 + "[" + str5 + "]";
    }

    public static ArrayList<String> parseTraceTag(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        int i = 0;
        int iIndexOf = str.indexOf("]", 0);
        while (iIndexOf > 0) {
            arrayList.add(str.substring(i + 1, iIndexOf));
            i = iIndexOf + 1;
            iIndexOf = str.indexOf("]", i);
        }
        return arrayList;
    }

    public static void traceLog(String str, String str2) {
        ILogger iLogger = sLogger;
        if (iLogger != null) {
            iLogger.traceLog(str + ": " + str2);
        }
    }

    public static void printLog(String str) {
        String strSubstring;
        int length = str.length();
        int i = 0;
        while (i < length) {
            int i2 = i + 4000;
            if (length <= i2) {
                strSubstring = str.substring(i);
            } else {
                strSubstring = str.substring(i, i2);
            }
            System.out.println("V8Trace: " + strSubstring);
            i = i2;
        }
    }

    public static void setCompileScriptCost(V8 v8, float f) {
        ILogger iLogger = sLogger;
        if (iLogger != null) {
            iLogger.setCompileScriptCost(v8, f);
        }
    }

    public static void addCommunicationCost(V8 v8, float f) {
        ILogger iLogger = sLogger;
        if (iLogger != null) {
            iLogger.addCommunicationCost(v8, f);
        }
    }

    public static void beginSection(V8 v8, String str, String str2) {
        ILogger iLogger = sLogger;
        if (iLogger != null) {
            iLogger.beginSection(v8, str, str2);
        }
    }

    public static void endSection(V8 v8) {
        ILogger iLogger = sLogger;
        if (iLogger != null) {
            iLogger.endSection(v8);
        }
    }

    public static void setLogger(ILogger iLogger) {
        sLogger = iLogger;
    }

    public static void beginSection(String str, String str2, String str3) {
        ILogger iLogger = sLogger;
        if (iLogger != null) {
            iLogger.beginSection(str, str2, str3);
        }
    }

    public static void endSection(String str, String str2, String str3) {
        ILogger iLogger = sLogger;
        if (iLogger != null) {
            iLogger.endSection(str, str2, str3);
        }
    }

    public static void logD(String str, String str2) {
        ILogger iLogger = sLogger;
        if (iLogger != null) {
            iLogger.logD(str, str2);
        }
    }

    public static void logI(String str, String str2) {
        ILogger iLogger = sLogger;
        if (iLogger != null) {
            iLogger.logI(str, str2);
        }
    }
}
