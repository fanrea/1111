package com.yxcorp.livestream.longconnection;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.kuaishou.common.netty.function.FunctionWithThrowable;
import io.reactivex.functions.Function;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class MessageNanoParser<T extends MessageNano> implements FunctionWithThrowable<byte[], T, InvalidProtocolBufferNanoException>, Function<byte[], T> {
    private Class<T> mClazz;
    private Method mParseFromMethod = null;

    public MessageNanoParser(Class<T> cls) {
        this.mClazz = cls;
    }

    @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
    public T apply(byte[] bArr) {
        try {
            if (this.mParseFromMethod == null) {
                this.mParseFromMethod = this.mClazz.getDeclaredMethod("parseFrom", byte[].class);
            }
            return (T) this.mParseFromMethod.invoke(null, bArr);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            throw new RuntimeException(e3);
        }
    }
}
