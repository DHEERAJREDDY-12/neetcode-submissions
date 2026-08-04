
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));

        if (dead.contains("0000")) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer("0000");
        visited.add("0000");

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current.equals(target)) {
                    return moves;
                }

                for (int position = 0; position < 4; position++) {
                    char[] digits = current.toCharArray();
                    char original = digits[position];

                    digits[position] =
                            original == '9' ? '0' : (char) (original + 1);

                    String forward = new String(digits);

                    if (!dead.contains(forward) && !visited.contains(forward)) {
                        visited.add(forward);
                        queue.offer(forward);
                    }

                    digits[position] =
                            original == '0' ? '9' : (char) (original - 1);

                    String backward = new String(digits);

                    if (!dead.contains(backward) && !visited.contains(backward)) {
                        visited.add(backward);
                        queue.offer(backward);
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}