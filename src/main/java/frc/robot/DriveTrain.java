package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
//hi
public class DriveTrain {
    private static Solenoid strafingSolenoids = new Solenoid(PneumaticsModuleType.CTREPCM, Robotmap.STRAFING_SOLENOIDS);
    private static DriveTrain driveTrainInstance;

// these two should be changed back to private later
    public static Talon rightDrive = new Talon(Robotmap.RIGHT_DRIVE);
    public static Talon leftDrive = new Talon(Robotmap.LEFT_DRIVE);
    
    private static TalonSRX frontStrafe = new TalonSRX(Robotmap.FRONT_STRAFE);
    private static TalonSRX backStrafe = new TalonSRX(Robotmap.BACK_STRAFE);

    private DriveTrain() {
        
    }

    public static DriveTrain getInstance()
    {
        if (driveTrainInstance == null)
        {
            driveTrainInstance = new DriveTrain();
        }
        return driveTrainInstance;
    }
    

    public void drive(double rightPercentage, double leftPercentage) {
        rightDrive.set(rightPercentage);
        leftDrive.set(leftPercentage * -1);
    }
    
    public void strafing(double leftPercentage) {
        frontStrafe.set(ControlMode.PercentOutput, leftPercentage);
        backStrafe.set(ControlMode.PercentOutput, leftPercentage * -1);
        System.out.println("deez");
    }

    public void straferight(){
        frontStrafe.set(ControlMode.PercentOutput, -0.5);
        backStrafe.set(ControlMode.PercentOutput, -0.5);
    }
    public void strafeleft(){
        frontStrafe.set(ControlMode.PercentOutput, 0.5);
        backStrafe.set(ControlMode.PercentOutput, 0.5);
    }
    public void stopstrafe(){
        frontStrafe.set(ControlMode.PercentOutput, 0);
        backStrafe.set(ControlMode.PercentOutput, 0);
    }

    public void strafe() {
        strafingSolenoids.set(true); 
    }
    
    public void destrafe() {
        strafingSolenoids.set(false);
    }
    
}
