class Solution {
    public int minOperations(String[] logs) {
        // List<String> list = new ArrayList();
        // for(int i = 0; i < logs.length ; i++){
        //     if(logs[i].equals("./"))    continue;
        //     else if(logs[i].equals("../")){
        //         if(list.size() > 0) list.remove(list.size()-1);
        //     }
        //     else{
        //         list.add("V");
        //     }
        // }
        // return list.size();
        int res = 0;
        for (String s : logs) {
            if (s.equals("../")) res = Math.max(0, --res);
            else if (s.equals("./")) continue;
            else res++;
        }
        return res;
    }
}