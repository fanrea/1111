package com.kuaishou.security.kste.logic.event;

import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSTEException extends Exception {
    private int mErrorCode;

    public interface ErrorCode {
        public static final int SEC_ERROR_BC_CACHE_FILE_NOT_EXISTS = 203;
        public static final int SEC_ERROR_BC_INVOKE_FUNCTION_ERROR = 202;
        public static final int SEC_ERROR_BC_NETWORK_RESP_DECRYPT_ERROR = 206;
        public static final int SEC_ERROR_BC_NETWORK_RESP_RESULT_0 = 205;
        public static final int SEC_ERROR_BC_PROCESSBCDOWNLOAD_PER_FAIL = 207;
        public static final int SEC_ERROR_BC_UPDATE_FAILS = 200;
        public static final int SEC_ERROR_BC_UPDATE_SINGLE_FETCH_ERROR = 201;
        public static final int SEC_ERROR_BC_UPDATE_SINGLE_FETCH_EXCEPTION = 204;
        public static final int SEC_ERROR_DOWNLOADFILE_FILE_DOWNLOAD_REQ_EXCEPTION = 113;
        public static final int SEC_ERROR_DOWNLOADFILE_FILE_DOWNLOAD_REQ_FAIL = 112;
        public static final int SEC_ERROR_DOWNLOADFILE_FILE_MD5ERROR = 111;
        public static final int SEC_ERROR_DOWNLOADFILE_NETWORK_REQUESTEXCEPTION_OKHTTPEXECUTE = 213;
        public static final int SEC_ERROR_FETCHBC_NETWORK_REQUESTERROR = 109;
        public static final int SEC_ERROR_FETCHBC_NETWORK_REQUESTEXCEPTION = 114;
        public static final int SEC_ERROR_FETCHBITCODE_RESP_ERROR = 110;
        public static final int SEC_ERROR_INTERP_LOAD_DEV_LIBRARY = 105;
        public static final int SEC_ERROR_INTERP_LOAD_ERROR = 100;
        public static final int SEC_ERROR_INTERP_LOAD_OLD_LIBRARY_ERROR = 101;
        public static final int SEC_ERROR_INTERP_LOAD_RETRY_FAILURE = 212;
        public static final int SEC_ERROR_INTERP_LOAD_UPDATE_LIBRARY_ERROR = 102;
        public static final int SEC_ERROR_INTERP_NOT_FOUND_LIB_IN_HISTORY = 103;
        public static final int SEC_ERROR_INVOKE_BIZID_NOT_EXISTS = 122;
        public static final int SEC_ERROR_NOT_INITIALIZE = 121;
        public static final int SEC_ERROR_PREFORM_RETRY_INIT_EXCEPTION = 121;
        public static final int SEC_ERROR_STAERUPCONFIG_INTERP_DOWNLOAD_FAIL = 208;
        public static final int SEC_ERROR_STAERUPCONFIG_INTERP_NOT_NEED_UPDATE = 116;
        public static final int SEC_ERROR_STAERUPCONFIG_NETWORK_REQUESTERROR = 108;
        public static final int SEC_ERROR_STAERUPCONFIG_NETWORK_REQUESTEXCEPTION = 115;
        public static final int SEC_ERROR_STAERUPCONFIG_NETWORK_REQUESTEXCEPTION_OKHTTPEXECUTE = 209;
        public static final int SEC_ERROR_STAERUPCONFIG_NETWORK_RESP_DECRYPT_ERROR = 118;
        public static final int SEC_ERROR_STAERUPCONFIG_NETWORK_RESP_DOWNLOADINTERP_FAIL = 119;
        public static final int SEC_ERROR_STAERUPCONFIG_NETWORK_RESP_DOWNLOADINTERP_FILE_NOT_EXISTS = 120;
        public static final int SEC_ERROR_STAERUPCONFIG_NETWORK_RESP_RESULT_0 = 117;
        public static final int SEC_ERROR_STAERUPCONFIG_PULL_EXCEPTION = 106;
        public static final int SEC_ERROR_STAERUPCONFIG_RESP_ERROR = 107;
        public static final int SEC_ERROR_STARTUPCONFIG_EMPTY = 104;
        public static final int SEC_INVOKEFUCTION_KSTEINIT_ERROR = 210;
        public static final int SEC_NATIVE_REPORT = 999;
        public static final int SEC_PERFORMINIT_SECSDK_INIT_FAIL = 211;
    }

    public KSTEException(int i) {
        this.mErrorCode = i;
    }

    public KSTEException(String str, int i) {
        super(str);
        this.mErrorCode = i;
    }

    public KSTEException(String str, Throwable th, int i) {
        super(str, th);
        this.mErrorCode = i;
    }

    public KSTEException(String str, boolean z) throws NumberFormatException {
        super(str);
        if (z) {
            int i = 10006;
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
            }
            this.mErrorCode = i;
        }
    }

    public KSTEException(Throwable th, int i) {
        super(th);
        this.mErrorCode = i;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        printStream.println("errorno = " + getErrorCode());
        super.printStackTrace(printStream);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        printWriter.println("errorno = " + getErrorCode());
        super.printStackTrace(printWriter);
    }

    public void setErrorCode(int i) {
        this.mErrorCode = i;
    }
}
