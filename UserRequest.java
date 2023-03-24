package com.example.models.requests;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class UserRequest implements Serializable, Comparable<UserRequest> {

  private Integer id;
  private String email;
  private String passcode;
  private Integer active;

      public UserRequest(){  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void parseAndSetId(String id) {
    this.id = Integer.parseInt(id);
  }

  public UserRequest withId(Integer id) {
    this.setId(id);
    return this;
  }

  public UserRequest withParsedId(String id) {
    this.parseAndSetId(id);
    return this;
  }

  public UserRequest withoutId( Integer id) {
    this.setId(null);
    return this;
  }

  public UserRequest withoutParsedId(String id) {
    this.setId(null);
    return this;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void parseAndSetEmail(String email) {
    this.email = email;
  }

  public UserRequest withEmail(String email) {
    this.setEmail(email);
    return this;
  }

  public UserRequest withParsedEmail(String email) {
    this.parseAndSetEmail(email);
    return this;
  }

  public UserRequest withoutEmail( String email) {
    this.setEmail(null);
    return this;
  }

  public UserRequest withoutParsedEmail(String email) {
    this.setEmail(null);
    return this;
  }


  public String getPasscode() {
    return passcode;
  }

  public void setPasscode(String passcode) {
    this.passcode = passcode;
  }

  public void parseAndSetPasscode(String passcode) {
    this.passcode = passcode;
  }

  public UserRequest withPasscode(String passcode) {
    this.setPasscode(passcode);
    return this;
  }

  public UserRequest withParsedPasscode(String passcode) {
    this.parseAndSetPasscode(passcode);
    return this;
  }

  public UserRequest withoutPasscode( String passcode) {
    this.setPasscode(null);
    return this;
  }

  public UserRequest withoutParsedPasscode(String passcode) {
    this.setPasscode(null);
    return this;
  }


  public Integer getActive() {
    return active;
  }

  public void setActive(Integer active) {
    this.active = active;
  }

  public void parseAndSetActive(String active) {
    this.active = Integer.parseInt(active);
  }

  public UserRequest withActive(Integer active) {
    this.setActive(active);
    return this;
  }

  public UserRequest withParsedActive(String active) {
    this.parseAndSetActive(active);
    return this;
  }

  public UserRequest withoutActive( Integer active) {
    this.setActive(null);
    return this;
  }

  public UserRequest withoutParsedActive(String active) {
    this.setActive(null);
    return this;
  }


    @Override
    public int compareTo(UserRequest otherUser) {
        // define here default comparison criteria 
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UserRequest)) return false;
        UserRequest otherUser = (UserRequest) obj;
        return 
        this.getId().equals(otherUser.getId()) 
 &&         this.getEmail().equals(otherUser.getEmail()) 
 &&         this.getPasscode().equals(otherUser.getPasscode()) 
 &&         this.getActive().equals(otherUser.getActive()) 
;    }

    @Override
    public int hashCode() {
        return Objects.hash( 
        this.getId()
,         this.getEmail()
,         this.getPasscode()
,         this.getActive()
 );    }

    @Override
    public String toString() {

        return "{ " + 
        "id:" + this.getId()  + ", " + 
        "email:" + this.getEmail()  + ", " + 
        "passcode:" + this.getPasscode()  + ", " + 
        "active:" + this.getActive()  + 
    " } ";
    }

    public boolean isNew(){
        return this.getId() == null;
    }

    public boolean isEmpty(){
        return ( this.getId() == null && 
this.getEmail() == null && 
this.getPasscode() == null && 
this.getActive() == null );    }

}
