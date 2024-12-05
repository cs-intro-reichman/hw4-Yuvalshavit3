public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",
            "The team showed great Synergy in the last project",
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }

    // Iterates through all the sentences.
    // If a sentence contains one or more of the kewords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        String newArr [] = new String[sentences.length];
        for(int i = 0; i < sentences.length; i++){
            newArr[i] = sentences [i];
        }
        

        for(int i = 0; i < newArr.length; i++){ //transforms all letters to lower case
            String sentence = newArr[i];
            for(int j = 0; j < sentence.length(); j++){
                char charat = sentence.charAt(j);
                if(charat < 91 && charat > 64){
                    charat = (char) (charat + 32);
                    if(j == 0){
                        sentence = charat + sentence.substring(j + 1, sentence.length());
                        newArr[i] = sentence;
                    } else {
                        sentence = sentence.substring(0, j) + charat + sentence.substring(j + 1, sentence.length());
                        newArr[i] = sentence;
                    }
                }
            }
        }

        for(int i = 0; i < keywords.length; i++){
            String word = keywords[i];
            for(int j = 0; j < word.length(); j++){
                char charat = word.charAt(j);
                if(charat < 91 && charat > 64){
                    charat = (char) (charat + 32);
                    if(j == 0){
                        word = charat + word.substring(j + 1, word.length());
                        keywords[i] = word;
                    } else {
                        word = word.substring(0, j) + charat + word.substring(j + 1, word.length());
                        keywords[i] = word;
                    }
                }
        }
    }

        for(int j = 0; j < newArr.length; j++){
            String sentence = newArr[j];
            for(int i = 0; i < keywords.length; i++){
                String word = keywords[i];
                    boolean contains = sentence.contains(word);
                    if(contains){
                        System.out.println(sentences[j]);
                    }
                
            }

        }
    }
}
