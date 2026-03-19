package org.aspectj.lang;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class NoAspectBoundException extends RuntimeException {
    public Throwable cause;

    public NoAspectBoundException() {
    }

    public NoAspectBoundException(String str, Throwable th) {
        super(th != null ? new StringBuffer().append("Exception while initializing ").append(str).append(": ").append(th).toString() : str);
        this.cause = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
