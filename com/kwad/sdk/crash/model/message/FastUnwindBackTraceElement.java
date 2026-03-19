package com.kwad.sdk.crash.model.message;

import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class FastUnwindBackTraceElement implements Serializable {
    private static final long serialVersionUID = -6763898640806477065L;
    public String costInfo;
    public String formatString;
    public long lastUpdateTime;
    public String tag;
    public String threadInfo;
    public int unwindFailReason;
    public long updateTime;
    public String declaringClass = "";
    public String methodName = "";
    public String fileName = "";
    public int lineNumber = 0;
    public String artMethod = "";
    public String pc = "";
    public String buildId = "";
    public boolean isNative = false;
    public boolean isIgnore = false;
    public boolean hasUnwind = true;

    public static FastUnwindBackTraceElement obtainFastUnwindBackTraceElement(Object obj) {
        FastUnwindBackTraceElement fastUnwindBackTraceElement = new FastUnwindBackTraceElement("");
        if (obj instanceof FastUnwindBackTraceElement) {
            fastUnwindBackTraceElement.updateTraceInfo((FastUnwindBackTraceElement) obj);
        } else if (obj instanceof StackTraceElement) {
            fastUnwindBackTraceElement.updateTraceInfo((StackTraceElement) obj);
        }
        return fastUnwindBackTraceElement;
    }

    public FastUnwindBackTraceElement(String str) {
        this.formatString = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.hasUnwind) {
            return (this.isNative ? new StringBuilder("native:") : new StringBuilder().append(this.artMethod).append(":")).append(this.pc).toString();
        }
        String str = this.formatString;
        if (str != null && !str.isEmpty()) {
            return this.formatString;
        }
        sb.append(this.declaringClass).append(".").append(this.methodName);
        int i = this.lineNumber;
        if (i == -2) {
            sb.append("(Native Method)");
        } else if (this.fileName != null) {
            if (i >= 0) {
                sb.append("(").append(this.fileName).append(":").append(this.lineNumber).append(")");
            } else {
                sb.append("(").append(this.fileName).append(")");
            }
        } else if (i >= 0) {
            sb.append("(Unknown Source:").append(this.lineNumber).append(")");
        } else {
            sb.append("(Unknown Source)");
        }
        return sb.toString();
    }

    public final String toTraceString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.updateTime).append(this.tag);
        String str = this.formatString;
        if (str != null && !str.isEmpty()) {
            sb.append(this.formatString).append(this.threadInfo).append(this.costInfo);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.declaringClass).append(".").append(this.methodName);
        int i = this.lineNumber;
        if (i == -2) {
            sb2.append("(Native Method)");
        } else if (this.fileName != null) {
            if (i >= 0) {
                sb2.append("(").append(this.fileName).append(":").append(this.lineNumber).append(")");
            } else {
                sb2.append("(").append(this.fileName).append(")");
            }
        } else if (i >= 0) {
            sb2.append("(Unknown Source:").append(this.lineNumber).append(")");
        } else {
            sb2.append("(Unknown Source)");
        }
        this.formatString = sb2.toString();
        sb.append((CharSequence) sb2);
        sb.append(this.threadInfo).append(this.costInfo);
        return sb.toString();
    }

    public final void updateTraceInfo(FastUnwindBackTraceElement fastUnwindBackTraceElement) {
        this.artMethod = fastUnwindBackTraceElement.artMethod;
        this.pc = fastUnwindBackTraceElement.pc;
        this.declaringClass = fastUnwindBackTraceElement.declaringClass;
        this.methodName = fastUnwindBackTraceElement.methodName;
        this.fileName = fastUnwindBackTraceElement.fileName;
        this.lineNumber = fastUnwindBackTraceElement.lineNumber;
        this.formatString = fastUnwindBackTraceElement.formatString;
        this.buildId = fastUnwindBackTraceElement.buildId;
        this.isNative = fastUnwindBackTraceElement.isNative;
        this.hasUnwind = fastUnwindBackTraceElement.hasUnwind;
        this.isIgnore = fastUnwindBackTraceElement.isIgnore;
        this.unwindFailReason = fastUnwindBackTraceElement.unwindFailReason;
    }

    public final void updateTraceInfo(StackTraceElement stackTraceElement) {
        this.declaringClass = stackTraceElement.getClassName();
        this.methodName = stackTraceElement.getMethodName();
        this.fileName = stackTraceElement.getFileName();
        this.lineNumber = stackTraceElement.getLineNumber();
        this.hasUnwind = true;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FastUnwindBackTraceElement)) {
            return false;
        }
        FastUnwindBackTraceElement fastUnwindBackTraceElement = (FastUnwindBackTraceElement) obj;
        if (this.isNative) {
            return fastUnwindBackTraceElement.pc.equals(this.pc);
        }
        String str = fastUnwindBackTraceElement.artMethod;
        return str != null && str.equals(this.artMethod) && fastUnwindBackTraceElement.pc.equals(this.pc);
    }

    public final int hashCode() {
        if (this.isNative) {
            return this.pc.hashCode();
        }
        return (this.artMethod.hashCode() * 31) + this.pc.hashCode();
    }

    public final boolean isEmpty() {
        if (this.isNative) {
            String str = this.pc;
            return str == null || str.isEmpty() || this.pc.equals("0");
        }
        String str2 = this.artMethod;
        return str2 == null || str2.isEmpty() || this.artMethod.equals("0");
    }
}
