package com.component.lottie.e;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public final class l {
    static final Logger a = Logger.getLogger(l.class.getName());

    private l() {
    }

    public static i a(aa aaVar) {
        return new u(aaVar);
    }

    public static h a(z zVar) {
        return new s(zVar);
    }

    public static z a(OutputStream outputStream) {
        return a(outputStream, new ab());
    }

    private static z a(OutputStream outputStream, ab abVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (abVar == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new m(abVar, outputStream);
    }

    public static z a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        }
        a aVarC = c(socket);
        return aVarC.a(a(socket.getOutputStream(), aVarC));
    }

    public static z a(File file) {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return a(new FileOutputStream(file));
    }

    public static aa a(InputStream inputStream) {
        return a(inputStream, new ab());
    }

    private static aa a(InputStream inputStream, ab abVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (abVar == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new n(abVar, inputStream);
    }

    public static aa b(File file) {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return a(new FileInputStream(file));
    }

    public static aa b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        a aVarC = c(socket);
        return aVarC.a(a(socket.getInputStream(), aVarC));
    }

    public static z c(File file) {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return a(new FileOutputStream(file, true));
    }

    public static z a() {
        return new o();
    }

    private static a c(Socket socket) {
        return new p(socket);
    }

    static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
