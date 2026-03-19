package aegon.chrome.net.urlconnection;

import aegon.chrome.net.UploadDataProvider;
import aegon.chrome.net.UploadDataSink;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.nio.ByteBuffer;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final class CronetChunkedOutputStream extends CronetOutputStream {
    private final ByteBuffer mBuffer;
    private final CronetHttpURLConnection mConnection;
    private boolean mLastChunk;
    private final MessageLoop mMessageLoop;
    private final UploadDataProvider mUploadDataProvider = new UploadDataProviderImpl();

    @Override // aegon.chrome.net.urlconnection.CronetOutputStream
    final void checkReceivedEnoughContent() {
    }

    @Override // aegon.chrome.net.urlconnection.CronetOutputStream
    final void setConnected() {
    }

    CronetChunkedOutputStream(CronetHttpURLConnection cronetHttpURLConnection, int i, MessageLoop messageLoop) {
        cronetHttpURLConnection.getClass();
        if (i <= 0) {
            throw new IllegalArgumentException("chunkLength should be greater than 0");
        }
        this.mBuffer = ByteBuffer.allocate(i);
        this.mConnection = cronetHttpURLConnection;
        this.mMessageLoop = messageLoop;
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws InterruptedIOException {
        ensureBufferHasRemaining();
        this.mBuffer.put((byte) i);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws InterruptedIOException {
        checkNotClosed();
        if (bArr.length - i < i2 || i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i2;
        while (i3 > 0) {
            int iMin = Math.min(i3, this.mBuffer.remaining());
            this.mBuffer.put(bArr, (i + i2) - i3, iMin);
            i3 -= iMin;
            ensureBufferHasRemaining();
        }
    }

    @Override // aegon.chrome.net.urlconnection.CronetOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        super.close();
        if (this.mLastChunk) {
            return;
        }
        this.mLastChunk = true;
        this.mBuffer.flip();
    }

    @Override // aegon.chrome.net.urlconnection.CronetOutputStream
    final UploadDataProvider getUploadDataProvider() {
        return this.mUploadDataProvider;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    class UploadDataProviderImpl extends UploadDataProvider {
        @Override // aegon.chrome.net.UploadDataProvider
        public long getLength() {
            return -1L;
        }

        private UploadDataProviderImpl() {
        }

        @Override // aegon.chrome.net.UploadDataProvider
        public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= CronetChunkedOutputStream.this.mBuffer.remaining()) {
                byteBuffer.put(CronetChunkedOutputStream.this.mBuffer);
                CronetChunkedOutputStream.this.mBuffer.clear();
                uploadDataSink.onReadSucceeded(CronetChunkedOutputStream.this.mLastChunk);
                if (CronetChunkedOutputStream.this.mLastChunk) {
                    return;
                }
                CronetChunkedOutputStream.this.mMessageLoop.quit();
                return;
            }
            int iLimit = CronetChunkedOutputStream.this.mBuffer.limit();
            CronetChunkedOutputStream.this.mBuffer.limit(CronetChunkedOutputStream.this.mBuffer.position() + byteBuffer.remaining());
            byteBuffer.put(CronetChunkedOutputStream.this.mBuffer);
            CronetChunkedOutputStream.this.mBuffer.limit(iLimit);
            uploadDataSink.onReadSucceeded(false);
        }

        @Override // aegon.chrome.net.UploadDataProvider
        public void rewind(UploadDataSink uploadDataSink) {
            uploadDataSink.onRewindError(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }

    private void ensureBufferHasRemaining() throws InterruptedIOException {
        if (this.mBuffer.hasRemaining()) {
            return;
        }
        uploadBufferInternal();
    }

    private void uploadBufferInternal() throws InterruptedIOException {
        checkNotClosed();
        this.mBuffer.flip();
        this.mMessageLoop.loop();
        checkNoException();
    }
}
