/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        if (size() > 0) {
            for (int i = 0; i < size(); i++) storage[i] = null;
        }
    }

    void save(Resume r) {
    }

    Resume get(String uuid) {
        return null;
    }

    void delete(String uuid) {
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
