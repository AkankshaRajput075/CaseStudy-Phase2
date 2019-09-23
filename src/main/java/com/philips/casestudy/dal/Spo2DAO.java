/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.casestudy.dal;

import org.springframework.stereotype.Repository;
import com.philips.casestudy.domain.MonitorStatus;
import com.philips.casestudy.domain.MonitoringVitals;
import com.philips.casestudy.domain.Spo2;

@Repository
public class Spo2DAO implements MonitoringVitalsDAO{

  @Override
  public MonitoringVitals vitalChecker(MonitoringVitals vitals) {

    final Spo2 spo2=vitals.getSpo2();

    if (checkRange(spo2.getReading(),Spo2.getUpperHealthyReading())) {
      spo2.setResult(MonitorStatus.getStatusByIndex(6));
    } else if (checkRange(spo2.getReading(),Spo2.getUpperAcceptableReading())) {
      spo2.setResult(MonitorStatus.getStatusByIndex(2));
    } else if (checkRange(spo2.getReading(),Spo2.getLowerAcceptableReading())) {
      spo2.setResult(MonitorStatus.getStatusByIndex(2));
    } else if (checkRange(spo2.getReading(),Spo2.getLowerUnsafeLevelReading())) {
      spo2.setResult(MonitorStatus.getStatusByIndex(1));
    } else {
      spo2.setResult(MonitorStatus.getStatusByIndex(0));
    }

    return vitals;
  }


  @Override
  public boolean checkRange(double currentspo2Reading,double fixedspo2Reading)
  {
    return currentspo2Reading>=fixedspo2Reading;
  }
}
