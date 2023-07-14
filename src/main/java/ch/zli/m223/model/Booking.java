package ch.zli.m223.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Booking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private AppUser user;

    @Column
    private boolean wantsBeamer;

    @Column 
    private boolean wantsNewsLetter;

    @Column
    private int duration;

//-------------------------------------------------------------------------------------
    
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public AppUser getUser() {
        return user;
    }

    public void setWantsBeamer(boolean wantsBeamer) {
        this.wantsBeamer = wantsBeamer;
    }

    public boolean wantsBeamer() {
        return wantsBeamer;
    }

    public void setWantsNewsLetter(boolean wantsNewsLetter) {
        this.wantsNewsLetter = wantsNewsLetter;
    }

    public boolean wantsNewsLetter() {
        return wantsNewsLetter;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public enum Status {
        ACCEPTED,
        PENDING,
        DECLINED
    }
}
