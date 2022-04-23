public class Codec {
    HashMap<String,String> idx = new HashMap<String,String>();
    HashMap<String,String> revIdx = new HashMap<String,String>();
    String key = "";
    String base = "http://tinyurl.com/";
    public String encode(String longUrl) {
        if(idx.containsKey(longUrl))    return base + idx.get(longUrl);
        String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder("");
        do{
            for(int i = 0; i < 6; i++){
                int t = (int)(Math.random() * charSet.length());
                sb.append(charSet.charAt(t));
            }
            key = sb.toString();
        }
        while(idx.containsKey(key));
            idx.put(key, longUrl);
            revIdx.put(longUrl,key);
            return base + key;
    }
    public String decode(String shortUrl) {
        return idx.get(shortUrl.replace(base,""));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));