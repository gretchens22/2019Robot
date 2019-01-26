/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.commands.UseDrive;
import jdk.jfr.Percentage;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


/**
 * Drive Subsystem for Mechanom Drive
 */
public class Drive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private final int FRONT_LEFT = 0;
  private final int FRONT_RIGHT = 1;
  private final int BACK_LEFT = 2;
  private final int BACK_RIGHT = 3;
  private final AHRS navX;
  public CANSparkMax[] motors;

  private MecanumDrive robotDrive;


  public Drive(CANSparkMax leftFrontMotor, CANSparkMax rightFrontMotor, CANSparkMax leftBackMotor,
      CANSparkMax rightBackMotor, AHRS _navX) { // callan is rly dum
    super();
    navX = _navX;
    // 1D array of the speed controllers passed
    motors = new CANSparkMax[] { leftFrontMotor, rightFrontMotor, leftBackMotor, rightBackMotor };
    
    // makes a new general robot drive that is a mecanum drive with front and back motors. wpilib's mecanum code. 
    robotDrive = new MecanumDrive(leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new UseDrive(this));
  }
  public void SetBreak(){
  }
  /**
   * Returns the motor speeds for a given mecanum-style input
   * 
   * @param x   the x position of the right stick
   * @param y   the y position of the right stick
   * @param rot the x position of the left stick
   * @return an array of motor speeds ([x][y])
   */
  public void mecanum(double x, double y, double rot) {
    robotDrive.driveCartesian(-x, y, rot, (navX.getAngle() % 360)-180);
    System.out.println("Dr" + navX.getAngle());
  }
}