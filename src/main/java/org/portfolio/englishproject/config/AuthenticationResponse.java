package org.portfolio.englishproject.config;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthenticationResponse {
    String token;
}
