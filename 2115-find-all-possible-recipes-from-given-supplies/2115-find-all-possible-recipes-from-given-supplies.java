class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String x : supplies)    map.put(x, 1);
        List<String> list = new ArrayList<>();
        int prev = recipes.length;
        while(true){
            boolean f = false;
            for(int i = 0; i < recipes.length; i++){
                if(!list.contains(recipes[i])){
                    f = true;
                    break;
                }
            }
            if(!f)  break;
            int count = 0;
            for(int i = 0; i < recipes.length; i++){
                if(list.contains(recipes[i]))   continue;
                f = true;
                for(int j = 0; j < ingredients.get(i).size(); j++){
                    if(!map.containsKey(ingredients.get(i).get(j))){
                        count++;
                        f = false;
                        break;
                    }
                }
                if(f){
                    list.add(recipes[i]);
                    map.put(recipes[i],1);
                }
            }
            if(count == prev)   break;
            prev = count;
        }
        return list;
    }
}