package app.dtos;

import app.entities.Guide;
import app.entities.Trip;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class GuideDTO {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private Number yearsOfExperience;

    private List<Trip> trip;

    public GuideDTO(String firstname, String lastname, String email, String phone, Number yearsOfExperience) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.yearsOfExperience = yearsOfExperience;
    }

    public GuideDTO(Guide guide) {
        this.id = guide.getId();
        this.firstname = guide.getFirstname();
        this.lastname = guide.getLastname();
        this.email = guide.getEmail();
        this.phone = guide.getPhone();
        this.yearsOfExperience = guide.getYearsOfExperience();
    }
}
