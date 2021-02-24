package models;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;

@ToString(exclude = "halls")
@Getter
@Setter
@Entity
@Table(name = "cinemas")
public class Cinema {
    @OneToMany(mappedBy = "cinemaCodeKey", cascade = CascadeType.REMOVE)
    private Collection<Hall> halls;

    @Id
    @Column(name = "cinema_code", nullable = false)
    private String cinemaCode;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
}
