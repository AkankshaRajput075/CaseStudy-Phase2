/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.casestudy.domain;

public class PulseRate {

  int reading;
  String result;
  private static final int LOWEST_PULSE_RATE=30;
  private static final int LOWEST_SLEEPING_RATE = 40;
  private static final int UPPER_SLEEPING_RATE= 60;
  private static final int UPPER_RESTING_RATE= 100;
  private static final int  UPPER_EXCERCISE_RATE= 220;
  private static final int HIGHEST_PULSE_RATE=254;
  String vitalName = "PulseRate";



  public static int getLowestPulseRate() {
    return LOWEST_PULSE_RATE;
  }

  public static int getLowestSleepingRate() {
    return LOWEST_SLEEPING_RATE;
  }

  public static int getUpperSleepingRate() {
    return UPPER_SLEEPING_RATE;
  }

  public static int getUpperRestingRate() {
    return UPPER_RESTING_RATE;
  }

  public static int getUpperExcerciseRate() {
    return UPPER_EXCERCISE_RATE;
  }

  public static int getHighestPulseRate() {
    return HIGHEST_PULSE_RATE;
  }

  public PulseRate(int reading) { // constructor
    this.reading = reading;
    result = null;
  }

  public PulseRate() {

  }

  public double getReading() {
    return reading;
  }

  @Override
  public String toString() {
    return "PulseRate [reading=" + reading + ", result=" + result + "]";
  }

  public void setReading(int reading) {
    this.reading = reading;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public void setVitalName(String vitalName) {
    this.vitalName = vitalName;
  }

  public String getResult() {
    return result;
  }

  public String getVitalName() {
    return vitalName;
  }

}