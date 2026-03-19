package com.tkruntime.v8;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class V8Locker {
    private final long mIsolatePtr;
    private Thread thread = null;
    private boolean released = false;
    private long mLockerPtr = 0;

    V8Locker(long j) {
        this.mIsolatePtr = j;
        acquire();
    }

    public Thread getThread() {
        return this.thread;
    }

    public synchronized void acquire() {
        if (this.thread != null && this.thread != Thread.currentThread()) {
            throw new Error("Invalid V8 thread access: current thread is " + Thread.currentThread() + " while the locker has thread " + this.thread);
        }
        if (this.thread == Thread.currentThread()) {
            return;
        }
        this.thread = Thread.currentThread();
        this.released = false;
    }

    public synchronized boolean tryAcquire() {
        if (this.thread != null && this.thread != Thread.currentThread()) {
            return false;
        }
        if (this.thread == Thread.currentThread()) {
            return true;
        }
        this.thread = Thread.currentThread();
        this.released = false;
        return true;
    }

    public synchronized void release() {
        if ((!this.released || this.thread != null) && this.mIsolatePtr != 0 && this.mLockerPtr != 0) {
            checkThread();
            this.thread = null;
            this.released = true;
        }
    }

    public void checkThread() {
        if (this.released && this.thread == null) {
            throw new Error("Invalid V8 thread access: the locker has been released!");
        }
        if (this.thread == Thread.currentThread()) {
            return;
        }
        throw new Error("Invalid V8 thread access: current thread is " + Thread.currentThread() + " while the locker has thread " + this.thread);
    }

    public boolean hasLock() {
        return this.thread == Thread.currentThread();
    }

    public static class DeprecatedV8Locker extends V8Locker {
        private boolean released;
        private Thread thread;

        @Override // com.tkruntime.v8.V8Locker
        public boolean hasLock() {
            return true;
        }

        DeprecatedV8Locker(long j) {
            super(j);
            this.thread = null;
            this.released = false;
        }

        @Override // com.tkruntime.v8.V8Locker
        public Thread getThread() {
            return this.thread;
        }

        @Override // com.tkruntime.v8.V8Locker
        public synchronized void acquire() {
            this.released = false;
        }

        @Override // com.tkruntime.v8.V8Locker
        public synchronized boolean tryAcquire() {
            this.released = false;
            return true;
        }

        @Override // com.tkruntime.v8.V8Locker
        public synchronized void release() {
            this.released = true;
            this.thread = null;
        }

        @Override // com.tkruntime.v8.V8Locker
        public void checkThread() {
            if (this.released) {
                throw new Error("Invalid V8 thread access: the locker has been released!");
            }
        }
    }
}
