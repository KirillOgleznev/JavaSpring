package models;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(exclude = {"SessionCodeKey", "SeatCodeKey"})
@Entity
@Getter
@Setter
@Table(name = "tickets", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"session_code","row", "seat_num"}, name = "row_seat_session_key")})
public class Ticket {
    @ManyToOne(optional = false)
    @JoinColumn(name = "session_code", nullable = false, insertable = false, updatable = false)
    private Session SessionCodeKey;

    @ManyToOne(optional = false)
    @JoinColumns({
            @JoinColumn(name = "hall_code", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "row", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "seat_num", nullable = false, insertable = false, updatable = false)})
    private Seat SeatCodeKey;

    @Id
    @GeneratedValue
    @Column(name = "ticket_code", nullable = false)
    private int ticketCode;

    @Column(name = "hall_code", nullable = false)
    private int hallCode;

    @Column(name = "session_code", nullable = false)
    private int sessionCode;

    @Column(name = "row", nullable = false)
    private String row;

    @Column(name = "seat_num", nullable = false)
    private int seatNum;

    @Column(name = "amount", nullable = false)
    private int amount;
}