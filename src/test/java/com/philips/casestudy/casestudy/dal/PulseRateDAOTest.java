/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.casestudy.casestudy.dal;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.philips.casestudy.dal.MonitoringVitalsDAO;
import com.philips.casestudy.dal.PulseRateDAO;
import com.philips.casestudy.domain.MonitoringVitals;
import com.philips.casestudy.domain.PulseRate;
import com.philips.casestudy.domain.Spo2;
import com.philips.casestudy.domain.Temperature;

public class PulseRateDAOTest {


  @Test
  public void vitalCheckerreturnUndetectablelowReading()
  {

    final MonitoringVitalsDAO dao=new PulseRateDAO();

    final PulseRate pulseRate=new PulseRate();
    final Spo2 spo2=new Spo2();
    final Temperature temperature=new Temperature();
    pulseRate.setReading(29);

    final MonitoringVitals vitals=new MonitoringVitals(pulseRate,spo2,temperature);

    dao.vitalChecker(vitals);
    assertEquals("undetectably low reading",vitals.getPulseRate().getResult());

  }

  @Test
  public void vitalCheckerreturnlowreadingwithcareNeeded()
  {

    final MonitoringVitalsDAO dao=new PulseRateDAO();

    final PulseRate pulseRate=new PulseRate();
    final Spo2 spo2=new Spo2();
    final Temperature temperature=new Temperature();
    pulseRate.setReading(39);

    final MonitoringVitals vitals=new MonitoringVitals(pulseRate,spo2,temperature);

    dao.vitalChecker(vitals);
    assertEquals("low reading - Care needed",vitals.getPulseRate().getResult());

  }


  @Test
  public void vitalCheckerreturnNormal()
  {

    final MonitoringVitalsDAO dao=new PulseRateDAO();

    final PulseRate pulseRate=new PulseRate();
    final Spo2 spo2=new Spo2();
    final Temperature temperature=new Temperature();
    pulseRate.setReading(59);

    final MonitoringVitals vitals=new MonitoringVitals(pulseRate,spo2,temperature);

    dao.vitalChecker(vitals);
    assertEquals("Normal",vitals.getPulseRate().getResult());

  }


  @Test
  public void vitalCheckerreturnHighreadingCareneeded()
  {

    final MonitoringVitalsDAO dao=new PulseRateDAO();

    final PulseRate pulseRate=new PulseRate();
    final Spo2 spo2=new Spo2();
    final Temperature temperature=new Temperature();
    pulseRate.setReading(253);

    final MonitoringVitals vitals=new MonitoringVitals(pulseRate,spo2,temperature);

    dao.vitalChecker(vitals);
    assertEquals("High reading - Care needed",vitals.getPulseRate().getResult());

  }


  @Test
  public void vitalCheckerreturnDeviceNotAbleToMeasure()
  {

    final MonitoringVitalsDAO dao=new PulseRateDAO();

    final PulseRate pulseRate=new PulseRate();
    final Spo2 spo2=new Spo2();
    final Temperature temperature=new Temperature();
    pulseRate.setReading(255);

    final MonitoringVitals vitals=new MonitoringVitals(pulseRate,spo2,temperature);

    dao.vitalChecker(vitals);
    assertEquals("Device not calibrated to measure such high values",vitals.getPulseRate().getResult());

  }

  @Test
  public void checkRangeReturnTrue()
  {

    final MonitoringVitalsDAO dao=new PulseRateDAO();
    assertEquals(true,dao.checkRange(50, 54));
  }
}
