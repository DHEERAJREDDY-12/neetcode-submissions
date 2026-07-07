

class MyCalendar {
    TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        if (map.isEmpty()) {
            map.put(startTime, endTime);
            return true;
        } 
        else {
            Integer bef = map.floorKey(startTime);
            Integer aft = map.ceilingKey(startTime);

            if (bef == null && aft == null) {
                map.put(startTime, endTime);
                return true;
            }
            else if (bef == null) {
                if (endTime <= aft) {
                    map.put(startTime, endTime);
                    return true;
                }
            }
            else if (aft == null) {
                if (startTime >= map.get(bef)) {
                    map.put(startTime, endTime);
                    return true;
                }
            }
            else {
                if (startTime >= map.get(bef) && endTime <= aft) {
                    map.put(startTime, endTime);
                    return true;
                }
            }
        }

        return false;
    }
}