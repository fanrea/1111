package com.kwai.middleware.azeroth.function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class Function<T, R> {
    public abstract R apply(T t);

    public static <T> Function<T, T> identity() {
        return new Function<T, T>() { // from class: com.kwai.middleware.azeroth.function.Function.1
            @Override // com.kwai.middleware.azeroth.function.Function
            public final T apply(T t) {
                return t;
            }
        };
    }

    public <V> Function<V, R> compose(final Function<? super V, ? extends T> function) {
        if (function == null) {
            throw new NullPointerException();
        }
        return new Function<V, R>() { // from class: com.kwai.middleware.azeroth.function.Function.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwai.middleware.azeroth.function.Function
            public R apply(V v) {
                return (R) Function.this.apply(function.apply(v));
            }
        };
    }

    public <V> Function<T, V> andThen(final Function<? super R, ? extends V> function) {
        if (function == null) {
            throw new NullPointerException();
        }
        return new Function<T, V>() { // from class: com.kwai.middleware.azeroth.function.Function.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwai.middleware.azeroth.function.Function
            public V apply(T t) {
                return (V) function.apply(Function.this.apply(t));
            }
        };
    }
}
