
import acm.program.*;

public class ThermostatRunner extends ConsoleProgram
{

    public void run()
    {
        Thermostat therm = new Thermostat(60,90);
        therm.warmer();
        println(therm.getValue());
        for (int i = 0; i<10;i++){
            therm.colder();
        }
        println(therm.getValue());
    }

}
