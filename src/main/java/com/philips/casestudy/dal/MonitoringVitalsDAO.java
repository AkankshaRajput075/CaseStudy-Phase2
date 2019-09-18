/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.casestudy.dal;

import com.philips.casestudy.domain.MonitoringVitals;

public interface MonitoringVitalsDAO  {

  public MonitoringVitals vitalChecker(MonitoringVitals vitals);

}