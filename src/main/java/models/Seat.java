package models;

import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.NaturalId;

import java.io.Serializable;
import java.util.Collection;


@ToString(exclude = {"hallCodeKey", "tickets"})
@Entity
@Getter
@Setter
@Table(name = "seats")
public class Seat {
    @OneToMany(mappedBy = "SeatCodeKey", cascade = CascadeType.ALL)
    private Collection<Ticket> tickets;

    @ManyToOne(optional = false)
    @JoinColumn(name = "hall_code", insertable = false, updatable = false)
    private Hall hallCodeKey;

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "hallCode", column = @Column(name = "hall_code", nullable = false)),
            @AttributeOverride(name = "row", column = @Column(name = "row", nullable = false)),
            @AttributeOverride(name = "seatNum", column = @Column(name = "seat_num", nullable = false))})
    private SeatKey seatKey;

//    @Id
//    @Column(name = "hall_code", nullable = false)
//    private int hallCode;
//
//    @Id
//    @NaturalId
//    @Column(name = "row", nullable = false)
//    private int row;
//
//    @Id
//    @NaturalId
//    @Column(name = "seat_num", nullable = false)
//    private int seatNum;

    @Column(name = "fare_conditions", nullable = false)
    private String fareConditions;
}

@Embeddable
@Getter
@Setter
class SeatKey implements Serializable {
    private static final long serialVersionUID = 1L;

    private int hallCode;

    private int row;

    private int seatNum;
}