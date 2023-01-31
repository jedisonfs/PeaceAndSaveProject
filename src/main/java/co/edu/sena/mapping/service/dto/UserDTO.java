package co.edu.sena.mapping.service.dto;

import co.edu.sena.mapping.domain.enums.Condition;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private Integer id;
    private String login;
    private String email;
    private Condition activited;
    private String createBy;
    private Date createdDate;
    private String lasModifiedBy;
    private Date lastModifiedDateBy;


    public UserDTO(Integer id, String login, String email, Condition activated, String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDateBy) {
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", activited=" + activited +
                ", createBy='" + createBy + '\'' +
                ", createdDate=" + createdDate +
                ", lasModifiedBy='" + lasModifiedBy + '\'' +
                ", lastModifiedDateBy=" + lastModifiedDateBy +
                '}';
    }
}
