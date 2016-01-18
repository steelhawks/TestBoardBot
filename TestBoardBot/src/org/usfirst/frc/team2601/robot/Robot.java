
package org.usfirst.frc.team2601.robot;

import org.usfirst.frc.team2601.robot.F310;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CameraServer;

/**
 * This is a demo program showing the use of the RobotDrive class.
 * The SampleRobot class is the base of a robot application that will automatically call your
 * Autonomous and OperatorControl methods at the right time as controlled by the switches on
 * the driver station or the field controls.
 *
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SampleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 *
 * WARNING: While it may look like a good choice to use for your code if you're inexperienced,
 * don't. Unless you know what you are doing, complex code will be much more difficult under
 * this system. Use IterativeRobot or Command-Based instead if you're new.
 */
public class Robot extends SampleRobot {
	CameraServer camsrv;
	RobotDrive myRobot;
    Joystick stick1;
    Joystick stick2;
    F310 gamepad;
    CANTalon ct1;
    CANTalon ct2;
    CANTalon ct3;
    CANTalon ct4;
    CANTalon ct5;
    CANTalon ct6;
    CANTalon ct7;
    final String defaultAuto = "Default";
    final String customAuto = "My Auto";
    SendableChooser chooser;

    public Robot() {
    	camsrv = CameraServer.getInstance();
        stick1 = new Joystick(0);
        stick2 = new Joystick(1);
        gamepad = new F310(2);
        ct1 = new CANTalon(1);
        ct2 = new CANTalon(2);
        ct3 = new CANTalon(3);
        ct4 = new CANTalon(4);
        ct5 = new CANTalon(5);
        ct6 = new CANTalon(6);
        ct7 = new CANTalon(7);
    }
    
    public void robotInit() {
    	camsrv.startAutomaticCapture();
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", defaultAuto);
        chooser.addObject("My Auto", customAuto);
        SmartDashboard.putData("Auto modes", chooser);
    }

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the if-else structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
    public void autonomous() {
    	
    	String autoSelected = (String) chooser.getSelected();
//		String autoSelected = SmartDashboard.getString("Auto Selector", defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
    	
    }

    /**
     * Runs the motors with arcade steering.
     */
    public void operatorControl() {
        while (isOperatorControl() && isEnabled()) {
        	ct1.set(stick1.getY());
        	ct2.set(stick1.getX());
        	ct3.set(stick2.getY());
        	ct4.set(stick2.getX());
        	ct5.set(gamepad.getLeftY());
        	ct6.set(gamepad.getRightY());
        	ct7.set(gamepad.getRightX());
        }
        
    }

    /**
     * Runs during test mode
     */
    public void test() {
    }
}
