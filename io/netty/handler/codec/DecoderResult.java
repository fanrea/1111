package io.netty.handler.codec;

import com.alipay.sdk.m.f0.c;
import io.netty.util.Signal;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class DecoderResult {
    private final Throwable cause;
    protected static final Signal SIGNAL_UNFINISHED = Signal.valueOf(DecoderResult.class, "UNFINISHED");
    protected static final Signal SIGNAL_SUCCESS = Signal.valueOf(DecoderResult.class, c.p);
    public static final DecoderResult UNFINISHED = new DecoderResult(SIGNAL_UNFINISHED);
    public static final DecoderResult SUCCESS = new DecoderResult(SIGNAL_SUCCESS);

    public static DecoderResult failure(Throwable th) {
        if (th == null) {
            throw new NullPointerException("cause");
        }
        return new DecoderResult(th);
    }

    protected DecoderResult(Throwable th) {
        if (th == null) {
            throw new NullPointerException("cause");
        }
        this.cause = th;
    }

    public boolean isFinished() {
        return this.cause != SIGNAL_UNFINISHED;
    }

    public boolean isSuccess() {
        return this.cause == SIGNAL_SUCCESS;
    }

    public boolean isFailure() {
        Throwable th = this.cause;
        return (th == SIGNAL_SUCCESS || th == SIGNAL_UNFINISHED) ? false : true;
    }

    public Throwable cause() {
        if (isFailure()) {
            return this.cause;
        }
        return null;
    }

    public String toString() {
        if (!isFinished()) {
            return "unfinished";
        }
        if (isSuccess()) {
            return "success";
        }
        String string = cause().toString();
        StringBuilder sb = new StringBuilder(string.length() + 17);
        sb.append("failure(");
        sb.append(string);
        sb.append(')');
        return sb.toString();
    }
}
