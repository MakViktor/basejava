package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void removeElement(int index) {
        size--;
        storage[index] = storage[size];
        storage[size] = null;
    }

    @Override
    protected void addElement(Resume resume, int index) {
        storage[size] = resume;
        size++;
    }
}
