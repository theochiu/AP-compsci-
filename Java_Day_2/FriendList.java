import java.util.TreeSet;

public class FriendList
{
    private TreeSet<String> friends;
    private String name;
    
    public FriendList(String myName)
    {
        name = myName;
        friends = new TreeSet<String>();
    }
    
    public int getNumFriends() { return friends.size();}
    public void addFriend(String who) 
    {
        if (!who.equals(name))
            friends.add(who);
    }
    public void unFriend(String who) {friends.remove(who);}
    public String getFriendSummary()
    { 
        String s = name + "'s friends: ";
        for (String f: friends)
                s += f + ", ";
        s = s.substring(0,s.length()-2);
        return s;
    }


}
