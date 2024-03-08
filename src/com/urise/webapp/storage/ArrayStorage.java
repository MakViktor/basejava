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
//        while (size > 0) {
//            storage[--size] = null;
//        }
        Arrays.fill(storage, 0, size - 1, null);
        size = 0;
    }

    public void save(Resume r) {
        if (getIndex(r.getUuid()) >= 0) {
            System.out.println("Резюме с uuid: " + r.getUuid() +
                    " уже имеется в базе.");
            return;
        }
        storage[size++] = r;
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) return storage[i];
        }
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                storage[i] = storage[--size];
                storage[size] = null;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
//        Resume[] allResume = new Resume[size];
//        for (int i = 0; i < allResume.length; i++) {
//            allResume[i] = storage[i];
//        }
//        allResume;
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    public void update(Resume r) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(r.getUuid())) {
                storage[i] = r;
                return;
            }
        }
        System.out.println("Резюме " + r.getUuid() +
                " не может быть обновлено, так как отсутствует в базе");
    }

    public int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) return i;
        }
        return -1;
    }
}
