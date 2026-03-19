package io.netty.buffer;

import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.C00oOOo;
import io.netty.util.internal.EmptyArrays;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class CompositeByteBuf extends AbstractReferenceCountedByteBuf implements Iterable<ByteBuf> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ByteBufAllocator alloc;
    private final List<Component> components;
    private final boolean direct;
    private boolean freed;
    private final int maxNumComponents;
    private static final ByteBuffer EMPTY_NIO_BUFFER = Unpooled.EMPTY_BUFFER.nioBuffer();
    private static final Iterator<ByteBuf> EMPTY_ITERATOR = Collections.emptyList().iterator();

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public CompositeByteBuf touch() {
        return this;
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public CompositeByteBuf touch(Object obj) {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return null;
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z, int i) {
        super(Integer.MAX_VALUE);
        if (byteBufAllocator == null) {
            throw new NullPointerException("alloc");
        }
        this.alloc = byteBufAllocator;
        this.direct = z;
        this.maxNumComponents = i;
        this.components = newList(i);
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z, int i, ByteBuf... byteBufArr) {
        super(Integer.MAX_VALUE);
        if (byteBufAllocator == null) {
            throw new NullPointerException("alloc");
        }
        if (i < 2) {
            throw new IllegalArgumentException("maxNumComponents: " + i + " (expected: >= 2)");
        }
        this.alloc = byteBufAllocator;
        this.direct = z;
        this.maxNumComponents = i;
        this.components = newList(i);
        addComponents0(0, byteBufArr);
        consolidateIfNeeded();
        setIndex(0, capacity());
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z, int i, Iterable<ByteBuf> iterable) {
        super(Integer.MAX_VALUE);
        if (byteBufAllocator == null) {
            throw new NullPointerException("alloc");
        }
        if (i < 2) {
            throw new IllegalArgumentException("maxNumComponents: " + i + " (expected: >= 2)");
        }
        this.alloc = byteBufAllocator;
        this.direct = z;
        this.maxNumComponents = i;
        this.components = newList(i);
        addComponents0(0, iterable);
        consolidateIfNeeded();
        setIndex(0, capacity());
    }

    private static List<Component> newList(int i) {
        return new ArrayList(Math.min(16, i));
    }

    CompositeByteBuf(ByteBufAllocator byteBufAllocator) {
        super(Integer.MAX_VALUE);
        this.alloc = byteBufAllocator;
        this.direct = false;
        this.maxNumComponents = 0;
        this.components = Collections.emptyList();
    }

    public CompositeByteBuf addComponent(ByteBuf byteBuf) {
        addComponent0(this.components.size(), byteBuf);
        consolidateIfNeeded();
        return this;
    }

    public CompositeByteBuf addComponents(ByteBuf... byteBufArr) {
        addComponents0(this.components.size(), byteBufArr);
        consolidateIfNeeded();
        return this;
    }

    public CompositeByteBuf addComponents(Iterable<ByteBuf> iterable) {
        addComponents0(this.components.size(), iterable);
        consolidateIfNeeded();
        return this;
    }

    public CompositeByteBuf addComponent(int i, ByteBuf byteBuf) {
        addComponent0(i, byteBuf);
        consolidateIfNeeded();
        return this;
    }

    private int addComponent0(int i, ByteBuf byteBuf) {
        checkComponentIndex(i);
        if (byteBuf == null) {
            throw new NullPointerException("buffer");
        }
        int i2 = byteBuf.readableBytes();
        Component component = new Component(byteBuf.order(ByteOrder.BIG_ENDIAN).slice());
        if (i == this.components.size()) {
            this.components.add(component);
            if (i == 0) {
                component.endOffset = i2;
            } else {
                component.offset = this.components.get(i - 1).endOffset;
                component.endOffset = component.offset + i2;
            }
        } else {
            this.components.add(i, component);
            if (i2 != 0) {
                updateComponentOffsets(i);
            }
        }
        return i;
    }

    public CompositeByteBuf addComponents(int i, ByteBuf... byteBufArr) {
        addComponents0(i, byteBufArr);
        consolidateIfNeeded();
        return this;
    }

    private int addComponents0(int i, ByteBuf... byteBufArr) {
        checkComponentIndex(i);
        if (byteBufArr == null) {
            throw new NullPointerException("buffers");
        }
        for (ByteBuf byteBuf : byteBufArr) {
            if (byteBuf == null) {
                break;
            }
            i = addComponent0(i, byteBuf) + 1;
            int size = this.components.size();
            if (i > size) {
                i = size;
            }
        }
        return i;
    }

    public CompositeByteBuf addComponents(int i, Iterable<ByteBuf> iterable) {
        addComponents0(i, iterable);
        consolidateIfNeeded();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int addComponents0(int i, Iterable<ByteBuf> iterable) {
        if (iterable == 0) {
            throw new NullPointerException("buffers");
        }
        if (iterable instanceof ByteBuf) {
            return addComponent0(i, (ByteBuf) iterable);
        }
        boolean z = iterable instanceof Collection;
        ArrayList arrayList = iterable;
        if (!z) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList2.add((ByteBuf) it.next());
            }
            arrayList = arrayList2;
        }
        ArrayList arrayList3 = arrayList;
        return addComponents0(i, (ByteBuf[]) arrayList3.toArray(new ByteBuf[arrayList3.size()]));
    }

    private void consolidateIfNeeded() {
        int size = this.components.size();
        if (size > this.maxNumComponents) {
            ByteBuf byteBufAllocBuffer = allocBuffer(this.components.get(size - 1).endOffset);
            for (int i = 0; i < size; i++) {
                Component component = this.components.get(i);
                byteBufAllocBuffer.writeBytes(component.buf);
                component.freeIfNecessary();
            }
            Component component2 = new Component(byteBufAllocBuffer);
            component2.endOffset = component2.length;
            this.components.clear();
            this.components.add(component2);
        }
    }

    private void checkComponentIndex(int i) {
        ensureAccessible();
        if (i < 0 || i > this.components.size()) {
            throw new IndexOutOfBoundsException(String.format("cIndex: %d (expected: >= 0 && <= numComponents(%d))", Integer.valueOf(i), Integer.valueOf(this.components.size())));
        }
    }

    private void checkComponentIndex(int i, int i2) {
        ensureAccessible();
        if (i < 0 || i + i2 > this.components.size()) {
            throw new IndexOutOfBoundsException(String.format("cIndex: %d, numComponents: %d (expected: cIndex >= 0 && cIndex + numComponents <= totalNumComponents(%d))", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.components.size())));
        }
    }

    private void updateComponentOffsets(int i) {
        int size = this.components.size();
        if (size <= i) {
            return;
        }
        Component component = this.components.get(i);
        if (i == 0) {
            component.offset = 0;
            component.endOffset = component.length;
            i++;
        }
        while (i < size) {
            Component component2 = this.components.get(i - 1);
            Component component3 = this.components.get(i);
            component3.offset = component2.endOffset;
            component3.endOffset = component3.offset + component3.length;
            i++;
        }
    }

    public CompositeByteBuf removeComponent(int i) {
        checkComponentIndex(i);
        Component componentRemove = this.components.remove(i);
        componentRemove.freeIfNecessary();
        if (componentRemove.length > 0) {
            updateComponentOffsets(i);
        }
        return this;
    }

    public CompositeByteBuf removeComponents(int i, int i2) {
        checkComponentIndex(i, i2);
        if (i2 == 0) {
            return this;
        }
        List<Component> listSubList = this.components.subList(i, i2 + i);
        boolean z = false;
        for (Component component : listSubList) {
            if (component.length > 0) {
                z = true;
            }
            component.freeIfNecessary();
        }
        listSubList.clear();
        if (z) {
            updateComponentOffsets(i);
        }
        return this;
    }

    public Iterator<ByteBuf> iterator() {
        ensureAccessible();
        if (this.components.isEmpty()) {
            return EMPTY_ITERATOR;
        }
        return new CompositeByteBufIterator();
    }

    public List<ByteBuf> decompose(int i, int i2) {
        checkIndex(i, i2);
        if (i2 == 0) {
            return Collections.emptyList();
        }
        int componentIndex = toComponentIndex(i);
        ArrayList arrayList = new ArrayList(this.components.size());
        Component component = this.components.get(componentIndex);
        ByteBuf byteBufDuplicate = component.buf.duplicate();
        byteBufDuplicate.readerIndex(i - component.offset);
        while (true) {
            int i3 = byteBufDuplicate.readableBytes();
            if (i2 <= i3) {
                byteBufDuplicate.writerIndex(byteBufDuplicate.readerIndex() + i2);
                arrayList.add(byteBufDuplicate);
                break;
            }
            arrayList.add(byteBufDuplicate);
            i2 -= i3;
            componentIndex++;
            byteBufDuplicate = this.components.get(componentIndex).buf.duplicate();
            if (i2 <= 0) {
                break;
            }
        }
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            arrayList.set(i4, ((ByteBuf) arrayList.get(i4)).slice());
        }
        return arrayList;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        int size = this.components.size();
        if (size == 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!this.components.get(i).buf.isDirect()) {
                return false;
            }
        }
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        int size = this.components.size();
        if (size == 0) {
            return true;
        }
        if (size != 1) {
            return false;
        }
        return this.components.get(0).buf.hasArray();
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        int size = this.components.size();
        if (size == 0) {
            return EmptyArrays.EMPTY_BYTES;
        }
        if (size == 1) {
            return this.components.get(0).buf.array();
        }
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        int size = this.components.size();
        if (size == 0) {
            return 0;
        }
        if (size == 1) {
            return this.components.get(0).buf.arrayOffset();
        }
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        int size = this.components.size();
        if (size == 0) {
            return Unpooled.EMPTY_BUFFER.hasMemoryAddress();
        }
        if (size != 1) {
            return false;
        }
        return this.components.get(0).buf.hasMemoryAddress();
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        int size = this.components.size();
        if (size == 0) {
            return Unpooled.EMPTY_BUFFER.memoryAddress();
        }
        if (size == 1) {
            return this.components.get(0).buf.memoryAddress();
        }
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        int size = this.components.size();
        if (size == 0) {
            return 0;
        }
        return this.components.get(size - 1).endOffset;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf capacity(int i) {
        ensureAccessible();
        if (i < 0 || i > maxCapacity()) {
            throw new IllegalArgumentException("newCapacity: " + i);
        }
        int iCapacity = capacity();
        if (i > iCapacity) {
            int i2 = i - iCapacity;
            if (this.components.size() < this.maxNumComponents) {
                ByteBuf byteBufAllocBuffer = allocBuffer(i2);
                byteBufAllocBuffer.setIndex(0, i2);
                addComponent0(this.components.size(), byteBufAllocBuffer);
            } else {
                ByteBuf byteBufAllocBuffer2 = allocBuffer(i2);
                byteBufAllocBuffer2.setIndex(0, i2);
                addComponent0(this.components.size(), byteBufAllocBuffer2);
                consolidateIfNeeded();
            }
        } else if (i < iCapacity) {
            int i3 = iCapacity - i;
            List<Component> list = this.components;
            ListIterator<Component> listIterator = list.listIterator(list.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    break;
                }
                Component componentPrevious = listIterator.previous();
                if (i3 >= componentPrevious.length) {
                    i3 -= componentPrevious.length;
                    listIterator.remove();
                } else {
                    Component component = new Component(componentPrevious.buf.slice(0, componentPrevious.length - i3));
                    component.offset = componentPrevious.offset;
                    component.endOffset = component.offset + component.length;
                    listIterator.set(component);
                    break;
                }
            }
            if (readerIndex() > i) {
                setIndex(i, i);
            } else if (writerIndex() > i) {
                writerIndex(i);
            }
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.alloc;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
    }

    public int numComponents() {
        return this.components.size();
    }

    public int maxNumComponents() {
        return this.maxNumComponents;
    }

    public int toComponentIndex(int i) {
        checkIndex(i);
        int size = this.components.size();
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            Component component = this.components.get(i3);
            if (i >= component.endOffset) {
                i2 = i3 + 1;
            } else {
                if (i >= component.offset) {
                    return i3;
                }
                size = i3 - 1;
            }
        }
        throw new Error("should not reach here");
    }

    public int toByteIndex(int i) {
        checkComponentIndex(i);
        return this.components.get(i).offset;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i) {
        return _getByte(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i) {
        Component componentFindComponent = findComponent(i);
        return componentFindComponent.buf.getByte(i - componentFindComponent.offset);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i) {
        Component componentFindComponent = findComponent(i);
        if (i + 2 <= componentFindComponent.endOffset) {
            return componentFindComponent.buf.getShort(i - componentFindComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (short) ((_getByte(i + 1) & 255) | ((_getByte(i) & 255) << 8));
        }
        return (short) (((_getByte(i + 1) & 255) << 8) | (_getByte(i) & 255));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int i) {
        Component componentFindComponent = findComponent(i);
        if (i + 2 <= componentFindComponent.endOffset) {
            return componentFindComponent.buf.getShortLE(i - componentFindComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (short) (((_getByte(i + 1) & 255) << 8) | (_getByte(i) & 255));
        }
        return (short) ((_getByte(i + 1) & 255) | ((_getByte(i) & 255) << 8));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMedium(int i) {
        Component componentFindComponent = findComponent(i);
        if (i + 3 <= componentFindComponent.endOffset) {
            return componentFindComponent.buf.getUnsignedMedium(i - componentFindComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (_getByte(i + 2) & 255) | ((_getShort(i) & 65535) << 8);
        }
        return ((_getByte(i + 2) & 255) << 16) | (_getShort(i) & 65535);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMediumLE(int i) {
        Component componentFindComponent = findComponent(i);
        if (i + 3 <= componentFindComponent.endOffset) {
            return componentFindComponent.buf.getUnsignedMediumLE(i - componentFindComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((_getByte(i + 2) & 255) << 16) | (_getShortLE(i) & 65535);
        }
        return (_getByte(i + 2) & 255) | ((_getShortLE(i) & 65535) << 8);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i) {
        Component componentFindComponent = findComponent(i);
        if (i + 4 <= componentFindComponent.endOffset) {
            return componentFindComponent.buf.getInt(i - componentFindComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (_getShort(i + 2) & 65535) | ((_getShort(i) & 65535) << 16);
        }
        return ((_getShort(i + 2) & 65535) << 16) | (_getShort(i) & 65535);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int i) {
        Component componentFindComponent = findComponent(i);
        if (i + 4 <= componentFindComponent.endOffset) {
            return componentFindComponent.buf.getIntLE(i - componentFindComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((_getShortLE(i + 2) & 65535) << 16) | (_getShortLE(i) & 65535);
        }
        return (_getShortLE(i + 2) & 65535) | ((_getShortLE(i) & 65535) << 16);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i) {
        Component componentFindComponent = findComponent(i);
        if (i + 8 <= componentFindComponent.endOffset) {
            return componentFindComponent.buf.getLong(i - componentFindComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((_getInt(i) & C00oOOo.f362O8oO888) << 32) | (C00oOOo.f362O8oO888 & _getInt(i + 4));
        }
        return (_getInt(i) & C00oOOo.f362O8oO888) | ((C00oOOo.f362O8oO888 & _getInt(i + 4)) << 32);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLongLE(int i) {
        Component componentFindComponent = findComponent(i);
        if (i + 8 <= componentFindComponent.endOffset) {
            return componentFindComponent.buf.getLongLE(i - componentFindComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (_getIntLE(i) & C00oOOo.f362O8oO888) | ((C00oOOo.f362O8oO888 & _getIntLE(i + 4)) << 32);
        }
        return ((_getIntLE(i) & C00oOOo.f362O8oO888) << 32) | (C00oOOo.f362O8oO888 & _getIntLE(i + 4));
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i, byte[] bArr, int i2, int i3) {
        checkDstIndex(i, i3, i2, bArr.length);
        if (i3 == 0) {
            return this;
        }
        int componentIndex = toComponentIndex(i);
        while (i3 > 0) {
            Component component = this.components.get(componentIndex);
            ByteBuf byteBuf = component.buf;
            int i4 = i - component.offset;
            int iMin = Math.min(i3, byteBuf.capacity() - i4);
            byteBuf.getBytes(i4, bArr, i2, iMin);
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            componentIndex++;
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i, ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iRemaining = byteBuffer.remaining();
        checkIndex(i, iRemaining);
        if (iRemaining == 0) {
            return this;
        }
        int componentIndex = toComponentIndex(i);
        while (iRemaining > 0) {
            try {
                Component component = this.components.get(componentIndex);
                ByteBuf byteBuf = component.buf;
                int i2 = i - component.offset;
                int iMin = Math.min(iRemaining, byteBuf.capacity() - i2);
                byteBuffer.limit(byteBuffer.position() + iMin);
                byteBuf.getBytes(i2, byteBuffer);
                i += iMin;
                iRemaining -= iMin;
                componentIndex++;
            } finally {
                byteBuffer.limit(iLimit);
            }
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        checkDstIndex(i, i3, i2, byteBuf.capacity());
        if (i3 == 0) {
            return this;
        }
        int componentIndex = toComponentIndex(i);
        while (i3 > 0) {
            Component component = this.components.get(componentIndex);
            ByteBuf byteBuf2 = component.buf;
            int i4 = i - component.offset;
            int iMin = Math.min(i3, byteBuf2.capacity() - i4);
            byteBuf2.getBytes(i4, byteBuf, i2, iMin);
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            componentIndex++;
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2) throws IOException {
        if (nioBufferCount() == 1) {
            return gatheringByteChannel.write(internalNioBuffer(i, i2));
        }
        long jWrite = gatheringByteChannel.write(nioBuffers(i, i2));
        if (jWrite > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) jWrite;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i, OutputStream outputStream, int i2) {
        checkIndex(i, i2);
        if (i2 == 0) {
            return this;
        }
        int componentIndex = toComponentIndex(i);
        while (i2 > 0) {
            Component component = this.components.get(componentIndex);
            ByteBuf byteBuf = component.buf;
            int i3 = i - component.offset;
            int iMin = Math.min(i2, byteBuf.capacity() - i3);
            byteBuf.getBytes(i3, outputStream, iMin);
            i += iMin;
            i2 -= iMin;
            componentIndex++;
        }
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setByte(int i, int i2) {
        Component componentFindComponent = findComponent(i);
        componentFindComponent.buf.setByte(i - componentFindComponent.offset, i2);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setByte(int i, int i2) {
        setByte(i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setShort(int i, int i2) {
        return (CompositeByteBuf) super.setShort(i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShort(int i, int i2) {
        Component componentFindComponent = findComponent(i);
        if (i + 2 <= componentFindComponent.endOffset) {
            componentFindComponent.buf.setShort(i - componentFindComponent.offset, i2);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setByte(i, (byte) (i2 >>> 8));
            _setByte(i + 1, (byte) i2);
        } else {
            _setByte(i, (byte) i2);
            _setByte(i + 1, (byte) (i2 >>> 8));
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShortLE(int i, int i2) {
        Component componentFindComponent = findComponent(i);
        if (i + 2 <= componentFindComponent.endOffset) {
            componentFindComponent.buf.setShortLE(i - componentFindComponent.offset, i2);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setByte(i, (byte) i2);
            _setByte(i + 1, (byte) (i2 >>> 8));
        } else {
            _setByte(i, (byte) (i2 >>> 8));
            _setByte(i + 1, (byte) i2);
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setMedium(int i, int i2) {
        return (CompositeByteBuf) super.setMedium(i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int i, int i2) {
        Component componentFindComponent = findComponent(i);
        if (i + 3 <= componentFindComponent.endOffset) {
            componentFindComponent.buf.setMedium(i - componentFindComponent.offset, i2);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setShort(i, (short) (i2 >> 8));
            _setByte(i + 2, (byte) i2);
        } else {
            _setShort(i, (short) i2);
            _setByte(i + 2, (byte) (i2 >>> 16));
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMediumLE(int i, int i2) {
        Component componentFindComponent = findComponent(i);
        if (i + 3 <= componentFindComponent.endOffset) {
            componentFindComponent.buf.setMediumLE(i - componentFindComponent.offset, i2);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setShortLE(i, (short) i2);
            _setByte(i + 2, (byte) (i2 >>> 16));
        } else {
            _setShortLE(i, (short) (i2 >> 8));
            _setByte(i + 2, (byte) i2);
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setInt(int i, int i2) {
        return (CompositeByteBuf) super.setInt(i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setInt(int i, int i2) {
        Component componentFindComponent = findComponent(i);
        if (i + 4 <= componentFindComponent.endOffset) {
            componentFindComponent.buf.setInt(i - componentFindComponent.offset, i2);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setShort(i, (short) (i2 >>> 16));
            _setShort(i + 2, (short) i2);
        } else {
            _setShort(i, (short) i2);
            _setShort(i + 2, (short) (i2 >>> 16));
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setIntLE(int i, int i2) {
        Component componentFindComponent = findComponent(i);
        if (i + 4 <= componentFindComponent.endOffset) {
            componentFindComponent.buf.setIntLE(i - componentFindComponent.offset, i2);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setShortLE(i, (short) i2);
            _setShortLE(i + 2, (short) (i2 >>> 16));
        } else {
            _setShortLE(i, (short) (i2 >>> 16));
            _setShortLE(i + 2, (short) i2);
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setLong(int i, long j) {
        return (CompositeByteBuf) super.setLong(i, j);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setLong(int i, long j) {
        Component componentFindComponent = findComponent(i);
        if (i + 8 <= componentFindComponent.endOffset) {
            componentFindComponent.buf.setLong(i - componentFindComponent.offset, j);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setInt(i, (int) (j >>> 32));
            _setInt(i + 4, (int) j);
        } else {
            _setInt(i, (int) j);
            _setInt(i + 4, (int) (j >>> 32));
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setLongLE(int i, long j) {
        Component componentFindComponent = findComponent(i);
        if (i + 8 <= componentFindComponent.endOffset) {
            componentFindComponent.buf.setLongLE(i - componentFindComponent.offset, j);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setIntLE(i, (int) j);
            _setIntLE(i + 4, (int) (j >>> 32));
        } else {
            _setIntLE(i, (int) (j >>> 32));
            _setIntLE(i + 4, (int) j);
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i, byte[] bArr, int i2, int i3) {
        checkSrcIndex(i, i3, i2, bArr.length);
        if (i3 == 0) {
            return this;
        }
        int componentIndex = toComponentIndex(i);
        while (i3 > 0) {
            Component component = this.components.get(componentIndex);
            ByteBuf byteBuf = component.buf;
            int i4 = i - component.offset;
            int iMin = Math.min(i3, byteBuf.capacity() - i4);
            byteBuf.setBytes(i4, bArr, i2, iMin);
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            componentIndex++;
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i, ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iRemaining = byteBuffer.remaining();
        checkIndex(i, iRemaining);
        if (iRemaining == 0) {
            return this;
        }
        int componentIndex = toComponentIndex(i);
        while (iRemaining > 0) {
            try {
                Component component = this.components.get(componentIndex);
                ByteBuf byteBuf = component.buf;
                int i2 = i - component.offset;
                int iMin = Math.min(iRemaining, byteBuf.capacity() - i2);
                byteBuffer.limit(byteBuffer.position() + iMin);
                byteBuf.setBytes(i2, byteBuffer);
                i += iMin;
                iRemaining -= iMin;
                componentIndex++;
            } finally {
                byteBuffer.limit(iLimit);
            }
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        checkSrcIndex(i, i3, i2, byteBuf.capacity());
        if (i3 == 0) {
            return this;
        }
        int componentIndex = toComponentIndex(i);
        while (i3 > 0) {
            Component component = this.components.get(componentIndex);
            ByteBuf byteBuf2 = component.buf;
            int i4 = i - component.offset;
            int iMin = Math.min(i3, byteBuf2.capacity() - i4);
            byteBuf2.setBytes(i4, byteBuf, i2, iMin);
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            componentIndex++;
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i, InputStream inputStream, int i2) {
        checkIndex(i, i2);
        if (i2 == 0) {
            return inputStream.read(EmptyArrays.EMPTY_BYTES);
        }
        int componentIndex = toComponentIndex(i);
        int i3 = 0;
        while (true) {
            Component component = this.components.get(componentIndex);
            ByteBuf byteBuf = component.buf;
            int i4 = i - component.offset;
            int iMin = Math.min(i2, byteBuf.capacity() - i4);
            int bytes = byteBuf.setBytes(i4, inputStream, iMin);
            if (bytes >= 0) {
                if (bytes == iMin) {
                    i += iMin;
                    i2 -= iMin;
                    i3 += iMin;
                    componentIndex++;
                } else {
                    i += bytes;
                    i2 -= bytes;
                    i3 += bytes;
                }
                if (i2 <= 0) {
                    break;
                }
            } else if (i3 == 0) {
                return -1;
            }
        }
        return i3;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i, ScatteringByteChannel scatteringByteChannel, int i2) {
        checkIndex(i, i2);
        if (i2 == 0) {
            return scatteringByteChannel.read(EMPTY_NIO_BUFFER);
        }
        int componentIndex = toComponentIndex(i);
        int i3 = 0;
        while (true) {
            Component component = this.components.get(componentIndex);
            ByteBuf byteBuf = component.buf;
            int i4 = i - component.offset;
            int iMin = Math.min(i2, byteBuf.capacity() - i4);
            int bytes = byteBuf.setBytes(i4, scatteringByteChannel, iMin);
            if (bytes == 0) {
                break;
            }
            if (bytes >= 0) {
                if (bytes == iMin) {
                    i += iMin;
                    i2 -= iMin;
                    i3 += iMin;
                    componentIndex++;
                } else {
                    i += bytes;
                    i2 -= bytes;
                    i3 += bytes;
                }
                if (i2 <= 0) {
                    break;
                }
            } else if (i3 == 0) {
                return -1;
            }
        }
        return i3;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i, int i2) {
        checkIndex(i, i2);
        ByteBuf byteBufBuffer = Unpooled.buffer(i2);
        if (i2 != 0) {
            copyTo(i, i2, toComponentIndex(i), byteBufBuffer);
        }
        return byteBufBuffer;
    }

    private void copyTo(int i, int i2, int i3, ByteBuf byteBuf) {
        int i4 = 0;
        while (i2 > 0) {
            Component component = this.components.get(i3);
            ByteBuf byteBuf2 = component.buf;
            int i5 = i - component.offset;
            int iMin = Math.min(i2, byteBuf2.capacity() - i5);
            byteBuf2.getBytes(i5, byteBuf, i4, iMin);
            i += iMin;
            i4 += iMin;
            i2 -= iMin;
            i3++;
        }
        byteBuf.writerIndex(byteBuf.capacity());
    }

    public ByteBuf component(int i) {
        return internalComponent(i).duplicate();
    }

    public ByteBuf componentAtOffset(int i) {
        return internalComponentAtOffset(i).duplicate();
    }

    public ByteBuf internalComponent(int i) {
        checkComponentIndex(i);
        return this.components.get(i).buf;
    }

    public ByteBuf internalComponentAtOffset(int i) {
        return findComponent(i).buf;
    }

    private Component findComponent(int i) {
        checkIndex(i);
        int size = this.components.size();
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            Component component = this.components.get(i3);
            if (i >= component.endOffset) {
                i2 = i3 + 1;
            } else {
                if (i >= component.offset) {
                    return component;
                }
                size = i3 - 1;
            }
        }
        throw new Error("should not reach here");
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        int size = this.components.size();
        if (size == 0) {
            return 1;
        }
        if (size == 1) {
            return this.components.get(0).buf.nioBufferCount();
        }
        int size2 = this.components.size();
        int iNioBufferCount = 0;
        for (int i = 0; i < size2; i++) {
            iNioBufferCount += this.components.get(i).buf.nioBufferCount();
        }
        return iNioBufferCount;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i, int i2) {
        int size = this.components.size();
        if (size == 0) {
            return EMPTY_NIO_BUFFER;
        }
        if (size == 1) {
            return this.components.get(0).buf.internalNioBuffer(i, i2);
        }
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i, int i2) {
        checkIndex(i, i2);
        int size = this.components.size();
        if (size == 0) {
            return EMPTY_NIO_BUFFER;
        }
        if (size == 1 && this.components.get(0).buf.nioBufferCount() == 1) {
            return this.components.get(0).buf.nioBuffer(i, i2);
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(i2).order(order());
        for (ByteBuffer byteBuffer : nioBuffers(i, i2)) {
            byteBufferOrder.put(byteBuffer);
        }
        byteBufferOrder.flip();
        return byteBufferOrder;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i, int i2) {
        checkIndex(i, i2);
        if (i2 == 0) {
            return new ByteBuffer[]{EMPTY_NIO_BUFFER};
        }
        ArrayList arrayList = new ArrayList(this.components.size());
        int componentIndex = toComponentIndex(i);
        while (i2 > 0) {
            Component component = this.components.get(componentIndex);
            ByteBuf byteBuf = component.buf;
            int i3 = i - component.offset;
            int iMin = Math.min(i2, byteBuf.capacity() - i3);
            int iNioBufferCount = byteBuf.nioBufferCount();
            if (iNioBufferCount == 0) {
                throw new UnsupportedOperationException();
            }
            if (iNioBufferCount == 1) {
                arrayList.add(byteBuf.nioBuffer(i3, iMin));
            } else {
                Collections.addAll(arrayList, byteBuf.nioBuffers(i3, iMin));
            }
            i += iMin;
            i2 -= iMin;
            componentIndex++;
        }
        return (ByteBuffer[]) arrayList.toArray(new ByteBuffer[arrayList.size()]);
    }

    public CompositeByteBuf consolidate() {
        ensureAccessible();
        int iNumComponents = numComponents();
        if (iNumComponents <= 1) {
            return this;
        }
        ByteBuf byteBufAllocBuffer = allocBuffer(this.components.get(iNumComponents - 1).endOffset);
        for (int i = 0; i < iNumComponents; i++) {
            Component component = this.components.get(i);
            byteBufAllocBuffer.writeBytes(component.buf);
            component.freeIfNecessary();
        }
        this.components.clear();
        this.components.add(new Component(byteBufAllocBuffer));
        updateComponentOffsets(0);
        return this;
    }

    public CompositeByteBuf consolidate(int i, int i2) {
        checkComponentIndex(i, i2);
        if (i2 <= 1) {
            return this;
        }
        int i3 = i2 + i;
        ByteBuf byteBufAllocBuffer = allocBuffer(this.components.get(i3 - 1).endOffset - this.components.get(i).offset);
        for (int i4 = i; i4 < i3; i4++) {
            Component component = this.components.get(i4);
            byteBufAllocBuffer.writeBytes(component.buf);
            component.freeIfNecessary();
        }
        this.components.subList(i + 1, i3).clear();
        this.components.set(i, new Component(byteBufAllocBuffer));
        updateComponentOffsets(i);
        return this;
    }

    public CompositeByteBuf discardReadComponents() {
        ensureAccessible();
        int i = readerIndex();
        if (i == 0) {
            return this;
        }
        int iWriterIndex = writerIndex();
        if (i == iWriterIndex && iWriterIndex == capacity()) {
            Iterator<Component> it = this.components.iterator();
            while (it.hasNext()) {
                it.next().freeIfNecessary();
            }
            this.components.clear();
            setIndex(0, 0);
            adjustMarkers(i);
            return this;
        }
        int componentIndex = toComponentIndex(i);
        for (int i2 = 0; i2 < componentIndex; i2++) {
            this.components.get(i2).freeIfNecessary();
        }
        this.components.subList(0, componentIndex).clear();
        int i3 = this.components.get(0).offset;
        updateComponentOffsets(0);
        setIndex(i - i3, iWriterIndex - i3);
        adjustMarkers(i3);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf discardReadBytes() {
        ensureAccessible();
        int i = readerIndex();
        if (i == 0) {
            return this;
        }
        int iWriterIndex = writerIndex();
        if (i == iWriterIndex && iWriterIndex == capacity()) {
            Iterator<Component> it = this.components.iterator();
            while (it.hasNext()) {
                it.next().freeIfNecessary();
            }
            this.components.clear();
            setIndex(0, 0);
            adjustMarkers(i);
            return this;
        }
        int componentIndex = toComponentIndex(i);
        for (int i2 = 0; i2 < componentIndex; i2++) {
            this.components.get(i2).freeIfNecessary();
        }
        this.components.subList(0, componentIndex).clear();
        Component component = this.components.get(0);
        int i3 = i - component.offset;
        if (i3 == component.length) {
            this.components.remove(0);
        } else {
            this.components.set(0, new Component(component.buf.slice(i3, component.length - i3)));
        }
        updateComponentOffsets(0);
        setIndex(0, iWriterIndex - i);
        adjustMarkers(i);
        return this;
    }

    private ByteBuf allocBuffer(int i) {
        if (this.direct) {
            return alloc().directBuffer(i);
        }
        return alloc().heapBuffer(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public String toString() {
        return super.toString().substring(0, r0.length() - 1) + ", components=" + this.components.size() + ')';
    }

    static final class Component {
        final ByteBuf buf;
        int endOffset;
        final int length;
        int offset;

        Component(ByteBuf byteBuf) {
            this.buf = byteBuf;
            this.length = byteBuf.readableBytes();
        }

        final void freeIfNecessary() {
            this.buf.release();
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readerIndex(int i) {
        return (CompositeByteBuf) super.readerIndex(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writerIndex(int i) {
        return (CompositeByteBuf) super.writerIndex(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setIndex(int i, int i2) {
        return (CompositeByteBuf) super.setIndex(i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf clear() {
        return (CompositeByteBuf) super.clear();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf markReaderIndex() {
        return (CompositeByteBuf) super.markReaderIndex();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf resetReaderIndex() {
        return (CompositeByteBuf) super.resetReaderIndex();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf markWriterIndex() {
        return (CompositeByteBuf) super.markWriterIndex();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf resetWriterIndex() {
        return (CompositeByteBuf) super.resetWriterIndex();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf ensureWritable(int i) {
        return (CompositeByteBuf) super.ensureWritable(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i, ByteBuf byteBuf) {
        return (CompositeByteBuf) super.getBytes(i, byteBuf);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i, ByteBuf byteBuf, int i2) {
        return (CompositeByteBuf) super.getBytes(i, byteBuf, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i, byte[] bArr) {
        return (CompositeByteBuf) super.getBytes(i, bArr);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBoolean(int i, boolean z) {
        return (CompositeByteBuf) super.setBoolean(i, z);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setChar(int i, int i2) {
        return (CompositeByteBuf) super.setChar(i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setFloat(int i, float f) {
        return (CompositeByteBuf) super.setFloat(i, f);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setDouble(int i, double d) {
        return (CompositeByteBuf) super.setDouble(i, d);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i, ByteBuf byteBuf) {
        return (CompositeByteBuf) super.setBytes(i, byteBuf);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i, ByteBuf byteBuf, int i2) {
        return (CompositeByteBuf) super.setBytes(i, byteBuf, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i, byte[] bArr) {
        return (CompositeByteBuf) super.setBytes(i, bArr);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setZero(int i, int i2) {
        return (CompositeByteBuf) super.setZero(i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf) {
        return (CompositeByteBuf) super.readBytes(byteBuf);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf, int i) {
        return (CompositeByteBuf) super.readBytes(byteBuf, i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf, int i, int i2) {
        return (CompositeByteBuf) super.readBytes(byteBuf, i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(byte[] bArr) {
        return (CompositeByteBuf) super.readBytes(bArr);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(byte[] bArr, int i, int i2) {
        return (CompositeByteBuf) super.readBytes(bArr, i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuffer byteBuffer) {
        return (CompositeByteBuf) super.readBytes(byteBuffer);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(OutputStream outputStream, int i) {
        return (CompositeByteBuf) super.readBytes(outputStream, i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf skipBytes(int i) {
        return (CompositeByteBuf) super.skipBytes(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBoolean(boolean z) {
        return (CompositeByteBuf) super.writeBoolean(z);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeByte(int i) {
        return (CompositeByteBuf) super.writeByte(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeShort(int i) {
        return (CompositeByteBuf) super.writeShort(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeMedium(int i) {
        return (CompositeByteBuf) super.writeMedium(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeInt(int i) {
        return (CompositeByteBuf) super.writeInt(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeLong(long j) {
        return (CompositeByteBuf) super.writeLong(j);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeChar(int i) {
        return (CompositeByteBuf) super.writeChar(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeFloat(float f) {
        return (CompositeByteBuf) super.writeFloat(f);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeDouble(double d) {
        return (CompositeByteBuf) super.writeDouble(d);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf) {
        return (CompositeByteBuf) super.writeBytes(byteBuf);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf, int i) {
        return (CompositeByteBuf) super.writeBytes(byteBuf, i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf, int i, int i2) {
        return (CompositeByteBuf) super.writeBytes(byteBuf, i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(byte[] bArr) {
        return (CompositeByteBuf) super.writeBytes(bArr);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(byte[] bArr, int i, int i2) {
        return (CompositeByteBuf) super.writeBytes(bArr, i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuffer byteBuffer) {
        return (CompositeByteBuf) super.writeBytes(byteBuffer);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeZero(int i) {
        return (CompositeByteBuf) super.writeZero(i);
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public CompositeByteBuf retain(int i) {
        return (CompositeByteBuf) super.retain(i);
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public CompositeByteBuf retain() {
        return (CompositeByteBuf) super.retain();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        return nioBuffers(readerIndex(), readableBytes());
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf discardSomeReadBytes() {
        return discardReadComponents();
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf
    protected void deallocate() {
        if (this.freed) {
            return;
        }
        this.freed = true;
        int size = this.components.size();
        for (int i = 0; i < size; i++) {
            this.components.get(i).freeIfNecessary();
        }
    }

    final class CompositeByteBufIterator implements Iterator<ByteBuf> {
        private int index;
        private final int size;

        private CompositeByteBufIterator() {
            this.size = CompositeByteBuf.this.components.size();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.size > this.index;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public final ByteBuf next() {
            if (this.size != CompositeByteBuf.this.components.size()) {
                throw new ConcurrentModificationException();
            }
            if (hasNext()) {
                try {
                    List list = CompositeByteBuf.this.components;
                    int i = this.index;
                    this.index = i + 1;
                    return ((Component) list.get(i)).buf;
                } catch (IndexOutOfBoundsException unused) {
                    throw new ConcurrentModificationException();
                }
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Read-Only");
        }
    }
}
