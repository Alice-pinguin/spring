package ua.goit.homework.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UserStatus {
        ACTIVE("ACTIVE"),
        DISABLED("DISABLED");

        private final String status;

        public String getStatus() {
            return status;
        }
}
