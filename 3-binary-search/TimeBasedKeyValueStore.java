/**
 * 
 * https://neetcode.io/problems/time-based-key-value-store/question?list=neetcode150
 * 
 * Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.
 * Implement the TimeMap class:
 * TimeMap() Initializes the object of the data structure.
 * void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
 * String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".
 * 
 * Constraints:
 * 1 <= key.length, value.length <= 100
 * key and value only include lowercase English letters and digits.
 * 0 <= timestamp <= 10^7
 * All the timestamps of set are strictly increasing.
 */
class TimeBasedKeyValueStore {
    Map<String, List<Pair<Integer, String>>> hm;

    public TimTimeBasedKeyValueStoreeMap() {
        this.hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair<Integer, String>> ls = this.hm.computeIfAbsent(key, k -> new ArrayList<>());
        ls.add(new Pair<>(timestamp, value));
        this.hm.put(key, ls);
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> ls = this.hm.getOrDefault(key, new ArrayList<>());
        int l = 0;
        int r = ls.size() - 1;
        String res = "";
        
        while (l <= r) {
            int m = (r - l) / 2 + l;
            Pair<Integer, String> p = ls.get(m);
            if (timestamp >= p.getKey()) {
                res = ls.get(m).getValue();
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return res;
    }
}

class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
