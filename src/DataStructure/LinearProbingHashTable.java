package DataStructure;

/**
 * HashTable with Close Hashing 기법 중 Linear Probing 기법
 * TimeComplexity:
 * 일반적인 경우(Collision X): O(1)
 * 최악인 경우(Collision O): O(n)
 */
public class LinearProbingHashTable {

    private Slot[] hashTable;

    class Slot {
        String key;
        String value;

        public Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public LinearProbingHashTable(Integer size) {
        this.hashTable = new Slot[size];
    }

    private Integer hashFunc(String key) {
        return (int)(key.charAt(0)) % hashTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);

        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key == key) {
                this.hashTable[address].value = value;
                return true;
            } else {

                Integer currentAddress = address + 1;
                while (this.hashTable[currentAddress] != null) {
                    if (this.hashTable[currentAddress].key == key) {
                        this.hashTable[currentAddress].value = value;
                        return true;
                    } else {
                        currentAddress++;
                        if (currentAddress >= hashTable.length)
                            return false;
                    }
                }
                this.hashTable[currentAddress] = new Slot(key, value);
            }
        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);

        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key == key)
                return this.hashTable[address].value;
            else {
                Integer currentAddress = address + 1;
                while (this.hashTable[currentAddress] != null) {
                    if (this.hashTable[currentAddress].key == key)
                        return this.hashTable[currentAddress].value;
                    else {
                        currentAddress++;
                        if (currentAddress >= this.hashTable.length)
                            return null;
                    }
                }
            }
        }
        return null;
    }
}
