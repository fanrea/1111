package com.kwad.sdk.glide.load.engine;

import android.util.Log;
import com.kwad.sdk.glide.load.DataSource;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class GlideException extends Exception {
    private static final StackTraceElement[] EMPTY_ELEMENTS = new StackTraceElement[0];
    private static final long serialVersionUID = 1;
    private final List<Throwable> causes;
    private Class<?> dataClass;
    private DataSource dataSource;
    private String detailMessage;
    private Exception exception;
    private com.kwad.sdk.glide.load.c key;

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        return this;
    }

    public GlideException(String str) {
        this(str, (List<Throwable>) Collections.emptyList());
    }

    public GlideException(String str, Throwable th) {
        this(str, (List<Throwable>) Collections.singletonList(th));
    }

    public GlideException(String str, List<Throwable> list) {
        this.detailMessage = str;
        setStackTrace(EMPTY_ELEMENTS);
        this.causes = list;
    }

    final void setLoggingDetails(com.kwad.sdk.glide.load.c cVar, DataSource dataSource) {
        setLoggingDetails(cVar, dataSource, null);
    }

    final void setLoggingDetails(com.kwad.sdk.glide.load.c cVar, DataSource dataSource, Class<?> cls) {
        this.key = cVar;
        this.dataSource = dataSource;
        this.dataClass = cls;
    }

    public final void setOrigin(Exception exc) {
        this.exception = exc;
    }

    public final Exception getOrigin() {
        return this.exception;
    }

    public final List<Throwable> getCauses() {
        return this.causes;
    }

    public final List<Throwable> getRootCauses() {
        ArrayList arrayList = new ArrayList();
        addRootCauses(this, arrayList);
        return arrayList;
    }

    public final void logRootCauses(String str) {
        List<Throwable> rootCauses = getRootCauses();
        int size = rootCauses.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            Log.i(str, "Root cause (" + i2 + " of " + size + ")", rootCauses.get(i));
            i = i2;
        }
    }

    private void addRootCauses(Throwable th, List<Throwable> list) {
        if (th instanceof GlideException) {
            Iterator<Throwable> it = ((GlideException) th).getCauses().iterator();
            while (it.hasNext()) {
                addRootCauses(it.next(), list);
            }
            return;
        }
        list.add(th);
    }

    @Override // java.lang.Throwable
    public final void printStackTrace() throws IOException {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintStream printStream) throws IOException {
        printStackTrace((Appendable) printStream);
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintWriter printWriter) throws IOException {
        printStackTrace((Appendable) printWriter);
    }

    private void printStackTrace(Appendable appendable) throws IOException {
        appendExceptionMessage(this, appendable);
        appendCauses(getCauses(), new a(appendable));
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        StringBuilder sbAppend = new StringBuilder(71).append(this.detailMessage).append(this.dataClass != null ? ", " + this.dataClass : "").append(this.dataSource != null ? ", " + this.dataSource : "").append(this.key != null ? ", " + this.key : "");
        List<Throwable> rootCauses = getRootCauses();
        if (rootCauses.isEmpty()) {
            return sbAppend.toString();
        }
        if (rootCauses.size() == 1) {
            sbAppend.append("\nThere was 1 cause:");
        } else {
            sbAppend.append("\nThere were ").append(rootCauses.size()).append(" causes:");
        }
        for (Throwable th : rootCauses) {
            sbAppend.append('\n').append(th.getClass().getName()).append('(').append(th.getMessage()).append(')');
        }
        sbAppend.append("\n call GlideException#logRootCauses(String) for more detail");
        return sbAppend.toString();
    }

    private static void appendExceptionMessage(Throwable th, Appendable appendable) throws IOException {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    private static void appendCauses(List<Throwable> list, Appendable appendable) {
        try {
            appendCausesWrapped(list, appendable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void appendCausesWrapped(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            appendable.append("Cause (").append(String.valueOf(i2)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i);
            if (th instanceof GlideException) {
                ((GlideException) th).printStackTrace(appendable);
            } else {
                appendExceptionMessage(th, appendable);
            }
            i = i2;
        }
    }

    static final class a implements Appendable {
        private final Appendable bUf;
        private boolean bUg = true;

        private static CharSequence d(CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        a(Appendable appendable) {
            this.bUf = appendable;
        }

        @Override // java.lang.Appendable
        public final Appendable append(char c) throws IOException {
            if (this.bUg) {
                this.bUg = false;
                this.bUf.append("  ");
            }
            this.bUg = c == '\n';
            this.bUf.append(c);
            return this;
        }

        @Override // java.lang.Appendable
        public final Appendable append(CharSequence charSequence) {
            CharSequence charSequenceD = d(charSequence);
            return append(charSequenceD, 0, charSequenceD.length());
        }

        @Override // java.lang.Appendable
        public final Appendable append(CharSequence charSequence, int i, int i2) throws IOException {
            CharSequence charSequenceD = d(charSequence);
            boolean z = false;
            if (this.bUg) {
                this.bUg = false;
                this.bUf.append("  ");
            }
            if (charSequenceD.length() > 0 && charSequenceD.charAt(i2 - 1) == '\n') {
                z = true;
            }
            this.bUg = z;
            this.bUf.append(charSequenceD, i, i2);
            return this;
        }
    }
}
