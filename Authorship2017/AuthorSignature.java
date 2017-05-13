import java.util.*;
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

    public String getAuthorName(){
        return aName;
    }

    public double getAverageWordLength(){
        return wordLength;
    }

    public double getDifferentWordRatio(){
        return wordRatio;
    }

    public double getHapaxRatio(){
        return hapax;
    }

    public double getAverageWordsPerSentence(){
        return wordsPerSent;
    }

    public double getAveragePhrasesPerSentence(){
        return phrasesPerSentence;
    }
}




