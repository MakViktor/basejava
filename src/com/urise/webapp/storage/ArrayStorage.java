package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size - 1, null);
        size = 0;
    }

    public void save(Resume r) {
        if (getIndex(r.getUuid()) >= 0) {
            System.out.println("Резюме с uuid: " + r.getUuid() +
                    " уже имеется в базе.");
            return;
        }
        if (size == storage.length)
            System.out.println("Нет возможности добавить резюме. База заполнена.");
        storage[size++] = r;
    }

    public Resume get(String uuid) {
        if (getIndex(uuid) < 0) {
            System.out.println("Резюме с uuid: " + uuid + " отсутствует в базе.");
            return null;
        }
        return storage[getIndex(uuid)];
    }

    public void delete(String uuid) {
        if (getIndex(uuid) < 0) {
            System.out.println("Резюме с uuid: " + uuid + " отсутствует в базе.");
            return;
        }
        storage[getIndex(uuid)] = storage[--size];
        storage[size] = null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    public void update(Resume r) {
        if (getIndex(r.getUuid()) < 0) {
            System.out.println("Резюме " + r.getUuid() +
                    " не может быть обновлено, так как отсутствует в базе");
            return;
        }
        storage[getIndex(r.getUuid())] = r;
    }

    public int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) return i;
        }
        return -1;
    }
}
