package com.luck.picture.lib.obj.pool;

import java.util.LinkedList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ObjectPools {

    public interface Pool<T> {
        T acquire();

        void destroy();

        boolean release(T t);
    }

    public static class SimpleObjectPool<T> implements Pool<T> {
        private final LinkedList<T> mPool = new LinkedList<>();

        @Override // com.luck.picture.lib.obj.pool.ObjectPools.Pool
        public T acquire() {
            return this.mPool.poll();
        }

        @Override // com.luck.picture.lib.obj.pool.ObjectPools.Pool
        public boolean release(T t) {
            if (isInPool(t)) {
                return false;
            }
            return this.mPool.add(t);
        }

        @Override // com.luck.picture.lib.obj.pool.ObjectPools.Pool
        public void destroy() {
            this.mPool.clear();
        }

        private boolean isInPool(T t) {
            return this.mPool.contains(t);
        }
    }

    public static class SynchronizedPool<T> extends SimpleObjectPool<T> {
        private final Object mLock = new Object();

        @Override // com.luck.picture.lib.obj.pool.ObjectPools.SimpleObjectPool, com.luck.picture.lib.obj.pool.ObjectPools.Pool
        public T acquire() {
            T t;
            synchronized (this.mLock) {
                t = (T) super.acquire();
            }
            return t;
        }

        @Override // com.luck.picture.lib.obj.pool.ObjectPools.SimpleObjectPool, com.luck.picture.lib.obj.pool.ObjectPools.Pool
        public boolean release(T t) {
            boolean zRelease;
            synchronized (this.mLock) {
                zRelease = super.release(t);
            }
            return zRelease;
        }

        @Override // com.luck.picture.lib.obj.pool.ObjectPools.SimpleObjectPool, com.luck.picture.lib.obj.pool.ObjectPools.Pool
        public void destroy() {
            synchronized (this.mLock) {
                super.destroy();
            }
        }
    }
}
