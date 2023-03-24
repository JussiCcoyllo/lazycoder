package com.sample;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class ShareEntity implements Serializable, Comparable<ShareEntity> {

  private Integer messageId;
  private Integer receiverId;

      public ShareEntity(){  }


  public Integer getMessageId() {
    return messageId;
  }

  public void setMessageId(Integer messageId) {
    this.messageId = messageId;
  }

  public void parseAndSetMessageId(String messageId) {
    this.messageId = Integer.parseInt(messageId);
  }

  public ShareEntity withMessageId(Integer messageId) {
    this.setMessageId(messageId);
    return this;
  }

  public ShareEntity withParsedMessageId(String messageId) {
    this.parseAndSetMessageId(messageId);
    return this;
  }

  public ShareEntity withoutMessageId( Integer messageId) {
    this.setMessageId(null);
    return this;
  }

  public ShareEntity withoutParsedMessageId(String messageId) {
    this.setMessageId(null);
    return this;
  }


  public Integer getReceiverId() {
    return receiverId;
  }

  public void setReceiverId(Integer receiverId) {
    this.receiverId = receiverId;
  }

  public void parseAndSetReceiverId(String receiverId) {
    this.receiverId = Integer.parseInt(receiverId);
  }

  public ShareEntity withReceiverId(Integer receiverId) {
    this.setReceiverId(receiverId);
    return this;
  }

  public ShareEntity withParsedReceiverId(String receiverId) {
    this.parseAndSetReceiverId(receiverId);
    return this;
  }

  public ShareEntity withoutReceiverId( Integer receiverId) {
    this.setReceiverId(null);
    return this;
  }

  public ShareEntity withoutParsedReceiverId(String receiverId) {
    this.setReceiverId(null);
    return this;
  }


    @Override
    public int compareTo(ShareEntity otherShare) {
        // define here default comparison criteria 
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ShareEntity)) return false;
        ShareEntity otherShare = (ShareEntity) obj;
        return 
        this.getMessageId().equals(otherShare.getMessageId()) 
 &&         this.getReceiverId().equals(otherShare.getReceiverId()) 
;    }

    @Override
    public int hashCode() {
        return Objects.hash( 
        this.getMessageId()
,         this.getReceiverId()
 );    }

    @Override
    public String toString() {

        return "{ " + 
        "messageId:" + this.getMessageId()  + ", " + 
        "receiverId:" + this.getReceiverId()  + 
    " } ";
    }

    public boolean isNew(){
        return this.getId() == null;
    }

    public boolean isEmpty(){
        return ( this.getMessageId() == null && 
this.getReceiverId() == null );    }

}
