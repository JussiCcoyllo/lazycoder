package com.example.models.requests;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class ShareRequest implements Serializable, Comparable<ShareRequest> {

  private Integer messageId;
  private Integer receiverId;

      public ShareRequest(){  }


  public Integer getMessageId() {
    return messageId;
  }

  public void setMessageId(Integer messageId) {
    this.messageId = messageId;
  }

  public void parseAndSetMessageId(String messageId) {
    this.messageId = Integer.parseInt(messageId);
  }

  public ShareRequest withMessageId(Integer messageId) {
    this.setMessageId(messageId);
    return this;
  }

  public ShareRequest withParsedMessageId(String messageId) {
    this.parseAndSetMessageId(messageId);
    return this;
  }

  public ShareRequest withoutMessageId( Integer messageId) {
    this.setMessageId(null);
    return this;
  }

  public ShareRequest withoutParsedMessageId(String messageId) {
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

  public ShareRequest withReceiverId(Integer receiverId) {
    this.setReceiverId(receiverId);
    return this;
  }

  public ShareRequest withParsedReceiverId(String receiverId) {
    this.parseAndSetReceiverId(receiverId);
    return this;
  }

  public ShareRequest withoutReceiverId( Integer receiverId) {
    this.setReceiverId(null);
    return this;
  }

  public ShareRequest withoutParsedReceiverId(String receiverId) {
    this.setReceiverId(null);
    return this;
  }


    @Override
    public int compareTo(ShareRequest otherShare) {
        // define here default comparison criteria 
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ShareRequest)) return false;
        ShareRequest otherShare = (ShareRequest) obj;
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
