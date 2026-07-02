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
public class TimeBasedKeyValueStore {
}
