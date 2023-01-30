package co.edu.sena.mapping.service.dto;

import co.edu.sena.mapping.domain.enums.Condition;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@ToString
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
}
