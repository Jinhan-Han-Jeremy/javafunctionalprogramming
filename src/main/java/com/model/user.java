package com.model;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class user {
    private int id;
    private String name;
    private String emailAddress;
    private boolean isVerified;
    private LocalDateTime createdAt;
    private List<Integer> friendUserIds;

    public int getId() {
        return id;
    }

    public user setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public user setName(String name) {
        this.name = name;
        return this;
    }

    public Optional<String> getEmailAddress() {
        return Optional.ofNullable(emailAddress);
    }

    public user setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public user setVerified(boolean isVerified) {
        this.isVerified = isVerified;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public user setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public List<Integer> getFriendUserIds() {
        return friendUserIds;
    }

    
    public user setFriendUserIds(List<Integer> friendUserIds) {
        this.friendUserIds = friendUserIds;
        return this;
    }

    @Override

    public String toString() {
        return "User [id=" + id + ", " + (name != null ? "name=" + name + ", " : "")
                + (emailAddress != null ? "emailAddress=" + emailAddress + ", " : "") + "isVerified=" + isVerified
                + ", " + (friendUserIds != null ? "friendUserIds=" + friendUserIds : "") + "]";
    }
}