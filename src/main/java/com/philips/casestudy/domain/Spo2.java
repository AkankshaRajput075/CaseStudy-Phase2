/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.casestudy.domain;

public class Spo2{

  String result;
  private double reading;
  private static final double  UPPER_HEALTHY_READING = 100;
  private static final double  UPPER_ACCEPTABLE_READING= 95;
  private static final double  LOWER_ACCEPTABLE_READING= 90;
  private static final double  LOWER_UNSAFE_LEVEL_READING= 70;
  String vitalName = "Spo2";

  public Spo2() {
  }

  public Spo2(double reading) {
    this.reading = reading;
    result = null;
  }


  public double getReading() {
    return reading;
  }

  @Override
  public String toString() {
    return "Spo2 [reading=" + reading + ", result=" + result + "]";
  }

  public String getResult() {
    return result;
  }

  public String getVitalName() {
    return vitalName;
  }

  public static double getUpperHealthyReading() {
    return UPPER_HEALTHY_READING;
  }

  public static double getUpperAcceptableReading() {
    return UPPER_ACCEPTABLE_READING;
  }

  public static double getLowerAcceptableReading() {
    return LOWER_ACCEPTABLE_READING;
  }

  public static double getLowerUnsafeLevelReading() {
    return LOWER_UNSAFE_LEVEL_READING;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public void setReading(double reading) {
    this.reading = reading;
  }

  public void setVitalName(String vitalName) {
    this.vitalName = vitalName;
  }



}