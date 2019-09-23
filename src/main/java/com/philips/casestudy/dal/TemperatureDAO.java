/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.casestudy.dal;

import org.springframework.stereotype.Repository;
import com.philips.casestudy.domain.MonitorStatus;
import com.philips.casestudy.domain.MonitoringVitals;
import com.philips.casestudy.domain.Temperature;

@Repository
public class TemperatureDAO implements MonitoringVitalsDAO{

  @Override
  public MonitoringVitals vitalChecker(MonitoringVitals vitals) {

    final Temperature temperature=vitals.getTemperature();

    if(checkRange(temperature.getReading(),Temperature.getMinFeverValue())) {
      temperature.setResult(MonitorStatus.getStatusByIndex(0));
    }
    else if (checkRange(temperature.getReading(),Temperature.getLowerNormalValue())) {
      temperature.setResult(MonitorStatus.getStatusByIndex(1));
    }
    else if (checkRange(temperature.getReading(),Temperature.getUpperNormalValue()) ){
      temperature.setResult(MonitorStatus.getStatusByIndex(2));
    }
    else if (checkRange(temperature.getReading(),Temperature.getUpperAcceptableFeverReading())) {
      temperature.setResult(MonitorStatus.getStatusByIndex(3));
    }
    else if (checkRange(temperature.getReading(),Temperature.getUpperConcernFeverReading())) {
      temperature.setResult(MonitorStatus.getStatusByIndex(4));
    }
    else if (checkRange(temperature.getReading(),Temperature.getMaxFeverValue())) {
      temperature.setResult(MonitorStatus.getStatusByIndex(5));
    }
    else
    {
      temperature.setResult(MonitorStatus.getStatusByIndex(6));
    }

    return vitals;
  }

  @Override
  public boolean checkRange(double currenttemperatureReading,double fixedtemperatureReading)
  {
    return currenttemperatureReading<=fixedtemperatureReading;
  }

}
