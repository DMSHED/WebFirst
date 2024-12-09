package com.http.dto;

import com.http.entity.Gender;
import com.http.entity.Role;

import java.time.LocalDate;

public final class UserDto {
    private final Integer id;
    private final String name;
    private final String email;
    private final LocalDate birthday;
    private final String image;
    private final Role role;
    private final Gender gender;

    UserDto(Integer id, String name, String email, LocalDate birthday, String image, Role role, Gender gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.image = image;
        this.role = role;
        this.gender = gender;
    }

    public static UserDtoBuilder builder() {
        return new UserDtoBuilder();
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public String getImage() {
        return this.image;
    }

    public Role getRole() {
        return this.role;
    }

    public Gender getGender() {
        return this.gender;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserDto)) return false;
        final UserDto other = (UserDto) o;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$birthday = this.getBirthday();
        final Object other$birthday = other.getBirthday();
        if (this$birthday == null ? other$birthday != null : !this$birthday.equals(other$birthday)) return false;
        final Object this$image = this.getImage();
        final Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) return false;
        final Object this$role = this.getRole();
        final Object other$role = other.getRole();
        if (this$role == null ? other$role != null : !this$role.equals(other$role)) return false;
        final Object this$gender = this.getGender();
        final Object other$gender = other.getGender();
        if (this$gender == null ? other$gender != null : !this$gender.equals(other$gender)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $birthday = this.getBirthday();
        result = result * PRIME + ($birthday == null ? 43 : $birthday.hashCode());
        final Object $image = this.getImage();
        result = result * PRIME + ($image == null ? 43 : $image.hashCode());
        final Object $role = this.getRole();
        result = result * PRIME + ($role == null ? 43 : $role.hashCode());
        final Object $gender = this.getGender();
        result = result * PRIME + ($gender == null ? 43 : $gender.hashCode());
        return result;
    }

    public String toString() {
        return "UserDto(id=" + this.getId() + ", name=" + this.getName() + ", email=" + this.getEmail() + ", birthday=" + this.getBirthday() + ", image=" + this.getImage() + ", role=" + this.getRole() + ", gender=" + this.getGender() + ")";
    }

    public static class UserDtoBuilder {
        private Integer id;
        private String name;
        private String email;
        private LocalDate birthday;
        private String image;
        private Role role;
        private Gender gender;

        UserDtoBuilder() {
        }

        public UserDtoBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public UserDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserDtoBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserDtoBuilder birthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        public UserDtoBuilder image(String image) {
            this.image = image;
            return this;
        }

        public UserDtoBuilder role(Role role) {
            this.role = role;
            return this;
        }

        public UserDtoBuilder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public UserDto build() {
            return new UserDto(this.id, this.name, this.email, this.birthday, this.image, this.role, this.gender);
        }

        public String toString() {
            return "UserDto.UserDtoBuilder(id=" + this.id + ", name=" + this.name + ", email=" + this.email + ", birthday=" + this.birthday + ", image=" + this.image + ", role=" + this.role + ", gender=" + this.gender + ")";
        }
    }
}
