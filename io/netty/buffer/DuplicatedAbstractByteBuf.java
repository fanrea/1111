package io.netty.buffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class DuplicatedAbstractByteBuf extends DuplicatedByteBuf {
    public DuplicatedAbstractByteBuf(AbstractByteBuf abstractByteBuf) {
        super(abstractByteBuf);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    protected final byte _getByte(int i) {
        return unwrap0()._getByte(i);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    protected final short _getShort(int i) {
        return unwrap0()._getShort(i);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    protected final int _getUnsignedMedium(int i) {
        return unwrap0()._getUnsignedMedium(i);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    protected final int _getInt(int i) {
        return unwrap0()._getInt(i);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    protected final long _getLong(int i) {
        return unwrap0()._getLong(i);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    protected final void _setByte(int i, int i2) {
        unwrap0()._setByte(i, i2);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    protected final void _setShort(int i, int i2) {
        unwrap0()._setShort(i, i2);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    protected final void _setMedium(int i, int i2) {
        unwrap0()._setMedium(i, i2);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    protected final void _setInt(int i, int i2) {
        unwrap0()._setInt(i, i2);
    }

    @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf
    protected final void _setLong(int i, long j) {
        unwrap0()._setLong(i, j);
    }

    private AbstractByteBuf unwrap0() {
        return (AbstractByteBuf) unwrap();
    }
}
