import java.util.ArrayList;
 
public class DigAdministration
{
    public static void main(String[] args)
    {
        System.out.println("FIRST SITE:");
        ArrayList<Archaeologist> group1 = new ArrayList<Archaeologist>();
        group1.add(new Archaeologist("CJ", "Gators", 56432));
        group1.add(new Archaeologist("Theo", "Iowa", 71650));
        group1.add(new Archaeologist("Emma", "Boston", 57735));
        group1.add(new Archaeologist("David", "Gators", 34902));
        group1.add(new Archaeologist("Zack", "Iowa", 63028));
        group1.add(new Archaeologist("Luca", "Bulldogs", 11853));
        group1.add(new Archaeologist("Emily", "Gators", 44822));
        group1.add(new Archaeologist("Izzy", "Gators", 12693));
        Site site1 = new Site(group1, 3, 5);
        site1.printSiteInfo();

        System.out.println();
        System.out.println("SECOND SITE:");        
        ArrayList<Archaeologist> group2 = new ArrayList<Archaeologist>();
        group2.add(new Archaeologist("RJ", "Gators", 65423));
        group2.add(new Archaeologist("Connor", "Iowa", 17549));
        group2.add(new Archaeologist("Grace", "Boston", 72239));
        group2.add(new Archaeologist("Will", "Gators", 98155));
        group2.add(new Archaeologist("Sabrina", "Bulldogs", 12808));
        group2.add(new Archaeologist("Brett", "Gators", 28192));
        group2.add(new Archaeologist("Jack", "Gators", 74347));
        group2.add(new Archaeologist("Jetta", "Iowa", 14013));
        group2.add(new Archaeologist("Max", "Gators", 52681));
        group2.add(new Archaeologist("Ethan", "Gators", 19206));
        group2.add(new Archaeologist("Alex", "Gators", 48460));
        group2.add(new Archaeologist("Trey", "Boston", 93277));
        group2.add(new Archaeologist("Gabi", "Gators", 41932));
        group2.add(new Archaeologist("James", "Gators", 36998));
        group2.add(new Archaeologist("Kylee", "Bulldogs", 30078));
        group2.add(new Archaeologist("Evan", "Gators", 22495));
        group2.add(new Archaeologist("Eliza", "Gators", 30236));
        group2.add(new Archaeologist("Josh", "Boston", 68204));
        group2.add(new Archaeologist("Robbie", "Iowa", 73451));

        Site site2 = new Site(group2, 4, 2);
        site2.printSiteInfo();

        System.out.println();
        System.out.println("SECOND SITE AFTER REMOVING \"Iowa\":");
        int removed = site2.clearSomeQuadrants("Iowa");
        site2.printSiteInfo();
        System.out.println("Number removed = " + removed);
    }
}
