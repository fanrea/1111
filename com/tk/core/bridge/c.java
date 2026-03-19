package com.tk.core.bridge;

import android.os.Handler;
import android.os.Message;
import com.tkruntime.v8.V8;
import com.tkruntime.v8.V8Object;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c extends V8 {
    private int Zq;
    private a Zr;
    private boolean Zs;

    public interface a {
        void hV();

        void hW();
    }

    public static c a(long j, boolean z) {
        return new c(j, true);
    }

    private c(long j, boolean z) {
        super(j, z);
        this.Zq = 0;
        this.Zs = false;
    }

    @Override // com.tkruntime.v8.V8, com.tkruntime.v8.V8Value, com.tkruntime.v8.Releasable, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.Zq > 0) {
            Handler handler = new Handler();
            handler.sendMessageAtFrontOfQueue(Message.obtain(handler, new Runnable() { // from class: com.tk.core.bridge.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.pw();
                }
            }));
        } else {
            pw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pw() {
        if (this.Zs) {
            return;
        }
        this.Zs = true;
        super.close();
    }

    public final void a(a aVar) {
        this.Zr = aVar;
    }

    @Override // com.tkruntime.v8.V8
    public final Object callObjectJavaMethod(long j, int i, int i2, V8Object v8Object, Object[] objArr) {
        try {
            this.Zq++;
            return super.callObjectJavaMethod(j, i, i2, v8Object, objArr);
        } finally {
            this.Zq--;
        }
    }

    @Override // com.tkruntime.v8.V8
    public final void callVoidJavaMethod(long j, int i, int i2, V8Object v8Object, Object[] objArr) {
        try {
            this.Zq++;
            super.callVoidJavaMethod(j, i, i2, v8Object, objArr);
        } finally {
            this.Zq--;
        }
    }

    private void px() {
        a aVar = this.Zr;
        if (aVar != null) {
            aVar.hV();
        }
    }

    private void py() {
        a aVar = this.Zr;
        if (aVar != null) {
            aVar.hW();
        }
    }

    @Override // com.tkruntime.v8.V8
    public final Object executeScript(long j, int i, String str, String str2, int i2, long j2) {
        try {
            px();
            return super.executeScript(j, i, str, str2, i2, j2);
        } finally {
            py();
        }
    }

    @Override // com.tkruntime.v8.V8
    public final void executeVoidScript(long j, String str, String str2, int i, long j2) {
        try {
            px();
            super.executeVoidScript(j, str, str2, i, j2);
        } finally {
            py();
        }
    }

    @Override // com.tkruntime.v8.V8
    public final Object executeFunction(long j, long j2, long j3, Object... objArr) {
        try {
            px();
            return super.executeFunction(j, j2, j3, objArr);
        } finally {
            py();
        }
    }

    @Override // com.tkruntime.v8.V8
    public final Object executeFunction(long j, int i, long j2, String str, Object... objArr) {
        try {
            px();
            return super.executeFunction(j, i, j2, str, objArr);
        } finally {
            py();
        }
    }

    @Override // com.tkruntime.v8.V8
    public final void executeVoidFunction(long j, long j2, String str, Object... objArr) {
        try {
            px();
            super.executeVoidFunction(j, j2, str, objArr);
        } finally {
            py();
        }
    }
}
