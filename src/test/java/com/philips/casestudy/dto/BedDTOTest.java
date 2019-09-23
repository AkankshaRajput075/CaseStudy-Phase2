/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.casestudy.dto;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.philips.casestudy.domain.Bed;

public class BedDTOTest {


  @Test
  public void BedDtoToEntity()
  {
    final BedDTO bedDto=new BedDTO(true);
    final Bed bed=bedDto.changeDTOToEntity(bedDto);
    assertTrue(bed.getisAvailable()==bedDto.getisAvailable());
  }

}
