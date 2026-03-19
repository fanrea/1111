package io.netty.util.collection;

import io.netty.util.collection.CharObjectMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class CharCollections {
    private static final CharObjectMap<Object> EMPTY_MAP = new EmptyMap();

    private CharCollections() {
    }

    public static <V> CharObjectMap<V> emptyMap() {
        return (CharObjectMap<V>) EMPTY_MAP;
    }

    public static <V> CharObjectMap<V> unmodifiableMap(CharObjectMap<V> charObjectMap) {
        return new UnmodifiableMap(charObjectMap);
    }

    static final class EmptyMap implements CharObjectMap<Object> {
        @Override // java.util.Map
        public final void clear() {
        }

        @Override // io.netty.util.collection.CharObjectMap
        public final boolean containsKey(char c) {
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

        @Override // io.netty.util.collection.CharObjectMap
        public final Object get(char c) {
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

        @Override // io.netty.util.collection.CharObjectMap
        public final Object remove(char c) {
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

        @Override // io.netty.util.collection.CharObjectMap
        public final Object put(char c, Object obj) {
            throw new UnsupportedOperationException("put");
        }

        @Override // java.util.Map
        public final Set<Character> keySet() {
            return Collections.emptySet();
        }

        @Override // io.netty.util.collection.CharObjectMap
        public final Iterable<CharObjectMap.PrimitiveEntry<Object>> entries() {
            return Collections.emptySet();
        }

        @Override // java.util.Map
        public final Object put(Character ch, Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public final void putAll(Map<? extends Character, ?> map) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public final Collection<Object> values() {
            return Collections.emptyList();
        }

        @Override // java.util.Map
        public final Set<Map.Entry<Character, Object>> entrySet() {
            return Collections.emptySet();
        }
    }

    static final class UnmodifiableMap<V> implements CharObjectMap<V> {
        private Iterable<CharObjectMap.PrimitiveEntry<V>> entries;
        private Set<Map.Entry<Character, V>> entrySet;
        private Set<Character> keySet;
        private final CharObjectMap<V> map;
        private Collection<V> values;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        public final /* bridge */ /* synthetic */ Object put(Character ch, Object obj) {
            return put2(ch, (Character) obj);
        }

        UnmodifiableMap(CharObjectMap<V> charObjectMap) {
            this.map = charObjectMap;
        }

        @Override // io.netty.util.collection.CharObjectMap
        public final V get(char c) {
            return this.map.get(c);
        }

        @Override // io.netty.util.collection.CharObjectMap
        public final V put(char c, V v) {
            throw new UnsupportedOperationException("put");
        }

        @Override // io.netty.util.collection.CharObjectMap
        public final V remove(char c) {
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

        @Override // io.netty.util.collection.CharObjectMap
        public final boolean containsKey(char c) {
            return this.map.containsKey(c);
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
        public final V put2(Character ch, V v) {
            throw new UnsupportedOperationException("put");
        }

        @Override // java.util.Map
        public final V remove(Object obj) {
            throw new UnsupportedOperationException("remove");
        }

        @Override // java.util.Map
        public final void putAll(Map<? extends Character, ? extends V> map) {
            throw new UnsupportedOperationException("putAll");
        }

        @Override // io.netty.util.collection.CharObjectMap
        public final Iterable<CharObjectMap.PrimitiveEntry<V>> entries() {
            if (this.entries == null) {
                this.entries = new Iterable<CharObjectMap.PrimitiveEntry<V>>() { // from class: io.netty.util.collection.CharCollections.UnmodifiableMap.1
                    @Override // java.lang.Iterable
                    public Iterator<CharObjectMap.PrimitiveEntry<V>> iterator() {
                        UnmodifiableMap unmodifiableMap = UnmodifiableMap.this;
                        return new IteratorImpl(unmodifiableMap.map.entries().iterator());
                    }
                };
            }
            return this.entries;
        }

        @Override // java.util.Map
        public final Set<Character> keySet() {
            if (this.keySet == null) {
                this.keySet = Collections.unmodifiableSet(this.map.keySet());
            }
            return this.keySet;
        }

        @Override // java.util.Map
        public final Set<Map.Entry<Character, V>> entrySet() {
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

        class IteratorImpl implements Iterator<CharObjectMap.PrimitiveEntry<V>> {
            final Iterator<CharObjectMap.PrimitiveEntry<V>> iter;

            IteratorImpl(Iterator<CharObjectMap.PrimitiveEntry<V>> it) {
                this.iter = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.iter.hasNext();
            }

            @Override // java.util.Iterator
            public CharObjectMap.PrimitiveEntry<V> next() {
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

        class EntryImpl implements CharObjectMap.PrimitiveEntry<V> {
            private final CharObjectMap.PrimitiveEntry<V> entry;

            EntryImpl(CharObjectMap.PrimitiveEntry<V> primitiveEntry) {
                this.entry = primitiveEntry;
            }

            @Override // io.netty.util.collection.CharObjectMap.PrimitiveEntry
            public char key() {
                return this.entry.key();
            }

            @Override // io.netty.util.collection.CharObjectMap.PrimitiveEntry
            public V value() {
                return this.entry.value();
            }

            @Override // io.netty.util.collection.CharObjectMap.PrimitiveEntry
            public void setValue(V v) {
                throw new UnsupportedOperationException("setValue");
            }
        }
    }
}
