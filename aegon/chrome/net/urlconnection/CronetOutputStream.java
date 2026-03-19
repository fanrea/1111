package aegon.chrome.net.urlconnection;

import aegon.chrome.net.UploadDataProvider;
import java.io.IOException;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
abstract class CronetOutputStream extends OutputStream {
    private boolean mClosed;
    private IOException mException;
    private boolean mRequestCompleted;

    abstract void checkReceivedEnoughContent();

    abstract UploadDataProvider getUploadDataProvider();

    abstract void setConnected();

    CronetOutputStream() {
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mClosed = true;
    }

    void setRequestCompleted(IOException iOException) {
        this.mException = iOException;
        this.mRequestCompleted = true;
    }

    protected void checkNotClosed() throws IOException {
        if (this.mRequestCompleted) {
            checkNoException();
            throw new IOException("Writing after request completed.");
        }
        if (this.mClosed) {
            throw new IOException("Stream has been closed.");
        }
    }

    protected void checkNoException() throws IOException {
        IOException iOException = this.mException;
        if (iOException != null) {
            throw iOException;
        }
    }
}
