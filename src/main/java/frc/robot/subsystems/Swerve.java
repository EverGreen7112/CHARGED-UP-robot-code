package frc.robot.subsystems;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Swerve extends SubsystemBase{

    private SwerveWheel m_rightFront;
    private SwerveWheel m_leftFront;
    private SwerveWheel m_rightBack;
    private SwerveWheel m_leftBack;

    public static final Swerve swerve = new Swerve(); //get instance
    
    public Swerve(){
        this.m_rightFront = new SwerveWheel(Constants.MotorPorts.RIGHT_UP_DRIVE_MOTOR_PORT, Constants.MotorPorts.RIGHT_UP_TURN_MOTOR_PORT);
        this.m_leftFront = new SwerveWheel(Constants.MotorPorts.LEFT_UP_DRIVE_MOTOR_PORT, Constants.MotorPorts.LEFT_UP_DRIVE_MOTOR_PORT);
        this.m_rightBack = new SwerveWheel(Constants.MotorPorts.RIGHT_DOWN_DRIVE_MOTOR_PORT, Constants.MotorPorts.RIGHT_DOWN_DRIVE_MOTOR_PORT);
        this.m_leftBack = new SwerveWheel(Constants.MotorPorts.LEFT_DOWN_DRIVE_MOTOR_PORT, Constants.MotorPorts.LEFT_DOWN_DRIVE_MOTOR_PORT);
    }

    public void set(double angle, double ms){
        m_rightFront.turnTo(angle);
        m_rightBack.turnTo(angle);
        m_leftFront.turnTo(angle);
        m_leftBack.turnTo(angle);

        m_rightFront.setSpeed(ms);
        m_leftFront.setSpeed(ms);
        m_rightBack.setSpeed(ms);
        m_leftBack.setSpeed(ms);
    }
    public void set(double rightFrontAngle, double rightBackAngle, double leftFrontAngle, double leftBackAngle, 
    double rightFrontSpeed, double rightBackSpeed, double leftFrontSpeed, double leftBackSpeed){
        m_rightFront.turnTo(rightFrontAngle);
        m_rightBack.turnTo(rightBackAngle);
        m_leftFront.turnTo(leftFrontAngle);
        m_leftBack.turnTo(leftBackAngle);

        m_rightFront.setSpeed(rightFrontSpeed);
        m_leftFront.setSpeed(rightBackSpeed);
        m_rightBack.setSpeed(leftFrontSpeed);
        m_leftBack.setSpeed(leftBackSpeed);
    }
    public void setWheelsAngle(double angle){
        m_rightFront.turnTo(angle);
        m_rightBack.turnTo(angle);
        m_leftFront.turnTo(angle);
        m_leftBack.turnTo(angle);
    }
    
    public void setWheelsSpeed(double ms){
        m_rightFront.setSpeed(ms);
        m_leftFront.setSpeed(ms);
        m_rightBack.setSpeed(ms);
        m_leftBack.setSpeed(ms);
    }

    public void drive (double x1, double y1, double x2) {
        double L = Constants.Values.SWERVE_LENGTH;
        double W = Constants.Values.SWERVE_WIDTH;
        double r = Math.sqrt ((L * L) + (W * W));
        y1 *= -1;
    
        double a = x1 - x2 * (L / r);
        double b = x1 + x2 * (L / r);
        double c = y1 - x2 * (W / r);
        double d = y1 + x2 * (W / r);
    
        double rightBackSpeed = Math.sqrt ((a * a) + (d * d))  * Constants.Values.MAX_SWERVE_SPEED;
        double leftBackSpeed = Math.sqrt ((a * a) + (c * c))   * Constants.Values.MAX_SWERVE_SPEED;
        double rightFrontSpeed = Math.sqrt ((b * b) + (d * d)) * Constants.Values.MAX_SWERVE_SPEED;
        double leftFrontSpeed = Math.sqrt ((b * b) + (c * c))  * Constants.Values.MAX_SWERVE_SPEED;
    
        double rightBackAngle = Math.atan2 (a, d) / Math.PI * 180;
        double leftBackAngle = Math.atan2 (a, c) / Math.PI * 180;
        double rightFrontAngle = Math.atan2 (b, d) / Math.PI * 180;
        double leftFrontAngle = Math.atan2 (b, c) / Math.PI * 180;

        set(rightFrontAngle, rightBackAngle, leftFrontAngle, leftBackAngle, rightFrontSpeed, rightBackSpeed, leftFrontSpeed, leftBackSpeed);        
    }
}
