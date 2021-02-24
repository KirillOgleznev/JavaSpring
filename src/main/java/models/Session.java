package models;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;
import java.sql.Timestamp;
import java.sql.Time;

@ToString(exclude = {"tickets", "hallCodeKey"})
@Entity
@Getter
@Setter
@Table(name = "sessions", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"hall_code", "start_time"}, name = "date_check")})
public class Session{

    @OneToMany(mappedBy = "SessionCodeKey", cascade = CascadeType.REMOVE)
    private Collection<Ticket> tickets;

    @ManyToOne(optional = false)
    @JoinColumn(name = "hall_code", insertable = false, updatable = false)
    private Hall hallCodeKey;

    @Id
    @GeneratedValue
    @Column(name = "session_code", nullable = false)
    private int sessionCode;

    @Column(name = "hall_code", nullable = false)
    private int hallCode;

    @Column(name = "film_name", nullable = false)
    private String filmName;

    @Column(name = "start_time", nullable = false)
    private Timestamp startTime;

    @Column(name = "duration", nullable = false)
    private Time duration;
}