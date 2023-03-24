package com.example.models.entities;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class MessageEntity implements Serializable, Comparable<MessageEntity> {

  private Integer id;
  private String subject;
  private String body;
  private Integer senderId;

      public MessageEntity(){  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void parseAndSetId(String id) {
    this.id = Integer.parseInt(id);
  }

  public MessageEntity withId(Integer id) {
    this.setId(id);
    return this;
  }

  public MessageEntity withParsedId(String id) {
    this.parseAndSetId(id);
    return this;
  }

  public MessageEntity withoutId( Integer id) {
    this.setId(null);
    return this;
  }

  public MessageEntity withoutParsedId(String id) {
    this.setId(null);
    return this;
  }


  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public void parseAndSetSubject(String subject) {
    this.subject = subject;
  }

  public MessageEntity withSubject(String subject) {
    this.setSubject(subject);
    return this;
  }

  public MessageEntity withParsedSubject(String subject) {
    this.parseAndSetSubject(subject);
    return this;
  }

  public MessageEntity withoutSubject( String subject) {
    this.setSubject(null);
    return this;
  }

  public MessageEntity withoutParsedSubject(String subject) {
    this.setSubject(null);
    return this;
  }


  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public void parseAndSetBody(String body) {
    this.body = body;
  }

  public MessageEntity withBody(String body) {
    this.setBody(body);
    return this;
  }

  public MessageEntity withParsedBody(String body) {
    this.parseAndSetBody(body);
    return this;
  }

  public MessageEntity withoutBody( String body) {
    this.setBody(null);
    return this;
  }

  public MessageEntity withoutParsedBody(String body) {
    this.setBody(null);
    return this;
  }


  public Integer getSenderId() {
    return senderId;
  }

  public void setSenderId(Integer senderId) {
    this.senderId = senderId;
  }

  public void parseAndSetSenderId(String senderId) {
    this.senderId = Integer.parseInt(senderId);
  }

  public MessageEntity withSenderId(Integer senderId) {
    this.setSenderId(senderId);
    return this;
  }

  public MessageEntity withParsedSenderId(String senderId) {
    this.parseAndSetSenderId(senderId);
    return this;
  }

  public MessageEntity withoutSenderId( Integer senderId) {
    this.setSenderId(null);
    return this;
  }

  public MessageEntity withoutParsedSenderId(String senderId) {
    this.setSenderId(null);
    return this;
  }


    @Override
    public int compareTo(MessageEntity otherMessage) {
        // define here default comparison criteria 
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MessageEntity)) return false;
        MessageEntity otherMessage = (MessageEntity) obj;
        return 
        this.getId().equals(otherMessage.getId()) 
 &&         this.getSubject().equals(otherMessage.getSubject()) 
 &&         this.getBody().equals(otherMessage.getBody()) 
 &&         this.getSenderId().equals(otherMessage.getSenderId()) 
;    }

    @Override
    public int hashCode() {
        return Objects.hash( 
        this.getId()
,         this.getSubject()
,         this.getBody()
,         this.getSenderId()
 );    }

    @Override
    public String toString() {

        return "{ " + 
        "id:" + this.getId()  + ", " + 
        "subject:" + this.getSubject()  + ", " + 
        "body:" + this.getBody()  + ", " + 
        "senderId:" + this.getSenderId()  + 
    " } ";
    }

    public boolean isNew(){
        return this.getId() == null;
    }

    public boolean isEmpty(){
        return ( this.getId() == null && 
this.getSubject() == null && 
this.getBody() == null && 
this.getSenderId() == null );    }

}
