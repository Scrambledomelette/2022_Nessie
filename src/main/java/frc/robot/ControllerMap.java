package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class ControllerMap {
    private Joystick joystickleft;
    private Joystick joystickright;
    private Joystick joystickmanipulator;
    private boolean togglestrafe;
    private boolean strafeleft;
    private boolean straferight;
    private double leftPercentage;
    private double rightPercentage;
    private boolean holdstrafe;
    private boolean raiselift;
    private boolean lowerlift;
    private boolean allignrobot;
    private boolean alligndistance;
    private boolean allignandfire;
    
    public ControllerMap() {
        joystickleft = new Joystick(0);
        joystickright = new Joystick(1);
        joystickmanipulator = new Joystick(2);
        holdstrafe = false;

        checkAllControls();    
    }

    public void periodic() {
        checkAllControls();
        if (togglestrafe){
            holdstrafe = !holdstrafe;
     
        }
    }

    private void checkAllControls() {
        allignrobot = joystickright.getRawButton(3);
        alligndistance = joystickright.getRawButton(4);
        allignandfire = joystickright.getRawButton(2);
        togglestrafe = joystickleft.getRawButtonPressed(2);
        strafeleft = joystickleft.getRawButton(3);
        straferight = joystickright.getRawButton(4);
        lowerlift = joystickmanipulator.getRawButton(3);
        raiselift = joystickmanipulator.getRawButton(5);
        if (Math.abs(joystickleft.getRawAxis(1)) < .2){
            leftPercentage = 0;
        }
        else{
            leftPercentage = joystickleft.getRawAxis(1);
        }
        if (Math.abs(joystickright.getRawAxis(1)) < .2){
            rightPercentage = 0;
        }
        else{
            rightPercentage = joystickright.getRawAxis(1);
        }
    }

    public double getLeftPercentage(){
        return leftPercentage;
    }
    public double getRightPercentage(){
        return rightPercentage;
    }
    public boolean getStrafeToggle(){
        return togglestrafe;
    }
    public boolean getstrafe() {
        return holdstrafe;
    }
    public boolean getstrafeleft() {
        return strafeleft;
    }

    public boolean getstraferight() {
        return straferight;
    }
    public boolean getlowerlift() {
        return lowerlift;
    }
    public boolean getraisedlift() {
        return raiselift;
    }
    public boolean getAllignStart() {
        return allignrobot;
    }
    public boolean getallignDistance(){
        return alligndistance;
    }
    public boolean allignAndFire(){
        return allignandfire;
    }

}
