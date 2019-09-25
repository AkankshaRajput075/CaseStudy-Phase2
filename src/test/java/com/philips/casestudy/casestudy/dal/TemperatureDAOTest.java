/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.casestudy.casestudy.dal;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.philips.casestudy.dal.MonitoringVitalsDAO;
import com.philips.casestudy.dal.TemperatureDAO;
import com.philips.casestudy.domain.MonitoringVitals;
import com.philips.casestudy.domain.PulseRate;
import com.philips.casestudy.domain.Spo2;
import com.philips.casestudy.domain.Temperature;

public class TemperatureDAOTest {


  @Test
  public void vitalCheckerreturnUndetectablelowReading()
  {

    final MonitoringVitalsDAO dao=new TemperatureDAO();

    final PulseRate pulseRate=new PulseRate();
    final Spo2 spo2=new Spo2();
    final Temperature temperature=new Temperature();
    temperature.setReading(29);

    final MonitoringVitals vitals=new MonitoringVitals(pulseRate,spo2,temperature);

    dao.vitalChecker(vitals);
    assertEquals("undetectably low reading",vitals.getTemperature().getResult());

  }


  @Test
  public void vitalCheckerreturnlowreadingwithcareNeeded()
  {

    final MonitoringVitalsDAO dao=new TemperatureDAO();

    final PulseRate pulseRate=new PulseRate();
    final Spo2 spo2=new Spo2();
    final Temperature temperature=new Temperature();
    temperature.setReading(96);

    final MonitoringVitals vitals=new MonitoringVitals(pulseRate,spo2,temperature);

    dao.vitalChecker(vitals);
    assertEquals("low reading - Care needed",vitals.getTemperature().getResult());

  }


  @Test
  public void vitalCheckerreturnNormal()
  {

    final MonitoringVitalsDAO dao=new TemperatureDAO();

    final PulseRate pulseRate=new PulseRate();
    final Spo2 spo2=new Spo2();
    final Temperature temperature=new Temperature();
    temperature.setReading(98);

    final MonitoringVitals vitals=new MonitoringVitals(pulseRate,spo2,temperature);

    dao.vitalChecker(vitals);
    assertEquals("Normal",vitals.getTemperature().getResult());

  }



  @Test
  public void vitalCheckerreturnHighReadingCareNeeded()
  {

    final MonitoringVitalsDAO dao=new TemperatureDAO();

    final PulseRate pulseRate=new PulseRate();
    final Spo2 spo2=new Spo2();
    final Temperature temperature=new Temperature();
    temperature.setReading(99);

    final MonitoringVitals vitals=new MonitoringVitals(pulseRate,spo2,temperature);

    dao.vitalChecker(vitals);
    assertEquals("High reading - Care needed",vitals.getTemperature().getResult());

  }

  @Test
  public void vitalCheckerreturnHighReadingExtremeCareNeeded()
  {

    final MonitoringVitalsDAO dao=new TemperatureDAO();

    final PulseRate pulseRate=new PulseRate();
    final Spo2 spo2=new Spo2();
    final Temperature temperature=new Temperature();
    temperature.setReading(101);

    final MonitoringVitals vitals=new MonitoringVitals(pulseRate,spo2,temperature);

    dao.vitalChecker(vitals);
    assertEquals("High reading - Extreme care needed",vitals.getTemperature().getResult());

  }


  @Test
  public void vitalCheckerreturnHighReadingCriticalCareNeeded()
  {

    final MonitoringVitalsDAO dao=new TemperatureDAO();

    final PulseRate pulseRate=new PulseRate();
    final Spo2 spo2=new Spo2();
    final Temperature temperature=new Temperature();
    temperature.setReading(104);

    final MonitoringVitals vitals=new MonitoringVitals(pulseRate,spo2,temperature);

    dao.vitalChecker(vitals);
    assertEquals("High reading - Critical care needed",vitals.getTemperature().getResult());

  }

  @Test
  public void vitalCheckerreturnDeviceNotAbleToMeasure()
  {

    final MonitoringVitalsDAO dao=new TemperatureDAO();

    final PulseRate pulseRate=new PulseRate();
    final Spo2 spo2=new Spo2();
    final Temperature temperature=new Temperature();
    temperature.setReading(110);

    final MonitoringVitals vitals=new MonitoringVitals(pulseRate,spo2,temperature);

    dao.vitalChecker(vitals);
    assertEquals("Device not calibrated to measure such high values",vitals.getTemperature().getResult());

  }

}
