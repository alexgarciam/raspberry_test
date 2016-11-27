package ledSamples;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

/**
 * 
 * @author alejandro
 *
 * Sample of one led blinking in Java
 */
public class TwoLedControl {
	
	
    public static void main(String[] args) throws InterruptedException {
    	
        // get a handle to the GPIO controller
    	final GpioController gpio = GpioFactory.getInstance();
        
        // creating the pin with parameter PinState.HIGH
        // will instantly power up the pin
        final GpioPinDigitalOutput pin0 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "PinLED", PinState.HIGH);
        final GpioPinDigitalOutput pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "PinLED", PinState.LOW);
        System.out.println("light is: ON");
                
        for (int i = 0; i <100; i++) {
        	 // wait 2 seconds
            Thread.sleep(2000);
            
            // turn off GPIO 1
            pin0.low();
            pin1.pulse(2000, true);
            System.out.println("light is: OFF");
            // wait 1 second
            Thread.sleep(2000);
            // turn on GPIO 1 for 1 second and then off
            System.out.println("light is: ON for 1 second");
            pin1.low();
            pin0.pulse(2000, true);
			
		}
       
        
        // release the GPIO controller resources
        gpio.shutdown();
    }
}