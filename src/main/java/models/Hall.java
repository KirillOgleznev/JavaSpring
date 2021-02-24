package models;

import javax.persistence.*;

import lombok.*;

import java.util.Collection;


@ToString(exclude = {"sessions", "cinemaCodeKey", "seats", "hallInfoKey"})
@Entity
@Getter
@Setter
@Table(name = "halls")
public class Hall{
    @OneToOne(mappedBy = "hallCodeKey", cascade = CascadeType.REMOVE)
    private HallInfo hallInfoKey;

    @OneToMany(mappedBy = "hallCodeKey", cascade = CascadeType.REMOVE)
    private Collection<Session> sessions;

    @OneToMany(mappedBy = "hallCodeKey", cascade = CascadeType.REMOVE)
    private Collection<Seat> seats;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cinema_code", insertable = false, updatable = false)
    private Cinema cinemaCodeKey;

    @Id
    @GeneratedValue
    @Column(name = "hall_code", nullable = false)
    private int hallCode;

    @Column(name = "cinema_code", nullable = false)
    private String cinemaCode;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "active", nullable = false)
    private boolean condition;
}