package api.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResponse {
   private String name;
    private String job;
    private String id;
    private String createdAt;
}
