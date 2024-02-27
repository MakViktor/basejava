/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        while (size > 0) {
            storage[--size] = null;
        }
    }

    void save(Resume r) {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if (storage[i].uuid.equals(r.uuid)) return;
            }
        }
        storage[size++] = r;
    }

    Resume get(String uuid) {
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
        return size;
    }
}
