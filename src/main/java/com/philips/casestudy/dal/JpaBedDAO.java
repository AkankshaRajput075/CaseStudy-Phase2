/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.casestudy.dal;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.philips.casestudy.domain.Bed;
import com.philips.casestudy.dto.BedDTO;

@Transactional
@Repository
public class JpaBedDAO implements BedDAO {

  @PersistenceContext
  EntityManager em;


  @Override
  public Bed save(BedDTO bed){
    System.out.println("bed : "+bed.toString());
    final Bed toBeSaved=bed.changeDTOToEntity(bed);
    System.out.println("BedDto : "+toBeSaved.toString());
    em.persist(toBeSaved);
    return toBeSaved;
  }



  @Override
  public List<Bed> findAll(){
    return em.createQuery("select b from Bed b").getResultList();
  }

  @Override
  public Bed findById(int bedId) {
    return em.find(Bed.class, bedId);
  }

  @Override
  public void deletebyId(int bedId)
  {
    final Bed bed = findById(bedId);
    if(bed!=null){
      em.remove(bed);
    }
  }

}