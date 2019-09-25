/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.casestudy.casestudy.dal;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.philips.casestudy.dal.MonitoringVitalsDAO;
import com.philips.casestudy.dal.Spo2DAO;
import com.philips.casestudy.domain.MonitoringVitals;
import com.philips.casestudy.domain.PulseRate;
import com.philips.casestudy.domain.Spo2;
import com.philips.casestudy.domain.Temperature;

public class Spo2DAOTest {


  @Test
  public void vitalCheckerreturnDeviceNotAbleToMeasure()
  {

    final MonitoringVitalsDAO dao=new Spo2DAO();

    final PulseRate pulseRate=new PulseRate();
    final Spo2 spo2=new Spo2();
    final Temperature temperature=new Temperature();
    spo2.setReading(101);

    final MonitoringVitals vitals=new MonitoringVitals(pulseRate,spo2,temperature);

    dao.vitalChecker(vitals);
    assertEquals("Device not calibrated to measure such high values",vitals.getSpo2().getResult());

  }



  @Test
  public void vitalCheckerreturnNormal()
  {

    final MonitoringVitalsDAO dao=new Spo2DAO();

    final PulseRate pulseRate=new PulseRate();
    final Spo2 spo2=new Spo2();
    final Temperature temperature=new Temperature();
    spo2.setReading(91);

    final MonitoringVitals vitals=new MonitoringVitals(pulseRate,spo2,temperature);

    dao.vitalChecker(vitals);
    assertEquals("Normal",vitals.getSpo2().getResult());

  }



  @Test
  public void vitalCheckerreturnlowreadingwithcareNeeded()
  {

    final MonitoringVitalsDAO dao=new Spo2DAO();

    final PulseRate pulseRate=new PulseRate();
    final Spo2 spo2=new Spo2();
    final Temperature temperature=new Temperature();
    spo2.setReading(71);

    final MonitoringVitals vitals=new MonitoringVitals(pulseRate,spo2,temperature);

    dao.vitalChecker(vitals);
    assertEquals("low reading - Care needed",vitals.getSpo2().getResult());

  }


  @Test
  public void vitalCheckerreturnUndetectablelowReading()
  {

    final MonitoringVitalsDAO dao=new Spo2DAO();

    final PulseRate pulseRate=new PulseRate();
    final Spo2 spo2=new Spo2();
    final Temperature temperature=new Temperature();
    spo2.setReading(29);

    final MonitoringVitals vitals=new MonitoringVitals(pulseRate,spo2,temperature);

    dao.vitalChecker(vitals);
    assertEquals("undetectably low reading",vitals.getSpo2().getResult());

  }

  @Test
  public void checkRangeReturnTrue()
  {

    final MonitoringVitalsDAO dao=new Spo2DAO();
    assertEquals(true,dao.checkRange(55, 54));
  }


}
