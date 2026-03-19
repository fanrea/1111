package io.netty.handler.codec.serialization;

import java.io.EOFException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.StreamCorruptedException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
class CompactObjectInputStream extends ObjectInputStream {
    private final ClassResolver classResolver;

    CompactObjectInputStream(InputStream inputStream, ClassResolver classResolver) {
        super(inputStream);
        this.classResolver = classResolver;
    }

    @Override // java.io.ObjectInputStream
    protected void readStreamHeader() throws StreamCorruptedException {
        int i = readByte() & 255;
        if (i == 5) {
            return;
        }
        throw new StreamCorruptedException("Unsupported version: " + i);
    }

    @Override // java.io.ObjectInputStream
    protected ObjectStreamClass readClassDescriptor() throws StreamCorruptedException, EOFException {
        int i = read();
        if (i < 0) {
            throw new EOFException();
        }
        if (i == 0) {
            return super.readClassDescriptor();
        }
        if (i == 1) {
            return ObjectStreamClass.lookupAny(this.classResolver.resolve(readUTF()));
        }
        throw new StreamCorruptedException("Unexpected class descriptor type: " + i);
    }

    @Override // java.io.ObjectInputStream
    protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) {
        try {
            return this.classResolver.resolve(objectStreamClass.getName());
        } catch (ClassNotFoundException unused) {
            return super.resolveClass(objectStreamClass);
        }
    }
}
