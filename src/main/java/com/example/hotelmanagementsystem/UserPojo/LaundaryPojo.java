package com.example.hotelmanagementsystem.UserPojo;
import com.example.hotelmanagementsystem.entity.Laundary;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class LaundaryPojo {

    private Integer id;

    private  Integer roomno;

    private Integer noofclothes;
    private Integer print;

    public LaundaryPojo(Laundary laundary) {
        this.id=laundary.getId();
        this.roomno=laundary.getRoomno();
        this.noofclothes=laundary.getNoofclothes();
        this.print=laundary.getPrint();

    }


}

