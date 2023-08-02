package api.pojos;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserResponse {
    private UserData data;
    private UserSupport support;
}
