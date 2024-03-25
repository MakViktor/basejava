package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 10000;

    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public final void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (size == STORAGE_LIMIT) {
            System.out.println("Нет возможности добавить резюме. База заполнена.");
        } else if (index >= 0) {
            System.out.println("Резюме с uuid: " + r.getUuid() + " уже имеется в базе.");
        } else {
            addElement(r, index);
        }
    }

    public final Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            showErrorMessage(uuid);
            return null;
        }
        return storage[index];
    }

    public final void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            showErrorMessage(uuid);
            return;
        }
        removeElement(index);
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    public int size() {
        return size;
    }

    public final void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            showErrorMessage(r.getUuid());
            return;
        }
        storage[index] = r;
    }

    protected abstract int getIndex(String uuid);

    private void showErrorMessage(String uuid) {
        System.out.println("Резюме с uuid: " + uuid + " отсутствует в базе.");
    }

    protected abstract void removeElement(int index);

    protected abstract void addElement(Resume resume, int index);
}
