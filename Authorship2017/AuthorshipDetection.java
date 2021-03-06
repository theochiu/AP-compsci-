
import acm.program.*;
import java.util.ArrayList;

public class AuthorshipDetection extends ConsoleProgram
{
    private static final String PUNCTUATION = "'!\",;:.-?)([]<>*#\n\t\r ";
    private static final double[] WEIGHT = {11.0, 33.0, 50.0, 0.4, 4.0};
    private AuthorSignature[] authors;
    private ArrayList<String> sentences;
    private ArrayList<String> words;

    public void run()
    {

    
        loadAuthorSignatures();
        String filename = readLine("Enter file name: ");
        String fileContents = FileHelper.getFileContents(filename);
        fileContents = fileContents.replaceAll("\n", " ");
        sentences = getSentencesFromContents(fileContents);
        words = getAllWordsFromSentences(sentences);


        AuthorSignature unknown = new AuthorSignature("unknown" , computeAverageWordLength(words), computeDifferentWordRatio(words), 
            computeHapaxLegomannaRatio(words), computeAverageWordsPerSentence(sentences), computeSentenceComplexity(sentences));

        println("number of sentences = "+sentences.size());
        println("number of words = " +words.size());
        println("\t"+unknown.getAverageWordLength());
        println("\t"+unknown.getDifferentWordRatio());
        println("\t"+unknown.getHapaxRatio());
        println("\t"+unknown.getAverageWordsPerSentence());
        println("\t"+unknown.getAveragePhrasesPerSentence());
        for(AuthorSignature author : authors){
            println(author.getAuthorName()+": "+computeScore(author, unknown));
        }
        findWinner(unknown);

    

        //test

        
        

    //    println(computeScore(authors[1], authors[2]));

        // println(computeAverageWordsPerSentence(sentences));

        // println(computeSentenceComplexity(sentences));

        // println(computeHapaxLegomannaRatio(words));

        // println(computeDifferentWordRatio(words));

/*
        println(words.size());
        println(computeAverageWordLength(words));
        // println("Number of sentences = "+ sentences.size());
*/

    /*
        for(int i=0;i<20;i++){
            // println(sentences.get(i)+"\n");
            println(getWordsFromSentence(sentences.get(1)).get(i));
        }
    */

        /*

        ArrayList<String> sentences = getSentencesFromContents(fileContents);
        ArrayList<String> allwords = getAllWordsFromSentences(sentences);
        for(int i=0;i<20;i++){
            println(allwords.get(i));

        */

            /*
        println(clean(",don't."));
        System.out.println(clean(",don't."));
            */
    
    }

    // you'll do tasks #2 through #12 here

    private ArrayList<String> getSentencesFromContents(String fileContents){
        ArrayList<String> sentences = new ArrayList<String>();
        /*
        while(fileContents.indexOf(".")!=-1){
            sentences.add(fileContents.substring(0,fileContents.indexOf(".")+1));
            fileContents = fileContents.substring(fileContents.indexOf(".")+1);
        }
        */

        while (fileContents.length()>0)
         {

            int period = fileContents.indexOf(".");
            if (period == -1) period = fileContents.length();
                        int qm = fileContents.indexOf("?");
            if (qm == -1) qm = fileContents.length();
                        int ex = fileContents.indexOf("!");
            if (ex == -1) ex = fileContents.length();
            int champ = period;
            if (qm < champ) champ = qm;
            if (ex < champ) champ = ex;
            if (champ == fileContents.length())
            {

                sentences.add(fileContents);
                return sentences;
            }
            String sentence = clean(fileContents.substring(0, champ));
            if (sentence.length()>0)
                sentences.add(sentence);
            fileContents = fileContents.substring(champ+1);


         }   

        return sentences;
    }
    
    private ArrayList<String> getWordsFromSentence(String sentence) {
        ArrayList<String> words = new ArrayList<String>();

        while(sentence.indexOf(" ")!=-1){
            String word = clean(sentence.substring(0,sentence.indexOf(" ")+1));
            if (word.length()>0)
                 words.add(word);
            sentence = sentence.substring(sentence.indexOf(" ")+1);
        }
        String word = clean(sentence);
        if (word.length()>0)
            words.add(word);
        return words;
    }

    private ArrayList<String> getAllWordsFromSentences(ArrayList<String> sentences){
        ArrayList<String> allwords = new ArrayList<String>();
        ArrayList<String> result = new ArrayList<String>();

        for(String sentence : sentences){
            result = getWordsFromSentence(sentence);
            for(String word : result){
                allwords.add(word);
            }
        }
        return allwords;
    }

    private String clean(String word) {
        word = word.toLowerCase();
        
        if(word.length()==0)
                return word;
        while (PUNCTUATION.indexOf(word.substring(0, 1)) != -1) {
            word=word.substring(1);

            if(word.length()==0)
                return word;
        }

        while(PUNCTUATION.indexOf(word.substring(word.length()-1, word.length()))!=-1){
            word=word.substring(0, word.length()-1);

            if(word.length()==0)
                return word;
        }
    
        return word;
    }


