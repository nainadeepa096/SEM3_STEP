package Assignment;
import java.util.*; 


class as05{

    static void wordFrequency(String text) {
      

        text = text.toLowerCase();
        text = text.replace(".", "").replace(",", "");
        String[] words = text.split("\\s+");
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};
        HashMap<String, Integer> map = new HashMap<>();
        

        for (int i = 0; i < words.length; i++) {
          
            boolean stop = false;
            

            for (int j = 0; j < stopWords.length; j++) {
               

                if (words[i].equals(stopWords[j])) {
                    
                    stop = true;
                   
                    break;
                    
                }
            }

            if (!stop) {
               
                map.put(words[i], map.getOrDefault(words[i], 0) + 1);
               
            }
        }

        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(map.entrySet());
        

        list.sort((x, y) -> y.getValue() - x.getValue());
        
        for (int i = 0; i < list.size(); i++) {
           
            System.out.println(list.get(i).getKey() + ": "
                    + list.get(i).getValue());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String text = sc.nextLine();
        
        wordFrequency(text);
       
    }
}
