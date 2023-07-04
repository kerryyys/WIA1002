package py2020;

import java.util.*;

public class Q4HashMap {

    private ArrayList<Entry> map;

    public Q4HashMap() {
        map = new ArrayList<>();
    }

    public void put(String name, String phone) {
        boolean found = false;
        for (Entry entry : map) {
            if (entry.getName().equals(name)) {
                entry.setValue(phone);
                found = true;
                break;
            }
        }
        if (!found) {
            Entry entry = new Entry(name, phone);
            map.add(entry);
        }
    }

    public Entry get(String name) {
        for (Entry entry : map) {
            if (entry.getName().equals(name)) {
                return entry;
            }
        }
        return null;
    }
}

class Entry {
    private String name;
    private String value;

    public Entry(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}