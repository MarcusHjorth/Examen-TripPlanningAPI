package app.entities;

import app.dtos.TripDTO;
import app.enums.Category;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "start_time", nullable = false)
    private String starttime;

    @Column(name = "end_time", nullable = false)
    private String endtime;

    @Column(name = "start_position", nullable = false)
    private String startposition;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guide_id")  // This column links Trip to Guide
    private Guide guide;

    public Trip(String starttime, String endtime, String startposition, String name, Double price, Category category) {
        this.starttime = starttime;
        this.endtime = endtime;
        this.startposition = startposition;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Trip(TripDTO tripDTO){
        this.id = tripDTO.getId();
        this.starttime = tripDTO.getStarttime();
        this.endtime = tripDTO.getEndtime();
        this.startposition = tripDTO.getStartposition();
        this.name = tripDTO.getName();
        this.price = tripDTO.getPrice();
        this.category = tripDTO.getCategory();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Same reference
        if (o == null || getClass() != o.getClass()) return false; // Null or not same class
        Trip trip = (Trip) o; // Correctly cast to Trip
        return Objects.equals(id, trip.id) &&
                Objects.equals(starttime, trip.starttime) &&
                Objects.equals(endtime, trip.endtime) &&
                Objects.equals(startposition, trip.startposition) &&
                Objects.equals(name, trip.name) &&
                Objects.equals(price, trip.price) &&
                category == trip.category && // Compare enums directly
                Objects.equals(guide, trip.guide); // Compare guide properly
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, starttime, endtime, startposition, name, price, category, guide);
    }
}
