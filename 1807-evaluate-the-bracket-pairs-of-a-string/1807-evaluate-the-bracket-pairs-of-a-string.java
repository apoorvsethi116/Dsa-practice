class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder ans = new StringBuilder();
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < knowledge.size(); i++) {
            map.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }

        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                int j = i + 1;
                while (s.charAt(j) != ')') {
                    j++;
                }
                if (map.containsKey(s.substring(i + 1, j))) {
                    ans.append(map.get(s.substring(i + 1, j)));
                } else {
                    ans.append("?");
                }
                i = j + 1;
            }else{
                ans.append(s.charAt(i));
                i++;
            }

        }

        return ans.toString();
    }
}