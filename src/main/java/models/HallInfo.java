package models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@ToString(exclude = {"hallCodeKey"})
@Entity
@Getter
@Setter
@Table(name = "halls_info")
public class HallInfo{
    @OneToOne(optional = false)
    @JoinColumn(name = "hall_code", insertable = false, updatable = false)
    private Hall hallCodeKey;

    @Id
    @Column(name = "hall_code", nullable = false)
    private int hallCode;

    @Column(name = "width_screen_m", nullable = false)
    private int widthScreenM;
    @Column(name = "length_screen_m", nullable = false)
    private int lengthScreenM;
    @Column(name = "width_hall_m", nullable = false)
    private int widthHallM;
    @Column(name = "length_hall_m", nullable = false)
    private int lengthHallM;
    @Column(name = "num_exits", nullable = false)
    private int numExits;
    @Column(name = "num_dynamics", nullable = false)
    private int numDynamics;

    @Column(name = "dolby_atmos", nullable = false)
    private boolean dolbyAtmos;
    @Column(name = "imax", nullable = false)
    private boolean imax;
    @Column(name = "fourdx", nullable = false)
    private boolean fourDX;
}

