/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.casestudy.domain;

import java.util.ArrayList;
import java.util.List;

public class MonitorStatus {
  private static final List<String> status=new ArrayList<> ();
  private MonitorStatus() {}

  private static  void setMonitorStatus()
  {
    status.add("undetectably low reading");
    status.add("low reading - Care needed");
    status.add("Normal");
    status.add("High reading - Care needed");
    status.add("High reading - Extreme care needed");
    status.add("High reading - Critical care needed");
    status.add("Device not calibrated to measure such high values");
  }

  public static List<String> getStatus() {
    return status;
  }

  public static String getStatusByIndex( int index)
  {
    setMonitorStatus();
    return status.get(index);
  }

}
