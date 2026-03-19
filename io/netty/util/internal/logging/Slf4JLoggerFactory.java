package io.netty.util.internal.logging;

import com.fendasz.moku.planet.utils.thirdparty.codec.CharEncoding;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.NOPLoggerFactory;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class Slf4JLoggerFactory extends InternalLoggerFactory {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public Slf4JLoggerFactory() {
    }

    Slf4JLoggerFactory(boolean z) {
        final StringBuffer stringBuffer = new StringBuffer();
        PrintStream printStream = System.err;
        try {
            System.setErr(new PrintStream(new OutputStream() { // from class: io.netty.util.internal.logging.Slf4JLoggerFactory.1
                @Override // java.io.OutputStream
                public void write(int i) {
                    stringBuffer.append((char) i);
                }
            }, true, CharEncoding.US_ASCII));
            try {
                if (LoggerFactory.getILoggerFactory() instanceof NOPLoggerFactory) {
                    throw new NoClassDefFoundError(stringBuffer.toString());
                }
                printStream.print(stringBuffer);
                printStream.flush();
            } finally {
                System.setErr(printStream);
            }
        } catch (UnsupportedEncodingException e) {
            throw new Error(e);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLoggerFactory
    public InternalLogger newInstance(String str) {
        return new Slf4JLogger(LoggerFactory.getLogger(str));
    }
}
