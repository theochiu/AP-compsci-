
import acm.program.*;

public class HotelRunner extends ConsoleProgram
{

    public void run()
    {
        HotelTelevision tvOne;
        tvOne = new HotelTelevision(3);
        
        HotelTelevision tvTwo = new HotelTelevision(7);
        
        tvOne.channelUp();
        tvTwo.channelDown();
        tvTwo.channelDown();
        tvOne.setChannel(6);
        
        int channel;
        channel = tvTwo.getChannel();
        
        println("The second television is on channel " + channel + ".");
        
        // you can do this, although it doesn't logically make any sense
        channel = 88;
        
        println("The second television is on channel " + channel + ".");
    }


}
