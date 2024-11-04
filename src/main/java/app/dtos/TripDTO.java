package app.dtos;

import app.entities.Trip;
import app.enums.Category;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class TripDTO {
    private Integer id;
    private String starttime;
    private String endtime;
    private String startposition;
    private String name;
    private Double price;
    private Category category;


    public TripDTO(Trip trip){
        this.id = trip.getId();
        this.starttime = trip.getStarttime();
        this.endtime = trip.getEndtime();
        this.startposition = trip.getStartposition();
        this.name = trip.getName();
        this.price = trip.getPrice();
        this.category = trip.getCategory();
    }

    public TripDTO(String starttime, String endtime, String startposition, String name, Double price, Category category) {
        this.starttime = starttime;
        this.endtime = endtime;
        this.startposition = startposition;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Same reference
        if (o == null || getClass() != o.getClass()) return false; // Null or not same class
        TripDTO tripDTO = (TripDTO) o; // Correctly cast to TripDTO
        return Objects.equals(id, tripDTO.id) && // Compare the fields
                Objects.equals(starttime, tripDTO.starttime) &&
                Objects.equals(endtime, tripDTO.endtime) &&
                Objects.equals(startposition, tripDTO.startposition) &&
                Objects.equals(name, tripDTO.name) &&
                Objects.equals(price, tripDTO.price) &&
                category == tripDTO.category; // Compare enums directly
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, starttime, endtime, startposition, name, price, category);
    }
}
