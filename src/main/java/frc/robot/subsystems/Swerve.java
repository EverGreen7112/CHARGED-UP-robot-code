package frc.robot.subsystems;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Swerve extends SubsystemBase{

    private SwerveWheel m_rightFront;
    private SwerveWheel m_leftFront;
    private SwerveWheel m_rightBack;
    private SwerveWheel m_leftBack;

    private AHRS m_navx;

    public static final Swerve swerve = new Swerve(); //get instance
    
    public Swerve(){
        this.m_rightFront = new SwerveWheel(Constants.MotorPorts.RIGHT_UP_DRIVE_MOTOR_PORT, Constants.MotorPorts.RIGHT_UP_TURN_MOTOR_PORT);
        this.m_leftFront = new SwerveWheel(Constants.MotorPorts.LEFT_UP_DRIVE_MOTOR_PORT, Constants.MotorPorts.LEFT_UP_DRIVE_MOTOR_PORT);
        this.m_rightBack = new SwerveWheel(Constants.MotorPorts.RIGHT_DOWN_DRIVE_MOTOR_PORT, Constants.MotorPorts.RIGHT_DOWN_DRIVE_MOTOR_PORT);
        this.m_leftBack = new SwerveWheel(Constants.MotorPorts.LEFT_DOWN_DRIVE_MOTOR_PORT, Constants.MotorPorts.LEFT_DOWN_DRIVE_MOTOR_PORT);
        
        this.m_navx = new AHRS(SPI.Port.kMXP);
    }
    /**
     * 
     * @param angle - degrees
     * @param ms - m/s
     */
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
    /**
     * 
     *same as set(double angle, double ms) but lets you assign different angles(degrees) and speeds(m/s)
     *
     */
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
    /**
     * 
     * @param angle - degrees
     */
    public void setWheelsAngle(double angle){
        m_rightFront.turnTo(angle);
        m_rightBack.turnTo(angle);
        m_leftFront.turnTo(angle);
        m_leftBack.turnTo(angle);
    }
    /**
     * 
     * @param ms - m/s
     */
    public void setWheelsSpeed(double ms){
        m_rightFront.setSpeed(ms);
        m_leftFront.setSpeed(ms);
        m_rightBack.setSpeed(ms);
        m_leftBack.setSpeed(ms);
    }
    /**
     * 
     * @param x1 - x input from speedJoystick
     * @param y1 - y input from speedJoystick
     * @param x2 - x input from angleJoystick
     */
    public void drive (double x1, double y1, double x2) {
        x1 *= Constants.Values.MAX_SWERVE_SPEED;
        y1 *= Constants.Values.MAX_SWERVE_SPEED;
        double angleRad = m_navx.getAngle();
		double temp = y1 * Math.cos(angleRad) + x1 * Math.sin(angleRad);
		x1 = -y1 * Math.sin(angleRad) + x1 * Math.cos(angleRad);
		y1 = temp;
        
        double L = Constants.Values.SWERVE_LENGTH;
        double W = Constants.Values.SWERVE_WIDTH;
        double r = Math.sqrt ((L * L) + (W * W));
        y1 *= -1;
    
        double a = x1 - x2 * (L / r);
        double b = x1 + x2 * (L / r);
        double c = y1 - x2 * (W / r);
        double d = y1 + x2 * (W / r);
    
        double rightBackSpeed  = Math.sqrt ((a * a) + (d * d));
        double leftBackSpeed   = Math.sqrt ((a * a) + (c * c));
        double rightFrontSpeed = Math.sqrt ((b * b) + (d * d));
        double leftFrontSpeed  = Math.sqrt ((b * b) + (c * c));
    
        double rightBackAngle  = Math.atan2 (a, d) / Math.PI * 180;
        double leftBackAngle   = Math.atan2 (a, c) / Math.PI * 180;
        double rightFrontAngle = Math.atan2 (b, d) / Math.PI * 180;
        double leftFrontAngle  = Math.atan2 (b, c) / Math.PI * 180;

        set(rightFrontAngle, rightBackAngle, leftFrontAngle, leftBackAngle, rightFrontSpeed, rightBackSpeed, leftFrontSpeed, leftBackSpeed);        
    }
}
