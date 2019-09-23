/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.casestudy.casestudy.service;

import org.junit.Test;
import org.mockito.Mockito;
import com.philips.casestudy.dal.JpaBedDAO;
import com.philips.casestudy.domain.Bed;
import com.philips.casestudy.domain.MyException;
import com.philips.casestudy.service.BedServiceImpl;

public class BedServiceImplTest {

  @Test(expected=MyException.class)
  public void deleteBed() throws MyException
  {
    final BedServiceImpl service=new BedServiceImpl();
    final Bed toBeDeleted=new Bed(false);
    toBeDeleted.setBedId(1);

    final JpaBedDAO mockDao=Mockito.mock(JpaBedDAO.class);

    service.setBedDao(mockDao);

    Mockito.when(mockDao.findById(Mockito.anyInt())).thenReturn(toBeDeleted);

    service.deleteExistingBed(toBeDeleted.getBedId());

    throw new MyException("Bed can't be deleted");

  }

}
