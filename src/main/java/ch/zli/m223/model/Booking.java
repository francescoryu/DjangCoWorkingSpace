package ch.zli.m223.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
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
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    private boolean isCanceled;

    @ManyToOne(optional = false)
    @Fetch(FetchMode.JOIN)
    private AppUser user;

    @Column(nullable = false)
    private boolean isAdmin;

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

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public AppUser getUser() {
        return user;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean wantsBeamer() {
        return wantsBeamer;
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
}
