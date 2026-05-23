


class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        char prev = ' ';
        for (char c : path.toCharArray()) {
            if (prev == '/' && c == '/') {
                continue;
            }
            sb.append(c);
            prev = c;
        }
        String clean = sb.toString();
        Stack<String> stk = new Stack<>();
        for (String c : clean.split("/")) {
            System.out.println(c);
            //case go back
            if (c.equals("..")) {
                System.out.println("e");
                if (!stk.isEmpty()) {
                    stk.pop();
                    continue;
                }
                continue;
            }
            else if (c.equals(".")) {
                continue;
            }
            else if (c.isEmpty()) {
                continue;
            }
            else {
                stk.push(c);
                continue;
            }
        }
        sb.setLength(0);
        int size = stk.size();
        for (int i  = 0; i < size; i++) {
            sb.insert(0, stk.pop());
            sb.insert(0, "/");
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}