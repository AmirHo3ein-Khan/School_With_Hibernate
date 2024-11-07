package ir.school.model;
import ir.school.model.base.BaseModel;
import ir.school.model.type.UserType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@ToString
public class Users extends BaseModel<Long> {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "national_code" , unique = true)
    private String nationalCode;
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(unique = true)
    private String username;
    private String password;
    @Column(name = "user_type")
    @Enumerated(EnumType.STRING)
    private UserType userType;
}
