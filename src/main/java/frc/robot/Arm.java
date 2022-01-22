package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;

public class Arm {
    private static TalonSRX arm;
    private static Arm armInstance;
    private static DigitalInput clawSensor;
    private static Solenoid gripSolenoid;

    private Arm() {
        arm = new TalonSRX(Robotmap.LIFT_MOTOR);
        clawSensor = new DigitalInput(Robotmap.CLAW_SENSOR);
        gripSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, Robotmap.GRIP_SOLENOID);
    }

    public static Arm getInstance()
    {
        if (armInstance == null)
        {
            armInstance = new Arm();
        }
        return armInstance;
    }

    public boolean getClawSensor() {
        return clawSensor.get();
    }

    public void startgripping() {
        gripSolenoid.set(false);
    }

    public void stopgripping() {
        gripSolenoid.set(true);
    }
    
    public void limitSwitchInit(){
        arm.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, 0);
        arm.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyClosed, 0);
    }

    public void lowerArm() {
      arm.set(ControlMode.PercentOutput, 0.5);
    }
    
    public void raiseArm() {
        arm.set(ControlMode.PercentOutput, -0.5);
    }
    
    public void stopArm() {
        arm.set(ControlMode.PercentOutput, 0);
      }    
}
