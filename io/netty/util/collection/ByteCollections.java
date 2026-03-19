package io.netty.util.collection;

import io.netty.util.collection.ByteObjectMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class ByteCollections {
    private static final ByteObjectMap<Object> EMPTY_MAP = new EmptyMap();

    private ByteCollections() {
    }

    public static <V> ByteObjectMap<V> emptyMap() {
        return (ByteObjectMap<V>) EMPTY_MAP;
    }

    public static <V> ByteObjectMap<V> unmodifiableMap(ByteObjectMap<V> byteObjectMap) {
        return new UnmodifiableMap(byteObjectMap);
    }

    static final class EmptyMap implements ByteObjectMap<Object> {
        @Override // java.util.Map
        public final void clear() {
        }

        @Override // io.netty.util.collection.ByteObjectMap
        public final boolean containsKey(byte b) {
            return false;
        }

        @Override // java.util.Map
        public final boolean containsKey(Object obj) {
            return false;
        }

        @Override // java.util.Map
        public final boolean containsValue(Object obj) {
            return false;
        }

        @Override // io.netty.util.collection.ByteObjectMap
        public final Object get(byte b) {
            return null;
        }

        @Override // java.util.Map
        public final Object get(Object obj) {
            return null;
        }

        @Override // java.util.Map
        public final boolean isEmpty() {
            return true;
        }

        @Override // io.netty.util.collection.ByteObjectMap
        public final Object remove(byte b) {
            return null;
        }

        @Override // java.util.Map
        public final Object remove(Object obj) {
            return null;
        }

        @Override // java.util.Map
        public final int size() {
            return 0;
        }

        private EmptyMap() {
        }

        @Override // io.netty.util.collection.ByteObjectMap
        public final Object put(byte b, Object obj) {
            throw new UnsupportedOperationException("put");
        }

        @Override // java.util.Map
        public final Set<Byte> keySet() {
            return Collections.emptySet();
        }

        @Override // io.netty.util.collection.ByteObjectMap
        public final Iterable<ByteObjectMap.PrimitiveEntry<Object>> entries() {
            return Collections.emptySet();
        }

        @Override // java.util.Map
        public final Object put(Byte b, Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public final void putAll(Map<? extends Byte, ?> map) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public final Collection<Object> values() {
            return Collections.emptyList();
        }

        @Override // java.util.Map
        public final Set<Map.Entry<Byte, Object>> entrySet() {
            return Collections.emptySet();
        }
    }

    static final class UnmodifiableMap<V> implements ByteObjectMap<V> {
        private Iterable<ByteObjectMap.PrimitiveEntry<V>> entries;
        private Set<Map.Entry<Byte, V>> entrySet;
        private Set<Byte> keySet;
        private final ByteObjectMap<V> map;
        private Collection<V> values;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        public final /* bridge */ /* synthetic */ Object put(Byte b, Object obj) {
            return put2(b, (Byte) obj);
        }

        UnmodifiableMap(ByteObjectMap<V> byteObjectMap) {
            this.map = byteObjectMap;
        }

        @Override // io.netty.util.collection.ByteObjectMap
        public final V get(byte b) {
            return this.map.get(b);
        }

        @Override // io.netty.util.collection.ByteObjectMap
        public final V put(byte b, V v) {
            throw new UnsupportedOperationException("put");
        }

        @Override // io.netty.util.collection.ByteObjectMap
        public final V remove(byte b) {
            throw new UnsupportedOperationException("remove");
        }

        @Override // java.util.Map
        public final int size() {
            return this.map.size();
        }

        @Override // java.util.Map
        public final boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // java.util.Map
        public final void clear() {
            throw new UnsupportedOperationException("clear");
        }

        @Override // io.netty.util.collection.ByteObjectMap
        public final boolean containsKey(byte b) {
            return this.map.containsKey(b);
        }

        @Override // java.util.Map
        public final boolean containsValue(Object obj) {
            return this.map.containsValue(obj);
        }

        @Override // java.util.Map
        public final boolean containsKey(Object obj) {
            return this.map.containsKey(obj);
        }

        @Override // java.util.Map
        public final V get(Object obj) {
            return this.map.get(obj);
        }

        /* renamed from: put, reason: avoid collision after fix types in other method */
        public final V put2(Byte b, V v) {
            throw new UnsupportedOperationException("put");
        }

        @Override // java.util.Map
        public final V remove(Object obj) {
            throw new UnsupportedOperationException("remove");
        }

        @Override // java.util.Map
        public final void putAll(Map<? extends Byte, ? extends V> map) {
            throw new UnsupportedOperationException("putAll");
        }

        @Override // io.netty.util.collection.ByteObjectMap
        public final Iterable<ByteObjectMap.PrimitiveEntry<V>> entries() {
            if (this.entries == null) {
                this.entries = new Iterable<ByteObjectMap.PrimitiveEntry<V>>() { // from class: io.netty.util.collection.ByteCollections.UnmodifiableMap.1
                    @Override // java.lang.Iterable
                    public Iterator<ByteObjectMap.PrimitiveEntry<V>> iterator() {
                        UnmodifiableMap unmodifiableMap = UnmodifiableMap.this;
                        return new IteratorImpl(unmodifiableMap.map.entries().iterator());
                    }
                };
            }
            return this.entries;
        }

        @Override // java.util.Map
        public final Set<Byte> keySet() {
            if (this.keySet == null) {
                this.keySet = Collections.unmodifiableSet(this.map.keySet());
            }
            return this.keySet;
        }

        @Override // java.util.Map
        public final Set<Map.Entry<Byte, V>> entrySet() {
            if (this.entrySet == null) {
                this.entrySet = Collections.unmodifiableSet(this.map.entrySet());
            }
            return this.entrySet;
        }

        @Override // java.util.Map
        public final Collection<V> values() {
            if (this.values == null) {
                this.values = Collections.unmodifiableCollection(this.map.values());
            }
            return this.values;
        }

        class IteratorImpl implements Iterator<ByteObjectMap.PrimitiveEntry<V>> {
            final Iterator<ByteObjectMap.PrimitiveEntry<V>> iter;

            IteratorImpl(Iterator<ByteObjectMap.PrimitiveEntry<V>> it) {
                this.iter = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.iter.hasNext();
            }

            @Override // java.util.Iterator
            public ByteObjectMap.PrimitiveEntry<V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return new EntryImpl(this.iter.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("remove");
            }
        }

        class EntryImpl implements ByteObjectMap.PrimitiveEntry<V> {
            private final ByteObjectMap.PrimitiveEntry<V> entry;

            EntryImpl(ByteObjectMap.PrimitiveEntry<V> primitiveEntry) {
                this.entry = primitiveEntry;
            }

            @Override // io.netty.util.collection.ByteObjectMap.PrimitiveEntry
            public byte key() {
                return this.entry.key();
            }

            @Override // io.netty.util.collection.ByteObjectMap.PrimitiveEntry
            public V value() {
                return this.entry.value();
            }

            @Override // io.netty.util.collection.ByteObjectMap.PrimitiveEntry
            public void setValue(V v) {
                throw new UnsupportedOperationException("setValue");
            }
        }
    }
}
