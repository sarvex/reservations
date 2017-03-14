package com.sarvex.landon.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Sarvex on 13/03/2017.
 */

@Entity
@Table(name = "ROOM")
public class Room {
  @Id
  @Column(name = "ROOM_ID")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "NAME")
  private String name;

  @Column(name = "ROOM_NUMBER")
  private String number;

  @Column(name = "BED_INFO")
  private String bedInfo;

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNumber() {
    return this.number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getBedInfo() {
    return this.bedInfo;
  }

  public void setBedInfo(String bedInfo) {
    this.bedInfo = bedInfo;
  }
}
