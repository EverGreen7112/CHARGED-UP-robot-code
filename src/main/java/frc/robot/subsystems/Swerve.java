package frc.robot.subsystems;
import frc.robot.Constants;

public class Swerve {

    private SwerveWheel m_rightUp;
    private SwerveWheel m_leftUp;
    private SwerveWheel m_rightDown;
    private SwerveWheel m_leftDown;

    private Swerve m_instance;
    
    public Swerve(){
        this.m_rightUp = new SwerveWheel(Constants.MotorPorts.RIGHT_UP_DRIVE_MOTOR_PORT, Constants.MotorPorts.RIGHT_UP_TURN_MOTOR_PORT);
        this.m_leftUp = new SwerveWheel(Constants.MotorPorts.LEFT_UP_DRIVE_MOTOR_PORT, Constants.MotorPorts.LEFT_UP_DRIVE_MOTOR_PORT);
        this.m_rightDown = new SwerveWheel(Constants.MotorPorts.RIGHT_DOWN_DRIVE_MOTOR_PORT, Constants.MotorPorts.RIGHT_DOWN_DRIVE_MOTOR_PORT);
        this.m_leftDown = new SwerveWheel(Constants.MotorPorts.LEFT_DOWN_DRIVE_MOTOR_PORT, Constants.MotorPorts.LEFT_DOWN_DRIVE_MOTOR_PORT);
    }

    public Swerve getInstance(){
        if(m_instance == null){
            m_instance = new Swerve();
        }
        return m_instance;
    }

    public void set(double angle, double ms){
        m_rightUp.turnTo(angle);
        m_rightDown.turnTo(angle);
        m_leftUp.turnTo(angle);
        m_leftDown.turnTo(angle);

        m_rightUp.setSpeed(ms);
        m_leftUp.setSpeed(ms);
        m_rightDown.setSpeed(ms);
        m_leftDown.setSpeed(ms);
    }

    public void setWheelsAngle(double angle){
        m_rightUp.turnTo(angle);
        m_rightDown.turnTo(angle);
        m_leftUp.turnTo(angle);
        m_leftDown.turnTo(angle);
    }
    
    public void setWheelsSpeed(double ms){
        m_rightUp.setSpeed(ms);
        m_leftUp.setSpeed(ms);
        m_rightDown.setSpeed(ms);
        m_leftDown.setSpeed(ms);
    }

}
