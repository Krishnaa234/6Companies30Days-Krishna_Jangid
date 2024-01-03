//Day1-2933. High-Access Employees
//You are given a 2D 0-indexed array of strings, access_times, with size n. For each i where 0 <= i <= n - 1, access_times[i][0] represents the name of an employee, and access_times[i][1] represents the access time of that employee. All entries in access_times are within the same day.

// The access time is represented as four digits using a 24-hour time format, for example, "0800" or "2250".

// An employee is said to be high-access if he has accessed the system three or more times within a one-hour period.

class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        
        Map<String, List<Integer>> Ma = new HashMap<>();
        for(List<String> a:access_times) {
            if(!Ma.containsKey(a.get(0))) {
                Ma.put(a.get(0), new ArrayList<>());
            }
            char[] s = a.get(1).toCharArray();
            int h = (s[0]-'0')*10 + s[1]-'0';
            int m = (s[2]-'0')*10 + s[3]-'0';
            Ma.get(a.get(0)).add(h*60+m);
        }
        List<String> ans = new ArrayList<>();
        for(String key: Ma.keySet()) { 
            List<Integer> v = Ma.get(key);
            Collections.sort(v);
            for(int i=0; i<v.size()-2; i++) {
                if(v.get(i+2)-v.get(i)<=59) {
                    ans.add(key);
                    break;
                }
            }
        }
        return ans;
    }
}