    private double computeAverageWordLength(ArrayList<String> words) {
        int total = 0;
        for (String word : words) {
            total += word.length();
        }
        return (1.*total)/(words.size());
    }

    private double computeDifferentWordRatio(ArrayList<String> words){
        ArrayList<String> uniquewords = new ArrayList<String>();
        for(String word : words){
            if(!uniquewords.contains(word)){
                uniquewords.add(word);
            }
        }
        return uniquewords.size()/(words.size()*1.0);
    }

    private double computeHapaxLegomannaRatio(ArrayList<String> words) {
        ArrayList<String> appearOnce = new ArrayList<String>();
        ArrayList<String> appearTwice = new ArrayList<String>();
        for(String word : words) {
            if (!appearOnce.contains(word)) {
                appearOnce.add(word);
            } else if (appearOnce.contains(word) && !(appearTwice.contains(word))) {
                appearTwice.add(word);
            }
        }
        return (appearOnce.size() - appearTwice.size())/(1.0*words.size());
    }

    private double computeSentenceComplexity(ArrayList<String> sentences) {
        double numPhrases = 0;
        String punc = ":;,";
        for (String sentence : sentences) {
            int ctr = 1;
            for (int i=0; i<sentence.length()-1; i++) {
                if (punc.indexOf(sentence.substring(i, i+1)) != -1) {
                    ctr++;
                }
            }
            numPhrases += ctr;
        }
        return numPhrases/(1.*sentences.size());
    }

    private double computeAverageWordsPerSentence(ArrayList<String> sentences){
        return getAllWordsFromSentences(sentences).size()*1./sentences.size();
    }

    

    private double computeScore(AuthorSignature first, AuthorSignature second){
        double score = 0;

        score += Math.abs(first.getAverageWordLength() - second.getAverageWordLength()) * WEIGHT[0];
        score += Math.abs(first.getDifferentWordRatio() - second.getDifferentWordRatio())* WEIGHT[1];
        score += Math.abs(first.getHapaxRatio() - second.getHapaxRatio())* WEIGHT[2];
        score += Math.abs(first.getAverageWordsPerSentence() - second.getAverageWordsPerSentence())* WEIGHT[3];
        score += Math.abs(first.getAveragePhrasesPerSentence() - second.getAveragePhrasesPerSentence())* WEIGHT[4];

        return score;
    }

    // I wrote this method for you
    private void loadAuthorSignatures()
    {
        authors = new AuthorSignature[13];
        authors[0] = new AuthorSignature("Agatha Christie", 4.40212537354, 0.103719383127, 0.0534892315963, 10.0836888743, 1.90662947161);
        authors[1] = new AuthorSignature("Alexandre Dumas", 4.38235547477, 0.049677588873, 0.0212183996175, 15.0054854981, 2.63499369483);
        authors[2] = new AuthorSignature("Brothers Grimm", 3.96868608302, 0.0529378997714, 0.0208217283571, 22.2267197987, 3.4129614094);
        authors[3] = new AuthorSignature("Charles Dickens", 4.34760725241, 0.0803220950584, 0.0390662700499, 16.2613453121, 2.87721723105);
        authors[4] = new AuthorSignature("Douglas Adams", 4.33408042189, 0.238435104414, 0.141554321967, 13.2874354561, 1.86574870912);
        authors[5] = new AuthorSignature("Emily Bronte", 4.35858972311, 0.089662598104, 0.0434307152651, 16.1531664212, 2.93439550141);
        authors[6] = new AuthorSignature("Fyodor Dostoevsky", 4.34066732195, 0.0528571428571, 0.0233414043584, 12.8108273249, 2.16705364781);
        authors[7] = new AuthorSignature("James Joyce", 4.52346300961, 0.120109917189, 0.0682315429476, 10.9663296918, 1.79667373227);
        authors[8] = new AuthorSignature("Jane Austen", 4.41553119311, 0.0563451817574, 0.02229943808, 16.8869087498, 2.54817097682);
        authors[9] = new AuthorSignature("Lewis Caroll", 4.22709528497, 0.111591342227, 0.0537026953444, 16.2728740581, 2.86275565124);
        authors[10] = new AuthorSignature("Mark Twain", 4.33272222298, 0.117254215021, 0.0633074228159, 14.3548573631, 2.43716268311);
        authors[11] = new AuthorSignature("Sir Arthur Conan Doyle", 4.16808311494, 0.0822989796874, 0.0394458485444, 14.717564466, 2.2220872148);
        authors[12] = new AuthorSignature("William Shakespeare", 4.16216957834, 0.105602561171, 0.0575348730848, 9.34707371975, 2.24620146314);
    }

    private void findWinner(AuthorSignature unknown){
        double min = computeScore(unknown, authors[0]);
        int ind = 0;
        for(int i = 1; i<12; i++){
            if(computeScore(unknown, authors[i])<min){
                min = computeScore(unknown,authors[i]);
                ind = i;
            }
        }
        println("The predicted author is: "+authors[ind].getAuthorName());
    }

}
