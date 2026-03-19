package com.kuaishou.tk.api.exception;

import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public abstract class TKJSException extends RuntimeException {
    private static final int MAX_SOURCE_LINE_LENGTH = 350;
    private final int endColumn;
    private final String fileName;
    private final String jsMessage;
    private final String jsStackTrace;
    private final int lineNumber;
    private final String sourceLine;
    private final int startColumn;

    public TKJSException(String str, int i, String str2, String str3, int i2, int i3, String str4, Throwable th) {
        this.fileName = str;
        this.lineNumber = i;
        this.jsMessage = str2;
        this.sourceLine = str3;
        this.startColumn = i2;
        this.endColumn = i3;
        this.jsStackTrace = str4;
        if (th != null) {
            initCause(th);
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        return createMessageLine() + createMessageDetails() + createJSStackDetails() + "\n" + getClass().getName();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return createMessageLine();
    }

    private String createMessageLine() {
        return this.jsMessage + "\n" + this.fileName + ":" + this.lineNumber + ":" + (this.startColumn + 1);
    }

    private String createJSStackDetails() {
        if (this.jsStackTrace == null) {
            return "";
        }
        return "\n" + this.jsStackTrace;
    }

    private String createMessageDetails() {
        StringBuilder sb = new StringBuilder();
        String str = this.sourceLine;
        if (str != null && !str.isEmpty() && this.sourceLine.length() <= 350) {
            sb.append('\n');
            sb.append(this.sourceLine);
            sb.append('\n');
            int i = this.startColumn;
            if (i >= 0) {
                sb.append(createCharSequence(i, ' '));
                sb.append(createCharSequence(this.endColumn - this.startColumn, '^'));
            }
        }
        return sb.toString();
    }

    private char[] createCharSequence(int i, char c) {
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = c;
        }
        return cArr;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getJsMessage() {
        return this.jsMessage;
    }

    public String getJsStackTrace() {
        return this.jsStackTrace;
    }

    public List<String> getStackTraceList() {
        ArrayList arrayList = new ArrayList();
        StackTraceElement[] stackTrace = getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                arrayList.add(stackTraceElement.toString());
            }
        }
        return arrayList;
    }
}
