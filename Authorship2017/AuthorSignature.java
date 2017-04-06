
public class AuthorSignature
{
    private String aName;
    private double wordRatio;
    private double wordLength;
    private double hapax;
    private double wordsPerSent;
    private double phrasesPerSentence;
    
    public AuthorSignature(String authorName, double avgWordLength, 
    double differentWordRatio, double hapaxRatio, double avgWordsPerSentence, double avgPhrasesPerSentence )
    {
        aName = authorName;
        wordLength = avgWordLength;
        wordRatio = differentWordRatio;
        hapax = hapaxRatio;
        wordsPerSent = avgWordsPerSentence;
        phrasesPerSentence = avgPhrasesPerSentence;
    }
    
    // you'll need five more methods here
}
