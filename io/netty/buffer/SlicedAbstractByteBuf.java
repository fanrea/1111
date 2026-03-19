package io.netty.buffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class SlicedAbstractByteBuf extends SlicedByteBuf {
    SlicedAbstractByteBuf(AbstractByteBuf abstractByteBuf, int i, int i2) {
        super(abstractByteBuf, i, i2);
    }

    @Override // io.netty.buffer.SlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected final byte _getByte(int i) {
        return unwrap0()._getByte(idx(i));
    }

    @Override // io.netty.buffer.SlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected final short _getShort(int i) {
        return unwrap0()._getShort(idx(i));
    }

    @Override // io.netty.buffer.SlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected final int _getUnsignedMedium(int i) {
        return unwrap0()._getUnsignedMedium(idx(i));
    }

    @Override // io.netty.buffer.SlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected final int _getInt(int i) {
        return unwrap0()._getInt(idx(i));
    }

    @Override // io.netty.buffer.SlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected final long _getLong(int i) {
        return unwrap0()._getLong(idx(i));
    }

    @Override // io.netty.buffer.SlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected final void _setByte(int i, int i2) {
        unwrap0()._setByte(idx(i), i2);
    }

    @Override // io.netty.buffer.SlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected final void _setShort(int i, int i2) {
        unwrap0()._setShort(idx(i), i2);
    }

    @Override // io.netty.buffer.SlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected final void _setMedium(int i, int i2) {
        unwrap0()._setMedium(idx(i), i2);
    }

    @Override // io.netty.buffer.SlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected final void _setInt(int i, int i2) {
        unwrap0()._setInt(idx(i), i2);
    }

    @Override // io.netty.buffer.SlicedByteBuf, io.netty.buffer.AbstractByteBuf
    protected final void _setLong(int i, long j) {
        unwrap0()._setLong(idx(i), j);
    }

    private AbstractByteBuf unwrap0() {
        return (AbstractByteBuf) unwrap();
    }
}
