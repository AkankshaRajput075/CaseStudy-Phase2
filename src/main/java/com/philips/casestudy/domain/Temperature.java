/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.casestudy.domain;

public class Temperature {

  private double reading;
  private static final double MIN_FEVER_VALUE=93;
  private static final double LOWER_NORMAL_VALUE= 97;
  private static final double UPPER_NORMAL_VALUE= 98.9;
  private static final double UPPER_ACCEPTABLE_FEVER_READING= 100.5;
  private static final double UPPER_CONCERN_FEVER_READING= 103.1;
  private static final double MAX_FEVER_VALUE=108;
  String result;
  String vitalName = "Temperature";

  public Temperature(double reading) {
    this.reading = reading;
    result = null;
  }

  public Temperature() {

  }

  public double getReading() {
    return reading;
  }

  @Override
  public String toString() {
    return "Temperature [reading=" + reading + ", result=" + result + "]";
  }
  public String getResult() {
    return result;
  }
  public String getVitalName() {
    return vitalName;
  }

  public static double getMinFeverValue() {
    return MIN_FEVER_VALUE;
  }

  public static double getLowerNormalValue() {
    return LOWER_NORMAL_VALUE;
  }

  public static double getUpperNormalValue() {
    return UPPER_NORMAL_VALUE;
  }

  public static double getUpperAcceptableFeverReading() {
    return UPPER_ACCEPTABLE_FEVER_READING;
  }

  public static double getUpperConcernFeverReading() {
    return UPPER_CONCERN_FEVER_READING;
  }

  public static double getMaxFeverValue() {
    return MAX_FEVER_VALUE;
  }

  public void setReading(double reading) {
    this.reading = reading;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public void setVitalName(String vitalName) {
    this.vitalName = vitalName;
  }



}