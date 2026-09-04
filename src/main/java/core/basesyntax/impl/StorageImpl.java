package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    Object[] keyArray = new Object[10];
    Object[] valueArray = new Object[10];
    int size;

    @Override
    public void put(K key, V value) {

        for (int i = 0; i < size; i++) {
            if (((keyArray[i] == null) && (key == null)) || ((keyArray[i] != null) && keyArray[i].equals(key))) {
                valueArray[i] = value;
                return;
            }
        }
        keyArray[size] = key;
        valueArray[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (((keyArray[i] == null) && (key == null)) || ((keyArray[i] != null) && keyArray[i].equals(key))) {

                return (V) valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }
}
