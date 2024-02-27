/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
//        if (size() > 0) {
//            for (int i = size() - 1; i >= 0; i--) storage[i] = null;
//        }
        while (size > 0) {
            storage[--size] = null;
        }
    }

    void save(Resume r) {
//        for (Resume res : getAll()) {
//            if (res.uuid.equals(r.uuid)) return;
//        }
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if (storage[i].uuid.equals(r.uuid)) return;
            }
        }
        storage[size++] = r;
    }

    Resume get(String uuid) {
//        if (size > 0) {
//            Resume result = new Resume();
//            for (Resume r : getAll()) {
//                if (r.uuid.equals(uuid)) result = r;
//            }
//            return result;
//        } else {
//            return null;
//        }
        if (size == 0) return null;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) return storage[i];
        }
        return null;
    }

    void delete(String uuid) {
        if (size > 0) {
            for (int i = 0; i < size(); i++) {
                if (storage[i].uuid.equals(uuid)) {
//                    if (i == storage.length - 1) storage[i] = null;
//                    else {
//                        for (int j = i; j < size(); j++) {
//                            if (j < storage.length - 1) storage[j] = storage[j + 1];
//                            else storage[j] = null;
//                        }
//                    }
                    storage[i] = storage[--size];
                    storage[size] = null;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] allResume = new Resume[size()];
        if (size() > 0) {
            for (int i = 0; i < allResume.length; i++) {
                allResume[i] = storage[i];
            }
        }
        return allResume;
    }

    int size() {
/*
        int i = 0;
        while (storage[i] != null) {
            i++;
        }
*/
        return size;
    }
}
