package com.example.models.requests;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class MessageRequest implements Serializable, Comparable<MessageRequest> {

  private Integer id;
  private String subject;
  private String body;
  private Integer senderId;

      public MessageRequest(){  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void parseAndSetId(String id) {
    this.id = Integer.parseInt(id);
  }

  public MessageRequest withId(Integer id) {
    this.setId(id);
    return this;
  }

  public MessageRequest withParsedId(String id) {
    this.parseAndSetId(id);
    return this;
  }

  public MessageRequest withoutId( Integer id) {
    this.setId(null);
    return this;
  }

  public MessageRequest withoutParsedId(String id) {
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

  public MessageRequest withSubject(String subject) {
    this.setSubject(subject);
    return this;
  }

  public MessageRequest withParsedSubject(String subject) {
    this.parseAndSetSubject(subject);
    return this;
  }

  public MessageRequest withoutSubject( String subject) {
    this.setSubject(null);
    return this;
  }

  public MessageRequest withoutParsedSubject(String subject) {
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

  public MessageRequest withBody(String body) {
    this.setBody(body);
    return this;
  }

  public MessageRequest withParsedBody(String body) {
    this.parseAndSetBody(body);
    return this;
  }

  public MessageRequest withoutBody( String body) {
    this.setBody(null);
    return this;
  }

  public MessageRequest withoutParsedBody(String body) {
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

  public MessageRequest withSenderId(Integer senderId) {
    this.setSenderId(senderId);
    return this;
  }

  public MessageRequest withParsedSenderId(String senderId) {
    this.parseAndSetSenderId(senderId);
    return this;
  }

  public MessageRequest withoutSenderId( Integer senderId) {
    this.setSenderId(null);
    return this;
  }

  public MessageRequest withoutParsedSenderId(String senderId) {
    this.setSenderId(null);
    return this;
  }


    @Override
    public int compareTo(MessageRequest otherMessage) {
        // define here default comparison criteria 
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MessageRequest)) return false;
        MessageRequest otherMessage = (MessageRequest) obj;
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
