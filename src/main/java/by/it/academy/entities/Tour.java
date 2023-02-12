package by.it.academy.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tour {
    private String name_ofTour;
    private int cost_ofTour;
    private String state_ofTour;
    private String hotel;
    private String attraction;

}
