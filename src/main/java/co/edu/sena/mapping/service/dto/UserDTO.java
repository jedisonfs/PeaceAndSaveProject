package co.edu.sena.mapping.service.dto;

import co.edu.sena.mapping.domain.Roles;
import co.edu.sena.mapping.domain.enums.Condition;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private Integer id;

    @NotNull
    @NotBlank
    private String login;

    @Email
    @NotNull
    private String email;

    @NotBlank
    private Condition activited;

    @NotBlank
    private String createBy;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;

    @NotNull
    @NotEmpty
    private String lastModifiedBy;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date lastModifiedDateBy;

    @NotNull
    private List<Roles> roles;


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
                ", lasModifiedBy='" + lastModifiedBy + '\'' +
                ", lastModifiedDateBy=" + lastModifiedDateBy +
                '}';
    }
}
