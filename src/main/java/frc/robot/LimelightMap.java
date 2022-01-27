package frc.robot;

import edu.wpi.first.networktables.NetworkTableInstance;

public class LimelightMap {
    private double yAxis;
    private double xAxis;
    private double visibility;
    private double distance;
    private double goalAngle;
    private double hypotenuseAngle;
    private boolean allClearAxis;
    private boolean allClearDistance;
    public boolean isTargetVisible() {
     return visibility == 1;
    }

    public void updatelimelight() {
    //This is the part that gets the different axis fro mthe limelight.
         yAxis = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
         visibility = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
         if (visibility == 1){
            xAxis = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
           }
    }
    public void updateDistance() {
        double goalHeight = 267; 
        double cameraHeight = 97;
        double mountedAngle = 45;
        goalAngle = yAxis;    
        hypotenuseAngle = Math.tan(Math.toRadians(mountedAngle + goalAngle));
        double oppositeAnlgeHeight = goalHeight - cameraHeight;
        distance = oppositeAnlgeHeight / hypotenuseAngle;
    }

    // use to get the axis in other classes or something, idk lol
    public double obtainXAxis() {
        return xAxis;
    }

    public double obtainYAxis() {
        return yAxis;
    }
  //This belongs in the drivetrain but im writing this in a different robot so nope kekw
    
  public void driveToAllignShot() {
        updatelimelight();    
        checkYourNuts();
        if (xAxis > 2) {
            DriveTrain.leftDrive.set(0.3);
            DriveTrain.rightDrive.set(0.3);
            System.out.println("this is the X axis" + xAxis);
        }
        else if (xAxis < -2) {
            DriveTrain.leftDrive.set(-0.3);
            DriveTrain.rightDrive.set(-0.3);
            System.out.println("this is the X axis" + xAxis);
        }
        else {
            allClearAxis = true;
        }
    }
    public void driveToAllignDistance() {
        updatelimelight();
        updateDistance();
        checkYourNuts();
        if (distance < 200) {
            DriveTrain.leftDrive.set(-0.3);
            DriveTrain.rightDrive.set(0.3);
            System.out.println(distance);
        } else if (distance > 215) {
            DriveTrain.leftDrive.set(0.3);
            DriveTrain.rightDrive.set(-0.3);
            System.out.println(distance);
        } else {
            allClearDistance = true;
        }
    }

    private void checkYourNuts() {
        if (allClearAxis = true) {
            if (allClearDistance = true) {
                System.out.println("ROCK AND STONE");
            }
        }
    }
    
}

