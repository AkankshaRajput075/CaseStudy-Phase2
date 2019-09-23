/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.casestudy.dto;

import org.modelmapper.ModelMapper;
import com.philips.casestudy.domain.Bed;
import com.philips.casestudy.domain.Patient;

public class PatientDTO {

  int id;
  String name;
  int age;
  String phoneNumber;
  Bed bed;


  public PatientDTO() {
    super();

  }

  public PatientDTO(Patient pat)
  {
    this(pat.getName(),pat.getAge(),pat.getPhoneNumber());
  }

  public PatientDTO(String name,int age,String phoneNumber)
  {
    this.age=age;
    this.name=name;
    this.phoneNumber=phoneNumber;
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public String getPhoneNumber() {
    return phoneNumber;
  }
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
  public Bed getBed() {
    return bed;
  }
  public void setBed(Bed bed) {
    this.bed = bed;
  }

  public Patient changeDTOToEntity(PatientDTO pat)
  {
    final ModelMapper model=new ModelMapper();
    return model.map(pat,Patient.class);

  }

}
