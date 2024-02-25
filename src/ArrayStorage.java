/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        if (size() > 0) {
            for (int i = size() - 1; i >= 0; i--) storage[i] = null;
        }
    }

    void save(Resume r) {
        for (Resume res : getAll()) {
            if (res.uuid.equals(r.uuid)) return;
        }
        storage[size()] = r;
    }

    Resume get(String uuid) {
        if (size() > 0) {
            Resume result = new Resume();
            for (Resume r : getAll()) {
                if (r.uuid.equals(uuid)) result = r;
            }
            return result;
        } else {
            return null;
        }
    }

    void delete(String uuid) {
        if (size() > 0) {
            for (int i = 0; i < size(); i++) {
                if (storage[i].uuid.equals(uuid)) {
                    if (i == storage.length - 1) storage[i] = null;
                    else {
                        for (int j = i; j < size(); j++) {
                            if (j < storage.length - 1) storage[j] = storage[j + 1];
                            else storage[j] = null;
                        }
                    }
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] allResums = new Resume[size()];
        if (size() > 0) {
            for (int i = 0; i < allResums.length; i++) {
                allResums[i] = storage[i];
            }
        }
        return allResums;
    }

    int size() {
        int i = 0;
        while (storage[i] != null) {
            i++;
        }
        return i;
    }
}
