
import acm.program.*;

public class HotelTelevisionRunner extends ConsoleProgram
{

	public void run()
	{
		HotelTelevision tv;
		tv = new HotelTelevision(4);
		tv.channelUp();
		int channel = tv.getChannel();
		tv.channelUp();
		println("You are watching " + tv.getChannelName());
	}


}
