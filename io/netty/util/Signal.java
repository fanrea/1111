package io.netty.util;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class Signal extends Error implements Constant<Signal> {
    private static final ConstantPool<Signal> pool = new ConstantPool<Signal>() { // from class: io.netty.util.Signal.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.ConstantPool
        public final Signal newConstant(int i, String str) {
            return new Signal(i, str);
        }
    };
    private static final long serialVersionUID = -221145131122459977L;
    private final SignalConstant constant;

    public final boolean equals(Object obj) {
        return this == obj;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        return this;
    }

    @Override // java.lang.Throwable
    public final Throwable initCause(Throwable th) {
        return this;
    }

    public static Signal valueOf(String str) {
        return (Signal) pool.valueOf(str);
    }

    public static Signal valueOf(Class<?> cls, String str) {
        return (Signal) pool.valueOf(cls, str);
    }

    private Signal(int i, String str) {
        this.constant = new SignalConstant(i, str);
    }

    public final void expect(Signal signal) {
        if (this == signal) {
            return;
        }
        throw new IllegalStateException("unexpected signal: " + signal);
    }

    @Override // io.netty.util.Constant
    public final int id() {
        return this.constant.id();
    }

    @Override // io.netty.util.Constant
    public final String name() {
        return this.constant.name();
    }

    public final int hashCode() {
        return System.identityHashCode(this);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Signal signal) {
        if (this == signal) {
            return 0;
        }
        return this.constant.compareTo(signal.constant);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return name();
    }

    static final class SignalConstant extends AbstractConstant<SignalConstant> {
        SignalConstant(int i, String str) {
            super(i, str);
        }
    }
}
