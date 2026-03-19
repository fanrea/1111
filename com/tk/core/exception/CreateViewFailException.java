package com.tk.core.exception;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class CreateViewFailException extends RuntimeException {
    public static final int NOT_TK_VIEW = 2;
    public static final int NO_VIEW_KEY = 0;
    public static final int VIEW_IS_NULL = 1;
    private int mErrorType;

    public CreateViewFailException(int i, String str) {
        super(getErrorMsg(i, str));
        this.mErrorType = i;
    }

    private static String getErrorMsg(int i, String str) {
        if (i == 0) {
            return "找不到对应 key: " + str + " 的 view";
        }
        if (i == 1) {
            return "对应 key: " + str + " 的构建返回了 null";
        }
        if (i != 2) {
            return "create view fail";
        }
        return "对应 key: " + str + " 的构建返回了非 view 类型";
    }

    public int getErrorType() {
        return this.mErrorType;
    }
}
