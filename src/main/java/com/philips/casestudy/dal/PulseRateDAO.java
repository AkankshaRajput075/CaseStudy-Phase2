/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.casestudy.dal;

import org.springframework.stereotype.Repository;
import com.philips.casestudy.domain.MonitorStatus;
import com.philips.casestudy.domain.MonitoringVitals;
import com.philips.casestudy.domain.PulseRate;

@Repository
public class PulseRateDAO implements MonitoringVitalsDAO{



  @Override
  public MonitoringVitals vitalChecker(MonitoringVitals vitals) {
    final PulseRate pulseRate=vitals.getPulseRate();
    if( pulseRate.getReading()<= PulseRate.getLowestPulseRate())
    {
      pulseRate.setResult(MonitorStatus.getStatusByIndex(0));
    }
    else if(pulseRate.getReading()<= PulseRate.getLowestSleepingRate()) {
      pulseRate.setResult(MonitorStatus.getStatusByIndex(1));

    }
    else if(pulseRate.getReading()<= PulseRate.getUpperSleepingRate()) {
      pulseRate.setResult(MonitorStatus.getStatusByIndex(2));
    }
    else if(pulseRate.getReading()<= PulseRate.getUpperRestingRate()) {
      pulseRate.setResult(MonitorStatus.getStatusByIndex(2));
    }
    else if(pulseRate.getReading()<= PulseRate.getUpperExcerciseRate()) {
      pulseRate.setResult(MonitorStatus.getStatusByIndex(2));
    }
    else if(pulseRate.getReading()<= PulseRate.getHighestPulseRate()) {
      pulseRate.setResult(MonitorStatus.getStatusByIndex(3));
    }
    else {
      pulseRate.setResult(MonitorStatus.getStatusByIndex(6));
    }

    return vitals;
  }

}
