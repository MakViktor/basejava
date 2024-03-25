package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume r) {
        int index = Arrays.binarySearch(storage, 0, size, r);
        if (size == STORAGE_LIMIT) {
            System.out.println("Нет возможности добавить резюме. База заполнена.");
        } else if (index >= 0) {
            System.out.println("Резюме с uuid: " + r.getUuid() + " уже имеется в базе.");
        } else if (-index - 1 < size) {
            System.arraycopy(storage, -index - 1, storage, -index, size + index + 1);
            storage[-index - 1] = r;
            size++;
        } else {
            storage[-index - 1] = r;
            size++;
        }
    }

//    public void delete(String uuid) {
//        int index = getIndex(uuid);
//        if (index < 0) {
//            System.out.println("Резюме с uuid: " + uuid + " отсутствует в базе.");
//            return;
//        }
//        System.arraycopy(storage, index + 1, storage, index, size - index);
//        storage[size] = null;
//        size--;
//    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    //System.arraycopy(storage, index + 1, storage, index, size - index);

}
